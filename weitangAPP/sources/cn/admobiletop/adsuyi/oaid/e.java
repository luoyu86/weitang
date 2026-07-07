package cn.admobiletop.adsuyi.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    public static boolean b() {
        return Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }

    public static boolean c() {
        return a("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(a(com.alipay.sdk.m.c.a.f5275a, ""));
    }

    public static boolean e() {
        return !TextUtils.isEmpty(a("ro.build.freeme.label", ""));
    }

    public static boolean f() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "Harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean g() {
        return Build.BRAND.equalsIgnoreCase("HONOR") && !f();
    }

    public static boolean h() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return false;
            }
        }
        return true;
    }

    public static boolean i() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("LENOVO") && !str.equalsIgnoreCase("ZUK")) {
                return false;
            }
        }
        return true;
    }

    public static boolean j() {
        return Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME");
    }

    public static boolean k() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
    }

    public static boolean l() {
        return Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA");
    }

    public static boolean m() {
        return Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA");
    }

    public static boolean n() {
        return Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public static boolean o() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("OPPO") && !str.equalsIgnoreCase("REALME") && TextUtils.isEmpty(a("ro.build.version.opporom", ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean p() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public static boolean q() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(a("ro.vivo.os.version", ""));
    }

    public static boolean r() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("REDMI")) {
                return false;
            }
        }
        return true;
    }

    public static boolean a() {
        return Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS");
    }

    public static boolean a(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
