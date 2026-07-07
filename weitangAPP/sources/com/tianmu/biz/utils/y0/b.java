package com.tianmu.biz.utils.y0;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: com.tianmu.biz.utils.y0.b$b, reason: collision with other inner class name */
    public static class C0184b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f10908a = new b();
    }

    public static final b a() {
        return C0184b.f10908a;
    }

    private b() {
    }

    public String a(String str) throws IllegalAccessException, InvocationTargetException {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
