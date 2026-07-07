package cn.admobiletop.adsuyi.a.l;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public class g extends cn.admobiletop.adsuyi.a.h.a.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f3381b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, Handler handler) {
        super(handler);
        this.f3381b = hVar;
    }

    @Override // cn.admobiletop.adsuyi.a.h.a.h
    public void e() {
    }

    @Override // cn.admobiletop.adsuyi.a.h.a.h
    public void f(int i2, String str) {
        if (i2 == -1003 && d.b().e() && d.b().d() > 0) {
            d.b().g();
            this.f3381b.t();
        }
    }
}
