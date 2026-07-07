package com.tom_roush.pdfbox.pdmodel.font;

import android.graphics.Path;
import android.util.Log;
import com.tom_roush.fontbox.cmap.CMap;
import com.tom_roush.fontbox.ttf.CmapLookup;
import com.tom_roush.fontbox.ttf.GlyphData;
import com.tom_roush.fontbox.ttf.OpenTypeFont;
import com.tom_roush.fontbox.ttf.TrueTypeFont;
import com.tom_roush.fontbox.util.BoundingBox;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.IOException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PDCIDFontType2 extends PDCIDFont {
    private final int[] cid2gid;
    private final CmapLookup cmap;
    private BoundingBox fontBBox;
    private Matrix fontMatrix;
    private final boolean isDamaged;
    private final boolean isEmbedded;
    private final Set<Integer> noMapping;
    private final TrueTypeFont ttf;

    public PDCIDFontType2(COSDictionary cOSDictionary, PDType0Font pDType0Font) throws IOException {
        this(cOSDictionary, pDType0Font, null);
    }

    private TrueTypeFont findFontOrSubstitute() throws IOException {
        CIDFontMapping cIDFont = FontMappers.instance().getCIDFont(getBaseFont(), getFontDescriptor(), getCIDSystemInfo());
        OpenTypeFont font = cIDFont.isCIDFont() ? cIDFont.getFont() : (TrueTypeFont) cIDFont.getTrueTypeFont();
        if (cIDFont.isFallback()) {
            Log.w("PdfBox-Android", "Using fallback font " + font.getName() + " for CID-keyed TrueType font " + getBaseFont());
        }
        return font;
    }

    private BoundingBox generateBoundingBox() throws IOException {
        PDRectangle fontBoundingBox;
        return (getFontDescriptor() == null || (fontBoundingBox = getFontDescriptor().getFontBoundingBox()) == null || (Float.compare(fontBoundingBox.getLowerLeftX(), 0.0f) == 0 && Float.compare(fontBoundingBox.getLowerLeftY(), 0.0f) == 0 && Float.compare(fontBoundingBox.getUpperRightX(), 0.0f) == 0 && Float.compare(fontBoundingBox.getUpperRightY(), 0.0f) == 0)) ? this.ttf.getFontBBox() : new BoundingBox(fontBoundingBox.getLowerLeftX(), fontBoundingBox.getLowerLeftY(), fontBoundingBox.getUpperRightX(), fontBoundingBox.getUpperRightY());
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDCIDFont
    public int codeToCID(int i2) {
        String unicode;
        CMap cMap = this.parent.getCMap();
        return (cMap.hasCIDMappings() || !cMap.hasUnicodeMappings() || (unicode = cMap.toUnicode(i2)) == null) ? cMap.toCID(i2) : unicode.codePointAt(0);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDCIDFont
    public int codeToGID(int i2) throws IOException {
        if (this.isEmbedded) {
            int iCodeToCID = codeToCID(i2);
            int[] iArr = this.cid2gid;
            if (iArr != null) {
                if (iCodeToCID < iArr.length) {
                    return iArr[iCodeToCID];
                }
                return 0;
            }
            if (iCodeToCID < this.ttf.getNumberOfGlyphs()) {
                return iCodeToCID;
            }
            return 0;
        }
        if (this.cid2gid != null && !this.isDamaged) {
            Log.w("PdfBox-Android", "Using non-embedded GIDs in font " + getName());
            int iCodeToCID2 = codeToCID(i2);
            int[] iArr2 = this.cid2gid;
            if (iCodeToCID2 < iArr2.length) {
                return iArr2[iCodeToCID2];
            }
            return 0;
        }
        String unicode = this.parent.toUnicode(i2);
        if (unicode != null) {
            if (unicode.length() > 1) {
                Log.w("PdfBox-Android", "Trying to map multi-byte character using 'cmap', result will be poor");
            }
            return this.cmap.getGlyphId(unicode.codePointAt(0));
        }
        if (!this.noMapping.contains(Integer.valueOf(i2))) {
            this.noMapping.add(Integer.valueOf(i2));
            Log.w("PdfBox-Android", "Failed to find a character mapping for " + i2 + " in " + getName());
        }
        return codeToCID(i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    @Override // com.tom_roush.pdfbox.pdmodel.font.PDCIDFont
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] encode(int r7) {
        /*
            r6 = this;
            boolean r0 = r6.isEmbedded
            r1 = 0
            if (r0 == 0) goto L4b
            com.tom_roush.pdfbox.pdmodel.font.PDType0Font r0 = r6.parent
            com.tom_roush.fontbox.cmap.CMap r0 = r0.getCMap()
            java.lang.String r0 = r0.getName()
            java.lang.String r2 = "Identity-"
            boolean r0 = r0.startsWith(r2)
            r2 = -1
            if (r0 == 0) goto L21
            com.tom_roush.fontbox.ttf.CmapLookup r0 = r6.cmap
            if (r0 == 0) goto L34
            int r0 = r0.getGlyphId(r7)
            goto L35
        L21:
            com.tom_roush.pdfbox.pdmodel.font.PDType0Font r0 = r6.parent
            com.tom_roush.fontbox.cmap.CMap r0 = r0.getCMapUCS2()
            if (r0 == 0) goto L34
            com.tom_roush.pdfbox.pdmodel.font.PDType0Font r0 = r6.parent
            com.tom_roush.fontbox.cmap.CMap r0 = r0.getCMapUCS2()
            int r0 = r0.toCID(r7)
            goto L35
        L34:
            r0 = -1
        L35:
            if (r0 != r2) goto L51
            com.tom_roush.pdfbox.pdmodel.font.PDType0Font r0 = r6.parent
            com.tom_roush.fontbox.cmap.CMap r0 = r0.getToUnicodeCMap()
            char r2 = (char) r7
            java.lang.String r2 = java.lang.Character.toString(r2)
            byte[] r0 = r0.getCodesFromUnicode(r2)
            if (r0 == 0) goto L49
            return r0
        L49:
            r0 = 0
            goto L51
        L4b:
            com.tom_roush.fontbox.ttf.CmapLookup r0 = r6.cmap
            int r0 = r0.getGlyphId(r7)
        L51:
            r2 = 1
            r3 = 2
            if (r0 == 0) goto L64
            byte[] r7 = new byte[r3]
            int r3 = r0 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = (byte) r3
            r7[r1] = r3
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = (byte) r0
            r7[r2] = r0
            return r7
        L64:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r4 = 3
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)
            r4[r1] = r5
            char r7 = (char) r7
            java.lang.Character r7 = java.lang.Character.valueOf(r7)
            r4[r2] = r7
            java.lang.String r7 = r6.getName()
            r4[r3] = r7
            java.lang.String r7 = "No glyph for U+%04X (%c) in font %s"
            java.lang.String r7 = java.lang.String.format(r7, r4)
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.font.PDCIDFontType2.encode(int):byte[]");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public BoundingBox getBoundingBox() throws IOException {
        if (this.fontBBox == null) {
            this.fontBBox = generateBoundingBox();
        }
        return this.fontBBox;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public Matrix getFontMatrix() {
        if (this.fontMatrix == null) {
            this.fontMatrix = new Matrix(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
        }
        return this.fontMatrix;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getHeight(int i2) throws IOException {
        return (this.ttf.getHorizontalHeader().getAscender() + (-this.ttf.getHorizontalHeader().getDescender())) / this.ttf.getUnitsPerEm();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDVectorFont
    public Path getPath(int i2) throws IOException {
        TrueTypeFont trueTypeFont = this.ttf;
        if ((trueTypeFont instanceof OpenTypeFont) && ((OpenTypeFont) trueTypeFont).isPostScript()) {
            return ((OpenTypeFont) this.ttf).getCFF().getFont().getType2CharString(codeToGID(i2)).getPath();
        }
        GlyphData glyph = this.ttf.getGlyph().getGlyph(codeToGID(i2));
        return glyph != null ? glyph.getPath() : new Path();
    }

    public TrueTypeFont getTrueTypeFont() {
        return this.ttf;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getWidthFromFont(int i2) throws IOException {
        int advanceWidth = this.ttf.getAdvanceWidth(codeToGID(i2));
        int unitsPerEm = this.ttf.getUnitsPerEm();
        if (unitsPerEm != 1000) {
            advanceWidth = (int) (advanceWidth * (1000.0f / unitsPerEm));
        }
        return advanceWidth;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDVectorFont
    public boolean hasGlyph(int i2) throws IOException {
        return codeToGID(i2) != 0;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public boolean isDamaged() {
        return this.isDamaged;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public boolean isEmbedded() {
        return this.isEmbedded;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PDCIDFontType2(com.tom_roush.pdfbox.cos.COSDictionary r5, com.tom_roush.pdfbox.pdmodel.font.PDType0Font r6, com.tom_roush.fontbox.ttf.TrueTypeFont r7) throws java.io.IOException {
        /*
            r4 = this;
            java.lang.String r0 = "PdfBox-Android"
            r4.<init>(r5, r6)
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            r4.noMapping = r5
            com.tom_roush.pdfbox.pdmodel.font.PDFontDescriptor r5 = r4.getFontDescriptor()
            r6 = 0
            r1 = 1
            if (r7 == 0) goto L1c
            r4.ttf = r7
            r4.isEmbedded = r1
            r4.isDamaged = r6
            goto L8b
        L1c:
            r7 = 0
            if (r5 == 0) goto L30
            com.tom_roush.pdfbox.pdmodel.common.PDStream r2 = r5.getFontFile2()
            if (r2 != 0) goto L29
            com.tom_roush.pdfbox.pdmodel.common.PDStream r2 = r5.getFontFile3()
        L29:
            if (r2 != 0) goto L31
            com.tom_roush.pdfbox.pdmodel.common.PDStream r2 = r5.getFontFile()
            goto L31
        L30:
            r2 = r7
        L31:
            if (r2 == 0) goto L7a
            com.tom_roush.fontbox.ttf.OTFParser r3 = new com.tom_roush.fontbox.ttf.OTFParser     // Catch: java.io.IOException -> L5f
            r3.<init>(r1)     // Catch: java.io.IOException -> L5f
            com.tom_roush.pdfbox.cos.COSInputStream r2 = r2.createInputStream()     // Catch: java.io.IOException -> L5f
            com.tom_roush.fontbox.ttf.OpenTypeFont r7 = r3.parse(r2)     // Catch: java.io.IOException -> L5f
            boolean r2 = r7.isPostScript()     // Catch: java.io.IOException -> L5f
            if (r2 == 0) goto L7a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L5f
            r2.<init>()     // Catch: java.io.IOException -> L5f
            java.lang.String r3 = "Found CFF/OTF but expected embedded TTF font "
            r2.append(r3)     // Catch: java.io.IOException -> L5f
            java.lang.String r5 = r5.getFontName()     // Catch: java.io.IOException -> L5f
            r2.append(r5)     // Catch: java.io.IOException -> L5f
            java.lang.String r5 = r2.toString()     // Catch: java.io.IOException -> L5f
            android.util.Log.w(r0, r5)     // Catch: java.io.IOException -> L5f
            goto L78
        L5f:
            r5 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Could not read embedded OTF for font "
            r2.append(r3)
            java.lang.String r3 = r4.getBaseFont()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r0, r2, r5)
        L78:
            r5 = 1
            goto L7b
        L7a:
            r5 = 0
        L7b:
            if (r7 == 0) goto L7e
            goto L7f
        L7e:
            r1 = 0
        L7f:
            r4.isEmbedded = r1
            r4.isDamaged = r5
            if (r7 != 0) goto L89
            com.tom_roush.fontbox.ttf.TrueTypeFont r7 = r4.findFontOrSubstitute()
        L89:
            r4.ttf = r7
        L8b:
            com.tom_roush.fontbox.ttf.TrueTypeFont r5 = r4.ttf
            com.tom_roush.fontbox.ttf.CmapLookup r5 = r5.getUnicodeCmapLookup(r6)
            r4.cmap = r5
            int[] r5 = r4.readCIDToGIDMap()
            r4.cid2gid = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.font.PDCIDFontType2.<init>(com.tom_roush.pdfbox.cos.COSDictionary, com.tom_roush.pdfbox.pdmodel.font.PDType0Font, com.tom_roush.fontbox.ttf.TrueTypeFont):void");
    }
}
