package g.a.i.d.a;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class d extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f14622b;

    public d(int i2) {
        if (i2 < 0) {
            throw new ArithmeticException("Negative length.");
        }
        this.f14647a = i2;
        this.f14622b = new int[(i2 + 31) >> 5];
    }

    public d(int i2, int i3, SecureRandom secureRandom) {
        if (i3 > i2) {
            throw new ArithmeticException("The hamming weight is greater than the length of vector.");
        }
        this.f14647a = i2;
        this.f14622b = new int[(i2 + 31) >> 5];
        int[] iArr = new int[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            iArr[i4] = i4;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            int iA = p.a(secureRandom, i2);
            setBit(iArr[iA]);
            i2--;
            iArr[iA] = iArr[i2];
        }
    }

    public d(int i2, SecureRandom secureRandom) {
        this.f14647a = i2;
        int i3 = (i2 + 31) >> 5;
        this.f14622b = new int[i3];
        int i4 = i3 - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            this.f14622b[i5] = secureRandom.nextInt();
        }
        int i6 = i2 & 31;
        if (i6 != 0) {
            int[] iArr = this.f14622b;
            iArr[i4] = ((1 << i6) - 1) & iArr[i4];
        }
    }

    public d(int i2, int[] iArr) {
        if (i2 < 0) {
            throw new ArithmeticException("negative length");
        }
        this.f14647a = i2;
        int i3 = (i2 + 31) >> 5;
        if (iArr.length != i3) {
            throw new ArithmeticException("length mismatch");
        }
        int[] iArrClone = h.clone(iArr);
        this.f14622b = iArrClone;
        int i4 = i2 & 31;
        if (i4 != 0) {
            int i5 = i3 - 1;
            iArrClone[i5] = ((1 << i4) - 1) & iArrClone[i5];
        }
    }

    public d(d dVar) {
        this.f14647a = dVar.f14647a;
        this.f14622b = h.clone(dVar.f14622b);
    }

    public d(int[] iArr, int i2) {
        this.f14622b = iArr;
        this.f14647a = i2;
    }

    public static d OS2VP(int i2, byte[] bArr) {
        if (i2 < 0) {
            throw new ArithmeticException("negative length");
        }
        if (bArr.length <= ((i2 + 7) >> 3)) {
            return new d(i2, j.toIntArray(bArr));
        }
        throw new ArithmeticException("length mismatch");
    }

    @Override // g.a.i.d.a.q
    public q add(q qVar) {
        if (!(qVar instanceof d)) {
            throw new ArithmeticException("vector is not defined over GF(2)");
        }
        d dVar = (d) qVar;
        if (this.f14647a != dVar.f14647a) {
            throw new ArithmeticException("length mismatch");
        }
        int[] iArrClone = h.clone(dVar.f14622b);
        for (int length = iArrClone.length - 1; length >= 0; length--) {
            iArrClone[length] = iArrClone[length] ^ this.f14622b[length];
        }
        return new d(this.f14647a, iArrClone);
    }

    @Override // g.a.i.d.a.q
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f14647a == dVar.f14647a && h.equals(this.f14622b, dVar.f14622b);
    }

    public d extractLeftVector(int i2) {
        int i3 = this.f14647a;
        if (i2 > i3) {
            throw new ArithmeticException("invalid length");
        }
        if (i2 == i3) {
            return new d(this);
        }
        d dVar = new d(i2);
        int i4 = i2 >> 5;
        int i5 = i2 & 31;
        System.arraycopy(this.f14622b, 0, dVar.f14622b, 0, i4);
        if (i5 != 0) {
            dVar.f14622b[i4] = ((1 << i5) - 1) & this.f14622b[i4];
        }
        return dVar;
    }

    public d extractRightVector(int i2) {
        int i3;
        int i4 = this.f14647a;
        if (i2 > i4) {
            throw new ArithmeticException("invalid length");
        }
        if (i2 == i4) {
            return new d(this);
        }
        d dVar = new d(i2);
        int i5 = this.f14647a;
        int i6 = (i5 - i2) >> 5;
        int i7 = (i5 - i2) & 31;
        int i8 = (i2 + 31) >> 5;
        int i9 = 0;
        if (i7 != 0) {
            while (true) {
                i3 = i8 - 1;
                if (i9 >= i3) {
                    break;
                }
                int[] iArr = dVar.f14622b;
                int[] iArr2 = this.f14622b;
                int i10 = i6 + 1;
                iArr[i9] = (iArr2[i6] >>> i7) | (iArr2[i10] << (32 - i7));
                i9++;
                i6 = i10;
            }
            int[] iArr3 = dVar.f14622b;
            int[] iArr4 = this.f14622b;
            int i11 = i6 + 1;
            iArr3[i3] = iArr4[i6] >>> i7;
            if (i11 < iArr4.length) {
                iArr3[i3] = (iArr4[i11] << (32 - i7)) | iArr3[i3];
            }
        } else {
            System.arraycopy(this.f14622b, i6, dVar.f14622b, 0, i8);
        }
        return dVar;
    }

    public d extractVector(int[] iArr) {
        int length = iArr.length;
        if (iArr[length - 1] > this.f14647a) {
            throw new ArithmeticException("invalid index set");
        }
        d dVar = new d(length);
        for (int i2 = 0; i2 < length; i2++) {
            if ((this.f14622b[iArr[i2] >> 5] & (1 << (iArr[i2] & 31))) != 0) {
                int[] iArr2 = dVar.f14622b;
                int i3 = i2 >> 5;
                iArr2[i3] = (1 << (i2 & 31)) | iArr2[i3];
            }
        }
        return dVar;
    }

    public int getBit(int i2) {
        if (i2 >= this.f14647a) {
            throw new IndexOutOfBoundsException();
        }
        int i3 = i2 >> 5;
        int i4 = i2 & 31;
        return (this.f14622b[i3] & (1 << i4)) >>> i4;
    }

    @Override // g.a.i.d.a.q
    public byte[] getEncoded() {
        return j.toByteArray(this.f14622b, (this.f14647a + 7) >> 3);
    }

    public int getHammingWeight() {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.f14622b;
            if (i2 >= iArr.length) {
                return i3;
            }
            int i4 = iArr[i2];
            for (int i5 = 0; i5 < 32; i5++) {
                if ((i4 & 1) != 0) {
                    i3++;
                }
                i4 >>>= 1;
            }
            i2++;
        }
    }

    public int[] getVecArray() {
        return this.f14622b;
    }

    @Override // g.a.i.d.a.q
    public int hashCode() {
        return (this.f14647a * 31) + g.a.j.a.hashCode(this.f14622b);
    }

    @Override // g.a.i.d.a.q
    public boolean isZero() {
        for (int length = this.f14622b.length - 1; length >= 0; length--) {
            if (this.f14622b[length] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // g.a.i.d.a.q
    public q multiply(l lVar) {
        int[] vector = lVar.getVector();
        int i2 = this.f14647a;
        if (i2 != vector.length) {
            throw new ArithmeticException("length mismatch");
        }
        d dVar = new d(i2);
        for (int i3 = 0; i3 < vector.length; i3++) {
            if ((this.f14622b[vector[i3] >> 5] & (1 << (vector[i3] & 31))) != 0) {
                int[] iArr = dVar.f14622b;
                int i4 = i3 >> 5;
                iArr[i4] = (1 << (i3 & 31)) | iArr[i4];
            }
        }
        return dVar;
    }

    public void setBit(int i2) {
        if (i2 >= this.f14647a) {
            throw new IndexOutOfBoundsException();
        }
        int[] iArr = this.f14622b;
        int i3 = i2 >> 5;
        iArr[i3] = (1 << (i2 & 31)) | iArr[i3];
    }

    public f toExtensionFieldVector(e eVar) {
        int degree = eVar.getDegree();
        int i2 = this.f14647a;
        if (i2 % degree != 0) {
            throw new ArithmeticException("conversion is impossible");
        }
        int i3 = i2 / degree;
        int[] iArr = new int[i3];
        int i4 = 0;
        for (int i5 = i3 - 1; i5 >= 0; i5--) {
            for (int degree2 = eVar.getDegree() - 1; degree2 >= 0; degree2--) {
                if (((this.f14622b[i4 >>> 5] >>> (i4 & 31)) & 1) == 1) {
                    iArr[i5] = iArr[i5] ^ (1 << degree2);
                }
                i4++;
            }
        }
        return new f(eVar, iArr);
    }

    @Override // g.a.i.d.a.q
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < this.f14647a; i2++) {
            if (i2 != 0 && (i2 & 31) == 0) {
                stringBuffer.append(' ');
            }
            stringBuffer.append((this.f14622b[i2 >> 5] & (1 << (i2 & 31))) == 0 ? '0' : '1');
        }
        return stringBuffer.toString();
    }
}
