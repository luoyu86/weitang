package com.google.zxing.oned;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.taobao.accs.flowcontrol.FlowControl;
import java.util.Map;
import okhttp3.internal.http.StatusLine;

/* JADX INFO: loaded from: classes2.dex */
public final class Code93Reader extends OneDReader {
    private static final int ASTERISK_ENCODING;
    private static final int[] CHARACTER_ENCODINGS;
    private static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, FlowControl.STATUS_FLOW_CTRL_ALL, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 404, 402, 394, 360, 356, 354, StatusLine.HTTP_PERM_REDIRECT, 282, 344, 332, 326, 300, 278, 436, 434, 428, FlowControl.STATUS_FLOW_CTRL_BRUSH, 406, TTAdConstant.IMAGE_LIST_SIZE_CODE, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[47];
    }

    private static void checkChecksums(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        checkOneChecksum(charSequence, length - 2, 20);
        checkOneChecksum(charSequence, length - 1, 15);
    }

    private static void checkOneChecksum(CharSequence charSequence, int i2, int i3) throws ChecksumException {
        int iIndexOf = 0;
        int i4 = 1;
        for (int i5 = i2 - 1; i5 >= 0; i5--) {
            iIndexOf += ALPHABET_STRING.indexOf(charSequence.charAt(i5)) * i4;
            i4++;
            if (i4 > i3) {
                i4 = 1;
            }
        }
        if (charSequence.charAt(i2) != ALPHABET[iIndexOf % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private static String decodeExtended(CharSequence charSequence) throws FormatException {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt >= 'a' && cCharAt <= 'd') {
                i3++;
                char cCharAt2 = charSequence.charAt(i3);
                switch (cCharAt) {
                    case 'a':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        }
                        i2 = cCharAt2 - '@';
                        c2 = (char) i2;
                        sb.append(c2);
                        break;
                    case 'b':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                            i2 = cCharAt2 - '&';
                        } else {
                            if (cCharAt2 < 'F' || cCharAt2 > 'W') {
                                throw FormatException.getFormatInstance();
                            }
                            i2 = cCharAt2 - 11;
                        }
                        c2 = (char) i2;
                        sb.append(c2);
                        break;
                    case 'c':
                        if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                            i2 = cCharAt2 - ' ';
                            c2 = (char) i2;
                            sb.append(c2);
                        } else {
                            if (cCharAt2 != 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            c2 = ':';
                            sb.append(c2);
                        }
                        break;
                    case 'd':
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        }
                        i2 = cCharAt2 + ' ';
                        c2 = (char) i2;
                        sb.append(c2);
                        break;
                    default:
                        c2 = 0;
                        sb.append(c2);
                        break;
                }
            } else {
                sb.append(cCharAt);
            }
            i3++;
        }
        return sb.toString();
    }

    private static int[] findAsteriskPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        int i2 = nextSet;
        boolean z = false;
        int i3 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 != 5) {
                    i3++;
                } else {
                    if (toPattern(iArr) == ASTERISK_ENCODING) {
                        return new int[]{i2, nextSet};
                    }
                    i2 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, 4);
                    iArr[4] = 0;
                    iArr[5] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char patternToChar(int i2) throws NotFoundException {
        int i3 = 0;
        while (true) {
            int[] iArr = CHARACTER_ENCODINGS;
            if (i3 >= iArr.length) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (iArr[i3] == i2) {
                return ALPHABET[i3];
            }
            i3++;
        }
    }

    private static int toPattern(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = ((iArr[i5] << 8) * 9) / i2;
            int i7 = i6 >> 8;
            if ((i6 & 255) > 127) {
                i7++;
            }
            if (i7 < 1 || i7 > 4) {
                return -1;
            }
            if ((i5 & 1) == 0) {
                for (int i8 = 0; i8 < i7; i8++) {
                    i4 = (i4 << 1) | 1;
                }
            } else {
                i4 <<= i7;
            }
        }
        return i4;
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray)[1]);
        int size = bitArray.getSize();
        StringBuilder sb = new StringBuilder(20);
        int[] iArr = new int[6];
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int pattern = toPattern(iArr);
            if (pattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char cPatternToChar = patternToChar(pattern);
            sb.append(cPatternToChar);
            int i3 = nextSet;
            for (int i4 = 0; i4 < 6; i4++) {
                i3 += iArr[i4];
            }
            int nextSet2 = bitArray.getNextSet(i3);
            if (cPatternToChar == '*') {
                sb.deleteCharAt(sb.length() - 1);
                if (nextSet2 == size || !bitArray.get(nextSet2)) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sb.length() < 2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                checkChecksums(sb);
                sb.setLength(sb.length() - 2);
                float f2 = i2;
                return new Result(decodeExtended(sb), null, new ResultPoint[]{new ResultPoint((r14[1] + r14[0]) / 2.0f, f2), new ResultPoint((nextSet2 + nextSet) / 2.0f, f2)}, BarcodeFormat.CODE_93);
            }
            nextSet = nextSet2;
        }
    }
}
