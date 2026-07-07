package d.i0.f.a;

import d.i0.c;
import d.k0.d.t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient d.i0.a<Object> f12597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d.i0.c f12598c;

    public d(d.i0.a<Object> aVar, d.i0.c cVar) {
        super(aVar);
        this.f12598c = cVar;
    }

    @Override // d.i0.f.a.a
    public void a() {
        d.i0.a<?> aVar = this.f12597b;
        if (aVar != null && aVar != this) {
            c.a aVar2 = getContext().get(d.i0.b.X);
            t.checkNotNull(aVar2);
            ((d.i0.b) aVar2).releaseInterceptedContinuation(aVar);
        }
        this.f12597b = c.f12596a;
    }

    @Override // d.i0.f.a.a, d.i0.a
    public d.i0.c getContext() {
        d.i0.c cVar = this.f12598c;
        t.checkNotNull(cVar);
        return cVar;
    }

    public final d.i0.a<Object> intercepted() {
        d.i0.a<Object> aVarInterceptContinuation = this.f12597b;
        if (aVarInterceptContinuation == null) {
            d.i0.b bVar = (d.i0.b) getContext().get(d.i0.b.X);
            if (bVar == null || (aVarInterceptContinuation = bVar.interceptContinuation(this)) == null) {
                aVarInterceptContinuation = this;
            }
            this.f12597b = aVarInterceptContinuation;
        }
        return aVarInterceptContinuation;
    }

    public d(d.i0.a<Object> aVar) {
        this(aVar, aVar != null ? aVar.getContext() : null);
    }
}
