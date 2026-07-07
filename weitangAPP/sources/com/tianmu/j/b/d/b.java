package com.tianmu.j.b.d;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12330d;

    public void a(int i2) {
        this.f12329c = i2;
    }

    public void b(int i2) {
        this.f12330d = i2;
    }

    public int[] a(int i2, int i3) {
        int i4;
        int i5;
        int i6 = this.f12330d;
        if (i6 == 90 || i6 == 270) {
            int i7 = i2 + i3;
            i3 = i7 - i3;
            i2 = i7 - i3;
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i8 = this.f12328b;
        if (i8 == 0 || (i4 = this.f12327a) == 0) {
            return new int[]{size, size2};
        }
        switch (this.f12329c) {
            case 1:
                i5 = (size / 16) * 9;
                if (size2 <= i5) {
                    i2 = (size2 / 9) * 16;
                    i3 = size2;
                }
                i3 = i5;
                i2 = size;
                break;
            case 2:
                i5 = (size / 4) * 3;
                if (size2 <= i5) {
                    i2 = (size2 / 3) * 4;
                    i3 = size2;
                }
                i3 = i5;
                i2 = size;
                break;
            case 3:
                break;
            case 4:
                i3 = i8;
                i2 = i4;
                break;
            case 5:
                int i9 = i4 * size2;
                int i10 = size * i8;
                if (i9 <= i10) {
                    i3 = i10 / i4;
                    i2 = size;
                } else {
                    i2 = i9 / i8;
                    i3 = size2;
                }
                break;
            case 6:
                if (i4 > i8) {
                    i3 = (i8 * i2) / i4;
                }
                break;
            default:
                int i11 = i4 * size2;
                int i12 = size * i8;
                if (i11 < i12) {
                    i2 = i11 / i8;
                } else if (i11 > i12) {
                    i3 = i12 / i4;
                    i2 = size;
                } else {
                    i2 = size;
                }
                i3 = size2;
                break;
        }
        return new int[]{i2, i3};
    }

    public void b(int i2, int i3) {
        this.f12327a = i2;
        this.f12328b = i3;
    }
}
