package d.i0.f.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j extends a {
    public j(d.i0.a<Object> aVar) {
        super(aVar);
        if (aVar != null) {
            if (!(aVar.getContext() == d.i0.d.INSTANCE)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // d.i0.f.a.a, d.i0.a
    public d.i0.c getContext() {
        return d.i0.d.INSTANCE;
    }
}
