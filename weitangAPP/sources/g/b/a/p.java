package g.b.a;

import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Class<?>, List<o>> f14731a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a[] f14732b = new a[4];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<g.b.a.s.b> f14733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f14735e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<o> f14736a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Class, Object> f14737b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, Class> f14738c = new HashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final StringBuilder f14739d = new StringBuilder(128);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Class<?> f14740e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Class<?> f14741f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f14742g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public g.b.a.s.a f14743h;

        public boolean a(Method method, Class<?> cls) {
            Object objPut = this.f14737b.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (!b((Method) objPut, cls)) {
                    throw new IllegalStateException();
                }
                this.f14737b.put(cls, this);
            }
            return b(method, cls);
        }

        public final boolean b(Method method, Class<?> cls) {
            this.f14739d.setLength(0);
            this.f14739d.append(method.getName());
            StringBuilder sb = this.f14739d;
            sb.append('>');
            sb.append(cls.getName());
            String string = this.f14739d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class clsPut = this.f14738c.put(string, declaringClass);
            if (clsPut == null || clsPut.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f14738c.put(string, clsPut);
            return false;
        }

        public void c(Class<?> cls) {
            this.f14741f = cls;
            this.f14740e = cls;
            this.f14742g = false;
            this.f14743h = null;
        }

        public void d() {
            if (this.f14742g) {
                this.f14741f = null;
                return;
            }
            Class<? super Object> superclass = this.f14741f.getSuperclass();
            this.f14741f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f14741f = null;
            }
        }

        public void e() {
            this.f14736a.clear();
            this.f14737b.clear();
            this.f14738c.clear();
            this.f14739d.setLength(0);
            this.f14740e = null;
            this.f14741f = null;
            this.f14742g = false;
            this.f14743h = null;
        }
    }

    public p(List<g.b.a.s.b> list, boolean z, boolean z2) {
        this.f14733c = list;
        this.f14734d = z;
        this.f14735e = z2;
    }

    public static void a() {
        f14731a.clear();
    }

    public List<o> b(Class<?> cls) {
        Map<Class<?>, List<o>> map = f14731a;
        List<o> list = map.get(cls);
        if (list != null) {
            return list;
        }
        List<o> listD = this.f14735e ? d(cls) : c(cls);
        if (!listD.isEmpty()) {
            map.put(cls, listD);
            return listD;
        }
        throw new e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    public final List<o> c(Class<?> cls) {
        a aVarH = h();
        aVarH.c(cls);
        while (aVarH.f14741f != null) {
            g.b.a.s.a aVarG = g(aVarH);
            aVarH.f14743h = aVarG;
            if (aVarG != null) {
                for (o oVar : aVarG.getSubscriberMethods()) {
                    if (aVarH.a(oVar.f14725a, oVar.f14727c)) {
                        aVarH.f14736a.add(oVar);
                    }
                }
            } else {
                e(aVarH);
            }
            aVarH.d();
        }
        return f(aVarH);
    }

    public final List<o> d(Class<?> cls) {
        a aVarH = h();
        aVarH.c(cls);
        while (aVarH.f14741f != null) {
            e(aVarH);
            aVarH.d();
        }
        return f(aVarH);
    }

    public final void e(a aVar) {
        Method[] methods;
        try {
            methods = aVar.f14741f.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = aVar.f14741f.getMethods();
            aVar.f14742g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    m mVar = (m) method.getAnnotation(m.class);
                    if (mVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f14736a.add(new o(method, cls, mVar.threadMode(), mVar.priority(), mVar.sticky()));
                        }
                    }
                } else if (this.f14734d && method.isAnnotationPresent(m.class)) {
                    throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + Consts.DOT + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f14734d && method.isAnnotationPresent(m.class)) {
                throw new e((method.getDeclaringClass().getName() + Consts.DOT + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    public final List<o> f(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f14736a);
        aVar.e();
        synchronized (f14732b) {
            int i2 = 0;
            while (true) {
                if (i2 >= 4) {
                    break;
                }
                a[] aVarArr = f14732b;
                if (aVarArr[i2] == null) {
                    aVarArr[i2] = aVar;
                    break;
                }
                i2++;
            }
        }
        return arrayList;
    }

    public final g.b.a.s.a g(a aVar) {
        g.b.a.s.a aVar2 = aVar.f14743h;
        if (aVar2 != null && aVar2.getSuperSubscriberInfo() != null) {
            g.b.a.s.a superSubscriberInfo = aVar.f14743h.getSuperSubscriberInfo();
            if (aVar.f14741f == superSubscriberInfo.getSubscriberClass()) {
                return superSubscriberInfo;
            }
        }
        List<g.b.a.s.b> list = this.f14733c;
        if (list == null) {
            return null;
        }
        Iterator<g.b.a.s.b> it = list.iterator();
        while (it.hasNext()) {
            g.b.a.s.a subscriberInfo = it.next().getSubscriberInfo(aVar.f14741f);
            if (subscriberInfo != null) {
                return subscriberInfo;
            }
        }
        return null;
    }

    public final a h() {
        synchronized (f14732b) {
            for (int i2 = 0; i2 < 4; i2++) {
                a[] aVarArr = f14732b;
                a aVar = aVarArr[i2];
                if (aVar != null) {
                    aVarArr[i2] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }
}
