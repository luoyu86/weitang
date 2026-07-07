package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: classes2.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private BitMatrix matrix;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x007e A[PHI: r4
  0x007e: PHI (r4v3 int) = (r4v2 int), (r4v6 int), (r4v6 int) binds: [B:25:0x005b, B:27:0x005f, B:28:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int[][] calculateBlackPoints(byte[] r17, int r18, int r19, int r20, int r21) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = 2
            int[] r5 = new int[r4]
            r6 = 1
            r5[r6] = r0
            r6 = 0
            r5[r6] = r1
            java.lang.Class<int> r7 = int.class
            java.lang.Object r5 = java.lang.reflect.Array.newInstance(r7, r5)
            int[][] r5 = (int[][]) r5
            r7 = 0
        L1a:
            if (r7 >= r1) goto L8e
            int r8 = r7 << 3
            int r9 = r8 + 8
            if (r9 < r3) goto L24
            int r8 = r3 + (-8)
        L24:
            r9 = 0
        L25:
            if (r9 >= r0) goto L88
            int r10 = r9 << 3
            int r11 = r10 + 8
            if (r11 < r2) goto L2f
            int r10 = r2 + (-8)
        L2f:
            int r11 = r8 * r2
            int r11 = r11 + r10
            r10 = 255(0xff, float:3.57E-43)
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 255(0xff, float:3.57E-43)
        L39:
            r6 = 8
            if (r12 >= r6) goto L56
            r4 = 0
        L3e:
            if (r4 >= r6) goto L51
            int r16 = r11 + r4
            r6 = r17[r16]
            r6 = r6 & r10
            int r13 = r13 + r6
            if (r6 >= r15) goto L49
            r15 = r6
        L49:
            if (r6 <= r14) goto L4c
            r14 = r6
        L4c:
            int r4 = r4 + 1
            r6 = 8
            goto L3e
        L51:
            int r12 = r12 + 1
            int r11 = r11 + r2
            r4 = 2
            goto L39
        L56:
            int r4 = r13 >> 6
            int r14 = r14 - r15
            r6 = 24
            if (r14 > r6) goto L7e
            int r4 = r15 >> 1
            if (r7 <= 0) goto L7e
            if (r9 <= 0) goto L7e
            int r6 = r7 + (-1)
            r10 = r5[r6]
            r10 = r10[r9]
            r11 = r5[r7]
            int r12 = r9 + (-1)
            r11 = r11[r12]
            r13 = 2
            int r11 = r11 * 2
            int r10 = r10 + r11
            r6 = r5[r6]
            r6 = r6[r12]
            int r10 = r10 + r6
            int r6 = r10 >> 2
            if (r15 >= r6) goto L7f
            r4 = r6
            goto L7f
        L7e:
            r13 = 2
        L7f:
            r6 = r5[r7]
            r6[r9] = r4
            int r9 = r9 + 1
            r4 = 2
            r6 = 0
            goto L25
        L88:
            r13 = 2
            int r7 = r7 + 1
            r4 = 2
            r6 = 0
            goto L1a
        L8e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.common.HybridBinarizer.calculateBlackPoints(byte[], int, int, int, int):int[][]");
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, BitMatrix bitMatrix) {
        int i6 = 0;
        while (i6 < i3) {
            int i7 = i6 << 3;
            if (i7 + 8 >= i5) {
                i7 = i5 - 8;
            }
            int i8 = i7;
            int i9 = 0;
            while (i9 < i2) {
                int i10 = i9 << 3;
                if (i10 + 8 >= i4) {
                    i10 = i4 - 8;
                }
                int i11 = i10;
                int i12 = i9 > 1 ? i9 : 2;
                if (i12 >= i2 - 2) {
                    i12 = i2 - 3;
                }
                int i13 = i6 > 1 ? i6 : 2;
                if (i13 >= i3 - 2) {
                    i13 = i3 - 3;
                }
                int i14 = 0;
                for (int i15 = -2; i15 <= 2; i15++) {
                    int[] iArr2 = iArr[i13 + i15];
                    i14 += iArr2[i12 - 2] + iArr2[i12 - 1] + iArr2[i12] + iArr2[i12 + 1] + iArr2[i12 + 2];
                }
                threshold8x8Block(bArr, i11, i8, i14 / 25, i4, bitMatrix);
                i9++;
            }
            i6++;
        }
    }

    private static void threshold8x8Block(byte[] bArr, int i2, int i3, int i4, int i5, BitMatrix bitMatrix) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & 255) <= i4) {
                    bitMatrix.set(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    @Override // com.google.zxing.common.GlobalHistogramBinarizer, com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        if (luminanceSource.getWidth() < 40 || luminanceSource.getHeight() < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix = luminanceSource.getMatrix();
            int width = luminanceSource.getWidth();
            int height = luminanceSource.getHeight();
            int i2 = width >> 3;
            if ((width & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = height >> 3;
            if ((height & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] iArrCalculateBlackPoints = calculateBlackPoints(matrix, i3, i5, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix, i3, i5, width, height, iArrCalculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        }
        return this.matrix;
    }
}
