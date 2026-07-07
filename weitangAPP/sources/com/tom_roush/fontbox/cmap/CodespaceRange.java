package com.tom_roush.fontbox.cmap;

/* JADX INFO: loaded from: classes2.dex */
public class CodespaceRange {
    private int codeLength;
    private int[] end;
    private byte[] endBytes;
    private int[] start;
    private byte[] startBytes;

    public CodespaceRange(byte[] bArr, byte[] bArr2) {
        this.codeLength = 0;
        if (bArr.length != bArr2.length && bArr.length == 1 && bArr[0] == 0) {
            bArr = new byte[bArr2.length];
        } else if (bArr.length != bArr2.length) {
            throw new IllegalArgumentException("The start and the end values must not have different lengths.");
        }
        this.start = new int[bArr.length];
        this.end = new int[bArr2.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            this.start[i2] = bArr[i2] & 255;
            this.end[i2] = bArr2[i2] & 255;
        }
        this.codeLength = bArr2.length;
    }

    public int getCodeLength() {
        return this.codeLength;
    }

    public byte[] getEnd() {
        return this.endBytes;
    }

    public byte[] getStart() {
        return this.startBytes;
    }

    public boolean isFullMatch(byte[] bArr, int i2) {
        if (this.codeLength != i2) {
            return false;
        }
        for (int i3 = 0; i3 < this.codeLength; i3++) {
            int i4 = bArr[i3] & 255;
            if (i4 < this.start[i3] || i4 > this.end[i3]) {
                return false;
            }
        }
        return true;
    }

    public boolean matches(byte[] bArr) {
        return isFullMatch(bArr, bArr.length);
    }

    public void setEnd(byte[] bArr) {
        this.endBytes = bArr;
        this.end = new int[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            this.end[i2] = bArr[i2] & 255;
        }
    }

    public void setStart(byte[] bArr) {
        this.startBytes = bArr;
        this.start = new int[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            this.start[i2] = bArr[i2] & 255;
        }
        this.codeLength = bArr.length;
    }

    public CodespaceRange() {
        this.codeLength = 0;
    }
}
