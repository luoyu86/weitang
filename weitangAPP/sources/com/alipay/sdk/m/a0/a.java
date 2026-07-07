package com.alipay.sdk.m.a0;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f5258a = new a();

    public static a a() {
        return f5258a;
    }

    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception unused) {
            return "0.0.0";
        }
    }
}
