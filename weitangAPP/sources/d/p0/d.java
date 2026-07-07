package d.p0;

/* JADX INFO: loaded from: classes2.dex */
public class d extends c {
    public static final char digitToChar(int i2) {
        if (i2 >= 0 && 9 >= i2) {
            return (char) (i2 + 48);
        }
        throw new IllegalArgumentException("Int " + i2 + " is not a decimal digit");
    }

    public static final int digitToInt(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        throw new IllegalArgumentException("Char " + c2 + " is not a decimal digit");
    }

    public static final Integer digitToIntOrNull(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return Integer.valueOf(c2 - '0');
        }
        return null;
    }

    public static final boolean equals(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (z) {
            return Character.toUpperCase(c2) == Character.toUpperCase(c3) || Character.toLowerCase(c2) == Character.toLowerCase(c3);
        }
        return false;
    }

    public static /* synthetic */ boolean equals$default(char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return equals(c2, c3, z);
    }

    public static final boolean isSurrogate(char c2) {
        return 55296 <= c2 && 57343 >= c2;
    }

    public static final char digitToChar(int i2, int i3) {
        if (2 > i3 || 36 < i3) {
            throw new IllegalArgumentException("Invalid radix: " + i3 + ". Valid radix values are in range 2..36");
        }
        if (i2 >= 0 && i2 < i3) {
            return (char) (i2 < 10 ? i2 + 48 : ((char) (i2 + 65)) - '\n');
        }
        throw new IllegalArgumentException("Digit " + i2 + " does not represent a valid digit in radix " + i3);
    }

    public static final int digitToInt(char c2, int i2) {
        Integer numDigitToIntOrNull = digitToIntOrNull(c2, i2);
        if (numDigitToIntOrNull != null) {
            return numDigitToIntOrNull.intValue();
        }
        throw new IllegalArgumentException("Char " + c2 + " is not a digit in the given radix=" + i2);
    }

    public static final Integer digitToIntOrNull(char c2, int i2) {
        if (2 > i2 || 36 < i2) {
            throw new IllegalArgumentException("Invalid radix: " + i2 + ". Valid radix values are in range 2..36");
        }
        if ('0' <= c2 && '9' >= c2) {
            int i3 = c2 - 48;
            if (i3 < i2) {
                return Integer.valueOf(i3);
            }
            return null;
        }
        int i4 = (c2 - (d.k0.d.t.compare((int) c2, 90) <= 0 ? 65 : 97)) + 10;
        if (10 <= i4 && i2 > i4) {
            return Integer.valueOf(i4);
        }
        return null;
    }
}
