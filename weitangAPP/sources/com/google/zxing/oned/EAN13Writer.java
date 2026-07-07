package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class EAN13Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 95;

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.encode(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public byte[] encode(String str) {
        if (str.length() == 13) {
            int i2 = EAN13Reader.FIRST_DIGIT_ENCODINGS[Integer.parseInt(str.substring(0, 1))];
            byte[] bArr = new byte[95];
            int iAppendPattern = OneDimensionalCodeWriter.appendPattern(bArr, 0, UPCEANReader.START_END_PATTERN, 1) + 0;
            int i3 = 1;
            while (i3 <= 6) {
                int i4 = i3 + 1;
                int i5 = Integer.parseInt(str.substring(i3, i4));
                if (((i2 >> (6 - i3)) & 1) == 1) {
                    i5 += 10;
                }
                iAppendPattern += OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern, UPCEANReader.L_AND_G_PATTERNS[i5], 0);
                i3 = i4;
            }
            int iAppendPattern2 = iAppendPattern + OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern, UPCEANReader.MIDDLE_PATTERN, 0);
            int i6 = 7;
            while (i6 <= 12) {
                int i7 = i6 + 1;
                iAppendPattern2 += OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern2, UPCEANReader.L_PATTERNS[Integer.parseInt(str.substring(i6, i7))], 1);
                i6 = i7;
            }
            OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern2, UPCEANReader.START_END_PATTERN, 1);
            return bArr;
        }
        throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + str.length());
    }
}
