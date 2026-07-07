package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class d0 extends i.c {
    public d0(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public d0(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
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
        c0 c0Var = (c0) this.f14127c;
        c0 c0Var2 = (c0) this.f14128d;
        c0 c0Var3 = (c0) iVar.getXCoord();
        c0 c0Var4 = (c0) iVar.getYCoord();
        c0 c0Var5 = (c0) this.f14129e[0];
        c0 c0Var6 = (c0) iVar.getZCoord(0);
        int[] iArrCreateExt = g.a.g.c.g.createExt();
        int[] iArrCreate = g.a.g.c.g.create();
        int[] iArrCreate2 = g.a.g.c.g.create();
        int[] iArrCreate3 = g.a.g.c.g.create();
        boolean zIsOne = c0Var5.isOne();
        if (zIsOne) {
            iArr = c0Var3.f13926h;
            iArr2 = c0Var4.f13926h;
        } else {
            b0.square(c0Var5.f13926h, iArrCreate2);
            b0.multiply(iArrCreate2, c0Var3.f13926h, iArrCreate);
            b0.multiply(iArrCreate2, c0Var5.f13926h, iArrCreate2);
            b0.multiply(iArrCreate2, c0Var4.f13926h, iArrCreate2);
            iArr = iArrCreate;
            iArr2 = iArrCreate2;
        }
        boolean zIsOne2 = c0Var6.isOne();
        if (zIsOne2) {
            iArr3 = c0Var.f13926h;
            iArr4 = c0Var2.f13926h;
        } else {
            b0.square(c0Var6.f13926h, iArrCreate3);
            b0.multiply(iArrCreate3, c0Var.f13926h, iArrCreateExt);
            b0.multiply(iArrCreate3, c0Var6.f13926h, iArrCreate3);
            b0.multiply(iArrCreate3, c0Var2.f13926h, iArrCreate3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrCreate3;
        }
        int[] iArrCreate4 = g.a.g.c.g.create();
        b0.subtract(iArr3, iArr, iArrCreate4);
        b0.subtract(iArr4, iArr2, iArrCreate);
        if (g.a.g.c.g.isZero(iArrCreate4)) {
            return g.a.g.c.g.isZero(iArrCreate) ? twice() : curve.getInfinity();
        }
        b0.square(iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = g.a.g.c.g.create();
        b0.multiply(iArrCreate2, iArrCreate4, iArrCreate5);
        b0.multiply(iArrCreate2, iArr3, iArrCreate2);
        b0.negate(iArrCreate5, iArrCreate5);
        g.a.g.c.g.mul(iArr4, iArrCreate5, iArrCreateExt);
        b0.reduce32(g.a.g.c.g.addBothTo(iArrCreate2, iArrCreate2, iArrCreate5), iArrCreate5);
        c0 c0Var7 = new c0(iArrCreate3);
        b0.square(iArrCreate, c0Var7.f13926h);
        int[] iArr5 = c0Var7.f13926h;
        b0.subtract(iArr5, iArrCreate5, iArr5);
        c0 c0Var8 = new c0(iArrCreate5);
        b0.subtract(iArrCreate2, c0Var7.f13926h, c0Var8.f13926h);
        b0.multiplyAddToExt(c0Var8.f13926h, iArrCreate, iArrCreateExt);
        b0.reduce(iArrCreateExt, c0Var8.f13926h);
        c0 c0Var9 = new c0(iArrCreate4);
        if (!zIsOne) {
            int[] iArr6 = c0Var9.f13926h;
            b0.multiply(iArr6, c0Var5.f13926h, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = c0Var9.f13926h;
            b0.multiply(iArr7, c0Var6.f13926h, iArr7);
        }
        return new d0(curve, c0Var7, c0Var8, new g.a.g.a.f[]{c0Var9});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new d0(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i negate() {
        return isInfinity() ? this : new d0(this.f14126b, this.f14127c, this.f14128d.negate(), this.f14129e);
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
        c0 c0Var = (c0) this.f14128d;
        if (c0Var.isZero()) {
            return curve.getInfinity();
        }
        c0 c0Var2 = (c0) this.f14127c;
        c0 c0Var3 = (c0) this.f14129e[0];
        int[] iArrCreate = g.a.g.c.g.create();
        int[] iArrCreate2 = g.a.g.c.g.create();
        int[] iArrCreate3 = g.a.g.c.g.create();
        b0.square(c0Var.f13926h, iArrCreate3);
        int[] iArrCreate4 = g.a.g.c.g.create();
        b0.square(iArrCreate3, iArrCreate4);
        boolean zIsOne = c0Var3.isOne();
        int[] iArr = c0Var3.f13926h;
        if (!zIsOne) {
            b0.square(iArr, iArrCreate2);
            iArr = iArrCreate2;
        }
        b0.subtract(c0Var2.f13926h, iArr, iArrCreate);
        b0.add(c0Var2.f13926h, iArr, iArrCreate2);
        b0.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        b0.reduce32(g.a.g.c.g.addBothTo(iArrCreate2, iArrCreate2, iArrCreate2), iArrCreate2);
        b0.multiply(iArrCreate3, c0Var2.f13926h, iArrCreate3);
        b0.reduce32(g.a.g.c.n.shiftUpBits(7, iArrCreate3, 2, 0), iArrCreate3);
        b0.reduce32(g.a.g.c.n.shiftUpBits(7, iArrCreate4, 3, 0, iArrCreate), iArrCreate);
        c0 c0Var4 = new c0(iArrCreate4);
        b0.square(iArrCreate2, c0Var4.f13926h);
        int[] iArr2 = c0Var4.f13926h;
        b0.subtract(iArr2, iArrCreate3, iArr2);
        int[] iArr3 = c0Var4.f13926h;
        b0.subtract(iArr3, iArrCreate3, iArr3);
        c0 c0Var5 = new c0(iArrCreate3);
        b0.subtract(iArrCreate3, c0Var4.f13926h, c0Var5.f13926h);
        int[] iArr4 = c0Var5.f13926h;
        b0.multiply(iArr4, iArrCreate2, iArr4);
        int[] iArr5 = c0Var5.f13926h;
        b0.subtract(iArr5, iArrCreate, iArr5);
        c0 c0Var6 = new c0(iArrCreate2);
        b0.twice(c0Var.f13926h, c0Var6.f13926h);
        if (!zIsOne) {
            int[] iArr6 = c0Var6.f13926h;
            b0.multiply(iArr6, c0Var3.f13926h, iArr6);
        }
        return new d0(curve, c0Var4, c0Var5, new g.a.g.a.f[]{c0Var6});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twicePlus(g.a.g.a.i iVar) {
        return this == iVar ? threeTimes() : isInfinity() ? iVar : iVar.isInfinity() ? twice() : this.f14128d.isZero() ? iVar : twice().add(iVar);
    }
}
