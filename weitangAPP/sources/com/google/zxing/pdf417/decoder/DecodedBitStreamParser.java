package com.google.zxing.pdf417.decoder;

import com.alipay.sdk.m.n.a;
import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.oned.rss.expanded.decoders.DecodedChar;
import java.math.BigInteger;
import org.apache.commons.codec.language.Soundex;
import org.apache.commons.codec.net.RFC1522Codec;

/* JADX INFO: loaded from: classes2.dex */
public final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = {';', '<', '>', '@', '[', '\\', '}', '_', '`', '~', '!', '\r', '\t', ',', ':', '\n', Soundex.SILENT_MARKER, '.', DecodedChar.FNC1, '/', '\"', '|', '*', '(', ')', RFC1522Codec.SEP, '{', '}', '\''};
    private static final char[] MIXED_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', '\r', '\t', ',', ':', '#', Soundex.SILENT_MARKER, '.', DecodedChar.FNC1, '/', '+', '%', '*', a.f5521h, '^'};

    /* JADX INFO: renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i2 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i2 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i2] = bigIntegerArr2[i2 - 1].multiply(bigIntegerValueOf);
            i2++;
        }
    }

    private DecodedBitStreamParser() {
    }

    private static int byteCompaction(int i2, int[] iArr, int i3, StringBuilder sb) {
        boolean z;
        boolean z2;
        long j = 900;
        int i4 = 6;
        if (i2 != 901) {
            if (i2 != BYTE_COMPACTION_MODE_LATCH_6) {
                return i3;
            }
            int i5 = i3;
            boolean z3 = false;
            int i6 = 0;
            long j2 = 0;
            while (i5 < iArr[0] && !z3) {
                int i7 = i5 + 1;
                int i8 = iArr[i5];
                if (i8 < 900) {
                    i6++;
                    j2 = (j2 * 900) + ((long) i8);
                    z = z3;
                    i5 = i7;
                } else {
                    boolean z4 = z3;
                    if (i8 != 900 && i8 != 901 && i8 != 902 && i8 != BYTE_COMPACTION_MODE_LATCH_6 && i8 != BEGIN_MACRO_PDF417_CONTROL_BLOCK && i8 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
                        if (i8 != MACRO_PDF417_TERMINATOR) {
                            z = z4;
                            i5 = i7;
                        }
                    }
                    i5 = i7 - 1;
                    z = true;
                }
                if (i6 % 5 != 0 || i6 <= 0) {
                    z2 = z;
                } else {
                    char[] cArr = new char[6];
                    int i9 = 0;
                    while (i9 < 6) {
                        cArr[5 - i9] = (char) (j2 & 255);
                        j2 >>= 8;
                        i9++;
                        z = z;
                    }
                    z2 = z;
                    sb.append(cArr);
                }
                z3 = z2;
            }
            return i5;
        }
        char[] cArr2 = new char[6];
        int[] iArr2 = new int[6];
        int i10 = i3;
        int i11 = 0;
        long j3 = 0;
        boolean z5 = false;
        while (i10 < iArr[0] && !z5) {
            int i12 = i10 + 1;
            int i13 = iArr[i10];
            if (i13 < 900) {
                iArr2[i11] = i13;
                i11++;
                j3 = (j3 * j) + ((long) i13);
            } else {
                if (i13 == 900 || i13 == 901 || i13 == 902 || i13 == BYTE_COMPACTION_MODE_LATCH_6 || i13 == BEGIN_MACRO_PDF417_CONTROL_BLOCK || i13 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i13 == MACRO_PDF417_TERMINATOR) {
                    i10 = i12 - 1;
                    z5 = true;
                }
                if (i11 % 5 != 0 && i11 > 0) {
                    int i14 = 0;
                    while (i14 < i4) {
                        cArr2[5 - i14] = (char) (j3 % 256);
                        j3 >>= 8;
                        i14++;
                        i4 = 6;
                    }
                    sb.append(cArr2);
                    i11 = 0;
                }
                j = 900;
                i4 = 6;
            }
            i10 = i12;
            if (i11 % 5 != 0) {
            }
            j = 900;
            i4 = 6;
        }
        for (int i15 = (i11 / 5) * 5; i15 < i11; i15++) {
            sb.append((char) iArr2[i15]);
        }
        return i10;
    }

    public static DecoderResult decode(int[] iArr) throws FormatException {
        int iByteCompaction;
        StringBuilder sb = new StringBuilder(100);
        int i2 = iArr[1];
        int i3 = 2;
        while (i3 < iArr[0]) {
            if (i2 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE && i2 != BYTE_COMPACTION_MODE_LATCH_6) {
                switch (i2) {
                    case 900:
                        iByteCompaction = textCompaction(iArr, i3, sb);
                        break;
                    case 901:
                        iByteCompaction = byteCompaction(i2, iArr, i3, sb);
                        break;
                    case 902:
                        iByteCompaction = numericCompaction(iArr, i3, sb);
                        break;
                    default:
                        iByteCompaction = textCompaction(iArr, i3 - 1, sb);
                        break;
                }
            } else {
                iByteCompaction = byteCompaction(i2, iArr, i3, sb);
            }
            if (iByteCompaction >= iArr.length) {
                throw FormatException.getFormatInstance();
            }
            i3 = iByteCompaction + 1;
            i2 = iArr[iByteCompaction];
        }
        return new DecoderResult(null, sb.toString(), null, null);
    }

    private static String decodeBase900toBase10(int[] iArr, int i2) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigIntegerAdd = bigIntegerAdd.add(EXP900[(i2 - i3) - 1].multiply(BigInteger.valueOf(iArr[i3])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        if (r6 == 26) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void decodeTextCompaction(int[] r15, int[] r16, int r17, java.lang.StringBuilder r18) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decodeTextCompaction(int[], int[], int, java.lang.StringBuilder):void");
    }

    private static int numericCompaction(int[] iArr, int i2, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i4 == iArr[0]) {
                z = true;
            }
            if (i5 < 900) {
                iArr2[i3] = i5;
                i3++;
            } else if (i5 == 900 || i5 == 901 || i5 == BYTE_COMPACTION_MODE_LATCH_6 || i5 == BEGIN_MACRO_PDF417_CONTROL_BLOCK || i5 == BEGIN_MACRO_PDF417_OPTIONAL_FIELD || i5 == MACRO_PDF417_TERMINATOR) {
                i4--;
                z = true;
            }
            if (i3 % 15 == 0 || i5 == 902 || z) {
                sb.append(decodeBase900toBase10(iArr2, i3));
                i3 = 0;
            }
            i2 = i4;
        }
        return i2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0031. Please report as an issue. */
    private static int textCompaction(int[] iArr, int i2, StringBuilder sb) {
        int[] iArr2 = new int[iArr[0] << 1];
        int[] iArr3 = new int[iArr[0] << 1];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i5 != BYTE_COMPACTION_MODE_LATCH_6) {
                    switch (i5) {
                    }
                }
                i2 = i4 - 1;
                z = true;
            } else {
                iArr2[i3] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i2 = i4 + 1;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i2 = i4;
        }
        decodeTextCompaction(iArr2, iArr3, i3, sb);
        return i2;
    }
}
