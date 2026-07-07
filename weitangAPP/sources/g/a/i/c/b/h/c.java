package g.a.i.c.b.h;

import g.a.a.a0;
import g.a.a.f0;
import g.a.a.v;
import g.a.i.a.i;
import g.a.i.b.i.y;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public class c implements PrivateKey, g.a.i.c.a.c {
    private static final long serialVersionUID = 8568701712864512338L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient y f14601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient v f14602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient f0 f14603c;

    public c(g.a.a.t3.b bVar) throws IOException {
        a(bVar);
    }

    public c(v vVar, y yVar) {
        this.f14602b = vVar;
        this.f14601a = yVar;
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
        this.f14603c = bVar.getAttributes();
        this.f14602b = i.getInstance(bVar.getPrivateKeyAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
        this.f14601a = (y) g.a.i.b.h.a.createKey(bVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f14602b.equals((a0) cVar.f14602b) && g.a.j.a.areEqual(this.f14601a.toByteArray(), cVar.f14601a.toByteArray());
    }

    @Override // g.a.i.c.a.c
    public g.a.i.c.a.c extractKeyShard(int i2) {
        return new c(this.f14602b, this.f14601a.extractKeyShard(i2));
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "XMSS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return g.a.i.b.h.b.createPrivateKeyInfo(this.f14601a, this.f14603c).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // g.a.i.c.a.c
    public int getHeight() {
        return this.f14601a.getParameters().getHeight();
    }

    @Override // g.a.i.c.a.c
    public long getIndex() {
        if (getUsagesRemaining() != 0) {
            return this.f14601a.getIndex();
        }
        throw new IllegalStateException("key exhausted");
    }

    @Override // g.a.i.c.a.c
    public String getTreeDigest() {
        return e.getXMSSDigestName(this.f14602b);
    }

    @Override // g.a.i.c.a.c
    public long getUsagesRemaining() {
        return this.f14601a.getUsagesRemaining();
    }

    public int hashCode() {
        return this.f14602b.hashCode() + (g.a.j.a.hashCode(this.f14601a.toByteArray()) * 37);
    }
}
