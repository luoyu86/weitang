package g.a.g.a.b0.b;

import g.a.g.a.f;
import g.a.g.c.h;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class c extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f13904g = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f13905h;

    public c() {
        this.f13905h = h.create();
    }

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f13904g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
        }
        this.f13905h = b.fromBigInteger(bigInteger);
    }

    public c(int[] iArr) {
        this.f13905h = iArr;
    }

    @Override // g.a.g.a.f
    public f add(f fVar) {
        int[] iArrCreate = h.create();
        b.add(this.f13905h, ((c) fVar).f13905h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public f addOne() {
        int[] iArrCreate = h.create();
        b.addOne(this.f13905h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public f divide(f fVar) {
        int[] iArrCreate = h.create();
        b.inv(((c) fVar).f13905h, iArrCreate);
        b.multiply(iArrCreate, this.f13905h, iArrCreate);
        return new c(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return h.eq(this.f13905h, ((c) obj).f13905h);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SM2P256V1Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f13904g.bitLength();
    }

    public int hashCode() {
        return f13904g.hashCode() ^ g.a.j.a.hashCode(this.f13905h, 0, 8);
    }

    @Override // g.a.g.a.f
    public f invert() {
        int[] iArrCreate = h.create();
        b.inv(this.f13905h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return h.isOne(this.f13905h);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return h.isZero(this.f13905h);
    }

    @Override // g.a.g.a.f
    public f multiply(f fVar) {
        int[] iArrCreate = h.create();
        b.multiply(this.f13905h, ((c) fVar).f13905h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public f negate() {
        int[] iArrCreate = h.create();
        b.negate(this.f13905h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public f sqrt() {
        int[] iArr = this.f13905h;
        if (h.isZero(iArr) || h.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = h.create();
        b.square(iArr, iArrCreate);
        b.multiply(iArrCreate, iArr, iArrCreate);
        int[] iArrCreate2 = h.create();
        b.squareN(iArrCreate, 2, iArrCreate2);
        b.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        int[] iArrCreate3 = h.create();
        b.squareN(iArrCreate2, 2, iArrCreate3);
        b.multiply(iArrCreate3, iArrCreate, iArrCreate3);
        b.squareN(iArrCreate3, 6, iArrCreate);
        b.multiply(iArrCreate, iArrCreate3, iArrCreate);
        int[] iArrCreate4 = h.create();
        b.squareN(iArrCreate, 12, iArrCreate4);
        b.multiply(iArrCreate4, iArrCreate, iArrCreate4);
        b.squareN(iArrCreate4, 6, iArrCreate);
        b.multiply(iArrCreate, iArrCreate3, iArrCreate);
        b.square(iArrCreate, iArrCreate3);
        b.multiply(iArrCreate3, iArr, iArrCreate3);
        b.squareN(iArrCreate3, 31, iArrCreate4);
        b.multiply(iArrCreate4, iArrCreate3, iArrCreate);
        b.squareN(iArrCreate4, 32, iArrCreate4);
        b.multiply(iArrCreate4, iArrCreate, iArrCreate4);
        b.squareN(iArrCreate4, 62, iArrCreate4);
        b.multiply(iArrCreate4, iArrCreate, iArrCreate4);
        b.squareN(iArrCreate4, 4, iArrCreate4);
        b.multiply(iArrCreate4, iArrCreate2, iArrCreate4);
        b.squareN(iArrCreate4, 32, iArrCreate4);
        b.multiply(iArrCreate4, iArr, iArrCreate4);
        b.squareN(iArrCreate4, 62, iArrCreate4);
        b.square(iArrCreate4, iArrCreate2);
        if (h.eq(iArr, iArrCreate2)) {
            return new c(iArrCreate4);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public f square() {
        int[] iArrCreate = h.create();
        b.square(this.f13905h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public f subtract(f fVar) {
        int[] iArrCreate = h.create();
        b.subtract(this.f13905h, ((c) fVar).f13905h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return h.getBit(this.f13905h, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return h.toBigInteger(this.f13905h);
    }
}
