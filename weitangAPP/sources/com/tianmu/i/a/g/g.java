package com.tianmu.i.a.g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.tianmu.i.a.g.m;
import tianmu.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12221b;

    public class a implements m.a {
        public a(g gVar) {
        }

        @Override // com.tianmu.i.a.g.m.a
        public String a(IBinder iBinder) {
            OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
            if (openDeviceIdentifierServiceAsInterface.isOaidTrackLimited()) {
                throw new com.tianmu.i.a.d("User has disabled advertising identifier");
            }
            return openDeviceIdentifierServiceAsInterface.getOaid();
        }
    }

    public g(Context context) {
        this.f12220a = context;
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        Context context = this.f12220a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f12221b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f12221b = "com.huawei.hwid.tv";
            } else {
                this.f12221b = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            return false;
        }
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        Context context = this.f12220a;
        if (context == null || bVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    com.tianmu.i.a.e.a("Get oaid from global settings: " + string);
                    bVar.a(string);
                    return;
                }
            } catch (Exception e2) {
                com.tianmu.i.a.e.a(e2);
            }
        }
        if (TextUtils.isEmpty(this.f12221b) && !a()) {
            bVar.a(new com.tianmu.i.a.d("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f12221b);
        m.a(this.f12220a, intent, bVar, new a(this));
    }
}
