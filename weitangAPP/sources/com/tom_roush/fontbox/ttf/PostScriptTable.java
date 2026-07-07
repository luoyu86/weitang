package com.tom_roush.fontbox.ttf;

import android.util.Log;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PostScriptTable extends TTFTable {
    public static final String TAG = "post";
    private float formatType;
    private String[] glyphNames;
    private long isFixedPitch;
    private float italicAngle;
    private long maxMemType1;
    private long maxMemType42;
    private long mimMemType1;
    private long minMemType42;
    private short underlinePosition;
    private short underlineThickness;

    public PostScriptTable(TrueTypeFont trueTypeFont) {
        super(trueTypeFont);
        this.glyphNames = null;
    }

    public float getFormatType() {
        return this.formatType;
    }

    public String[] getGlyphNames() {
        return this.glyphNames;
    }

    public long getIsFixedPitch() {
        return this.isFixedPitch;
    }

    public float getItalicAngle() {
        return this.italicAngle;
    }

    public long getMaxMemType1() {
        return this.maxMemType1;
    }

    public long getMaxMemType42() {
        return this.maxMemType42;
    }

    public long getMinMemType1() {
        return this.mimMemType1;
    }

    public long getMinMemType42() {
        return this.minMemType42;
    }

    public String getName(int i2) {
        String[] strArr;
        if (i2 < 0 || (strArr = this.glyphNames) == null || i2 >= strArr.length) {
            return null;
        }
        return strArr[i2];
    }

    public short getUnderlinePosition() {
        return this.underlinePosition;
    }

    public short getUnderlineThickness() {
        return this.underlineThickness;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFTable
    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.formatType = tTFDataStream.read32Fixed();
        this.italicAngle = tTFDataStream.read32Fixed();
        this.underlinePosition = tTFDataStream.readSignedShort();
        this.underlineThickness = tTFDataStream.readSignedShort();
        this.isFixedPitch = tTFDataStream.readUnsignedInt();
        this.minMemType42 = tTFDataStream.readUnsignedInt();
        this.maxMemType42 = tTFDataStream.readUnsignedInt();
        this.mimMemType1 = tTFDataStream.readUnsignedInt();
        this.maxMemType1 = tTFDataStream.readUnsignedInt();
        float f2 = this.formatType;
        int i2 = 0;
        if (f2 == 1.0f) {
            String[] strArr = new String[WGL4Names.NUMBER_OF_MAC_GLYPHS];
            this.glyphNames = strArr;
            System.arraycopy(WGL4Names.MAC_GLYPH_NAMES, 0, strArr, 0, WGL4Names.NUMBER_OF_MAC_GLYPHS);
        } else if (f2 == 2.0f) {
            int unsignedShort = tTFDataStream.readUnsignedShort();
            int[] iArr = new int[unsignedShort];
            this.glyphNames = new String[unsignedShort];
            int iMax = Integer.MIN_VALUE;
            for (int i3 = 0; i3 < unsignedShort; i3++) {
                int unsignedShort2 = tTFDataStream.readUnsignedShort();
                iArr[i3] = unsignedShort2;
                if (unsignedShort2 <= 32767) {
                    iMax = Math.max(iMax, unsignedShort2);
                }
            }
            String[] strArr2 = null;
            if (iMax >= 258) {
                int i4 = (iMax - WGL4Names.NUMBER_OF_MAC_GLYPHS) + 1;
                strArr2 = new String[i4];
                int i5 = 0;
                while (i5 < i4) {
                    try {
                        strArr2[i5] = tTFDataStream.readString(tTFDataStream.readUnsignedByte());
                        i5++;
                    } catch (IOException e2) {
                        Log.w("PdfBox-Android", "Error reading names in PostScript table at entry " + i5 + " of " + i4 + ", setting remaining entries to .notdef", e2);
                        while (i5 < i4) {
                            strArr2[i5] = ".notdef";
                            i5++;
                        }
                    }
                }
            }
            while (i2 < unsignedShort) {
                int i6 = iArr[i2];
                if (i6 >= 0 && i6 < 258) {
                    this.glyphNames[i2] = WGL4Names.MAC_GLYPH_NAMES[i6];
                } else if (i6 < 258 || i6 > 32767) {
                    this.glyphNames[i2] = ".undefined";
                } else {
                    this.glyphNames[i2] = strArr2[i6 - 258];
                }
                i2++;
            }
        } else if (f2 == 2.5f) {
            int numberOfGlyphs = trueTypeFont.getNumberOfGlyphs();
            int[] iArr2 = new int[numberOfGlyphs];
            int i7 = 0;
            while (i7 < numberOfGlyphs) {
                int i8 = i7 + 1;
                iArr2[i7] = tTFDataStream.readSignedByte() + i8;
                i7 = i8;
            }
            this.glyphNames = new String[numberOfGlyphs];
            while (true) {
                String[] strArr3 = this.glyphNames;
                if (i2 >= strArr3.length) {
                    break;
                }
                int i9 = iArr2[i2];
                if (i9 < 0 || i9 >= 258) {
                    Log.d("PdfBox-Android", "incorrect glyph name index " + i9 + ", valid numbers 0.." + WGL4Names.NUMBER_OF_MAC_GLYPHS);
                } else {
                    String str = WGL4Names.MAC_GLYPH_NAMES[i9];
                    if (str != null) {
                        strArr3[i2] = str;
                    }
                }
                i2++;
            }
        } else if (f2 == 3.0f) {
            Log.d("PdfBox-Android", "No PostScript name information is provided for the font " + this.font.getName());
        }
        this.initialized = true;
    }

    public void setFormatType(float f2) {
        this.formatType = f2;
    }

    public void setGlyphNames(String[] strArr) {
        this.glyphNames = strArr;
    }

    public void setIsFixedPitch(long j) {
        this.isFixedPitch = j;
    }

    public void setItalicAngle(float f2) {
        this.italicAngle = f2;
    }

    public void setMaxMemType1(long j) {
        this.maxMemType1 = j;
    }

    public void setMaxMemType42(long j) {
        this.maxMemType42 = j;
    }

    public void setMimMemType1(long j) {
        this.mimMemType1 = j;
    }

    public void setMinMemType42(long j) {
        this.minMemType42 = j;
    }

    public void setUnderlinePosition(short s) {
        this.underlinePosition = s;
    }

    public void setUnderlineThickness(short s) {
        this.underlineThickness = s;
    }
}
