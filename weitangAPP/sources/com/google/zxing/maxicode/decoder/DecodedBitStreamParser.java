package com.google.zxing.maxicode.decoder;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.common.DecoderResult;
import com.tom_roush.fontbox.ttf.GlyfDescript;
import com.tom_roush.pdfbox.pdfparser.BaseParser;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.commons.codec.net.URLCodec;

/* JADX INFO: loaded from: classes2.dex */
public final class DecodedBitStreamParser {
    private static final char ECI = 65530;
    private static final char FS = 28;
    private static final char GS = 29;
    private static final char LATCHA = 65527;
    private static final char LATCHB = 65528;
    private static final char LOCK = 65529;
    private static final char NS = 65531;
    private static final char PAD = 65532;
    private static final char RS = 30;
    private static final char SHIFTA = 65520;
    private static final char SHIFTB = 65521;
    private static final char SHIFTC = 65522;
    private static final char SHIFTD = 65523;
    private static final char SHIFTE = 65524;
    private static final char THREESHIFTA = 65526;
    private static final char TWOSHIFTA = 65525;
    private static final NumberFormat NINE_DIGITS = new DecimalFormat("000000000");
    private static final NumberFormat THREE_DIGITS = new DecimalFormat("000");
    private static final String[] SETS = {"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb ￼\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{￼}~\u007f;<=>?[\\]^_ ,./:@!|￼\ufff5\ufff6￼\ufff0\ufff2\ufff3\ufff4\ufff7", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ\ufffa\u001c\u001d\u001eÛÜÝÞßª¬±²³µ¹º¼½¾\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú\ufffa\u001c\u001d\u001e\ufffbûüýþÿ¡¨«¯°´·¸»¿\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa￼￼\u001b\ufffb\u001c\u001d\u001e\u001f\u009f ¢£¤¥¦§©\u00ad®¶\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    private DecodedBitStreamParser() {
    }

    public static DecoderResult decode(byte[] bArr, int i2) {
        String postCode3;
        StringBuilder sb = new StringBuilder(TTDownloadField.CALL_DOWNLOAD_MODEL_SET_HEADERS);
        if (i2 == 2 || i2 == 3) {
            if (i2 == 2) {
                postCode3 = new DecimalFormat("0000000000".substring(0, getPostCode2Length(bArr))).format(getPostCode2(bArr));
            } else {
                postCode3 = getPostCode3(bArr);
            }
            NumberFormat numberFormat = THREE_DIGITS;
            String str = numberFormat.format(getCountry(bArr));
            String str2 = numberFormat.format(getServiceClass(bArr));
            sb.append(getMessage(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, postCode3 + GS + str + GS + str2 + GS);
            } else {
                sb.insert(0, postCode3 + GS + str + GS + str2 + GS);
            }
        } else if (i2 == 4) {
            sb.append(getMessage(bArr, 1, 93));
        } else if (i2 == 5) {
            sb.append(getMessage(bArr, 1, 77));
        }
        return new DecoderResult(bArr, sb.toString(), null, String.valueOf(i2));
    }

    private static int getBit(int i2, byte[] bArr) {
        int i3 = i2 - 1;
        return ((1 << (5 - (i3 % 6))) & bArr[i3 / 6]) == 0 ? 0 : 1;
    }

    private static int getCountry(byte[] bArr) {
        return getInt(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, URLCodec.ESCAPE_CHAR, 38});
    }

    private static int getInt(byte[] bArr, byte[] bArr2) {
        int bit = 0;
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            bit += getBit(bArr2[i2], bArr) << ((bArr2.length - i2) - 1);
        }
        return bit;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String getMessage(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        int i4 = i2;
        int i5 = 0;
        int i6 = -1;
        int i7 = 0;
        while (i4 < i2 + i3) {
            char cCharAt = SETS[i5].charAt(bArr[i4]);
            switch (cCharAt) {
                case 65520:
                case 65521:
                case 65522:
                case 65523:
                case 65524:
                    i7 = i5;
                    i5 = cCharAt - SHIFTA;
                    i6 = 1;
                    break;
                case 65525:
                    i6 = 2;
                    i7 = i5;
                    i5 = 0;
                    break;
                case 65526:
                    i6 = 3;
                    i7 = i5;
                    i5 = 0;
                    break;
                case 65527:
                    i5 = 0;
                    i6 = -1;
                    break;
                case 65528:
                    i5 = 1;
                    i6 = -1;
                    break;
                case 65529:
                    i6 = -1;
                    break;
                case 65530:
                default:
                    sb.append(cCharAt);
                    break;
                case 65531:
                    int i8 = i4 + 1;
                    int i9 = bArr[i8] << 24;
                    int i10 = i8 + 1;
                    int i11 = i9 + (bArr[i10] << 18);
                    int i12 = i10 + 1;
                    int i13 = i11 + (bArr[i12] << 12);
                    int i14 = i12 + 1;
                    int i15 = i13 + (bArr[i14] << 6);
                    i4 = i14 + 1;
                    sb.append(NINE_DIGITS.format(i15 + bArr[i4]));
                    break;
            }
            int i16 = i6 - 1;
            if (i6 == 0) {
                i5 = i7;
            }
            i4++;
            i6 = i16;
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == 65532) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    private static int getPostCode2(byte[] bArr) {
        return getInt(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, BaseParser.ASCII_CR, 14, 15, GlyfDescript.X_DUAL, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2});
    }

    private static int getPostCode2Length(byte[] bArr) {
        return getInt(bArr, new byte[]{39, 40, 41, 42, 31, 32});
    }

    private static String getPostCode3(byte[] bArr) {
        String[] strArr = SETS;
        return String.valueOf(new char[]{strArr[0].charAt(getInt(bArr, new byte[]{39, 40, 41, 42, 31, 32})), strArr[0].charAt(getInt(bArr, new byte[]{33, 34, 35, 36, 25, 26})), strArr[0].charAt(getInt(bArr, new byte[]{27, 28, 29, 30, 19, 20})), strArr[0].charAt(getInt(bArr, new byte[]{21, 22, 23, 24, BaseParser.ASCII_CR, 14})), strArr[0].charAt(getInt(bArr, new byte[]{15, GlyfDescript.X_DUAL, 17, 18, 7, 8})), strArr[0].charAt(getInt(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
    }

    private static int getServiceClass(byte[] bArr) {
        return getInt(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52});
    }
}
