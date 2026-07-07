package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class f1 extends i.b {
    public f1(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public f1(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i add(g.a.g.a.i iVar) {
        g.a.g.a.f fVarMultiply;
        g.a.g.a.f fVarMultiply2;
        g.a.g.a.f fVarMultiply3;
        g.a.g.a.f fVarAdd;
        g.a.g.a.f fVarFromBigInteger;
        g.a.g.a.f fVarAdd2;
        if (isInfinity()) {
            return iVar;
        }
        if (iVar.isInfinity()) {
            return this;
        }
        g.a.g.a.e curve = getCurve();
        g.a.g.a.f fVarMultiply4 = this.f14127c;
        g.a.g.a.f rawXCoord = iVar.getRawXCoord();
        if (fVarMultiply4.isZero()) {
            return rawXCoord.isZero() ? curve.getInfinity() : iVar.add(this);
        }
        g.a.g.a.f fVar = this.f14128d;
        g.a.g.a.f fVar2 = this.f14129e[0];
        g.a.g.a.f rawYCoord = iVar.getRawYCoord();
        g.a.g.a.f zCoord = iVar.getZCoord(0);
        boolean zIsOne = fVar2.isOne();
        if (zIsOne) {
            fVarMultiply = rawXCoord;
            fVarMultiply2 = rawYCoord;
        } else {
            fVarMultiply = rawXCoord.multiply(fVar2);
            fVarMultiply2 = rawYCoord.multiply(fVar2);
        }
        boolean zIsOne2 = zCoord.isOne();
        if (zIsOne2) {
            fVarMultiply3 = fVar;
        } else {
            fVarMultiply4 = fVarMultiply4.multiply(zCoord);
            fVarMultiply3 = fVar.multiply(zCoord);
        }
        g.a.g.a.f fVarAdd3 = fVarMultiply3.add(fVarMultiply2);
        g.a.g.a.f fVarAdd4 = fVarMultiply4.add(fVarMultiply);
        if (fVarAdd4.isZero()) {
            return fVarAdd3.isZero() ? twice() : curve.getInfinity();
        }
        if (rawXCoord.isZero()) {
            g.a.g.a.i iVarNormalize = normalize();
            g.a.g.a.f xCoord = iVarNormalize.getXCoord();
            g.a.g.a.f yCoord = iVarNormalize.getYCoord();
            g.a.g.a.f fVarDivide = yCoord.add(rawYCoord).divide(xCoord);
            fVarAdd = fVarDivide.square().add(fVarDivide).add(xCoord).add(curve.getA());
            if (fVarAdd.isZero()) {
                return new f1(curve, fVarAdd, curve.getB().sqrt());
            }
            fVarAdd2 = fVarDivide.multiply(xCoord.add(fVarAdd)).add(fVarAdd).add(yCoord).divide(fVarAdd).add(fVarAdd);
            fVarFromBigInteger = curve.fromBigInteger(g.a.g.a.d.f14091b);
        } else {
            g.a.g.a.f fVarSquare = fVarAdd4.square();
            g.a.g.a.f fVarMultiply5 = fVarAdd3.multiply(fVarMultiply4);
            g.a.g.a.f fVarMultiply6 = fVarAdd3.multiply(fVarMultiply);
            g.a.g.a.f fVarMultiply7 = fVarMultiply5.multiply(fVarMultiply6);
            if (fVarMultiply7.isZero()) {
                return new f1(curve, fVarMultiply7, curve.getB().sqrt());
            }
            g.a.g.a.f fVarMultiply8 = fVarAdd3.multiply(fVarSquare);
            g.a.g.a.f fVarMultiply9 = !zIsOne2 ? fVarMultiply8.multiply(zCoord) : fVarMultiply8;
            g.a.g.a.f fVarSquarePlusProduct = fVarMultiply6.add(fVarSquare).squarePlusProduct(fVarMultiply9, fVar.add(fVar2));
            if (!zIsOne) {
                fVarMultiply9 = fVarMultiply9.multiply(fVar2);
            }
            fVarAdd = fVarMultiply7;
            fVarFromBigInteger = fVarMultiply9;
            fVarAdd2 = fVarSquarePlusProduct;
        }
        return new f1(curve, fVarAdd, fVarAdd2, new g.a.g.a.f[]{fVarFromBigInteger});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new f1(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // g.a.g.a.i
    public boolean d() {
        g.a.g.a.f rawXCoord = getRawXCoord();
        return (rawXCoord.isZero() || getRawYCoord().testBitZero() == rawXCoord.testBitZero()) ? false : true;
    }

    @Override // g.a.g.a.i
    public g.a.g.a.f getYCoord() {
        g.a.g.a.f fVar = this.f14127c;
        g.a.g.a.f fVar2 = this.f14128d;
        if (isInfinity() || fVar.isZero()) {
            return fVar2;
        }
        g.a.g.a.f fVarMultiply = fVar2.add(fVar).multiply(fVar);
        g.a.g.a.f fVar3 = this.f14129e[0];
        return !fVar3.isOne() ? fVarMultiply.divide(fVar3) : fVarMultiply;
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i negate() {
        if (isInfinity()) {
            return this;
        }
        g.a.g.a.f fVar = this.f14127c;
        if (fVar.isZero()) {
            return this;
        }
        g.a.g.a.f fVar2 = this.f14128d;
        g.a.g.a.f fVar3 = this.f14129e[0];
        return new f1(this.f14126b, fVar, fVar2.add(fVar3), new g.a.g.a.f[]{fVar3});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twice() {
        if (isInfinity()) {
            return this;
        }
        g.a.g.a.e curve = getCurve();
        g.a.g.a.f fVarMultiply = this.f14127c;
        if (fVarMultiply.isZero()) {
            return curve.getInfinity();
        }
        g.a.g.a.f fVar = this.f14128d;
        g.a.g.a.f fVar2 = this.f14129e[0];
        boolean zIsOne = fVar2.isOne();
        g.a.g.a.f fVarMultiply2 = zIsOne ? fVar : fVar.multiply(fVar2);
        g.a.g.a.f fVarSquare = zIsOne ? fVar2 : fVar2.square();
        g.a.g.a.f a2 = curve.getA();
        if (!zIsOne) {
            a2 = a2.multiply(fVarSquare);
        }
        g.a.g.a.f fVarAdd = fVar.square().add(fVarMultiply2).add(a2);
        if (fVarAdd.isZero()) {
            return new f1(curve, fVarAdd, curve.getB().sqrt());
        }
        g.a.g.a.f fVarSquare2 = fVarAdd.square();
        g.a.g.a.f fVarMultiply3 = zIsOne ? fVarAdd : fVarAdd.multiply(fVarSquare);
        if (!zIsOne) {
            fVarMultiply = fVarMultiply.multiply(fVar2);
        }
        return new f1(curve, fVarSquare2, fVarMultiply.squarePlusProduct(fVarAdd, fVarMultiply2).add(fVarSquare2).add(fVarMultiply3), new g.a.g.a.f[]{fVarMultiply3});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twicePlus(g.a.g.a.i iVar) {
        if (isInfinity()) {
            return iVar;
        }
        if (iVar.isInfinity()) {
            return twice();
        }
        g.a.g.a.e curve = getCurve();
        g.a.g.a.f fVar = this.f14127c;
        if (fVar.isZero()) {
            return iVar;
        }
        g.a.g.a.f rawXCoord = iVar.getRawXCoord();
        g.a.g.a.f zCoord = iVar.getZCoord(0);
        if (rawXCoord.isZero() || !zCoord.isOne()) {
            return twice().add(iVar);
        }
        g.a.g.a.f fVar2 = this.f14128d;
        g.a.g.a.f fVar3 = this.f14129e[0];
        g.a.g.a.f rawYCoord = iVar.getRawYCoord();
        g.a.g.a.f fVarSquare = fVar.square();
        g.a.g.a.f fVarSquare2 = fVar2.square();
        g.a.g.a.f fVarSquare3 = fVar3.square();
        g.a.g.a.f fVarAdd = curve.getA().multiply(fVarSquare3).add(fVarSquare2).add(fVar2.multiply(fVar3));
        g.a.g.a.f fVarAddOne = rawYCoord.addOne();
        g.a.g.a.f fVarMultiplyPlusProduct = curve.getA().add(fVarAddOne).multiply(fVarSquare3).add(fVarSquare2).multiplyPlusProduct(fVarAdd, fVarSquare, fVarSquare3);
        g.a.g.a.f fVarMultiply = rawXCoord.multiply(fVarSquare3);
        g.a.g.a.f fVarSquare4 = fVarMultiply.add(fVarAdd).square();
        if (fVarSquare4.isZero()) {
            return fVarMultiplyPlusProduct.isZero() ? iVar.twice() : curve.getInfinity();
        }
        if (fVarMultiplyPlusProduct.isZero()) {
            return new f1(curve, fVarMultiplyPlusProduct, curve.getB().sqrt());
        }
        g.a.g.a.f fVarMultiply2 = fVarMultiplyPlusProduct.square().multiply(fVarMultiply);
        g.a.g.a.f fVarMultiply3 = fVarMultiplyPlusProduct.multiply(fVarSquare4).multiply(fVarSquare3);
        return new f1(curve, fVarMultiply2, fVarMultiplyPlusProduct.add(fVarSquare4).square().multiplyPlusProduct(fVarAdd, fVarAddOne, fVarMultiply3), new g.a.g.a.f[]{fVarMultiply3});
    }
}
