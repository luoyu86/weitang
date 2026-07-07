package cn.admobiletop.adsuyi.oaid.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class b implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4308a;

    public b(Context context) {
        this.f4308a = context;
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        Context context = this.f4308a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            return false;
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (this.f4308a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        u.a(this.f4308a, intent, iGetter, new C0339a(this));
    }
}
