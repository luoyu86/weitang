package d.g0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l0 implements Iterator<Integer>, d.k0.d.n0.a {
    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
