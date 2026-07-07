package com.alibaba.fastjson.serializer;

import androidx.appcompat.widget.ActivityChooserView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.sdk.m.n.a;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import org.apache.commons.codec.language.Soundex;

/* JADX INFO: loaded from: classes.dex */
public final class SerializeWriter extends Writer {
    public static final char[] DIGITS;
    public static final byte[] specicalFlags_doubleQuotes;
    public static final byte[] specicalFlags_singleQuotes;
    public char[] buf;
    public int count;
    public int features;
    public final Writer writer;
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    public static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};
    public static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static final char[] DigitTens = {'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
    public static final char[] DigitOnes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final char[] ascii_chars = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};
    public static final char[] replaceChars = new char[93];

    static {
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i2 = 14; i2 <= 31; i2++) {
            specicalFlags_doubleQuotes[i2] = 4;
            specicalFlags_singleQuotes[i2] = 4;
        }
        for (int i3 = 127; i3 < 160; i3++) {
            specicalFlags_doubleQuotes[i3] = 4;
            specicalFlags_singleQuotes[i3] = 4;
        }
        char[] cArr = replaceChars;
        cArr[0] = '0';
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = '\"';
        cArr[39] = '\'';
        cArr[47] = '/';
        cArr[92] = '\\';
        DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    public static void getChars(long j, int i2, char[] cArr) {
        char c2;
        if (j < 0) {
            c2 = Soundex.SILENT_MARKER;
            j = -j;
        } else {
            c2 = 0;
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            int i3 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            int i4 = i2 - 1;
            cArr[i4] = DigitOnes[i3];
            i2 = i4 - 1;
            cArr[i2] = DigitTens[i3];
            j = j2;
        }
        int i5 = (int) j;
        while (i5 >= 65536) {
            int i6 = i5 / 100;
            int i7 = i5 - (((i6 << 6) + (i6 << 5)) + (i6 << 2));
            int i8 = i2 - 1;
            cArr[i8] = DigitOnes[i7];
            i2 = i8 - 1;
            cArr[i2] = DigitTens[i7];
            i5 = i6;
        }
        while (true) {
            int i9 = (52429 * i5) >>> 19;
            i2--;
            cArr[i2] = digits[i5 - ((i9 << 3) + (i9 << 1))];
            if (i9 == 0) {
                break;
            } else {
                i5 = i9;
            }
        }
        if (c2 != 0) {
            cArr[i2 - 1] = c2;
        }
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z = true;
        int i2 = this.count + length + 1;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(34);
                    write(34);
                    write(58);
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    }
                    char cCharAt = str.charAt(i3);
                    byte[] bArr = specicalFlags_doubleQuotes;
                    if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z) {
                    write(34);
                }
                for (int i4 = 0; i4 < length; i4++) {
                    char cCharAt2 = str.charAt(i4);
                    byte[] bArr2 = specicalFlags_doubleQuotes;
                    if (cCharAt2 >= bArr2.length || bArr2[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(replaceChars[cCharAt2]);
                    }
                }
                if (z) {
                    write(34);
                }
                write(58);
                return;
            }
            expandCapacity(i2);
        }
        if (length == 0) {
            int i5 = this.count;
            if (i5 + 3 > this.buf.length) {
                expandCapacity(i5 + 3);
            }
            char[] cArr = this.buf;
            int i6 = this.count;
            int i7 = i6 + 1;
            this.count = i7;
            cArr[i6] = '\"';
            int i8 = i7 + 1;
            this.count = i8;
            cArr[i7] = '\"';
            this.count = i8 + 1;
            cArr[i8] = ':';
            return;
        }
        int i9 = this.count;
        int i10 = i9 + length;
        str.getChars(0, length, this.buf, i9);
        this.count = i2;
        int i11 = i9;
        boolean z2 = false;
        while (i11 < i10) {
            char[] cArr2 = this.buf;
            char c2 = cArr2[i11];
            byte[] bArr3 = specicalFlags_doubleQuotes;
            if (c2 < bArr3.length && bArr3[c2] != 0) {
                if (z2) {
                    i2++;
                    if (i2 > cArr2.length) {
                        expandCapacity(i2);
                    }
                    this.count = i2;
                    char[] cArr3 = this.buf;
                    int i12 = i11 + 1;
                    System.arraycopy(cArr3, i12, cArr3, i11 + 2, i10 - i11);
                    char[] cArr4 = this.buf;
                    cArr4[i11] = '\\';
                    cArr4[i12] = replaceChars[c2];
                    i10++;
                    i11 = i12;
                } else {
                    i2 += 3;
                    if (i2 > cArr2.length) {
                        expandCapacity(i2);
                    }
                    this.count = i2;
                    char[] cArr5 = this.buf;
                    int i13 = i11 + 1;
                    System.arraycopy(cArr5, i13, cArr5, i11 + 3, (i10 - i11) - 1);
                    char[] cArr6 = this.buf;
                    System.arraycopy(cArr6, 0, cArr6, 1, i11);
                    char[] cArr7 = this.buf;
                    cArr7[i9] = '\"';
                    cArr7[i13] = '\\';
                    int i14 = i13 + 1;
                    cArr7[i14] = replaceChars[c2];
                    i10 += 2;
                    cArr7[this.count - 2] = '\"';
                    i11 = i14;
                    z2 = true;
                }
            }
            i11++;
        }
        this.buf[this.count - 1] = ':';
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z = true;
        int i2 = this.count + length + 1;
        if (i2 > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z = false;
                        break;
                    }
                    char cCharAt = str.charAt(i3);
                    byte[] bArr = specicalFlags_singleQuotes;
                    if (cCharAt < bArr.length && bArr[cCharAt] != 0) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z) {
                    write(39);
                }
                for (int i4 = 0; i4 < length; i4++) {
                    char cCharAt2 = str.charAt(i4);
                    byte[] bArr2 = specicalFlags_singleQuotes;
                    if (cCharAt2 >= bArr2.length || bArr2[cCharAt2] == 0) {
                        write(cCharAt2);
                    } else {
                        write(92);
                        write(replaceChars[cCharAt2]);
                    }
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
            expandCapacity(i2);
        }
        if (length == 0) {
            int i5 = this.count;
            if (i5 + 3 > this.buf.length) {
                expandCapacity(i5 + 3);
            }
            char[] cArr = this.buf;
            int i6 = this.count;
            int i7 = i6 + 1;
            this.count = i7;
            cArr[i6] = '\'';
            int i8 = i7 + 1;
            this.count = i8;
            cArr[i7] = '\'';
            this.count = i8 + 1;
            cArr[i8] = ':';
            return;
        }
        int i9 = this.count;
        int i10 = i9 + length;
        str.getChars(0, length, this.buf, i9);
        this.count = i2;
        int i11 = i9;
        boolean z2 = false;
        while (i11 < i10) {
            char[] cArr2 = this.buf;
            char c2 = cArr2[i11];
            byte[] bArr3 = specicalFlags_singleQuotes;
            if (c2 < bArr3.length && bArr3[c2] != 0) {
                if (z2) {
                    i2++;
                    if (i2 > cArr2.length) {
                        expandCapacity(i2);
                    }
                    this.count = i2;
                    char[] cArr3 = this.buf;
                    int i12 = i11 + 1;
                    System.arraycopy(cArr3, i12, cArr3, i11 + 2, i10 - i11);
                    char[] cArr4 = this.buf;
                    cArr4[i11] = '\\';
                    cArr4[i12] = replaceChars[c2];
                    i10++;
                    i11 = i12;
                } else {
                    i2 += 3;
                    if (i2 > cArr2.length) {
                        expandCapacity(i2);
                    }
                    this.count = i2;
                    char[] cArr5 = this.buf;
                    int i13 = i11 + 1;
                    System.arraycopy(cArr5, i13, cArr5, i11 + 3, (i10 - i11) - 1);
                    char[] cArr6 = this.buf;
                    System.arraycopy(cArr6, 0, cArr6, 1, i11);
                    char[] cArr7 = this.buf;
                    cArr7[i9] = '\'';
                    cArr7[i13] = '\\';
                    int i14 = i13 + 1;
                    cArr7[i14] = replaceChars[c2];
                    i10 += 2;
                    cArr7[this.count - 2] = '\'';
                    i11 = i14;
                    z2 = true;
                }
            }
            i11++;
        }
        this.buf[i2 - 1] = ':';
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 8192) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        if (z) {
            this.features = serializerFeature.mask | this.features;
        } else {
            this.features = (~serializerFeature.mask) & this.features;
        }
    }

    public void expandCapacity(int i2) {
        char[] cArr = this.buf;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i2) {
            i2 = length;
        }
        char[] cArr2 = new char[i2];
        System.arraycopy(cArr, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (IOException e2) {
            throw new JSONException(e2.getMessage(), e2);
        }
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public byte[] toBytes(String str) {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (str == null) {
            str = "UTF-8";
        }
        try {
            return new String(this.buf, 0, this.count).getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new JSONException("toBytes error", e2);
        }
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int i2) {
        int i3 = 1;
        int i4 = this.count + 1;
        if (i4 <= this.buf.length) {
            i3 = i4;
        } else if (this.writer == null) {
            expandCapacity(i4);
            i3 = i4;
        } else {
            flush();
        }
        this.buf[this.count] = (char) i2;
        this.count = i3;
    }

    public void writeByteArray(byte[] bArr) {
        int length = bArr.length;
        boolean z = (this.features & SerializerFeature.UseSingleQuotes.mask) != 0;
        char c2 = z ? '\'' : '\"';
        if (length == 0) {
            write(z ? "''" : "\"\"");
            return;
        }
        char[] cArr = JSONLexer.CA;
        int i2 = (length / 3) * 3;
        int i3 = length - 1;
        int i4 = this.count;
        int i5 = (((i3 / 3) + 1) << 2) + i4 + 2;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                write(c2);
                int i6 = 0;
                while (i6 < i2) {
                    int i7 = i6 + 1;
                    int i8 = i7 + 1;
                    int i9 = ((bArr[i6] & 255) << 16) | ((bArr[i7] & 255) << 8) | (bArr[i8] & 255);
                    write(cArr[(i9 >>> 18) & 63]);
                    write(cArr[(i9 >>> 12) & 63]);
                    write(cArr[(i9 >>> 6) & 63]);
                    write(cArr[i9 & 63]);
                    i6 = i8 + 1;
                }
                int i10 = length - i2;
                if (i10 > 0) {
                    int i11 = ((bArr[i2] & 255) << 10) | (i10 == 2 ? (bArr[i3] & 255) << 2 : 0);
                    write(cArr[i11 >> 12]);
                    write(cArr[(i11 >>> 6) & 63]);
                    write(i10 == 2 ? cArr[i11 & 63] : a.f5521h);
                    write(61);
                }
                write(c2);
                return;
            }
            expandCapacity(i5);
        }
        this.count = i5;
        int i12 = i4 + 1;
        this.buf[i4] = c2;
        int i13 = 0;
        while (i13 < i2) {
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = ((bArr[i13] & 255) << 16) | ((bArr[i14] & 255) << 8);
            int i17 = i15 + 1;
            int i18 = i16 | (bArr[i15] & 255);
            char[] cArr2 = this.buf;
            int i19 = i12 + 1;
            cArr2[i12] = cArr[(i18 >>> 18) & 63];
            int i20 = i19 + 1;
            cArr2[i19] = cArr[(i18 >>> 12) & 63];
            int i21 = i20 + 1;
            cArr2[i20] = cArr[(i18 >>> 6) & 63];
            i12 = i21 + 1;
            cArr2[i21] = cArr[i18 & 63];
            i13 = i17;
        }
        int i22 = length - i2;
        if (i22 > 0) {
            int i23 = ((bArr[i2] & 255) << 10) | (i22 == 2 ? (bArr[i3] & 255) << 2 : 0);
            char[] cArr3 = this.buf;
            cArr3[i5 - 5] = cArr[i23 >> 12];
            cArr3[i5 - 4] = cArr[(i23 >>> 6) & 63];
            cArr3[i5 - 3] = i22 == 2 ? cArr[i23 & 63] : a.f5521h;
            cArr3[i5 - 2] = a.f5521h;
        }
        this.buf[i5 - 1] = c2;
    }

    public void writeFieldName(String str, boolean z) {
        int i2 = this.features;
        if ((SerializerFeature.UseSingleQuotes.mask & i2) == 0) {
            if ((i2 & SerializerFeature.QuoteFieldNames.mask) != 0) {
                writeStringWithDoubleQuote(str, ':', z);
                return;
            } else {
                writeKeyWithDoubleQuoteIfHasSpecial(str);
                return;
            }
        }
        if ((SerializerFeature.QuoteFieldNames.mask & i2) == 0) {
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else {
            writeStringWithSingleQuote(str);
            write(58);
        }
    }

    public void writeInt(int i2) {
        if (i2 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int i3 = 0;
        while ((i2 < 0 ? -i2 : i2) > sizeTable[i3]) {
            i3++;
        }
        int i4 = i3 + 1;
        if (i2 < 0) {
            i4++;
        }
        int i5 = this.count + i4;
        if (i5 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[i4];
                getChars(i2, i4, cArr);
                write(cArr, 0, i4);
                return;
            }
            expandCapacity(i5);
        }
        getChars(i2, i5, this.buf);
        this.count = i5;
    }

    public void writeLong(long j) {
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        long j2 = j < 0 ? -j : j;
        int i2 = 1;
        long j3 = 10;
        while (true) {
            if (i2 >= 19) {
                i2 = 0;
                break;
            } else {
                if (j2 < j3) {
                    break;
                }
                j3 *= 10;
                i2++;
            }
        }
        int i3 = i2 != 0 ? i2 : 19;
        if (j < 0) {
            i3++;
        }
        int i4 = this.count + i3;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                char[] cArr = new char[i3];
                getChars(j, i3, cArr);
                write(cArr, 0, i3);
                return;
            }
            expandCapacity(i4);
        }
        getChars(j, i4, this.buf);
        this.count = i4;
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str) {
        if ((this.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x00e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0094 A[PHI: r4 r13
  0x0094: PHI (r4v24 int) = (r4v19 int), (r4v25 int) binds: [B:75:0x00e4, B:41:0x0092] A[DONT_GENERATE, DONT_INLINE]
  0x0094: PHI (r13v8 int) = (r13v4 int), (r13v9 int) binds: [B:75:0x00e4, B:41:0x0092] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0099 A[PHI: r4 r13 r14
  0x0099: PHI (r4v22 int) = (r4v19 int), (r4v21 int), (r4v25 int) binds: [B:75:0x00e4, B:52:0x00ac, B:41:0x0092] A[DONT_GENERATE, DONT_INLINE]
  0x0099: PHI (r13v6 int) = (r13v4 int), (r13v5 int), (r13v9 int) binds: [B:75:0x00e4, B:52:0x00ac, B:41:0x0092] A[DONT_GENERATE, DONT_INLINE]
  0x0099: PHI (r14v12 int) = (r14v1 int), (r14v10 int), (r14v1 int) binds: [B:75:0x00e4, B:52:0x00ac, B:41:0x0092] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeStringWithDoubleQuote(java.lang.String r18, char r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char, boolean):void");
    }

    public void writeStringWithSingleQuote(String str) {
        int i2 = 0;
        if (str == null) {
            int i3 = this.count + 4;
            if (i3 > this.buf.length) {
                expandCapacity(i3);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i3;
            return;
        }
        int length = str.length();
        int i4 = this.count + length + 2;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i2 < str.length()) {
                    char cCharAt = str.charAt(i2);
                    if (cCharAt <= '\r' || cCharAt == '\\' || cCharAt == '\'' || (cCharAt == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                        write(92);
                        write(replaceChars[cCharAt]);
                    } else {
                        write(cCharAt);
                    }
                    i2++;
                }
                write(39);
                return;
            }
            expandCapacity(i4);
        }
        int i5 = this.count;
        int i6 = i5 + 1;
        int i7 = i6 + length;
        char[] cArr = this.buf;
        cArr[i5] = '\'';
        str.getChars(0, length, cArr, i6);
        this.count = i4;
        int i8 = -1;
        char c2 = 0;
        for (int i9 = i6; i9 < i7; i9++) {
            char c3 = this.buf[i9];
            if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                i2++;
                i8 = i9;
                c2 = c3;
            }
        }
        int i10 = i4 + i2;
        if (i10 > this.buf.length) {
            expandCapacity(i10);
        }
        this.count = i10;
        if (i2 == 1) {
            char[] cArr2 = this.buf;
            int i11 = i8 + 1;
            System.arraycopy(cArr2, i11, cArr2, i8 + 2, (i7 - i8) - 1);
            char[] cArr3 = this.buf;
            cArr3[i8] = '\\';
            cArr3[i11] = replaceChars[c2];
        } else if (i2 > 1) {
            char[] cArr4 = this.buf;
            int i12 = i8 + 1;
            System.arraycopy(cArr4, i12, cArr4, i8 + 2, (i7 - i8) - 1);
            char[] cArr5 = this.buf;
            cArr5[i8] = '\\';
            cArr5[i12] = replaceChars[c2];
            int i13 = i7 + 1;
            for (int i14 = i12 - 2; i14 >= i6; i14--) {
                char[] cArr6 = this.buf;
                char c4 = cArr6[i14];
                if (c4 <= '\r' || c4 == '\\' || c4 == '\'' || (c4 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                    int i15 = i14 + 1;
                    System.arraycopy(cArr6, i15, cArr6, i14 + 2, (i13 - i14) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i14] = '\\';
                    cArr7[i15] = replaceChars[c4];
                    i13++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        writer.write(this.buf, 0, this.count);
    }

    public SerializeWriter(Writer writer) {
        this.writer = writer;
        this.features = JSON.DEFAULT_GENERATE_FEATURE;
        ThreadLocal<char[]> threadLocal = bufLocal;
        this.buf = threadLocal.get();
        if (threadLocal != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer == null) {
            outputStream.write(new String(this.buf, 0, this.count).getBytes(charset.name()));
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String string = charSequence == null ? "null" : charSequence.toString();
        write(string, 0, string.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i2, int i3) {
        int i4;
        if (i2 < 0 || i2 > cArr.length || i3 < 0 || (i4 = i2 + i3) > cArr.length || i4 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i3 == 0) {
            return;
        }
        int i5 = this.count + i3;
        if (i5 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i5);
            } else {
                do {
                    char[] cArr2 = this.buf;
                    int length = cArr2.length;
                    int i6 = this.count;
                    int i7 = length - i6;
                    System.arraycopy(cArr, i2, cArr2, i6, i7);
                    this.count = this.buf.length;
                    flush();
                    i3 -= i7;
                    i2 += i7;
                } while (i3 > this.buf.length);
                i5 = i3;
            }
        }
        System.arraycopy(cArr, i2, this.buf, this.count, i3);
        this.count = i5;
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this(null, 0, serializerFeatureArr);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i2, int i3) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String string = charSequence.subSequence(i2, i3).toString();
        write(string, 0, string.length());
        return this;
    }

    public SerializeWriter(Writer writer, int i2, SerializerFeature[] serializerFeatureArr) {
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i2 |= serializerFeature.mask;
        }
        this.features = i2;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c2) {
        write(c2);
        return this;
    }

    public SerializeWriter(int i2) {
        this(null, i2);
    }

    public SerializeWriter(Writer writer, int i2) {
        this.writer = writer;
        if (i2 > 0) {
            this.buf = new char[i2];
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i2);
    }

    @Override // java.io.Writer
    public void write(String str, int i2, int i3) {
        int i4;
        int i5 = this.count + i3;
        if (i5 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i5);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i6 = this.count;
                    int i7 = length - i6;
                    i4 = i2 + i7;
                    str.getChars(i2, i4, cArr, i6);
                    this.count = this.buf.length;
                    flush();
                    i3 -= i7;
                    if (i3 <= this.buf.length) {
                        break;
                    } else {
                        i2 = i4;
                    }
                }
                i5 = i3;
                i2 = i4;
            }
        }
        str.getChars(i2, i3 + i2, this.buf, this.count);
        this.count = i5;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(boolean z) {
        write(z ? "true" : "false");
    }
}
