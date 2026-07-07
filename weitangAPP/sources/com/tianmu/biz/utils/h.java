package com.tianmu.biz.utils;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    public static PointF a(float f2, PointF pointF, PointF pointF2, PointF pointF3) {
        PointF pointF4 = new PointF();
        float f3 = 1.0f - f2;
        float f4 = f3 * f3;
        float f5 = 2.0f * f2 * f3;
        float f6 = f2 * f2;
        pointF4.x = (pointF.x * f4) + (pointF2.x * f5) + (pointF3.x * f6);
        pointF4.y = (f4 * pointF.y) + (f5 * pointF2.y) + (f6 * pointF3.y);
        return pointF4;
    }
}
