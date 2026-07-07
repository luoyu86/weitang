package d.g0.i1;

import d.k0.d.t;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e<K, V> extends a<Map.Entry<K, V>, K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<K, V> f12493a;

    public e(d<K, V> dVar) {
        t.checkNotNullParameter(dVar, "backing");
        this.f12493a = dVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
        t.checkNotNullParameter(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f12493a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<? extends Object> collection) {
        t.checkNotNullParameter(collection, "elements");
        return this.f12493a.containsAllEntries$kotlin_stdlib(collection);
    }

    @Override // d.g0.i1.a
    public boolean containsEntry(Map.Entry<? extends K, ? extends V> entry) {
        t.checkNotNullParameter(entry, "element");
        return this.f12493a.containsEntry$kotlin_stdlib(entry);
    }

    public final d<K, V> getBacking() {
        return this.f12493a;
    }

    @Override // d.g0.g
    public int getSize() {
        return this.f12493a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f12493a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f12493a.entriesIterator$kotlin_stdlib();
    }

    @Override // d.g0.i1.a
    public boolean remove(Map.Entry entry) {
        t.checkNotNullParameter(entry, "element");
        return this.f12493a.removeEntry$kotlin_stdlib(entry);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection<? extends Object> collection) {
        t.checkNotNullParameter(collection, "elements");
        this.f12493a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<? extends Object> collection) {
        t.checkNotNullParameter(collection, "elements");
        this.f12493a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }

    @Override // d.g0.g, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Map.Entry<K, V> entry) {
        t.checkNotNullParameter(entry, "element");
        throw new UnsupportedOperationException();
    }
}
