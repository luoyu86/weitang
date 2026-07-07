package com.tom_roush.pdfbox.pdmodel.graphics.shading;

import android.graphics.PointF;
import java.lang.reflect.Array;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TensorPatch extends Patch {
    public TensorPatch(PointF[] pointFArr, float[][] fArr) {
        super(fArr);
        this.controlPoints = reshapeControlPoints(pointFArr);
        this.level = calcLevel();
        this.listOfTriangles = getTriangles();
    }

    private int[] calcLevel() {
        int[] iArr = {4, 4};
        PointF[] pointFArr = new PointF[4];
        PointF[] pointFArr2 = new PointF[4];
        for (int i2 = 0; i2 < 4; i2++) {
            PointF[][] pointFArr3 = this.controlPoints;
            pointFArr[i2] = pointFArr3[i2][0];
            pointFArr2[i2] = pointFArr3[i2][3];
        }
        if (isEdgeALine(pointFArr) && isEdgeALine(pointFArr2) && !isOnSameSideCC(this.controlPoints[1][1]) && !isOnSameSideCC(this.controlPoints[1][2]) && !isOnSameSideCC(this.controlPoints[2][1]) && !isOnSameSideCC(this.controlPoints[2][2])) {
            double len = getLen(pointFArr[0], pointFArr[3]);
            double len2 = getLen(pointFArr2[0], pointFArr2[3]);
            if (len <= 800.0d && len2 <= 800.0d) {
                if (len > 400.0d || len2 > 400.0d) {
                    iArr[0] = 3;
                } else if (len > 200.0d || len2 > 200.0d) {
                    iArr[0] = 2;
                } else {
                    iArr[0] = 1;
                }
            }
        }
        if (isEdgeALine(this.controlPoints[0]) && isEdgeALine(this.controlPoints[3]) && !isOnSameSideDD(this.controlPoints[1][1]) && !isOnSameSideDD(this.controlPoints[1][2]) && !isOnSameSideDD(this.controlPoints[2][1]) && !isOnSameSideDD(this.controlPoints[2][2])) {
            PointF[][] pointFArr4 = this.controlPoints;
            double len3 = getLen(pointFArr4[0][0], pointFArr4[0][3]);
            PointF[][] pointFArr5 = this.controlPoints;
            double len4 = getLen(pointFArr5[3][0], pointFArr5[3][3]);
            if (len3 <= 800.0d && len4 <= 800.0d) {
                if (len3 > 400.0d || len4 > 400.0d) {
                    iArr[1] = 3;
                } else if (len3 > 200.0d || len4 > 200.0d) {
                    iArr[1] = 2;
                } else {
                    iArr[1] = 1;
                }
            }
        }
        return iArr;
    }

    private double[][] getBernsteinPolynomials(int i2) {
        int i3 = (1 << i2) + 1;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) double.class, 4, i3);
        double d2 = 1.0d / ((double) (i3 - 1));
        double d3 = -d2;
        for (int i4 = 0; i4 < i3; i4++) {
            d3 += d2;
            double d4 = 1.0d - d3;
            dArr[0][i4] = d4 * d4 * d4;
            double d5 = 3.0d * d3;
            dArr[1][i4] = d5 * d4 * d4;
            dArr[2][i4] = d5 * d3 * d4;
            dArr[3][i4] = d3 * d3 * d3;
        }
        return dArr;
    }

    private CoordinateColorPair[][] getPatchCoordinatesColor() {
        TensorPatch tensorPatch = this;
        int i2 = 0;
        int length = tensorPatch.cornerColor[0].length;
        double[][] bernsteinPolynomials = tensorPatch.getBernsteinPolynomials(tensorPatch.level[0]);
        int length2 = bernsteinPolynomials[0].length;
        double[][] bernsteinPolynomials2 = tensorPatch.getBernsteinPolynomials(tensorPatch.level[1]);
        int length3 = bernsteinPolynomials2[0].length;
        CoordinateColorPair[][] coordinateColorPairArr = (CoordinateColorPair[][]) Array.newInstance((Class<?>) CoordinateColorPair.class, length3, length2);
        double d2 = 1.0d / ((double) (length2 - 1));
        double d3 = 1.0d / ((double) (length3 - 1));
        double d4 = -d3;
        int i3 = 0;
        while (i3 < length3) {
            double d5 = d4 + d3;
            double d6 = -d2;
            while (i2 < length2) {
                double d7 = d5;
                double d8 = d3;
                double d9 = 0.0d;
                int i4 = 0;
                int i5 = length2;
                int i6 = length3;
                double d10 = 0.0d;
                while (true) {
                    int i7 = 4;
                    if (i4 >= 4) {
                        break;
                    }
                    int i8 = length;
                    int i9 = 0;
                    while (i9 < i7) {
                        PointF[][] pointFArr = tensorPatch.controlPoints;
                        d9 += ((double) pointFArr[i4][i9].x) * bernsteinPolynomials[i4][i2] * bernsteinPolynomials2[i9][i3];
                        d10 += ((double) pointFArr[i4][i9].y) * bernsteinPolynomials[i4][i2] * bernsteinPolynomials2[i9][i3];
                        i9++;
                        i7 = 4;
                        tensorPatch = this;
                        d2 = d2;
                    }
                    i4++;
                    tensorPatch = this;
                    length = i8;
                }
                double d11 = d2;
                PointF pointF = new PointF((float) d9, (float) d10);
                d6 += d11;
                int i10 = length;
                float[] fArr = new float[i10];
                int i11 = 0;
                while (i11 < i10) {
                    double d12 = 1.0d - d6;
                    float[][] fArr2 = this.cornerColor;
                    fArr[i11] = (float) (((1.0d - d7) * ((((double) fArr2[0][i11]) * d12) + (((double) fArr2[3][i11]) * d6))) + (d7 * ((d12 * ((double) fArr2[1][i11])) + (((double) fArr2[2][i11]) * d6))));
                    i11++;
                    i2 = i2;
                    i10 = i10;
                    bernsteinPolynomials2 = bernsteinPolynomials2;
                    bernsteinPolynomials = bernsteinPolynomials;
                    i3 = i3;
                }
                int i12 = i2;
                coordinateColorPairArr[i3][i12] = new CoordinateColorPair(pointF, fArr);
                i2 = i12 + 1;
                tensorPatch = this;
                length3 = i6;
                length2 = i5;
                d3 = d8;
                d5 = d7;
                length = i10;
                d2 = d11;
                bernsteinPolynomials2 = bernsteinPolynomials2;
                bernsteinPolynomials = bernsteinPolynomials;
            }
            i3++;
            d4 = d5;
            length = length;
            i2 = 0;
        }
        return coordinateColorPairArr;
    }

    private List<ShadedTriangle> getTriangles() {
        return getShadedTriangles(getPatchCoordinatesColor());
    }

    private boolean isOnSameSideCC(PointF pointF) {
        PointF[][] pointFArr = this.controlPoints;
        double dEdgeEquationValue = edgeEquationValue(pointF, pointFArr[0][0], pointFArr[3][0]);
        PointF[][] pointFArr2 = this.controlPoints;
        return dEdgeEquationValue * edgeEquationValue(pointF, pointFArr2[0][3], pointFArr2[3][3]) > 0.0d;
    }

    private boolean isOnSameSideDD(PointF pointF) {
        PointF[][] pointFArr = this.controlPoints;
        double dEdgeEquationValue = edgeEquationValue(pointF, pointFArr[0][0], pointFArr[0][3]);
        PointF[][] pointFArr2 = this.controlPoints;
        return dEdgeEquationValue * edgeEquationValue(pointF, pointFArr2[3][0], pointFArr2[3][3]) > 0.0d;
    }

    private PointF[][] reshapeControlPoints(PointF[] pointFArr) {
        PointF[][] pointFArr2 = (PointF[][]) Array.newInstance((Class<?>) PointF.class, 4, 4);
        for (int i2 = 0; i2 <= 3; i2++) {
            pointFArr2[0][i2] = pointFArr[i2];
            pointFArr2[3][i2] = pointFArr[9 - i2];
        }
        for (int i3 = 1; i3 <= 2; i3++) {
            pointFArr2[i3][0] = pointFArr[12 - i3];
            pointFArr2[i3][2] = pointFArr[i3 + 12];
            pointFArr2[i3][3] = pointFArr[i3 + 3];
        }
        pointFArr2[1][1] = pointFArr[12];
        pointFArr2[2][1] = pointFArr[15];
        return pointFArr2;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.Patch
    public PointF[] getFlag1Edge() {
        PointF[] pointFArr = new PointF[4];
        for (int i2 = 0; i2 < 4; i2++) {
            pointFArr[i2] = this.controlPoints[i2][3];
        }
        return pointFArr;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.Patch
    public PointF[] getFlag2Edge() {
        PointF[] pointFArr = new PointF[4];
        for (int i2 = 0; i2 < 4; i2++) {
            pointFArr[i2] = this.controlPoints[3][3 - i2];
        }
        return pointFArr;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.Patch
    public PointF[] getFlag3Edge() {
        PointF[] pointFArr = new PointF[4];
        for (int i2 = 0; i2 < 4; i2++) {
            pointFArr[i2] = this.controlPoints[3 - i2][0];
        }
        return pointFArr;
    }
}
