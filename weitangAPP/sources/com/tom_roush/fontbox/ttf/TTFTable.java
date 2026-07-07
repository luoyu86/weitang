package com.tom_roush.fontbox.ttf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class TTFTable {
    private long checkSum;
    public final TrueTypeFont font;
    public volatile boolean initialized;
    private long length;
    private long offset;
    private String tag;

    public TTFTable(TrueTypeFont trueTypeFont) {
        this.font = trueTypeFont;
    }

    public long getCheckSum() {
        return this.checkSum;
    }

    public boolean getInitialized() {
        return this.initialized;
    }

    public long getLength() {
        return this.length;
    }

    public long getOffset() {
        return this.offset;
    }

    public String getTag() {
        return this.tag;
    }

    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
    }

    public void setCheckSum(long j) {
        this.checkSum = j;
    }

    public void setLength(long j) {
        this.length = j;
    }

    public void setOffset(long j) {
        this.offset = j;
    }

    public void setTag(String str) {
        this.tag = str;
    }
}
