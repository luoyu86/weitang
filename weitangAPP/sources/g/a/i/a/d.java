package g.a.i.a;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;
import g.a.a.w;
import g.a.a.x1;

/* JADX INFO: loaded from: classes3.dex */
public class d extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g.a.i.d.a.c f14235c;

    public d(int i2, int i3, g.a.i.d.a.c cVar) {
        this.f14233a = i2;
        this.f14234b = i3;
        this.f14235c = new g.a.i.d.a.c(cVar);
    }

    public d(d0 d0Var) {
        this.f14233a = ((q) d0Var.getObjectAt(0)).intValueExact();
        this.f14234b = ((q) d0Var.getObjectAt(1)).intValueExact();
        this.f14235c = new g.a.i.d.a.c(((w) d0Var.getObjectAt(2)).getOctets());
    }

    public static d getInstance(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.i.d.a.c getG() {
        return new g.a.i.d.a.c(this.f14235c);
    }

    public int getN() {
        return this.f14233a;
    }

    public int getT() {
        return this.f14234b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        hVar.add(new q(this.f14233a));
        hVar.add(new q(this.f14234b));
        hVar.add(new x1(this.f14235c.getEncoded()));
        return new b2(hVar);
    }
}
