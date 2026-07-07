package com.bytedance.pangle.b.a;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<String, Field> f5948a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<String, Method> f5949b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<String, Constructor> f5950c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<String, Class> f5951d = new HashMap();

    static {
        try {
            FieldUtils.writeField(b.class, "classLoader", (Object) null);
            ZeusLogger.w(ZeusLogger.TAG_INIT, "HackHelper HackHelperImpl use BootClassLoader");
        } catch (Exception e2) {
            ZeusLogger.errReport(ZeusLogger.TAG_INIT, "HackHelperinit failed", e2);
        }
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) {
        Method method;
        String strB = b(cls, str, clsArr);
        synchronized (f5949b) {
            method = f5949b.get(strB);
        }
        if (method != null) {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method;
        }
        try {
            Method methodA = b.a(cls, str, clsArr);
            if (methodA != null) {
                synchronized (f5949b) {
                    f5949b.put(strB, methodA);
                }
            }
            return methodA;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getMethod %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }

    private static String b(Class<?> cls, String str, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName());
        sb.append("#");
        sb.append(str);
        if (clsArr == null || clsArr.length <= 0) {
            sb.append(Void.class.getName());
        } else {
            for (Class<?> cls2 : clsArr) {
                sb.append(cls2.getName());
                sb.append("#");
            }
        }
        return sb.toString();
    }

    public static Constructor a(Class<?> cls, Class<?>... clsArr) {
        Constructor constructor;
        String strB = b(cls, "clinit", clsArr);
        synchronized (f5950c) {
            constructor = f5950c.get(strB);
        }
        if (constructor != null) {
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            return constructor;
        }
        try {
            Constructor constructorA = b.a(cls, clsArr);
            if (constructorA != null) {
                synchronized (f5950c) {
                    f5950c.put(strB, constructorA);
                }
            }
            return constructorA;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getConstructor %s failed !!!", cls.getName()), th);
            return null;
        }
    }

    public static Field a(Class<?> cls, String str) {
        Field field;
        String str2 = cls.getName() + "#" + str;
        synchronized (f5948a) {
            field = f5948a.get(str2);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        try {
            Field fieldA = b.a(cls, str);
            if (fieldA != null) {
                synchronized (f5948a) {
                    f5948a.put(str2, fieldA);
                }
            }
            return fieldA;
        } catch (Throwable th) {
            ZeusLogger.w(ZeusLogger.TAG, "HackHelper" + String.format("getField %s#%s failed !!!", cls.getName(), str), th);
            return null;
        }
    }
}
