package d.g0.i1;

import d.k0.d.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class h<E> extends d.g0.g<E> implements Set<E>, d.k0.d.n0.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<E, ?> f12496a;

    public h(d<E, ?> dVar) {
        t.checkNotNullParameter(dVar, "backing");
        this.f12496a = dVar;
    }

    @Override // d.g0.g, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e2) {
        return this.f12496a.addKey$kotlin_stdlib(e2) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        t.checkNotNullParameter(collection, "elements");
        this.f12496a.checkIsMutable$kotlin_stdlib();
        return super.addAll(collection);
    }

    public final Set<E> build() {
        this.f12496a.build();
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f12496a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f12496a.containsKey(obj);
    }

    @Override // d.g0.g
    public int getSize() {
        return this.f12496a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f12496a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return this.f12496a.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f12496a.removeKey$kotlin_stdlib(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        t.checkNotNullParameter(collection, "elements");
        this.f12496a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        t.checkNotNullParameter(collection, "elements");
        this.f12496a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }

    public h() {
        this(new d());
    }

    public h(int i2) {
        this(new d(i2));
    }
}
