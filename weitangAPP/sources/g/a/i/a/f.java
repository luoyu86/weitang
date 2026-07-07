package g.a.i.a;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;
import g.a.a.v;
import g.a.a.w;
import g.a.a.x1;

/* JADX INFO: loaded from: classes3.dex */
public class f extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f14246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f14247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[][] f14248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f14249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[][] f14250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f14251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f14252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g.a.i.b.f.a[] f14253h;

    public f(d0 d0Var) {
        int i2 = 0;
        if (d0Var.getObjectAt(0) instanceof q) {
            this.f14246a = q.getInstance(d0Var.getObjectAt(0));
        } else {
            this.f14247b = v.getInstance(d0Var.getObjectAt(0));
        }
        d0 d0Var2 = (d0) d0Var.getObjectAt(1);
        this.f14248c = new byte[d0Var2.size()][];
        for (int i3 = 0; i3 < d0Var2.size(); i3++) {
            this.f14248c[i3] = ((w) d0Var2.getObjectAt(i3)).getOctets();
        }
        this.f14249d = ((w) ((d0) d0Var.getObjectAt(2)).getObjectAt(0)).getOctets();
        d0 d0Var3 = (d0) d0Var.getObjectAt(3);
        this.f14250e = new byte[d0Var3.size()][];
        for (int i4 = 0; i4 < d0Var3.size(); i4++) {
            this.f14250e[i4] = ((w) d0Var3.getObjectAt(i4)).getOctets();
        }
        this.f14251f = ((w) ((d0) d0Var.getObjectAt(4)).getObjectAt(0)).getOctets();
        this.f14252g = ((w) ((d0) d0Var.getObjectAt(5)).getObjectAt(0)).getOctets();
        d0 d0Var4 = (d0) d0Var.getObjectAt(6);
        byte[][][][] bArr = new byte[d0Var4.size()][][][];
        byte[][][][] bArr2 = new byte[d0Var4.size()][][][];
        byte[][][] bArr3 = new byte[d0Var4.size()][][];
        byte[][] bArr4 = new byte[d0Var4.size()][];
        int i5 = 0;
        while (i5 < d0Var4.size()) {
            d0 d0Var5 = (d0) d0Var4.getObjectAt(i5);
            d0 d0Var6 = (d0) d0Var5.getObjectAt(i2);
            bArr[i5] = new byte[d0Var6.size()][][];
            for (int i6 = 0; i6 < d0Var6.size(); i6++) {
                d0 d0Var7 = (d0) d0Var6.getObjectAt(i6);
                bArr[i5][i6] = new byte[d0Var7.size()][];
                for (int i7 = 0; i7 < d0Var7.size(); i7++) {
                    bArr[i5][i6][i7] = ((w) d0Var7.getObjectAt(i7)).getOctets();
                }
            }
            d0 d0Var8 = (d0) d0Var5.getObjectAt(1);
            bArr2[i5] = new byte[d0Var8.size()][][];
            for (int i8 = 0; i8 < d0Var8.size(); i8++) {
                d0 d0Var9 = (d0) d0Var8.getObjectAt(i8);
                bArr2[i5][i8] = new byte[d0Var9.size()][];
                for (int i9 = 0; i9 < d0Var9.size(); i9++) {
                    bArr2[i5][i8][i9] = ((w) d0Var9.getObjectAt(i9)).getOctets();
                }
            }
            d0 d0Var10 = (d0) d0Var5.getObjectAt(2);
            bArr3[i5] = new byte[d0Var10.size()][];
            for (int i10 = 0; i10 < d0Var10.size(); i10++) {
                bArr3[i5][i10] = ((w) d0Var10.getObjectAt(i10)).getOctets();
            }
            bArr4[i5] = ((w) d0Var5.getObjectAt(3)).getOctets();
            i5++;
            i2 = 0;
        }
        int length = this.f14252g.length - 1;
        this.f14253h = new g.a.i.b.f.a[length];
        int i11 = 0;
        while (i11 < length) {
            byte[] bArr5 = this.f14252g;
            int i12 = i11 + 1;
            this.f14253h[i11] = new g.a.i.b.f.a(bArr5[i11], bArr5[i12], g.a.i.b.f.e.b.convertArray(bArr[i11]), g.a.i.b.f.e.b.convertArray(bArr2[i11]), g.a.i.b.f.e.b.convertArray(bArr3[i11]), g.a.i.b.f.e.b.convertArray(bArr4[i11]));
            i11 = i12;
        }
    }

    public f(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, g.a.i.b.f.a[] aVarArr) {
        this.f14246a = new q(1L);
        this.f14248c = g.a.i.b.f.e.b.convertArray(sArr);
        this.f14249d = g.a.i.b.f.e.b.convertArray(sArr2);
        this.f14250e = g.a.i.b.f.e.b.convertArray(sArr3);
        this.f14251f = g.a.i.b.f.e.b.convertArray(sArr4);
        this.f14252g = g.a.i.b.f.e.b.convertIntArray(iArr);
        this.f14253h = aVarArr;
    }

    public static f getInstance(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(d0.getInstance(obj));
        }
        return null;
    }

    public short[] getB1() {
        return g.a.i.b.f.e.b.convertArray(this.f14249d);
    }

    public short[] getB2() {
        return g.a.i.b.f.e.b.convertArray(this.f14251f);
    }

    public short[][] getInvA1() {
        return g.a.i.b.f.e.b.convertArray(this.f14248c);
    }

    public short[][] getInvA2() {
        return g.a.i.b.f.e.b.convertArray(this.f14250e);
    }

    public g.a.i.b.f.a[] getLayers() {
        return this.f14253h;
    }

    public q getVersion() {
        return this.f14246a;
    }

    public int[] getVi() {
        return g.a.i.b.f.e.b.convertArraytoInt(this.f14252g);
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        g.a.a.g gVar = this.f14246a;
        if (gVar == null) {
            gVar = this.f14247b;
        }
        hVar.add(gVar);
        g.a.a.h hVar2 = new g.a.a.h();
        for (int i2 = 0; i2 < this.f14248c.length; i2++) {
            hVar2.add(new x1(this.f14248c[i2]));
        }
        hVar.add(new b2(hVar2));
        g.a.a.h hVar3 = new g.a.a.h();
        hVar3.add(new x1(this.f14249d));
        hVar.add(new b2(hVar3));
        g.a.a.h hVar4 = new g.a.a.h();
        for (int i3 = 0; i3 < this.f14250e.length; i3++) {
            hVar4.add(new x1(this.f14250e[i3]));
        }
        hVar.add(new b2(hVar4));
        g.a.a.h hVar5 = new g.a.a.h();
        hVar5.add(new x1(this.f14251f));
        hVar.add(new b2(hVar5));
        g.a.a.h hVar6 = new g.a.a.h();
        hVar6.add(new x1(this.f14252g));
        hVar.add(new b2(hVar6));
        g.a.a.h hVar7 = new g.a.a.h();
        for (int i4 = 0; i4 < this.f14253h.length; i4++) {
            g.a.a.h hVar8 = new g.a.a.h();
            byte[][][] bArrConvertArray = g.a.i.b.f.e.b.convertArray(this.f14253h[i4].getCoeffAlpha());
            g.a.a.h hVar9 = new g.a.a.h();
            for (int i5 = 0; i5 < bArrConvertArray.length; i5++) {
                g.a.a.h hVar10 = new g.a.a.h();
                for (int i6 = 0; i6 < bArrConvertArray[i5].length; i6++) {
                    hVar10.add(new x1(bArrConvertArray[i5][i6]));
                }
                hVar9.add(new b2(hVar10));
            }
            hVar8.add(new b2(hVar9));
            byte[][][] bArrConvertArray2 = g.a.i.b.f.e.b.convertArray(this.f14253h[i4].getCoeffBeta());
            g.a.a.h hVar11 = new g.a.a.h();
            for (int i7 = 0; i7 < bArrConvertArray2.length; i7++) {
                g.a.a.h hVar12 = new g.a.a.h();
                for (int i8 = 0; i8 < bArrConvertArray2[i7].length; i8++) {
                    hVar12.add(new x1(bArrConvertArray2[i7][i8]));
                }
                hVar11.add(new b2(hVar12));
            }
            hVar8.add(new b2(hVar11));
            byte[][] bArrConvertArray3 = g.a.i.b.f.e.b.convertArray(this.f14253h[i4].getCoeffGamma());
            g.a.a.h hVar13 = new g.a.a.h();
            for (byte[] bArr : bArrConvertArray3) {
                hVar13.add(new x1(bArr));
            }
            hVar8.add(new b2(hVar13));
            hVar8.add(new x1(g.a.i.b.f.e.b.convertArray(this.f14253h[i4].getCoeffEta())));
            hVar7.add(new b2(hVar8));
        }
        hVar.add(new b2(hVar7));
        return new b2(hVar);
    }
}
