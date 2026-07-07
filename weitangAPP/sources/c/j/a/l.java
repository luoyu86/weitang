package c.j.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class l {
    public static DisplayCutout a(Activity activity) {
        Window window;
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28 || activity == null || (window = activity.getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    public static DisplayCutout b(View view) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28 || view == null || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    public static boolean c(Activity activity) {
        return a(activity) != null;
    }

    public static boolean d(View view) {
        return b(view) != null;
    }

    public static boolean e(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean f(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean h(Context context) {
        int iIntValue;
        if ("Xiaomi".equals(Build.MANUFACTURER)) {
            try {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
                iIntValue = ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, "ro.miui.notch", 0)).intValue();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                iIntValue = 0;
            }
        } else {
            iIntValue = 0;
        }
        return iIntValue == 1;
    }

    public static boolean hasNotchScreen(Activity activity) {
        return activity != null && (h(activity) || e(activity) || f(activity) || g(activity) || c(activity));
    }

    public static boolean hasNotchScreen(View view) {
        return view != null && (h(view.getContext()) || e(view.getContext()) || f(view.getContext()) || g(view.getContext()) || d(view));
    }
}
