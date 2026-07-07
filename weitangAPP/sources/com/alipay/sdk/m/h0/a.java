package com.alipay.sdk.m.h0;

import android.content.Context;
import com.alipay.sdk.m.a.a;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a(Context context) {
        if (a.b.f5249a) {
            return a.c.b.f5257a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String b(Context context) {
        if (a.b.f5249a) {
            return a.c.b.f5257a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (a.b.f5249a) {
            return a.c.b.f5257a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (a.b.f5249a) {
            return a.c.b.f5257a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static void e(Context context) {
        a.b.f5250b = a.c.b.f5257a.a(context.getApplicationContext());
        a.b.f5249a = true;
    }

    public static boolean a() {
        if (a.b.f5249a) {
            return a.b.f5250b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
