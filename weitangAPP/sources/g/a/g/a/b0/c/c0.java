package g.a.g.a.b0.c;

import g.a.g.a.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class c0 extends f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f13925g = new BigInteger(1, g.a.j.r.c.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int[] f13926h;

    public c0() {
        this.f13926h = g.a.g.c.g.create();
    }

    public c0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f13925g) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        this.f13926h = b0.fromBigInteger(bigInteger);
    }

    public c0(int[] iArr) {
        this.f13926h = iArr;
    }

    public static void a(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7) {
        b0.multiply(iArr5, iArr3, iArr7);
        b0.multiply(iArr7, iArr, iArr7);
        b0.multiply(iArr4, iArr2, iArr6);
        b0.add(iArr6, iArr7, iArr6);
        b0.multiply(iArr4, iArr3, iArr7);
        g.a.g.c.g.copy(iArr6, iArr4);
        b0.multiply(iArr5, iArr2, iArr5);
        b0.add(iArr5, iArr7, iArr5);
        b0.square(iArr5, iArr6);
        b0.multiply(iArr6, iArr, iArr6);
    }

    public static void b(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        g.a.g.c.g.copy(iArr, iArr4);
        int[] iArrCreate = g.a.g.c.g.create();
        int[] iArrCreate2 = g.a.g.c.g.create();
        for (int i2 = 0; i2 < 7; i2++) {
            g.a.g.c.g.copy(iArr2, iArrCreate);
            g.a.g.c.g.copy(iArr3, iArrCreate2);
            int i3 = 1 << i2;
            while (true) {
                i3--;
                if (i3 >= 0) {
                    c(iArr2, iArr3, iArr4, iArr5);
                }
            }
            a(iArr, iArrCreate, iArrCreate2, iArr2, iArr3, iArr4, iArr5);
        }
    }

    public static void c(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        b0.multiply(iArr2, iArr, iArr2);
        b0.twice(iArr2, iArr2);
        b0.square(iArr, iArr4);
        b0.add(iArr3, iArr4, iArr);
        b0.multiply(iArr3, iArr4, iArr3);
        b0.reduce32(g.a.g.c.n.shiftUpBits(7, iArr3, 2, 0), iArr3);
    }

    public static boolean d(int[] iArr) {
        int[] iArrCreate = g.a.g.c.g.create();
        int[] iArrCreate2 = g.a.g.c.g.create();
        g.a.g.c.g.copy(iArr, iArrCreate);
        for (int i2 = 0; i2 < 7; i2++) {
            g.a.g.c.g.copy(iArrCreate, iArrCreate2);
            b0.squareN(iArrCreate, 1 << i2, iArrCreate);
            b0.multiply(iArrCreate, iArrCreate2, iArrCreate);
        }
        b0.squareN(iArrCreate, 95, iArrCreate);
        return g.a.g.c.g.isOne(iArrCreate);
    }

    public static boolean e(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreate = g.a.g.c.g.create();
        g.a.g.c.g.copy(iArr2, iArrCreate);
        int[] iArrCreate2 = g.a.g.c.g.create();
        iArrCreate2[0] = 1;
        int[] iArrCreate3 = g.a.g.c.g.create();
        b(iArr, iArrCreate, iArrCreate2, iArrCreate3, iArr3);
        int[] iArrCreate4 = g.a.g.c.g.create();
        int[] iArrCreate5 = g.a.g.c.g.create();
        for (int i2 = 1; i2 < 96; i2++) {
            g.a.g.c.g.copy(iArrCreate, iArrCreate4);
            g.a.g.c.g.copy(iArrCreate2, iArrCreate5);
            c(iArrCreate, iArrCreate2, iArrCreate3, iArr3);
            if (g.a.g.c.g.isZero(iArrCreate)) {
                b0.inv(iArrCreate5, iArr3);
                b0.multiply(iArr3, iArrCreate4, iArr3);
                return true;
            }
        }
        return false;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f add(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.g.create();
        b0.add(this.f13926h, ((c0) fVar).f13926h, iArrCreate);
        return new c0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f addOne() {
        int[] iArrCreate = g.a.g.c.g.create();
        b0.addOne(this.f13926h, iArrCreate);
        return new c0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f divide(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.g.create();
        b0.inv(((c0) fVar).f13926h, iArrCreate);
        b0.multiply(iArrCreate, this.f13926h, iArrCreate);
        return new c0(iArrCreate);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c0) {
            return g.a.g.c.g.eq(this.f13926h, ((c0) obj).f13926h);
        }
        return false;
    }

    @Override // g.a.g.a.f
    public String getFieldName() {
        return "SecP224R1Field";
    }

    @Override // g.a.g.a.f
    public int getFieldSize() {
        return f13925g.bitLength();
    }

    public int hashCode() {
        return f13925g.hashCode() ^ g.a.j.a.hashCode(this.f13926h, 0, 7);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f invert() {
        int[] iArrCreate = g.a.g.c.g.create();
        b0.inv(this.f13926h, iArrCreate);
        return new c0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean isOne() {
        return g.a.g.c.g.isOne(this.f13926h);
    }

    @Override // g.a.g.a.f
    public boolean isZero() {
        return g.a.g.c.g.isZero(this.f13926h);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f multiply(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.g.create();
        b0.multiply(this.f13926h, ((c0) fVar).f13926h, iArrCreate);
        return new c0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f negate() {
        int[] iArrCreate = g.a.g.c.g.create();
        b0.negate(this.f13926h, iArrCreate);
        return new c0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f sqrt() {
        int[] iArr = this.f13926h;
        if (g.a.g.c.g.isZero(iArr) || g.a.g.c.g.isOne(iArr)) {
            return this;
        }
        int[] iArrCreate = g.a.g.c.g.create();
        b0.negate(iArr, iArrCreate);
        int[] iArrRandom = g.a.g.c.c.random(b0.f13918a);
        int[] iArrCreate2 = g.a.g.c.g.create();
        if (!d(iArr)) {
            return null;
        }
        while (!e(iArrCreate, iArrRandom, iArrCreate2)) {
            b0.addOne(iArrRandom, iArrRandom);
        }
        b0.square(iArrCreate2, iArrRandom);
        if (g.a.g.c.g.eq(iArr, iArrRandom)) {
            return new c0(iArrCreate2);
        }
        return null;
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f square() {
        int[] iArrCreate = g.a.g.c.g.create();
        b0.square(this.f13926h, iArrCreate);
        return new c0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public g.a.g.a.f subtract(g.a.g.a.f fVar) {
        int[] iArrCreate = g.a.g.c.g.create();
        b0.subtract(this.f13926h, ((c0) fVar).f13926h, iArrCreate);
        return new c0(iArrCreate);
    }

    @Override // g.a.g.a.f
    public boolean testBitZero() {
        return g.a.g.c.g.getBit(this.f13926h, 0) == 1;
    }

    @Override // g.a.g.a.f
    public BigInteger toBigInteger() {
        return g.a.g.c.g.toBigInteger(this.f13926h);
    }
}
