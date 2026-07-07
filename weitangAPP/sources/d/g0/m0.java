package d.g0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m0 implements Iterator<Long>, d.k0.d.n0.a {
    public abstract long nextLong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
