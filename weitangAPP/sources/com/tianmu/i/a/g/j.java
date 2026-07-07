package com.tianmu.i.a.g;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.tianmu.i.a.g.m;
import tianmu.com.bun.lib.MsaIdInterface;

/* JADX INFO: loaded from: classes2.dex */
public class j implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12224a;

    public class a implements m.a {
        public a(j jVar) {
        }

        @Override // com.tianmu.i.a.g.m.a
        public String a(IBinder iBinder) {
            MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
            if (msaIdInterfaceAsInterface == null) {
                throw new com.tianmu.i.a.d("MsaIdInterface is null");
            }
            if (msaIdInterfaceAsInterface.isSupported()) {
                return msaIdInterfaceAsInterface.getOAID();
            }
            throw new com.tianmu.i.a.d("MsaIdInterface#isSupported return false");
        }
    }

    public j(Context context) {
        this.f12224a = context;
    }

    private void b() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.f12224a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.f12224a.startService(intent);
            } else {
                this.f12224a.startForegroundService(intent);
            }
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
        }
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        Context context = this.f12224a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            return false;
        }
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        if (this.f12224a == null || bVar == null) {
            return;
        }
        b();
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.f12224a.getPackageName());
        m.a(this.f12224a, intent, bVar, new a(this));
    }
}
