package com.alibaba.mtl.log.d;

import android.app.ActivityManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class b {
    private static String ai = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f4552g;

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        int iMyPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(packageName)) {
                    if (runningAppProcessInfo.importance == 400) {
                        return false;
                    }
                    if (powerManager.isScreenOn()) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String getAppkey() {
        return f4552g;
    }

    public static String k() {
        if (com.alibaba.mtl.log.a.getContext() == null) {
            return "";
        }
        try {
            String string = com.alibaba.mtl.log.a.getContext().getSharedPreferences("UTCommon", 0).getString("_lun", "");
            return !TextUtils.isEmpty(string) ? new String(c.decode(string.getBytes(), 2), "UTF-8") : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String l() {
        if (com.alibaba.mtl.log.a.getContext() == null) {
            return "";
        }
        try {
            String string = com.alibaba.mtl.log.a.getContext().getSharedPreferences("UTCommon", 0).getString("_luid", "");
            return !TextUtils.isEmpty(string) ? new String(c.decode(string.getBytes(), 2), "UTF-8") : "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m() {
        return ai;
    }

    public static String n() {
        return "";
    }

    public static String o() {
        return "";
    }

    public static void o(String str) {
        i.a("AppInfoUtil", "[setChannle]", str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iIndexOf = str.indexOf("@");
        if (iIndexOf == -1) {
            ai = str;
        } else {
            ai = str.substring(0, iIndexOf);
        }
    }

    public static void p(String str) {
        i.a("AppInfoUtil", "set Appkey:", str);
        f4552g = str;
    }
}
