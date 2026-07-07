package c.n.a;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class j implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f2901a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f2902b = new c.n.a.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Class[] f2903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Class[] f2904d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class[] f2905e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final HashMap<Class, HashMap<String, Method>> f2906f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final HashMap<Class, HashMap<String, Method>> f2907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f2908h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c.n.b.d f2909i;
    public Method j;
    public Method k;
    public Class l;
    public g m;
    public final ReentrantReadWriteLock n;
    public final Object[] o;
    public k p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Object f2910q;

    static {
        Class cls = Float.TYPE;
        Class cls2 = Integer.TYPE;
        f2903c = new Class[]{cls, Float.class, Double.TYPE, cls2, Double.class, Integer.class};
        Class cls3 = Double.TYPE;
        f2904d = new Class[]{cls2, Integer.class, cls, cls3, Float.class, Double.class};
        f2905e = new Class[]{cls3, Double.class, cls, cls2, Float.class, Integer.class};
        f2906f = new HashMap<>();
        f2907g = new HashMap<>();
    }

    public static String c(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        return str + Character.toUpperCase(str2.charAt(0)) + str2.substring(1);
    }

    public static j ofFloat(String str, float... fArr) {
        return new b(str, fArr);
    }

    public static j ofInt(String str, int... iArr) {
        return new c(str, iArr);
    }

    public static j ofKeyframe(String str, f... fVarArr) {
        g gVarOfKeyframe = g.ofKeyframe(fVarArr);
        if (gVarOfKeyframe instanceof e) {
            return new c(str, (e) gVarOfKeyframe);
        }
        if (gVarOfKeyframe instanceof c.n.a.c) {
            return new b(str, (c.n.a.c) gVarOfKeyframe);
        }
        j jVar = new j(str);
        jVar.m = gVarOfKeyframe;
        jVar.l = fVarArr[0].getType();
        return jVar;
    }

    public static j ofObject(String str, k kVar, Object... objArr) {
        j jVar = new j(str);
        jVar.setObjectValues(objArr);
        jVar.setEvaluator(kVar);
        return jVar;
    }

    public void a(float f2) {
        this.f2910q = this.m.getValue(f2);
    }

    public Object b() {
        return this.f2910q;
    }

    public final Method d(Class cls, String str, Class cls2) {
        String strC = c(str, this.f2908h);
        Method declaredMethod = null;
        if (cls2 == null) {
            try {
                return cls.getMethod(strC, null);
            } catch (NoSuchMethodException e2) {
                try {
                    declaredMethod = cls.getDeclaredMethod(strC, null);
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException unused) {
                    Log.e("PropertyValuesHolder", "Couldn't find no-arg method for property " + this.f2908h + ": " + e2);
                }
            }
        } else {
            Class<?>[] clsArr = new Class[1];
            for (Class<?> cls3 : this.l.equals(Float.class) ? f2903c : this.l.equals(Integer.class) ? f2904d : this.l.equals(Double.class) ? f2905e : new Class[]{this.l}) {
                clsArr[0] = cls3;
                try {
                    try {
                        Method method = cls.getMethod(strC, clsArr);
                        this.l = cls3;
                        return method;
                    } catch (NoSuchMethodException unused2) {
                    }
                } catch (NoSuchMethodException unused3) {
                    declaredMethod = cls.getDeclaredMethod(strC, clsArr);
                    declaredMethod.setAccessible(true);
                    this.l = cls3;
                    return declaredMethod;
                }
            }
            Log.e("PropertyValuesHolder", "Couldn't find setter/getter for property " + this.f2908h + " with value type " + this.l);
        }
        return declaredMethod;
    }

    public void e() {
        if (this.p == null) {
            Class cls = this.l;
            this.p = cls == Integer.class ? f2901a : cls == Float.class ? f2902b : null;
        }
        k kVar = this.p;
        if (kVar != null) {
            this.m.setEvaluator(kVar);
        }
    }

    public void f(Object obj) {
        c.n.b.d dVar = this.f2909i;
        if (dVar != null) {
            dVar.set(obj, b());
        }
        if (this.j != null) {
            try {
                this.o[0] = b();
                this.j.invoke(obj, this.o);
            } catch (IllegalAccessException e2) {
                Log.e("PropertyValuesHolder", e2.toString());
            } catch (InvocationTargetException e3) {
                Log.e("PropertyValuesHolder", e3.toString());
            }
        }
    }

    public void g(Object obj) {
        m(obj, this.m.f2890e.get(r0.size() - 1));
    }

    public String getPropertyName() {
        return this.f2908h;
    }

    public final void h(Class cls) {
        this.k = k(cls, f2907g, "get", null);
    }

    public void i(Class cls) {
        this.j = k(cls, f2906f, "set", this.l);
    }

    public void j(Object obj) {
        c.n.b.d dVar = this.f2909i;
        if (dVar != null) {
            try {
                dVar.get(obj);
                for (f fVar : this.m.f2890e) {
                    if (!fVar.hasValue()) {
                        fVar.setValue(this.f2909i.get(obj));
                    }
                }
                return;
            } catch (ClassCastException unused) {
                Log.e("PropertyValuesHolder", "No such property (" + this.f2909i.getName() + ") on target object " + obj + ". Trying reflection instead");
                this.f2909i = null;
            }
        }
        Class<?> cls = obj.getClass();
        if (this.j == null) {
            i(cls);
        }
        for (f fVar2 : this.m.f2890e) {
            if (!fVar2.hasValue()) {
                if (this.k == null) {
                    h(cls);
                }
                try {
                    fVar2.setValue(this.k.invoke(obj, new Object[0]));
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                } catch (InvocationTargetException e3) {
                    Log.e("PropertyValuesHolder", e3.toString());
                }
            }
        }
    }

    public final Method k(Class cls, HashMap<Class, HashMap<String, Method>> map, String str, Class cls2) {
        try {
            this.n.writeLock().lock();
            HashMap<String, Method> map2 = map.get(cls);
            Method methodD = map2 != null ? map2.get(this.f2908h) : null;
            if (methodD == null) {
                methodD = d(cls, str, cls2);
                if (map2 == null) {
                    map2 = new HashMap<>();
                    map.put(cls, map2);
                }
                map2.put(this.f2908h, methodD);
            }
            return methodD;
        } finally {
            this.n.writeLock().unlock();
        }
    }

    public void l(Object obj) {
        m(obj, this.m.f2890e.get(0));
    }

    public final void m(Object obj, f fVar) {
        c.n.b.d dVar = this.f2909i;
        if (dVar != null) {
            fVar.setValue(dVar.get(obj));
        }
        try {
            if (this.k == null) {
                h(obj.getClass());
            }
            fVar.setValue(this.k.invoke(obj, new Object[0]));
        } catch (IllegalAccessException e2) {
            Log.e("PropertyValuesHolder", e2.toString());
        } catch (InvocationTargetException e3) {
            Log.e("PropertyValuesHolder", e3.toString());
        }
    }

    public void setEvaluator(k kVar) {
        this.p = kVar;
        this.m.setEvaluator(kVar);
    }

    public void setFloatValues(float... fArr) {
        this.l = Float.TYPE;
        this.m = g.ofFloat(fArr);
    }

    public void setIntValues(int... iArr) {
        this.l = Integer.TYPE;
        this.m = g.ofInt(iArr);
    }

    public void setKeyframes(f... fVarArr) {
        int length = fVarArr.length;
        f[] fVarArr2 = new f[Math.max(length, 2)];
        this.l = fVarArr[0].getType();
        for (int i2 = 0; i2 < length; i2++) {
            fVarArr2[i2] = fVarArr[i2];
        }
        this.m = new g(fVarArr2);
    }

    public void setObjectValues(Object... objArr) {
        this.l = objArr[0].getClass();
        this.m = g.ofObject(objArr);
    }

    public void setProperty(c.n.b.d dVar) {
        this.f2909i = dVar;
    }

    public void setPropertyName(String str) {
        this.f2908h = str;
    }

    public String toString() {
        return this.f2908h + ": " + this.m.toString();
    }

    public static class b extends j {
        public c.n.b.a r;
        public c.n.a.c s;
        public float t;

        public b(String str, c.n.a.c cVar) {
            super(str);
            this.l = Float.TYPE;
            this.m = cVar;
            this.s = cVar;
        }

        @Override // c.n.a.j
        public void a(float f2) {
            this.t = this.s.getFloatValue(f2);
        }

        @Override // c.n.a.j
        public Object b() {
            return Float.valueOf(this.t);
        }

        @Override // c.n.a.j
        public void f(Object obj) {
            c.n.b.a aVar = this.r;
            if (aVar != null) {
                aVar.setValue(obj, this.t);
                return;
            }
            c.n.b.d dVar = this.f2909i;
            if (dVar != null) {
                dVar.set(obj, Float.valueOf(this.t));
                return;
            }
            if (this.j != null) {
                try {
                    this.o[0] = Float.valueOf(this.t);
                    this.j.invoke(obj, this.o);
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                } catch (InvocationTargetException e3) {
                    Log.e("PropertyValuesHolder", e3.toString());
                }
            }
        }

        @Override // c.n.a.j
        public void i(Class cls) {
            if (this.f2909i != null) {
                return;
            }
            super.i(cls);
        }

        @Override // c.n.a.j
        public void setFloatValues(float... fArr) {
            super.setFloatValues(fArr);
            this.s = (c.n.a.c) this.m;
        }

        @Override // c.n.a.j
        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public b mo10clone() {
            b bVar = (b) super.mo10clone();
            bVar.s = (c.n.a.c) bVar.m;
            return bVar;
        }

        public b(c.n.b.d dVar, c.n.a.c cVar) {
            super(dVar);
            this.l = Float.TYPE;
            this.m = cVar;
            this.s = cVar;
            if (dVar instanceof c.n.b.a) {
                this.r = (c.n.b.a) this.f2909i;
            }
        }

        public b(String str, float... fArr) {
            super(str);
            setFloatValues(fArr);
        }

        public b(c.n.b.d dVar, float... fArr) {
            super(dVar);
            setFloatValues(fArr);
            if (dVar instanceof c.n.b.a) {
                this.r = (c.n.b.a) this.f2909i;
            }
        }
    }

    public static class c extends j {
        public c.n.b.b r;
        public e s;
        public int t;

        public c(String str, e eVar) {
            super(str);
            this.l = Integer.TYPE;
            this.m = eVar;
            this.s = eVar;
        }

        @Override // c.n.a.j
        public void a(float f2) {
            this.t = this.s.getIntValue(f2);
        }

        @Override // c.n.a.j
        public Object b() {
            return Integer.valueOf(this.t);
        }

        @Override // c.n.a.j
        public void f(Object obj) {
            c.n.b.b bVar = this.r;
            if (bVar != null) {
                bVar.setValue(obj, this.t);
                return;
            }
            c.n.b.d dVar = this.f2909i;
            if (dVar != null) {
                dVar.set(obj, Integer.valueOf(this.t));
                return;
            }
            if (this.j != null) {
                try {
                    this.o[0] = Integer.valueOf(this.t);
                    this.j.invoke(obj, this.o);
                } catch (IllegalAccessException e2) {
                    Log.e("PropertyValuesHolder", e2.toString());
                } catch (InvocationTargetException e3) {
                    Log.e("PropertyValuesHolder", e3.toString());
                }
            }
        }

        @Override // c.n.a.j
        public void i(Class cls) {
            if (this.f2909i != null) {
                return;
            }
            super.i(cls);
        }

        @Override // c.n.a.j
        public void setIntValues(int... iArr) {
            super.setIntValues(iArr);
            this.s = (e) this.m;
        }

        @Override // c.n.a.j
        /* JADX INFO: renamed from: clone */
        public c mo10clone() {
            c cVar = (c) super.mo10clone();
            cVar.s = (e) cVar.m;
            return cVar;
        }

        public c(c.n.b.d dVar, e eVar) {
            super(dVar);
            this.l = Integer.TYPE;
            this.m = eVar;
            this.s = eVar;
            if (dVar instanceof c.n.b.b) {
                this.r = (c.n.b.b) this.f2909i;
            }
        }

        public c(String str, int... iArr) {
            super(str);
            setIntValues(iArr);
        }

        public c(c.n.b.d dVar, int... iArr) {
            super(dVar);
            setIntValues(iArr);
            if (dVar instanceof c.n.b.b) {
                this.r = (c.n.b.b) this.f2909i;
            }
        }
    }

    public static j ofFloat(c.n.b.d<?, Float> dVar, float... fArr) {
        return new b(dVar, fArr);
    }

    public static j ofInt(c.n.b.d<?, Integer> dVar, int... iArr) {
        return new c(dVar, iArr);
    }

    @Override // 
    /* JADX INFO: renamed from: clone */
    public j mo10clone() {
        try {
            j jVar = (j) super.clone();
            jVar.f2908h = this.f2908h;
            jVar.f2909i = this.f2909i;
            jVar.m = this.m.mo8clone();
            jVar.p = this.p;
            return jVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public j(String str) {
        this.j = null;
        this.k = null;
        this.m = null;
        this.n = new ReentrantReadWriteLock();
        this.o = new Object[1];
        this.f2908h = str;
    }

    public static <V> j ofObject(c.n.b.d dVar, k<V> kVar, V... vArr) {
        j jVar = new j(dVar);
        jVar.setObjectValues(vArr);
        jVar.setEvaluator(kVar);
        return jVar;
    }

    public static j ofKeyframe(c.n.b.d dVar, f... fVarArr) {
        g gVarOfKeyframe = g.ofKeyframe(fVarArr);
        if (gVarOfKeyframe instanceof e) {
            return new c(dVar, (e) gVarOfKeyframe);
        }
        if (gVarOfKeyframe instanceof c.n.a.c) {
            return new b(dVar, (c.n.a.c) gVarOfKeyframe);
        }
        j jVar = new j(dVar);
        jVar.m = gVarOfKeyframe;
        jVar.l = fVarArr[0].getType();
        return jVar;
    }

    public j(c.n.b.d dVar) {
        this.j = null;
        this.k = null;
        this.m = null;
        this.n = new ReentrantReadWriteLock();
        this.o = new Object[1];
        this.f2909i = dVar;
        if (dVar != null) {
            this.f2908h = dVar.getName();
        }
    }
}
