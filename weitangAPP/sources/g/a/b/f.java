package g.a.b;

import g.a.a.v;
import g.a.a.y3.l;
import g.a.a.y3.n;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class f implements g.a.j.d, Serializable {
    private static final long serialVersionUID = 20170722001L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g.a.a.y3.b f13602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient g.a.a.y3.f f13603b;

    public f(g.a.a.y3.b bVar) {
        a(bVar);
    }

    public f(byte[] bArr) throws IOException {
        this(b(bArr));
    }

    public static g.a.a.y3.b b(byte[] bArr) throws IOException {
        try {
            return g.a.a.y3.b.getInstance(c.e(bArr));
        } catch (ClassCastException e2) {
            throw new b("malformed data: " + e2.getMessage(), e2);
        } catch (IllegalArgumentException e3) {
            throw new b("malformed data: " + e3.getMessage(), e3);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        a(g.a.a.y3.b.getInstance(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final void a(g.a.a.y3.b bVar) {
        this.f13602a = bVar;
        this.f13603b = bVar.getTBSCertificate().getExtensions();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return this.f13602a.equals(((f) obj).f13602a);
        }
        return false;
    }

    public Set getCriticalExtensionOIDs() {
        return c.a(this.f13603b);
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        return this.f13602a.getEncoded();
    }

    public g.a.a.y3.e getExtension(v vVar) {
        g.a.a.y3.f fVar = this.f13603b;
        if (fVar != null) {
            return fVar.getExtension(vVar);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return c.b(this.f13603b);
    }

    public g.a.a.y3.f getExtensions() {
        return this.f13603b;
    }

    public g.a.a.x3.c getIssuer() {
        return g.a.a.x3.c.getInstance(this.f13602a.getIssuer());
    }

    public Set getNonCriticalExtensionOIDs() {
        return c.c(this.f13603b);
    }

    public Date getNotAfter() {
        return this.f13602a.getEndDate().getDate();
    }

    public Date getNotBefore() {
        return this.f13602a.getStartDate().getDate();
    }

    public BigInteger getSerialNumber() {
        return this.f13602a.getSerialNumber().getValue();
    }

    public byte[] getSignature() {
        return this.f13602a.getSignature().getOctets();
    }

    public g.a.a.y3.a getSignatureAlgorithm() {
        return this.f13602a.getSignatureAlgorithm();
    }

    public g.a.a.x3.c getSubject() {
        return g.a.a.x3.c.getInstance(this.f13602a.getSubject());
    }

    public l getSubjectPublicKeyInfo() {
        return this.f13602a.getSubjectPublicKeyInfo();
    }

    public int getVersion() {
        return this.f13602a.getVersionNumber();
    }

    public int getVersionNumber() {
        return this.f13602a.getVersionNumber();
    }

    public boolean hasExtensions() {
        return this.f13603b != null;
    }

    public int hashCode() {
        return this.f13602a.hashCode();
    }

    public boolean isSignatureValid(g.a.h.c cVar) throws a {
        n tBSCertificate = this.f13602a.getTBSCertificate();
        if (!c.d(tBSCertificate.getSignature(), this.f13602a.getSignatureAlgorithm())) {
            throw new a("signature invalid - algorithm identifier mismatch");
        }
        try {
            g.a.h.b bVar = cVar.get(tBSCertificate.getSignature());
            OutputStream outputStream = bVar.getOutputStream();
            tBSCertificate.encodeTo(outputStream, "DER");
            outputStream.close();
            return bVar.verify(getSignature());
        } catch (Exception e2) {
            throw new a("unable to process signature: " + e2.getMessage(), e2);
        }
    }

    public boolean isValidOn(Date date) {
        return (date.before(this.f13602a.getStartDate().getDate()) || date.after(this.f13602a.getEndDate().getDate())) ? false : true;
    }

    public g.a.a.y3.b toASN1Structure() {
        return this.f13602a;
    }
}
