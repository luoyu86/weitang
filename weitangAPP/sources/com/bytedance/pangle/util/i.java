package com.bytedance.pangle.util;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class i {
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT < 21;
    }

    public static boolean c() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 21 && i2 <= 23;
    }

    public static boolean d() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 21 && i2 < 23;
    }

    public static boolean e() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 21 && i2 <= 25;
    }

    public static boolean f() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 26 && i2 <= 28;
    }

    public static boolean g() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 29 && i2 <= 30;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean i() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean j() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 28) {
            return i2 == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 31) {
            return i2 == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}
