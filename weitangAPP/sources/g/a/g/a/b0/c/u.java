package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class u extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f14045g = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f14046h;

    public u() {
        this.f14046h = g.a.g.c.f.create();
    }

    public u(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f14045g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
        }
        this.f14046h = t.fromBigInteger(bigInteger);
    }

    public u(int[] iArr) {
        this.f14046h = iArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.f.create();
        t.add(this.f14046h, ((u) fVar).f14046h, iArrCreate);
        return new u(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        int[] iArrCreate = g.a.g.c.f.create();
        t.addOne(this.f14046h, iArrCreate);
        return new u(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.f.create();
        t.inv(((u) fVar).f14046h, iArrCreate);
        t.multiply(iArrCreate, this.f14046h, iArrCreate);
        return new u(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            return g.a.g.c.f.eq(this.f14046h, ((u) obj).f14046h);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecP192R1Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f14045g.bitLength();
    }

    public int hashCode() {
        return f14045g.hashCode() ^ g.a.j.a.hashCode(this.f14046h, 0, 6);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        int[] iArrCreate = g.a.g.c.f.create();
        t.inv(this.f14046h, iArrCreate);
        return new u(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.f.isOne(this.f14046h);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.f.isZero(this.f14046h);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.f.create();
        t.multiply(this.f14046h, ((u) fVar).f14046h, iArrCreate);
        return new u(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        int[] iArrCreate = g.a.g.c.f.create();
        t.negate(this.f14046h, iArrCreate);
        return new u(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        int[] iArr = this.f14046h;
        if (g.a.g.c.f.isZero(iArr) || g.a.g.c.f.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = g.a.g.c.f.create();
        int[] iArrCreate2 = g.a.g.c.f.create();
        t.square(iArr, iArrCreate);
        t.multiply(iArrCreate, iArr, iArrCreate);
        t.squareN(iArrCreate, 2, iArrCreate2);
        t.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        t.squareN(iArrCreate2, 4, iArrCreate);
        t.multiply(iArrCreate, iArrCreate2, iArrCreate);
        t.squareN(iArrCreate, 8, iArrCreate2);
        t.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        t.squareN(iArrCreate2, 16, iArrCreate);
        t.multiply(iArrCreate, iArrCreate2, iArrCreate);
        t.squareN(iArrCreate, 32, iArrCreate2);
        t.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        t.squareN(iArrCreate2, 64, iArrCreate);
        t.multiply(iArrCreate, iArrCreate2, iArrCreate);
        t.squareN(iArrCreate, 62, iArrCreate);
        t.square(iArrCreate, iArrCreate2);
        if (g.a.g.c.f.eq(iArr, iArrCreate2)) {
            return new u(iArrCreate);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        int[] iArrCreate = g.a.g.c.f.create();
        t.square(this.f14046h, iArrCreate);
        return new u(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.f.create();
        t.subtract(this.f14046h, ((u) fVar).f14046h, iArrCreate);
        return new u(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return g.a.g.c.f.getBit(this.f14046h, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.f.toBigInteger(this.f14046h);
    }
}
