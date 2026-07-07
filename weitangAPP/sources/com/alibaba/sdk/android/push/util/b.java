package com.alibaba.sdk.android.push.util;

import android.os.Build;
import android.text.TextUtils;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean a() {
        boolean zEqualsIgnoreCase = Build.BRAND.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI);
        if (zEqualsIgnoreCase) {
            return zEqualsIgnoreCase;
        }
        return (TextUtils.isEmpty(a(com.alipay.sdk.m.c.a.f5275a)) && TextUtils.isEmpty(a(com.alipay.sdk.m.c.a.f5276b))) ? false : true;
    }

    public static boolean b() {
        return d() && !e();
    }

    public static boolean c() {
        return Build.MANUFACTURER.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO);
    }

    private static boolean d() {
        return Build.MANUFACTURER.equalsIgnoreCase("HONOR");
    }

    private static boolean e() {
        String str = "";
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, com.alipay.sdk.m.c.a.f5275a, "");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return !TextUtils.isEmpty(str) && (str.contains("MagicUI") || str.contains("MagicOS"));
    }
}
