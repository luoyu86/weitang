package com.tom_roush.fontbox.cmap;

/* JADX INFO: loaded from: classes2.dex */
public class CIDRange {
    private final int cid;
    private final char from;
    private char to;

    public CIDRange(char c2, char c3, int i2) {
        this.from = c2;
        this.to = c3;
        this.cid = i2;
    }

    public boolean extend(char c2, char c3, int i2) {
        char c4 = this.to;
        if (c2 != c4 + 1 || i2 != ((this.cid + c4) - this.from) + 1) {
            return false;
        }
        this.to = c3;
        return true;
    }

    public int map(char c2) {
        char c3 = this.from;
        if (c3 > c2 || c2 > this.to) {
            return -1;
        }
        return this.cid + (c2 - c3);
    }

    public int unmap(int i2) {
        int i3 = this.cid;
        if (i3 > i2) {
            return -1;
        }
        char c2 = this.to;
        char c3 = this.from;
        if (i2 <= (c2 - c3) + i3) {
            return c3 + (i2 - i3);
        }
        return -1;
    }
}
