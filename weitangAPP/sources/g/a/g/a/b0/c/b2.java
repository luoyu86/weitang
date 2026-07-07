package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class b2 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f13922g;

    public b2() {
        this.f13922g = g.a.g.c.h.create64();
    }

    public b2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        this.f13922g = a2.fromBigInteger(bigInteger);
    }

    public b2(long[] jArr) {
        this.f13922g = jArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        a2.add(this.f13922g, ((b2) fVar).f13922g, jArrCreate64);
        return new b2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        a2.addOne(this.f13922g, jArrCreate64);
        return new b2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        return multiply(fVar.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b2) {
            return g.a.g.c.h.eq64(this.f13922g, ((b2) obj).f13922g);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecT239Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return 239;
    }

    public int getK1() {
        return 158;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return 239;
    }

    public int getRepresentation() {
        return 2;
    }

    @Override // g.a.g.a.f.a
    public g.a.g.a.f halfTrace() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        a2.halfTrace(this.f13922g, jArrCreate64);
        return new b2(jArrCreate64);
    }

    @Override // g.a.g.a.f.a
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f13922g, 0, 4) ^ 23900158;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        a2.invert(this.f13922g, jArrCreate64);
        return new b2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.h.isOne64(this.f13922g);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.h.isZero64(this.f13922g);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        a2.multiply(this.f13922g, ((b2) fVar).f13922g, jArrCreate64);
        return new b2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        return multiplyPlusProduct(fVar, fVar2, fVar3);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyPlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        long[] jArr = this.f13922g;
        long[] jArr2 = ((b2) fVar).f13922g;
        long[] jArr3 = ((b2) fVar2).f13922g;
        long[] jArr4 = ((b2) fVar3).f13922g;
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        a2.multiplyAddToExt(jArr, jArr2, jArrCreateExt64);
        a2.multiplyAddToExt(jArr3, jArr4, jArrCreateExt64);
        long[] jArrCreate64 = g.a.g.c.h.create64();
        a2.reduce(jArrCreateExt64, jArrCreate64);
        return new b2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        return this;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        a2.sqrt(this.f13922g, jArrCreate64);
        return new b2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        a2.square(this.f13922g, jArrCreate64);
        return new b2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squareMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return squarePlusProduct(fVar, fVar2);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        long[] jArr = this.f13922g;
        long[] jArr2 = ((b2) fVar).f13922g;
        long[] jArr3 = ((b2) fVar2).f13922g;
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        a2.squareAddToExt(jArr, jArrCreateExt64);
        a2.multiplyAddToExt(jArr2, jArr3, jArrCreateExt64);
        long[] jArrCreate64 = g.a.g.c.h.create64();
        a2.reduce(jArrCreateExt64, jArrCreate64);
        return new b2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePow(int i2) {
        if (i2 < 1) {
            return this;
        }
        long[] jArrCreate64 = g.a.g.c.h.create64();
        a2.squareN(this.f13922g, i2, jArrCreate64);
        return new b2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        return add(fVar);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return (this.f13922g[0] & 1) != 0;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.h.toBigInteger64(this.f13922g);
    }

    @Override // g.a.g.a.f.a
    public int trace() {
        return a2.trace(this.f13922g);
    }
}
