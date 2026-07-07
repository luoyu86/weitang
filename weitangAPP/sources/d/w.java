package d;

import d.g0.f1;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class w implements Collection<v>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f12963a;

    public static final class a extends f1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f12965b;

        public a(int[] iArr) {
            d.k0.d.t.checkNotNullParameter(iArr, "array");
            this.f12965b = iArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12964a < this.f12965b.length;
        }

        @Override // d.g0.f1
        /* JADX INFO: renamed from: nextUInt-pVg5ArA */
        public int mo138nextUIntpVg5ArA() {
            int i2 = this.f12964a;
            int[] iArr = this.f12965b;
            if (i2 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f12964a));
            }
            this.f12964a = i2 + 1;
            return v.m424constructorimpl(iArr[i2]);
        }
    }

    public /* synthetic */ w(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "storage");
        this.f12963a = iArr;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ w m430boximpl(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "v");
        return new w(iArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m431constructorimpl(int i2) {
        return m432constructorimpl(new int[i2]);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int[] m432constructorimpl(int[] iArr) {
        d.k0.d.t.checkNotNullParameter(iArr, "storage");
        return iArr;
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m434containsAllimpl(int[] iArr, Collection<v> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        if (!collection.isEmpty()) {
            for (Object obj : collection) {
                if (!((obj instanceof v) && d.g0.m.contains(iArr, ((v) obj).m429unboximpl()))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m435equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof w) && d.k0.d.t.areEqual(iArr, ((w) obj).m446unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m436equalsimpl0(int[] iArr, int[] iArr2) {
        return d.k0.d.t.areEqual(iArr, iArr2);
    }

    /* JADX INFO: renamed from: get-pVg5ArA, reason: not valid java name */
    public static final int m437getpVg5ArA(int[] iArr, int i2) {
        return v.m424constructorimpl(iArr[i2]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m438getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m439hashCodeimpl(int[] iArr) {
        if (iArr != null) {
            return Arrays.hashCode(iArr);
        }
        return 0;
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m440isEmptyimpl(int[] iArr) {
        return iArr.length == 0;
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static f1 m441iteratorimpl(int[] iArr) {
        return new a(iArr);
    }

    /* JADX INFO: renamed from: set-VXSXFK8, reason: not valid java name */
    public static final void m442setVXSXFK8(int[] iArr, int i2, int i3) {
        iArr[i2] = i3;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m443toStringimpl(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ")";
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(v vVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: add-WZ4Q5Ns, reason: not valid java name */
    public boolean m444addWZ4Q5Ns(int i2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends v> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof v) {
            return m445containsWZ4Q5Ns(((v) obj).m429unboximpl());
        }
        return false;
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m445containsWZ4Q5Ns(int i2) {
        return m433containsWZ4Q5Ns(this.f12963a, i2);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        return m434containsAllimpl(this.f12963a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m435equalsimpl(this.f12963a, obj);
    }

    public int getSize() {
        return m438getSizeimpl(this.f12963a);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m439hashCodeimpl(this.f12963a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m440isEmptyimpl(this.f12963a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public f1 iterator() {
        return m441iteratorimpl(this.f12963a);
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
        return m443toStringimpl(this.f12963a);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m446unboximpl() {
        return this.f12963a;
    }

    /* JADX INFO: renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public static boolean m433containsWZ4Q5Ns(int[] iArr, int i2) {
        return d.g0.m.contains(iArr, i2);
    }
}
