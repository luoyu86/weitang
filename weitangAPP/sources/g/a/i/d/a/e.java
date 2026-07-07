package g.a.i.d.a;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14624b;

    public e(int i2) {
        this.f14623a = 0;
        if (i2 >= 32) {
            throw new IllegalArgumentException(" Error: the degree of field is too large ");
        }
        if (i2 < 1) {
            throw new IllegalArgumentException(" Error: the degree of field is non-positive ");
        }
        this.f14623a = i2;
        this.f14624b = n.getIrreduciblePolynomial(i2);
    }

    public e(int i2, int i3) {
        this.f14623a = 0;
        if (i2 != n.degree(i3)) {
            throw new IllegalArgumentException(" Error: the degree is not correct");
        }
        if (!n.isIrreducible(i3)) {
            throw new IllegalArgumentException(" Error: given polynomial is reducible");
        }
        this.f14623a = i2;
        this.f14624b = i3;
    }

    public e(e eVar) {
        this.f14623a = 0;
        this.f14623a = eVar.f14623a;
        this.f14624b = eVar.f14624b;
    }

    public e(byte[] bArr) {
        this.f14623a = 0;
        if (bArr.length != 4) {
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        int iOS2IP = j.OS2IP(bArr);
        this.f14624b = iOS2IP;
        if (!n.isIrreducible(iOS2IP)) {
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        this.f14623a = n.degree(this.f14624b);
    }

    public static String a(int i2) {
        if (i2 == 0) {
            return "0";
        }
        String str = ((byte) (i2 & 1)) == 1 ? "1" : "";
        int i3 = i2 >>> 1;
        int i4 = 1;
        while (i3 != 0) {
            if (((byte) (i3 & 1)) == 1) {
                str = str + "+x^" + i4;
            }
            i3 >>>= 1;
            i4++;
        }
        return str;
    }

    public int add(int i2, int i3) {
        return i2 ^ i3;
    }

    public String elementToStr(int i2) {
        StringBuilder sb;
        String str;
        String string = "";
        for (int i3 = 0; i3 < this.f14623a; i3++) {
            if ((((byte) i2) & 1) == 0) {
                sb = new StringBuilder();
                str = "0";
            } else {
                sb = new StringBuilder();
                str = "1";
            }
            sb.append(str);
            sb.append(string);
            string = sb.toString();
            i2 >>>= 1;
        }
        return string;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof e)) {
            e eVar = (e) obj;
            if (this.f14623a == eVar.f14623a && this.f14624b == eVar.f14624b) {
                return true;
            }
        }
        return false;
    }

    public int exp(int i2, int i3) {
        if (i3 == 0) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 == 1) {
            return 1;
        }
        if (i3 < 0) {
            i2 = inverse(i2);
            i3 = -i3;
        }
        int iMult = 1;
        while (i3 != 0) {
            if ((i3 & 1) == 1) {
                iMult = mult(iMult, i2);
            }
            i2 = mult(i2, i2);
            i3 >>>= 1;
        }
        return iMult;
    }

    public int getDegree() {
        return this.f14623a;
    }

    public byte[] getEncoded() {
        return j.I2OSP(this.f14624b);
    }

    public int getPolynomial() {
        return this.f14624b;
    }

    public int getRandomElement(SecureRandom secureRandom) {
        return p.a(secureRandom, 1 << this.f14623a);
    }

    public int getRandomNonZeroElement() {
        return getRandomNonZeroElement(g.a.d.c.getSecureRandom());
    }

    public int getRandomNonZeroElement(SecureRandom secureRandom) {
        int iA = p.a(secureRandom, 1 << this.f14623a);
        int i2 = 0;
        while (iA == 0 && i2 < 1048576) {
            iA = p.a(secureRandom, 1 << this.f14623a);
            i2++;
        }
        if (i2 == 1048576) {
            return 1;
        }
        return iA;
    }

    public int hashCode() {
        return this.f14624b;
    }

    public int inverse(int i2) {
        return exp(i2, (1 << this.f14623a) - 2);
    }

    public boolean isElementOfThisField(int i2) {
        int i3 = this.f14623a;
        return i3 == 31 ? i2 >= 0 : i2 >= 0 && i2 < (1 << i3);
    }

    public int mult(int i2, int i3) {
        return n.modMultiply(i2, i3, this.f14624b);
    }

    public int sqRoot(int i2) {
        for (int i3 = 1; i3 < this.f14623a; i3++) {
            i2 = mult(i2, i2);
        }
        return i2;
    }

    public String toString() {
        return "Finite Field GF(2^" + this.f14623a + ") = GF(2)[X]/<" + a(this.f14624b) + "> ";
    }
}
