package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class o0 extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f14009g = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f14010h;

    public o0() {
        this.f14010h = g.a.g.c.n.create(12);
    }

    public o0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f14009g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        this.f14010h = n0.fromBigInteger(bigInteger);
    }

    public o0(int[] iArr) {
        this.f14010h = iArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.n.create(12);
        n0.add(this.f14010h, ((o0) fVar).f14010h, iArrCreate);
        return new o0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        int[] iArrCreate = g.a.g.c.n.create(12);
        n0.addOne(this.f14010h, iArrCreate);
        return new o0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.n.create(12);
        n0.inv(((o0) fVar).f14010h, iArrCreate);
        n0.multiply(iArrCreate, this.f14010h, iArrCreate);
        return new o0(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o0) {
            return g.a.g.c.n.eq(12, this.f14010h, ((o0) obj).f14010h);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecP384R1Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f14009g.bitLength();
    }

    public int hashCode() {
        return f14009g.hashCode() ^ g.a.j.a.hashCode(this.f14010h, 0, 12);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        int[] iArrCreate = g.a.g.c.n.create(12);
        n0.inv(this.f14010h, iArrCreate);
        return new o0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.n.isOne(12, this.f14010h);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.n.isZero(12, this.f14010h);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.n.create(12);
        n0.multiply(this.f14010h, ((o0) fVar).f14010h, iArrCreate);
        return new o0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        int[] iArrCreate = g.a.g.c.n.create(12);
        n0.negate(this.f14010h, iArrCreate);
        return new o0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        int[] iArr = this.f14010h;
        if (g.a.g.c.n.isZero(12, iArr) || g.a.g.c.n.isOne(12, iArr)) {
            return this;
        }
        int[] iArrCreate = g.a.g.c.n.create(12);
        int[] iArrCreate2 = g.a.g.c.n.create(12);
        int[] iArrCreate3 = g.a.g.c.n.create(12);
        int[] iArrCreate4 = g.a.g.c.n.create(12);
        n0.square(iArr, iArrCreate);
        n0.multiply(iArrCreate, iArr, iArrCreate);
        n0.squareN(iArrCreate, 2, iArrCreate2);
        n0.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        n0.square(iArrCreate2, iArrCreate2);
        n0.multiply(iArrCreate2, iArr, iArrCreate2);
        n0.squareN(iArrCreate2, 5, iArrCreate3);
        n0.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        n0.squareN(iArrCreate3, 5, iArrCreate4);
        n0.multiply(iArrCreate4, iArrCreate2, iArrCreate4);
        n0.squareN(iArrCreate4, 15, iArrCreate2);
        n0.multiply(iArrCreate2, iArrCreate4, iArrCreate2);
        n0.squareN(iArrCreate2, 2, iArrCreate3);
        n0.multiply(iArrCreate, iArrCreate3, iArrCreate);
        n0.squareN(iArrCreate3, 28, iArrCreate3);
        n0.multiply(iArrCreate2, iArrCreate3, iArrCreate2);
        n0.squareN(iArrCreate2, 60, iArrCreate3);
        n0.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        n0.squareN(iArrCreate3, 120, iArrCreate2);
        n0.multiply(iArrCreate2, iArrCreate3, iArrCreate2);
        n0.squareN(iArrCreate2, 15, iArrCreate2);
        n0.multiply(iArrCreate2, iArrCreate4, iArrCreate2);
        n0.squareN(iArrCreate2, 33, iArrCreate2);
        n0.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        n0.squareN(iArrCreate2, 64, iArrCreate2);
        n0.multiply(iArrCreate2, iArr, iArrCreate2);
        n0.squareN(iArrCreate2, 30, iArrCreate);
        n0.square(iArrCreate, iArrCreate2);
        if (g.a.g.c.n.eq(12, iArr, iArrCreate2)) {
            return new o0(iArrCreate);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        int[] iArrCreate = g.a.g.c.n.create(12);
        n0.square(this.f14010h, iArrCreate);
        return new o0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.n.create(12);
        n0.subtract(this.f14010h, ((o0) fVar).f14010h, iArrCreate);
        return new o0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return g.a.g.c.n.getBit(this.f14010h, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.n.toBigInteger(12, this.f14010h);
    }
}
