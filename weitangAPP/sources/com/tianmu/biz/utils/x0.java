package com.tianmu.biz.utils;

import dalvik.system.BaseDexClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class x0 {
    private static boolean a(Throwable th) {
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            String className = stackTraceElement.getClassName();
            if (className != null && className.contains("de.robv.android.xposed.XposedBridge")) {
                return true;
            }
        }
        return false;
    }

    public static boolean b() {
        try {
            throw new Exception("gg");
        } catch (Throwable th) {
            return a(th);
        }
    }

    public static boolean a() {
        try {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            Class<?> cls = Class.forName("dalvik.system.DexPathList");
            Method method = Class.forName("dalvik.system.DexPathList$Element").getMethod("toString", new Class[0]);
            Field declaredField = cls.getDeclaredField("dexElements");
            declaredField.setAccessible(true);
            Field declaredField2 = BaseDexClassLoader.class.getDeclaredField("pathList");
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField.get(declaredField2.get(systemClassLoader));
            boolean z = false;
            for (Object obj : objArr) {
                try {
                    String str = (String) method.invoke(obj, new Object[0]);
                    if (str != null && str.contains("XposedBridge.jar")) {
                        z = true;
                    }
                } catch (Exception unused) {
                    z = false;
                }
            }
            return z;
        } catch (Exception unused2) {
            return false;
        }
    }
}
