package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class p0 extends i.c {
    public p0(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public p0(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
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
        o0 o0Var = (o0) this.f14127c;
        o0 o0Var2 = (o0) this.f14128d;
        o0 o0Var3 = (o0) iVar.getXCoord();
        o0 o0Var4 = (o0) iVar.getYCoord();
        o0 o0Var5 = (o0) this.f14129e[0];
        o0 o0Var6 = (o0) iVar.getZCoord(0);
        int[] iArrCreate = g.a.g.c.n.create(24);
        int[] iArrCreate2 = g.a.g.c.n.create(24);
        int[] iArrCreate3 = g.a.g.c.n.create(12);
        int[] iArrCreate4 = g.a.g.c.n.create(12);
        boolean zIsOne = o0Var5.isOne();
        if (zIsOne) {
            iArr = o0Var3.f14010h;
            iArr2 = o0Var4.f14010h;
        } else {
            n0.square(o0Var5.f14010h, iArrCreate3);
            n0.multiply(iArrCreate3, o0Var3.f14010h, iArrCreate2);
            n0.multiply(iArrCreate3, o0Var5.f14010h, iArrCreate3);
            n0.multiply(iArrCreate3, o0Var4.f14010h, iArrCreate3);
            iArr = iArrCreate2;
            iArr2 = iArrCreate3;
        }
        boolean zIsOne2 = o0Var6.isOne();
        if (zIsOne2) {
            iArr3 = o0Var.f14010h;
            iArr4 = o0Var2.f14010h;
        } else {
            n0.square(o0Var6.f14010h, iArrCreate4);
            n0.multiply(iArrCreate4, o0Var.f14010h, iArrCreate);
            n0.multiply(iArrCreate4, o0Var6.f14010h, iArrCreate4);
            n0.multiply(iArrCreate4, o0Var2.f14010h, iArrCreate4);
            iArr3 = iArrCreate;
            iArr4 = iArrCreate4;
        }
        int[] iArrCreate5 = g.a.g.c.n.create(12);
        n0.subtract(iArr3, iArr, iArrCreate5);
        int[] iArrCreate6 = g.a.g.c.n.create(12);
        n0.subtract(iArr4, iArr2, iArrCreate6);
        if (g.a.g.c.n.isZero(12, iArrCreate5)) {
            return g.a.g.c.n.isZero(12, iArrCreate6) ? twice() : curve.getInfinity();
        }
        n0.square(iArrCreate5, iArrCreate3);
        int[] iArrCreate7 = g.a.g.c.n.create(12);
        n0.multiply(iArrCreate3, iArrCreate5, iArrCreate7);
        n0.multiply(iArrCreate3, iArr3, iArrCreate3);
        n0.negate(iArrCreate7, iArrCreate7);
        g.a.g.c.j.mul(iArr4, iArrCreate7, iArrCreate);
        n0.reduce32(g.a.g.c.n.addBothTo(12, iArrCreate3, iArrCreate3, iArrCreate7), iArrCreate7);
        o0 o0Var7 = new o0(iArrCreate4);
        n0.square(iArrCreate6, o0Var7.f14010h);
        int[] iArr5 = o0Var7.f14010h;
        n0.subtract(iArr5, iArrCreate7, iArr5);
        o0 o0Var8 = new o0(iArrCreate7);
        n0.subtract(iArrCreate3, o0Var7.f14010h, o0Var8.f14010h);
        g.a.g.c.j.mul(o0Var8.f14010h, iArrCreate6, iArrCreate2);
        n0.addExt(iArrCreate, iArrCreate2, iArrCreate);
        n0.reduce(iArrCreate, o0Var8.f14010h);
        o0 o0Var9 = new o0(iArrCreate5);
        if (!zIsOne) {
            int[] iArr6 = o0Var9.f14010h;
            n0.multiply(iArr6, o0Var5.f14010h, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = o0Var9.f14010h;
            n0.multiply(iArr7, o0Var6.f14010h, iArr7);
        }
        return new p0(curve, o0Var7, o0Var8, new g.a.g.a.f[]{o0Var9});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new p0(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i negate() {
        return isInfinity() ? this : new p0(this.f14126b, this.f14127c, this.f14128d.negate(), this.f14129e);
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
        o0 o0Var = (o0) this.f14128d;
        if (o0Var.isZero()) {
            return curve.getInfinity();
        }
        o0 o0Var2 = (o0) this.f14127c;
        o0 o0Var3 = (o0) this.f14129e[0];
        int[] iArrCreate = g.a.g.c.n.create(12);
        int[] iArrCreate2 = g.a.g.c.n.create(12);
        int[] iArrCreate3 = g.a.g.c.n.create(12);
        n0.square(o0Var.f14010h, iArrCreate3);
        int[] iArrCreate4 = g.a.g.c.n.create(12);
        n0.square(iArrCreate3, iArrCreate4);
        boolean zIsOne = o0Var3.isOne();
        int[] iArr = o0Var3.f14010h;
        if (!zIsOne) {
            n0.square(iArr, iArrCreate2);
            iArr = iArrCreate2;
        }
        n0.subtract(o0Var2.f14010h, iArr, iArrCreate);
        n0.add(o0Var2.f14010h, iArr, iArrCreate2);
        n0.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        n0.reduce32(g.a.g.c.n.addBothTo(12, iArrCreate2, iArrCreate2, iArrCreate2), iArrCreate2);
        n0.multiply(iArrCreate3, o0Var2.f14010h, iArrCreate3);
        n0.reduce32(g.a.g.c.n.shiftUpBits(12, iArrCreate3, 2, 0), iArrCreate3);
        n0.reduce32(g.a.g.c.n.shiftUpBits(12, iArrCreate4, 3, 0, iArrCreate), iArrCreate);
        o0 o0Var4 = new o0(iArrCreate4);
        n0.square(iArrCreate2, o0Var4.f14010h);
        int[] iArr2 = o0Var4.f14010h;
        n0.subtract(iArr2, iArrCreate3, iArr2);
        int[] iArr3 = o0Var4.f14010h;
        n0.subtract(iArr3, iArrCreate3, iArr3);
        o0 o0Var5 = new o0(iArrCreate3);
        n0.subtract(iArrCreate3, o0Var4.f14010h, o0Var5.f14010h);
        int[] iArr4 = o0Var5.f14010h;
        n0.multiply(iArr4, iArrCreate2, iArr4);
        int[] iArr5 = o0Var5.f14010h;
        n0.subtract(iArr5, iArrCreate, iArr5);
        o0 o0Var6 = new o0(iArrCreate2);
        n0.twice(o0Var.f14010h, o0Var6.f14010h);
        if (!zIsOne) {
            int[] iArr6 = o0Var6.f14010h;
            n0.multiply(iArr6, o0Var3.f14010h, iArr6);
        }
        return new p0(curve, o0Var4, o0Var5, new g.a.g.a.f[]{o0Var6});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twicePlus(g.a.g.a.i iVar) {
        return this == iVar ? threeTimes() : isInfinity() ? iVar : iVar.isInfinity() ? twice() : this.f14128d.isZero() ? iVar : twice().add(iVar);
    }
}
