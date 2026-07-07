package com.tom_roush.pdfbox.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RandomAccessBuffer implements RandomAccess, Cloneable {
    private static final int DEFAULT_CHUNK_SIZE = 1024;
    private List<byte[]> bufferList;
    private int bufferListIndex;
    private int bufferListMaxIndex;
    private int chunkSize;
    private byte[] currentBuffer;
    private int currentBufferPointer;
    private long pointer;
    private long size;

    public RandomAccessBuffer() {
        this(1024);
    }

    private void checkClosed() throws IOException {
        if (this.currentBuffer == null) {
            throw new IOException("RandomAccessBuffer already closed");
        }
    }

    private void expandBuffer() throws IOException {
        if (this.bufferListMaxIndex > this.bufferListIndex) {
            nextBuffer();
            return;
        }
        byte[] bArr = new byte[this.chunkSize];
        this.currentBuffer = bArr;
        this.bufferList.add(bArr);
        this.currentBufferPointer = 0;
        this.bufferListMaxIndex++;
        this.bufferListIndex++;
    }

    private void nextBuffer() throws IOException {
        int i2 = this.bufferListIndex;
        if (i2 == this.bufferListMaxIndex) {
            throw new IOException("No more chunks available, end of buffer reached");
        }
        this.currentBufferPointer = 0;
        List<byte[]> list = this.bufferList;
        int i3 = i2 + 1;
        this.bufferListIndex = i3;
        this.currentBuffer = list.get(i3);
    }

    private int readRemainingBytes(byte[] bArr, int i2, int i3) {
        int iMin = (int) Math.min(i3, this.size - this.pointer);
        int i4 = this.chunkSize;
        int i5 = this.currentBufferPointer;
        int i6 = i4 - i5;
        if (i6 == 0) {
            return 0;
        }
        if (iMin >= i6) {
            System.arraycopy(this.currentBuffer, i5, bArr, i2, i6);
            this.currentBufferPointer += i6;
            this.pointer += (long) i6;
            return i6;
        }
        System.arraycopy(this.currentBuffer, i5, bArr, i2, iMin);
        this.currentBufferPointer += iMin;
        this.pointer += (long) iMin;
        return iMin;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public int available() throws IOException {
        return (int) Math.min(length() - getPosition(), 2147483647L);
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessWrite
    public void clear() {
        this.bufferList.clear();
        byte[] bArr = new byte[this.chunkSize];
        this.currentBuffer = bArr;
        this.bufferList.add(bArr);
        this.pointer = 0L;
        this.currentBufferPointer = 0;
        this.size = 0L;
        this.bufferListIndex = 0;
        this.bufferListMaxIndex = 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.currentBuffer = null;
        this.bufferList.clear();
        this.pointer = 0L;
        this.currentBufferPointer = 0;
        this.size = 0L;
        this.bufferListIndex = 0;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public long getPosition() throws IOException {
        checkClosed();
        return this.pointer;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public boolean isClosed() {
        return this.currentBuffer == null;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public boolean isEOF() throws IOException {
        checkClosed();
        return this.pointer >= this.size;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public long length() throws IOException {
        checkClosed();
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
        if (this.pointer >= this.size) {
            return -1;
        }
        if (this.currentBufferPointer >= this.chunkSize) {
            int i2 = this.bufferListIndex;
            if (i2 >= this.bufferListMaxIndex) {
                return -1;
            }
            List<byte[]> list = this.bufferList;
            int i3 = i2 + 1;
            this.bufferListIndex = i3;
            this.currentBuffer = list.get(i3);
            this.currentBufferPointer = 0;
        }
        this.pointer++;
        byte[] bArr = this.currentBuffer;
        int i4 = this.currentBufferPointer;
        this.currentBufferPointer = i4 + 1;
        return bArr[i4] & 255;
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
        checkClosed();
        seek(getPosition() - ((long) i2));
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public void seek(long j) throws IOException {
        checkClosed();
        if (j < 0) {
            throw new IOException("Invalid position " + j);
        }
        this.pointer = j;
        if (j >= this.size) {
            int i2 = this.bufferListMaxIndex;
            this.bufferListIndex = i2;
            this.currentBuffer = this.bufferList.get(i2);
            this.currentBufferPointer = (int) (this.size % ((long) this.chunkSize));
            return;
        }
        int i3 = this.chunkSize;
        int i4 = (int) (j / ((long) i3));
        this.bufferListIndex = i4;
        this.currentBufferPointer = (int) (j % ((long) i3));
        this.currentBuffer = this.bufferList.get(i4);
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessWrite
    public void write(int i2) throws IOException {
        checkClosed();
        int i3 = this.currentBufferPointer;
        int i4 = this.chunkSize;
        if (i3 >= i4) {
            if (this.pointer + ((long) i4) >= 2147483647L) {
                throw new IOException("RandomAccessBuffer overflow");
            }
            expandBuffer();
        }
        byte[] bArr = this.currentBuffer;
        int i5 = this.currentBufferPointer;
        int i6 = i5 + 1;
        this.currentBufferPointer = i6;
        bArr[i5] = (byte) i2;
        long j = this.pointer + 1;
        this.pointer = j;
        if (j > this.size) {
            this.size = j;
        }
        int i7 = this.chunkSize;
        if (i6 >= i7) {
            if (j + ((long) i7) >= 2147483647L) {
                throw new IOException("RandomAccessBuffer overflow");
            }
            expandBuffer();
        }
    }

    private RandomAccessBuffer(int i2) {
        this.chunkSize = 1024;
        this.bufferList = null;
        ArrayList arrayList = new ArrayList();
        this.bufferList = arrayList;
        this.chunkSize = i2;
        byte[] bArr = new byte[i2];
        this.currentBuffer = bArr;
        arrayList.add(bArr);
        this.pointer = 0L;
        this.currentBufferPointer = 0;
        this.size = 0L;
        this.bufferListIndex = 0;
        this.bufferListMaxIndex = 0;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public RandomAccessBuffer m84clone() {
        RandomAccessBuffer randomAccessBuffer = new RandomAccessBuffer(this.chunkSize);
        randomAccessBuffer.bufferList = new ArrayList(this.bufferList.size());
        for (byte[] bArr : this.bufferList) {
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            randomAccessBuffer.bufferList.add(bArr2);
        }
        if (this.currentBuffer != null) {
            randomAccessBuffer.currentBuffer = randomAccessBuffer.bufferList.get(r1.size() - 1);
        } else {
            randomAccessBuffer.currentBuffer = null;
        }
        randomAccessBuffer.pointer = this.pointer;
        randomAccessBuffer.currentBufferPointer = this.currentBufferPointer;
        randomAccessBuffer.size = this.size;
        randomAccessBuffer.bufferListIndex = this.bufferListIndex;
        randomAccessBuffer.bufferListMaxIndex = this.bufferListMaxIndex;
        return randomAccessBuffer;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        checkClosed();
        if (this.pointer >= this.size) {
            return -1;
        }
        int remainingBytes = readRemainingBytes(bArr, i2, i3);
        while (remainingBytes < i3 && available() > 0) {
            remainingBytes += readRemainingBytes(bArr, i2 + remainingBytes, i3 - remainingBytes);
            if (this.currentBufferPointer == this.chunkSize) {
                nextBuffer();
            }
        }
        return remainingBytes;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessWrite
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public RandomAccessBuffer(byte[] bArr) {
        this.chunkSize = 1024;
        this.bufferList = null;
        ArrayList arrayList = new ArrayList(1);
        this.bufferList = arrayList;
        this.chunkSize = bArr.length;
        this.currentBuffer = bArr;
        arrayList.add(bArr);
        this.pointer = 0L;
        this.currentBufferPointer = 0;
        this.size = this.chunkSize;
        this.bufferListIndex = 0;
        this.bufferListMaxIndex = 0;
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessWrite
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        checkClosed();
        long j = i3;
        long j2 = this.pointer + j;
        int i4 = this.chunkSize;
        int i5 = this.currentBufferPointer;
        int i6 = i4 - i5;
        if (i3 < i6) {
            System.arraycopy(bArr, i2, this.currentBuffer, i5, i3);
            this.currentBufferPointer += i3;
        } else if (j2 <= 2147483647L) {
            System.arraycopy(bArr, i2, this.currentBuffer, i5, i6);
            int i7 = i2 + i6;
            long j3 = i3 - i6;
            int i8 = ((int) j3) / this.chunkSize;
            for (int i9 = 0; i9 < i8; i9++) {
                expandBuffer();
                System.arraycopy(bArr, i7, this.currentBuffer, this.currentBufferPointer, this.chunkSize);
                i7 += this.chunkSize;
            }
            long j4 = j3 - (((long) i8) * ((long) this.chunkSize));
            if (j4 >= 0) {
                expandBuffer();
                if (j4 > 0) {
                    System.arraycopy(bArr, i7, this.currentBuffer, this.currentBufferPointer, (int) j4);
                }
                this.currentBufferPointer = (int) j4;
            }
        } else {
            throw new IOException("RandomAccessBuffer overflow");
        }
        long j5 = this.pointer + j;
        this.pointer = j5;
        if (j5 > this.size) {
            this.size = j5;
        }
    }

    @Override // com.tom_roush.pdfbox.io.RandomAccessRead
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public RandomAccessBuffer(InputStream inputStream) throws IOException {
        this();
        byte[] bArr = new byte[8192];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 > -1) {
                write(bArr, 0, i2);
            } else {
                seek(0L);
                return;
            }
        }
    }
}
