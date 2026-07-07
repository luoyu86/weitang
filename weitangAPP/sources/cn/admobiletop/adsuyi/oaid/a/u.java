package cn.admobiletop.adsuyi.oaid.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class u implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IGetter f4330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f4331c;

    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder);
    }

    public u(Context context, IGetter iGetter, a aVar) {
        if (context instanceof Application) {
            this.f4329a = context;
        } else {
            this.f4329a = context.getApplicationContext();
        }
        this.f4330b = iGetter;
        this.f4331c = aVar;
    }

    public static void a(Context context, Intent intent, IGetter iGetter, a aVar) {
        new u(context, iGetter, aVar).b(intent);
    }

    public final void b(Intent intent) {
        try {
            if (!this.f4329a.bindService(intent, this, 1)) {
                throw new cn.admobiletop.adsuyi.oaid.c("Service binding failed");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Service has been bound: ");
            sb.append(intent);
            cn.admobiletop.adsuyi.oaid.d.a(sb.toString());
        } catch (Exception e2) {
            this.f4330b.onOAIDGetError(e2);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        cn.admobiletop.adsuyi.oaid.d.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                String strA = this.f4331c.a(iBinder);
                if (strA == null || strA.length() == 0) {
                    throw new cn.admobiletop.adsuyi.oaid.c("OAID/AAID acquire failed");
                }
                StringBuilder sb = new StringBuilder();
                sb.append("OAID/AAID acquire success: ");
                sb.append(strA);
                cn.admobiletop.adsuyi.oaid.d.a(sb.toString());
                this.f4330b.onOAIDGetComplete(strA);
                try {
                    this.f4329a.unbindService(this);
                    cn.admobiletop.adsuyi.oaid.d.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e2) {
                    cn.admobiletop.adsuyi.oaid.d.a(e2);
                }
            } catch (Exception e3) {
                cn.admobiletop.adsuyi.oaid.d.a(e3);
                this.f4330b.onOAIDGetError(e3);
                try {
                    this.f4329a.unbindService(this);
                    cn.admobiletop.adsuyi.oaid.d.a("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e4) {
                    cn.admobiletop.adsuyi.oaid.d.a(e4);
                }
            }
        } catch (Throwable th) {
            try {
                this.f4329a.unbindService(this);
                cn.admobiletop.adsuyi.oaid.d.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e5) {
                cn.admobiletop.adsuyi.oaid.d.a(e5);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        cn.admobiletop.adsuyi.oaid.d.a("Service has been disconnected: " + componentName.getClassName());
    }
}
