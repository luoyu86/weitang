package g.a.i.c.b.f;

import g.a.a.a0;
import g.a.a.v;
import g.a.a.y3.l;
import g.a.i.a.e;
import g.a.i.a.h;
import g.a.i.b.h.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes3.dex */
public class b implements PublicKey, Key {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient v f14594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient g.a.i.b.g.c f14595b;

    public b(v vVar, g.a.i.b.g.c cVar) {
        this.f14594a = vVar;
        this.f14595b = cVar;
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
        this.f14594a = h.getInstance(lVar.getAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
        this.f14595b = (g.a.i.b.g.c) g.a.i.b.h.c.createKey(lVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14594a.equals((a0) bVar.f14594a) && g.a.j.a.areEqual(this.f14595b.getKeyData(), bVar.f14595b.getKeyData());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return (this.f14595b.getTreeDigest() != null ? d.createSubjectPublicKeyInfo(this.f14595b) : new l(new g.a.a.y3.a(e.r, new h(new g.a.a.y3.a(this.f14594a))), this.f14595b.getKeyData())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public byte[] getKeyData() {
        return this.f14595b.getKeyData();
    }

    public int hashCode() {
        return this.f14594a.hashCode() + (g.a.j.a.hashCode(this.f14595b.getKeyData()) * 37);
    }
}
