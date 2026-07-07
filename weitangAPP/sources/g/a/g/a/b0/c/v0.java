package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class v0 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f14050g;

    public v0() {
        this.f14050g = g.a.g.c.d.create64();
    }

    public v0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 113) {
            throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
        }
        this.f14050g = u0.fromBigInteger(bigInteger);
    }

    public v0(long[] jArr) {
        this.f14050g = jArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.d.create64();
        u0.add(this.f14050g, ((v0) fVar).f14050g, jArrCreate64);
        return new v0(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        long[] jArrCreate64 = g.a.g.c.d.create64();
        u0.addOne(this.f14050g, jArrCreate64);
        return new v0(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        return multiply(fVar.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v0) {
            return g.a.g.c.d.eq64(this.f14050g, ((v0) obj).f14050g);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecT113Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return 113;
    }

    public int getK1() {
        return 9;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 113;
    }

    public int getRepresentation() {
        return 2;
    }

    @Override // g.a.g.a.f.a
    public g.a.g.a.f halfTrace() {
        long[] jArrCreate64 = g.a.g.c.d.create64();
        u0.halfTrace(this.f14050g, jArrCreate64);
        return new v0(jArrCreate64);
    }

    @Override // g.a.g.a.f.a
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f14050g, 0, 2) ^ 113009;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        long[] jArrCreate64 = g.a.g.c.d.create64();
        u0.invert(this.f14050g, jArrCreate64);
        return new v0(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.d.isOne64(this.f14050g);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.d.isZero64(this.f14050g);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.d.create64();
        u0.multiply(this.f14050g, ((v0) fVar).f14050g, jArrCreate64);
        return new v0(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        return multiplyPlusProduct(fVar, fVar2, fVar3);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyPlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        long[] jArr = this.f14050g;
        long[] jArr2 = ((v0) fVar).f14050g;
        long[] jArr3 = ((v0) fVar2).f14050g;
        long[] jArr4 = ((v0) fVar3).f14050g;
        long[] jArrCreateExt64 = g.a.g.c.d.createExt64();
        u0.multiplyAddToExt(jArr, jArr2, jArrCreateExt64);
        u0.multiplyAddToExt(jArr3, jArr4, jArrCreateExt64);
        long[] jArrCreate64 = g.a.g.c.d.create64();
        u0.reduce(jArrCreateExt64, jArrCreate64);
        return new v0(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        return this;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        long[] jArrCreate64 = g.a.g.c.d.create64();
        u0.sqrt(this.f14050g, jArrCreate64);
        return new v0(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        long[] jArrCreate64 = g.a.g.c.d.create64();
        u0.square(this.f14050g, jArrCreate64);
        return new v0(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squareMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return squarePlusProduct(fVar, fVar2);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        long[] jArr = this.f14050g;
        long[] jArr2 = ((v0) fVar).f14050g;
        long[] jArr3 = ((v0) fVar2).f14050g;
        long[] jArrCreateExt64 = g.a.g.c.d.createExt64();
        u0.squareAddToExt(jArr, jArrCreateExt64);
        u0.multiplyAddToExt(jArr2, jArr3, jArrCreateExt64);
        long[] jArrCreate64 = g.a.g.c.d.create64();
        u0.reduce(jArrCreateExt64, jArrCreate64);
        return new v0(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePow(int i2) {
        if (i2 < 1) {
            return this;
        }
        long[] jArrCreate64 = g.a.g.c.d.create64();
        u0.squareN(this.f14050g, i2, jArrCreate64);
        return new v0(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        return add(fVar);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return (this.f14050g[0] & 1) != 0;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.d.toBigInteger64(this.f14050g);
    }

    @Override // g.a.g.a.f.a
    public int trace() {
        return u0.trace(this.f14050g);
    }
}
