package d.g0;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class h<T> implements Collection<T>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T[] f12461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f12462b;

    public h(T[] tArr, boolean z) {
        d.k0.d.t.checkNotNullParameter(tArr, "values");
        this.f12461a = tArr;
        this.f12462b = z;
    }

    @Override // java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return m.contains(this.f12461a, obj);
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

    public int getSize() {
        return this.f12461a.length;
    }

    public final T[] getValues() {
        return this.f12461a;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f12461a.length == 0;
    }

    public final boolean isVarargs() {
        return this.f12462b;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return d.k0.d.h.iterator(this.f12461a);
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
    public final Object[] toArray() {
        return r.copyToArrayOfAny(this.f12461a, this.f12462b);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) d.k0.d.o.toArray(this, tArr);
    }
}
