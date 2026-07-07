package g.a.i.a;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;

/* JADX INFO: loaded from: classes3.dex */
public class i extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f14262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g.a.a.y3.a f14264c;

    public i(int i2, g.a.a.y3.a aVar) {
        this.f14262a = new q(0L);
        this.f14263b = i2;
        this.f14264c = aVar;
    }

    public i(d0 d0Var) {
        this.f14262a = q.getInstance(d0Var.getObjectAt(0));
        this.f14263b = q.getInstance(d0Var.getObjectAt(1)).intValueExact();
        this.f14264c = g.a.a.y3.a.getInstance(d0Var.getObjectAt(2));
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

    public int getHeight() {
        return this.f14263b;
    }

    public g.a.a.y3.a getTreeDigest() {
        return this.f14264c;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        hVar.add(this.f14262a);
        hVar.add(new q(this.f14263b));
        hVar.add(this.f14264c);
        return new b2(hVar);
    }
}
