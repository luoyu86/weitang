package com.tianmu.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.os.Process;
import com.alipay.sdk.m.u.n;
import java.util.Arrays;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuPackageUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f12339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f12340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String[] f12341c = {"com.wudaokou.hippo", n.f5712b, "com.taobao.litetao", AgooConstants.TAOBAO_PACKAGE, "me.ele", "com.taobao.live", "com.tmall.wireless", "com.youku.phone", "com.xunmeng.pinduoduo", "com.achievo.vipshop", "com.jingdong.app.mall", "cn.soulapp.android", "com.quark.browser", "com.shuqi.controller", "com.autonavi.minimap", "com.sankuai.meituan"};

    private static boolean a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    private static List<String> b() {
        return Arrays.asList(f12341c);
    }

    public static JSONArray getAppInstalledPackages(Context context) {
        JSONArray jSONArray = new JSONArray();
        if (!com.tianmu.c.n.n.D().u()) {
            return jSONArray;
        }
        List<String> listA = a();
        if (listA.size() == 0) {
            return jSONArray;
        }
        try {
            for (String str : listA) {
                if (a(context, str)) {
                    jSONArray.put(str);
                }
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }

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
        if (f12340b == null && context != null) {
            try {
                f12340b = context.getPackageManager().getPackageInfo(getPackageName(context), 0).versionName;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return f12340b;
    }

    public static String getPackageName(Context context) {
        if (f12339a == null && context != null) {
            f12339a = context.getPackageName();
        }
        return f12339a;
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

    private static List<String> a() {
        List<String> listE = com.tianmu.c.n.n.D().e();
        return (listE == null || listE.size() == 0) ? b() : listE;
    }
}
