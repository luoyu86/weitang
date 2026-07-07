package g.b.a;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f14679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f14680b = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Class<?>, List<Class<?>>> f14681c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<?>, CopyOnWriteArrayList<q>> f14682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Object, List<Class<?>>> f14683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Class<?>, Object> f14684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ThreadLocal<C0264c> f14685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final h f14686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final l f14687i;
    public final g.b.a.b j;
    public final g.b.a.a k;
    public final p l;
    public final ExecutorService m;
    public final boolean n;
    public final boolean o;
    public final boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f14688q;
    public final boolean r;
    public final boolean s;
    public final int t;
    public final g u;

    public class a extends ThreadLocal<C0264c> {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0264c initialValue() {
            return new C0264c();
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14690a;

        static {
            int[] iArr = new int[r.values().length];
            f14690a = iArr;
            try {
                iArr[r.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14690a[r.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14690a[r.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14690a[r.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14690a[r.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: renamed from: g.b.a.c$c, reason: collision with other inner class name */
    public static final class C0264c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Object> f14691a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f14693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public q f14694d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f14695e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f14696f;
    }

    public c() {
        this(f14680b);
    }

    public static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static d builder() {
        return new d();
    }

    public static void clearCaches() {
        p.a();
        f14681c.clear();
    }

    public static c getDefault() {
        if (f14679a == null) {
            synchronized (c.class) {
                if (f14679a == null) {
                    f14679a = new c();
                }
            }
        }
        return f14679a;
    }

    public static List<Class<?>> h(Class<?> cls) {
        List<Class<?>> arrayList;
        Map<Class<?>, List<Class<?>>> map = f14681c;
        synchronized (map) {
            arrayList = map.get(cls);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.add(superclass);
                    a(arrayList, superclass.getInterfaces());
                }
                f14681c.put(cls, arrayList);
            }
        }
        return arrayList;
    }

    public final void b(q qVar, Object obj) {
        if (obj != null) {
            k(qVar, obj, g());
        }
    }

    public ExecutorService c() {
        return this.m;
    }

    public void cancelEventDelivery(Object obj) {
        C0264c c0264c = this.f14685g.get();
        if (!c0264c.f14692b) {
            throw new e("This method may only be called from inside event handling methods on the posting thread");
        }
        if (obj == null) {
            throw new e("Event may not be null");
        }
        if (c0264c.f14695e != obj) {
            throw new e("Only the currently handled event may be aborted");
        }
        if (c0264c.f14694d.f14745b.f14726b != r.POSTING) {
            throw new e(" event handlers may only abort the incoming event");
        }
        c0264c.f14696f = true;
    }

    public final void d(q qVar, Object obj, Throwable th) {
        if (!(obj instanceof n)) {
            if (this.n) {
                throw new e("Invoking subscriber failed", th);
            }
            if (this.o) {
                this.u.log(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + qVar.f14744a.getClass(), th);
            }
            if (this.f14688q) {
                post(new n(this, th, obj, qVar.f14744a));
                return;
            }
            return;
        }
        if (this.o) {
            g gVar = this.u;
            Level level = Level.SEVERE;
            gVar.log(level, "SubscriberExceptionEvent subscriber " + qVar.f14744a.getClass() + " threw an exception", th);
            n nVar = (n) obj;
            this.u.log(level, "Initial event " + nVar.f14723c + " caused exception in " + nVar.f14724d, nVar.f14722b);
        }
    }

    public void e(j jVar) {
        Object obj = jVar.f14716b;
        q qVar = jVar.f14717c;
        j.b(jVar);
        if (qVar.f14746c) {
            f(qVar, obj);
        }
    }

    public void f(q qVar, Object obj) {
        try {
            qVar.f14745b.f14725a.invoke(qVar.f14744a, obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            d(qVar, obj, e3.getCause());
        }
    }

    public final boolean g() {
        h hVar = this.f14686h;
        if (hVar != null) {
            return hVar.isMainThread();
        }
        return true;
    }

    public g getLogger() {
        return this.u;
    }

    public <T> T getStickyEvent(Class<T> cls) {
        T tCast;
        synchronized (this.f14684f) {
            tCast = cls.cast(this.f14684f.get(cls));
        }
        return tCast;
    }

    public boolean hasSubscriberForEvent(Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList;
        List<Class<?>> listH = h(cls);
        if (listH != null) {
            int size = listH.size();
            for (int i2 = 0; i2 < size; i2++) {
                Class<?> cls2 = listH.get(i2);
                synchronized (this) {
                    copyOnWriteArrayList = this.f14682d.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void i(Object obj, C0264c c0264c) throws Error {
        boolean zJ;
        Class<?> cls = obj.getClass();
        if (this.s) {
            List<Class<?>> listH = h(cls);
            int size = listH.size();
            zJ = false;
            for (int i2 = 0; i2 < size; i2++) {
                zJ |= j(obj, c0264c, listH.get(i2));
            }
        } else {
            zJ = j(obj, c0264c, cls);
        }
        if (zJ) {
            return;
        }
        if (this.p) {
            this.u.log(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.r || cls == i.class || cls == n.class) {
            return;
        }
        post(new i(this, obj));
    }

    public synchronized boolean isRegistered(Object obj) {
        return this.f14683e.containsKey(obj);
    }

    public final boolean j(Object obj, C0264c c0264c, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f14682d.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (q qVar : copyOnWriteArrayList) {
            c0264c.f14695e = obj;
            c0264c.f14694d = qVar;
            try {
                k(qVar, obj, c0264c.f14693c);
                if (c0264c.f14696f) {
                    return true;
                }
            } finally {
                c0264c.f14695e = null;
                c0264c.f14694d = null;
                c0264c.f14696f = false;
            }
        }
        return true;
    }

    public final void k(q qVar, Object obj, boolean z) {
        int i2 = b.f14690a[qVar.f14745b.f14726b.ordinal()];
        if (i2 == 1) {
            f(qVar, obj);
            return;
        }
        if (i2 == 2) {
            if (z) {
                f(qVar, obj);
                return;
            } else {
                this.f14687i.enqueue(qVar, obj);
                return;
            }
        }
        if (i2 == 3) {
            l lVar = this.f14687i;
            if (lVar != null) {
                lVar.enqueue(qVar, obj);
                return;
            } else {
                f(qVar, obj);
                return;
            }
        }
        if (i2 == 4) {
            if (z) {
                this.j.enqueue(qVar, obj);
                return;
            } else {
                f(qVar, obj);
                return;
            }
        }
        if (i2 == 5) {
            this.k.enqueue(qVar, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + qVar.f14745b.f14726b);
    }

    public final void l(Object obj, o oVar) {
        Class<?> cls = oVar.f14727c;
        q qVar = new q(obj, oVar);
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.f14682d.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f14682d.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(qVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || oVar.f14728d > copyOnWriteArrayList.get(i2).f14745b.f14728d) {
                copyOnWriteArrayList.add(i2, qVar);
                break;
            }
        }
        List<Class<?>> arrayList = this.f14683e.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f14683e.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (oVar.f14729e) {
            if (!this.s) {
                b(qVar, this.f14684f.get(cls));
                return;
            }
            for (Map.Entry<Class<?>, Object> entry : this.f14684f.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    b(qVar, entry.getValue());
                }
            }
        }
    }

    public final void m(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.f14682d.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = copyOnWriteArrayList.get(i2);
                if (qVar.f14744a == obj) {
                    qVar.f14746c = false;
                    copyOnWriteArrayList.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    public void post(Object obj) {
        C0264c c0264c = this.f14685g.get();
        List<Object> list = c0264c.f14691a;
        list.add(obj);
        if (c0264c.f14692b) {
            return;
        }
        c0264c.f14693c = g();
        c0264c.f14692b = true;
        if (c0264c.f14696f) {
            throw new e("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                } else {
                    i(list.remove(0), c0264c);
                }
            } finally {
                c0264c.f14692b = false;
                c0264c.f14693c = false;
            }
        }
    }

    public void postSticky(Object obj) {
        synchronized (this.f14684f) {
            this.f14684f.put(obj.getClass(), obj);
        }
        post(obj);
    }

    public void register(Object obj) {
        List<o> listB = this.l.b(obj.getClass());
        synchronized (this) {
            Iterator<o> it = listB.iterator();
            while (it.hasNext()) {
                l(obj, it.next());
            }
        }
    }

    public void removeAllStickyEvents() {
        synchronized (this.f14684f) {
            this.f14684f.clear();
        }
    }

    public <T> T removeStickyEvent(Class<T> cls) {
        T tCast;
        synchronized (this.f14684f) {
            tCast = cls.cast(this.f14684f.remove(cls));
        }
        return tCast;
    }

    public String toString() {
        return "EventBus[indexCount=" + this.t + ", eventInheritance=" + this.s + "]";
    }

    public synchronized void unregister(Object obj) {
        List<Class<?>> list = this.f14683e.get(obj);
        if (list != null) {
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                m(obj, it.next());
            }
            this.f14683e.remove(obj);
        } else {
            this.u.log(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public c(d dVar) {
        this.f14685g = new a();
        this.u = dVar.b();
        this.f14682d = new HashMap();
        this.f14683e = new HashMap();
        this.f14684f = new ConcurrentHashMap();
        h hVarC = dVar.c();
        this.f14686h = hVarC;
        this.f14687i = hVarC != null ? hVarC.createPoster(this) : null;
        this.j = new g.b.a.b(this);
        this.k = new g.b.a.a(this);
        List<g.b.a.s.b> list = dVar.l;
        this.t = list != null ? list.size() : 0;
        this.l = new p(dVar.l, dVar.f14705i, dVar.f14704h);
        this.o = dVar.f14698b;
        this.p = dVar.f14699c;
        this.f14688q = dVar.f14700d;
        this.r = dVar.f14701e;
        this.n = dVar.f14702f;
        this.s = dVar.f14703g;
        this.m = dVar.j;
    }

    public boolean removeStickyEvent(Object obj) {
        synchronized (this.f14684f) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f14684f.get(cls))) {
                return false;
            }
            this.f14684f.remove(cls);
            return true;
        }
    }
}
