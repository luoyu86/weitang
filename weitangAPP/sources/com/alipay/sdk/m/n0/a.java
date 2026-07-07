package com.alipay.sdk.m.n0;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(Context context) {
        b bVarB = c.b(context);
        return (bVarB == null || com.alipay.sdk.m.l0.f.m66a(bVarB.c())) ? "ffffffffffffffffffffffff" : bVarB.c();
    }

    public static String b(Context context) {
        String strA = d.a(context).a();
        return (strA == null || com.alipay.sdk.m.l0.f.m66a(strA)) ? "ffffffffffffffffffffffff" : strA;
    }

    @Deprecated
    public static String c(Context context) {
        return a(context);
    }

    @Deprecated
    public static String d(Context context) {
        return b(context);
    }
}
