package com.qq.e.comm.managers.plugin;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f9685a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f9686b = false;

    public static void a(Throwable th, String str) {
        try {
            Exception exc = new Exception("插件错误：" + str, th);
            if (f9686b) {
                return;
            }
            if (f9685a == null) {
                Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
                f9685a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            f9685a.invoke(null, exc);
        } catch (Throwable unused) {
            f9686b = true;
        }
    }
}
