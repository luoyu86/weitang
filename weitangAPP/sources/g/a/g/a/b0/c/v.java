package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class v extends i.c {
    public v(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public v(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
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
        u uVar = (u) this.f14127c;
        u uVar2 = (u) this.f14128d;
        u uVar3 = (u) iVar.getXCoord();
        u uVar4 = (u) iVar.getYCoord();
        u uVar5 = (u) this.f14129e[0];
        u uVar6 = (u) iVar.getZCoord(0);
        int[] iArrCreateExt = g.a.g.c.f.createExt();
        int[] iArrCreate = g.a.g.c.f.create();
        int[] iArrCreate2 = g.a.g.c.f.create();
        int[] iArrCreate3 = g.a.g.c.f.create();
        boolean zIsOne = uVar5.isOne();
        if (zIsOne) {
            iArr = uVar3.f14046h;
            iArr2 = uVar4.f14046h;
        } else {
            t.square(uVar5.f14046h, iArrCreate2);
            t.multiply(iArrCreate2, uVar3.f14046h, iArrCreate);
            t.multiply(iArrCreate2, uVar5.f14046h, iArrCreate2);
            t.multiply(iArrCreate2, uVar4.f14046h, iArrCreate2);
            iArr = iArrCreate;
            iArr2 = iArrCreate2;
        }
        boolean zIsOne2 = uVar6.isOne();
        if (zIsOne2) {
            iArr3 = uVar.f14046h;
            iArr4 = uVar2.f14046h;
        } else {
            t.square(uVar6.f14046h, iArrCreate3);
            t.multiply(iArrCreate3, uVar.f14046h, iArrCreateExt);
            t.multiply(iArrCreate3, uVar6.f14046h, iArrCreate3);
            t.multiply(iArrCreate3, uVar2.f14046h, iArrCreate3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrCreate3;
        }
        int[] iArrCreate4 = g.a.g.c.f.create();
        t.subtract(iArr3, iArr, iArrCreate4);
        t.subtract(iArr4, iArr2, iArrCreate);
        if (g.a.g.c.f.isZero(iArrCreate4)) {
            return g.a.g.c.f.isZero(iArrCreate) ? twice() : curve.getInfinity();
        }
        t.square(iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = g.a.g.c.f.create();
        t.multiply(iArrCreate2, iArrCreate4, iArrCreate5);
        t.multiply(iArrCreate2, iArr3, iArrCreate2);
        t.negate(iArrCreate5, iArrCreate5);
        g.a.g.c.f.mul(iArr4, iArrCreate5, iArrCreateExt);
        t.reduce32(g.a.g.c.f.addBothTo(iArrCreate2, iArrCreate2, iArrCreate5), iArrCreate5);
        u uVar7 = new u(iArrCreate3);
        t.square(iArrCreate, uVar7.f14046h);
        int[] iArr5 = uVar7.f14046h;
        t.subtract(iArr5, iArrCreate5, iArr5);
        u uVar8 = new u(iArrCreate5);
        t.subtract(iArrCreate2, uVar7.f14046h, uVar8.f14046h);
        t.multiplyAddToExt(uVar8.f14046h, iArrCreate, iArrCreateExt);
        t.reduce(iArrCreateExt, uVar8.f14046h);
        u uVar9 = new u(iArrCreate4);
        if (!zIsOne) {
            int[] iArr6 = uVar9.f14046h;
            t.multiply(iArr6, uVar5.f14046h, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = uVar9.f14046h;
            t.multiply(iArr7, uVar6.f14046h, iArr7);
        }
        return new v(curve, uVar7, uVar8, new g.a.g.a.f[]{uVar9});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new v(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i negate() {
        return isInfinity() ? this : new v(this.f14126b, this.f14127c, this.f14128d.negate(), this.f14129e);
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
        u uVar = (u) this.f14128d;
        if (uVar.isZero()) {
            return curve.getInfinity();
        }
        u uVar2 = (u) this.f14127c;
        u uVar3 = (u) this.f14129e[0];
        int[] iArrCreate = g.a.g.c.f.create();
        int[] iArrCreate2 = g.a.g.c.f.create();
        int[] iArrCreate3 = g.a.g.c.f.create();
        t.square(uVar.f14046h, iArrCreate3);
        int[] iArrCreate4 = g.a.g.c.f.create();
        t.square(iArrCreate3, iArrCreate4);
        boolean zIsOne = uVar3.isOne();
        int[] iArr = uVar3.f14046h;
        if (!zIsOne) {
            t.square(iArr, iArrCreate2);
            iArr = iArrCreate2;
        }
        t.subtract(uVar2.f14046h, iArr, iArrCreate);
        t.add(uVar2.f14046h, iArr, iArrCreate2);
        t.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        t.reduce32(g.a.g.c.f.addBothTo(iArrCreate2, iArrCreate2, iArrCreate2), iArrCreate2);
        t.multiply(iArrCreate3, uVar2.f14046h, iArrCreate3);
        t.reduce32(g.a.g.c.n.shiftUpBits(6, iArrCreate3, 2, 0), iArrCreate3);
        t.reduce32(g.a.g.c.n.shiftUpBits(6, iArrCreate4, 3, 0, iArrCreate), iArrCreate);
        u uVar4 = new u(iArrCreate4);
        t.square(iArrCreate2, uVar4.f14046h);
        int[] iArr2 = uVar4.f14046h;
        t.subtract(iArr2, iArrCreate3, iArr2);
        int[] iArr3 = uVar4.f14046h;
        t.subtract(iArr3, iArrCreate3, iArr3);
        u uVar5 = new u(iArrCreate3);
        t.subtract(iArrCreate3, uVar4.f14046h, uVar5.f14046h);
        int[] iArr4 = uVar5.f14046h;
        t.multiply(iArr4, iArrCreate2, iArr4);
        int[] iArr5 = uVar5.f14046h;
        t.subtract(iArr5, iArrCreate, iArr5);
        u uVar6 = new u(iArrCreate2);
        t.twice(uVar.f14046h, uVar6.f14046h);
        if (!zIsOne) {
            int[] iArr6 = uVar6.f14046h;
            t.multiply(iArr6, uVar3.f14046h, iArr6);
        }
        return new v(curve, uVar4, uVar5, new g.a.g.a.f[]{uVar6});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twicePlus(g.a.g.a.i iVar) {
        return this == iVar ? threeTimes() : isInfinity() ? iVar : iVar.isInfinity() ? twice() : this.f14128d.isZero() ? iVar : twice().add(iVar);
    }
}
