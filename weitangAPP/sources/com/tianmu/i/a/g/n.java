package com.tianmu.i.a.g;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.tianmu.i.a.g.m;
import java.security.MessageDigest;
import tianmu.com.heytap.openid.IOpenID;

/* JADX INFO: loaded from: classes2.dex */
public class n implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12231b;

    public class a implements m.a {
        public a() {
        }

        @Override // com.tianmu.i.a.g.m.a
        public String a(IBinder iBinder) throws RemoteException {
            try {
                return n.this.a(iBinder);
            } catch (RemoteException e2) {
                throw e2;
            } catch (com.tianmu.i.a.d e3) {
                throw e3;
            } catch (Exception e4) {
                throw new com.tianmu.i.a.d(e4);
            }
        }
    }

    public n(Context context) {
        if (context instanceof Application) {
            this.f12230a = context;
        } else {
            this.f12230a = context.getApplicationContext();
        }
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        Context context = this.f12230a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            return false;
        }
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        if (this.f12230a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        m.a(this.f12230a, intent, bVar, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"PackageManagerGetSignatures"})
    public String a(IBinder iBinder) {
        String packageName = this.f12230a.getPackageName();
        String str = this.f12231b;
        if (str == null) {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f12230a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArrDigest) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            String string = sb.toString();
            this.f12231b = string;
            return a(iBinder, packageName, string);
        }
        return a(iBinder, packageName, str);
    }

    private String a(IBinder iBinder, String str, String str2) {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface != null) {
            return iOpenIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new com.tianmu.i.a.d("IOpenID is null");
    }
}
