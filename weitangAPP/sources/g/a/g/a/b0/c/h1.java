package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class h1 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f13962g;

    public h1() {
        this.f13962g = g.a.g.c.f.create64();
    }

    public h1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 163) {
            throw new IllegalArgumentException("x value invalid for SecT163FieldElement");
        }
        this.f13962g = g1.fromBigInteger(bigInteger);
    }

    public h1(long[] jArr) {
        this.f13962g = jArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        g1.add(this.f13962g, ((h1) fVar).f13962g, jArrCreate64);
        return new h1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        g1.addOne(this.f13962g, jArrCreate64);
        return new h1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        return multiply(fVar.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h1) {
            return g.a.g.c.f.eq64(this.f13962g, ((h1) obj).f13962g);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecT163Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return 163;
    }

    public int getK1() {
        return 3;
    }

    public int getK2() {
        return 6;
    }

    public int getK3() {
        return 7;
    }

    public int getM() {
        return 163;
    }

    public int getRepresentation() {
        return 3;
    }

    @Override // g.a.g.a.f.a
    public g.a.g.a.f halfTrace() {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        g1.halfTrace(this.f13962g, jArrCreate64);
        return new h1(jArrCreate64);
    }

    @Override // g.a.g.a.f.a
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f13962g, 0, 3) ^ 163763;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        g1.invert(this.f13962g, jArrCreate64);
        return new h1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.f.isOne64(this.f13962g);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.f.isZero64(this.f13962g);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        g1.multiply(this.f13962g, ((h1) fVar).f13962g, jArrCreate64);
        return new h1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        return multiplyPlusProduct(fVar, fVar2, fVar3);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyPlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        long[] jArr = this.f13962g;
        long[] jArr2 = ((h1) fVar).f13962g;
        long[] jArr3 = ((h1) fVar2).f13962g;
        long[] jArr4 = ((h1) fVar3).f13962g;
        long[] jArrCreateExt64 = g.a.g.c.f.createExt64();
        g1.multiplyAddToExt(jArr, jArr2, jArrCreateExt64);
        g1.multiplyAddToExt(jArr3, jArr4, jArrCreateExt64);
        long[] jArrCreate64 = g.a.g.c.f.create64();
        g1.reduce(jArrCreateExt64, jArrCreate64);
        return new h1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        return this;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        g1.sqrt(this.f13962g, jArrCreate64);
        return new h1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        g1.square(this.f13962g, jArrCreate64);
        return new h1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squareMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return squarePlusProduct(fVar, fVar2);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        long[] jArr = this.f13962g;
        long[] jArr2 = ((h1) fVar).f13962g;
        long[] jArr3 = ((h1) fVar2).f13962g;
        long[] jArrCreateExt64 = g.a.g.c.f.createExt64();
        g1.squareAddToExt(jArr, jArrCreateExt64);
        g1.multiplyAddToExt(jArr2, jArr3, jArrCreateExt64);
        long[] jArrCreate64 = g.a.g.c.f.create64();
        g1.reduce(jArrCreateExt64, jArrCreate64);
        return new h1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePow(int i2) {
        if (i2 < 1) {
            return this;
        }
        long[] jArrCreate64 = g.a.g.c.f.create64();
        g1.squareN(this.f13962g, i2, jArrCreate64);
        return new h1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        return add(fVar);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return (this.f13962g[0] & 1) != 0;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.f.toBigInteger64(this.f13962g);
    }

    @Override // g.a.g.a.f.a
    public int trace() {
        return g1.trace(this.f13962g);
    }
}
