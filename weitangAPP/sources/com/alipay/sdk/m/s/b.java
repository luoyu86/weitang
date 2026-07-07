package com.alipay.sdk.m.s;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f5645b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5646a;

    public static b d() {
        if (f5645b == null) {
            f5645b = new b();
        }
        return f5645b;
    }

    public static boolean e() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i2 = 0; i2 < 10; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    public void a(Context context) {
        com.alipay.sdk.m.m.b.b();
        this.f5646a = context.getApplicationContext();
    }

    public Context b() {
        return this.f5646a;
    }

    public String c() {
        return com.alipay.sdk.m.w.b.c(null, this.f5646a);
    }

    public com.alipay.sdk.m.m.b a() {
        return com.alipay.sdk.m.m.b.b();
    }
}
