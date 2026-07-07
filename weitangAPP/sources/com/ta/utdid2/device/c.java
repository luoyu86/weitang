package com.ta.utdid2.device;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.ta.a.c.f;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f10219e;

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception e2) {
            f.a("", e2, new Object[0]);
            return null;
        }
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public static boolean m82c(Context context) {
        try {
            String strE = e(context);
            String strC = c(context);
            f.m80a("", "curProcessName", strC);
            if (!TextUtils.isEmpty(strC) && !TextUtils.isEmpty(strE)) {
                return strC.equals(strE);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String d(Context context) {
        int iMyPid;
        try {
            iMyPid = Process.myPid();
        } catch (Exception unused) {
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
            return null;
        }
        return null;
    }

    private static String e(Context context) {
        PackageInfo packageInfoA = a(context);
        return packageInfoA != null ? packageInfoA.packageName : "";
    }

    private static String n() {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return Application.getProcessName();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static String o() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable th) {
            f.a("", th, new Object[0]);
            return null;
        }
    }

    private static String c(Context context) {
        if (!TextUtils.isEmpty(f10219e)) {
            return f10219e;
        }
        String strN = n();
        f10219e = strN;
        f.m80a("", "currentProcessName", strN);
        if (!TextUtils.isEmpty(f10219e)) {
            return f10219e;
        }
        String strO = o();
        f10219e = strO;
        f.m80a("", "currentProcessName2", strO);
        if (!TextUtils.isEmpty(f10219e)) {
            return f10219e;
        }
        String strD = d(context);
        f10219e = strD;
        f.m80a("", "currentProcessName3", strD);
        return f10219e;
    }
}
