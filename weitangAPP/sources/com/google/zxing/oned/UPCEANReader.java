package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UPCEANReader extends OneDReader {
    public static final int[][] L_AND_G_PATTERNS;
    public static final int[][] L_PATTERNS;
    private static final int MAX_AVG_VARIANCE = 122;
    private static final int MAX_INDIVIDUAL_VARIANCE = 179;
    public static final int[] START_END_PATTERN = {1, 1, 1};
    public static final int[] MIDDLE_PATTERN = {1, 1, 1, 1, 1};
    private final StringBuilder decodeRowStringBuffer = new StringBuilder(20);
    private final UPCEANExtensionSupport extensionReader = new UPCEANExtensionSupport();
    private final EANManufacturerOrgSupport eanManSupport = new EANManufacturerOrgSupport();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        L_PATTERNS = iArr;
        int[][] iArr2 = new int[20][];
        L_AND_G_PATTERNS = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr3 = L_PATTERNS[i2 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i3 = 0; i3 < iArr3.length; i3++) {
                iArr4[i3] = iArr3[(iArr3.length - i3) - 1];
            }
            L_AND_G_PATTERNS[i2] = iArr4;
        }
    }

    private static boolean checkStandardUPCEANChecksum(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = 0;
        for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
            int iCharAt = charSequence.charAt(i3) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i2 += iCharAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
            int iCharAt2 = charSequence.charAt(i5) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i4 += iCharAt2;
        }
        return i4 % 10 == 0;
    }

    public static int decodeDigit(BitArray bitArray, int[] iArr, int i2, int[][] iArr2) throws NotFoundException {
        OneDReader.recordPattern(bitArray, i2, iArr);
        int length = iArr2.length;
        int i3 = 122;
        int i4 = -1;
        for (int i5 = 0; i5 < length; i5++) {
            int iPatternMatchVariance = OneDReader.patternMatchVariance(iArr, iArr2[i5], MAX_INDIVIDUAL_VARIANCE);
            if (iPatternMatchVariance < i3) {
                i4 = i5;
                i3 = iPatternMatchVariance;
            }
        }
        if (i4 >= 0) {
            return i4;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] findGuardPattern(BitArray bitArray, int i2, boolean z, int[] iArr) throws NotFoundException {
        return findGuardPattern(bitArray, i2, z, iArr, new int[iArr.length]);
    }

    public static int[] findStartGuardPattern(BitArray bitArray) throws NotFoundException {
        int[] iArr = new int[START_END_PATTERN.length];
        int[] iArrFindGuardPattern = null;
        boolean zIsRange = false;
        int i2 = 0;
        while (!zIsRange) {
            int[] iArr2 = START_END_PATTERN;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrFindGuardPattern = findGuardPattern(bitArray, i2, false, iArr2, iArr);
            int i3 = iArrFindGuardPattern[0];
            int i4 = iArrFindGuardPattern[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                zIsRange = bitArray.isRange(i5, i3, false);
            }
            i2 = i4;
        }
        return iArrFindGuardPattern;
    }

    public boolean checkChecksum(String str) throws ChecksumException, FormatException {
        return checkStandardUPCEANChecksum(str);
    }

    public int[] decodeEnd(BitArray bitArray, int i2) throws NotFoundException {
        return findGuardPattern(bitArray, i2, false, START_END_PATTERN);
    }

    public abstract int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException;

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i2, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return decodeRow(i2, bitArray, findStartGuardPattern(bitArray), map);
    }

    public abstract BarcodeFormat getBarcodeFormat();

    public static int[] findGuardPattern(BitArray bitArray, int i2, boolean z, int[] iArr, int[] iArr2) throws NotFoundException {
        int length = iArr.length;
        int size = bitArray.getSize();
        int nextUnset = z ? bitArray.getNextUnset(i2) : bitArray.getNextSet(i2);
        boolean z2 = z;
        int i3 = 0;
        int i4 = nextUnset;
        while (nextUnset < size) {
            if (bitArray.get(nextUnset) ^ z2) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                int i5 = length - 1;
                if (i3 != i5) {
                    i3++;
                } else {
                    if (OneDReader.patternMatchVariance(iArr2, iArr, MAX_INDIVIDUAL_VARIANCE) < 122) {
                        return new int[]{i4, nextUnset};
                    }
                    i4 += iArr2[0] + iArr2[1];
                    int i6 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z2 = !z2;
            }
            nextUnset++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public Result decodeRow(int i2, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        String strLookupCountryIdentifier;
        ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((iArr[0] + iArr[1]) / 2.0f, i2));
        }
        StringBuilder sb = this.decodeRowStringBuffer;
        sb.setLength(0);
        int iDecodeMiddle = decodeMiddle(bitArray, iArr, sb);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint(iDecodeMiddle, i2));
        }
        int[] iArrDecodeEnd = decodeEnd(bitArray, iDecodeMiddle);
        if (resultPointCallback != null) {
            resultPointCallback.foundPossibleResultPoint(new ResultPoint((iArrDecodeEnd[0] + iArrDecodeEnd[1]) / 2.0f, i2));
        }
        int i3 = iArrDecodeEnd[1];
        int i4 = (i3 - iArrDecodeEnd[0]) + i3;
        if (i4 >= bitArray.getSize() || !bitArray.isRange(i3, i4, false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        String string = sb.toString();
        if (!checkChecksum(string)) {
            throw ChecksumException.getChecksumInstance();
        }
        BarcodeFormat barcodeFormat = getBarcodeFormat();
        float f2 = i2;
        Result result = new Result(string, null, new ResultPoint[]{new ResultPoint((iArr[1] + iArr[0]) / 2.0f, f2), new ResultPoint((iArrDecodeEnd[1] + iArrDecodeEnd[0]) / 2.0f, f2)}, barcodeFormat);
        try {
            Result resultDecodeRow = this.extensionReader.decodeRow(i2, bitArray, iArrDecodeEnd[1]);
            result.putAllMetadata(resultDecodeRow.getResultMetadata());
            result.addResultPoints(resultDecodeRow.getResultPoints());
        } catch (ReaderException unused) {
        }
        if ((barcodeFormat == BarcodeFormat.EAN_13 || barcodeFormat == BarcodeFormat.UPC_A) && (strLookupCountryIdentifier = this.eanManSupport.lookupCountryIdentifier(string)) != null) {
            result.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, strLookupCountryIdentifier);
        }
        return result;
    }
}
