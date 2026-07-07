package d.k0.d;

import d.n0.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 extends d0 implements d.n0.m {
    public b0() {
    }

    @Override // d.k0.d.l
    public d.n0.a a() {
        return f0.property1(this);
    }

    @Override // d.n0.m
    public abstract /* synthetic */ V get(T t);

    @Override // d.n0.m
    public Object getDelegate(Object obj) {
        return ((d.n0.m) b()).getDelegate(obj);
    }

    @Override // d.n0.m, d.k0.c.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public b0(Object obj) {
        super(obj);
    }

    @Override // d.k0.d.d0, d.n0.k, d.n0.l
    public m.a getGetter() {
        return ((d.n0.m) b()).getGetter();
    }

    public b0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
