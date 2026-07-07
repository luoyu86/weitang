package g.a.b;

import g.a.a.a0;
import g.a.a.p;
import g.a.a.v;
import g.a.a.y3.g;
import g.a.a.y3.h;
import g.a.a.y3.i;
import g.a.a.y3.m;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class e implements g.a.j.d, Serializable {
    private static final long serialVersionUID = 20170722001L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g.a.a.y3.c f13598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient boolean f13599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient g.a.a.y3.f f13600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient h f13601d;

    public e(g.a.a.y3.c cVar) {
        a(cVar);
    }

    public e(InputStream inputStream) throws IOException {
        this(c(inputStream));
    }

    public e(byte[] bArr) throws IOException {
        this(c(new ByteArrayInputStream(bArr)));
    }

    public static boolean b(g.a.a.y3.f fVar) {
        g.a.a.y3.e extension;
        return (fVar == null || (extension = fVar.getExtension(g.a.a.y3.e.m)) == null || !i.getInstance(extension.getParsedValue()).isIndirectCRL()) ? false : true;
    }

    public static g.a.a.y3.c c(InputStream inputStream) throws IOException {
        try {
            a0 object = new p(inputStream, true).readObject();
            if (object != null) {
                return g.a.a.y3.c.getInstance(object);
            }
            throw new IOException("no content found");
        } catch (ClassCastException e2) {
            throw new b("malformed data: " + e2.getMessage(), e2);
        } catch (IllegalArgumentException e3) {
            throw new b("malformed data: " + e3.getMessage(), e3);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        a(g.a.a.y3.c.getInstance(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final void a(g.a.a.y3.c cVar) {
        this.f13598a = cVar;
        g.a.a.y3.f extensions = cVar.getTBSCertList().getExtensions();
        this.f13600c = extensions;
        this.f13599b = b(extensions);
        this.f13601d = new h(new g(cVar.getIssuer()));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return this.f13598a.equals(((e) obj).f13598a);
        }
        return false;
    }

    public Set getCriticalExtensionOIDs() {
        return c.a(this.f13600c);
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        return this.f13598a.getEncoded();
    }

    public g.a.a.y3.e getExtension(v vVar) {
        g.a.a.y3.f fVar = this.f13600c;
        if (fVar != null) {
            return fVar.getExtension(vVar);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return c.b(this.f13600c);
    }

    public g.a.a.y3.f getExtensions() {
        return this.f13600c;
    }

    public g.a.a.x3.c getIssuer() {
        return g.a.a.x3.c.getInstance(this.f13598a.getIssuer());
    }

    public Date getNextUpdate() {
        g.a.a.y3.p nextUpdate = this.f13598a.getNextUpdate();
        if (nextUpdate != null) {
            return nextUpdate.getDate();
        }
        return null;
    }

    public Set getNonCriticalExtensionOIDs() {
        return c.c(this.f13600c);
    }

    public d getRevokedCertificate(BigInteger bigInteger) {
        g.a.a.y3.e extension;
        h hVar = this.f13601d;
        Enumeration revokedCertificateEnumeration = this.f13598a.getRevokedCertificateEnumeration();
        while (revokedCertificateEnumeration.hasMoreElements()) {
            m.b bVar = (m.b) revokedCertificateEnumeration.nextElement();
            if (bVar.getUserCertificate().hasValue(bigInteger)) {
                return new d(bVar, this.f13599b, hVar);
            }
            if (this.f13599b && bVar.hasExtensions() && (extension = bVar.getExtensions().getExtension(g.a.a.y3.e.n)) != null) {
                hVar = h.getInstance(extension.getParsedValue());
            }
        }
        return null;
    }

    public Collection getRevokedCertificates() {
        ArrayList arrayList = new ArrayList(this.f13598a.getRevokedCertificates().length);
        h certificateIssuer = this.f13601d;
        Enumeration revokedCertificateEnumeration = this.f13598a.getRevokedCertificateEnumeration();
        while (revokedCertificateEnumeration.hasMoreElements()) {
            d dVar = new d((m.b) revokedCertificateEnumeration.nextElement(), this.f13599b, certificateIssuer);
            arrayList.add(dVar);
            certificateIssuer = dVar.getCertificateIssuer();
        }
        return arrayList;
    }

    public Date getThisUpdate() {
        return this.f13598a.getThisUpdate().getDate();
    }

    public boolean hasExtensions() {
        return this.f13600c != null;
    }

    public int hashCode() {
        return this.f13598a.hashCode();
    }

    public boolean isSignatureValid(g.a.h.c cVar) throws a {
        m tBSCertList = this.f13598a.getTBSCertList();
        if (!c.d(tBSCertList.getSignature(), this.f13598a.getSignatureAlgorithm())) {
            throw new a("signature invalid - algorithm identifier mismatch");
        }
        try {
            g.a.h.b bVar = cVar.get(tBSCertList.getSignature());
            OutputStream outputStream = bVar.getOutputStream();
            tBSCertList.encodeTo(outputStream, "DER");
            outputStream.close();
            return bVar.verify(this.f13598a.getSignature().getOctets());
        } catch (Exception e2) {
            throw new a("unable to process signature: " + e2.getMessage(), e2);
        }
    }

    public g.a.a.y3.c toASN1Structure() {
        return this.f13598a;
    }
}
