package c.k.a.e;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList<c.k.a.c.a> f2797a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReentrantLock f2798b = new ReentrantLock();

    public static void addAllImageFolder(ArrayList<c.k.a.c.a> arrayList) {
    }

    public static void clearCacheImageFolders() {
        f2797a.clear();
    }

    public static int dp2px(Context context, float f2) {
        return (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static boolean existSDCard() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static ArrayList<c.k.a.c.a> getImageFolders() {
        return f2797a;
    }

    public static int getImageItemWidth(Activity activity) {
        int i2 = activity.getResources().getDisplayMetrics().widthPixels;
        int i3 = i2 / activity.getResources().getDisplayMetrics().densityDpi;
        if (i3 < 3) {
            i3 = 3;
        }
        return (i2 - (((int) (activity.getResources().getDisplayMetrics().density * 2.0f)) * (i3 - 1))) / i3;
    }

    public static int getNavigationBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", DispatchConstants.ANDROID);
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static DisplayMetrics getScreenPix(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int getStatusHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean hasVirtualNavigationBar(android.content.Context r5) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 1
            r3 = 17
            if (r0 < r3) goto L35
            java.lang.String r0 = "window"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.view.WindowManager r5 = (android.view.WindowManager) r5
            android.view.Display r5 = r5.getDefaultDisplay()
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            r5.getRealMetrics(r0)
            int r3 = r0.heightPixels
            int r0 = r0.widthPixels
            android.util.DisplayMetrics r4 = new android.util.DisplayMetrics
            r4.<init>()
            r5.getMetrics(r4)
            int r5 = r4.heightPixels
            int r4 = r4.widthPixels
            int r0 = r0 - r4
            if (r0 > 0) goto L32
            int r3 = r3 - r5
            if (r3 <= 0) goto L33
        L32:
            r1 = 1
        L33:
            r2 = r1
            goto L4b
        L35:
            r3 = 14
            if (r0 < r3) goto L4b
            android.view.ViewConfiguration r5 = android.view.ViewConfiguration.get(r5)
            boolean r5 = r5.hasPermanentMenuKey()
            r0 = 4
            boolean r0 = android.view.KeyCharacterMap.deviceHasKey(r0)
            if (r5 != 0) goto L33
            if (r0 != 0) goto L33
            goto L32
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: c.k.a.e.d.hasVirtualNavigationBar(android.content.Context):boolean");
    }
}
