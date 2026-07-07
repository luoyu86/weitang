package d.p0;

import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static final int checkRadix(int i2) {
        if (2 <= i2 && 36 >= i2) {
            return i2;
        }
        throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new d.m0.k(2, 36));
    }

    public static final int digitOf(char c2, int i2) {
        return Character.digit((int) c2, i2);
    }

    public static final a getCategory(char c2) {
        return a.Companion.valueOf(Character.getType(c2));
    }

    public static final b getDirectionality(char c2) {
        return b.Companion.valueOf(Character.getDirectionality(c2));
    }

    public static final boolean isWhitespace(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    public static final String lowercase(char c2, Locale locale) {
        d.k0.d.t.checkNotNullParameter(locale, "locale");
        String strValueOf = String.valueOf(c2);
        Objects.requireNonNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(locale);
        d.k0.d.t.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    public static final String titlecase(char c2) {
        String strValueOf = String.valueOf(c2);
        Objects.requireNonNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = strValueOf.toUpperCase(locale);
        d.k0.d.t.checkNotNullExpressionValue(upperCase, "(this as java.lang.Strin….toUpperCase(Locale.ROOT)");
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c2));
        }
        if (c2 == 329) {
            return upperCase;
        }
        char cCharAt = upperCase.charAt(0);
        String strSubstring = upperCase.substring(1);
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        d.k0.d.t.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
        return String.valueOf(cCharAt) + lowerCase;
    }

    public static final String uppercase(char c2, Locale locale) {
        d.k0.d.t.checkNotNullParameter(locale, "locale");
        String strValueOf = String.valueOf(c2);
        Objects.requireNonNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(locale);
        d.k0.d.t.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    public static final String titlecase(char c2, Locale locale) {
        d.k0.d.t.checkNotNullParameter(locale, "locale");
        String strUppercase = uppercase(c2, locale);
        if (strUppercase.length() <= 1) {
            String strValueOf = String.valueOf(c2);
            Objects.requireNonNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            d.k0.d.t.checkNotNullExpressionValue(upperCase, "(this as java.lang.Strin….toUpperCase(Locale.ROOT)");
            return d.k0.d.t.areEqual(strUppercase, upperCase) ^ true ? strUppercase : String.valueOf(Character.toTitleCase(c2));
        }
        if (c2 == 329) {
            return strUppercase;
        }
        char cCharAt = strUppercase.charAt(0);
        String strSubstring = strUppercase.substring(1);
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        d.k0.d.t.checkNotNullExpressionValue(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
        return String.valueOf(cCharAt) + lowerCase;
    }
}
