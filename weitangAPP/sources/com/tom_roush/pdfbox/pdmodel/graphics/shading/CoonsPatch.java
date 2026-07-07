package com.tom_roush.pdfbox.pdmodel.graphics.shading;

import android.graphics.PointF;
import java.lang.reflect.Array;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CoonsPatch extends Patch {
    public CoonsPatch(PointF[] pointFArr, float[][] fArr) {
        super(fArr);
        this.controlPoints = reshapeControlPoints(pointFArr);
        this.level = calcLevel();
        this.listOfTriangles = getTriangles();
    }

    private int[] calcLevel() {
        int[] iArr = {4, 4};
        if (isEdgeALine(this.controlPoints[0]) && isEdgeALine(this.controlPoints[1])) {
            PointF[][] pointFArr = this.controlPoints;
            double len = getLen(pointFArr[0][0], pointFArr[0][3]);
            PointF[][] pointFArr2 = this.controlPoints;
            double len2 = getLen(pointFArr2[1][0], pointFArr2[1][3]);
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
        if (isEdgeALine(this.controlPoints[2]) && isEdgeALine(this.controlPoints[3])) {
            PointF[][] pointFArr3 = this.controlPoints;
            double len3 = getLen(pointFArr3[2][0], pointFArr3[2][3]);
            PointF[][] pointFArr4 = this.controlPoints;
            double len4 = getLen(pointFArr4[3][0], pointFArr4[3][3]);
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

    private List<ShadedTriangle> getTriangles() {
        return getShadedTriangles(new CoordinateColorPair[0][]);
    }

    private PointF[][] reshapeControlPoints(PointF[] pointFArr) {
        PointF[][] pointFArr2 = (PointF[][]) Array.newInstance((Class<?>) PointF.class, 4, 4);
        pointFArr2[2] = new PointF[]{pointFArr[0], pointFArr[1], pointFArr[2], pointFArr[3]};
        pointFArr2[1] = new PointF[]{pointFArr[3], pointFArr[4], pointFArr[5], pointFArr[6]};
        pointFArr2[3] = new PointF[]{pointFArr[9], pointFArr[8], pointFArr[7], pointFArr[6]};
        pointFArr2[0] = new PointF[]{pointFArr[0], pointFArr[11], pointFArr[10], pointFArr[9]};
        return pointFArr2;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.Patch
    public PointF[] getFlag1Edge() {
        return (PointF[]) this.controlPoints[1].clone();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.Patch
    public PointF[] getFlag2Edge() {
        PointF[][] pointFArr = this.controlPoints;
        return new PointF[]{pointFArr[3][3], pointFArr[3][2], pointFArr[3][1], pointFArr[3][0]};
    }

    @Override // com.tom_roush.pdfbox.pdmodel.graphics.shading.Patch
    public PointF[] getFlag3Edge() {
        PointF[][] pointFArr = this.controlPoints;
        return new PointF[]{pointFArr[0][3], pointFArr[0][2], pointFArr[0][1], pointFArr[0][0]};
    }
}
