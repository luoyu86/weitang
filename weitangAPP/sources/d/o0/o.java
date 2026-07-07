package d.o0;

import d.d0;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o<T> {
    public abstract Object yield(T t, d.i0.a<? super d0> aVar);

    public final Object yieldAll(Iterable<? extends T> iterable, d.i0.a<? super d0> aVar) {
        Object objYieldAll;
        return (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) && (objYieldAll = yieldAll(iterable.iterator(), aVar)) == d.i0.e.c.getCOROUTINE_SUSPENDED()) ? objYieldAll : d0.f12421a;
    }

    public abstract Object yieldAll(Iterator<? extends T> it, d.i0.a<? super d0> aVar);

    public final Object yieldAll(m<? extends T> mVar, d.i0.a<? super d0> aVar) {
        Object objYieldAll = yieldAll(mVar.iterator(), aVar);
        return objYieldAll == d.i0.e.c.getCOROUTINE_SUSPENDED() ? objYieldAll : d0.f12421a;
    }
}
