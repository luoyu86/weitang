package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public final class BarcodeMatrix {
    private int currentRow;
    private final int height;
    private final BarcodeRow[] matrix;
    private final int width;

    public BarcodeMatrix(int i2, int i3) {
        int i4 = i2 + 2;
        BarcodeRow[] barcodeRowArr = new BarcodeRow[i4];
        this.matrix = barcodeRowArr;
        int length = barcodeRowArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            this.matrix[i5] = new BarcodeRow(((i3 + 4) * 17) + 1);
        }
        this.width = i3 * 17;
        this.height = i4;
        this.currentRow = 0;
    }

    public BarcodeRow getCurrentRow() {
        return this.matrix[this.currentRow];
    }

    public byte[][] getMatrix() {
        return getScaledMatrix(1, 1);
    }

    public byte[][] getScaledMatrix(int i2) {
        return getScaledMatrix(i2, i2);
    }

    public void set(int i2, int i3, byte b2) {
        this.matrix[i3].set(i2, b2);
    }

    public void setMatrix(int i2, int i3, boolean z) {
        set(i2, i3, z ? (byte) 1 : (byte) 0);
    }

    public void startRow() {
        this.currentRow++;
    }

    public byte[][] getScaledMatrix(int i2, int i3) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.height * i3, this.width * i2);
        int i4 = this.height * i3;
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[(i4 - i5) - 1] = this.matrix[i5 / i3].getScaledRow(i2);
        }
        return bArr;
    }
}
