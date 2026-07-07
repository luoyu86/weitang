package c.n.b;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class e<T, V> extends d<T, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Method f2922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Method f2923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Field f2924e;

    public e(Class<T> cls, Class<V> cls2, String str) {
        super(cls2, str);
        String str2 = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        String str3 = "get" + str2;
        try {
            try {
                this.f2923d = cls.getMethod(str3, null);
            } catch (NoSuchMethodException unused) {
                Method declaredMethod = cls.getDeclaredMethod(str3, null);
                this.f2923d = declaredMethod;
                declaredMethod.setAccessible(true);
            }
        } catch (NoSuchMethodException unused2) {
            String str4 = "is" + str2;
            try {
                try {
                    try {
                        this.f2923d = cls.getMethod(str4, null);
                    } catch (NoSuchMethodException unused3) {
                        Method declaredMethod2 = cls.getDeclaredMethod(str4, null);
                        this.f2923d = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                    }
                } catch (NoSuchMethodException unused4) {
                    Field field = cls.getField(str);
                    this.f2924e = field;
                    Class<?> type = field.getType();
                    if (a(cls2, type)) {
                        return;
                    }
                    throw new c("Underlying type (" + type + ") does not match Property type (" + cls2 + ")");
                }
            } catch (NoSuchFieldException unused5) {
                throw new c("No accessor method or field found for property with name " + str);
            }
        }
        Class<?> returnType = this.f2923d.getReturnType();
        if (a(cls2, returnType)) {
            try {
                Method declaredMethod3 = cls.getDeclaredMethod("set" + str2, returnType);
                this.f2922c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                return;
            } catch (NoSuchMethodException unused6) {
                return;
            }
        }
        throw new c("Underlying type (" + returnType + ") does not match Property type (" + cls2 + ")");
    }

    public final boolean a(Class<V> cls, Class cls2) {
        if (cls2 == cls) {
            return true;
        }
        if (!cls2.isPrimitive()) {
            return false;
        }
        if (cls2 == Float.TYPE && cls == Float.class) {
            return true;
        }
        if (cls2 == Integer.TYPE && cls == Integer.class) {
            return true;
        }
        if (cls2 == Boolean.TYPE && cls == Boolean.class) {
            return true;
        }
        if (cls2 == Long.TYPE && cls == Long.class) {
            return true;
        }
        if (cls2 == Double.TYPE && cls == Double.class) {
            return true;
        }
        if (cls2 == Short.TYPE && cls == Short.class) {
            return true;
        }
        if (cls2 == Byte.TYPE && cls == Byte.class) {
            return true;
        }
        return cls2 == Character.TYPE && cls == Character.class;
    }

    @Override // c.n.b.d
    public V get(T t) {
        Method method = this.f2923d;
        if (method != null) {
            try {
                return (V) method.invoke(t, null);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        Field field = this.f2924e;
        if (field == null) {
            throw new AssertionError();
        }
        try {
            return (V) field.get(t);
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    @Override // c.n.b.d
    public boolean isReadOnly() {
        return this.f2922c == null && this.f2924e == null;
    }

    @Override // c.n.b.d
    public void set(T t, V v) {
        Method method = this.f2922c;
        if (method != null) {
            try {
                method.invoke(t, v);
                return;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        Field field = this.f2924e;
        if (field != null) {
            try {
                field.set(t, v);
            } catch (IllegalAccessException unused2) {
                throw new AssertionError();
            }
        } else {
            throw new UnsupportedOperationException("Property " + getName() + " is read-only");
        }
    }
}
