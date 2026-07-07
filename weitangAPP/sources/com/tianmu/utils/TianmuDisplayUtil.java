package com.tianmu.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.tianmu.TianmuSDK;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuDisplayUtil {
    public static boolean activityIsLandscape(Context context) {
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        int requestedOrientation = ((Activity) context).getRequestedOrientation();
        return (requestedOrientation == 0 || requestedOrientation == 8 || requestedOrientation == 6) || context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean activityIsPortrait(Context context) {
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        int requestedOrientation = ((Activity) context).getRequestedOrientation();
        return requestedOrientation == 1 || requestedOrientation == 9 || requestedOrientation == 7;
    }

    public static int dp2px(int i2) {
        return (int) (TianmuSDK.getInstance().getInitiallyDensity() * i2);
    }

    public static int getDensityDpi() {
        return getResources().getDisplayMetrics().densityDpi;
    }

    public static Resources getResources() {
        return TianmuSDK.getInstance().getContext().getResources();
    }

    public static int getScreenHeight() {
        return getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier;
        try {
            identifier = context.getResources().getIdentifier("status_bar_height", "dimen", DispatchConstants.ANDROID);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        return dimensionPixelSize <= 0 ? (int) (context.getResources().getDisplayMetrics().density * 24.0f) : dimensionPixelSize;
    }

    public static int px2dp(int i2) {
        return (int) (i2 / Math.max(1.0f, TianmuSDK.getInstance().getInitiallyDensity()));
    }
}
