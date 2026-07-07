package com.tom_roush.pdfbox.pdmodel.font;

import android.graphics.Path;
import android.util.Log;
import com.tom_roush.fontbox.FontBoxFont;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.font.encoding.DictionaryEncoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.Encoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.GlyphList;
import com.tom_roush.pdfbox.pdmodel.font.encoding.MacRomanEncoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.StandardEncoding;
import com.tom_roush.pdfbox.pdmodel.font.encoding.WinAnsiEncoding;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDSimpleFont extends PDFont {
    public Encoding encoding;
    public GlyphList glyphList;
    private Boolean isSymbolic;
    private final Set<Integer> noUnicode;

    public PDSimpleFont() {
        this.noUnicode = new HashSet();
    }

    private void assignGlyphList(String str) {
        if ("ZapfDingbats".equals(str)) {
            this.glyphList = GlyphList.getZapfDingbats();
        } else {
            this.glyphList = GlyphList.getAdobeGlyphList();
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public void addToSubset(int i2) {
        throw new UnsupportedOperationException();
    }

    public Encoding getEncoding() {
        return this.encoding;
    }

    public abstract FontBoxFont getFontBoxFont();

    public GlyphList getGlyphList() {
        return this.glyphList;
    }

    public abstract Path getPath(String str) throws IOException;

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public final float getStandard14Width(int i2) {
        if (getStandard14AFM() == null) {
            throw new IllegalStateException("No AFM");
        }
        String name = getEncoding().getName(i2);
        if (".notdef".equals(name)) {
            return 250.0f;
        }
        if ("nbspace".equals(name)) {
            name = "space";
        } else if ("sfthyphen".equals(name)) {
            name = "hyphen";
        }
        return getStandard14AFM().getCharacterWidth(name);
    }

    public final Boolean getSymbolicFlag() {
        if (getFontDescriptor() != null) {
            return Boolean.valueOf(getFontDescriptor().isSymbolic());
        }
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFontLike
    public boolean hasExplicitWidth(int i2) throws IOException {
        int i3;
        return this.dict.containsKey(COSName.WIDTHS) && i2 >= (i3 = this.dict.getInt(COSName.FIRST_CHAR, -1)) && i2 - i3 < getWidths().size();
    }

    public abstract boolean hasGlyph(String str) throws IOException;

    public Boolean isFontSymbolic() {
        Boolean symbolicFlag = getSymbolicFlag();
        if (symbolicFlag != null) {
            return symbolicFlag;
        }
        if (isStandard14()) {
            String mappedFontName = Standard14Fonts.getMappedFontName(getName());
            return Boolean.valueOf(mappedFontName.equals("Symbol") || mappedFontName.equals("ZapfDingbats"));
        }
        Encoding encoding = this.encoding;
        if (encoding == null) {
            if (this instanceof PDTrueTypeFont) {
                return Boolean.TRUE;
            }
            throw new IllegalStateException("PDFBox bug: encoding should not be null!");
        }
        if ((encoding instanceof WinAnsiEncoding) || (encoding instanceof MacRomanEncoding) || (encoding instanceof StandardEncoding)) {
            return Boolean.FALSE;
        }
        if (!(encoding instanceof DictionaryEncoding)) {
            return null;
        }
        for (String str : ((DictionaryEncoding) encoding).getDifferences().values()) {
            if (!".notdef".equals(str) && (!WinAnsiEncoding.INSTANCE.contains(str) || !MacRomanEncoding.INSTANCE.contains(str) || !StandardEncoding.INSTANCE.contains(str))) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public boolean isStandard14() {
        if (getEncoding() instanceof DictionaryEncoding) {
            DictionaryEncoding dictionaryEncoding = (DictionaryEncoding) getEncoding();
            if (dictionaryEncoding.getDifferences().size() > 0) {
                Encoding baseEncoding = dictionaryEncoding.getBaseEncoding();
                for (Map.Entry<Integer, String> entry : dictionaryEncoding.getDifferences().entrySet()) {
                    if (!entry.getValue().equals(baseEncoding.getName(entry.getKey().intValue()))) {
                        return false;
                    }
                }
            }
        }
        return super.isStandard14();
    }

    public final boolean isSymbolic() {
        if (this.isSymbolic == null) {
            Boolean boolIsFontSymbolic = isFontSymbolic();
            if (boolIsFontSymbolic != null) {
                this.isSymbolic = boolIsFontSymbolic;
            } else {
                this.isSymbolic = Boolean.TRUE;
            }
        }
        return this.isSymbolic.booleanValue();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public boolean isVertical() {
        return false;
    }

    public void readEncoding() throws IOException {
        COSBase dictionaryObject = this.dict.getDictionaryObject(COSName.ENCODING);
        if (dictionaryObject instanceof COSName) {
            COSName cOSName = (COSName) dictionaryObject;
            Encoding encoding = Encoding.getInstance(cOSName);
            this.encoding = encoding;
            if (encoding == null) {
                Log.w("PdfBox-Android", "Unknown encoding: " + cOSName.getName());
                this.encoding = readEncodingFromFont();
            }
        } else if (dictionaryObject instanceof COSDictionary) {
            COSDictionary cOSDictionary = (COSDictionary) dictionaryObject;
            Encoding encodingFromFont = null;
            Boolean symbolicFlag = getSymbolicFlag();
            COSName cOSName2 = cOSDictionary.getCOSName(COSName.BASE_ENCODING);
            if (!((cOSName2 == null || Encoding.getInstance(cOSName2) == null) ? false : true) && Boolean.TRUE.equals(symbolicFlag)) {
                encodingFromFont = readEncodingFromFont();
            }
            if (symbolicFlag == null) {
                symbolicFlag = Boolean.FALSE;
            }
            this.encoding = new DictionaryEncoding(cOSDictionary, !symbolicFlag.booleanValue(), encodingFromFont);
        } else if (dictionaryObject == null) {
            this.encoding = readEncodingFromFont();
        }
        assignGlyphList(Standard14Fonts.getMappedFontName(getName()));
    }

    public abstract Encoding readEncodingFromFont() throws IOException;

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public void subset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public String toUnicode(int i2) throws IOException {
        return toUnicode(i2, GlyphList.getAdobeGlyphList());
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public boolean willBeSubset() {
        return false;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.PDFont
    public String toUnicode(int i2, GlyphList glyphList) throws IOException {
        String name;
        if (this.glyphList != GlyphList.getAdobeGlyphList()) {
            glyphList = this.glyphList;
        }
        String unicode = super.toUnicode(i2);
        if (unicode != null) {
            return unicode;
        }
        Encoding encoding = this.encoding;
        if (encoding != null) {
            name = encoding.getName(i2);
            String unicode2 = glyphList.toUnicode(name);
            if (unicode2 != null) {
                return unicode2;
            }
        } else {
            name = null;
        }
        if (!this.noUnicode.contains(Integer.valueOf(i2))) {
            this.noUnicode.add(Integer.valueOf(i2));
            if (name != null) {
                Log.w("PdfBox-Android", "No Unicode mapping for " + name + " (" + i2 + ") in font " + getName());
            } else {
                Log.w("PdfBox-Android", "No Unicode mapping for character code " + i2 + " in font " + getName());
            }
        }
        return null;
    }

    public PDSimpleFont(String str) {
        super(str);
        this.noUnicode = new HashSet();
        assignGlyphList(str);
    }

    public PDSimpleFont(COSDictionary cOSDictionary) throws IOException {
        super(cOSDictionary);
        this.noUnicode = new HashSet();
    }
}
