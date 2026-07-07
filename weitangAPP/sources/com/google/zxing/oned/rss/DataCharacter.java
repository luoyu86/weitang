package com.google.zxing.oned.rss;

/* JADX INFO: loaded from: classes2.dex */
public class DataCharacter {
    private final int checksumPortion;
    private final int value;

    public DataCharacter(int i2, int i3) {
        this.value = i2;
        this.checksumPortion = i3;
    }

    public int getChecksumPortion() {
        return this.checksumPortion;
    }

    public int getValue() {
        return this.value;
    }
}
