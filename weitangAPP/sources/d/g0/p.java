package d.g0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p implements Iterator<Byte>, d.k0.d.n0.a {
    public abstract byte nextByte();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public final Byte next() {
        return Byte.valueOf(nextByte());
    }
}
