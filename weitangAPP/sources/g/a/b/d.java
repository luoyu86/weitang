package g.a.b;

import g.a.a.v;
import g.a.a.y3.h;
import g.a.a.y3.m;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m.b f13596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f13597b;

    public d(m.b bVar, boolean z, h hVar) {
        g.a.a.y3.e extension;
        this.f13596a = bVar;
        this.f13597b = hVar;
        if (z && bVar.hasExtensions() && (extension = bVar.getExtensions().getExtension(g.a.a.y3.e.n)) != null) {
            this.f13597b = h.getInstance(extension.getParsedValue());
        }
    }

    public h getCertificateIssuer() {
        return this.f13597b;
    }

    public Set getCriticalExtensionOIDs() {
        return c.a(this.f13596a.getExtensions());
    }

    public g.a.a.y3.e getExtension(v vVar) {
        g.a.a.y3.f extensions = this.f13596a.getExtensions();
        if (extensions != null) {
            return extensions.getExtension(vVar);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return c.b(this.f13596a.getExtensions());
    }

    public g.a.a.y3.f getExtensions() {
        return this.f13596a.getExtensions();
    }

    public Set getNonCriticalExtensionOIDs() {
        return c.c(this.f13596a.getExtensions());
    }

    public Date getRevocationDate() {
        return this.f13596a.getRevocationDate().getDate();
    }

    public BigInteger getSerialNumber() {
        return this.f13596a.getUserCertificate().getValue();
    }

    public boolean hasExtensions() {
        return this.f13596a.hasExtensions();
    }
}
