package d.k0.d;

import d.n0.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c0 extends d0 implements d.n0.n {
    public c0() {
    }

    @Override // d.k0.d.l
    public d.n0.a a() {
        return f0.property2(this);
    }

    @Override // d.n0.n
    public abstract /* synthetic */ V get(D d2, E e2);

    @Override // d.n0.n
    public Object getDelegate(Object obj, Object obj2) {
        return ((d.n0.n) b()).getDelegate(obj, obj2);
    }

    @Override // d.n0.n, d.k0.c.p
    public Object invoke(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    public c0(Class cls, String str, String str2, int i2) {
        super(l.NO_RECEIVER, cls, str, str2, i2);
    }

    @Override // d.k0.d.d0, d.n0.k, d.n0.l
    public n.a getGetter() {
        return ((d.n0.n) b()).getGetter();
    }
}
