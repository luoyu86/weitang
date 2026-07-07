package d.i0;

import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import d.i0.c;
import d.k0.c.p;
import d.k0.d.t;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements c, Serializable {
    public static final d INSTANCE = new d();
    private static final long serialVersionUID = 0;

    private final Object readResolve() {
        return INSTANCE;
    }

    @Override // d.i0.c
    public <R> R fold(R r, p<? super R, ? super c.a, ? extends R> pVar) {
        t.checkNotNullParameter(pVar, "operation");
        return r;
    }

    @Override // d.i0.c
    public <E extends c.a> E get(c.b<E> bVar) {
        t.checkNotNullParameter(bVar, "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // d.i0.c
    public c minusKey(c.b<?> bVar) {
        t.checkNotNullParameter(bVar, "key");
        return this;
    }

    @Override // d.i0.c
    public c plus(c cVar) {
        t.checkNotNullParameter(cVar, TTLiveConstants.CONTEXT_KEY);
        return cVar;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }
}
