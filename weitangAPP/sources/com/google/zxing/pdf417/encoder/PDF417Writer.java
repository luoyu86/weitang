package com.google.zxing.pdf417.encoder;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.lang.reflect.Array;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class PDF417Writer implements Writer {
    private static BitMatrix bitMatrixFromEncoder(PDF417 pdf417, String str, int i2, int i3) throws WriterException {
        boolean z;
        pdf417.generateBarcodeLogic(str, 2);
        byte[][] scaledMatrix = pdf417.getBarcodeMatrix().getScaledMatrix(2, 8);
        if ((i3 > i2) ^ (scaledMatrix[0].length < scaledMatrix.length)) {
            scaledMatrix = rotateArray(scaledMatrix);
            z = true;
        } else {
            z = false;
        }
        int length = i2 / scaledMatrix[0].length;
        int length2 = i3 / scaledMatrix.length;
        if (length >= length2) {
            length = length2;
        }
        if (length <= 1) {
            return bitMatrixFrombitArray(scaledMatrix);
        }
        byte[][] scaledMatrix2 = pdf417.getBarcodeMatrix().getScaledMatrix(length * 2, length * 4 * 2);
        if (z) {
            scaledMatrix2 = rotateArray(scaledMatrix2);
        }
        return bitMatrixFrombitArray(scaledMatrix2);
    }

    private static BitMatrix bitMatrixFrombitArray(byte[][] bArr) {
        BitMatrix bitMatrix = new BitMatrix(bArr.length + 60, bArr[0].length + 60);
        bitMatrix.clear();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            for (int i3 = 0; i3 < bArr[0].length; i3++) {
                if (bArr[i2][i3] == 1) {
                    bitMatrix.set(i2 + 30, i3 + 30);
                }
            }
        }
        return bitMatrix;
    }

    private static PDF417 initializeEncoder(BarcodeFormat barcodeFormat, boolean z) {
        if (barcodeFormat == BarcodeFormat.PDF_417) {
            PDF417 pdf417 = new PDF417();
            pdf417.setCompact(z);
            return pdf417;
        }
        throw new IllegalArgumentException("Can only encode PDF_417, but got " + barcodeFormat);
    }

    private static byte[][] rotateArray(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) byte.class, bArr[0].length, bArr.length);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int length = (bArr.length - i2) - 1;
            for (int i3 = 0; i3 < bArr[0].length; i3++) {
                bArr2[i3][length] = bArr[i2][i3];
            }
        }
        return bArr2;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        return encode(str, barcodeFormat, i2, i3);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return bitMatrixFromEncoder(initializeEncoder(barcodeFormat, false), str, i2, i3);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, Compaction compaction) throws WriterException {
        PDF417 pdf417InitializeEncoder = initializeEncoder(barcodeFormat, z);
        pdf417InitializeEncoder.setDimensions(i5, i4, i7, i6);
        pdf417InitializeEncoder.setCompaction(compaction);
        return bitMatrixFromEncoder(pdf417InitializeEncoder, str, i2, i3);
    }
}
