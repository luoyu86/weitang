package g.a.a.k3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.g;
import g.a.a.h;
import g.a.a.l0;
import g.a.a.t;
import g.a.a.v;
import g.a.a.w;
import g.a.a.x1;
import g.a.a.y3.l;

/* JADX INFO: loaded from: classes2.dex */
public class f extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f13223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f13224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13225c;

    public f(d0 d0Var) {
        if (d0Var.size() == 2) {
            this.f13223a = v.getInstance(d0Var.getObjectAt(0));
            this.f13225c = w.getInstance(d0Var.getObjectAt(1)).getOctets();
            this.f13224b = null;
        } else if (d0Var.size() == 3) {
            this.f13223a = v.getInstance(d0Var.getObjectAt(0));
            this.f13224b = l.getInstance(l0.getInstance(d0Var.getObjectAt(1)), false);
            this.f13225c = w.getInstance(d0Var.getObjectAt(2)).getOctets();
        } else {
            throw new IllegalArgumentException("unknown sequence length: " + d0Var.size());
        }
    }

    public f(v vVar, l lVar, byte[] bArr) {
        this.f13223a = vVar;
        this.f13224b = lVar;
        this.f13225c = g.a.j.a.clone(bArr);
    }

    public static f getInstance(l0 l0Var, boolean z) {
        return new f(d0.getInstance(l0Var, z));
    }

    public static f getInstance(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(d0.getInstance(obj));
        }
        return null;
    }

    public v getEncryptionParamSet() {
        return this.f13223a;
    }

    public l getEphemeralPublicKey() {
        return this.f13224b;
    }

    public byte[] getUkm() {
        return g.a.j.a.clone(this.f13225c);
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        h hVar = new h(3);
        hVar.add(this.f13223a);
        l lVar = this.f13224b;
        if (lVar != null) {
            hVar.add(new e2(false, 0, (g) lVar));
        }
        hVar.add(new x1(this.f13225c));
        return new b2(hVar);
    }
}
