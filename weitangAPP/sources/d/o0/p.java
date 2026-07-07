package d.o0;

import d.d0;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d.k0.c.p f12772a;

        public a(d.k0.c.p pVar) {
            this.f12772a = pVar;
        }

        @Override // d.o0.m
        public Iterator<T> iterator() {
            return p.iterator(this.f12772a);
        }
    }

    public static /* synthetic */ void SequenceBuilder$annotations() {
    }

    public static final <T> Iterator<T> iterator(d.k0.c.p<? super o<? super T>, ? super d.i0.a<? super d0>, ? extends Object> pVar) {
        d.k0.d.t.checkNotNullParameter(pVar, "block");
        n nVar = new n();
        nVar.setNextStep(d.i0.e.b.createCoroutineUnintercepted(pVar, nVar, nVar));
        return nVar;
    }

    public static final <T> m<T> sequence(d.k0.c.p<? super o<? super T>, ? super d.i0.a<? super d0>, ? extends Object> pVar) {
        d.k0.d.t.checkNotNullParameter(pVar, "block");
        return new a(pVar);
    }
}
