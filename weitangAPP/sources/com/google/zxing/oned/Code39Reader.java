package com.google.zxing.oned;

import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.qq.e.comm.adevent.AdEventType;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Code39Reader extends OneDReader {
    private static final int ASTERISK_ENCODING;
    public static final int[] CHARACTER_ENCODINGS;
    private final boolean extendedMode;
    private final boolean usingCheckDigit;
    public static final String ALPHABET_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
    private static final char[] ALPHABET = ALPHABET_STRING.toCharArray();

    static {
        int[] iArr = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION, 400, AdEventType.VIDEO_CLICKED, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, 388, 196, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_INDEPENDENT_PROCESS, 168, 162, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, 42};
        CHARACTER_ENCODINGS = iArr;
        ASTERISK_ENCODING = iArr[39];
    }

    public Code39Reader() {
        this.usingCheckDigit = false;
        this.extendedMode = false;
    }

    private static String decodeExtended(CharSequence charSequence) throws FormatException {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (cCharAt == '+' || cCharAt == '$' || cCharAt == '%' || cCharAt == '/') {
                i3++;
                char cCharAt2 = charSequence.charAt(i3);
                if (cCharAt != '$') {
                    if (cCharAt != '%') {
                        if (cCharAt != '+') {
                            if (cCharAt != '/') {
                                c2 = 0;
                            } else if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                i2 = cCharAt2 - ' ';
                            } else {
                                if (cCharAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                }
                                c2 = ':';
                            }
                            sb.append(c2);
                        } else {
                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                throw FormatException.getFormatInstance();
                            }
                            i2 = cCharAt2 + ' ';
                        }
                    } else if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                        i2 = cCharAt2 - '&';
                    } else {
                        if (cCharAt2 < 'F' || cCharAt2 > 'W') {
                            throw FormatException.getFormatInstance();
                        }
                        i2 = cCharAt2 - 11;
                    }
                } else {
                    if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                        throw FormatException.getFormatInstance();
                    }
                    i2 = cCharAt2 - '@';
                }
                c2 = (char) i2;
                sb.append(c2);
            } else {
                sb.append(cCharAt);
            }
            i3++;
        }
        return sb.toString();
    }

    private static int[] findAsteriskPattern(BitArray bitArray, int[] iArr) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int length = iArr.length;
        int i2 = nextSet;
        boolean z = false;
        int i3 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                int i4 = length - 1;
                if (i3 != i4) {
                    i3++;
                } else {
                    if (toNarrowWidePattern(iArr) == ASTERISK_ENCODING && bitArray.isRange(Math.max(0, i2 - ((nextSet - i2) >> 1)), i2, false)) {
                        return new int[]{i2, nextSet};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i5 = length - 2;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i4] = 0;
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

    private static int toNarrowWidePattern(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (iArr[i8] > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (iArr[i10] > i3) {
                        i5--;
                        if ((i11 << 1) >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            }
            if (i5 <= 3) {
                return -1;
            }
            i2 = i3;
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] iArr = new int[9];
        int nextSet = bitArray.getNextSet(findAsteriskPattern(bitArray, iArr)[1]);
        int size = bitArray.getSize();
        StringBuilder sb = new StringBuilder(20);
        while (true) {
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            int narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern < 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            char cPatternToChar = patternToChar(narrowWidePattern);
            sb.append(cPatternToChar);
            int i3 = nextSet;
            for (int i4 = 0; i4 < 9; i4++) {
                i3 += iArr[i4];
            }
            int nextSet2 = bitArray.getNextSet(i3);
            if (cPatternToChar == '*') {
                sb.setLength(sb.length() - 1);
                int i5 = 0;
                for (int i6 = 0; i6 < 9; i6++) {
                    i5 += iArr[i6];
                }
                int i7 = (nextSet2 - nextSet) - i5;
                if (nextSet2 != size && (i7 >> 1) < i5) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (this.usingCheckDigit) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i8 = 0; i8 < length; i8++) {
                        iIndexOf += ALPHABET_STRING.indexOf(sb.charAt(i8));
                    }
                    if (sb.charAt(length) != ALPHABET[iIndexOf % 43]) {
                        throw ChecksumException.getChecksumInstance();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw NotFoundException.getNotFoundInstance();
                }
                float f2 = i2;
                return new Result(this.extendedMode ? decodeExtended(sb) : sb.toString(), null, new ResultPoint[]{new ResultPoint((r1[1] + r1[0]) / 2.0f, f2), new ResultPoint((nextSet2 + nextSet) / 2.0f, f2)}, BarcodeFormat.CODE_39);
            }
            nextSet = nextSet2;
        }
    }

    public Code39Reader(boolean z) {
        this.usingCheckDigit = z;
        this.extendedMode = false;
    }

    public Code39Reader(boolean z, boolean z2) {
        this.usingCheckDigit = z;
        this.extendedMode = z2;
    }
}
