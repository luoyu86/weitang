package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class f2 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f13948g;

    public f2() {
        this.f13948g = g.a.g.c.i.create64();
    }

    public f2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 283) {
            throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
        }
        this.f13948g = e2.fromBigInteger(bigInteger);
    }

    public f2(long[] jArr) {
        this.f13948g = jArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.i.create64();
        e2.add(this.f13948g, ((f2) fVar).f13948g, jArrCreate64);
        return new f2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        long[] jArrCreate64 = g.a.g.c.i.create64();
        e2.addOne(this.f13948g, jArrCreate64);
        return new f2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        return multiply(fVar.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f2) {
            return g.a.g.c.i.eq64(this.f13948g, ((f2) obj).f13948g);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecT283Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return 283;
    }

    public int getK1() {
        return 5;
    }

    public int getK2() {
        return 7;
    }

    public int getK3() {
        return 12;
    }

    public int getM() {
        return 283;
    }

    public int getRepresentation() {
        return 3;
    }

    @Override // g.a.g.a.f.a
    public g.a.g.a.f halfTrace() {
        long[] jArrCreate64 = g.a.g.c.i.create64();
        e2.halfTrace(this.f13948g, jArrCreate64);
        return new f2(jArrCreate64);
    }

    @Override // g.a.g.a.f.a
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f13948g, 0, 5) ^ 2831275;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        long[] jArrCreate64 = g.a.g.c.i.create64();
        e2.invert(this.f13948g, jArrCreate64);
        return new f2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.i.isOne64(this.f13948g);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.i.isZero64(this.f13948g);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.i.create64();
        e2.multiply(this.f13948g, ((f2) fVar).f13948g, jArrCreate64);
        return new f2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        return multiplyPlusProduct(fVar, fVar2, fVar3);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyPlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        long[] jArr = this.f13948g;
        long[] jArr2 = ((f2) fVar).f13948g;
        long[] jArr3 = ((f2) fVar2).f13948g;
        long[] jArr4 = ((f2) fVar3).f13948g;
        long[] jArrCreate64 = g.a.g.c.n.create64(9);
        e2.multiplyAddToExt(jArr, jArr2, jArrCreate64);
        e2.multiplyAddToExt(jArr3, jArr4, jArrCreate64);
        long[] jArrCreate642 = g.a.g.c.i.create64();
        e2.reduce(jArrCreate64, jArrCreate642);
        return new f2(jArrCreate642);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        return this;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        long[] jArrCreate64 = g.a.g.c.i.create64();
        e2.sqrt(this.f13948g, jArrCreate64);
        return new f2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        long[] jArrCreate64 = g.a.g.c.i.create64();
        e2.square(this.f13948g, jArrCreate64);
        return new f2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squareMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return squarePlusProduct(fVar, fVar2);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        long[] jArr = this.f13948g;
        long[] jArr2 = ((f2) fVar).f13948g;
        long[] jArr3 = ((f2) fVar2).f13948g;
        long[] jArrCreate64 = g.a.g.c.n.create64(9);
        e2.squareAddToExt(jArr, jArrCreate64);
        e2.multiplyAddToExt(jArr2, jArr3, jArrCreate64);
        long[] jArrCreate642 = g.a.g.c.i.create64();
        e2.reduce(jArrCreate64, jArrCreate642);
        return new f2(jArrCreate642);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePow(int i2) {
        if (i2 < 1) {
            return this;
        }
        long[] jArrCreate64 = g.a.g.c.i.create64();
        e2.squareN(this.f13948g, i2, jArrCreate64);
        return new f2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        return add(fVar);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return (this.f13948g[0] & 1) != 0;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.i.toBigInteger64(this.f13948g);
    }

    @Override // g.a.g.a.f.a
    public int trace() {
        return e2.trace(this.f13948g);
    }
}
