package g.a.g.a.b0.a;

import g.a.g.a.e;
import g.a.g.a.f;
import g.a.g.a.i;
import g.a.g.c.h;

/* JADX INFO: loaded from: classes2.dex */
public class d extends i.c {
    public d(e eVar, f fVar, f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public d(e eVar, f fVar, f fVar2, f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.i
    public i add(i iVar) {
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
        e curve = getCurve();
        c cVar = (c) this.f14127c;
        c cVar2 = (c) this.f14128d;
        c cVar3 = (c) this.f14129e[0];
        c cVar4 = (c) iVar.getXCoord();
        c cVar5 = (c) iVar.getYCoord();
        c cVar6 = (c) iVar.getZCoord(0);
        int[] iArrCreateExt = h.createExt();
        int[] iArrCreate = h.create();
        int[] iArrCreate2 = h.create();
        int[] iArrCreate3 = h.create();
        boolean zIsOne = cVar3.isOne();
        if (zIsOne) {
            iArr = cVar4.f13897i;
            iArr2 = cVar5.f13897i;
        } else {
            b.square(cVar3.f13897i, iArrCreate2);
            b.multiply(iArrCreate2, cVar4.f13897i, iArrCreate);
            b.multiply(iArrCreate2, cVar3.f13897i, iArrCreate2);
            b.multiply(iArrCreate2, cVar5.f13897i, iArrCreate2);
            iArr = iArrCreate;
            iArr2 = iArrCreate2;
        }
        boolean zIsOne2 = cVar6.isOne();
        if (zIsOne2) {
            iArr3 = cVar.f13897i;
            iArr4 = cVar2.f13897i;
        } else {
            b.square(cVar6.f13897i, iArrCreate3);
            b.multiply(iArrCreate3, cVar.f13897i, iArrCreateExt);
            b.multiply(iArrCreate3, cVar6.f13897i, iArrCreate3);
            b.multiply(iArrCreate3, cVar2.f13897i, iArrCreate3);
            iArr3 = iArrCreateExt;
            iArr4 = iArrCreate3;
        }
        int[] iArrCreate4 = h.create();
        b.subtract(iArr3, iArr, iArrCreate4);
        b.subtract(iArr4, iArr2, iArrCreate);
        if (h.isZero(iArrCreate4)) {
            return h.isZero(iArrCreate) ? twice() : curve.getInfinity();
        }
        int[] iArrCreate5 = h.create();
        b.square(iArrCreate4, iArrCreate5);
        int[] iArrCreate6 = h.create();
        b.multiply(iArrCreate5, iArrCreate4, iArrCreate6);
        b.multiply(iArrCreate5, iArr3, iArrCreate2);
        b.negate(iArrCreate6, iArrCreate6);
        h.mul(iArr4, iArrCreate6, iArrCreateExt);
        b.reduce27(h.addBothTo(iArrCreate2, iArrCreate2, iArrCreate6), iArrCreate6);
        c cVar7 = new c(iArrCreate3);
        b.square(iArrCreate, cVar7.f13897i);
        int[] iArr5 = cVar7.f13897i;
        b.subtract(iArr5, iArrCreate6, iArr5);
        c cVar8 = new c(iArrCreate6);
        b.subtract(iArrCreate2, cVar7.f13897i, cVar8.f13897i);
        b.multiplyAddToExt(cVar8.f13897i, iArrCreate, iArrCreateExt);
        b.reduce(iArrCreateExt, cVar8.f13897i);
        c cVar9 = new c(iArrCreate4);
        if (!zIsOne) {
            int[] iArr6 = cVar9.f13897i;
            b.multiply(iArr6, cVar3.f13897i, iArr6);
        }
        if (!zIsOne2) {
            int[] iArr7 = cVar9.f13897i;
            b.multiply(iArr7, cVar6.f13897i, iArr7);
        }
        if (!zIsOne || !zIsOne2) {
            iArrCreate5 = null;
        }
        return new d(curve, cVar7, cVar8, new f[]{cVar9, m(cVar9, iArrCreate5)});
    }

    @Override // g.a.g.a.i
    public i c() {
        return new d(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public f getZCoord(int i2) {
        return i2 == 1 ? n() : super.getZCoord(i2);
    }

    public c m(c cVar, int[] iArr) {
        c cVar2 = (c) getCurve().getA();
        if (cVar.isOne()) {
            return cVar2;
        }
        c cVar3 = new c();
        if (iArr == null) {
            iArr = cVar3.f13897i;
            b.square(cVar.f13897i, iArr);
        }
        b.square(iArr, cVar3.f13897i);
        int[] iArr2 = cVar3.f13897i;
        b.multiply(iArr2, cVar2.f13897i, iArr2);
        return cVar3;
    }

    public c n() {
        f[] fVarArr = this.f14129e;
        c cVar = (c) fVarArr[1];
        if (cVar != null) {
            return cVar;
        }
        c cVarM = m((c) fVarArr[0], null);
        fVarArr[1] = cVarM;
        return cVarM;
    }

    @Override // g.a.g.a.i
    public i negate() {
        return isInfinity() ? this : new d(getCurve(), this.f14127c, this.f14128d.negate(), this.f14129e);
    }

    public d o(boolean z) {
        c cVar = (c) this.f14127c;
        c cVar2 = (c) this.f14128d;
        c cVar3 = (c) this.f14129e[0];
        c cVarN = n();
        int[] iArrCreate = h.create();
        b.square(cVar.f13897i, iArrCreate);
        b.reduce27(h.addBothTo(iArrCreate, iArrCreate, iArrCreate) + h.addTo(cVarN.f13897i, iArrCreate), iArrCreate);
        int[] iArrCreate2 = h.create();
        b.twice(cVar2.f13897i, iArrCreate2);
        int[] iArrCreate3 = h.create();
        b.multiply(iArrCreate2, cVar2.f13897i, iArrCreate3);
        int[] iArrCreate4 = h.create();
        b.multiply(iArrCreate3, cVar.f13897i, iArrCreate4);
        b.twice(iArrCreate4, iArrCreate4);
        int[] iArrCreate5 = h.create();
        b.square(iArrCreate3, iArrCreate5);
        b.twice(iArrCreate5, iArrCreate5);
        c cVar4 = new c(iArrCreate3);
        b.square(iArrCreate, cVar4.f13897i);
        int[] iArr = cVar4.f13897i;
        b.subtract(iArr, iArrCreate4, iArr);
        int[] iArr2 = cVar4.f13897i;
        b.subtract(iArr2, iArrCreate4, iArr2);
        c cVar5 = new c(iArrCreate4);
        b.subtract(iArrCreate4, cVar4.f13897i, cVar5.f13897i);
        int[] iArr3 = cVar5.f13897i;
        b.multiply(iArr3, iArrCreate, iArr3);
        int[] iArr4 = cVar5.f13897i;
        b.subtract(iArr4, iArrCreate5, iArr4);
        c cVar6 = new c(iArrCreate2);
        if (!h.isOne(cVar3.f13897i)) {
            int[] iArr5 = cVar6.f13897i;
            b.multiply(iArr5, cVar3.f13897i, iArr5);
        }
        c cVar7 = null;
        if (z) {
            cVar7 = new c(iArrCreate5);
            int[] iArr6 = cVar7.f13897i;
            b.multiply(iArr6, cVarN.f13897i, iArr6);
            int[] iArr7 = cVar7.f13897i;
            b.twice(iArr7, iArr7);
        }
        return new d(getCurve(), cVar4, cVar5, new f[]{cVar6, cVar7});
    }

    @Override // g.a.g.a.i
    public i threeTimes() {
        return (isInfinity() || this.f14128d.isZero()) ? this : o(false).add(this);
    }

    @Override // g.a.g.a.i
    public i twice() {
        if (isInfinity()) {
            return this;
        }
        return this.f14128d.isZero() ? getCurve().getInfinity() : o(true);
    }

    @Override // g.a.g.a.i
    public i twicePlus(i iVar) {
        return this == iVar ? threeTimes() : isInfinity() ? iVar : iVar.isInfinity() ? twice() : this.f14128d.isZero() ? iVar : o(false).add(iVar);
    }
}
