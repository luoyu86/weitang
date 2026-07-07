package d.i0.f.a;

import d.d0;
import d.k0.d.t;
import d.n;
import d.o;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements d.i0.a<Object>, e, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.i0.a<Object> f12595a;

    public a(d.i0.a<Object> aVar) {
        this.f12595a = aVar;
    }

    public void a() {
    }

    public d.i0.a<d0> create(d.i0.a<?> aVar) {
        t.checkNotNullParameter(aVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // d.i0.f.a.e
    public e getCallerFrame() {
        d.i0.a<Object> aVar = this.f12595a;
        if (!(aVar instanceof e)) {
            aVar = null;
        }
        return (e) aVar;
    }

    public final d.i0.a<Object> getCompletion() {
        return this.f12595a;
    }

    @Override // d.i0.a
    public abstract /* synthetic */ d.i0.c getContext();

    @Override // d.i0.f.a.e
    public StackTraceElement getStackTraceElement() {
        return g.getStackTraceElement(this);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // d.i0.a
    public final void resumeWith(Object obj) {
        Object objInvokeSuspend;
        a aVar = this;
        while (true) {
            h.probeCoroutineResumed(aVar);
            d.i0.a<Object> aVar2 = aVar.f12595a;
            t.checkNotNull(aVar2);
            try {
                objInvokeSuspend = aVar.invokeSuspend(obj);
            } catch (Throwable th) {
                n.a aVar3 = n.Companion;
                obj = n.m379constructorimpl(o.createFailure(th));
            }
            if (objInvokeSuspend == d.i0.e.c.getCOROUTINE_SUSPENDED()) {
                return;
            }
            n.a aVar4 = n.Companion;
            obj = n.m379constructorimpl(objInvokeSuspend);
            aVar.a();
            if (!(aVar2 instanceof a)) {
                aVar2.resumeWith(obj);
                return;
            }
            aVar = (a) aVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public d.i0.a<d0> create(Object obj, d.i0.a<?> aVar) {
        t.checkNotNullParameter(aVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
