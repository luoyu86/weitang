package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class d extends i.c {
    public d(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public d(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
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
        c cVar = (c) this.f14127c;
        c cVar2 = (c) this.f14128d;
        c cVar3 = (c) iVar.getXCoord();
        c cVar4 = (c) iVar.getYCoord();
        c cVar5 = (c) this.f14129e[0];
        c cVar6 = (c) iVar.getZCoord(0);
        int[] iArrCreateExt = g.a.g.c.d.createExt();
        int[] iArrCreate = g.a.g.c.d.create();
        int[] iArrCreate2 = g.a.g.c.d.create();
        int[] iArrCreate3 = g.a.g.c.d.create();
        boolean zIsOne = cVar5.isOne();
        if (zIsOne) {
            iArr = cVar3.f13924h;
            iArr2 = cVar4.f13924h;
        } else {
            b.square(cVar5.f13924h, iArrCreate2);
            b.multiply(iArrCreate2, cVar3.f13924h, iArrCreate);
            b.multiply(iArrCreate2, cVar5.f13924h, iArrCreate2);
            b.multiply(iArrCreate2, cVar4.f13924h, iArrCreate2);
            iArr = iArrCreate;
            iArr2 = iArrCreate2;
        }
        boolean zIsOne2 = cVar6.isOne();
        if (zIsOne2) {
            iArr3 = cVar.f13924h;
            iArr4 = cVar2.f13924h;
        } else {
            b.square(cVar6.f13924h, iArrCreate3);
            b.multiply(iArrCreate3, cVar.f13924h, iArrCreateExt);
            b.multiply(iArrCreate3, cVar6.f13924h, iArrCreate3);
            b.multiply(iArrCreate3, cVar2.f13924h, iArrCreate3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrCreate3;
        }
        int[] iArrCreate4 = g.a.g.c.d.create();
        b.subtract(iArr3, iArr, iArrCreate4);
        b.subtract(iArr4, iArr2, iArrCreate);
        if (g.a.g.c.d.isZero(iArrCreate4)) {
            return g.a.g.c.d.isZero(iArrCreate) ? twice() : curve.getInfinity();
        }
        b.square(iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = g.a.g.c.d.create();
        b.multiply(iArrCreate2, iArrCreate4, iArrCreate5);
        b.multiply(iArrCreate2, iArr3, iArrCreate2);
        b.negate(iArrCreate5, iArrCreate5);
        g.a.g.c.d.mul(iArr4, iArrCreate5, iArrCreateExt);
        b.reduce32(g.a.g.c.d.addBothTo(iArrCreate2, iArrCreate2, iArrCreate5), iArrCreate5);
        c cVar7 = new c(iArrCreate3);
        b.square(iArrCreate, cVar7.f13924h);
        int[] iArr5 = cVar7.f13924h;
        b.subtract(iArr5, iArrCreate5, iArr5);
        c cVar8 = new c(iArrCreate5);
        b.subtract(iArrCreate2, cVar7.f13924h, cVar8.f13924h);
        b.multiplyAddToExt(cVar8.f13924h, iArrCreate, iArrCreateExt);
        b.reduce(iArrCreateExt, cVar8.f13924h);
        c cVar9 = new c(iArrCreate4);
        if (!zIsOne) {
            int[] iArr6 = cVar9.f13924h;
            b.multiply(iArr6, cVar5.f13924h, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = cVar9.f13924h;
            b.multiply(iArr7, cVar6.f13924h, iArr7);
        }
        return new d(curve, cVar7, cVar8, new g.a.g.a.f[]{cVar9});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new d(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i negate() {
        return isInfinity() ? this : new d(this.f14126b, this.f14127c, this.f14128d.negate(), this.f14129e);
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
        c cVar = (c) this.f14128d;
        if (cVar.isZero()) {
            return curve.getInfinity();
        }
        c cVar2 = (c) this.f14127c;
        c cVar3 = (c) this.f14129e[0];
        int[] iArrCreate = g.a.g.c.d.create();
        int[] iArrCreate2 = g.a.g.c.d.create();
        int[] iArrCreate3 = g.a.g.c.d.create();
        b.square(cVar.f13924h, iArrCreate3);
        int[] iArrCreate4 = g.a.g.c.d.create();
        b.square(iArrCreate3, iArrCreate4);
        boolean zIsOne = cVar3.isOne();
        int[] iArr = cVar3.f13924h;
        if (!zIsOne) {
            b.square(iArr, iArrCreate2);
            iArr = iArrCreate2;
        }
        b.subtract(cVar2.f13924h, iArr, iArrCreate);
        b.add(cVar2.f13924h, iArr, iArrCreate2);
        b.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        b.reduce32(g.a.g.c.d.addBothTo(iArrCreate2, iArrCreate2, iArrCreate2), iArrCreate2);
        b.multiply(iArrCreate3, cVar2.f13924h, iArrCreate3);
        b.reduce32(g.a.g.c.n.shiftUpBits(4, iArrCreate3, 2, 0), iArrCreate3);
        b.reduce32(g.a.g.c.n.shiftUpBits(4, iArrCreate4, 3, 0, iArrCreate), iArrCreate);
        c cVar4 = new c(iArrCreate4);
        b.square(iArrCreate2, cVar4.f13924h);
        int[] iArr2 = cVar4.f13924h;
        b.subtract(iArr2, iArrCreate3, iArr2);
        int[] iArr3 = cVar4.f13924h;
        b.subtract(iArr3, iArrCreate3, iArr3);
        c cVar5 = new c(iArrCreate3);
        b.subtract(iArrCreate3, cVar4.f13924h, cVar5.f13924h);
        int[] iArr4 = cVar5.f13924h;
        b.multiply(iArr4, iArrCreate2, iArr4);
        int[] iArr5 = cVar5.f13924h;
        b.subtract(iArr5, iArrCreate, iArr5);
        c cVar6 = new c(iArrCreate2);
        b.twice(cVar.f13924h, cVar6.f13924h);
        if (!zIsOne) {
            int[] iArr6 = cVar6.f13924h;
            b.multiply(iArr6, cVar3.f13924h, iArr6);
        }
        return new d(curve, cVar4, cVar5, new g.a.g.a.f[]{cVar6});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twicePlus(g.a.g.a.i iVar) {
        return this == iVar ? threeTimes() : isInfinity() ? iVar : iVar.isInfinity() ? twice() : this.f14128d.isZero() ? iVar : twice().add(iVar);
    }
}
