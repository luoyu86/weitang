package com.alipay.sdk.m.j;

import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5388a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f5389b;

    public static void a(String str) {
        f5389b = str;
    }

    public static String b() {
        c cVarB = c.b(c.DOUBLE_REQUEST.b());
        return a(cVarB.b(), cVarB.a(), "");
    }

    public static boolean c() {
        return f5388a;
    }

    public static String d() {
        return f5389b;
    }

    public static String e() {
        c cVarB = c.b(c.PARAMS_ERROR.b());
        return a(cVarB.b(), cVarB.a(), "");
    }

    public static void a(boolean z) {
        f5388a = z;
    }

    public static String a() {
        c cVarB = c.b(c.CANCELED.b());
        return a(cVarB.b(), cVarB.a(), "");
    }

    public static String a(int i2, String str, String str2) {
        return "resultStatus={" + i2 + "};memo={" + str + "};result={" + str2 + i.f5699d;
    }
}
