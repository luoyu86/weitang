package com.tom_roush.pdfbox.util;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public final class IterativeMergeSort {
    private IterativeMergeSort() {
    }

    private static <T> void iterativeMergeSort(T[] tArr, Comparator<? super T> comparator) {
        Object[] objArr = (Object[]) tArr.clone();
        for (int i2 = 1; i2 < tArr.length; i2 <<= 1) {
            int i3 = 0;
            while (i3 < tArr.length) {
                int i4 = i3 + (i2 << 1);
                merge(tArr, objArr, i3, i3 + i2, i4, comparator);
                i3 = i4;
            }
        }
    }

    private static <T> void merge(T[] tArr, T[] tArr2, int i2, int i3, int i4, Comparator<? super T> comparator) {
        int i5;
        if (i3 >= tArr.length) {
            return;
        }
        if (i4 > tArr.length) {
            i4 = tArr.length;
        }
        int i6 = i2;
        int i7 = i6;
        int i8 = i3;
        while (i6 < i4) {
            if (i7 == i3) {
                i5 = i8 + 1;
                tArr2[i6] = tArr[i8];
            } else if (i8 != i4 && comparator.compare(tArr[i8], tArr[i7]) < 0) {
                i5 = i8 + 1;
                tArr2[i6] = tArr[i8];
            } else {
                int i9 = i7 + 1;
                tArr2[i6] = tArr[i7];
                i7 = i9;
                i6++;
            }
            i8 = i5;
            i6++;
        }
        System.arraycopy(tArr2, i2, tArr, i2, i4 - i2);
    }

    public static <T> void sort(List<T> list, Comparator<? super T> comparator) {
        if (list.size() < 2) {
            return;
        }
        Object[] array = list.toArray();
        iterativeMergeSort(array, comparator);
        ListIterator<T> listIterator = list.listIterator();
        for (Object obj : array) {
            listIterator.next();
            listIterator.set(obj);
        }
    }
}
