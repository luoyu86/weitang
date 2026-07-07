package d.i0.f.a;

import d.k0.d.t;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f12600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f12601c = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12599a = new a(null, null, null);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f12602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f12603b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f12604c;

        public a(Method method, Method method2, Method method3) {
            this.f12602a = method;
            this.f12603b = method2;
            this.f12604c = method3;
        }
    }

    public final a a(d.i0.f.a.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f12600b = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f12599a;
            f12600b = aVar3;
            return aVar3;
        }
    }

    public final String getModuleName(d.i0.f.a.a aVar) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        t.checkNotNullParameter(aVar, "continuation");
        a aVarA = f12600b;
        if (aVarA == null) {
            aVarA = a(aVar);
        }
        if (aVarA == f12599a || (method = aVarA.f12602a) == null || (objInvoke = method.invoke(aVar.getClass(), new Object[0])) == null || (method2 = aVarA.f12603b) == null || (objInvoke2 = method2.invoke(objInvoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVarA.f12604c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        return (String) (objInvoke3 instanceof String ? objInvoke3 : null);
    }
}
