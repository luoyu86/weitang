package com.sun.mail.imap;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class LengthCounter extends OutputStream {
    private int maxsize;
    private int size = 0;
    private byte[] buf = new byte[8192];

    public LengthCounter(int i2) {
        this.maxsize = i2;
    }

    public byte[] getBytes() {
        return this.buf;
    }

    public int getSize() {
        return this.size;
    }

    @Override // java.io.OutputStream
    public void write(int i2) {
        int i3 = this.size;
        int i4 = i3 + 1;
        byte[] bArr = this.buf;
        if (bArr != null) {
            int i5 = this.maxsize;
            if (i4 > i5 && i5 >= 0) {
                this.buf = null;
            } else if (i4 > bArr.length) {
                byte[] bArr2 = new byte[Math.max(bArr.length << 1, i4)];
                System.arraycopy(this.buf, 0, bArr2, 0, this.size);
                this.buf = bArr2;
                bArr2[this.size] = (byte) i2;
            } else {
                bArr[i3] = (byte) i2;
            }
        }
        this.size = i4;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        int i4;
        if (i2 < 0 || i2 > bArr.length || i3 < 0 || (i4 = i2 + i3) > bArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return;
        }
        int i5 = this.size;
        int i6 = i5 + i3;
        byte[] bArr2 = this.buf;
        if (bArr2 != null) {
            int i7 = this.maxsize;
            if (i6 > i7 && i7 >= 0) {
                this.buf = null;
            } else if (i6 > bArr2.length) {
                byte[] bArr3 = new byte[Math.max(bArr2.length << 1, i6)];
                System.arraycopy(this.buf, 0, bArr3, 0, this.size);
                this.buf = bArr3;
                System.arraycopy(bArr, i2, bArr3, this.size, i3);
            } else {
                System.arraycopy(bArr, i2, bArr2, i5, i3);
            }
        }
        this.size = i6;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
