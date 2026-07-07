package com.tom_roush.pdfbox.io;

import android.util.Log;
import androidx.appcompat.widget.ActivityChooserView;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class ScratchFileBuffer implements RandomAccess {
    private byte[] currentPage;
    private long currentPageOffset;
    private int currentPagePositionInPageIndexes;
    private ScratchFile pageHandler;
    private final int pageSize;
    private int positionInPage;
    private long size = 0;
    private boolean currentPageContentChanged = false;
    private int[] pageIndexes = new int[16];
    private int pageCount = 0;

    public ScratchFileBuffer(ScratchFile scratchFile) throws IOException {
        scratchFile.checkClosed();
        this.pageHandler = scratchFile;
        this.pageSize = scratchFile.getPageSize();
        addPage();
    }

    private void addPage() throws IOException {
        int i2 = this.pageCount;
        int i3 = i2 + 1;
        int[] iArr = this.pageIndexes;
        if (i3 >= iArr.length) {
            int length = iArr.length * 2;
            if (length < iArr.length) {
                if (iArr.length == Integer.MAX_VALUE) {
                    throw new IOException("Maximum buffer size reached.");
                }
                length = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            int[] iArr2 = new int[length];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.pageIndexes = iArr2;
        }
        int newPage = this.pageHandler.getNewPage();
        int[] iArr3 = this.pageIndexes;
        int i4 = this.pageCount;
        iArr3[i4] = newPage;
        this.currentPagePositionInPageIndexes = i4;
        int i5 = this.pageSize;
        this.currentPageOffset = ((long) i4) * ((long) i5);
        this.pageCount = i4 + 1;
        this.currentPage = new byte[i5];
        this.positionInPage = 0;
    }

    private void checkClosed() throws IOException {
        ScratchFile scratchFile = this.pageHandler;
        if (scratchFile == null) {
            throw new IOException("Buffer already closed");
        }
        scratchFile.checkClosed();
    }

    private boolean ensureAvailableBytesInPage(boolean z) throws IOException {
        if (this.positionInPage >= this.pageSize) {
            if (this.currentPageContentChanged) {
                this.pageHandler.writePage(this.pageIndexes[this.currentPagePositionInPageIndexes], this.currentPage);
                this.currentPageContentChanged = false;
            }
            int i2 = this.currentPagePositionInPageIndexes;
            if (i2 + 1 < this.pageCount) {
                ScratchFile scratchFile = this.pageHandler;
                int[] iArr = this.pageIndexes;
                int i3 = i2 + 1;
                this.currentPagePositionInPageIndexes = i3;
                this.currentPage = scratchFile.readPage(iArr[i3]);
                this.currentPageOffset = ((long) this.currentPagePositionInPageIndexes) * ((long) this.pageSize);
                this.positionInPage = 0;
            } else {
                if (!z) {
                    return false;
                }
                addPage();
            }
        }
        return true;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public int available() throws IOException {
        checkClosed();
        return (int) Math.min(this.size - (this.currentPageOffset + ((long) this.positionInPage)), 2147483647L);
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessWrite
    public final void clear() throws IOException {
        checkClosed();
        this.pageHandler.markPagesAsFree(this.pageIndexes, 1, this.pageCount - 1);
        this.pageCount = 1;
        if (this.currentPagePositionInPageIndexes > 0) {
            this.currentPage = this.pageHandler.readPage(this.pageIndexes[0]);
            this.currentPagePositionInPageIndexes = 0;
            this.currentPageOffset = 0L;
        }
        this.positionInPage = 0;
        this.size = 0L;
        this.currentPageContentChanged = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ScratchFile scratchFile = this.pageHandler;
        if (scratchFile != null) {
            scratchFile.markPagesAsFree(this.pageIndexes, 0, this.pageCount);
            this.pageHandler = null;
            this.pageIndexes = null;
            this.currentPage = null;
            this.currentPageOffset = 0L;
            this.currentPagePositionInPageIndexes = -1;
            this.positionInPage = 0;
            this.size = 0L;
        }
    }

    public void finalize() throws Throwable {
        try {
            if (this.pageHandler != null && PDFBoxConfig.isDebugEnabled()) {
                Log.d("PdfBox-Android", "ScratchFileBuffer not closed!");
            }
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public long getPosition() throws IOException {
        checkClosed();
        return this.currentPageOffset + ((long) this.positionInPage);
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public boolean isClosed() {
        return this.pageHandler == null;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public boolean isEOF() throws IOException {
        checkClosed();
        return this.currentPageOffset + ((long) this.positionInPage) >= this.size;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public long length() throws IOException {
        return this.size;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public int peek() throws IOException {
        int i2 = read();
        if (i2 != -1) {
            rewind(1);
        }
        return i2;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public int read() throws IOException {
        checkClosed();
        if (this.currentPageOffset + ((long) this.positionInPage) >= this.size) {
            return -1;
        }
        if (!ensureAvailableBytesInPage(false)) {
            throw new IOException("Unexpectedly no bytes available for read in buffer.");
        }
        byte[] bArr = this.currentPage;
        int i2 = this.positionInPage;
        this.positionInPage = i2 + 1;
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
        seek((this.currentPageOffset + ((long) this.positionInPage)) - ((long) i2));
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public void seek(long j) throws IOException {
        checkClosed();
        if (j > this.size) {
            throw new EOFException();
        }
        if (j < 0) {
            throw new IOException("Negative seek offset: " + j);
        }
        long j2 = this.currentPageOffset;
        if (j >= j2 && j <= ((long) this.pageSize) + j2) {
            this.positionInPage = (int) (j - j2);
            return;
        }
        if (this.currentPageContentChanged) {
            this.pageHandler.writePage(this.pageIndexes[this.currentPagePositionInPageIndexes], this.currentPage);
            this.currentPageContentChanged = false;
        }
        int i2 = this.pageSize;
        int i3 = (int) (j / ((long) i2));
        if (j % ((long) i2) == 0 && j == this.size) {
            i3--;
        }
        this.currentPage = this.pageHandler.readPage(this.pageIndexes[i3]);
        this.currentPagePositionInPageIndexes = i3;
        long j3 = ((long) i3) * ((long) this.pageSize);
        this.currentPageOffset = j3;
        this.positionInPage = (int) (j - j3);
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessWrite
    public void write(int i2) throws IOException {
        checkClosed();
        ensureAvailableBytesInPage(true);
        byte[] bArr = this.currentPage;
        int i3 = this.positionInPage;
        int i4 = i3 + 1;
        this.positionInPage = i4;
        bArr[i3] = (byte) i2;
        this.currentPageContentChanged = true;
        long j = this.currentPageOffset;
        if (((long) i4) + j > this.size) {
            this.size = j + ((long) i4);
        }
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        checkClosed();
        long j = this.currentPageOffset;
        int i4 = this.positionInPage;
        long j2 = ((long) i4) + j;
        long j3 = this.size;
        if (j2 >= j3) {
            return -1;
        }
        int iMin = (int) Math.min(i3, j3 - (j + ((long) i4)));
        int i5 = 0;
        while (iMin > 0) {
            if (ensureAvailableBytesInPage(false)) {
                int iMin2 = Math.min(iMin, this.pageSize - this.positionInPage);
                System.arraycopy(this.currentPage, this.positionInPage, bArr, i2, iMin2);
                this.positionInPage += iMin2;
                i5 += iMin2;
                i2 += iMin2;
                iMin -= iMin2;
            } else {
                throw new IOException("Unexpectedly no bytes available for read in buffer.");
            }
        }
        return i5;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessWrite
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessWrite
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        checkClosed();
        while (i3 > 0) {
            ensureAvailableBytesInPage(true);
            int iMin = Math.min(i3, this.pageSize - this.positionInPage);
            System.arraycopy(bArr, i2, this.currentPage, this.positionInPage, iMin);
            this.positionInPage += iMin;
            this.currentPageContentChanged = true;
            i2 += iMin;
            i3 -= iMin;
        }
        long j = this.currentPageOffset;
        int i4 = this.positionInPage;
        if (((long) i4) + j > this.size) {
            this.size = j + ((long) i4);
        }
    }
}
