package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class j extends i.c {
    public j(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public j(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
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
        i iVar2 = (i) this.f14127c;
        i iVar3 = (i) this.f14128d;
        i iVar4 = (i) iVar.getXCoord();
        i iVar5 = (i) iVar.getYCoord();
        i iVar6 = (i) this.f14129e[0];
        i iVar7 = (i) iVar.getZCoord(0);
        int[] iArrCreateExt = g.a.g.c.e.createExt();
        int[] iArrCreate = g.a.g.c.e.create();
        int[] iArrCreate2 = g.a.g.c.e.create();
        int[] iArrCreate3 = g.a.g.c.e.create();
        boolean zIsOne = iVar6.isOne();
        if (zIsOne) {
            iArr = iVar4.f13964h;
            iArr2 = iVar5.f13964h;
        } else {
            h.square(iVar6.f13964h, iArrCreate2);
            h.multiply(iArrCreate2, iVar4.f13964h, iArrCreate);
            h.multiply(iArrCreate2, iVar6.f13964h, iArrCreate2);
            h.multiply(iArrCreate2, iVar5.f13964h, iArrCreate2);
            iArr = iArrCreate;
            iArr2 = iArrCreate2;
        }
        boolean zIsOne2 = iVar7.isOne();
        if (zIsOne2) {
            iArr3 = iVar2.f13964h;
            iArr4 = iVar3.f13964h;
        } else {
            h.square(iVar7.f13964h, iArrCreate3);
            h.multiply(iArrCreate3, iVar2.f13964h, iArrCreateExt);
            h.multiply(iArrCreate3, iVar7.f13964h, iArrCreate3);
            h.multiply(iArrCreate3, iVar3.f13964h, iArrCreate3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrCreate3;
        }
        int[] iArrCreate4 = g.a.g.c.e.create();
        h.subtract(iArr3, iArr, iArrCreate4);
        h.subtract(iArr4, iArr2, iArrCreate);
        if (g.a.g.c.e.isZero(iArrCreate4)) {
            return g.a.g.c.e.isZero(iArrCreate) ? twice() : curve.getInfinity();
        }
        h.square(iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = g.a.g.c.e.create();
        h.multiply(iArrCreate2, iArrCreate4, iArrCreate5);
        h.multiply(iArrCreate2, iArr3, iArrCreate2);
        h.negate(iArrCreate5, iArrCreate5);
        g.a.g.c.e.mul(iArr4, iArrCreate5, iArrCreateExt);
        h.reduce32(g.a.g.c.e.addBothTo(iArrCreate2, iArrCreate2, iArrCreate5), iArrCreate5);
        i iVar8 = new i(iArrCreate3);
        h.square(iArrCreate, iVar8.f13964h);
        int[] iArr5 = iVar8.f13964h;
        h.subtract(iArr5, iArrCreate5, iArr5);
        i iVar9 = new i(iArrCreate5);
        h.subtract(iArrCreate2, iVar8.f13964h, iVar9.f13964h);
        h.multiplyAddToExt(iVar9.f13964h, iArrCreate, iArrCreateExt);
        h.reduce(iArrCreateExt, iVar9.f13964h);
        i iVar10 = new i(iArrCreate4);
        if (!zIsOne) {
            int[] iArr6 = iVar10.f13964h;
            h.multiply(iArr6, iVar6.f13964h, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = iVar10.f13964h;
            h.multiply(iArr7, iVar7.f13964h, iArr7);
        }
        return new j(curve, iVar8, iVar9, new g.a.g.a.f[]{iVar10});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new j(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i negate() {
        return isInfinity() ? this : new j(this.f14126b, this.f14127c, this.f14128d.negate(), this.f14129e);
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
        i iVar = (i) this.f14128d;
        if (iVar.isZero()) {
            return curve.getInfinity();
        }
        i iVar2 = (i) this.f14127c;
        i iVar3 = (i) this.f14129e[0];
        int[] iArrCreate = g.a.g.c.e.create();
        int[] iArrCreate2 = g.a.g.c.e.create();
        int[] iArrCreate3 = g.a.g.c.e.create();
        h.square(iVar.f13964h, iArrCreate3);
        int[] iArrCreate4 = g.a.g.c.e.create();
        h.square(iArrCreate3, iArrCreate4);
        boolean zIsOne = iVar3.isOne();
        int[] iArr = iVar3.f13964h;
        if (!zIsOne) {
            h.square(iArr, iArrCreate2);
            iArr = iArrCreate2;
        }
        h.subtract(iVar2.f13964h, iArr, iArrCreate);
        h.add(iVar2.f13964h, iArr, iArrCreate2);
        h.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        h.reduce32(g.a.g.c.e.addBothTo(iArrCreate2, iArrCreate2, iArrCreate2), iArrCreate2);
        h.multiply(iArrCreate3, iVar2.f13964h, iArrCreate3);
        h.reduce32(g.a.g.c.n.shiftUpBits(5, iArrCreate3, 2, 0), iArrCreate3);
        h.reduce32(g.a.g.c.n.shiftUpBits(5, iArrCreate4, 3, 0, iArrCreate), iArrCreate);
        i iVar4 = new i(iArrCreate4);
        h.square(iArrCreate2, iVar4.f13964h);
        int[] iArr2 = iVar4.f13964h;
        h.subtract(iArr2, iArrCreate3, iArr2);
        int[] iArr3 = iVar4.f13964h;
        h.subtract(iArr3, iArrCreate3, iArr3);
        i iVar5 = new i(iArrCreate3);
        h.subtract(iArrCreate3, iVar4.f13964h, iVar5.f13964h);
        int[] iArr4 = iVar5.f13964h;
        h.multiply(iArr4, iArrCreate2, iArr4);
        int[] iArr5 = iVar5.f13964h;
        h.subtract(iArr5, iArrCreate, iArr5);
        i iVar6 = new i(iArrCreate2);
        h.twice(iVar.f13964h, iVar6.f13964h);
        if (!zIsOne) {
            int[] iArr6 = iVar6.f13964h;
            h.multiply(iArr6, iVar3.f13964h, iArr6);
        }
        return new j(curve, iVar4, iVar5, new g.a.g.a.f[]{iVar6});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twicePlus(g.a.g.a.i iVar) {
        return this == iVar ? threeTimes() : isInfinity() ? iVar : iVar.isInfinity() ? twice() : this.f14128d.isZero() ? iVar : twice().add(iVar);
    }
}
