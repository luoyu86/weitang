package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class UPCEANExtensionSupport {
    private final int[] decodeMiddleCounters = new int[4];
    private final StringBuilder decodeRowStringBuffer = new StringBuilder();
    private static final int[] EXTENSION_START_PATTERN = {1, 1, 2};
    private static final int[] CHECK_DIGIT_ENCODINGS = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    private static int determineCheckDigit(int i2) throws NotFoundException {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == CHECK_DIGIT_ENCODINGS[i3]) {
                return i3;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int extensionChecksum(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            iCharAt += charSequence.charAt(i2) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            iCharAt2 += charSequence.charAt(i3) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    private static Integer parseExtension2String(String str) {
        return Integer.valueOf(str);
    }

    private static String parseExtension5String(String str) {
        String strValueOf;
        char cCharAt = str.charAt(0);
        String str2 = "";
        if (cCharAt == '0') {
            str2 = "£";
        } else if (cCharAt == '5') {
            str2 = "$";
        } else if (cCharAt == '9') {
            if ("90000".equals(str)) {
                return null;
            }
            if ("99991".equals(str)) {
                return "0.00";
            }
            if ("99990".equals(str)) {
                return "Used";
            }
        }
        int i2 = Integer.parseInt(str.substring(1));
        String strValueOf2 = String.valueOf(i2 / 100);
        int i3 = i2 % 100;
        if (i3 < 10) {
            strValueOf = "0" + i3;
        } else {
            strValueOf = String.valueOf(i3);
        }
        return str2 + strValueOf2 + '.' + strValueOf;
    }

    private static Map<ResultMetadataType, Object> parseExtensionString(String str) {
        ResultMetadataType resultMetadataType;
        Object extension2String;
        int length = str.length();
        if (length == 2) {
            resultMetadataType = ResultMetadataType.ISSUE_NUMBER;
            extension2String = parseExtension2String(str);
        } else {
            if (length != 5) {
                return null;
            }
            resultMetadataType = ResultMetadataType.SUGGESTED_PRICE;
            extension2String = parseExtension5String(str);
        }
        if (extension2String == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put(resultMetadataType, extension2String);
        return enumMap;
    }

    public int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int nextUnset = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 5 && nextUnset < size; i3++) {
            int iDecodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, nextUnset, UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((iDecodeDigit % 10) + 48));
            for (int i4 : iArr2) {
                nextUnset += i4;
            }
            if (iDecodeDigit >= 10) {
                i2 |= 1 << (4 - i3);
            }
            if (i3 != 4) {
                nextUnset = bitArray.getNextUnset(bitArray.getNextSet(nextUnset));
            }
        }
        if (sb.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (extensionChecksum(sb.toString()) == determineCheckDigit(i2)) {
            return nextUnset;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public Result decodeRow(int i2, BitArray bitArray, int i3) throws NotFoundException {
        int[] iArrFindGuardPattern = UPCEANReader.findGuardPattern(bitArray, i3, false, EXTENSION_START_PATTERN);
        StringBuilder sb = this.decodeRowStringBuffer;
        sb.setLength(0);
        int iDecodeMiddle = decodeMiddle(bitArray, iArrFindGuardPattern, sb);
        String string = sb.toString();
        Map<ResultMetadataType, Object> extensionString = parseExtensionString(string);
        float f2 = i2;
        Result result = new Result(string, null, new ResultPoint[]{new ResultPoint((iArrFindGuardPattern[0] + iArrFindGuardPattern[1]) / 2.0f, f2), new ResultPoint(iDecodeMiddle, f2)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (extensionString != null) {
            result.putAllMetadata(extensionString);
        }
        return result;
    }
}
