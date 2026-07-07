package g.a.i.c.b.d;

import g.a.a.y3.l;
import g.a.i.b.h.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes3.dex */
public class b implements PublicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g.a.i.b.e.b f14580a;

    public b(l lVar) throws IOException {
        a(lVar);
    }

    public b(g.a.i.b.e.b bVar) {
        this.f14580a = bVar;
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
        this.f14580a = (g.a.i.b.e.b) g.a.i.b.h.c.createKey(lVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14580a.getSecurityCategory() == bVar.f14580a.getSecurityCategory() && g.a.j.a.areEqual(this.f14580a.getPublicData(), bVar.f14580a.getPublicData());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return g.a.i.b.e.c.getName(this.f14580a.getSecurityCategory());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return d.createSubjectPublicKeyInfo(this.f14580a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public g.a.i.c.c.a getParams() {
        return new g.a.i.c.c.a(getAlgorithm());
    }

    public int hashCode() {
        return this.f14580a.getSecurityCategory() + (g.a.j.a.hashCode(this.f14580a.getPublicData()) * 37);
    }
}
