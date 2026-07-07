package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public final class JSONLexer {
    public static final char[] CA;
    public static final int END = 4;
    public static final char EOI = 26;
    public static final int[] IA;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int UNKNOWN = 0;
    private static boolean V6 = false;
    public static final int VALUE = 3;
    public static final int[] digits;
    public static final boolean[] firstIdentifierFlags;
    public static final boolean[] identifierFlags;
    private static final ThreadLocal<char[]> sbufLocal;
    public int bp;
    public Calendar calendar;
    public char ch;
    public boolean disableCircularReferenceDetect;
    public int eofPos;
    public boolean exp;
    public int features;
    public long fieldHash;
    public boolean hasSpecial;
    public boolean isDouble;
    public final int len;
    public Locale locale;
    public int matchStat;
    public int np;
    public int pos;
    public char[] sbuf;
    public int sp;
    public String stringDefaultValue;
    public final String text;
    public TimeZone timeZone;
    public int token;

    static {
        int i2;
        try {
            i2 = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
        } catch (Exception unused) {
            i2 = -1;
        }
        char c2 = 0;
        V6 = i2 >= 23;
        sbufLocal = new ThreadLocal<>();
        digits = new int[103];
        for (int i3 = 48; i3 <= 57; i3++) {
            digits[i3] = i3 - 48;
        }
        for (int i4 = 97; i4 <= 102; i4++) {
            digits[i4] = (i4 - 97) + 10;
        }
        for (int i5 = 65; i5 <= 70; i5++) {
            digits[i5] = (i5 - 65) + 10;
        }
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i6 = 0; i6 < length; i6++) {
            IA[CA[i6]] = i6;
        }
        IA[61] = 0;
        firstIdentifierFlags = new boolean[256];
        char c3 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c3 >= zArr.length) {
                break;
            }
            if (c3 >= 'A' && c3 <= 'Z') {
                zArr[c3] = true;
            } else if (c3 >= 'a' && c3 <= 'z') {
                zArr[c3] = true;
            } else if (c3 == '_') {
                zArr[c3] = true;
            }
            c3 = (char) (c3 + 1);
        }
        identifierFlags = new boolean[256];
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c2 >= zArr2.length) {
                return;
            }
            if (c2 >= 'A' && c2 <= 'Z') {
                zArr2[c2] = true;
            } else if (c2 >= 'a' && c2 <= 'z') {
                zArr2[c2] = true;
            } else if (c2 == '_') {
                zArr2[c2] = true;
            } else if (c2 >= '0' && c2 <= '9') {
                zArr2[c2] = true;
            }
            c2 = (char) (c2 + 1);
        }
    }

    public JSONLexer(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public static boolean checkDate(char c2, char c3, char c4, char c5, char c6, char c7, int i2, int i3) {
        if (c2 >= '1' && c2 <= '3' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9' && c5 >= '0' && c5 <= '9') {
            if (c6 == '0') {
                if (c7 < '1' || c7 > '9') {
                    return false;
                }
            } else if (c6 != '1' || (c7 != '0' && c7 != '1' && c7 != '2')) {
                return false;
            }
            if (i2 == 48) {
                return i3 >= 49 && i3 <= 57;
            }
            if (i2 != 49 && i2 != 50) {
                return i2 == 51 && (i3 == 48 || i3 == 49);
            }
            if (i3 >= 48 && i3 <= 57) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkTime(char c2, char c3, char c4, char c5, char c6, char c7) {
        if (c2 == '0') {
            if (c3 < '0' || c3 > '9') {
                return false;
            }
        } else {
            if (c2 != '1') {
                if (c2 == '2' && c3 >= '0' && c3 <= '4') {
                }
                return false;
            }
            if (c3 < '0' || c3 > '9') {
                return false;
            }
        }
        if (c4 < '0' || c4 > '5') {
            if (c4 != '6' || c5 != '0') {
                return false;
            }
        } else if (c5 < '0' || c5 > '9') {
            return false;
        }
        return (c6 < '0' || c6 > '5') ? c6 == '6' && c7 == '0' : c7 >= '0' && c7 <= '9';
    }

    public static final byte[] decodeFast(String str, int i2, int i3) {
        int i4;
        int i5 = 0;
        if (i3 == 0) {
            return new byte[0];
        }
        int i6 = (i2 + i3) - 1;
        while (i2 < i6 && IA[str.charAt(i2)] < 0) {
            i2++;
        }
        while (i6 > 0 && IA[str.charAt(i6)] < 0) {
            i6--;
        }
        int i7 = str.charAt(i6) == '=' ? str.charAt(i6 + (-1)) == '=' ? 2 : 1 : 0;
        int i8 = (i6 - i2) + 1;
        if (i3 > 76) {
            i4 = (str.charAt(76) == '\r' ? i8 / 78 : 0) << 1;
        } else {
            i4 = 0;
        }
        int i9 = (((i8 - i4) * 6) >> 3) - i7;
        byte[] bArr = new byte[i9];
        int i10 = (i9 / 3) * 3;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10) {
            int[] iArr = IA;
            int i13 = i2 + 1;
            int i14 = i13 + 1;
            int i15 = (iArr[str.charAt(i2)] << 18) | (iArr[str.charAt(i13)] << 12);
            int i16 = i14 + 1;
            int i17 = i15 | (iArr[str.charAt(i14)] << 6);
            int i18 = i16 + 1;
            int i19 = i17 | iArr[str.charAt(i16)];
            int i20 = i11 + 1;
            bArr[i11] = (byte) (i19 >> 16);
            int i21 = i20 + 1;
            bArr[i20] = (byte) (i19 >> 8);
            int i22 = i21 + 1;
            bArr[i21] = (byte) i19;
            if (i4 <= 0 || (i12 = i12 + 1) != 19) {
                i2 = i18;
            } else {
                i2 = i18 + 2;
                i12 = 0;
            }
            i11 = i22;
        }
        if (i11 < i9) {
            int i23 = 0;
            while (i2 <= i6 - i7) {
                i5 |= IA[str.charAt(i2)] << (18 - (i23 * 6));
                i23++;
                i2++;
            }
            int i24 = 16;
            while (i11 < i9) {
                bArr[i11] = (byte) (i5 >> i24);
                i24 -= 8;
                i11++;
            }
        }
        return bArr;
    }

    private int matchFieldHash(long j) {
        char cCharAt = this.ch;
        int i2 = 1;
        while (cCharAt != '\"' && cCharAt != '\'') {
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t' && cCharAt != '\f' && cCharAt != '\b') {
                this.fieldHash = 0L;
                this.matchStat = -2;
                return 0;
            }
            int i3 = i2 + 1;
            int i4 = this.bp + i2;
            cCharAt = i4 >= this.len ? EOI : this.text.charAt(i4);
            i2 = i3;
        }
        long j2 = -3750763034362895579L;
        int i5 = this.bp + i2;
        while (true) {
            if (i5 >= this.len) {
                break;
            }
            char cCharAt2 = this.text.charAt(i5);
            if (cCharAt2 == cCharAt) {
                i2 += (i5 - this.bp) - i2;
                break;
            }
            j2 = 1099511628211L * (((long) cCharAt2) ^ j2);
            i5++;
        }
        if (j2 != j) {
            this.fieldHash = j2;
            this.matchStat = -2;
            return 0;
        }
        int i6 = i2 + 1;
        int i7 = this.bp + i6;
        char cCharAt3 = i7 >= this.len ? EOI : this.text.charAt(i7);
        while (cCharAt3 != ':') {
            if (cCharAt3 > ' ' || !(cCharAt3 == ' ' || cCharAt3 == '\n' || cCharAt3 == '\r' || cCharAt3 == '\t' || cCharAt3 == '\f' || cCharAt3 == '\b')) {
                throw new JSONException("match feild error expect ':'");
            }
            int i8 = i6 + 1;
            int i9 = this.bp + i6;
            cCharAt3 = i9 >= this.len ? EOI : this.text.charAt(i9);
            i6 = i8;
        }
        return i6 + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String readString(char[] r12, int r13) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.readString(char[], int):java.lang.String");
    }

    private void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String strStringVal = stringVal();
        if (strStringVal.equals("null")) {
            this.token = 8;
            return;
        }
        if (strStringVal.equals("true")) {
            this.token = 6;
            return;
        }
        if (strStringVal.equals("false")) {
            this.token = 7;
            return;
        }
        if (strStringVal.equals("new")) {
            this.token = 9;
            return;
        }
        if (strStringVal.equals("undefined")) {
            this.token = 23;
            return;
        }
        if (strStringVal.equals("Set")) {
            this.token = 21;
        } else if (strStringVal.equals("TreeSet")) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    private void setCalendar(char c2, char c3, char c4, char c5, char c6, char c7, char c8, char c9) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c2 - '0') * 1000) + ((c3 - '0') * 100) + ((c4 - '0') * 10) + (c5 - '0'));
        this.calendar.set(2, (((c6 - '0') * 10) + (c7 - '0')) - 1);
        this.calendar.set(5, ((c8 - '0') * 10) + (c9 - '0'));
    }

    private final String subString(int i2, int i3) {
        char[] cArr = this.sbuf;
        if (i3 < cArr.length) {
            this.text.getChars(i2, i2 + i3, cArr, 0);
            return new String(this.sbuf, 0, i3);
        }
        char[] cArr2 = new char[i3];
        this.text.getChars(i2, i3 + i2, cArr2, 0);
        return new String(cArr2);
    }

    public byte[] bytesValue() {
        return decodeFast(this.text, this.np + 1, this.sp);
    }

    public char charAt(int i2) {
        return i2 >= this.len ? EOI : this.text.charAt(i2);
    }

    public void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8196) {
            sbufLocal.set(cArr);
        }
        this.sbuf = null;
    }

    public final void config(Feature feature, boolean z) {
        if (z) {
            this.features |= feature.mask;
        } else {
            this.features &= ~feature.mask;
        }
        if (feature == Feature.InitStringFieldAsEmpty) {
            this.stringDefaultValue = z ? "" : null;
        }
        this.disableCircularReferenceDetect = (this.features & Feature.DisableCircularReferenceDetect.mask) != 0;
    }

    public final Number decimalValue(boolean z) {
        char[] cArr;
        boolean z2;
        int i2 = (this.np + this.sp) - 1;
        char cCharAt = i2 >= this.len ? EOI : this.text.charAt(i2);
        try {
            if (cCharAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (cCharAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            if (z) {
                return decimalValue();
            }
            char cCharAt2 = this.text.charAt((this.np + this.sp) - 1);
            int i3 = this.sp;
            if (cCharAt2 == 'L' || cCharAt2 == 'S' || cCharAt2 == 'B' || cCharAt2 == 'F' || cCharAt2 == 'D') {
                i3--;
            }
            int i4 = this.np;
            char[] cArr2 = this.sbuf;
            int i5 = 0;
            if (i3 < cArr2.length) {
                this.text.getChars(i4, i4 + i3, cArr2, 0);
                cArr = this.sbuf;
            } else {
                char[] cArr3 = new char[i3];
                this.text.getChars(i4, i4 + i3, cArr3, 0);
                cArr = cArr3;
            }
            if (i3 > 9 || this.exp) {
                return Double.valueOf(Double.parseDouble(new String(cArr, 0, i3)));
            }
            char c2 = cArr[0];
            int i6 = 2;
            if (c2 == '-') {
                c2 = cArr[1];
                z2 = true;
            } else if (c2 == '+') {
                c2 = cArr[1];
                z2 = false;
            } else {
                z2 = false;
                i6 = 1;
            }
            int i7 = c2 - '0';
            while (i6 < i3) {
                char c3 = cArr[i6];
                if (c3 == '.') {
                    i5 = 1;
                } else {
                    i7 = (i7 * 10) + (c3 - '0');
                    if (i5 != 0) {
                        i5 *= 10;
                    }
                }
                i6++;
            }
            double d2 = ((double) i7) / ((double) i5);
            if (z2) {
                d2 = -d2;
            }
            return Double.valueOf(d2);
        } catch (NumberFormatException e2) {
            throw new JSONException(e2.getMessage() + ", " + info());
        }
    }

    public String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", json : ");
        sb.append(this.len < 65536 ? this.text : this.text.substring(0, 65536));
        return sb.toString();
    }

    public final int intValue() {
        int i2;
        boolean z;
        int i3 = this.np;
        int i4 = this.sp + i3;
        int i5 = 0;
        if ((i3 >= this.len ? EOI : this.text.charAt(i3)) == '-') {
            i2 = Integer.MIN_VALUE;
            i3++;
            z = true;
        } else {
            i2 = -2147483647;
            z = false;
        }
        if (i3 < i4) {
            i5 = -((i3 >= this.len ? EOI : this.text.charAt(i3)) - '0');
            i3++;
        }
        while (i3 < i4) {
            int i6 = i3 + 1;
            char cCharAt = i3 >= this.len ? EOI : this.text.charAt(i3);
            if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B') {
                i3 = i6;
                break;
            }
            int i7 = cCharAt - '0';
            if (i5 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i8 = i5 * 10;
            if (i8 < i2 + i7) {
                throw new NumberFormatException(numberString());
            }
            i5 = i8 - i7;
            i3 = i6;
        }
        if (!z) {
            return -i5;
        }
        if (i3 > this.np + 1) {
            return i5;
        }
        throw new NumberFormatException(numberString());
    }

    public final Number integerValue() throws NumberFormatException {
        char c2;
        long j;
        boolean z;
        long j2;
        int i2 = this.np;
        int i3 = this.sp + i2;
        int i4 = i3 - 1;
        char cCharAt = i4 >= this.len ? EOI : this.text.charAt(i4);
        if (cCharAt == 'B') {
            i3--;
            c2 = 'B';
        } else if (cCharAt == 'L') {
            i3--;
            c2 = 'L';
        } else if (cCharAt != 'S') {
            c2 = ' ';
        } else {
            i3--;
            c2 = 'S';
        }
        int i5 = this.np;
        if ((i5 >= this.len ? EOI : this.text.charAt(i5)) == '-') {
            j = Long.MIN_VALUE;
            i2++;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        if (i2 < i3) {
            j2 = -((i2 >= this.len ? EOI : this.text.charAt(i2)) - '0');
            i2++;
        } else {
            j2 = 0;
        }
        while (i2 < i3) {
            int i6 = i2 + 1;
            int iCharAt = (i2 >= this.len ? EOI : this.text.charAt(i2)) - '0';
            if (j2 < -922337203685477580L) {
                return new BigInteger(numberString());
            }
            long j3 = j2 * 10;
            long j4 = iCharAt;
            if (j3 < j + j4) {
                return new BigInteger(numberString());
            }
            j2 = j3 - j4;
            i2 = i6;
        }
        if (!z) {
            long j5 = -j2;
            return (j5 > 2147483647L || c2 == 'L') ? Long.valueOf(j5) : c2 == 'S' ? Short.valueOf((short) j5) : c2 == 'B' ? Byte.valueOf((byte) j5) : Integer.valueOf((int) j5);
        }
        if (i2 > this.np + 1) {
            return (j2 < -2147483648L || c2 == 'L') ? Long.valueOf(j2) : c2 == 'S' ? Short.valueOf((short) j2) : c2 == 'B' ? Byte.valueOf((byte) j2) : Integer.valueOf((int) j2);
        }
        throw new NumberFormatException(numberString());
    }

    public final boolean isBlankInput() {
        int i2 = 0;
        while (true) {
            char cCharAt = charAt(i2);
            boolean z = true;
            if (cCharAt == 26) {
                return true;
            }
            if (cCharAt > ' ' || (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t' && cCharAt != '\f' && cCharAt != '\b')) {
                z = false;
            }
            if (!z) {
                return false;
            }
            i2++;
        }
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.mask & this.features) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x005e -> B:8:0x0026). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r13 = this;
            int r0 = r13.np
            int r1 = r13.sp
            int r1 = r1 + r0
            char r2 = r13.charAt(r0)
            r3 = 1
            r4 = 45
            if (r2 != r4) goto L14
            r4 = -9223372036854775808
            int r0 = r0 + 1
            r2 = 1
            goto L1a
        L14:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r2 = 0
        L1a:
            if (r0 >= r1) goto L28
            int r6 = r0 + 1
            char r0 = r13.charAt(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r7 = (long) r0
        L26:
            r0 = r6
            goto L2a
        L28:
            r7 = 0
        L2a:
            if (r0 >= r1) goto L75
            int r6 = r0 + 1
            int r9 = r13.len
            if (r0 < r9) goto L35
            r0 = 26
            goto L3b
        L35:
            java.lang.String r9 = r13.text
            char r0 = r9.charAt(r0)
        L3b:
            r9 = 76
            if (r0 == r9) goto L74
            r9 = 83
            if (r0 == r9) goto L74
            r9 = 66
            if (r0 != r9) goto L48
            goto L74
        L48:
            int r0 = r0 + (-48)
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L6a
            r9 = 10
            long r7 = r7 * r9
            long r9 = (long) r0
            long r11 = r4 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L60
            long r7 = r7 - r9
            goto L26
        L60:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L6a:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L74:
            r0 = r6
        L75:
            if (r2 == 0) goto L87
            int r1 = r13.np
            int r1 = r1 + r3
            if (r0 <= r1) goto L7d
            return r7
        L7d:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L87:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.longValue():long");
    }

    public boolean matchField(long j) {
        char cCharAt = this.ch;
        int i2 = this.bp + 1;
        int i3 = 1;
        while (cCharAt != '\"' && cCharAt != '\'') {
            if (cCharAt > ' ' || !(cCharAt == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\f' || cCharAt == '\b')) {
                this.fieldHash = 0L;
                this.matchStat = -2;
                return false;
            }
            int i4 = i3 + 1;
            int i5 = this.bp + i3;
            cCharAt = i5 >= this.len ? EOI : this.text.charAt(i5);
            i3 = i4;
        }
        int i6 = i2;
        long j2 = -3750763034362895579L;
        while (true) {
            if (i6 >= this.len) {
                break;
            }
            char cCharAt2 = this.text.charAt(i6);
            if (cCharAt2 == cCharAt) {
                i3 += (i6 - i2) + 1;
                break;
            }
            j2 = 1099511628211L * (j2 ^ ((long) cCharAt2));
            i6++;
        }
        if (j2 != j) {
            this.matchStat = -2;
            this.fieldHash = j2;
            return false;
        }
        int i7 = i3 + 1;
        int i8 = this.bp + i3;
        char cCharAt3 = i8 >= this.len ? EOI : this.text.charAt(i8);
        while (cCharAt3 != ':') {
            if (cCharAt3 > ' ' || !(cCharAt3 == ' ' || cCharAt3 == '\n' || cCharAt3 == '\r' || cCharAt3 == '\t' || cCharAt3 == '\f' || cCharAt3 == '\b')) {
                throw new JSONException("match feild error expect ':'");
            }
            int i9 = i7 + 1;
            int i10 = this.bp + i7;
            cCharAt3 = i10 >= this.len ? EOI : this.text.charAt(i10);
            i7 = i9;
        }
        int i11 = this.bp + i7;
        char cCharAt4 = i11 >= this.len ? EOI : this.text.charAt(i11);
        if (cCharAt4 == '{') {
            int i12 = i11 + 1;
            this.bp = i12;
            this.ch = i12 >= this.len ? EOI : this.text.charAt(i12);
            this.token = 12;
        } else if (cCharAt4 == '[') {
            int i13 = i11 + 1;
            this.bp = i13;
            this.ch = i13 >= this.len ? EOI : this.text.charAt(i13);
            this.token = 14;
        } else {
            this.bp = i11;
            this.ch = i11 >= this.len ? EOI : this.text.charAt(i11);
            nextToken();
        }
        return true;
    }

    public char next() {
        int i2 = this.bp + 1;
        this.bp = i2;
        char cCharAt = i2 >= this.len ? EOI : this.text.charAt(i2);
        this.ch = cCharAt;
        return cCharAt;
    }

    public final void nextIdent() {
        char c2;
        while (true) {
            c2 = this.ch;
            if (!(c2 <= ' ' && (c2 == ' ' || c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == '\f' || c2 == '\b'))) {
                break;
            } else {
                next();
            }
        }
        if (c2 == '_' || Character.isLetter(c2)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        scanNumber();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0103, code lost:
    
        scanIdent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0106, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void nextToken() {
        /*
            Method dump skipped, instruction units count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.nextToken():void");
    }

    public final void nextTokenWithChar(char c2) {
        this.sp = 0;
        while (true) {
            char c3 = this.ch;
            if (c3 == c2) {
                int i2 = this.bp + 1;
                this.bp = i2;
                this.ch = i2 >= this.len ? EOI : this.text.charAt(i2);
                nextToken();
                return;
            }
            if (c3 != ' ' && c3 != '\n' && c3 != '\r' && c3 != '\t' && c3 != '\f' && c3 != '\b') {
                throw new JSONException("not match " + c2 + " - " + this.ch);
            }
            next();
        }
    }

    public final String numberString() {
        char cCharAt = this.text.charAt((this.np + this.sp) - 1);
        int i2 = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i2--;
        }
        return subString(this.np, i2);
    }

    public boolean scanBoolean() {
        boolean z = false;
        int i2 = 1;
        if (this.text.startsWith("false", this.bp)) {
            i2 = 5;
        } else if (this.text.startsWith("true", this.bp)) {
            z = true;
            i2 = 4;
        } else {
            char c2 = this.ch;
            if (c2 == '1') {
                z = true;
            } else if (c2 != '0') {
                this.matchStat = -1;
                return false;
            }
        }
        int i3 = this.bp + i2;
        this.bp = i3;
        this.ch = charAt(i3);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean scanFieldBoolean(long r13) {
        /*
            Method dump skipped, instruction units count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldBoolean(long):boolean");
    }

    public Date scanFieldDate(long j) {
        int i2;
        char cCharAt;
        char cCharAt2;
        int i3;
        Date date;
        this.matchStat = 0;
        int iMatchFieldHash = matchFieldHash(j);
        if (iMatchFieldHash == 0) {
            return null;
        }
        int i4 = this.bp;
        char c2 = this.ch;
        int i5 = iMatchFieldHash + 1;
        int i6 = iMatchFieldHash + i4;
        int i7 = this.len;
        char cCharAt3 = EOI;
        char cCharAt4 = i6 >= i7 ? EOI : this.text.charAt(i6);
        if (cCharAt4 == '\"') {
            int i8 = this.bp;
            int i9 = i8 + i5;
            int i10 = i5 + 1;
            int i11 = i8 + i5;
            if (i11 < this.len) {
                this.text.charAt(i11);
            }
            int iIndexOf = this.text.indexOf(34, this.bp + i10);
            if (iIndexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int i12 = iIndexOf - i9;
            this.bp = i9;
            if (!scanISO8601DateIfMatch(false, i12)) {
                this.bp = i4;
                this.matchStat = -1;
                return null;
            }
            date = this.calendar.getTime();
            int i13 = i10 + i12;
            i3 = i13 + 1;
            cCharAt2 = charAt(i13 + i4);
            this.bp = i4;
        } else {
            if (cCharAt4 < '0' || cCharAt4 > '9') {
                this.matchStat = -1;
                return null;
            }
            long j2 = cCharAt4 - '0';
            while (true) {
                i2 = i5 + 1;
                int i14 = this.bp + i5;
                cCharAt = i14 >= this.len ? EOI : this.text.charAt(i14);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                j2 = (j2 * 10) + ((long) (cCharAt - '0'));
                i5 = i2;
            }
            if (cCharAt == '.') {
                this.matchStat = -1;
                return null;
            }
            if (cCharAt == '\"') {
                int i15 = i2 + 1;
                int i16 = this.bp + i2;
                cCharAt2 = i16 >= this.len ? EOI : this.text.charAt(i16);
                i3 = i15;
            } else {
                cCharAt2 = cCharAt;
                i3 = i2;
            }
            if (j2 < 0) {
                this.matchStat = -1;
                return null;
            }
            date = new Date(j2);
        }
        if (cCharAt2 == ',') {
            int i17 = this.bp + (i3 - 1);
            this.bp = i17;
            int i18 = i17 + 1;
            this.bp = i18;
            if (i18 < this.len) {
                cCharAt3 = this.text.charAt(i18);
            }
            this.ch = cCharAt3;
            this.matchStat = 3;
            this.token = 16;
            return date;
        }
        if (cCharAt2 != '}') {
            this.bp = i4;
            this.ch = c2;
            this.matchStat = -1;
            return null;
        }
        int i19 = i3 + 1;
        char cCharAt5 = charAt(this.bp + i3);
        if (cCharAt5 == ',') {
            this.token = 16;
            int i20 = this.bp + (i19 - 1);
            this.bp = i20;
            int i21 = i20 + 1;
            this.bp = i21;
            if (i21 < this.len) {
                cCharAt3 = this.text.charAt(i21);
            }
            this.ch = cCharAt3;
        } else if (cCharAt5 == ']') {
            this.token = 15;
            int i22 = this.bp + (i19 - 1);
            this.bp = i22;
            int i23 = i22 + 1;
            this.bp = i23;
            if (i23 < this.len) {
                cCharAt3 = this.text.charAt(i23);
            }
            this.ch = cCharAt3;
        } else if (cCharAt5 == '}') {
            this.token = 13;
            int i24 = this.bp + (i19 - 1);
            this.bp = i24;
            int i25 = i24 + 1;
            this.bp = i25;
            if (i25 < this.len) {
                cCharAt3 = this.text.charAt(i25);
            }
            this.ch = cCharAt3;
        } else {
            if (cCharAt5 != 26) {
                this.bp = i4;
                this.ch = c2;
                this.matchStat = -1;
                return null;
            }
            this.token = 20;
            this.bp += i19 - 1;
            this.ch = EOI;
        }
        this.matchStat = 4;
        return date;
    }

    public final double scanFieldDouble(long j) {
        int i2;
        char cCharAt;
        int i3;
        double d2;
        int i4;
        char cCharAt2;
        this.matchStat = 0;
        int iMatchFieldHash = matchFieldHash(j);
        if (iMatchFieldHash == 0) {
            return 0.0d;
        }
        int i5 = iMatchFieldHash + 1;
        char cCharAt3 = charAt(this.bp + iMatchFieldHash);
        int i6 = this.bp;
        int i7 = (i6 + i5) - 1;
        boolean z = cCharAt3 == '-';
        if (z) {
            char cCharAt4 = charAt(i6 + i5);
            i5++;
            cCharAt3 = cCharAt4;
        }
        if (cCharAt3 < '0' || cCharAt3 > '9') {
            this.matchStat = -1;
            return 0.0d;
        }
        int i8 = cCharAt3 - '0';
        while (true) {
            i2 = i5 + 1;
            cCharAt = charAt(this.bp + i5);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i8 = (i8 * 10) + (cCharAt - '0');
            i5 = i2;
        }
        if (cCharAt == '.') {
            int i9 = i2 + 1;
            char cCharAt5 = charAt(this.bp + i2);
            if (cCharAt5 < '0' || cCharAt5 > '9') {
                this.matchStat = -1;
                return 0.0d;
            }
            i8 = (i8 * 10) + (cCharAt5 - '0');
            int i10 = 10;
            while (true) {
                i4 = i9 + 1;
                cCharAt2 = charAt(this.bp + i9);
                if (cCharAt2 < '0' || cCharAt2 > '9') {
                    break;
                }
                i8 = (i8 * 10) + (cCharAt2 - '0');
                i10 *= 10;
                i9 = i4;
            }
            i2 = i4;
            i3 = i10;
            cCharAt = cCharAt2;
        } else {
            i3 = 1;
        }
        boolean z2 = cCharAt == 'e' || cCharAt == 'E';
        if (z2) {
            int i11 = i2 + 1;
            cCharAt = charAt(this.bp + i2);
            if (cCharAt == '+' || cCharAt == '-') {
                int i12 = i11 + 1;
                cCharAt = charAt(this.bp + i11);
                i2 = i12;
            } else {
                i2 = i11;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                int i13 = i2 + 1;
                cCharAt = charAt(this.bp + i2);
                i2 = i13;
            }
        }
        int i14 = ((this.bp + i2) - i7) - 1;
        if (z2 || i14 >= 10) {
            d2 = Double.parseDouble(subString(i7, i14));
        } else {
            d2 = ((double) i8) / ((double) i3);
            if (z) {
                d2 = -d2;
            }
        }
        if (cCharAt == ',') {
            this.bp += i2 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return d2;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0.0d;
        }
        int i15 = i2 + 1;
        char cCharAt6 = charAt(this.bp + i2);
        if (cCharAt6 == ',') {
            this.token = 16;
            this.bp += i15 - 1;
            next();
        } else if (cCharAt6 == ']') {
            this.token = 15;
            this.bp += i15 - 1;
            next();
        } else if (cCharAt6 == '}') {
            this.token = 13;
            this.bp += i15 - 1;
            next();
        } else {
            if (cCharAt6 != 26) {
                this.matchStat = -1;
                return 0.0d;
            }
            this.bp += i15 - 1;
            this.token = 20;
            this.ch = EOI;
        }
        this.matchStat = 4;
        return d2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x021c, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x021e, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d3, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d5, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010d A[PHI: r4
  0x010d: PHI (r4v24 int) = (r4v23 int), (r4v28 int) binds: [B:81:0x010b, B:88:0x0125] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0116 -> B:85:0x0119). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double[] scanFieldDoubleArray(long r20) {
        /*
            Method dump skipped, instruction units count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDoubleArray(long):double[]");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:88:0x012b
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final double[][] scanFieldDoubleArray2(long r21) {
        /*
            Method dump skipped, instruction units count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDoubleArray2(long):double[][]");
    }

    public final float scanFieldFloat(long j) {
        int i2;
        char cCharAt;
        int i3;
        float f2;
        int i4;
        char cCharAt2;
        this.matchStat = 0;
        int iMatchFieldHash = matchFieldHash(j);
        if (iMatchFieldHash == 0) {
            return 0.0f;
        }
        int i5 = iMatchFieldHash + 1;
        char cCharAt3 = charAt(this.bp + iMatchFieldHash);
        int i6 = this.bp;
        int i7 = (i6 + i5) - 1;
        boolean z = cCharAt3 == '-';
        if (z) {
            char cCharAt4 = charAt(i6 + i5);
            i5++;
            cCharAt3 = cCharAt4;
        }
        if (cCharAt3 < '0' || cCharAt3 > '9') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i8 = cCharAt3 - '0';
        while (true) {
            i2 = i5 + 1;
            cCharAt = charAt(this.bp + i5);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i8 = (i8 * 10) + (cCharAt - '0');
            i5 = i2;
        }
        if (cCharAt == '.') {
            int i9 = i2 + 1;
            char cCharAt5 = charAt(this.bp + i2);
            if (cCharAt5 < '0' || cCharAt5 > '9') {
                this.matchStat = -1;
                return 0.0f;
            }
            i8 = (i8 * 10) + (cCharAt5 - '0');
            int i10 = 10;
            while (true) {
                i4 = i9 + 1;
                cCharAt2 = charAt(this.bp + i9);
                if (cCharAt2 < '0' || cCharAt2 > '9') {
                    break;
                }
                i8 = (i8 * 10) + (cCharAt2 - '0');
                i10 *= 10;
                i9 = i4;
            }
            i2 = i4;
            i3 = i10;
            cCharAt = cCharAt2;
        } else {
            i3 = 1;
        }
        boolean z2 = cCharAt == 'e' || cCharAt == 'E';
        if (z2) {
            int i11 = i2 + 1;
            cCharAt = charAt(this.bp + i2);
            if (cCharAt == '+' || cCharAt == '-') {
                int i12 = i11 + 1;
                cCharAt = charAt(this.bp + i11);
                i2 = i12;
            } else {
                i2 = i11;
            }
            while (cCharAt >= '0' && cCharAt <= '9') {
                int i13 = i2 + 1;
                cCharAt = charAt(this.bp + i2);
                i2 = i13;
            }
        }
        int i14 = ((this.bp + i2) - i7) - 1;
        if (z2 || i14 >= 10) {
            f2 = Float.parseFloat(subString(i7, i14));
        } else {
            f2 = i8 / i3;
            if (z) {
                f2 = -f2;
            }
        }
        if (cCharAt == ',') {
            this.bp += i2 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return f2;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0.0f;
        }
        int i15 = i2 + 1;
        char cCharAt6 = charAt(this.bp + i2);
        if (cCharAt6 == ',') {
            this.token = 16;
            this.bp += i15 - 1;
            next();
        } else if (cCharAt6 == ']') {
            this.token = 15;
            this.bp += i15 - 1;
            next();
        } else if (cCharAt6 == '}') {
            this.token = 13;
            this.bp += i15 - 1;
            next();
        } else {
            if (cCharAt6 != 26) {
                this.matchStat = -1;
                return 0.0f;
            }
            this.bp += i15 - 1;
            this.token = 20;
            this.ch = EOI;
        }
        this.matchStat = 4;
        return f2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x021c, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x021e, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d3, code lost:
    
        r19.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d5, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:82:0x010d A[PHI: r4
  0x010d: PHI (r4v30 int) = (r4v29 int), (r4v34 int) binds: [B:81:0x010b, B:88:0x0125] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0128  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0116 -> B:85:0x0119). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[] scanFieldFloatArray(long r20) {
        /*
            Method dump skipped, instruction units count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloatArray(long):float[]");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:88:0x012b
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:282)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:65)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final float[][] scanFieldFloatArray2(long r21) {
        /*
            Method dump skipped, instruction units count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloatArray2(long):float[][]");
    }

    public int scanFieldInt(long j) {
        int i2;
        char cCharAt;
        this.matchStat = 0;
        int iMatchFieldHash = matchFieldHash(j);
        if (iMatchFieldHash == 0) {
            return 0;
        }
        int i3 = iMatchFieldHash + 1;
        int i4 = this.bp + iMatchFieldHash;
        int i5 = this.len;
        char cCharAt2 = EOI;
        char cCharAt3 = i4 >= i5 ? EOI : this.text.charAt(i4);
        boolean z = cCharAt3 == '\"';
        if (z) {
            int i6 = i3 + 1;
            int i7 = this.bp + i3;
            cCharAt3 = i7 >= this.len ? EOI : this.text.charAt(i7);
            i3 = i6;
            z = true;
        }
        boolean z2 = cCharAt3 == '-';
        if (z2) {
            int i8 = i3 + 1;
            int i9 = this.bp + i3;
            cCharAt3 = i9 >= this.len ? EOI : this.text.charAt(i9);
            i3 = i8;
        }
        if (cCharAt3 < '0' || cCharAt3 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i10 = cCharAt3 - '0';
        while (true) {
            i2 = i3 + 1;
            int i11 = this.bp + i3;
            cCharAt = i11 >= this.len ? EOI : this.text.charAt(i11);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            i10 = (i10 * 10) + (cCharAt - '0');
            i3 = i2;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (cCharAt == '\"') {
            if (!z) {
                this.matchStat = -1;
                return 0;
            }
            int i12 = i2 + 1;
            int i13 = this.bp + i2;
            i2 = i12;
            cCharAt = i13 >= this.len ? EOI : this.text.charAt(i13);
        }
        if (i10 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (cCharAt != ',') {
            if (cCharAt > ' ' || !(cCharAt == ' ' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == '\t' || cCharAt == '\f' || cCharAt == '\b')) {
                if (cCharAt != '}') {
                    this.matchStat = -1;
                    return 0;
                }
                int i14 = i2 + 1;
                char cCharAt4 = charAt(this.bp + i2);
                if (cCharAt4 == ',') {
                    this.token = 16;
                    int i15 = this.bp + (i14 - 1);
                    this.bp = i15;
                    int i16 = i15 + 1;
                    this.bp = i16;
                    if (i16 < this.len) {
                        cCharAt2 = this.text.charAt(i16);
                    }
                    this.ch = cCharAt2;
                } else if (cCharAt4 == ']') {
                    this.token = 15;
                    int i17 = this.bp + (i14 - 1);
                    this.bp = i17;
                    int i18 = i17 + 1;
                    this.bp = i18;
                    if (i18 < this.len) {
                        cCharAt2 = this.text.charAt(i18);
                    }
                    this.ch = cCharAt2;
                } else if (cCharAt4 == '}') {
                    this.token = 13;
                    int i19 = this.bp + (i14 - 1);
                    this.bp = i19;
                    int i20 = i19 + 1;
                    this.bp = i20;
                    if (i20 < this.len) {
                        cCharAt2 = this.text.charAt(i20);
                    }
                    this.ch = cCharAt2;
                } else {
                    if (cCharAt4 != 26) {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.token = 20;
                    this.bp += i14 - 1;
                    this.ch = EOI;
                }
                this.matchStat = 4;
                return z2 ? -i10 : i10;
            }
            int i21 = i2 + 1;
            int i22 = this.bp + i2;
            i2 = i21;
            cCharAt = i22 >= this.len ? EOI : this.text.charAt(i22);
        }
        int i23 = this.bp + (i2 - 1);
        this.bp = i23;
        int i24 = i23 + 1;
        this.bp = i24;
        if (i24 < this.len) {
            cCharAt2 = this.text.charAt(i24);
        }
        this.ch = cCharAt2;
        this.matchStat = 3;
        this.token = 16;
        return z2 ? -i10 : i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0164, code lost:
    
        r17.matchStat = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0166, code lost:
    
        return r7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int[] scanFieldIntArray(long r18) {
        /*
            Method dump skipped, instruction units count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldIntArray(long):int[]");
    }

    public long scanFieldLong(long j) {
        int i2;
        char cCharAt;
        this.matchStat = 0;
        int iMatchFieldHash = matchFieldHash(j);
        if (iMatchFieldHash == 0) {
            return 0L;
        }
        int i3 = iMatchFieldHash + 1;
        int i4 = this.bp + iMatchFieldHash;
        char cCharAt2 = i4 >= this.len ? EOI : this.text.charAt(i4);
        boolean z = cCharAt2 == '\"';
        if (z) {
            int i5 = i3 + 1;
            int i6 = this.bp + i3;
            cCharAt2 = i6 >= this.len ? EOI : this.text.charAt(i6);
            i3 = i5;
        }
        boolean z2 = cCharAt2 == '-';
        if (z2) {
            int i7 = i3 + 1;
            int i8 = this.bp + i3;
            cCharAt2 = i8 >= this.len ? EOI : this.text.charAt(i8);
            i3 = i7;
        }
        if (cCharAt2 < '0' || cCharAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j2 = cCharAt2 - '0';
        while (true) {
            i2 = i3 + 1;
            int i9 = this.bp + i3;
            cCharAt = i9 >= this.len ? EOI : this.text.charAt(i9);
            if (cCharAt < '0' || cCharAt > '9') {
                break;
            }
            j2 = (j2 * 10) + ((long) (cCharAt - '0'));
            i3 = i2;
        }
        if (cCharAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (cCharAt == '\"') {
            if (!z) {
                this.matchStat = -1;
                return 0L;
            }
            int i10 = i2 + 1;
            int i11 = this.bp + i2;
            cCharAt = i11 >= this.len ? EOI : this.text.charAt(i11);
            i2 = i10;
        }
        if (j2 < 0) {
            this.matchStat = -1;
            return 0L;
        }
        if (cCharAt == ',') {
            int i12 = this.bp + (i2 - 1);
            this.bp = i12;
            int i13 = i12 + 1;
            this.bp = i13;
            this.ch = i13 >= this.len ? EOI : this.text.charAt(i13);
            this.matchStat = 3;
            this.token = 16;
            return z2 ? -j2 : j2;
        }
        if (cCharAt != '}') {
            this.matchStat = -1;
            return 0L;
        }
        int i14 = i2 + 1;
        char cCharAt3 = charAt(this.bp + i2);
        if (cCharAt3 == ',') {
            this.token = 16;
            int i15 = this.bp + (i14 - 1);
            this.bp = i15;
            int i16 = i15 + 1;
            this.bp = i16;
            this.ch = i16 >= this.len ? EOI : this.text.charAt(i16);
        } else if (cCharAt3 == ']') {
            this.token = 15;
            int i17 = this.bp + (i14 - 1);
            this.bp = i17;
            int i18 = i17 + 1;
            this.bp = i18;
            this.ch = i18 >= this.len ? EOI : this.text.charAt(i18);
        } else if (cCharAt3 == '}') {
            this.token = 13;
            int i19 = this.bp + (i14 - 1);
            this.bp = i19;
            int i20 = i19 + 1;
            this.bp = i20;
            this.ch = i20 >= this.len ? EOI : this.text.charAt(i20);
        } else {
            if (cCharAt3 != 26) {
                this.matchStat = -1;
                return 0L;
            }
            this.token = 20;
            this.bp += i14 - 1;
            this.ch = EOI;
        }
        this.matchStat = 4;
        return z2 ? -j2 : j2;
    }

    public String scanFieldString(long j) {
        String str;
        this.matchStat = 0;
        int iMatchFieldHash = matchFieldHash(j);
        if (iMatchFieldHash == 0) {
            return null;
        }
        int i2 = iMatchFieldHash + 1;
        int i3 = this.bp + iMatchFieldHash;
        if (i3 >= this.len) {
            throw new JSONException("unclosed str, " + info());
        }
        if (this.text.charAt(i3) != '\"') {
            this.matchStat = -1;
            return this.stringDefaultValue;
        }
        int i4 = this.bp + i2;
        int iIndexOf = this.text.indexOf(34, i4);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str, " + info());
        }
        if (V6) {
            str = this.text.substring(i4, iIndexOf);
        } else {
            int i5 = iIndexOf - i4;
            str = new String(sub_chars(this.bp + i2, i5), 0, i5);
        }
        if (str.indexOf(92) != -1) {
            boolean z = false;
            while (true) {
                int i6 = iIndexOf - 1;
                int i7 = 0;
                while (i6 >= 0 && this.text.charAt(i6) == '\\') {
                    i7++;
                    i6--;
                    z = true;
                }
                if (i7 % 2 == 0) {
                    break;
                }
                iIndexOf = this.text.indexOf(34, iIndexOf + 1);
            }
            int i8 = iIndexOf - i4;
            char[] cArrSub_chars = sub_chars(this.bp + i2, i8);
            if (z) {
                str = readString(cArrSub_chars, i8);
            } else {
                str = new String(cArrSub_chars, 0, i8);
                if (str.indexOf(92) != -1) {
                    str = readString(cArrSub_chars, i8);
                }
            }
        }
        int i9 = iIndexOf + 1;
        int i10 = this.len;
        char cCharAt = EOI;
        char cCharAt2 = i9 >= i10 ? EOI : this.text.charAt(i9);
        if (cCharAt2 == ',') {
            this.bp = i9;
            int i11 = i9 + 1;
            this.bp = i11;
            if (i11 < this.len) {
                cCharAt = this.text.charAt(i11);
            }
            this.ch = cCharAt;
            this.matchStat = 3;
            this.token = 16;
            return str;
        }
        if (cCharAt2 != '}') {
            this.matchStat = -1;
            return this.stringDefaultValue;
        }
        int i12 = i9 + 1;
        char cCharAt3 = i12 >= this.len ? EOI : this.text.charAt(i12);
        if (cCharAt3 == ',') {
            this.token = 16;
            this.bp = i12;
            next();
        } else if (cCharAt3 == ']') {
            this.token = 15;
            this.bp = i12;
            next();
        } else if (cCharAt3 == '}') {
            this.token = 13;
            this.bp = i12;
            next();
        } else {
            if (cCharAt3 != 26) {
                this.matchStat = -1;
                return this.stringDefaultValue;
            }
            this.token = 20;
            this.bp = i12;
            this.ch = EOI;
        }
        this.matchStat = 4;
        return str;
    }

    public long scanFieldSymbol(long j) {
        this.matchStat = 0;
        int iMatchFieldHash = matchFieldHash(j);
        if (iMatchFieldHash == 0) {
            return 0L;
        }
        int i2 = iMatchFieldHash + 1;
        int i3 = this.bp + iMatchFieldHash;
        int i4 = this.len;
        char cCharAt = EOI;
        if ((i3 >= i4 ? EOI : this.text.charAt(i3)) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j2 = -3750763034362895579L;
        while (true) {
            int i5 = i2 + 1;
            int i6 = this.bp + i2;
            char cCharAt2 = i6 >= this.len ? EOI : this.text.charAt(i6);
            if (cCharAt2 == '\"') {
                int i7 = i5 + 1;
                int i8 = this.bp + i5;
                char cCharAt3 = i8 >= this.len ? EOI : this.text.charAt(i8);
                if (cCharAt3 == ',') {
                    int i9 = this.bp + (i7 - 1);
                    this.bp = i9;
                    int i10 = i9 + 1;
                    this.bp = i10;
                    if (i10 < this.len) {
                        cCharAt = this.text.charAt(i10);
                    }
                    this.ch = cCharAt;
                    this.matchStat = 3;
                    return j2;
                }
                if (cCharAt3 != '}') {
                    this.matchStat = -1;
                    return 0L;
                }
                int i11 = i7 + 1;
                int i12 = this.bp + i7;
                char cCharAt4 = i12 >= this.len ? EOI : this.text.charAt(i12);
                if (cCharAt4 == ',') {
                    this.token = 16;
                    this.bp += i11 - 1;
                    next();
                } else if (cCharAt4 == ']') {
                    this.token = 15;
                    this.bp += i11 - 1;
                    next();
                } else if (cCharAt4 == '}') {
                    this.token = 13;
                    this.bp += i11 - 1;
                    next();
                } else {
                    if (cCharAt4 != 26) {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.token = 20;
                    this.bp += i11 - 1;
                    this.ch = EOI;
                }
                this.matchStat = 4;
                return j2;
            }
            j2 = (j2 ^ ((long) cCharAt2)) * 1099511628211L;
            if (cCharAt2 == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i2 = i5;
        }
    }

    public boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.bp);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c3, code lost:
    
        if (r0 != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c6, code lost:
    
        return -r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long scanLongValue() {
        /*
            r13 = this;
            r0 = 0
            r13.np = r0
            char r1 = r13.ch
            r2 = 1
            r3 = 45
            if (r1 != r3) goto L3f
            r0 = -9223372036854775808
            r3 = 0
            int r3 = r3 + r2
            r13.np = r3
            int r3 = r13.bp
            int r3 = r3 + r2
            r13.bp = r3
            int r4 = r13.len
            if (r3 >= r4) goto L24
            java.lang.String r4 = r13.text
            char r3 = r4.charAt(r3)
            r13.ch = r3
            r3 = r0
            r0 = 1
            goto L44
        L24:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "syntax error, "
            r1.append(r2)
            java.lang.String r2 = r13.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L3f:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L44:
            r5 = 0
        L46:
            char r1 = r13.ch
            r7 = 48
            if (r1 < r7) goto Lc3
            r7 = 57
            if (r1 > r7) goto Lc3
            int r1 = r1 + (-48)
            r7 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            java.lang.String r9 = ", "
            java.lang.String r10 = "error long value, "
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 < 0) goto La4
            r7 = 10
            long r5 = r5 * r7
            long r7 = (long) r1
            long r11 = r3 + r7
            int r1 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r1 < 0) goto L85
            long r5 = r5 - r7
            int r1 = r13.np
            int r1 = r1 + r2
            r13.np = r1
            int r1 = r13.bp
            int r1 = r1 + r2
            r13.bp = r1
            int r7 = r13.len
            if (r1 < r7) goto L7c
            r1 = 26
            goto L82
        L7c:
            java.lang.String r7 = r13.text
            char r1 = r7.charAt(r1)
        L82:
            r13.ch = r1
            goto L46
        L85:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            r1.append(r5)
            r1.append(r9)
            java.lang.String r2 = r13.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        La4:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r10)
            r1.append(r5)
            r1.append(r9)
            java.lang.String r2 = r13.info()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        Lc3:
            if (r0 != 0) goto Lc6
            long r5 = -r5
        Lc6:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanLongValue():long");
    }

    public final void scanNumber() {
        char c2;
        char c3;
        int i2 = this.bp;
        this.np = i2;
        this.exp = false;
        if (this.ch == '-') {
            this.sp++;
            int i3 = i2 + 1;
            this.bp = i3;
            this.ch = i3 >= this.len ? EOI : this.text.charAt(i3);
        }
        while (true) {
            c2 = this.ch;
            if (c2 < '0' || c2 > '9') {
                break;
            }
            this.sp++;
            int i4 = this.bp + 1;
            this.bp = i4;
            this.ch = i4 >= this.len ? EOI : this.text.charAt(i4);
        }
        this.isDouble = false;
        if (c2 == '.') {
            this.sp++;
            int i5 = this.bp + 1;
            this.bp = i5;
            this.ch = i5 >= this.len ? EOI : this.text.charAt(i5);
            this.isDouble = true;
            while (true) {
                char c4 = this.ch;
                if (c4 < '0' || c4 > '9') {
                    break;
                }
                this.sp++;
                int i6 = this.bp + 1;
                this.bp = i6;
                this.ch = i6 >= this.len ? EOI : this.text.charAt(i6);
            }
        }
        char c5 = this.ch;
        if (c5 == 'L' || c5 == 'S' || c5 == 'B') {
            this.sp++;
            next();
        } else if (c5 == 'F' || c5 == 'D') {
            this.sp++;
            next();
            this.isDouble = true;
        } else if (c5 == 'e' || c5 == 'E') {
            this.sp++;
            int i7 = this.bp + 1;
            this.bp = i7;
            char cCharAt = i7 >= this.len ? EOI : this.text.charAt(i7);
            this.ch = cCharAt;
            if (cCharAt == '+' || cCharAt == '-') {
                this.sp++;
                int i8 = this.bp + 1;
                this.bp = i8;
                this.ch = i8 >= this.len ? EOI : this.text.charAt(i8);
            }
            while (true) {
                c3 = this.ch;
                if (c3 < '0' || c3 > '9') {
                    break;
                }
                this.sp++;
                int i9 = this.bp + 1;
                this.bp = i9;
                this.ch = i9 >= this.len ? EOI : this.text.charAt(i9);
            }
            if (c3 == 'D' || c3 == 'F') {
                this.sp++;
                next();
            }
            this.exp = true;
            this.isDouble = true;
        }
        if (this.isDouble) {
            this.token = 3;
        } else {
            this.token = 2;
        }
    }

    public final Number scanNumberValue() {
        long j;
        boolean z;
        char c2;
        int i2;
        char c3;
        boolean z2;
        int i3;
        char c4;
        boolean z3;
        char[] cArr;
        int i4;
        int i5;
        char[] cArr2;
        long j2;
        long j3;
        long j4;
        long j5;
        int i6 = this.bp;
        this.np = 0;
        if (this.ch == '-') {
            j = Long.MIN_VALUE;
            this.np = 0 + 1;
            int i7 = i6 + 1;
            this.bp = i7;
            this.ch = i7 >= this.len ? EOI : this.text.charAt(i7);
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        long j6 = 0;
        int i8 = 1;
        boolean z4 = false;
        while (true) {
            c2 = this.ch;
            i2 = 18;
            c3 = '0';
            if (c2 < '0' || c2 > '9') {
                break;
            }
            int i9 = c2 - '0';
            if (i8 < 18) {
                j4 = j6 * 10;
                j5 = i9;
            } else {
                if (j6 < -922337203685477580L) {
                    z4 = true;
                }
                j4 = j6 * 10;
                j5 = i9;
                if (j4 < j + j5) {
                    z4 = true;
                }
            }
            j6 = j4 - j5;
            this.np++;
            int i10 = this.bp + 1;
            this.bp = i10;
            this.ch = i10 >= this.len ? EOI : this.text.charAt(i10);
            i8++;
        }
        Number numberValueOf = null;
        if (c2 == '.') {
            this.np++;
            int i11 = this.bp + 1;
            this.bp = i11;
            this.ch = i11 >= this.len ? EOI : this.text.charAt(i11);
            i3 = 0;
            while (true) {
                char c5 = this.ch;
                if (c5 < c3 || c5 > '9') {
                    break;
                }
                i3++;
                int i12 = c5 - '0';
                if (i8 < i2) {
                    j2 = j6 * 10;
                    j3 = i12;
                } else {
                    if (j6 < -922337203685477580L) {
                        z4 = true;
                    }
                    j2 = j6 * 10;
                    j3 = i12;
                    if (j2 < j + j3) {
                        z4 = true;
                    }
                }
                j6 = j2 - j3;
                this.np++;
                int i13 = this.bp + 1;
                this.bp = i13;
                this.ch = i13 >= this.len ? EOI : this.text.charAt(i13);
                i8++;
                c3 = '0';
                i2 = 18;
            }
            if (!z) {
                j6 = -j6;
            }
            z2 = true;
        } else {
            if (!z) {
                j6 = -j6;
            }
            if (c2 == 'L') {
                this.np++;
                next();
                numberValueOf = Long.valueOf(j6);
            } else if (c2 == 'S') {
                this.np++;
                next();
                numberValueOf = Short.valueOf((short) j6);
            } else if (c2 == 'B') {
                this.np++;
                next();
                numberValueOf = Byte.valueOf((byte) j6);
            } else if (c2 == 'F') {
                this.np++;
                next();
                numberValueOf = Float.valueOf(j6);
            } else if (c2 == 'D') {
                this.np++;
                next();
                numberValueOf = Double.valueOf(j6);
            }
            z2 = false;
            i3 = 0;
        }
        char c6 = this.ch;
        if (c6 == 'e' || c6 == 'E') {
            this.np++;
            int i14 = this.bp + 1;
            this.bp = i14;
            char cCharAt = i14 >= this.len ? EOI : this.text.charAt(i14);
            this.ch = cCharAt;
            if (cCharAt == '+' || cCharAt == '-') {
                this.np++;
                int i15 = this.bp + 1;
                this.bp = i15;
                this.ch = i15 >= this.len ? EOI : this.text.charAt(i15);
            }
            while (true) {
                c4 = this.ch;
                if (c4 < '0' || c4 > '9') {
                    break;
                }
                this.np++;
                int i16 = this.bp + 1;
                this.bp = i16;
                this.ch = i16 >= this.len ? EOI : this.text.charAt(i16);
            }
            if (c4 == 'D' || c4 == 'F') {
                this.np++;
                next();
            } else {
                c4 = 0;
            }
            z3 = true;
        } else {
            z3 = false;
            c4 = 0;
        }
        if (!z2 && !z3) {
            if (z4) {
                int i17 = this.bp;
                char[] cArr3 = new char[i17 - i6];
                this.text.getChars(i6, i17, cArr3, 0);
                numberValueOf = new BigInteger(new String(cArr3));
            }
            return numberValueOf == null ? (j6 <= -2147483648L || j6 >= 2147483647L) ? Long.valueOf(j6) : Integer.valueOf((int) j6) : numberValueOf;
        }
        int i18 = this.bp - i6;
        if (c4 != 0) {
            i18--;
        }
        if (!z3 && (this.features & Feature.UseBigDecimal.mask) != 0) {
            if (!z4) {
                return BigDecimal.valueOf(j6, i3);
            }
            char[] cArr4 = this.sbuf;
            if (i18 < cArr4.length) {
                i5 = 0;
                this.text.getChars(i6, i6 + i18, cArr4, 0);
                cArr2 = this.sbuf;
            } else {
                i5 = 0;
                char[] cArr5 = new char[i18];
                this.text.getChars(i6, i6 + i18, cArr5, 0);
                cArr2 = cArr5;
            }
            return new BigDecimal(cArr2, i5, i18);
        }
        char[] cArr6 = this.sbuf;
        if (i18 < cArr6.length) {
            this.text.getChars(i6, i6 + i18, cArr6, 0);
            cArr = this.sbuf;
        } else {
            char[] cArr7 = new char[i18];
            this.text.getChars(i6, i6 + i18, cArr7, 0);
            cArr = cArr7;
        }
        try {
            if (i18 > 9 || z3) {
                String str = new String(cArr, 0, i18);
                return c4 == 'F' ? Float.valueOf(str) : Double.valueOf(Double.parseDouble(str));
            }
            char c7 = cArr[0];
            if (c7 == '-' || c7 == '+') {
                c7 = cArr[1];
                i4 = 2;
            } else {
                i4 = 1;
            }
            int i19 = c7 - '0';
            int i20 = 0;
            for (int i21 = i4; i21 < i18; i21++) {
                char c8 = cArr[i21];
                if (c8 == '.') {
                    i20 = 1;
                } else {
                    i19 = (i19 * 10) + (c8 - '0');
                    if (i20 != 0) {
                        i20 *= 10;
                    }
                }
            }
            if (c4 == 'F') {
                float f2 = i19 / i20;
                if (z) {
                    f2 = -f2;
                }
                return Float.valueOf(f2);
            }
            double d2 = ((double) i19) / ((double) i20);
            if (z) {
                d2 = -d2;
            }
            return Double.valueOf(d2);
        } catch (NumberFormatException e2) {
            throw new JSONException(e2.getMessage() + ", " + info(), e2);
        }
    }

    public final void scanString() {
        char c2 = this.ch;
        int i2 = this.bp + 1;
        int iIndexOf = this.text.indexOf(c2, i2);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str, " + info());
        }
        int i3 = iIndexOf - i2;
        char[] cArrSub_chars = sub_chars(this.bp + 1, i3);
        boolean z = false;
        while (i3 > 0 && cArrSub_chars[i3 - 1] == '\\') {
            int i4 = 1;
            for (int i5 = i3 - 2; i5 >= 0 && cArrSub_chars[i5] == '\\'; i5--) {
                i4++;
            }
            if (i4 % 2 == 0) {
                break;
            }
            int iIndexOf2 = this.text.indexOf(c2, iIndexOf + 1);
            int i6 = (iIndexOf2 - iIndexOf) + i3;
            if (i6 >= cArrSub_chars.length) {
                int length = (cArrSub_chars.length * 3) / 2;
                if (length < i6) {
                    length = i6;
                }
                char[] cArr = new char[length];
                System.arraycopy(cArrSub_chars, 0, cArr, 0, cArrSub_chars.length);
                cArrSub_chars = cArr;
            }
            this.text.getChars(iIndexOf, iIndexOf2, cArrSub_chars, i3);
            iIndexOf = iIndexOf2;
            i3 = i6;
            z = true;
        }
        if (!z) {
            for (int i7 = 0; i7 < i3; i7++) {
                if (cArrSub_chars[i7] == '\\') {
                    z = true;
                }
            }
        }
        this.sbuf = cArrSub_chars;
        this.sp = i3;
        this.np = this.bp;
        this.hasSpecial = z;
        int i8 = iIndexOf + 1;
        this.bp = i8;
        this.ch = i8 >= this.len ? EOI : this.text.charAt(i8);
        this.token = 4;
    }

    public String scanStringValue(char c2) {
        String str;
        int i2 = this.bp + 1;
        int iIndexOf = this.text.indexOf(c2, i2);
        if (iIndexOf == -1) {
            throw new JSONException("unclosed str, " + info());
        }
        if (V6) {
            str = this.text.substring(i2, iIndexOf);
        } else {
            int i3 = iIndexOf - i2;
            str = new String(sub_chars(this.bp + 1, i3), 0, i3);
        }
        if (str.indexOf(92) != -1) {
            while (true) {
                int i4 = 0;
                for (int i5 = iIndexOf - 1; i5 >= 0 && this.text.charAt(i5) == '\\'; i5--) {
                    i4++;
                }
                if (i4 % 2 == 0) {
                    break;
                }
                iIndexOf = this.text.indexOf(c2, iIndexOf + 1);
            }
            int i6 = iIndexOf - i2;
            str = readString(sub_chars(this.bp + 1, i6), i6);
        }
        int i7 = iIndexOf + 1;
        this.bp = i7;
        this.ch = i7 >= this.len ? EOI : this.text.charAt(i7);
        return str;
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        char c2;
        while (true) {
            c2 = this.ch;
            if (c2 != ' ' && c2 != '\n' && c2 != '\r' && c2 != '\t' && c2 != '\f' && c2 != '\b') {
                break;
            }
            next();
        }
        if (c2 == '\"') {
            return scanSymbol(symbolTable, '\"');
        }
        if (c2 == '\'') {
            return scanSymbol(symbolTable, '\'');
        }
        if (c2 == '}') {
            next();
            this.token = 13;
            return null;
        }
        if (c2 == ',') {
            next();
            this.token = 16;
            return null;
        }
        if (c2 != 26) {
            return scanSymbolUnQuoted(symbolTable);
        }
        this.token = 20;
        return null;
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        int i2 = this.ch;
        boolean[] zArr = firstIdentifierFlags;
        if (!(i2 >= zArr.length || zArr[i2])) {
            throw new JSONException("illegal identifier : " + this.ch + ", " + info());
        }
        this.np = this.bp;
        this.sp = 1;
        while (true) {
            char next = next();
            boolean[] zArr2 = identifierFlags;
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i2 = (i2 * 31) + next;
            this.sp++;
        }
        this.ch = charAt(this.bp);
        this.token = 18;
        if (this.sp == 4 && this.text.startsWith("null", this.np)) {
            return null;
        }
        return symbolTable.addSymbol(this.text, this.np, this.sp, i2);
    }

    public void setTime(char c2, char c3, char c4, char c5, char c6, char c7) {
        this.calendar.set(11, ((c2 - '0') * 10) + (c3 - '0'));
        this.calendar.set(12, ((c4 - '0') * 10) + (c5 - '0'));
        this.calendar.set(13, ((c6 - '0') * 10) + (c7 - '0'));
    }

    public void setTimeZone(char c2, char c3, char c4) {
        int i2 = (((c3 - '0') * 10) + (c4 - '0')) * 3600 * 1000;
        if (c2 == '-') {
            i2 = -i2;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i2) {
            String[] availableIDs = TimeZone.getAvailableIDs(i2);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(TimeZone.getTimeZone(availableIDs[0]));
            }
        }
    }

    public void skipComment() {
        next();
        char c2 = this.ch;
        if (c2 == '/') {
            do {
                next();
            } while (this.ch != '\n');
            next();
        } else {
            if (c2 != '*') {
                throw new JSONException("invalid comment");
            }
            next();
            while (true) {
                char c3 = this.ch;
                if (c3 == 26) {
                    return;
                }
                if (c3 == '*') {
                    next();
                    if (this.ch == '/') {
                        next();
                        return;
                    }
                } else {
                    next();
                }
            }
        }
    }

    public final void skipWhitespace() {
        while (true) {
            char c2 = this.ch;
            if (c2 > '/') {
                return;
            }
            if (c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t' || c2 == '\f' || c2 == '\b') {
                next();
            } else if (c2 != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final String stringVal() {
        return this.hasSpecial ? readString(this.sbuf, this.sp) : subString(this.np + 1, this.sp);
    }

    public final char[] sub_chars(int i2, int i3) {
        char[] cArr = this.sbuf;
        if (i3 < cArr.length) {
            this.text.getChars(i2, i3 + i2, cArr, 0);
            return this.sbuf;
        }
        char[] cArr2 = new char[i3];
        this.sbuf = cArr2;
        this.text.getChars(i2, i3 + i2, cArr2, 0);
        return cArr2;
    }

    public final int token() {
        return this.token;
    }

    public JSONLexer(char[] cArr, int i2) {
        this(cArr, i2, JSON.DEFAULT_PARSER_FEATURE);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean scanISO8601DateIfMatch(boolean r36, int r37) {
        /*
            Method dump skipped, instruction units count: 1607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    public JSONLexer(char[] cArr, int i2, int i3) {
        this(new String(cArr, 0, i2), i3);
    }

    public JSONLexer(String str, int i2) {
        this.features = JSON.DEFAULT_PARSER_FEATURE;
        this.exp = false;
        this.isDouble = false;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.calendar = null;
        this.matchStat = 0;
        char[] cArr = sbufLocal.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
        this.features = i2;
        this.text = str;
        int length = str.length();
        this.len = length;
        this.bp = -1;
        int i3 = (-1) + 1;
        this.bp = i3;
        char cCharAt = i3 >= length ? EOI : str.charAt(i3);
        this.ch = cCharAt;
        if (cCharAt == 65279) {
            next();
        }
        this.stringDefaultValue = (Feature.InitStringFieldAsEmpty.mask & i2) != 0 ? "" : null;
        this.disableCircularReferenceDetect = (Feature.DisableCircularReferenceDetect.mask & i2) != 0;
    }

    public String scanSymbol(SymbolTable symbolTable, char c2) {
        String string;
        int i2 = this.bp + 1;
        int iIndexOf = this.text.indexOf(c2, i2);
        if (iIndexOf != -1) {
            int i3 = iIndexOf - i2;
            char[] cArrSub_chars = sub_chars(this.bp + 1, i3);
            boolean z = false;
            while (i3 > 0 && cArrSub_chars[i3 - 1] == '\\') {
                int i4 = 1;
                for (int i5 = i3 - 2; i5 >= 0 && cArrSub_chars[i5] == '\\'; i5--) {
                    i4++;
                }
                if (i4 % 2 == 0) {
                    break;
                }
                int iIndexOf2 = this.text.indexOf(c2, iIndexOf + 1);
                int i6 = (iIndexOf2 - iIndexOf) + i3;
                if (i6 >= cArrSub_chars.length) {
                    int length = (cArrSub_chars.length * 3) / 2;
                    if (length < i6) {
                        length = i6;
                    }
                    char[] cArr = new char[length];
                    System.arraycopy(cArrSub_chars, 0, cArr, 0, cArrSub_chars.length);
                    cArrSub_chars = cArr;
                }
                this.text.getChars(iIndexOf, iIndexOf2, cArrSub_chars, i3);
                iIndexOf = iIndexOf2;
                i3 = i6;
                z = true;
            }
            if (z) {
                string = readString(cArrSub_chars, i3);
            } else {
                int i7 = 0;
                for (int i8 = 0; i8 < i3; i8++) {
                    char c3 = cArrSub_chars[i8];
                    i7 = (i7 * 31) + c3;
                    if (c3 == '\\') {
                        z = true;
                    }
                }
                if (z) {
                    string = readString(cArrSub_chars, i3);
                } else {
                    string = i3 < 20 ? symbolTable.addSymbol(cArrSub_chars, 0, i3, i7) : new String(cArrSub_chars, 0, i3);
                }
            }
            int i9 = iIndexOf + 1;
            this.bp = i9;
            this.ch = i9 >= this.len ? EOI : this.text.charAt(i9);
            return string;
        }
        throw new JSONException("unclosed str, " + info());
    }

    public final BigDecimal decimalValue() {
        char cCharAt = this.text.charAt((this.np + this.sp) - 1);
        int i2 = this.sp;
        if (cCharAt == 'L' || cCharAt == 'S' || cCharAt == 'B' || cCharAt == 'F' || cCharAt == 'D') {
            i2--;
        }
        int i3 = this.np;
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i3, i3 + i2, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i2);
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i3, i2 + i3, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00a3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void nextToken(int r11) {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.nextToken(int):void");
    }
}
