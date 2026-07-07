package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class l0 extends i.c {
    public l0(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public l0(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
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
        k0 k0Var = (k0) this.f14127c;
        k0 k0Var2 = (k0) this.f14128d;
        k0 k0Var3 = (k0) iVar.getXCoord();
        k0 k0Var4 = (k0) iVar.getYCoord();
        k0 k0Var5 = (k0) this.f14129e[0];
        k0 k0Var6 = (k0) iVar.getZCoord(0);
        int[] iArrCreateExt = g.a.g.c.h.createExt();
        int[] iArrCreate = g.a.g.c.h.create();
        int[] iArrCreate2 = g.a.g.c.h.create();
        int[] iArrCreate3 = g.a.g.c.h.create();
        boolean zIsOne = k0Var5.isOne();
        if (zIsOne) {
            iArr = k0Var3.f13982h;
            iArr2 = k0Var4.f13982h;
        } else {
            j0.square(k0Var5.f13982h, iArrCreate2);
            j0.multiply(iArrCreate2, k0Var3.f13982h, iArrCreate);
            j0.multiply(iArrCreate2, k0Var5.f13982h, iArrCreate2);
            j0.multiply(iArrCreate2, k0Var4.f13982h, iArrCreate2);
            iArr = iArrCreate;
            iArr2 = iArrCreate2;
        }
        boolean zIsOne2 = k0Var6.isOne();
        if (zIsOne2) {
            iArr3 = k0Var.f13982h;
            iArr4 = k0Var2.f13982h;
        } else {
            j0.square(k0Var6.f13982h, iArrCreate3);
            j0.multiply(iArrCreate3, k0Var.f13982h, iArrCreateExt);
            j0.multiply(iArrCreate3, k0Var6.f13982h, iArrCreate3);
            j0.multiply(iArrCreate3, k0Var2.f13982h, iArrCreate3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrCreate3;
        }
        int[] iArrCreate4 = g.a.g.c.h.create();
        j0.subtract(iArr3, iArr, iArrCreate4);
        j0.subtract(iArr4, iArr2, iArrCreate);
        if (g.a.g.c.h.isZero(iArrCreate4)) {
            return g.a.g.c.h.isZero(iArrCreate) ? twice() : curve.getInfinity();
        }
        j0.square(iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = g.a.g.c.h.create();
        j0.multiply(iArrCreate2, iArrCreate4, iArrCreate5);
        j0.multiply(iArrCreate2, iArr3, iArrCreate2);
        j0.negate(iArrCreate5, iArrCreate5);
        g.a.g.c.h.mul(iArr4, iArrCreate5, iArrCreateExt);
        j0.reduce32(g.a.g.c.h.addBothTo(iArrCreate2, iArrCreate2, iArrCreate5), iArrCreate5);
        k0 k0Var7 = new k0(iArrCreate3);
        j0.square(iArrCreate, k0Var7.f13982h);
        int[] iArr5 = k0Var7.f13982h;
        j0.subtract(iArr5, iArrCreate5, iArr5);
        k0 k0Var8 = new k0(iArrCreate5);
        j0.subtract(iArrCreate2, k0Var7.f13982h, k0Var8.f13982h);
        j0.multiplyAddToExt(k0Var8.f13982h, iArrCreate, iArrCreateExt);
        j0.reduce(iArrCreateExt, k0Var8.f13982h);
        k0 k0Var9 = new k0(iArrCreate4);
        if (!zIsOne) {
            int[] iArr6 = k0Var9.f13982h;
            j0.multiply(iArr6, k0Var5.f13982h, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = k0Var9.f13982h;
            j0.multiply(iArr7, k0Var6.f13982h, iArr7);
        }
        return new l0(curve, k0Var7, k0Var8, new g.a.g.a.f[]{k0Var9});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new l0(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i negate() {
        return isInfinity() ? this : new l0(this.f14126b, this.f14127c, this.f14128d.negate(), this.f14129e);
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
        k0 k0Var = (k0) this.f14128d;
        if (k0Var.isZero()) {
            return curve.getInfinity();
        }
        k0 k0Var2 = (k0) this.f14127c;
        k0 k0Var3 = (k0) this.f14129e[0];
        int[] iArrCreate = g.a.g.c.h.create();
        int[] iArrCreate2 = g.a.g.c.h.create();
        int[] iArrCreate3 = g.a.g.c.h.create();
        j0.square(k0Var.f13982h, iArrCreate3);
        int[] iArrCreate4 = g.a.g.c.h.create();
        j0.square(iArrCreate3, iArrCreate4);
        boolean zIsOne = k0Var3.isOne();
        int[] iArr = k0Var3.f13982h;
        if (!zIsOne) {
            j0.square(iArr, iArrCreate2);
            iArr = iArrCreate2;
        }
        j0.subtract(k0Var2.f13982h, iArr, iArrCreate);
        j0.add(k0Var2.f13982h, iArr, iArrCreate2);
        j0.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        j0.reduce32(g.a.g.c.h.addBothTo(iArrCreate2, iArrCreate2, iArrCreate2), iArrCreate2);
        j0.multiply(iArrCreate3, k0Var2.f13982h, iArrCreate3);
        j0.reduce32(g.a.g.c.n.shiftUpBits(8, iArrCreate3, 2, 0), iArrCreate3);
        j0.reduce32(g.a.g.c.n.shiftUpBits(8, iArrCreate4, 3, 0, iArrCreate), iArrCreate);
        k0 k0Var4 = new k0(iArrCreate4);
        j0.square(iArrCreate2, k0Var4.f13982h);
        int[] iArr2 = k0Var4.f13982h;
        j0.subtract(iArr2, iArrCreate3, iArr2);
        int[] iArr3 = k0Var4.f13982h;
        j0.subtract(iArr3, iArrCreate3, iArr3);
        k0 k0Var5 = new k0(iArrCreate3);
        j0.subtract(iArrCreate3, k0Var4.f13982h, k0Var5.f13982h);
        int[] iArr4 = k0Var5.f13982h;
        j0.multiply(iArr4, iArrCreate2, iArr4);
        int[] iArr5 = k0Var5.f13982h;
        j0.subtract(iArr5, iArrCreate, iArr5);
        k0 k0Var6 = new k0(iArrCreate2);
        j0.twice(k0Var.f13982h, k0Var6.f13982h);
        if (!zIsOne) {
            int[] iArr6 = k0Var6.f13982h;
            j0.multiply(iArr6, k0Var3.f13982h, iArr6);
        }
        return new l0(curve, k0Var4, k0Var5, new g.a.g.a.f[]{k0Var6});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twicePlus(g.a.g.a.i iVar) {
        return this == iVar ? threeTimes() : isInfinity() ? iVar : iVar.isInfinity() ? twice() : this.f14128d.isZero() ? iVar : twice().add(iVar);
    }
}
