package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class m extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f13990g = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f13991h;

    public m() {
        this.f13991h = g.a.g.c.e.create();
    }

    public m(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f13990g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
        }
        this.f13991h = l.fromBigInteger(bigInteger);
    }

    public m(int[] iArr) {
        this.f13991h = iArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.e.create();
        l.add(this.f13991h, ((m) fVar).f13991h, iArrCreate);
        return new m(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        int[] iArrCreate = g.a.g.c.e.create();
        l.addOne(this.f13991h, iArrCreate);
        return new m(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.e.create();
        l.inv(((m) fVar).f13991h, iArrCreate);
        l.multiply(iArrCreate, this.f13991h, iArrCreate);
        return new m(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            return g.a.g.c.e.eq(this.f13991h, ((m) obj).f13991h);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecP160R2Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f13990g.bitLength();
    }

    public int hashCode() {
        return f13990g.hashCode() ^ g.a.j.a.hashCode(this.f13991h, 0, 5);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        int[] iArrCreate = g.a.g.c.e.create();
        l.inv(this.f13991h, iArrCreate);
        return new m(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.e.isOne(this.f13991h);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.e.isZero(this.f13991h);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.e.create();
        l.multiply(this.f13991h, ((m) fVar).f13991h, iArrCreate);
        return new m(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        int[] iArrCreate = g.a.g.c.e.create();
        l.negate(this.f13991h, iArrCreate);
        return new m(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        int[] iArr = this.f13991h;
        if (g.a.g.c.e.isZero(iArr) || g.a.g.c.e.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = g.a.g.c.e.create();
        l.square(iArr, iArrCreate);
        l.multiply(iArrCreate, iArr, iArrCreate);
        int[] iArrCreate2 = g.a.g.c.e.create();
        l.square(iArrCreate, iArrCreate2);
        l.multiply(iArrCreate2, iArr, iArrCreate2);
        int[] iArrCreate3 = g.a.g.c.e.create();
        l.square(iArrCreate2, iArrCreate3);
        l.multiply(iArrCreate3, iArr, iArrCreate3);
        int[] iArrCreate4 = g.a.g.c.e.create();
        l.squareN(iArrCreate3, 3, iArrCreate4);
        l.multiply(iArrCreate4, iArrCreate2, iArrCreate4);
        l.squareN(iArrCreate4, 7, iArrCreate3);
        l.multiply(iArrCreate3, iArrCreate4, iArrCreate3);
        l.squareN(iArrCreate3, 3, iArrCreate4);
        l.multiply(iArrCreate4, iArrCreate2, iArrCreate4);
        int[] iArrCreate5 = g.a.g.c.e.create();
        l.squareN(iArrCreate4, 14, iArrCreate5);
        l.multiply(iArrCreate5, iArrCreate3, iArrCreate5);
        l.squareN(iArrCreate5, 31, iArrCreate3);
        l.multiply(iArrCreate3, iArrCreate5, iArrCreate3);
        l.squareN(iArrCreate3, 62, iArrCreate5);
        l.multiply(iArrCreate5, iArrCreate3, iArrCreate5);
        l.squareN(iArrCreate5, 3, iArrCreate3);
        l.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        l.squareN(iArrCreate3, 18, iArrCreate3);
        l.multiply(iArrCreate3, iArrCreate4, iArrCreate3);
        l.squareN(iArrCreate3, 2, iArrCreate3);
        l.multiply(iArrCreate3, iArr, iArrCreate3);
        l.squareN(iArrCreate3, 3, iArrCreate3);
        l.multiply(iArrCreate3, iArrCreate, iArrCreate3);
        l.squareN(iArrCreate3, 6, iArrCreate3);
        l.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        l.squareN(iArrCreate3, 2, iArrCreate3);
        l.multiply(iArrCreate3, iArr, iArrCreate3);
        l.square(iArrCreate3, iArrCreate);
        if (g.a.g.c.e.eq(iArr, iArrCreate)) {
            return new m(iArrCreate3);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        int[] iArrCreate = g.a.g.c.e.create();
        l.square(this.f13991h, iArrCreate);
        return new m(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.e.create();
        l.subtract(this.f13991h, ((m) fVar).f13991h, iArrCreate);
        return new m(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return g.a.g.c.e.getBit(this.f13991h, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.e.toBigInteger(this.f13991h);
    }
}
