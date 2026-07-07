package com.tom_roush.fontbox.ttf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class CmapTable extends TTFTable {
    public static final int ENCODING_MAC_ROMAN = 0;
    public static final int ENCODING_UNICODE_1_0 = 0;
    public static final int ENCODING_UNICODE_1_1 = 1;
    public static final int ENCODING_UNICODE_2_0_BMP = 3;
    public static final int ENCODING_UNICODE_2_0_FULL = 4;
    public static final int ENCODING_WIN_BIG5 = 3;
    public static final int ENCODING_WIN_JOHAB = 6;
    public static final int ENCODING_WIN_PRC = 4;
    public static final int ENCODING_WIN_SHIFT_JIS = 2;
    public static final int ENCODING_WIN_SYMBOL = 0;
    public static final int ENCODING_WIN_UNICODE_BMP = 1;
    public static final int ENCODING_WIN_UNICODE_FULL = 10;
    public static final int ENCODING_WIN_WANSUNG = 5;
    public static final int PLATFORM_MACINTOSH = 1;
    public static final int PLATFORM_UNICODE = 0;
    public static final int PLATFORM_WINDOWS = 3;
    public static final String TAG = "cmap";
    private CmapSubtable[] cmaps;

    public CmapTable(TrueTypeFont trueTypeFont) {
        super(trueTypeFont);
    }

    public CmapSubtable[] getCmaps() {
        return this.cmaps;
    }

    public CmapSubtable getSubtable(int i2, int i3) {
        for (CmapSubtable cmapSubtable : this.cmaps) {
            if (cmapSubtable.getPlatformId() == i2 && cmapSubtable.getPlatformEncodingId() == i3) {
                return cmapSubtable;
            }
        }
        return null;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFTable
    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        tTFDataStream.readUnsignedShort();
        int unsignedShort = tTFDataStream.readUnsignedShort();
        this.cmaps = new CmapSubtable[unsignedShort];
        for (int i2 = 0; i2 < unsignedShort; i2++) {
            CmapSubtable cmapSubtable = new CmapSubtable();
            cmapSubtable.initData(tTFDataStream);
            this.cmaps[i2] = cmapSubtable;
        }
        int numberOfGlyphs = trueTypeFont.getNumberOfGlyphs();
        for (int i3 = 0; i3 < unsignedShort; i3++) {
            this.cmaps[i3].initSubtable(this, numberOfGlyphs, tTFDataStream);
        }
        this.initialized = true;
    }

    public void setCmaps(CmapSubtable[] cmapSubtableArr) {
        this.cmaps = cmapSubtableArr;
    }
}
