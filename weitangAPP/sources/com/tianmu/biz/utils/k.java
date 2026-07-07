package com.tianmu.biz.utils;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.tianmu.TianmuSDK;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    public static void a(BroadcastReceiver broadcastReceiver, String... strArr) {
        if (broadcastReceiver != null) {
            IntentFilter intentFilter = new IntentFilter();
            if (strArr != null && strArr.length > 0) {
                for (String str : strArr) {
                    intentFilter.addAction(str);
                }
            }
            try {
                LocalBroadcastManager.getInstance(TianmuSDK.getInstance().getContext()).registerReceiver(broadcastReceiver, intentFilter);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(BroadcastReceiver broadcastReceiver) {
        if (broadcastReceiver != null) {
            try {
                LocalBroadcastManager.getInstance(TianmuSDK.getInstance().getContext()).unregisterReceiver(broadcastReceiver);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(String str, long j, long j2, String str2, String str3) {
        try {
            Intent intent = new Intent();
            intent.setAction(str);
            intent.putExtra("extraCurPos", j);
            intent.putExtra("extraMaxPos", j2);
            intent.putExtra("extraCurrentAdKey", str2);
            intent.putExtra("extraAppPackageName", str3);
            LocalBroadcastManager.getInstance(TianmuSDK.getInstance().getContext()).sendBroadcast(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3) {
        try {
            Intent intent = new Intent();
            intent.setAction(str);
            intent.putExtra("extraCurrentAdKey", str2);
            intent.putExtra("extraAppPackageName", str3);
            LocalBroadcastManager.getInstance(TianmuSDK.getInstance().getContext()).sendBroadcast(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, String str2, String str3, String str4) {
        try {
            Intent intent = new Intent();
            intent.setAction(str);
            intent.putExtra("extraCurrentAdKey", str2);
            intent.putExtra("extraAppPackageName", str3);
            intent.putExtra("extraRealAppPackageName", str4);
            LocalBroadcastManager.getInstance(TianmuSDK.getInstance().getContext()).sendBroadcast(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
