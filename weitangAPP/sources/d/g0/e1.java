package d.g0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e1 implements Iterator<d.t>, d.k0.d.n0.a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ d.t next() {
        return d.t.m399boximpl(m135nextw2LRezQ());
    }

    /* JADX INFO: renamed from: next-w2LRezQ, reason: not valid java name */
    public final byte m135nextw2LRezQ() {
        return mo136nextUBytew2LRezQ();
    }

    /* JADX INFO: renamed from: nextUByte-w2LRezQ, reason: not valid java name */
    public abstract byte mo136nextUBytew2LRezQ();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
