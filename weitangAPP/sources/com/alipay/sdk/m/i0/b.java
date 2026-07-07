package com.alipay.sdk.m.i0;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5369a = "OpenIdHelper";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f5370b;

    public static String a(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.f5380c);
    }

    public static void a(boolean z) {
        f.a();
        f.a(z);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (f5370b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f5370b = method;
                method.setAccessible(true);
            }
            context = (Context) f5370b.invoke(null, new Object[0]);
        } catch (Exception e2) {
            Log.e(f5369a, "ActivityThread:currentApplication --> " + e2.toString());
        }
        if (context == null) {
            return false;
        }
        return f.a().a(context, false);
    }

    public static String b(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.f5379b);
    }

    public static String c(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.f5378a);
    }

    public static String d(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.f5381d);
    }
}
