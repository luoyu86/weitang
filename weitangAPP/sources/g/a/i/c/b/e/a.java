package g.a.i.c.b.e;

import g.a.a.v1;
import g.a.i.a.e;
import g.a.i.a.f;
import java.io.IOException;
import java.security.PrivateKey;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class a implements PrivateKey {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short[][] f14581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public short[] f14582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public short[][] f14583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short[] f14584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g.a.i.b.f.a[] f14585e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int[] f14586f;

    public a(g.a.i.b.f.c cVar) {
        this(cVar.getInvA1(), cVar.getB1(), cVar.getInvA2(), cVar.getB2(), cVar.getVi(), cVar.getLayers());
    }

    public a(g.a.i.c.c.b bVar) {
        this(bVar.getInvA1(), bVar.getB1(), bVar.getInvA2(), bVar.getB2(), bVar.getVi(), bVar.getLayers());
    }

    public a(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, g.a.i.b.f.a[] aVarArr) {
        this.f14581a = sArr;
        this.f14582b = sArr2;
        this.f14583c = sArr3;
        this.f14584d = sArr4;
        this.f14586f = iArr;
        this.f14585e = aVarArr;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        boolean zEquals = ((((g.a.i.b.f.e.b.equals(this.f14581a, aVar.getInvA1())) && g.a.i.b.f.e.b.equals(this.f14583c, aVar.getInvA2())) && g.a.i.b.f.e.b.equals(this.f14582b, aVar.getB1())) && g.a.i.b.f.e.b.equals(this.f14584d, aVar.getB2())) && Arrays.equals(this.f14586f, aVar.getVi());
        if (this.f14585e.length != aVar.getLayers().length) {
            return false;
        }
        for (int length = this.f14585e.length - 1; length >= 0; length--) {
            zEquals &= this.f14585e[length].equals(aVar.getLayers()[length]);
        }
        return zEquals;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Rainbow";
    }

    public short[] getB1() {
        return this.f14582b;
    }

    public short[] getB2() {
        return this.f14584d;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new g.a.a.t3.b(new g.a.a.y3.a(e.f14236a, v1.f13368b), new f(this.f14581a, this.f14582b, this.f14583c, this.f14584d, this.f14586f, this.f14585e)).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public short[][] getInvA1() {
        return this.f14581a;
    }

    public short[][] getInvA2() {
        return this.f14583c;
    }

    public g.a.i.b.f.a[] getLayers() {
        return this.f14585e;
    }

    public int[] getVi() {
        return this.f14586f;
    }

    public int hashCode() {
        int length = (((((((((this.f14585e.length * 37) + g.a.j.a.hashCode(this.f14581a)) * 37) + g.a.j.a.hashCode(this.f14582b)) * 37) + g.a.j.a.hashCode(this.f14583c)) * 37) + g.a.j.a.hashCode(this.f14584d)) * 37) + g.a.j.a.hashCode(this.f14586f);
        for (int length2 = this.f14585e.length - 1; length2 >= 0; length2--) {
            length = (length * 37) + this.f14585e[length2].hashCode();
        }
        return length;
    }
}
