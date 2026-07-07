package d.p0;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import d.k0.d.h0;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class x extends w {
    public static final String capitalize(String str) {
        d.k0.d.t.checkNotNullParameter(str, "$this$capitalize");
        Locale locale = Locale.getDefault();
        d.k0.d.t.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        return capitalize(str, locale);
    }

    public static final int compareTo(String str, String str2, boolean z) {
        d.k0.d.t.checkNotNullParameter(str, "$this$compareTo");
        d.k0.d.t.checkNotNullParameter(str2, "other");
        return z ? str.compareToIgnoreCase(str2) : str.compareTo(str2);
    }

    public static /* synthetic */ int compareTo$default(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return compareTo(str, str2, z);
    }

    public static final String concatToString(char[] cArr) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$concatToString");
        return new String(cArr);
    }

    public static /* synthetic */ String concatToString$default(char[] cArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = cArr.length;
        }
        return concatToString(cArr, i2, i3);
    }

    public static final String decapitalize(String str) {
        d.k0.d.t.checkNotNullParameter(str, "$this$decapitalize");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase();
        d.k0.d.t.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        d.k0.d.t.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    public static final String decodeToString(byte[] bArr) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$decodeToString");
        return new String(bArr, e.f12897a);
    }

    public static /* synthetic */ String decodeToString$default(byte[] bArr, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return decodeToString(bArr, i2, i3, z);
    }

    public static final byte[] encodeToByteArray(String str) {
        d.k0.d.t.checkNotNullParameter(str, "$this$encodeToByteArray");
        byte[] bytes = str.getBytes(e.f12897a);
        d.k0.d.t.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            z = false;
        }
        return encodeToByteArray(str, i2, i3, z);
    }

    public static final boolean endsWith(String str, String str2, boolean z) {
        d.k0.d.t.checkNotNullParameter(str, "$this$endsWith");
        d.k0.d.t.checkNotNullParameter(str2, "suffix");
        return !z ? str.endsWith(str2) : regionMatches(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return endsWith(str, str2, z);
    }

    public static final boolean equals(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean equals$default(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return equals(str, str2, z);
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(h0 h0Var) {
        d.k0.d.t.checkNotNullParameter(h0Var, "$this$CASE_INSENSITIVE_ORDER");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        d.k0.d.t.checkNotNullExpressionValue(comparator, "java.lang.String.CASE_INSENSITIVE_ORDER");
        return comparator;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isBlank(java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "$this$isBlank"
            d.k0.d.t.checkNotNullParameter(r4, r0)
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L3e
            d.m0.k r0 = d.p0.y.getIndices(r4)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L20
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L20
        L1e:
            r4 = 1
            goto L3c
        L20:
            java.util.Iterator r0 = r0.iterator()
        L24:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L1e
            r3 = r0
            d.g0.l0 r3 = (d.g0.l0) r3
            int r3 = r3.nextInt()
            char r3 = r4.charAt(r3)
            boolean r3 = d.p0.c.isWhitespace(r3)
            if (r3 != 0) goto L24
            r4 = 0
        L3c:
            if (r4 == 0) goto L3f
        L3e:
            r1 = 1
        L3f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.p0.x.isBlank(java.lang.CharSequence):boolean");
    }

    public static final boolean regionMatches(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$regionMatches");
        d.k0.d.t.checkNotNullParameter(charSequence2, "other");
        return ((charSequence instanceof String) && (charSequence2 instanceof String)) ? regionMatches((String) charSequence, i2, (String) charSequence2, i3, i4, z) : y.regionMatchesImpl(charSequence, i2, charSequence2, i3, i4, z);
    }

    public static final String repeat(CharSequence charSequence, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$repeat");
        int i3 = 1;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i2 + '.').toString());
        }
        if (i2 == 0) {
            return "";
        }
        if (i2 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                cArr[i4] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i2);
        if (1 <= i2) {
            while (true) {
                sb.append(charSequence);
                if (i3 == i2) {
                    break;
                }
                i3++;
            }
        }
        String string = sb.toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    public static final String replace(String str, char c2, char c3, boolean z) {
        d.k0.d.t.checkNotNullParameter(str, "$this$replace");
        if (!z) {
            String strReplace = str.replace(c2, c3);
            d.k0.d.t.checkNotNullExpressionValue(strReplace, "(this as java.lang.Strin…replace(oldChar, newChar)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (d.equals(cCharAt, c2, z)) {
                cCharAt = c3;
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String replace$default(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return replace(str, c2, c3, z);
    }

    public static final String replaceFirst(String str, char c2, char c3, boolean z) {
        d.k0.d.t.checkNotNullParameter(str, "$this$replaceFirst");
        int iIndexOf$default = y.indexOf$default(str, c2, 0, z, 2, (Object) null);
        return iIndexOf$default < 0 ? str : y.replaceRange(str, iIndexOf$default, iIndexOf$default + 1, String.valueOf(c3)).toString();
    }

    public static /* synthetic */ String replaceFirst$default(String str, char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return replaceFirst(str, c2, c3, z);
    }

    public static final List<String> split(CharSequence charSequence, Pattern pattern, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, "$this$split");
        d.k0.d.t.checkNotNullParameter(pattern, "regex");
        if (i2 >= 0) {
            if (i2 == 0) {
                i2 = -1;
            }
            String[] strArrSplit = pattern.split(charSequence, i2);
            d.k0.d.t.checkNotNullExpressionValue(strArrSplit, "regex.split(this, if (limit == 0) -1 else limit)");
            return d.g0.l.asList(strArrSplit);
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, Pattern pattern, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return split(charSequence, pattern, i2);
    }

    public static final boolean startsWith(String str, String str2, boolean z) {
        d.k0.d.t.checkNotNullParameter(str, "$this$startsWith");
        d.k0.d.t.checkNotNullParameter(str2, RequestParameters.PREFIX);
        return !z ? str.startsWith(str2) : regionMatches(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return startsWith(str, str2, z);
    }

    public static final char[] toCharArray(String str, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(str, "$this$toCharArray");
        d.g0.d.f12454a.checkBoundsIndexes$kotlin_stdlib(i2, i3, str.length());
        char[] cArr = new char[i3 - i2];
        str.getChars(i2, i3, cArr, 0);
        return cArr;
    }

    public static /* synthetic */ char[] toCharArray$default(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return toCharArray(str, i2, i3);
    }

    public static final String capitalize(String str, Locale locale) {
        d.k0.d.t.checkNotNullParameter(str, "$this$capitalize");
        d.k0.d.t.checkNotNullParameter(locale, "locale");
        if (!(str.length() > 0)) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if (!Character.isLowerCase(cCharAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char titleCase = Character.toTitleCase(cCharAt);
        if (titleCase != Character.toUpperCase(cCharAt)) {
            sb.append(titleCase);
        } else {
            String strSubstring = str.substring(0, 1);
            d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strSubstring.toUpperCase(locale);
            d.k0.d.t.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
        }
        String strSubstring2 = str.substring(1);
        d.k0.d.t.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        String string = sb.toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static final String concatToString(char[] cArr, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(cArr, "$this$concatToString");
        d.g0.d.f12454a.checkBoundsIndexes$kotlin_stdlib(i2, i3, cArr.length);
        return new String(cArr, i2, i3 - i2);
    }

    public static final String decapitalize(String str, Locale locale) {
        d.k0.d.t.checkNotNullParameter(str, "$this$decapitalize");
        d.k0.d.t.checkNotNullParameter(locale, "locale");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(0, 1);
        d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        d.k0.d.t.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        sb.append(lowerCase);
        String strSubstring2 = str.substring(1);
        d.k0.d.t.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring2);
        return sb.toString();
    }

    public static final String decodeToString(byte[] bArr, int i2, int i3, boolean z) {
        d.k0.d.t.checkNotNullParameter(bArr, "$this$decodeToString");
        d.g0.d.f12454a.checkBoundsIndexes$kotlin_stdlib(i2, i3, bArr.length);
        if (!z) {
            return new String(bArr, i2, i3 - i2, e.f12897a);
        }
        String string = e.f12897a.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i2, i3 - i2)).toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return string;
    }

    public static final byte[] encodeToByteArray(String str, int i2, int i3, boolean z) throws CharacterCodingException {
        d.k0.d.t.checkNotNullParameter(str, "$this$encodeToByteArray");
        d.g0.d.f12454a.checkBoundsIndexes$kotlin_stdlib(i2, i3, str.length());
        if (!z) {
            String strSubstring = str.substring(i2, i3);
            d.k0.d.t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Charset charset = e.f12897a;
            Objects.requireNonNull(strSubstring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = strSubstring.getBytes(charset);
            d.k0.d.t.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        ByteBuffer byteBufferEncode = e.f12897a.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i2, i3));
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0) {
            int iRemaining = byteBufferEncode.remaining();
            byte[] bArrArray = byteBufferEncode.array();
            d.k0.d.t.checkNotNull(bArrArray);
            if (iRemaining == bArrArray.length) {
                byte[] bArrArray2 = byteBufferEncode.array();
                d.k0.d.t.checkNotNullExpressionValue(bArrArray2, "byteBuffer.array()");
                return bArrArray2;
            }
        }
        byte[] bArr = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr);
        return bArr;
    }

    public static /* synthetic */ String replace$default(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return replace(str, str2, str3, z);
    }

    public static /* synthetic */ String replaceFirst$default(String str, String str2, String str3, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return replaceFirst(str, str2, str3, z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        return startsWith(str, str2, i2, z);
    }

    public static final String replaceFirst(String str, String str2, String str3, boolean z) {
        d.k0.d.t.checkNotNullParameter(str, "$this$replaceFirst");
        d.k0.d.t.checkNotNullParameter(str2, "oldValue");
        d.k0.d.t.checkNotNullParameter(str3, "newValue");
        int iIndexOf$default = y.indexOf$default(str, str2, 0, z, 2, (Object) null);
        return iIndexOf$default < 0 ? str : y.replaceRange(str, iIndexOf$default, str2.length() + iIndexOf$default, str3).toString();
    }

    public static final boolean startsWith(String str, String str2, int i2, boolean z) {
        d.k0.d.t.checkNotNullParameter(str, "$this$startsWith");
        d.k0.d.t.checkNotNullParameter(str2, RequestParameters.PREFIX);
        if (!z) {
            return str.startsWith(str2, i2);
        }
        return regionMatches(str, i2, str2, 0, str2.length(), z);
    }

    public static final boolean regionMatches(String str, int i2, String str2, int i3, int i4, boolean z) {
        d.k0.d.t.checkNotNullParameter(str, "$this$regionMatches");
        d.k0.d.t.checkNotNullParameter(str2, "other");
        if (!z) {
            return str.regionMatches(i2, str2, i3, i4);
        }
        return str.regionMatches(z, i2, str2, i3, i4);
    }

    public static final String replace(String str, String str2, String str3, boolean z) {
        d.k0.d.t.checkNotNullParameter(str, "$this$replace");
        d.k0.d.t.checkNotNullParameter(str2, "oldValue");
        d.k0.d.t.checkNotNullParameter(str3, "newValue");
        int i2 = 0;
        int iIndexOf = y.indexOf(str, str2, 0, z);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str2.length();
        int iCoerceAtLeast = d.m0.p.coerceAtLeast(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i2, iIndexOf);
                sb.append(str3);
                i2 = iIndexOf + length;
                if (iIndexOf >= str.length()) {
                    break;
                }
                iIndexOf = y.indexOf(str, str2, iIndexOf + iCoerceAtLeast, z);
            } while (iIndexOf > 0);
            sb.append((CharSequence) str, i2, str.length());
            String string = sb.toString();
            d.k0.d.t.checkNotNullExpressionValue(string, "stringBuilder.append(this, i, length).toString()");
            return string;
        }
        throw new OutOfMemoryError();
    }
}
