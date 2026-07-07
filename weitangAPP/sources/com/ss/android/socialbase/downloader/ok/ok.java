package com.ss.android.socialbase.downloader.ok;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.socialbase.downloader.q.kf;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private bl f10151a;
    private final List<InterfaceC0174ok> bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f10152h;
    private volatile int kf;
    private WeakReference<Activity> n;
    private Application ok;
    private final Application.ActivityLifecycleCallbacks p;
    private int s;

    public static class a {
        private static final ok ok = new ok();
    }

    public interface bl {
    }

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.ok.ok$ok, reason: collision with other inner class name */
    public interface InterfaceC0174ok {
        @MainThread
        void a();

        @MainThread
        void bl();
    }

    private boolean h() {
        try {
            Application application = this.ok;
            if (application == null) {
                return false;
            }
            return TextUtils.equals(application.getPackageName(), kf.s(application));
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf() {
        this.kf = 0;
        Object[] objArrS = s();
        if (objArrS != null) {
            for (Object obj : objArrS) {
                ((InterfaceC0174ok) obj).bl();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.kf = 1;
        Object[] objArrS = s();
        if (objArrS != null) {
            for (Object obj : objArrS) {
                ((InterfaceC0174ok) obj).a();
            }
        }
    }

    private Object[] s() {
        Object[] array;
        synchronized (this.bl) {
            array = this.bl.size() > 0 ? this.bl.toArray() : null;
        }
        return array;
    }

    private ok() {
        this.bl = new ArrayList();
        this.kf = -1;
        this.f10152h = false;
        this.p = new Application.ActivityLifecycleCallbacks() { // from class: com.ss.android.socialbase.downloader.ok.ok.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                ok.this.f10152h = true;
                if (ok.this.s != 0 || activity == null) {
                    return;
                }
                ok.this.s = activity.hashCode();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                int i2 = ok.this.s;
                ok.this.f10152h = false;
                ok.this.s = activity != null ? activity.hashCode() : i2;
                if (i2 == 0) {
                    ok.this.n();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                ok.this.n = new WeakReference(activity);
                int i2 = ok.this.s;
                ok.this.s = activity != null ? activity.hashCode() : i2;
                ok.this.f10152h = false;
                if (i2 == 0) {
                    ok.this.n();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                if (activity != null && activity.hashCode() == ok.this.s) {
                    ok.this.s = 0;
                    ok.this.kf();
                }
                ok.this.f10152h = false;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    public boolean a() {
        int i2 = this.kf;
        ?? r0 = i2;
        if (i2 == -1) {
            ?? H = h();
            this.kf = H;
            r0 = H;
        }
        return r0 == 1;
    }

    public boolean bl() {
        return a() && !this.f10152h;
    }

    public static ok ok() {
        return a.ok;
    }

    public void a(InterfaceC0174ok interfaceC0174ok) {
        synchronized (this.bl) {
            this.bl.remove(interfaceC0174ok);
        }
    }

    public void ok(Context context) {
        if (this.ok == null && (context instanceof Application)) {
            synchronized (this) {
                if (this.ok == null) {
                    Application application = (Application) context;
                    this.ok = application;
                    application.registerActivityLifecycleCallbacks(this.p);
                }
            }
        }
    }

    public void ok(bl blVar) {
        this.f10151a = blVar;
    }

    public void ok(InterfaceC0174ok interfaceC0174ok) {
        if (interfaceC0174ok == null) {
            return;
        }
        synchronized (this.bl) {
            if (!this.bl.contains(interfaceC0174ok)) {
                this.bl.add(interfaceC0174ok);
            }
        }
    }
}
