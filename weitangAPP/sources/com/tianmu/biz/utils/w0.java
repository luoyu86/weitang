package com.tianmu.biz.utils;

import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import androidx.core.content.ContextCompat;
import com.taobao.accs.utl.UtilityImpl;
import com.tianmu.TianmuSDK;

/* JADX INFO: loaded from: classes2.dex */
public class w0 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f10905a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10906b = "";
    }

    @SuppressLint({"MissingPermission"})
    public static boolean a() {
        NetworkInfo activeNetworkInfo = null;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) TianmuSDK.getInstance().getContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
    }

    @SuppressLint({"HardwareIds"})
    public static a a(boolean z) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        a aVar = new a();
        try {
            int iCheckSelfPermission = ContextCompat.checkSelfPermission(TianmuSDK.getInstance().getContext(), "android.permission.ACCESS_WIFI_STATE");
            int iCheckSelfPermission2 = ContextCompat.checkSelfPermission(TianmuSDK.getInstance().getContext(), "android.permission.ACCESS_COARSE_LOCATION");
            if (!z || iCheckSelfPermission != 0 || iCheckSelfPermission2 != 0 || (wifiManager = (WifiManager) TianmuSDK.getInstance().getContext().getApplicationContext().getApplicationContext().getSystemService(UtilityImpl.NET_TYPE_WIFI)) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return aVar;
            }
            aVar.f10905a = connectionInfo.getSSID();
            aVar.f10906b = connectionInfo.getMacAddress();
            connectionInfo.getBSSID();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return aVar;
    }
}
