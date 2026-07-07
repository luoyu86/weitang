package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class i extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f13963g = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f13964h;

    public i() {
        this.f13964h = g.a.g.c.e.create();
    }

    public i(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f13963g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
        }
        this.f13964h = h.fromBigInteger(bigInteger);
    }

    public i(int[] iArr) {
        this.f13964h = iArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.e.create();
        h.add(this.f13964h, ((i) fVar).f13964h, iArrCreate);
        return new i(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        int[] iArrCreate = g.a.g.c.e.create();
        h.addOne(this.f13964h, iArrCreate);
        return new i(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.e.create();
        h.inv(((i) fVar).f13964h, iArrCreate);
        h.multiply(iArrCreate, this.f13964h, iArrCreate);
        return new i(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            return g.a.g.c.e.eq(this.f13964h, ((i) obj).f13964h);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecP160R1Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f13963g.bitLength();
    }

    public int hashCode() {
        return f13963g.hashCode() ^ g.a.j.a.hashCode(this.f13964h, 0, 5);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        int[] iArrCreate = g.a.g.c.e.create();
        h.inv(this.f13964h, iArrCreate);
        return new i(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.e.isOne(this.f13964h);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.e.isZero(this.f13964h);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.e.create();
        h.multiply(this.f13964h, ((i) fVar).f13964h, iArrCreate);
        return new i(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        int[] iArrCreate = g.a.g.c.e.create();
        h.negate(this.f13964h, iArrCreate);
        return new i(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        int[] iArr = this.f13964h;
        if (g.a.g.c.e.isZero(iArr) || g.a.g.c.e.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = g.a.g.c.e.create();
        h.square(iArr, iArrCreate);
        h.multiply(iArrCreate, iArr, iArrCreate);
        int[] iArrCreate2 = g.a.g.c.e.create();
        h.squareN(iArrCreate, 2, iArrCreate2);
        h.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        h.squareN(iArrCreate2, 4, iArrCreate);
        h.multiply(iArrCreate, iArrCreate2, iArrCreate);
        h.squareN(iArrCreate, 8, iArrCreate2);
        h.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        h.squareN(iArrCreate2, 16, iArrCreate);
        h.multiply(iArrCreate, iArrCreate2, iArrCreate);
        h.squareN(iArrCreate, 32, iArrCreate2);
        h.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        h.squareN(iArrCreate2, 64, iArrCreate);
        h.multiply(iArrCreate, iArrCreate2, iArrCreate);
        h.square(iArrCreate, iArrCreate2);
        h.multiply(iArrCreate2, iArr, iArrCreate2);
        h.squareN(iArrCreate2, 29, iArrCreate2);
        h.square(iArrCreate2, iArrCreate);
        if (g.a.g.c.e.eq(iArr, iArrCreate)) {
            return new i(iArrCreate2);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        int[] iArrCreate = g.a.g.c.e.create();
        h.square(this.f13964h, iArrCreate);
        return new i(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.e.create();
        h.subtract(this.f13964h, ((i) fVar).f13964h, iArrCreate);
        return new i(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return g.a.g.c.e.getBit(this.f13964h, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.e.toBigInteger(this.f13964h);
    }
}
