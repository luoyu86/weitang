package d.g0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class v extends u {
    public static final <T> void forEach(Iterator<? extends T> it, d.k0.c.l<? super T, d.d0> lVar) {
        d.k0.d.t.checkNotNullParameter(it, "$this$forEach");
        d.k0.d.t.checkNotNullParameter(lVar, "operation");
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
    }

    public static final <T> Iterator<i0<T>> withIndex(Iterator<? extends T> it) {
        d.k0.d.t.checkNotNullParameter(it, "$this$withIndex");
        return new k0(it);
    }
}
