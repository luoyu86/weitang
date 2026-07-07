package d.o0;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<m<T>> f12722a;

    public a(m<? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "sequence");
        this.f12722a = new AtomicReference<>(mVar);
    }

    @Override // d.o0.m
    public Iterator<T> iterator() {
        m<T> andSet = this.f12722a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
