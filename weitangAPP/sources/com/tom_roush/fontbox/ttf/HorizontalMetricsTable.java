package com.tom_roush.fontbox.ttf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class HorizontalMetricsTable extends TTFTable {
    public static final String TAG = "hmtx";
    private int[] advanceWidth;
    private short[] leftSideBearing;
    private short[] nonHorizontalLeftSideBearing;
    private int numHMetrics;

    public HorizontalMetricsTable(TrueTypeFont trueTypeFont) {
        super(trueTypeFont);
    }

    public int getAdvanceWidth(int i2) {
        if (i2 < this.numHMetrics) {
            return this.advanceWidth[i2];
        }
        return this.advanceWidth[r2.length - 1];
    }

    public int getLeftSideBearing(int i2) {
        int i3 = this.numHMetrics;
        return i2 < i3 ? this.leftSideBearing[i2] : this.nonHorizontalLeftSideBearing[i2 - i3];
    }

    @Override // com.tom_roush.fontbox.ttf.TTFTable
    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        int i2;
        HorizontalHeaderTable horizontalHeader = trueTypeFont.getHorizontalHeader();
        if (horizontalHeader == null) {
            throw new IOException("Could not get hmtx table");
        }
        this.numHMetrics = horizontalHeader.getNumberOfHMetrics();
        int numberOfGlyphs = trueTypeFont.getNumberOfGlyphs();
        int i3 = this.numHMetrics;
        this.advanceWidth = new int[i3];
        this.leftSideBearing = new short[i3];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            i2 = this.numHMetrics;
            if (i4 >= i2) {
                break;
            }
            this.advanceWidth[i4] = tTFDataStream.readUnsignedShort();
            this.leftSideBearing[i4] = tTFDataStream.readSignedShort();
            i5 += 4;
            i4++;
        }
        int i6 = numberOfGlyphs - i2;
        if (i6 >= 0) {
            numberOfGlyphs = i6;
        }
        this.nonHorizontalLeftSideBearing = new short[numberOfGlyphs];
        if (i5 < getLength()) {
            for (int i7 = 0; i7 < numberOfGlyphs; i7++) {
                if (i5 < getLength()) {
                    this.nonHorizontalLeftSideBearing[i7] = tTFDataStream.readSignedShort();
                    i5 += 2;
                }
            }
        }
        this.initialized = true;
    }
}
