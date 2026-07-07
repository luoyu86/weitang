package cn.admobiletop.adsuyi.oaid.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class m implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4321b;

    public m(Context context) {
        this.f4320a = context;
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        Context context = this.f4320a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f4321b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f4321b = "com.huawei.hwid.tv";
            } else {
                this.f4321b = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            return false;
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        Context context = this.f4320a;
        if (context == null || iGetter == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Get oaid from global settings: ");
                    sb.append(string);
                    cn.admobiletop.adsuyi.oaid.d.a(sb.toString());
                    iGetter.onOAIDGetComplete(string);
                    return;
                }
            } catch (Exception e2) {
                cn.admobiletop.adsuyi.oaid.d.a(e2);
            }
        }
        if (TextUtils.isEmpty(this.f4321b) && !a()) {
            iGetter.onOAIDGetError(new cn.admobiletop.adsuyi.oaid.c("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f4321b);
        u.a(this.f4320a, intent, iGetter, new l(this));
    }
}
