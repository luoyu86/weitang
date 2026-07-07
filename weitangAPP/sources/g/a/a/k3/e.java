package g.a.a.k3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.g;
import g.a.a.h;
import g.a.a.l0;
import g.a.a.t;

/* JADX INFO: loaded from: classes2.dex */
public class e extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f13221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f13222b;

    public e(d0 d0Var) {
        this.f13221a = d.getInstance(d0Var.getObjectAt(0));
        this.f13222b = f.getInstance(l0.getInstance(d0Var.getObjectAt(1)), false);
    }

    public e(d dVar, f fVar) {
        this.f13221a = dVar;
        this.f13222b = fVar;
    }

    public static e getInstance(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(d0.getInstance(obj));
        }
        return null;
    }

    public d getSessionEncryptedKey() {
        return this.f13221a;
    }

    public f getTransportParameters() {
        return this.f13222b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        h hVar = new h(2);
        hVar.add(this.f13221a);
        f fVar = this.f13222b;
        if (fVar != null) {
            hVar.add(new e2(false, 0, (g) fVar));
        }
        return new b2(hVar);
    }
}
