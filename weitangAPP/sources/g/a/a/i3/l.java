package g.a.a.i3;

import g.a.a.a0;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class l extends g.a.a.t implements g.a.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f13146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x f13147b;

    public l(i iVar) {
        this.f13146a = iVar;
        this.f13147b = null;
    }

    public l(x xVar) {
        this.f13146a = null;
        this.f13147b = xVar;
    }

    public static l getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static l getInstance(Object obj) {
        if (obj == null || (obj instanceof l)) {
            return (l) obj;
        }
        if (obj instanceof d0) {
            return new l(i.getInstance(obj));
        }
        if (obj instanceof l0) {
            l0 l0Var = (l0) obj;
            if (l0Var.getTagNo() == 0) {
                return new l(x.getInstance(l0Var, false));
            }
        }
        throw new IllegalArgumentException("Invalid KeyAgreeRecipientIdentifier: " + obj.getClass().getName());
    }

    public i getIssuerAndSerialNumber() {
        return this.f13146a;
    }

    public x getRKeyID() {
        return this.f13147b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        i iVar = this.f13146a;
        return iVar != null ? iVar.toASN1Primitive() : new e2(false, 0, (g.a.a.g) this.f13147b);
    }
}
