package com.tom_roush.fontbox.ttf;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class GlyphTable extends TTFTable {
    private static final int MAX_CACHED_GLYPHS = 100;
    private static final int MAX_CACHE_SIZE = 5000;
    public static final String TAG = "glyf";
    private int cached;
    private TTFDataStream data;
    private GlyphData[] glyphs;
    private IndexToLocationTable loca;
    private int numGlyphs;

    public GlyphTable(TrueTypeFont trueTypeFont) {
        super(trueTypeFont);
        this.cached = 0;
    }

    private GlyphData getGlyphData(int i2) throws IOException {
        GlyphData glyphData = new GlyphData();
        HorizontalMetricsTable horizontalMetrics = this.font.getHorizontalMetrics();
        glyphData.initData(this, this.data, horizontalMetrics == null ? 0 : horizontalMetrics.getLeftSideBearing(i2));
        if (glyphData.getDescription().isComposite()) {
            glyphData.getDescription().resolve();
        }
        return glyphData;
    }

    public GlyphData getGlyph(int i2) throws IOException {
        GlyphData glyphData;
        int i3;
        if (i2 < 0 || i2 >= this.numGlyphs) {
            return null;
        }
        GlyphData[] glyphDataArr = this.glyphs;
        if (glyphDataArr != null && glyphDataArr[i2] != null) {
            return glyphDataArr[i2];
        }
        synchronized (this.data) {
            long[] offsets = this.loca.getOffsets();
            if (offsets[i2] == offsets[i2 + 1]) {
                glyphData = new GlyphData();
                glyphData.initEmptyData();
            } else {
                long currentPosition = this.data.getCurrentPosition();
                this.data.seek(getOffset() + offsets[i2]);
                glyphData = getGlyphData(i2);
                this.data.seek(currentPosition);
            }
            GlyphData[] glyphDataArr2 = this.glyphs;
            if (glyphDataArr2 != null && glyphDataArr2[i2] == null && (i3 = this.cached) < 100) {
                glyphDataArr2[i2] = glyphData;
                this.cached = i3 + 1;
            }
        }
        return glyphData;
    }

    @Deprecated
    public GlyphData[] getGlyphs() throws IOException {
        GlyphData[] glyphDataArr;
        synchronized (this.data) {
            long[] offsets = this.loca.getOffsets();
            long j = offsets[this.numGlyphs];
            long offset = getOffset();
            if (this.glyphs == null) {
                this.glyphs = new GlyphData[this.numGlyphs];
            }
            int i2 = 0;
            while (i2 < this.numGlyphs && (j == 0 || j != offsets[i2])) {
                int i3 = i2 + 1;
                if (offsets[i3] > offsets[i2] && this.glyphs[i2] == null) {
                    this.data.seek(offsets[i2] + offset);
                    GlyphData[] glyphDataArr2 = this.glyphs;
                    if (glyphDataArr2[i2] == null) {
                        this.cached++;
                    }
                    glyphDataArr2[i2] = getGlyphData(i2);
                }
                i2 = i3;
            }
            this.initialized = true;
            glyphDataArr = this.glyphs;
        }
        return glyphDataArr;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFTable
    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.loca = trueTypeFont.getIndexToLocation();
        int numberOfGlyphs = trueTypeFont.getNumberOfGlyphs();
        this.numGlyphs = numberOfGlyphs;
        if (numberOfGlyphs < 5000) {
            this.glyphs = new GlyphData[numberOfGlyphs];
        }
        this.data = tTFDataStream;
        this.initialized = true;
    }

    public void setGlyphs(GlyphData[] glyphDataArr) {
        this.glyphs = glyphDataArr;
    }
}
