package com.alibaba.sdk.android.man.crashreporter;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public final class MotuCrashReporter {
    private static MotuCrashReporter instance;
    private ReporterConfigure configure;
    private c environment;
    private long startupTime = System.currentTimeMillis();
    private AtomicBoolean isEnable = new AtomicBoolean(true);
    private int crashReporterState = -1;
    private com.alibaba.sdk.android.man.crashreporter.handler.b crashReportManager = null;
    public List myExtListenerList = new ArrayList();
    public List mySenderListenerList = new ArrayList();
    private String strExtraInfo = null;

    private MotuCrashReporter() {
    }

    public static MotuCrashReporter getInstance() {
        if (instance == null) {
            initMotuCrashReporter();
        }
        return instance;
    }

    private static synchronized MotuCrashReporter initMotuCrashReporter() {
        if (instance == null) {
            instance = new MotuCrashReporter();
        }
        return instance;
    }

    public boolean enable(Context context, String str, String str2, String str3, String str4, ReporterConfigure reporterConfigure) {
        AtomicBoolean atomicBoolean = this.isEnable;
        if (atomicBoolean != null && atomicBoolean.get()) {
            if (reporterConfigure != null) {
                this.configure = reporterConfigure;
            } else {
                this.configure = new ReporterConfigure();
            }
            try {
                String str5 = context.getApplicationInfo().packageName;
                if (str5 == null || !str5.equals(AgooConstants.TAOBAO_PACKAGE)) {
                    com.alibaba.sdk.android.man.crashreporter.b.a.e("package name:" + str5);
                    if (str != null) {
                        if (str2 == null) {
                        }
                    }
                    com.alibaba.sdk.android.man.crashreporter.b.a.e("enable failure. because context or appKey or appVersion equal to null!");
                    return false;
                }
                com.alibaba.sdk.android.man.crashreporter.b.a.e("package name:" + str5);
                com.alibaba.sdk.android.man.crashreporter.b.a.b("start enable. context:", context.toString());
                com.alibaba.sdk.android.man.crashreporter.b.a.b("start enable. appKey: ", str == null ? "use taobao detault" : str);
                com.alibaba.sdk.android.man.crashreporter.b.a.b("start enable. appVersion: ", str2 == null ? "use taobao default" : str2);
                if (this.environment == null) {
                    this.environment = new c();
                }
                c cVar = this.environment;
                cVar.appKey = str;
                cVar.appVersion = str2;
                cVar.channel = str3;
                cVar.userNick = str4;
                cVar.startupTime = this.startupTime;
                com.alibaba.sdk.android.man.crashreporter.handler.a aVar = new com.alibaba.sdk.android.man.crashreporter.handler.a();
                this.crashReportManager = aVar;
                if (aVar.a(context, this.configure, this.environment)) {
                    com.alibaba.sdk.android.man.crashreporter.b.a.e("enable succ!");
                    return true;
                }
                com.alibaba.sdk.android.man.crashreporter.b.a.e("enable failure!");
                return true;
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("enable err", e2);
            }
        }
        return false;
    }

    public ReporterConfigure getConfigure() {
        return this.configure;
    }

    public int getCrashReporterState() {
        return this.crashReporterState;
    }

    public List getMyListenerList() {
        return this.myExtListenerList;
    }

    public List getMySenderListenerList() {
        return this.mySenderListenerList;
    }

    public String getStrExtraInfo() {
        return this.strExtraInfo;
    }

    public void setAppVersion(String str) {
        if (this.environment == null) {
            this.environment = new c();
        }
        if (str != null) {
            com.alibaba.sdk.android.man.crashreporter.b.a.b("set appVersion succ!", str);
            this.environment.appVersion = str;
        }
    }

    public void setCrashCaughtListener(IUTCrashCaughtListener iUTCrashCaughtListener) {
        com.alibaba.sdk.android.man.crashreporter.b.a.b("setCrashCaughtListener", iUTCrashCaughtListener == null ? "ext listener is null" : iUTCrashCaughtListener.toString());
        List list = this.myExtListenerList;
        if (list != null) {
            list.add(iUTCrashCaughtListener);
        }
    }

    public void setCrashReporterState(int i2) {
        this.crashReporterState = i2;
    }

    public void setExtraInfo(String str) {
        this.strExtraInfo = str;
    }

    public void setSenderListener(a aVar) {
        com.alibaba.sdk.android.man.crashreporter.b.a.b("setSenderListener", aVar == null ? "sender listener is null" : aVar.toString());
        List list = this.mySenderListenerList;
        if (list != null) {
            list.add(aVar);
        }
    }

    public void setTTid(String str) {
        if (this.environment == null) {
            this.environment = new c();
        }
        if (str != null) {
            com.alibaba.sdk.android.man.crashreporter.b.a.b("set ttid succ!", str);
            this.environment.channel = str;
        }
    }

    public void setUserNick(String str) {
        if (this.environment == null) {
            this.environment = new c();
        }
        if (str != null) {
            com.alibaba.sdk.android.man.crashreporter.b.a.b("set user nick succ!", str);
            this.environment.userNick = str;
        }
    }

    public boolean turnoffCrashReporter() {
        com.alibaba.sdk.android.man.crashreporter.handler.b bVar;
        if (!this.isEnable.compareAndSet(true, false) || (bVar = this.crashReportManager) == null) {
            return false;
        }
        return bVar.c();
    }
}
