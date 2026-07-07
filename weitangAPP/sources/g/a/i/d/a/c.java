package g.a.i.d.a;

import java.lang.reflect.Array;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class c extends k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[][] f14620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14621d;

    public c(int i2, char c2) {
        this(i2, c2, new SecureRandom());
    }

    public c(int i2, char c2, SecureRandom secureRandom) {
        if (i2 <= 0) {
            throw new ArithmeticException("Size of matrix is non-positive.");
        }
        if (c2 == 'I') {
            e(i2);
            return;
        }
        if (c2 == 'L') {
            b(i2, secureRandom);
            return;
        }
        if (c2 == 'R') {
            c(i2, secureRandom);
        } else if (c2 == 'U') {
            d(i2, secureRandom);
        } else {
            if (c2 != 'Z') {
                throw new ArithmeticException("Unknown matrix type.");
            }
            f(i2, i2);
        }
    }

    public c(int i2, int i3) {
        if (i3 <= 0 || i2 <= 0) {
            throw new ArithmeticException("size of matrix is non-positive");
        }
        f(i2, i3);
    }

    public c(int i2, int[][] iArr) {
        if (iArr[0].length != ((i2 + 31) >> 5)) {
            throw new ArithmeticException("Int array does not match given number of columns.");
        }
        this.f14638b = i2;
        this.f14637a = iArr.length;
        this.f14621d = iArr[0].length;
        int i3 = i2 & 31;
        int i4 = i3 == 0 ? -1 : (1 << i3) - 1;
        for (int i5 = 0; i5 < this.f14637a; i5++) {
            int[] iArr2 = iArr[i5];
            int i6 = this.f14621d - 1;
            iArr2[i6] = iArr2[i6] & i4;
        }
        this.f14620c = iArr;
    }

    public c(c cVar) {
        this.f14638b = cVar.getNumColumns();
        this.f14637a = cVar.getNumRows();
        this.f14621d = cVar.f14621d;
        this.f14620c = new int[cVar.f14620c.length][];
        int i2 = 0;
        while (true) {
            int[][] iArr = this.f14620c;
            if (i2 >= iArr.length) {
                return;
            }
            iArr[i2] = h.clone(cVar.f14620c[i2]);
            i2++;
        }
    }

    public c(byte[] bArr) {
        if (bArr.length < 9) {
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        this.f14637a = j.OS2IP(bArr, 0);
        int iOS2IP = j.OS2IP(bArr, 4);
        this.f14638b = iOS2IP;
        int i2 = this.f14637a;
        int i3 = ((iOS2IP + 7) >>> 3) * i2;
        if (i2 > 0) {
            int i4 = 8;
            if (i3 == bArr.length - 8) {
                int i5 = (iOS2IP + 31) >>> 5;
                this.f14621d = i5;
                this.f14620c = (int[][]) Array.newInstance((Class<?>) int.class, i2, i5);
                int i6 = this.f14638b;
                int i7 = i6 >> 5;
                int i8 = i6 & 31;
                for (int i9 = 0; i9 < this.f14637a; i9++) {
                    int i10 = 0;
                    while (i10 < i7) {
                        this.f14620c[i9][i10] = j.OS2IP(bArr, i4);
                        i10++;
                        i4 += 4;
                    }
                    int i11 = 0;
                    while (i11 < i8) {
                        int[] iArr = this.f14620c[i9];
                        iArr[i7] = ((bArr[i4] & 255) << i11) ^ iArr[i7];
                        i11 += 8;
                        i4++;
                    }
                }
                return;
            }
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    public static void a(int[] iArr, int[] iArr2, int i2) {
        for (int length = iArr2.length - 1; length >= i2; length--) {
            iArr2[length] = iArr[length] ^ iArr2[length];
        }
    }

    public static c[] createRandomRegularMatrixAndItsInverse(int i2, SecureRandom secureRandom) {
        c[] cVarArr = new c[2];
        int i3 = (i2 + 31) >> 5;
        c cVar = new c(i2, 'L', secureRandom);
        c cVar2 = new c(i2, 'U', secureRandom);
        c cVar3 = (c) cVar.rightMultiply(cVar2);
        l lVar = new l(i2, secureRandom);
        int[] vector = lVar.getVector();
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i2, i3);
        for (int i4 = 0; i4 < i2; i4++) {
            System.arraycopy(cVar3.f14620c[vector[i4]], 0, iArr[i4], 0, i3);
        }
        cVarArr[0] = new c(i2, iArr);
        c cVar4 = new c(i2, 'I');
        int i5 = 0;
        while (i5 < i2) {
            int i6 = i5 >>> 5;
            int i7 = 1 << (i5 & 31);
            int i8 = i5 + 1;
            for (int i9 = i8; i9 < i2; i9++) {
                if ((cVar.f14620c[i9][i6] & i7) != 0) {
                    for (int i10 = 0; i10 <= i6; i10++) {
                        int[][] iArr2 = cVar4.f14620c;
                        int[] iArr3 = iArr2[i9];
                        iArr3[i10] = iArr3[i10] ^ iArr2[i5][i10];
                    }
                }
            }
            i5 = i8;
        }
        c cVar5 = new c(i2, 'I');
        for (int i11 = i2 - 1; i11 >= 0; i11--) {
            int i12 = i11 >>> 5;
            int i13 = 1 << (i11 & 31);
            for (int i14 = i11 - 1; i14 >= 0; i14--) {
                if ((cVar2.f14620c[i14][i12] & i13) != 0) {
                    for (int i15 = i12; i15 < i3; i15++) {
                        int[][] iArr4 = cVar5.f14620c;
                        int[] iArr5 = iArr4[i14];
                        iArr5[i15] = iArr4[i11][i15] ^ iArr5[i15];
                    }
                }
            }
        }
        cVarArr[1] = (c) cVar5.rightMultiply(cVar4.rightMultiply(lVar));
        return cVarArr;
    }

    public static void g(int[][] iArr, int i2, int i3) {
        int[] iArr2 = iArr[i2];
        iArr[i2] = iArr[i3];
        iArr[i3] = iArr2;
    }

    public final void b(int i2, SecureRandom secureRandom) {
        this.f14637a = i2;
        this.f14638b = i2;
        int i3 = (i2 + 31) >>> 5;
        this.f14621d = i3;
        this.f14620c = (int[][]) Array.newInstance((Class<?>) int.class, i2, i3);
        for (int i4 = 0; i4 < this.f14637a; i4++) {
            int i5 = i4 >>> 5;
            int i6 = i4 & 31;
            int i7 = 31 - i6;
            int i8 = 1 << i6;
            for (int i9 = 0; i9 < i5; i9++) {
                this.f14620c[i4][i9] = secureRandom.nextInt();
            }
            this.f14620c[i4][i5] = i8 | (secureRandom.nextInt() >>> i7);
            while (true) {
                i5++;
                if (i5 < this.f14621d) {
                    this.f14620c[i4][i5] = 0;
                }
            }
        }
    }

    public final void c(int i2, SecureRandom secureRandom) {
        this.f14637a = i2;
        this.f14638b = i2;
        int i3 = (i2 + 31) >>> 5;
        this.f14621d = i3;
        this.f14620c = (int[][]) Array.newInstance((Class<?>) int.class, i2, i3);
        c cVar = (c) new c(i2, 'L', secureRandom).rightMultiply(new c(i2, 'U', secureRandom));
        int[] vector = new l(i2, secureRandom).getVector();
        for (int i4 = 0; i4 < i2; i4++) {
            System.arraycopy(cVar.f14620c[i4], 0, this.f14620c[vector[i4]], 0, this.f14621d);
        }
    }

    @Override // g.a.i.d.a.k
    public k computeInverse() {
        int i2 = this.f14637a;
        if (i2 != this.f14638b) {
            throw new ArithmeticException("Matrix is not invertible.");
        }
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i2, this.f14621d);
        for (int i3 = this.f14637a - 1; i3 >= 0; i3--) {
            iArr[i3] = h.clone(this.f14620c[i3]);
        }
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) int.class, this.f14637a, this.f14621d);
        for (int i4 = this.f14637a - 1; i4 >= 0; i4--) {
            iArr2[i4][i4 >> 5] = 1 << (i4 & 31);
        }
        for (int i5 = 0; i5 < this.f14637a; i5++) {
            int i6 = i5 >> 5;
            int i7 = 1 << (i5 & 31);
            if ((iArr[i5][i6] & i7) == 0) {
                int i8 = i5 + 1;
                boolean z = false;
                while (i8 < this.f14637a) {
                    if ((iArr[i8][i6] & i7) != 0) {
                        g(iArr, i5, i8);
                        g(iArr2, i5, i8);
                        i8 = this.f14637a;
                        z = true;
                    }
                    i8++;
                }
                if (!z) {
                    throw new ArithmeticException("Matrix is not invertible.");
                }
            }
            for (int i9 = this.f14637a - 1; i9 >= 0; i9--) {
                if (i9 != i5 && (iArr[i9][i6] & i7) != 0) {
                    a(iArr[i5], iArr[i9], i6);
                    a(iArr2[i5], iArr2[i9], 0);
                }
            }
        }
        return new c(this.f14638b, iArr2);
    }

    public k computeTranspose() {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, this.f14638b, (this.f14637a + 31) >>> 5);
        int i2 = 0;
        while (true) {
            int i3 = this.f14637a;
            if (i2 >= i3) {
                return new c(i3, iArr);
            }
            for (int i4 = 0; i4 < this.f14638b; i4++) {
                int i5 = i2 >>> 5;
                int i6 = i2 & 31;
                if (((this.f14620c[i2][i4 >>> 5] >>> (i4 & 31)) & 1) == 1) {
                    int[] iArr2 = iArr[i4];
                    iArr2[i5] = (1 << i6) | iArr2[i5];
                }
            }
            i2++;
        }
    }

    public final void d(int i2, SecureRandom secureRandom) {
        int i3;
        this.f14637a = i2;
        this.f14638b = i2;
        int i4 = (i2 + 31) >>> 5;
        this.f14621d = i4;
        this.f14620c = (int[][]) Array.newInstance((Class<?>) int.class, i2, i4);
        int i5 = i2 & 31;
        int i6 = i5 == 0 ? -1 : (1 << i5) - 1;
        for (int i7 = 0; i7 < this.f14637a; i7++) {
            int i8 = i7 >>> 5;
            int i9 = i7 & 31;
            int i10 = 1 << i9;
            for (int i11 = 0; i11 < i8; i11++) {
                this.f14620c[i7][i11] = 0;
            }
            this.f14620c[i7][i8] = (secureRandom.nextInt() << i9) | i10;
            while (true) {
                i8++;
                i3 = this.f14621d;
                if (i8 < i3) {
                    this.f14620c[i7][i8] = secureRandom.nextInt();
                }
            }
            int[] iArr = this.f14620c[i7];
            int i12 = i3 - 1;
            iArr[i12] = iArr[i12] & i6;
        }
    }

    public final void e(int i2) {
        this.f14637a = i2;
        this.f14638b = i2;
        int i3 = (i2 + 31) >>> 5;
        this.f14621d = i3;
        int[] iArr = {i2, i3};
        this.f14620c = (int[][]) Array.newInstance((Class<?>) int.class, iArr);
        for (int i4 = 0; i4 < this.f14637a; i4++) {
            for (int i5 = 0; i5 < this.f14621d; i5++) {
                this.f14620c[i4][i5] = 0;
            }
        }
        for (int i6 = 0; i6 < this.f14637a; i6++) {
            this.f14620c[i6][i6 >>> 5] = 1 << (i6 & 31);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f14637a != cVar.f14637a || this.f14638b != cVar.f14638b || this.f14621d != cVar.f14621d) {
            return false;
        }
        for (int i2 = 0; i2 < this.f14637a; i2++) {
            if (!h.equals(this.f14620c[i2], cVar.f14620c[i2])) {
                return false;
            }
        }
        return true;
    }

    public c extendLeftCompactForm() {
        int i2 = this.f14638b;
        int i3 = this.f14637a;
        c cVar = new c(i3, i2 + i3);
        int i4 = this.f14637a;
        int i5 = (i4 - 1) + this.f14638b;
        int i6 = i4 - 1;
        while (i6 >= 0) {
            System.arraycopy(this.f14620c[i6], 0, cVar.f14620c[i6], 0, this.f14621d);
            int[] iArr = cVar.f14620c[i6];
            int i7 = i5 >> 5;
            iArr[i7] = iArr[i7] | (1 << (i5 & 31));
            i6--;
            i5--;
        }
        return cVar;
    }

    public c extendRightCompactForm() {
        int i2;
        int i3 = this.f14637a;
        c cVar = new c(i3, this.f14638b + i3);
        int i4 = this.f14637a;
        int i5 = i4 >> 5;
        int i6 = i4 & 31;
        for (int i7 = i4 - 1; i7 >= 0; i7--) {
            int[][] iArr = cVar.f14620c;
            int[] iArr2 = iArr[i7];
            int i8 = i7 >> 5;
            iArr2[i8] = iArr2[i8] | (1 << (i7 & 31));
            int i9 = 0;
            if (i6 != 0) {
                int i10 = i5;
                while (true) {
                    i2 = this.f14621d;
                    if (i9 >= i2 - 1) {
                        break;
                    }
                    int i11 = this.f14620c[i7][i9];
                    int[][] iArr3 = cVar.f14620c;
                    int[] iArr4 = iArr3[i7];
                    int i12 = i10 + 1;
                    iArr4[i10] = iArr4[i10] | (i11 << i6);
                    int[] iArr5 = iArr3[i7];
                    iArr5[i12] = (i11 >>> (32 - i6)) | iArr5[i12];
                    i9++;
                    i10 = i12;
                }
                int i13 = this.f14620c[i7][i2 - 1];
                int[][] iArr6 = cVar.f14620c;
                int[] iArr7 = iArr6[i7];
                int i14 = i10 + 1;
                iArr7[i10] = iArr7[i10] | (i13 << i6);
                if (i14 < cVar.f14621d) {
                    int[] iArr8 = iArr6[i7];
                    iArr8[i14] = (i13 >>> (32 - i6)) | iArr8[i14];
                }
            } else {
                System.arraycopy(this.f14620c[i7], 0, iArr[i7], i5, this.f14621d);
            }
        }
        return cVar;
    }

    public final void f(int i2, int i3) {
        this.f14637a = i2;
        this.f14638b = i3;
        int i4 = (i3 + 31) >>> 5;
        this.f14621d = i4;
        this.f14620c = (int[][]) Array.newInstance((Class<?>) int.class, i2, i4);
        for (int i5 = 0; i5 < this.f14637a; i5++) {
            for (int i6 = 0; i6 < this.f14621d; i6++) {
                this.f14620c[i5][i6] = 0;
            }
        }
    }

    @Override // g.a.i.d.a.k
    public byte[] getEncoded() {
        int i2 = (this.f14638b + 7) >>> 3;
        int i3 = this.f14637a;
        int i4 = 8;
        byte[] bArr = new byte[(i2 * i3) + 8];
        j.I2OSP(i3, bArr, 0);
        j.I2OSP(this.f14638b, bArr, 4);
        int i5 = this.f14638b;
        int i6 = i5 >>> 5;
        int i7 = i5 & 31;
        for (int i8 = 0; i8 < this.f14637a; i8++) {
            int i9 = 0;
            while (i9 < i6) {
                j.I2OSP(this.f14620c[i8][i9], bArr, i4);
                i9++;
                i4 += 4;
            }
            int i10 = 0;
            while (i10 < i7) {
                bArr[i4] = (byte) ((this.f14620c[i8][i6] >>> i10) & 255);
                i10 += 8;
                i4++;
            }
        }
        return bArr;
    }

    public double getHammingWeight() {
        int i2 = this.f14638b & 31;
        int i3 = this.f14621d;
        if (i2 != 0) {
            i3--;
        }
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i4 = 0; i4 < this.f14637a; i4++) {
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = this.f14620c[i4][i5];
                for (int i7 = 0; i7 < 32; i7++) {
                    d2 += (double) ((i6 >>> i7) & 1);
                    d3 += 1.0d;
                }
            }
            int i8 = this.f14620c[i4][this.f14621d - 1];
            for (int i9 = 0; i9 < i2; i9++) {
                d2 += (double) ((i8 >>> i9) & 1);
                d3 += 1.0d;
            }
        }
        return d2 / d3;
    }

    public int[][] getIntArray() {
        return this.f14620c;
    }

    public c getLeftSubMatrix() {
        int i2 = this.f14638b;
        int i3 = this.f14637a;
        if (i2 <= i3) {
            throw new ArithmeticException("empty submatrix");
        }
        int i4 = (i3 + 31) >> 5;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i3, i4);
        int i5 = this.f14637a;
        int i6 = (1 << (i5 & 31)) - 1;
        if (i6 == 0) {
            i6 = -1;
        }
        for (int i7 = i5 - 1; i7 >= 0; i7--) {
            System.arraycopy(this.f14620c[i7], 0, iArr[i7], 0, i4);
            int[] iArr2 = iArr[i7];
            int i8 = i4 - 1;
            iArr2[i8] = iArr2[i8] & i6;
        }
        return new c(this.f14637a, iArr);
    }

    public int getLength() {
        return this.f14621d;
    }

    public c getRightSubMatrix() {
        int i2;
        int i3 = this.f14638b;
        int i4 = this.f14637a;
        if (i3 <= i4) {
            throw new ArithmeticException("empty submatrix");
        }
        int i5 = i4 >> 5;
        int i6 = i4 & 31;
        c cVar = new c(i4, i3 - i4);
        for (int i7 = this.f14637a - 1; i7 >= 0; i7--) {
            int i8 = 0;
            if (i6 != 0) {
                int i9 = i5;
                while (true) {
                    i2 = cVar.f14621d;
                    if (i8 >= i2 - 1) {
                        break;
                    }
                    int[] iArr = cVar.f14620c[i7];
                    int[][] iArr2 = this.f14620c;
                    int i10 = i9 + 1;
                    iArr[i8] = (iArr2[i7][i9] >>> i6) | (iArr2[i7][i10] << (32 - i6));
                    i8++;
                    i9 = i10;
                }
                int[][] iArr3 = cVar.f14620c;
                int[][] iArr4 = this.f14620c;
                int i11 = i9 + 1;
                iArr3[i7][i2 - 1] = iArr4[i7][i9] >>> i6;
                if (i11 < this.f14621d) {
                    int[] iArr5 = iArr3[i7];
                    int i12 = i2 - 1;
                    iArr5[i12] = iArr5[i12] | (iArr4[i7][i11] << (32 - i6));
                }
            } else {
                System.arraycopy(this.f14620c[i7], i5, cVar.f14620c[i7], 0, cVar.f14621d);
            }
        }
        return cVar;
    }

    public int[] getRow(int i2) {
        return this.f14620c[i2];
    }

    public int hashCode() {
        int iHashCode = (((this.f14637a * 31) + this.f14638b) * 31) + this.f14621d;
        for (int i2 = 0; i2 < this.f14637a; i2++) {
            iHashCode = (iHashCode * 31) + g.a.j.a.hashCode(this.f14620c[i2]);
        }
        return iHashCode;
    }

    @Override // g.a.i.d.a.k
    public boolean isZero() {
        for (int i2 = 0; i2 < this.f14637a; i2++) {
            for (int i3 = 0; i3 < this.f14621d; i3++) {
                if (this.f14620c[i2][i3] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public k leftMultiply(l lVar) {
        int[] vector = lVar.getVector();
        int length = vector.length;
        int i2 = this.f14637a;
        if (length != i2) {
            throw new ArithmeticException("length mismatch");
        }
        int[][] iArr = new int[i2][];
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            iArr[i3] = h.clone(this.f14620c[vector[i3]]);
        }
        return new c(this.f14637a, iArr);
    }

    @Override // g.a.i.d.a.k
    public q leftMultiply(q qVar) {
        if (!(qVar instanceof d)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        }
        if (qVar.f14647a != this.f14637a) {
            throw new ArithmeticException("length mismatch");
        }
        int[] vecArray = ((d) qVar).getVecArray();
        int[] iArr = new int[this.f14621d];
        int i2 = this.f14637a;
        int i3 = i2 >> 5;
        int i4 = 1 << (i2 & 31);
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = 1;
            do {
                if ((vecArray[i6] & i7) != 0) {
                    for (int i8 = 0; i8 < this.f14621d; i8++) {
                        iArr[i8] = iArr[i8] ^ this.f14620c[i5][i8];
                    }
                }
                i5++;
                i7 <<= 1;
            } while (i7 != 0);
        }
        for (int i9 = 1; i9 != i4; i9 <<= 1) {
            if ((vecArray[i3] & i9) != 0) {
                for (int i10 = 0; i10 < this.f14621d; i10++) {
                    iArr[i10] = iArr[i10] ^ this.f14620c[i5][i10];
                }
            }
            i5++;
        }
        return new d(iArr, this.f14638b);
    }

    public q leftMultiplyLeftCompactForm(q qVar) {
        if (!(qVar instanceof d)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        }
        if (qVar.f14647a != this.f14637a) {
            throw new ArithmeticException("length mismatch");
        }
        int[] vecArray = ((d) qVar).getVecArray();
        int i2 = this.f14637a;
        int[] iArr = new int[((this.f14638b + i2) + 31) >>> 5];
        int i3 = i2 >>> 5;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = 1;
            do {
                if ((vecArray[i5] & i6) != 0) {
                    for (int i7 = 0; i7 < this.f14621d; i7++) {
                        iArr[i7] = iArr[i7] ^ this.f14620c[i4][i7];
                    }
                    int i8 = this.f14638b;
                    int i9 = (i8 + i4) >>> 5;
                    iArr[i9] = (1 << ((i8 + i4) & 31)) | iArr[i9];
                }
                i4++;
                i6 <<= 1;
            } while (i6 != 0);
        }
        int i10 = 1 << (this.f14637a & 31);
        for (int i11 = 1; i11 != i10; i11 <<= 1) {
            if ((vecArray[i3] & i11) != 0) {
                for (int i12 = 0; i12 < this.f14621d; i12++) {
                    iArr[i12] = iArr[i12] ^ this.f14620c[i4][i12];
                }
                int i13 = this.f14638b;
                int i14 = (i13 + i4) >>> 5;
                iArr[i14] = (1 << ((i13 + i4) & 31)) | iArr[i14];
            }
            i4++;
        }
        return new d(iArr, this.f14637a + this.f14638b);
    }

    @Override // g.a.i.d.a.k
    public k rightMultiply(k kVar) {
        if (!(kVar instanceof c)) {
            throw new ArithmeticException("matrix is not defined over GF(2)");
        }
        if (kVar.f14637a != this.f14638b) {
            throw new ArithmeticException("length mismatch");
        }
        c cVar = (c) kVar;
        c cVar2 = new c(this.f14637a, kVar.f14638b);
        int i2 = this.f14638b & 31;
        int i3 = this.f14621d;
        if (i2 != 0) {
            i3--;
        }
        for (int i4 = 0; i4 < this.f14637a; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = this.f14620c[i4][i6];
                for (int i8 = 0; i8 < 32; i8++) {
                    if (((1 << i8) & i7) != 0) {
                        for (int i9 = 0; i9 < cVar.f14621d; i9++) {
                            int[] iArr = cVar2.f14620c[i4];
                            iArr[i9] = iArr[i9] ^ cVar.f14620c[i5][i9];
                        }
                    }
                    i5++;
                }
            }
            int i10 = this.f14620c[i4][this.f14621d - 1];
            for (int i11 = 0; i11 < i2; i11++) {
                if (((1 << i11) & i10) != 0) {
                    for (int i12 = 0; i12 < cVar.f14621d; i12++) {
                        int[] iArr2 = cVar2.f14620c[i4];
                        iArr2[i12] = iArr2[i12] ^ cVar.f14620c[i5][i12];
                    }
                }
                i5++;
            }
        }
        return cVar2;
    }

    @Override // g.a.i.d.a.k
    public k rightMultiply(l lVar) {
        int[] vector = lVar.getVector();
        int length = vector.length;
        int i2 = this.f14638b;
        if (length != i2) {
            throw new ArithmeticException("length mismatch");
        }
        c cVar = new c(this.f14637a, i2);
        for (int i3 = this.f14638b - 1; i3 >= 0; i3--) {
            int i4 = i3 >>> 5;
            int i5 = i3 & 31;
            int i6 = vector[i3] >>> 5;
            int i7 = vector[i3] & 31;
            for (int i8 = this.f14637a - 1; i8 >= 0; i8--) {
                int[] iArr = cVar.f14620c[i8];
                iArr[i4] = iArr[i4] | (((this.f14620c[i8][i6] >>> i7) & 1) << i5);
            }
        }
        return cVar;
    }

    @Override // g.a.i.d.a.k
    public q rightMultiply(q qVar) {
        if (!(qVar instanceof d)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        }
        if (qVar.f14647a != this.f14638b) {
            throw new ArithmeticException("length mismatch");
        }
        int[] vecArray = ((d) qVar).getVecArray();
        int[] iArr = new int[(this.f14637a + 31) >>> 5];
        int i2 = 0;
        while (true) {
            int i3 = this.f14637a;
            if (i2 >= i3) {
                return new d(iArr, i3);
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.f14621d; i5++) {
                i4 ^= this.f14620c[i2][i5] & vecArray[i5];
            }
            int i6 = 0;
            for (int i7 = 0; i7 < 32; i7++) {
                i6 ^= (i4 >>> i7) & 1;
            }
            if (i6 == 1) {
                int i8 = i2 >>> 5;
                iArr[i8] = iArr[i8] | (1 << (i2 & 31));
            }
            i2++;
        }
    }

    public q rightMultiplyRightCompactForm(q qVar) {
        int i2;
        if (!(qVar instanceof d)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        }
        if (qVar.f14647a != this.f14638b + this.f14637a) {
            throw new ArithmeticException("length mismatch");
        }
        int[] vecArray = ((d) qVar).getVecArray();
        int i3 = this.f14637a;
        int[] iArr = new int[(i3 + 31) >>> 5];
        int i4 = i3 >> 5;
        int i5 = i3 & 31;
        int i6 = 0;
        while (true) {
            int i7 = this.f14637a;
            if (i6 >= i7) {
                return new d(iArr, i7);
            }
            int i8 = i6 >> 5;
            int i9 = i6 & 31;
            int i10 = (vecArray[i8] >>> i9) & 1;
            int i11 = i4;
            int i12 = 0;
            if (i5 != 0) {
                while (true) {
                    i2 = this.f14621d;
                    if (i12 >= i2 - 1) {
                        break;
                    }
                    int i13 = i11 + 1;
                    i10 ^= ((vecArray[i11] >>> i5) | (vecArray[i13] << (32 - i5))) & this.f14620c[i6][i12];
                    i12++;
                    i11 = i13;
                }
                int i14 = i11 + 1;
                int i15 = vecArray[i11] >>> i5;
                if (i14 < vecArray.length) {
                    i15 |= vecArray[i14] << (32 - i5);
                }
                i10 ^= this.f14620c[i6][i2 - 1] & i15;
            } else {
                while (i12 < this.f14621d) {
                    i10 ^= vecArray[i11] & this.f14620c[i6][i12];
                    i12++;
                    i11++;
                }
            }
            int i16 = 0;
            for (int i17 = 0; i17 < 32; i17++) {
                i16 ^= i10 & 1;
                i10 >>>= 1;
            }
            if (i16 == 1) {
                iArr[i8] = iArr[i8] | (1 << i9);
            }
            i6++;
        }
    }

    @Override // g.a.i.d.a.k
    public String toString() {
        int i2 = this.f14638b & 31;
        int i3 = this.f14621d;
        if (i2 != 0) {
            i3--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < this.f14637a; i4++) {
            stringBuffer.append(i4 + ": ");
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = this.f14620c[i4][i5];
                for (int i7 = 0; i7 < 32; i7++) {
                    if (((i6 >>> i7) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            int i8 = this.f14620c[i4][this.f14621d - 1];
            for (int i9 = 0; i9 < i2; i9++) {
                if (((i8 >>> i9) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}
