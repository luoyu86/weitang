package g.a.g.a.b0.c;

import g.a.g.a.i;

/* JADX INFO: loaded from: classes3.dex */
public class v2 extends i.b {
    public v2(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        super(eVar, fVar, fVar2);
    }

    public v2(g.a.g.a.e eVar, g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f[] fVarArr) {
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
            r2Var = (r2) fVarDivide.square().add(fVarDivide).add(r2Var10).addOne();
            if (r2Var.isZero()) {
                return new v2(curve, r2Var, u2.l);
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
                return new v2(curve, r2Var11, u2.l);
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
        return new v2(curve, r2Var, r2Var2, new g.a.g.a.f[]{r2Var3});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i c() {
        return new v2(null, getAffineXCoord(), getAffineYCoord());
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
        return new v2(this.f14126b, fVar, fVar2.add(fVar3), new g.a.g.a.f[]{fVar3});
    }

    @Override // g.a.g.a.i
    public g.a.g.a.i twice() {
        long[] jArr;
        if (isInfinity()) {
            return this;
        }
        g.a.g.a.e curve = getCurve();
        r2 r2Var = (r2) this.f14127c;
        if (r2Var.isZero()) {
            return curve.getInfinity();
        }
        r2 r2Var2 = (r2) this.f14128d;
        r2 r2Var3 = (r2) this.f14129e[0];
        long[] jArrCreate64 = g.a.g.c.m.create64();
        long[] jArrCreate642 = g.a.g.c.m.create64();
        long[] jArrPrecompMultiplicand = r2Var3.isOne() ? null : q2.precompMultiplicand(r2Var3.f14029g);
        long[] jArr2 = r2Var2.f14029g;
        if (jArrPrecompMultiplicand == null) {
            jArr = r2Var3.f14029g;
        } else {
            q2.multiplyPrecomp(jArr2, jArrPrecompMultiplicand, jArrCreate64);
            q2.square(r2Var3.f14029g, jArrCreate642);
            jArr2 = jArrCreate64;
            jArr = jArrCreate642;
        }
        long[] jArrCreate643 = g.a.g.c.m.create64();
        q2.square(r2Var2.f14029g, jArrCreate643);
        q2.addBothTo(jArr2, jArr, jArrCreate643);
        if (g.a.g.c.m.isZero64(jArrCreate643)) {
            return new v2(curve, new r2(jArrCreate643), u2.l);
        }
        long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
        q2.multiplyAddToExt(jArrCreate643, jArr2, jArrCreateExt64);
        r2 r2Var4 = new r2(jArrCreate64);
        q2.square(jArrCreate643, r2Var4.f14029g);
        r2 r2Var5 = new r2(jArrCreate643);
        if (jArrPrecompMultiplicand != null) {
            long[] jArr3 = r2Var5.f14029g;
            q2.multiply(jArr3, jArr, jArr3);
        }
        long[] jArr4 = r2Var.f14029g;
        if (jArrPrecompMultiplicand != null) {
            q2.multiplyPrecomp(jArr4, jArrPrecompMultiplicand, jArrCreate642);
            jArr4 = jArrCreate642;
        }
        q2.squareAddToExt(jArr4, jArrCreateExt64);
        q2.reduce(jArrCreateExt64, jArrCreate642);
        q2.addBothTo(r2Var4.f14029g, r2Var5.f14029g, jArrCreate642);
        return new v2(curve, r2Var4, new r2(jArrCreate642), new g.a.g.a.f[]{r2Var5});
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
        r2 r2Var = (r2) this.f14127c;
        if (r2Var.isZero()) {
            return iVar;
        }
        r2 r2Var2 = (r2) iVar.getRawXCoord();
        r2 r2Var3 = (r2) iVar.getZCoord(0);
        if (r2Var2.isZero() || !r2Var3.isOne()) {
            return twice().add(iVar);
        }
        r2 r2Var4 = (r2) this.f14128d;
        r2 r2Var5 = (r2) this.f14129e[0];
        r2 r2Var6 = (r2) iVar.getRawYCoord();
        long[] jArrCreate64 = g.a.g.c.m.create64();
        long[] jArrCreate642 = g.a.g.c.m.create64();
        long[] jArrCreate643 = g.a.g.c.m.create64();
        long[] jArrCreate644 = g.a.g.c.m.create64();
        q2.square(r2Var.f14029g, jArrCreate64);
        q2.square(r2Var4.f14029g, jArrCreate642);
        q2.square(r2Var5.f14029g, jArrCreate643);
        q2.multiply(r2Var4.f14029g, r2Var5.f14029g, jArrCreate644);
        q2.addBothTo(jArrCreate643, jArrCreate642, jArrCreate644);
        long[] jArrPrecompMultiplicand = q2.precompMultiplicand(jArrCreate643);
        q2.multiplyPrecomp(r2Var6.f14029g, jArrPrecompMultiplicand, jArrCreate643);
        q2.add(jArrCreate643, jArrCreate642, jArrCreate643);
        long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
        q2.multiplyAddToExt(jArrCreate643, jArrCreate644, jArrCreateExt64);
        q2.multiplyPrecompAddToExt(jArrCreate64, jArrPrecompMultiplicand, jArrCreateExt64);
        q2.reduce(jArrCreateExt64, jArrCreate643);
        q2.multiplyPrecomp(r2Var2.f14029g, jArrPrecompMultiplicand, jArrCreate64);
        q2.add(jArrCreate64, jArrCreate644, jArrCreate642);
        q2.square(jArrCreate642, jArrCreate642);
        if (g.a.g.c.m.isZero64(jArrCreate642)) {
            return g.a.g.c.m.isZero64(jArrCreate643) ? iVar.twice() : curve.getInfinity();
        }
        if (g.a.g.c.m.isZero64(jArrCreate643)) {
            return new v2(curve, new r2(jArrCreate643), u2.l);
        }
        r2 r2Var7 = new r2();
        q2.square(jArrCreate643, r2Var7.f14029g);
        long[] jArr = r2Var7.f14029g;
        q2.multiply(jArr, jArrCreate64, jArr);
        r2 r2Var8 = new r2(jArrCreate64);
        q2.multiply(jArrCreate643, jArrCreate642, r2Var8.f14029g);
        long[] jArr2 = r2Var8.f14029g;
        q2.multiplyPrecomp(jArr2, jArrPrecompMultiplicand, jArr2);
        r2 r2Var9 = new r2(jArrCreate642);
        q2.add(jArrCreate643, jArrCreate642, r2Var9.f14029g);
        long[] jArr3 = r2Var9.f14029g;
        q2.square(jArr3, jArr3);
        g.a.g.c.n.zero64(18, jArrCreateExt64);
        q2.multiplyAddToExt(r2Var9.f14029g, jArrCreate644, jArrCreateExt64);
        q2.addOne(r2Var6.f14029g, jArrCreate644);
        q2.multiplyAddToExt(jArrCreate644, r2Var8.f14029g, jArrCreateExt64);
        q2.reduce(jArrCreateExt64, r2Var9.f14029g);
        return new v2(curve, r2Var7, r2Var9, new g.a.g.a.f[]{r2Var8});
    }
}
