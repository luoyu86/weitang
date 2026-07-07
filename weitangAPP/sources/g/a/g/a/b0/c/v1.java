package g.a.g.a.b0.c;

import com.chinavisionary.microtang.life.vo.SubmitLifeOrderVo;
import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class v1 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f14051g;

    public v1() {
        this.f14051g = g.a.g.c.h.create64();
    }

    public v1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        this.f14051g = u1.fromBigInteger(bigInteger);
    }

    public v1(long[] jArr) {
        this.f14051g = jArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        u1.add(this.f14051g, ((v1) fVar).f14051g, jArrCreate64);
        return new v1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        u1.addOne(this.f14051g, jArrCreate64);
        return new v1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        return multiply(fVar.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v1) {
            return g.a.g.c.h.eq64(this.f14051g, ((v1) obj).f14051g);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecT233Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return SubmitLifeOrderVo.ITEM_TYPE_INFO;
    }

    public int getK1() {
        return 74;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return SubmitLifeOrderVo.ITEM_TYPE_INFO;
    }

    public int getRepresentation() {
        return 2;
    }

    @Override // g.a.g.a.f.a
    public g.a.g.a.f halfTrace() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        u1.halfTrace(this.f14051g, jArrCreate64);
        return new v1(jArrCreate64);
    }

    @Override // g.a.g.a.f.a
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f14051g, 0, 4) ^ 2330074;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        u1.invert(this.f14051g, jArrCreate64);
        return new v1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.h.isOne64(this.f14051g);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.h.isZero64(this.f14051g);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        u1.multiply(this.f14051g, ((v1) fVar).f14051g, jArrCreate64);
        return new v1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        return multiplyPlusProduct(fVar, fVar2, fVar3);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyPlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        long[] jArr = this.f14051g;
        long[] jArr2 = ((v1) fVar).f14051g;
        long[] jArr3 = ((v1) fVar2).f14051g;
        long[] jArr4 = ((v1) fVar3).f14051g;
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        u1.multiplyAddToExt(jArr, jArr2, jArrCreateExt64);
        u1.multiplyAddToExt(jArr3, jArr4, jArrCreateExt64);
        long[] jArrCreate64 = g.a.g.c.h.create64();
        u1.reduce(jArrCreateExt64, jArrCreate64);
        return new v1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        return this;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        u1.sqrt(this.f14051g, jArrCreate64);
        return new v1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        long[] jArrCreate64 = g.a.g.c.h.create64();
        u1.square(this.f14051g, jArrCreate64);
        return new v1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squareMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return squarePlusProduct(fVar, fVar2);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        long[] jArr = this.f14051g;
        long[] jArr2 = ((v1) fVar).f14051g;
        long[] jArr3 = ((v1) fVar2).f14051g;
        long[] jArrCreateExt64 = g.a.g.c.h.createExt64();
        u1.squareAddToExt(jArr, jArrCreateExt64);
        u1.multiplyAddToExt(jArr2, jArr3, jArrCreateExt64);
        long[] jArrCreate64 = g.a.g.c.h.create64();
        u1.reduce(jArrCreateExt64, jArrCreate64);
        return new v1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePow(int i2) {
        if (i2 < 1) {
            return this;
        }
        long[] jArrCreate64 = g.a.g.c.h.create64();
        u1.squareN(this.f14051g, i2, jArrCreate64);
        return new v1(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        return add(fVar);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return (this.f14051g[0] & 1) != 0;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.h.toBigInteger64(this.f14051g);
    }

    @Override // g.a.g.a.f.a
    public int trace() {
        return u1.trace(this.f14051g);
    }
}
