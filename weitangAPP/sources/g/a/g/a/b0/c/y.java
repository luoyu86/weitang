package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class y extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f14065g = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f14066h = {868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f14067i;

    public y() {
        this.f14067i = g.a.g.c.g.create();
    }

    public y(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f14065g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        }
        this.f14067i = x.fromBigInteger(bigInteger);
    }

    public y(int[] iArr) {
        this.f14067i = iArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.g.create();
        x.add(this.f14067i, ((y) fVar).f14067i, iArrCreate);
        return new y(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        int[] iArrCreate = g.a.g.c.g.create();
        x.addOne(this.f14067i, iArrCreate);
        return new y(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.g.create();
        x.inv(((y) fVar).f14067i, iArrCreate);
        x.multiply(iArrCreate, this.f14067i, iArrCreate);
        return new y(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y) {
            return g.a.g.c.g.eq(this.f14067i, ((y) obj).f14067i);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecP224K1Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f14065g.bitLength();
    }

    public int hashCode() {
        return f14065g.hashCode() ^ g.a.j.a.hashCode(this.f14067i, 0, 7);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        int[] iArrCreate = g.a.g.c.g.create();
        x.inv(this.f14067i, iArrCreate);
        return new y(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.g.isOne(this.f14067i);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.g.isZero(this.f14067i);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.g.create();
        x.multiply(this.f14067i, ((y) fVar).f14067i, iArrCreate);
        return new y(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        int[] iArrCreate = g.a.g.c.g.create();
        x.negate(this.f14067i, iArrCreate);
        return new y(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        int[] iArr = this.f14067i;
        if (g.a.g.c.g.isZero(iArr) || g.a.g.c.g.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = g.a.g.c.g.create();
        x.square(iArr, iArrCreate);
        x.multiply(iArrCreate, iArr, iArrCreate);
        x.square(iArrCreate, iArrCreate);
        x.multiply(iArrCreate, iArr, iArrCreate);
        int[] iArrCreate2 = g.a.g.c.g.create();
        x.square(iArrCreate, iArrCreate2);
        x.multiply(iArrCreate2, iArr, iArrCreate2);
        int[] iArrCreate3 = g.a.g.c.g.create();
        x.squareN(iArrCreate2, 4, iArrCreate3);
        x.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        int[] iArrCreate4 = g.a.g.c.g.create();
        x.squareN(iArrCreate3, 3, iArrCreate4);
        x.multiply(iArrCreate4, iArrCreate, iArrCreate4);
        x.squareN(iArrCreate4, 8, iArrCreate4);
        x.multiply(iArrCreate4, iArrCreate3, iArrCreate4);
        x.squareN(iArrCreate4, 4, iArrCreate3);
        x.multiply(iArrCreate3, iArrCreate2, iArrCreate3);
        x.squareN(iArrCreate3, 19, iArrCreate2);
        x.multiply(iArrCreate2, iArrCreate4, iArrCreate2);
        int[] iArrCreate5 = g.a.g.c.g.create();
        x.squareN(iArrCreate2, 42, iArrCreate5);
        x.multiply(iArrCreate5, iArrCreate2, iArrCreate5);
        x.squareN(iArrCreate5, 23, iArrCreate2);
        x.multiply(iArrCreate2, iArrCreate3, iArrCreate2);
        x.squareN(iArrCreate2, 84, iArrCreate3);
        x.multiply(iArrCreate3, iArrCreate5, iArrCreate3);
        x.squareN(iArrCreate3, 20, iArrCreate3);
        x.multiply(iArrCreate3, iArrCreate4, iArrCreate3);
        x.squareN(iArrCreate3, 3, iArrCreate3);
        x.multiply(iArrCreate3, iArr, iArrCreate3);
        x.squareN(iArrCreate3, 2, iArrCreate3);
        x.multiply(iArrCreate3, iArr, iArrCreate3);
        x.squareN(iArrCreate3, 4, iArrCreate3);
        x.multiply(iArrCreate3, iArrCreate, iArrCreate3);
        x.square(iArrCreate3, iArrCreate3);
        x.square(iArrCreate3, iArrCreate5);
        if (g.a.g.c.g.eq(iArr, iArrCreate5)) {
            return new y(iArrCreate3);
        }
        x.multiply(iArrCreate3, f14066h, iArrCreate3);
        x.square(iArrCreate3, iArrCreate5);
        if (g.a.g.c.g.eq(iArr, iArrCreate5)) {
            return new y(iArrCreate3);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        int[] iArrCreate = g.a.g.c.g.create();
        x.square(this.f14067i, iArrCreate);
        return new y(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.g.create();
        x.subtract(this.f14067i, ((y) fVar).f14067i, iArrCreate);
        return new y(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return g.a.g.c.g.getBit(this.f14067i, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.g.toBigInteger(this.f14067i);
    }
}
