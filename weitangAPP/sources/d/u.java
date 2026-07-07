package d;

import d.g0.e1;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements Collection<t>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f12958a;

    public static final class a extends e1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f12960b;

        public a(byte[] bArr) {
            d.k0.d.t.checkNotNullParameter(bArr, "array");
            this.f12960b = bArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12959a < this.f12960b.length;
        }

        @Override // d.g0.e1
        /* JADX INFO: renamed from: nextUByte-w2LRezQ */
        public byte mo136nextUBytew2LRezQ() {
            int i2 = this.f12959a;
            byte[] bArr = this.f12960b;
            if (i2 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f12959a));
            }
            this.f12959a = i2 + 1;
            return t.m400constructorimpl(bArr[i2]);
        }
    }

    public /* synthetic */ u(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "storage");
        this.f12958a = bArr;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ u m406boximpl(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "v");
        return new u(bArr);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m407constructorimpl(int i2) {
        return m408constructorimpl(new byte[i2]);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m408constructorimpl(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "storage");
        return bArr;
    }

    /* JADX INFO: renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m410containsAllimpl(byte[] bArr, Collection<t> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        if (!collection.isEmpty()) {
            for (Object obj : collection) {
                if (!((obj instanceof t) && d.g0.m.contains(bArr, ((t) obj).m405unboximpl()))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m411equalsimpl(byte[] bArr, Object obj) {
        return (obj instanceof u) && d.k0.d.t.areEqual(bArr, ((u) obj).m422unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m412equalsimpl0(byte[] bArr, byte[] bArr2) {
        return d.k0.d.t.areEqual(bArr, bArr2);
    }

    /* JADX INFO: renamed from: get-w2LRezQ, reason: not valid java name */
    public static final byte m413getw2LRezQ(byte[] bArr, int i2) {
        return t.m400constructorimpl(bArr[i2]);
    }

    /* JADX INFO: renamed from: getSize-impl, reason: not valid java name */
    public static int m414getSizeimpl(byte[] bArr) {
        return bArr.length;
    }

    public static /* synthetic */ void getStorage$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m415hashCodeimpl(byte[] bArr) {
        if (bArr != null) {
            return Arrays.hashCode(bArr);
        }
        return 0;
    }

    /* JADX INFO: renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m416isEmptyimpl(byte[] bArr) {
        return bArr.length == 0;
    }

    /* JADX INFO: renamed from: iterator-impl, reason: not valid java name */
    public static e1 m417iteratorimpl(byte[] bArr) {
        return new a(bArr);
    }

    /* JADX INFO: renamed from: set-VurrAj0, reason: not valid java name */
    public static final void m418setVurrAj0(byte[] bArr, int i2, byte b2) {
        bArr[i2] = b2;
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m419toStringimpl(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ")";
    }

    @Override // java.util.Collection
    public /* synthetic */ boolean add(t tVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: add-7apg3OU, reason: not valid java name */
    public boolean m420add7apg3OU(byte b2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends t> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof t) {
            return m421contains7apg3OU(((t) obj).m405unboximpl());
        }
        return false;
    }

    /* JADX INFO: renamed from: contains-7apg3OU, reason: not valid java name */
    public boolean m421contains7apg3OU(byte b2) {
        return m409contains7apg3OU(this.f12958a, b2);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        return m410containsAllimpl(this.f12958a, collection);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m411equalsimpl(this.f12958a, obj);
    }

    public int getSize() {
        return m414getSizeimpl(this.f12958a);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m415hashCodeimpl(this.f12958a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m416isEmptyimpl(this.f12958a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public e1 iterator() {
        return m417iteratorimpl(this.f12958a);
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
        return m419toStringimpl(this.f12958a);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ byte[] m422unboximpl() {
        return this.f12958a;
    }

    /* JADX INFO: renamed from: contains-7apg3OU, reason: not valid java name */
    public static boolean m409contains7apg3OU(byte[] bArr, byte b2) {
        return d.g0.m.contains(bArr, b2);
    }
}
