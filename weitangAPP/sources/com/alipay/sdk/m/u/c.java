package com.alipay.sdk.m.u;

import android.content.Context;
import android.net.NetworkInfo;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5661a = "00:00:00:00:00:00";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static c f5662b;

    public c(Context context) {
    }

    public static c b(Context context) {
        if (f5662b == null) {
            f5662b = new c(context);
        }
        return f5662b;
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static g d(Context context) {
        try {
            NetworkInfo networkInfoA = com.alipay.sdk.m.w.b.a(null, context);
            return (networkInfoA == null || networkInfoA.getType() != 0) ? (networkInfoA == null || networkInfoA.getType() != 1) ? g.NONE : g.WIFI : g.a(networkInfoA.getSubtype());
        } catch (Exception unused) {
            return g.NONE;
        }
    }

    public String a() {
        String str = b() + "|";
        String strC = c();
        if (TextUtils.isEmpty(strC)) {
            return str + "000000000000000";
        }
        return str + strC;
    }

    public String b() {
        return "000000000000000";
    }

    public String c() {
        return "000000000000000";
    }

    public String d() {
        return f5661a;
    }

    public static String a(Context context) {
        return b(context).a().substring(0, 8);
    }
}
