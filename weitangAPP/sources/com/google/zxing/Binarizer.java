package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Binarizer {
    private final LuminanceSource source;

    public Binarizer(LuminanceSource luminanceSource) {
        this.source = luminanceSource;
    }

    public abstract Binarizer createBinarizer(LuminanceSource luminanceSource);

    public abstract BitMatrix getBlackMatrix() throws NotFoundException;

    public abstract BitArray getBlackRow(int i2, BitArray bitArray) throws NotFoundException;

    public int getHeight() {
        return this.source.getHeight();
    }

    public LuminanceSource getLuminanceSource() {
        return this.source;
    }

    public int getWidth() {
        return this.source.getWidth();
    }
}
