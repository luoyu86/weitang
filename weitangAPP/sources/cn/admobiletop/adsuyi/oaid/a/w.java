package cn.admobiletop.adsuyi.oaid.a;

import adsuyi.com.heytap.openid.IOpenID;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cn.admobiletop.adsuyi.oaid.IGetter;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public class w implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4333a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4334b;

    public w(Context context) {
        if (context instanceof Application) {
            this.f4333a = context;
        } else {
            this.f4333a = context.getApplicationContext();
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        Context context = this.f4333a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            return false;
        }
    }

    public final String b(IBinder iBinder, String str, String str2) {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface != null) {
            return iOpenIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new cn.admobiletop.adsuyi.oaid.c("IOpenID is null");
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (this.f4333a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        u.a(this.f4333a, intent, iGetter, new v(this));
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public final String a(IBinder iBinder) {
        String packageName = this.f4333a.getPackageName();
        String str = this.f4334b;
        if (str == null) {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f4333a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            String string = sb.toString();
            this.f4334b = string;
            return b(iBinder, packageName, string);
        }
        return b(iBinder, packageName, str);
    }
}
