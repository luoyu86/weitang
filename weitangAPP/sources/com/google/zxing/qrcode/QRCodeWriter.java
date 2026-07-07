package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class QRCodeWriter implements Writer {
    private static final int QUIET_ZONE_SIZE = 4;

    private static BitMatrix renderResult(QRCode qRCode, int i2, int i3) {
        ByteMatrix matrix = qRCode.getMatrix();
        if (matrix == null) {
            throw new IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int i4 = width + 8;
        int i5 = height + 8;
        int iMax = Math.max(i2, i4);
        int iMax2 = Math.max(i3, i5);
        int iMin = Math.min(iMax / i4, iMax2 / i5);
        int i6 = (iMax - (width * iMin)) / 2;
        int i7 = (iMax2 - (height * iMin)) / 2;
        BitMatrix bitMatrix = new BitMatrix(iMax, iMax2);
        int i8 = 0;
        while (i8 < height) {
            int i9 = i6;
            int i10 = 0;
            while (i10 < width) {
                if (matrix.get(i10, i8) == 1) {
                    bitMatrix.setRegion(i9, i7, iMin, iMin);
                }
                i10++;
                i9 += iMin;
            }
            i8++;
            i7 += iMin;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return encode(str, barcodeFormat, i2, i3, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        ErrorCorrectionLevel errorCorrectionLevel;
        if (str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        ErrorCorrectionLevel errorCorrectionLevel2 = ErrorCorrectionLevel.L;
        if (map != null && (errorCorrectionLevel = (ErrorCorrectionLevel) map.get(EncodeHintType.ERROR_CORRECTION)) != null) {
            errorCorrectionLevel2 = errorCorrectionLevel;
        }
        QRCode qRCode = new QRCode();
        Encoder.encode(str, errorCorrectionLevel2, map, qRCode);
        return renderResult(qRCode, i2, i3);
    }
}
