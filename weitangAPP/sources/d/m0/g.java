package d.m0;

import d.k0.d.t;
import java.lang.Comparable;

/* JADX INFO: loaded from: classes2.dex */
public interface g<T extends Comparable<? super T>> {

    public static final class a {
        public static <T extends Comparable<? super T>> boolean contains(g<T> gVar, T t) {
            t.checkNotNullParameter(t, com.alipay.sdk.m.p0.b.f5579d);
            return t.compareTo(gVar.getStart()) >= 0 && t.compareTo(gVar.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean isEmpty(g<T> gVar) {
            return gVar.getStart().compareTo(gVar.getEndInclusive()) > 0;
        }
    }

    boolean contains(T t);

    T getEndInclusive();

    T getStart();

    boolean isEmpty();
}
