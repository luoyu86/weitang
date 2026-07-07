package cn.admobiletop.adsuyi.a.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.taobao.accs.utl.UtilityImpl;
import java.net.NetworkInterface;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return TextUtils.isEmpty(string) ? Settings.System.getString(context.getContentResolver(), "android_id") : string;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String b(Context context) {
        int i2;
        TelephonyManager telephonyManager;
        String imei;
        if (context != null && (i2 = Build.VERSION.SDK_INT) < 29) {
            try {
                if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0 && (telephonyManager = (TelephonyManager) context.getSystemService(NewLoginBo.SMS_LOGIN_NAME)) != null) {
                    if (i2 >= 26) {
                        try {
                            imei = telephonyManager.getImei();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            imei = null;
                        }
                    } else {
                        imei = null;
                    }
                    if (!TextUtils.isEmpty(imei)) {
                        return imei;
                    }
                    try {
                        return telephonyManager.getDeviceId();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return imei;
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public static String c(Context context) {
        return Build.VERSION.SDK_INT >= 23 ? a() : d(context);
    }

    public static String d(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_WIFI_STATE") != 0 || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService(UtilityImpl.NET_TYPE_WIFI)) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return "02:00:00:00:00:00";
            }
            String macAddress = connectionInfo.getMacAddress();
            return TextUtils.isEmpty(macAddress) ? "02:00:00:00:00:00" : macAddress;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return "02:00:00:00:00:00";
    }

    public static String a() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if ("wlan0".equalsIgnoreCase(networkInterface.getName())) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }
}
