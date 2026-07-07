package com.google.zxing.oned;

import androidx.appcompat.widget.ActivityChooserView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class CodaBarReader extends OneDReader {
    private static final int minCharacterLength = 6;
    private static final String ALPHABET_STRING = "0123456789-$:/.+ABCDTN";
    public static final char[] ALPHABET = ALPHABET_STRING.toCharArray();
    public static final int[] CHARACTER_ENCODINGS = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14, 26, 41};
    private static final char[] STARTEND_ENCODING = {'E', '*', 'A', 'B', 'C', 'D', 'T', 'N'};

    public static boolean arrayContains(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[] findAsteriskPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[7];
        int i2 = nextSet;
        boolean z = false;
        int i3 = 0;
        while (nextSet < size) {
            if (bitArray.get(nextSet) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 == 6) {
                    try {
                        if (arrayContains(STARTEND_ENCODING, toNarrowWidePattern(iArr)) && bitArray.isRange(Math.max(0, i2 - ((nextSet - i2) / 2)), i2, false)) {
                            return new int[]{i2, nextSet};
                        }
                    } catch (IllegalArgumentException unused) {
                    }
                    i2 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, 5);
                    iArr[5] = 0;
                    iArr[6] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArr[i3] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char toNarrowWidePattern(int[] iArr) {
        int length = iArr.length;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (iArr[i4] < i2) {
                i2 = iArr[i4];
            }
            if (iArr[i4] > i3) {
                i3 = iArr[i4];
            }
        }
        do {
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                if (iArr[i7] > i3) {
                    i6 |= 1 << ((length - 1) - i7);
                    i5++;
                }
            }
            if (i5 == 2 || i5 == 3) {
                int i8 = 0;
                while (true) {
                    int[] iArr2 = CHARACTER_ENCODINGS;
                    if (i8 >= iArr2.length) {
                        break;
                    }
                    if (iArr2[i8] == i6) {
                        return ALPHABET[i8];
                    }
                    i8++;
                }
            }
            i3--;
        } while (i3 > i2);
        return '!';
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i3;
        int[] iArrFindAsteriskPattern = findAsteriskPattern(bitArray);
        iArrFindAsteriskPattern[1] = 0;
        int nextSet = bitArray.getNextSet(iArrFindAsteriskPattern[1]);
        int size = bitArray.getSize();
        StringBuilder sb = new StringBuilder();
        int[] iArr = new int[7];
        while (true) {
            for (int i4 = 0; i4 < 7; i4++) {
                iArr[i4] = 0;
            }
            OneDReader.recordPattern(bitArray, nextSet, iArr);
            char narrowWidePattern = toNarrowWidePattern(iArr);
            if (narrowWidePattern == '!') {
                throw NotFoundException.getNotFoundInstance();
            }
            sb.append(narrowWidePattern);
            int i5 = nextSet;
            for (int i6 = 0; i6 < 7; i6++) {
                i5 += iArr[i6];
            }
            int nextSet2 = bitArray.getNextSet(i5);
            if (nextSet2 >= size) {
                int i7 = 0;
                for (int i8 = 0; i8 < 7; i8++) {
                    i7 += iArr[i8];
                }
                int i9 = (nextSet2 - nextSet) - i7;
                if (nextSet2 != size && i9 / 2 < i7) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sb.length() < 2) {
                    throw NotFoundException.getNotFoundInstance();
                }
                char cCharAt = sb.charAt(0);
                if (!arrayContains(STARTEND_ENCODING, cCharAt)) {
                    throw NotFoundException.getNotFoundInstance();
                }
                int i10 = 1;
                while (true) {
                    if (i10 >= sb.length()) {
                        break;
                    }
                    if (sb.charAt(i10) == cCharAt && (i3 = i10 + 1) != sb.length()) {
                        sb.delete(i3, sb.length() - 1);
                        break;
                    }
                    i10++;
                }
                if (sb.length() <= 6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(0);
                float f2 = i2;
                return new Result(sb.toString(), null, new ResultPoint[]{new ResultPoint((iArrFindAsteriskPattern[1] + iArrFindAsteriskPattern[0]) / 2.0f, f2), new ResultPoint((nextSet2 + nextSet) / 2.0f, f2)}, BarcodeFormat.CODABAR);
            }
            nextSet = nextSet2;
        }
    }
}
