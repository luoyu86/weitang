package g.a.g.b;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14182a = new g(BigInteger.valueOf(2));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14183b = new g(BigInteger.valueOf(3));

    public static f getBinaryExtensionField(int[] iArr) {
        if (iArr[0] != 0) {
            throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
        }
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] <= iArr[i2 - 1]) {
                throw new IllegalArgumentException("Polynomial exponents must be monotonically increasing");
            }
        }
        return new d(f14182a, new c(iArr));
    }

    public static a getPrimeField(BigInteger bigInteger) {
        int iBitLength = bigInteger.bitLength();
        if (bigInteger.signum() <= 0 || iBitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (iBitLength < 3) {
            int iIntValue = bigInteger.intValue();
            if (iIntValue == 2) {
                return f14182a;
            }
            if (iIntValue == 3) {
                return f14183b;
            }
        }
        return new g(bigInteger);
    }
}
