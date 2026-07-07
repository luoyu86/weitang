package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class t2 extends i.b {
    public t2(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public t2(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
        super(eVar, fVar, fVar2, fVarArr);
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i add(g.a.g.a.i iVar) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        r2 r2Var;
        r2 r2Var2;
        r2 r2Var3;
        if (isInfinity()) {
            return iVar;
        }
        if (iVar.isInfinity()) {
            return this;
        }
        g.a.g.a.e curve = getCurve();
        r2 r2Var4 = (r2) this.f14127c;
        r2 r2Var5 = (r2) iVar.getRawXCoord();
        if (r2Var4.isZero()) {
            return r2Var5.isZero() ? curve.getInfinity() : iVar.add(this);
        }
        r2 r2Var6 = (r2) this.f14128d;
        r2 r2Var7 = (r2) this.f14129e[0];
        r2 r2Var8 = (r2) iVar.getRawYCoord();
        r2 r2Var9 = (r2) iVar.getZCoord(0);
        long[] jArrCreate64 = g.a.g.c.m.create64();
        long[] jArrCreate642 = g.a.g.c.m.create64();
        long[] jArrCreate643 = g.a.g.c.m.create64();
        long[] jArrCreate644 = g.a.g.c.m.create64();
        long[] jArrPrecompMultiplicand = r2Var7.isOne() ? null : q2.precompMultiplicand(r2Var7.f14029g);
        if (jArrPrecompMultiplicand == null) {
            jArr = r2Var5.f14029g;
            jArr2 = r2Var8.f14029g;
        } else {
            q2.multiplyPrecomp(r2Var5.f14029g, jArrPrecompMultiplicand, jArrCreate642);
            q2.multiplyPrecomp(r2Var8.f14029g, jArrPrecompMultiplicand, jArrCreate644);
            jArr = jArrCreate642;
            jArr2 = jArrCreate644;
        }
        long[] jArrPrecompMultiplicand2 = r2Var9.isOne() ? null : q2.precompMultiplicand(r2Var9.f14029g);
        long[] jArr4 = r2Var4.f14029g;
        if (jArrPrecompMultiplicand2 == null) {
            jArr3 = r2Var6.f14029g;
        } else {
            q2.multiplyPrecomp(jArr4, jArrPrecompMultiplicand2, jArrCreate64);
            q2.multiplyPrecomp(r2Var6.f14029g, jArrPrecompMultiplicand2, jArrCreate643);
            jArr4 = jArrCreate64;
            jArr3 = jArrCreate643;
        }
        q2.add(jArr3, jArr2, jArrCreate643);
        q2.add(jArr4, jArr, jArrCreate644);
        if (g.a.g.c.m.isZero64(jArrCreate644)) {
            return g.a.g.c.m.isZero64(jArrCreate643) ? twice() : curve.getInfinity();
        }
        if (r2Var5.isZero()) {
            g.a.g.a.i iVarNormalize = normalize();
            r2 r2Var10 = (r2) iVarNormalize.getXCoord();
            g.a.g.a.f yCoord = iVarNormalize.getYCoord();
            g.a.g.a.f fVarDivide = yCoord.add(r2Var8).divide(r2Var10);
            r2Var = (r2) fVarDivide.square().add(fVarDivide).add(r2Var10);
            if (r2Var.isZero()) {
                return new t2(curve, r2Var, curve.getB());
            }
            r2Var2 = (r2) fVarDivide.multiply(r2Var10.add(r2Var)).add(r2Var).add(yCoord).divide(r2Var).add(r2Var);
            r2Var3 = (r2) curve.fromBigInteger(g.a.g.a.d.f14091b);
        } else {
            q2.square(jArrCreate644, jArrCreate644);
            long[] jArrPrecompMultiplicand3 = q2.precompMultiplicand(jArrCreate643);
            q2.multiplyPrecomp(jArr4, jArrPrecompMultiplicand3, jArrCreate64);
            q2.multiplyPrecomp(jArr, jArrPrecompMultiplicand3, jArrCreate642);
            r2 r2Var11 = new r2(jArrCreate64);
            q2.multiply(jArrCreate64, jArrCreate642, r2Var11.f14029g);
            if (r2Var11.isZero()) {
                return new t2(curve, r2Var11, curve.getB());
            }
            r2 r2Var12 = new r2(jArrCreate643);
            q2.multiplyPrecomp(jArrCreate644, jArrPrecompMultiplicand3, r2Var12.f14029g);
            if (jArrPrecompMultiplicand2 != null) {
                long[] jArr5 = r2Var12.f14029g;
                q2.multiplyPrecomp(jArr5, jArrPrecompMultiplicand2, jArr5);
            }
            long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
            q2.add(jArrCreate642, jArrCreate644, jArrCreate644);
            q2.squareAddToExt(jArrCreate644, jArrCreateExt64);
            q2.add(r2Var6.f14029g, r2Var7.f14029g, jArrCreate644);
            q2.multiplyAddToExt(jArrCreate644, r2Var12.f14029g, jArrCreateExt64);
            r2 r2Var13 = new r2(jArrCreate644);
            q2.reduce(jArrCreateExt64, r2Var13.f14029g);
            if (jArrPrecompMultiplicand != null) {
                long[] jArr6 = r2Var12.f14029g;
                q2.multiplyPrecomp(jArr6, jArrPrecompMultiplicand, jArr6);
            }
            r2Var = r2Var11;
            r2Var2 = r2Var13;
            r2Var3 = r2Var12;
        }
        return new t2(curve, r2Var, r2Var2, new g.a.g.a.f[]{r2Var3});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new t2(null, getAffineXCoord(), getAffineYCoord());
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
        return new t2(this.f14126b, fVar, fVar2.add(fVar3), new g.a.g.a.f[]{fVar3});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twice() {
        if (isInfinity()) {
            return this;
        }
        g.a.g.a.e curve = getCurve();
        g.a.g.a.f fVar = this.f14127c;
        if (fVar.isZero()) {
            return curve.getInfinity();
        }
        g.a.g.a.f fVar2 = this.f14128d;
        g.a.g.a.f fVarSquare = this.f14129e[0];
        boolean zIsOne = fVarSquare.isOne();
        g.a.g.a.f fVarSquare2 = zIsOne ? fVarSquare : fVarSquare.square();
        g.a.g.a.f fVarAdd = zIsOne ? fVar2.square().add(fVar2) : fVar2.add(fVarSquare).multiply(fVar2);
        if (fVarAdd.isZero()) {
            return new t2(curve, fVarAdd, curve.getB());
        }
        g.a.g.a.f fVarSquare3 = fVarAdd.square();
        g.a.g.a.f fVarMultiply = zIsOne ? fVarAdd : fVarAdd.multiply(fVarSquare2);
        g.a.g.a.f fVarSquare4 = fVar2.add(fVar).square();
        if (!zIsOne) {
            fVarSquare = fVarSquare2.square();
        }
        return new t2(curve, fVarSquare3, fVarSquare4.add(fVarAdd).add(fVarSquare2).multiply(fVarSquare4).add(fVarSquare).add(fVarSquare3).add(fVarMultiply), new g.a.g.a.f[]{fVarMultiply});
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
        g.a.g.a.f fVarAdd = fVarSquare2.add(fVar2.multiply(fVar3));
        g.a.g.a.f fVarAddOne = rawYCoord.addOne();
        g.a.g.a.f fVarMultiplyPlusProduct = fVarAddOne.multiply(fVarSquare3).add(fVarSquare2).multiplyPlusProduct(fVarAdd, fVarSquare, fVarSquare3);
        g.a.g.a.f fVarMultiply = rawXCoord.multiply(fVarSquare3);
        g.a.g.a.f fVarSquare4 = fVarMultiply.add(fVarAdd).square();
        if (fVarSquare4.isZero()) {
            return fVarMultiplyPlusProduct.isZero() ? iVar.twice() : curve.getInfinity();
        }
        if (fVarMultiplyPlusProduct.isZero()) {
            return new t2(curve, fVarMultiplyPlusProduct, curve.getB());
        }
        g.a.g.a.f fVarMultiply2 = fVarMultiplyPlusProduct.square().multiply(fVarMultiply);
        g.a.g.a.f fVarMultiply3 = fVarMultiplyPlusProduct.multiply(fVarSquare4).multiply(fVarSquare3);
        return new t2(curve, fVarMultiply2, fVarMultiplyPlusProduct.add(fVarSquare4).square().multiplyPlusProduct(fVarAdd, fVarAddOne, fVarMultiply3), new g.a.g.a.f[]{fVarMultiply3});
    }
}
