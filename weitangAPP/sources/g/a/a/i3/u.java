package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class u extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f13170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.w f13171b;

    public u(d0 d0Var) {
        this.f13170a = l.getInstance(d0Var.getObjectAt(0));
        this.f13171b = (g.a.a.w) d0Var.getObjectAt(1);
    }

    public u(l lVar, g.a.a.w wVar) {
        this.f13170a = lVar;
        this.f13171b = wVar;
    }

    public static u getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static u getInstance(Object obj) {
        if (obj instanceof u) {
            return (u) obj;
        }
        if (obj != null) {
            return new u(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.w getEncryptedKey() {
        return this.f13171b;
    }

    public l getIdentifier() {
        return this.f13170a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        hVar.add(this.f13170a);
        hVar.add(this.f13171b);
        return new b2(hVar);
    }
}
