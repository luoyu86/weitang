package com.tianmu.biz.utils;

import android.view.MotionEvent;
import android.view.View;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static void a(View view) {
        a(view, false);
    }

    public static void a(View view, boolean z) {
        if (view != null) {
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            Random random = new Random();
            int iNextInt = random.nextInt(measuredWidth);
            int iNextInt2 = random.nextInt(measuredHeight);
            a(iNextInt, iNextInt2, iNextInt, iNextInt2, view, z);
        }
    }

    public static void a(int i2, int i3, int i4, int i5, View view, boolean z) {
        try {
            a(0, i2, i3, view, z);
            a(1, i4, i5, view, z);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(int i2, int i3, int i4, View view, boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, i2, i3, i4, 0);
        if (z) {
            view.dispatchTouchEvent(motionEventObtain);
        } else {
            view.onTouchEvent(motionEventObtain);
        }
        motionEventObtain.recycle();
    }
}
