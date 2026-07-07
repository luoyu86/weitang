package com.tianmu.i.a.g;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tianmu.i.a.g.m;
import tianmu.com.coolpad.deviceidsupport.IDeviceIdManager;

/* JADX INFO: loaded from: classes2.dex */
public class b implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12211a;

    public class a implements m.a {
        public a() {
        }

        @Override // com.tianmu.i.a.g.m.a
        public String a(IBinder iBinder) {
            IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
            if (iDeviceIdManagerAsInterface != null) {
                return iDeviceIdManagerAsInterface.getOAID(b.this.f12211a.getPackageName());
            }
            throw new com.tianmu.i.a.d("IDeviceIdManager is null");
        }
    }

    public b(Context context) {
        if (context instanceof Application) {
            this.f12211a = context;
        } else {
            this.f12211a = context.getApplicationContext();
        }
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        Context context = this.f12211a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            return false;
        }
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        if (this.f12211a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        m.a(this.f12211a, intent, bVar, new a());
    }
}
