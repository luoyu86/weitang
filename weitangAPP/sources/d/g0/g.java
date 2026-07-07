package d.g0;

import java.util.AbstractSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g<E> extends AbstractSet<E> implements Set<E>, d.k0.d.n0.h {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean add(E e2);

    public abstract int getSize();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }
}
