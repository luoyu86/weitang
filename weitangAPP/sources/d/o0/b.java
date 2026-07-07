package d.o0;

import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T, K> extends d.g0.c<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<K> f12723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Iterator<T> f12724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d.k0.c.l<T, K> f12725e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(Iterator<? extends T> it, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(it, "source");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        this.f12724d = it;
        this.f12725e = lVar;
        this.f12723c = new HashSet<>();
    }

    @Override // d.g0.c
    public void a() {
        while (this.f12724d.hasNext()) {
            T next = this.f12724d.next();
            if (this.f12723c.add(this.f12725e.invoke(next))) {
                c(next);
                return;
            }
        }
        b();
    }
}
