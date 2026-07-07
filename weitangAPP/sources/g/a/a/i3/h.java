package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;

/* JADX INFO: loaded from: classes2.dex */
public class h extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.a.a.y3.a f13135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g.a.a.y3.a f13136b;

    public h(d0 d0Var) {
        if (d0Var.size() != 2) {
            throw new IllegalArgumentException("ASN.1 SEQUENCE should be of length 2");
        }
        this.f13135a = g.a.a.y3.a.getInstance(d0Var.getObjectAt(0));
        this.f13136b = g.a.a.y3.a.getInstance(d0Var.getObjectAt(1));
    }

    public h(g.a.a.y3.a aVar, g.a.a.y3.a aVar2) {
        this.f13135a = aVar;
        this.f13136b = aVar2;
    }

    public static h getInstance(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.y3.a getDem() {
        return this.f13136b;
    }

    public g.a.a.y3.a getKem() {
        return this.f13135a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        hVar.add(this.f13135a);
        hVar.add(this.f13136b);
        return new b2(hVar);
    }
}
