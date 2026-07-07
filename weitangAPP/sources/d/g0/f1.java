package d.g0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f1 implements Iterator<d.v>, d.k0.d.n0.a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ d.v next() {
        return d.v.m423boximpl(m137nextpVg5ArA());
    }

    /* JADX INFO: renamed from: next-pVg5ArA, reason: not valid java name */
    public final int m137nextpVg5ArA() {
        return mo138nextUIntpVg5ArA();
    }

    /* JADX INFO: renamed from: nextUInt-pVg5ArA, reason: not valid java name */
    public abstract int mo138nextUIntpVg5ArA();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
