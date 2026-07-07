package com.tom_roush.pdfbox.pdmodel.font;

import android.graphics.Path;
import android.util.Log;
import com.tom_roush.fontbox.FontBoxFont;
import com.tom_roush.fontbox.util.BoundingBox;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.pdmodel.PDResources;
import com.tom_roush.pdfbox.pdmodel.ResourceCache;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.font.encoding.DictionaryEncoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.Encoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.GlyphList;
import com.tom_roush.pdfbox.util.Matrix;
import com.tom_roush.pdfbox.util.Vector;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PDType3Font extends PDSimpleFont {
    private COSDictionary charProcs;
    private BoundingBox fontBBox;
    private Matrix fontMatrix;
    private final ResourceCache resourceCache;
    private PDResources resources;

    public PDType3Font(COSDictionary cOSDictionary) throws IOException {
        this(cOSDictionary, null);
    }

    private BoundingBox generateBoundingBox() {
        PDRectangle fontBBox = getFontBBox();
        if (fontBBox.getLowerLeftX() == 0.0f && fontBBox.getLowerLeftY() == 0.0f && fontBBox.getUpperRightX() == 0.0f && fontBBox.getUpperRightY() == 0.0f) {
            COSDictionary charProcs = getCharProcs();
            Iterator<COSName> it = charProcs.keySet().iterator();
            while (it.hasNext()) {
                COSBase dictionaryObject = charProcs.getDictionaryObject(it.next());
                if (dictionaryObject instanceof COSStream) {
                    try {
                        PDRectangle glyphBBox = new PDType3CharProc(this, (COSStream) dictionaryObject).getGlyphBBox();
                        if (glyphBBox != null) {
                            fontBBox.setLowerLeftX(Math.min(fontBBox.getLowerLeftX(), glyphBBox.getLowerLeftX()));
                            fontBBox.setLowerLeftY(Math.min(fontBBox.getLowerLeftY(), glyphBBox.getLowerLeftY()));
                            fontBBox.setUpperRightX(Math.max(fontBBox.getUpperRightX(), glyphBBox.getUpperRightX()));
                            fontBBox.setUpperRightY(Math.max(fontBBox.getUpperRightY(), glyphBBox.getUpperRightY()));
                        }
                    } catch (IOException unused) {
                    }
                }
            }
        }
        return new BoundingBox(fontBBox.getLowerLeftX(), fontBBox.getLowerLeftY(), fontBBox.getUpperRightX(), fontBBox.getUpperRightY());
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public byte[] encode(int i2) throws IOException {
        throw new UnsupportedOperationException("Not implemented: Type3");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public BoundingBox getBoundingBox() {
        if (this.fontBBox == null) {
            this.fontBBox = generateBoundingBox();
        }
        return this.fontBBox;
    }

    public PDType3CharProc getCharProc(int i2) {
        COSStream cOSStream;
        String name = getEncoding().getName(i2);
        if (getCharProcs() == null || (cOSStream = getCharProcs().getCOSStream(COSName.getPDFName(name))) == null) {
            return null;
        }
        return new PDType3CharProc(this, cOSStream);
    }

    public COSDictionary getCharProcs() {
        if (this.charProcs == null) {
            this.charProcs = this.dict.getCOSDictionary(COSName.CHAR_PROCS);
        }
        return this.charProcs;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public Vector getDisplacement(int i2) throws IOException {
        return getFontMatrix().transform(new Vector(getWidth(i2), 0.0f));
    }

    public PDRectangle getFontBBox() {
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.FONT_BBOX);
        if (dictionaryObject instanceof COSArray) {
            return new PDRectangle((COSArray) dictionaryObject);
        }
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public FontBoxFont getFontBoxFont() {
        throw new UnsupportedOperationException("not supported for Type 3 fonts");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont, com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public Matrix getFontMatrix() {
        if (this.fontMatrix == null) {
            COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.FONT_MATRIX);
            if (!(dictionaryObject instanceof COSArray)) {
                return super.getFontMatrix();
            }
            this.fontMatrix = new Matrix((COSArray) dictionaryObject);
        }
        return this.fontMatrix;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getHeight(int i2) throws IOException {
        PDFontDescriptor fontDescriptor = getFontDescriptor();
        if (fontDescriptor == null) {
            return 0.0f;
        }
        PDRectangle fontBoundingBox = fontDescriptor.getFontBoundingBox();
        float height = fontBoundingBox != null ? fontBoundingBox.getHeight() / 2.0f : 0.0f;
        if (height == 0.0f) {
            height = fontDescriptor.getCapHeight();
        }
        if (height == 0.0f) {
            height = fontDescriptor.getAscent();
        }
        if (height != 0.0f) {
            return height;
        }
        float xHeight = fontDescriptor.getXHeight();
        return xHeight > 0.0f ? xHeight - fontDescriptor.getDescent() : xHeight;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public String getName() {
        return this.dict.getNameAsString(COSName.NAME);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public Path getPath(String str) throws IOException {
        throw new UnsupportedOperationException("not supported for Type 3 fonts");
    }

    public PDResources getResources() {
        if (this.resources == null) {
            COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.RESOURCES);
            if (dictionaryObject instanceof COSDictionary) {
                this.resources = new PDResources((COSDictionary) dictionaryObject, this.resourceCache);
            }
        }
        return this.resources;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont, com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getWidth(int i2) throws IOException {
        Float f2;
        int i3 = this.dict.getInt(COSName.FIRST_CHAR, -1);
        int i4 = this.dict.getInt(COSName.LAST_CHAR, -1);
        List<Float> widths = getWidths();
        if (widths.isEmpty() || i2 < i3 || i2 > i4) {
            PDFontDescriptor fontDescriptor = getFontDescriptor();
            return fontDescriptor != null ? fontDescriptor.getMissingWidth() : getWidthFromFont(i2);
        }
        int i5 = i2 - i3;
        if (i5 < widths.size() && (f2 = widths.get(i5)) != null) {
            return f2.floatValue();
        }
        return 0.0f;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public float getWidthFromFont(int i2) throws IOException {
        PDType3CharProc charProc = getCharProc(i2);
        if (charProc == null || charProc.getContentStream().getLength() == 0) {
            return 0.0f;
        }
        return charProc.getWidth();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public boolean hasGlyph(String str) throws IOException {
        return getCharProcs().getDictionaryObject(COSName.getPDFName(str)) instanceof COSStream;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public boolean isDamaged() {
        return false;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public boolean isEmbedded() {
        return true;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public Boolean isFontSymbolic() {
        return Boolean.FALSE;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont, com.tom_roush.pdfbox.pdmodel.font.PDFont
    public boolean isStandard14() {
        return false;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public int readCode(InputStream inputStream) throws IOException {
        return inputStream.read();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public final void readEncoding() throws IOException {
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.ENCODING);
        if (dictionaryObject instanceof COSName) {
            COSName cOSName = (COSName) dictionaryObject;
            Encoding encoding = Encoding.getInstance(cOSName);
            this.encoding = encoding;
            if (encoding == null) {
                Log.w("PdfBox-Android", "Unknown encoding: " + cOSName.getName());
            }
        } else if (dictionaryObject instanceof COSDictionary) {
            this.encoding = new DictionaryEncoding((COSDictionary) dictionaryObject);
        }
        this.glyphList = GlyphList.getAdobeGlyphList();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont
    public Encoding readEncodingFromFont() throws IOException {
        throw new UnsupportedOperationException("not supported for Type 3 fonts");
    }

    public PDType3Font(COSDictionary cOSDictionary, ResourceCache resourceCache) throws IOException {
        super(cOSDictionary);
        this.resourceCache = resourceCache;
        readEncoding();
    }
}
