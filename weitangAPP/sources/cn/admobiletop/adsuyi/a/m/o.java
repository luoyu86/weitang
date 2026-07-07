package cn.admobiletop.adsuyi.a.m;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import com.vivo.identifier.IdentifierConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public class o {
    public static boolean a() {
        String strJ = j();
        return strJ.contains("intel") || strJ.contains("amd");
    }

    public static boolean a(int i2) {
        return 618 == i2;
    }

    public static boolean b() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean c() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i2 = 0; i2 < 10; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean d() {
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", "su"});
        } catch (Throwable unused) {
            processExec = null;
        }
        try {
            boolean z = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() != null;
            processExec.destroy();
            return z;
        } catch (Throwable unused2) {
            if (processExec != null) {
                processExec.destroy();
            }
            return false;
        }
    }

    public static boolean e() {
        Context context = ADSuyiSdk.getInstance().getContext();
        return context == null || Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
    }

    public static boolean f() {
        try {
            return (ADSuyiSdk.getInstance().getContext().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g() {
        return b() || c() || d();
    }

    public static boolean h() {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = IdentifierConstant.OAID_STATE_DEFAULT;
            }
            return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean i() {
        try {
            Context context = ADSuyiSdk.getInstance().getContext();
            if (!(context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", "packageName") == 0)) {
                return false;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (Build.VERSION.SDK_INT >= 23) {
                return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()).hasTransport(4);
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(17);
            if (networkInfo == null) {
                return false;
            }
            return networkInfo.isConnectedOrConnecting();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String j() {
        try {
            Process processStart = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream(), "utf-8"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return stringBuffer.toString().toLowerCase();
                }
                stringBuffer.append(line);
            }
        } catch (IOException unused) {
            return "";
        }
    }

    public static boolean b(int i2) {
        if (618 == i2) {
            return true;
        }
        return (f() || h() || e() || !(i() ^ true) || !(a() ^ true) || g()) ? false : true;
    }
}
