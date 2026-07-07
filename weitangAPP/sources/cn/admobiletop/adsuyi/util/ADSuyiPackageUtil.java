package cn.admobiletop.adsuyi.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiPackageUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f4352b;

    public static String getAppName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getAppVersion(Context context) {
        if (f4352b == null && context != null) {
            try {
                f4352b = context.getPackageManager().getPackageInfo(getPackageName(context), 0).versionName;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return f4352b;
    }

    public static String getPackageName(Context context) {
        if (f4351a == null && context != null) {
            f4351a = context.getPackageName();
        }
        return f4351a;
    }

    public static String getProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.size() <= 0) {
                return null;
            }
            for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
                if (runningAppProcessInfo.pid == Process.myPid() && (str = runningAppProcessInfo.processName) != null) {
                    return str;
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean isMainProcess(Context context) {
        String packageName = getPackageName(context);
        return packageName != null && packageName.equals(getProcessName(context));
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
