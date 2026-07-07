package com.tianmu.i.a.g;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.provider.Settings;
import android.text.TextUtils;
import com.tianmu.i.a.g.m;
import tianmu.com.hihonor.cloudservice.oaid.a;
import tianmu.com.hihonor.cloudservice.oaid.b;

/* JADX INFO: loaded from: classes2.dex */
public class f implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12217b = "";

    public class a implements m.a {

        /* JADX INFO: renamed from: com.tianmu.i.a.g.f$a$a, reason: collision with other inner class name */
        public class BinderC0226a extends a.Stub {
            public BinderC0226a() {
            }

            @Override // tianmu.com.hihonor.cloudservice.oaid.a
            public void a(int i2, long j, boolean z, float f2, double d2, String str) {
            }

            @Override // tianmu.com.hihonor.cloudservice.oaid.a
            public void a(int i2, Bundle bundle) {
                if (i2 == 0 && bundle != null) {
                    f.this.f12217b = bundle.getString("oa_id_flag");
                    com.tianmu.i.a.e.a("OAIDCallBack handleResult success");
                } else {
                    com.tianmu.i.a.e.a("OAIDCallBack handleResult error retCode=$ " + i2);
                }
            }
        }

        public a() {
        }

        @Override // com.tianmu.i.a.g.m.a
        public String a(IBinder iBinder) {
            tianmu.com.hihonor.cloudservice.oaid.b internalStub;
            if (iBinder == null) {
                internalStub = null;
            } else {
                try {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                    internalStub = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof tianmu.com.hihonor.cloudservice.oaid.b)) ? new b.Stub.InternalStub(iBinder) : (tianmu.com.hihonor.cloudservice.oaid.b) iInterfaceQueryLocalInterface;
                } catch (Exception e2) {
                    com.tianmu.i.a.e.a("onServiceConnected error:" + e2.getMessage());
                }
            }
            internalStub.b(new BinderC0226a());
            return f.this.f12217b;
        }
    }

    public f(Context context) {
        this.f12216a = context;
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        Context context = this.f12216a;
        if (context == null) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo("com.hihonor.id", 0);
            new Intent("com.hihonor.id.HnOaIdService").setPackage("com.hihonor.id");
            return !r1.queryIntentServices(r3, 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        Context context = this.f12216a;
        if (context == null || bVar == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                String string = Settings.Global.getString(context.getContentResolver(), "oaid_limit_state");
                String string2 = Settings.Global.getString(this.f12216a.getContentResolver(), "oaid");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    com.tianmu.i.a.e.a("Get oaid from global settings: " + string2);
                    bVar.a(string2);
                    return;
                }
            }
        } catch (Throwable th) {
            com.tianmu.i.a.e.a(th);
        }
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        m.a(this.f12216a, intent, bVar, new a());
    }
}
