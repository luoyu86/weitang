package c.i.b.y;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l {

    public static class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f2684a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f2685b;

        public a(Method method, Object obj) {
            this.f2684a = method;
            this.f2685b = obj;
        }

        @Override // c.i.b.y.l
        public <T> T newInstance(Class<T> cls) throws Exception {
            l.a(cls);
            return (T) this.f2684a.invoke(this.f2685b, cls);
        }
    }

    public static class b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f2686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f2687b;

        public b(Method method, int i2) {
            this.f2686a = method;
            this.f2687b = i2;
        }

        @Override // c.i.b.y.l
        public <T> T newInstance(Class<T> cls) throws Exception {
            l.a(cls);
            return (T) this.f2686a.invoke(null, cls, Integer.valueOf(this.f2687b));
        }
    }

    public static class c extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Method f2688a;

        public c(Method method) {
            this.f2688a = method;
        }

        @Override // c.i.b.y.l
        public <T> T newInstance(Class<T> cls) throws Exception {
            l.a(cls);
            return (T) this.f2688a.invoke(null, cls, Object.class);
        }
    }

    public static class d extends l {
        @Override // c.i.b.y.l
        public <T> T newInstance(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    public static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static l create() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    public abstract <T> T newInstance(Class<T> cls) throws Exception;
}
