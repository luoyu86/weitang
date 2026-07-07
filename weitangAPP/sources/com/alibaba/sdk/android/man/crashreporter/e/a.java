package com.alibaba.sdk.android.man.crashreporter.e;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.android.arouter.utils.Consts;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.taobao.accs.utl.UtilityImpl;
import com.tom_roush.fontbox.ttf.OpenTypeScript;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            int iMyPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return null;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String c(Context context) {
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI)).getConnectionInfo();
            if (connectionInfo == null) {
                return "127.0.0.1";
            }
            int ipAddress = connectionInfo.getIpAddress();
            return (ipAddress & 255) + "" + ((ipAddress >> 8) & 255) + Consts.DOT + ((ipAddress >> 16) & 255) + Consts.DOT + ((ipAddress >> 24) & 255);
        } catch (Exception unused) {
            return "127.0.0.1";
        }
    }

    public static boolean d(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String e(Context context) {
        String deviceId = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(NewLoginBo.SMS_LOGIN_NAME);
                if (telephonyManager != null) {
                    deviceId = telephonyManager.getDeviceId();
                }
            } catch (Exception unused) {
            }
        }
        return i.b(deviceId) ? k() : deviceId;
    }

    public static String f(Context context) {
        String subscriberId = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(NewLoginBo.SMS_LOGIN_NAME);
                if (telephonyManager != null) {
                    subscriberId = telephonyManager.getSubscriberId();
                }
            } catch (Exception unused) {
            }
        }
        return i.b(subscriberId) ? k() : subscriberId;
    }

    public static String g(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            return (packageManager == null || packageName == null) ? "" : packageManager.getApplicationLabel(packageManager.getPackageInfo(packageName, 1).applicationInfo).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String h(Context context) {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(UtilityImpl.NET_TYPE_WIFI);
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return "00-00-00-00-00-00";
            }
            String macAddress = connectionInfo.getMacAddress();
            return i.b((CharSequence) macAddress) ? macAddress : "00-00-00-00-00-00";
        } catch (Exception unused) {
            return "00-00-00-00-00-00";
        }
    }

    public static String i(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            if (i2 > i3) {
                int i4 = i2 ^ i3;
                i3 ^= i4;
                i2 = i4 ^ i3;
            }
            return String.format("%s*%s", Integer.valueOf(i3), Integer.valueOf(i2));
        } catch (Exception unused) {
            return OpenTypeScript.UNKNOWN;
        }
    }

    public static final String k() {
        try {
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            int iNanoTime = (int) System.nanoTime();
            int iNextInt = new Random().nextInt();
            int iNextInt2 = new Random().nextInt();
            byte[] bArrD = c.d(iCurrentTimeMillis);
            byte[] bArrD2 = c.d(iNanoTime);
            byte[] bArrD3 = c.d(iNextInt);
            byte[] bArrD4 = c.d(iNextInt2);
            byte[] bArr = new byte[16];
            System.arraycopy(bArrD, 0, bArr, 0, 4);
            System.arraycopy(bArrD2, 0, bArr, 4, 4);
            System.arraycopy(bArrD3, 0, bArr, 8, 4);
            System.arraycopy(bArrD4, 0, bArr, 12, 4);
            return b.a(bArr, 2);
        } catch (IOException unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public static boolean m50e(Context context) {
        return m49a(context)[0].equals("Wi-Fi");
    }

    public static String f() throws IOException {
        String line = null;
        try {
            FileReader fileReader = new FileReader("/proc/cpuinfo");
            BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
            line = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException | IOException unused) {
        }
        return line != null ? line.substring(line.indexOf(58) + 1).trim() : "";
    }

    public static int a() {
        try {
            return Build.VERSION.class.getField("SDK_INT").getInt(null);
        } catch (IllegalAccessException unused) {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (IllegalArgumentException unused2) {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (NoSuchFieldException unused3) {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (SecurityException unused4) {
            return Integer.parseInt(Build.VERSION.SDK);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String[] m49a(Context context) {
        ConnectivityManager connectivityManager;
        String[] strArr = {OpenTypeScript.UNKNOWN, OpenTypeScript.UNKNOWN};
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "Wi-Fi";
                    return strArr;
                }
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "2G/3G";
                    strArr[1] = networkInfo2.getSubtypeName();
                }
            }
        } catch (Exception unused) {
        }
        return strArr;
    }
}
