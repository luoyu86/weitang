package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class EAN8Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 67;

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.encode(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public byte[] encode(String str) {
        if (str.length() == 8) {
            byte[] bArr = new byte[67];
            int iAppendPattern = OneDimensionalCodeWriter.appendPattern(bArr, 0, UPCEANReader.START_END_PATTERN, 1) + 0;
            int i2 = 0;
            while (i2 <= 3) {
                int i3 = i2 + 1;
                iAppendPattern += OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern, UPCEANReader.L_PATTERNS[Integer.parseInt(str.substring(i2, i3))], 0);
                i2 = i3;
            }
            int iAppendPattern2 = iAppendPattern + OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern, UPCEANReader.MIDDLE_PATTERN, 0);
            int i4 = 4;
            while (i4 <= 7) {
                int i5 = i4 + 1;
                iAppendPattern2 += OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern2, UPCEANReader.L_PATTERNS[Integer.parseInt(str.substring(i4, i5))], 1);
                i4 = i5;
            }
            OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern2, UPCEANReader.START_END_PATTERN, 1);
            return bArr;
        }
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + str.length());
    }
}
