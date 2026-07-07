package d.i0.e;

import d.d0;
import d.i0.f.a.h;
import d.i0.f.a.j;
import d.k0.c.l;
import d.k0.c.p;
import d.k0.d.i0;
import d.k0.d.t;
import d.o;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    public static final class a extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12579b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d.i0.a f12580c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ l f12581d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d.i0.a aVar, d.i0.a aVar2, l lVar) {
            super(aVar2);
            this.f12580c = aVar;
            this.f12581d = lVar;
        }

        @Override // d.i0.f.a.a
        public Object invokeSuspend(Object obj) {
            int i2 = this.f12579b;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.f12579b = 2;
                o.throwOnFailure(obj);
                return obj;
            }
            this.f12579b = 1;
            o.throwOnFailure(obj);
            l lVar = this.f12581d;
            Objects.requireNonNull(lVar, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((l) i0.beforeCheckcastToFunctionOfArity(lVar, 1)).invoke(this);
        }
    }

    /* JADX INFO: renamed from: d.i0.e.b$b, reason: collision with other inner class name */
    public static final class C0238b extends d.i0.f.a.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12582d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ d.i0.a f12583e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ d.i0.c f12584f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ l f12585g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0238b(d.i0.a aVar, d.i0.c cVar, d.i0.a aVar2, d.i0.c cVar2, l lVar) {
            super(aVar2, cVar2);
            this.f12583e = aVar;
            this.f12584f = cVar;
            this.f12585g = lVar;
        }

        @Override // d.i0.f.a.a
        public Object invokeSuspend(Object obj) {
            int i2 = this.f12582d;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.f12582d = 2;
                o.throwOnFailure(obj);
                return obj;
            }
            this.f12582d = 1;
            o.throwOnFailure(obj);
            l lVar = this.f12585g;
            Objects.requireNonNull(lVar, "null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((l) i0.beforeCheckcastToFunctionOfArity(lVar, 1)).invoke(this);
        }
    }

    public static final class c extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12586b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d.i0.a f12587c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p f12588d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f12589e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d.i0.a aVar, d.i0.a aVar2, p pVar, Object obj) {
            super(aVar2);
            this.f12587c = aVar;
            this.f12588d = pVar;
            this.f12589e = obj;
        }

        @Override // d.i0.f.a.a
        public Object invokeSuspend(Object obj) {
            int i2 = this.f12586b;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.f12586b = 2;
                o.throwOnFailure(obj);
                return obj;
            }
            this.f12586b = 1;
            o.throwOnFailure(obj);
            p pVar = this.f12588d;
            Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((p) i0.beforeCheckcastToFunctionOfArity(pVar, 2)).invoke(this.f12589e, this);
        }
    }

    public static final class d extends d.i0.f.a.d {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12590d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ d.i0.a f12591e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ d.i0.c f12592f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ p f12593g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Object f12594h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(d.i0.a aVar, d.i0.c cVar, d.i0.a aVar2, d.i0.c cVar2, p pVar, Object obj) {
            super(aVar2, cVar2);
            this.f12591e = aVar;
            this.f12592f = cVar;
            this.f12593g = pVar;
            this.f12594h = obj;
        }

        @Override // d.i0.f.a.a
        public Object invokeSuspend(Object obj) {
            int i2 = this.f12590d;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("This coroutine had already completed".toString());
                }
                this.f12590d = 2;
                o.throwOnFailure(obj);
                return obj;
            }
            this.f12590d = 1;
            o.throwOnFailure(obj);
            p pVar = this.f12593g;
            Objects.requireNonNull(pVar, "null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            return ((p) i0.beforeCheckcastToFunctionOfArity(pVar, 2)).invoke(this.f12594h, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> d.i0.a<d0> createCoroutineUnintercepted(l<? super d.i0.a<? super T>, ? extends Object> lVar, d.i0.a<? super T> aVar) {
        t.checkNotNullParameter(lVar, "$this$createCoroutineUnintercepted");
        t.checkNotNullParameter(aVar, "completion");
        d.i0.a<?> aVarProbeCoroutineCreated = h.probeCoroutineCreated(aVar);
        if (lVar instanceof d.i0.f.a.a) {
            return ((d.i0.f.a.a) lVar).create(aVarProbeCoroutineCreated);
        }
        d.i0.c context = aVarProbeCoroutineCreated.getContext();
        return context == d.i0.d.INSTANCE ? new a(aVarProbeCoroutineCreated, aVarProbeCoroutineCreated, lVar) : new C0238b(aVarProbeCoroutineCreated, context, aVarProbeCoroutineCreated, context, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> d.i0.a<T> intercepted(d.i0.a<? super T> aVar) {
        d.i0.a<T> aVar2;
        t.checkNotNullParameter(aVar, "$this$intercepted");
        d.i0.f.a.d dVar = (d.i0.f.a.d) (!(aVar instanceof d.i0.f.a.d) ? null : aVar);
        return (dVar == null || (aVar2 = (d.i0.a<T>) dVar.intercepted()) == null) ? aVar : aVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <R, T> d.i0.a<d0> createCoroutineUnintercepted(p<? super R, ? super d.i0.a<? super T>, ? extends Object> pVar, R r, d.i0.a<? super T> aVar) {
        d.i0.a<d0> dVar;
        t.checkNotNullParameter(pVar, "$this$createCoroutineUnintercepted");
        t.checkNotNullParameter(aVar, "completion");
        d.i0.a<?> aVarProbeCoroutineCreated = h.probeCoroutineCreated(aVar);
        if (pVar instanceof d.i0.f.a.a) {
            return ((d.i0.f.a.a) pVar).create(r, aVarProbeCoroutineCreated);
        }
        d.i0.c context = aVarProbeCoroutineCreated.getContext();
        if (context == d.i0.d.INSTANCE) {
            dVar = new c(aVarProbeCoroutineCreated, aVarProbeCoroutineCreated, pVar, r);
        } else {
            dVar = new d(aVarProbeCoroutineCreated, context, aVarProbeCoroutineCreated, context, pVar, r);
        }
        return dVar;
    }
}
