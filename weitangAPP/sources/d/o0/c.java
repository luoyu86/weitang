package d.o0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class c<T, K> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m<T> f12726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.k0.c.l<T, K> f12727b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(m<? extends T> mVar, d.k0.c.l<? super T, ? extends K> lVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "source");
        d.k0.d.t.checkNotNullParameter(lVar, "keySelector");
        this.f12726a = mVar;
        this.f12727b = lVar;
    }

    @Override // d.o0.m
    public Iterator<T> iterator() {
        return new b(this.f12726a.iterator(), this.f12727b);
    }
}
