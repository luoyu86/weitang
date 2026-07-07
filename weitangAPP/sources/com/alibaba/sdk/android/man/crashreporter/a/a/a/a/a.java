package com.alibaba.sdk.android.man.crashreporter.a.a.a.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.alibaba.sdk.android.man.crashreporter.MotuCrashReporter;
import com.alibaba.sdk.android.man.crashreporter.e.i;
import com.alibaba.sdk.android.man.crashreporter.global.BaseDataContent;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a implements com.alibaba.sdk.android.man.crashreporter.a.a.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ComponentName f4684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f87a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.alibaba.sdk.android.man.crashreporter.a.b f88a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.alibaba.sdk.android.man.crashreporter.d.c f89a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Object f90a = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f4685q;

    /* JADX INFO: renamed from: com.alibaba.sdk.android.man.crashreporter.a.a.a.a.a$a, reason: collision with other inner class name */
    @TargetApi(14)
    public class C0060a implements Application.ActivityLifecycleCallbacks {
        public C0060a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            a.this.f4684a = activity.getComponentName();
            a.this.f4685q = "onActivityCreated";
            a.this.f4685q = String.format("%s:%s", "onActivityCreated", Long.valueOf(System.currentTimeMillis()));
            com.alibaba.sdk.android.man.crashreporter.b.a.e("onActivityCreated");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            a.this.f4684a = activity.getComponentName();
            a.this.f4685q = "onActivityDestroyed";
            a.this.f4685q = String.format("%s:%s", "onActivityDestroyed", Long.valueOf(System.currentTimeMillis()));
            com.alibaba.sdk.android.man.crashreporter.b.a.e("onActivityDestroyed");
            synchronized (a.this.f90a) {
                a aVar = a.this;
                if (aVar.f89a != null) {
                    aVar.a(2);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            a.this.f4684a = activity.getComponentName();
            a.this.f4685q = String.format("%s:%s", "onActivityPaused", Long.valueOf(System.currentTimeMillis()));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            a.this.f4684a = activity.getComponentName();
            a.this.f4685q = "onActivityResumed";
            a.this.f4685q = String.format("%s:%s", "onActivityResumed", Long.valueOf(System.currentTimeMillis()));
            com.alibaba.sdk.android.man.crashreporter.b.a.e("onActivityResumed");
            synchronized (a.this.f90a) {
                a aVar = a.this;
                if (aVar.f89a != null) {
                    aVar.a(1);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            a.this.f4684a = activity.getComponentName();
            a.this.f4685q = String.format("%s:%s", "onActivitySaveInstanceState", Long.valueOf(System.currentTimeMillis()));
            com.alibaba.sdk.android.man.crashreporter.b.a.e("onActivitySaveInstanceState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            a.this.f4684a = activity.getComponentName();
            a.this.f4685q = String.format("%s:%s", "onActivityStarted", Long.valueOf(System.currentTimeMillis()));
            com.alibaba.sdk.android.man.crashreporter.b.a.e("onActivityStarted");
            synchronized (a.this.f90a) {
                a aVar = a.this;
                if (aVar.f89a != null) {
                    aVar.a(1);
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            a.this.f4684a = activity.getComponentName();
            a.this.f4685q = "onActivityStopped";
            a.this.f4685q = String.format("%s:%s", "onActivityStopped", Long.valueOf(System.currentTimeMillis()));
            com.alibaba.sdk.android.man.crashreporter.b.a.e("onActivityStopped");
            synchronized (a.this.f90a) {
                a aVar = a.this;
                if (aVar.f89a != null) {
                    aVar.a(2);
                }
            }
        }
    }

    public a(Context context, com.alibaba.sdk.android.man.crashreporter.d.c cVar, com.alibaba.sdk.android.man.crashreporter.a.b bVar) {
        this.f89a = null;
        this.f88a = null;
        this.f87a = context;
        a();
        this.f89a = cVar;
        this.f88a = bVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String c() {
        /*
            r4 = this;
            android.content.Context r0 = r4.f87a
            java.lang.String r1 = ""
            if (r0 == 0) goto L30
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch: java.lang.Exception -> L2a
            if (r0 == 0) goto L30
            android.content.ComponentName r2 = r4.f4684a     // Catch: java.lang.Exception -> L2a
            if (r2 == 0) goto L30
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ActivityInfo r0 = r0.getActivityInfo(r2, r3)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L23 java.lang.Exception -> L2a
            if (r0 == 0) goto L30
            android.os.Bundle r0 = r0.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L23 java.lang.Exception -> L2a
            if (r0 == 0) goto L30
            java.lang.String r2 = "bundleLocation"
            java.lang.String r0 = r0.getString(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L23 java.lang.Exception -> L2a
            goto L31
        L23:
            r0 = move-exception
            java.lang.String r2 = "get bundle failed."
            com.alibaba.sdk.android.man.crashreporter.b.a.d(r2, r0)     // Catch: java.lang.Exception -> L2a
            goto L30
        L2a:
            r0 = move-exception
            java.lang.String r2 = "system error, getBundle failed"
            com.alibaba.sdk.android.man.crashreporter.b.a.d(r2, r0)
        L30:
            r0 = r1
        L31:
            if (r0 == 0) goto L34
            r1 = r0
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.man.crashreporter.a.a.a.a.a.c():java.lang.String");
    }

    private String d() {
        ComponentName componentName = this.f4684a;
        return componentName != null ? componentName.getClassName() : "";
    }

    public String b() {
        return !i.a((CharSequence) this.f4685q) ? this.f4685q : "";
    }

    @TargetApi(14)
    private void a() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 14) {
            if (this.f87a.getApplicationContext() instanceof Application) {
                ((Application) this.f87a.getApplicationContext()).registerActivityLifecycleCallbacks(new C0060a());
                return;
            }
            return;
        }
        com.alibaba.sdk.android.man.crashreporter.b.a.g(String.format("build version %s not suppert registerActivityLifecycleCallbacks, registerActivityLifecycleCallbacks failed", Integer.valueOf(i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        try {
            BaseDataContent baseDataContentA = this.f89a.a();
            if (baseDataContentA == null) {
                baseDataContentA = new BaseDataContent();
            }
            if (i2 == 2) {
                this.f88a.a(MotuCrashReporter.getInstance().getConfigure(), baseDataContentA, 2);
            } else if (i2 == 1) {
                this.f88a.a(MotuCrashReporter.getInstance().getConfigure(), baseDataContentA, 1);
            }
        } catch (Exception e2) {
            com.alibaba.sdk.android.man.crashreporter.b.a.d("write app status err", e2);
        }
    }

    @Override // com.alibaba.sdk.android.man.crashreporter.a.a.a.c
    public void a(Map<com.alibaba.sdk.android.man.crashreporter.global.a, String> map) {
        map.put(com.alibaba.sdk.android.man.crashreporter.global.a.ACTIVITY, d());
        map.put(com.alibaba.sdk.android.man.crashreporter.global.a.ACTIVITY_STATUS, b());
        map.put(com.alibaba.sdk.android.man.crashreporter.global.a.BUNDLE, c());
    }
}
