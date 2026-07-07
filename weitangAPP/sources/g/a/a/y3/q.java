package g.a.a.y3;

import g.a.a.a0;
import g.a.a.d0;
import g.a.a.l0;
import g.a.a.n1;

/* JADX INFO: loaded from: classes2.dex */
public class q extends g.a.a.t implements x, g.a.a.t3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f13518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f13519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f13520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g.a.a.c f13521d;

    public q(d0 d0Var) {
        this.f13518a = d0Var;
        if (d0Var.size() != 3) {
            throw new IllegalArgumentException("sequence wrong size for a certificate");
        }
        this.f13519b = o.getInstance(d0Var.getObjectAt(0));
        this.f13520c = a.getInstance(d0Var.getObjectAt(1));
        this.f13521d = n1.getInstance((Object) d0Var.getObjectAt(2));
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

    public p getEndDate() {
        return this.f13519b.getEndDate();
    }

    public g.a.a.x3.c getIssuer() {
        return this.f13519b.getIssuer();
    }

    public g.a.a.q getSerialNumber() {
        return this.f13519b.getSerialNumber();
    }

    public g.a.a.c getSignature() {
        return this.f13521d;
    }

    public a getSignatureAlgorithm() {
        return this.f13520c;
    }

    public p getStartDate() {
        return this.f13519b.getStartDate();
    }

    public g.a.a.x3.c getSubject() {
        return this.f13519b.getSubject();
    }

    public l getSubjectPublicKeyInfo() {
        return this.f13519b.getSubjectPublicKeyInfo();
    }

    public o getTBSCertificate() {
        return this.f13519b;
    }

    public int getVersion() {
        return this.f13519b.getVersion();
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13518a;
    }
}
