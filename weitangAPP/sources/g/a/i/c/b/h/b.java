package g.a.i.c.b.h;

import g.a.a.a0;
import g.a.a.v;
import g.a.a.y3.l;
import g.a.i.b.i.t;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes3.dex */
public class b implements PublicKey {
    private static final long serialVersionUID = 3230324130542413475L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient v f14599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient t f14600b;

    public b(v vVar, t tVar) {
        this.f14599a = vVar;
        this.f14600b = tVar;
    }

    public b(l lVar) throws IOException {
        a(lVar);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        a(l.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final void a(l lVar) throws IOException {
        t tVar = (t) g.a.i.b.h.c.createKey(lVar);
        this.f14600b = tVar;
        this.f14599a = e.a(tVar.getTreeDigest());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14599a.equals((a0) bVar.f14599a) && g.a.j.a.areEqual(this.f14600b.toByteArray(), bVar.f14600b.toByteArray());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return g.a.i.b.h.d.createSubjectPublicKeyInfo(this.f14600b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int getHeight() {
        return this.f14600b.getParameters().getHeight();
    }

    public int getLayers() {
        return this.f14600b.getParameters().getLayers();
    }

    public String getTreeDigest() {
        return e.getXMSSDigestName(this.f14599a);
    }

    public int hashCode() {
        return this.f14599a.hashCode() + (g.a.j.a.hashCode(this.f14600b.toByteArray()) * 37);
    }
}
