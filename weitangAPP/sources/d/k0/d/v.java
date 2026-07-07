package d.k0.d;

import d.n0.g;
import d.n0.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v extends y implements d.n0.g {
    public v() {
    }

    @Override // d.k0.d.l
    public d.n0.a a() {
        return f0.mutableProperty0(this);
    }

    @Override // d.n0.g, d.n0.l
    public abstract /* synthetic */ V get();

    @Override // d.n0.g, d.n0.l
    public Object getDelegate() {
        return ((d.n0.g) b()).getDelegate();
    }

    @Override // d.n0.g, d.n0.l, d.k0.c.a
    public Object invoke() {
        return get();
    }

    @Override // d.n0.g
    public abstract /* synthetic */ void set(V v);

    public v(Object obj) {
        super(obj);
    }

    @Override // d.k0.d.y, d.k0.d.d0, d.n0.k, d.n0.l
    public l.a getGetter() {
        return ((d.n0.g) b()).getGetter();
    }

    @Override // d.k0.d.y, d.n0.g
    public g.a getSetter() {
        return ((d.n0.g) b()).m388getSetter();
    }

    public v(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
