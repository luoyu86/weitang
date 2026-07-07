package com.tom_roush.fontbox.cff;

import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.tom_roush.fontbox.afm.AFMParser;
import com.tom_roush.fontbox.cff.CFFOperator;
import com.tom_roush.fontbox.ttf.CFFTable;
import com.tom_roush.fontbox.util.Charsets;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class CFFParser {
    private static final String TAG_OTTO = "OTTO";
    private static final String TAG_TTCF = "ttcf";
    private static final String TAG_TTFONLY = "\u0000\u0001\u0000\u0000";
    private String debugFontName;
    private ByteSource source;
    private String[] stringIndex = null;

    public interface ByteSource {
        byte[] getBytes() throws IOException;
    }

    public static abstract class CFFBuiltInEncoding extends CFFEncoding {
        private int nSups;
        private Supplement[] supplement;

        public static class Supplement {
            private int code;
            private String name;
            private int sid;

            public int getCode() {
                return this.code;
            }

            public String getName() {
                return this.name;
            }

            public int getSID() {
                return this.sid;
            }

            public String toString() {
                return getClass().getName() + "[code=" + this.code + ", sid=" + this.sid + "]";
            }
        }
    }

    public static class DictData {
        private final Map<String, Entry> entries;

        public static class Entry {
            private List<Number> operands;
            private CFFOperator operator;

            private Entry() {
                this.operands = new ArrayList();
                this.operator = null;
            }

            public List<Number> getArray() {
                return this.operands;
            }

            public Boolean getBoolean(int i2) {
                Number number = this.operands.get(i2);
                if (number instanceof Integer) {
                    int iIntValue = number.intValue();
                    if (iIntValue == 0) {
                        return Boolean.FALSE;
                    }
                    if (iIntValue == 1) {
                        return Boolean.TRUE;
                    }
                }
                throw new IllegalArgumentException();
            }

            public List<Number> getDelta() {
                ArrayList arrayList = new ArrayList(this.operands);
                for (int i2 = 1; i2 < arrayList.size(); i2++) {
                    arrayList.set(i2, Integer.valueOf(((Number) arrayList.get(i2 - 1)).intValue() + ((Number) arrayList.get(i2)).intValue()));
                }
                return arrayList;
            }

            public Number getNumber(int i2) {
                return this.operands.get(i2);
            }

            public boolean hasOperands() {
                return !this.operands.isEmpty();
            }

            public int size() {
                return this.operands.size();
            }

            public String toString() {
                return getClass().getName() + "[operands=" + this.operands + ", operator=" + this.operator + "]";
            }
        }

        private DictData() {
            this.entries = new HashMap();
        }

        public void add(Entry entry) {
            if (entry.operator != null) {
                this.entries.put(entry.operator.getName(), entry);
            }
        }

        public List<Number> getArray(String str, List<Number> list) {
            Entry entry = getEntry(str);
            return (entry == null || entry.getArray().isEmpty()) ? list : entry.getArray();
        }

        public Boolean getBoolean(String str, boolean z) {
            Entry entry = getEntry(str);
            if (entry != null && !entry.getArray().isEmpty()) {
                z = entry.getBoolean(0).booleanValue();
            }
            return Boolean.valueOf(z);
        }

        public List<Number> getDelta(String str, List<Number> list) {
            Entry entry = getEntry(str);
            return (entry == null || entry.getArray().isEmpty()) ? list : entry.getDelta();
        }

        public Entry getEntry(String str) {
            return this.entries.get(str);
        }

        public Number getNumber(String str, Number number) {
            Entry entry = getEntry(str);
            return (entry == null || entry.getArray().isEmpty()) ? number : entry.getNumber(0);
        }

        public String toString() {
            return getClass().getName() + "[entries=" + this.entries + "]";
        }
    }

    public static abstract class EmbeddedCharset extends CFFCharset {
        public EmbeddedCharset(boolean z) {
            super(z);
        }
    }

    public static class EmptyCharset extends EmbeddedCharset {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmptyCharset(int i2) {
            super(true);
            addCID(0, 0);
            for (int i3 = 1; i3 <= i2; i3++) {
                addCID(i3, i3);
            }
        }

        public String toString() {
            return getClass().getName();
        }
    }

    public static class Format0Charset extends EmbeddedCharset {
        private int format;

        public Format0Charset(boolean z) {
            super(z);
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.format + "]";
        }
    }

    public static class Format0Encoding extends CFFBuiltInEncoding {
        private int format;
        private int nCodes;

        private Format0Encoding() {
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.format + ", nCodes=" + this.nCodes + ", supplement=" + Arrays.toString(((CFFBuiltInEncoding) this).supplement) + "]";
        }
    }

    public static class Format0FDSelect extends FDSelect {
        private int[] fds;
        private int format;

        @Override // com.tom_roush.fontbox.cff.FDSelect
        public int getFDIndex(int i2) {
            int[] iArr = this.fds;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return 0;
        }

        public String toString() {
            return getClass().getName() + "[fds=" + Arrays.toString(this.fds) + "]";
        }

        private Format0FDSelect(CFFCIDFont cFFCIDFont) {
            super(cFFCIDFont);
        }
    }

    public static class Format1Charset extends EmbeddedCharset {
        private int format;
        private List<RangeMapping> rangesCID2GID;

        public Format1Charset(boolean z) {
            super(z);
        }

        @Override // com.tom_roush.fontbox.cff.CFFCharset
        public int getCIDForGID(int i2) {
            if (isCIDFont()) {
                for (RangeMapping rangeMapping : this.rangesCID2GID) {
                    if (rangeMapping.isInRange(i2)) {
                        return rangeMapping.mapValue(i2);
                    }
                }
            }
            return super.getCIDForGID(i2);
        }

        @Override // com.tom_roush.fontbox.cff.CFFCharset
        public int getGIDForCID(int i2) {
            if (isCIDFont()) {
                for (RangeMapping rangeMapping : this.rangesCID2GID) {
                    if (rangeMapping.isInReverseRange(i2)) {
                        return rangeMapping.mapReverseValue(i2);
                    }
                }
            }
            return super.getGIDForCID(i2);
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.format + "]";
        }
    }

    public static class Format1Encoding extends CFFBuiltInEncoding {
        private int format;
        private int nRanges;

        private Format1Encoding() {
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.format + ", nRanges=" + this.nRanges + ", supplement=" + Arrays.toString(((CFFBuiltInEncoding) this).supplement) + "]";
        }
    }

    public static class Format2Charset extends EmbeddedCharset {
        private int format;
        private List<RangeMapping> rangesCID2GID;

        public Format2Charset(boolean z) {
            super(z);
        }

        @Override // com.tom_roush.fontbox.cff.CFFCharset
        public int getCIDForGID(int i2) {
            for (RangeMapping rangeMapping : this.rangesCID2GID) {
                if (rangeMapping.isInRange(i2)) {
                    return rangeMapping.mapValue(i2);
                }
            }
            return super.getCIDForGID(i2);
        }

        @Override // com.tom_roush.fontbox.cff.CFFCharset
        public int getGIDForCID(int i2) {
            for (RangeMapping rangeMapping : this.rangesCID2GID) {
                if (rangeMapping.isInReverseRange(i2)) {
                    return rangeMapping.mapReverseValue(i2);
                }
            }
            return super.getGIDForCID(i2);
        }

        public String toString() {
            return getClass().getName() + "[format=" + this.format + "]";
        }
    }

    public static final class Format3FDSelect extends FDSelect {
        private int format;
        private int nbRanges;
        private Range3[] range3;
        private int sentinel;

        @Override // com.tom_roush.fontbox.cff.FDSelect
        public int getFDIndex(int i2) {
            for (int i3 = 0; i3 < this.nbRanges; i3++) {
                if (this.range3[i3].first <= i2) {
                    int i4 = i3 + 1;
                    if (i4 >= this.nbRanges) {
                        if (this.sentinel > i2) {
                            return this.range3[i3].fd;
                        }
                        return -1;
                    }
                    if (this.range3[i4].first > i2) {
                        return this.range3[i3].fd;
                    }
                }
            }
            return 0;
        }

        public String toString() {
            return Format3FDSelect.class.getName() + "[format=" + this.format + " nbRanges=" + this.nbRanges + ", range3=" + Arrays.toString(this.range3) + " sentinel=" + this.sentinel + "]";
        }

        private Format3FDSelect(CFFCIDFont cFFCIDFont) {
            super(cFFCIDFont);
        }
    }

    public static class Header {
        private int hdrSize;
        private int major;
        private int minor;
        private int offSize;

        private Header() {
        }

        public String toString() {
            return getClass().getName() + "[major=" + this.major + ", minor=" + this.minor + ", hdrSize=" + this.hdrSize + ", offSize=" + this.offSize + "]";
        }
    }

    public static final class Range3 {
        private int fd;
        private int first;

        private Range3() {
        }

        public String toString() {
            return Range3.class.getName() + "[first=" + this.first + ", fd=" + this.fd + "]";
        }
    }

    public static final class RangeMapping {
        private final int endMappedValue;
        private final int endValue;
        private final int startMappedValue;
        private final int startValue;

        public boolean isInRange(int i2) {
            return i2 >= this.startValue && i2 <= this.endValue;
        }

        public boolean isInReverseRange(int i2) {
            return i2 >= this.startMappedValue && i2 <= this.endMappedValue;
        }

        public int mapReverseValue(int i2) {
            if (isInReverseRange(i2)) {
                return this.startValue + (i2 - this.startMappedValue);
            }
            return 0;
        }

        public int mapValue(int i2) {
            if (isInRange(i2)) {
                return this.startMappedValue + (i2 - this.startValue);
            }
            return 0;
        }

        public String toString() {
            return RangeMapping.class.getName() + "[start value=" + this.startValue + ", end value=" + this.endValue + ", start mapped-value=" + this.startMappedValue + ", end mapped-value=" + this.endMappedValue + "]";
        }

        private RangeMapping(int i2, int i3, int i4) {
            this.startValue = i2;
            this.endValue = i2 + i4;
            this.startMappedValue = i3;
            this.endMappedValue = i3 + i4;
        }
    }

    private void concatenateMatrix(List<Number> list, List<Number> list2) {
        double dDoubleValue = list.get(0).doubleValue();
        double dDoubleValue2 = list.get(1).doubleValue();
        double dDoubleValue3 = list.get(2).doubleValue();
        double dDoubleValue4 = list.get(3).doubleValue();
        double dDoubleValue5 = list.get(4).doubleValue();
        double dDoubleValue6 = list.get(5).doubleValue();
        double dDoubleValue7 = list2.get(0).doubleValue();
        double dDoubleValue8 = list2.get(1).doubleValue();
        double dDoubleValue9 = list2.get(2).doubleValue();
        double dDoubleValue10 = list2.get(3).doubleValue();
        double dDoubleValue11 = list2.get(4).doubleValue();
        double dDoubleValue12 = list2.get(5).doubleValue();
        list.set(0, Double.valueOf((dDoubleValue * dDoubleValue7) + (dDoubleValue2 * dDoubleValue9)));
        list.set(1, Double.valueOf((dDoubleValue * dDoubleValue8) + (dDoubleValue2 * dDoubleValue4)));
        list.set(2, Double.valueOf((dDoubleValue3 * dDoubleValue7) + (dDoubleValue4 * dDoubleValue9)));
        list.set(3, Double.valueOf((dDoubleValue3 * dDoubleValue8) + (dDoubleValue4 * dDoubleValue10)));
        list.set(4, Double.valueOf((dDoubleValue7 * dDoubleValue5) + (dDoubleValue9 * dDoubleValue6) + dDoubleValue11));
        list.set(5, Double.valueOf((dDoubleValue5 * dDoubleValue8) + (dDoubleValue6 * dDoubleValue10) + dDoubleValue12));
    }

    private CFFDataInput createTaggedCFFDataInput(CFFDataInput cFFDataInput, byte[] bArr) throws IOException {
        short s = cFFDataInput.readShort();
        cFFDataInput.readShort();
        cFFDataInput.readShort();
        cFFDataInput.readShort();
        for (int i2 = 0; i2 < s; i2++) {
            String tagName = readTagName(cFFDataInput);
            readLong(cFFDataInput);
            long j = readLong(cFFDataInput);
            long j2 = readLong(cFFDataInput);
            if (CFFTable.TAG.equals(tagName)) {
                return new CFFDataInput(Arrays.copyOfRange(bArr, (int) j, (int) (j + j2)));
            }
        }
        throw new IOException("CFF tag not found in this OpenType font.");
    }

    private String getString(DictData dictData, String str) {
        DictData.Entry entry = dictData.getEntry(str);
        if (entry == null || !entry.hasOperands()) {
            return null;
        }
        return readString(entry.getNumber(0).intValue());
    }

    private void parseCIDFontDicts(CFFDataInput cFFDataInput, DictData dictData, CFFCIDFont cFFCIDFont, int i2) throws IOException {
        DictData.Entry entry = dictData.getEntry("FDArray");
        if (entry == null || !entry.hasOperands()) {
            throw new IOException("FDArray is missing for a CIDKeyed Font.");
        }
        cFFDataInput.setPosition(entry.getNumber(0).intValue());
        byte[][] indexData = readIndexData(cFFDataInput);
        if (indexData == null) {
            throw new IOException("Font dict index is missing for a CIDKeyed Font");
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (byte[] bArr : indexData) {
            DictData dictData2 = readDictData(new CFFDataInput(bArr));
            DictData.Entry entry2 = dictData2.getEntry(StandardStructureTypes.PRIVATE);
            if (entry2 == null || entry2.size() < 2) {
                throw new IOException("Font DICT invalid without \"Private\" entry");
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(4);
            linkedHashMap.put(AFMParser.FONT_NAME, getString(dictData2, AFMParser.FONT_NAME));
            linkedHashMap.put("FontType", dictData2.getNumber("FontType", 0));
            linkedHashMap.put(AFMParser.FONT_BBOX, dictData2.getArray(AFMParser.FONT_BBOX, null));
            linkedHashMap.put("FontMatrix", dictData2.getArray("FontMatrix", null));
            linkedList2.add(linkedHashMap);
            int iIntValue = entry2.getNumber(1).intValue();
            cFFDataInput.setPosition(iIntValue);
            DictData dictData3 = readDictData(cFFDataInput, entry2.getNumber(0).intValue());
            Map<String, Object> privateDict = readPrivateDict(dictData3);
            linkedList.add(privateDict);
            Number number = dictData3.getNumber("Subrs", 0);
            if (number instanceof Integer) {
                Integer num = (Integer) number;
                if (num.intValue() > 0) {
                    cFFDataInput.setPosition(iIntValue + num.intValue());
                    privateDict.put("Subrs", readIndexData(cFFDataInput));
                }
            }
        }
        DictData.Entry entry3 = dictData.getEntry("FDSelect");
        if (entry3 == null || !entry3.hasOperands()) {
            throw new IOException("FDSelect is missing or empty");
        }
        cFFDataInput.setPosition(entry3.getNumber(0).intValue());
        FDSelect fDSelect = readFDSelect(cFFDataInput, i2, cFFCIDFont);
        cFFCIDFont.setFontDict(linkedList2);
        cFFCIDFont.setPrivDict(linkedList);
        cFFCIDFont.setFdSelect(fDSelect);
    }

    private CFFFont parseFont(CFFDataInput cFFDataInput, String str, byte[] bArr) throws IOException {
        CFFFont cFFType1Font;
        CFFCharset emptyCharset;
        DictData dictData = readDictData(new CFFDataInput(bArr));
        if (dictData.getEntry("SyntheticBase") != null) {
            throw new IOException("Synthetic Fonts are not supported");
        }
        boolean z = dictData.getEntry("ROS") != null;
        if (z) {
            CFFCIDFont cFFCIDFont = new CFFCIDFont();
            DictData.Entry entry = dictData.getEntry("ROS");
            if (entry == null || entry.size() < 3) {
                throw new IOException("ROS entry must have 3 elements");
            }
            cFFCIDFont.setRegistry(readString(entry.getNumber(0).intValue()));
            cFFCIDFont.setOrdering(readString(entry.getNumber(1).intValue()));
            cFFCIDFont.setSupplement(entry.getNumber(2).intValue());
            cFFType1Font = cFFCIDFont;
        } else {
            cFFType1Font = new CFFType1Font();
        }
        this.debugFontName = str;
        cFFType1Font.setName(str);
        cFFType1Font.addValueToTopDict("version", getString(dictData, "version"));
        cFFType1Font.addValueToTopDict(AFMParser.NOTICE, getString(dictData, AFMParser.NOTICE));
        cFFType1Font.addValueToTopDict("Copyright", getString(dictData, "Copyright"));
        cFFType1Font.addValueToTopDict(AFMParser.FULL_NAME, getString(dictData, AFMParser.FULL_NAME));
        cFFType1Font.addValueToTopDict(AFMParser.FAMILY_NAME, getString(dictData, AFMParser.FAMILY_NAME));
        cFFType1Font.addValueToTopDict(AFMParser.WEIGHT, getString(dictData, AFMParser.WEIGHT));
        cFFType1Font.addValueToTopDict("isFixedPitch", dictData.getBoolean("isFixedPitch", false));
        cFFType1Font.addValueToTopDict(AFMParser.ITALIC_ANGLE, dictData.getNumber(AFMParser.ITALIC_ANGLE, 0));
        cFFType1Font.addValueToTopDict(AFMParser.UNDERLINE_POSITION, dictData.getNumber(AFMParser.UNDERLINE_POSITION, -100));
        cFFType1Font.addValueToTopDict(AFMParser.UNDERLINE_THICKNESS, dictData.getNumber(AFMParser.UNDERLINE_THICKNESS, 50));
        cFFType1Font.addValueToTopDict("PaintType", dictData.getNumber("PaintType", 0));
        cFFType1Font.addValueToTopDict("CharstringType", dictData.getNumber("CharstringType", 2));
        cFFType1Font.addValueToTopDict("FontMatrix", dictData.getArray("FontMatrix", Arrays.asList(Double.valueOf(0.001d), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(0.001d), Double.valueOf(0.0d), Double.valueOf(0.0d))));
        cFFType1Font.addValueToTopDict("UniqueID", dictData.getNumber("UniqueID", null));
        cFFType1Font.addValueToTopDict(AFMParser.FONT_BBOX, dictData.getArray(AFMParser.FONT_BBOX, Arrays.asList(0, 0, 0, 0)));
        cFFType1Font.addValueToTopDict("StrokeWidth", dictData.getNumber("StrokeWidth", 0));
        cFFType1Font.addValueToTopDict("XUID", dictData.getArray("XUID", null));
        DictData.Entry entry2 = dictData.getEntry("CharStrings");
        if (entry2 == null || !entry2.hasOperands()) {
            throw new IOException("CharStrings is missing or empty");
        }
        cFFDataInput.setPosition(entry2.getNumber(0).intValue());
        byte[][] indexData = readIndexData(cFFDataInput);
        DictData.Entry entry3 = dictData.getEntry("charset");
        if (entry3 == null || !entry3.hasOperands()) {
            emptyCharset = z ? new EmptyCharset(indexData.length) : CFFISOAdobeCharset.getInstance();
        } else {
            int iIntValue = entry3.getNumber(0).intValue();
            if (!z && iIntValue == 0) {
                emptyCharset = CFFISOAdobeCharset.getInstance();
            } else if (!z && iIntValue == 1) {
                emptyCharset = CFFExpertCharset.getInstance();
            } else if (z || iIntValue != 2) {
                cFFDataInput.setPosition(iIntValue);
                emptyCharset = readCharset(cFFDataInput, indexData.length, z);
            } else {
                emptyCharset = CFFExpertSubsetCharset.getInstance();
            }
        }
        cFFType1Font.setCharset(emptyCharset);
        cFFType1Font.charStrings = indexData;
        if (z) {
            CFFCIDFont cFFCIDFont2 = (CFFCIDFont) cFFType1Font;
            parseCIDFontDicts(cFFDataInput, dictData, cFFCIDFont2, indexData.length);
            List<Map<String, Object>> fontDicts = cFFCIDFont2.getFontDicts();
            List<Number> list = (fontDicts.isEmpty() || !fontDicts.get(0).containsKey("FontMatrix")) ? null : (List) fontDicts.get(0).get("FontMatrix");
            List<Number> array = dictData.getArray("FontMatrix", null);
            if (array == null) {
                if (list != null) {
                    cFFType1Font.addValueToTopDict("FontMatrix", list);
                } else {
                    cFFType1Font.addValueToTopDict("FontMatrix", dictData.getArray("FontMatrix", Arrays.asList(Double.valueOf(0.001d), Double.valueOf(0.0d), Double.valueOf(0.0d), Double.valueOf(0.001d), Double.valueOf(0.0d), Double.valueOf(0.0d))));
                }
            } else if (list != null) {
                concatenateMatrix(array, list);
            }
        } else {
            parseType1Dicts(cFFDataInput, dictData, (CFFType1Font) cFFType1Font, emptyCharset);
        }
        return cFFType1Font;
    }

    private void parseType1Dicts(CFFDataInput cFFDataInput, DictData dictData, CFFType1Font cFFType1Font, CFFCharset cFFCharset) throws IOException {
        CFFEncoding cFFStandardEncoding;
        DictData.Entry entry = dictData.getEntry("Encoding");
        int iIntValue = (entry == null || !entry.hasOperands()) ? 0 : entry.getNumber(0).intValue();
        if (iIntValue == 0) {
            cFFStandardEncoding = CFFStandardEncoding.getInstance();
        } else if (iIntValue != 1) {
            cFFDataInput.setPosition(iIntValue);
            cFFStandardEncoding = readEncoding(cFFDataInput, cFFCharset);
        } else {
            cFFStandardEncoding = CFFExpertEncoding.getInstance();
        }
        cFFType1Font.setEncoding(cFFStandardEncoding);
        DictData.Entry entry2 = dictData.getEntry(StandardStructureTypes.PRIVATE);
        if (entry2 == null || entry2.size() < 2) {
            throw new IOException("Private dictionary entry missing for font " + cFFType1Font.fontName);
        }
        int iIntValue2 = entry2.getNumber(1).intValue();
        cFFDataInput.setPosition(iIntValue2);
        DictData dictData2 = readDictData(cFFDataInput, entry2.getNumber(0).intValue());
        for (Map.Entry<String, Object> entry3 : readPrivateDict(dictData2).entrySet()) {
            cFFType1Font.addToPrivateDict(entry3.getKey(), entry3.getValue());
        }
        Number number = dictData2.getNumber("Subrs", 0);
        if (number instanceof Integer) {
            Integer num = (Integer) number;
            if (num.intValue() > 0) {
                cFFDataInput.setPosition(iIntValue2 + num.intValue());
                cFFType1Font.addToPrivateDict("Subrs", readIndexData(cFFDataInput));
            }
        }
    }

    private CFFCharset readCharset(CFFDataInput cFFDataInput, int i2, boolean z) throws IOException {
        int card8 = cFFDataInput.readCard8();
        if (card8 == 0) {
            return readFormat0Charset(cFFDataInput, card8, i2, z);
        }
        if (card8 == 1) {
            return readFormat1Charset(cFFDataInput, card8, i2, z);
        }
        if (card8 == 2) {
            return readFormat2Charset(cFFDataInput, card8, i2, z);
        }
        throw new IllegalArgumentException();
    }

    private static DictData readDictData(CFFDataInput cFFDataInput) throws IOException {
        DictData dictData = new DictData();
        while (cFFDataInput.hasRemaining()) {
            dictData.add(readEntry(cFFDataInput));
        }
        return dictData;
    }

    private CFFEncoding readEncoding(CFFDataInput cFFDataInput, CFFCharset cFFCharset) throws IOException {
        int card8 = cFFDataInput.readCard8();
        int i2 = card8 & 127;
        if (i2 == 0) {
            return readFormat0Encoding(cFFDataInput, cFFCharset, card8);
        }
        if (i2 == 1) {
            return readFormat1Encoding(cFFDataInput, cFFCharset, card8);
        }
        throw new IllegalArgumentException();
    }

    private static DictData.Entry readEntry(CFFDataInput cFFDataInput) throws IOException {
        int unsignedByte;
        DictData.Entry entry = new DictData.Entry();
        while (true) {
            unsignedByte = cFFDataInput.readUnsignedByte();
            if (unsignedByte >= 0 && unsignedByte <= 21) {
                entry.operator = readOperator(cFFDataInput, unsignedByte);
                return entry;
            }
            if (unsignedByte == 28 || unsignedByte == 29) {
                entry.operands.add(readIntegerNumber(cFFDataInput, unsignedByte));
            } else if (unsignedByte == 30) {
                entry.operands.add(readRealNumber(cFFDataInput));
            } else {
                if (unsignedByte < 32 || unsignedByte > 254) {
                    break;
                }
                entry.operands.add(readIntegerNumber(cFFDataInput, unsignedByte));
            }
        }
        throw new IOException("invalid DICT data b0 byte: " + unsignedByte);
    }

    private static FDSelect readFDSelect(CFFDataInput cFFDataInput, int i2, CFFCIDFont cFFCIDFont) throws IOException {
        int card8 = cFFDataInput.readCard8();
        if (card8 == 0) {
            return readFormat0FDSelect(cFFDataInput, card8, i2, cFFCIDFont);
        }
        if (card8 == 3) {
            return readFormat3FDSelect(cFFDataInput, card8, i2, cFFCIDFont);
        }
        throw new IllegalArgumentException();
    }

    private Format0Charset readFormat0Charset(CFFDataInput cFFDataInput, int i2, int i3, boolean z) throws IOException {
        Format0Charset format0Charset = new Format0Charset(z);
        format0Charset.format = i2;
        if (z) {
            format0Charset.addCID(0, 0);
        } else {
            format0Charset.addSID(0, 0, ".notdef");
        }
        for (int i4 = 1; i4 < i3; i4++) {
            int sid = cFFDataInput.readSID();
            if (z) {
                format0Charset.addCID(i4, sid);
            } else {
                format0Charset.addSID(i4, sid, readString(sid));
            }
        }
        return format0Charset;
    }

    private Format0Encoding readFormat0Encoding(CFFDataInput cFFDataInput, CFFCharset cFFCharset, int i2) throws IOException {
        Format0Encoding format0Encoding = new Format0Encoding();
        format0Encoding.format = i2;
        format0Encoding.nCodes = cFFDataInput.readCard8();
        format0Encoding.add(0, 0, ".notdef");
        for (int i3 = 1; i3 <= format0Encoding.nCodes; i3++) {
            int card8 = cFFDataInput.readCard8();
            int sIDForGID = cFFCharset.getSIDForGID(i3);
            format0Encoding.add(card8, sIDForGID, readString(sIDForGID));
        }
        if ((i2 & 128) != 0) {
            readSupplement(cFFDataInput, format0Encoding);
        }
        return format0Encoding;
    }

    private static Format0FDSelect readFormat0FDSelect(CFFDataInput cFFDataInput, int i2, int i3, CFFCIDFont cFFCIDFont) throws IOException {
        Format0FDSelect format0FDSelect = new Format0FDSelect(cFFCIDFont);
        format0FDSelect.format = i2;
        format0FDSelect.fds = new int[i3];
        for (int i4 = 0; i4 < format0FDSelect.fds.length; i4++) {
            format0FDSelect.fds[i4] = cFFDataInput.readCard8();
        }
        return format0FDSelect;
    }

    private Format1Charset readFormat1Charset(CFFDataInput cFFDataInput, int i2, int i3, boolean z) throws IOException {
        Format1Charset format1Charset = new Format1Charset(z);
        format1Charset.format = i2;
        if (z) {
            format1Charset.addCID(0, 0);
            format1Charset.rangesCID2GID = new ArrayList();
        } else {
            format1Charset.addSID(0, 0, ".notdef");
        }
        int i4 = 1;
        while (i4 < i3) {
            int sid = cFFDataInput.readSID();
            int card8 = cFFDataInput.readCard8();
            if (z) {
                format1Charset.rangesCID2GID.add(new RangeMapping(i4, sid, card8));
            } else {
                for (int i5 = 0; i5 < card8 + 1; i5++) {
                    int i6 = sid + i5;
                    format1Charset.addSID(i4 + i5, i6, readString(i6));
                }
            }
            i4 = i4 + card8 + 1;
        }
        return format1Charset;
    }

    private Format1Encoding readFormat1Encoding(CFFDataInput cFFDataInput, CFFCharset cFFCharset, int i2) throws IOException {
        Format1Encoding format1Encoding = new Format1Encoding();
        format1Encoding.format = i2;
        format1Encoding.nRanges = cFFDataInput.readCard8();
        format1Encoding.add(0, 0, ".notdef");
        int i3 = 1;
        for (int i4 = 0; i4 < format1Encoding.nRanges; i4++) {
            int card8 = cFFDataInput.readCard8();
            int card82 = cFFDataInput.readCard8();
            for (int i5 = 0; i5 <= card82; i5++) {
                int sIDForGID = cFFCharset.getSIDForGID(i3);
                format1Encoding.add(card8 + i5, sIDForGID, readString(sIDForGID));
                i3++;
            }
        }
        if ((i2 & 128) != 0) {
            readSupplement(cFFDataInput, format1Encoding);
        }
        return format1Encoding;
    }

    private Format2Charset readFormat2Charset(CFFDataInput cFFDataInput, int i2, int i3, boolean z) throws IOException {
        Format2Charset format2Charset = new Format2Charset(z);
        format2Charset.format = i2;
        if (z) {
            format2Charset.addCID(0, 0);
            format2Charset.rangesCID2GID = new ArrayList();
        } else {
            format2Charset.addSID(0, 0, ".notdef");
        }
        int i4 = 1;
        while (i4 < i3) {
            int sid = cFFDataInput.readSID();
            int card16 = cFFDataInput.readCard16();
            if (z) {
                format2Charset.rangesCID2GID.add(new RangeMapping(i4, sid, card16));
            } else {
                for (int i5 = 0; i5 < card16 + 1; i5++) {
                    int i6 = sid + i5;
                    format2Charset.addSID(i4 + i5, i6, readString(i6));
                }
            }
            i4 = i4 + card16 + 1;
        }
        return format2Charset;
    }

    private static Format3FDSelect readFormat3FDSelect(CFFDataInput cFFDataInput, int i2, int i3, CFFCIDFont cFFCIDFont) throws IOException {
        Format3FDSelect format3FDSelect = new Format3FDSelect(cFFCIDFont);
        format3FDSelect.format = i2;
        format3FDSelect.nbRanges = cFFDataInput.readCard16();
        format3FDSelect.range3 = new Range3[format3FDSelect.nbRanges];
        for (int i4 = 0; i4 < format3FDSelect.nbRanges; i4++) {
            Range3 range3 = new Range3();
            range3.first = cFFDataInput.readCard16();
            range3.fd = cFFDataInput.readCard8();
            format3FDSelect.range3[i4] = range3;
        }
        format3FDSelect.sentinel = cFFDataInput.readCard16();
        return format3FDSelect;
    }

    private static Header readHeader(CFFDataInput cFFDataInput) throws IOException {
        Header header = new Header();
        header.major = cFFDataInput.readCard8();
        header.minor = cFFDataInput.readCard8();
        header.hdrSize = cFFDataInput.readCard8();
        header.offSize = cFFDataInput.readOffSize();
        return header;
    }

    private static byte[][] readIndexData(CFFDataInput cFFDataInput) throws IOException {
        int[] indexDataOffsets = readIndexDataOffsets(cFFDataInput);
        if (indexDataOffsets == null) {
            return null;
        }
        int length = indexDataOffsets.length - 1;
        byte[][] bArr = new byte[length][];
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            bArr[i2] = cFFDataInput.readBytes(indexDataOffsets[i3] - indexDataOffsets[i2]);
            i2 = i3;
        }
        return bArr;
    }

    private static int[] readIndexDataOffsets(CFFDataInput cFFDataInput) throws IOException {
        int card16 = cFFDataInput.readCard16();
        if (card16 == 0) {
            return null;
        }
        int offSize = cFFDataInput.readOffSize();
        int[] iArr = new int[card16 + 1];
        for (int i2 = 0; i2 <= card16; i2++) {
            int offset = cFFDataInput.readOffset(offSize);
            if (offset > cFFDataInput.length()) {
                throw new IOException("illegal offset value " + offset + " in CFF font");
            }
            iArr[i2] = offset;
        }
        return iArr;
    }

    private static Integer readIntegerNumber(CFFDataInput cFFDataInput, int i2) throws IOException {
        if (i2 == 28) {
            return Integer.valueOf(cFFDataInput.readShort());
        }
        if (i2 == 29) {
            return Integer.valueOf(cFFDataInput.readInt());
        }
        if (i2 >= 32 && i2 <= 246) {
            return Integer.valueOf(i2 - 139);
        }
        if (i2 >= 247 && i2 <= 250) {
            return Integer.valueOf(((i2 - 247) * 256) + cFFDataInput.readUnsignedByte() + 108);
        }
        if (i2 < 251 || i2 > 254) {
            throw new IllegalArgumentException();
        }
        return Integer.valueOf((((-(i2 - 251)) * 256) - cFFDataInput.readUnsignedByte()) - 108);
    }

    private static long readLong(CFFDataInput cFFDataInput) throws IOException {
        return cFFDataInput.readCard16() | (cFFDataInput.readCard16() << 16);
    }

    private static CFFOperator readOperator(CFFDataInput cFFDataInput, int i2) throws IOException {
        return CFFOperator.getOperator(readOperatorKey(cFFDataInput, i2));
    }

    private static CFFOperator.Key readOperatorKey(CFFDataInput cFFDataInput, int i2) throws IOException {
        return i2 == 12 ? new CFFOperator.Key(i2, cFFDataInput.readUnsignedByte()) : new CFFOperator.Key(i2);
    }

    private Map<String, Object> readPrivateDict(DictData dictData) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(17);
        linkedHashMap.put("BlueValues", dictData.getDelta("BlueValues", null));
        linkedHashMap.put("OtherBlues", dictData.getDelta("OtherBlues", null));
        linkedHashMap.put("FamilyBlues", dictData.getDelta("FamilyBlues", null));
        linkedHashMap.put("FamilyOtherBlues", dictData.getDelta("FamilyOtherBlues", null));
        linkedHashMap.put("BlueScale", dictData.getNumber("BlueScale", Double.valueOf(0.039625d)));
        linkedHashMap.put("BlueShift", dictData.getNumber("BlueShift", 7));
        linkedHashMap.put("BlueFuzz", dictData.getNumber("BlueFuzz", 1));
        linkedHashMap.put(AFMParser.STD_HW, dictData.getNumber(AFMParser.STD_HW, null));
        linkedHashMap.put(AFMParser.STD_VW, dictData.getNumber(AFMParser.STD_VW, null));
        linkedHashMap.put("StemSnapH", dictData.getDelta("StemSnapH", null));
        linkedHashMap.put("StemSnapV", dictData.getDelta("StemSnapV", null));
        linkedHashMap.put("ForceBold", dictData.getBoolean("ForceBold", false));
        linkedHashMap.put("LanguageGroup", dictData.getNumber("LanguageGroup", 0));
        linkedHashMap.put("ExpansionFactor", dictData.getNumber("ExpansionFactor", Double.valueOf(0.06d)));
        linkedHashMap.put("initialRandomSeed", dictData.getNumber("initialRandomSeed", 0));
        linkedHashMap.put("defaultWidthX", dictData.getNumber("defaultWidthX", 0));
        linkedHashMap.put("nominalWidthX", dictData.getNumber("nominalWidthX", 0));
        return linkedHashMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static Double readRealNumber(CFFDataInput cFFDataInput) throws IOException {
        StringBuilder sb = new StringBuilder();
        int[] iArr = new int[2];
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (!z) {
            int unsignedByte = cFFDataInput.readUnsignedByte();
            iArr[0] = unsignedByte / 16;
            iArr[1] = unsignedByte % 16;
            for (int i2 = 0; i2 < 2; i2++) {
                int i3 = iArr[i2];
                switch (i3) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        sb.append(i3);
                        z2 = false;
                        break;
                    case 10:
                        sb.append(Consts.DOT);
                        break;
                    case 11:
                        if (z3) {
                            Log.w("PdfBox-Android", "duplicate 'E' ignored after " + ((Object) sb));
                        } else {
                            sb.append("E");
                            z2 = true;
                            z3 = true;
                        }
                        break;
                    case 12:
                        if (z3) {
                            Log.w("PdfBox-Android", "duplicate 'E-' ignored after " + ((Object) sb));
                        } else {
                            sb.append("E-");
                            z2 = true;
                            z3 = true;
                        }
                        break;
                    case 13:
                        break;
                    case 14:
                        sb.append("-");
                        break;
                    case 15:
                        z = true;
                        break;
                    default:
                        throw new IllegalArgumentException("illegal nibble " + i3);
                }
            }
        }
        if (z2) {
            sb.append("0");
        }
        if (sb.length() == 0) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(sb.toString());
        } catch (NumberFormatException e2) {
            throw new IOException(e2);
        }
    }

    private String readString(int i2) {
        if (i2 >= 0 && i2 <= 390) {
            return CFFStandardString.getName(i2);
        }
        int i3 = i2 - 391;
        String[] strArr = this.stringIndex;
        if (i3 < strArr.length) {
            return strArr[i3];
        }
        return "SID" + i2;
    }

    private static String[] readStringIndexData(CFFDataInput cFFDataInput) throws IOException {
        int[] indexDataOffsets = readIndexDataOffsets(cFFDataInput);
        if (indexDataOffsets == null) {
            return null;
        }
        int length = indexDataOffsets.length - 1;
        String[] strArr = new String[length];
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int i4 = indexDataOffsets[i3] - indexDataOffsets[i2];
            if (i4 < 0) {
                throw new IOException("Negative index data length + " + i4 + " at " + i2 + ": offsets[" + i3 + "]=" + indexDataOffsets[i3] + ", offsets[" + i2 + "]=" + indexDataOffsets[i2]);
            }
            strArr[i2] = new String(cFFDataInput.readBytes(i4), Charsets.ISO_8859_1);
            i2 = i3;
        }
        return strArr;
    }

    private void readSupplement(CFFDataInput cFFDataInput, CFFBuiltInEncoding cFFBuiltInEncoding) throws IOException {
        cFFBuiltInEncoding.nSups = cFFDataInput.readCard8();
        cFFBuiltInEncoding.supplement = new CFFBuiltInEncoding.Supplement[cFFBuiltInEncoding.nSups];
        for (int i2 = 0; i2 < cFFBuiltInEncoding.supplement.length; i2++) {
            CFFBuiltInEncoding.Supplement supplement = new CFFBuiltInEncoding.Supplement();
            supplement.code = cFFDataInput.readCard8();
            supplement.sid = cFFDataInput.readSID();
            supplement.name = readString(supplement.sid);
            cFFBuiltInEncoding.supplement[i2] = supplement;
            cFFBuiltInEncoding.add(supplement.code, supplement.sid, readString(supplement.sid));
        }
    }

    private static String readTagName(CFFDataInput cFFDataInput) throws IOException {
        return new String(cFFDataInput.readBytes(4), Charsets.ISO_8859_1);
    }

    public List<CFFFont> parse(byte[] bArr, ByteSource byteSource) throws IOException {
        this.source = byteSource;
        return parse(bArr);
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + this.debugFontName + "]";
    }

    public List<CFFFont> parse(byte[] bArr) throws IOException {
        CFFDataInput cFFDataInput = new CFFDataInput(bArr);
        String tagName = readTagName(cFFDataInput);
        if (TAG_OTTO.equals(tagName)) {
            cFFDataInput = createTaggedCFFDataInput(cFFDataInput, bArr);
        } else if (!TAG_TTCF.equals(tagName)) {
            if (!TAG_TTFONLY.equals(tagName)) {
                cFFDataInput.setPosition(0);
            } else {
                throw new IOException("OpenType fonts containing a true type font are not supported.");
            }
        } else {
            throw new IOException("True Type Collection fonts are not supported.");
        }
        readHeader(cFFDataInput);
        String[] stringIndexData = readStringIndexData(cFFDataInput);
        if (stringIndexData != null) {
            byte[][] indexData = readIndexData(cFFDataInput);
            this.stringIndex = readStringIndexData(cFFDataInput);
            byte[][] indexData2 = readIndexData(cFFDataInput);
            ArrayList arrayList = new ArrayList(stringIndexData.length);
            for (int i2 = 0; i2 < stringIndexData.length; i2++) {
                CFFFont font = parseFont(cFFDataInput, stringIndexData[i2], indexData[i2]);
                font.setGlobalSubrIndex(indexData2);
                font.setData(this.source);
                arrayList.add(font);
            }
            return arrayList;
        }
        throw new IOException("Name index missing in CFF font");
    }

    private static DictData readDictData(CFFDataInput cFFDataInput, int i2) throws IOException {
        DictData dictData = new DictData();
        int position = cFFDataInput.getPosition() + i2;
        while (cFFDataInput.getPosition() < position) {
            dictData.add(readEntry(cFFDataInput));
        }
        return dictData;
    }
}
