package g.a.i.a;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;
import g.a.a.w;
import g.a.a.x1;

/* JADX INFO: loaded from: classes3.dex */
public class c extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f14228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f14229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f14230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f14231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f14232g;

    public c(int i2, int i3, g.a.i.d.a.e eVar, g.a.i.d.a.m mVar, g.a.i.d.a.l lVar, g.a.i.d.a.l lVar2, g.a.i.d.a.c cVar) {
        this.f14226a = i2;
        this.f14227b = i3;
        this.f14228c = eVar.getEncoded();
        this.f14229d = mVar.getEncoded();
        this.f14230e = cVar.getEncoded();
        this.f14231f = lVar.getEncoded();
        this.f14232g = lVar2.getEncoded();
    }

    public c(d0 d0Var) {
        this.f14226a = ((q) d0Var.getObjectAt(0)).intValueExact();
        this.f14227b = ((q) d0Var.getObjectAt(1)).intValueExact();
        this.f14228c = ((w) d0Var.getObjectAt(2)).getOctets();
        this.f14229d = ((w) d0Var.getObjectAt(3)).getOctets();
        this.f14231f = ((w) d0Var.getObjectAt(4)).getOctets();
        this.f14232g = ((w) d0Var.getObjectAt(5)).getOctets();
        this.f14230e = ((w) d0Var.getObjectAt(6)).getOctets();
    }

    public static c getInstance(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.i.d.a.e getField() {
        return new g.a.i.d.a.e(this.f14228c);
    }

    public g.a.i.d.a.m getGoppaPoly() {
        return new g.a.i.d.a.m(getField(), this.f14229d);
    }

    public int getK() {
        return this.f14227b;
    }

    public int getN() {
        return this.f14226a;
    }

    public g.a.i.d.a.l getP1() {
        return new g.a.i.d.a.l(this.f14231f);
    }

    public g.a.i.d.a.l getP2() {
        return new g.a.i.d.a.l(this.f14232g);
    }

    public g.a.i.d.a.c getSInv() {
        return new g.a.i.d.a.c(this.f14230e);
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        hVar.add(new q(this.f14226a));
        hVar.add(new q(this.f14227b));
        hVar.add(new x1(this.f14228c));
        hVar.add(new x1(this.f14229d));
        hVar.add(new x1(this.f14231f));
        hVar.add(new x1(this.f14232g));
        hVar.add(new x1(this.f14230e));
        return new b2(hVar);
    }
}
