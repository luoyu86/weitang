package com.tom_roush.fontbox.cff;

import android.graphics.Path;
import com.tom_roush.fontbox.type1.Type1CharStringReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class CFFCIDFont extends CFFFont {
    private FDSelect fdSelect;
    private String ordering;
    private String registry;
    private int supplement;
    private List<Map<String, Object>> fontDictionaries = new LinkedList();
    private List<Map<String, Object>> privateDictionaries = new LinkedList();
    private final Map<Integer, CIDKeyedType2CharString> charStringCache = new ConcurrentHashMap();
    private final PrivateType1CharStringReader reader = new PrivateType1CharStringReader();

    public class PrivateType1CharStringReader implements Type1CharStringReader {
        private PrivateType1CharStringReader() {
        }

        @Override // com.tom_roush.fontbox.type1.Type1CharStringReader
        public Type1CharString getType1CharString(String str) throws IOException {
            return CFFCIDFont.this.getType2CharString(0);
        }
    }

    private int getDefaultWidthX(int i2) {
        int fDIndex = this.fdSelect.getFDIndex(i2);
        if (fDIndex == -1) {
            return 1000;
        }
        Map<String, Object> map = this.privateDictionaries.get(fDIndex);
        if (map.containsKey("defaultWidthX")) {
            return ((Number) map.get("defaultWidthX")).intValue();
        }
        return 1000;
    }

    private byte[][] getLocalSubrIndex(int i2) {
        int fDIndex = this.fdSelect.getFDIndex(i2);
        if (fDIndex == -1) {
            return null;
        }
        return (byte[][]) this.privateDictionaries.get(fDIndex).get("Subrs");
    }

    private int getNominalWidthX(int i2) {
        int fDIndex = this.fdSelect.getFDIndex(i2);
        if (fDIndex == -1) {
            return 0;
        }
        Map<String, Object> map = this.privateDictionaries.get(fDIndex);
        if (map.containsKey("nominalWidthX")) {
            return ((Number) map.get("nominalWidthX")).intValue();
        }
        return 0;
    }

    private int selectorToCID(String str) {
        if (str.startsWith("\\")) {
            return Integer.parseInt(str.substring(1));
        }
        throw new IllegalArgumentException("Invalid selector");
    }

    public FDSelect getFdSelect() {
        return this.fdSelect;
    }

    public List<Map<String, Object>> getFontDicts() {
        return this.fontDictionaries;
    }

    @Override // com.tom_roush.fontbox.cff.CFFFont, com.tom_roush.fontbox.FontBoxFont
    public List<Number> getFontMatrix() {
        return (List) this.topDict.get("FontMatrix");
    }

    public String getOrdering() {
        return this.ordering;
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public Path getPath(String str) throws IOException {
        return getType2CharString(selectorToCID(str)).getPath();
    }

    public List<Map<String, Object>> getPrivDicts() {
        return this.privateDictionaries;
    }

    public String getRegistry() {
        return this.registry;
    }

    public int getSupplement() {
        return this.supplement;
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public float getWidth(String str) throws IOException {
        return getType2CharString(selectorToCID(str)).getWidth();
    }

    @Override // com.tom_roush.fontbox.FontBoxFont
    public boolean hasGlyph(String str) throws IOException {
        return selectorToCID(str) != 0;
    }

    public void setFdSelect(FDSelect fDSelect) {
        this.fdSelect = fDSelect;
    }

    public void setFontDict(List<Map<String, Object>> list) {
        this.fontDictionaries = list;
    }

    public void setOrdering(String str) {
        this.ordering = str;
    }

    public void setPrivDict(List<Map<String, Object>> list) {
        this.privateDictionaries = list;
    }

    public void setRegistry(String str) {
        this.registry = str;
    }

    public void setSupplement(int i2) {
        this.supplement = i2;
    }

    @Override // com.tom_roush.fontbox.cff.CFFFont
    public CIDKeyedType2CharString getType2CharString(int i2) throws IOException {
        CIDKeyedType2CharString cIDKeyedType2CharString = this.charStringCache.get(Integer.valueOf(i2));
        if (cIDKeyedType2CharString != null) {
            return cIDKeyedType2CharString;
        }
        int gIDForCID = this.charset.getGIDForCID(i2);
        byte[][] bArr = this.charStrings;
        byte[] bArr2 = bArr[gIDForCID];
        if (bArr2 == null) {
            bArr2 = bArr[0];
        }
        CIDKeyedType2CharString cIDKeyedType2CharString2 = new CIDKeyedType2CharString(this.reader, this.fontName, i2, gIDForCID, new Type2CharStringParser(this.fontName, i2).parse(bArr2, this.globalSubrIndex, getLocalSubrIndex(gIDForCID)), getDefaultWidthX(gIDForCID), getNominalWidthX(gIDForCID));
        this.charStringCache.put(Integer.valueOf(i2), cIDKeyedType2CharString2);
        return cIDKeyedType2CharString2;
    }
}
