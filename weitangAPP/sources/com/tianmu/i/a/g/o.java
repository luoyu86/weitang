package com.tianmu.i.a.g;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tianmu.i.a.g.m;
import tianmu.com.samsung.android.deviceidservice.IDeviceIdService;

/* JADX INFO: loaded from: classes2.dex */
public class o implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12233a;

    public class a implements m.a {
        public a(o oVar) {
        }

        @Override // com.tianmu.i.a.g.m.a
        public String a(IBinder iBinder) {
            IDeviceIdService iDeviceIdServiceAsInterface = IDeviceIdService.Stub.asInterface(iBinder);
            if (iDeviceIdServiceAsInterface != null) {
                return iDeviceIdServiceAsInterface.getOAID();
            }
            throw new com.tianmu.i.a.d("IDeviceIdService is null");
        }
    }

    public o(Context context) {
        this.f12233a = context;
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        Context context = this.f12233a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            return false;
        }
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        if (this.f12233a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        m.a(this.f12233a, intent, bVar, new a(this));
    }
}
