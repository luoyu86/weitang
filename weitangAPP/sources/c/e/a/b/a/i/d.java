package c.e.a.b.a.i;

import android.R;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.util.TypedValue;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static SharedPreferences a(Context context) {
        return context.getApplicationContext().getSharedPreferences("sp_photopicker", 0);
    }

    public static int getActionBarHeight(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return 0;
    }

    public static boolean getBooleanSp(Context context, String str) {
        return a(context).getBoolean(str, true);
    }

    public static int getNavigationBarHeight(Context context) {
        int identifier;
        boolean zHasNavigationBar = hasNavigationBar(context);
        Resources resources = context.getResources();
        if (!zHasNavigationBar || (identifier = resources.getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID)) <= 0) {
            return 0;
        }
        return resources.getDimensionPixelSize(identifier);
    }

    public static int getStateBarHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static Uri getUri(String str) {
        return TextUtils.isEmpty(str) ? Uri.EMPTY : (str.startsWith("http") || str.startsWith("https")) ? Uri.parse(str) : str.startsWith("android.resource://") ? Uri.parse(str) : Uri.fromFile(new File(str));
    }

    public static boolean hasNavigationBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", DispatchConstants.ANDROID);
        boolean z = false;
        boolean z2 = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
            if (!"1".equals(str)) {
                z = "0".equals(str) ? true : z2;
            }
            return z;
        } catch (Exception e2) {
            e2.printStackTrace();
            return z2;
        }
    }

    public static void putBooleanSp(Context context, String str, boolean z) {
        a(context).edit().putBoolean(str, z).commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String savePhotoToSD(android.graphics.Bitmap r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            if (r4 != 0) goto L3
            return r5
        L3:
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto La
            return r5
        La:
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L22 java.lang.Exception -> L24
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> L20 java.lang.Throwable -> L34
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch: java.lang.Exception -> L20 java.lang.Throwable -> L34
            r1.close()     // Catch: java.lang.Exception -> L1b
            goto L1f
        L1b:
            r4 = move-exception
            r4.printStackTrace()
        L1f:
            return r5
        L20:
            r4 = move-exception
            goto L26
        L22:
            r4 = move-exception
            goto L36
        L24:
            r4 = move-exception
            r1 = r0
        L26:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L33
            r1.close()     // Catch: java.lang.Exception -> L2f
            goto L33
        L2f:
            r4 = move-exception
            r4.printStackTrace()
        L33:
            return r0
        L34:
            r4 = move-exception
            r0 = r1
        L36:
            if (r0 == 0) goto L40
            r0.close()     // Catch: java.lang.Exception -> L3c
            goto L40
        L3c:
            r5 = move-exception
            r5.printStackTrace()
        L40:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: c.e.a.b.a.i.d.savePhotoToSD(android.graphics.Bitmap, java.lang.String):java.lang.String");
    }
}
