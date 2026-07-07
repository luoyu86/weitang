package d.g0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h1 implements Iterator<d.a0>, d.k0.d.n0.a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ d.a0 next() {
        return d.a0.m94boximpl(m141nextMh2AYeg());
    }

    /* JADX INFO: renamed from: next-Mh2AYeg, reason: not valid java name */
    public final short m141nextMh2AYeg() {
        return mo118nextUShortMh2AYeg();
    }

    /* JADX INFO: renamed from: nextUShort-Mh2AYeg */
    public abstract short mo118nextUShortMh2AYeg();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
