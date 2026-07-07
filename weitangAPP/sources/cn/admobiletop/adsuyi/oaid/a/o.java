package cn.admobiletop.adsuyi.oaid.a;

import android.content.Context;
import android.content.Intent;
import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class o implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4323a;

    public o(Context context) {
        this.f4323a = context;
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        Context context = this.f4323a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            return false;
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (this.f4323a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        u.a(this.f4323a, intent, iGetter, new n(this));
    }
}
