package g.a.g.a;

import com.alibaba.android.arouter.utils.Consts;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f14149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14150b;

    public s(BigInteger bigInteger, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        }
        this.f14149a = bigInteger;
        this.f14150b = i2;
    }

    public static s getInstance(BigInteger bigInteger, int i2) {
        return new s(bigInteger.shiftLeft(i2), i2);
    }

    public final void a(s sVar) {
        if (this.f14150b != sVar.f14150b) {
            throw new IllegalArgumentException("Only SimpleBigDecimal of same scale allowed in arithmetic operations");
        }
    }

    public s add(s sVar) {
        a(sVar);
        return new s(this.f14149a.add(sVar.f14149a), this.f14150b);
    }

    public s add(BigInteger bigInteger) {
        return new s(this.f14149a.add(bigInteger.shiftLeft(this.f14150b)), this.f14150b);
    }

    public s adjustScale(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("scale may not be negative");
        }
        int i3 = this.f14150b;
        return i2 == i3 ? this : new s(this.f14149a.shiftLeft(i2 - i3), i2);
    }

    public int compareTo(s sVar) {
        a(sVar);
        return this.f14149a.compareTo(sVar.f14149a);
    }

    public int compareTo(BigInteger bigInteger) {
        return this.f14149a.compareTo(bigInteger.shiftLeft(this.f14150b));
    }

    public s divide(s sVar) {
        a(sVar);
        return new s(this.f14149a.shiftLeft(this.f14150b).divide(sVar.f14149a), this.f14150b);
    }

    public s divide(BigInteger bigInteger) {
        return new s(this.f14149a.divide(bigInteger), this.f14150b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f14149a.equals(sVar.f14149a) && this.f14150b == sVar.f14150b;
    }

    public BigInteger floor() {
        return this.f14149a.shiftRight(this.f14150b);
    }

    public int getScale() {
        return this.f14150b;
    }

    public int hashCode() {
        return this.f14149a.hashCode() ^ this.f14150b;
    }

    public int intValue() {
        return floor().intValue();
    }

    public long longValue() {
        return floor().longValue();
    }

    public s multiply(s sVar) {
        a(sVar);
        BigInteger bigIntegerMultiply = this.f14149a.multiply(sVar.f14149a);
        int i2 = this.f14150b;
        return new s(bigIntegerMultiply, i2 + i2);
    }

    public s multiply(BigInteger bigInteger) {
        return new s(this.f14149a.multiply(bigInteger), this.f14150b);
    }

    public s negate() {
        return new s(this.f14149a.negate(), this.f14150b);
    }

    public BigInteger round() {
        return add(new s(d.f14091b, 1).adjustScale(this.f14150b)).floor();
    }

    public s shiftLeft(int i2) {
        return new s(this.f14149a.shiftLeft(i2), this.f14150b);
    }

    public s subtract(s sVar) {
        return add(sVar.negate());
    }

    public s subtract(BigInteger bigInteger) {
        return new s(this.f14149a.subtract(bigInteger.shiftLeft(this.f14150b)), this.f14150b);
    }

    public String toString() {
        if (this.f14150b == 0) {
            return this.f14149a.toString();
        }
        BigInteger bigIntegerFloor = floor();
        BigInteger bigIntegerSubtract = this.f14149a.subtract(bigIntegerFloor.shiftLeft(this.f14150b));
        if (this.f14149a.signum() == -1) {
            bigIntegerSubtract = d.f14091b.shiftLeft(this.f14150b).subtract(bigIntegerSubtract);
        }
        if (bigIntegerFloor.signum() == -1 && !bigIntegerSubtract.equals(d.f14090a)) {
            bigIntegerFloor = bigIntegerFloor.add(d.f14091b);
        }
        String string = bigIntegerFloor.toString();
        char[] cArr = new char[this.f14150b];
        String string2 = bigIntegerSubtract.toString(2);
        int length = string2.length();
        int i2 = this.f14150b - length;
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = '0';
        }
        for (int i4 = 0; i4 < length; i4++) {
            cArr[i2 + i4] = string2.charAt(i4);
        }
        String str = new String(cArr);
        StringBuffer stringBuffer = new StringBuffer(string);
        stringBuffer.append(Consts.DOT);
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
