package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;
import g.a.a.n1;

/* JADX INFO: loaded from: classes2.dex */
public class q extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.y3.a f13160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n1 f13161b;

    public q(d0 d0Var) {
        this.f13160a = g.a.a.y3.a.getInstance(d0Var.getObjectAt(0));
        this.f13161b = (n1) d0Var.getObjectAt(1);
    }

    public q(g.a.a.y3.a aVar, byte[] bArr) {
        this.f13160a = aVar;
        this.f13161b = new n1(bArr);
    }

    public static q getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static q getInstance(Object obj) {
        if (obj instanceof q) {
            return (q) obj;
        }
        if (obj != null) {
            return new q(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.y3.a getAlgorithm() {
        return this.f13160a;
    }

    public n1 getPublicKey() {
        return this.f13161b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        hVar.add(this.f13160a);
        hVar.add(this.f13161b);
        return new b2(hVar);
    }
}
