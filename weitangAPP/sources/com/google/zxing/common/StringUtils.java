package com.google.zxing.common;

import com.google.zxing.DecodeHintType;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class StringUtils {
    private static final boolean ASSUME_SHIFT_JIS;
    private static final String EUC_JP = "EUC_JP";
    public static final String GB2312 = "GB2312";
    private static final String ISO88591 = "ISO8859_1";
    private static final String PLATFORM_DEFAULT_ENCODING;
    public static final String SHIFT_JIS = "SJIS";
    private static final String UTF8 = "UTF8";

    static {
        String property = System.getProperty("file.encoding");
        PLATFORM_DEFAULT_ENCODING = property;
        ASSUME_SHIFT_JIS = SHIFT_JIS.equalsIgnoreCase(property) || EUC_JP.equalsIgnoreCase(property);
    }

    private StringUtils() {
    }

    public static String guessEncoding(byte[] bArr, Map<DecodeHintType, ?> map) {
        int i2;
        int i3;
        String str;
        if (map != null && (str = (String) map.get(DecodeHintType.CHARACTER_SET)) != null) {
            return str;
        }
        if (bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return UTF8;
        }
        int length = bArr.length;
        boolean z = true;
        boolean z2 = true;
        boolean z3 = true;
        int i4 = 0;
        boolean z4 = false;
        int i5 = 0;
        int i6 = 0;
        boolean z5 = false;
        boolean z6 = false;
        for (int i7 = 0; i7 < length && (z || z2 || z3); i7++) {
            int i8 = bArr[i7] & 255;
            if (i8 < 128 || i8 > 191) {
                if (i4 > 0) {
                    z3 = false;
                }
                if (i8 >= 192 && i8 <= 253) {
                    for (int i9 = i8; (i9 & 64) != 0; i9 <<= 1) {
                        i4++;
                    }
                    z4 = true;
                }
            } else if (i4 > 0) {
                i4--;
            }
            if ((i8 == 194 || i8 == 195) && i7 < length - 1 && (i2 = bArr[i7 + 1] & 255) <= 191 && ((i8 == 194 && i2 >= 160) || (i8 == 195 && i2 >= 128))) {
                z5 = true;
            }
            if (i8 >= 127 && i8 <= 159) {
                z = false;
            }
            if (i8 >= 161 && i8 <= 223 && !z6) {
                i6++;
            }
            if (!z6 && ((i8 >= 240 && i8 <= 255) || i8 == 128 || i8 == 160)) {
                z2 = false;
            }
            if (((i8 < 129 || i8 > 159) && (i8 < 224 || i8 > 239)) || z6) {
                z6 = false;
            } else {
                if (i7 < bArr.length - 1 && (i3 = bArr[i7 + 1] & 255) >= 64 && i3 <= 252) {
                    i5++;
                } else {
                    z2 = false;
                }
                z6 = true;
            }
        }
        return (z2 && ASSUME_SHIFT_JIS) ? SHIFT_JIS : ((i4 > 0 ? false : z3) && z4) ? UTF8 : (!z2 || (i5 < 3 && i6 * 20 <= length)) ? (z5 || !z) ? PLATFORM_DEFAULT_ENCODING : ISO88591 : SHIFT_JIS;
    }
}
