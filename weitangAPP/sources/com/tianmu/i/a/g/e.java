package com.tianmu.i.a.g;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tianmu.i.a.g.m;
import tianmu.com.android.creator.IdsSupplier;

/* JADX INFO: loaded from: classes2.dex */
public class e implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12215a;

    public class a implements m.a {
        public a(e eVar) {
        }

        @Override // com.tianmu.i.a.g.m.a
        public String a(IBinder iBinder) {
            IdsSupplier idsSupplierAsInterface = IdsSupplier.Stub.asInterface(iBinder);
            if (idsSupplierAsInterface != null) {
                return idsSupplierAsInterface.getOAID();
            }
            throw new com.tianmu.i.a.d("IdsSupplier is null");
        }
    }

    public e(Context context) {
        this.f12215a = context;
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        Context context = this.f12215a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            return false;
        }
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        if (this.f12215a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        m.a(this.f12215a, intent, bVar, new a(this));
    }
}
