package com.tom_roush.pdfbox.io;

import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RandomAccessBufferedFileInputStream extends InputStream implements RandomAccessRead {
    private static final String TMP_FILE_PREFIX = "tmpPDFBox";
    private byte[] curPage;
    private long curPageOffset;
    private final long fileLength;
    private long fileOffset;
    private boolean isClosed;
    private byte[] lastRemovedCachePage;
    private int maxCachedPages;
    private int offsetWithinPage;
    private final Map<Long, byte[]> pageCache;
    private long pageOffsetMask;
    private int pageSize;
    private int pageSizeShift;
    private final java.io.RandomAccessFile raFile;
    private File tempFile;

    public RandomAccessBufferedFileInputStream(String str) throws IOException {
        this(new File(str));
    }

    private File createTmpFile(InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        Throwable th;
        File fileCreateTempFile;
        try {
            fileCreateTempFile = File.createTempFile(TMP_FILE_PREFIX, ".pdf");
            fileOutputStream = new FileOutputStream(fileCreateTempFile);
        } catch (Throwable th2) {
            fileOutputStream = null;
            th = th2;
        }
        try {
            IOUtils.copy(inputStream, fileOutputStream);
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream);
            return fileCreateTempFile;
        } catch (Throwable th3) {
            th = th3;
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream);
            throw th;
        }
    }

    private void deleteTempFile() {
        File file = this.tempFile;
        if (file != null) {
            file.delete();
        }
    }

    private byte[] readPage() throws IOException {
        int i2;
        byte[] bArr = this.lastRemovedCachePage;
        if (bArr != null) {
            this.lastRemovedCachePage = null;
        } else {
            bArr = new byte[this.pageSize];
        }
        int i3 = 0;
        while (true) {
            int i4 = this.pageSize;
            if (i3 >= i4 || (i2 = this.raFile.read(bArr, i3, i4 - i3)) < 0) {
                break;
            }
            i3 += i2;
        }
        return bArr;
    }

    @Override // java.io.InputStream, com.tom_roush.pdfbox.io.RandomAccessRead
    public int available() throws IOException {
        return (int) Math.min(this.fileLength - this.fileOffset, 2147483647L);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.raFile.close();
        deleteTempFile();
        this.pageCache.clear();
        this.isClosed = true;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public long getPosition() {
        return this.fileOffset;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public boolean isClosed() {
        return this.isClosed;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public boolean isEOF() throws IOException {
        return peek() == -1;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public long length() throws IOException {
        return this.fileLength;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public int peek() throws IOException {
        int i2 = read();
        if (i2 != -1) {
            rewind(1);
        }
        return i2;
    }

    @Override // java.io.InputStream, com.tom_roush.pdfbox.io.RandomAccessRead
    public int read() throws IOException {
        long j = this.fileOffset;
        if (j >= this.fileLength) {
            return -1;
        }
        if (this.offsetWithinPage == this.pageSize) {
            seek(j);
        }
        this.fileOffset++;
        byte[] bArr = this.curPage;
        int i2 = this.offsetWithinPage;
        this.offsetWithinPage = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public byte[] readFully(int i2) throws IOException {
        byte[] bArr = new byte[i2];
        int i3 = 0;
        do {
            int i4 = read(bArr, i3, i2 - i3);
            if (i4 < 0) {
                throw new EOFException();
            }
            i3 += i4;
        } while (i3 < i2);
        return bArr;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public void rewind(int i2) throws IOException {
        seek(getPosition() - ((long) i2));
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public void seek(long j) throws IOException {
        long j2 = this.pageOffsetMask & j;
        if (j2 != this.curPageOffset) {
            byte[] page = this.pageCache.get(Long.valueOf(j2));
            if (page == null) {
                this.raFile.seek(j2);
                page = readPage();
                this.pageCache.put(Long.valueOf(j2), page);
            }
            this.curPageOffset = j2;
            this.curPage = page;
        }
        this.offsetWithinPage = (int) (j - this.curPageOffset);
        this.fileOffset = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long skip(long r9) throws java.io.IOException {
        /*
            r8 = this;
            long r0 = r8.fileLength
            long r2 = r8.fileOffset
            long r4 = r0 - r2
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 >= 0) goto Lc
            long r9 = r0 - r2
        Lc:
            int r0 = r8.pageSize
            long r4 = (long) r0
            int r1 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r1 >= 0) goto L25
            int r1 = r8.offsetWithinPage
            long r4 = (long) r1
            long r4 = r4 + r9
            long r6 = (long) r0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 > 0) goto L25
            long r0 = (long) r1
            long r0 = r0 + r9
            int r1 = (int) r0
            r8.offsetWithinPage = r1
            long r2 = r2 + r9
            r8.fileOffset = r2
            goto L29
        L25:
            long r2 = r2 + r9
            r8.seek(r2)
        L29:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.io.RandomAccessBufferedFileInputStream.skip(long):long");
    }

    public RandomAccessBufferedFileInputStream(File file) throws IOException {
        this.pageSizeShift = 12;
        this.pageSize = 1 << 12;
        this.pageOffsetMask = (-1) << 12;
        this.maxCachedPages = 1000;
        this.lastRemovedCachePage = null;
        this.pageCache = new LinkedHashMap<Long, byte[]>(this.maxCachedPages, 0.75f, true) { // from class: com.tom_roush.pdfbox.io.RandomAccessBufferedFileInputStream.1
            private static final long serialVersionUID = -6302488539257741101L;

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<Long, byte[]> entry) {
                boolean z = size() > RandomAccessBufferedFileInputStream.this.maxCachedPages;
                if (z) {
                    RandomAccessBufferedFileInputStream.this.lastRemovedCachePage = entry.getValue();
                }
                return z;
            }
        };
        this.curPageOffset = -1L;
        this.curPage = new byte[this.pageSize];
        this.offsetWithinPage = 0;
        this.fileOffset = 0L;
        this.raFile = new java.io.RandomAccessFile(file, PDPageLabelRange.STYLE_ROMAN_LOWER);
        this.fileLength = file.length();
        seek(0L);
    }

    @Override // java.io.InputStream, com.tom_roush.pdfbox.io.RandomAccessRead
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream, com.tom_roush.pdfbox.io.RandomAccessRead
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        long j = this.fileOffset;
        if (j >= this.fileLength) {
            return -1;
        }
        if (this.offsetWithinPage == this.pageSize) {
            seek(j);
        }
        int iMin = Math.min(this.pageSize - this.offsetWithinPage, i3);
        long j2 = this.fileLength;
        long j3 = this.fileOffset;
        if (j2 - j3 < this.pageSize) {
            iMin = Math.min(iMin, (int) (j2 - j3));
        }
        System.arraycopy(this.curPage, this.offsetWithinPage, bArr, i2, iMin);
        this.offsetWithinPage += iMin;
        this.fileOffset += (long) iMin;
        return iMin;
    }

    public RandomAccessBufferedFileInputStream(InputStream inputStream) throws Throwable {
        this.pageSizeShift = 12;
        this.pageSize = 1 << 12;
        this.pageOffsetMask = (-1) << 12;
        this.maxCachedPages = 1000;
        this.lastRemovedCachePage = null;
        this.pageCache = new LinkedHashMap<Long, byte[]>(this.maxCachedPages, 0.75f, true) { // from class: com.tom_roush.pdfbox.io.RandomAccessBufferedFileInputStream.1
            private static final long serialVersionUID = -6302488539257741101L;

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<Long, byte[]> entry) {
                boolean z = size() > RandomAccessBufferedFileInputStream.this.maxCachedPages;
                if (z) {
                    RandomAccessBufferedFileInputStream.this.lastRemovedCachePage = entry.getValue();
                }
                return z;
            }
        };
        this.curPageOffset = -1L;
        this.curPage = new byte[this.pageSize];
        this.offsetWithinPage = 0;
        this.fileOffset = 0L;
        File fileCreateTmpFile = createTmpFile(inputStream);
        this.tempFile = fileCreateTmpFile;
        this.fileLength = fileCreateTmpFile.length();
        this.raFile = new java.io.RandomAccessFile(this.tempFile, PDPageLabelRange.STYLE_ROMAN_LOWER);
        seek(0L);
    }
}
