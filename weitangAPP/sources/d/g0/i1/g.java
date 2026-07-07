package d.g0.i1;

import d.k0.d.t;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class g<V> extends d.g0.e<V> implements Collection<V>, d.k0.d.n0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<?, V> f12495a;

    public g(d<?, V> dVar) {
        t.checkNotNullParameter(dVar, "backing");
        this.f12495a = dVar;
    }

    @Override // d.g0.e, java.util.AbstractCollection, java.util.Collection
    public boolean add(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends V> collection) {
        t.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f12495a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f12495a.containsValue(obj);
    }

    public final d<?, V> getBacking() {
        return this.f12495a;
    }

    @Override // d.g0.e
    public int getSize() {
        return this.f12495a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f12495a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<V> iterator() {
        return this.f12495a.valuesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f12495a.removeValue$kotlin_stdlib(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        t.checkNotNullParameter(collection, "elements");
        this.f12495a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        t.checkNotNullParameter(collection, "elements");
        this.f12495a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
