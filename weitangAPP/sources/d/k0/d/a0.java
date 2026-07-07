package d.k0.d;

import d.n0.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a0 extends d0 implements d.n0.l {
    public a0() {
    }

    @Override // d.k0.d.l
    public d.n0.a a() {
        return f0.property0(this);
    }

    @Override // d.n0.l
    public abstract /* synthetic */ V get();

    @Override // d.n0.l
    public Object getDelegate() {
        return ((d.n0.l) b()).getDelegate();
    }

    @Override // d.n0.l, d.k0.c.a
    public Object invoke() {
        return get();
    }

    public a0(Object obj) {
        super(obj);
    }

    @Override // d.k0.d.d0, d.n0.k, d.n0.l
    public l.a getGetter() {
        return ((d.n0.l) b()).getGetter();
    }

    public a0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
