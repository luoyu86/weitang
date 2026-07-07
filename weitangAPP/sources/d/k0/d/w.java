package d.k0.d;

import d.n0.h;
import d.n0.m;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w extends y implements d.n0.h {
    public w() {
    }

    @Override // d.k0.d.l
    public d.n0.a a() {
        return f0.mutableProperty1(this);
    }

    @Override // d.n0.h, d.n0.m
    public abstract /* synthetic */ V get(T t);

    @Override // d.n0.h, d.n0.m
    public Object getDelegate(Object obj) {
        return ((d.n0.h) b()).getDelegate(obj);
    }

    @Override // d.n0.h, d.n0.m, d.k0.c.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    @Override // d.n0.h
    public abstract /* synthetic */ void set(T t, V v);

    public w(Object obj) {
        super(obj);
    }

    @Override // d.k0.d.y, d.k0.d.d0, d.n0.k, d.n0.l
    public m.a getGetter() {
        return ((d.n0.h) b()).getGetter();
    }

    @Override // d.k0.d.y, d.n0.g
    public h.a getSetter() {
        return ((d.n0.h) b()).m389getSetter();
    }

    public w(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, i2);
    }
}
