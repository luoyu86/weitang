package com.google.zxing.qrcode.encoder;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/* JADX INFO: loaded from: classes2.dex */
public final class MatrixUtil {
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;
    private static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] HORIZONTAL_SEPARATION_PATTERN = {new int[]{0, 0, 0, 0, 0, 0, 0, 0}};
    private static final int[][] VERTICAL_SEPARATION_PATTERN = {new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, -1}, new int[]{6, 34, 60, 86, 112, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, -1}, new int[]{6, 30, 58, 86, 114, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, -1}, new int[]{6, 34, 62, 90, 118, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH, -1}, new int[]{6, 30, 54, 78, 102, 126, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, 158}, new int[]{6, 32, 58, 84, 110, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 162}, new int[]{6, 26, 54, 82, 110, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK, TTAdConstant.IMAGE_MODE_LIVE}, new int[]{6, 30, 58, 86, 114, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 170}};
    private static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private MatrixUtil() {
    }

    public static void buildMatrix(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        clearMatrix(byteMatrix);
        embedBasicPatterns(i2, byteMatrix);
        embedTypeInfo(errorCorrectionLevel, i3, byteMatrix);
        maybeEmbedVersionInfo(i2, byteMatrix);
        embedDataBits(bitArray, i3, byteMatrix);
    }

    public static int calculateBCHCode(int i2, int i3) {
        int iFindMSBSet = findMSBSet(i3);
        int iFindMSBSet2 = i2 << (iFindMSBSet - 1);
        while (findMSBSet(iFindMSBSet2) >= iFindMSBSet) {
            iFindMSBSet2 ^= i3 << (findMSBSet(iFindMSBSet2) - iFindMSBSet);
        }
        return iFindMSBSet2;
    }

    public static void clearMatrix(ByteMatrix byteMatrix) {
        byteMatrix.clear((byte) -1);
    }

    public static void embedBasicPatterns(int i2, ByteMatrix byteMatrix) throws WriterException {
        embedPositionDetectionPatternsAndSeparators(byteMatrix);
        embedDarkDotAtLeftBottomCorner(byteMatrix);
        maybeEmbedPositionAdjustmentPatterns(i2, byteMatrix);
        embedTimingPatterns(byteMatrix);
    }

    private static void embedDarkDotAtLeftBottomCorner(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) == 0) {
            throw new WriterException();
        }
        byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
    }

    public static void embedDataBits(BitArray bitArray, int i2, ByteMatrix byteMatrix) throws WriterException {
        boolean z;
        int width = byteMatrix.getWidth() - 1;
        int height = byteMatrix.getHeight() - 1;
        int i3 = 0;
        int i4 = -1;
        while (width > 0) {
            if (width == 6) {
                width--;
            }
            while (height >= 0 && height < byteMatrix.getHeight()) {
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = width - i5;
                    if (isEmpty(byteMatrix.get(i6, height))) {
                        if (i3 < bitArray.getSize()) {
                            z = bitArray.get(i3);
                            i3++;
                        } else {
                            z = false;
                        }
                        if (i2 != -1 && MaskUtil.getDataMaskBit(i2, i6, height)) {
                            z = !z;
                        }
                        byteMatrix.set(i6, height, z);
                    }
                }
                height += i4;
            }
            i4 = -i4;
            height += i4;
            width -= 2;
        }
        if (i3 == bitArray.getSize()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i3 + '/' + bitArray.getSize());
    }

    private static void embedHorizontalSeparationPattern(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        int[][] iArr = HORIZONTAL_SEPARATION_PATTERN;
        if (iArr[0].length != 8 || iArr.length != 1) {
            throw new WriterException("Bad horizontal separation pattern");
        }
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (!isEmpty(byteMatrix.get(i5, i3))) {
                throw new WriterException();
            }
            byteMatrix.set(i5, i3, HORIZONTAL_SEPARATION_PATTERN[0][i4]);
        }
    }

    private static void embedPositionAdjustmentPattern(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        int[][] iArr = POSITION_ADJUSTMENT_PATTERN;
        if (iArr[0].length != 5 || iArr.length != 5) {
            throw new WriterException("Bad position adjustment");
        }
        for (int i4 = 0; i4 < 5; i4++) {
            for (int i5 = 0; i5 < 5; i5++) {
                int i6 = i2 + i5;
                int i7 = i3 + i4;
                if (!isEmpty(byteMatrix.get(i6, i7))) {
                    throw new WriterException();
                }
                byteMatrix.set(i6, i7, POSITION_ADJUSTMENT_PATTERN[i4][i5]);
            }
        }
    }

    private static void embedPositionDetectionPattern(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        int[][] iArr = POSITION_DETECTION_PATTERN;
        if (iArr[0].length != 7 || iArr.length != 7) {
            throw new WriterException("Bad position detection pattern");
        }
        for (int i4 = 0; i4 < 7; i4++) {
            for (int i5 = 0; i5 < 7; i5++) {
                int i6 = i2 + i5;
                int i7 = i3 + i4;
                if (!isEmpty(byteMatrix.get(i6, i7))) {
                    throw new WriterException();
                }
                byteMatrix.set(i6, i7, POSITION_DETECTION_PATTERN[i4][i5]);
            }
        }
    }

    private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix byteMatrix) throws WriterException {
        int length = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, byteMatrix);
        embedPositionDetectionPattern(byteMatrix.getWidth() - length, 0, byteMatrix);
        embedPositionDetectionPattern(0, byteMatrix.getWidth() - length, byteMatrix);
        int length2 = HORIZONTAL_SEPARATION_PATTERN[0].length;
        int i2 = length2 - 1;
        embedHorizontalSeparationPattern(0, i2, byteMatrix);
        embedHorizontalSeparationPattern(byteMatrix.getWidth() - length2, i2, byteMatrix);
        embedHorizontalSeparationPattern(0, byteMatrix.getWidth() - length2, byteMatrix);
        int length3 = VERTICAL_SEPARATION_PATTERN.length;
        embedVerticalSeparationPattern(length3, 0, byteMatrix);
        embedVerticalSeparationPattern((byteMatrix.getHeight() - length3) - 1, 0, byteMatrix);
        embedVerticalSeparationPattern(length3, byteMatrix.getHeight() - length3, byteMatrix);
    }

    private static void embedTimingPatterns(ByteMatrix byteMatrix) throws WriterException {
        int i2 = 8;
        while (i2 < byteMatrix.getWidth() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (!isValidValue(byteMatrix.get(i2, 6))) {
                throw new WriterException();
            }
            if (isEmpty(byteMatrix.get(i2, 6))) {
                byteMatrix.set(i2, 6, i4);
            }
            if (!isValidValue(byteMatrix.get(6, i2))) {
                throw new WriterException();
            }
            if (isEmpty(byteMatrix.get(6, i2))) {
                byteMatrix.set(6, i2, i4);
            }
            i2 = i3;
        }
    }

    public static void embedTypeInfo(ErrorCorrectionLevel errorCorrectionLevel, int i2, ByteMatrix byteMatrix) throws WriterException {
        BitArray bitArray = new BitArray();
        makeTypeInfoBits(errorCorrectionLevel, i2, bitArray);
        for (int i3 = 0; i3 < bitArray.getSize(); i3++) {
            boolean z = bitArray.get((bitArray.getSize() - 1) - i3);
            int[][] iArr = TYPE_INFO_COORDINATES;
            byteMatrix.set(iArr[i3][0], iArr[i3][1], z);
            if (i3 < 8) {
                byteMatrix.set((byteMatrix.getWidth() - i3) - 1, 8, z);
            } else {
                byteMatrix.set(8, (byteMatrix.getHeight() - 7) + (i3 - 8), z);
            }
        }
    }

    private static void embedVerticalSeparationPattern(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        int[][] iArr = VERTICAL_SEPARATION_PATTERN;
        if (iArr[0].length != 1 || iArr.length != 7) {
            throw new WriterException("Bad vertical separation pattern");
        }
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (!isEmpty(byteMatrix.get(i2, i5))) {
                throw new WriterException();
            }
            byteMatrix.set(i2, i5, VERTICAL_SEPARATION_PATTERN[i4][0]);
        }
    }

    public static int findMSBSet(int i2) {
        int i3 = 0;
        while (i2 != 0) {
            i2 >>>= 1;
            i3++;
        }
        return i3;
    }

    private static boolean isEmpty(int i2) {
        return i2 == -1;
    }

    private static boolean isValidValue(int i2) {
        return i2 == -1 || i2 == 0 || i2 == 1;
    }

    public static void makeTypeInfoBits(ErrorCorrectionLevel errorCorrectionLevel, int i2, BitArray bitArray) throws WriterException {
        if (!QRCode.isValidMaskPattern(i2)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i2;
        bitArray.appendBits(bits, 5);
        bitArray.appendBits(calculateBCHCode(bits, TYPE_INFO_POLY), 10);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(TYPE_INFO_MASK_PATTERN, 15);
        bitArray.xor(bitArray2);
        if (bitArray.getSize() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    public static void makeVersionInfoBits(int i2, BitArray bitArray) throws WriterException {
        bitArray.appendBits(i2, 6);
        bitArray.appendBits(calculateBCHCode(i2, VERSION_INFO_POLY), 12);
        if (bitArray.getSize() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    private static void maybeEmbedPositionAdjustmentPatterns(int i2, ByteMatrix byteMatrix) throws WriterException {
        if (i2 < 2) {
            return;
        }
        int i3 = i2 - 1;
        int[][] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
        int[] iArr2 = iArr[i3];
        int length = iArr[i3].length;
        for (int i4 = 0; i4 < length; i4++) {
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = iArr2[i4];
                int i7 = iArr2[i5];
                if (i7 != -1 && i6 != -1 && isEmpty(byteMatrix.get(i7, i6))) {
                    embedPositionAdjustmentPattern(i7 - 2, i6 - 2, byteMatrix);
                }
            }
        }
    }

    public static void maybeEmbedVersionInfo(int i2, ByteMatrix byteMatrix) throws WriterException {
        if (i2 < 7) {
            return;
        }
        BitArray bitArray = new BitArray();
        makeVersionInfoBits(i2, bitArray);
        int i3 = 17;
        for (int i4 = 0; i4 < 6; i4++) {
            for (int i5 = 0; i5 < 3; i5++) {
                boolean z = bitArray.get(i3);
                i3--;
                byteMatrix.set(i4, (byteMatrix.getHeight() - 11) + i5, z);
                byteMatrix.set((byteMatrix.getHeight() - 11) + i5, i4, z);
            }
        }
    }
}
