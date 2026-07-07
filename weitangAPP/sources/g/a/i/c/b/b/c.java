package g.a.i.c.b.b;

import g.a.i.d.a.l;
import g.a.i.d.a.m;
import java.io.IOException;
import java.security.PrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public class c implements g.a.d.a, PrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.i.b.c.f f14573a;

    public c(g.a.i.b.c.f fVar) {
        this.f14573a = fVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return getN() == cVar.getN() && getK() == cVar.getK() && getField().equals(cVar.getField()) && getGoppaPoly().equals(cVar.getGoppaPoly()) && getSInv().equals(cVar.getSInv()) && getP1().equals(cVar.getP1()) && getP2().equals(cVar.getP2());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new g.a.a.t3.b(new g.a.a.y3.a(g.a.i.a.e.m), new g.a.i.a.c(this.f14573a.getN(), this.f14573a.getK(), this.f14573a.getField(), this.f14573a.getGoppaPoly(), this.f14573a.getP1(), this.f14573a.getP2(), this.f14573a.getSInv())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public g.a.i.d.a.e getField() {
        return this.f14573a.getField();
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public m getGoppaPoly() {
        return this.f14573a.getGoppaPoly();
    }

    public g.a.i.d.a.c getH() {
        return this.f14573a.getH();
    }

    public int getK() {
        return this.f14573a.getK();
    }

    public int getN() {
        return this.f14573a.getN();
    }

    public l getP1() {
        return this.f14573a.getP1();
    }

    public l getP2() {
        return this.f14573a.getP2();
    }

    public m[] getQInv() {
        return this.f14573a.getQInv();
    }

    public g.a.i.d.a.c getSInv() {
        return this.f14573a.getSInv();
    }

    public int hashCode() {
        return (((((((((((this.f14573a.getK() * 37) + this.f14573a.getN()) * 37) + this.f14573a.getField().hashCode()) * 37) + this.f14573a.getGoppaPoly().hashCode()) * 37) + this.f14573a.getP1().hashCode()) * 37) + this.f14573a.getP2().hashCode()) * 37) + this.f14573a.getSInv().hashCode();
    }
}
