package com.tom_roush.pdfbox.pdmodel.font;

import android.graphics.Path;
import android.util.Log;
import com.tom_roush.fontbox.EncodedFont;
import com.tom_roush.fontbox.FontBoxFont;
import com.tom_roush.fontbox.cff.CFFParser;
import com.tom_roush.fontbox.cff.CFFType1Font;
import com.tom_roush.fontbox.util.BoundingBox;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.common.PDStream;
import com.tom_roush.pdfbox.pdmodel.font.encoding.Encoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.StandardEncoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.Type1Encoding;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PDType1CFont extends PDSimpleFont {
    private Float avgWidth;
    private final CFFType1Font cffFont;
    private BoundingBox fontBBox;
    private Matrix fontMatrix;
    private final AffineTransform fontMatrixTransform;
    private final FontBoxFont genericFont;
    private final Map<String, Float> glyphHeights;
    private final boolean isDamaged;
    private final boolean isEmbedded;

    public class FF3ByteSource implements CFFParser.ByteSource {
        private FF3ByteSource() {
        }

        @Override // com.tom_roush.fontbox.cff.CFFParser.ByteSource
        public byte[] getBytes() throws IOException {
            return PDType1CFont.this.getFontDescriptor().getFontFile3().toByteArray();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v12 */
    public PDType1CFont(COSDictionary cOSDictionary) throws Throwable {
        byte[] byteArray;
        boolean z;
        PDStream fontFile3;
        super(cOSDictionary);
        this.glyphHeights = new HashMap();
        AnonymousClass1 anonymousClass1 = 0;
        CFFType1Font cFFType1Font = 0;
        this.avgWidth = null;
        PDFontDescriptor fontDescriptor = getFontDescriptor();
        if (fontDescriptor == null || (fontFile3 = fontDescriptor.getFontFile3()) == null) {
            byteArray = null;
        } else {
            byteArray = fontFile3.toByteArray();
            if (byteArray.length == 0) {
                Log.e("PdfBox-Android", "Invalid data for embedded Type1C font " + getName());
                byteArray = null;
            }
        }
        if (byteArray != null) {
            try {
                anonymousClass1 = (CFFType1Font) new CFFParser().parse(byteArray, new FF3ByteSource()).get(0);
                z = false;
                cFFType1Font = anonymousClass1;
            } catch (IOException e2) {
                Log.e("PdfBox-Android", "Can't read the embedded Type1C font " + getName(), e2);
                z = true;
            }
        } else {
            z = false;
            cFFType1Font = anonymousClass1;
        }
        this.isDamaged = z;
        this.cffFont = cFFType1Font;
        if (cFFType1Font != 0) {
            this.genericFont = cFFType1Font;
            this.isEmbedded = true;
        } else {
            FontMapping<FontBoxFont> fontBoxFont = FontMappers.instance().getFontBoxFont(getBaseFont(), fontDescriptor);
            FontBoxFont font = fontBoxFont.getFont();
            this.genericFont = font;
            if (fontBoxFont.isFallback()) {
                Log.w("PdfBox-Android", "Using fallback font " + font.getName() + " for " + getBaseFont());
            }
            this.isEmbedded = false;
        }
        readEncoding();
        AffineTransform affineTransformCreateAffineTransform = getFontMatrix().createAffineTransform();
        this.fontMatrixTransform = affineTransformCreateAffineTransform;
        affineTransformCreateAffineTransform.scale(1000.0d, 1000.0d);
    }

    private BoundingBox generateBoundingBox() throws IOException {
        PDRectangle fontBoundingBox;
        return (getFontDescriptor() == null || (fontBoundingBox = getFontDescriptor().getFontBoundingBox()) == null || (fontBoundingBox.getLowerLeftX() == 0.0f && fontBoundingBox.getLowerLeftY() == 0.0f && fontBoundingBox.getUpperRightX() == 0.0f && fontBoundingBox.getUpperRightY() == 0.0f)) ? this.genericFont.getFontBBox() : new BoundingBox(fontBoundingBox.getLowerLeftX(), fontBoundingBox.getLowerLeftY(), fontBoundingBox.getUpperRightX(), fontBoundingBox.getUpperRightY());
    }

    private float getAverageCharacterWidth() {
        return 500.0f;
    }

    private String getNameInFont(String str) throws IOException {
        if (isEmbedded() || this.genericFont.hasGlyph(str)) {
            return str;
        }
        String unicode = getGlyphList().toUnicode(str);
        if (unicode != null && unicode.length() == 1) {
            String uniNameOfCodePoint = UniUtil.getUniNameOfCodePoint(unicode.codePointAt(0));
            if (this.genericFont.hasGlyph(uniNameOfCodePoint)) {
                return uniNameOfCodePoint;
            }
        }
        return ".notdef";
    }

    public String codeToName(int i2) {
        return getEncoding().getName(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public byte[] encode(int i2) throws IOException {
        String strCodePointToName = getGlyphList().codePointToName(i2);
        if (!this.encoding.contains(strCodePointToName)) {
            throw new IllegalArgumentException(String.format("U+%04X ('%s') is not available in this font's encoding: %s", Integer.valueOf(i2), strCodePointToName, this.encoding.getEncodingName()));
        }
        String nameInFont = getNameInFont(strCodePointToName);
        Map<String, Integer> nameToCodeMap = this.encoding.getNameToCodeMap();
        if (nameInFont.equals(".notdef") || !this.genericFont.hasGlyph(nameInFont)) {
            throw new IllegalArgumentException(String.format("No glyph for U+%04X in font %s", Integer.valueOf(i2), getName()));
        }
        return new byte[]{(byte) nameToCodeMap.get(strCodePointToName).intValue()};
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont, com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getAverageFontWidth() {
        if (this.avgWidth == null) {
            this.avgWidth = Float.valueOf(getAverageCharacterWidth());
        }
        return this.avgWidth.floatValue();
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

    public CFFType1Font getCFFType1Font() {
        return this.cffFont;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public FontBoxFont getFontBoxFont() {
        return this.genericFont;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont, com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public final Matrix getFontMatrix() {
        if (this.fontMatrix == null) {
            List<Number> fontMatrix = null;
            try {
                fontMatrix = this.genericFont.getFontMatrix();
            } catch (IOException unused) {
                this.fontMatrix = PDFont.DEFAULT_FONT_MATRIX;
            }
            if (fontMatrix == null || fontMatrix.size() != 6) {
                return super.getFontMatrix();
            }
            this.fontMatrix = new Matrix(fontMatrix.get(0).floatValue(), fontMatrix.get(1).floatValue(), fontMatrix.get(2).floatValue(), fontMatrix.get(3).floatValue(), fontMatrix.get(4).floatValue(), fontMatrix.get(5).floatValue());
        }
        return this.fontMatrix;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getHeight(int i2) throws IOException {
        String strCodeToName = codeToName(i2);
        if (this.glyphHeights.containsKey(strCodeToName)) {
            return this.glyphHeights.get(strCodeToName).floatValue();
        }
        CFFType1Font cFFType1Font = this.cffFont;
        if (cFFType1Font == null) {
            Log.w("PdfBox-Android", "No embedded CFF font, returning 0");
            return 0.0f;
        }
        float fHeight = cFFType1Font.getType1CharString(strCodeToName).getBounds().height();
        this.glyphHeights.put(strCodeToName, Float.valueOf(fHeight));
        return fHeight;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public final String getName() {
        return getBaseFont();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public Path getPath(String str) throws IOException {
        return (!str.equals(".notdef") || isEmbedded() || isStandard14()) ? "sfthyphen".equals(str) ? this.genericFont.getPath("hyphen") : "nbspace".equals(str) ? !hasGlyph("space") ? new Path() : this.genericFont.getPath("space") : this.genericFont.getPath(str) : new Path();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public float getStringWidth(String str) throws IOException {
        float width = 0.0f;
        if (this.cffFont == null) {
            Log.w("PdfBox-Android", "No embedded CFF font, returning 0");
            return 0.0f;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            width += this.cffFont.getType1CharString(getGlyphList().codePointToName(str.codePointAt(i2))).getWidth();
        }
        return width;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getWidthFromFont(int i2) throws IOException {
        float[] fArr = {this.genericFont.getWidth(getNameInFont(codeToName(i2))), 0.0f};
        this.fontMatrixTransform.transform(fArr, 0, fArr, 0, 1);
        return fArr[0];
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public boolean hasGlyph(String str) throws IOException {
        return this.genericFont.hasGlyph(str);
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
        FontBoxFont fontBoxFont = this.genericFont;
        return fontBoxFont instanceof EncodedFont ? Type1Encoding.fromFontBox(((EncodedFont) fontBoxFont).getEncoding()) : StandardEncoding.INSTANCE;
    }
}
