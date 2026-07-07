package com.tom_roush.pdfbox.pdmodel.font;

import android.graphics.Path;
import android.util.Log;
import com.tom_roush.fontbox.cmap.CMap;
import com.tom_roush.fontbox.ttf.CmapLookup;
import com.tom_roush.fontbox.ttf.TTFParser;
import com.tom_roush.fontbox.ttf.TrueTypeFont;
import com.tom_roush.fontbox.util.BoundingBox;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.util.Matrix;
import com.tom_roush.pdfbox.util.Vector;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PDType0Font extends PDFont implements PDVectorFont {
    private CMap cMap;
    private CMap cMapUCS2;
    private final PDCIDFont descendantFont;
    private PDCIDFontType2Embedder embedder;
    private boolean isCMapPredefined;
    private boolean isDescendantCJK;
    private final Set<Integer> noUnicode;
    private TrueTypeFont ttf;

    public PDType0Font(COSDictionary cOSDictionary) throws IOException {
        super(cOSDictionary);
        this.noUnicode = new HashSet();
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.DESCENDANT_FONTS);
        if (!(dictionaryObject instanceof COSArray)) {
            throw new IOException("Missing descendant font array");
        }
        COSArray cOSArray = (COSArray) dictionaryObject;
        if (cOSArray.size() == 0) {
            throw new IOException("Descendant font array is empty");
        }
        COSBase object = cOSArray.getObject(0);
        if (!(object instanceof COSDictionary)) {
            throw new IOException("Missing descendant font dictionary");
        }
        this.descendantFont = PDFontFactory.createDescendantFont((COSDictionary) object, this);
        readEncoding();
        fetchCMapUCS2();
    }

    private void fetchCMapUCS2() throws IOException {
        COSName cOSName = this.dict.getCOSName(COSName.ENCODING);
        if ((!this.isCMapPredefined || cOSName == COSName.IDENTITY_H || cOSName == COSName.IDENTITY_V) && !this.isDescendantCJK) {
            return;
        }
        String name = null;
        if (this.isDescendantCJK) {
            name = this.descendantFont.getCIDSystemInfo().getRegistry() + "-" + this.descendantFont.getCIDSystemInfo().getOrdering() + "-" + this.descendantFont.getCIDSystemInfo().getSupplement();
        } else if (cOSName != null) {
            name = cOSName.getName();
        }
        if (name != null) {
            try {
                CMap predefinedCMap = CMapManager.getPredefinedCMap(name);
                this.cMapUCS2 = CMapManager.getPredefinedCMap(predefinedCMap.getRegistry() + "-" + predefinedCMap.getOrdering() + "-UCS2");
            } catch (IOException e2) {
                Log.w("PdfBox-Android", "Could not get " + name + " UC2 map for font " + getName(), e2);
            }
        }
    }

    public static PDType0Font load(PDDocument pDDocument, File file) throws IOException {
        return new PDType0Font(pDDocument, new TTFParser().parse(file), true, true, false);
    }

    public static PDType0Font loadVertical(PDDocument pDDocument, File file) throws IOException {
        return new PDType0Font(pDDocument, new TTFParser().parse(file), true, true, true);
    }

    private void readEncoding() throws IOException {
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.ENCODING);
        boolean z = true;
        if (dictionaryObject instanceof COSName) {
            CMap predefinedCMap = CMapManager.getPredefinedCMap(((COSName) dictionaryObject).getName());
            this.cMap = predefinedCMap;
            if (predefinedCMap == null) {
                throw new IOException("Missing required CMap");
            }
            this.isCMapPredefined = true;
        } else if (dictionaryObject != null) {
            CMap cMap = readCMap(dictionaryObject);
            this.cMap = cMap;
            if (cMap == null) {
                throw new IOException("Missing required CMap");
            }
            if (!cMap.hasCIDMappings()) {
                Log.w("PdfBox-Android", "Invalid Encoding CMap in font " + getName());
            }
        }
        PDCIDSystemInfo cIDSystemInfo = this.descendantFont.getCIDSystemInfo();
        if (cIDSystemInfo != null) {
            if (!"Adobe".equals(cIDSystemInfo.getRegistry()) || (!"GB1".equals(cIDSystemInfo.getOrdering()) && !"CNS1".equals(cIDSystemInfo.getOrdering()) && !"Japan1".equals(cIDSystemInfo.getOrdering()) && !"Korea1".equals(cIDSystemInfo.getOrdering()))) {
                z = false;
            }
            this.isDescendantCJK = z;
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public void addToSubset(int i2) {
        if (!willBeSubset()) {
            throw new IllegalStateException("This font was created with subsetting disabled");
        }
        this.embedder.addToSubset(i2);
    }

    public int codeToCID(int i2) {
        return this.descendantFont.codeToCID(i2);
    }

    public int codeToGID(int i2) throws IOException {
        return this.descendantFont.codeToGID(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public byte[] encode(int i2) throws IOException {
        return this.descendantFont.encode(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont, com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getAverageFontWidth() {
        return this.descendantFont.getAverageFontWidth();
    }

    public String getBaseFont() {
        return this.dict.getNameAsString(COSName.BASE_FONT);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public BoundingBox getBoundingBox() throws IOException {
        return this.descendantFont.getBoundingBox();
    }

    public CMap getCMap() {
        return this.cMap;
    }

    public CMap getCMapUCS2() {
        return this.cMapUCS2;
    }

    public PDCIDFont getDescendantFont() {
        return this.descendantFont;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public Vector getDisplacement(int i2) throws IOException {
        return isVertical() ? new Vector(0.0f, this.descendantFont.getVerticalDisplacementVectorY(i2) / 1000.0f) : super.getDisplacement(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont, com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public PDFontDescriptor getFontDescriptor() {
        return this.descendantFont.getFontDescriptor();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont, com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public Matrix getFontMatrix() {
        return this.descendantFont.getFontMatrix();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getHeight(int i2) throws IOException {
        return this.descendantFont.getHeight(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public String getName() {
        return getBaseFont();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDVectorFont
    public Path getPath(int i2) throws IOException {
        return this.descendantFont.getPath(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont, com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public Vector getPositionVector(int i2) {
        return this.descendantFont.getPositionVector(i2).scale(-0.001f);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public float getStandard14Width(int i2) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont, com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getWidth(int i2) throws IOException {
        return this.descendantFont.getWidth(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getWidthFromFont(int i2) throws IOException {
        return this.descendantFont.getWidthFromFont(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public boolean hasExplicitWidth(int i2) throws IOException {
        return this.descendantFont.hasExplicitWidth(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDVectorFont
    public boolean hasGlyph(int i2) throws IOException {
        return this.descendantFont.hasGlyph(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public boolean isDamaged() {
        return this.descendantFont.isDamaged();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public boolean isEmbedded() {
        return this.descendantFont.isEmbedded();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public boolean isStandard14() {
        return false;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public boolean isVertical() {
        return this.cMap.getWMode() == 1;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public int readCode(InputStream inputStream) throws IOException {
        return this.cMap.readCode(inputStream);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public void subset() throws IOException {
        if (!willBeSubset()) {
            throw new IllegalStateException("This font was created with subsetting disabled");
        }
        this.embedder.subset();
        TrueTypeFont trueTypeFont = this.ttf;
        if (trueTypeFont != null) {
            trueTypeFont.close();
            this.ttf = null;
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public String toString() {
        return getClass().getSimpleName() + "/" + (getDescendantFont() != null ? getDescendantFont().getClass().getSimpleName() : null) + ", PostScript name: " + getBaseFont();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public String toUnicode(int i2) throws IOException {
        TrueTypeFont trueTypeFont;
        String unicode = super.toUnicode(i2);
        if (unicode != null) {
            return unicode;
        }
        if ((this.isCMapPredefined || this.isDescendantCJK) && this.cMapUCS2 != null) {
            return this.cMapUCS2.toUnicode(codeToCID(i2));
        }
        PDCIDFont pDCIDFont = this.descendantFont;
        if ((pDCIDFont instanceof PDCIDFontType2) && (trueTypeFont = ((PDCIDFontType2) pDCIDFont).getTrueTypeFont()) != null) {
            try {
                CmapLookup unicodeCmapLookup = trueTypeFont.getUnicodeCmapLookup(false);
                if (unicodeCmapLookup != null) {
                    List<Integer> charCodes = unicodeCmapLookup.getCharCodes(this.descendantFont.isEmbedded() ? this.descendantFont.codeToGID(i2) : this.descendantFont.codeToCID(i2));
                    if (charCodes != null && !charCodes.isEmpty()) {
                        return Character.toString((char) charCodes.get(0).intValue());
                    }
                }
            } catch (IOException e2) {
                Log.w("PdfBox-Android", "get unicode from font cmap fail", e2);
            }
        }
        if (this.noUnicode.contains(Integer.valueOf(i2))) {
            return null;
        }
        Log.w("PdfBox-Android", "No Unicode mapping for " + ("CID+" + codeToCID(i2)) + " (" + i2 + ") in font " + getName());
        this.noUnicode.add(Integer.valueOf(i2));
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public boolean willBeSubset() {
        PDCIDFontType2Embedder pDCIDFontType2Embedder = this.embedder;
        return pDCIDFontType2Embedder != null && pDCIDFontType2Embedder.needsSubset();
    }

    public static PDType0Font load(PDDocument pDDocument, InputStream inputStream) throws IOException {
        return load(pDDocument, inputStream, true);
    }

    public static PDType0Font loadVertical(PDDocument pDDocument, InputStream inputStream) throws IOException {
        return new PDType0Font(pDDocument, new TTFParser().parse(inputStream), true, true, true);
    }

    public static PDType0Font load(PDDocument pDDocument, InputStream inputStream, boolean z) throws IOException {
        return new PDType0Font(pDDocument, new TTFParser().parse(inputStream), z, true, false);
    }

    public static PDType0Font loadVertical(PDDocument pDDocument, InputStream inputStream, boolean z) throws IOException {
        return new PDType0Font(pDDocument, new TTFParser().parse(inputStream), z, true, true);
    }

    public static PDType0Font load(PDDocument pDDocument, TrueTypeFont trueTypeFont, boolean z) throws IOException {
        return new PDType0Font(pDDocument, trueTypeFont, z, false, false);
    }

    public static PDType0Font loadVertical(PDDocument pDDocument, TrueTypeFont trueTypeFont, boolean z) throws IOException {
        return new PDType0Font(pDDocument, trueTypeFont, z, false, true);
    }

    private PDType0Font(PDDocument pDDocument, TrueTypeFont trueTypeFont, boolean z, boolean z2, boolean z3) throws IOException {
        this.noUnicode = new HashSet();
        if (z3) {
            trueTypeFont.enableVerticalSubstitutions();
        }
        PDCIDFontType2Embedder pDCIDFontType2Embedder = new PDCIDFontType2Embedder(pDDocument, this.dict, trueTypeFont, z, this, z3);
        this.embedder = pDCIDFontType2Embedder;
        this.descendantFont = pDCIDFontType2Embedder.getCIDFont();
        readEncoding();
        fetchCMapUCS2();
        if (z2) {
            if (z) {
                this.ttf = trueTypeFont;
                pDDocument.registerTrueTypeFontForClosing(trueTypeFont);
            } else {
                trueTypeFont.close();
            }
        }
    }
}
