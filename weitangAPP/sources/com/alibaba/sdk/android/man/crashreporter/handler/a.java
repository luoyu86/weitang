package com.alibaba.sdk.android.man.crashreporter.handler;

import android.content.Context;
import com.alibaba.sdk.android.man.crashreporter.IUTCrashCaughtListener;
import com.alibaba.sdk.android.man.crashreporter.MotuCrashReporter;
import com.alibaba.sdk.android.man.crashreporter.ReporterConfigure;
import com.alibaba.sdk.android.man.crashreporter.d.c;
import com.alibaba.sdk.android.man.crashreporter.e.i;
import com.alibaba.sdk.android.man.crashreporter.global.CrashReportDataForSave;
import com.alibaba.sdk.android.man.crashreporter.handler.nativeCrashHandler.NativeCrashHandler;
import com.alibaba.sdk.android.man.util.UTWrapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    private static int w = 61005;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4738a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.man.crashreporter.a.b f108a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f4739b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private c f110a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.man.crashreporter.c.b f109a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.man.crashreporter.handler.a.a f111a = null;
    private NativeCrashHandler nativeCrashHandler = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private com.alibaba.sdk.android.man.crashreporter.handler.b.a f112a = null;
    private AtomicBoolean crashing = new AtomicBoolean(false);

    @Override // com.alibaba.sdk.android.man.crashreporter.handler.b
    public boolean a(Context context, ReporterConfigure reporterConfigure, com.alibaba.sdk.android.man.crashreporter.c cVar) {
        String[] strArrSplit;
        try {
            if (context == null) {
                com.alibaba.sdk.android.man.crashreporter.b.a.e("init handler failure!");
                return false;
            }
            this.f4738a = context;
            this.f108a = new com.alibaba.sdk.android.man.crashreporter.a.a();
            this.f4739b = new com.alibaba.sdk.android.man.crashreporter.d.b();
            this.f110a = new com.alibaba.sdk.android.man.crashreporter.d.a(context, cVar);
            this.f109a = new com.alibaba.sdk.android.man.crashreporter.c.a();
            if (!this.f108a.a(context, reporterConfigure, cVar, this.f4739b, this.f110a) || !this.f4739b.c(context) || !this.f109a.a(context, this.f108a, this.f4739b, this.f110a)) {
                return false;
            }
            if (reporterConfigure.enableCatchUncaughtException) {
                this.f111a = new com.alibaba.sdk.android.man.crashreporter.handler.a.a(this.crashing, this);
            }
            if (reporterConfigure.enableCatchNativeException) {
                NativeCrashHandler nativeCrashHandlerInit = NativeCrashHandler.init(context);
                this.nativeCrashHandler = nativeCrashHandlerInit;
                if (nativeCrashHandlerInit.regist(this.crashing, this, reporterConfigure.enableDebug, cVar)) {
                    com.alibaba.sdk.android.man.crashreporter.b.a.e("native crash handler regist succ!");
                }
            }
            String str = cVar.appVersion;
            if (str != null && (strArrSplit = str.split("\\.")) != null && strArrSplit.length >= 4) {
                if (reporterConfigure.enableCatchANRException) {
                    this.f112a = new com.alibaba.sdk.android.man.crashreporter.handler.b.a(context, this, this.crashing, reporterConfigure.enabeANRTimeoutInterval, reporterConfigure.enableANRMainThreadOnly);
                }
                if (reporterConfigure.enableDebug) {
                    com.alibaba.sdk.android.man.crashreporter.handler.c.a.a("isDebug", cVar.appVersion);
                }
            }
            this.f109a.b(this.f108a.a(0, 0, 0, 0));
            return true;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("init handler err", e2);
            return false;
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m54b(String str) {
        try {
            if (this.f108a == null || this.f4739b == null || this.f4738a == null) {
                return;
            }
            com.alibaba.sdk.android.man.crashreporter.handler.c.b.a("TBCRASH_REPORTER_SDK", 2, w);
            com.alibaba.sdk.android.man.crashreporter.b.a.e("ANR handler start.");
            CrashReportDataForSave crashReportDataForSaveA = this.f108a.a(str);
            if (crashReportDataForSaveA != null && !a(crashReportDataForSaveA.content)) {
                this.f109a.a(crashReportDataForSaveA, this.f108a.a(0, 0, 0, 0), 2);
            }
            UTWrapper.commitCrashEvent();
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("handle stuck failure", e2);
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.handler.b
    public boolean c() {
        com.alibaba.sdk.android.man.crashreporter.handler.a.a aVar = this.f111a;
        if (aVar != null) {
            aVar.b();
            com.alibaba.sdk.android.man.crashreporter.b.a.e("Java crash handler is removed success.");
        } else {
            com.alibaba.sdk.android.man.crashreporter.b.a.e("Java crash handler is null.");
        }
        NativeCrashHandler nativeCrashHandler = this.nativeCrashHandler;
        if (nativeCrashHandler == null) {
            com.alibaba.sdk.android.man.crashreporter.b.a.e("Native crash handler is null.");
        } else if (!nativeCrashHandler.removeNativeCrashHandler()) {
            return false;
        }
        com.alibaba.sdk.android.man.crashreporter.handler.b.a aVar2 = this.f112a;
        if (aVar2 != null) {
            aVar2.c();
            return true;
        }
        com.alibaba.sdk.android.man.crashreporter.b.a.e("Stuck crash handler is null.");
        return true;
    }

    private String b(String str) {
        try {
            return !i.b(str) ? str.replaceAll("\n", "++") : str;
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("getMessageToUTArgs err.", e2);
            return str;
        }
    }

    public void a(Throwable th, Thread thread, String str, String str2) {
        try {
            if (this.f108a == null || this.f4739b == null || this.f4738a == null) {
                return;
            }
            com.alibaba.sdk.android.man.crashreporter.handler.c.b.a("TBCRASH_REPORTER_SDK", 0, w);
            com.alibaba.sdk.android.man.crashreporter.b.a.e("crash handler start.");
            Map mapA = a(th, thread);
            this.f108a.a(str, str2, b(str2), mapA);
            UTWrapper.commitCrashEvent();
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.a("handleJavaCrash err!", e2);
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            if (this.f108a == null || this.f4739b == null || this.f4738a == null) {
                return;
            }
            com.alibaba.sdk.android.man.crashreporter.b.a.e("native crash handler start.");
            this.f108a.b(str2, str, str3, a(null, null));
            UTWrapper.commitCrashEvent();
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("handle native stackTrace failure", e2);
        }
    }

    private boolean a(String str) {
        List mySenderListenerList = MotuCrashReporter.getInstance().getMySenderListenerList();
        if (mySenderListenerList != null) {
            try {
                if (mySenderListenerList.size() != 0) {
                    com.alibaba.sdk.android.man.crashreporter.b.a.e("start call sender listener!");
                    for (int i2 = 0; i2 < mySenderListenerList.size(); i2++) {
                        ((com.alibaba.sdk.android.man.crashreporter.a) mySenderListenerList.get(i2)).a(str);
                    }
                    return true;
                }
            } catch (Exception e2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("call sender listener err", e2);
            }
        }
        return false;
    }

    private Map a(Throwable th, Thread thread) {
        List myListenerList = MotuCrashReporter.getInstance().getMyListenerList();
        String strExtraInfo = MotuCrashReporter.getInstance().getStrExtraInfo();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < myListenerList.size(); i2++) {
            try {
                IUTCrashCaughtListener iUTCrashCaughtListener = (IUTCrashCaughtListener) myListenerList.get(i2);
                com.alibaba.sdk.android.man.crashreporter.b.a.b("ext listener is:", iUTCrashCaughtListener.toString());
                Map<String, Object> mapOnCrashCaught = iUTCrashCaughtListener.onCrashCaught(thread, th);
                if (mapOnCrashCaught != null) {
                    for (Map.Entry<String, Object> entry : mapOnCrashCaught.entrySet()) {
                        map.put(entry.getKey(), entry.getValue().toString());
                    }
                }
            } catch (Throwable th2) {
                com.alibaba.sdk.android.man.crashreporter.b.a.d("Listener's extraMsg store error.", th2);
                return null;
            }
        }
        if (strExtraInfo != null) {
            map.put("exaInfo", strExtraInfo);
        }
        if (map.size() > 0) {
            return map;
        }
        return null;
    }
}
