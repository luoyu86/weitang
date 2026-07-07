package g.a.a.i3;

import g.a.a.a0;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class w extends g.a.a.t implements g.a.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.g f13173a;

    public w(a0 a0Var) {
        this.f13173a = a0Var;
    }

    public w(k kVar) {
        this.f13173a = new e2(false, 2, (g.a.a.g) kVar);
    }

    public w(m mVar) {
        this.f13173a = new e2(false, 1, (g.a.a.g) mVar);
    }

    public w(n nVar) {
        this.f13173a = nVar;
    }

    public w(s sVar) {
        this.f13173a = new e2(false, 4, (g.a.a.g) sVar);
    }

    public w(t tVar) {
        this.f13173a = new e2(false, 3, (g.a.a.g) tVar);
    }

    public static w getInstance(Object obj) {
        if (obj == null || (obj instanceof w)) {
            return (w) obj;
        }
        if (obj instanceof d0) {
            return new w((d0) obj);
        }
        if (obj instanceof l0) {
            return new w((l0) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public final k a(l0 l0Var) {
        return k.getInstance(l0Var, l0Var.isExplicit());
    }

    public g.a.a.g getInfo() {
        g.a.a.g gVar = this.f13173a;
        if (!(gVar instanceof l0)) {
            return n.getInstance(gVar);
        }
        l0 l0Var = (l0) gVar;
        int tagNo = l0Var.getTagNo();
        if (tagNo == 1) {
            return m.getInstance(l0Var, false);
        }
        if (tagNo == 2) {
            return a(l0Var);
        }
        if (tagNo == 3) {
            return t.getInstance(l0Var, false);
        }
        if (tagNo == 4) {
            return s.getInstance(l0Var, false);
        }
        throw new IllegalStateException("unknown tag");
    }

    public g.a.a.q getVersion() {
        g.a.a.g gVar = this.f13173a;
        if (!(gVar instanceof l0)) {
            return n.getInstance(gVar).getVersion();
        }
        l0 l0Var = (l0) gVar;
        int tagNo = l0Var.getTagNo();
        if (tagNo == 1) {
            return m.getInstance(l0Var, false).getVersion();
        }
        if (tagNo == 2) {
            return a(l0Var).getVersion();
        }
        if (tagNo == 3) {
            return t.getInstance(l0Var, false).getVersion();
        }
        if (tagNo == 4) {
            return new g.a.a.q(0L);
        }
        throw new IllegalStateException("unknown tag");
    }

    public boolean isTagged() {
        return this.f13173a instanceof l0;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13173a.toASN1Primitive();
    }
}
