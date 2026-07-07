package com.tom_roush.pdfbox.pdmodel.graphics.shading;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes2.dex */
public class CoordinateColorPair {
    public final float[] color;
    public final PointF coordinate;

    public CoordinateColorPair(PointF pointF, float[] fArr) {
        this.coordinate = pointF;
        this.color = (float[]) fArr.clone();
    }
}
