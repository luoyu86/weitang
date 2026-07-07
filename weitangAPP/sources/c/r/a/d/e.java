package c.r.a.d;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
