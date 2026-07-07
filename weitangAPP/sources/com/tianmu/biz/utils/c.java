package com.tianmu.biz.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a(Context context) {
        return p0.a() ? c(context) : p0.b() ? d(context) : p0.c() ? e(context) : "";
    }

    public static String b(Context context) {
        if (!p0.a()) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 16384);
            return packageInfo != null ? String.valueOf(packageInfo.versionCode) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c(Context context) {
        if (!p0.a()) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.appmarket", 16384);
            return packageInfo != null ? String.valueOf(packageInfo.versionCode) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String d(Context context) {
        if (!p0.b()) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.oppo.market", 16384);
            return packageInfo != null ? String.valueOf(packageInfo.versionCode) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e(Context context) {
        if (!p0.c()) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.bbk.appstore", 16384);
            return packageInfo != null ? String.valueOf(packageInfo.versionCode) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String b() {
        if (!p0.a()) {
            return "";
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, com.alipay.sdk.m.c.a.f5275a);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c() {
        return !e() ? "" : a(com.alipay.sdk.m.c.a.f5276b, "");
    }

    public static String d() {
        if (!p0.d()) {
            return "";
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.miui.ui.version.name");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static boolean e() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return TextUtils.isEmpty(str3) ? str2 : str3;
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String a() {
        try {
            if (p0.a()) {
                return b();
            }
            return p0.d() ? d() : "";
        } catch (Exception unused) {
            return "";
        }
    }
}
