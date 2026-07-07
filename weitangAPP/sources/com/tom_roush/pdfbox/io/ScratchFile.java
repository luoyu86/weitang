package com.tom_roush.pdfbox.io;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserView;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;

/* JADX INFO: loaded from: classes2.dex */
public class ScratchFile implements Closeable {
    private static final int ENLARGE_PAGE_COUNT = 16;
    private static final int INIT_UNRESTRICTED_MAINMEM_PAGECOUNT = 100000;
    private static final int PAGE_SIZE = 4096;
    private File file;
    private final BitSet freePages;
    private final int inMemoryMaxPageCount;
    private volatile byte[][] inMemoryPages;
    private final Object ioLock;
    private volatile boolean isClosed;
    private final boolean maxMainMemoryIsRestricted;
    private final int maxPageCount;
    private volatile int pageCount;
    private java.io.RandomAccessFile raf;
    private final File scratchFileDirectory;
    private final boolean useScratchFile;

    public ScratchFile(File file) throws IOException {
        this(MemoryUsageSetting.setupTempFileOnly().setTempDir(file));
    }

    private void enlarge() throws IOException {
        synchronized (this.ioLock) {
            checkClosed();
            if (this.pageCount >= this.maxPageCount) {
                return;
            }
            if (this.useScratchFile) {
                if (this.raf == null) {
                    this.file = File.createTempFile("PDFBox", ".tmp", this.scratchFileDirectory);
                    try {
                        this.raf = new java.io.RandomAccessFile(this.file, "rw");
                    } catch (IOException e2) {
                        if (!this.file.delete()) {
                            Log.w("PdfBox-Android", "Error deleting scratch file: " + this.file.getAbsolutePath());
                        }
                        throw e2;
                    }
                }
                long length = this.raf.length();
                long j = (((long) this.pageCount) - ((long) this.inMemoryMaxPageCount)) * 4096;
                if (j != length) {
                    throw new IOException("Expected scratch file size of " + j + " but found " + length + " in file " + this.file);
                }
                if (this.pageCount + 16 > this.pageCount) {
                    if (PDFBoxConfig.isDebugEnabled()) {
                        Log.d("PdfBox-Android", "file: " + this.file);
                        Log.d("PdfBox-Android", "fileLen before: " + length + ", raf length: " + this.raf.length() + ", file length: " + this.file.length());
                    }
                    long j2 = length + PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
                    this.raf.setLength(j2);
                    if (PDFBoxConfig.isDebugEnabled()) {
                        Log.d("PdfBox-Android", "fileLen after1: " + j2 + ", raf length: " + this.raf.length() + ", file length: " + this.file.length());
                    }
                    if (j2 != this.raf.length()) {
                        long filePointer = this.raf.getFilePointer();
                        this.raf.seek(j2 - 1);
                        this.raf.write(0);
                        this.raf.seek(filePointer);
                        Log.d("PdfBox-Android", "fileLen after2:  " + j2 + ", raf length: " + this.raf.length() + ", file length: " + this.file.length());
                    }
                    this.freePages.set(this.pageCount, this.pageCount + 16);
                }
            } else if (!this.maxMainMemoryIsRestricted) {
                int length2 = this.inMemoryPages.length;
                int iMin = (int) Math.min(((long) length2) * 2, 2147483647L);
                if (iMin > length2) {
                    byte[][] bArr = new byte[iMin][];
                    System.arraycopy(this.inMemoryPages, 0, bArr, 0, length2);
                    this.inMemoryPages = bArr;
                    this.freePages.set(length2, iMin);
                }
            }
        }
    }

    public static ScratchFile getMainMemoryOnlyInstance() {
        try {
            return new ScratchFile(MemoryUsageSetting.setupMainMemoryOnly());
        } catch (IOException e2) {
            Log.e("PdfBox-Android", "Unexpected exception occurred creating main memory scratch file instance: " + e2.getMessage());
            return null;
        }
    }

