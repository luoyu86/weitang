package c.i.b.y;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Type, c.i.b.h<?>> f2627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.i.b.y.n.b f2628b = c.i.b.y.n.b.getInstance();

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements c.i.b.y.h<T> {
        public a() {
        }

        @Override // c.i.b.y.h
        public T construct() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements c.i.b.y.h<T> {
        public b() {
        }

        @Override // c.i.b.y.h
        public T construct() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: c.i.b.y.c$c, reason: collision with other inner class name */
    public class C0036c<T> implements c.i.b.y.h<T> {
        public C0036c() {
        }

        @Override // c.i.b.y.h
        public T construct() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class d<T> implements c.i.b.y.h<T> {
        public d() {
        }

        @Override // c.i.b.y.h
        public T construct() {
            return (T) new c.i.b.y.g();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class e<T> implements c.i.b.y.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c.i.b.y.l f2633a = c.i.b.y.l.create();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f2634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Type f2635c;

        public e(Class cls, Type type) {
            this.f2634b = cls;
            this.f2635c = type;
        }

        @Override // c.i.b.y.h
        public T construct() {
            try {
                return (T) this.f2633a.newInstance(this.f2634b);
            } catch (Exception e2) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f2635c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e2);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class f<T> implements c.i.b.y.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.i.b.h f2637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f2638b;

        public f(c.i.b.h hVar, Type type) {
            this.f2637a = hVar;
            this.f2638b = type;
        }

        @Override // c.i.b.y.h
        public T construct() {
            return (T) this.f2637a.createInstance(this.f2638b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class g<T> implements c.i.b.y.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c.i.b.h f2640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Type f2641b;

        public g(c.i.b.h hVar, Type type) {
            this.f2640a = hVar;
            this.f2641b = type;
        }

        @Override // c.i.b.y.h
        public T construct() {
            return (T) this.f2640a.createInstance(this.f2641b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class h<T> implements c.i.b.y.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Constructor f2643a;

        public h(Constructor constructor) {
            this.f2643a = constructor;
        }

        @Override // c.i.b.y.h
        public T construct() {
            try {
                return (T) this.f2643a.newInstance(null);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Failed to invoke " + this.f2643a + " with no args", e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Failed to invoke " + this.f2643a + " with no args", e4.getTargetException());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class i<T> implements c.i.b.y.h<T> {
        public i() {
        }

        @Override // c.i.b.y.h
        public T construct() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class j<T> implements c.i.b.y.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f2646a;

        public j(Type type) {
            this.f2646a = type;
        }

        @Override // c.i.b.y.h
        public T construct() {
            Type type = this.f2646a;
            if (!(type instanceof ParameterizedType)) {
                throw new c.i.b.m("Invalid EnumSet type: " + this.f2646a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new c.i.b.m("Invalid EnumSet type: " + this.f2646a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class k<T> implements c.i.b.y.h<T> {
        public k() {
        }

        @Override // c.i.b.y.h
        public T construct() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class l<T> implements c.i.b.y.h<T> {
        public l() {
        }

        @Override // c.i.b.y.h
        public T construct() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class m<T> implements c.i.b.y.h<T> {
        public m() {
        }

        @Override // c.i.b.y.h
        public T construct() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class n<T> implements c.i.b.y.h<T> {
        public n() {
        }

        @Override // c.i.b.y.h
        public T construct() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    public c(Map<Type, c.i.b.h<?>> map) {
        this.f2627a = map;
    }

    public final <T> c.i.b.y.h<T> a(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f2628b.makeAccessible(declaredConstructor);
            }
            return new h(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final <T> c.i.b.y.h<T> b(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new i() : EnumSet.class.isAssignableFrom(cls) ? new j(type) : Set.class.isAssignableFrom(cls) ? new k() : Queue.class.isAssignableFrom(cls) ? new l() : new m();
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new n() : ConcurrentMap.class.isAssignableFrom(cls) ? new a() : SortedMap.class.isAssignableFrom(cls) ? new b() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(c.i.b.z.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new d() : new C0036c();
        }
        return null;
    }

    public final <T> c.i.b.y.h<T> c(Type type, Class<? super T> cls) {
        return new e(cls, type);
    }

    public <T> c.i.b.y.h<T> get(c.i.b.z.a<T> aVar) {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        c.i.b.h<?> hVar = this.f2627a.get(type);
        if (hVar != null) {
            return new f(hVar, type);
        }
        c.i.b.h<?> hVar2 = this.f2627a.get(rawType);
        if (hVar2 != null) {
            return new g(hVar2, type);
        }
        c.i.b.y.h<T> hVarA = a(rawType);
        if (hVarA != null) {
            return hVarA;
        }
        c.i.b.y.h<T> hVarB = b(type, rawType);
        return hVarB != null ? hVarB : c(type, rawType);
    }

    public String toString() {
        return this.f2627a.toString();
    }
}
