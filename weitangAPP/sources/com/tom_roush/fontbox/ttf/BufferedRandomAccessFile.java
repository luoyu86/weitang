package com.tom_roush.fontbox.ttf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public class BufferedRandomAccessFile extends RandomAccessFile {
    private int bufend;
    private final byte[] buffer;
    private int bufpos;
    private long realpos;

    public BufferedRandomAccessFile(String str, String str2, int i2) throws FileNotFoundException {
        super(str, str2);
        this.bufend = 0;
        this.bufpos = 0;
        this.realpos = 0L;
        this.buffer = new byte[i2];
    }

    private int fillBuffer() throws IOException {
        int i2 = super.read(this.buffer);
        if (i2 >= 0) {
            this.realpos += (long) i2;
            this.bufend = i2;
            this.bufpos = 0;
        }
        return i2;
    }

    private void invalidate() throws IOException {
        this.bufend = 0;
        this.bufpos = 0;
        this.realpos = super.getFilePointer();
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() throws IOException {
        return (this.realpos - ((long) this.bufend)) + ((long) this.bufpos);
    }

    @Override // java.io.RandomAccessFile
    public final int read() throws IOException {
        if ((this.bufpos >= this.bufend && fillBuffer() < 0) || this.bufend == 0) {
            return -1;
        }
        byte[] bArr = this.buffer;
        int i2 = this.bufpos;
        this.bufpos = i2 + 1;
        return (bArr[i2] + 256) & 255;
    }

    @Override // java.io.RandomAccessFile
    public void seek(long j) throws IOException {
        int i2;
        int i3 = (int) (this.realpos - j);
        if (i3 >= 0 && i3 <= (i2 = this.bufend)) {
            this.bufpos = i2 - i3;
        } else {
            super.seek(j);
            invalidate();
        }
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        while (true) {
            int i5 = this.bufend;
            int i6 = this.bufpos;
            int i7 = i5 - i6;
            if (i3 <= i7) {
                System.arraycopy(this.buffer, i6, bArr, i2, i3);
                this.bufpos += i3;
                return i4 + i3;
            }
            System.arraycopy(this.buffer, i6, bArr, i2, i7);
            i4 += i7;
            this.bufpos += i7;
            if (fillBuffer() <= 0) {
                if (i4 == 0) {
                    return -1;
                }
                return i4;
            }
            i2 += i7;
            i3 -= i7;
        }
    }

    public BufferedRandomAccessFile(File file, String str, int i2) throws FileNotFoundException {
        super(file, str);
        this.bufend = 0;
        this.bufpos = 0;
        this.realpos = 0L;
        this.buffer = new byte[i2];
    }
}
