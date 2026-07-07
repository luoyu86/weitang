package d.i0;

import d.k0.c.p;

/* JADX INFO: loaded from: classes2.dex */
public interface c {

    public interface a extends c {
        @Override // d.i0.c
        <R> R fold(R r, p<? super R, ? super a, ? extends R> pVar);

        @Override // d.i0.c
        <E extends a> E get(b<E> bVar);

        b<?> getKey();

        @Override // d.i0.c
        c minusKey(b<?> bVar);

        @Override // d.i0.c
        /* synthetic */ c plus(c cVar);
    }

    public interface b<E extends a> {
    }

    <R> R fold(R r, p<? super R, ? super a, ? extends R> pVar);

    <E extends a> E get(b<E> bVar);

    c minusKey(b<?> bVar);

    c plus(c cVar);
}
