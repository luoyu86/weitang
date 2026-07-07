package com.tom_roush.fontbox.ttf;

import android.util.Log;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class TTFParser {
    private boolean isEmbedded;
    private boolean parseOnDemandOnly;

    public TTFParser() {
        this(false);
    }

    private void parseTables(TrueTypeFont trueTypeFont) throws IOException {
        for (TTFTable tTFTable : trueTypeFont.getTables()) {
            if (!tTFTable.getInitialized()) {
                trueTypeFont.readTable(tTFTable);
            }
        }
        boolean z = allowCFF() && trueTypeFont.tables.containsKey(CFFTable.TAG);
        if (trueTypeFont.getHeader() == null) {
            throw new IOException("head is mandatory");
        }
        if (trueTypeFont.getHorizontalHeader() == null) {
            throw new IOException("hhead is mandatory");
        }
        if (trueTypeFont.getMaximumProfile() == null) {
            throw new IOException("maxp is mandatory");
        }
        if (trueTypeFont.getPostScript() == null && !this.isEmbedded) {
            throw new IOException("post is mandatory");
        }
        if (!z) {
            if (trueTypeFont.getIndexToLocation() == null) {
                throw new IOException("loca is mandatory");
            }
            if (trueTypeFont.getGlyph() == null) {
                throw new IOException("glyf is mandatory");
            }
        }
        if (trueTypeFont.getNaming() == null && !this.isEmbedded) {
            throw new IOException("name is mandatory");
        }
        if (trueTypeFont.getHorizontalMetrics() == null) {
            throw new IOException("hmtx is mandatory");
        }
        if (!this.isEmbedded && trueTypeFont.getCmap() == null) {
            throw new IOException("cmap is mandatory");
        }
    }

    private TTFTable readTableDirectory(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        String string = tTFDataStream.readString(4);
        TTFTable cmapTable = string.equals(CmapTable.TAG) ? new CmapTable(trueTypeFont) : string.equals(GlyphTable.TAG) ? new GlyphTable(trueTypeFont) : string.equals(HeaderTable.TAG) ? new HeaderTable(trueTypeFont) : string.equals(HorizontalHeaderTable.TAG) ? new HorizontalHeaderTable(trueTypeFont) : string.equals(HorizontalMetricsTable.TAG) ? new HorizontalMetricsTable(trueTypeFont) : string.equals(IndexToLocationTable.TAG) ? new IndexToLocationTable(trueTypeFont) : string.equals(MaximumProfileTable.TAG) ? new MaximumProfileTable(trueTypeFont) : string.equals("name") ? new NamingTable(trueTypeFont) : string.equals(OS2WindowsMetricsTable.TAG) ? new OS2WindowsMetricsTable(trueTypeFont) : string.equals(PostScriptTable.TAG) ? new PostScriptTable(trueTypeFont) : string.equals(DigitalSignatureTable.TAG) ? new DigitalSignatureTable(trueTypeFont) : string.equals(KerningTable.TAG) ? new KerningTable(trueTypeFont) : string.equals(VerticalHeaderTable.TAG) ? new VerticalHeaderTable(trueTypeFont) : string.equals(VerticalMetricsTable.TAG) ? new VerticalMetricsTable(trueTypeFont) : string.equals(VerticalOriginTable.TAG) ? new VerticalOriginTable(trueTypeFont) : string.equals(GlyphSubstitutionTable.TAG) ? new GlyphSubstitutionTable(trueTypeFont) : readTable(trueTypeFont, string);
        cmapTable.setTag(string);
        cmapTable.setCheckSum(tTFDataStream.readUnsignedInt());
        cmapTable.setOffset(tTFDataStream.readUnsignedInt());
        cmapTable.setLength(tTFDataStream.readUnsignedInt());
        if (cmapTable.getLength() != 0 || string.equals(GlyphTable.TAG)) {
            return cmapTable;
        }
        return null;
    }

    public boolean allowCFF() {
        return false;
    }

    public TrueTypeFont newFont(TTFDataStream tTFDataStream) {
        return new TrueTypeFont(tTFDataStream);
    }

    public TrueTypeFont parse(String str) throws IOException {
        return parse(new File(str));
    }

    public TrueTypeFont parseEmbedded(InputStream inputStream) throws IOException {
        this.isEmbedded = true;
        return parse(new MemoryTTFDataStream(inputStream));
    }

    public TTFTable readTable(TrueTypeFont trueTypeFont, String str) {
        return new TTFTable(trueTypeFont);
    }

    public TTFParser(boolean z) {
        this(z, false);
    }

    public TrueTypeFont parse(File file) throws IOException {
        RAFDataStream rAFDataStream = new RAFDataStream(file, PDPageLabelRange.STYLE_ROMAN_LOWER);
        try {
            return parse(rAFDataStream);
        } catch (IOException e2) {
            rAFDataStream.close();
            throw e2;
        }
    }

    public TTFParser(boolean z, boolean z2) {
        this.isEmbedded = false;
        this.parseOnDemandOnly = false;
        this.isEmbedded = z;
        this.parseOnDemandOnly = z2;
    }

    public TrueTypeFont parse(InputStream inputStream) throws IOException {
        return parse(new MemoryTTFDataStream(inputStream));
    }

    public TrueTypeFont parse(TTFDataStream tTFDataStream) throws IOException {
        TrueTypeFont trueTypeFontNewFont = newFont(tTFDataStream);
        trueTypeFontNewFont.setVersion(tTFDataStream.read32Fixed());
        int unsignedShort = tTFDataStream.readUnsignedShort();
        tTFDataStream.readUnsignedShort();
        tTFDataStream.readUnsignedShort();
        tTFDataStream.readUnsignedShort();
        for (int i2 = 0; i2 < unsignedShort; i2++) {
            TTFTable tableDirectory = readTableDirectory(trueTypeFontNewFont, tTFDataStream);
            if (tableDirectory != null) {
                if (tableDirectory.getOffset() + tableDirectory.getLength() > trueTypeFontNewFont.getOriginalDataSize()) {
                    Log.w("PdfBox-Android", "Skip table '" + tableDirectory.getTag() + "' which goes past the file size; offset: " + tableDirectory.getOffset() + ", size: " + tableDirectory.getLength() + ", font size: " + trueTypeFontNewFont.getOriginalDataSize());
                } else {
                    trueTypeFontNewFont.addTable(tableDirectory);
                }
            }
        }
        if (!this.parseOnDemandOnly) {
            parseTables(trueTypeFontNewFont);
        }
        return trueTypeFontNewFont;
    }
}
