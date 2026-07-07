package com.alipay.sdk.m.r0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.alipay.sdk.m.q0.a;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f5625e = "OpenDeviceId library";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f5626f = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.alipay.sdk.m.q0.a f5628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ServiceConnection f5629c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5627a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0088b f5630d = null;

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f5628b = a.AbstractBinderC0086a.a(iBinder);
            if (b.this.f5630d != null) {
                b.this.f5630d.a("Deviceid Service Connected", b.this);
            }
            b.this.b("Service onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f5628b = null;
            b.this.b("Service onServiceDisconnected");
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.r0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0088b<T> {
        void a(T t, b bVar);
    }

    public String b() {
        if (this.f5627a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            com.alipay.sdk.m.q0.a aVar = this.f5628b;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        } catch (RemoteException e2) {
            a("getOAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public String c() {
        if (this.f5627a == null) {
            a("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            com.alipay.sdk.m.q0.a aVar = this.f5628b;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        } catch (RemoteException e2) {
            a("getUDID error, RemoteException!");
            e2.printStackTrace();
            return null;
        } catch (Exception e3) {
            a("getUDID error, Exception!");
            e3.printStackTrace();
            return null;
        }
    }

    public String d() {
        Context context = this.f5627a;
        if (context == null) {
            b("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        String packageName = context.getPackageName();
        b("liufeng, getVAID package：" + packageName);
        if (packageName == null || packageName.equals("")) {
            b("input package is null!");
            return null;
        }
        try {
            com.alipay.sdk.m.q0.a aVar = this.f5628b;
            if (aVar != null) {
                return aVar.b(packageName);
            }
            return null;
        } catch (RemoteException e2) {
            a("getVAID error, RemoteException!");
            e2.printStackTrace();
            return null;
        }
    }

    public boolean e() {
        try {
            if (this.f5628b == null) {
                return false;
            }
            b("Device support opendeviceid");
            return this.f5628b.c();
        } catch (RemoteException unused) {
            a("isSupport error, RemoteException!");
            return false;
        }
    }

    public void f() {
        try {
            this.f5627a.unbindService(this.f5629c);
            b("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            a("unBind Service exception");
        }
        this.f5628b = null;
    }

    public int a(Context context, InterfaceC0088b<String> interfaceC0088b) {
        Objects.requireNonNull(context, "Context can not be null.");
        this.f5627a = context;
        this.f5630d = interfaceC0088b;
        this.f5629c = new a();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (this.f5627a.bindService(intent, this.f5629c, 1)) {
            b("bindService Successful!");
            return 1;
        }
        b("bindService Failed!");
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (f5626f) {
            Log.i(f5625e, str);
        }
    }

    public String a() {
        Context context = this.f5627a;
        if (context != null) {
            String packageName = context.getPackageName();
            b("liufeng, getAAID package：" + packageName);
            if (packageName != null && !packageName.equals("")) {
                try {
                    com.alipay.sdk.m.q0.a aVar = this.f5628b;
                    if (aVar == null) {
                        return null;
                    }
                    String strA = aVar.a(packageName);
                    return ((strA == null || "".equals(strA)) && this.f5628b.c(packageName)) ? this.f5628b.a(packageName) : strA;
                } catch (RemoteException unused) {
                    a("getAAID error, RemoteException!");
                    return null;
                }
            }
            b("input package is null!");
            return null;
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void a(boolean z) {
        f5626f = z;
    }

    private void a(String str) {
        if (f5626f) {
            Log.e(f5625e, str);
        }
    }
}
