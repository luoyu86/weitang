package com.tom_roush.pdfbox.pdmodel.graphics.shading;

import android.graphics.PointF;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Patch {
    public PointF[][] controlPoints;
    public float[][] cornerColor;
    public int[] level;
    public List<ShadedTriangle> listOfTriangles;

    public Patch(float[][] fArr) {
        this.cornerColor = (float[][]) fArr.clone();
    }

    private boolean overlaps(PointF pointF, PointF pointF2) {
        return ((double) Math.abs(pointF.x - pointF2.x)) < 0.001d && ((double) Math.abs(pointF.y - pointF2.y)) < 0.001d;
    }

    public double edgeEquationValue(PointF pointF, PointF pointF2, PointF pointF3) {
        float f2 = pointF3.y;
        float f3 = pointF2.y;
        float f4 = pointF.x;
        float f5 = pointF2.x;
        return ((f2 - f3) * (f4 - f5)) - ((pointF3.x - f5) * (pointF.y - f3));
    }

    public float[][] getFlag1Color() {
        int length = this.cornerColor[0].length;
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) float.class, 2, length);
        for (int i2 = 0; i2 < length; i2++) {
            float[] fArr2 = fArr[0];
            float[][] fArr3 = this.cornerColor;
            fArr2[i2] = fArr3[1][i2];
            fArr[1][i2] = fArr3[2][i2];
        }
        return fArr;
    }

    public abstract PointF[] getFlag1Edge();

    public float[][] getFlag2Color() {
        int length = this.cornerColor[0].length;
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) float.class, 2, length);
        for (int i2 = 0; i2 < length; i2++) {
            float[] fArr2 = fArr[0];
            float[][] fArr3 = this.cornerColor;
            fArr2[i2] = fArr3[2][i2];
            fArr[1][i2] = fArr3[3][i2];
        }
        return fArr;
    }

    public abstract PointF[] getFlag2Edge();

    public float[][] getFlag3Color() {
        int length = this.cornerColor[0].length;
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) float.class, 2, length);
        for (int i2 = 0; i2 < length; i2++) {
            float[] fArr2 = fArr[0];
            float[][] fArr3 = this.cornerColor;
            fArr2[i2] = fArr3[3][i2];
            fArr[1][i2] = fArr3[0][i2];
        }
        return fArr;
    }

    public abstract PointF[] getFlag3Edge();

    public double getLen(PointF pointF, PointF pointF2) {
        double d2 = pointF2.x - pointF.x;
        double d3 = pointF2.y - pointF.y;
        return Math.sqrt((d2 * d2) + (d3 * d3));
    }

    public List<ShadedTriangle> getShadedTriangles(CoordinateColorPair[][] coordinateColorPairArr) {
        boolean z;
        ArrayList arrayList = new ArrayList();
        int length = coordinateColorPairArr.length;
        int length2 = coordinateColorPairArr[0].length;
        for (int i2 = 1; i2 < length; i2++) {
            for (int i3 = 1; i3 < length2; i3++) {
                int i4 = i2 - 1;
                int i5 = i3 - 1;
                PointF pointF = coordinateColorPairArr[i4][i5].coordinate;
                PointF pointF2 = coordinateColorPairArr[i4][i3].coordinate;
                PointF pointF3 = coordinateColorPairArr[i2][i3].coordinate;
                PointF pointF4 = coordinateColorPairArr[i2][i5].coordinate;
                if (overlaps(pointF, pointF2) || overlaps(pointF, pointF4)) {
                    z = false;
                } else {
                    arrayList.add(new ShadedTriangle(new PointF[]{pointF, pointF2, pointF4}, new float[][]{coordinateColorPairArr[i4][i5].color, coordinateColorPairArr[i4][i3].color, coordinateColorPairArr[i2][i5].color}));
                    z = true;
                }
                if (!z || (!overlaps(pointF3, pointF2) && !overlaps(pointF3, pointF4))) {
                    arrayList.add(new ShadedTriangle(new PointF[]{pointF4, pointF2, pointF3}, new float[][]{coordinateColorPairArr[i2][i5].color, coordinateColorPairArr[i4][i3].color, coordinateColorPairArr[i2][i3].color}));
                }
            }
        }
        return arrayList;
    }

    public boolean isEdgeALine(PointF[] pointFArr) {
        double dAbs = Math.abs(edgeEquationValue(pointFArr[1], pointFArr[0], pointFArr[3]));
        double dAbs2 = Math.abs(edgeEquationValue(pointFArr[2], pointFArr[0], pointFArr[3]));
        double dAbs3 = Math.abs(pointFArr[0].x - pointFArr[3].x);
        double dAbs4 = Math.abs(pointFArr[0].y - pointFArr[3].y);
        if (dAbs > dAbs3 || dAbs2 > dAbs3) {
            return dAbs <= dAbs4 && dAbs2 <= dAbs4;
        }
        return true;
    }
}
