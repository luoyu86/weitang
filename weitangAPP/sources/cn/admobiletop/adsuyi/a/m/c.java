package cn.admobiletop.adsuyi.a.m;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.tsplugin.adapter.CrashPluginAdapter;
import java.lang.Thread;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class c implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f3430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f3431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3432c = System.currentTimeMillis();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f3433d = Thread.getDefaultUncaughtExceptionHandler();

    public c(Context context) {
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f3431b = context;
    }

    public static c a(Context context) {
        c cVar = f3430a;
        if (cVar == null) {
            synchronized (c.class) {
                cVar = f3430a;
                if (cVar == null) {
                    cVar = new c(context.getApplicationContext());
                    f3430a = cVar;
                }
            }
        }
        return cVar;
    }

    public final void b(Throwable th) {
        if (th == null) {
            return;
        }
        cn.admobiletop.adsuyi.a.a.d.a(Log.getStackTraceString(th));
        c(th);
    }

    public final void c(Throwable th) {
        if (th == null || this.f3431b == null || !a()) {
            return;
        }
        try {
            CrashPluginAdapter.getInstance().insert(th, this.f3432c, ADSuyiSdk.getInstance().getSdkVersion());
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (thread != null && "FinalizerWatchdogDaemon".equals(thread.getName()) && (th instanceof TimeoutException)) {
            return;
        }
        b(th);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f3433d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        } else {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    public boolean a() {
        return cn.admobiletop.adsuyi.a.l.h.l().c() || ADSuyiSdk.getInstance().isDebug();
    }
}
