package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class m extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.q f13148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f13149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.a.w f13150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g.a.a.y3.a f13151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d0 f13152e;

    public m(d0 d0Var) {
        this.f13148a = (g.a.a.q) d0Var.getObjectAt(0);
        this.f13149b = o.getInstance((l0) d0Var.getObjectAt(1), true);
        int i2 = 2;
        if (d0Var.getObjectAt(2) instanceof l0) {
            this.f13150c = g.a.a.w.getInstance((l0) d0Var.getObjectAt(2), true);
            i2 = 3;
        }
        this.f13151d = g.a.a.y3.a.getInstance(d0Var.getObjectAt(i2));
        this.f13152e = (d0) d0Var.getObjectAt(i2 + 1);
    }

    public m(o oVar, g.a.a.w wVar, g.a.a.y3.a aVar, d0 d0Var) {
        this.f13148a = new g.a.a.q(3L);
        this.f13149b = oVar;
        this.f13150c = wVar;
        this.f13151d = aVar;
        this.f13152e = d0Var;
    }

    public static m getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static m getInstance(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.y3.a getKeyEncryptionAlgorithm() {
        return this.f13151d;
    }

    public o getOriginator() {
        return this.f13149b;
    }

    public d0 getRecipientEncryptedKeys() {
        return this.f13152e;
    }

    public g.a.a.w getUserKeyingMaterial() {
        return this.f13150c;
    }

    public g.a.a.q getVersion() {
        return this.f13148a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(5);
        hVar.add(this.f13148a);
        hVar.add(new e2(true, 0, (g.a.a.g) this.f13149b));
        g.a.a.w wVar = this.f13150c;
        if (wVar != null) {
            hVar.add(new e2(true, 1, (g.a.a.g) wVar));
        }
        hVar.add(this.f13151d);
        hVar.add(this.f13152e);
        return new b2(hVar);
    }
}
