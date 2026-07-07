package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class g0 extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f13953g = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f13954h;

    public g0() {
        this.f13954h = g.a.g.c.h.create();
    }

    public g0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f13953g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
        }
        this.f13954h = f0.fromBigInteger(bigInteger);
    }

    public g0(int[] iArr) {
        this.f13954h = iArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.h.create();
        f0.add(this.f13954h, ((g0) fVar).f13954h, iArrCreate);
        return new g0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        int[] iArrCreate = g.a.g.c.h.create();
        f0.addOne(this.f13954h, iArrCreate);
        return new g0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.h.create();
        f0.inv(((g0) fVar).f13954h, iArrCreate);
        f0.multiply(iArrCreate, this.f13954h, iArrCreate);
        return new g0(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0) {
            return g.a.g.c.h.eq(this.f13954h, ((g0) obj).f13954h);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecP256K1Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f13953g.bitLength();
    }

    public int hashCode() {
        return f13953g.hashCode() ^ g.a.j.a.hashCode(this.f13954h, 0, 8);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        int[] iArrCreate = g.a.g.c.h.create();
        f0.inv(this.f13954h, iArrCreate);
        return new g0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.h.isOne(this.f13954h);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.h.isZero(this.f13954h);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.h.create();
        f0.multiply(this.f13954h, ((g0) fVar).f13954h, iArrCreate);
        return new g0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        int[] iArrCreate = g.a.g.c.h.create();
        f0.negate(this.f13954h, iArrCreate);
        return new g0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        int[] iArr = this.f13954h;
        if (g.a.g.c.h.isZero(iArr) || g.a.g.c.h.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = g.a.g.c.h.create();
        f0.square(iArr, iArrCreate);
        f0.multiply(iArrCreate, iArr, iArrCreate);
        int[] iArrCreate2 = g.a.g.c.h.create();
        f0.square(iArrCreate, iArrCreate2);
        f0.multiply(iArrCreate2, iArr, iArrCreate2);
        int[] iArrCreate3 = g.a.g.c.h.create();
        f0.squareN(iArrCreate2, 3, iArrCreate3);
        f0.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        f0.squareN(iArrCreate3, 3, iArrCreate3);
        f0.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        f0.squareN(iArrCreate3, 2, iArrCreate3);
        f0.multiply(iArrCreate3, iArrCreate, iArrCreate3);
        int[] iArrCreate4 = g.a.g.c.h.create();
        f0.squareN(iArrCreate3, 11, iArrCreate4);
        f0.multiply(iArrCreate4, iArrCreate3, iArrCreate4);
        f0.squareN(iArrCreate4, 22, iArrCreate3);
        f0.multiply(iArrCreate3, iArrCreate4, iArrCreate3);
        int[] iArrCreate5 = g.a.g.c.h.create();
        f0.squareN(iArrCreate3, 44, iArrCreate5);
        f0.multiply(iArrCreate5, iArrCreate3, iArrCreate5);
        int[] iArrCreate6 = g.a.g.c.h.create();
        f0.squareN(iArrCreate5, 88, iArrCreate6);
        f0.multiply(iArrCreate6, iArrCreate5, iArrCreate6);
        f0.squareN(iArrCreate6, 44, iArrCreate5);
        f0.multiply(iArrCreate5, iArrCreate3, iArrCreate5);
        f0.squareN(iArrCreate5, 3, iArrCreate3);
        f0.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        f0.squareN(iArrCreate3, 23, iArrCreate3);
        f0.multiply(iArrCreate3, iArrCreate4, iArrCreate3);
        f0.squareN(iArrCreate3, 6, iArrCreate3);
        f0.multiply(iArrCreate3, iArrCreate, iArrCreate3);
        f0.squareN(iArrCreate3, 2, iArrCreate3);
        f0.square(iArrCreate3, iArrCreate);
        if (g.a.g.c.h.eq(iArr, iArrCreate)) {
            return new g0(iArrCreate3);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        int[] iArrCreate = g.a.g.c.h.create();
        f0.square(this.f13954h, iArrCreate);
        return new g0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.h.create();
        f0.subtract(this.f13954h, ((g0) fVar).f13954h, iArrCreate);
        return new g0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return g.a.g.c.h.getBit(this.f13954h, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.h.toBigInteger(this.f13954h);
    }
}
