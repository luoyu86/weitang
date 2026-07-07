package g.a.g.a;

import java.math.BigInteger;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f implements g.a.g.a.d {

    public static abstract class a extends f {
        public f halfTrace() {
            int fieldSize = getFieldSize();
            if ((fieldSize & 1) == 0) {
                throw new IllegalStateException("Half-trace only defined for odd m");
            }
            int i2 = (fieldSize + 1) >>> 1;
            int iNumberOfLeadingZeros = 31 - g.a.j.g.numberOfLeadingZeros(i2);
            int i3 = 1;
            f fVarAdd = this;
            while (iNumberOfLeadingZeros > 0) {
                fVarAdd = fVarAdd.squarePow(i3 << 1).add(fVarAdd);
                iNumberOfLeadingZeros--;
                i3 = i2 >>> iNumberOfLeadingZeros;
                if ((i3 & 1) != 0) {
                    fVarAdd = fVarAdd.squarePow(2).add(this);
                }
            }
            return fVarAdd;
        }

        public boolean hasFastTrace() {
            return false;
        }

        public int trace() {
            int fieldSize = getFieldSize();
            int iNumberOfLeadingZeros = 31 - g.a.j.g.numberOfLeadingZeros(fieldSize);
            int i2 = 1;
            f fVarAdd = this;
            while (iNumberOfLeadingZeros > 0) {
                fVarAdd = fVarAdd.squarePow(i2).add(fVarAdd);
                iNumberOfLeadingZeros--;
                i2 = fieldSize >>> iNumberOfLeadingZeros;
                if ((i2 & 1) != 0) {
                    fVarAdd = fVarAdd.square().add(this);
                }
            }
            if (fVarAdd.isZero()) {
                return 0;
            }
            if (fVarAdd.isOne()) {
                return 1;
            }
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    public static abstract class b extends f {
    }

    public static class c extends a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f14119g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f14120h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int[] f14121i;
        public o j;

        public c(int i2, int i3, int i4, int i5, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i2) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i4 == 0 && i5 == 0) {
                this.f14119g = 2;
                this.f14121i = new int[]{i3};
            } else {
                if (i4 >= i5) {
                    throw new IllegalArgumentException("k2 must be smaller than k3");
                }
                if (i4 <= 0) {
                    throw new IllegalArgumentException("k2 must be larger than 0");
                }
                this.f14119g = 3;
                this.f14121i = new int[]{i3, i4, i5};
            }
            this.f14120h = i2;
            this.j = new o(bigInteger);
        }

        public c(int i2, int[] iArr, o oVar) {
            this.f14120h = i2;
            this.f14119g = iArr.length == 1 ? 2 : 3;
            this.f14121i = iArr;
            this.j = oVar;
        }

        @Override // g.a.g.a.f
        public f add(f fVar) {
            o oVar = (o) this.j.clone();
            oVar.addShiftedByWords(((c) fVar).j, 0);
            return new c(this.f14120h, this.f14121i, oVar);
        }

        @Override // g.a.g.a.f
        public f addOne() {
            return new c(this.f14120h, this.f14121i, this.j.addOne());
        }

        @Override // g.a.g.a.f
        public int bitLength() {
            return this.j.degree();
        }

        @Override // g.a.g.a.f
        public f divide(f fVar) {
            return multiply(fVar.invert());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f14120h == cVar.f14120h && this.f14119g == cVar.f14119g && g.a.j.a.areEqual(this.f14121i, cVar.f14121i) && this.j.equals(cVar.j);
        }

        @Override // g.a.g.a.f
        public String getFieldName() {
            return "F2m";
        }

        @Override // g.a.g.a.f
        public int getFieldSize() {
            return this.f14120h;
        }

        public int getK1() {
            return this.f14121i[0];
        }

        public int getK2() {
            int[] iArr = this.f14121i;
            if (iArr.length >= 2) {
                return iArr[1];
            }
            return 0;
        }

        public int getK3() {
            int[] iArr = this.f14121i;
            if (iArr.length >= 3) {
                return iArr[2];
            }
            return 0;
        }

        public int getM() {
            return this.f14120h;
        }

        public int getRepresentation() {
            return this.f14119g;
        }

        public int hashCode() {
            return (this.j.hashCode() ^ this.f14120h) ^ g.a.j.a.hashCode(this.f14121i);
        }

        @Override // g.a.g.a.f
        public f invert() {
            int i2 = this.f14120h;
            int[] iArr = this.f14121i;
            return new c(i2, iArr, this.j.modInverse(i2, iArr));
        }

        @Override // g.a.g.a.f
        public boolean isOne() {
            return this.j.isOne();
        }

        @Override // g.a.g.a.f
        public boolean isZero() {
            return this.j.isZero();
        }

        @Override // g.a.g.a.f
        public f multiply(f fVar) {
            int i2 = this.f14120h;
            int[] iArr = this.f14121i;
            return new c(i2, iArr, this.j.modMultiply(((c) fVar).j, i2, iArr));
        }

        @Override // g.a.g.a.f
        public f multiplyMinusProduct(f fVar, f fVar2, f fVar3) {
            return multiplyPlusProduct(fVar, fVar2, fVar3);
        }

        @Override // g.a.g.a.f
        public f multiplyPlusProduct(f fVar, f fVar2, f fVar3) {
            o oVar = this.j;
            o oVar2 = ((c) fVar).j;
            o oVar3 = ((c) fVar2).j;
            o oVar4 = ((c) fVar3).j;
            o oVarMultiply = oVar.multiply(oVar2, this.f14120h, this.f14121i);
            o oVarMultiply2 = oVar3.multiply(oVar4, this.f14120h, this.f14121i);
            if (oVarMultiply == oVar || oVarMultiply == oVar2) {
                oVarMultiply = (o) oVarMultiply.clone();
            }
            oVarMultiply.addShiftedByWords(oVarMultiply2, 0);
            oVarMultiply.reduce(this.f14120h, this.f14121i);
            return new c(this.f14120h, this.f14121i, oVarMultiply);
        }

        @Override // g.a.g.a.f
        public f negate() {
            return this;
        }

        @Override // g.a.g.a.f
        public f sqrt() {
            return (this.j.isZero() || this.j.isOne()) ? this : squarePow(this.f14120h - 1);
        }

        @Override // g.a.g.a.f
        public f square() {
            int i2 = this.f14120h;
            int[] iArr = this.f14121i;
            return new c(i2, iArr, this.j.modSquare(i2, iArr));
        }

        @Override // g.a.g.a.f
        public f squareMinusProduct(f fVar, f fVar2) {
            return squarePlusProduct(fVar, fVar2);
        }

        @Override // g.a.g.a.f
        public f squarePlusProduct(f fVar, f fVar2) {
            o oVar = this.j;
            o oVar2 = ((c) fVar).j;
            o oVar3 = ((c) fVar2).j;
            o oVarSquare = oVar.square(this.f14120h, this.f14121i);
            o oVarMultiply = oVar2.multiply(oVar3, this.f14120h, this.f14121i);
            if (oVarSquare == oVar) {
                oVarSquare = (o) oVarSquare.clone();
            }
            oVarSquare.addShiftedByWords(oVarMultiply, 0);
            oVarSquare.reduce(this.f14120h, this.f14121i);
            return new c(this.f14120h, this.f14121i, oVarSquare);
        }

        @Override // g.a.g.a.f
        public f squarePow(int i2) {
            if (i2 < 1) {
                return this;
            }
            int i3 = this.f14120h;
            int[] iArr = this.f14121i;
            return new c(i3, iArr, this.j.modSquareN(i2, i3, iArr));
        }

        @Override // g.a.g.a.f
        public f subtract(f fVar) {
            return add(fVar);
        }

        @Override // g.a.g.a.f
        public boolean testBitZero() {
            return this.j.testBitZero();
        }

        @Override // g.a.g.a.f
        public BigInteger toBigInteger() {
            return this.j.toBigInteger();
        }
    }

    public static class d extends b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public BigInteger f14122g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public BigInteger f14123h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public BigInteger f14124i;

        public d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.f14122g = bigInteger;
            this.f14123h = bigInteger2;
            this.f14124i = bigInteger3;
        }

        public static BigInteger a(BigInteger bigInteger) {
            int iBitLength = bigInteger.bitLength();
            if (iBitLength < 96 || bigInteger.shiftRight(iBitLength - 64).longValue() != -1) {
                return null;
            }
            return g.a.g.a.d.f14091b.shiftLeft(iBitLength).subtract(bigInteger);
        }

        @Override // g.a.g.a.f
        public f add(f fVar) {
            return new d(this.f14122g, this.f14123h, d(this.f14124i, fVar.toBigInteger()));
        }

        @Override // g.a.g.a.f
        public f addOne() {
            BigInteger bigIntegerAdd = this.f14124i.add(g.a.g.a.d.f14091b);
            if (bigIntegerAdd.compareTo(this.f14122g) == 0) {
                bigIntegerAdd = g.a.g.a.d.f14090a;
            }
            return new d(this.f14122g, this.f14123h, bigIntegerAdd);
        }

        public final f b(f fVar) {
            if (fVar.square().equals(this)) {
                return fVar;
            }
            return null;
        }

        public final BigInteger[] c(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int iBitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigIntegerH = g.a.g.a.d.f14091b;
            BigInteger bigIntegerI = bigInteger;
            BigInteger bigIntegerH2 = bigIntegerH;
            BigInteger bigIntegerI2 = g.a.g.a.d.f14092c;
            BigInteger bigIntegerH3 = bigIntegerH2;
            for (int i2 = iBitLength - 1; i2 >= lowestSetBit + 1; i2--) {
                bigIntegerH = h(bigIntegerH, bigIntegerH3);
                if (bigInteger3.testBit(i2)) {
                    bigIntegerH3 = h(bigIntegerH, bigInteger2);
                    bigIntegerH2 = h(bigIntegerH2, bigIntegerI);
                    bigIntegerI2 = i(bigIntegerI.multiply(bigIntegerI2).subtract(bigInteger.multiply(bigIntegerH)));
                    bigIntegerI = i(bigIntegerI.multiply(bigIntegerI).subtract(bigIntegerH3.shiftLeft(1)));
                } else {
                    BigInteger bigIntegerI3 = i(bigIntegerH2.multiply(bigIntegerI2).subtract(bigIntegerH));
                    BigInteger bigIntegerI4 = i(bigIntegerI.multiply(bigIntegerI2).subtract(bigInteger.multiply(bigIntegerH)));
                    bigIntegerI2 = i(bigIntegerI2.multiply(bigIntegerI2).subtract(bigIntegerH.shiftLeft(1)));
                    bigIntegerI = bigIntegerI4;
                    bigIntegerH2 = bigIntegerI3;
                    bigIntegerH3 = bigIntegerH;
                }
            }
            BigInteger bigIntegerH4 = h(bigIntegerH, bigIntegerH3);
            BigInteger bigIntegerH5 = h(bigIntegerH4, bigInteger2);
            BigInteger bigIntegerI5 = i(bigIntegerH2.multiply(bigIntegerI2).subtract(bigIntegerH4));
            BigInteger bigIntegerI6 = i(bigIntegerI.multiply(bigIntegerI2).subtract(bigInteger.multiply(bigIntegerH4)));
            BigInteger bigIntegerH6 = h(bigIntegerH4, bigIntegerH5);
            for (int i3 = 1; i3 <= lowestSetBit; i3++) {
                bigIntegerI5 = h(bigIntegerI5, bigIntegerI6);
                bigIntegerI6 = i(bigIntegerI6.multiply(bigIntegerI6).subtract(bigIntegerH6.shiftLeft(1)));
                bigIntegerH6 = h(bigIntegerH6, bigIntegerH6);
            }
            return new BigInteger[]{bigIntegerI5, bigIntegerI6};
        }

        public BigInteger d(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger bigIntegerAdd = bigInteger.add(bigInteger2);
            return bigIntegerAdd.compareTo(this.f14122g) >= 0 ? bigIntegerAdd.subtract(this.f14122g) : bigIntegerAdd;
        }

        @Override // g.a.g.a.f
        public f divide(f fVar) {
            return new d(this.f14122g, this.f14123h, h(this.f14124i, g(fVar.toBigInteger())));
        }

        public BigInteger e(BigInteger bigInteger) {
            BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(1);
            return bigIntegerShiftLeft.compareTo(this.f14122g) >= 0 ? bigIntegerShiftLeft.subtract(this.f14122g) : bigIntegerShiftLeft;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f14122g.equals(dVar.f14122g) && this.f14124i.equals(dVar.f14124i);
        }

        public BigInteger f(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f14122g.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        public BigInteger g(BigInteger bigInteger) {
            return g.a.j.b.modOddInverse(this.f14122g, bigInteger);
        }

        @Override // g.a.g.a.f
        public String getFieldName() {
            return "Fp";
        }

        @Override // g.a.g.a.f
        public int getFieldSize() {
            return this.f14122g.bitLength();
        }

        public BigInteger getQ() {
            return this.f14122g;
        }

        public BigInteger h(BigInteger bigInteger, BigInteger bigInteger2) {
            return i(bigInteger.multiply(bigInteger2));
        }

        public int hashCode() {
            return this.f14122g.hashCode() ^ this.f14124i.hashCode();
        }

        public BigInteger i(BigInteger bigInteger) {
            if (this.f14123h == null) {
                return bigInteger.mod(this.f14122g);
            }
            boolean z = bigInteger.signum() < 0;
            if (z) {
                bigInteger = bigInteger.abs();
            }
            int iBitLength = this.f14122g.bitLength();
            boolean zEquals = this.f14123h.equals(g.a.g.a.d.f14091b);
            while (bigInteger.bitLength() > iBitLength + 1) {
                BigInteger bigIntegerShiftRight = bigInteger.shiftRight(iBitLength);
                BigInteger bigIntegerSubtract = bigInteger.subtract(bigIntegerShiftRight.shiftLeft(iBitLength));
                if (!zEquals) {
                    bigIntegerShiftRight = bigIntegerShiftRight.multiply(this.f14123h);
                }
                bigInteger = bigIntegerShiftRight.add(bigIntegerSubtract);
            }
            while (bigInteger.compareTo(this.f14122g) >= 0) {
                bigInteger = bigInteger.subtract(this.f14122g);
            }
            return (!z || bigInteger.signum() == 0) ? bigInteger : this.f14122g.subtract(bigInteger);
        }

        @Override // g.a.g.a.f
        public f invert() {
            return new d(this.f14122g, this.f14123h, g(this.f14124i));
        }

        public BigInteger j(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger bigIntegerSubtract = bigInteger.subtract(bigInteger2);
            return bigIntegerSubtract.signum() < 0 ? bigIntegerSubtract.add(this.f14122g) : bigIntegerSubtract;
        }

        @Override // g.a.g.a.f
        public f multiply(f fVar) {
            return new d(this.f14122g, this.f14123h, h(this.f14124i, fVar.toBigInteger()));
        }

        @Override // g.a.g.a.f
        public f multiplyMinusProduct(f fVar, f fVar2, f fVar3) {
            BigInteger bigInteger = this.f14124i;
            BigInteger bigInteger2 = fVar.toBigInteger();
            BigInteger bigInteger3 = fVar2.toBigInteger();
            BigInteger bigInteger4 = fVar3.toBigInteger();
            return new d(this.f14122g, this.f14123h, i(bigInteger.multiply(bigInteger2).subtract(bigInteger3.multiply(bigInteger4))));
        }

        @Override // g.a.g.a.f
        public f multiplyPlusProduct(f fVar, f fVar2, f fVar3) {
            BigInteger bigInteger = this.f14124i;
            BigInteger bigInteger2 = fVar.toBigInteger();
            BigInteger bigInteger3 = fVar2.toBigInteger();
            BigInteger bigInteger4 = fVar3.toBigInteger();
            return new d(this.f14122g, this.f14123h, i(bigInteger.multiply(bigInteger2).add(bigInteger3.multiply(bigInteger4))));
        }

        @Override // g.a.g.a.f
        public f negate() {
            if (this.f14124i.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.f14122g;
            return new d(bigInteger, this.f14123h, bigInteger.subtract(this.f14124i));
        }

        @Override // g.a.g.a.f
        public f sqrt() {
            if (isZero() || isOne()) {
                return this;
            }
            if (!this.f14122g.testBit(0)) {
                throw new RuntimeException("not done yet");
            }
            if (this.f14122g.testBit(1)) {
                BigInteger bigIntegerAdd = this.f14122g.shiftRight(2).add(g.a.g.a.d.f14091b);
                BigInteger bigInteger = this.f14122g;
                return b(new d(bigInteger, this.f14123h, this.f14124i.modPow(bigIntegerAdd, bigInteger)));
            }
            if (this.f14122g.testBit(2)) {
                BigInteger bigIntegerModPow = this.f14124i.modPow(this.f14122g.shiftRight(3), this.f14122g);
                BigInteger bigIntegerH = h(bigIntegerModPow, this.f14124i);
                if (h(bigIntegerH, bigIntegerModPow).equals(g.a.g.a.d.f14091b)) {
                    return b(new d(this.f14122g, this.f14123h, bigIntegerH));
                }
                return b(new d(this.f14122g, this.f14123h, h(bigIntegerH, g.a.g.a.d.f14092c.modPow(this.f14122g.shiftRight(2), this.f14122g))));
            }
            BigInteger bigIntegerShiftRight = this.f14122g.shiftRight(1);
            BigInteger bigIntegerModPow2 = this.f14124i.modPow(bigIntegerShiftRight, this.f14122g);
            BigInteger bigInteger2 = g.a.g.a.d.f14091b;
            if (!bigIntegerModPow2.equals(bigInteger2)) {
                return null;
            }
            BigInteger bigInteger3 = this.f14124i;
            BigInteger bigIntegerE = e(e(bigInteger3));
            BigInteger bigIntegerAdd2 = bigIntegerShiftRight.add(bigInteger2);
            BigInteger bigIntegerSubtract = this.f14122g.subtract(bigInteger2);
            Random random = new Random();
            while (true) {
                BigInteger bigInteger4 = new BigInteger(this.f14122g.bitLength(), random);
                if (bigInteger4.compareTo(this.f14122g) < 0 && i(bigInteger4.multiply(bigInteger4).subtract(bigIntegerE)).modPow(bigIntegerShiftRight, this.f14122g).equals(bigIntegerSubtract)) {
                    BigInteger[] bigIntegerArrC = c(bigInteger4, bigInteger3, bigIntegerAdd2);
                    BigInteger bigInteger5 = bigIntegerArrC[0];
                    BigInteger bigInteger6 = bigIntegerArrC[1];
                    if (h(bigInteger6, bigInteger6).equals(bigIntegerE)) {
                        return new d(this.f14122g, this.f14123h, f(bigInteger6));
                    }
                    if (!bigInteger5.equals(g.a.g.a.d.f14091b) && !bigInteger5.equals(bigIntegerSubtract)) {
                        return null;
                    }
                }
            }
        }

        @Override // g.a.g.a.f
        public f square() {
            BigInteger bigInteger = this.f14122g;
            BigInteger bigInteger2 = this.f14123h;
            BigInteger bigInteger3 = this.f14124i;
            return new d(bigInteger, bigInteger2, h(bigInteger3, bigInteger3));
        }

        @Override // g.a.g.a.f
        public f squareMinusProduct(f fVar, f fVar2) {
            BigInteger bigInteger = this.f14124i;
            BigInteger bigInteger2 = fVar.toBigInteger();
            BigInteger bigInteger3 = fVar2.toBigInteger();
            return new d(this.f14122g, this.f14123h, i(bigInteger.multiply(bigInteger).subtract(bigInteger2.multiply(bigInteger3))));
        }

        @Override // g.a.g.a.f
        public f squarePlusProduct(f fVar, f fVar2) {
            BigInteger bigInteger = this.f14124i;
            BigInteger bigInteger2 = fVar.toBigInteger();
            BigInteger bigInteger3 = fVar2.toBigInteger();
            return new d(this.f14122g, this.f14123h, i(bigInteger.multiply(bigInteger).add(bigInteger2.multiply(bigInteger3))));
        }

        @Override // g.a.g.a.f
        public f subtract(f fVar) {
            return new d(this.f14122g, this.f14123h, j(this.f14124i, fVar.toBigInteger()));
        }

        @Override // g.a.g.a.f
        public BigInteger toBigInteger() {
            return this.f14124i;
        }
    }

    public abstract f add(f fVar);

    public abstract f addOne();

    public int bitLength() {
        return toBigInteger().bitLength();
    }

    public abstract f divide(f fVar);

    public byte[] getEncoded() {
        return g.a.j.b.asUnsignedByteArray((getFieldSize() + 7) / 8, toBigInteger());
    }

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract f invert();

    public boolean isOne() {
        return bitLength() == 1;
    }

    public boolean isZero() {
        return toBigInteger().signum() == 0;
    }

    public abstract f multiply(f fVar);

    public f multiplyMinusProduct(f fVar, f fVar2, f fVar3) {
        return multiply(fVar).subtract(fVar2.multiply(fVar3));
    }

    public f multiplyPlusProduct(f fVar, f fVar2, f fVar3) {
        return multiply(fVar).add(fVar2.multiply(fVar3));
    }

    public abstract f negate();

    public abstract f sqrt();

    public abstract f square();

    public f squareMinusProduct(f fVar, f fVar2) {
        return square().subtract(fVar.multiply(fVar2));
    }

    public f squarePlusProduct(f fVar, f fVar2) {
        return square().add(fVar.multiply(fVar2));
    }

    public f squarePow(int i2) {
        f fVarSquare = this;
        for (int i3 = 0; i3 < i2; i3++) {
            fVarSquare = fVarSquare.square();
        }
        return fVarSquare;
    }

    public abstract f subtract(f fVar);

    public boolean testBitZero() {
        return toBigInteger().testBit(0);
    }

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(16);
    }
}
