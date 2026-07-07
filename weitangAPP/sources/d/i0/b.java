package d.i0;

import d.i0.c;
import d.k0.c.p;

/* JADX INFO: loaded from: classes2.dex */
public interface b extends c.a {
    public static final a X = a.f12577a;

    public static final class a implements c.b<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f12577a = new a();
    }

    @Override // d.i0.c.a, d.i0.c
    /* synthetic */ <R> R fold(R r, p<? super R, ? super c.a, ? extends R> pVar);

    @Override // d.i0.c.a, d.i0.c
    <E extends c.a> E get(c.b<E> bVar);

    @Override // d.i0.c.a
    /* synthetic */ c.b<?> getKey();

    <T> d.i0.a<T> interceptContinuation(d.i0.a<? super T> aVar);

    @Override // d.i0.c.a, d.i0.c
    c minusKey(c.b<?> bVar);

    @Override // d.i0.c.a, d.i0.c
    /* synthetic */ c plus(c cVar);

    void releaseInterceptedContinuation(d.i0.a<?> aVar);
}
