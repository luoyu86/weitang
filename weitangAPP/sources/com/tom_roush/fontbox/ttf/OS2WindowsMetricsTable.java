package com.tom_roush.fontbox.ttf;

import android.util.Log;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class OS2WindowsMetricsTable extends TTFTable {
    public static final int FAMILY_CLASS_CLAREDON_SERIFS = 4;
    public static final int FAMILY_CLASS_FREEFORM_SERIFS = 7;
    public static final int FAMILY_CLASS_MODERN_SERIFS = 3;
    public static final int FAMILY_CLASS_NO_CLASSIFICATION = 0;
    public static final int FAMILY_CLASS_OLDSTYLE_SERIFS = 1;
    public static final int FAMILY_CLASS_ORNAMENTALS = 9;
    public static final int FAMILY_CLASS_SANS_SERIF = 8;
    public static final int FAMILY_CLASS_SCRIPTS = 10;
    public static final int FAMILY_CLASS_SLAB_SERIFS = 5;
    public static final int FAMILY_CLASS_SYMBOLIC = 12;
    public static final int FAMILY_CLASS_TRANSITIONAL_SERIFS = 2;
    public static final short FSTYPE_BITMAP_ONLY = 512;
    public static final short FSTYPE_EDITIBLE = 8;
    public static final short FSTYPE_NO_SUBSETTING = 256;
    public static final short FSTYPE_PREVIEW_AND_PRINT = 4;
    public static final short FSTYPE_RESTRICTED = 2;
    public static final String TAG = "OS/2";
    public static final int WEIGHT_CLASS_BLACK = 900;
    public static final int WEIGHT_CLASS_BOLD = 700;
    public static final int WEIGHT_CLASS_EXTRA_BOLD = 800;
    public static final int WEIGHT_CLASS_LIGHT = 300;
    public static final int WEIGHT_CLASS_MEDIUM = 500;
    public static final int WEIGHT_CLASS_NORMAL = 400;
    public static final int WEIGHT_CLASS_SEMI_BOLD = 600;
    public static final int WEIGHT_CLASS_THIN = 100;
    public static final int WEIGHT_CLASS_ULTRA_LIGHT = 200;
    public static final int WIDTH_CLASS_CONDENSED = 3;
    public static final int WIDTH_CLASS_EXPANDED = 7;
    public static final int WIDTH_CLASS_EXTRA_CONDENSED = 2;
    public static final int WIDTH_CLASS_EXTRA_EXPANDED = 8;
    public static final int WIDTH_CLASS_MEDIUM = 5;
    public static final int WIDTH_CLASS_SEMI_CONDENSED = 4;
    public static final int WIDTH_CLASS_SEMI_EXPANDED = 6;
    public static final int WIDTH_CLASS_ULTRA_CONDENSED = 1;
    public static final int WIDTH_CLASS_ULTRA_EXPANDED = 9;
    private String achVendId;
    private short averageCharWidth;
    private long codePageRange1;
    private long codePageRange2;
    private int familyClass;
    private int firstCharIndex;
    private int fsSelection;
    private short fsType;
    private int lastCharIndex;
    private byte[] panose;
    private int sCapHeight;
    private short strikeoutPosition;
    private short strikeoutSize;
    private short subscriptXOffset;
    private short subscriptXSize;
    private short subscriptYOffset;
    private short subscriptYSize;
    private short superscriptXOffset;
    private short superscriptXSize;
    private short superscriptYOffset;
    private short superscriptYSize;
    private int sxHeight;
    private int typoAscender;
    private int typoDescender;
    private int typoLineGap;
    private long unicodeRange1;
    private long unicodeRange2;
    private long unicodeRange3;
    private long unicodeRange4;
    private int usBreakChar;
    private int usDefaultChar;
    private int usMaxContext;
    private int version;
    private int weightClass;
    private int widthClass;
    private int winAscent;
    private int winDescent;

    public OS2WindowsMetricsTable(TrueTypeFont trueTypeFont) {
        super(trueTypeFont);
        this.panose = new byte[10];
        this.achVendId = "XXXX";
        this.codePageRange1 = 0L;
        this.codePageRange2 = 0L;
    }

    public String getAchVendId() {
        return this.achVendId;
    }

    public short getAverageCharWidth() {
        return this.averageCharWidth;
    }

    public int getBreakChar() {
        return this.usBreakChar;
    }

    public int getCapHeight() {
        return this.sCapHeight;
    }

    public long getCodePageRange1() {
        return this.codePageRange1;
    }

    public long getCodePageRange2() {
        return this.codePageRange2;
    }

    public int getDefaultChar() {
        return this.usDefaultChar;
    }

    public int getFamilyClass() {
        return this.familyClass;
    }

    public int getFirstCharIndex() {
        return this.firstCharIndex;
    }

    public int getFsSelection() {
        return this.fsSelection;
    }

    public short getFsType() {
        return this.fsType;
    }

    public int getHeight() {
        return this.sxHeight;
    }

    public int getLastCharIndex() {
        return this.lastCharIndex;
    }

    public int getMaxContext() {
        return this.usMaxContext;
    }

    public byte[] getPanose() {
        return this.panose;
    }

    public short getStrikeoutPosition() {
        return this.strikeoutPosition;
    }

    public short getStrikeoutSize() {
        return this.strikeoutSize;
    }

    public short getSubscriptXOffset() {
        return this.subscriptXOffset;
    }

    public short getSubscriptXSize() {
        return this.subscriptXSize;
    }

    public short getSubscriptYOffset() {
        return this.subscriptYOffset;
    }

    public short getSubscriptYSize() {
        return this.subscriptYSize;
    }

    public short getSuperscriptXOffset() {
        return this.superscriptXOffset;
    }

    public short getSuperscriptXSize() {
        return this.superscriptXSize;
    }

    public short getSuperscriptYOffset() {
        return this.superscriptYOffset;
    }

    public short getSuperscriptYSize() {
        return this.superscriptYSize;
    }

    public int getTypoAscender() {
        return this.typoAscender;
    }

    public int getTypoDescender() {
        return this.typoDescender;
    }

    public int getTypoLineGap() {
        return this.typoLineGap;
    }

    public long getUnicodeRange1() {
        return this.unicodeRange1;
    }

    public long getUnicodeRange2() {
        return this.unicodeRange2;
    }

    public long getUnicodeRange3() {
        return this.unicodeRange3;
    }

    public long getUnicodeRange4() {
        return this.unicodeRange4;
    }

    public int getVersion() {
        return this.version;
    }

    public int getWeightClass() {
        return this.weightClass;
    }

    public int getWidthClass() {
        return this.widthClass;
    }

    public int getWinAscent() {
        return this.winAscent;
    }

    public int getWinDescent() {
        return this.winDescent;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFTable
    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        this.version = tTFDataStream.readUnsignedShort();
        this.averageCharWidth = tTFDataStream.readSignedShort();
        this.weightClass = tTFDataStream.readUnsignedShort();
        this.widthClass = tTFDataStream.readUnsignedShort();
        this.fsType = tTFDataStream.readSignedShort();
        this.subscriptXSize = tTFDataStream.readSignedShort();
        this.subscriptYSize = tTFDataStream.readSignedShort();
        this.subscriptXOffset = tTFDataStream.readSignedShort();
        this.subscriptYOffset = tTFDataStream.readSignedShort();
        this.superscriptXSize = tTFDataStream.readSignedShort();
        this.superscriptYSize = tTFDataStream.readSignedShort();
        this.superscriptXOffset = tTFDataStream.readSignedShort();
        this.superscriptYOffset = tTFDataStream.readSignedShort();
        this.strikeoutSize = tTFDataStream.readSignedShort();
        this.strikeoutPosition = tTFDataStream.readSignedShort();
        this.familyClass = tTFDataStream.readSignedShort();
        this.panose = tTFDataStream.read(10);
        this.unicodeRange1 = tTFDataStream.readUnsignedInt();
        this.unicodeRange2 = tTFDataStream.readUnsignedInt();
        this.unicodeRange3 = tTFDataStream.readUnsignedInt();
        this.unicodeRange4 = tTFDataStream.readUnsignedInt();
        this.achVendId = tTFDataStream.readString(4);
        this.fsSelection = tTFDataStream.readUnsignedShort();
        this.firstCharIndex = tTFDataStream.readUnsignedShort();
        this.lastCharIndex = tTFDataStream.readUnsignedShort();
        try {
            this.typoAscender = tTFDataStream.readSignedShort();
            this.typoDescender = tTFDataStream.readSignedShort();
            this.typoLineGap = tTFDataStream.readSignedShort();
            this.winAscent = tTFDataStream.readUnsignedShort();
            this.winDescent = tTFDataStream.readUnsignedShort();
            if (this.version >= 1) {
                try {
                    this.codePageRange1 = tTFDataStream.readUnsignedInt();
                    this.codePageRange2 = tTFDataStream.readUnsignedInt();
                } catch (EOFException e2) {
                    this.version = 0;
                    Log.w("PdfBox-Android", "Could not read all expected parts of version >= 1, setting version to 0", e2);
                    this.initialized = true;
                    return;
                }
            }
            if (this.version >= 2) {
                try {
                    this.sxHeight = tTFDataStream.readSignedShort();
                    this.sCapHeight = tTFDataStream.readSignedShort();
                    this.usDefaultChar = tTFDataStream.readUnsignedShort();
                    this.usBreakChar = tTFDataStream.readUnsignedShort();
                    this.usMaxContext = tTFDataStream.readUnsignedShort();
                } catch (EOFException e3) {
                    this.version = 1;
                    Log.w("PdfBox-Android", "Could not read all expected parts of version >= 2, setting version to 1", e3);
                    this.initialized = true;
                    return;
                }
            }
            this.initialized = true;
        } catch (EOFException unused) {
            Log.d("PdfBox-Android", "EOF, probably some legacy TrueType font");
            this.initialized = true;
        }
    }

    public void setAchVendId(String str) {
        this.achVendId = str;
    }

    public void setAverageCharWidth(short s) {
        this.averageCharWidth = s;
    }

    public void setCodePageRange1(long j) {
        this.codePageRange1 = j;
    }

    public void setCodePageRange2(long j) {
        this.codePageRange2 = j;
    }

    public void setFamilyClass(int i2) {
        this.familyClass = i2;
    }

    public void setFirstCharIndex(int i2) {
        this.firstCharIndex = i2;
    }

    public void setFsSelection(int i2) {
        this.fsSelection = i2;
    }

    public void setFsType(short s) {
        this.fsType = s;
    }

    public void setLastCharIndex(int i2) {
        this.lastCharIndex = i2;
    }

    public void setPanose(byte[] bArr) {
        this.panose = bArr;
    }

    public void setStrikeoutPosition(short s) {
        this.strikeoutPosition = s;
    }

    public void setStrikeoutSize(short s) {
        this.strikeoutSize = s;
    }

    public void setSubscriptXOffset(short s) {
        this.subscriptXOffset = s;
    }

    public void setSubscriptXSize(short s) {
        this.subscriptXSize = s;
    }

    public void setSubscriptYOffset(short s) {
        this.subscriptYOffset = s;
    }

    public void setSubscriptYSize(short s) {
        this.subscriptYSize = s;
    }

    public void setSuperscriptXOffset(short s) {
        this.superscriptXOffset = s;
    }

    public void setSuperscriptXSize(short s) {
        this.superscriptXSize = s;
    }

    public void setSuperscriptYOffset(short s) {
        this.superscriptYOffset = s;
    }

    public void setSuperscriptYSize(short s) {
        this.superscriptYSize = s;
    }

    public void setTypoAscender(int i2) {
        this.typoAscender = i2;
    }

    public void setTypoDescender(int i2) {
        this.typoDescender = i2;
    }

    public void setTypoLineGap(int i2) {
        this.typoLineGap = i2;
    }

    public void setUnicodeRange1(long j) {
        this.unicodeRange1 = j;
    }

    public void setUnicodeRange2(long j) {
        this.unicodeRange2 = j;
    }

    public void setUnicodeRange3(long j) {
        this.unicodeRange3 = j;
    }

    public void setUnicodeRange4(long j) {
        this.unicodeRange4 = j;
    }

    public void setVersion(int i2) {
        this.version = i2;
    }

    public void setWeightClass(int i2) {
        this.weightClass = i2;
    }

    public void setWidthClass(int i2) {
        this.widthClass = i2;
    }

    public void setWinAscent(int i2) {
        this.winAscent = i2;
    }

    public void setWinDescent(int i2) {
        this.winDescent = i2;
    }
}
