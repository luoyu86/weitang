package com.alipay.sdk.m.a0;

import android.os.Build;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f5266a = new e();

    public static e a() {
        return f5266a;
    }

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    public static String b() {
        return DispatchConstants.ANDROID;
    }

    public static boolean c() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i2 = 0; i2 < 5; i2++) {
            try {
                if (new File(strArr[i2] + "su").exists()) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean d() {
        try {
            if (!Build.HARDWARE.contains("goldfish") && !Build.PRODUCT.contains("sdk")) {
                if (!Build.FINGERPRINT.contains("generic")) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String e() {
        return Build.BOARD;
    }

    public static String f() {
        return Build.BRAND;
    }

    public static String g() {
        return Build.DEVICE;
    }

    public static String h() {
        return Build.DISPLAY;
    }

    public static String i() {
        return Build.VERSION.INCREMENTAL;
    }

    public static String j() {
        return Build.MANUFACTURER;
    }

    public static String k() {
        return Build.MODEL;
    }

    public static String l() {
        return Build.PRODUCT;
    }

    public static String m() {
        return Build.VERSION.RELEASE;
    }

    public static String n() {
        return Build.VERSION.SDK;
    }

    public static String o() {
        return Build.TAGS;
    }

    public static String p() {
        return a("ro.kernel.qemu", "0");
    }
}
