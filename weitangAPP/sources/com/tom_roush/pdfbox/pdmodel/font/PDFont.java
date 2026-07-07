package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.tom_roush.fontbox.afm.FontMetrics;
import com.tom_roush.fontbox.cmap.CMap;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInputStream;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.common.COSArrayList;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import com.tom_roush.pdfbox.pdmodel.font.encoding.GlyphList;
import com.tom_roush.pdfbox.util.Matrix;
import com.tom_roush.pdfbox.util.Vector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDFont implements COSObjectable, PDFontLike {
    public static final Matrix DEFAULT_FONT_MATRIX = new Matrix(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
    private final FontMetrics afmStandard14;
    private float avgFontWidth;
    private final Map<Integer, Float> codeToWidthMap;
    public final COSDictionary dict;
    private PDFontDescriptor fontDescriptor;
    private float fontWidthOfSpace;
    private final CMap toUnicodeCMap;
    private List<Float> widths;

    public PDFont() {
        this.fontWidthOfSpace = -1.0f;
        COSDictionary cOSDictionary = new COSDictionary();
        this.dict = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.FONT);
        this.toUnicodeCMap = null;
        this.fontDescriptor = null;
        this.afmStandard14 = null;
        this.codeToWidthMap = new HashMap();
    }

    private PDFontDescriptor loadFontDescriptor() {
        COSDictionary cOSDictionary = this.dict.getCOSDictionary(COSName.FONT_DESC);
        if (cOSDictionary != null) {
            return new PDFontDescriptor(cOSDictionary);
        }
        FontMetrics fontMetrics = this.afmStandard14;
        if (fontMetrics != null) {
            return PDType1FontEmbedder.buildFontDescriptor(fontMetrics);
        }
        return null;
    }

    private CMap loadUnicodeCmap() {
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.TO_UNICODE);
        CMap predefinedCMap = null;
        if (dictionaryObject == null) {
            return null;
        }
        try {
            CMap cMap = readCMap(dictionaryObject);
            if (cMap == null || cMap.hasUnicodeMappings()) {
                return cMap;
            }
            Log.w("PdfBox-Android", "Invalid ToUnicode CMap in font " + getName());
            String name = cMap.getName() != null ? cMap.getName() : "";
            String ordering = cMap.getOrdering() != null ? cMap.getOrdering() : "";
            COSBase dictionaryObject2 = this.dict.getDictionaryObject(COSName.ENCODING);
            if (!name.contains("Identity") && !ordering.contains("Identity") && !COSName.IDENTITY_H.equals(dictionaryObject2) && !COSName.IDENTITY_V.equals(dictionaryObject2)) {
                return cMap;
            }
            predefinedCMap = CMapManager.getPredefinedCMap(COSName.IDENTITY_H.getName());
            Log.w("PdfBox-Android", "Using predefined identity CMap instead");
            return predefinedCMap;
        } catch (IOException e2) {
            Log.e("PdfBox-Android", "Could not read ToUnicode CMap in font " + getName(), e2);
            return predefinedCMap;
        }
    }

    public abstract void addToSubset(int i2);

    public abstract byte[] encode(int i2) throws IOException;

    public final byte[] encode(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            byteArrayOutputStream.write(encode(iCodePointAt));
            iCharCount += Character.charCount(iCodePointAt);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public boolean equals(Object obj) {
        return (obj instanceof PDFont) && ((PDFont) obj).getCOSObject() == getCOSObject();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getAverageFontWidth() {
        float fFloatValue;
        float f2;
        float f3 = this.avgFontWidth;
        if (f3 == 0.0f) {
            COSArray cOSArray = this.dict.getCOSArray(COSName.WIDTHS);
            if (cOSArray != null) {
                fFloatValue = 0.0f;
                f2 = 0.0f;
                for (int i2 = 0; i2 < cOSArray.size(); i2++) {
                    COSNumber cOSNumber = (COSNumber) cOSArray.getObject(i2);
                    if (cOSNumber.floatValue() > 0.0f) {
                        fFloatValue += cOSNumber.floatValue();
                        f2 += 1.0f;
                    }
                }
            } else {
                fFloatValue = 0.0f;
                f2 = 0.0f;
            }
            f3 = fFloatValue > 0.0f ? fFloatValue / f2 : 0.0f;
            this.avgFontWidth = f3;
        }
        return f3;
    }

    public Vector getDisplacement(int i2) throws IOException {
        return new Vector(getWidth(i2) / 1000.0f, 0.0f);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public PDFontDescriptor getFontDescriptor() {
        return this.fontDescriptor;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public Matrix getFontMatrix() {
        return DEFAULT_FONT_MATRIX;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public Vector getPositionVector(int i2) {
        throw new UnsupportedOperationException("Horizontal fonts have no position vector");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[Catch: Exception -> 0x0046, TryCatch #0 {Exception -> 0x0046, blocks: (B:6:0x0014, B:8:0x0018, B:10:0x001f, B:12:0x002c, B:14:0x0033, B:15:0x0039, B:17:0x003f, B:11:0x0026), top: B:23:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public float getSpaceWidth() {
        /*
            r3 = this;
            float r0 = r3.fontWidthOfSpace
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L52
            com.tom_roush.pdfbox.cos.COSDictionary r0 = r3.dict
            com.tom_roush.pdfbox.cos.COSName r1 = com.tom_roush.pdfbox.cos.COSName.TO_UNICODE
            com.tom_roush.pdfbox.cos.COSBase r0 = r0.getDictionaryObject(r1)
            r1 = 32
            if (r0 == 0) goto L26
            com.tom_roush.fontbox.cmap.CMap r0 = r3.toUnicodeCMap     // Catch: java.lang.Exception -> L46
            if (r0 == 0) goto L26
            int r0 = r0.getSpaceMapping()     // Catch: java.lang.Exception -> L46
            r2 = -1
            if (r0 <= r2) goto L2c
            float r0 = r3.getWidth(r0)     // Catch: java.lang.Exception -> L46
            r3.fontWidthOfSpace = r0     // Catch: java.lang.Exception -> L46
            goto L2c
        L26:
            float r0 = r3.getWidth(r1)     // Catch: java.lang.Exception -> L46
            r3.fontWidthOfSpace = r0     // Catch: java.lang.Exception -> L46
        L2c:
            float r0 = r3.fontWidthOfSpace     // Catch: java.lang.Exception -> L46
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L39
            float r0 = r3.getWidthFromFont(r1)     // Catch: java.lang.Exception -> L46
            r3.fontWidthOfSpace = r0     // Catch: java.lang.Exception -> L46
        L39:
            float r0 = r3.fontWidthOfSpace     // Catch: java.lang.Exception -> L46
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L52
            float r0 = r3.getAverageFontWidth()     // Catch: java.lang.Exception -> L46
            r3.fontWidthOfSpace = r0     // Catch: java.lang.Exception -> L46
            goto L52
        L46:
            r0 = move-exception
            java.lang.String r1 = "PdfBox-Android"
            java.lang.String r2 = "Can't determine the width of the space character, assuming 250"
            android.util.Log.e(r1, r2, r0)
            r0 = 1132068864(0x437a0000, float:250.0)
            r3.fontWidthOfSpace = r0
        L52:
            float r0 = r3.fontWidthOfSpace
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.font.PDFont.getSpaceWidth():float");
    }

    public final FontMetrics getStandard14AFM() {
        return this.afmStandard14;
    }

    public abstract float getStandard14Width(int i2);

    public float getStringWidth(String str) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(encode(str));
        float width = 0.0f;
        while (byteArrayInputStream.available() > 0) {
            width += getWidth(readCode(byteArrayInputStream));
        }
        return width;
    }

    public String getSubType() {
        return this.dict.getNameAsString(COSName.SUBTYPE);
    }

    public CMap getToUnicodeCMap() {
        return this.toUnicodeCMap;
    }

    public String getType() {
        return this.dict.getNameAsString(COSName.TYPE);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getWidth(int i2) throws IOException {
        Float f2 = this.codeToWidthMap.get(Integer.valueOf(i2));
        if (f2 != null) {
            return f2.floatValue();
        }
        if (this.dict.getDictionaryObject(COSName.WIDTHS) != null || this.dict.containsKey(COSName.MISSING_WIDTH)) {
            int i3 = this.dict.getInt(COSName.FIRST_CHAR, -1);
            int i4 = this.dict.getInt(COSName.LAST_CHAR, -1);
            int size = getWidths().size();
            int i5 = i2 - i3;
            if (size > 0 && i2 >= i3 && i2 <= i4 && i5 < size) {
                Float fValueOf = getWidths().get(i5);
                if (fValueOf == null) {
                    fValueOf = Float.valueOf(0.0f);
                }
                this.codeToWidthMap.put(Integer.valueOf(i2), fValueOf);
                return fValueOf.floatValue();
            }
            PDFontDescriptor fontDescriptor = getFontDescriptor();
            if (fontDescriptor != null) {
                Float fValueOf2 = Float.valueOf(fontDescriptor.getMissingWidth());
                this.codeToWidthMap.put(Integer.valueOf(i2), fValueOf2);
                return fValueOf2.floatValue();
            }
        }
        if (isStandard14()) {
            Float fValueOf3 = Float.valueOf(getStandard14Width(i2));
            this.codeToWidthMap.put(Integer.valueOf(i2), fValueOf3);
            return fValueOf3.floatValue();
        }
        Float fValueOf4 = Float.valueOf(getWidthFromFont(i2));
        this.codeToWidthMap.put(Integer.valueOf(i2), fValueOf4);
        return fValueOf4.floatValue();
    }

    public final List<Float> getWidths() {
        if (this.widths == null) {
            COSArray cOSArray = this.dict.getCOSArray(COSName.WIDTHS);
            if (cOSArray != null) {
                this.widths = COSArrayList.convertFloatCOSArrayToList(cOSArray);
            } else {
                this.widths = Collections.emptyList();
            }
        }
        return this.widths;
    }

    public int hashCode() {
        return getCOSObject().hashCode();
    }

    public boolean isStandard14() {
        if (isEmbedded()) {
            return false;
        }
        return Standard14Fonts.containsName(getName());
    }

    public abstract boolean isVertical();

    public final CMap readCMap(COSBase cOSBase) throws IOException {
        if (cOSBase instanceof COSName) {
            return CMapManager.getPredefinedCMap(((COSName) cOSBase).getName());
        }
        if (!(cOSBase instanceof COSStream)) {
            throw new IOException("Expected Name or Stream");
        }
        COSInputStream cOSInputStreamCreateInputStream = null;
        try {
            cOSInputStreamCreateInputStream = ((COSStream) cOSBase).createInputStream();
            return CMapManager.parseCMap(cOSInputStreamCreateInputStream);
        } finally {
            IOUtils.closeQuietly(cOSInputStreamCreateInputStream);
        }
    }

    public abstract int readCode(InputStream inputStream) throws IOException;

    public final void setFontDescriptor(PDFontDescriptor pDFontDescriptor) {
        this.fontDescriptor = pDFontDescriptor;
    }

    public abstract void subset() throws IOException;

    public String toString() {
        return getClass().getSimpleName() + " " + getName();
    }

    public String toUnicode(int i2, GlyphList glyphList) throws IOException {
        return toUnicode(i2);
    }

    public abstract boolean willBeSubset();

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.dict;
    }

    public String toUnicode(int i2) throws IOException {
        CMap cMap = this.toUnicodeCMap;
        if (cMap != null) {
            return (cMap.getName() == null || !this.toUnicodeCMap.getName().startsWith("Identity-") || (!(this.dict.getDictionaryObject(COSName.TO_UNICODE) instanceof COSName) && this.toUnicodeCMap.hasUnicodeMappings())) ? this.toUnicodeCMap.toUnicode(i2) : new String(new char[]{(char) i2});
        }
        return null;
    }

    public PDFont(String str) {
        this.fontWidthOfSpace = -1.0f;
        COSDictionary cOSDictionary = new COSDictionary();
        this.dict = cOSDictionary;
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.FONT);
        this.toUnicodeCMap = null;
        FontMetrics afm = Standard14Fonts.getAFM(str);
        this.afmStandard14 = afm;
        if (afm != null) {
            this.fontDescriptor = PDType1FontEmbedder.buildFontDescriptor(afm);
            this.codeToWidthMap = new ConcurrentHashMap();
        } else {
            throw new IllegalArgumentException("No AFM for font " + str);
        }
    }

    public PDFont(COSDictionary cOSDictionary) throws IOException {
        this.fontWidthOfSpace = -1.0f;
        this.dict = cOSDictionary;
        this.codeToWidthMap = new HashMap();
        this.afmStandard14 = Standard14Fonts.getAFM(getName());
        this.fontDescriptor = loadFontDescriptor();
        this.toUnicodeCMap = loadUnicodeCmap();
    }
}
