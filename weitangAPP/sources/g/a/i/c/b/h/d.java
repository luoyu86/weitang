package g.a.i.c.b.h;

import g.a.a.a0;
import g.a.a.v;
import g.a.a.y3.l;
import g.a.i.b.i.z;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes3.dex */
public class d implements PublicKey {
    private static final long serialVersionUID = -5617456225328969766L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient z f14604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient v f14605b;

    public d(v vVar, z zVar) {
        this.f14605b = vVar;
        this.f14604a = zVar;
    }

    public d(l lVar) throws IOException {
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
        z zVar = (z) g.a.i.b.h.c.createKey(lVar);
        this.f14604a = zVar;
        this.f14605b = e.a(zVar.getTreeDigest());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            try {
                if (this.f14605b.equals((a0) dVar.f14605b)) {
                    if (g.a.j.a.areEqual(this.f14604a.getEncoded(), dVar.f14604a.getEncoded())) {
                        return true;
                    }
                }
                return false;
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return g.a.i.b.h.d.createSubjectPublicKeyInfo(this.f14604a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int getHeight() {
        return this.f14604a.getParameters().getHeight();
    }

    public String getTreeDigest() {
        return e.getXMSSDigestName(this.f14605b);
    }

    public int hashCode() {
        try {
            return this.f14605b.hashCode() + (g.a.j.a.hashCode(this.f14604a.getEncoded()) * 37);
        } catch (IOException unused) {
            return this.f14605b.hashCode();
        }
    }
}
