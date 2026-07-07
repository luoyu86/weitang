package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5158a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f5159b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f5160c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f5161d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f5162e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Map<String, String> f5163f = new HashMap();

    public static synchronized String a(String str) {
        String str2 = "apdidTokenCache" + str;
        if (f5163f.containsKey(str2)) {
            String str3 = f5163f.get(str2);
            if (com.alipay.sdk.m.z.a.b(str3)) {
                return str3;
            }
        }
        return "";
    }

    public static synchronized void a() {
    }

    public static synchronized void a(b bVar) {
        if (bVar != null) {
            f5158a = bVar.f5144a;
            f5159b = bVar.f5145b;
            f5160c = bVar.f5146c;
        }
    }

    public static synchronized void a(c cVar) {
        if (cVar != null) {
            f5158a = cVar.f5147a;
            f5159b = cVar.f5148b;
            f5161d = cVar.f5150d;
            f5162e = cVar.f5151e;
            f5160c = cVar.f5149c;
        }
    }

    public static synchronized void a(String str, String str2) {
        String str3 = "apdidTokenCache" + str;
        if (f5163f.containsKey(str3)) {
            f5163f.remove(str3);
        }
        f5163f.put(str3, str2);
    }

    public static synchronized boolean a(Context context, String str) {
        long jA;
        boolean z;
        try {
            jA = h.a(context);
        } catch (Throwable unused) {
        }
        if (jA < 0) {
            jA = 86400000;
        }
        try {
        } catch (Throwable th) {
            com.alipay.apmobilesecuritysdk.c.a.a(th);
        }
        z = Math.abs(System.currentTimeMillis() - h.h(context, str)) < jA;
        return z;
    }

    public static synchronized String b() {
        return f5158a;
    }

    public static void b(String str) {
        f5158a = str;
    }

    public static synchronized String c() {
        return f5159b;
    }

    public static void c(String str) {
        f5159b = str;
    }

    public static synchronized String d() {
        return f5161d;
    }

    public static void d(String str) {
        f5160c = str;
    }

    public static synchronized String e() {
        return f5162e;
    }

    public static void e(String str) {
        f5161d = str;
    }

    public static synchronized String f() {
        return f5160c;
    }

    public static void f(String str) {
        f5162e = str;
    }

    public static synchronized c g() {
        return new c(f5158a, f5159b, f5160c, f5161d, f5162e);
    }

    public static void h() {
        f5163f.clear();
        f5158a = "";
        f5159b = "";
        f5161d = "";
        f5162e = "";
        f5160c = "";
    }
}
