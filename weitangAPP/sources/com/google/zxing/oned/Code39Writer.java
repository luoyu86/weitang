package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Code39Writer extends UPCEANWriter {
    private static void toIntArray(int i2, int[] iArr) {
        for (int i3 = 0; i3 < 9; i3++) {
            int i4 = 1;
            if (((1 << i3) & i2) != 0) {
                i4 = 2;
            }
            iArr[i3] = i4;
        }
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.encode(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + barcodeFormat);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public byte[] encode(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            int i2 = length + 25;
            for (int i3 = 0; i3 < length; i3++) {
                toIntArray(Code39Reader.CHARACTER_ENCODINGS[Code39Reader.ALPHABET_STRING.indexOf(str.charAt(i3))], iArr);
                for (int i4 = 0; i4 < 9; i4++) {
                    i2 += iArr[i4];
                }
            }
            byte[] bArr = new byte[i2];
            toIntArray(Code39Reader.CHARACTER_ENCODINGS[39], iArr);
            int iAppendPattern = OneDimensionalCodeWriter.appendPattern(bArr, 0, iArr, 1);
            int[] iArr2 = {1};
            int iAppendPattern2 = iAppendPattern + OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern, iArr2, 0);
            for (int i5 = length - 1; i5 >= 0; i5--) {
                toIntArray(Code39Reader.CHARACTER_ENCODINGS[Code39Reader.ALPHABET_STRING.indexOf(str.charAt(i5))], iArr);
                int iAppendPattern3 = iAppendPattern2 + OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern2, iArr, 1);
                iAppendPattern2 = iAppendPattern3 + OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern3, iArr2, 0);
            }
            toIntArray(Code39Reader.CHARACTER_ENCODINGS[39], iArr);
            OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern2, iArr, 1);
            return bArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
    }
}
