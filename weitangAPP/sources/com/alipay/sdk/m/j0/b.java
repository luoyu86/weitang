package com.alipay.sdk.m.j0;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5407a = "IdentifierManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object f5408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class<?> f5409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Method f5410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Method f5411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f5412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Method f5413g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f5409c = cls;
            f5408b = cls.newInstance();
            f5410d = f5409c.getMethod("getUDID", Context.class);
            f5411e = f5409c.getMethod("getOAID", Context.class);
            f5412f = f5409c.getMethod("getVAID", Context.class);
            f5413g = f5409c.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e(f5407a, "reflect exception!", e2);
        }
    }

    public static boolean a() {
        return (f5409c == null || f5408b == null) ? false : true;
    }

    public static String b(Context context) {
        return a(context, f5411e);
    }

    public static String c(Context context) {
        return a(context, f5410d);
    }

    public static String d(Context context) {
        return a(context, f5412f);
    }

    public static String a(Context context) {
        return a(context, f5413g);
    }

    public static String a(Context context, Method method) {
        Object obj = f5408b;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception e2) {
            Log.e(f5407a, "invoke exception!", e2);
            return null;
        }
    }
}
