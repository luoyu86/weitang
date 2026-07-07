package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class n extends i.c {
    public n(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public n(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
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
        m mVar = (m) this.f14127c;
        m mVar2 = (m) this.f14128d;
        m mVar3 = (m) iVar.getXCoord();
        m mVar4 = (m) iVar.getYCoord();
        m mVar5 = (m) this.f14129e[0];
        m mVar6 = (m) iVar.getZCoord(0);
        int[] iArrCreateExt = g.a.g.c.e.createExt();
        int[] iArrCreate = g.a.g.c.e.create();
        int[] iArrCreate2 = g.a.g.c.e.create();
        int[] iArrCreate3 = g.a.g.c.e.create();
        boolean zIsOne = mVar5.isOne();
        if (zIsOne) {
            iArr = mVar3.f13991h;
            iArr2 = mVar4.f13991h;
        } else {
            l.square(mVar5.f13991h, iArrCreate2);
            l.multiply(iArrCreate2, mVar3.f13991h, iArrCreate);
            l.multiply(iArrCreate2, mVar5.f13991h, iArrCreate2);
            l.multiply(iArrCreate2, mVar4.f13991h, iArrCreate2);
            iArr = iArrCreate;
            iArr2 = iArrCreate2;
        }
        boolean zIsOne2 = mVar6.isOne();
        if (zIsOne2) {
            iArr3 = mVar.f13991h;
            iArr4 = mVar2.f13991h;
        } else {
            l.square(mVar6.f13991h, iArrCreate3);
            l.multiply(iArrCreate3, mVar.f13991h, iArrCreateExt);
            l.multiply(iArrCreate3, mVar6.f13991h, iArrCreate3);
            l.multiply(iArrCreate3, mVar2.f13991h, iArrCreate3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrCreate3;
        }
        int[] iArrCreate4 = g.a.g.c.e.create();
        l.subtract(iArr3, iArr, iArrCreate4);
        l.subtract(iArr4, iArr2, iArrCreate);
        if (g.a.g.c.e.isZero(iArrCreate4)) {
            return g.a.g.c.e.isZero(iArrCreate) ? twice() : curve.getInfinity();
        }
        l.square(iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = g.a.g.c.e.create();
        l.multiply(iArrCreate2, iArrCreate4, iArrCreate5);
        l.multiply(iArrCreate2, iArr3, iArrCreate2);
        l.negate(iArrCreate5, iArrCreate5);
        g.a.g.c.e.mul(iArr4, iArrCreate5, iArrCreateExt);
        l.reduce32(g.a.g.c.e.addBothTo(iArrCreate2, iArrCreate2, iArrCreate5), iArrCreate5);
        m mVar7 = new m(iArrCreate3);
        l.square(iArrCreate, mVar7.f13991h);
        int[] iArr5 = mVar7.f13991h;
        l.subtract(iArr5, iArrCreate5, iArr5);
        m mVar8 = new m(iArrCreate5);
        l.subtract(iArrCreate2, mVar7.f13991h, mVar8.f13991h);
        l.multiplyAddToExt(mVar8.f13991h, iArrCreate, iArrCreateExt);
        l.reduce(iArrCreateExt, mVar8.f13991h);
        m mVar9 = new m(iArrCreate4);
        if (!zIsOne) {
            int[] iArr6 = mVar9.f13991h;
            l.multiply(iArr6, mVar5.f13991h, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = mVar9.f13991h;
            l.multiply(iArr7, mVar6.f13991h, iArr7);
        }
        return new n(curve, mVar7, mVar8, new g.a.g.a.f[]{mVar9});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new n(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i negate() {
        return isInfinity() ? this : new n(this.f14126b, this.f14127c, this.f14128d.negate(), this.f14129e);
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
        m mVar = (m) this.f14128d;
        if (mVar.isZero()) {
            return curve.getInfinity();
        }
        m mVar2 = (m) this.f14127c;
        m mVar3 = (m) this.f14129e[0];
        int[] iArrCreate = g.a.g.c.e.create();
        int[] iArrCreate2 = g.a.g.c.e.create();
        int[] iArrCreate3 = g.a.g.c.e.create();
        l.square(mVar.f13991h, iArrCreate3);
        int[] iArrCreate4 = g.a.g.c.e.create();
        l.square(iArrCreate3, iArrCreate4);
        boolean zIsOne = mVar3.isOne();
        int[] iArr = mVar3.f13991h;
        if (!zIsOne) {
            l.square(iArr, iArrCreate2);
            iArr = iArrCreate2;
        }
        l.subtract(mVar2.f13991h, iArr, iArrCreate);
        l.add(mVar2.f13991h, iArr, iArrCreate2);
        l.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        l.reduce32(g.a.g.c.e.addBothTo(iArrCreate2, iArrCreate2, iArrCreate2), iArrCreate2);
        l.multiply(iArrCreate3, mVar2.f13991h, iArrCreate3);
        l.reduce32(g.a.g.c.n.shiftUpBits(5, iArrCreate3, 2, 0), iArrCreate3);
        l.reduce32(g.a.g.c.n.shiftUpBits(5, iArrCreate4, 3, 0, iArrCreate), iArrCreate);
        m mVar4 = new m(iArrCreate4);
        l.square(iArrCreate2, mVar4.f13991h);
        int[] iArr2 = mVar4.f13991h;
        l.subtract(iArr2, iArrCreate3, iArr2);
        int[] iArr3 = mVar4.f13991h;
        l.subtract(iArr3, iArrCreate3, iArr3);
        m mVar5 = new m(iArrCreate3);
        l.subtract(iArrCreate3, mVar4.f13991h, mVar5.f13991h);
        int[] iArr4 = mVar5.f13991h;
        l.multiply(iArr4, iArrCreate2, iArr4);
        int[] iArr5 = mVar5.f13991h;
        l.subtract(iArr5, iArrCreate, iArr5);
        m mVar6 = new m(iArrCreate2);
        l.twice(mVar.f13991h, mVar6.f13991h);
        if (!zIsOne) {
            int[] iArr6 = mVar6.f13991h;
            l.multiply(iArr6, mVar3.f13991h, iArr6);
        }
        return new n(curve, mVar4, mVar5, new g.a.g.a.f[]{mVar6});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twicePlus(g.a.g.a.i iVar) {
        return this == iVar ? threeTimes() : isInfinity() ? iVar : iVar.isInfinity() ? twice() : this.f14128d.isZero() ? iVar : twice().add(iVar);
    }
}
