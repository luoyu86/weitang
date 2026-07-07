package com.alipay.sdk.m.c;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.alipay.sdk.m.b.b {
    @Override // com.alipay.sdk.m.b.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zA = com.alipay.sdk.m.i0.b.a();
        com.alipay.sdk.m.d.a.b("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return com.alipay.sdk.m.i0.b.b(context);
        }
        return null;
    }
}
