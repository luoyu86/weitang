package com.alibaba.sdk.android.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f5046c = false;

    public static void a(String str, String str2) {
        if (f5046c) {
            Log.d(str, str2);
        }
    }

    public static void b(String str, String str2) {
        if (f5046c) {
            Log.i(str, str2);
        }
    }

    public static boolean c() {
        return f5046c;
    }

    public static void setLogEnabled(boolean z) {
        f5046c = z;
    }

    public static void c(String str, String str2) {
        if (f5046c) {
            Log.e(str, str2);
        }
    }

    public static void a(String str, Throwable th) {
        if (!f5046c || th == null) {
            return;
        }
        Log.e(str, th.toString(), th);
    }
}
