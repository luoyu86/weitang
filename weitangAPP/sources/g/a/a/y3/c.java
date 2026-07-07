package g.a.a.y3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;
import g.a.a.n1;
import g.a.a.y3.m;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public class c extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f13455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f13456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.a.c f13457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f13458d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13459e;

    public c(d0 d0Var) {
        if (d0Var.size() != 3) {
            throw new IllegalArgumentException("sequence wrong size for CertificateList");
        }
        this.f13455a = m.getInstance(d0Var.getObjectAt(0));
        this.f13456b = a.getInstance(d0Var.getObjectAt(1));
        this.f13457c = n1.getInstance((Object) d0Var.getObjectAt(2));
    }

    public static c getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static c getInstance(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.x3.c getIssuer() {
        return this.f13455a.getIssuer();
    }

    public p getNextUpdate() {
        return this.f13455a.getNextUpdate();
    }

    public Enumeration getRevokedCertificateEnumeration() {
        return this.f13455a.getRevokedCertificateEnumeration();
    }

    public m.b[] getRevokedCertificates() {
        return this.f13455a.getRevokedCertificates();
    }

    public g.a.a.c getSignature() {
        return this.f13457c;
    }

    public a getSignatureAlgorithm() {
        return this.f13456b;
    }

    public m getTBSCertList() {
        return this.f13455a;
    }

    public p getThisUpdate() {
        return this.f13455a.getThisUpdate();
    }

    public int getVersionNumber() {
        return this.f13455a.getVersionNumber();
    }

    @Override // g.a.a.t
    public int hashCode() {
        if (!this.f13458d) {
            this.f13459e = super.hashCode();
            this.f13458d = true;
        }
        return this.f13459e;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(3);
        hVar.add(this.f13455a);
        hVar.add(this.f13456b);
        hVar.add(this.f13457c);
        return new b2(hVar);
    }
}
