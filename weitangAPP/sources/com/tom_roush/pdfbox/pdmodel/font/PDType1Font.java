package com.tom_roush.pdfbox.pdmodel.font;

import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import com.tom_roush.fontbox.EncodedFont;
import com.tom_roush.fontbox.FontBoxFont;
import com.tom_roush.fontbox.type1.Type1Font;
import com.tom_roush.fontbox.util.BoundingBox;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.font.encoding.Encoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.StandardEncoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.SymbolEncoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.Type1Encoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.ZapfDingbatsEncoding;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class PDType1Font extends PDSimpleFont {
    private static final Map<String, String> ALT_NAMES;
    public static final PDType1Font COURIER;
    public static final PDType1Font COURIER_BOLD;
    public static final PDType1Font COURIER_BOLD_OBLIQUE;
    public static final PDType1Font COURIER_OBLIQUE;
    public static final PDType1Font HELVETICA;
    public static final PDType1Font HELVETICA_BOLD;
    public static final PDType1Font HELVETICA_BOLD_OBLIQUE;
    public static final PDType1Font HELVETICA_OBLIQUE;
    private static final int PFB_START_MARKER = 128;
    public static final PDType1Font SYMBOL;
    public static final PDType1Font TIMES_BOLD;
    public static final PDType1Font TIMES_BOLD_ITALIC;
    public static final PDType1Font TIMES_ITALIC;
    public static final PDType1Font TIMES_ROMAN;
    public static final PDType1Font ZAPF_DINGBATS;
    private final Map<Integer, byte[]> codeToBytesMap;
    private BoundingBox fontBBox;
    private Matrix fontMatrix;
    private final AffineTransform fontMatrixTransform;
    private final FontBoxFont genericFont;
    private final boolean isDamaged;
    private final boolean isEmbedded;
    private final Type1Font type1font;

    static {
        HashMap map = new HashMap();
        ALT_NAMES = map;
        map.put("ff", "f_f");
        map.put("ffi", "f_f_i");
        map.put("ffl", "f_f_l");
        map.put("fi", "f_i");
        map.put("fl", "f_l");
        map.put("st", "s_t");
        map.put("IJ", "I_J");
        map.put("ij", "i_j");
        map.put("ellipsis", "elipsis");
        TIMES_ROMAN = new PDType1Font("Times-Roman");
        TIMES_BOLD = new PDType1Font("Times-Bold");
        TIMES_ITALIC = new PDType1Font("Times-Italic");
        TIMES_BOLD_ITALIC = new PDType1Font("Times-BoldItalic");
        HELVETICA = new PDType1Font("Helvetica");
        HELVETICA_BOLD = new PDType1Font("Helvetica-Bold");
        HELVETICA_OBLIQUE = new PDType1Font("Helvetica-Oblique");
        HELVETICA_BOLD_OBLIQUE = new PDType1Font("Helvetica-BoldOblique");
        COURIER = new PDType1Font("Courier");
        COURIER_BOLD = new PDType1Font("Courier-Bold");
        COURIER_OBLIQUE = new PDType1Font("Courier-Oblique");
        COURIER_BOLD_OBLIQUE = new PDType1Font("Courier-BoldOblique");
        SYMBOL = new PDType1Font("Symbol");
        ZAPF_DINGBATS = new PDType1Font("ZapfDingbats");
    }

    private PDType1Font(String str) {
        String name;
        super(str);
        this.dict.setItem(COSName.SUBTYPE, (COSBase) COSName.TYPE1);
        this.dict.setName(COSName.BASE_FONT, str);
        if ("ZapfDingbats".equals(str)) {
            this.encoding = ZapfDingbatsEncoding.INSTANCE;
        } else if ("Symbol".equals(str)) {
            this.encoding = SymbolEncoding.INSTANCE;
        } else {
            this.encoding = WinAnsiEncoding.INSTANCE;
            this.dict.setItem(COSName.ENCODING, (COSBase) COSName.WIN_ANSI_ENCODING);
        }
        this.codeToBytesMap = new ConcurrentHashMap();
        this.type1font = null;
        FontMapping<FontBoxFont> fontBoxFont = FontMappers.instance().getFontBoxFont(getBaseFont(), getFontDescriptor());
        FontBoxFont font = fontBoxFont.getFont();
        this.genericFont = font;
        if (fontBoxFont.isFallback()) {
            try {
                name = font.getName();
            } catch (IOException unused) {
                name = "?";
            }
            Log.w("PdfBox-Android", "Using fallback font " + name + " for base font " + getBaseFont());
        }
        this.isEmbedded = false;
        this.isDamaged = false;
        this.fontMatrixTransform = new AffineTransform();
    }

    private static int findBinaryOffsetAfterExec(byte[] bArr, int i2) {
        while (true) {
            if (i2 <= 0) {
                break;
            }
            if (bArr[i2 + 0] == 101 && bArr[i2 + 1] == 120 && bArr[i2 + 2] == 101 && bArr[i2 + 3] == 99) {
                i2 += 4;
                while (i2 < bArr.length && (bArr[i2] == 13 || bArr[i2] == 10 || bArr[i2] == 32 || bArr[i2] == 9)) {
                    i2++;
                }
            } else {
                i2--;
            }
        }
        return i2;
    }

    private BoundingBox generateBoundingBox() throws IOException {
        PDRectangle fontBoundingBox;
        return (getFontDescriptor() == null || (fontBoundingBox = getFontDescriptor().getFontBoundingBox()) == null || (fontBoundingBox.getLowerLeftX() == 0.0f && fontBoundingBox.getLowerLeftY() == 0.0f && fontBoundingBox.getUpperRightX() == 0.0f && fontBoundingBox.getUpperRightY() == 0.0f)) ? this.genericFont.getFontBBox() : new BoundingBox(fontBoundingBox.getLowerLeftX(), fontBoundingBox.getLowerLeftY(), fontBoundingBox.getUpperRightX(), fontBoundingBox.getUpperRightY());
    }

    private String getNameInFont(String str) throws IOException {
        Integer num;
        if (isEmbedded() || this.genericFont.hasGlyph(str)) {
            return str;
        }
        String str2 = ALT_NAMES.get(str);
        if (str2 != null && !str.equals(".notdef") && this.genericFont.hasGlyph(str2)) {
            return str2;
        }
        String unicode = getGlyphList().toUnicode(str);
        if (unicode != null && unicode.length() == 1) {
            String uniNameOfCodePoint = UniUtil.getUniNameOfCodePoint(unicode.codePointAt(0));
            if (this.genericFont.hasGlyph(uniNameOfCodePoint)) {
                return uniNameOfCodePoint;
            }
            if ("SymbolMT".equals(this.genericFont.getName()) && (num = SymbolEncoding.INSTANCE.getNameToCodeMap().get(str)) != null) {
                String uniNameOfCodePoint2 = UniUtil.getUniNameOfCodePoint(num.intValue() + 61440);
                if (this.genericFont.hasGlyph(uniNameOfCodePoint2)) {
                    return uniNameOfCodePoint2;
                }
            }
        }
        return ".notdef";
    }

    private int repairLength1(byte[] bArr, int i2) {
        int iMax = Math.max(0, i2 - 4);
        if (iMax <= 0 || iMax > bArr.length - 4) {
            iMax = bArr.length - 4;
        }
        int iFindBinaryOffsetAfterExec = findBinaryOffsetAfterExec(bArr, iMax);
        if (iFindBinaryOffsetAfterExec == 0 && i2 > 0) {
            iFindBinaryOffsetAfterExec = findBinaryOffsetAfterExec(bArr, bArr.length - 4);
        }
        if (i2 - iFindBinaryOffsetAfterExec == 0 || iFindBinaryOffsetAfterExec <= 0) {
            return i2;
        }
        Log.w("PdfBox-Android", "Ignored invalid Length1 " + i2 + " for Type 1 font " + getName());
        return iFindBinaryOffsetAfterExec;
    }

    private int repairLength2(byte[] bArr, int i2, int i3) {
        if (i3 >= 0 && i3 <= bArr.length - i2) {
            return i3;
        }
        Log.w("PdfBox-Android", "Ignored invalid Length2 " + i3 + " for Type 1 font " + getName());
        return bArr.length - i2;
    }

    public String codeToName(int i2) throws IOException {
        return getNameInFont(getEncoding().getName(i2));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public byte[] encode(int i2) throws IOException {
        byte[] bArr = this.codeToBytesMap.get(Integer.valueOf(i2));
        if (bArr != null) {
            return bArr;
        }
        String strCodePointToName = getGlyphList().codePointToName(i2);
        if (isStandard14()) {
            if (!this.encoding.contains(strCodePointToName)) {
                throw new IllegalArgumentException(String.format("U+%04X ('%s') is not available in the font %s, encoding: %s", Integer.valueOf(i2), strCodePointToName, getName(), this.encoding.getEncodingName()));
            }
            if (".notdef".equals(strCodePointToName)) {
                throw new IllegalArgumentException(String.format("No glyph for U+%04X in the font %s", Integer.valueOf(i2), getName()));
            }
        } else {
            if (!this.encoding.contains(strCodePointToName)) {
                throw new IllegalArgumentException(String.format("U+%04X ('%s') is not available in the font %s (generic: %s), encoding: %s", Integer.valueOf(i2), strCodePointToName, getName(), this.genericFont.getName(), this.encoding.getEncodingName()));
            }
            String nameInFont = getNameInFont(strCodePointToName);
            if (nameInFont.equals(".notdef") || !this.genericFont.hasGlyph(nameInFont)) {
                throw new IllegalArgumentException(String.format("No glyph for U+%04X in the font %s (generic: %s)", Integer.valueOf(i2), getName(), this.genericFont.getName()));
            }
        }
        int iIntValue = this.encoding.getNameToCodeMap().get(strCodePointToName).intValue();
        if (iIntValue < 0) {
            throw new IllegalArgumentException(String.format("U+%04X ('%s') is not available in the font %s (generic: %s), encoding: %s", Integer.valueOf(i2), strCodePointToName, getName(), this.genericFont.getName(), this.encoding.getEncodingName()));
        }
        byte[] bArr2 = {(byte) iIntValue};
        this.codeToBytesMap.put(Integer.valueOf(i2), bArr2);
        return bArr2;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont, com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getAverageFontWidth() {
        return getStandard14AFM() != null ? getStandard14AFM().getAverageCharacterWidth() : super.getAverageFontWidth();
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
        if (getStandard14AFM() != null) {
            return getStandard14AFM().getCharacterHeight(getEncoding().getName(i2));
        }
        String strCodeToName = codeToName(i2);
        RectF rectF = new RectF();
        this.genericFont.getPath(strCodeToName).computeBounds(rectF, true);
        return rectF.height();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public String getName() {
        return getBaseFont();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public Path getPath(String str) throws IOException {
        return (!str.equals(".notdef") || this.isEmbedded) ? this.genericFont.getPath(getNameInFont(str)) : new Path();
    }

    public Type1Font getType1Font() {
        return this.type1font;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getWidthFromFont(int i2) throws IOException {
        String strCodeToName = codeToName(i2);
        if (!this.isEmbedded && ".notdef".equals(strCodeToName)) {
            return 250.0f;
        }
        float[] fArr = {this.genericFont.getWidth(strCodeToName), 0.0f};
        this.fontMatrixTransform.transform(fArr, 0, fArr, 0, 1);
        return fArr[0];
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public boolean hasGlyph(String str) throws IOException {
        return this.genericFont.hasGlyph(getNameInFont(str));
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

    public PDType1Font(PDDocument pDDocument, InputStream inputStream) throws IOException {
        this(pDDocument, inputStream, null);
    }

    public PDType1Font(PDDocument pDDocument, InputStream inputStream, Encoding encoding) throws IOException {
        PDType1FontEmbedder pDType1FontEmbedder = new PDType1FontEmbedder(pDDocument, this.dict, inputStream, encoding);
        this.encoding = encoding == null ? pDType1FontEmbedder.getFontEncoding() : encoding;
        this.glyphList = pDType1FontEmbedder.getGlyphList();
        this.type1font = pDType1FontEmbedder.getType1Font();
        this.genericFont = pDType1FontEmbedder.getType1Font();
        this.isEmbedded = true;
        this.isDamaged = false;
        this.fontMatrixTransform = new AffineTransform();
        this.codeToBytesMap = new HashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d1 A[PHI: r3
  0x00d1: PHI (r3v1 com.tom_roush.fontbox.type1.Type1Font) = 
  (r3v0 com.tom_roush.fontbox.type1.Type1Font)
  (r3v0 com.tom_roush.fontbox.type1.Type1Font)
  (r3v0 com.tom_roush.fontbox.type1.Type1Font)
  (r3v0 com.tom_roush.fontbox.type1.Type1Font)
  (r3v3 com.tom_roush.fontbox.type1.Type1Font)
  (r3v4 com.tom_roush.fontbox.type1.Type1Font)
 binds: [B:3:0x0013, B:7:0x001f, B:17:0x005c, B:18:0x005e, B:19:0x0060, B:12:0x0048] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PDType1Font(com.tom_roush.pdfbox.cos.COSDictionary r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.font.PDType1Font.<init>(com.tom_roush.pdfbox.cos.COSDictionary):void");
    }
}
