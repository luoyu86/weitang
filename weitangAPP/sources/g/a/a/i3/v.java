package g.a.a.i3;

import g.a.a.a0;
import g.a.a.e2;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class v extends g.a.a.t implements g.a.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.g f13172a;

    public v(a0 a0Var) {
        this.f13172a = a0Var;
    }

    public v(i iVar) {
        this.f13172a = iVar;
    }

    public v(g.a.a.w wVar) {
        this.f13172a = new e2(false, 0, (g.a.a.g) wVar);
    }

    public static v getInstance(Object obj) {
        if (obj == null || (obj instanceof v)) {
            return (v) obj;
        }
        if (obj instanceof i) {
            return new v((i) obj);
        }
        if (obj instanceof g.a.a.w) {
            return new v((g.a.a.w) obj);
        }
        if (obj instanceof a0) {
            return new v((a0) obj);
        }
        throw new IllegalArgumentException("Illegal object in RecipientIdentifier: " + obj.getClass().getName());
    }

    public g.a.a.g getId() {
        g.a.a.g gVar = this.f13172a;
        return gVar instanceof l0 ? g.a.a.w.getInstance((l0) gVar, false) : i.getInstance(gVar);
    }

    public boolean isTagged() {
        return this.f13172a instanceof l0;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13172a.toASN1Primitive();
    }
}
