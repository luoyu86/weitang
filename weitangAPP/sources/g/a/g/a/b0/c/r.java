package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class r extends i.c {
    public r(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public r(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
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
        q qVar = (q) this.f14127c;
        q qVar2 = (q) this.f14128d;
        q qVar3 = (q) iVar.getXCoord();
        q qVar4 = (q) iVar.getYCoord();
        q qVar5 = (q) this.f14129e[0];
        q qVar6 = (q) iVar.getZCoord(0);
        int[] iArrCreateExt = g.a.g.c.f.createExt();
        int[] iArrCreate = g.a.g.c.f.create();
        int[] iArrCreate2 = g.a.g.c.f.create();
        int[] iArrCreate3 = g.a.g.c.f.create();
        boolean zIsOne = qVar5.isOne();
        if (zIsOne) {
            iArr = qVar3.f14019h;
            iArr2 = qVar4.f14019h;
        } else {
            p.square(qVar5.f14019h, iArrCreate2);
            p.multiply(iArrCreate2, qVar3.f14019h, iArrCreate);
            p.multiply(iArrCreate2, qVar5.f14019h, iArrCreate2);
            p.multiply(iArrCreate2, qVar4.f14019h, iArrCreate2);
            iArr = iArrCreate;
            iArr2 = iArrCreate2;
        }
        boolean zIsOne2 = qVar6.isOne();
        if (zIsOne2) {
            iArr3 = qVar.f14019h;
            iArr4 = qVar2.f14019h;
        } else {
            p.square(qVar6.f14019h, iArrCreate3);
            p.multiply(iArrCreate3, qVar.f14019h, iArrCreateExt);
            p.multiply(iArrCreate3, qVar6.f14019h, iArrCreate3);
            p.multiply(iArrCreate3, qVar2.f14019h, iArrCreate3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrCreate3;
        }
        int[] iArrCreate4 = g.a.g.c.f.create();
        p.subtract(iArr3, iArr, iArrCreate4);
        p.subtract(iArr4, iArr2, iArrCreate);
        if (g.a.g.c.f.isZero(iArrCreate4)) {
            return g.a.g.c.f.isZero(iArrCreate) ? twice() : curve.getInfinity();
        }
        p.square(iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = g.a.g.c.f.create();
        p.multiply(iArrCreate2, iArrCreate4, iArrCreate5);
        p.multiply(iArrCreate2, iArr3, iArrCreate2);
        p.negate(iArrCreate5, iArrCreate5);
        g.a.g.c.f.mul(iArr4, iArrCreate5, iArrCreateExt);
        p.reduce32(g.a.g.c.f.addBothTo(iArrCreate2, iArrCreate2, iArrCreate5), iArrCreate5);
        q qVar7 = new q(iArrCreate3);
        p.square(iArrCreate, qVar7.f14019h);
        int[] iArr5 = qVar7.f14019h;
        p.subtract(iArr5, iArrCreate5, iArr5);
        q qVar8 = new q(iArrCreate5);
        p.subtract(iArrCreate2, qVar7.f14019h, qVar8.f14019h);
        p.multiplyAddToExt(qVar8.f14019h, iArrCreate, iArrCreateExt);
        p.reduce(iArrCreateExt, qVar8.f14019h);
        q qVar9 = new q(iArrCreate4);
        if (!zIsOne) {
            int[] iArr6 = qVar9.f14019h;
            p.multiply(iArr6, qVar5.f14019h, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = qVar9.f14019h;
            p.multiply(iArr7, qVar6.f14019h, iArr7);
        }
        return new r(curve, qVar7, qVar8, new g.a.g.a.f[]{qVar9});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new r(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i negate() {
        return isInfinity() ? this : new r(this.f14126b, this.f14127c, this.f14128d.negate(), this.f14129e);
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
        q qVar = (q) this.f14128d;
        if (qVar.isZero()) {
            return curve.getInfinity();
        }
        q qVar2 = (q) this.f14127c;
        q qVar3 = (q) this.f14129e[0];
        int[] iArrCreate = g.a.g.c.f.create();
        p.square(qVar.f14019h, iArrCreate);
        int[] iArrCreate2 = g.a.g.c.f.create();
        p.square(iArrCreate, iArrCreate2);
        int[] iArrCreate3 = g.a.g.c.f.create();
        p.square(qVar2.f14019h, iArrCreate3);
        p.reduce32(g.a.g.c.f.addBothTo(iArrCreate3, iArrCreate3, iArrCreate3), iArrCreate3);
        p.multiply(iArrCreate, qVar2.f14019h, iArrCreate);
        p.reduce32(g.a.g.c.n.shiftUpBits(6, iArrCreate, 2, 0), iArrCreate);
        int[] iArrCreate4 = g.a.g.c.f.create();
        p.reduce32(g.a.g.c.n.shiftUpBits(6, iArrCreate2, 3, 0, iArrCreate4), iArrCreate4);
        q qVar4 = new q(iArrCreate2);
        p.square(iArrCreate3, qVar4.f14019h);
        int[] iArr = qVar4.f14019h;
        p.subtract(iArr, iArrCreate, iArr);
        int[] iArr2 = qVar4.f14019h;
        p.subtract(iArr2, iArrCreate, iArr2);
        q qVar5 = new q(iArrCreate);
        p.subtract(iArrCreate, qVar4.f14019h, qVar5.f14019h);
        int[] iArr3 = qVar5.f14019h;
        p.multiply(iArr3, iArrCreate3, iArr3);
        int[] iArr4 = qVar5.f14019h;
        p.subtract(iArr4, iArrCreate4, iArr4);
        q qVar6 = new q(iArrCreate3);
        p.twice(qVar.f14019h, qVar6.f14019h);
        if (!qVar3.isOne()) {
            int[] iArr5 = qVar6.f14019h;
            p.multiply(iArr5, qVar3.f14019h, iArr5);
        }
        return new r(curve, qVar4, qVar5, new g.a.g.a.f[]{qVar6});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twicePlus(g.a.g.a.i iVar) {
        return this == iVar ? threeTimes() : isInfinity() ? iVar : iVar.isInfinity() ? twice() : this.f14128d.isZero() ? iVar : twice().add(iVar);
    }
}
