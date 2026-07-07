package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class q extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f14018g = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f14019h;

    public q() {
        this.f14019h = g.a.g.c.f.create();
    }

    public q(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f14018g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
        }
        this.f14019h = p.fromBigInteger(bigInteger);
    }

    public q(int[] iArr) {
        this.f14019h = iArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.f.create();
        p.add(this.f14019h, ((q) fVar).f14019h, iArrCreate);
        return new q(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        int[] iArrCreate = g.a.g.c.f.create();
        p.addOne(this.f14019h, iArrCreate);
        return new q(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.f.create();
        p.inv(((q) fVar).f14019h, iArrCreate);
        p.multiply(iArrCreate, this.f14019h, iArrCreate);
        return new q(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            return g.a.g.c.f.eq(this.f14019h, ((q) obj).f14019h);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecP192K1Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f14018g.bitLength();
    }

    public int hashCode() {
        return f14018g.hashCode() ^ g.a.j.a.hashCode(this.f14019h, 0, 6);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        int[] iArrCreate = g.a.g.c.f.create();
        p.inv(this.f14019h, iArrCreate);
        return new q(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.f.isOne(this.f14019h);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.f.isZero(this.f14019h);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.f.create();
        p.multiply(this.f14019h, ((q) fVar).f14019h, iArrCreate);
        return new q(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        int[] iArrCreate = g.a.g.c.f.create();
        p.negate(this.f14019h, iArrCreate);
        return new q(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        int[] iArr = this.f14019h;
        if (g.a.g.c.f.isZero(iArr) || g.a.g.c.f.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = g.a.g.c.f.create();
        p.square(iArr, iArrCreate);
        p.multiply(iArrCreate, iArr, iArrCreate);
        int[] iArrCreate2 = g.a.g.c.f.create();
        p.square(iArrCreate, iArrCreate2);
        p.multiply(iArrCreate2, iArr, iArrCreate2);
        int[] iArrCreate3 = g.a.g.c.f.create();
        p.squareN(iArrCreate2, 3, iArrCreate3);
        p.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        p.squareN(iArrCreate3, 2, iArrCreate3);
        p.multiply(iArrCreate3, iArrCreate, iArrCreate3);
        p.squareN(iArrCreate3, 8, iArrCreate);
        p.multiply(iArrCreate, iArrCreate3, iArrCreate);
        p.squareN(iArrCreate, 3, iArrCreate3);
        p.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        int[] iArrCreate4 = g.a.g.c.f.create();
        p.squareN(iArrCreate3, 16, iArrCreate4);
        p.multiply(iArrCreate4, iArrCreate, iArrCreate4);
        p.squareN(iArrCreate4, 35, iArrCreate);
        p.multiply(iArrCreate, iArrCreate4, iArrCreate);
        p.squareN(iArrCreate, 70, iArrCreate4);
        p.multiply(iArrCreate4, iArrCreate, iArrCreate4);
        p.squareN(iArrCreate4, 19, iArrCreate);
        p.multiply(iArrCreate, iArrCreate3, iArrCreate);
        p.squareN(iArrCreate, 20, iArrCreate);
        p.multiply(iArrCreate, iArrCreate3, iArrCreate);
        p.squareN(iArrCreate, 4, iArrCreate);
        p.multiply(iArrCreate, iArrCreate2, iArrCreate);
        p.squareN(iArrCreate, 6, iArrCreate);
        p.multiply(iArrCreate, iArrCreate2, iArrCreate);
        p.square(iArrCreate, iArrCreate);
        p.square(iArrCreate, iArrCreate2);
        if (g.a.g.c.f.eq(iArr, iArrCreate2)) {
            return new q(iArrCreate);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        int[] iArrCreate = g.a.g.c.f.create();
        p.square(this.f14019h, iArrCreate);
        return new q(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.f.create();
        p.subtract(this.f14019h, ((q) fVar).f14019h, iArrCreate);
        return new q(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return g.a.g.c.f.getBit(this.f14019h, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.f.toBigInteger(this.f14019h);
    }
}
