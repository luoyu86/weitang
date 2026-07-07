package com.google.zxing.oned.rss;

/* JADX INFO: loaded from: classes2.dex */
public final class RSSUtils {
    private RSSUtils() {
    }

    private static int combins(int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 > i3) {
            i4 = i3;
            i3 = i4;
        }
        int i5 = 1;
        int i6 = 1;
        while (i2 > i3) {
            i5 *= i2;
            if (i6 <= i4) {
                i5 /= i6;
                i6++;
            }
            i2--;
        }
        while (i6 <= i4) {
            i5 /= i6;
            i6++;
        }
        return i5;
    }

    public static int[] elements(int[] iArr, int i2, int i3) {
        int[] iArr2 = new int[iArr.length + 2];
        int i4 = i3 << 1;
        iArr2[0] = 1;
        int i5 = 10;
        int i6 = 1;
        for (int i7 = 1; i7 < i4 - 2; i7 += 2) {
            int i8 = i7 - 1;
            iArr2[i7] = iArr[i8] - iArr2[i8];
            int i9 = i7 + 1;
            iArr2[i9] = iArr[i7] - iArr2[i7];
            i6 += iArr2[i7] + iArr2[i9];
            if (iArr2[i7] < i5) {
                i5 = iArr2[i7];
            }
        }
        int i10 = i4 - 1;
        iArr2[i10] = i2 - i6;
        if (iArr2[i10] < i5) {
            i5 = iArr2[i10];
        }
        if (i5 > 1) {
            for (int i11 = 0; i11 < i4; i11 += 2) {
                int i12 = i5 - 1;
                iArr2[i11] = iArr2[i11] + i12;
                int i13 = i11 + 1;
                iArr2[i13] = iArr2[i13] - i12;
            }
        }
        return iArr2;
    }

    public static int getRSSvalue(int[] iArr, int i2, boolean z) {
        int[] iArr2 = iArr;
        int length = iArr2.length;
        int i3 = 0;
        for (int i4 : iArr2) {
            i3 += i4;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = length - 1;
            if (i5 >= i8) {
                return i6;
            }
            int i9 = 1 << i5;
            i7 |= i9;
            int i10 = 1;
            while (i10 < iArr2[i5]) {
                int i11 = i3 - i10;
                int i12 = length - i5;
                int i13 = i12 - 2;
                int iCombins = combins(i11 - 1, i13);
                if (z && i7 == 0) {
                    int i14 = i12 - 1;
                    if (i11 - i14 >= i14) {
                        iCombins -= combins(i11 - i12, i13);
                    }
                }
                if (i12 - 1 > 1) {
                    int iCombins2 = 0;
                    for (int i15 = i11 - i13; i15 > i2; i15--) {
                        iCombins2 += combins((i11 - i15) - 1, i12 - 3);
                    }
                    iCombins -= iCombins2 * (i8 - i5);
                } else if (i11 > i2) {
                    iCombins--;
                }
                i6 += iCombins;
                i10++;
                i7 &= ~i9;
                iArr2 = iArr;
            }
            i3 -= i10;
            i5++;
            iArr2 = iArr;
        }
    }

    public static int[] getRSSwidths(int i2, int i3, int i4, int i5, boolean z) {
        int i6;
        int iCombins;
        int i7 = i4;
        int[] iArr = new int[i7];
        int i8 = i2;
        int i9 = i3;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = i7 - 1;
            if (i10 >= i12) {
                iArr[i10] = i9;
                return iArr;
            }
            int i13 = 1 << i10;
            i11 |= i13;
            int i14 = 1;
            while (true) {
                i6 = i9 - i14;
                int i15 = i7 - i10;
                int i16 = i15 - 2;
                iCombins = combins(i6 - 1, i16);
                if (z && i11 == 0) {
                    int i17 = i15 - 1;
                    if (i6 - i17 >= i17) {
                        iCombins -= combins(i6 - i15, i16);
                    }
                }
                if (i15 - 1 > 1) {
                    int iCombins2 = 0;
                    for (int i18 = i6 - i16; i18 > i5; i18--) {
                        iCombins2 += combins((i6 - i18) - 1, i15 - 3);
                    }
                    iCombins -= iCombins2 * (i12 - i10);
                } else if (i6 > i5) {
                    iCombins--;
                }
                i8 -= iCombins;
                if (i8 < 0) {
                    break;
                }
                i14++;
                i11 &= ~i13;
                i7 = i4;
            }
            i8 += iCombins;
            iArr[i10] = i14;
            i10++;
            i7 = i4;
            i9 = i6;
        }
    }
}
