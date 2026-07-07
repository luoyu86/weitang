package com.tom_roush.fontbox.encoding;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Encoding {
    public Map<Integer, String> codeToName = new HashMap(250);
    public Map<String, Integer> nameToCode = new HashMap(250);

    public void addCharacterEncoding(int i2, String str) {
        this.codeToName.put(Integer.valueOf(i2), str);
        this.nameToCode.put(str, Integer.valueOf(i2));
    }

    public Integer getCode(String str) {
        return this.nameToCode.get(str);
    }

    public Map<Integer, String> getCodeToNameMap() {
        return Collections.unmodifiableMap(this.codeToName);
    }

    public String getName(int i2) {
        String str = this.codeToName.get(Integer.valueOf(i2));
        return str != null ? str : ".notdef";
    }
}
