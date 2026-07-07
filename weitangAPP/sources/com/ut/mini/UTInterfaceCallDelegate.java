package com.ut.mini;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public class UTInterfaceCallDelegate {
    public static void pageAppearByAuto(Activity activity) {
        UTPageHitHelper.getInstance().pageAppearByAuto(activity);
    }

    public static void pageDisAppearByAuto(Activity activity) {
        UTPageHitHelper.getInstance().pageDisAppearByAuto(activity);
    }
}
