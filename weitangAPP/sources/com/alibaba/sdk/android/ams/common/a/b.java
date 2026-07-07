package com.alibaba.sdk.android.ams.common.a;

import android.app.Application;
import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class b {
    public static void a(Application application) {
        if (application == null) {
            return;
        }
        a.f4587b = application;
    }

    public static void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("null applicationContext!");
        }
        a.f4586a = context;
    }

    public static void a(String str) {
        a.f4589d = str;
    }

    public static void a(boolean z) {
        a.f4588c = z;
    }

    public static void b(String str) {
        a.f4590e = str;
    }

    public static void c(String str) {
        a.f4591f = str;
    }
}
