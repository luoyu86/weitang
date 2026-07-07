package d.p0;

import com.chinavisionary.microtang.comment.vo.ScoresBean;

/* JADX INFO: loaded from: classes2.dex */
public class w extends v {
    public static final Void numberFormatError(String str) {
        d.k0.d.t.checkNotNullParameter(str, ScoresBean.SCORE_TYPE_INPUT);
        throw new NumberFormatException("Invalid number format: '" + str + '\'');
    }

    public static final Byte toByteOrNull(String str) {
        d.k0.d.t.checkNotNullParameter(str, "$this$toByteOrNull");
        return toByteOrNull(str, 10);
    }

    public static final Integer toIntOrNull(String str) {
        d.k0.d.t.checkNotNullParameter(str, "$this$toIntOrNull");
        return toIntOrNull(str, 10);
    }

    public static final Long toLongOrNull(String str) {
        d.k0.d.t.checkNotNullParameter(str, "$this$toLongOrNull");
        return toLongOrNull(str, 10);
    }

    public static final Short toShortOrNull(String str) {
        d.k0.d.t.checkNotNullParameter(str, "$this$toShortOrNull");
        return toShortOrNull(str, 10);
    }

    public static final Byte toByteOrNull(String str, int i2) {
        int iIntValue;
        d.k0.d.t.checkNotNullParameter(str, "$this$toByteOrNull");
        Integer intOrNull = toIntOrNull(str, i2);
        if (intOrNull == null || (iIntValue = intOrNull.intValue()) < -128 || iIntValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) iIntValue);
    }

    public static final Integer toIntOrNull(String str, int i2) {
        boolean z;
        int i3;
        d.k0.d.t.checkNotNullParameter(str, "$this$toIntOrNull");
        c.checkRadix(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        int i5 = -2147483647;
        int i6 = 1;
        if (d.k0.d.t.compare((int) cCharAt, 48) >= 0) {
            z = false;
            i6 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i5 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z = false;
            }
        }
        int i7 = -59652323;
        while (i6 < length) {
            int iDigitOf = c.digitOf(str.charAt(i6), i2);
            if (iDigitOf < 0) {
                return null;
            }
            if ((i4 < i7 && (i7 != -59652323 || i4 < (i7 = i5 / i2))) || (i3 = i4 * i2) < i5 + iDigitOf) {
                return null;
            }
            i4 = i3 - iDigitOf;
            i6++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    public static final Long toLongOrNull(String str, int i2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$toLongOrNull");
        c.checkRadix(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        long j = -9223372036854775807L;
        boolean z = true;
        if (d.k0.d.t.compare((int) cCharAt, 48) >= 0) {
            z = false;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j = Long.MIN_VALUE;
                i3 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                i3 = 1;
                z = false;
            }
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i3 < length) {
            int iDigitOf = c.digitOf(str.charAt(i3), i2);
            if (iDigitOf < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 == j2) {
                    j4 = j / ((long) i2);
                    if (j3 < j4) {
                    }
                }
                return null;
            }
            long j5 = j3 * ((long) i2);
            long j6 = iDigitOf;
            if (j5 < j + j6) {
                return null;
            }
            j3 = j5 - j6;
            i3++;
            j2 = -256204778801521550L;
        }
        return z ? Long.valueOf(j3) : Long.valueOf(-j3);
    }

    public static final Short toShortOrNull(String str, int i2) {
        int iIntValue;
        d.k0.d.t.checkNotNullParameter(str, "$this$toShortOrNull");
        Integer intOrNull = toIntOrNull(str, i2);
        if (intOrNull == null || (iIntValue = intOrNull.intValue()) < -32768 || iIntValue > 32767) {
            return null;
        }
        return Short.valueOf((short) iIntValue);
    }
}
