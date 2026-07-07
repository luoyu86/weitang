package g.a.g.b;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f14185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f14186b;

    public d(a aVar, e eVar) {
        this.f14185a = aVar;
        this.f14186b = eVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f14185a.equals(dVar.f14185a) && this.f14186b.equals(dVar.f14186b);
    }

    @Override // g.a.g.b.f, g.a.g.b.a
    public BigInteger getCharacteristic() {
        return this.f14185a.getCharacteristic();
    }

    @Override // g.a.g.b.f
    public int getDegree() {
        return this.f14186b.getDegree();
    }

    @Override // g.a.g.b.f, g.a.g.b.a
    public int getDimension() {
        return this.f14185a.getDimension() * this.f14186b.getDegree();
    }

    @Override // g.a.g.b.f
    public e getMinimalPolynomial() {
        return this.f14186b;
    }

    @Override // g.a.g.b.f
    public a getSubfield() {
        return this.f14185a;
    }

    public int hashCode() {
        return this.f14185a.hashCode() ^ g.a.j.g.rotateLeft(this.f14186b.hashCode(), 16);
    }
}
