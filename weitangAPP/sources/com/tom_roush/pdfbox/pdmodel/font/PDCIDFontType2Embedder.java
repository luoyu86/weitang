package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.tom_roush.fontbox.ttf.GlyphData;
import com.tom_roush.fontbox.ttf.GlyphTable;
import com.tom_roush.fontbox.ttf.HorizontalMetricsTable;
import com.tom_roush.fontbox.ttf.TrueTypeFont;
import com.tom_roush.fontbox.ttf.VerticalHeaderTable;
import com.tom_roush.fontbox.ttf.VerticalMetricsTable;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes2.dex */
public final class PDCIDFontType2Embedder extends TrueTypeEmbedder {
    private final COSDictionary cidFont;
    private final COSDictionary dict;
    private final PDDocument document;
    private final PDType0Font parent;
    private final boolean vertical;

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.pdmodel.font.PDCIDFontType2Embedder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$tom_roush$pdfbox$pdmodel$font$PDCIDFontType2Embedder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$tom_roush$pdfbox$pdmodel$font$PDCIDFontType2Embedder$State = iArr;
            try {
                iArr[State.FIRST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tom_roush$pdfbox$pdmodel$font$PDCIDFontType2Embedder$State[State.BRACKET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tom_roush$pdfbox$pdmodel$font$PDCIDFontType2Embedder$State[State.SERIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum State {
        FIRST,
        BRACKET,
        SERIAL
    }

    public PDCIDFontType2Embedder(PDDocument pDDocument, COSDictionary cOSDictionary, TrueTypeFont trueTypeFont, boolean z, PDType0Font pDType0Font, boolean z2) throws IOException {
        super(pDDocument, cOSDictionary, trueTypeFont, z);
        this.document = pDDocument;
        this.dict = cOSDictionary;
        this.parent = pDType0Font;
        this.vertical = z2;
        cOSDictionary.setItem(COSName.SUBTYPE, COSName.TYPE0);
        cOSDictionary.setName(COSName.BASE_FONT, this.fontDescriptor.getFontName());
        cOSDictionary.setItem(COSName.ENCODING, z2 ? COSName.IDENTITY_V : COSName.IDENTITY_H);
        COSDictionary cOSDictionaryCreateCIDFont = createCIDFont();
        this.cidFont = cOSDictionaryCreateCIDFont;
        COSArray cOSArray = new COSArray();
        cOSArray.add((COSBase) cOSDictionaryCreateCIDFont);
        cOSDictionary.setItem(COSName.DESCENDANT_FONTS, (COSBase) cOSArray);
        if (z) {
            return;
        }
        buildToUnicodeCMap(null);
    }

    private void addNameTag(String str) {
        String str2 = str + this.fontDescriptor.getFontName();
        COSDictionary cOSDictionary = this.dict;
        COSName cOSName = COSName.BASE_FONT;
        cOSDictionary.setName(cOSName, str2);
        this.fontDescriptor.setFontName(str2);
        this.cidFont.setName(cOSName, str2);
    }

    private void buildCIDSet(Map<Integer, Integer> map) throws IOException {
        int iIntValue = ((Integer) Collections.max(map.keySet())).intValue();
        byte[] bArr = new byte[(iIntValue / 8) + 1];
        for (int i2 = 0; i2 <= iIntValue; i2++) {
            int i3 = i2 / 8;
            bArr[i3] = (byte) ((1 << (7 - (i2 % 8))) | bArr[i3]);
        }
        this.fontDescriptor.setCIDSet(new PDStream(this.document, (InputStream) new ByteArrayInputStream(bArr), COSName.FLATE_DECODE));
    }

    private void buildCIDToGIDMap(Map<Integer, Integer> map) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iIntValue = ((Integer) Collections.max(map.keySet())).intValue();
        for (int i2 = 0; i2 <= iIntValue; i2++) {
            int iIntValue2 = map.containsKey(Integer.valueOf(i2)) ? map.get(Integer.valueOf(i2)).intValue() : 0;
            byteArrayOutputStream.write(new byte[]{(byte) ((iIntValue2 >> 8) & 255), (byte) (iIntValue2 & 255)});
        }
        this.cidFont.setItem(COSName.CID_TO_GID_MAP, new PDStream(this.document, (InputStream) new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), COSName.FLATE_DECODE));
    }

    private void buildToUnicodeCMap(Map<Integer, Integer> map) throws IOException {
        int iIntValue;
        ToUnicodeWriter toUnicodeWriter = new ToUnicodeWriter();
        int numGlyphs = this.ttf.getMaximumProfile().getNumGlyphs();
        boolean z = false;
        for (int i2 = 1; i2 <= numGlyphs; i2++) {
            if (map == null) {
                iIntValue = i2;
            } else if (map.containsKey(Integer.valueOf(i2))) {
                iIntValue = map.get(Integer.valueOf(i2)).intValue();
            }
            List<Integer> charCodes = this.cmapLookup.getCharCodes(iIntValue);
            if (charCodes != null) {
                int iIntValue2 = charCodes.get(0).intValue();
                if (iIntValue2 > 65535) {
                    z = true;
                }
                toUnicodeWriter.add(iIntValue, new String(new int[]{iIntValue2}, 0, 1));
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        toUnicodeWriter.writeTo(byteArrayOutputStream);
        PDStream pDStream = new PDStream(this.document, (InputStream) new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), COSName.FLATE_DECODE);
        if (z && this.document.getVersion() < 1.5d) {
            this.document.setVersion(1.5f);
        }
        this.dict.setItem(COSName.TO_UNICODE, pDStream);
    }

    private boolean buildVerticalHeader(COSDictionary cOSDictionary) throws IOException {
        if (this.ttf.getVerticalHeader() == null) {
            Log.w("PdfBox-Android", "Font to be subset is set to vertical, but has no 'vhea' table");
            return false;
        }
        float unitsPerEm = 1000.0f / this.ttf.getHeader().getUnitsPerEm();
        long jRound = Math.round(r0.getAscender() * unitsPerEm);
        long jRound2 = Math.round((-r0.getAdvanceHeightMax()) * unitsPerEm);
        if (jRound == 880 && jRound2 == -1000) {
            return true;
        }
        COSArray cOSArray = new COSArray();
        cOSArray.add((COSBase) COSInteger.get(jRound));
        cOSArray.add((COSBase) COSInteger.get(jRound2));
        cOSDictionary.setItem(COSName.DW2, (COSBase) cOSArray);
        return true;
    }

    private void buildVerticalMetrics(Map<Integer, Integer> map) throws IOException {
        VerticalMetricsTable verticalMetricsTable;
        GlyphTable glyphTable;
        if (buildVerticalHeader(this.cidFont)) {
            float unitsPerEm = 1000.0f / this.ttf.getHeader().getUnitsPerEm();
            VerticalHeaderTable verticalHeader = this.ttf.getVerticalHeader();
            VerticalMetricsTable verticalMetrics = this.ttf.getVerticalMetrics();
            GlyphTable glyph = this.ttf.getGlyph();
            HorizontalMetricsTable horizontalMetrics = this.ttf.getHorizontalMetrics();
            long jRound = Math.round(verticalHeader.getAscender() * unitsPerEm);
            long jRound2 = Math.round((-verticalHeader.getAdvanceHeightMax()) * unitsPerEm);
            COSArray cOSArray = new COSArray();
            COSArray cOSArray2 = new COSArray();
            int i2 = Integer.MIN_VALUE;
            Iterator it = new TreeSet(map.keySet()).iterator();
            while (it.hasNext()) {
                int iIntValue = ((Integer) it.next()).intValue();
                if (glyph.getGlyph(iIntValue) == null) {
                    verticalMetricsTable = verticalMetrics;
                    glyphTable = glyph;
                } else {
                    long jRound3 = Math.round((r14.getYMaximum() + verticalMetrics.getTopSideBearing(iIntValue)) * unitsPerEm);
                    glyphTable = glyph;
                    verticalMetricsTable = verticalMetrics;
                    long jRound4 = Math.round((-verticalMetrics.getAdvanceHeight(iIntValue)) * unitsPerEm);
                    if (jRound3 != jRound || jRound4 != jRound2) {
                        long j = jRound;
                        if (i2 != iIntValue - 1) {
                            COSArray cOSArray3 = new COSArray();
                            cOSArray.add((COSBase) COSInteger.get(iIntValue));
                            cOSArray.add((COSBase) cOSArray3);
                            cOSArray2 = cOSArray3;
                        }
                        cOSArray2.add((COSBase) COSInteger.get(jRound4));
                        cOSArray2.add((COSBase) COSInteger.get(((long) Math.round(horizontalMetrics.getAdvanceWidth(iIntValue) * unitsPerEm)) / 2));
                        cOSArray2.add((COSBase) COSInteger.get(jRound3));
                        i2 = iIntValue;
                        glyph = glyphTable;
                        verticalMetrics = verticalMetricsTable;
                        jRound = j;
                    }
                }
                glyph = glyphTable;
                verticalMetrics = verticalMetricsTable;
            }
            this.cidFont.setItem(COSName.W2, (COSBase) cOSArray);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void buildWidths(Map<Integer, Integer> map) throws IOException {
        float unitsPerEm = 1000.0f / this.ttf.getHeader().getUnitsPerEm();
        COSArray cOSArray = new COSArray();
        COSArray cOSArray2 = new COSArray();
        Iterator it = new TreeSet(map.keySet()).iterator();
        int i2 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            long jRound = Math.round(this.ttf.getHorizontalMetrics().getAdvanceWidth(map.get(Integer.valueOf(iIntValue)).intValue()) * unitsPerEm);
            if (jRound != 1000) {
                if (i2 != iIntValue - 1) {
                    cOSArray2 = new COSArray();
                    cOSArray.add((COSBase) COSInteger.get(iIntValue));
                    cOSArray.add((COSBase) cOSArray2);
                }
                cOSArray2.add((COSBase) COSInteger.get(jRound));
                i2 = iIntValue;
            }
        }
        this.cidFont.setItem(COSName.W, (COSBase) cOSArray);
    }

    private COSDictionary createCIDFont() throws IOException {
        COSDictionary cOSDictionary = new COSDictionary();
        cOSDictionary.setItem(COSName.TYPE, (COSBase) COSName.FONT);
        cOSDictionary.setItem(COSName.SUBTYPE, (COSBase) COSName.CID_FONT_TYPE2);
        cOSDictionary.setName(COSName.BASE_FONT, this.fontDescriptor.getFontName());
        cOSDictionary.setItem(COSName.CIDSYSTEMINFO, (COSBase) toCIDSystemInfo("Adobe", "Identity", 0));
        cOSDictionary.setItem(COSName.FONT_DESC, (COSBase) this.fontDescriptor.getCOSObject());
        buildWidths(cOSDictionary);
        if (this.vertical) {
            buildVerticalMetrics(cOSDictionary);
        }
        cOSDictionary.setItem(COSName.CID_TO_GID_MAP, (COSBase) COSName.IDENTITY);
        return cOSDictionary;
    }

    private COSArray getVerticalMetrics(int[] iArr) throws IOException {
        float f2;
        COSArray cOSArray;
        State state;
        int[] iArr2 = iArr;
        if (iArr2.length == 0) {
            throw new IllegalArgumentException("length of values must be > 0");
        }
        float unitsPerEm = 1000.0f / this.ttf.getHeader().getUnitsPerEm();
        long j = iArr2[0];
        long jRound = Math.round((-iArr2[1]) * unitsPerEm);
        long jRound2 = Math.round((iArr2[2] * unitsPerEm) / 2.0f);
        long jRound3 = Math.round(iArr2[3] * unitsPerEm);
        COSArray cOSArray2 = new COSArray();
        COSArray cOSArray3 = new COSArray();
        cOSArray3.add((COSBase) COSInteger.get(j));
        State state2 = State.FIRST;
        int i2 = 4;
        while (i2 < iArr2.length) {
            COSArray cOSArray4 = cOSArray3;
            long j2 = iArr2[i2];
            if (j2 == -2147483648L) {
                f2 = unitsPerEm;
                state = state2;
                cOSArray = cOSArray4;
            } else {
                long j3 = jRound3;
                long jRound4 = Math.round((-iArr2[i2 + 1]) * unitsPerEm);
                long j4 = jRound2;
                jRound2 = Math.round((iArr2[i2 + 2] * unitsPerEm) / 2.0f);
                f2 = unitsPerEm;
                long jRound5 = Math.round(iArr2[i2 + 3] * unitsPerEm);
                int i3 = AnonymousClass1.$SwitchMap$com$tom_roush$pdfbox$pdmodel$font$PDCIDFontType2Embedder$State[state2.ordinal()];
                State state3 = state2;
                if (i3 == 1) {
                    cOSArray = cOSArray4;
                    long j5 = j + 1;
                    if (j2 == j5 && jRound4 == jRound && jRound2 == j4 && jRound5 == j3) {
                        state = State.SERIAL;
                    } else if (j2 == j5) {
                        state = State.BRACKET;
                        cOSArray2 = new COSArray();
                        cOSArray2.add((COSBase) COSInteger.get(jRound));
                        cOSArray2.add((COSBase) COSInteger.get(j4));
                        cOSArray2.add((COSBase) COSInteger.get(j3));
                    } else {
                        cOSArray2 = new COSArray();
                        cOSArray2.add((COSBase) COSInteger.get(jRound));
                        cOSArray2.add((COSBase) COSInteger.get(j4));
                        cOSArray2.add((COSBase) COSInteger.get(j3));
                        cOSArray.add((COSBase) cOSArray2);
                        cOSArray.add((COSBase) COSInteger.get(j2));
                        state = state3;
                    }
                    j = j2;
                    jRound = jRound4;
                    jRound3 = jRound5;
                } else if (i3 == 2) {
                    cOSArray = cOSArray4;
                    long j6 = j + 1;
                    if (j2 == j6 && jRound4 == jRound && jRound2 == j4 && jRound5 == j3) {
                        state = State.SERIAL;
                        cOSArray.add((COSBase) cOSArray2);
                        cOSArray.add((COSBase) COSInteger.get(j));
                    } else if (j2 == j6) {
                        cOSArray2.add((COSBase) COSInteger.get(jRound));
                        cOSArray2.add((COSBase) COSInteger.get(j4));
                        cOSArray2.add((COSBase) COSInteger.get(j3));
                        state = state3;
                    } else {
                        state = State.FIRST;
                        cOSArray2.add((COSBase) COSInteger.get(jRound));
                        cOSArray2.add((COSBase) COSInteger.get(j4));
                        cOSArray2.add((COSBase) COSInteger.get(j3));
                        cOSArray.add((COSBase) cOSArray2);
                        cOSArray.add((COSBase) COSInteger.get(j2));
                    }
                    j = j2;
                    jRound = jRound4;
                    jRound3 = jRound5;
                } else if (i3 == 3 && !(j2 == j + 1 && jRound4 == jRound && jRound2 == j4 && jRound5 == j3)) {
                    cOSArray = cOSArray4;
                    cOSArray.add((COSBase) COSInteger.get(j));
                    cOSArray.add((COSBase) COSInteger.get(jRound));
                    cOSArray.add((COSBase) COSInteger.get(j4));
                    cOSArray.add((COSBase) COSInteger.get(j3));
                    cOSArray.add((COSBase) COSInteger.get(j2));
                    state = State.FIRST;
                    j = j2;
                    jRound = jRound4;
                    jRound3 = jRound5;
                } else {
                    cOSArray = cOSArray4;
                    state = state3;
                    j = j2;
                    jRound = jRound4;
                    jRound3 = jRound5;
                }
            }
            i2 += 4;
            iArr2 = iArr;
            cOSArray3 = cOSArray;
            unitsPerEm = f2;
            state2 = state;
        }
        State state4 = state2;
        COSArray cOSArray5 = cOSArray3;
        long j7 = jRound2;
        long j8 = jRound3;
        int i4 = AnonymousClass1.$SwitchMap$com$tom_roush$pdfbox$pdmodel$font$PDCIDFontType2Embedder$State[state4.ordinal()];
        if (i4 == 1) {
            COSArray cOSArray6 = new COSArray();
            cOSArray6.add((COSBase) COSInteger.get(jRound));
            cOSArray6.add((COSBase) COSInteger.get(j7));
            cOSArray6.add((COSBase) COSInteger.get(j8));
            cOSArray5.add((COSBase) cOSArray6);
        } else if (i4 == 2) {
            cOSArray2.add((COSBase) COSInteger.get(jRound));
            cOSArray2.add((COSBase) COSInteger.get(j7));
            cOSArray2.add((COSBase) COSInteger.get(j8));
            cOSArray5.add((COSBase) cOSArray2);
        } else if (i4 == 3) {
            cOSArray5.add((COSBase) COSInteger.get(j));
            cOSArray5.add((COSBase) COSInteger.get(jRound));
            cOSArray5.add((COSBase) COSInteger.get(j7));
            cOSArray5.add((COSBase) COSInteger.get(j8));
        }
        return cOSArray5;
    }

    private COSArray getWidths(int[] iArr) throws IOException {
        State state;
        if (iArr.length == 0) {
            throw new IllegalArgumentException("length of widths must be > 0");
        }
        float unitsPerEm = 1000.0f / this.ttf.getHeader().getUnitsPerEm();
        long j = iArr[0];
        int i2 = 1;
        long jRound = Math.round(iArr[1] * unitsPerEm);
        COSArray cOSArray = new COSArray();
        COSArray cOSArray2 = new COSArray();
        cOSArray2.add((COSBase) COSInteger.get(j));
        State state2 = State.FIRST;
        int i3 = 2;
        while (i3 < iArr.length) {
            long j2 = iArr[i3];
            int i4 = i3;
            long jRound2 = Math.round(iArr[i3 + 1] * unitsPerEm);
            int i5 = AnonymousClass1.$SwitchMap$com$tom_roush$pdfbox$pdmodel$font$PDCIDFontType2Embedder$State[state2.ordinal()];
            if (i5 == i2) {
                long j3 = j + 1;
                if (j2 == j3 && jRound2 == jRound) {
                    state = State.SERIAL;
                    state2 = state;
                } else if (j2 == j3) {
                    State state3 = State.BRACKET;
                    COSArray cOSArray3 = new COSArray();
                    cOSArray3.add((COSBase) COSInteger.get(jRound));
                    state2 = state3;
                    cOSArray = cOSArray3;
                } else {
                    COSArray cOSArray4 = new COSArray();
                    cOSArray4.add((COSBase) COSInteger.get(jRound));
                    cOSArray2.add((COSBase) cOSArray4);
                    cOSArray2.add((COSBase) COSInteger.get(j2));
                    cOSArray = cOSArray4;
                }
            } else if (i5 == 2) {
                long j4 = j + 1;
                if (j2 == j4 && jRound2 == jRound) {
                    State state4 = State.SERIAL;
                    cOSArray2.add((COSBase) cOSArray);
                    cOSArray2.add((COSBase) COSInteger.get(j));
                    state2 = state4;
                } else if (j2 == j4) {
                    cOSArray.add((COSBase) COSInteger.get(jRound));
                } else {
                    state = State.FIRST;
                    cOSArray.add((COSBase) COSInteger.get(jRound));
                    cOSArray2.add((COSBase) cOSArray);
                    cOSArray2.add((COSBase) COSInteger.get(j2));
                    state2 = state;
                }
            } else if (i5 == 3 && (j2 != j + 1 || jRound2 != jRound)) {
                cOSArray2.add((COSBase) COSInteger.get(j));
                cOSArray2.add((COSBase) COSInteger.get(jRound));
                cOSArray2.add((COSBase) COSInteger.get(j2));
                state = State.FIRST;
                state2 = state;
            }
            jRound = jRound2;
            i2 = 1;
            i3 = i4 + 2;
            j = j2;
        }
        int i6 = AnonymousClass1.$SwitchMap$com$tom_roush$pdfbox$pdmodel$font$PDCIDFontType2Embedder$State[state2.ordinal()];
        if (i6 == 1) {
            COSArray cOSArray5 = new COSArray();
            cOSArray5.add((COSBase) COSInteger.get(jRound));
            cOSArray2.add((COSBase) cOSArray5);
        } else if (i6 == 2) {
            cOSArray.add((COSBase) COSInteger.get(jRound));
            cOSArray2.add((COSBase) cOSArray);
        } else if (i6 == 3) {
            cOSArray2.add((COSBase) COSInteger.get(j));
            cOSArray2.add((COSBase) COSInteger.get(jRound));
        }
        return cOSArray2;
    }

    private COSDictionary toCIDSystemInfo(String str, String str2, int i2) {
        COSDictionary cOSDictionary = new COSDictionary();
        cOSDictionary.setString(COSName.REGISTRY, str);
        cOSDictionary.setString(COSName.ORDERING, str2);
        cOSDictionary.setInt(COSName.SUPPLEMENT, i2);
        return cOSDictionary;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.TrueTypeEmbedder
    public void buildSubset(InputStream inputStream, String str, Map<Integer, Integer> map) throws IOException {
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            map2.put(Integer.valueOf(entry.getValue().intValue()), Integer.valueOf(entry.getKey().intValue()));
        }
        buildToUnicodeCMap(map);
        if (this.vertical) {
            buildVerticalMetrics(map2);
        }
        buildFontFile2(inputStream);
        addNameTag(str);
        buildWidths(map2);
        buildCIDToGIDMap(map2);
        buildCIDSet(map2);
    }

    public PDCIDFont getCIDFont() throws IOException {
        return new PDCIDFontType2(this.cidFont, this.parent, this.ttf);
    }

    private void buildWidths(COSDictionary cOSDictionary) throws IOException {
        int numberOfGlyphs = this.ttf.getNumberOfGlyphs();
        int[] iArr = new int[numberOfGlyphs * 2];
        for (int i2 = 0; i2 < numberOfGlyphs; i2++) {
            int i3 = i2 * 2;
            iArr[i3] = i2;
            iArr[i3 + 1] = this.ttf.getHorizontalMetrics().getAdvanceWidth(i2);
        }
        cOSDictionary.setItem(COSName.W, (COSBase) getWidths(iArr));
    }

    private void buildVerticalMetrics(COSDictionary cOSDictionary) throws IOException {
        if (buildVerticalHeader(cOSDictionary)) {
            int numberOfGlyphs = this.ttf.getNumberOfGlyphs();
            int[] iArr = new int[numberOfGlyphs * 4];
            for (int i2 = 0; i2 < numberOfGlyphs; i2++) {
                GlyphData glyph = this.ttf.getGlyph().getGlyph(i2);
                if (glyph == null) {
                    iArr[i2 * 4] = Integer.MIN_VALUE;
                } else {
                    int i3 = i2 * 4;
                    iArr[i3] = i2;
                    iArr[i3 + 1] = this.ttf.getVerticalMetrics().getAdvanceHeight(i2);
                    iArr[i3 + 2] = this.ttf.getHorizontalMetrics().getAdvanceWidth(i2);
                    iArr[i3 + 3] = glyph.getYMaximum() + this.ttf.getVerticalMetrics().getTopSideBearing(i2);
                }
            }
            cOSDictionary.setItem(COSName.W2, (COSBase) getVerticalMetrics(iArr));
        }
    }
}
