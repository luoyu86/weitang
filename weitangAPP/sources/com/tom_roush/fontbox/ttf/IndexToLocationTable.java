package com.tom_roush.fontbox.ttf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class IndexToLocationTable extends TTFTable {
    private static final short LONG_OFFSETS = 1;
    private static final short SHORT_OFFSETS = 0;
    public static final String TAG = "loca";
    private long[] offsets;

    public IndexToLocationTable(TrueTypeFont trueTypeFont) {
        super(trueTypeFont);
    }

    public long[] getOffsets() {
        return this.offsets;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFTable
    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        HeaderTable header = trueTypeFont.getHeader();
        if (header == null) {
            throw new IOException("Could not get head table");
        }
        int numberOfGlyphs = trueTypeFont.getNumberOfGlyphs() + 1;
        this.offsets = new long[numberOfGlyphs];
        for (int i2 = 0; i2 < numberOfGlyphs; i2++) {
            if (header.getIndexToLocFormat() == 0) {
                this.offsets[i2] = tTFDataStream.readUnsignedShort() * 2;
            } else {
                if (header.getIndexToLocFormat() != 1) {
                    throw new IOException("Error:TTF.loca unknown offset format.");
                }
                this.offsets[i2] = tTFDataStream.readUnsignedInt();
            }
        }
        this.initialized = true;
    }

    public void setOffsets(long[] jArr) {
        this.offsets = jArr;
    }
}
