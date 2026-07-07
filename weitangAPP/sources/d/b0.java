package d;

import d.g0.h1;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 implements Collection<a0>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short[] f12418a;

    public static final class a extends h1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final short[] f12420b;

        public a(short[] sArr) {
            d.k0.d.t.checkNotNullParameter(sArr, "array");
            this.f12420b = sArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12419a < this.f12420b.length;
        }

        @Override // d.g0.h1
        /* JADX INFO: renamed from: nextUShort-Mh2AYeg, reason: not valid java name */
        public short mo118nextUShortMh2AYeg() {
            int i2 = this.f12419a;
            short[] sArr = this.f12420b;
            if (i2 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f12419a));
            }
            this.f12419a = i2 + 1;
            return a0.m95constructorimpl(sArr[i2]);
        }
    }

    public /* synthetic */ b0(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "storage");
        this.f12418a = sArr;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ b0 m101boximpl(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "v");
        return new b0(sArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short[] m102constructorimpl(int i2) {
        return m103constructorimpl(new short[i2]);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short[] m103constructorimpl(short[] sArr) {
        d.k0.d.t.checkNotNullParameter(sArr, "storage");
        return sArr;
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m105containsAllimpl(short[] sArr, Collection<a0> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        if (!collection.isEmpty()) {
            for (Object obj : collection) {
                if (!((obj instanceof a0) && d.g0.m.contains(sArr, ((a0) obj).m100unboximpl()))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m106equalsimpl(short[] sArr, Object obj) {
        return (obj instanceof b0) && d.k0.d.t.areEqual(sArr, ((b0) obj).m117unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m107equalsimpl0(short[] sArr, short[] sArr2) {
        return d.k0.d.t.areEqual(sArr, sArr2);
    }

    /* JADX INFO: renamed from: get-Mh2AYeg, reason: not valid java name */
    public static final short m108getMh2AYeg(short[] sArr, int i2) {
        return a0.m95constructorimpl(sArr[i2]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m109getSizeimpl(short[] sArr) {
        return sArr.length;
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m110hashCodeimpl(short[] sArr) {
        if (sArr != null) {
            return Arrays.hashCode(sArr);
        }
        return 0;
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m111isEmptyimpl(short[] sArr) {
        return sArr.length == 0;
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static h1 m112iteratorimpl(short[] sArr) {
        return new a(sArr);
    }

    /* JADX INFO: renamed from: set-01HTLdE, reason: not valid java name */
    public static final void m113set01HTLdE(short[] sArr, int i2, short s) {
        sArr[i2] = s;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m114toStringimpl(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ")";
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(a0 a0Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: add-xj2QHRw, reason: not valid java name */
    public boolean m115addxj2QHRw(short s) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends a0> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof a0) {
            return m116containsxj2QHRw(((a0) obj).m100unboximpl());
        }
        return false;
    }

    /* JADX INFO: renamed from: contains-xj2QHRw, reason: not valid java name */
    public boolean m116containsxj2QHRw(short s) {
        return m104containsxj2QHRw(this.f12418a, s);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        return m105containsAllimpl(this.f12418a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m106equalsimpl(this.f12418a, obj);
    }

    public int getSize() {
        return m109getSizeimpl(this.f12418a);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m110hashCodeimpl(this.f12418a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m111isEmptyimpl(this.f12418a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public h1 iterator() {
        return m112iteratorimpl(this.f12418a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return d.k0.d.o.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) d.k0.d.o.toArray(this, tArr);
    }

    public String toString() {
        return m114toStringimpl(this.f12418a);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short[] m117unboximpl() {
        return this.f12418a;
    }

    /* JADX INFO: renamed from: contains-xj2QHRw, reason: not valid java name */
    public static boolean m104containsxj2QHRw(short[] sArr, short s) {
        return d.g0.m.contains(sArr, s);
    }
}
