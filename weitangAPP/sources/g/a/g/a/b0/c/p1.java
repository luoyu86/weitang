package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class p1 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f14017g;

    public p1() {
        this.f14017g = g.a.g.c.h.create64();
    }

    public p1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 193) {
            throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
        }
        this.f14017g = o1.fromBigInteger(bigInteger);
    }

    public p1(long[] jArr) {
        this.f14017g = jArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        o1.add(this.f14017g, ((p1) fVar).f14017g, jArrCreate64);
        return new p1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        o1.addOne(this.f14017g, jArrCreate64);
        return new p1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        return multiply(fVar.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p1) {
            return g.a.g.c.h.eq64(this.f14017g, ((p1) obj).f14017g);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecT193Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return 193;
    }

    public int getK1() {
        return 15;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 193;
    }

    public int getRepresentation() {
        return 2;
    }

    @Override // g.a.g.a.f.a
    public g.a.g.a.f halfTrace() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        o1.halfTrace(this.f14017g, jArrCreate64);
        return new p1(jArrCreate64);
    }

    @Override // g.a.g.a.f.a
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f14017g, 0, 4) ^ 1930015;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        o1.invert(this.f14017g, jArrCreate64);
        return new p1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.h.isOne64(this.f14017g);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.h.isZero64(this.f14017g);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        o1.multiply(this.f14017g, ((p1) fVar).f14017g, jArrCreate64);
        return new p1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        return multiplyPlusProduct(fVar, fVar2, fVar3);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyPlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        long[] jArr = this.f14017g;
        long[] jArr2 = ((p1) fVar).f14017g;
        long[] jArr3 = ((p1) fVar2).f14017g;
        long[] jArr4 = ((p1) fVar3).f14017g;
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        o1.multiplyAddToExt(jArr, jArr2, jArrCreateExt64);
        o1.multiplyAddToExt(jArr3, jArr4, jArrCreateExt64);
        long[] jArrCreate64 = g.a.g.c.h.create64();
        o1.reduce(jArrCreateExt64, jArrCreate64);
        return new p1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        return this;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        o1.sqrt(this.f14017g, jArrCreate64);
        return new p1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        o1.square(this.f14017g, jArrCreate64);
        return new p1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squareMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return squarePlusProduct(fVar, fVar2);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        long[] jArr = this.f14017g;
        long[] jArr2 = ((p1) fVar).f14017g;
        long[] jArr3 = ((p1) fVar2).f14017g;
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        o1.squareAddToExt(jArr, jArrCreateExt64);
        o1.multiplyAddToExt(jArr2, jArr3, jArrCreateExt64);
        long[] jArrCreate64 = g.a.g.c.h.create64();
        o1.reduce(jArrCreateExt64, jArrCreate64);
        return new p1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePow(int i2) {
        if (i2 < 1) {
            return this;
        }
        long[] jArrCreate64 = g.a.g.c.h.create64();
        o1.squareN(this.f14017g, i2, jArrCreate64);
        return new p1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        return add(fVar);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return (this.f14017g[0] & 1) != 0;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.h.toBigInteger64(this.f14017g);
    }

    @Override // g.a.g.a.f.a
    public int trace() {
        return o1.trace(this.f14017g);
    }
}
