package com.tianmu.c.h.e;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.tianmu.TianmuSDK;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static PendingIntent a(String str, String str2, String str3, String str4, int i2) {
        Intent intent = new Intent(a(str3, str));
        intent.putExtra("extraCurrentAdKey", str2);
        intent.putExtra("extraAppPackageName", str4);
        return Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(TianmuSDK.getInstance().getContext(), i2, intent, 67108864) : PendingIntent.getBroadcast(TianmuSDK.getInstance().getContext(), i2, intent, 134217728);
    }

    public static IntentFilter a(String... strArr) {
        IntentFilter intentFilter = new IntentFilter();
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                intentFilter.addAction(str);
            }
        }
        return intentFilter;
    }

    private static String a(String str, String str2) {
        return str + str2;
    }
}
