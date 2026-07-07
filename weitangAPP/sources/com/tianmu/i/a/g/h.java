package com.tianmu.i.a.g;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tianmu.i.a.g.m;
import tianmu.com.zui.deviceidservice.IDeviceidInterface;

/* JADX INFO: loaded from: classes2.dex */
public class h implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12222a;

    public class a implements m.a {
        public a(h hVar) {
        }

        @Override // com.tianmu.i.a.g.m.a
        public String a(IBinder iBinder) {
            IDeviceidInterface iDeviceidInterfaceAsInterface = IDeviceidInterface.Stub.asInterface(iBinder);
            if (iDeviceidInterfaceAsInterface == null) {
                throw new com.tianmu.i.a.d("IDeviceidInterface is null");
            }
            if (iDeviceidInterfaceAsInterface.isSupport()) {
                return iDeviceidInterfaceAsInterface.getOAID();
            }
            throw new com.tianmu.i.a.d("IDeviceidInterface#isSupport return false");
        }
    }

    public h(Context context) {
        this.f12222a = context;
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        Context context = this.f12222a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            return false;
        }
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        if (this.f12222a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        m.a(this.f12222a, intent, bVar, new a(this));
    }
}
