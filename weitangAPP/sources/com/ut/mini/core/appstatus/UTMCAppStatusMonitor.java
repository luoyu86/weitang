package com.ut.mini.core.appstatus;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.alibaba.mtl.log.d.s;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
public class UTMCAppStatusMonitor implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static UTMCAppStatusMonitor f12355a;
    private int K = 0;
    private boolean T = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ScheduledFuture<?> f155a = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object f12356e = new Object();
    private List<UTMCAppStatusCallbacks> m = new LinkedList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object f12357f = new Object();

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            UTMCAppStatusMonitor.this.T = false;
            synchronized (UTMCAppStatusMonitor.this.f12357f) {
                Iterator it = UTMCAppStatusMonitor.this.m.iterator();
                while (it.hasNext()) {
                    ((UTMCAppStatusCallbacks) it.next()).onSwitchBackground();
                }
            }
        }

        private a() {
        }
    }

    private UTMCAppStatusMonitor() {
    }

    private void J() {
        synchronized (this.f12356e) {
            s.a().f(11);
        }
    }

    public static synchronized UTMCAppStatusMonitor getInstance() {
        if (f12355a == null) {
            f12355a = new UTMCAppStatusMonitor();
        }
        return f12355a;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.f12357f) {
            Iterator<UTMCAppStatusCallbacks> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().onActivityCreated(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        synchronized (this.f12357f) {
            Iterator<UTMCAppStatusCallbacks> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        synchronized (this.f12357f) {
            Iterator<UTMCAppStatusCallbacks> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        synchronized (this.f12357f) {
            Iterator<UTMCAppStatusCallbacks> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().onActivityResumed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.f12357f) {
            Iterator<UTMCAppStatusCallbacks> it = this.m.iterator();
            while (it.hasNext()) {
                it.next().onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        J();
        this.K++;
        if (!this.T) {
            synchronized (this.f12357f) {
                Iterator<UTMCAppStatusCallbacks> it = this.m.iterator();
                while (it.hasNext()) {
                    it.next().onSwitchForeground();
                }
            }
        }
        this.T = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i2 = this.K - 1;
        this.K = i2;
        if (i2 == 0) {
            J();
            s.a().a(11, new a(), 1000L);
        }
    }

    public void registerAppStatusCallbacks(UTMCAppStatusCallbacks uTMCAppStatusCallbacks) {
        if (uTMCAppStatusCallbacks != null) {
            synchronized (this.f12357f) {
                this.m.add(uTMCAppStatusCallbacks);
            }
        }
    }

    public void unregisterAppStatusCallbacks(UTMCAppStatusCallbacks uTMCAppStatusCallbacks) {
        if (uTMCAppStatusCallbacks != null) {
            synchronized (this.f12357f) {
                this.m.remove(uTMCAppStatusCallbacks);
            }
        }
    }
}
