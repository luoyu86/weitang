package cn.admobiletop.adsuyi.adapter.gdt.e;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;

/* JADX INFO: loaded from: classes.dex */
public class b {
    @SuppressLint({"MissingPermission"})
    public static boolean a() {
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config == null || config.isCanUseWifiState()) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) ADSuyiSdk.getInstance().getContext().getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return 1 == activeNetworkInfo.getType();
                }
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
