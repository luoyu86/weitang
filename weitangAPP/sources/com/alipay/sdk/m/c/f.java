package com.alipay.sdk.m.c;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.alipay.sdk.m.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5288a = false;

    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f5288a) {
            com.alipay.sdk.m.h0.a.e(context);
            this.f5288a = true;
        }
        boolean zA = com.alipay.sdk.m.h0.a.a();
        com.alipay.sdk.m.d.a.b("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return com.alipay.sdk.m.h0.a.b(context);
        }
        return null;
    }
}
