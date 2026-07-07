package com.tianmu.biz.utils;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuNativeCommonUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f10847a = true;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static TianmuNativeCommonUtil f10848a = new TianmuNativeCommonUtil();
    }

    static {
        try {
            System.loadLibrary("native-tianmu-common");
        } catch (Throwable unused) {
            f10847a = false;
        }
    }

    private native String A();

    private native String AA();

    private native String Ab();

    private native String B();

    private native String C();

    private native String Ca();

    private native String D();

    private native String E();

    private native String F();

    public static TianmuNativeCommonUtil N() {
        return b.f10848a;
    }

    private native String a();

    private native String aa();

    private native String aaa();

    private native String aab();

    private native String aac();

    private native String aad();

    private native String aae();

    private native String ab();

    private native String b();

    private native String bb();

    private native String c();

    private native String d();

    private native String e();

    private native String f();

    private native String g();

    private native String h();

    public String G() {
        if (!f10847a) {
            return "";
        }
        try {
            return AA();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String H() {
        if (!f10847a) {
            return "";
        }
        try {
            return aa();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String I() {
        if (!f10847a) {
            return "";
        }
        try {
            return ab();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String J() {
        if (!f10847a) {
            return "";
        }
        try {
            return A();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String K() {
        if (!f10847a) {
            return "";
        }
        try {
            return Ca();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String L() {
        if (!f10847a) {
            return "";
        }
        try {
            return Ab();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String M() {
        if (!f10847a) {
            return "";
        }
        try {
            return bb();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String i() {
        if (!f10847a) {
            return "";
        }
        try {
            return B();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String j() {
        if (!f10847a) {
            return "";
        }
        try {
            return C();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String k() {
        if (!f10847a) {
            return "";
        }
        try {
            return b();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String l() {
        if (!f10847a) {
            return "";
        }
        try {
            return a();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String m() {
        if (!f10847a) {
            return "";
        }
        try {
            return c();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String n() {
        if (!f10847a) {
            return "";
        }
        try {
            return d();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String o() {
        return !f10847a ? "" : h();
    }

    public String p() {
        return !f10847a ? "" : g();
    }

    public String q() {
        if (!f10847a) {
            return "";
        }
        try {
            return e();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String r() {
        if (!f10847a) {
            return "";
        }
        try {
            return f();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String s() {
        if (!f10847a) {
            return "";
        }
        try {
            return E();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String t() {
        if (!f10847a) {
            return "";
        }
        try {
            return D();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String u() {
        if (!f10847a) {
            return "";
        }
        try {
            return aab();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String v() {
        if (!f10847a) {
            return "";
        }
        try {
            return aae();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String w() {
        if (!f10847a) {
            return "";
        }
        try {
            return aad();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String x() {
        if (!f10847a) {
            return "";
        }
        try {
            return aac();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String y() {
        if (!f10847a) {
            return "";
        }
        try {
            return aaa();
        } catch (Throwable unused) {
            return "";
        }
    }

    public String z() {
        if (!f10847a) {
            return "";
        }
        try {
            return F();
        } catch (Throwable unused) {
            return "";
        }
    }

    private TianmuNativeCommonUtil() {
    }
}
