package g.a.i.c.b.b;

import g.a.i.d.a.l;
import g.a.i.d.a.m;
import java.io.IOException;
import java.security.PrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public class a implements PrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.i.b.c.b f14571a;

    public a(g.a.i.b.c.b bVar) {
        this.f14571a = bVar;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return getN() == aVar.getN() && getK() == aVar.getK() && getField().equals(aVar.getField()) && getGoppaPoly().equals(aVar.getGoppaPoly()) && getP().equals(aVar.getP()) && getH().equals(aVar.getH());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "McEliece-CCA2";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new g.a.a.t3.b(new g.a.a.y3.a(g.a.i.a.e.n), new g.a.i.a.a(getN(), getK(), getField(), getGoppaPoly(), getP(), g.a(this.f14571a.getDigest()))).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    public g.a.i.d.a.e getField() {
        return this.f14571a.getField();
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public m getGoppaPoly() {
        return this.f14571a.getGoppaPoly();
    }

    public g.a.i.d.a.c getH() {
        return this.f14571a.getH();
    }

    public int getK() {
        return this.f14571a.getK();
    }

    public int getN() {
        return this.f14571a.getN();
    }

    public l getP() {
        return this.f14571a.getP();
    }

    public m[] getQInv() {
        return this.f14571a.getQInv();
    }

    public int getT() {
        return this.f14571a.getGoppaPoly().getDegree();
    }

    public int hashCode() {
        return (((((((((this.f14571a.getK() * 37) + this.f14571a.getN()) * 37) + this.f14571a.getField().hashCode()) * 37) + this.f14571a.getGoppaPoly().hashCode()) * 37) + this.f14571a.getP().hashCode()) * 37) + this.f14571a.getH().hashCode();
    }
}
