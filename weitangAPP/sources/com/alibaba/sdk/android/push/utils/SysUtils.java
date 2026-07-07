package com.alibaba.sdk.android.push.utils;

import android.app.ActivityManager;
import android.content.Context;
import com.taobao.accs.utl.ALog;

/* JADX INFO: loaded from: classes.dex */
public class SysUtils {
    private static final String TAG = "com.alibaba.sdk.android.push.utils.SysUtils";
    private static Boolean isMainProcess;

    public static String getProcessName(Context context, int i2) {
        String str = "";
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                try {
                    if (runningAppProcessInfo.pid == i2) {
                        str = runningAppProcessInfo.processName;
                    }
                } catch (Exception unused) {
                    ALog.e(TAG, "获取进程名失败", new Object[0]);
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "getProcessName:get process name failed.", th, new Object[0]);
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isMainProcess(android.content.Context r5) {
        /*
            java.lang.Boolean r0 = com.alibaba.sdk.android.push.utils.SysUtils.isMainProcess
            if (r0 == 0) goto L9
            boolean r5 = r0.booleanValue()
            return r5
        L9:
            java.lang.String r0 = r5.getPackageName()
            r1 = 0
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch: java.lang.Throwable -> L3f
            android.content.pm.PackageInfo r0 = r2.getPackageInfo(r0, r1)     // Catch: java.lang.Throwable -> L3f
            android.content.pm.ApplicationInfo r0 = r0.applicationInfo     // Catch: java.lang.Throwable -> L3f
            java.lang.String r0 = r0.processName     // Catch: java.lang.Throwable -> L3f
            int r2 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L3f
            java.lang.String r5 = getProcessName(r5, r2)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r2 = ""
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L3f
            if (r2 != 0) goto L32
            boolean r5 = r0.equalsIgnoreCase(r5)     // Catch: java.lang.Throwable -> L3f
            if (r5 == 0) goto L32
            r5 = 1
            goto L33
        L32:
            r5 = 0
        L33:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L3a
            com.alibaba.sdk.android.push.utils.SysUtils.isMainProcess = r0     // Catch: java.lang.Throwable -> L3a
            goto L4b
        L3a:
            r0 = move-exception
            r4 = r0
            r0 = r5
            r5 = r4
            goto L41
        L3f:
            r5 = move-exception
            r0 = 0
        L41:
            java.lang.String r2 = com.alibaba.sdk.android.push.utils.SysUtils.TAG
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r3 = "isMainProcess:get process name failed."
            com.taobao.accs.utl.ALog.e(r2, r3, r5, r1)
            r5 = r0
        L4b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.push.utils.SysUtils.isMainProcess(android.content.Context):boolean");
    }
}
