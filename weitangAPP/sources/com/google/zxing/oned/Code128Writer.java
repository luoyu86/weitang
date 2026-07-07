package com.google.zxing.oned;

import com.chinavisionary.microtang.life.vo.SubmitLifeOrderVo;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Code128Writer extends UPCEANWriter {
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_B = 100;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final char ESCAPE_FNC_1 = 241;
    private static final char ESCAPE_FNC_2 = 242;
    private static final char ESCAPE_FNC_3 = 243;
    private static final char ESCAPE_FNC_4 = 244;

    private static boolean isDigits(CharSequence charSequence, int i2, int i3) {
        int i4 = i3 + i2;
        int length = charSequence.length();
        while (i2 < i4 && i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt < '0' || cCharAt > '9') {
                if (cCharAt != 241) {
                    return false;
                }
                i4++;
            }
            i2++;
        }
        return i4 <= length;
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.encode(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got " + barcodeFormat);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public byte[] encode(String str) {
        int length = str.length();
        if (length >= 1 && length <= 80) {
            int iAppendPattern = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt < ' ' || cCharAt > '~') {
                    switch (cCharAt) {
                        case SubmitLifeOrderVo.ITEM_TYPE_CB /* 241 */:
                        case 242:
                        case 243:
                        case 244:
                            break;
                        default:
                            throw new IllegalArgumentException("Bad character in input: " + cCharAt);
                    }
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 1;
            while (i3 < length) {
                int iCharAt = 100;
                int i7 = isDigits(str, i3, i5 == 99 ? 2 : 4) ? 99 : 100;
                if (i7 == i5) {
                    if (i5 != 100) {
                        switch (str.charAt(i3)) {
                            case SubmitLifeOrderVo.ITEM_TYPE_CB /* 241 */:
                                iCharAt = 102;
                                break;
                            case 242:
                                iCharAt = 97;
                                break;
                            case 243:
                                iCharAt = 96;
                                break;
                            case 244:
                                break;
                            default:
                                int i8 = i3 + 2;
                                iCharAt = Integer.parseInt(str.substring(i3, i8));
                                i3 = i8;
                                break;
                        }
                    } else {
                        iCharAt = str.charAt(i3) - ' ';
                    }
                    i3++;
                } else {
                    iCharAt = i5 == 0 ? i7 == 100 ? 104 : 105 : i7;
                    i5 = i7;
                }
                arrayList.add(Code128Reader.CODE_PATTERNS[iCharAt]);
                i4 += iCharAt * i6;
                if (i3 != 0) {
                    i6++;
                }
            }
            int[][] iArr = Code128Reader.CODE_PATTERNS;
            arrayList.add(iArr[i4 % 103]);
            arrayList.add(iArr[106]);
            int i9 = 0;
            for (int[] iArr2 : arrayList) {
                for (int i10 : iArr2) {
                    i9 += i10;
                }
            }
            byte[] bArr = new byte[i9];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                iAppendPattern += OneDimensionalCodeWriter.appendPattern(bArr, iAppendPattern, (int[]) it.next(), 1);
            }
            return bArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + length);
    }
}
