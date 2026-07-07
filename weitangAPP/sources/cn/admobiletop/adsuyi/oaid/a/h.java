package cn.admobiletop.adsuyi.oaid.a;

import android.content.Context;
import android.content.Intent;
import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class h implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4314a;

    public h(Context context) {
        this.f4314a = context;
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        Context context = this.f4314a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            return false;
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (this.f4314a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        u.a(this.f4314a, intent, iGetter, new g(this));
    }
}
