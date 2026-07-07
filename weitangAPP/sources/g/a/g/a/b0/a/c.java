package g.a.g.a.b0.a;

import g.a.g.a.f;
import g.a.g.c.h;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class c extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f13895g = h.toBigInteger(b.f13893a);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f13896h = {1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f13897i;

    public c() {
        this.f13897i = h.create();
    }

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f13895g) >= 0) {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        }
        this.f13897i = b.fromBigInteger(bigInteger);
    }

    public c(int[] iArr) {
        this.f13897i = iArr;
    }

    @Override // g.a.g.a.f
    public f add(f fVar) {
        int[] iArrCreate = h.create();
        b.add(this.f13897i, ((c) fVar).f13897i, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public f addOne() {
        int[] iArrCreate = h.create();
        b.addOne(this.f13897i, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public f divide(f fVar) {
        int[] iArrCreate = h.create();
        b.inv(((c) fVar).f13897i, iArrCreate);
        b.multiply(iArrCreate, this.f13897i, iArrCreate);
        return new c(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return h.eq(this.f13897i, ((c) obj).f13897i);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "Curve25519Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f13895g.bitLength();
    }

    public int hashCode() {
        return f13895g.hashCode() ^ g.a.j.a.hashCode(this.f13897i, 0, 8);
    }

    @Override // g.a.g.a.f
    public f invert() {
        int[] iArrCreate = h.create();
        b.inv(this.f13897i, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return h.isOne(this.f13897i);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return h.isZero(this.f13897i);
    }

    @Override // g.a.g.a.f
    public f multiply(f fVar) {
        int[] iArrCreate = h.create();
        b.multiply(this.f13897i, ((c) fVar).f13897i, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public f negate() {
        int[] iArrCreate = h.create();
        b.negate(this.f13897i, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public f sqrt() {
        int[] iArr = this.f13897i;
        if (h.isZero(iArr) || h.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = h.create();
        b.square(iArr, iArrCreate);
        b.multiply(iArrCreate, iArr, iArrCreate);
        b.square(iArrCreate, iArrCreate);
        b.multiply(iArrCreate, iArr, iArrCreate);
        int[] iArrCreate2 = h.create();
        b.square(iArrCreate, iArrCreate2);
        b.multiply(iArrCreate2, iArr, iArrCreate2);
        int[] iArrCreate3 = h.create();
        b.squareN(iArrCreate2, 3, iArrCreate3);
        b.multiply(iArrCreate3, iArrCreate, iArrCreate3);
        b.squareN(iArrCreate3, 4, iArrCreate);
        b.multiply(iArrCreate, iArrCreate2, iArrCreate);
        b.squareN(iArrCreate, 4, iArrCreate3);
        b.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        b.squareN(iArrCreate3, 15, iArrCreate2);
        b.multiply(iArrCreate2, iArrCreate3, iArrCreate2);
        b.squareN(iArrCreate2, 30, iArrCreate3);
        b.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        b.squareN(iArrCreate3, 60, iArrCreate2);
        b.multiply(iArrCreate2, iArrCreate3, iArrCreate2);
        b.squareN(iArrCreate2, 11, iArrCreate3);
        b.multiply(iArrCreate3, iArrCreate, iArrCreate3);
        b.squareN(iArrCreate3, 120, iArrCreate);
        b.multiply(iArrCreate, iArrCreate2, iArrCreate);
        b.square(iArrCreate, iArrCreate);
        b.square(iArrCreate, iArrCreate2);
        if (h.eq(iArr, iArrCreate2)) {
            return new c(iArrCreate);
        }
        b.multiply(iArrCreate, f13896h, iArrCreate);
        b.square(iArrCreate, iArrCreate2);
        if (h.eq(iArr, iArrCreate2)) {
            return new c(iArrCreate);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public f square() {
        int[] iArrCreate = h.create();
        b.square(this.f13897i, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public f subtract(f fVar) {
        int[] iArrCreate = h.create();
        b.subtract(this.f13897i, ((c) fVar).f13897i, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return h.getBit(this.f13897i, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return h.toBigInteger(this.f13897i);
    }
}
