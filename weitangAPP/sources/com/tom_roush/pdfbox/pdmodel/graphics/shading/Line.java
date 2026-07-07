package com.tom_roush.pdfbox.pdmodel.graphics.shading;

import android.graphics.Point;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class Line {
    private final float[] color0;
    private final float[] color1;
    public final Set<Point> linePoints;
    private final Point point0;
    private final Point point1;

    public Line(Point point, Point point2, float[] fArr, float[] fArr2) {
        this.point0 = point;
        this.point1 = point2;
        this.color0 = (float[]) fArr.clone();
        this.color1 = (float[]) fArr2.clone();
        this.linePoints = calcLine(point.x, point.y, point2.x, point2.y);
    }

    private Set<Point> calcLine(int i2, int i3, int i4, int i5) {
        HashSet hashSet = new HashSet(3);
        int iAbs = Math.abs(i4 - i2);
        int iAbs2 = Math.abs(i5 - i3);
        int i6 = i2 < i4 ? 1 : -1;
        int i7 = i3 >= i5 ? -1 : 1;
        int i8 = iAbs - iAbs2;
        while (true) {
            hashSet.add(new Point(i2, i3));
            if (i2 == i4 && i3 == i5) {
                return hashSet;
            }
            int i9 = i8 * 2;
            if (i9 > (-iAbs2)) {
                i8 -= iAbs2;
                i2 += i6;
            }
            if (i9 < iAbs) {
                i8 += iAbs;
                i3 += i7;
            }
        }
    }

    public float[] calcColor(Point point) {
        Point point2 = this.point0;
        int i2 = point2.x;
        Point point3 = this.point1;
        int i3 = point3.x;
        if (i2 == i3 && point2.y == point3.y) {
            return this.color0;
        }
        int length = this.color0.length;
        float[] fArr = new float[length];
        int i4 = 0;
        if (i2 == i3) {
            float f2 = point3.y - point2.y;
            while (i4 < length) {
                float f3 = this.color0[i4];
                int i5 = this.point1.y;
                int i6 = point.y;
                fArr[i4] = ((f3 * (i5 - i6)) / f2) + ((this.color1[i4] * (i6 - this.point0.y)) / f2);
                i4++;
            }
        } else {
            float f4 = i3 - i2;
            while (i4 < length) {
                float f5 = this.color0[i4];
                int i7 = this.point1.x;
                int i8 = point.x;
                fArr[i4] = ((f5 * (i7 - i8)) / f4) + ((this.color1[i4] * (i8 - this.point0.x)) / f4);
                i4++;
            }
        }
        return fArr;
    }
}
