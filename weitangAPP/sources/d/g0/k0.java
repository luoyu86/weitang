package d.g0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class k0<T> implements Iterator<i0<? extends T>>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterator<T> f12507b;

    /* JADX WARN: Multi-variable type inference failed */
    public k0(Iterator<? extends T> it) {
        d.k0.d.t.checkNotNullParameter(it, "iterator");
        this.f12507b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f12507b.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    public final i0<T> next() {
        int i2 = this.f12506a;
        this.f12506a = i2 + 1;
        if (i2 < 0) {
            s.throwIndexOverflow();
        }
        return new i0<>(i2, this.f12507b.next());
    }
}
