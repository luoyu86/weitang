package cn.admobiletop.adsuyi.oaid.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class k implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4318b = "";

    public k(Context context) {
        this.f4317a = context;
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        Context context = this.f4317a;
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

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        Context context = this.f4317a;
        if (context == null || iGetter == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                String string = Settings.Global.getString(context.getContentResolver(), "oaid_limit_state");
                String string2 = Settings.Global.getString(this.f4317a.getContentResolver(), "oaid");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Get oaid from global settings: ");
                    sb.append(string2);
                    cn.admobiletop.adsuyi.oaid.d.a(sb.toString());
                    iGetter.onOAIDGetComplete(string2);
                    return;
                }
            }
        } catch (Throwable th) {
            cn.admobiletop.adsuyi.oaid.d.a(th);
        }
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        u.a(this.f4317a, intent, iGetter, new j(this));
    }
}
