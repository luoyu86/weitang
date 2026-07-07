package g.a.i.d.a;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static int a(int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[i4];
        iArr[i4] = iArr[i3];
        iArr[i3] = i5;
        int i6 = i2;
        while (i2 < i3) {
            if (iArr[i2] <= i5) {
                int i7 = iArr[i6];
                iArr[i6] = iArr[i2];
                iArr[i2] = i7;
                i6++;
            }
            i2++;
        }
        int i8 = iArr[i6];
        iArr[i6] = iArr[i3];
        iArr[i3] = i8;
        return i6;
    }

    public static int[] clone(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        if (iArr.length != iArr2.length) {
            return false;
        }
        boolean z = true;
        for (int length = iArr.length - 1; length >= 0; length--) {
            z &= iArr[length] == iArr2[length];
        }
        return z;
    }

    public static void fill(int[] iArr, int i2) {
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr[length] = i2;
        }
    }

    public static void quicksort(int[] iArr) {
        quicksort(iArr, 0, iArr.length - 1);
    }

    public static void quicksort(int[] iArr, int i2, int i3) {
        if (i3 > i2) {
            int iA = a(iArr, i2, i3, i3);
            quicksort(iArr, i2, iA - 1);
            quicksort(iArr, iA + 1, i3);
        }
    }

    public static int[] subArray(int[] iArr, int i2, int i3) {
        int i4 = i3 - i2;
        int[] iArr2 = new int[i4];
        System.arraycopy(iArr, i2, iArr2, 0, i4);
        return iArr2;
    }

    public static String toHexString(int[] iArr) {
        return b.toHexString(a.toByteArray(iArr));
    }

    public static String toString(int[] iArr) {
        String str = "";
        for (int i2 : iArr) {
            str = str + i2 + " ";
        }
        return str;
    }
}
