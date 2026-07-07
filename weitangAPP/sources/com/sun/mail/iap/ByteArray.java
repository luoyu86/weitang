package com.sun.mail.iap;

import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ByteArray {
    private byte[] bytes;
    private int count;
    private int start;

    public ByteArray(byte[] bArr, int i2, int i3) {
        this.bytes = bArr;
        this.start = i2;
        this.count = i3;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public int getCount() {
        return this.count;
    }

    public byte[] getNewBytes() {
        int i2 = this.count;
        byte[] bArr = new byte[i2];
        System.arraycopy(this.bytes, this.start, bArr, 0, i2);
        return bArr;
    }

    public int getStart() {
        return this.start;
    }

    public void grow(int i2) {
        byte[] bArr = this.bytes;
        byte[] bArr2 = new byte[bArr.length + i2];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.bytes = bArr2;
    }

    public void setCount(int i2) {
        this.count = i2;
    }

    public ByteArrayInputStream toByteArrayInputStream() {
        return new ByteArrayInputStream(this.bytes, this.start, this.count);
    }

    public ByteArray(int i2) {
        this(new byte[i2], 0, i2);
    }
}
