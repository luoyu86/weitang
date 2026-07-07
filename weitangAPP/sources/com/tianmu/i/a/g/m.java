package com.tianmu.i.a.g;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class m implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.tianmu.i.a.b f12228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f12229c;

    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder);
    }

    private m(Context context, com.tianmu.i.a.b bVar, a aVar) {
        if (context instanceof Application) {
            this.f12227a = context;
        } else {
            this.f12227a = context.getApplicationContext();
        }
        this.f12228b = bVar;
        this.f12229c = aVar;
    }

    public static void a(Context context, Intent intent, com.tianmu.i.a.b bVar, a aVar) {
        new m(context, bVar, aVar).a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.tianmu.i.a.e.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                String strA = this.f12229c.a(iBinder);
                if (strA == null || strA.length() == 0) {
                    throw new com.tianmu.i.a.d("OAID/AAID acquire failed");
                }
                com.tianmu.i.a.e.a("OAID/AAID acquire success: " + strA);
                this.f12228b.a(strA);
                try {
                    this.f12227a.unbindService(this);
                    com.tianmu.i.a.e.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e2) {
                    com.tianmu.i.a.e.a(e2);
                }
            } catch (Exception e3) {
                com.tianmu.i.a.e.a(e3);
                this.f12228b.a(e3);
                try {
                    this.f12227a.unbindService(this);
                    com.tianmu.i.a.e.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e4) {
                    com.tianmu.i.a.e.a(e4);
                }
            }
        } catch (Throwable th) {
            try {
                this.f12227a.unbindService(this);
                com.tianmu.i.a.e.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e5) {
                com.tianmu.i.a.e.a(e5);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.tianmu.i.a.e.a("Service has been disconnected: " + componentName.getClassName());
    }

    private void a(Intent intent) {
        try {
            if (!this.f12227a.bindService(intent, this, 1)) {
                throw new com.tianmu.i.a.d("Service binding failed");
            }
            com.tianmu.i.a.e.a("Service has been bound: " + intent);
        } catch (Exception e2) {
            this.f12228b.a(e2);
        }
    }
}
