package com.tianmu.j.b.e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import android.view.WindowManager;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static boolean a(Activity activity) {
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT < 28) {
            return b(activity) || c(activity) || d(activity) || e(activity);
        }
        WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
        return (rootWindowInsets == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null || displayCutout.getBoundingRects().size() <= 0) ? false : true;
    }

    private static boolean b(Activity activity) {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            return false;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            if (clsLoadClass != null) {
                return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean c(Activity activity) {
        if (Build.MANUFACTURER.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO)) {
            return activity.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        }
        return false;
    }

    @SuppressLint({"PrivateApi"})
    private static boolean d(Activity activity) {
        if (!Build.MANUFACTURER.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO)) {
            return false;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.util.FtFeature");
            if (clsLoadClass != null) {
                return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @SuppressLint({"PrivateApi"})
    private static boolean e(Activity activity) {
        if (!Build.MANUFACTURER.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI)) {
            return false;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, "ro.miui.notch", 0)).intValue() == 1;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(Context context, boolean z) {
        Activity activityC = b.c(context);
        if (activityC != null && Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = activityC.getWindow().getAttributes();
            if (z) {
                attributes.layoutInDisplayCutoutMode = 1;
            } else {
                attributes.layoutInDisplayCutoutMode = 0;
            }
            activityC.getWindow().setAttributes(attributes);
        }
    }
}
