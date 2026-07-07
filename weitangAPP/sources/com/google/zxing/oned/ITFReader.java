package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ITFReader extends OneDReader {
    private static final int MAX_AVG_VARIANCE = 107;
    private static final int MAX_INDIVIDUAL_VARIANCE = 204;
    private static final int N = 1;
    private static final int W = 3;
    private int narrowLineWidth = -1;
    private static final int[] DEFAULT_ALLOWED_LENGTHS = {44, 24, 20, 18, 16, 14, 12, 10, 8, 6};
    private static final int[] START_PATTERN = {1, 1, 1, 1};
    private static final int[] END_PATTERN_REVERSED = {1, 1, 3};
    public static final int[][] PATTERNS = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    private static int decodeDigit(int[] iArr) throws NotFoundException {
        int length = PATTERNS.length;
        int i2 = 107;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            int iPatternMatchVariance = OneDReader.patternMatchVariance(iArr, PATTERNS[i4], 204);
            if (iPatternMatchVariance < i2) {
                i3 = i4;
                i2 = iPatternMatchVariance;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static void decodeMiddle(BitArray bitArray, int i2, int i3, StringBuilder sb) throws NotFoundException {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i2 < i3) {
            OneDReader.recordPattern(bitArray, i2, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 << 1;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (decodeDigit(iArr2) + 48));
            sb.append((char) (decodeDigit(iArr3) + 48));
            for (int i6 = 0; i6 < 10; i6++) {
                i2 += iArr[i6];
            }
        }
    }

    private static int[] findGuardPattern(BitArray bitArray, int i2, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int size = bitArray.getSize();
        int i3 = i2;
        boolean z = false;
        int i4 = 0;
        while (i2 < size) {
            if (bitArray.get(i2) ^ z) {
                iArr2[i4] = iArr2[i4] + 1;
            } else {
                int i5 = length - 1;
                if (i4 != i5) {
                    i4++;
                } else {
                    if (OneDReader.patternMatchVariance(iArr2, iArr, 204) < 107) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i6 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i4--;
                }
                iArr2[i4] = 1;
                z = !z;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int skipWhiteSpace(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        if (nextSet != size) {
            return nextSet;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void validateQuietZone(BitArray bitArray, int i2) throws NotFoundException {
        int i3 = this.narrowLineWidth * 10;
        for (int i4 = i2 - 1; i3 > 0 && i4 >= 0 && !bitArray.get(i4); i4--) {
            i3--;
        }
        if (i3 != 0) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public int[] decodeEnd(BitArray bitArray) throws NotFoundException {
        bitArray.reverse();
        try {
            int[] iArrFindGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), END_PATTERN_REVERSED);
            validateQuietZone(bitArray, iArrFindGuardPattern[0]);
            int i2 = iArrFindGuardPattern[0];
            iArrFindGuardPattern[0] = bitArray.getSize() - iArrFindGuardPattern[1];
            iArrFindGuardPattern[1] = bitArray.getSize() - i2;
            return iArrFindGuardPattern;
        } finally {
            bitArray.reverse();
        }
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        boolean z;
        int[] iArrDecodeStart = decodeStart(bitArray);
        int[] iArrDecodeEnd = decodeEnd(bitArray);
        StringBuilder sb = new StringBuilder(20);
        decodeMiddle(bitArray, iArrDecodeStart[1], iArrDecodeEnd[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = DEFAULT_ALLOWED_LENGTHS;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length2) {
                z = false;
                break;
            }
            if (length == iArr[i3]) {
                z = true;
                break;
            }
            i3++;
        }
        if (!z) {
            throw FormatException.getFormatInstance();
        }
        float f2 = i2;
        return new Result(string, null, new ResultPoint[]{new ResultPoint(iArrDecodeStart[1], f2), new ResultPoint(iArrDecodeEnd[0], f2)}, BarcodeFormat.ITF);
    }

    public int[] decodeStart(BitArray bitArray) throws NotFoundException {
        int[] iArrFindGuardPattern = findGuardPattern(bitArray, skipWhiteSpace(bitArray), START_PATTERN);
        this.narrowLineWidth = (iArrFindGuardPattern[1] - iArrFindGuardPattern[0]) >> 2;
        validateQuietZone(bitArray, iArrFindGuardPattern[0]);
        return iArrFindGuardPattern;
    }
}
