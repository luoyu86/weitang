package g.a.i.c.b.a;

import g.a.a.y3.l;
import g.a.i.b.b.f;
import g.a.i.b.b.o;
import g.a.i.b.b.r;
import g.a.i.b.h.d;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes3.dex */
public class b implements PublicKey, Key {
    private static final long serialVersionUID = -5617456225328969766L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient o f14570a;

    public b(l lVar) throws IOException {
        a(lVar);
    }

    public b(o oVar) {
        this.f14570a = oVar;
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
        this.f14570a = (o) g.a.i.b.h.c.createKey(lVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            try {
                return g.a.j.a.areEqual(this.f14570a.getEncoded(), ((b) obj).f14570a.getEncoded());
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "LMS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return d.createSubjectPublicKeyInfo(this.f14570a).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int getLevels() {
        o oVar = this.f14570a;
        if (oVar instanceof r) {
            return 1;
        }
        return ((f) oVar).getL();
    }

    public int hashCode() {
        try {
            return g.a.j.a.hashCode(this.f14570a.getEncoded());
        } catch (IOException unused) {
            return -1;
        }
    }
}
