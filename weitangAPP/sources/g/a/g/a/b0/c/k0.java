package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class k0 extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f13981g = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f13982h;

    public k0() {
        this.f13982h = g.a.g.c.h.create();
    }

    public k0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f13981g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
        }
        this.f13982h = j0.fromBigInteger(bigInteger);
    }

    public k0(int[] iArr) {
        this.f13982h = iArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.h.create();
        j0.add(this.f13982h, ((k0) fVar).f13982h, iArrCreate);
        return new k0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        int[] iArrCreate = g.a.g.c.h.create();
        j0.addOne(this.f13982h, iArrCreate);
        return new k0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.h.create();
        j0.inv(((k0) fVar).f13982h, iArrCreate);
        j0.multiply(iArrCreate, this.f13982h, iArrCreate);
        return new k0(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k0) {
            return g.a.g.c.h.eq(this.f13982h, ((k0) obj).f13982h);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecP256R1Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f13981g.bitLength();
    }

    public int hashCode() {
        return f13981g.hashCode() ^ g.a.j.a.hashCode(this.f13982h, 0, 8);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        int[] iArrCreate = g.a.g.c.h.create();
        j0.inv(this.f13982h, iArrCreate);
        return new k0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.h.isOne(this.f13982h);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.h.isZero(this.f13982h);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.h.create();
        j0.multiply(this.f13982h, ((k0) fVar).f13982h, iArrCreate);
        return new k0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        int[] iArrCreate = g.a.g.c.h.create();
        j0.negate(this.f13982h, iArrCreate);
        return new k0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        int[] iArr = this.f13982h;
        if (g.a.g.c.h.isZero(iArr) || g.a.g.c.h.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = g.a.g.c.h.create();
        int[] iArrCreate2 = g.a.g.c.h.create();
        j0.square(iArr, iArrCreate);
        j0.multiply(iArrCreate, iArr, iArrCreate);
        j0.squareN(iArrCreate, 2, iArrCreate2);
        j0.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        j0.squareN(iArrCreate2, 4, iArrCreate);
        j0.multiply(iArrCreate, iArrCreate2, iArrCreate);
        j0.squareN(iArrCreate, 8, iArrCreate2);
        j0.multiply(iArrCreate2, iArrCreate, iArrCreate2);
        j0.squareN(iArrCreate2, 16, iArrCreate);
        j0.multiply(iArrCreate, iArrCreate2, iArrCreate);
        j0.squareN(iArrCreate, 32, iArrCreate);
        j0.multiply(iArrCreate, iArr, iArrCreate);
        j0.squareN(iArrCreate, 96, iArrCreate);
        j0.multiply(iArrCreate, iArr, iArrCreate);
        j0.squareN(iArrCreate, 94, iArrCreate);
        j0.square(iArrCreate, iArrCreate2);
        if (g.a.g.c.h.eq(iArr, iArrCreate2)) {
            return new k0(iArrCreate);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        int[] iArrCreate = g.a.g.c.h.create();
        j0.square(this.f13982h, iArrCreate);
        return new k0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.h.create();
        j0.subtract(this.f13982h, ((k0) fVar).f13982h, iArrCreate);
        return new k0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return g.a.g.c.h.getBit(this.f13982h, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.h.toBigInteger(this.f13982h);
    }
}
