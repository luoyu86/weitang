package d;

import d.g0.g1;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class y implements Collection<x>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f12968a;

    public static final class a extends g1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f12970b;

        public a(long[] jArr) {
            d.k0.d.t.checkNotNullParameter(jArr, "array");
            this.f12970b = jArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12969a < this.f12970b.length;
        }

        @Override // d.g0.g1
        /* JADX INFO: renamed from: nextULong-s-VKNKU */
        public long mo140nextULongsVKNKU() {
            int i2 = this.f12969a;
            long[] jArr = this.f12970b;
            if (i2 >= jArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f12969a));
            }
            this.f12969a = i2 + 1;
            return x.m448constructorimpl(jArr[i2]);
        }
    }

    public /* synthetic */ y(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "storage");
        this.f12968a = jArr;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ y m454boximpl(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "v");
        return new y(jArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long[] m455constructorimpl(int i2) {
        return m456constructorimpl(new long[i2]);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long[] m456constructorimpl(long[] jArr) {
        d.k0.d.t.checkNotNullParameter(jArr, "storage");
        return jArr;
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m458containsAllimpl(long[] jArr, Collection<x> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        if (!collection.isEmpty()) {
            for (Object obj : collection) {
                if (!((obj instanceof x) && d.g0.m.contains(jArr, ((x) obj).m453unboximpl()))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m459equalsimpl(long[] jArr, Object obj) {
        return (obj instanceof y) && d.k0.d.t.areEqual(jArr, ((y) obj).m470unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m460equalsimpl0(long[] jArr, long[] jArr2) {
        return d.k0.d.t.areEqual(jArr, jArr2);
    }

    /* JADX INFO: renamed from: get-s-VKNKU, reason: not valid java name */
    public static final long m461getsVKNKU(long[] jArr, int i2) {
        return x.m448constructorimpl(jArr[i2]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m462getSizeimpl(long[] jArr) {
        return jArr.length;
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m463hashCodeimpl(long[] jArr) {
        if (jArr != null) {
            return Arrays.hashCode(jArr);
        }
        return 0;
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m464isEmptyimpl(long[] jArr) {
        return jArr.length == 0;
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static g1 m465iteratorimpl(long[] jArr) {
        return new a(jArr);
    }

    /* JADX INFO: renamed from: set-k8EXiF4, reason: not valid java name */
    public static final void m466setk8EXiF4(long[] jArr, int i2, long j) {
        jArr[i2] = j;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m467toStringimpl(long[] jArr) {
        return "ULongArray(storage=" + Arrays.toString(jArr) + ")";
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(x xVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: add-VKZWuLQ, reason: not valid java name */
    public boolean m468addVKZWuLQ(long j) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends x> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof x) {
            return m469containsVKZWuLQ(((x) obj).m453unboximpl());
        }
        return false;
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public boolean m469containsVKZWuLQ(long j) {
        return m457containsVKZWuLQ(this.f12968a, j);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        return m458containsAllimpl(this.f12968a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m459equalsimpl(this.f12968a, obj);
    }

    public int getSize() {
        return m462getSizeimpl(this.f12968a);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m463hashCodeimpl(this.f12968a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m464isEmptyimpl(this.f12968a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public g1 iterator() {
        return m465iteratorimpl(this.f12968a);
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
        return m467toStringimpl(this.f12968a);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long[] m470unboximpl() {
        return this.f12968a;
    }

    /* JADX INFO: renamed from: contains-VKZWuLQ, reason: not valid java name */
    public static boolean m457containsVKZWuLQ(long[] jArr, long j) {
        return d.g0.m.contains(jArr, j);
    }
}
