package anet.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class GlobalAppRuntimeInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f313a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f319g;
    private static volatile long k;
    private static String l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ENV f314b = ENV.ONLINE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f315c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f316d = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile boolean f320h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static SharedPreferences f321i = null;
    private static volatile CopyOnWriteArrayList<String> j = null;

    public static void addBucketInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.length() > 32 || str2.length() > 32) {
            return;
        }
        synchronized (GlobalAppRuntimeInfo.class) {
            if (j == null) {
                j = new CopyOnWriteArrayList<>();
            }
            j.add(str);
            j.add(str2);
        }
    }

    public static CopyOnWriteArrayList<String> getBucketInfo() {
        return j;
    }

    public static Context getContext() {
        return f313a;
    }

    public static String getCurrentProcess() {
        return f316d;
    }

    public static ENV getEnv() {
        return f314b;
    }

    @Deprecated
    public static long getInitTime() {
        return k;
    }

    @Deprecated
    public static int getStartType() {
        anet.channel.fulltrace.b sceneInfo = anet.channel.fulltrace.a.a().getSceneInfo();
        if (sceneInfo != null) {
            return sceneInfo.f471a;
        }
        return -1;
    }

    public static String getTtid() {
        return f317e;
    }

    public static String getUserId() {
        return f318f;
    }

    public static String getUtdid() {
        Context context;
        if (f319g == null && (context = f313a) != null) {
            f319g = Utils.getDeviceId(context);
        }
        return f319g;
    }

    public static boolean isAppBackground() {
        if (f313a == null) {
            return true;
        }
        return f320h;
    }

    public static boolean isTargetProcess() {
        if (TextUtils.isEmpty(f315c) || TextUtils.isEmpty(f316d)) {
            return true;
        }
        return f315c.equalsIgnoreCase(f316d);
    }

    public static void setBackground(boolean z) {
        f320h = z;
    }

    public static void setContext(Context context) {
        f313a = context;
        if (context != null) {
            if (TextUtils.isEmpty(f316d)) {
                f316d = Utils.getProcessName(context, Process.myPid());
            }
            if (TextUtils.isEmpty(f315c)) {
                f315c = Utils.getMainProcessName(context);
            }
            if (f321i == null) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                f321i = defaultSharedPreferences;
                f318f = defaultSharedPreferences.getString("UserId", null);
            }
            ALog.e("awcn.GlobalAppRuntimeInfo", "", null, "CurrentProcess", f316d, "TargetProcess", f315c);
        }
    }

    public static void setCurrentProcess(String str) {
        f316d = str;
    }

    public static void setEnv(ENV env) {
        f314b = env;
    }

    @Deprecated
    public static void setInitTime(long j2) {
        k = j2;
    }

    public static void setTargetProcess(String str) {
        f315c = str;
    }

    public static void setTtid(String str) {
        f317e = str;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int iIndexOf = str.indexOf("@");
            String strSubstring = null;
            String strSubstring2 = iIndexOf != -1 ? str.substring(0, iIndexOf) : null;
            String strSubstring3 = str.substring(iIndexOf + 1);
            int iLastIndexOf = strSubstring3.lastIndexOf("_");
            if (iLastIndexOf != -1) {
                String strSubstring4 = strSubstring3.substring(0, iLastIndexOf);
                strSubstring = strSubstring3.substring(iLastIndexOf + 1);
                strSubstring3 = strSubstring4;
            }
            l = strSubstring;
            AmdcRuntimeInfo.setAppInfo(strSubstring3, strSubstring, strSubstring2);
        } catch (Exception unused) {
        }
    }

    public static void setUserId(String str) {
        String str2 = f318f;
        if (str2 == null || !str2.equals(str)) {
            f318f = str;
            StrategyCenter.getInstance().forceRefreshStrategy(DispatchConstants.getAmdcServerDomain());
            SharedPreferences sharedPreferences = f321i;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("UserId", str).apply();
            }
        }
    }

    public static void setUtdid(String str) {
        String str2 = f319g;
        if (str2 == null || !str2.equals(str)) {
            f319g = str;
        }
    }

    public static boolean isTargetProcess(String str) {
        if (TextUtils.isEmpty(f315c) || TextUtils.isEmpty(str)) {
            return true;
        }
        return f315c.equalsIgnoreCase(str);
    }
}
