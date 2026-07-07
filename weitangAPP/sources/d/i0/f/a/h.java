package d.i0.f.a;

import d.k0.d.t;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> d.i0.a<T> probeCoroutineCreated(d.i0.a<? super T> aVar) {
        t.checkNotNullParameter(aVar, "completion");
        return aVar;
    }

    public static final void probeCoroutineResumed(d.i0.a<?> aVar) {
        t.checkNotNullParameter(aVar, "frame");
    }

    public static final void probeCoroutineSuspended(d.i0.a<?> aVar) {
        t.checkNotNullParameter(aVar, "frame");
    }
}
