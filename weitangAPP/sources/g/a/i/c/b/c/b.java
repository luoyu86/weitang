package g.a.i.c.b.c;

import g.a.a.y3.l;
import g.a.i.b.h.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes3.dex */
public class b implements Key, PublicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g.a.i.b.d.b f14577a;

    public b(l lVar) throws IOException {
        a(lVar);
    }

    public b(g.a.i.b.d.b bVar) {
        this.f14577a = bVar;
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
        this.f14577a = (g.a.i.b.d.b) g.a.i.b.h.c.createKey(lVar);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        return g.a.j.a.areEqual(this.f14577a.getPubData(), ((b) obj).f14577a.getPubData());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return d.createSubjectPublicKeyInfo(this.f14577a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public byte[] getPublicData() {
        return this.f14577a.getPubData();
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f14577a.getPubData());
    }
}
