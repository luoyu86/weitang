package com.google.zxing.qrcode.encoder;

/* JADX INFO: loaded from: classes2.dex */
public final class MaskUtil {
    private MaskUtil() {
    }

    public static int applyMaskPenaltyRule1(ByteMatrix byteMatrix) {
        return applyMaskPenaltyRule1Internal(byteMatrix, true) + applyMaskPenaltyRule1Internal(byteMatrix, false);
    }

    private static int applyMaskPenaltyRule1Internal(ByteMatrix byteMatrix, boolean z) {
        int height = z ? byteMatrix.getHeight() : byteMatrix.getWidth();
        int width = z ? byteMatrix.getWidth() : byteMatrix.getHeight();
        byte[][] array = byteMatrix.getArray();
        byte b2 = -1;
        int i2 = 0;
        for (int i3 = 0; i3 < height; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < width; i5++) {
                byte b3 = z ? array[i3][i5] : array[i5][i3];
                if (b3 == b2) {
                    i4++;
                    if (i4 == 5) {
                        i2 += 3;
                    } else if (i4 > 5) {
                        i2++;
                    }
                } else {
                    b2 = b3;
                    i4 = 1;
                }
            }
        }
        return i2;
    }

    public static int applyMaskPenaltyRule2(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i2 = 0;
        for (int i3 = 0; i3 < height - 1; i3++) {
            int i4 = 0;
            while (i4 < width - 1) {
                byte b2 = array[i3][i4];
                int i5 = i4 + 1;
                if (b2 == array[i3][i5]) {
                    int i6 = i3 + 1;
                    if (b2 == array[i6][i4] && b2 == array[i6][i5]) {
                        i2 += 3;
                    }
                }
                i4 = i5;
            }
        }
        return i2;
    }

    public static int applyMaskPenaltyRule3(ByteMatrix byteMatrix) {
        int i2;
        int i3;
        int i4;
        int i5;
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i6 = 0;
        for (int i7 = 0; i7 < height; i7++) {
            for (int i8 = 0; i8 < width; i8++) {
                int i9 = i8 + 6;
                if (i9 < width && array[i7][i8] == 1 && array[i7][i8 + 1] == 0 && array[i7][i8 + 2] == 1 && array[i7][i8 + 3] == 1 && array[i7][i8 + 4] == 1 && array[i7][i8 + 5] == 0 && array[i7][i9] == 1 && (((i4 = i8 + 10) < width && array[i7][i8 + 7] == 0 && array[i7][i8 + 8] == 0 && array[i7][i8 + 9] == 0 && array[i7][i4] == 0) || (i8 - 4 >= 0 && array[i7][i8 - 1] == 0 && array[i7][i8 - 2] == 0 && array[i7][i8 - 3] == 0 && array[i7][i5] == 0))) {
                    i6 += 40;
                }
                int i10 = i7 + 6;
                if (i10 < height && array[i7][i8] == 1 && array[i7 + 1][i8] == 0 && array[i7 + 2][i8] == 1 && array[i7 + 3][i8] == 1 && array[i7 + 4][i8] == 1 && array[i7 + 5][i8] == 0 && array[i10][i8] == 1 && (((i2 = i7 + 10) < height && array[i7 + 7][i8] == 0 && array[i7 + 8][i8] == 0 && array[i7 + 9][i8] == 0 && array[i2][i8] == 0) || (i7 - 4 >= 0 && array[i7 - 1][i8] == 0 && array[i7 - 2][i8] == 0 && array[i7 - 3][i8] == 0 && array[i3][i8] == 0))) {
                    i6 += 40;
                }
            }
        }
        return i6;
    }

    public static int applyMaskPenaltyRule4(ByteMatrix byteMatrix) {
        byte[][] array = byteMatrix.getArray();
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int i2 = 0;
        for (int i3 = 0; i3 < height; i3++) {
            for (int i4 = 0; i4 < width; i4++) {
                if (array[i3][i4] == 1) {
                    i2++;
                }
            }
        }
        return (Math.abs((int) (((((double) i2) / ((double) (byteMatrix.getHeight() * byteMatrix.getWidth()))) * 100.0d) - 50.0d)) / 5) * 10;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean getDataMaskBit(int r1, int r2, int r3) {
        /*
            boolean r0 = com.google.zxing.qrcode.encoder.QRCode.isValidMaskPattern(r1)
            if (r0 == 0) goto L4f
            r0 = 1
            switch(r1) {
                case 0: goto L47;
                case 1: goto L48;
                case 2: goto L44;
                case 3: goto L40;
                case 4: goto L39;
                case 5: goto L31;
                case 6: goto L29;
                case 7: goto L21;
                default: goto La;
            }
        La:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r0 = "Invalid mask pattern: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1)
            throw r2
        L21:
            int r1 = r3 * r2
            int r1 = r1 % 3
            int r3 = r3 + r2
            r2 = r3 & 1
            goto L3d
        L29:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L3e
        L31:
            int r3 = r3 * r2
            r1 = r3 & 1
            int r3 = r3 % 3
            int r1 = r1 + r3
            goto L4a
        L39:
            int r1 = r3 >>> 1
            int r2 = r2 / 3
        L3d:
            int r1 = r1 + r2
        L3e:
            r1 = r1 & r0
            goto L4a
        L40:
            int r3 = r3 + r2
            int r1 = r3 % 3
            goto L4a
        L44:
            int r1 = r2 % 3
            goto L4a
        L47:
            int r3 = r3 + r2
        L48:
            r1 = r3 & 1
        L4a:
            if (r1 != 0) goto L4d
            goto L4e
        L4d:
            r0 = 0
        L4e:
            return r0
        L4f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Invalid mask pattern"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.MaskUtil.getDataMaskBit(int, int, int):boolean");
    }
}
