package com.tom_roush.pdfbox.pdmodel.graphics.shading;

import android.graphics.Point;
import android.graphics.PointF;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class ShadedTriangle {
    private final double area;
    public final float[][] color;
    public final PointF[] corner;
    private final int degree;
    private final Line line;
    private final double v0;
    private final double v1;
    private final double v2;

    public ShadedTriangle(PointF[] pointFArr, float[][] fArr) {
        PointF[] pointFArr2 = (PointF[]) pointFArr.clone();
        this.corner = pointFArr2;
        float[][] fArr2 = (float[][]) fArr.clone();
        this.color = fArr2;
        this.area = getArea(pointFArr[0], pointFArr[1], pointFArr[2]);
        int iCalcDeg = calcDeg(pointFArr);
        this.degree = iCalcDeg;
        if (iCalcDeg != 2) {
            this.line = null;
        } else if (!overlaps(pointFArr2[1], pointFArr2[2]) || overlaps(pointFArr2[0], pointFArr2[2])) {
            this.line = new Line(new Point(Math.round(pointFArr2[1].x), Math.round(pointFArr2[1].y)), new Point(Math.round(pointFArr2[2].x), Math.round(pointFArr2[2].y)), fArr2[1], fArr2[2]);
        } else {
            this.line = new Line(new Point(Math.round(pointFArr2[0].x), Math.round(pointFArr2[0].y)), new Point(Math.round(pointFArr2[2].x), Math.round(pointFArr2[2].y)), fArr2[0], fArr2[2]);
        }
        this.v0 = edgeEquationValue(pointFArr[0], pointFArr[1], pointFArr[2]);
        this.v1 = edgeEquationValue(pointFArr[1], pointFArr[2], pointFArr[0]);
        this.v2 = edgeEquationValue(pointFArr[2], pointFArr[0], pointFArr[1]);
    }

    private int calcDeg(PointF[] pointFArr) {
        HashSet hashSet = new HashSet();
        for (PointF pointF : pointFArr) {
            hashSet.add(new Point(Math.round(pointF.x * 1000.0f), Math.round(pointF.y * 1000.0f)));
        }
        return hashSet.size();
    }

    private double edgeEquationValue(PointF pointF, PointF pointF2, PointF pointF3) {
        float f2 = pointF3.y;
        float f3 = pointF2.y;
        float f4 = pointF.x;
        float f5 = pointF2.x;
        return ((f2 - f3) * (f4 - f5)) - ((pointF3.x - f5) * (pointF.y - f3));
    }

    private double getArea(PointF pointF, PointF pointF2, PointF pointF3) {
        float f2 = pointF3.x;
        float f3 = f2 - pointF2.x;
        float f4 = pointF3.y;
        return ((double) Math.abs((f3 * (f4 - pointF.y)) - ((f2 - pointF.x) * (f4 - pointF2.y)))) / 2.0d;
    }

    private boolean overlaps(PointF pointF, PointF pointF2) {
        return ((double) Math.abs(pointF.x - pointF2.x)) < 0.001d && ((double) Math.abs(pointF.y - pointF2.y)) < 0.001d;
    }

    public float[] calcColor(PointF pointF) {
        int length = this.color[0].length;
        float[] fArr = new float[length];
        int i2 = this.degree;
        if (i2 == 1) {
            for (int i3 = 0; i3 < length; i3++) {
                float[][] fArr2 = this.color;
                fArr[i3] = ((fArr2[0][i3] + fArr2[1][i3]) + fArr2[2][i3]) / 3.0f;
            }
        } else {
            if (i2 == 2) {
                return this.line.calcColor(new Point(Math.round(pointF.x), Math.round(pointF.y)));
            }
            PointF[] pointFArr = this.corner;
            float area = (float) (getArea(pointF, pointFArr[1], pointFArr[2]) / this.area);
            PointF[] pointFArr2 = this.corner;
            float area2 = (float) (getArea(pointF, pointFArr2[2], pointFArr2[0]) / this.area);
            PointF[] pointFArr3 = this.corner;
            float area3 = (float) (getArea(pointF, pointFArr3[0], pointFArr3[1]) / this.area);
            for (int i4 = 0; i4 < length; i4++) {
                float[][] fArr3 = this.color;
                fArr[i4] = (fArr3[0][i4] * area) + (fArr3[1][i4] * area2) + (fArr3[2][i4] * area3);
            }
        }
        return fArr;
    }

    public boolean contains(PointF pointF) {
        int i2 = this.degree;
        if (i2 == 1) {
            return overlaps(this.corner[0], pointF) || overlaps(this.corner[1], pointF) || overlaps(this.corner[2], pointF);
        }
        if (i2 == 2) {
            return this.line.linePoints.contains(new Point(Math.round(pointF.x), Math.round(pointF.y)));
        }
        PointF[] pointFArr = this.corner;
        if (edgeEquationValue(pointF, pointFArr[1], pointFArr[2]) * this.v0 < 0.0d) {
            return false;
        }
        PointF[] pointFArr2 = this.corner;
        if (edgeEquationValue(pointF, pointFArr2[2], pointFArr2[0]) * this.v1 < 0.0d) {
            return false;
        }
        PointF[] pointFArr3 = this.corner;
        return edgeEquationValue(pointF, pointFArr3[0], pointFArr3[1]) * this.v2 >= 0.0d;
    }

    public int[] getBoundary() {
        int iRound = Math.round(this.corner[0].x);
        int iRound2 = Math.round(this.corner[1].x);
        int iRound3 = Math.round(this.corner[2].x);
        int iRound4 = Math.round(this.corner[0].y);
        int iRound5 = Math.round(this.corner[1].y);
        int iRound6 = Math.round(this.corner[2].y);
        return new int[]{Math.min(Math.min(iRound, iRound2), iRound3), Math.max(Math.max(iRound, iRound2), iRound3), Math.min(Math.min(iRound4, iRound5), iRound6), Math.max(Math.max(iRound4, iRound5), iRound6)};
    }

    public int getDeg() {
        return this.degree;
    }

    public Line getLine() {
        return this.line;
    }

    public String toString() {
        return this.corner[0] + " " + this.corner[1] + " " + this.corner[2];
    }
}
