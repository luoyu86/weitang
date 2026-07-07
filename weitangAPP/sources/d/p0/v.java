package d.p0;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/* JADX INFO: loaded from: classes2.dex */
public class v extends u {
    public static final BigDecimal toBigDecimalOrNull(String str) {
        d.k0.d.t.checkNotNullParameter(str, "$this$toBigDecimalOrNull");
        try {
            if (o.f12938a.matches(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final BigInteger toBigIntegerOrNull(String str) {
        d.k0.d.t.checkNotNullParameter(str, "$this$toBigIntegerOrNull");
        return toBigIntegerOrNull(str, 10);
    }

    public static final Double toDoubleOrNull(String str) {
        d.k0.d.t.checkNotNullParameter(str, "$this$toDoubleOrNull");
        try {
            if (o.f12938a.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final Float toFloatOrNull(String str) {
        d.k0.d.t.checkNotNullParameter(str, "$this$toFloatOrNull");
        try {
            if (o.f12938a.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static final BigInteger toBigIntegerOrNull(String str, int i2) {
        d.k0.d.t.checkNotNullParameter(str, "$this$toBigIntegerOrNull");
        c.checkRadix(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i3 = str.charAt(0) == '-' ? 1 : 0; i3 < length; i3++) {
                if (c.digitOf(str.charAt(i3), i2) < 0) {
                    return null;
                }
            }
        } else if (c.digitOf(str.charAt(0), i2) < 0) {
            return null;
        }
        return new BigInteger(str, c.checkRadix(i2));
    }

    public static final BigDecimal toBigDecimalOrNull(String str, MathContext mathContext) {
        d.k0.d.t.checkNotNullParameter(str, "$this$toBigDecimalOrNull");
        d.k0.d.t.checkNotNullParameter(mathContext, "mathContext");
        try {
            if (o.f12938a.matches(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}
