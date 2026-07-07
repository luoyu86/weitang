package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes2.dex */
public final class DecodedNumeric extends DecodedObject {
    public static final int FNC1 = 10;
    private final int firstDigit;
    private final int secondDigit;

    public DecodedNumeric(int i2, int i3, int i4) {
        super(i2);
        this.firstDigit = i3;
        this.secondDigit = i4;
        if (i3 < 0 || i3 > 10) {
            throw new IllegalArgumentException("Invalid firstDigit: " + i3);
        }
        if (i4 < 0 || i4 > 10) {
            throw new IllegalArgumentException("Invalid secondDigit: " + i4);
        }
    }

    public int getFirstDigit() {
        return this.firstDigit;
    }

    public int getSecondDigit() {
        return this.secondDigit;
    }

    public int getValue() {
        return (this.firstDigit * 10) + this.secondDigit;
    }

    public boolean isAnyFNC1() {
        return this.firstDigit == 10 || this.secondDigit == 10;
    }

    public boolean isFirstDigitFNC1() {
        return this.firstDigit == 10;
    }

    public boolean isSecondDigitFNC1() {
        return this.secondDigit == 10;
    }
}
