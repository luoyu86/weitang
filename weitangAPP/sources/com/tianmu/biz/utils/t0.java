package com.tianmu.biz.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import anet.channel.strategy.dispatch.DispatchConstants;

/* JADX INFO: loaded from: classes2.dex */
public class t0 {
    public static int a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealMetrics(displayMetrics);
        } else {
            defaultDisplay.getMetrics(displayMetrics);
        }
        return displayMetrics.heightPixels;
    }

    public static int b(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static int c(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static float d(Context context) {
        if (context.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID) > 0) {
            return context.getApplicationContext().getResources().getDimensionPixelSize(r0);
        }
        return 0.0f;
    }

    public static void a(Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 19) {
            return;
        }
        Window window = activity.getWindow();
        if (i2 >= 21) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 256 | 1024);
            window.setStatusBarColor(0);
            return;
        }
        window.addFlags(67108864);
    }
}
