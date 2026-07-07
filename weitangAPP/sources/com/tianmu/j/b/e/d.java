package com.tianmu.j.b.e;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static boolean a(int i2, int i3) {
        return ((float) (i2 / i3)) < 1.0f;
    }

    public static boolean a(int i2, int i3, int i4, int i5) {
        return i3 == 0 || i5 == 0 || ((double) Math.abs(((float) (i2 / i3)) - ((float) (i4 / i5)))) <= 0.1d;
    }
}
