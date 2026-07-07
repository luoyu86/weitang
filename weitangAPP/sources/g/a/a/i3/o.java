package g.a.a.i3;

import g.a.a.a0;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class o extends g.a.a.t implements g.a.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.g f13157a;

    public o(a0 a0Var) {
        this.f13157a = a0Var;
    }

    public o(i iVar) {
        this.f13157a = iVar;
    }

    public o(q qVar) {
        this.f13157a = new e2(false, 1, (g.a.a.g) qVar);
    }

    public o(g.a.a.w wVar) {
        this(new g.a.a.y3.k(wVar.getOctets()));
    }

    public o(g.a.a.y3.k kVar) {
        this.f13157a = new e2(false, 0, (g.a.a.g) kVar);
    }

    public static o getInstance(l0 l0Var, boolean z) {
        if (z) {
            return getInstance(l0Var.getObject());
        }
        throw new IllegalArgumentException("Can't implicitly tag OriginatorIdentifierOrKey");
    }

    public static o getInstance(Object obj) {
        if (obj == null || (obj instanceof o)) {
            return (o) obj;
        }
        if ((obj instanceof i) || (obj instanceof d0)) {
            return new o(i.getInstance(obj));
        }
        if (obj instanceof l0) {
            l0 l0Var = (l0) obj;
            if (l0Var.getTagNo() == 0) {
                return new o(g.a.a.y3.k.getInstance(l0Var, false));
            }
            if (l0Var.getTagNo() == 1) {
                return new o(q.getInstance(l0Var, false));
            }
        }
        throw new IllegalArgumentException("Invalid OriginatorIdentifierOrKey: " + obj.getClass().getName());
    }

    public g.a.a.g getId() {
        return this.f13157a;
    }

    public i getIssuerAndSerialNumber() {
        g.a.a.g gVar = this.f13157a;
        if (gVar instanceof i) {
            return (i) gVar;
        }
        return null;
    }

    public q getOriginatorKey() {
        g.a.a.g gVar = this.f13157a;
        if ((gVar instanceof l0) && ((l0) gVar).getTagNo() == 1) {
            return q.getInstance((l0) this.f13157a, false);
        }
        return null;
    }

    public g.a.a.y3.k getSubjectKeyIdentifier() {
        g.a.a.g gVar = this.f13157a;
        if ((gVar instanceof l0) && ((l0) gVar).getTagNo() == 0) {
            return g.a.a.y3.k.getInstance((l0) this.f13157a, false);
        }
        return null;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13157a.toASN1Primitive();
    }
}
