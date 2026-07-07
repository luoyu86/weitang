package com.tianmu.d.c;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tianmu.TianmuSDK;
import com.tianmu.biz.utils.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Application f11972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11975d;

    /* JADX INFO: renamed from: com.tianmu.d.c.a$a, reason: collision with other inner class name */
    public class C0216a implements Application.ActivityLifecycleCallbacks {
        public C0216a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            if (!a.this.f11973b || a.this.f11972a == null) {
                return;
            }
            a.this.f11972a.unregisterActivityLifecycleCallbacks(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            String name = activity.getClass().getName();
            if (a.this.f11973b || !a.this.f11974c || com.tianmu.d.d.a.c(name)) {
                return;
            }
            com.tianmu.d.d.a.a(activity);
            a.this.f11973b = true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f11977a = new a(null);
    }

    public /* synthetic */ a(C0216a c0216a) {
        this();
    }

    private a() {
        this.f11975d = false;
    }

    public static a b() {
        return b.f11977a;
    }

    public void a(boolean z) {
        this.f11974c = z;
    }

    public void a() {
        if (this.f11975d) {
            return;
        }
        this.f11975d = true;
        if (TianmuSDK.getInstance().getContext() instanceof Activity) {
            this.f11972a = ((Activity) TianmuSDK.getInstance().getContext()).getApplication();
        } else {
            this.f11972a = e.b().a();
        }
        Application application = this.f11972a;
        if (application == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new C0216a());
    }
}
