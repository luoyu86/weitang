package com.tom_roush.fontbox.ttf;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class OTFParser extends TTFParser {
    public OTFParser() {
    }

    @Override // com.tom_roush.fontbox.ttf.TTFParser
    public boolean allowCFF() {
        return true;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFParser
    public TTFTable readTable(TrueTypeFont trueTypeFont, String str) {
        return (str.equals("BASE") || str.equals("GDEF") || str.equals("GPOS") || str.equals(GlyphSubstitutionTable.TAG) || str.equals("JSTF")) ? new OTLTable(trueTypeFont) : str.equals(CFFTable.TAG) ? new CFFTable(trueTypeFont) : super.readTable(trueTypeFont, str);
    }

    public OTFParser(boolean z) {
        this(z, false);
    }

    @Override // com.tom_roush.fontbox.ttf.TTFParser
    public OpenTypeFont newFont(TTFDataStream tTFDataStream) {
        return new OpenTypeFont(tTFDataStream);
    }

    public OTFParser(boolean z, boolean z2) {
        super(z, z2);
    }

    @Override // com.tom_roush.fontbox.ttf.TTFParser
    public OpenTypeFont parse(String str) throws IOException {
        return (OpenTypeFont) super.parse(str);
    }

    @Override // com.tom_roush.fontbox.ttf.TTFParser
    public OpenTypeFont parse(File file) throws IOException {
        return (OpenTypeFont) super.parse(file);
    }

    @Override // com.tom_roush.fontbox.ttf.TTFParser
    public OpenTypeFont parse(InputStream inputStream) throws IOException {
        return (OpenTypeFont) super.parse(inputStream);
    }

    @Override // com.tom_roush.fontbox.ttf.TTFParser
    public OpenTypeFont parse(TTFDataStream tTFDataStream) throws IOException {
        return (OpenTypeFont) super.parse(tTFDataStream);
    }
}