    public void checkClosed() throws IOException {
        if (this.isClosed) {
            throw new IOException("Scratch file already closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.ioLock) {
            if (this.isClosed) {
                return;
            }
            this.isClosed = true;
            java.io.RandomAccessFile randomAccessFile = this.raf;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    e = null;
                } catch (IOException e2) {
                    e = e2;
                }
            } else {
                e = null;
            }
            File file = this.file;
            if (file != null && !file.delete() && this.file.exists() && e == null) {
                e = new IOException("Error deleting scratch file: " + this.file.getAbsolutePath());
            }
            synchronized (this.freePages) {
                this.freePages.clear();
                this.pageCount = 0;
            }
            if (e != null) {
                throw e;
            }
        }
    }

    public RandomAccess createBuffer() throws IOException {
        return new ScratchFileBuffer(this);
    }

    public int getNewPage() throws IOException {
        int iNextSetBit;
        synchronized (this.freePages) {
            iNextSetBit = this.freePages.nextSetBit(0);
            if (iNextSetBit < 0) {
                enlarge();
                iNextSetBit = this.freePages.nextSetBit(0);
                if (iNextSetBit < 0) {
                    throw new IOException("Maximum allowed scratch file memory exceeded.");
                }
            }
            this.freePages.clear(iNextSetBit);
            if (iNextSetBit >= this.pageCount) {
                this.pageCount = iNextSetBit + 1;
            }
        }
        return iNextSetBit;
    }

    public int getPageSize() {
        return 4096;
    }

    public void markPagesAsFree(int[] iArr, int i2, int i3) {
        synchronized (this.freePages) {
            while (i2 < i3) {
                int i4 = iArr[i2];
                if (i4 >= 0 && i4 < this.pageCount && !this.freePages.get(i4)) {
                    this.freePages.set(i4);
                    if (i4 < this.inMemoryMaxPageCount) {
                        this.inMemoryPages[i4] = null;
                    }
                }
                i2++;
            }
        }
    }

    public byte[] readPage(int i2) throws IOException {
        byte[] bArr;
        if (i2 < 0 || i2 >= this.pageCount) {
            checkClosed();
            StringBuilder sb = new StringBuilder();
            sb.append("Page index out of range: ");
            sb.append(i2);
            sb.append(". Max value: ");
            sb.append(this.pageCount - 1);
            throw new IOException(sb.toString());
        }
        if (i2 < this.inMemoryMaxPageCount) {
            byte[] bArr2 = this.inMemoryPages[i2];
            if (bArr2 != null) {
                return bArr2;
            }
            checkClosed();
            throw new IOException("Requested page with index " + i2 + " was not written before.");
        }
        synchronized (this.ioLock) {
            java.io.RandomAccessFile randomAccessFile = this.raf;
            if (randomAccessFile == null) {
                checkClosed();
                throw new IOException("Missing scratch file to read page with index " + i2 + " from.");
            }
            bArr = new byte[4096];
            randomAccessFile.seek((((long) i2) - ((long) this.inMemoryMaxPageCount)) * 4096);
            this.raf.readFully(bArr);
        }
        return bArr;
    }

    public void writePage(int i2, byte[] bArr) throws IOException {
        if (i2 < 0 || i2 >= this.pageCount) {
            checkClosed();
            StringBuilder sb = new StringBuilder();
            sb.append("Page index out of range: ");
            sb.append(i2);
            sb.append(". Max value: ");
            sb.append(this.pageCount - 1);
            throw new IOException(sb.toString());
        }
        if (bArr.length != 4096) {
            throw new IOException("Wrong page size to write: " + bArr.length + ". Expected: 4096");
        }
        if (i2 >= this.inMemoryMaxPageCount) {
            synchronized (this.ioLock) {
                checkClosed();
                this.raf.seek((((long) i2) - ((long) this.inMemoryMaxPageCount)) * 4096);
                this.raf.write(bArr);
            }
            return;
        }
        if (this.maxMainMemoryIsRestricted) {
            this.inMemoryPages[i2] = bArr;
        } else {
            synchronized (this.ioLock) {
                this.inMemoryPages[i2] = bArr;
            }
        }
        checkClosed();
    }

    public ScratchFile(MemoryUsageSetting memoryUsageSetting) throws IOException {
        this.ioLock = new Object();
        this.pageCount = 0;
        BitSet bitSet = new BitSet();
        this.freePages = bitSet;
        this.isClosed = false;
        boolean z = !memoryUsageSetting.useMainMemory() || memoryUsageSetting.isMainMemoryRestricted();
        this.maxMainMemoryIsRestricted = z;
        boolean z2 = z && memoryUsageSetting.useTempFile();
        this.useScratchFile = z2;
        File tempDir = z2 ? memoryUsageSetting.getTempDir() : null;
        this.scratchFileDirectory = tempDir;
        if (tempDir != null && !tempDir.isDirectory()) {
            throw new IOException("Scratch file directory does not exist: " + tempDir);
        }
        boolean zIsStorageRestricted = memoryUsageSetting.isStorageRestricted();
        int iMin = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.maxPageCount = zIsStorageRestricted ? (int) Math.min(2147483647L, memoryUsageSetting.getMaxStorageBytes() / 4096) : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        if (!memoryUsageSetting.useMainMemory()) {
            iMin = 0;
        } else if (memoryUsageSetting.isMainMemoryRestricted()) {
            iMin = (int) Math.min(2147483647L, memoryUsageSetting.getMaxMainMemoryBytes() / 4096);
        }
        this.inMemoryMaxPageCount = iMin;
        this.inMemoryPages = new byte[z ? iMin : INIT_UNRESTRICTED_MAINMEM_PAGECOUNT][];
        bitSet.set(0, this.inMemoryPages.length);
    }

    public RandomAccess createBuffer(InputStream inputStream) throws IOException {
        ScratchFileBuffer scratchFileBuffer = new ScratchFileBuffer(this);
        byte[] bArr = new byte[8192];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 <= -1) {
                scratchFileBuffer.seek(0L);
                return scratchFileBuffer;
            }
            scratchFileBuffer.write(bArr, 0, i2);
        }
    }
}
