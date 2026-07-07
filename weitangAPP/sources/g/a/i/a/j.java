package g.a.i.a;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;

/* JADX INFO: loaded from: classes3.dex */
public class j extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f14265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g.a.a.y3.a f14268d;

    public j(int i2, int i3, g.a.a.y3.a aVar) {
        this.f14265a = new q(0L);
        this.f14266b = i2;
        this.f14267c = i3;
        this.f14268d = aVar;
    }

    public j(d0 d0Var) {
        this.f14265a = q.getInstance(d0Var.getObjectAt(0));
        this.f14266b = q.getInstance(d0Var.getObjectAt(1)).intValueExact();
        this.f14267c = q.getInstance(d0Var.getObjectAt(2)).intValueExact();
        this.f14268d = g.a.a.y3.a.getInstance(d0Var.getObjectAt(3));
    }

    public static j getInstance(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(d0.getInstance(obj));
        }
        return null;
    }

    public int getHeight() {
        return this.f14266b;
    }

    public int getLayers() {
        return this.f14267c;
    }

    public g.a.a.y3.a getTreeDigest() {
        return this.f14268d;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        hVar.add(this.f14265a);
        hVar.add(new q(this.f14266b));
        hVar.add(new q(this.f14267c));
        hVar.add(this.f14268d);
        return new b2(hVar);
    }
}
