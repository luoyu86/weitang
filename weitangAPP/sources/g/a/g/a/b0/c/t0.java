package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class t0 extends i.c {
    public t0(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public t0(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
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
        s0 s0Var = (s0) this.f14127c;
        s0 s0Var2 = (s0) this.f14128d;
        s0 s0Var3 = (s0) iVar.getXCoord();
        s0 s0Var4 = (s0) iVar.getYCoord();
        s0 s0Var5 = (s0) this.f14129e[0];
        s0 s0Var6 = (s0) iVar.getZCoord(0);
        int[] iArrCreate = g.a.g.c.n.create(17);
        int[] iArrCreate2 = g.a.g.c.n.create(17);
        int[] iArrCreate3 = g.a.g.c.n.create(17);
        int[] iArrCreate4 = g.a.g.c.n.create(17);
        boolean zIsOne = s0Var5.isOne();
        if (zIsOne) {
            iArr = s0Var3.f14035h;
            iArr2 = s0Var4.f14035h;
        } else {
            r0.square(s0Var5.f14035h, iArrCreate3);
            r0.multiply(iArrCreate3, s0Var3.f14035h, iArrCreate2);
            r0.multiply(iArrCreate3, s0Var5.f14035h, iArrCreate3);
            r0.multiply(iArrCreate3, s0Var4.f14035h, iArrCreate3);
            iArr = iArrCreate2;
            iArr2 = iArrCreate3;
        }
        boolean zIsOne2 = s0Var6.isOne();
        if (zIsOne2) {
            iArr3 = s0Var.f14035h;
            iArr4 = s0Var2.f14035h;
        } else {
            r0.square(s0Var6.f14035h, iArrCreate4);
            r0.multiply(iArrCreate4, s0Var.f14035h, iArrCreate);
            r0.multiply(iArrCreate4, s0Var6.f14035h, iArrCreate4);
            r0.multiply(iArrCreate4, s0Var2.f14035h, iArrCreate4);
            iArr3 = iArrCreate;
            iArr4 = iArrCreate4;
        }
        int[] iArrCreate5 = g.a.g.c.n.create(17);
        r0.subtract(iArr3, iArr, iArrCreate5);
        r0.subtract(iArr4, iArr2, iArrCreate2);
        if (g.a.g.c.n.isZero(17, iArrCreate5)) {
            return g.a.g.c.n.isZero(17, iArrCreate2) ? twice() : curve.getInfinity();
        }
        r0.square(iArrCreate5, iArrCreate3);
        int[] iArrCreate6 = g.a.g.c.n.create(17);
        r0.multiply(iArrCreate3, iArrCreate5, iArrCreate6);
        r0.multiply(iArrCreate3, iArr3, iArrCreate3);
        r0.multiply(iArr4, iArrCreate6, iArrCreate);
        s0 s0Var7 = new s0(iArrCreate4);
        r0.square(iArrCreate2, s0Var7.f14035h);
        int[] iArr5 = s0Var7.f14035h;
        r0.add(iArr5, iArrCreate6, iArr5);
        int[] iArr6 = s0Var7.f14035h;
        r0.subtract(iArr6, iArrCreate3, iArr6);
        int[] iArr7 = s0Var7.f14035h;
        r0.subtract(iArr7, iArrCreate3, iArr7);
        s0 s0Var8 = new s0(iArrCreate6);
        r0.subtract(iArrCreate3, s0Var7.f14035h, s0Var8.f14035h);
        r0.multiply(s0Var8.f14035h, iArrCreate2, iArrCreate2);
        r0.subtract(iArrCreate2, iArrCreate, s0Var8.f14035h);
        s0 s0Var9 = new s0(iArrCreate5);
        if (!zIsOne) {
            int[] iArr8 = s0Var9.f14035h;
            r0.multiply(iArr8, s0Var5.f14035h, iArr8);
        }
        if (!zIsOne2) {
            int[] iArr9 = s0Var9.f14035h;
            r0.multiply(iArr9, s0Var6.f14035h, iArr9);
        }
        return new t0(curve, s0Var7, s0Var8, new g.a.g.a.f[]{s0Var9});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new t0(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i negate() {
        return isInfinity() ? this : new t0(this.f14126b, this.f14127c, this.f14128d.negate(), this.f14129e);
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
        s0 s0Var = (s0) this.f14128d;
        if (s0Var.isZero()) {
            return curve.getInfinity();
        }
        s0 s0Var2 = (s0) this.f14127c;
        s0 s0Var3 = (s0) this.f14129e[0];
        int[] iArrCreate = g.a.g.c.n.create(17);
        int[] iArrCreate2 = g.a.g.c.n.create(17);
        int[] iArrCreate3 = g.a.g.c.n.create(17);
        r0.square(s0Var.f14035h, iArrCreate3);
        int[] iArrCreate4 = g.a.g.c.n.create(17);
        r0.square(iArrCreate3, iArrCreate4);
        boolean zIsOne = s0Var3.isOne();
        int[] iArr = s0Var3.f14035h;
        if (!zIsOne) {
            r0.square(iArr, iArrCreate2);
            iArr = iArrCreate2;
        }
        r0.subtract(s0Var2.f14035h, iArr, iArrCreate);
        r0.add(s0Var2.f14035h, iArr, iArrCreate2);
        r0.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        g.a.g.c.n.addBothTo(17, iArrCreate2, iArrCreate2, iArrCreate2);
        r0.reduce23(iArrCreate2);
        r0.multiply(iArrCreate3, s0Var2.f14035h, iArrCreate3);
        g.a.g.c.n.shiftUpBits(17, iArrCreate3, 2, 0);
        r0.reduce23(iArrCreate3);
        g.a.g.c.n.shiftUpBits(17, iArrCreate4, 3, 0, iArrCreate);
        r0.reduce23(iArrCreate);
        s0 s0Var4 = new s0(iArrCreate4);
        r0.square(iArrCreate2, s0Var4.f14035h);
        int[] iArr2 = s0Var4.f14035h;
        r0.subtract(iArr2, iArrCreate3, iArr2);
        int[] iArr3 = s0Var4.f14035h;
        r0.subtract(iArr3, iArrCreate3, iArr3);
        s0 s0Var5 = new s0(iArrCreate3);
        r0.subtract(iArrCreate3, s0Var4.f14035h, s0Var5.f14035h);
        int[] iArr4 = s0Var5.f14035h;
        r0.multiply(iArr4, iArrCreate2, iArr4);
        int[] iArr5 = s0Var5.f14035h;
        r0.subtract(iArr5, iArrCreate, iArr5);
        s0 s0Var6 = new s0(iArrCreate2);
        r0.twice(s0Var.f14035h, s0Var6.f14035h);
        if (!zIsOne) {
            int[] iArr6 = s0Var6.f14035h;
            r0.multiply(iArr6, s0Var3.f14035h, iArr6);
        }
        return new t0(curve, s0Var4, s0Var5, new g.a.g.a.f[]{s0Var6});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twicePlus(g.a.g.a.i iVar) {
        return this == iVar ? threeTimes() : isInfinity() ? iVar : iVar.isInfinity() ? twice() : this.f14128d.isZero() ? iVar : twice().add(iVar);
    }
}
