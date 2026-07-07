package com.tianmu.i.a.g;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.tianmu.i.a.g.m;
import tianmu.com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12210a;

    /* JADX INFO: renamed from: com.tianmu.i.a.g.a$a, reason: collision with other inner class name */
    public class C0225a implements m.a {
        public C0225a(a aVar) {
        }

        @Override // com.tianmu.i.a.g.m.a
        public String a(IBinder iBinder) {
            IDidAidlInterface iDidAidlInterfaceAsInterface = IDidAidlInterface.Stub.asInterface(iBinder);
            if (iDidAidlInterfaceAsInterface == null) {
                throw new com.tianmu.i.a.d("IDidAidlInterface is null");
            }
            if (iDidAidlInterfaceAsInterface.isSupport()) {
                return iDidAidlInterfaceAsInterface.getOAID();
            }
            throw new com.tianmu.i.a.d("IDidAidlInterface#isSupport return false");
        }
    }

    public a(Context context) {
        this.f12210a = context;
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        Context context = this.f12210a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            return false;
        }
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        if (this.f12210a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        m.a(this.f12210a, intent, bVar, new C0225a(this));
    }
}
