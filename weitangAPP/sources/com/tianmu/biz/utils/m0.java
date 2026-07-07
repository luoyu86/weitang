package com.tianmu.biz.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.provider.Settings;
import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import com.vivo.identifier.IdentifierConstant;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class m0 {
    private static boolean a() {
        return (TianmuSDK.getInstance().getContext().getApplicationInfo().flags & 2) != 0;
    }

    private static boolean b() {
        return Debug.isDebuggerConnected();
    }

    private static boolean c() {
        return com.tianmu.biz.utils.y0.c.h().a(TianmuSDK.getInstance().getContext());
    }

    private static boolean d() {
        return x0.b() || x0.a();
    }

    private static int e() throws IllegalAccessException, InvocationTargetException {
        String strA = com.tianmu.biz.utils.y0.b.a().a("ro.secure");
        return (strA != null && "0".equals(strA)) ? 0 : 1;
    }

    private static boolean f() {
        Context context = TianmuSDK.getInstance().getContext();
        return context == null || Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
    }

    private static boolean g() {
        try {
            if (!a()) {
                if (!b()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean h() {
        if (e() == 0) {
            return true;
        }
        return j();
    }

    private static boolean i() {
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

    private static boolean j() {
        try {
            String[] strArr = {"/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/system/sbin/su", "/vendor/bin/su"};
            for (int i2 = 0; i2 < 10; i2++) {
                if (new File(strArr[i2]).exists()) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean k() {
        try {
            Context context = TianmuSDK.getInstance().getContext();
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

    public static boolean a(String str) {
        if ("11.11".equals(str)) {
            return true;
        }
        return (g() || i() || f() || k() || c() || h() || d()) ? false : true;
    }
}
