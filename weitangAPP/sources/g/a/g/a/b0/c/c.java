package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class c extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f13923g = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f13924h;

    public c() {
        this.f13924h = g.a.g.c.d.create();
    }

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f13923g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
        }
        this.f13924h = b.fromBigInteger(bigInteger);
    }

    public c(int[] iArr) {
        this.f13924h = iArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.d.create();
        b.add(this.f13924h, ((c) fVar).f13924h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        int[] iArrCreate = g.a.g.c.d.create();
        b.addOne(this.f13924h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.d.create();
        b.inv(((c) fVar).f13924h, iArrCreate);
        b.multiply(iArrCreate, this.f13924h, iArrCreate);
        return new c(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return g.a.g.c.d.eq(this.f13924h, ((c) obj).f13924h);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecP128R1Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f13923g.bitLength();
    }

    public int hashCode() {
        return f13923g.hashCode() ^ g.a.j.a.hashCode(this.f13924h, 0, 4);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        int[] iArrCreate = g.a.g.c.d.create();
        b.inv(this.f13924h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.d.isOne(this.f13924h);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.d.isZero(this.f13924h);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.d.create();
        b.multiply(this.f13924h, ((c) fVar).f13924h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        int[] iArrCreate = g.a.g.c.d.create();
        b.negate(this.f13924h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        int[] iArr = this.f13924h;
        if (g.a.g.c.d.isZero(iArr) || g.a.g.c.d.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = g.a.g.c.d.create();
        b.square(iArr, iArrCreate);
        b.multiply(iArrCreate, iArr, iArrCreate);
        int[] iArrCreate2 = g.a.g.c.d.create();
        b.squareN(iArrCreate, 2, iArrCreate2);
        b.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        int[] iArrCreate3 = g.a.g.c.d.create();
        b.squareN(iArrCreate2, 4, iArrCreate3);
        b.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        b.squareN(iArrCreate3, 2, iArrCreate2);
        b.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        b.squareN(iArrCreate2, 10, iArrCreate);
        b.multiply(iArrCreate, iArrCreate2, iArrCreate);
        b.squareN(iArrCreate, 10, iArrCreate3);
        b.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        b.square(iArrCreate3, iArrCreate2);
        b.multiply(iArrCreate2, iArr, iArrCreate2);
        b.squareN(iArrCreate2, 95, iArrCreate2);
        b.square(iArrCreate2, iArrCreate3);
        if (g.a.g.c.d.eq(iArr, iArrCreate3)) {
            return new c(iArrCreate2);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        int[] iArrCreate = g.a.g.c.d.create();
        b.square(this.f13924h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.d.create();
        b.subtract(this.f13924h, ((c) fVar).f13924h, iArrCreate);
        return new c(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return g.a.g.c.d.getBit(this.f13924h, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.d.toBigInteger(this.f13924h);
    }
}
