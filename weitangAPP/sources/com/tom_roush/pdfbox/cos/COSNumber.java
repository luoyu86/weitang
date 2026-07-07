package com.tom_roush.pdfbox.cos;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class COSNumber extends COSBase {

    @Deprecated
    public static final COSInteger ZERO = COSInteger.ZERO;

    @Deprecated
    public static final COSInteger ONE = COSInteger.ONE;

    public static COSNumber get(String str) throws IOException {
        if (str.length() != 1) {
            if (isFloat(str)) {
                return new COSFloat(str);
            }
            try {
                return str.charAt(0) == '+' ? COSInteger.get(Long.parseLong(str.substring(1))) : COSInteger.get(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                if (((str.startsWith("+") || str.startsWith("-")) ? str.substring(1) : str).matches("[0-9]*")) {
                    return str.startsWith("-") ? COSInteger.OUT_OF_RANGE_MIN : COSInteger.OUT_OF_RANGE_MAX;
                }
                throw new IOException("Not a number: " + str);
            }
        }
        char cCharAt = str.charAt(0);
        if ('0' <= cCharAt && cCharAt <= '9') {
            return COSInteger.get(((long) cCharAt) - 48);
        }
        if (cCharAt == '-' || cCharAt == '.') {
            return COSInteger.ZERO;
        }
        throw new IOException("Not a number: " + str);
    }

    private static boolean isFloat(String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '.' || cCharAt == 'e') {
                return true;
            }
        }
        return false;
    }

    public abstract double doubleValue();

    public abstract float floatValue();

    public abstract int intValue();

    public abstract long longValue();
}
