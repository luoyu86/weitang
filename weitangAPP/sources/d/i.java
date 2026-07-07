package d;

import com.taobao.accs.common.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static final <T> g<T> lazy(d.k0.c.a<? extends T> aVar) {
        d.k0.d.t.checkNotNullParameter(aVar, "initializer");
        return new q(aVar, null, 2, null);
    }

    public static final <T> g<T> lazy(j jVar, d.k0.c.a<? extends T> aVar) {
        d.k0.d.t.checkNotNullParameter(jVar, Constants.KEY_MODE);
        d.k0.d.t.checkNotNullParameter(aVar, "initializer");
        int i2 = h.f12564a[jVar.ordinal()];
        if (i2 == 1) {
            return new q(aVar, null, 2, null);
        }
        if (i2 == 2) {
            return new p(aVar);
        }
        if (i2 == 3) {
            return new e0(aVar);
        }
        throw new l();
    }

    public static final <T> g<T> lazy(Object obj, d.k0.c.a<? extends T> aVar) {
        d.k0.d.t.checkNotNullParameter(aVar, "initializer");
        return new q(aVar, obj);
    }
}
