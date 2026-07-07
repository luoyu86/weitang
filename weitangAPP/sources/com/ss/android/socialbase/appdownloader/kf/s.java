package com.ss.android.socialbase.appdownloader.kf;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f9941a;
    private static String bl;
    private static Boolean n;
    private static String ok;
    private static String s;

    public static boolean a(Context context) {
        return context != null && s(context) == 0 && kf();
    }

    public static String bl() {
        if (bl == null) {
            bl = ok("getReleaseType");
        }
        return bl;
    }

    public static String h() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean kf() {
        return n() && a(a(), ok()) && ok(Process.myUid()) == 0;
    }

    public static boolean n() {
        if (n == null) {
            n = Boolean.FALSE;
            try {
                n = Boolean.valueOf("156".equals(ok("ro.config.hw_optb", "0")) && "true".equals(ok("hw_mc.pure_mode.enable", "false")));
            } catch (Exception unused) {
            }
        }
        return n.booleanValue();
    }

    public static boolean ok(Context context) {
        return context != null && bl(context) == 0 && n();
    }

    public static String s() {
        if (s == null) {
            s = ok("getBuildVersion");
        }
        return s;
    }

    public static String a() {
        if (f9941a == null) {
            f9941a = ok("getVersion");
        }
        return f9941a;
    }

    public static String ok() {
        if (ok == null) {
            ok = ok("getApiVersion");
        }
        return ok;
    }

    public static int bl(Context context) {
        if (context == null) {
            return 1;
        }
        if (a(a(), ok())) {
            return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 1) == 0 ? 0 : 1;
        }
        return Settings.Secure.getInt(context.getContentResolver(), "pure_mode_state", 0);
    }

    public static int s(Context context) {
        return (context == null || Settings.Secure.getInt(context.getContentResolver(), "pure_enhanced_mode_state", 1) != 0) ? 1 : 0;
    }

    private static boolean a(String str, String str2) {
        return !TextUtils.isEmpty(str2) && str.startsWith("3");
    }

    private static String ok(String str, String str2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.SystemPropertiesEx");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    private static int ok(int i2) {
        try {
            Class<?> cls = Class.forName("com.huawei.android.os.UserHandleEx");
            return ((Integer) cls.getMethod("getUserId", Integer.TYPE).invoke(cls, Integer.valueOf(i2))).intValue();
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    private static String ok(String str) {
        try {
            Class<?> cls = Class.forName("ohos.system.version.SystemVersion");
            return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]).toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
