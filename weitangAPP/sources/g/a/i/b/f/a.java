package g.a.i.b.f;

import java.lang.reflect.Array;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short[][][] f14404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public short[][][] f14405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public short[][] f14406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public short[] f14407g;

    public a(byte b2, byte b3, short[][][] sArr, short[][][] sArr2, short[][] sArr3, short[] sArr4) {
        int i2 = b2 & 255;
        this.f14401a = i2;
        int i3 = b3 & 255;
        this.f14402b = i3;
        this.f14403c = i3 - i2;
        this.f14404d = sArr;
        this.f14405e = sArr2;
        this.f14406f = sArr3;
        this.f14407g = sArr4;
    }

    public a(int i2, int i3, SecureRandom secureRandom) {
        this.f14401a = i2;
        this.f14402b = i3;
        int i4 = i3 - i2;
        this.f14403c = i4;
        this.f14404d = (short[][][]) Array.newInstance((Class<?>) short.class, i4, i4, i2);
        int i5 = this.f14403c;
        int i6 = this.f14401a;
        this.f14405e = (short[][][]) Array.newInstance((Class<?>) short.class, i5, i6, i6);
        this.f14406f = (short[][]) Array.newInstance((Class<?>) short.class, this.f14403c, this.f14402b);
        int i7 = this.f14403c;
        this.f14407g = new short[i7];
        for (int i8 = 0; i8 < i7; i8++) {
            for (int i9 = 0; i9 < this.f14403c; i9++) {
                for (int i10 = 0; i10 < this.f14401a; i10++) {
                    this.f14404d[i8][i9][i10] = (short) (secureRandom.nextInt() & 255);
                }
            }
        }
        for (int i11 = 0; i11 < i7; i11++) {
            for (int i12 = 0; i12 < this.f14401a; i12++) {
                for (int i13 = 0; i13 < this.f14401a; i13++) {
                    this.f14405e[i11][i12][i13] = (short) (secureRandom.nextInt() & 255);
                }
            }
        }
        for (int i14 = 0; i14 < i7; i14++) {
            for (int i15 = 0; i15 < this.f14402b; i15++) {
                this.f14406f[i14][i15] = (short) (secureRandom.nextInt() & 255);
            }
        }
        for (int i16 = 0; i16 < i7; i16++) {
            this.f14407g[i16] = (short) (secureRandom.nextInt() & 255);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f14401a == aVar.getVi() && this.f14402b == aVar.getViNext() && this.f14403c == aVar.getOi() && g.a.i.b.f.e.b.equals(this.f14404d, aVar.getCoeffAlpha()) && g.a.i.b.f.e.b.equals(this.f14405e, aVar.getCoeffBeta()) && g.a.i.b.f.e.b.equals(this.f14406f, aVar.getCoeffGamma()) && g.a.i.b.f.e.b.equals(this.f14407g, aVar.getCoeffEta());
    }

    public short[][][] getCoeffAlpha() {
        return this.f14404d;
    }

    public short[][][] getCoeffBeta() {
        return this.f14405e;
    }

    public short[] getCoeffEta() {
        return this.f14407g;
    }

    public short[][] getCoeffGamma() {
        return this.f14406f;
    }

    public int getOi() {
        return this.f14403c;
    }

    public int getVi() {
        return this.f14401a;
    }

    public int getViNext() {
        return this.f14402b;
    }

    public int hashCode() {
        return (((((((((((this.f14401a * 37) + this.f14402b) * 37) + this.f14403c) * 37) + g.a.j.a.hashCode(this.f14404d)) * 37) + g.a.j.a.hashCode(this.f14405e)) * 37) + g.a.j.a.hashCode(this.f14406f)) * 37) + g.a.j.a.hashCode(this.f14407g);
    }

    public short[][] plugInVinegars(short[] sArr) {
        int i2 = this.f14403c;
        int i3 = 0;
        short[][] sArr2 = (short[][]) Array.newInstance((Class<?>) short.class, i2, i2 + 1);
        short[] sArr3 = new short[this.f14403c];
        for (int i4 = 0; i4 < this.f14403c; i4++) {
            for (int i5 = 0; i5 < this.f14401a; i5++) {
                for (int i6 = 0; i6 < this.f14401a; i6++) {
                    sArr3[i4] = g.a.i.b.f.e.a.addElem(sArr3[i4], g.a.i.b.f.e.a.multElem(g.a.i.b.f.e.a.multElem(this.f14405e[i4][i5][i6], sArr[i5]), sArr[i6]));
                }
            }
        }
        for (int i7 = 0; i7 < this.f14403c; i7++) {
            for (int i8 = 0; i8 < this.f14403c; i8++) {
                for (int i9 = 0; i9 < this.f14401a; i9++) {
                    sArr2[i7][i8] = g.a.i.b.f.e.a.addElem(sArr2[i7][i8], g.a.i.b.f.e.a.multElem(this.f14404d[i7][i8][i9], sArr[i9]));
                }
            }
        }
        for (int i10 = 0; i10 < this.f14403c; i10++) {
            for (int i11 = 0; i11 < this.f14401a; i11++) {
                sArr3[i10] = g.a.i.b.f.e.a.addElem(sArr3[i10], g.a.i.b.f.e.a.multElem(this.f14406f[i10][i11], sArr[i11]));
            }
        }
        for (int i12 = 0; i12 < this.f14403c; i12++) {
            for (int i13 = this.f14401a; i13 < this.f14402b; i13++) {
                short[] sArr4 = sArr2[i12];
                int i14 = this.f14401a;
                sArr4[i13 - i14] = g.a.i.b.f.e.a.addElem(this.f14406f[i12][i13], sArr2[i12][i13 - i14]);
            }
        }
        for (int i15 = 0; i15 < this.f14403c; i15++) {
            sArr3[i15] = g.a.i.b.f.e.a.addElem(sArr3[i15], this.f14407g[i15]);
        }
        while (true) {
            int i16 = this.f14403c;
            if (i3 >= i16) {
                return sArr2;
            }
            sArr2[i3][i16] = sArr3[i3];
            i3++;
        }
    }
}
