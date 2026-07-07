package g.a.i.a;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;
import g.a.a.w;
import g.a.a.x1;

/* JADX INFO: loaded from: classes3.dex */
public class b extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g.a.i.d.a.c f14224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g.a.a.y3.a f14225d;

    public b(int i2, int i3, g.a.i.d.a.c cVar, g.a.a.y3.a aVar) {
        this.f14222a = i2;
        this.f14223b = i3;
        this.f14224c = new g.a.i.d.a.c(cVar.getEncoded());
        this.f14225d = aVar;
    }

    public b(d0 d0Var) {
        this.f14222a = ((q) d0Var.getObjectAt(0)).intValueExact();
        this.f14223b = ((q) d0Var.getObjectAt(1)).intValueExact();
        this.f14224c = new g.a.i.d.a.c(((w) d0Var.getObjectAt(2)).getOctets());
        this.f14225d = g.a.a.y3.a.getInstance(d0Var.getObjectAt(3));
    }

    public static b getInstance(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.y3.a getDigest() {
        return this.f14225d;
    }

    public g.a.i.d.a.c getG() {
        return this.f14224c;
    }

    public int getN() {
        return this.f14222a;
    }

    public int getT() {
        return this.f14223b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        hVar.add(new q(this.f14222a));
        hVar.add(new q(this.f14223b));
        hVar.add(new x1(this.f14224c.getEncoded()));
        hVar.add(this.f14225d);
        return new b2(hVar);
    }
}
