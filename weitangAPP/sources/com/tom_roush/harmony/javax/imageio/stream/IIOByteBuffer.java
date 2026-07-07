package com.tom_roush.harmony.javax.imageio.stream;

/* JADX INFO: loaded from: classes2.dex */
public class IIOByteBuffer {
    private byte[] data;
    private int length;
    private int offset;

    public IIOByteBuffer(byte[] bArr, int i2, int i3) {
        this.data = bArr;
        this.offset = i2;
        this.length = i3;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getLength() {
        return this.length;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public void setLength(int i2) {
        this.length = i2;
    }

    public void setOffset(int i2) {
        this.offset = i2;
    }
}
