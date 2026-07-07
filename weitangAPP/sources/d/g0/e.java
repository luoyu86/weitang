package d.g0;

import java.util.AbstractCollection;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e<E> extends AbstractCollection<E> implements Collection<E>, d.k0.d.n0.b {
    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean add(E e2);

    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }
}
