package com.tom_roush.pdfbox.pdmodel.font;

import android.graphics.Path;
import android.util.Log;
import com.tom_roush.fontbox.FontBoxFont;
import com.tom_roush.fontbox.ttf.CmapSubtable;
import com.tom_roush.fontbox.ttf.CmapTable;
import com.tom_roush.fontbox.ttf.GlyphData;
import com.tom_roush.fontbox.ttf.PostScriptTable;
import com.tom_roush.fontbox.ttf.TTFParser;
import com.tom_roush.fontbox.ttf.TrueTypeFont;
import com.tom_roush.fontbox.util.BoundingBox;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.common.PDStream;
import com.tom_roush.pdfbox.pdmodel.font.encoding.BuiltInEncoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.Encoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.GlyphList;
import com.tom_roush.pdfbox.pdmodel.font.encoding.MacOSRomanEncoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.MacRomanEncoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.StandardEncoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.Type1Encoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PDTrueTypeFont extends PDSimpleFont implements PDVectorFont {
    private static final Map<String, Integer> INVERTED_MACOS_ROMAN = new HashMap(250);
    private static final int START_RANGE_F000 = 61440;
    private static final int START_RANGE_F100 = 61696;
    private static final int START_RANGE_F200 = 61952;
    private boolean cmapInitialized;
    private CmapSubtable cmapMacRoman;
    private CmapSubtable cmapWinSymbol;
    private CmapSubtable cmapWinUnicode;
    private BoundingBox fontBBox;
    private Map<Integer, Integer> gidToCode;
    private final boolean isDamaged;
    private final boolean isEmbedded;
    private final TrueTypeFont ttf;

    static {
        for (Map.Entry<Integer, String> entry : MacOSRomanEncoding.INSTANCE.getCodeToNameMap().entrySet()) {
            Map<String, Integer> map = INVERTED_MACOS_ROMAN;
            if (!map.containsKey(entry.getValue())) {
                map.put(entry.getValue(), entry.getKey());
            }
        }
    }

    public PDTrueTypeFont(COSDictionary cOSDictionary) throws IOException {
        boolean z;
        PDStream fontFile2;
        super(cOSDictionary);
        TrueTypeFont trueTypeFont = null;
        this.cmapWinUnicode = null;
        this.cmapWinSymbol = null;
        this.cmapMacRoman = null;
        this.cmapInitialized = false;
        if (getFontDescriptor() == null || (fontFile2 = super.getFontDescriptor().getFontFile2()) == null) {
            z = false;
        } else {
            try {
                trueTypeFont = new TTFParser(true).parse(fontFile2.createInputStream());
                z = false;
            } catch (IOException e2) {
                Log.w("PdfBox-Android", "Could not read embedded TTF for font " + getBaseFont(), e2);
                z = true;
            }
        }
        this.isEmbedded = trueTypeFont != null;
        this.isDamaged = z;
        if (trueTypeFont == null) {
            FontMapping<TrueTypeFont> trueTypeFont2 = FontMappers.instance().getTrueTypeFont(getBaseFont(), getFontDescriptor());
            TrueTypeFont trueTypeFont3 = (TrueTypeFont) trueTypeFont2.getFont();
            if (trueTypeFont2.isFallback()) {
                Log.w("PdfBox-Android", "Using fallback font '" + trueTypeFont3 + "' for '" + getBaseFont() + OperatorName.SHOW_TEXT_LINE);
            }
            trueTypeFont = trueTypeFont3;
        }
        this.ttf = trueTypeFont;
        readEncoding();
    }

    private void extractCmapTable() throws IOException {
        if (this.cmapInitialized) {
            return;
        }
        CmapTable cmap = this.ttf.getCmap();
        if (cmap != null) {
            for (CmapSubtable cmapSubtable : cmap.getCmaps()) {
                if (3 == cmapSubtable.getPlatformId()) {
                    if (1 == cmapSubtable.getPlatformEncodingId()) {
                        this.cmapWinUnicode = cmapSubtable;
                    } else if (cmapSubtable.getPlatformEncodingId() == 0) {
                        this.cmapWinSymbol = cmapSubtable;
                    }
                } else if (1 == cmapSubtable.getPlatformId() && cmapSubtable.getPlatformEncodingId() == 0) {
                    this.cmapMacRoman = cmapSubtable;
                } else if (cmapSubtable.getPlatformId() == 0 && cmapSubtable.getPlatformEncodingId() == 0) {
                    this.cmapWinUnicode = cmapSubtable;
                }
            }
        }
        this.cmapInitialized = true;
    }

    private BoundingBox generateBoundingBox() throws IOException {
        PDRectangle fontBoundingBox;
        return (getFontDescriptor() == null || (fontBoundingBox = getFontDescriptor().getFontBoundingBox()) == null) ? this.ttf.getFontBBox() : new BoundingBox(fontBoundingBox.getLowerLeftX(), fontBoundingBox.getLowerLeftY(), fontBoundingBox.getUpperRightX(), fontBoundingBox.getUpperRightY());
    }

    public static PDTrueTypeFont load(PDDocument pDDocument, File file, Encoding encoding) throws IOException {
        return new PDTrueTypeFont(pDDocument, new TTFParser().parse(file), encoding, true);
    }

    @Deprecated
    public static PDTrueTypeFont loadTTF(PDDocument pDDocument, File file) throws IOException {
        return new PDTrueTypeFont(pDDocument, new TTFParser().parse(file), WinAnsiEncoding.INSTANCE, true);
    }

    public int codeToGID(int i2) throws IOException {
        CmapSubtable cmapSubtable;
        Integer num;
        String unicode;
        extractCmapTable();
        int glyphId = 0;
        if (!isSymbolic()) {
            String name = this.encoding.getName(i2);
            if (".notdef".equals(name)) {
                return 0;
            }
            if (this.cmapWinUnicode != null && (unicode = GlyphList.getAdobeGlyphList().toUnicode(name)) != null) {
                glyphId = this.cmapWinUnicode.getGlyphId(unicode.codePointAt(0));
            }
            if (glyphId == 0 && this.cmapMacRoman != null && (num = INVERTED_MACOS_ROMAN.get(name)) != null) {
                glyphId = this.cmapMacRoman.getGlyphId(num.intValue());
            }
            return glyphId == 0 ? this.ttf.nameToGID(name) : glyphId;
        }
        CmapSubtable cmapSubtable2 = this.cmapWinUnicode;
        if (cmapSubtable2 != null) {
            Encoding encoding = this.encoding;
            if ((encoding instanceof WinAnsiEncoding) || (encoding instanceof MacRomanEncoding)) {
                String name2 = encoding.getName(i2);
                if (".notdef".equals(name2)) {
                    return 0;
                }
                String unicode2 = GlyphList.getAdobeGlyphList().toUnicode(name2);
                if (unicode2 != null) {
                    glyphId = this.cmapWinUnicode.getGlyphId(unicode2.codePointAt(0));
                }
            } else {
                glyphId = cmapSubtable2.getGlyphId(i2);
            }
        }
        CmapSubtable cmapSubtable3 = this.cmapWinSymbol;
        if (cmapSubtable3 != null) {
            int glyphId2 = cmapSubtable3.getGlyphId(i2);
            if (i2 >= 0 && i2 <= 255) {
                if (glyphId2 == 0) {
                    glyphId2 = this.cmapWinSymbol.getGlyphId(START_RANGE_F000 + i2);
                }
                if (glyphId2 == 0) {
                    glyphId2 = this.cmapWinSymbol.getGlyphId(START_RANGE_F100 + i2);
                }
                if (glyphId2 == 0) {
                    glyphId2 = this.cmapWinSymbol.getGlyphId(START_RANGE_F200 + i2);
                }
            }
            glyphId = glyphId2;
        }
        return (glyphId != 0 || (cmapSubtable = this.cmapMacRoman) == null) ? glyphId : cmapSubtable.getGlyphId(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public byte[] encode(int i2) throws IOException {
        Encoding encoding = this.encoding;
        if (encoding == null) {
            String strCodePointToName = getGlyphList().codePointToName(i2);
            if (!this.ttf.hasGlyph(strCodePointToName)) {
                throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", Integer.valueOf(i2), getName()));
            }
            Integer num = getGIDToCode().get(Integer.valueOf(this.ttf.nameToGID(strCodePointToName)));
            if (num != null) {
                return new byte[]{(byte) num.intValue()};
            }
            throw new IllegalArgumentException(String.format("U+%04X is not available in this font's Encoding", Integer.valueOf(i2)));
        }
        if (!encoding.contains(getGlyphList().codePointToName(i2))) {
            throw new IllegalArgumentException(String.format("U+%04X is not available in this font's encoding: %s", Integer.valueOf(i2), this.encoding.getEncodingName()));
        }
        String strCodePointToName2 = getGlyphList().codePointToName(i2);
        Map<String, Integer> nameToCodeMap = this.encoding.getNameToCodeMap();
        if (this.ttf.hasGlyph(strCodePointToName2) || this.ttf.hasGlyph(UniUtil.getUniNameOfCodePoint(i2))) {
            return new byte[]{(byte) nameToCodeMap.get(strCodePointToName2).intValue()};
        }
        throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", Integer.valueOf(i2), getName()));
    }

    public final String getBaseFont() {
        return this.dict.getNameAsString(COSName.BASE_FONT);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public BoundingBox getBoundingBox() throws IOException {
        if (this.fontBBox == null) {
            this.fontBBox = generateBoundingBox();
        }
        return this.fontBBox;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public FontBoxFont getFontBoxFont() {
        return this.ttf;
    }

    public Map<Integer, Integer> getGIDToCode() throws IOException {
        Map<Integer, Integer> map = this.gidToCode;
        if (map != null) {
            return map;
        }
        this.gidToCode = new HashMap();
        for (int i2 = 0; i2 <= 255; i2++) {
            int iCodeToGID = codeToGID(i2);
            if (!this.gidToCode.containsKey(Integer.valueOf(iCodeToGID))) {
                this.gidToCode.put(Integer.valueOf(iCodeToGID), Integer.valueOf(i2));
            }
        }
        return this.gidToCode;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getHeight(int i2) throws IOException {
        GlyphData glyph = this.ttf.getGlyph().getGlyph(codeToGID(i2));
        if (glyph != null) {
            return glyph.getBoundingBox().getHeight();
        }
        return 0.0f;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public String getName() {
        return getBaseFont();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDVectorFont
    public Path getPath(int i2) throws IOException {
        GlyphData glyph = this.ttf.getGlyph().getGlyph(codeToGID(i2));
        return glyph == null ? new Path() : glyph.getPath();
    }

    public TrueTypeFont getTrueTypeFont() {
        return this.ttf;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getWidthFromFont(int i2) throws IOException {
        float advanceWidth = this.ttf.getAdvanceWidth(codeToGID(i2));
        float unitsPerEm = this.ttf.getUnitsPerEm();
        return unitsPerEm != 1000.0f ? advanceWidth * (1000.0f / unitsPerEm) : advanceWidth;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public boolean hasGlyph(String str) throws IOException {
        return this.ttf.nameToGID(str) != 0;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public boolean isDamaged() {
        return this.isDamaged;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public boolean isEmbedded() {
        return this.isEmbedded;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public int readCode(InputStream inputStream) throws IOException {
        return inputStream.read();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public Encoding readEncodingFromFont() throws IOException {
        if (!isEmbedded() && getStandard14AFM() != null) {
            return new Type1Encoding(getStandard14AFM());
        }
        if (getSymbolicFlag() != null && !getSymbolicFlag().booleanValue()) {
            return StandardEncoding.INSTANCE;
        }
        String mappedFontName = Standard14Fonts.getMappedFontName(getName());
        if (isStandard14() && !mappedFontName.equals("Symbol") && !mappedFontName.equals("ZapfDingbats")) {
            return StandardEncoding.INSTANCE;
        }
        PostScriptTable postScript = this.ttf.getPostScript();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 <= 256; i2++) {
            int iCodeToGID = codeToGID(i2);
            if (iCodeToGID > 0) {
                String name = postScript != null ? postScript.getName(iCodeToGID) : null;
                if (name == null) {
                    name = Integer.toString(iCodeToGID);
                }
                map.put(Integer.valueOf(i2), name);
            }
        }
        return new BuiltInEncoding(map);
    }

    public static PDTrueTypeFont load(PDDocument pDDocument, InputStream inputStream, Encoding encoding) throws IOException {
        return new PDTrueTypeFont(pDDocument, new TTFParser().parse(inputStream), encoding, true);
    }

    @Deprecated
    public static PDTrueTypeFont loadTTF(PDDocument pDDocument, InputStream inputStream) throws IOException {
        return new PDTrueTypeFont(pDDocument, new TTFParser().parse(inputStream), WinAnsiEncoding.INSTANCE, true);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDVectorFont
    public boolean hasGlyph(int i2) throws IOException {
        return codeToGID(i2) != 0;
    }

    public static PDTrueTypeFont load(PDDocument pDDocument, TrueTypeFont trueTypeFont, Encoding encoding) throws IOException {
        return new PDTrueTypeFont(pDDocument, trueTypeFont, encoding, false);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public Path getPath(String str) throws IOException {
        int i2;
        int iNameToGID = this.ttf.nameToGID(str);
        if (iNameToGID == 0) {
            try {
                i2 = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
            iNameToGID = i2 > this.ttf.getNumberOfGlyphs() ? 0 : i2;
        }
        if (iNameToGID == 0) {
            return new Path();
        }
        GlyphData glyph = this.ttf.getGlyph().getGlyph(iNameToGID);
        if (glyph != null) {
            return glyph.getPath();
        }
        return new Path();
    }

    private PDTrueTypeFont(PDDocument pDDocument, TrueTypeFont trueTypeFont, Encoding encoding, boolean z) throws IOException {
        this.cmapWinUnicode = null;
        this.cmapWinSymbol = null;
        this.cmapMacRoman = null;
        this.cmapInitialized = false;
        PDTrueTypeFontEmbedder pDTrueTypeFontEmbedder = new PDTrueTypeFontEmbedder(pDDocument, this.dict, trueTypeFont, encoding);
        this.encoding = encoding;
        this.ttf = trueTypeFont;
        setFontDescriptor(pDTrueTypeFontEmbedder.getFontDescriptor());
        this.isEmbedded = true;
        this.isDamaged = false;
        this.glyphList = GlyphList.getAdobeGlyphList();
        if (z) {
            trueTypeFont.close();
        }
    }
}
