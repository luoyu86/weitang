package d.k0.d;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final <T> Iterator<T> iterator(T[] tArr) {
        t.checkNotNullParameter(tArr, "array");
        return new g(tArr);
    }
}
