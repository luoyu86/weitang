package g.a.i.c.b.d;

import g.a.a.f0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public class a implements PrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g.a.i.b.e.a f14578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient f0 f14579b;

    public a(g.a.a.t3.b bVar) throws IOException {
        a(bVar);
    }

    public a(g.a.i.b.e.a aVar) {
        this.f14578a = aVar;
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
        this.f14579b = bVar.getAttributes();
        this.f14578a = (g.a.i.b.e.a) g.a.i.b.h.a.createKey(bVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14578a.getSecurityCategory() == aVar.f14578a.getSecurityCategory() && g.a.j.a.areEqual(this.f14578a.getSecret(), aVar.f14578a.getSecret());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return g.a.i.b.e.c.getName(this.f14578a.getSecurityCategory());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return g.a.i.b.h.b.createPrivateKeyInfo(this.f14578a, this.f14579b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public g.a.i.c.c.a getParams() {
        return new g.a.i.c.c.a(getAlgorithm());
    }

    public int hashCode() {
        return this.f14578a.getSecurityCategory() + (g.a.j.a.hashCode(this.f14578a.getSecret()) * 37);
    }
}
