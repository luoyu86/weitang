package com.tom_roush.harmony.javax.imageio.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class RandomAccessMemoryCache {
    private static final int BLOCK_MASK = 511;
    private static final int BLOCK_SHIFT = 9;
    private static final int BLOCK_SIZE = 512;
    private long length;
    private int firstUndisposed = 0;
    private ArrayList<byte[]> blocks = new ArrayList<>();

    private void grow(long j) {
        int size = (((int) (j >> 9)) - this.blocks.size()) + 1;
        for (int i2 = 0; i2 < size; i2++) {
            this.blocks.add(new byte[512]);
        }
        this.length = j + 1;
    }

    public int appendData(InputStream inputStream, int i2) throws IOException {
        if (i2 <= 0) {
            return 0;
        }
        long j = this.length;
        grow((((long) i2) + j) - 1);
        int i3 = (int) (j >> 9);
        int i4 = (int) (j & 511);
        int i5 = 0;
        while (i2 > 0) {
            byte[] bArr = this.blocks.get(i3);
            int iMin = Math.min(512 - i4, i2);
            i2 -= iMin;
            i5 += iMin;
            while (iMin > 0) {
                int i6 = inputStream.read(bArr, i4, iMin);
                if (i6 < 0) {
                    this.length -= (long) (i2 - i5);
                    return i5;
                }
                iMin -= i6;
                i4 += i6;
            }
            i3++;
            i4 = 0;
        }
        return i5;
    }

    public void close() {
        this.blocks.clear();
        this.length = 0L;
    }

    public void freeBefore(long j) {
        int i2 = (int) (j >> 9);
        int i3 = this.firstUndisposed;
        if (i2 <= i3) {
            return;
        }
        while (i3 < i2) {
            this.blocks.set(i3, null);
            i3++;
        }
        this.firstUndisposed = i2;
    }

    public int getData(long j) {
        if (j >= this.length) {
            return -1;
        }
        return this.blocks.get((int) (j >> 9))[(int) (j & 511)] & 255;
    }

    public long length() {
        return this.length;
    }

    public void putData(int i2, long j) {
        if (j >= this.length) {
            grow(j);
        }
        this.blocks.get((int) (j >> 9))[(int) (j & 511)] = (byte) i2;
    }

    public int getData(byte[] bArr, int i2, int i3, long j) {
        if (i3 > bArr.length - i2 || i3 < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.length;
        if (j >= j2) {
            return -1;
        }
        if (((long) i3) + j > j2) {
            i3 = (int) (j2 - j);
        }
        byte[] bArr2 = this.blocks.get((int) (j >> 9));
        int i4 = (int) (j & 511);
        int iMin = Math.min(i3, 512 - i4);
        System.arraycopy(bArr2, i4, bArr, i2, iMin);
        return iMin;
    }

    public void putData(byte[] bArr, int i2, int i3, long j) {
        if (i3 > bArr.length - i2 || i3 < 0 || i2 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return;
        }
        long j2 = (((long) i3) + j) - 1;
        if (j2 >= this.length) {
            grow(j2);
        }
        while (i3 > 0) {
            byte[] bArr2 = this.blocks.get((int) (j >> 9));
            int i4 = (int) (511 & j);
            int iMin = Math.min(512 - i4, i3);
            System.arraycopy(bArr, i2, bArr2, i4, iMin);
            j += (long) iMin;
            i3 -= iMin;
            i2 += iMin;
        }
    }

    public void getData(OutputStream outputStream, int i2, long j) throws IOException {
        if (((long) i2) + j <= this.length) {
            int i3 = (int) (j >> 9);
            int i4 = (int) (j & 511);
            if (i3 < this.firstUndisposed) {
                throw new IndexOutOfBoundsException("The requested data are already disposed");
            }
            while (i2 > 0) {
                byte[] bArr = this.blocks.get(i3);
                int iMin = Math.min(512 - i4, i2);
                outputStream.write(bArr, i4, iMin);
                i3++;
                i4 = 0;
                i2 -= iMin;
            }
            return;
        }
        throw new IndexOutOfBoundsException("Argument out of cache");
    }
}
