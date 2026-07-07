package com.intelligoo.sdk;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static String a(String str) {
        return null;
    }

    public static String a(String str, boolean z) {
        return str == null ? "" : !z ? str.substring(0, 32) : a(str).substring(0, 32);
    }

    public static String b(String str, boolean z) {
        return str == null ? "" : !z ? str.substring(32, 43) : a(str).substring(32, 43);
    }

    public static String c(String str, boolean z) {
        return str == null ? "" : !z ? str.substring(43, 54) : a(str).substring(43, 54);
    }

    public static String d(String str, boolean z) {
        return str == null ? "" : !z ? str.length() == 68 ? str.substring(54, 64) : str.length() == 74 ? str.substring(54, 70) : "" : str.length() == 68 ? a(str).substring(54, 64) : str.length() == 74 ? a(str).substring(54, 70) : "";
    }

    public static String e(String str, boolean z) {
        if (str == null) {
            return "";
        }
        if (z) {
            return str.length() == 68 ? a(str).substring(64, 65) : str.length() == 74 ? a(str).substring(70, 71) : "";
        }
        l.a(str);
        return str.length() == 68 ? str.substring(64, 65) : str.length() == 74 ? str.substring(70, 71) : "";
    }
}
