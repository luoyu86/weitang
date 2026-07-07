package com.tom_roush.fontbox.type1;

import android.graphics.Path;
import com.tom_roush.fontbox.EncodedFont;
import com.tom_roush.fontbox.FontBoxFont;
import com.tom_roush.fontbox.cff.Type1CharString;
import com.tom_roush.fontbox.cff.Type1CharStringParser;
import com.tom_roush.fontbox.encoding.Encoding;
import com.tom_roush.fontbox.pfb.PfbParser;
import com.tom_roush.fontbox.util.BoundingBox;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class Type1Font implements Type1CharStringReader, EncodedFont, FontBoxFont {
    public int blueFuzz;
    public float blueScale;
    public int blueShift;
    public int fontType;
    public boolean forceBold;
    public boolean isFixedPitch;
    public float italicAngle;
    public int languageGroup;
    public int paintType;
    private final byte[] segment1;
    private final byte[] segment2;
    public float strokeWidth;
    public float underlinePosition;
    public float underlineThickness;
    public int uniqueID;
    public String fontName = "";
    public Encoding encoding = null;
    public List<Number> fontMatrix = new ArrayList();
    public List<Number> fontBBox = new ArrayList();
    public String fontID = "";
    public String version = "";
    public String notice = "";
    public String fullName = "";
    public String familyName = "";
    public String weight = "";
    public List<Number> blueValues = new ArrayList();
    public List<Number> otherBlues = new ArrayList();
    public List<Number> familyBlues = new ArrayList();
    public List<Number> familyOtherBlues = new ArrayList();
    public List<Number> stdHW = new ArrayList();
    public List<Number> stdVW = new ArrayList();
    public List<Number> stemSnapH = new ArrayList();
    public List<Number> stemSnapV = new ArrayList();
    public final List<byte[]> subrs = new ArrayList();
    public final Map<String, byte[]> charstrings = new LinkedHashMap();
    private final Map<String, Type1CharString> charStringCache = new ConcurrentHashMap();

    public Type1Font(byte[] bArr, byte[] bArr2) {
        this.segment1 = bArr;
        this.segment2 = bArr2;
    }

    public static Type1Font createWithPFB(InputStream inputStream) throws IOException {
        PfbParser pfbParser = new PfbParser(inputStream);
        return new Type1Parser().parse(pfbParser.getSegment1(), pfbParser.getSegment2());
    }

    public static Type1Font createWithSegments(byte[] bArr, byte[] bArr2) throws IOException {
        return new Type1Parser().parse(bArr, bArr2);
    }

    public byte[] getASCIISegment() {
        return this.segment1;
    }

    public byte[] getBinarySegment() {
        return this.segment2;
    }

    public int getBlueFuzz() {
        return this.blueFuzz;
    }

    public float getBlueScale() {
        return this.blueScale;
    }

    public int getBlueShift() {
        return this.blueShift;
    }

    public List<Number> getBlueValues() {
        return Collections.unmodifiableList(this.blueValues);
    }

    public Map<String, byte[]> getCharStringsDict() {
        return Collections.unmodifiableMap(this.charstrings);
    }

    @Override // com.tom_roush.fontbox.EncodedFont
    public Encoding getEncoding() {
        return this.encoding;
    }

    public List<Number> getFamilyBlues() {
        return Collections.unmodifiableList(this.familyBlues);
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public List<Number> getFamilyOtherBlues() {
        return Collections.unmodifiableList(this.familyOtherBlues);
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public BoundingBox getFontBBox() {
        return new BoundingBox(this.fontBBox);
    }

    public String getFontID() {
        return this.fontID;
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public List<Number> getFontMatrix() {
        return Collections.unmodifiableList(this.fontMatrix);
    }

    public String getFontName() {
        return this.fontName;
    }

    public int getFontType() {
        return this.fontType;
    }

    public String getFullName() {
        return this.fullName;
    }

    public float getItalicAngle() {
        return this.italicAngle;
    }

    public int getLanguageGroup() {
        return this.languageGroup;
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public String getName() {
        return this.fontName;
    }

    public String getNotice() {
        return this.notice;
    }

    public List<Number> getOtherBlues() {
        return Collections.unmodifiableList(this.otherBlues);
    }

    public int getPaintType() {
        return this.paintType;
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public Path getPath(String str) throws IOException {
        return getType1CharString(str).getPath();
    }

    public List<Number> getStdHW() {
        return Collections.unmodifiableList(this.stdHW);
    }

    public List<Number> getStdVW() {
        return Collections.unmodifiableList(this.stdVW);
    }

    public List<Number> getStemSnapH() {
        return Collections.unmodifiableList(this.stemSnapH);
    }

    public List<Number> getStemSnapV() {
        return Collections.unmodifiableList(this.stemSnapV);
    }

    public float getStrokeWidth() {
        return this.strokeWidth;
    }

    public List<byte[]> getSubrsArray() {
        return Collections.unmodifiableList(this.subrs);
    }

    @Override // com.tom_roush.fontbox.type1.Type1CharStringReader
    public Type1CharString getType1CharString(String str) throws IOException {
        Type1CharString type1CharString = this.charStringCache.get(str);
        if (type1CharString != null) {
            return type1CharString;
        }
        byte[] bArr = this.charstrings.get(str);
        if (bArr == null) {
            bArr = this.charstrings.get(".notdef");
        }
        Type1CharString type1CharString2 = new Type1CharString(this, this.fontName, str, new Type1CharStringParser(this.fontName, str).parse(bArr, this.subrs));
        this.charStringCache.put(str, type1CharString2);
        return type1CharString2;
    }

    public float getUnderlinePosition() {
        return this.underlinePosition;
    }

    public float getUnderlineThickness() {
        return this.underlineThickness;
    }

    public int getUniqueID() {
        return this.uniqueID;
    }

    public String getVersion() {
        return this.version;
    }

    public String getWeight() {
        return this.weight;
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public float getWidth(String str) throws IOException {
        return getType1CharString(str).getWidth();
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public boolean hasGlyph(String str) {
        return this.charstrings.get(str) != null;
    }

    public boolean isFixedPitch() {
        return this.isFixedPitch;
    }

    public boolean isForceBold() {
        return this.forceBold;
    }

    public String toString() {
        return Type1Font.class.getName() + "[fontName=" + this.fontName + ", fullName=" + this.fullName + ", encoding=" + this.encoding + ", charStringsDict=" + this.charstrings + "]";
    }

    public static Type1Font createWithPFB(byte[] bArr) throws IOException {
        PfbParser pfbParser = new PfbParser(bArr);
        return new Type1Parser().parse(pfbParser.getSegment1(), pfbParser.getSegment2());
    }
}
