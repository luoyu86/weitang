package cn.admobiletop.adsuyi.oaid.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class d implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4310a;

    public d(Context context) {
        if (context instanceof Application) {
            this.f4310a = context;
        } else {
            this.f4310a = context.getApplicationContext();
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        Context context = this.f4310a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            return false;
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (this.f4310a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        u.a(this.f4310a, intent, iGetter, new c(this));
    }
}
