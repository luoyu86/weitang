package g.a.g.a;

import androidx.core.view.InputDeviceCompat;
import g.a.g.a.e;
import g.a.g.a.f;
import java.math.BigInteger;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f[] f14125a = new f[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.g.a.e f14126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f14127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f14128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f[] f14129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Hashtable f14130f;

    public class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f14132b;

        public a(boolean z, boolean z2) {
            this.f14131a = z;
            this.f14132b = z2;
        }

        @Override // g.a.g.a.p
        public q precompute(q qVar) {
            u uVar = qVar instanceof u ? (u) qVar : null;
            if (uVar == null) {
                uVar = new u();
            }
            if (uVar.b()) {
                return uVar;
            }
            if (!uVar.a()) {
                if (!this.f14131a && !i.this.k()) {
                    uVar.e();
                    return uVar;
                }
                uVar.d();
            }
            if (this.f14132b && !uVar.c()) {
                if (!i.this.l()) {
                    uVar.e();
                    return uVar;
                }
                uVar.f();
            }
            return uVar;
        }
    }

    public static abstract class b extends i {
        public b(g.a.g.a.e eVar, f fVar, f fVar2) {
            super(eVar, fVar, fVar2);
        }

        public b(g.a.g.a.e eVar, f fVar, f fVar2, f[] fVarArr) {
            super(eVar, fVar, fVar2, fVarArr);
        }

        @Override // g.a.g.a.i
        public boolean k() {
            f fVarMultiplyPlusProduct;
            f fVarSquarePlusProduct;
            g.a.g.a.e curve = getCurve();
            f fVar = this.f14127c;
            f a2 = curve.getA();
            f b2 = curve.getB();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 6) {
                f fVar2 = this.f14128d;
                f fVarMultiply = fVar2.add(fVar).multiply(fVar2);
                if (coordinateSystem != 0) {
                    if (coordinateSystem != 1) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    f fVar3 = this.f14129e[0];
                    if (!fVar3.isOne()) {
                        f fVarMultiply2 = fVar3.multiply(fVar3.square());
                        fVarMultiply = fVarMultiply.multiply(fVar3);
                        a2 = a2.multiply(fVar3);
                        b2 = b2.multiply(fVarMultiply2);
                    }
                }
                return fVarMultiply.equals(fVar.add(a2).multiply(fVar.square()).add(b2));
            }
            f fVar4 = this.f14129e[0];
            boolean zIsOne = fVar4.isOne();
            if (fVar.isZero()) {
                f fVarSquare = this.f14128d.square();
                if (!zIsOne) {
                    b2 = b2.multiply(fVar4.square());
                }
                return fVarSquare.equals(b2);
            }
            f fVar5 = this.f14128d;
            f fVarSquare2 = fVar.square();
            if (zIsOne) {
                fVarMultiplyPlusProduct = fVar5.square().add(fVar5).add(a2);
                fVarSquarePlusProduct = fVarSquare2.square().add(b2);
            } else {
                f fVarSquare3 = fVar4.square();
                f fVarSquare4 = fVarSquare3.square();
                fVarMultiplyPlusProduct = fVar5.add(fVar4).multiplyPlusProduct(fVar5, a2, fVarSquare3);
                fVarSquarePlusProduct = fVarSquare2.squarePlusProduct(b2, fVarSquare4);
            }
            return fVarMultiplyPlusProduct.multiply(fVarSquare2).equals(fVarSquarePlusProduct);
        }

        @Override // g.a.g.a.i
        public boolean l() {
            BigInteger cofactor = this.f14126b.getCofactor();
            if (g.a.g.a.d.f14092c.equals(cofactor)) {
                return ((f.a) normalize().getAffineXCoord()).trace() != 0;
            }
            if (!g.a.g.a.d.f14094e.equals(cofactor)) {
                return super.l();
            }
            i iVarNormalize = normalize();
            f affineXCoord = iVarNormalize.getAffineXCoord();
            g.a.g.a.e eVar = this.f14126b;
            f fVarK = ((e.b) eVar).k(affineXCoord.add(eVar.getA()));
            if (fVarK == null) {
                return false;
            }
            return ((f.a) affineXCoord.multiply(fVarK).add(iVarNormalize.getAffineYCoord())).trace() == 0;
        }

        @Override // g.a.g.a.i
        public i scaleX(f fVar) {
            if (isInfinity()) {
                return this;
            }
            int iE = e();
            if (iE == 5) {
                f rawXCoord = getRawXCoord();
                return getCurve().f(rawXCoord, getRawYCoord().add(rawXCoord).divide(fVar).add(rawXCoord.multiply(fVar)), g());
            }
            if (iE != 6) {
                return super.scaleX(fVar);
            }
            f rawXCoord2 = getRawXCoord();
            f rawYCoord = getRawYCoord();
            f fVar2 = g()[0];
            f fVarMultiply = rawXCoord2.multiply(fVar.square());
            return getCurve().f(fVarMultiply, rawYCoord.add(rawXCoord2).add(fVarMultiply), new f[]{fVar2.multiply(fVar)});
        }

        @Override // g.a.g.a.i
        public i scaleXNegateY(f fVar) {
            return scaleX(fVar);
        }

        @Override // g.a.g.a.i
        public i scaleY(f fVar) {
            if (isInfinity()) {
                return this;
            }
            int iE = e();
            if (iE != 5 && iE != 6) {
                return super.scaleY(fVar);
            }
            f rawXCoord = getRawXCoord();
            return getCurve().f(rawXCoord, getRawYCoord().add(rawXCoord).multiply(fVar).add(rawXCoord), g());
        }

        @Override // g.a.g.a.i
        public i scaleYNegateX(f fVar) {
            return scaleY(fVar);
        }

        @Override // g.a.g.a.i
        public i subtract(i iVar) {
            return iVar.isInfinity() ? this : add(iVar.negate());
        }

        public b tau() {
            i iVarE;
            if (isInfinity()) {
                return this;
            }
            g.a.g.a.e curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            f fVar = this.f14127c;
            if (coordinateSystem == 0) {
                iVarE = curve.e(fVar.square(), this.f14128d.square());
            } else {
                if (coordinateSystem != 1) {
                    if (coordinateSystem != 5) {
                        if (coordinateSystem != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                    iVarE = curve.e(fVar.square(), this.f14128d.square());
                }
                iVarE = curve.f(fVar.square(), this.f14128d.square(), new f[]{this.f14129e[0].square()});
            }
            return (b) iVarE;
        }

        public b tauPow(int i2) {
            i iVarE;
            if (isInfinity()) {
                return this;
            }
            g.a.g.a.e curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            f fVar = this.f14127c;
            if (coordinateSystem == 0) {
                iVarE = curve.e(fVar.squarePow(i2), this.f14128d.squarePow(i2));
            } else {
                if (coordinateSystem != 1) {
                    if (coordinateSystem != 5) {
                        if (coordinateSystem != 6) {
                            throw new IllegalStateException("unsupported coordinate system");
                        }
                    }
                    iVarE = curve.e(fVar.squarePow(i2), this.f14128d.squarePow(i2));
                }
                iVarE = curve.f(fVar.squarePow(i2), this.f14128d.squarePow(i2), new f[]{this.f14129e[0].squarePow(i2)});
            }
            return (b) iVarE;
        }
    }

    public static abstract class c extends i {
        public c(g.a.g.a.e eVar, f fVar, f fVar2) {
            super(eVar, fVar, fVar2);
        }

        public c(g.a.g.a.e eVar, f fVar, f fVar2, f[] fVarArr) {
            super(eVar, fVar, fVar2, fVarArr);
        }

        @Override // g.a.g.a.i
        public boolean d() {
            return getAffineYCoord().testBitZero();
        }

        @Override // g.a.g.a.i
        public boolean k() {
            f fVar = this.f14127c;
            f fVar2 = this.f14128d;
            f a2 = this.f14126b.getA();
            f b2 = this.f14126b.getB();
            f fVarSquare = fVar2.square();
            int iE = e();
            if (iE != 0) {
                if (iE == 1) {
                    f fVar3 = this.f14129e[0];
                    if (!fVar3.isOne()) {
                        f fVarSquare2 = fVar3.square();
                        f fVarMultiply = fVar3.multiply(fVarSquare2);
                        fVarSquare = fVarSquare.multiply(fVar3);
                        a2 = a2.multiply(fVarSquare2);
                        b2 = b2.multiply(fVarMultiply);
                    }
                } else {
                    if (iE != 2 && iE != 3 && iE != 4) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    f fVar4 = this.f14129e[0];
                    if (!fVar4.isOne()) {
                        f fVarSquare3 = fVar4.square();
                        f fVarSquare4 = fVarSquare3.square();
                        f fVarMultiply2 = fVarSquare3.multiply(fVarSquare4);
                        a2 = a2.multiply(fVarSquare4);
                        b2 = b2.multiply(fVarMultiply2);
                    }
                }
            }
            return fVarSquare.equals(fVar.square().add(a2).multiply(fVar).add(b2));
        }

        @Override // g.a.g.a.i
        public i subtract(i iVar) {
            return iVar.isInfinity() ? this : add(iVar.negate());
        }
    }

    public static class d extends b {
        public d(g.a.g.a.e eVar, f fVar, f fVar2) {
            super(eVar, fVar, fVar2);
        }

        public d(g.a.g.a.e eVar, f fVar, f fVar2, f[] fVarArr) {
            super(eVar, fVar, fVar2, fVarArr);
        }

        @Override // g.a.g.a.i
        public i add(i iVar) {
            f fVarMultiply;
            f fVarMultiply2;
            f fVarMultiply3;
            f fVarAdd;
            f fVarFromBigInteger;
            f fVarAdd2;
            if (isInfinity()) {
                return iVar;
            }
            if (iVar.isInfinity()) {
                return this;
            }
            g.a.g.a.e curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            f fVarMultiply4 = this.f14127c;
            f fVar = iVar.f14127c;
            if (coordinateSystem == 0) {
                f fVar2 = this.f14128d;
                f fVar3 = iVar.f14128d;
                f fVarAdd3 = fVarMultiply4.add(fVar);
                f fVarAdd4 = fVar2.add(fVar3);
                if (fVarAdd3.isZero()) {
                    return fVarAdd4.isZero() ? twice() : curve.getInfinity();
                }
                f fVarDivide = fVarAdd4.divide(fVarAdd3);
                f fVarAdd5 = fVarDivide.square().add(fVarDivide).add(fVarAdd3).add(curve.getA());
                return new d(curve, fVarAdd5, fVarDivide.multiply(fVarMultiply4.add(fVarAdd5)).add(fVarAdd5).add(fVar2));
            }
            if (coordinateSystem == 1) {
                f fVar4 = this.f14128d;
                f fVarMultiply5 = this.f14129e[0];
                f fVar5 = iVar.f14128d;
                f fVar6 = iVar.f14129e[0];
                boolean zIsOne = fVar6.isOne();
                f fVarAdd6 = fVarMultiply5.multiply(fVar5).add(zIsOne ? fVar4 : fVar4.multiply(fVar6));
                f fVarAdd7 = fVarMultiply5.multiply(fVar).add(zIsOne ? fVarMultiply4 : fVarMultiply4.multiply(fVar6));
                if (fVarAdd7.isZero()) {
                    return fVarAdd6.isZero() ? twice() : curve.getInfinity();
                }
                f fVarSquare = fVarAdd7.square();
                f fVarMultiply6 = fVarSquare.multiply(fVarAdd7);
                if (!zIsOne) {
                    fVarMultiply5 = fVarMultiply5.multiply(fVar6);
                }
                f fVarAdd8 = fVarAdd6.add(fVarAdd7);
                f fVarAdd9 = fVarAdd8.multiplyPlusProduct(fVarAdd6, fVarSquare, curve.getA()).multiply(fVarMultiply5).add(fVarMultiply6);
                f fVarMultiply7 = fVarAdd7.multiply(fVarAdd9);
                if (!zIsOne) {
                    fVarSquare = fVarSquare.multiply(fVar6);
                }
                return new d(curve, fVarMultiply7, fVarAdd6.multiplyPlusProduct(fVarMultiply4, fVarAdd7, fVar4).multiplyPlusProduct(fVarSquare, fVarAdd8, fVarAdd9), new f[]{fVarMultiply6.multiply(fVarMultiply5)});
            }
            if (coordinateSystem != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            if (fVarMultiply4.isZero()) {
                return fVar.isZero() ? curve.getInfinity() : iVar.add(this);
            }
            f fVar7 = this.f14128d;
            f fVar8 = this.f14129e[0];
            f fVar9 = iVar.f14128d;
            f fVar10 = iVar.f14129e[0];
            boolean zIsOne2 = fVar8.isOne();
            if (zIsOne2) {
                fVarMultiply = fVar;
                fVarMultiply2 = fVar9;
            } else {
                fVarMultiply = fVar.multiply(fVar8);
                fVarMultiply2 = fVar9.multiply(fVar8);
            }
            boolean zIsOne3 = fVar10.isOne();
            if (zIsOne3) {
                fVarMultiply3 = fVar7;
            } else {
                fVarMultiply4 = fVarMultiply4.multiply(fVar10);
                fVarMultiply3 = fVar7.multiply(fVar10);
            }
            f fVarAdd10 = fVarMultiply3.add(fVarMultiply2);
            f fVarAdd11 = fVarMultiply4.add(fVarMultiply);
            if (fVarAdd11.isZero()) {
                return fVarAdd10.isZero() ? twice() : curve.getInfinity();
            }
            if (fVar.isZero()) {
                i iVarNormalize = normalize();
                f xCoord = iVarNormalize.getXCoord();
                f yCoord = iVarNormalize.getYCoord();
                f fVarDivide2 = yCoord.add(fVar9).divide(xCoord);
                fVarAdd = fVarDivide2.square().add(fVarDivide2).add(xCoord).add(curve.getA());
                if (fVarAdd.isZero()) {
                    return new d(curve, fVarAdd, curve.getB().sqrt());
                }
                fVarAdd2 = fVarDivide2.multiply(xCoord.add(fVarAdd)).add(fVarAdd).add(yCoord).divide(fVarAdd).add(fVarAdd);
                fVarFromBigInteger = curve.fromBigInteger(g.a.g.a.d.f14091b);
            } else {
                f fVarSquare2 = fVarAdd11.square();
                f fVarMultiply8 = fVarAdd10.multiply(fVarMultiply4);
                f fVarMultiply9 = fVarAdd10.multiply(fVarMultiply);
                f fVarMultiply10 = fVarMultiply8.multiply(fVarMultiply9);
                if (fVarMultiply10.isZero()) {
                    return new d(curve, fVarMultiply10, curve.getB().sqrt());
                }
                f fVarMultiply11 = fVarAdd10.multiply(fVarSquare2);
                f fVarMultiply12 = !zIsOne3 ? fVarMultiply11.multiply(fVar10) : fVarMultiply11;
                f fVarSquarePlusProduct = fVarMultiply9.add(fVarSquare2).squarePlusProduct(fVarMultiply12, fVar7.add(fVar8));
                if (!zIsOne2) {
                    fVarMultiply12 = fVarMultiply12.multiply(fVar8);
                }
                fVarAdd = fVarMultiply10;
                fVarFromBigInteger = fVarMultiply12;
                fVarAdd2 = fVarSquarePlusProduct;
            }
            return new d(curve, fVarAdd, fVarAdd2, new f[]{fVarFromBigInteger});
        }

        @Override // g.a.g.a.i
        public i c() {
            return new d(null, getAffineXCoord(), getAffineYCoord());
        }

        @Override // g.a.g.a.i
        public boolean d() {
            f rawXCoord = getRawXCoord();
            if (rawXCoord.isZero()) {
                return false;
            }
            f rawYCoord = getRawYCoord();
            int iE = e();
            return (iE == 5 || iE == 6) ? rawYCoord.testBitZero() != rawXCoord.testBitZero() : rawYCoord.divide(rawXCoord).testBitZero();
        }

        @Override // g.a.g.a.i
        public f getYCoord() {
            int iE = e();
            if (iE != 5 && iE != 6) {
                return this.f14128d;
            }
            f fVar = this.f14127c;
            f fVar2 = this.f14128d;
            if (isInfinity() || fVar.isZero()) {
                return fVar2;
            }
            f fVarMultiply = fVar2.add(fVar).multiply(fVar);
            if (6 != iE) {
                return fVarMultiply;
            }
            f fVar3 = this.f14129e[0];
            return !fVar3.isOne() ? fVarMultiply.divide(fVar3) : fVarMultiply;
        }

        @Override // g.a.g.a.i
        public i negate() {
            if (isInfinity()) {
                return this;
            }
            f fVar = this.f14127c;
            if (fVar.isZero()) {
                return this;
            }
            int iE = e();
            if (iE == 0) {
                return new d(this.f14126b, fVar, this.f14128d.add(fVar));
            }
            if (iE == 1) {
                return new d(this.f14126b, fVar, this.f14128d.add(fVar), new f[]{this.f14129e[0]});
            }
            if (iE == 5) {
                return new d(this.f14126b, fVar, this.f14128d.addOne());
            }
            if (iE != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            f fVar2 = this.f14128d;
            f fVar3 = this.f14129e[0];
            return new d(this.f14126b, fVar, fVar2.add(fVar3), new f[]{fVar3});
        }

        @Override // g.a.g.a.i
        public i twice() {
            f fVarAdd;
            if (isInfinity()) {
                return this;
            }
            g.a.g.a.e curve = getCurve();
            f fVarMultiply = this.f14127c;
            if (fVarMultiply.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem == 0) {
                f fVarAdd2 = this.f14128d.divide(fVarMultiply).add(fVarMultiply);
                f fVarAdd3 = fVarAdd2.square().add(fVarAdd2).add(curve.getA());
                return new d(curve, fVarAdd3, fVarMultiply.squarePlusProduct(fVarAdd3, fVarAdd2.addOne()));
            }
            if (coordinateSystem == 1) {
                f fVarMultiply2 = this.f14128d;
                f fVar = this.f14129e[0];
                boolean zIsOne = fVar.isOne();
                f fVarMultiply3 = zIsOne ? fVarMultiply : fVarMultiply.multiply(fVar);
                if (!zIsOne) {
                    fVarMultiply2 = fVarMultiply2.multiply(fVar);
                }
                f fVarSquare = fVarMultiply.square();
                f fVarAdd4 = fVarSquare.add(fVarMultiply2);
                f fVarSquare2 = fVarMultiply3.square();
                f fVarAdd5 = fVarAdd4.add(fVarMultiply3);
                f fVarMultiplyPlusProduct = fVarAdd5.multiplyPlusProduct(fVarAdd4, fVarSquare2, curve.getA());
                return new d(curve, fVarMultiply3.multiply(fVarMultiplyPlusProduct), fVarSquare.square().multiplyPlusProduct(fVarMultiply3, fVarMultiplyPlusProduct, fVarAdd5), new f[]{fVarMultiply3.multiply(fVarSquare2)});
            }
            if (coordinateSystem != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            f fVar2 = this.f14128d;
            f fVar3 = this.f14129e[0];
            boolean zIsOne2 = fVar3.isOne();
            f fVarMultiply4 = zIsOne2 ? fVar2 : fVar2.multiply(fVar3);
            f fVarSquare3 = zIsOne2 ? fVar3 : fVar3.square();
            f a2 = curve.getA();
            f fVarMultiply5 = zIsOne2 ? a2 : a2.multiply(fVarSquare3);
            f fVarAdd6 = fVar2.square().add(fVarMultiply4).add(fVarMultiply5);
            if (fVarAdd6.isZero()) {
                return new d(curve, fVarAdd6, curve.getB().sqrt());
            }
            f fVarSquare4 = fVarAdd6.square();
            f fVarMultiply6 = zIsOne2 ? fVarAdd6 : fVarAdd6.multiply(fVarSquare3);
            f b2 = curve.getB();
            if (b2.bitLength() < (curve.getFieldSize() >> 1)) {
                f fVarSquare5 = fVar2.add(fVarMultiply).square();
                fVarAdd = fVarSquare5.add(fVarAdd6).add(fVarSquare3).multiply(fVarSquare5).add(b2.isOne() ? fVarMultiply5.add(fVarSquare3).square() : fVarMultiply5.squarePlusProduct(b2, fVarSquare3.square())).add(fVarSquare4);
                if (!a2.isZero()) {
                    if (!a2.isOne()) {
                        fVarAdd = fVarAdd.add(a2.addOne().multiply(fVarMultiply6));
                    }
                }
                return new d(curve, fVarSquare4, fVarAdd, new f[]{fVarMultiply6});
            }
            if (!zIsOne2) {
                fVarMultiply = fVarMultiply.multiply(fVar3);
            }
            fVarAdd = fVarMultiply.squarePlusProduct(fVarAdd6, fVarMultiply4).add(fVarSquare4);
            fVarAdd = fVarAdd.add(fVarMultiply6);
            return new d(curve, fVarSquare4, fVarAdd, new f[]{fVarMultiply6});
        }

        @Override // g.a.g.a.i
        public i twicePlus(i iVar) {
            if (isInfinity()) {
                return iVar;
            }
            if (iVar.isInfinity()) {
                return twice();
            }
            g.a.g.a.e curve = getCurve();
            f fVar = this.f14127c;
            if (fVar.isZero()) {
                return iVar;
            }
            if (curve.getCoordinateSystem() != 6) {
                return twice().add(iVar);
            }
            f fVar2 = iVar.f14127c;
            f fVar3 = iVar.f14129e[0];
            if (fVar2.isZero() || !fVar3.isOne()) {
                return twice().add(iVar);
            }
            f fVar4 = this.f14128d;
            f fVar5 = this.f14129e[0];
            f fVar6 = iVar.f14128d;
            f fVarSquare = fVar.square();
            f fVarSquare2 = fVar4.square();
            f fVarSquare3 = fVar5.square();
            f fVarAdd = curve.getA().multiply(fVarSquare3).add(fVarSquare2).add(fVar4.multiply(fVar5));
            f fVarAddOne = fVar6.addOne();
            f fVarMultiplyPlusProduct = curve.getA().add(fVarAddOne).multiply(fVarSquare3).add(fVarSquare2).multiplyPlusProduct(fVarAdd, fVarSquare, fVarSquare3);
            f fVarMultiply = fVar2.multiply(fVarSquare3);
            f fVarSquare4 = fVarMultiply.add(fVarAdd).square();
            if (fVarSquare4.isZero()) {
                return fVarMultiplyPlusProduct.isZero() ? iVar.twice() : curve.getInfinity();
            }
            if (fVarMultiplyPlusProduct.isZero()) {
                return new d(curve, fVarMultiplyPlusProduct, curve.getB().sqrt());
            }
            f fVarMultiply2 = fVarMultiplyPlusProduct.square().multiply(fVarMultiply);
            f fVarMultiply3 = fVarMultiplyPlusProduct.multiply(fVarSquare4).multiply(fVarSquare3);
            return new d(curve, fVarMultiply2, fVarMultiplyPlusProduct.add(fVarSquare4).square().multiplyPlusProduct(fVarAdd, fVarAddOne, fVarMultiply3), new f[]{fVarMultiply3});
        }
    }

    public static class e extends c {
        public e(g.a.g.a.e eVar, f fVar, f fVar2) {
            super(eVar, fVar, fVar2);
        }

        public e(g.a.g.a.e eVar, f fVar, f fVar2, f[] fVarArr) {
            super(eVar, fVar, fVar2, fVarArr);
        }

        /* JADX WARN: Removed duplicated region for block: B:61:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x0136  */
        @Override // g.a.g.a.i
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public g.a.g.a.i add(g.a.g.a.i r17) {
            /*
                Method dump skipped, instruction units count: 532
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.g.a.i.e.add(g.a.g.a.i):g.a.g.a.i");
        }

        @Override // g.a.g.a.i
        public i c() {
            return new e(null, getAffineXCoord(), getAffineYCoord());
        }

        @Override // g.a.g.a.i
        public f getZCoord(int i2) {
            return (i2 == 1 && 4 == e()) ? p() : super.getZCoord(i2);
        }

        public f m(f fVar, f fVar2) {
            f a2 = getCurve().getA();
            if (a2.isZero() || fVar.isOne()) {
                return a2;
            }
            if (fVar2 == null) {
                fVar2 = fVar.square();
            }
            f fVarSquare = fVar2.square();
            f fVarNegate = a2.negate();
            return fVarNegate.bitLength() < a2.bitLength() ? fVarSquare.multiply(fVarNegate).negate() : fVarSquare.multiply(a2);
        }

        public f n(f fVar) {
            return o(s(fVar));
        }

        @Override // g.a.g.a.i
        public i negate() {
            if (isInfinity()) {
                return this;
            }
            g.a.g.a.e curve = getCurve();
            return curve.getCoordinateSystem() != 0 ? new e(curve, this.f14127c, this.f14128d.negate(), this.f14129e) : new e(curve, this.f14127c, this.f14128d.negate());
        }

        public f o(f fVar) {
            return s(s(fVar));
        }

        public f p() {
            f[] fVarArr = this.f14129e;
            f fVar = fVarArr[1];
            if (fVar != null) {
                return fVar;
            }
            f fVarM = m(fVarArr[0], null);
            fVarArr[1] = fVarM;
            return fVarM;
        }

        public f q(f fVar) {
            return s(fVar).add(fVar);
        }

        public e r(boolean z) {
            f fVar = this.f14127c;
            f fVar2 = this.f14128d;
            f fVar3 = this.f14129e[0];
            f fVarP = p();
            f fVarAdd = q(fVar.square()).add(fVarP);
            f fVarS = s(fVar2);
            f fVarMultiply = fVarS.multiply(fVar2);
            f fVarS2 = s(fVar.multiply(fVarMultiply));
            f fVarSubtract = fVarAdd.square().subtract(s(fVarS2));
            f fVarS3 = s(fVarMultiply.square());
            f fVarSubtract2 = fVarAdd.multiply(fVarS2.subtract(fVarSubtract)).subtract(fVarS3);
            f fVarS4 = z ? s(fVarS3.multiply(fVarP)) : null;
            if (!fVar3.isOne()) {
                fVarS = fVarS.multiply(fVar3);
            }
            return new e(getCurve(), fVarSubtract, fVarSubtract2, new f[]{fVarS, fVarS4});
        }

        public f s(f fVar) {
            return fVar.add(fVar);
        }

        @Override // g.a.g.a.i
        public i threeTimes() {
            if (isInfinity()) {
                return this;
            }
            f fVar = this.f14128d;
            if (fVar.isZero()) {
                return this;
            }
            g.a.g.a.e curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 0) {
                return coordinateSystem != 4 ? twice().add(this) : r(false).add(this);
            }
            f fVar2 = this.f14127c;
            f fVarS = s(fVar);
            f fVarSquare = fVarS.square();
            f fVarAdd = q(fVar2.square()).add(getCurve().getA());
            f fVarSubtract = q(fVar2).multiply(fVarSquare).subtract(fVarAdd.square());
            if (fVarSubtract.isZero()) {
                return getCurve().getInfinity();
            }
            f fVarInvert = fVarSubtract.multiply(fVarS).invert();
            f fVarMultiply = fVarSubtract.multiply(fVarInvert).multiply(fVarAdd);
            f fVarSubtract2 = fVarSquare.square().multiply(fVarInvert).subtract(fVarMultiply);
            f fVarAdd2 = fVarSubtract2.subtract(fVarMultiply).multiply(fVarMultiply.add(fVarSubtract2)).add(fVar2);
            return new e(curve, fVarAdd2, fVar2.subtract(fVarAdd2).multiply(fVarSubtract2).subtract(fVar));
        }

        @Override // g.a.g.a.i
        public i timesPow2(int i2) {
            f fVarSquare;
            if (i2 < 0) {
                throw new IllegalArgumentException("'e' cannot be negative");
            }
            if (i2 == 0 || isInfinity()) {
                return this;
            }
            if (i2 == 1) {
                return twice();
            }
            g.a.g.a.e curve = getCurve();
            f fVarSubtract = this.f14128d;
            if (fVarSubtract.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            f a2 = curve.getA();
            f fVarMultiply = this.f14127c;
            f[] fVarArr = this.f14129e;
            f fVarFromBigInteger = fVarArr.length < 1 ? curve.fromBigInteger(g.a.g.a.d.f14091b) : fVarArr[0];
            if (!fVarFromBigInteger.isOne() && coordinateSystem != 0) {
                if (coordinateSystem == 1) {
                    fVarSquare = fVarFromBigInteger.square();
                    fVarMultiply = fVarMultiply.multiply(fVarFromBigInteger);
                    fVarSubtract = fVarSubtract.multiply(fVarSquare);
                } else if (coordinateSystem == 2) {
                    fVarSquare = null;
                } else {
                    if (coordinateSystem != 4) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    a2 = p();
                }
                a2 = m(fVarFromBigInteger, fVarSquare);
            }
            int i3 = 0;
            while (i3 < i2) {
                if (fVarSubtract.isZero()) {
                    return curve.getInfinity();
                }
                f fVarQ = q(fVarMultiply.square());
                f fVarS = s(fVarSubtract);
                f fVarMultiply2 = fVarS.multiply(fVarSubtract);
                f fVarS2 = s(fVarMultiply.multiply(fVarMultiply2));
                f fVarS3 = s(fVarMultiply2.square());
                if (!a2.isZero()) {
                    fVarQ = fVarQ.add(a2);
                    a2 = s(fVarS3.multiply(a2));
                }
                f fVarSubtract2 = fVarQ.square().subtract(s(fVarS2));
                fVarSubtract = fVarQ.multiply(fVarS2.subtract(fVarSubtract2)).subtract(fVarS3);
                fVarFromBigInteger = fVarFromBigInteger.isOne() ? fVarS : fVarS.multiply(fVarFromBigInteger);
                i3++;
                fVarMultiply = fVarSubtract2;
            }
            if (coordinateSystem == 0) {
                f fVarInvert = fVarFromBigInteger.invert();
                f fVarSquare2 = fVarInvert.square();
                return new e(curve, fVarMultiply.multiply(fVarSquare2), fVarSubtract.multiply(fVarSquare2.multiply(fVarInvert)));
            }
            if (coordinateSystem == 1) {
                return new e(curve, fVarMultiply.multiply(fVarFromBigInteger), fVarSubtract, new f[]{fVarFromBigInteger.multiply(fVarFromBigInteger.square())});
            }
            if (coordinateSystem == 2) {
                return new e(curve, fVarMultiply, fVarSubtract, new f[]{fVarFromBigInteger});
            }
            if (coordinateSystem == 4) {
                return new e(curve, fVarMultiply, fVarSubtract, new f[]{fVarFromBigInteger, a2});
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        @Override // g.a.g.a.i
        public i twice() {
            f fVarSubtract;
            f fVarMultiply;
            if (isInfinity()) {
                return this;
            }
            g.a.g.a.e curve = getCurve();
            f fVar = this.f14128d;
            if (fVar.isZero()) {
                return curve.getInfinity();
            }
            int coordinateSystem = curve.getCoordinateSystem();
            f fVar2 = this.f14127c;
            if (coordinateSystem == 0) {
                f fVarDivide = q(fVar2.square()).add(getCurve().getA()).divide(s(fVar));
                f fVarSubtract2 = fVarDivide.square().subtract(s(fVar2));
                return new e(curve, fVarSubtract2, fVarDivide.multiply(fVar2.subtract(fVarSubtract2)).subtract(fVar));
            }
            if (coordinateSystem == 1) {
                f fVar3 = this.f14129e[0];
                boolean zIsOne = fVar3.isOne();
                f a2 = curve.getA();
                if (!a2.isZero() && !zIsOne) {
                    a2 = a2.multiply(fVar3.square());
                }
                f fVarAdd = a2.add(q(fVar2.square()));
                f fVarMultiply2 = zIsOne ? fVar : fVar.multiply(fVar3);
                f fVarSquare = zIsOne ? fVar.square() : fVarMultiply2.multiply(fVar);
                f fVarO = o(fVar2.multiply(fVarSquare));
                f fVarSubtract3 = fVarAdd.square().subtract(s(fVarO));
                f fVarS = s(fVarMultiply2);
                f fVarMultiply3 = fVarSubtract3.multiply(fVarS);
                f fVarS2 = s(fVarSquare);
                return new e(curve, fVarMultiply3, fVarO.subtract(fVarSubtract3).multiply(fVarAdd).subtract(s(fVarS2.square())), new f[]{s(zIsOne ? s(fVarS2) : fVarS.square()).multiply(fVarMultiply2)});
            }
            if (coordinateSystem != 2) {
                if (coordinateSystem == 4) {
                    return r(true);
                }
                throw new IllegalStateException("unsupported coordinate system");
            }
            f fVar4 = this.f14129e[0];
            boolean zIsOne2 = fVar4.isOne();
            f fVarSquare2 = fVar.square();
            f fVarSquare3 = fVarSquare2.square();
            f a3 = curve.getA();
            f fVarNegate = a3.negate();
            if (fVarNegate.toBigInteger().equals(BigInteger.valueOf(3L))) {
                f fVarSquare4 = zIsOne2 ? fVar4 : fVar4.square();
                fVarSubtract = q(fVar2.add(fVarSquare4).multiply(fVar2.subtract(fVarSquare4)));
                fVarMultiply = fVarSquare2.multiply(fVar2);
            } else {
                f fVarQ = q(fVar2.square());
                if (zIsOne2) {
                    fVarSubtract = fVarQ.add(a3);
                    fVarMultiply = fVar2.multiply(fVarSquare2);
                } else {
                    if (a3.isZero()) {
                        fVarSubtract = fVarQ;
                    } else {
                        f fVarSquare5 = fVar4.square().square();
                        if (fVarNegate.bitLength() < a3.bitLength()) {
                            fVarSubtract = fVarQ.subtract(fVarSquare5.multiply(fVarNegate));
                        } else {
                            a3 = fVarSquare5.multiply(a3);
                            fVarSubtract = fVarQ.add(a3);
                        }
                    }
                    fVarMultiply = fVar2.multiply(fVarSquare2);
                }
            }
            f fVarO2 = o(fVarMultiply);
            f fVarSubtract4 = fVarSubtract.square().subtract(s(fVarO2));
            f fVarSubtract5 = fVarO2.subtract(fVarSubtract4).multiply(fVarSubtract).subtract(n(fVarSquare3));
            f fVarS3 = s(fVar);
            if (!zIsOne2) {
                fVarS3 = fVarS3.multiply(fVar4);
            }
            return new e(curve, fVarSubtract4, fVarSubtract5, new f[]{fVarS3});
        }

        @Override // g.a.g.a.i
        public i twicePlus(i iVar) {
            if (this == iVar) {
                return threeTimes();
            }
            if (isInfinity()) {
                return iVar;
            }
            if (iVar.isInfinity()) {
                return twice();
            }
            f fVar = this.f14128d;
            if (fVar.isZero()) {
                return iVar;
            }
            g.a.g.a.e curve = getCurve();
            int coordinateSystem = curve.getCoordinateSystem();
            if (coordinateSystem != 0) {
                return coordinateSystem != 4 ? twice().add(iVar) : r(false).add(iVar);
            }
            f fVar2 = this.f14127c;
            f fVar3 = iVar.f14127c;
            f fVar4 = iVar.f14128d;
            f fVarSubtract = fVar3.subtract(fVar2);
            f fVarSubtract2 = fVar4.subtract(fVar);
            if (fVarSubtract.isZero()) {
                return fVarSubtract2.isZero() ? threeTimes() : this;
            }
            f fVarSquare = fVarSubtract.square();
            f fVarSubtract3 = fVarSquare.multiply(s(fVar2).add(fVar3)).subtract(fVarSubtract2.square());
            if (fVarSubtract3.isZero()) {
                return curve.getInfinity();
            }
            f fVarInvert = fVarSubtract3.multiply(fVarSubtract).invert();
            f fVarMultiply = fVarSubtract3.multiply(fVarInvert).multiply(fVarSubtract2);
            f fVarSubtract4 = s(fVar).multiply(fVarSquare).multiply(fVarSubtract).multiply(fVarInvert).subtract(fVarMultiply);
            f fVarAdd = fVarSubtract4.subtract(fVarMultiply).multiply(fVarMultiply.add(fVarSubtract4)).add(fVar3);
            return new e(curve, fVarAdd, fVar2.subtract(fVarAdd).multiply(fVarSubtract4).subtract(fVar));
        }
    }

    public i(g.a.g.a.e eVar, f fVar, f fVar2) {
        this(eVar, fVar, fVar2, f(eVar));
    }

    public i(g.a.g.a.e eVar, f fVar, f fVar2, f[] fVarArr) {
        this.f14130f = null;
        this.f14126b = eVar;
        this.f14127c = fVar;
        this.f14128d = fVar2;
        this.f14129e = fVarArr;
    }

    public static f[] f(g.a.g.a.e eVar) {
        int coordinateSystem = eVar == null ? 0 : eVar.getCoordinateSystem();
        if (coordinateSystem == 0 || coordinateSystem == 5) {
            return f14125a;
        }
        f fVarFromBigInteger = eVar.fromBigInteger(g.a.g.a.d.f14091b);
        if (coordinateSystem != 1 && coordinateSystem != 2) {
            if (coordinateSystem == 3) {
                return new f[]{fVarFromBigInteger, fVarFromBigInteger, fVarFromBigInteger};
            }
            if (coordinateSystem == 4) {
                return new f[]{fVarFromBigInteger, eVar.getA()};
            }
            if (coordinateSystem != 6) {
                throw new IllegalArgumentException("unknown coordinate system");
            }
        }
        return new f[]{fVarFromBigInteger};
    }

    public void a() {
        if (!isNormalized()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    public abstract i add(i iVar);

    public i b(f fVar, f fVar2) {
        return getCurve().e(getRawXCoord().multiply(fVar), getRawYCoord().multiply(fVar2));
    }

    public abstract i c();

    public abstract boolean d();

    public int e() {
        g.a.g.a.e eVar = this.f14126b;
        if (eVar == null) {
            return 0;
        }
        return eVar.getCoordinateSystem();
    }

    public boolean equals(i iVar) {
        i iVarNormalize;
        if (iVar == null) {
            return false;
        }
        g.a.g.a.e curve = getCurve();
        g.a.g.a.e curve2 = iVar.getCurve();
        boolean z = curve == null;
        boolean z2 = curve2 == null;
        boolean zIsInfinity = isInfinity();
        boolean zIsInfinity2 = iVar.isInfinity();
        if (zIsInfinity || zIsInfinity2) {
            if (zIsInfinity && zIsInfinity2) {
                return z || z2 || curve.equals(curve2);
            }
            return false;
        }
        if (z && z2) {
            iVarNormalize = this;
        } else if (z) {
            iVar = iVar.normalize();
            iVarNormalize = this;
        } else if (z2) {
            iVarNormalize = normalize();
        } else {
            if (!curve.equals(curve2)) {
                return false;
            }
            i[] iVarArr = {this, curve.importPoint(iVar)};
            curve.normalizeAll(iVarArr);
            iVarNormalize = iVarArr[0];
            iVar = iVarArr[1];
        }
        return iVarNormalize.getXCoord().equals(iVar.getXCoord()) && iVarNormalize.getYCoord().equals(iVar.getYCoord());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            return equals((i) obj);
        }
        return false;
    }

    public final f[] g() {
        return this.f14129e;
    }

    public f getAffineXCoord() {
        a();
        return getXCoord();
    }

    public f getAffineYCoord() {
        a();
        return getYCoord();
    }

    public g.a.g.a.e getCurve() {
        return this.f14126b;
    }

    public final i getDetachedPoint() {
        return normalize().c();
    }

    public byte[] getEncoded(boolean z) {
        if (isInfinity()) {
            return new byte[1];
        }
        i iVarNormalize = normalize();
        byte[] encoded = iVarNormalize.getXCoord().getEncoded();
        if (z) {
            byte[] bArr = new byte[encoded.length + 1];
            bArr[0] = (byte) (iVarNormalize.d() ? 3 : 2);
            System.arraycopy(encoded, 0, bArr, 1, encoded.length);
            return bArr;
        }
        byte[] encoded2 = iVarNormalize.getYCoord().getEncoded();
        byte[] bArr2 = new byte[encoded.length + encoded2.length + 1];
        bArr2[0] = 4;
        System.arraycopy(encoded, 0, bArr2, 1, encoded.length);
        System.arraycopy(encoded2, 0, bArr2, encoded.length + 1, encoded2.length);
        return bArr2;
    }

    public final f getRawXCoord() {
        return this.f14127c;
    }

    public final f getRawYCoord() {
        return this.f14128d;
    }

    public f getXCoord() {
        return this.f14127c;
    }

    public f getYCoord() {
        return this.f14128d;
    }

    public f getZCoord(int i2) {
        if (i2 >= 0) {
            f[] fVarArr = this.f14129e;
            if (i2 < fVarArr.length) {
                return fVarArr[i2];
            }
        }
        return null;
    }

    public f[] getZCoords() {
        f[] fVarArr = this.f14129e;
        int length = fVarArr.length;
        if (length == 0) {
            return f14125a;
        }
        f[] fVarArr2 = new f[length];
        System.arraycopy(fVarArr, 0, fVarArr2, 0, length);
        return fVarArr2;
    }

    public boolean h(boolean z, boolean z2) {
        if (isInfinity()) {
            return true;
        }
        return !((u) getCurve().precompute(this, "bc_validity", new a(z, z2))).b();
    }

    public int hashCode() {
        g.a.g.a.e curve = getCurve();
        int i2 = curve == null ? 0 : ~curve.hashCode();
        if (isInfinity()) {
            return i2;
        }
        i iVarNormalize = normalize();
        return (i2 ^ (iVarNormalize.getXCoord().hashCode() * 17)) ^ (iVarNormalize.getYCoord().hashCode() * InputDeviceCompat.SOURCE_KEYBOARD);
    }

    public boolean i() {
        return h(false, false);
    }

    public boolean isInfinity() {
        if (this.f14127c != null && this.f14128d != null) {
            f[] fVarArr = this.f14129e;
            if (fVarArr.length <= 0 || !fVarArr[0].isZero()) {
                return false;
            }
        }
        return true;
    }

    public boolean isNormalized() {
        int iE = e();
        return iE == 0 || iE == 5 || isInfinity() || this.f14129e[0].isOne();
    }

    public boolean isValid() {
        return h(false, true);
    }

    public i j(f fVar) {
        int iE = e();
        if (iE != 1) {
            if (iE == 2 || iE == 3 || iE == 4) {
                f fVarSquare = fVar.square();
                return b(fVarSquare, fVarSquare.multiply(fVar));
            }
            if (iE != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return b(fVar, fVar);
    }

    public abstract boolean k();

    public boolean l() {
        BigInteger order;
        return g.a.g.a.d.f14091b.equals(this.f14126b.getCofactor()) || (order = this.f14126b.getOrder()) == null || g.a.g.a.c.referenceMultiply(this, order).isInfinity();
    }

    public i multiply(BigInteger bigInteger) {
        return getCurve().getMultiplier().multiply(this, bigInteger);
    }

    public abstract i negate();

    public i normalize() {
        int iE;
        if (isInfinity() || (iE = e()) == 0 || iE == 5) {
            return this;
        }
        f zCoord = getZCoord(0);
        if (zCoord.isOne()) {
            return this;
        }
        if (this.f14126b == null) {
            throw new IllegalStateException("Detached points must be in affine coordinates");
        }
        f fVarRandomFieldElementMult = this.f14126b.randomFieldElementMult(g.a.d.c.getSecureRandom());
        return j(zCoord.multiply(fVarRandomFieldElementMult).invert().multiply(fVarRandomFieldElementMult));
    }

    public i scaleX(f fVar) {
        return isInfinity() ? this : getCurve().f(getRawXCoord().multiply(fVar), getRawYCoord(), g());
    }

    public i scaleXNegateY(f fVar) {
        return isInfinity() ? this : getCurve().f(getRawXCoord().multiply(fVar), getRawYCoord().negate(), g());
    }

    public i scaleY(f fVar) {
        return isInfinity() ? this : getCurve().f(getRawXCoord(), getRawYCoord().multiply(fVar), g());
    }

    public i scaleYNegateX(f fVar) {
        return isInfinity() ? this : getCurve().f(getRawXCoord().negate(), getRawYCoord().multiply(fVar), g());
    }

    public abstract i subtract(i iVar);

    public i threeTimes() {
        return twicePlus(this);
    }

    public i timesPow2(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
        i iVarTwice = this;
        while (true) {
            i2--;
            if (i2 < 0) {
                return iVarTwice;
            }
            iVarTwice = iVarTwice.twice();
        }
    }

    public String toString() {
        if (isInfinity()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(getRawXCoord());
        stringBuffer.append(',');
        stringBuffer.append(getRawYCoord());
        for (int i2 = 0; i2 < this.f14129e.length; i2++) {
            stringBuffer.append(',');
            stringBuffer.append(this.f14129e[i2]);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public abstract i twice();

    public i twicePlus(i iVar) {
        return twice().add(iVar);
    }
}
