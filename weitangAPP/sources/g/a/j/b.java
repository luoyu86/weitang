package g.a.j;

import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f14650a = BigInteger.valueOf(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final BigInteger f14651b = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BigInteger f14652c = BigInteger.valueOf(2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final BigInteger f14653d = BigInteger.valueOf(3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final BigInteger f14654e = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f14655f = BigInteger.valueOf(743).bitLength();

    public static byte[] a(int i2, SecureRandom secureRandom) throws IllegalArgumentException {
        if (i2 < 1) {
            throw new IllegalArgumentException("bitLength must be at least 1");
        }
        int i3 = (i2 + 7) / 8;
        byte[] bArr = new byte[i3];
        secureRandom.nextBytes(bArr);
        bArr[0] = (byte) (bArr[0] & ((byte) (255 >>> ((i3 * 8) - i2))));
        return bArr;
    }

    public static void asUnsignedByteArray(BigInteger bigInteger, byte[] bArr, int i2, int i3) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i3) {
            System.arraycopy(byteArray, 0, bArr, i2, i3);
            return;
        }
        int i4 = (byteArray[0] != 0 || byteArray.length == 1) ? 0 : 1;
        int length = byteArray.length - i4;
        if (length > i3) {
            throw new IllegalArgumentException("standard length exceeded for value");
        }
        int i5 = (i3 - length) + i2;
        a.fill(bArr, i2, i5, (byte) 0);
        System.arraycopy(byteArray, i4, bArr, i5, length);
    }

    public static byte[] asUnsignedByteArray(int i2, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i2) {
            return byteArray;
        }
        int i3 = 0;
        if (byteArray[0] == 0 && byteArray.length != 1) {
            i3 = 1;
        }
        int length = byteArray.length - i3;
        if (length > i2) {
            throw new IllegalArgumentException("standard length exceeded for value");
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(byteArray, i3, bArr, i2 - length, length);
        return bArr;
    }

    public static byte[] asUnsignedByteArray(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] != 0 || byteArray.length == 1) {
            return byteArray;
        }
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }

    public static byte byteValueExact(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 7) {
            return bigInteger.byteValue();
        }
        throw new ArithmeticException("BigInteger out of int range");
    }

    public static BigInteger createRandomBigInteger(int i2, SecureRandom secureRandom) {
        return new BigInteger(1, a(i2, secureRandom));
    }

    public static BigInteger createRandomInRange(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger bigIntegerCreateRandomBigInteger;
        int iCompareTo = bigInteger.compareTo(bigInteger2);
        if (iCompareTo >= 0) {
            if (iCompareTo <= 0) {
                return bigInteger;
            }
            throw new IllegalArgumentException("'min' may not be greater than 'max'");
        }
        if (bigInteger.bitLength() > bigInteger2.bitLength() / 2) {
            bigIntegerCreateRandomBigInteger = createRandomInRange(f14650a, bigInteger2.subtract(bigInteger), secureRandom);
        } else {
            for (int i2 = 0; i2 < 1000; i2++) {
                BigInteger bigIntegerCreateRandomBigInteger2 = createRandomBigInteger(bigInteger2.bitLength(), secureRandom);
                if (bigIntegerCreateRandomBigInteger2.compareTo(bigInteger) >= 0 && bigIntegerCreateRandomBigInteger2.compareTo(bigInteger2) <= 0) {
                    return bigIntegerCreateRandomBigInteger2;
                }
            }
            bigIntegerCreateRandomBigInteger = createRandomBigInteger(bigInteger2.subtract(bigInteger).bitLength() - 1, secureRandom);
        }
        return bigIntegerCreateRandomBigInteger.add(bigInteger);
    }

    public static BigInteger createRandomPrime(int i2, int i3, SecureRandom secureRandom) {
        BigInteger bigInteger;
        if (i2 < 2) {
            throw new IllegalArgumentException("bitLength < 2");
        }
        if (i2 == 2) {
            return secureRandom.nextInt() < 0 ? f14652c : f14653d;
        }
        do {
            byte[] bArrA = a(i2, secureRandom);
            bArrA[0] = (byte) (((byte) (1 << (7 - ((bArrA.length * 8) - i2)))) | bArrA[0]);
            int length = bArrA.length - 1;
            bArrA[length] = (byte) (bArrA[length] | 1);
            bigInteger = new BigInteger(1, bArrA);
            if (i2 > f14655f) {
                while (!bigInteger.gcd(f14654e).equals(f14651b)) {
                    bigInteger = bigInteger.add(f14652c);
                }
            }
        } while (!bigInteger.isProbablePrime(i3));
        return bigInteger;
    }

    public static BigInteger fromUnsignedByteArray(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static BigInteger fromUnsignedByteArray(byte[] bArr, int i2, int i3) {
        if (i2 != 0 || i3 != bArr.length) {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            bArr = bArr2;
        }
        return new BigInteger(1, bArr);
    }

    public static int getUnsignedByteLength(BigInteger bigInteger) {
        if (bigInteger.equals(f14650a)) {
            return 1;
        }
        return (bigInteger.bitLength() + 7) / 8;
    }

    public static int intValueExact(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 31) {
            return bigInteger.intValue();
        }
        throw new ArithmeticException("BigInteger out of int range");
    }

    public static long longValueExact(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 63) {
            return bigInteger.longValue();
        }
        throw new ArithmeticException("BigInteger out of long range");
    }

    public static BigInteger modOddInverse(BigInteger bigInteger, BigInteger bigInteger2) {
        if (!bigInteger.testBit(0)) {
            throw new IllegalArgumentException("'M' must be odd");
        }
        if (bigInteger.signum() != 1) {
            throw new ArithmeticException("BigInteger: modulus not positive");
        }
        if (bigInteger2.signum() < 0 || bigInteger2.compareTo(bigInteger) >= 0) {
            bigInteger2 = bigInteger2.mod(bigInteger);
        }
        int iBitLength = bigInteger.bitLength();
        int[] iArrFromBigInteger = g.a.g.c.n.fromBigInteger(iBitLength, bigInteger);
        int[] iArrFromBigInteger2 = g.a.g.c.n.fromBigInteger(iBitLength, bigInteger2);
        int length = iArrFromBigInteger.length;
        int[] iArrCreate = g.a.g.c.n.create(length);
        if (g.a.g.c.c.modOddInverse(iArrFromBigInteger, iArrFromBigInteger2, iArrCreate) != 0) {
            return g.a.g.c.n.toBigInteger(length, iArrCreate);
        }
        throw new ArithmeticException("BigInteger not invertible.");
    }

    public static BigInteger modOddInverseVar(BigInteger bigInteger, BigInteger bigInteger2) {
        if (!bigInteger.testBit(0)) {
            throw new IllegalArgumentException("'M' must be odd");
        }
        if (bigInteger.signum() != 1) {
            throw new ArithmeticException("BigInteger: modulus not positive");
        }
        BigInteger bigInteger3 = f14651b;
        if (bigInteger.equals(bigInteger3)) {
            return f14650a;
        }
        if (bigInteger2.signum() < 0 || bigInteger2.compareTo(bigInteger) >= 0) {
            bigInteger2 = bigInteger2.mod(bigInteger);
        }
        if (bigInteger2.equals(bigInteger3)) {
            return bigInteger3;
        }
        int iBitLength = bigInteger.bitLength();
        int[] iArrFromBigInteger = g.a.g.c.n.fromBigInteger(iBitLength, bigInteger);
        int[] iArrFromBigInteger2 = g.a.g.c.n.fromBigInteger(iBitLength, bigInteger2);
        int length = iArrFromBigInteger.length;
        int[] iArrCreate = g.a.g.c.n.create(length);
        if (g.a.g.c.c.modOddInverseVar(iArrFromBigInteger, iArrFromBigInteger2, iArrCreate)) {
            return g.a.g.c.n.toBigInteger(length, iArrCreate);
        }
        throw new ArithmeticException("BigInteger not invertible.");
    }

    public static short shortValueExact(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 15) {
            return bigInteger.shortValue();
        }
        throw new ArithmeticException("BigInteger out of int range");
    }
}
