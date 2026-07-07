package c.j.a;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f2735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f2736b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Field f2737c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f2738d;

    static {
        try {
            f2735a = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException unused) {
        }
        try {
            f2736b = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
        }
        try {
            f2737c = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException unused3) {
        }
        try {
            f2738d = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
        } catch (IllegalAccessException | NoSuchFieldException unused4) {
        }
    }

    public static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i3 = declaredField2.getInt(layoutParams);
            int i4 = z ? i2 | i3 : (~i2) & i3;
            if (i3 == i4) {
                return false;
            }
            declaredField2.setInt(layoutParams, i4);
            return true;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return false;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b(Window window, int i2) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = f2737c;
        if (field != null) {
            try {
                if (field.getInt(attributes) != i2) {
                    f2737c.set(attributes, Integer.valueOf(i2));
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void c(Activity activity, boolean z, boolean z2) {
        Method method = f2736b;
        if (method == null) {
            if (z2) {
                setStatusBarDarkIcon(activity.getWindow(), z);
                return;
            }
            return;
        }
        try {
            method.invoke(activity, Boolean.valueOf(z));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public static void d(View view, boolean z) {
        int systemUiVisibility = view.getSystemUiVisibility();
        int i2 = z ? f2738d | systemUiVisibility : (~f2738d) & systemUiVisibility;
        if (i2 != systemUiVisibility) {
            view.setSystemUiVisibility(i2);
        }
    }

    public static boolean isBlackColor(int i2, int i3) {
        return toGrey(i2) < i3;
    }

    public static void setStatusBarDarkIcon(Activity activity, int i2) {
        Method method = f2735a;
        if (method == null) {
            boolean zIsBlackColor = isBlackColor(i2, 50);
            if (f2737c == null) {
                setStatusBarDarkIcon(activity, zIsBlackColor);
                return;
            } else {
                c(activity, zIsBlackColor, zIsBlackColor);
                setStatusBarDarkIcon(activity.getWindow(), i2);
                return;
            }
        }
        try {
            method.invoke(activity, Integer.valueOf(i2));
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
    }

    public static int toGrey(int i2) {
        return (((((i2 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16) * 38) + (((65280 & i2) >> 8) * 75)) + ((i2 & 255) * 15)) >> 7;
    }

    public static void setStatusBarDarkIcon(Window window, int i2) {
        try {
            b(window, i2);
            if (Build.VERSION.SDK_INT > 22) {
                d(window.getDecorView(), true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setStatusBarDarkIcon(Activity activity, boolean z) {
        c(activity, z, true);
    }

    public static void setStatusBarDarkIcon(Window window, boolean z) {
        if (Build.VERSION.SDK_INT < 23) {
            a(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
        } else {
            d(window.getDecorView(), z);
            b(window, 0);
        }
    }
}
