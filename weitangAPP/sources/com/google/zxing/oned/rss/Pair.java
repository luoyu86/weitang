package com.google.zxing.oned.rss;

/* JADX INFO: loaded from: classes2.dex */
public final class Pair extends DataCharacter {
    private int count;
    private final FinderPattern finderPattern;

    public Pair(int i2, int i3, FinderPattern finderPattern) {
        super(i2, i3);
        this.finderPattern = finderPattern;
    }

    public int getCount() {
        return this.count;
    }

    public FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    public void incrementCount() {
        this.count++;
    }
}
