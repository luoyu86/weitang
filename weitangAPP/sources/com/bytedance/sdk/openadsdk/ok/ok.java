package com.bytedance.sdk.openadsdk.ok;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Application.ActivityLifecycleCallbacks {
    private static volatile boolean ok = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6451a = 0;
    private InterfaceC0115ok bl;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.ok.ok$ok, reason: collision with other inner class name */
    public interface InterfaceC0115ok {
        void a();

        void ok();
    }

    public Boolean ok() {
        return Boolean.valueOf(ok);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        this.f6451a++;
        ok = false;
        InterfaceC0115ok interfaceC0115ok = this.bl;
        if (interfaceC0115ok != null) {
            interfaceC0115ok.a();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i2 = this.f6451a - 1;
        this.f6451a = i2;
        if (i2 == 0) {
            ok = true;
            InterfaceC0115ok interfaceC0115ok = this.bl;
            if (interfaceC0115ok != null) {
                interfaceC0115ok.ok();
            }
        }
    }

    public void ok(InterfaceC0115ok interfaceC0115ok) {
        this.bl = interfaceC0115ok;
    }
}
