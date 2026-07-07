package g.a.i.c.b.e;

import g.a.a.v1;
import g.a.i.a.e;
import g.a.i.a.g;
import g.a.i.b.f.d;
import java.security.PublicKey;

/* JADX INFO: loaded from: classes3.dex */
public class b implements PublicKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[][] f14587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public short[][] f14588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short[] f14589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14590d;

    public b(int i2, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f14590d = i2;
        this.f14587a = sArr;
        this.f14588b = sArr2;
        this.f14589c = sArr3;
    }

    public b(d dVar) {
        this(dVar.getDocLength(), dVar.getCoeffQuadratic(), dVar.getCoeffSingular(), dVar.getCoeffScalar());
    }

    public b(g.a.i.c.c.c cVar) {
        this(cVar.getDocLength(), cVar.getCoeffQuadratic(), cVar.getCoeffSingular(), cVar.getCoeffScalar());
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14590d == bVar.getDocLength() && g.a.i.b.f.e.b.equals(this.f14587a, bVar.getCoeffQuadratic()) && g.a.i.b.f.e.b.equals(this.f14588b, bVar.getCoeffSingular()) && g.a.i.b.f.e.b.equals(this.f14589c, bVar.getCoeffScalar());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    public short[][] getCoeffQuadratic() {
        return this.f14587a;
    }

    public short[] getCoeffScalar() {
        return g.a.j.a.clone(this.f14589c);
    }

    public short[][] getCoeffSingular() {
        short[][] sArr = new short[this.f14588b.length][];
        int i2 = 0;
        while (true) {
            short[][] sArr2 = this.f14588b;
            if (i2 == sArr2.length) {
                return sArr;
            }
            sArr[i2] = g.a.j.a.clone(sArr2[i2]);
            i2++;
        }
    }

    public int getDocLength() {
        return this.f14590d;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return g.a.i.c.b.g.a.getEncodedSubjectPublicKeyInfo(new g.a.a.y3.a(e.f14236a, v1.f13368b), new g(this.f14590d, this.f14587a, this.f14588b, this.f14589c));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        return (((((this.f14590d * 37) + g.a.j.a.hashCode(this.f14587a)) * 37) + g.a.j.a.hashCode(this.f14588b)) * 37) + g.a.j.a.hashCode(this.f14589c);
    }
}
