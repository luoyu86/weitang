package d.g0.i1;

import com.alipay.sdk.m.u.i;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import d.g0.l;
import d.k0.d.n0.g;
import d.k0.d.t;
import d.m0.p;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class d<K, V> implements Map<K, V>, d.k0.d.n0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12479a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d.g0.i1.f<K> f12482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g<V> f12483e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d.g0.i1.e<K, V> f12484f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f12485g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public K[] f12486h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public V[] f12487i;
    public int[] j;
    public int[] k;
    public int l;
    public int m;

    public static final class a {
        public a() {
        }

        public final int a(int i2) {
            return Integer.highestOneBit(p.coerceAtLeast(i2, 1) * 3);
        }

        public final int b(int i2) {
            return Integer.numberOfLeadingZeros(i2) + 1;
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public static final class b<K, V> extends C0233d<K, V> implements Iterator<Map.Entry<K, V>>, d.k0.d.n0.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d<K, V> dVar) {
            super(dVar);
            t.checkNotNullParameter(dVar, "map");
        }

        public final void nextAppendString(StringBuilder sb) {
            t.checkNotNullParameter(sb, "sb");
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().m) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object obj = getMap$kotlin_stdlib().f12486h[getLastIndex$kotlin_stdlib()];
            if (t.areEqual(obj, getMap$kotlin_stdlib())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append(com.alipay.sdk.m.n.a.f5521h);
            Object[] objArr = getMap$kotlin_stdlib().f12487i;
            t.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
            if (t.areEqual(obj2, getMap$kotlin_stdlib())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            initNext$kotlin_stdlib();
        }

        public final int nextHashCode$kotlin_stdlib() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().m) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object obj = getMap$kotlin_stdlib().f12486h[getLastIndex$kotlin_stdlib()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = getMap$kotlin_stdlib().f12487i;
            t.checkNotNull(objArr);
            Object obj2 = objArr[getLastIndex$kotlin_stdlib()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            initNext$kotlin_stdlib();
            return iHashCode2;
        }

        @Override // java.util.Iterator
        public c<K, V> next() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().m) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            c<K, V> cVar = new c<>(getMap$kotlin_stdlib(), getLastIndex$kotlin_stdlib());
            initNext$kotlin_stdlib();
            return cVar;
        }
    }

    public static final class c<K, V> implements Map.Entry<K, V>, g.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d<K, V> f12488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12489b;

        public c(d<K, V> dVar, int i2) {
            t.checkNotNullParameter(dVar, "map");
            this.f12488a = dVar;
            this.f12489b = i2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (t.areEqual(entry.getKey(), getKey()) && t.areEqual(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) this.f12488a.f12486h[this.f12489b];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = this.f12488a.f12487i;
            t.checkNotNull(objArr);
            return (V) objArr[this.f12489b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            this.f12488a.checkIsMutable$kotlin_stdlib();
            Object[] objArrA = this.f12488a.a();
            int i2 = this.f12489b;
            V v2 = (V) objArrA[i2];
            objArrA[i2] = v;
            return v2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append(com.alipay.sdk.m.n.a.f5521h);
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: d.g0.i1.d$d, reason: collision with other inner class name */
    public static class C0233d<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12491b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d<K, V> f12492c;

        public C0233d(d<K, V> dVar) {
            t.checkNotNullParameter(dVar, "map");
            this.f12492c = dVar;
            this.f12491b = -1;
            initNext$kotlin_stdlib();
        }

        public final int getIndex$kotlin_stdlib() {
            return this.f12490a;
        }

        public final int getLastIndex$kotlin_stdlib() {
            return this.f12491b;
        }

        public final d<K, V> getMap$kotlin_stdlib() {
            return this.f12492c;
        }

        public final boolean hasNext() {
            return this.f12490a < this.f12492c.m;
        }

        public final void initNext$kotlin_stdlib() {
            while (this.f12490a < this.f12492c.m) {
                int[] iArr = this.f12492c.j;
                int i2 = this.f12490a;
                if (iArr[i2] >= 0) {
                    return;
                } else {
                    this.f12490a = i2 + 1;
                }
            }
        }

        public final void remove() {
            this.f12492c.checkIsMutable$kotlin_stdlib();
            this.f12492c.p(this.f12491b);
            this.f12491b = -1;
        }

        public final void setIndex$kotlin_stdlib(int i2) {
            this.f12490a = i2;
        }

        public final void setLastIndex$kotlin_stdlib(int i2) {
            this.f12491b = i2;
        }
    }

    public static final class e<K, V> extends C0233d<K, V> implements Iterator<K>, d.k0.d.n0.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d<K, V> dVar) {
            super(dVar);
            t.checkNotNullParameter(dVar, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().m) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            K k = (K) getMap$kotlin_stdlib().f12486h[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return k;
        }
    }

    public static final class f<K, V> extends C0233d<K, V> implements Iterator<V>, d.k0.d.n0.d {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d<K, V> dVar) {
            super(dVar);
            t.checkNotNullParameter(dVar, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (getIndex$kotlin_stdlib() >= getMap$kotlin_stdlib().m) {
                throw new NoSuchElementException();
            }
            int index$kotlin_stdlib = getIndex$kotlin_stdlib();
            setIndex$kotlin_stdlib(index$kotlin_stdlib + 1);
            setLastIndex$kotlin_stdlib(index$kotlin_stdlib);
            Object[] objArr = getMap$kotlin_stdlib().f12487i;
            t.checkNotNull(objArr);
            V v = (V) objArr[getLastIndex$kotlin_stdlib()];
            initNext$kotlin_stdlib();
            return v;
        }
    }

    public d(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i2, int i3) {
        this.f12486h = kArr;
        this.f12487i = vArr;
        this.j = iArr;
        this.k = iArr2;
        this.l = i2;
        this.m = i3;
        this.f12480b = f12479a.b(i());
    }

    public final V[] a() {
        V[] vArr = this.f12487i;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) d.g0.i1.c.arrayOfUninitializedElements(h());
        this.f12487i = vArr2;
        return vArr2;
    }

    public final int addKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        while (true) {
            int iJ = j(k);
            int iCoerceAtMost = p.coerceAtMost(this.l * 2, i() / 2);
            int i2 = 0;
            while (true) {
                int i3 = this.k[iJ];
                if (i3 <= 0) {
                    if (this.m < h()) {
                        int i4 = this.m;
                        int i5 = i4 + 1;
                        this.m = i5;
                        this.f12486h[i4] = k;
                        this.j[i4] = iJ;
                        this.k[iJ] = i5;
                        this.f12481c = size() + 1;
                        if (i2 > this.l) {
                            this.l = i2;
                        }
                        return i4;
                    }
                    e(1);
                } else {
                    if (t.areEqual(this.f12486h[i3 - 1], k)) {
                        return -i3;
                    }
                    i2++;
                    if (i2 > iCoerceAtMost) {
                        n(i() * 2);
                        break;
                    }
                    iJ = iJ == 0 ? i() - 1 : iJ - 1;
                }
            }
        }
    }

    public final void b() {
        int i2;
        V[] vArr = this.f12487i;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = this.m;
            if (i3 >= i2) {
                break;
            }
            if (this.j[i3] >= 0) {
                K[] kArr = this.f12486h;
                kArr[i4] = kArr[i3];
                if (vArr != null) {
                    vArr[i4] = vArr[i3];
                }
                i4++;
            }
            i3++;
        }
        d.g0.i1.c.resetRange(this.f12486h, i4, i2);
        if (vArr != null) {
            d.g0.i1.c.resetRange(vArr, i4, this.m);
        }
        this.m = i4;
    }

    public final Map<K, V> build() {
        checkIsMutable$kotlin_stdlib();
        this.f12485g = true;
        return this;
    }

    public final boolean c(Map<?, ?> map) {
        return size() == map.size() && containsAllEntries$kotlin_stdlib(map.entrySet());
    }

    public final void checkIsMutable$kotlin_stdlib() {
        if (this.f12485g) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public void clear() {
        checkIsMutable$kotlin_stdlib();
        int i2 = this.m - 1;
        if (i2 >= 0) {
            int i3 = 0;
            while (true) {
                int[] iArr = this.j;
                int i4 = iArr[i3];
                if (i4 >= 0) {
                    this.k[i4] = 0;
                    iArr[i3] = -1;
                }
                if (i3 == i2) {
                    break;
                } else {
                    i3++;
                }
            }
        }
        d.g0.i1.c.resetRange(this.f12486h, 0, this.m);
        V[] vArr = this.f12487i;
        if (vArr != null) {
            d.g0.i1.c.resetRange(vArr, 0, this.m);
        }
        this.f12481c = 0;
        this.m = 0;
    }

    public final boolean containsAllEntries$kotlin_stdlib(Collection<?> collection) {
        t.checkNotNullParameter(collection, OperatorName.MOVE_TO);
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!containsEntry$kotlin_stdlib((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean containsEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        t.checkNotNullParameter(entry, "entry");
        int iF = f(entry.getKey());
        if (iF < 0) {
            return false;
        }
        V[] vArr = this.f12487i;
        t.checkNotNull(vArr);
        return t.areEqual(vArr[iF], entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return g(obj) >= 0;
    }

    public final void d(int i2) {
        if (i2 <= h()) {
            if ((this.m + i2) - size() > h()) {
                n(i());
                return;
            }
            return;
        }
        int iH = (h() * 3) / 2;
        if (i2 <= iH) {
            i2 = iH;
        }
        this.f12486h = (K[]) d.g0.i1.c.copyOfUninitializedElements(this.f12486h, i2);
        V[] vArr = this.f12487i;
        this.f12487i = vArr != null ? (V[]) d.g0.i1.c.copyOfUninitializedElements(vArr, i2) : null;
        int[] iArrCopyOf = Arrays.copyOf(this.j, i2);
        t.checkNotNullExpressionValue(iArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        this.j = iArrCopyOf;
        int iA = f12479a.a(i2);
        if (iA > i()) {
            n(iA);
        }
    }

    public final void e(int i2) {
        d(this.m + i2);
    }

    public final b<K, V> entriesIterator$kotlin_stdlib() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof Map) && c((Map) obj));
    }

    public final int f(K k) {
        int iJ = j(k);
        int i2 = this.l;
        while (true) {
            int i3 = this.k[iJ];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (t.areEqual(this.f12486h[i4], k)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            iJ = iJ == 0 ? i() - 1 : iJ - 1;
        }
    }

    public final int g(V v) {
        int i2 = this.m;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.j[i2] >= 0) {
                V[] vArr = this.f12487i;
                t.checkNotNull(vArr);
                if (t.areEqual(vArr[i2], v)) {
                    return i2;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object obj) {
        int iF = f(obj);
        if (iF < 0) {
            return null;
        }
        V[] vArr = this.f12487i;
        t.checkNotNull(vArr);
        return vArr[iF];
    }

    public Set<Map.Entry<K, V>> getEntries() {
        d.g0.i1.e<K, V> eVar = this.f12484f;
        if (eVar != null) {
            return eVar;
        }
        d.g0.i1.e<K, V> eVar2 = new d.g0.i1.e<>(this);
        this.f12484f = eVar2;
        return eVar2;
    }

    public Set<K> getKeys() {
        d.g0.i1.f<K> fVar = this.f12482d;
        if (fVar != null) {
            return fVar;
        }
        d.g0.i1.f<K> fVar2 = new d.g0.i1.f<>(this);
        this.f12482d = fVar2;
        return fVar2;
    }

    public int getSize() {
        return this.f12481c;
    }

    public Collection<V> getValues() {
        g<V> gVar = this.f12483e;
        if (gVar != null) {
            return gVar;
        }
        g<V> gVar2 = new g<>(this);
        this.f12483e = gVar2;
        return gVar2;
    }

    public final int h() {
        return this.f12486h.length;
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int iNextHashCode$kotlin_stdlib = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            iNextHashCode$kotlin_stdlib += bVarEntriesIterator$kotlin_stdlib.nextHashCode$kotlin_stdlib();
        }
        return iNextHashCode$kotlin_stdlib;
    }

    public final int i() {
        return this.k.length;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final int j(K k) {
        return ((k != null ? k.hashCode() : 0) * (-1640531527)) >>> this.f12480b;
    }

    public final boolean k(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        e(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = collection.iterator();
        while (it.hasNext()) {
            if (l(it.next())) {
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    public final e<K, V> keysIterator$kotlin_stdlib() {
        return new e<>(this);
    }

    public final boolean l(Map.Entry<? extends K, ? extends V> entry) {
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(entry.getKey());
        V[] vArrA = a();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrA[iAddKey$kotlin_stdlib] = entry.getValue();
            return true;
        }
        int i2 = (-iAddKey$kotlin_stdlib) - 1;
        if (!(!t.areEqual(entry.getValue(), vArrA[i2]))) {
            return false;
        }
        vArrA[i2] = entry.getValue();
        return true;
    }

    public final boolean m(int i2) {
        int iJ = j(this.f12486h[i2]);
        int i3 = this.l;
        while (true) {
            int[] iArr = this.k;
            if (iArr[iJ] == 0) {
                iArr[iJ] = i2 + 1;
                this.j[i2] = iJ;
                return true;
            }
            i3--;
            if (i3 < 0) {
                return false;
            }
            iJ = iJ == 0 ? i() - 1 : iJ - 1;
        }
    }

    public final void n(int i2) {
        if (this.m > size()) {
            b();
        }
        int i3 = 0;
        if (i2 != i()) {
            this.k = new int[i2];
            this.f12480b = f12479a.b(i2);
        } else {
            l.fill(this.k, 0, 0, i());
        }
        while (i3 < this.m) {
            int i4 = i3 + 1;
            if (!m(i3)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i3 = i4;
        }
    }

    public final void o(int i2) {
        int iCoerceAtMost = p.coerceAtMost(this.l * 2, i() / 2);
        int i3 = 0;
        int i4 = i2;
        do {
            i2 = i2 == 0 ? i() - 1 : i2 - 1;
            i3++;
            if (i3 > this.l) {
                this.k[i4] = 0;
                return;
            }
            int[] iArr = this.k;
            int i5 = iArr[i2];
            if (i5 == 0) {
                iArr[i4] = 0;
                return;
            }
            if (i5 < 0) {
                iArr[i4] = -1;
            } else {
                int i6 = i5 - 1;
                if (((j(this.f12486h[i6]) - i2) & (i() - 1)) >= i3) {
                    this.k[i4] = i5;
                    this.j[i6] = i4;
                }
                iCoerceAtMost--;
            }
            i4 = i2;
            i3 = 0;
            iCoerceAtMost--;
        } while (iCoerceAtMost >= 0);
        this.k[i4] = -1;
    }

    public final void p(int i2) {
        d.g0.i1.c.resetAt(this.f12486h, i2);
        o(this.j[i2]);
        this.j[i2] = -1;
        this.f12481c = size() - 1;
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        checkIsMutable$kotlin_stdlib();
        int iAddKey$kotlin_stdlib = addKey$kotlin_stdlib(k);
        V[] vArrA = a();
        if (iAddKey$kotlin_stdlib >= 0) {
            vArrA[iAddKey$kotlin_stdlib] = v;
            return null;
        }
        int i2 = (-iAddKey$kotlin_stdlib) - 1;
        V v2 = vArrA[i2];
        vArrA[i2] = v;
        return v2;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        t.checkNotNullParameter(map, "from");
        checkIsMutable$kotlin_stdlib();
        k(map.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object obj) {
        int iRemoveKey$kotlin_stdlib = removeKey$kotlin_stdlib(obj);
        if (iRemoveKey$kotlin_stdlib < 0) {
            return null;
        }
        V[] vArr = this.f12487i;
        t.checkNotNull(vArr);
        V v = vArr[iRemoveKey$kotlin_stdlib];
        d.g0.i1.c.resetAt(vArr, iRemoveKey$kotlin_stdlib);
        return v;
    }

    public final boolean removeEntry$kotlin_stdlib(Map.Entry<? extends K, ? extends V> entry) {
        t.checkNotNullParameter(entry, "entry");
        checkIsMutable$kotlin_stdlib();
        int iF = f(entry.getKey());
        if (iF < 0) {
            return false;
        }
        t.checkNotNull(this.f12487i);
        if (!t.areEqual(r2[iF], entry.getValue())) {
            return false;
        }
        p(iF);
        return true;
    }

    public final int removeKey$kotlin_stdlib(K k) {
        checkIsMutable$kotlin_stdlib();
        int iF = f(k);
        if (iF < 0) {
            return -1;
        }
        p(iF);
        return iF;
    }

    public final boolean removeValue$kotlin_stdlib(V v) {
        checkIsMutable$kotlin_stdlib();
        int iG = g(v);
        if (iG < 0) {
            return false;
        }
        p(iG);
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b<K, V> bVarEntriesIterator$kotlin_stdlib = entriesIterator$kotlin_stdlib();
        int i2 = 0;
        while (bVarEntriesIterator$kotlin_stdlib.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            bVarEntriesIterator$kotlin_stdlib.nextAppendString(sb);
            i2++;
        }
        sb.append(i.f5699d);
        String string = sb.toString();
        t.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }

    public final f<K, V> valuesIterator$kotlin_stdlib() {
        return new f<>(this);
    }

    public d() {
        this(8);
    }

    public d(int i2) {
        this(d.g0.i1.c.arrayOfUninitializedElements(i2), null, new int[i2], new int[f12479a.a(i2)], 2, 0);
    }
}
