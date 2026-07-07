package com.meizu.flyme.openidsdk;

/* JADX INFO: loaded from: classes2.dex */
public class ValueData {
    public int code;
    public long expired = System.currentTimeMillis() + 86400000;
    public String value;

    public ValueData(String str, int i2) {
        this.value = str;
        this.code = i2;
    }

    public native String toString();
}
