package g.a.i.a;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;

/* JADX INFO: loaded from: classes3.dex */
public class h extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f14260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g.a.a.y3.a f14261b;

    public h(d0 d0Var) {
        this.f14260a = q.getInstance(d0Var.getObjectAt(0));
        this.f14261b = g.a.a.y3.a.getInstance(d0Var.getObjectAt(1));
    }

    public h(g.a.a.y3.a aVar) {
        this.f14260a = new q(0L);
        this.f14261b = aVar;
    }

    public static final h getInstance(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.y3.a getTreeDigest() {
        return this.f14261b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        hVar.add(this.f14260a);
        hVar.add(this.f14261b);
        return new b2(hVar);
    }
}
