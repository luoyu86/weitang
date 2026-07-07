package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class z extends i.c {
    public z(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public z(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
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
        y yVar = (y) this.f14127c;
        y yVar2 = (y) this.f14128d;
        y yVar3 = (y) iVar.getXCoord();
        y yVar4 = (y) iVar.getYCoord();
        y yVar5 = (y) this.f14129e[0];
        y yVar6 = (y) iVar.getZCoord(0);
        int[] iArrCreateExt = g.a.g.c.g.createExt();
        int[] iArrCreate = g.a.g.c.g.create();
        int[] iArrCreate2 = g.a.g.c.g.create();
        int[] iArrCreate3 = g.a.g.c.g.create();
        boolean zIsOne = yVar5.isOne();
        if (zIsOne) {
            iArr = yVar3.f14067i;
            iArr2 = yVar4.f14067i;
        } else {
            x.square(yVar5.f14067i, iArrCreate2);
            x.multiply(iArrCreate2, yVar3.f14067i, iArrCreate);
            x.multiply(iArrCreate2, yVar5.f14067i, iArrCreate2);
            x.multiply(iArrCreate2, yVar4.f14067i, iArrCreate2);
            iArr = iArrCreate;
            iArr2 = iArrCreate2;
        }
        boolean zIsOne2 = yVar6.isOne();
        if (zIsOne2) {
            iArr3 = yVar.f14067i;
            iArr4 = yVar2.f14067i;
        } else {
            x.square(yVar6.f14067i, iArrCreate3);
            x.multiply(iArrCreate3, yVar.f14067i, iArrCreateExt);
            x.multiply(iArrCreate3, yVar6.f14067i, iArrCreate3);
            x.multiply(iArrCreate3, yVar2.f14067i, iArrCreate3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrCreate3;
        }
        int[] iArrCreate4 = g.a.g.c.g.create();
        x.subtract(iArr3, iArr, iArrCreate4);
        x.subtract(iArr4, iArr2, iArrCreate);
        if (g.a.g.c.g.isZero(iArrCreate4)) {
            return g.a.g.c.g.isZero(iArrCreate) ? twice() : curve.getInfinity();
        }
        x.square(iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = g.a.g.c.g.create();
        x.multiply(iArrCreate2, iArrCreate4, iArrCreate5);
        x.multiply(iArrCreate2, iArr3, iArrCreate2);
        x.negate(iArrCreate5, iArrCreate5);
        g.a.g.c.g.mul(iArr4, iArrCreate5, iArrCreateExt);
        x.reduce32(g.a.g.c.g.addBothTo(iArrCreate2, iArrCreate2, iArrCreate5), iArrCreate5);
        y yVar7 = new y(iArrCreate3);
        x.square(iArrCreate, yVar7.f14067i);
        int[] iArr5 = yVar7.f14067i;
        x.subtract(iArr5, iArrCreate5, iArr5);
        y yVar8 = new y(iArrCreate5);
        x.subtract(iArrCreate2, yVar7.f14067i, yVar8.f14067i);
        x.multiplyAddToExt(yVar8.f14067i, iArrCreate, iArrCreateExt);
        x.reduce(iArrCreateExt, yVar8.f14067i);
        y yVar9 = new y(iArrCreate4);
        if (!zIsOne) {
            int[] iArr6 = yVar9.f14067i;
            x.multiply(iArr6, yVar5.f14067i, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = yVar9.f14067i;
            x.multiply(iArr7, yVar6.f14067i, iArr7);
        }
        return new z(curve, yVar7, yVar8, new g.a.g.a.f[]{yVar9});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new z(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i negate() {
        return isInfinity() ? this : new z(this.f14126b, this.f14127c, this.f14128d.negate(), this.f14129e);
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
        y yVar = (y) this.f14128d;
        if (yVar.isZero()) {
            return curve.getInfinity();
        }
        y yVar2 = (y) this.f14127c;
        y yVar3 = (y) this.f14129e[0];
        int[] iArrCreate = g.a.g.c.g.create();
        x.square(yVar.f14067i, iArrCreate);
        int[] iArrCreate2 = g.a.g.c.g.create();
        x.square(iArrCreate, iArrCreate2);
        int[] iArrCreate3 = g.a.g.c.g.create();
        x.square(yVar2.f14067i, iArrCreate3);
        x.reduce32(g.a.g.c.g.addBothTo(iArrCreate3, iArrCreate3, iArrCreate3), iArrCreate3);
        x.multiply(iArrCreate, yVar2.f14067i, iArrCreate);
        x.reduce32(g.a.g.c.n.shiftUpBits(7, iArrCreate, 2, 0), iArrCreate);
        int[] iArrCreate4 = g.a.g.c.g.create();
        x.reduce32(g.a.g.c.n.shiftUpBits(7, iArrCreate2, 3, 0, iArrCreate4), iArrCreate4);
        y yVar4 = new y(iArrCreate2);
        x.square(iArrCreate3, yVar4.f14067i);
        int[] iArr = yVar4.f14067i;
        x.subtract(iArr, iArrCreate, iArr);
        int[] iArr2 = yVar4.f14067i;
        x.subtract(iArr2, iArrCreate, iArr2);
        y yVar5 = new y(iArrCreate);
        x.subtract(iArrCreate, yVar4.f14067i, yVar5.f14067i);
        int[] iArr3 = yVar5.f14067i;
        x.multiply(iArr3, iArrCreate3, iArr3);
        int[] iArr4 = yVar5.f14067i;
        x.subtract(iArr4, iArrCreate4, iArr4);
        y yVar6 = new y(iArrCreate3);
        x.twice(yVar.f14067i, yVar6.f14067i);
        if (!yVar3.isOne()) {
            int[] iArr5 = yVar6.f14067i;
            x.multiply(iArr5, yVar3.f14067i, iArr5);
        }
        return new z(curve, yVar4, yVar5, new g.a.g.a.f[]{yVar6});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twicePlus(g.a.g.a.i iVar) {
        return this == iVar ? threeTimes() : isInfinity() ? iVar : iVar.isInfinity() ? twice() : this.f14128d.isZero() ? iVar : twice().add(iVar);
    }
}
