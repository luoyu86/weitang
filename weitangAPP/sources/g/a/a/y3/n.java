package g.a.a.y3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class n extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f13499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.q f13500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.a.q f13501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f13502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g.a.a.x3.c f13503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f13504f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p f13505g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g.a.a.x3.c f13506h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f13507i;
    public g.a.a.c j;
    public g.a.a.c k;
    public f l;

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public n(g.a.a.d0 r10) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: g.a.a.y3.n.<init>(g.a.a.d0):void");
    }

    public static n getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static n getInstance(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(d0.getInstance(obj));
        }
        return null;
    }

    public p getEndDate() {
        return this.f13505g;
    }

    public f getExtensions() {
        return this.l;
    }

    public g.a.a.x3.c getIssuer() {
        return this.f13503e;
    }

    public g.a.a.c getIssuerUniqueId() {
        return this.j;
    }

    public g.a.a.q getSerialNumber() {
        return this.f13501c;
    }

    public a getSignature() {
        return this.f13502d;
    }

    public p getStartDate() {
        return this.f13504f;
    }

    public g.a.a.x3.c getSubject() {
        return this.f13506h;
    }

    public l getSubjectPublicKeyInfo() {
        return this.f13507i;
    }

    public g.a.a.c getSubjectUniqueId() {
        return this.k;
    }

    public g.a.a.q getVersion() {
        return this.f13500b;
    }

    public int getVersionNumber() {
        return this.f13500b.intValueExact() + 1;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        if (g.a.j.l.getPropertyValue("org.bouncycastle.x509.allow_non-der_tbscert") != null && !g.a.j.l.isOverrideSet("org.bouncycastle.x509.allow_non-der_tbscert")) {
            g.a.a.h hVar = new g.a.a.h();
            if (!this.f13500b.hasValue(0)) {
                hVar.add(new e2(true, 0, (g.a.a.g) this.f13500b));
            }
            hVar.add(this.f13501c);
            hVar.add(this.f13502d);
            hVar.add(this.f13503e);
            g.a.a.h hVar2 = new g.a.a.h(2);
            hVar2.add(this.f13504f);
            hVar2.add(this.f13505g);
            hVar.add(new b2(hVar2));
            g.a.a.g b2Var = this.f13506h;
            if (b2Var == null) {
                b2Var = new b2();
            }
            hVar.add(b2Var);
            hVar.add(this.f13507i);
            g.a.a.c cVar = this.j;
            if (cVar != null) {
                hVar.add(new e2(false, 1, (g.a.a.g) cVar));
            }
            g.a.a.c cVar2 = this.k;
            if (cVar2 != null) {
                hVar.add(new e2(false, 2, (g.a.a.g) cVar2));
            }
            f fVar = this.l;
            if (fVar != null) {
                hVar.add(new e2(true, 3, (g.a.a.g) fVar));
            }
            return new b2(hVar);
        }
        return this.f13499a;
    }
}
