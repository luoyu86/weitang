package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class r2 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f14029g;

    public r2() {
        this.f14029g = g.a.g.c.m.create64();
    }

    public r2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 571) {
            throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
        }
        this.f14029g = q2.fromBigInteger(bigInteger);
    }

    public r2(long[] jArr) {
        this.f14029g = jArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.m.create64();
        q2.add(this.f14029g, ((r2) fVar).f14029g, jArrCreate64);
        return new r2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        long[] jArrCreate64 = g.a.g.c.m.create64();
        q2.addOne(this.f14029g, jArrCreate64);
        return new r2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        return multiply(fVar.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r2) {
            return g.a.g.c.m.eq64(this.f14029g, ((r2) obj).f14029g);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecT571Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return 571;
    }

    public int getK1() {
        return 2;
    }

    public int getK2() {
        return 5;
    }

    public int getK3() {
        return 10;
    }

    public int getM() {
        return 571;
    }

    public int getRepresentation() {
        return 3;
    }

    @Override // g.a.g.a.f.a
    public g.a.g.a.f halfTrace() {
        long[] jArrCreate64 = g.a.g.c.m.create64();
        q2.halfTrace(this.f14029g, jArrCreate64);
        return new r2(jArrCreate64);
    }

    @Override // g.a.g.a.f.a
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f14029g, 0, 9) ^ 5711052;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        long[] jArrCreate64 = g.a.g.c.m.create64();
        q2.invert(this.f14029g, jArrCreate64);
        return new r2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.m.isOne64(this.f14029g);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.m.isZero64(this.f14029g);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.m.create64();
        q2.multiply(this.f14029g, ((r2) fVar).f14029g, jArrCreate64);
        return new r2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        return multiplyPlusProduct(fVar, fVar2, fVar3);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyPlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        long[] jArr = this.f14029g;
        long[] jArr2 = ((r2) fVar).f14029g;
        long[] jArr3 = ((r2) fVar2).f14029g;
        long[] jArr4 = ((r2) fVar3).f14029g;
        long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
        q2.multiplyAddToExt(jArr, jArr2, jArrCreateExt64);
        q2.multiplyAddToExt(jArr3, jArr4, jArrCreateExt64);
        long[] jArrCreate64 = g.a.g.c.m.create64();
        q2.reduce(jArrCreateExt64, jArrCreate64);
        return new r2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        return this;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        long[] jArrCreate64 = g.a.g.c.m.create64();
        q2.sqrt(this.f14029g, jArrCreate64);
        return new r2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        long[] jArrCreate64 = g.a.g.c.m.create64();
        q2.square(this.f14029g, jArrCreate64);
        return new r2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squareMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return squarePlusProduct(fVar, fVar2);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        long[] jArr = this.f14029g;
        long[] jArr2 = ((r2) fVar).f14029g;
        long[] jArr3 = ((r2) fVar2).f14029g;
        long[] jArrCreateExt64 = g.a.g.c.m.createExt64();
        q2.squareAddToExt(jArr, jArrCreateExt64);
        q2.multiplyAddToExt(jArr2, jArr3, jArrCreateExt64);
        long[] jArrCreate64 = g.a.g.c.m.create64();
        q2.reduce(jArrCreateExt64, jArrCreate64);
        return new r2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePow(int i2) {
        if (i2 < 1) {
            return this;
        }
        long[] jArrCreate64 = g.a.g.c.m.create64();
        q2.squareN(this.f14029g, i2, jArrCreate64);
        return new r2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        return add(fVar);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return (this.f14029g[0] & 1) != 0;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.m.toBigInteger64(this.f14029g);
    }

    @Override // g.a.g.a.f.a
    public int trace() {
        return q2.trace(this.f14029g);
    }
}
