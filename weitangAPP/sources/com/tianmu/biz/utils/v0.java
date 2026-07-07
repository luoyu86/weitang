package com.tianmu.biz.utils;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f10904b;

    public static String a() {
        if (f10904b == null) {
            a("");
        }
        return f10904b;
    }

    private static String b(String str) {
        return f0.a(str, null);
    }

    private static boolean a(String str) {
        String str2;
        try {
            str2 = f10903a;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (str2 != null) {
            return str2.equals(str);
        }
        String strB = b("ro.miui.ui.version.name");
        f10904b = strB;
        if (!TextUtils.isEmpty(strB)) {
            f10903a = "MIUI";
        } else {
            String strB2 = b(com.alipay.sdk.m.c.a.f5275a);
            f10904b = strB2;
            if (!TextUtils.isEmpty(strB2)) {
                f10903a = "EMUI";
            } else {
                String strB3 = b("ro.build.version.opporom");
                f10904b = strB3;
                if (!TextUtils.isEmpty(strB3)) {
                    f10903a = "COLOROS";
                } else {
                    String strB4 = b("ro.vivo.os.version");
                    f10904b = strB4;
                    if (!TextUtils.isEmpty(strB4)) {
                        f10903a = "FUNTOUCH";
                    } else {
                        String str3 = Build.DISPLAY;
                        f10904b = str3;
                        if (str3 != null && str3.toUpperCase().contains("FLYME")) {
                            f10903a = "FLYME";
                        } else {
                            f10904b = "unknown";
                            f10903a = "unknown";
                        }
                    }
                }
            }
        }
        String str4 = f10903a;
        return str4 != null && str4.equals(str);
    }
}
