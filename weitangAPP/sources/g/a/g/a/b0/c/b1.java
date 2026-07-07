package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class b1 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f13921g;

    public b1() {
        this.f13921g = g.a.g.c.f.create64();
    }

    public b1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 131) {
            throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
        }
        this.f13921g = a1.fromBigInteger(bigInteger);
    }

    public b1(long[] jArr) {
        this.f13921g = jArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        a1.add(this.f13921g, ((b1) fVar).f13921g, jArrCreate64);
        return new b1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        a1.addOne(this.f13921g, jArrCreate64);
        return new b1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        return multiply(fVar.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b1) {
            return g.a.g.c.f.eq64(this.f13921g, ((b1) obj).f13921g);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecT131Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return 131;
    }

    public int getK1() {
        return 2;
    }

    public int getK2() {
        return 3;
    }

    public int getK3() {
        return 8;
    }

    public int getM() {
        return 131;
    }

    public int getRepresentation() {
        return 3;
    }

    @Override // g.a.g.a.f.a
    public g.a.g.a.f halfTrace() {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        a1.halfTrace(this.f13921g, jArrCreate64);
        return new b1(jArrCreate64);
    }

    @Override // g.a.g.a.f.a
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f13921g, 0, 3) ^ 131832;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        a1.invert(this.f13921g, jArrCreate64);
        return new b1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.f.isOne64(this.f13921g);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.f.isZero64(this.f13921g);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        a1.multiply(this.f13921g, ((b1) fVar).f13921g, jArrCreate64);
        return new b1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        return multiplyPlusProduct(fVar, fVar2, fVar3);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyPlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        long[] jArr = this.f13921g;
        long[] jArr2 = ((b1) fVar).f13921g;
        long[] jArr3 = ((b1) fVar2).f13921g;
        long[] jArr4 = ((b1) fVar3).f13921g;
        long[] jArrCreate64 = g.a.g.c.n.create64(5);
        a1.multiplyAddToExt(jArr, jArr2, jArrCreate64);
        a1.multiplyAddToExt(jArr3, jArr4, jArrCreate64);
        long[] jArrCreate642 = g.a.g.c.f.create64();
        a1.reduce(jArrCreate64, jArrCreate642);
        return new b1(jArrCreate642);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        return this;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        a1.sqrt(this.f13921g, jArrCreate64);
        return new b1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        long[] jArrCreate64 = g.a.g.c.f.create64();
        a1.square(this.f13921g, jArrCreate64);
        return new b1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squareMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return squarePlusProduct(fVar, fVar2);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        long[] jArr = this.f13921g;
        long[] jArr2 = ((b1) fVar).f13921g;
        long[] jArr3 = ((b1) fVar2).f13921g;
        long[] jArrCreate64 = g.a.g.c.n.create64(5);
        a1.squareAddToExt(jArr, jArrCreate64);
        a1.multiplyAddToExt(jArr2, jArr3, jArrCreate64);
        long[] jArrCreate642 = g.a.g.c.f.create64();
        a1.reduce(jArrCreate64, jArrCreate642);
        return new b1(jArrCreate642);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePow(int i2) {
        if (i2 < 1) {
            return this;
        }
        long[] jArrCreate64 = g.a.g.c.f.create64();
        a1.squareN(this.f13921g, i2, jArrCreate64);
        return new b1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        return add(fVar);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return (this.f13921g[0] & 1) != 0;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.f.toBigInteger64(this.f13921g);
    }

    @Override // g.a.g.a.f.a
    public int trace() {
        return a1.trace(this.f13921g);
    }
}
