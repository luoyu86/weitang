package d.g0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g1 implements Iterator<d.x>, d.k0.d.n0.a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ d.x next() {
        return d.x.m447boximpl(m139nextsVKNKU());
    }

    /* JADX INFO: renamed from: next-s-VKNKU, reason: not valid java name */
    public final long m139nextsVKNKU() {
        return mo140nextULongsVKNKU();
    }

    /* JADX INFO: renamed from: nextULong-s-VKNKU, reason: not valid java name */
    public abstract long mo140nextULongsVKNKU();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
