package d.g0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class j0<T> implements Iterable<i0<? extends T>>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.k0.c.a<Iterator<T>> f12497a;

    /* JADX WARN: Multi-variable type inference failed */
    public j0(d.k0.c.a<? extends Iterator<? extends T>> aVar) {
        d.k0.d.t.checkNotNullParameter(aVar, "iteratorFactory");
        this.f12497a = aVar;
    }

    @Override // java.lang.Iterable
    public Iterator<i0<T>> iterator() {
        return new k0(this.f12497a.invoke());
    }
}
