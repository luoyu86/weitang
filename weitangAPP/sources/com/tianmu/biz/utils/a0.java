package com.tianmu.biz.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.taobao.accs.utl.UtilityImpl;
import com.tianmu.TianmuSDK;
import com.tianmu.config.TianmuInitConfig;

/* JADX INFO: loaded from: classes2.dex */
public class a0 {
    @SuppressLint({"MissingPermission"})
    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        TianmuInitConfig config = TianmuSDK.getInstance().getConfig();
        if (config == null || config.isCanUseWifiState()) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                        return UtilityImpl.NET_TYPE_WIFI;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(NewLoginBo.SMS_LOGIN_NAME);
                    if (telephonyManager == null) {
                        return "unknown";
                    }
                    int networkType = telephonyManager.getNetworkType();
                    if (networkType == 19) {
                        return "4g";
                    }
                    if (networkType == 20) {
                        return "5g";
                    }
                    switch (networkType) {
                    }
                }
                return "unknown";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "unknown";
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        r0.add(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> a() {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Enumeration r1 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.net.SocketException -> L55
        L9:
            boolean r2 = r1.hasMoreElements()     // Catch: java.net.SocketException -> L55
            if (r2 == 0) goto L55
            java.lang.Object r2 = r1.nextElement()     // Catch: java.net.SocketException -> L55
            java.net.NetworkInterface r2 = (java.net.NetworkInterface) r2     // Catch: java.net.SocketException -> L55
            java.util.Enumeration r2 = r2.getInetAddresses()     // Catch: java.net.SocketException -> L55
        L19:
            boolean r3 = r2.hasMoreElements()     // Catch: java.net.SocketException -> L55
            if (r3 == 0) goto L9
            java.lang.Object r3 = r2.nextElement()     // Catch: java.net.SocketException -> L55
            java.net.InetAddress r3 = (java.net.InetAddress) r3     // Catch: java.net.SocketException -> L55
            boolean r4 = r3.isLoopbackAddress()     // Catch: java.net.SocketException -> L55
            if (r4 != 0) goto L19
            boolean r4 = r3 instanceof java.net.Inet6Address     // Catch: java.net.SocketException -> L55
            if (r4 == 0) goto L19
            java.lang.String r3 = r3.getHostAddress()     // Catch: java.net.SocketException -> L55
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.net.SocketException -> L55
            if (r4 != 0) goto L19
            java.lang.String r4 = r3.toLowerCase()     // Catch: java.net.SocketException -> L55
            java.lang.String r5 = "fe80"
            boolean r4 = r4.startsWith(r5)     // Catch: java.net.SocketException -> L55
            if (r4 != 0) goto L19
            java.lang.String r4 = r3.toLowerCase()     // Catch: java.net.SocketException -> L55
            java.lang.String r5 = "fc00"
            boolean r4 = r4.startsWith(r5)     // Catch: java.net.SocketException -> L55
            if (r4 == 0) goto L52
            goto L19
        L52:
            r0.add(r3)     // Catch: java.net.SocketException -> L55
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tianmu.biz.utils.a0.a():java.util.List");
    }
}
