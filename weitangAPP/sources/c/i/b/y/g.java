package c.i.b.y;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class g<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<Comparable> f2655a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Comparator<? super K> f2656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e<K, V> f2657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e<K, V> f2660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g<K, V>.b f2661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g<K, V>.c f2662h;

    public static class a implements Comparator<Comparable> {
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    public class b extends AbstractSet<Map.Entry<K, V>> {

        public class a extends g<K, V>.d<Map.Entry<K, V>> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && g.this.c((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> eVarC;
            if (!(obj instanceof Map.Entry) || (eVarC = g.this.c((Map.Entry) obj)) == null) {
                return false;
            }
            g.this.f(eVarC, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g.this.f2658d;
        }
    }

    public final class c extends AbstractSet<K> {

        public class a extends g<K, V>.d<K> {
            public a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f2676f;
            }
        }

        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return g.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return g.this.g(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g.this.f2658d;
        }
    }

    public abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<K, V> f2667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e<K, V> f2668b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2669c;

        public d() {
            this.f2667a = g.this.f2660f.f2674d;
            this.f2669c = g.this.f2659e;
        }

        public final e<K, V> a() {
            e<K, V> eVar = this.f2667a;
            g gVar = g.this;
            if (eVar == gVar.f2660f) {
                throw new NoSuchElementException();
            }
            if (gVar.f2659e != this.f2669c) {
                throw new ConcurrentModificationException();
            }
            this.f2667a = eVar.f2674d;
            this.f2668b = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f2667a != g.this.f2660f;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.f2668b;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            g.this.f(eVar, true);
            this.f2668b = null;
            this.f2669c = g.this.f2659e;
        }
    }

    public g() {
        this(f2655a);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    public final boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public e<K, V> b(K k, boolean z) {
        int iCompareTo;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f2656b;
        e<K, V> eVar2 = this.f2657c;
        if (eVar2 != null) {
            Comparable comparable = comparator == f2655a ? (Comparable) k : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(eVar2.f2676f) : comparator.compare(k, eVar2.f2676f);
                if (iCompareTo == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = iCompareTo < 0 ? eVar2.f2672b : eVar2.f2673c;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            iCompareTo = 0;
        }
        if (!z) {
            return null;
        }
        e<K, V> eVar4 = this.f2660f;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k, eVar4, eVar4.f2675e);
            if (iCompareTo < 0) {
                eVar2.f2672b = eVar;
            } else {
                eVar2.f2673c = eVar;
            }
            e(eVar2, true);
        } else {
            if (comparator == f2655a && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(eVar2, k, eVar4, eVar4.f2675e);
            this.f2657c = eVar;
        }
        this.f2658d++;
        this.f2659e++;
        return eVar;
    }

    public e<K, V> c(Map.Entry<?, ?> entry) {
        e<K, V> eVarD = d(entry.getKey());
        if (eVarD != null && a(eVarD.f2677g, entry.getValue())) {
            return eVarD;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f2657c = null;
        this.f2658d = 0;
        this.f2659e++;
        e<K, V> eVar = this.f2660f;
        eVar.f2675e = eVar;
        eVar.f2674d = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return d(obj) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e<K, V> d(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return b(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public final void e(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.f2672b;
            e<K, V> eVar3 = eVar.f2673c;
            int i2 = eVar2 != null ? eVar2.f2678h : 0;
            int i3 = eVar3 != null ? eVar3.f2678h : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                e<K, V> eVar4 = eVar3.f2672b;
                e<K, V> eVar5 = eVar3.f2673c;
                int i5 = (eVar4 != null ? eVar4.f2678h : 0) - (eVar5 != null ? eVar5.f2678h : 0);
                if (i5 == -1 || (i5 == 0 && !z)) {
                    i(eVar);
                } else {
                    j(eVar3);
                    i(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                e<K, V> eVar6 = eVar2.f2672b;
                e<K, V> eVar7 = eVar2.f2673c;
                int i6 = (eVar6 != null ? eVar6.f2678h : 0) - (eVar7 != null ? eVar7.f2678h : 0);
                if (i6 == 1 || (i6 == 0 && !z)) {
                    j(eVar);
                } else {
                    i(eVar2);
                    j(eVar);
                }
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                eVar.f2678h = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                eVar.f2678h = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f2671a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        g<K, V>.b bVar = this.f2661g;
        if (bVar != null) {
            return bVar;
        }
        g<K, V>.b bVar2 = new b();
        this.f2661g = bVar2;
        return bVar2;
    }

    public void f(e<K, V> eVar, boolean z) {
        int i2;
        if (z) {
            e<K, V> eVar2 = eVar.f2675e;
            eVar2.f2674d = eVar.f2674d;
            eVar.f2674d.f2675e = eVar2;
        }
        e<K, V> eVar3 = eVar.f2672b;
        e<K, V> eVar4 = eVar.f2673c;
        e<K, V> eVar5 = eVar.f2671a;
        int i3 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                h(eVar, eVar3);
                eVar.f2672b = null;
            } else if (eVar4 != null) {
                h(eVar, eVar4);
                eVar.f2673c = null;
            } else {
                h(eVar, null);
            }
            e(eVar5, false);
            this.f2658d--;
            this.f2659e++;
            return;
        }
        e<K, V> eVarLast = eVar3.f2678h > eVar4.f2678h ? eVar3.last() : eVar4.first();
        f(eVarLast, false);
        e<K, V> eVar6 = eVar.f2672b;
        if (eVar6 != null) {
            i2 = eVar6.f2678h;
            eVarLast.f2672b = eVar6;
            eVar6.f2671a = eVarLast;
            eVar.f2672b = null;
        } else {
            i2 = 0;
        }
        e<K, V> eVar7 = eVar.f2673c;
        if (eVar7 != null) {
            i3 = eVar7.f2678h;
            eVarLast.f2673c = eVar7;
            eVar7.f2671a = eVarLast;
            eVar.f2673c = null;
        }
        eVarLast.f2678h = Math.max(i2, i3) + 1;
        h(eVar, eVarLast);
    }

    public e<K, V> g(Object obj) {
        e<K, V> eVarD = d(obj);
        if (eVarD != null) {
            f(eVarD, true);
        }
        return eVarD;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> eVarD = d(obj);
        if (eVarD != null) {
            return eVarD.f2677g;
        }
        return null;
    }

    public final void h(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f2671a;
        eVar.f2671a = null;
        if (eVar2 != null) {
            eVar2.f2671a = eVar3;
        }
        if (eVar3 == null) {
            this.f2657c = eVar2;
        } else if (eVar3.f2672b == eVar) {
            eVar3.f2672b = eVar2;
        } else {
            eVar3.f2673c = eVar2;
        }
    }

    public final void i(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f2672b;
        e<K, V> eVar3 = eVar.f2673c;
        e<K, V> eVar4 = eVar3.f2672b;
        e<K, V> eVar5 = eVar3.f2673c;
        eVar.f2673c = eVar4;
        if (eVar4 != null) {
            eVar4.f2671a = eVar;
        }
        h(eVar, eVar3);
        eVar3.f2672b = eVar;
        eVar.f2671a = eVar3;
        int iMax = Math.max(eVar2 != null ? eVar2.f2678h : 0, eVar4 != null ? eVar4.f2678h : 0) + 1;
        eVar.f2678h = iMax;
        eVar3.f2678h = Math.max(iMax, eVar5 != null ? eVar5.f2678h : 0) + 1;
    }

    public final void j(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.f2672b;
        e<K, V> eVar3 = eVar.f2673c;
        e<K, V> eVar4 = eVar2.f2672b;
        e<K, V> eVar5 = eVar2.f2673c;
        eVar.f2672b = eVar5;
        if (eVar5 != null) {
            eVar5.f2671a = eVar;
        }
        h(eVar, eVar2);
        eVar2.f2673c = eVar;
        eVar.f2671a = eVar2;
        int iMax = Math.max(eVar3 != null ? eVar3.f2678h : 0, eVar5 != null ? eVar5.f2678h : 0) + 1;
        eVar.f2678h = iMax;
        eVar2.f2678h = Math.max(iMax, eVar4 != null ? eVar4.f2678h : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        g<K, V>.c cVar = this.f2662h;
        if (cVar != null) {
            return cVar;
        }
        g<K, V>.c cVar2 = new c();
        this.f2662h = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Objects.requireNonNull(k, "key == null");
        e<K, V> eVarB = b(k, true);
        V v2 = eVarB.f2677g;
        eVarB.f2677g = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> eVarG = g(obj);
        if (eVarG != null) {
            return eVarG.f2677g;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f2658d;
    }

    public g(Comparator<? super K> comparator) {
        this.f2658d = 0;
        this.f2659e = 0;
        this.f2660f = new e<>();
        this.f2656b = comparator == null ? f2655a : comparator;
    }

    public static final class e<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e<K, V> f2671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e<K, V> f2672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e<K, V> f2673c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public e<K, V> f2674d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public e<K, V> f2675e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final K f2676f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public V f2677g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f2678h;

        public e() {
            this.f2676f = null;
            this.f2675e = this;
            this.f2674d = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f2676f;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.f2677g;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public e<K, V> first() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f2672b; eVar2 != null; eVar2 = eVar2.f2672b) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f2676f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f2677g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f2676f;
            int iHashCode = k == null ? 0 : k.hashCode();
            V v = this.f2677g;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        public e<K, V> last() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.f2673c; eVar2 != null; eVar2 = eVar2.f2673c) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f2677g;
            this.f2677g = v;
            return v2;
        }

        public String toString() {
            return this.f2676f + "=" + this.f2677g;
        }

        public e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.f2671a = eVar;
            this.f2676f = k;
            this.f2678h = 1;
            this.f2674d = eVar2;
            this.f2675e = eVar3;
            eVar3.f2674d = this;
            eVar2.f2675e = this;
        }
    }
}
