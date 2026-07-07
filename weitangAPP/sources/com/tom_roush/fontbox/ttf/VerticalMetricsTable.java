package com.tom_roush.fontbox.ttf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class VerticalMetricsTable extends TTFTable {
    public static final String TAG = "vmtx";
    private short[] additionalTopSideBearing;
    private int[] advanceHeight;
    private int numVMetrics;
    private short[] topSideBearing;

    public VerticalMetricsTable(TrueTypeFont trueTypeFont) {
        super(trueTypeFont);
    }

    public int getAdvanceHeight(int i2) {
        if (i2 < this.numVMetrics) {
            return this.advanceHeight[i2];
        }
        return this.advanceHeight[r2.length - 1];
    }

    public int getTopSideBearing(int i2) {
        int i3 = this.numVMetrics;
        return i2 < i3 ? this.topSideBearing[i2] : this.additionalTopSideBearing[i2 - i3];
    }

    @Override // com.tom_roush.fontbox.ttf.TTFTable
    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        VerticalHeaderTable verticalHeader = trueTypeFont.getVerticalHeader();
        if (verticalHeader == null) {
            throw new IOException("Could not get vhea table");
        }
        this.numVMetrics = verticalHeader.getNumberOfVMetrics();
        int numberOfGlyphs = trueTypeFont.getNumberOfGlyphs();
        int i2 = this.numVMetrics;
        this.advanceHeight = new int[i2];
        this.topSideBearing = new short[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < this.numVMetrics; i4++) {
            this.advanceHeight[i4] = tTFDataStream.readUnsignedShort();
            this.topSideBearing[i4] = tTFDataStream.readSignedShort();
            i3 += 4;
        }
        if (i3 < getLength()) {
            int i5 = numberOfGlyphs - this.numVMetrics;
            if (i5 >= 0) {
                numberOfGlyphs = i5;
            }
            this.additionalTopSideBearing = new short[numberOfGlyphs];
            for (int i6 = 0; i6 < numberOfGlyphs; i6++) {
                if (i3 < getLength()) {
                    this.additionalTopSideBearing[i6] = tTFDataStream.readSignedShort();
                    i3 += 2;
                }
            }
        }
        this.initialized = true;
    }
}
