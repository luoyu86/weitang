package g.a.i.c.b.f;

import g.a.a.a0;
import g.a.a.f0;
import g.a.a.v;
import g.a.a.x1;
import g.a.i.a.e;
import g.a.i.a.h;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.PrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public class a implements PrivateKey, Key {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient v f14591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient g.a.i.b.g.b f14592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient f0 f14593c;

    public a(g.a.a.t3.b bVar) throws IOException {
        a(bVar);
    }

    public a(v vVar, g.a.i.b.g.b bVar) {
        this.f14591a = vVar;
        this.f14592b = bVar;
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
        this.f14593c = bVar.getAttributes();
        this.f14591a = h.getInstance(bVar.getPrivateKeyAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
        this.f14592b = (g.a.i.b.g.b) g.a.i.b.h.a.createKey(bVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14591a.equals((a0) aVar.f14591a) && g.a.j.a.areEqual(this.f14592b.getKeyData(), aVar.f14592b.getKeyData());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return (this.f14592b.getTreeDigest() != null ? g.a.i.b.h.b.createPrivateKeyInfo(this.f14592b, this.f14593c) : new g.a.a.t3.b(new g.a.a.y3.a(e.r, new h(new g.a.a.y3.a(this.f14591a))), new x1(this.f14592b.getKeyData()), this.f14593c)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public byte[] getKeyData() {
        return this.f14592b.getKeyData();
    }

    public int hashCode() {
        return this.f14591a.hashCode() + (g.a.j.a.hashCode(this.f14592b.getKeyData()) * 37);
    }
}
