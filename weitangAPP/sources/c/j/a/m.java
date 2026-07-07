package c.j.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    public static String a() {
        return b("ro.build.display.id", "");
    }

    public static String b(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str2;
        }
    }

    public static String getEMUIVersion() {
        return isEMUI() ? b(com.alipay.sdk.m.c.a.f5275a, "") : "";
    }

    public static String getFlymeOSVersion() {
        return isFlymeOS() ? b("ro.build.display.id", "") : "";
    }

    public static String getMIUIVersion() {
        return isMIUI() ? b("ro.miui.ui.version.name", "") : "";
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(b(com.alipay.sdk.m.c.a.f5275a, ""));
    }

    public static boolean isEMUI3_0() {
        return getEMUIVersion().contains("EmotionUI_3.0");
    }

    public static boolean isEMUI3_1() {
        String eMUIVersion = getEMUIVersion();
        return "EmotionUI 3".equals(eMUIVersion) || eMUIVersion.contains("EmotionUI_3.1");
    }

    public static boolean isEMUI3_x() {
        return isEMUI3_0() || isEMUI3_1();
    }

    public static boolean isFlymeOS() {
        return a().toLowerCase().contains("flyme");
    }

    public static boolean isFlymeOS4Later() {
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            return (flymeOSVersion.toLowerCase().contains("os") ? Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue() : Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue()) >= 4;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isFlymeOS5() {
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            return (flymeOSVersion.toLowerCase().contains("os") ? Integer.valueOf(flymeOSVersion.substring(9, 10)).intValue() : Integer.valueOf(flymeOSVersion.substring(6, 7)).intValue()) == 5;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(b("ro.miui.ui.version.name", ""));
    }

    public static boolean isMIUI6Later() {
        String mIUIVersion = getMIUIVersion();
        if (mIUIVersion.isEmpty()) {
            return false;
        }
        try {
            return Integer.valueOf(mIUIVersion.substring(1)).intValue() >= 6;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
