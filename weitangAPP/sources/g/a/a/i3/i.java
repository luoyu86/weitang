package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class i extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.x3.c f13137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.q f13138b;

    public i(d0 d0Var) {
        this.f13137a = g.a.a.x3.c.getInstance(d0Var.getObjectAt(0));
        this.f13138b = (g.a.a.q) d0Var.getObjectAt(1);
    }

    public i(g.a.a.x3.c cVar, BigInteger bigInteger) {
        this.f13137a = cVar;
        this.f13138b = new g.a.a.q(bigInteger);
    }

    public i(g.a.a.y3.b bVar) {
        this.f13137a = bVar.getIssuer();
        this.f13138b = bVar.getSerialNumber();
    }

    public i(g.a.a.y3.q qVar) {
        this.f13137a = qVar.getIssuer();
        this.f13138b = qVar.getSerialNumber();
    }

    public i(g.a.a.y3.u uVar, g.a.a.q qVar) {
        this.f13137a = g.a.a.x3.c.getInstance(uVar);
        this.f13138b = qVar;
    }

    public i(g.a.a.y3.u uVar, BigInteger bigInteger) {
        this.f13137a = g.a.a.x3.c.getInstance(uVar);
        this.f13138b = new g.a.a.q(bigInteger);
    }

    public static i getInstance(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.x3.c getName() {
        return this.f13137a;
    }

    public g.a.a.q getSerialNumber() {
        return this.f13138b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        hVar.add(this.f13137a);
        hVar.add(this.f13138b);
        return new b2(hVar);
    }
}
