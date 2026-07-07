package com.tom_roush.fontbox.ttf;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class GlyphSubstitutionTable extends TTFTable {
    public static final String TAG = "GSUB";
    private FeatureRecord[] featureList;
    private String lastUsedSupportedScript;
    private final Map<Integer, Integer> lookupCache;
    private LookupTable[] lookupList;
    private final Map<Integer, Integer> reverseLookup;
    private LinkedHashMap<String, ScriptTable> scriptList;

    public static abstract class CoverageTable {
        public int coverageFormat;

        public abstract int getCoverageIndex(int i2);
    }

    public static class CoverageTableFormat1 extends CoverageTable {
        public int[] glyphArray;

        @Override // com.tom_roush.fontbox.ttf.GlyphSubstitutionTable.CoverageTable
        public int getCoverageIndex(int i2) {
            return Arrays.binarySearch(this.glyphArray, i2);
        }

        public String toString() {
            return String.format("CoverageTableFormat1[coverageFormat=%d,glyphArray=%s]", Integer.valueOf(this.coverageFormat), Arrays.toString(this.glyphArray));
        }
    }

    public static class CoverageTableFormat2 extends CoverageTable {
        public RangeRecord[] rangeRecords;

        @Override // com.tom_roush.fontbox.ttf.GlyphSubstitutionTable.CoverageTable
        public int getCoverageIndex(int i2) {
            for (RangeRecord rangeRecord : this.rangeRecords) {
                int i3 = rangeRecord.startGlyphID;
                if (i3 <= i2 && i2 <= rangeRecord.endGlyphID) {
                    return (rangeRecord.startCoverageIndex + i2) - i3;
                }
            }
            return -1;
        }

        public String toString() {
            return String.format("CoverageTableFormat2[coverageFormat=%d]", Integer.valueOf(this.coverageFormat));
        }
    }

    public static class FeatureRecord {
        public FeatureTable featureTable;
        public String featureTag;

        public String toString() {
            return String.format("FeatureRecord[featureTag=%s]", this.featureTag);
        }
    }

    public static class FeatureTable {
        public int[] lookupListIndices;

        public String toString() {
            return String.format("FeatureTable[lookupListIndiciesCount=%d]", Integer.valueOf(this.lookupListIndices.length));
        }
    }

    public static class LangSysRecord {
        public LangSysTable langSysTable;
        public String langSysTag;

        public String toString() {
            return String.format("LangSysRecord[langSysTag=%s]", this.langSysTag);
        }
    }

    public static class LangSysTable {
        public int[] featureIndices;
        public int requiredFeatureIndex;

        public String toString() {
            return String.format("LangSysTable[requiredFeatureIndex=%d]", Integer.valueOf(this.requiredFeatureIndex));
        }
    }

    public static abstract class LookupSubTable {
        public CoverageTable coverageTable;
        public int substFormat;

        public abstract int doSubstitution(int i2, int i3);
    }

    public static class LookupTable {
        public int lookupFlag;
        public int lookupType;
        public int markFilteringSet;
        public LookupSubTable[] subTables;

        public String toString() {
            return String.format("LookupTable[lookupType=%d,lookupFlag=%d,markFilteringSet=%d]", Integer.valueOf(this.lookupType), Integer.valueOf(this.lookupFlag), Integer.valueOf(this.markFilteringSet));
        }
    }

    public static class LookupTypeSingleSubstFormat1 extends LookupSubTable {
        public short deltaGlyphID;

        @Override // com.tom_roush.fontbox.ttf.GlyphSubstitutionTable.LookupSubTable
        public int doSubstitution(int i2, int i3) {
            return i3 < 0 ? i2 : i2 + this.deltaGlyphID;
        }

        public String toString() {
            return String.format("LookupTypeSingleSubstFormat1[substFormat=%d,deltaGlyphID=%d]", Integer.valueOf(this.substFormat), Short.valueOf(this.deltaGlyphID));
        }
    }

    public static class LookupTypeSingleSubstFormat2 extends LookupSubTable {
        public int[] substituteGlyphIDs;

        @Override // com.tom_roush.fontbox.ttf.GlyphSubstitutionTable.LookupSubTable
        public int doSubstitution(int i2, int i3) {
            return i3 < 0 ? i2 : this.substituteGlyphIDs[i3];
        }

        public String toString() {
            return String.format("LookupTypeSingleSubstFormat2[substFormat=%d,substituteGlyphIDs=%s]", Integer.valueOf(this.substFormat), Arrays.toString(this.substituteGlyphIDs));
        }
    }

    public static class RangeRecord {
        public int endGlyphID;
        public int startCoverageIndex;
        public int startGlyphID;

        public String toString() {
            return String.format("RangeRecord[startGlyphID=%d,endGlyphID=%d,startCoverageIndex=%d]", Integer.valueOf(this.startGlyphID), Integer.valueOf(this.endGlyphID), Integer.valueOf(this.startCoverageIndex));
        }
    }

    public static class ScriptRecord {
        public ScriptTable scriptTable;
        public String scriptTag;

        public String toString() {
            return String.format("ScriptRecord[scriptTag=%s]", this.scriptTag);
        }
    }

    public static class ScriptTable {
        public LangSysTable defaultLangSysTable;
        public LinkedHashMap<String, LangSysTable> langSysTables;

        public String toString() {
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.defaultLangSysTable != null);
            objArr[1] = Integer.valueOf(this.langSysTables.size());
            return String.format("ScriptTable[hasDefault=%s,langSysRecordsCount=%d]", objArr);
        }
    }

    public GlyphSubstitutionTable(TrueTypeFont trueTypeFont) {
        super(trueTypeFont);
        this.lookupCache = new HashMap();
        this.reverseLookup = new HashMap();
    }

    private int applyFeature(FeatureRecord featureRecord, int i2) {
        for (int i3 : featureRecord.featureTable.lookupListIndices) {
            LookupTable lookupTable = this.lookupList[i3];
            if (lookupTable.lookupType != 1) {
                Log.d("PdfBox-Android", "Skipping GSUB feature '" + featureRecord.featureTag + "' because it requires unsupported lookup table type " + lookupTable.lookupType);
            } else {
                i2 = doLookup(lookupTable, i2);
            }
        }
        return i2;
    }

    private boolean containsFeature(List<FeatureRecord> list, String str) {
        Iterator<FeatureRecord> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().featureTag.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int doLookup(LookupTable lookupTable, int i2) {
        for (LookupSubTable lookupSubTable : lookupTable.subTables) {
            int coverageIndex = lookupSubTable.coverageTable.getCoverageIndex(i2);
            if (coverageIndex >= 0) {
                return lookupSubTable.doSubstitution(i2, coverageIndex);
            }
        }
        return i2;
    }

    private List<FeatureRecord> getFeatureRecords(Collection<LangSysTable> collection, final List<String> list) {
        if (collection.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (LangSysTable langSysTable : collection) {
            int i2 = langSysTable.requiredFeatureIndex;
            if (i2 != 65535) {
                FeatureRecord[] featureRecordArr = this.featureList;
                if (i2 < featureRecordArr.length) {
                    arrayList.add(featureRecordArr[i2]);
                }
            }
            for (int i3 : langSysTable.featureIndices) {
                FeatureRecord[] featureRecordArr2 = this.featureList;
                if (i3 < featureRecordArr2.length && (list == null || list.contains(featureRecordArr2[i3].featureTag))) {
                    arrayList.add(this.featureList[i3]);
                }
            }
        }
        if (containsFeature(arrayList, "vrt2")) {
            removeFeature(arrayList, "vert");
        }
        if (list != null && arrayList.size() > 1) {
            Collections.sort(arrayList, new Comparator<FeatureRecord>() { // from class: com.tom_roush.fontbox.ttf.GlyphSubstitutionTable.1
                @Override // java.util.Comparator
                public int compare(FeatureRecord featureRecord, FeatureRecord featureRecord2) {
                    int iIndexOf = list.indexOf(featureRecord.featureTag);
                    int iIndexOf2 = list.indexOf(featureRecord2.featureTag);
                    if (iIndexOf < iIndexOf2) {
                        return -1;
                    }
                    return iIndexOf == iIndexOf2 ? 0 : 1;
                }
            });
        }
        return arrayList;
    }

    private Collection<LangSysTable> getLangSysTables(String str) {
        List listEmptyList = Collections.emptyList();
        ScriptTable scriptTable = this.scriptList.get(str);
        if (scriptTable == null) {
            return listEmptyList;
        }
        if (scriptTable.defaultLangSysTable == null) {
            return scriptTable.langSysTables.values();
        }
        ArrayList arrayList = new ArrayList(scriptTable.langSysTables.values());
        arrayList.add(scriptTable.defaultLangSysTable);
        return arrayList;
    }

    private void removeFeature(List<FeatureRecord> list, String str) {
        Iterator<FeatureRecord> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().featureTag.equals(str)) {
                it.remove();
            }
        }
    }

    private String selectScriptTag(String[] strArr) {
        if (strArr.length == 1) {
            String str = strArr[0];
            if (OpenTypeScript.INHERITED.equals(str) || (OpenTypeScript.TAG_DEFAULT.equals(str) && !this.scriptList.containsKey(str))) {
                if (this.lastUsedSupportedScript == null) {
                    this.lastUsedSupportedScript = this.scriptList.keySet().iterator().next();
                }
                return this.lastUsedSupportedScript;
            }
        }
        for (String str2 : strArr) {
            if (this.scriptList.containsKey(str2)) {
                this.lastUsedSupportedScript = str2;
                return str2;
            }
        }
        return strArr[0];
    }

    public int getSubstitution(int i2, String[] strArr, List<String> list) {
        if (i2 == -1) {
            return -1;
        }
        Integer num = this.lookupCache.get(Integer.valueOf(i2));
        if (num != null) {
            return num.intValue();
        }
        Iterator<FeatureRecord> it = getFeatureRecords(getLangSysTables(selectScriptTag(strArr)), list).iterator();
        int iApplyFeature = i2;
        while (it.hasNext()) {
            iApplyFeature = applyFeature(it.next(), iApplyFeature);
        }
        this.lookupCache.put(Integer.valueOf(i2), Integer.valueOf(iApplyFeature));
        this.reverseLookup.put(Integer.valueOf(iApplyFeature), Integer.valueOf(i2));
        return iApplyFeature;
    }

    public int getUnsubstitution(int i2) {
        Integer num = this.reverseLookup.get(Integer.valueOf(i2));
        if (num != null) {
            return num.intValue();
        }
        Log.w("PdfBox-Android", "Trying to un-substitute a never-before-seen gid: " + i2);
        return i2;
    }

    @Override // com.tom_roush.fontbox.ttf.TTFTable
    public void read(TrueTypeFont trueTypeFont, TTFDataStream tTFDataStream) throws IOException {
        long currentPosition = tTFDataStream.getCurrentPosition();
        tTFDataStream.readUnsignedShort();
        int unsignedShort = tTFDataStream.readUnsignedShort();
        int unsignedShort2 = tTFDataStream.readUnsignedShort();
        int unsignedShort3 = tTFDataStream.readUnsignedShort();
        int unsignedShort4 = tTFDataStream.readUnsignedShort();
        if (unsignedShort == 1) {
            tTFDataStream.readUnsignedInt();
        }
        this.scriptList = readScriptList(tTFDataStream, ((long) unsignedShort2) + currentPosition);
        this.featureList = readFeatureList(tTFDataStream, ((long) unsignedShort3) + currentPosition);
        this.lookupList = readLookupList(tTFDataStream, currentPosition + ((long) unsignedShort4));
    }

    public CoverageTable readCoverageTable(TTFDataStream tTFDataStream, long j) throws IOException {
        tTFDataStream.seek(j);
        int unsignedShort = tTFDataStream.readUnsignedShort();
        int i2 = 0;
        if (unsignedShort == 1) {
            CoverageTableFormat1 coverageTableFormat1 = new CoverageTableFormat1();
            coverageTableFormat1.coverageFormat = unsignedShort;
            int unsignedShort2 = tTFDataStream.readUnsignedShort();
            coverageTableFormat1.glyphArray = new int[unsignedShort2];
            while (i2 < unsignedShort2) {
                coverageTableFormat1.glyphArray[i2] = tTFDataStream.readUnsignedShort();
                i2++;
            }
            return coverageTableFormat1;
        }
        if (unsignedShort != 2) {
            throw new IOException("Unknown coverage format: " + unsignedShort);
        }
        CoverageTableFormat2 coverageTableFormat2 = new CoverageTableFormat2();
        coverageTableFormat2.coverageFormat = unsignedShort;
        int unsignedShort3 = tTFDataStream.readUnsignedShort();
        coverageTableFormat2.rangeRecords = new RangeRecord[unsignedShort3];
        while (i2 < unsignedShort3) {
            coverageTableFormat2.rangeRecords[i2] = readRangeRecord(tTFDataStream);
            i2++;
        }
        return coverageTableFormat2;
    }

    public FeatureRecord[] readFeatureList(TTFDataStream tTFDataStream, long j) throws IOException {
        tTFDataStream.seek(j);
        int unsignedShort = tTFDataStream.readUnsignedShort();
        FeatureRecord[] featureRecordArr = new FeatureRecord[unsignedShort];
        int[] iArr = new int[unsignedShort];
        String str = "";
        for (int i2 = 0; i2 < unsignedShort; i2++) {
            FeatureRecord featureRecord = new FeatureRecord();
            String string = tTFDataStream.readString(4);
            featureRecord.featureTag = string;
            if (i2 > 0 && string.compareTo(str) < 0) {
                if (!featureRecord.featureTag.matches("\\w{4}") || !str.matches("\\w{4}")) {
                    Log.w("PdfBox-Android", "FeatureRecord array not alphabetically sorted by FeatureTag: " + featureRecord.featureTag + " < " + str);
                    return new FeatureRecord[0];
                }
                Log.d("PdfBox-Android", "FeatureRecord array not alphabetically sorted by FeatureTag: " + featureRecord.featureTag + " < " + str);
            }
            iArr[i2] = tTFDataStream.readUnsignedShort();
            featureRecordArr[i2] = featureRecord;
            str = featureRecord.featureTag;
        }
        for (int i3 = 0; i3 < unsignedShort; i3++) {
            featureRecordArr[i3].featureTable = readFeatureTable(tTFDataStream, ((long) iArr[i3]) + j);
        }
        return featureRecordArr;
    }

    public FeatureTable readFeatureTable(TTFDataStream tTFDataStream, long j) throws IOException {
        tTFDataStream.seek(j);
        FeatureTable featureTable = new FeatureTable();
        tTFDataStream.readUnsignedShort();
        int unsignedShort = tTFDataStream.readUnsignedShort();
        featureTable.lookupListIndices = new int[unsignedShort];
        for (int i2 = 0; i2 < unsignedShort; i2++) {
            featureTable.lookupListIndices[i2] = tTFDataStream.readUnsignedShort();
        }
        return featureTable;
    }

    public LangSysTable readLangSysTable(TTFDataStream tTFDataStream, long j) throws IOException {
        tTFDataStream.seek(j);
        LangSysTable langSysTable = new LangSysTable();
        tTFDataStream.readUnsignedShort();
        langSysTable.requiredFeatureIndex = tTFDataStream.readUnsignedShort();
        int unsignedShort = tTFDataStream.readUnsignedShort();
        langSysTable.featureIndices = new int[unsignedShort];
        for (int i2 = 0; i2 < unsignedShort; i2++) {
            langSysTable.featureIndices[i2] = tTFDataStream.readUnsignedShort();
        }
        return langSysTable;
    }

    public LookupTable[] readLookupList(TTFDataStream tTFDataStream, long j) throws IOException {
        tTFDataStream.seek(j);
        int unsignedShort = tTFDataStream.readUnsignedShort();
        int[] iArr = new int[unsignedShort];
        for (int i2 = 0; i2 < unsignedShort; i2++) {
            iArr[i2] = tTFDataStream.readUnsignedShort();
        }
        LookupTable[] lookupTableArr = new LookupTable[unsignedShort];
        for (int i3 = 0; i3 < unsignedShort; i3++) {
            lookupTableArr[i3] = readLookupTable(tTFDataStream, ((long) iArr[i3]) + j);
        }
        return lookupTableArr;
    }

    public LookupSubTable readLookupSubTable(TTFDataStream tTFDataStream, long j) throws IOException {
        tTFDataStream.seek(j);
        int unsignedShort = tTFDataStream.readUnsignedShort();
        if (unsignedShort == 1) {
            LookupTypeSingleSubstFormat1 lookupTypeSingleSubstFormat1 = new LookupTypeSingleSubstFormat1();
            lookupTypeSingleSubstFormat1.substFormat = unsignedShort;
            int unsignedShort2 = tTFDataStream.readUnsignedShort();
            lookupTypeSingleSubstFormat1.deltaGlyphID = tTFDataStream.readSignedShort();
            lookupTypeSingleSubstFormat1.coverageTable = readCoverageTable(tTFDataStream, j + ((long) unsignedShort2));
            return lookupTypeSingleSubstFormat1;
        }
        if (unsignedShort != 2) {
            throw new IOException("Unknown substFormat: " + unsignedShort);
        }
        LookupTypeSingleSubstFormat2 lookupTypeSingleSubstFormat2 = new LookupTypeSingleSubstFormat2();
        lookupTypeSingleSubstFormat2.substFormat = unsignedShort;
        int unsignedShort3 = tTFDataStream.readUnsignedShort();
        int unsignedShort4 = tTFDataStream.readUnsignedShort();
        lookupTypeSingleSubstFormat2.substituteGlyphIDs = new int[unsignedShort4];
        for (int i2 = 0; i2 < unsignedShort4; i2++) {
            lookupTypeSingleSubstFormat2.substituteGlyphIDs[i2] = tTFDataStream.readUnsignedShort();
        }
        lookupTypeSingleSubstFormat2.coverageTable = readCoverageTable(tTFDataStream, j + ((long) unsignedShort3));
        return lookupTypeSingleSubstFormat2;
    }

    public LookupTable readLookupTable(TTFDataStream tTFDataStream, long j) throws IOException {
        tTFDataStream.seek(j);
        LookupTable lookupTable = new LookupTable();
        lookupTable.lookupType = tTFDataStream.readUnsignedShort();
        lookupTable.lookupFlag = tTFDataStream.readUnsignedShort();
        int unsignedShort = tTFDataStream.readUnsignedShort();
        int[] iArr = new int[unsignedShort];
        for (int i2 = 0; i2 < unsignedShort; i2++) {
            iArr[i2] = tTFDataStream.readUnsignedShort();
        }
        if ((lookupTable.lookupFlag & 16) != 0) {
            lookupTable.markFilteringSet = tTFDataStream.readUnsignedShort();
        }
        lookupTable.subTables = new LookupSubTable[unsignedShort];
        if (lookupTable.lookupType != 1) {
            Log.d("PdfBox-Android", "Type " + lookupTable.lookupType + " GSUB lookup table is not supported and will be ignored");
        } else {
            for (int i3 = 0; i3 < unsignedShort; i3++) {
                lookupTable.subTables[i3] = readLookupSubTable(tTFDataStream, ((long) iArr[i3]) + j);
            }
        }
        return lookupTable;
    }

    public RangeRecord readRangeRecord(TTFDataStream tTFDataStream) throws IOException {
        RangeRecord rangeRecord = new RangeRecord();
        rangeRecord.startGlyphID = tTFDataStream.readUnsignedShort();
        rangeRecord.endGlyphID = tTFDataStream.readUnsignedShort();
        rangeRecord.startCoverageIndex = tTFDataStream.readUnsignedShort();
        return rangeRecord;
    }

    public LinkedHashMap<String, ScriptTable> readScriptList(TTFDataStream tTFDataStream, long j) throws IOException {
        tTFDataStream.seek(j);
        int unsignedShort = tTFDataStream.readUnsignedShort();
        ScriptRecord[] scriptRecordArr = new ScriptRecord[unsignedShort];
        int[] iArr = new int[unsignedShort];
        for (int i2 = 0; i2 < unsignedShort; i2++) {
            ScriptRecord scriptRecord = new ScriptRecord();
            scriptRecord.scriptTag = tTFDataStream.readString(4);
            iArr[i2] = tTFDataStream.readUnsignedShort();
            scriptRecordArr[i2] = scriptRecord;
        }
        for (int i3 = 0; i3 < unsignedShort; i3++) {
            scriptRecordArr[i3].scriptTable = readScriptTable(tTFDataStream, ((long) iArr[i3]) + j);
        }
        LinkedHashMap<String, ScriptTable> linkedHashMap = new LinkedHashMap<>(unsignedShort);
        for (int i4 = 0; i4 < unsignedShort; i4++) {
            ScriptRecord scriptRecord2 = scriptRecordArr[i4];
            linkedHashMap.put(scriptRecord2.scriptTag, scriptRecord2.scriptTable);
        }
        return linkedHashMap;
    }

    public ScriptTable readScriptTable(TTFDataStream tTFDataStream, long j) throws IOException {
        tTFDataStream.seek(j);
        ScriptTable scriptTable = new ScriptTable();
        int unsignedShort = tTFDataStream.readUnsignedShort();
        int unsignedShort2 = tTFDataStream.readUnsignedShort();
        LangSysRecord[] langSysRecordArr = new LangSysRecord[unsignedShort2];
        int[] iArr = new int[unsignedShort2];
        String str = "";
        for (int i2 = 0; i2 < unsignedShort2; i2++) {
            LangSysRecord langSysRecord = new LangSysRecord();
            String string = tTFDataStream.readString(4);
            langSysRecord.langSysTag = string;
            if (i2 > 0 && string.compareTo(str) <= 0) {
                throw new IOException("LangSysRecords not alphabetically sorted by LangSys tag: " + langSysRecord.langSysTag + " <= " + str);
            }
            iArr[i2] = tTFDataStream.readUnsignedShort();
            langSysRecordArr[i2] = langSysRecord;
            str = langSysRecord.langSysTag;
        }
        if (unsignedShort != 0) {
            scriptTable.defaultLangSysTable = readLangSysTable(tTFDataStream, ((long) unsignedShort) + j);
        }
        for (int i3 = 0; i3 < unsignedShort2; i3++) {
            langSysRecordArr[i3].langSysTable = readLangSysTable(tTFDataStream, ((long) iArr[i3]) + j);
        }
        scriptTable.langSysTables = new LinkedHashMap<>(unsignedShort2);
        for (int i4 = 0; i4 < unsignedShort2; i4++) {
            LangSysRecord langSysRecord2 = langSysRecordArr[i4];
            scriptTable.langSysTables.put(langSysRecord2.langSysTag, langSysRecord2.langSysTable);
        }
        return scriptTable;
    }
}
