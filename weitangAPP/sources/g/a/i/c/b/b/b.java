package g.a.i.c.b.b;

import g.a.a.y3.l;
import java.io.IOException;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes3.dex */
public class b implements g.a.d.a, PublicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.i.b.c.c f14572a;

    public b(g.a.i.b.c.c cVar) {
        this.f14572a = cVar;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14572a.getN() == bVar.getN() && this.f14572a.getT() == bVar.getT() && this.f14572a.getG().equals(bVar.getG());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new l(new g.a.a.y3.a(g.a.i.a.e.n), new g.a.i.a.b(this.f14572a.getN(), this.f14572a.getT(), this.f14572a.getG(), g.a(this.f14572a.getDigest()))).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public g.a.i.d.a.c getG() {
        return this.f14572a.getG();
    }

    public int getK() {
        return this.f14572a.getK();
    }

    public int getN() {
        return this.f14572a.getN();
    }

    public int getT() {
        return this.f14572a.getT();
    }

    public int hashCode() {
        return ((this.f14572a.getN() + (this.f14572a.getT() * 37)) * 37) + this.f14572a.getG().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.f14572a.getN() + "\n") + " error correction capability: " + this.f14572a.getT() + "\n") + " generator matrix           : " + this.f14572a.getG().toString();
    }
}
