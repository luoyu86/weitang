package d;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public static final <A, B> m<A, B> to(A a2, B b2) {
        return new m<>(a2, b2);
    }

    public static final <T> List<T> toList(m<? extends T, ? extends T> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$toList");
        return d.g0.s.listOf(mVar.getFirst(), mVar.getSecond());
    }

    public static final <T> List<T> toList(r<? extends T, ? extends T, ? extends T> rVar) {
        d.k0.d.t.checkNotNullParameter(rVar, "$this$toList");
        return d.g0.s.listOf(rVar.getFirst(), rVar.getSecond(), rVar.getThird());
    }
}
