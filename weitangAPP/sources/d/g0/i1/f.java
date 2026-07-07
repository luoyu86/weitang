package d.g0.i1;

import d.k0.d.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class f<E> extends d.g0.g<E> implements Set<E>, d.k0.d.n0.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<E, ?> f12494a;

    public f(d<E, ?> dVar) {
        t.checkNotNullParameter(dVar, "backing");
        this.f12494a = dVar;
    }

    @Override // d.g0.g, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        t.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f12494a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f12494a.containsKey(obj);
    }

    @Override // d.g0.g
    public int getSize() {
        return this.f12494a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f12494a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.f12494a.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f12494a.removeKey$kotlin_stdlib(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        t.checkNotNullParameter(collection, "elements");
        this.f12494a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        t.checkNotNullParameter(collection, "elements");
        this.f12494a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
