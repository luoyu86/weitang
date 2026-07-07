package g.a.a.y3;

import g.a.a.a0;
import g.a.a.d0;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class b extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f13451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n f13452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f13453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g.a.a.c f13454d;

    public b(d0 d0Var) {
        this.f13451a = d0Var;
        if (d0Var.size() != 3) {
            throw new IllegalArgumentException("sequence wrong size for a certificate");
        }
        this.f13452b = n.getInstance(d0Var.getObjectAt(0));
        this.f13453c = a.getInstance(d0Var.getObjectAt(1));
        this.f13454d = g.a.a.c.getInstance(d0Var.getObjectAt(2));
    }

    public static b getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static b getInstance(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(d0.getInstance(obj));
        }
        return null;
    }

    public p getEndDate() {
        return this.f13452b.getEndDate();
    }

    public g.a.a.x3.c getIssuer() {
        return this.f13452b.getIssuer();
    }

    public g.a.a.q getSerialNumber() {
        return this.f13452b.getSerialNumber();
    }

    public g.a.a.c getSignature() {
        return this.f13454d;
    }

    public a getSignatureAlgorithm() {
        return this.f13453c;
    }

    public p getStartDate() {
        return this.f13452b.getStartDate();
    }

    public g.a.a.x3.c getSubject() {
        return this.f13452b.getSubject();
    }

    public l getSubjectPublicKeyInfo() {
        return this.f13452b.getSubjectPublicKeyInfo();
    }

    public n getTBSCertificate() {
        return this.f13452b;
    }

    public g.a.a.q getVersion() {
        return this.f13452b.getVersion();
    }

    public int getVersionNumber() {
        return this.f13452b.getVersionNumber();
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13451a;
    }
}
