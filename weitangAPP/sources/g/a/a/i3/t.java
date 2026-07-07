package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class t extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.q f13166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.y3.a f13167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.a.y3.a f13168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g.a.a.w f13169d;

    public t(d0 d0Var) {
        g.a.a.g objectAt;
        this.f13166a = (g.a.a.q) d0Var.getObjectAt(0);
        if (d0Var.getObjectAt(1) instanceof l0) {
            this.f13167b = g.a.a.y3.a.getInstance((l0) d0Var.getObjectAt(1), false);
            this.f13168c = g.a.a.y3.a.getInstance(d0Var.getObjectAt(2));
            objectAt = d0Var.getObjectAt(3);
        } else {
            this.f13168c = g.a.a.y3.a.getInstance(d0Var.getObjectAt(1));
            objectAt = d0Var.getObjectAt(2);
        }
        this.f13169d = (g.a.a.w) objectAt;
    }

    public t(g.a.a.y3.a aVar, g.a.a.w wVar) {
        this.f13166a = new g.a.a.q(0L);
        this.f13168c = aVar;
        this.f13169d = wVar;
    }

    public t(g.a.a.y3.a aVar, g.a.a.y3.a aVar2, g.a.a.w wVar) {
        this.f13166a = new g.a.a.q(0L);
        this.f13167b = aVar;
        this.f13168c = aVar2;
        this.f13169d = wVar;
    }

    public static t getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static t getInstance(Object obj) {
        if (obj instanceof t) {
            return (t) obj;
        }
        if (obj != null) {
            return new t(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.w getEncryptedKey() {
        return this.f13169d;
    }

    public g.a.a.y3.a getKeyDerivationAlgorithm() {
        return this.f13167b;
    }

    public g.a.a.y3.a getKeyEncryptionAlgorithm() {
        return this.f13168c;
    }

    public g.a.a.q getVersion() {
        return this.f13166a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(4);
        hVar.add(this.f13166a);
        g.a.a.y3.a aVar = this.f13167b;
        if (aVar != null) {
            hVar.add(new e2(false, 0, (g.a.a.g) aVar));
        }
        hVar.add(this.f13168c);
        hVar.add(this.f13169d);
        return new b2(hVar);
    }
}
