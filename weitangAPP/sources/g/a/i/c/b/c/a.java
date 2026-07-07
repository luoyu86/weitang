package g.a.i.c.b.c;

import g.a.a.f0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.PrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public class a implements Key, PrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g.a.i.b.d.a f14575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient f0 f14576b;

    public a(g.a.a.t3.b bVar) throws IOException {
        a(bVar);
    }

    public a(g.a.i.b.d.a aVar) {
        this.f14575a = aVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        a(g.a.a.t3.b.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public final void a(g.a.a.t3.b bVar) throws IOException {
        this.f14576b = bVar.getAttributes();
        this.f14575a = (g.a.i.b.d.a) g.a.i.b.h.a.createKey(bVar);
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            return g.a.j.a.areEqual(this.f14575a.getSecData(), ((a) obj).f14575a.getSecData());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return g.a.i.b.h.b.createPrivateKeyInfo(this.f14575a, this.f14576b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public short[] getSecretData() {
        return this.f14575a.getSecData();
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f14575a.getSecData());
    }
}
