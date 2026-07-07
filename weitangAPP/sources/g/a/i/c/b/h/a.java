package g.a.i.c.b.h;

import g.a.a.a0;
import g.a.a.f0;
import g.a.a.v;
import g.a.i.a.j;
import g.a.i.b.i.s;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public class a implements PrivateKey, g.a.i.c.a.b {
    private static final long serialVersionUID = 7682140473044521395L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient v f14596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient s f14597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient f0 f14598c;

    public a(g.a.a.t3.b bVar) throws IOException {
        a(bVar);
    }

    public a(v vVar, s sVar) {
        this.f14596a = vVar;
        this.f14597b = sVar;
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
        this.f14598c = bVar.getAttributes();
        this.f14596a = j.getInstance(bVar.getPrivateKeyAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
        this.f14597b = (s) g.a.i.b.h.a.createKey(bVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14596a.equals((a0) aVar.f14596a) && g.a.j.a.areEqual(this.f14597b.toByteArray(), aVar.f14597b.toByteArray());
    }

    @Override // g.a.i.c.a.b
    public g.a.i.c.a.b extractKeyShard(int i2) {
        return new a(this.f14596a, this.f14597b.extractKeyShard(i2));
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSSMT";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return g.a.i.b.h.b.createPrivateKeyInfo(this.f14597b, this.f14598c).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // g.a.i.c.a.b
    public int getHeight() {
        return this.f14597b.getParameters().getHeight();
    }

    @Override // g.a.i.c.a.b
    public long getIndex() {
        if (getUsagesRemaining() != 0) {
            return this.f14597b.getIndex();
        }
        throw new IllegalStateException("key exhausted");
    }

    @Override // g.a.i.c.a.b
    public int getLayers() {
        return this.f14597b.getParameters().getLayers();
    }

    @Override // g.a.i.c.a.b
    public String getTreeDigest() {
        return e.getXMSSDigestName(this.f14596a);
    }

    @Override // g.a.i.c.a.b
    public long getUsagesRemaining() {
        return this.f14597b.getUsagesRemaining();
    }

    public int hashCode() {
        return this.f14596a.hashCode() + (g.a.j.a.hashCode(this.f14597b.toByteArray()) * 37);
    }
}
