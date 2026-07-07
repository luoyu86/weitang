package d.g0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a1 implements Iterator<Short>, d.k0.d.n0.a {
    public abstract short nextShort();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final Short next() {
        return Short.valueOf(nextShort());
    }
}
