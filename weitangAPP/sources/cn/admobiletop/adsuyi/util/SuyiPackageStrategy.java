package cn.admobiletop.adsuyi.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import cn.admobiletop.adsuyi.a.l.k;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SuyiPackageStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4355a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String[] f4356b = {"NUBIANX563J", "NUBIANX629J", "ONEPLUSONEPLUSA5010"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f4357c = false;

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

    /* JADX WARN: Code restructure failed: missing block: B:35:0x007c, code lost:
    
        if ("getAll".equalsIgnoreCase(r5.getMethodName()) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007e, code lost:
    
        cn.admobiletop.adsuyi.util.SuyiPackageStrategy.f4355a = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0080, code lost:
    
        return "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getSuyiPackageName(android.app.Application r8) {
        /*
            java.lang.String r0 = ""
            if (r8 == 0) goto L85
            android.content.Context r1 = r8.getBaseContext()
            if (r1 != 0) goto Lc
            goto L85
        Lc:
            android.content.Context r1 = r8.getBaseContext()
            java.lang.String r1 = r1.getPackageName()
            boolean r2 = cn.admobiletop.adsuyi.util.SuyiPackageStrategy.f4355a
            if (r2 == 0) goto L19
            return r1
        L19:
            boolean r2 = cn.admobiletop.adsuyi.util.SuyiPackageStrategy.f4357c
            if (r2 == 0) goto L1e
            return r1
        L1e:
            boolean r2 = withoutLowSystem()
            if (r2 == 0) goto L25
            return r1
        L25:
            boolean r2 = isShieldDevice()
            if (r2 == 0) goto L2c
            return r1
        L2c:
            cn.admobiletop.adsuyi.ADSuyiSdk r2 = cn.admobiletop.adsuyi.ADSuyiSdk.getInstance()
            android.content.Context r2 = r2.getContext()
            if (r2 != 0) goto L37
            return r1
        L37:
            cn.admobiletop.adsuyi.a.l.s r2 = cn.admobiletop.adsuyi.a.l.s.a()
            java.lang.String r3 = "suyi_is_use_package_strategy"
            r4 = 1
            r2.a(r3, r4)
            cn.admobiletop.adsuyi.a.l.s r2 = cn.admobiletop.adsuyi.a.l.s.a()
            java.lang.String r3 = "suyi_request_header_ctl"
            boolean r2 = r2.a(r3)
            if (r2 != 0) goto L4e
            return r1
        L4e:
            java.lang.String r8 = getProcessName(r8)
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L84
            java.lang.Thread r8 = java.lang.Thread.currentThread()     // Catch: java.lang.Exception -> L84
            java.lang.StackTraceElement[] r8 = r8.getStackTrace()     // Catch: java.lang.Exception -> L84
            int r2 = r8.length     // Catch: java.lang.Exception -> L84
            r3 = 0
        L62:
            if (r3 >= r2) goto L84
            r5 = r8[r3]     // Catch: java.lang.Exception -> L84
            java.lang.String r6 = "org.chromium.base.BuildInfo"
            java.lang.String r7 = r5.getClassName()     // Catch: java.lang.Exception -> L84
            boolean r6 = r6.equalsIgnoreCase(r7)     // Catch: java.lang.Exception -> L84
            if (r6 == 0) goto L81
            java.lang.String r8 = "getAll"
            java.lang.String r2 = r5.getMethodName()     // Catch: java.lang.Exception -> L84
            boolean r8 = r8.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> L84
            if (r8 == 0) goto L84
            cn.admobiletop.adsuyi.util.SuyiPackageStrategy.f4355a = r4     // Catch: java.lang.Exception -> L84
            return r0
        L81:
            int r3 = r3 + 1
            goto L62
        L84:
            return r1
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.admobiletop.adsuyi.util.SuyiPackageStrategy.getSuyiPackageName(android.app.Application):java.lang.String");
    }

    public static boolean isShieldDevice() {
        if (!Arrays.asList(f4356b).contains((k.d().k() + k.d().g()).replaceAll(" +", ""))) {
            return false;
        }
        f4357c = true;
        return true;
    }

    public static boolean withoutLowSystem() {
        return Build.VERSION.SDK_INT < 26;
    }
}
