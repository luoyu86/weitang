package g.a.g.a.b0.c;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class l2 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f13989g;

    public l2() {
        this.f13989g = g.a.g.c.k.create64();
    }

    public l2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 409) {
            throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
        }
        this.f13989g = k2.fromBigInteger(bigInteger);
    }

    public l2(long[] jArr) {
        this.f13989g = jArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.k.create64();
        k2.add(this.f13989g, ((l2) fVar).f13989g, jArrCreate64);
        return new l2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        long[] jArrCreate64 = g.a.g.c.k.create64();
        k2.addOne(this.f13989g, jArrCreate64);
        return new l2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        return multiply(fVar.invert());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l2) {
            return g.a.g.c.k.eq64(this.f13989g, ((l2) obj).f13989g);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecT409Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return TTAdConstant.IMAGE_LIST_CODE;
    }

    public int getK1() {
        return 87;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return TTAdConstant.IMAGE_LIST_CODE;
    }

    public int getRepresentation() {
        return 2;
    }

    @Override // g.a.g.a.f.a
    public g.a.g.a.f halfTrace() {
        long[] jArrCreate64 = g.a.g.c.k.create64();
        k2.halfTrace(this.f13989g, jArrCreate64);
        return new l2(jArrCreate64);
    }

    @Override // g.a.g.a.f.a
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return g.a.j.a.hashCode(this.f13989g, 0, 7) ^ 4090087;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        long[] jArrCreate64 = g.a.g.c.k.create64();
        k2.invert(this.f13989g, jArrCreate64);
        return new l2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.k.isOne64(this.f13989g);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.k.isZero64(this.f13989g);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        long[] jArrCreate64 = g.a.g.c.k.create64();
        k2.multiply(this.f13989g, ((l2) fVar).f13989g, jArrCreate64);
        return new l2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        return multiplyPlusProduct(fVar, fVar2, fVar3);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiplyPlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2, g.a.g.a.f fVar3) {
        long[] jArr = this.f13989g;
        long[] jArr2 = ((l2) fVar).f13989g;
        long[] jArr3 = ((l2) fVar2).f13989g;
        long[] jArr4 = ((l2) fVar3).f13989g;
        long[] jArrCreate64 = g.a.g.c.n.create64(13);
        k2.multiplyAddToExt(jArr, jArr2, jArrCreate64);
        k2.multiplyAddToExt(jArr3, jArr4, jArrCreate64);
        long[] jArrCreate642 = g.a.g.c.k.create64();
        k2.reduce(jArrCreate64, jArrCreate642);
        return new l2(jArrCreate642);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        return this;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        long[] jArrCreate64 = g.a.g.c.k.create64();
        k2.sqrt(this.f13989g, jArrCreate64);
        return new l2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        long[] jArrCreate64 = g.a.g.c.k.create64();
        k2.square(this.f13989g, jArrCreate64);
        return new l2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squareMinusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        return squarePlusProduct(fVar, fVar2);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePlusProduct(g.a.g.a.f fVar, g.a.g.a.f fVar2) {
        long[] jArr = this.f13989g;
        long[] jArr2 = ((l2) fVar).f13989g;
        long[] jArr3 = ((l2) fVar2).f13989g;
        long[] jArrCreate64 = g.a.g.c.n.create64(13);
        k2.squareAddToExt(jArr, jArrCreate64);
        k2.multiplyAddToExt(jArr2, jArr3, jArrCreate64);
        long[] jArrCreate642 = g.a.g.c.k.create64();
        k2.reduce(jArrCreate64, jArrCreate642);
        return new l2(jArrCreate642);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f squarePow(int i2) {
        if (i2 < 1) {
            return this;
        }
        long[] jArrCreate64 = g.a.g.c.k.create64();
        k2.squareN(this.f13989g, i2, jArrCreate64);
        return new l2(jArrCreate64);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        return add(fVar);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return (this.f13989g[0] & 1) != 0;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.k.toBigInteger64(this.f13989g);
    }

    @Override // g.a.g.a.f.a
    public int trace() {
        return k2.trace(this.f13989g);
    }
}
