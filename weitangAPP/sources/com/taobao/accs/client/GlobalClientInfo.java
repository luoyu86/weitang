package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public class GlobalClientInfo {
    public static final String AGOO_SERVICE_ID = "agooSend";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f10249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f10250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile GlobalClientInfo f10251c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Map<String, String> f10252h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, ILoginInfo> f10253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ActivityManager f10254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConnectivityManager f10255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PackageInfo f10256g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, AccsAbstractDataListener> f10257i = new ConcurrentHashMap();

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        f10252h = concurrentHashMap;
        concurrentHashMap.put(AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        concurrentHashMap.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        concurrentHashMap.put("agooTokenReport", "org.android.agoo.accs.AgooService");
    }

    private GlobalClientInfo(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        if (f10249a == null) {
            f10249a = context.getApplicationContext();
        }
        ThreadPoolExecutorFactory.execute(new d(this));
    }

    public static Context getContext() {
        return f10249a;
    }

    public static GlobalClientInfo getInstance(Context context) {
        if (f10251c == null) {
            synchronized (GlobalClientInfo.class) {
                if (f10251c == null) {
                    f10251c = new GlobalClientInfo(context);
                }
            }
        }
        return f10251c;
    }

    public void clearLoginInfoImpl() {
        this.f10253d = null;
    }

    public ActivityManager getActivityManager() {
        if (this.f10254e == null) {
            this.f10254e = (ActivityManager) f10249a.getSystemService("activity");
        }
        return this.f10254e;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.f10255f == null) {
            this.f10255f = (ConnectivityManager) f10249a.getSystemService("connectivity");
        }
        return this.f10255f;
    }

    public AccsAbstractDataListener getListener(String str) {
        return this.f10257i.get(str);
    }

    public String getNick(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f10253d;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getNick();
    }

    public PackageInfo getPackageInfo() {
        try {
            if (this.f10256g == null) {
                this.f10256g = f10249a.getPackageManager().getPackageInfo(f10249a.getPackageName(), 0);
            }
        } catch (Throwable th) {
            ALog.e("GlobalClientInfo", "getPackageInfo", th, new Object[0]);
        }
        return this.f10256g;
    }

    public String getService(String str) {
        return f10252h.get(str);
    }

    public String getSid(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f10253d;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getSid();
    }

    public String getUserId(String str) {
        ILoginInfo iLoginInfo;
        ConcurrentHashMap<String, ILoginInfo> concurrentHashMap = this.f10253d;
        if (concurrentHashMap == null || (iLoginInfo = concurrentHashMap.get(str)) == null) {
            return null;
        }
        return iLoginInfo.getUserId();
    }

    public void registerListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        if (TextUtils.isEmpty(str) || accsAbstractDataListener == null) {
            return;
        }
        this.f10257i.put(str, accsAbstractDataListener);
    }

    public void registerService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        f10252h.put(str, str2);
    }

    public void setLoginInfoImpl(String str, ILoginInfo iLoginInfo) {
        if (this.f10253d == null) {
            this.f10253d = new ConcurrentHashMap<>(1);
        }
        if (iLoginInfo != null) {
            this.f10253d.put(str, iLoginInfo);
        }
    }

    public void unRegisterService(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f10252h.remove(str);
    }

    public void unregisterListener(String str) {
        this.f10257i.remove(str);
    }
}
