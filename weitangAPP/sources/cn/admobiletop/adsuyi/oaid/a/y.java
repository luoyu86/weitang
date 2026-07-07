package cn.admobiletop.adsuyi.oaid.a;

import android.content.Context;
import android.content.Intent;
import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class y implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4336a;

    public y(Context context) {
        this.f4336a = context;
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        Context context = this.f4336a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            return false;
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (this.f4336a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        u.a(this.f4336a, intent, iGetter, new x(this));
    }
}
