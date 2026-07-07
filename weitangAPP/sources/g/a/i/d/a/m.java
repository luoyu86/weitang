package g.a.i.d.a;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f14640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f14642c;

    public m(e eVar) {
        this.f14640a = eVar;
        this.f14641b = -1;
        this.f14642c = new int[1];
    }

    public m(e eVar, int i2) {
        this.f14640a = eVar;
        this.f14641b = i2;
        int[] iArr = new int[i2 + 1];
        this.f14642c = iArr;
        iArr[i2] = 1;
    }

    public m(e eVar, int i2, char c2, SecureRandom secureRandom) {
        this.f14640a = eVar;
        if (c2 == 'I') {
            this.f14642c = d(i2, secureRandom);
            c();
        } else {
            throw new IllegalArgumentException(" Error: type " + c2 + " is not defined for GF2smallmPolynomial");
        }
    }

    public m(e eVar, byte[] bArr) {
        this.f14640a = eVar;
        int i2 = 8;
        int i3 = 1;
        while (eVar.getDegree() > i2) {
            i3++;
            i2 += 8;
        }
        if (bArr.length % i3 != 0) {
            throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
        }
        this.f14642c = new int[bArr.length / i3];
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr = this.f14642c;
            if (i4 >= iArr.length) {
                if (iArr.length != 1 && iArr[iArr.length - 1] == 0) {
                    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                }
                c();
                return;
            }
            int i6 = 0;
            while (i6 < i2) {
                int[] iArr2 = this.f14642c;
                iArr2[i4] = ((bArr[i5] & 255) << i6) ^ iArr2[i4];
                i6 += 8;
                i5++;
            }
            if (!this.f14640a.isElementOfThisField(this.f14642c[i4])) {
                throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
            }
            i4++;
        }
    }

    public m(e eVar, int[] iArr) {
        this.f14640a = eVar;
        this.f14642c = p(iArr);
        c();
    }

    public m(f fVar) {
        this(fVar.getField(), fVar.getIntArrayForm());
    }

    public m(m mVar) {
        this.f14640a = mVar.f14640a;
        this.f14641b = mVar.f14641b;
        this.f14642c = h.clone(mVar.f14642c);
    }

    public static int b(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    public static int g(int[] iArr) {
        int iB = b(iArr);
        if (iB == -1) {
            return 0;
        }
        return iArr[iB];
    }

    public static boolean h(int[] iArr, int[] iArr2) {
        int iB = b(iArr);
        if (iB != b(iArr2)) {
            return false;
        }
        for (int i2 = 0; i2 <= iB; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static int[] n(int[] iArr, int i2) {
        int iB = b(iArr);
        if (iB == -1) {
            return new int[1];
        }
        int[] iArr2 = new int[iB + i2 + 1];
        System.arraycopy(iArr, 0, iArr2, i2, iB + 1);
        return iArr2;
    }

    public static int[] p(int[] iArr) {
        int iB = b(iArr);
        if (iB == -1) {
            return new int[1];
        }
        int i2 = iB + 1;
        if (iArr.length == i2) {
            return h.clone(iArr);
        }
        int[] iArr2 = new int[i2];
        System.arraycopy(iArr, 0, iArr2, 0, i2);
        return iArr2;
    }

    public final int[] a(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr3[length] = this.f14640a.add(iArr3[length], iArr[length]);
        }
        return iArr3;
    }

    public m add(m mVar) {
        return new m(this.f14640a, a(this.f14642c, mVar.f14642c));
    }

    public m addMonomial(int i2) {
        int[] iArr = new int[i2 + 1];
        iArr[i2] = 1;
        return new m(this.f14640a, a(this.f14642c, iArr));
    }

    public void addToThis(m mVar) {
        this.f14642c = a(this.f14642c, mVar.f14642c);
        c();
    }

    public final void c() {
        int length = this.f14642c.length;
        do {
            this.f14641b = length - 1;
            length = this.f14641b;
            if (length < 0) {
                return;
            }
        } while (this.f14642c[length] == 0);
    }

    public final int[] d(int i2, SecureRandom secureRandom) {
        int[] iArr = new int[i2 + 1];
        iArr[i2] = 1;
        iArr[0] = this.f14640a.getRandomNonZeroElement(secureRandom);
        for (int i3 = 1; i3 < i2; i3++) {
            iArr[i3] = this.f14640a.getRandomElement(secureRandom);
        }
        while (!i(iArr)) {
            int iA = p.a(secureRandom, i2);
            if (iA == 0) {
                iArr[0] = this.f14640a.getRandomNonZeroElement(secureRandom);
            } else {
                iArr[iA] = this.f14640a.getRandomElement(secureRandom);
            }
        }
        return iArr;
    }

    public m[] div(m mVar) {
        int[][] iArrE = e(this.f14642c, mVar.f14642c);
        return new m[]{new m(this.f14640a, iArrE[0]), new m(this.f14640a, iArrE[1])};
    }

    public final int[][] e(int[] iArr, int[] iArr2) {
        int iB = b(iArr2);
        int iB2 = b(iArr) + 1;
        if (iB == -1) {
            throw new ArithmeticException("Division by zero.");
        }
        int[][] iArr3 = {new int[1], new int[iB2]};
        int iInverse = this.f14640a.inverse(g(iArr2));
        iArr3[0][0] = 0;
        System.arraycopy(iArr, 0, iArr3[1], 0, iArr3[1].length);
        while (iB <= b(iArr3[1])) {
            int[] iArr4 = {this.f14640a.mult(g(iArr3[1]), iInverse)};
            int[] iArrM = m(iArr2, iArr4[0]);
            int iB3 = b(iArr3[1]) - iB;
            int[] iArrN = n(iArrM, iB3);
            iArr3[0] = a(n(iArr4, iB3), iArr3[0]);
            iArr3[1] = a(iArrN, iArr3[1]);
        }
        return iArr3;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof m)) {
            m mVar = (m) obj;
            if (this.f14640a.equals(mVar.f14640a) && this.f14641b == mVar.f14641b && h(this.f14642c, mVar.f14642c)) {
                return true;
            }
        }
        return false;
    }

    public int evaluateAt(int i2) {
        int[] iArr = this.f14642c;
        int i3 = this.f14641b;
        int iMult = iArr[i3];
        for (int i4 = i3 - 1; i4 >= 0; i4--) {
            iMult = this.f14640a.mult(iMult, i2) ^ this.f14642c[i4];
        }
        return iMult;
    }

    public final int[] f(int[] iArr, int[] iArr2) {
        if (b(iArr) == -1) {
            return iArr2;
        }
        while (b(iArr2) != -1) {
            int[] iArrJ = j(iArr, iArr2);
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            int length2 = iArrJ.length;
            int[] iArr4 = new int[length2];
            System.arraycopy(iArrJ, 0, iArr4, 0, length2);
            iArr2 = iArr4;
            iArr = iArr3;
        }
        return m(iArr, this.f14640a.inverse(g(iArr)));
    }

    public m gcd(m mVar) {
        return new m(this.f14640a, f(this.f14642c, mVar.f14642c));
    }

    public int getCoefficient(int i2) {
        if (i2 < 0 || i2 > this.f14641b) {
            return 0;
        }
        return this.f14642c[i2];
    }

    public int getDegree() {
        int[] iArr = this.f14642c;
        int length = iArr.length - 1;
        if (iArr[length] == 0) {
            return -1;
        }
        return length;
    }

    public byte[] getEncoded() {
        int i2 = 8;
        int i3 = 1;
        while (this.f14640a.getDegree() > i2) {
            i3++;
            i2 += 8;
        }
        byte[] bArr = new byte[this.f14642c.length * i3];
        int i4 = 0;
        for (int i5 = 0; i5 < this.f14642c.length; i5++) {
            int i6 = 0;
            while (i6 < i2) {
                bArr[i4] = (byte) (this.f14642c[i5] >>> i6);
                i6 += 8;
                i4++;
            }
        }
        return bArr;
    }

    public int getHeadCoefficient() {
        int i2 = this.f14641b;
        if (i2 == -1) {
            return 0;
        }
        return this.f14642c[i2];
    }

    public int hashCode() {
        int iHashCode = this.f14640a.hashCode();
        int i2 = 0;
        while (true) {
            int[] iArr = this.f14642c;
            if (i2 >= iArr.length) {
                return iHashCode;
            }
            iHashCode = (iHashCode * 31) + iArr[i2];
            i2++;
        }
    }

    public final boolean i(int[] iArr) {
        if (iArr[0] == 0) {
            return false;
        }
        int iB = b(iArr) >> 1;
        int[] iArrP = {0, 1};
        int[] iArr2 = {0, 1};
        int degree = this.f14640a.getDegree();
        for (int i2 = 0; i2 < iB; i2++) {
            for (int i3 = degree - 1; i3 >= 0; i3--) {
                iArrP = l(iArrP, iArrP, iArr);
            }
            iArrP = p(iArrP);
            if (b(f(a(iArrP, iArr2), iArr)) != 0) {
                return false;
            }
        }
        return true;
    }

    public final int[] j(int[] iArr, int[] iArr2) {
        int iB = b(iArr2);
        if (iB == -1) {
            throw new ArithmeticException("Division by zero");
        }
        int length = iArr.length;
        int[] iArrA = new int[length];
        int iInverse = this.f14640a.inverse(g(iArr2));
        System.arraycopy(iArr, 0, iArrA, 0, length);
        while (iB <= b(iArrA)) {
            iArrA = a(m(n(iArr2, b(iArrA) - iB), this.f14640a.mult(g(iArrA), iInverse)), iArrA);
        }
        return iArrA;
    }

    public final int[] k(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrP = p(iArr3);
        int[] iArrJ = j(iArr2, iArr3);
        int[] iArrP2 = {0};
        int[] iArrJ2 = j(iArr, iArr3);
        while (b(iArrJ) != -1) {
            int[][] iArrE = e(iArrP, iArrJ);
            int[] iArrP3 = p(iArrJ);
            int[] iArrP4 = p(iArrE[1]);
            int[] iArrA = a(iArrP2, l(iArrE[0], iArrJ2, iArr3));
            iArrP2 = p(iArrJ2);
            iArrJ2 = p(iArrA);
            iArrP = iArrP3;
            iArrJ = iArrP4;
        }
        return m(iArrP2, this.f14640a.inverse(g(iArrP)));
    }

    public final int[] l(int[] iArr, int[] iArr2, int[] iArr3) {
        return j(o(iArr, iArr2), iArr3);
    }

    public final int[] m(int[] iArr, int i2) {
        int iB = b(iArr);
        if (iB == -1 || i2 == 0) {
            return new int[1];
        }
        if (i2 == 1) {
            return h.clone(iArr);
        }
        int[] iArr2 = new int[iB + 1];
        while (iB >= 0) {
            iArr2[iB] = this.f14640a.mult(iArr[iB], i2);
            iB--;
        }
        return iArr2;
    }

    public m mod(m mVar) {
        return new m(this.f14640a, j(this.f14642c, mVar.f14642c));
    }

    public m modDiv(m mVar, m mVar2) {
        return new m(this.f14640a, k(this.f14642c, mVar.f14642c, mVar2.f14642c));
    }

    public m modInverse(m mVar) {
        return new m(this.f14640a, k(new int[]{1}, this.f14642c, mVar.f14642c));
    }

    public m modMultiply(m mVar, m mVar2) {
        return new m(this.f14640a, l(this.f14642c, mVar.f14642c, mVar2.f14642c));
    }

    public m[] modPolynomialToFracton(m mVar) {
        int i2 = mVar.f14641b >> 1;
        int[] iArrP = p(mVar.f14642c);
        int[] iArrJ = j(this.f14642c, mVar.f14642c);
        int[] iArr = {0};
        int[] iArr2 = {1};
        while (b(iArrJ) > i2) {
            int[][] iArrE = e(iArrP, iArrJ);
            int[] iArr3 = iArrE[1];
            int[] iArrA = a(iArr, l(iArrE[0], iArr2, mVar.f14642c));
            iArr = iArr2;
            iArr2 = iArrA;
            iArrP = iArrJ;
            iArrJ = iArr3;
        }
        return new m[]{new m(this.f14640a, iArrJ), new m(this.f14640a, iArr2)};
    }

    public m modSquareMatrix(m[] mVarArr) {
        int length = mVarArr.length;
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        int i2 = 0;
        while (true) {
            int[] iArr3 = this.f14642c;
            if (i2 >= iArr3.length) {
                break;
            }
            iArr2[i2] = this.f14640a.mult(iArr3[i2], iArr3[i2]);
            i2++;
        }
        for (int i3 = 0; i3 < length; i3++) {
            for (int i4 = 0; i4 < length; i4++) {
                if (i3 < mVarArr[i4].f14642c.length) {
                    iArr[i3] = this.f14640a.add(iArr[i3], this.f14640a.mult(mVarArr[i4].f14642c[i3], iArr2[i4]));
                }
            }
        }
        return new m(this.f14640a, iArr);
    }

    public m modSquareRoot(m mVar) {
        int[] iArrClone = h.clone(this.f14642c);
        int[] iArrL = l(iArrClone, iArrClone, mVar.f14642c);
        while (!h(iArrL, this.f14642c)) {
            iArrClone = p(iArrL);
            iArrL = l(iArrClone, iArrClone, mVar.f14642c);
        }
        return new m(this.f14640a, iArrClone);
    }

    public m modSquareRootMatrix(m[] mVarArr) {
        int length = mVarArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                if (i2 < mVarArr[i3].f14642c.length) {
                    int[] iArr2 = this.f14642c;
                    if (i3 < iArr2.length) {
                        iArr[i2] = this.f14640a.add(iArr[i2], this.f14640a.mult(mVarArr[i3].f14642c[i2], iArr2[i3]));
                    }
                }
            }
        }
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = this.f14640a.sqRoot(iArr[i4]);
        }
        return new m(this.f14640a, iArr);
    }

    public void multThisWithElement(int i2) {
        if (!this.f14640a.isElementOfThisField(i2)) {
            throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
        }
        this.f14642c = m(this.f14642c, i2);
        c();
    }

    public m multWithElement(int i2) {
        if (!this.f14640a.isElementOfThisField(i2)) {
            throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
        }
        return new m(this.f14640a, m(this.f14642c, i2));
    }

    public m multWithMonomial(int i2) {
        return new m(this.f14640a, n(this.f14642c, i2));
    }

    public m multiply(m mVar) {
        return new m(this.f14640a, o(this.f14642c, mVar.f14642c));
    }

    public final int[] o(int[] iArr, int[] iArr2) {
        if (b(iArr) < b(iArr2)) {
            iArr2 = iArr;
            iArr = iArr2;
        }
        int[] iArrP = p(iArr);
        int[] iArrP2 = p(iArr2);
        if (iArrP2.length == 1) {
            return m(iArrP, iArrP2[0]);
        }
        int length = iArrP.length;
        int length2 = iArrP2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        if (length2 != length) {
            int[] iArr4 = new int[length2];
            int i2 = length - length2;
            int[] iArr5 = new int[i2];
            System.arraycopy(iArrP, 0, iArr4, 0, length2);
            System.arraycopy(iArrP, length2, iArr5, 0, i2);
            return a(o(iArr4, iArrP2), n(o(iArr5, iArrP2), length2));
        }
        int i3 = (length + 1) >>> 1;
        int i4 = length - i3;
        int[] iArr6 = new int[i3];
        int[] iArr7 = new int[i3];
        int[] iArr8 = new int[i4];
        int[] iArr9 = new int[i4];
        System.arraycopy(iArrP, 0, iArr6, 0, i3);
        System.arraycopy(iArrP, i3, iArr8, 0, i4);
        System.arraycopy(iArrP2, 0, iArr7, 0, i3);
        System.arraycopy(iArrP2, i3, iArr9, 0, i4);
        int[] iArrA = a(iArr6, iArr8);
        int[] iArrA2 = a(iArr7, iArr9);
        int[] iArrO = o(iArr6, iArr7);
        int[] iArrO2 = o(iArrA, iArrA2);
        int[] iArrO3 = o(iArr8, iArr9);
        return a(n(a(a(a(iArrO2, iArrO), iArrO3), n(iArrO3, i3)), i3), iArrO);
    }

    public String toString() {
        String str = " Polynomial over " + this.f14640a.toString() + ": \n";
        for (int i2 = 0; i2 < this.f14642c.length; i2++) {
            str = str + this.f14640a.elementToStr(this.f14642c[i2]) + "Y^" + i2 + "+";
        }
        return str + com.alipay.sdk.m.u.i.f5697b;
    }
}
