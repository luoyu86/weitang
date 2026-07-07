package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class OneDimensionalCodeWriter implements Writer {
    private final int sidesMargin;

    public OneDimensionalCodeWriter(int i2) {
        this.sidesMargin = i2;
    }

    public static int appendPattern(byte[] bArr, int i2, int[] iArr, int i3) {
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("startColor must be either 0 or 1, but got: " + i3);
        }
        byte b2 = (byte) i3;
        int i4 = 0;
        for (int i5 : iArr) {
            for (int i6 = 0; i6 < i5; i6++) {
                bArr[i2] = b2;
                i2++;
                i4++;
            }
            b2 = (byte) (b2 ^ 1);
        }
        return i4;
    }

    private BitMatrix renderResult(byte[] bArr, int i2, int i3) {
        int length = bArr.length;
        int i4 = this.sidesMargin + length;
        int iMax = Math.max(i2, i4);
        int iMax2 = Math.max(1, i3);
        int i5 = iMax / i4;
        int i6 = (iMax - (length * i5)) / 2;
        BitMatrix bitMatrix = new BitMatrix(iMax, iMax2);
        int i7 = 0;
        while (i7 < length) {
            if (bArr[i7] == 1) {
                bitMatrix.setRegion(i6, 0, i5, iMax2);
            }
            i7++;
            i6 += i5;
        }
        return bitMatrix;
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return encode(str, barcodeFormat, i2, i3, null);
    }

    public abstract byte[] encode(String str);

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i2 >= 0 && i3 >= 0) {
            return renderResult(encode(str), i2, i3);
        }
        throw new IllegalArgumentException("Negative size is not allowed. Input: " + i2 + 'x' + i3);
    }
}
