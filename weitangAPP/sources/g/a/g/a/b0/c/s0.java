package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class s0 extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f14034g = new BigInteger(1, g.a.j.r.c.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f14035h;

    public s0() {
        this.f14035h = g.a.g.c.n.create(17);
    }

    public s0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f14034g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        this.f14035h = r0.fromBigInteger(bigInteger);
    }

    public s0(int[] iArr) {
        this.f14035h = iArr;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.n.create(17);
        r0.add(this.f14035h, ((s0) fVar).f14035h, iArrCreate);
        return new s0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        int[] iArrCreate = g.a.g.c.n.create(17);
        r0.addOne(this.f14035h, iArrCreate);
        return new s0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.n.create(17);
        r0.inv(((s0) fVar).f14035h, iArrCreate);
        r0.multiply(iArrCreate, this.f14035h, iArrCreate);
        return new s0(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s0) {
            return g.a.g.c.n.eq(17, this.f14035h, ((s0) obj).f14035h);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecP521R1Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f14034g.bitLength();
    }

    public int hashCode() {
        return f14034g.hashCode() ^ g.a.j.a.hashCode(this.f14035h, 0, 17);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        int[] iArrCreate = g.a.g.c.n.create(17);
        r0.inv(this.f14035h, iArrCreate);
        return new s0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.n.isOne(17, this.f14035h);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.n.isZero(17, this.f14035h);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.n.create(17);
        r0.multiply(this.f14035h, ((s0) fVar).f14035h, iArrCreate);
        return new s0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        int[] iArrCreate = g.a.g.c.n.create(17);
        r0.negate(this.f14035h, iArrCreate);
        return new s0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        int[] iArr = this.f14035h;
        if (g.a.g.c.n.isZero(17, iArr) || g.a.g.c.n.isOne(17, iArr)) {
            return this;
        }
        int[] iArrCreate = g.a.g.c.n.create(17);
        int[] iArrCreate2 = g.a.g.c.n.create(17);
        r0.squareN(iArr, 519, iArrCreate);
        r0.square(iArrCreate, iArrCreate2);
        if (g.a.g.c.n.eq(17, iArr, iArrCreate2)) {
            return new s0(iArrCreate);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        int[] iArrCreate = g.a.g.c.n.create(17);
        r0.square(this.f14035h, iArrCreate);
        return new s0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.n.create(17);
        r0.subtract(this.f14035h, ((s0) fVar).f14035h, iArrCreate);
        return new s0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return g.a.g.c.n.getBit(this.f14035h, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.n.toBigInteger(17, this.f14035h);
    }
}
