package g.a.i.c.b.a;

import g.a.a.f0;
import g.a.i.b.b.e;
import g.a.i.b.b.o;
import g.a.i.b.b.q;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public class a implements PrivateKey, g.a.i.c.a.a {
    private static final long serialVersionUID = 8568701712864512338L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient o f14568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient f0 f14569b;

    public a(g.a.a.t3.b bVar) throws IOException {
        a(bVar);
    }

    public a(o oVar) {
        this.f14568a = oVar;
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
        this.f14569b = bVar.getAttributes();
        this.f14568a = (o) g.a.i.b.h.a.createKey(bVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        try {
            return g.a.j.a.areEqual(this.f14568a.getEncoded(), ((a) obj).f14568a.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("unable to perform equals");
        }
    }

    @Override // g.a.i.c.a.a
    public g.a.i.c.a.a extractKeyShard(int i2) {
        o oVar = this.f14568a;
        return oVar instanceof q ? new a(((q) oVar).extractKeyShard(i2)) : new a(((e) oVar).extractKeyShard(i2));
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "LMS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return g.a.i.b.h.b.createPrivateKeyInfo(this.f14568a, this.f14569b).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // g.a.i.c.a.a
    public long getIndex() {
        if (getUsagesRemaining() == 0) {
            throw new IllegalStateException("key exhausted");
        }
        o oVar = this.f14568a;
        return oVar instanceof q ? ((q) oVar).getIndex() : ((e) oVar).getIndex();
    }

    @Override // g.a.i.c.a.a
    public int getLevels() {
        o oVar = this.f14568a;
        if (oVar instanceof q) {
            return 1;
        }
        return ((e) oVar).getL();
    }

    @Override // g.a.i.c.a.a
    public long getUsagesRemaining() {
        o oVar = this.f14568a;
        return oVar instanceof q ? ((q) oVar).getUsagesRemaining() : ((e) oVar).getUsagesRemaining();
    }

    public int hashCode() {
        try {
            return g.a.j.a.hashCode(this.f14568a.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("unable to calculate hashCode");
        }
    }
}
