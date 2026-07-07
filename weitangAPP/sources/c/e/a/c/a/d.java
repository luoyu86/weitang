package c.e.a.c.a;

import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1137a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f1138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Method f1139c;

    static {
        String simpleName = d.class.getSimpleName();
        Object objB = b();
        f1138b = objB;
        f1139c = c(objB);
        if (objB == null) {
            Log.v(simpleName, "This device does supports control of a flashlight");
        } else {
            Log.v(simpleName, "This device does not support control of a flashlight");
        }
    }

    public static void a() {
        g(false);
    }

    public static Object b() {
        Method methodF;
        Object objD;
        Class<?> clsE;
        Method methodF2;
        Class<?> clsE2 = e("android.os.ServiceManager");
        if (clsE2 == null || (methodF = f(clsE2, "getService", String.class)) == null || (objD = d(methodF, null, "hardware")) == null || (clsE = e("android.os.IHardwareService$Stub")) == null || (methodF2 = f(clsE, "asInterface", IBinder.class)) == null) {
            return null;
        }
        return d(methodF2, null, objD);
    }

    public static Method c(Object obj) {
        if (obj == null) {
            return null;
        }
        return f(obj.getClass(), "setFlashlightEnabled", Boolean.TYPE);
    }

    public static Object d(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            Log.w(f1137a, "Unexpected error while invoking " + method, e2);
            return null;
        } catch (RuntimeException e3) {
            Log.w(f1137a, "Unexpected error while invoking " + method, e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.w(f1137a, "Unexpected error while invoking " + method, e4.getCause());
            return null;
        }
    }

    public static Class<?> e(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (RuntimeException e2) {
            Log.w(f1137a, "Unexpected error while finding class " + str, e2);
            return null;
        }
    }

    public static Method f(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (RuntimeException e2) {
            Log.w(f1137a, "Unexpected error while finding method " + str, e2);
            return null;
        }
    }

    public static void g(boolean z) {
        Object obj = f1138b;
        if (obj != null) {
            d(f1139c, obj, Boolean.valueOf(z));
        }
    }
}
