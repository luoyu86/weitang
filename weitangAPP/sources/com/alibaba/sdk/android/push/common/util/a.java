package com.alibaba.sdk.android.push.common.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }
}
