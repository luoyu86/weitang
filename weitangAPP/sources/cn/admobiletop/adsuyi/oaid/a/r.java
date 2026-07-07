package cn.admobiletop.adsuyi.oaid.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class r implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4326a;

    public r(Context context) {
        this.f4326a = context;
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        Context context = this.f4326a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            return false;
        }
    }

    public final void b() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.f4326a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.f4326a.startService(intent);
            } else {
                this.f4326a.startForegroundService(intent);
            }
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (this.f4326a == null || iGetter == null) {
            return;
        }
        b();
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.f4326a.getPackageName());
        u.a(this.f4326a, intent, iGetter, new q(this));
    }
}
