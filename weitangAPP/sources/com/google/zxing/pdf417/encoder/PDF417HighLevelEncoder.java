package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import com.tom_roush.pdfbox.pdfparser.BaseParser;
import java.math.BigInteger;
import java.util.Arrays;
import org.apache.commons.codec.binary.BaseNCodec;
import org.apache.commons.codec.net.URLCodec;

/* JADX INFO: loaded from: classes2.dex */
public final class PDF417HighLevelEncoder {
    private static final int BYTE_COMPACTION = 1;
    private static final int LATCH_TO_BYTE = 924;
    private static final int LATCH_TO_BYTE_PADDED = 901;
    private static final int LATCH_TO_NUMERIC = 902;
    private static final int LATCH_TO_TEXT = 900;
    private static final byte[] MIXED;
    private static final int NUMERIC_COMPACTION = 2;
    private static final int SHIFT_TO_BYTE = 913;
    private static final int SUBMODE_ALPHA = 0;
    private static final int SUBMODE_LOWER = 1;
    private static final int SUBMODE_MIXED = 2;
    private static final int SUBMODE_PUNCTUATION = 3;
    private static final int TEXT_COMPACTION = 0;
    private static final byte[] TEXT_MIXED_RAW = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, BaseParser.ASCII_CR, 9, 44, 58, 35, 45, 46, 36, 47, 43, URLCodec.ESCAPE_CHAR, 42, BaseNCodec.PAD_DEFAULT, 94, 0, 32, 0, 0, 0};
    private static final byte[] TEXT_PUNCTUATION_RAW = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, BaseParser.ASCII_CR, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
    private static final byte[] PUNCTUATION = new byte[128];

    static {
        byte[] bArr = new byte[128];
        MIXED = bArr;
        Arrays.fill(bArr, (byte) -1);
        byte b2 = 0;
        byte b3 = 0;
        while (true) {
            byte[] bArr2 = TEXT_MIXED_RAW;
            if (b3 >= bArr2.length) {
                break;
            }
            byte b4 = bArr2[b3];
            if (b4 > 0) {
                MIXED[b4] = b3;
            }
            b3 = (byte) (b3 + 1);
        }
        Arrays.fill(PUNCTUATION, (byte) -1);
        while (true) {
            byte[] bArr3 = TEXT_PUNCTUATION_RAW;
            if (b2 >= bArr3.length) {
                return;
            }
            byte b5 = bArr3[b2];
            if (b5 > 0) {
                PUNCTUATION[b5] = b2;
            }
            b2 = (byte) (b2 + 1);
        }
    }

    private PDF417HighLevelEncoder() {
    }

    private static int determineConsecutiveBinaryCount(CharSequence charSequence, byte[] bArr, int i2) throws WriterException {
        int i3;
        int i4;
        int length = charSequence.length();
        int i5 = i2;
        while (i5 < length) {
            char cCharAt = charSequence.charAt(i5);
            int i6 = 0;
            int i7 = 0;
            while (i7 < 13 && isDigit(cCharAt) && (i4 = i5 + (i7 = i7 + 1)) < length) {
                cCharAt = charSequence.charAt(i4);
            }
            if (i7 >= 13) {
                return i5 - i2;
            }
            while (i6 < 5 && isText(cCharAt) && (i3 = i5 + (i6 = i6 + 1)) < length) {
                cCharAt = charSequence.charAt(i3);
            }
            if (i6 >= 5) {
                return i5 - i2;
            }
            char cCharAt2 = charSequence.charAt(i5);
            if (bArr[i5] == 63 && cCharAt2 != '?') {
                throw new WriterException("Non-encodable character detected: " + cCharAt2 + " (Unicode: " + ((int) cCharAt2) + ')');
            }
            i5++;
        }
        return i5 - i2;
    }

    private static int determineConsecutiveDigitCount(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        if (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            while (isDigit(cCharAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    cCharAt = charSequence.charAt(i2);
                }
            }
        }
        return i3;
    }

    private static int determineConsecutiveTextCount(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = i2;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            int i4 = 0;
            while (i4 < 13 && isDigit(cCharAt) && i3 < length) {
                i4++;
                i3++;
                if (i3 < length) {
                    cCharAt = charSequence.charAt(i3);
                }
            }
            if (i4 >= 13) {
                return (i3 - i2) - i4;
            }
            if (i4 <= 0) {
                if (!isText(charSequence.charAt(i3))) {
                    break;
                }
                i3++;
            }
        }
        return i3 - i2;
    }

    private static void encodeBinary(byte[] bArr, int i2, int i3, int i4, StringBuilder sb) {
        int i5;
        if (i3 == 1 && i4 == 0) {
            sb.append((char) 913);
        }
        if (i3 >= 6) {
            sb.append((char) 924);
            char[] cArr = new char[5];
            i5 = i2;
            while ((i2 + i3) - i5 >= 6) {
                long j = 0;
                for (int i6 = 0; i6 < 6; i6++) {
                    j = (j << 8) + ((long) (bArr[i5 + i6] & 255));
                }
                for (int i7 = 0; i7 < 5; i7++) {
                    cArr[i7] = (char) (j % 900);
                    j /= 900;
                }
                for (int i8 = 4; i8 >= 0; i8--) {
                    sb.append(cArr[i8]);
                }
                i5 += 6;
            }
        } else {
            i5 = i2;
        }
        int i9 = i2 + i3;
        if (i5 < i9) {
            sb.append((char) 901);
        }
        while (i5 < i9) {
            sb.append((char) (bArr[i5] & 255));
            i5++;
        }
    }

    public static String encodeHighLevel(String str, Compaction compaction) throws WriterException {
        int iDetermineConsecutiveDigitCount;
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        if (compaction == Compaction.TEXT) {
            encodeText(str, 0, length, sb, 0);
        } else if (compaction == Compaction.BYTE) {
            byte[] bytesForMessage = getBytesForMessage(str);
            encodeBinary(bytesForMessage, 0, bytesForMessage.length, 1, sb);
        } else if (compaction == Compaction.NUMERIC) {
            sb.append((char) 902);
            encodeNumeric(str, 0, length, sb);
        } else {
            byte[] bytesForMessage2 = null;
            int i2 = 0;
            int i3 = 0;
            loop0: while (true) {
                int iEncodeText = 0;
                while (i2 < length) {
                    iDetermineConsecutiveDigitCount = determineConsecutiveDigitCount(str, i2);
                    if (iDetermineConsecutiveDigitCount >= 13) {
                        break;
                    }
                    int iDetermineConsecutiveTextCount = determineConsecutiveTextCount(str, i2);
                    if (iDetermineConsecutiveTextCount >= 5 || iDetermineConsecutiveDigitCount == length) {
                        if (i3 != 0) {
                            sb.append((char) 900);
                            i3 = 0;
                            iEncodeText = 0;
                        }
                        iEncodeText = encodeText(str, i2, iDetermineConsecutiveTextCount, sb, iEncodeText);
                        i2 += iDetermineConsecutiveTextCount;
                    } else {
                        if (bytesForMessage2 == null) {
                            bytesForMessage2 = getBytesForMessage(str);
                        }
                        int iDetermineConsecutiveBinaryCount = determineConsecutiveBinaryCount(str, bytesForMessage2, i2);
                        if (iDetermineConsecutiveBinaryCount == 0) {
                            iDetermineConsecutiveBinaryCount = 1;
                        }
                        if (iDetermineConsecutiveBinaryCount == 1 && i3 == 0) {
                            encodeBinary(bytesForMessage2, i2, 1, 0, sb);
                        } else {
                            encodeBinary(bytesForMessage2, i2, iDetermineConsecutiveBinaryCount, i3, sb);
                            i3 = 1;
                            iEncodeText = 0;
                        }
                        i2 += iDetermineConsecutiveBinaryCount;
                    }
                }
                sb.append((char) 902);
                i3 = 2;
                encodeNumeric(str, i2, iDetermineConsecutiveDigitCount, sb);
                i2 += iDetermineConsecutiveDigitCount;
            }
        }
        return sb.toString();
    }

    private static void encodeNumeric(String str, int i2, int i3, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i3 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i4 = 0;
        while (i4 < i3 - 1) {
            sb2.setLength(0);
            int iMin = Math.min(44, i3 - i4);
            StringBuilder sb3 = new StringBuilder();
            sb3.append('1');
            int i5 = i2 + i4;
            sb3.append(str.substring(i5, i5 + iMin));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i4 += iMin;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x00f6 A[EDGE_INSN: B:76:0x00f6->B:55:0x00f6 BREAK  A[LOOP:0: B:3:0x0011->B:93:0x0011], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0011 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int encodeText(java.lang.CharSequence r16, int r17, int r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.encoder.PDF417HighLevelEncoder.encodeText(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    private static byte[] getBytesForMessage(String str) {
        return str.getBytes();
    }

    private static boolean isAlphaLower(char c2) {
        return c2 == ' ' || (c2 >= 'a' && c2 <= 'z');
    }

    private static boolean isAlphaUpper(char c2) {
        return c2 == ' ' || (c2 >= 'A' && c2 <= 'Z');
    }

    private static boolean isDigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean isMixed(char c2) {
        return MIXED[c2] != -1;
    }

    private static boolean isPunctuation(char c2) {
        return PUNCTUATION[c2] != -1;
    }

    private static boolean isText(char c2) {
        return c2 == '\t' || c2 == '\n' || c2 == '\r' || (c2 >= ' ' && c2 <= '~');
    }
}
