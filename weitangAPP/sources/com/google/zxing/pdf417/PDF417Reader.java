package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.pdf417.decoder.Decoder;
import com.google.zxing.pdf417.detector.Detector;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class PDF417Reader implements Reader {
    private static final ResultPoint[] NO_POINTS = new ResultPoint[0];
    private final Decoder decoder = new Decoder();

    private static BitMatrix extractPureBits(BitMatrix bitMatrix) throws NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iModuleSize = moduleSize(topLeftOnBit, bitMatrix);
        int i2 = topLeftOnBit[1];
        int i3 = bottomRightOnBit[1];
        int iFindPatternStart = findPatternStart(topLeftOnBit[0], i2, bitMatrix);
        int iFindPatternEnd = ((findPatternEnd(topLeftOnBit[0], i2, bitMatrix) - iFindPatternStart) + 1) / iModuleSize;
        int i4 = ((i3 - i2) + 1) / iModuleSize;
        if (iFindPatternEnd <= 0 || i4 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i5 = iModuleSize >> 1;
        int i6 = i2 + i5;
        int i7 = iFindPatternStart + i5;
        BitMatrix bitMatrix2 = new BitMatrix(iFindPatternEnd, i4);
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = (i8 * iModuleSize) + i6;
            for (int i10 = 0; i10 < iFindPatternEnd; i10++) {
                if (bitMatrix.get((i10 * iModuleSize) + i7, i9)) {
                    bitMatrix2.set(i10, i8);
                }
            }
        }
        return bitMatrix2;
    }

    private static int findPatternEnd(int i2, int i3, BitMatrix bitMatrix) throws NotFoundException {
        boolean z = true;
        int width = bitMatrix.getWidth() - 1;
        while (width > i2 && !bitMatrix.get(width, i3)) {
            width--;
        }
        int i4 = 0;
        while (width > i2 && i4 < 9) {
            width--;
            boolean z2 = bitMatrix.get(width, i3);
            if (z != z2) {
                i4++;
            }
            z = z2;
        }
        if (width != i2) {
            return width;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int findPatternStart(int i2, int i3, BitMatrix bitMatrix) throws NotFoundException {
        int i4;
        int width = bitMatrix.getWidth();
        int i5 = 0;
        boolean z = true;
        while (true) {
            i4 = width - 1;
            if (i2 >= i4 || i5 >= 8) {
                break;
            }
            i2++;
            boolean z2 = bitMatrix.get(i2, i3);
            if (z != z2) {
                i5++;
            }
            z = z2;
        }
        if (i2 != i4) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int moduleSize(int[] iArr, BitMatrix bitMatrix) throws NotFoundException {
        int i2 = iArr[0];
        int i3 = iArr[1];
        int width = bitMatrix.getWidth();
        while (i2 < width && bitMatrix.get(i2, i3)) {
            i2++;
        }
        if (i2 == width) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i4 = (i2 - iArr[0]) >>> 3;
        if (i4 != 0) {
            return i4;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) throws NotFoundException, FormatException {
        return decode(binaryBitmap, null);
    }

    @Override // com.google.zxing.Reader
    public void reset() {
    }

    @Override // com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPoint[] points;
        DecoderResult decoderResultDecode;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            DetectorResult detectorResultDetect = new Detector(binaryBitmap).detect();
            DecoderResult decoderResultDecode2 = this.decoder.decode(detectorResultDetect.getBits());
            points = detectorResultDetect.getPoints();
            decoderResultDecode = decoderResultDecode2;
        } else {
            decoderResultDecode = this.decoder.decode(extractPureBits(binaryBitmap.getBlackMatrix()));
            points = NO_POINTS;
        }
        return new Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), points, BarcodeFormat.PDF_417);
    }
}
