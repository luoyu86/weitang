package d.g0;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<E> implements Collection<E>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: d.g0.a$a, reason: collision with other inner class name */
    public static final class C0231a extends d.k0.d.u implements d.k0.c.l<E, CharSequence> {
        public C0231a() {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.k0.c.l
        public final CharSequence invoke(E e2) {
            return e2 == a.this ? "(this Collection)" : String.valueOf(e2);
        }
    }

    @Override // java.util.Collection
    public boolean add(E e2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (d.k0.d.t.areEqual(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        d.k0.d.t.checkNotNullParameter(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public abstract int getSize();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public abstract Iterator<E> iterator();

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

    public String toString() {
        return a0.joinToString$default(this, ", ", "[", "]", 0, null, new C0231a(), 24, null);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        d.k0.d.t.checkNotNullParameter(tArr, "array");
        T[] tArr2 = (T[]) d.k0.d.o.toArray(this, tArr);
        Objects.requireNonNull(tArr2, "null cannot be cast to non-null type kotlin.Array<T>");
        return tArr2;
    }
}
