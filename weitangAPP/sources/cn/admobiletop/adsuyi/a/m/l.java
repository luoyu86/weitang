package cn.admobiletop.adsuyi.a.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.sun.mail.pop3.POP3Message;

/* JADX INFO: loaded from: classes.dex */
public class l {
    @SuppressLint({"MissingPermission"})
    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                    return "WIFI";
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(NewLoginBo.SMS_LOGIN_NAME);
                if (telephonyManager == null) {
                    return POP3Message.UNKNOWN;
                }
                int networkType = telephonyManager.getNetworkType();
                if (networkType == 19) {
                    return "4G";
                }
                if (networkType == 20) {
                    return "5G";
                }
                switch (networkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        return POP3Message.UNKNOWN;
                }
            }
            return POP3Message.UNKNOWN;
        } catch (Throwable th) {
            th.printStackTrace();
            return POP3Message.UNKNOWN;
        }
    }

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
