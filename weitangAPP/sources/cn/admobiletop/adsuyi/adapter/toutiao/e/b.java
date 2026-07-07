package cn.admobiletop.adsuyi.adapter.toutiao.e;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static int a(Context context, float f2) {
        float f3 = context.getResources().getDisplayMetrics().density;
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    public static int b(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static float c(Context context) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = context.getResources().getDisplayMetrics().widthPixels;
        if (f2 <= 0.0f) {
            f2 = 1.0f;
        }
        return (f3 / f2) + 0.5f;
    }

    public static int d(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static float e(Context context) {
        if (context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID) > 0) {
            return context.getApplicationContext().getResources().getDimensionPixelSize(r0);
        }
        return 0.0f;
    }

    public static int a(Context context) {
        return (int) (b(context) + e(context));
    }
}
