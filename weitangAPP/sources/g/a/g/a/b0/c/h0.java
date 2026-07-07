package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class h0 extends i.c {
    public h0(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public h0(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i add(g.a.g.a.i iVar) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (isInfinity()) {
            return iVar;
        }
        if (iVar.isInfinity()) {
            return this;
        }
        if (this == iVar) {
            return twice();
        }
        g.a.g.a.e curve = getCurve();
        g0 g0Var = (g0) this.f14127c;
        g0 g0Var2 = (g0) this.f14128d;
        g0 g0Var3 = (g0) iVar.getXCoord();
        g0 g0Var4 = (g0) iVar.getYCoord();
        g0 g0Var5 = (g0) this.f14129e[0];
        g0 g0Var6 = (g0) iVar.getZCoord(0);
        int[] iArrCreateExt = g.a.g.c.h.createExt();
        int[] iArrCreate = g.a.g.c.h.create();
        int[] iArrCreate2 = g.a.g.c.h.create();
        int[] iArrCreate3 = g.a.g.c.h.create();
        boolean zIsOne = g0Var5.isOne();
        if (zIsOne) {
            iArr = g0Var3.f13954h;
            iArr2 = g0Var4.f13954h;
        } else {
            f0.square(g0Var5.f13954h, iArrCreate2);
            f0.multiply(iArrCreate2, g0Var3.f13954h, iArrCreate);
            f0.multiply(iArrCreate2, g0Var5.f13954h, iArrCreate2);
            f0.multiply(iArrCreate2, g0Var4.f13954h, iArrCreate2);
            iArr = iArrCreate;
            iArr2 = iArrCreate2;
        }
        boolean zIsOne2 = g0Var6.isOne();
        if (zIsOne2) {
            iArr3 = g0Var.f13954h;
            iArr4 = g0Var2.f13954h;
        } else {
            f0.square(g0Var6.f13954h, iArrCreate3);
            f0.multiply(iArrCreate3, g0Var.f13954h, iArrCreateExt);
            f0.multiply(iArrCreate3, g0Var6.f13954h, iArrCreate3);
            f0.multiply(iArrCreate3, g0Var2.f13954h, iArrCreate3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrCreate3;
        }
        int[] iArrCreate4 = g.a.g.c.h.create();
        f0.subtract(iArr3, iArr, iArrCreate4);
        f0.subtract(iArr4, iArr2, iArrCreate);
        if (g.a.g.c.h.isZero(iArrCreate4)) {
            return g.a.g.c.h.isZero(iArrCreate) ? twice() : curve.getInfinity();
        }
        f0.square(iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = g.a.g.c.h.create();
        f0.multiply(iArrCreate2, iArrCreate4, iArrCreate5);
        f0.multiply(iArrCreate2, iArr3, iArrCreate2);
        f0.negate(iArrCreate5, iArrCreate5);
        g.a.g.c.h.mul(iArr4, iArrCreate5, iArrCreateExt);
        f0.reduce32(g.a.g.c.h.addBothTo(iArrCreate2, iArrCreate2, iArrCreate5), iArrCreate5);
        g0 g0Var7 = new g0(iArrCreate3);
        f0.square(iArrCreate, g0Var7.f13954h);
        int[] iArr5 = g0Var7.f13954h;
        f0.subtract(iArr5, iArrCreate5, iArr5);
        g0 g0Var8 = new g0(iArrCreate5);
        f0.subtract(iArrCreate2, g0Var7.f13954h, g0Var8.f13954h);
        f0.multiplyAddToExt(g0Var8.f13954h, iArrCreate, iArrCreateExt);
        f0.reduce(iArrCreateExt, g0Var8.f13954h);
        g0 g0Var9 = new g0(iArrCreate4);
        if (!zIsOne) {
            int[] iArr6 = g0Var9.f13954h;
            f0.multiply(iArr6, g0Var5.f13954h, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = g0Var9.f13954h;
            f0.multiply(iArr7, g0Var6.f13954h, iArr7);
        }
        return new h0(curve, g0Var7, g0Var8, new g.a.g.a.f[]{g0Var9});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new h0(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i negate() {
        return isInfinity() ? this : new h0(this.f14126b, this.f14127c, this.f14128d.negate(), this.f14129e);
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i threeTimes() {
        return (isInfinity() || this.f14128d.isZero()) ? this : twice().add(this);
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twice() {
        if (isInfinity()) {
            return this;
        }
        g.a.g.a.e curve = getCurve();
        g0 g0Var = (g0) this.f14128d;
        if (g0Var.isZero()) {
            return curve.getInfinity();
        }
        g0 g0Var2 = (g0) this.f14127c;
        g0 g0Var3 = (g0) this.f14129e[0];
        int[] iArrCreate = g.a.g.c.h.create();
        f0.square(g0Var.f13954h, iArrCreate);
        int[] iArrCreate2 = g.a.g.c.h.create();
        f0.square(iArrCreate, iArrCreate2);
        int[] iArrCreate3 = g.a.g.c.h.create();
        f0.square(g0Var2.f13954h, iArrCreate3);
        f0.reduce32(g.a.g.c.h.addBothTo(iArrCreate3, iArrCreate3, iArrCreate3), iArrCreate3);
        f0.multiply(iArrCreate, g0Var2.f13954h, iArrCreate);
        f0.reduce32(g.a.g.c.n.shiftUpBits(8, iArrCreate, 2, 0), iArrCreate);
        int[] iArrCreate4 = g.a.g.c.h.create();
        f0.reduce32(g.a.g.c.n.shiftUpBits(8, iArrCreate2, 3, 0, iArrCreate4), iArrCreate4);
        g0 g0Var4 = new g0(iArrCreate2);
        f0.square(iArrCreate3, g0Var4.f13954h);
        int[] iArr = g0Var4.f13954h;
        f0.subtract(iArr, iArrCreate, iArr);
        int[] iArr2 = g0Var4.f13954h;
        f0.subtract(iArr2, iArrCreate, iArr2);
        g0 g0Var5 = new g0(iArrCreate);
        f0.subtract(iArrCreate, g0Var4.f13954h, g0Var5.f13954h);
        int[] iArr3 = g0Var5.f13954h;
        f0.multiply(iArr3, iArrCreate3, iArr3);
        int[] iArr4 = g0Var5.f13954h;
        f0.subtract(iArr4, iArrCreate4, iArr4);
        g0 g0Var6 = new g0(iArrCreate3);
        f0.twice(g0Var.f13954h, g0Var6.f13954h);
        if (!g0Var3.isOne()) {
            int[] iArr5 = g0Var6.f13954h;
            f0.multiply(iArr5, g0Var3.f13954h, iArr5);
        }
        return new h0(curve, g0Var4, g0Var5, new g.a.g.a.f[]{g0Var6});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twicePlus(g.a.g.a.i iVar) {
        return this == iVar ? threeTimes() : isInfinity() ? iVar : iVar.isInfinity() ? twice() : this.f14128d.isZero() ? iVar : twice().add(iVar);
    }
}
