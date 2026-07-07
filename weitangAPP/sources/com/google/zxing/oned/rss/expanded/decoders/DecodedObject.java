package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
public abstract class DecodedObject {
    private final int newPosition;

    public DecodedObject(int i2) {
        this.newPosition = i2;
    }

    public int getNewPosition() {
        return this.newPosition;
    }
}
