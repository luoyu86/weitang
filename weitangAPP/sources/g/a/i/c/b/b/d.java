package g.a.i.c.b.b;

import g.a.a.y3.l;
import java.io.IOException;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes3.dex */
public class d implements PublicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.i.b.c.g f14574a;

    public d(g.a.i.b.c.g gVar) {
        this.f14574a = gVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f14574a.getN() == dVar.getN() && this.f14574a.getT() == dVar.getT() && this.f14574a.getG().equals(dVar.getG());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new l(new g.a.a.y3.a(g.a.i.a.e.m), new g.a.i.a.d(this.f14574a.getN(), this.f14574a.getT(), this.f14574a.getG())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public g.a.i.d.a.c getG() {
        return this.f14574a.getG();
    }

    public int getK() {
        return this.f14574a.getK();
    }

    public int getN() {
        return this.f14574a.getN();
    }

    public int getT() {
        return this.f14574a.getT();
    }

    public int hashCode() {
        return ((this.f14574a.getN() + (this.f14574a.getT() * 37)) * 37) + this.f14574a.getG().hashCode();
    }

    public String toString() {
        return (("McEliecePublicKey:\n length of the code         : " + this.f14574a.getN() + "\n") + " error correction capability: " + this.f14574a.getT() + "\n") + " generator matrix           : " + this.f14574a.getG();
    }
}
