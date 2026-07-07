package com.tom_roush.pdfbox.pdmodel.font.encoding;

import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Encoding implements COSObjectable {
    public static final int CHAR_CODE = 0;
    public static final int CHAR_NAME = 1;
    public final Map<Integer, String> codeToName = new HashMap(250);
    public final Map<String, Integer> inverted = new HashMap(250);

    public static Encoding getInstance(COSName cOSName) {
        if (COSName.STANDARD_ENCODING.equals(cOSName)) {
            return StandardEncoding.INSTANCE;
        }
        if (COSName.WIN_ANSI_ENCODING.equals(cOSName)) {
            return WinAnsiEncoding.INSTANCE;
        }
        if (COSName.MAC_ROMAN_ENCODING.equals(cOSName)) {
            return MacRomanEncoding.INSTANCE;
        }
        if (COSName.MAC_EXPERT_ENCODING.equals(cOSName)) {
            return MacExpertEncoding.INSTANCE;
        }
        return null;
    }

    public void add(int i2, String str) {
        this.codeToName.put(Integer.valueOf(i2), str);
        if (this.inverted.containsKey(str)) {
            return;
        }
        this.inverted.put(str, Integer.valueOf(i2));
    }

    public boolean contains(String str) {
        return this.inverted.containsKey(str);
    }

    public Map<Integer, String> getCodeToNameMap() {
        return Collections.unmodifiableMap(this.codeToName);
    }

    public abstract String getEncodingName();

    public String getName(int i2) {
        String str = this.codeToName.get(Integer.valueOf(i2));
        return str != null ? str : ".notdef";
    }

    public Map<String, Integer> getNameToCodeMap() {
        return Collections.unmodifiableMap(this.inverted);
    }

    public void overwrite(int i2, String str) {
        Integer num;
        String str2 = this.codeToName.get(Integer.valueOf(i2));
        if (str2 != null && (num = this.inverted.get(str2)) != null && num.intValue() == i2) {
            this.inverted.remove(str2);
        }
        this.inverted.put(str, Integer.valueOf(i2));
        this.codeToName.put(Integer.valueOf(i2), str);
    }

    public boolean contains(int i2) {
        return this.codeToName.containsKey(Integer.valueOf(i2));
    }
}
