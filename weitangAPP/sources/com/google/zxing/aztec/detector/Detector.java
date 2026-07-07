package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* JADX INFO: loaded from: classes2.dex */
public final class Detector {
    private boolean compact;
    private final BitMatrix image;
    private int nbCenterLayers;
    private int nbDataBlocks;
    private int nbLayers;
    private int shift;

    public static class Point {
        public final int x;
        public final int y;

        public ResultPoint toResultPoint() {
            return new ResultPoint(this.x, this.y);
        }

        private Point(int i2, int i3) {
            this.x = i2;
            this.y = i3;
        }
    }

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private static void correctParameterData(boolean[] zArr, boolean z) throws NotFoundException {
        int i2;
        int i3;
        if (z) {
            i2 = 7;
            i3 = 2;
        } else {
            i2 = 10;
            i3 = 4;
        }
        int i4 = i2 - i3;
        int[] iArr = new int[i2];
        int i5 = 0;
        while (true) {
            if (i5 >= i2) {
                try {
                    break;
                } catch (ReedSolomonException unused) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
            int i6 = 1;
            for (int i7 = 1; i7 <= 4; i7++) {
                if (zArr[((4 * i5) + 4) - i7]) {
                    iArr[i5] = iArr[i5] + i6;
                }
                i6 <<= 1;
            }
            i5++;
        }
        new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(iArr, i4);
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = 1;
            for (int i10 = 1; i10 <= 4; i10++) {
                zArr[((i8 * 4) + 4) - i10] = (iArr[i8] & i9) == i9;
                i9 <<= 1;
            }
        }
    }

    private static float distance(Point point, Point point2) {
        int i2 = point.x;
        int i3 = point2.x;
        int i4 = point.y;
        int i5 = point2.y;
        return (float) Math.sqrt(((i2 - i3) * (i2 - i3)) + ((i4 - i5) * (i4 - i5)));
    }

    private void extractParameters(Point[] pointArr) throws NotFoundException {
        boolean[] zArr;
        int i2 = 0;
        boolean[] zArrSampleLine = sampleLine(pointArr[0], pointArr[1], (this.nbCenterLayers * 2) + 1);
        boolean[] zArrSampleLine2 = sampleLine(pointArr[1], pointArr[2], (this.nbCenterLayers * 2) + 1);
        boolean[] zArrSampleLine3 = sampleLine(pointArr[2], pointArr[3], (this.nbCenterLayers * 2) + 1);
        boolean[] zArrSampleLine4 = sampleLine(pointArr[3], pointArr[0], (this.nbCenterLayers * 2) + 1);
        if (zArrSampleLine[0] && zArrSampleLine[this.nbCenterLayers * 2]) {
            this.shift = 0;
        } else if (zArrSampleLine2[0] && zArrSampleLine2[this.nbCenterLayers * 2]) {
            this.shift = 1;
        } else if (zArrSampleLine3[0] && zArrSampleLine3[this.nbCenterLayers * 2]) {
            this.shift = 2;
        } else {
            if (!zArrSampleLine4[0] || !zArrSampleLine4[this.nbCenterLayers * 2]) {
                throw NotFoundException.getNotFoundInstance();
            }
            this.shift = 3;
        }
        if (this.compact) {
            boolean[] zArr2 = new boolean[28];
            for (int i3 = 0; i3 < 7; i3++) {
                int i4 = i3 + 2;
                zArr2[i3] = zArrSampleLine[i4];
                zArr2[i3 + 7] = zArrSampleLine2[i4];
                zArr2[i3 + 14] = zArrSampleLine3[i4];
                zArr2[i3 + 21] = zArrSampleLine4[i4];
            }
            zArr = new boolean[28];
            while (i2 < 28) {
                zArr[i2] = zArr2[((this.shift * 7) + i2) % 28];
                i2++;
            }
        } else {
            boolean[] zArr3 = new boolean[40];
            for (int i5 = 0; i5 < 11; i5++) {
                if (i5 < 5) {
                    int i6 = i5 + 2;
                    zArr3[i5] = zArrSampleLine[i6];
                    zArr3[i5 + 10] = zArrSampleLine2[i6];
                    zArr3[i5 + 20] = zArrSampleLine3[i6];
                    zArr3[i5 + 30] = zArrSampleLine4[i6];
                }
                if (i5 > 5) {
                    int i7 = i5 + 2;
                    zArr3[i5 - 1] = zArrSampleLine[i7];
                    zArr3[(i5 + 10) - 1] = zArrSampleLine2[i7];
                    zArr3[(i5 + 20) - 1] = zArrSampleLine3[i7];
                    zArr3[(i5 + 30) - 1] = zArrSampleLine4[i7];
                }
            }
            zArr = new boolean[40];
            while (i2 < 40) {
                zArr[i2] = zArr3[((this.shift * 10) + i2) % 40];
                i2++;
            }
        }
        correctParameterData(zArr, this.compact);
        getParameters(zArr);
    }

    private Point[] getBullEyeCornerPoints(Point point) throws NotFoundException {
        this.nbCenterLayers = 1;
        Point point2 = point;
        Point point3 = point2;
        Point point4 = point3;
        Point point5 = point4;
        boolean z = true;
        while (this.nbCenterLayers < 9) {
            Point firstDifferent = getFirstDifferent(point2, z, 1, -1);
            Point firstDifferent2 = getFirstDifferent(point3, z, 1, 1);
            Point firstDifferent3 = getFirstDifferent(point4, z, -1, 1);
            Point firstDifferent4 = getFirstDifferent(point5, z, -1, -1);
            if (this.nbCenterLayers > 2) {
                double dDistance = (distance(firstDifferent4, firstDifferent) * this.nbCenterLayers) / (distance(point5, point2) * (this.nbCenterLayers + 2));
                if (dDistance < 0.75d || dDistance > 1.25d || !isWhiteOrBlackRectangle(firstDifferent, firstDifferent2, firstDifferent3, firstDifferent4)) {
                    break;
                }
            }
            z = !z;
            this.nbCenterLayers++;
            point5 = firstDifferent4;
            point2 = firstDifferent;
            point3 = firstDifferent2;
            point4 = firstDifferent3;
        }
        int i2 = this.nbCenterLayers;
        if (i2 != 5 && i2 != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.compact = i2 == 5;
        float f2 = 1.5f / ((i2 * 2) - 3);
        int i3 = point2.x;
        int i4 = point4.x;
        int i5 = point2.y - point4.y;
        float f3 = (i3 - i4) * f2;
        int iRound = round(i4 - f3);
        float f4 = i5 * f2;
        int iRound2 = round(point4.y - f4);
        int iRound3 = round(point2.x + f3);
        int iRound4 = round(point2.y + f4);
        int i6 = point3.x;
        int i7 = point5.x;
        int i8 = point3.y - point5.y;
        float f5 = (i6 - i7) * f2;
        int iRound5 = round(i7 - f5);
        float f6 = f2 * i8;
        int iRound6 = round(point5.y - f6);
        int iRound7 = round(point3.x + f5);
        int iRound8 = round(point3.y + f6);
        if (!isValid(iRound3, iRound4) || !isValid(iRound7, iRound8) || !isValid(iRound, iRound2) || !isValid(iRound5, iRound6)) {
            throw NotFoundException.getNotFoundInstance();
        }
        return new Point[]{new Point(iRound3, iRound4), new Point(iRound7, iRound8), new Point(iRound, iRound2), new Point(iRound5, iRound6)};
    }

    private int getColor(Point point, Point point2) {
        float fDistance = distance(point, point2);
        int i2 = point2.x;
        int i3 = point.x;
        float f2 = (i2 - i3) / fDistance;
        int i4 = point2.y;
        int i5 = point.y;
        float f3 = (i4 - i5) / fDistance;
        float f4 = i3;
        float f5 = i5;
        boolean z = this.image.get(i3, i5);
        int i6 = 0;
        for (int i7 = 0; i7 < fDistance; i7++) {
            f4 += f2;
            f5 += f3;
            if (this.image.get(round(f4), round(f5)) != z) {
                i6++;
            }
        }
        double d2 = i6 / fDistance;
        if (d2 <= 0.1d || d2 >= 0.9d) {
            return d2 <= 0.1d ? z ? 1 : -1 : z ? -1 : 1;
        }
        return 0;
    }

    private Point getFirstDifferent(Point point, boolean z, int i2, int i3) {
        int i4 = point.x + i2;
        int i5 = point.y;
        while (true) {
            i5 += i3;
            if (!isValid(i4, i5) || this.image.get(i4, i5) != z) {
                break;
            }
            i4 += i2;
        }
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        while (isValid(i6, i7) && this.image.get(i6, i7) == z) {
            i6 += i2;
        }
        int i8 = i6 - i2;
        while (isValid(i8, i7) && this.image.get(i8, i7) == z) {
            i7 += i3;
        }
        return new Point(i8, i7 - i3);
    }

    private Point getMatrixCenter() {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        ResultPoint resultPoint5;
        ResultPoint resultPoint6;
        ResultPoint resultPoint7;
        ResultPoint resultPoint8;
        try {
            ResultPoint[] resultPointArrDetect = new WhiteRectangleDetector(this.image).detect();
            resultPoint3 = resultPointArrDetect[0];
            resultPoint4 = resultPointArrDetect[1];
            resultPoint2 = resultPointArrDetect[2];
            resultPoint = resultPointArrDetect[3];
        } catch (NotFoundException unused) {
            int width = this.image.getWidth() / 2;
            int height = this.image.getHeight() / 2;
            int i2 = width + 7;
            int i3 = height - 7;
            ResultPoint resultPoint9 = getFirstDifferent(new Point(i2, i3), false, 1, -1).toResultPoint();
            int i4 = height + 7;
            ResultPoint resultPoint10 = getFirstDifferent(new Point(i2, i4), false, 1, 1).toResultPoint();
            int i5 = width - 7;
            ResultPoint resultPoint11 = getFirstDifferent(new Point(i5, i4), false, -1, 1).toResultPoint();
            resultPoint = getFirstDifferent(new Point(i5, i3), false, -1, -1).toResultPoint();
            resultPoint2 = resultPoint11;
            resultPoint3 = resultPoint9;
            resultPoint4 = resultPoint10;
        }
        int iRound = round((((resultPoint3.getX() + resultPoint.getX()) + resultPoint4.getX()) + resultPoint2.getX()) / 4.0f);
        int iRound2 = round((((resultPoint3.getY() + resultPoint.getY()) + resultPoint4.getY()) + resultPoint2.getY()) / 4.0f);
        try {
            ResultPoint[] resultPointArrDetect2 = new WhiteRectangleDetector(this.image, 15, iRound, iRound2).detect();
            resultPoint5 = resultPointArrDetect2[0];
            resultPoint6 = resultPointArrDetect2[1];
            resultPoint7 = resultPointArrDetect2[2];
            resultPoint8 = resultPointArrDetect2[3];
        } catch (NotFoundException unused2) {
            int i6 = iRound + 7;
            int i7 = iRound2 - 7;
            resultPoint5 = getFirstDifferent(new Point(i6, i7), false, 1, -1).toResultPoint();
            int i8 = iRound2 + 7;
            resultPoint6 = getFirstDifferent(new Point(i6, i8), false, 1, 1).toResultPoint();
            int i9 = iRound - 7;
            resultPoint7 = getFirstDifferent(new Point(i9, i8), false, -1, 1).toResultPoint();
            resultPoint8 = getFirstDifferent(new Point(i9, i7), false, -1, -1).toResultPoint();
        }
        return new Point(round((((resultPoint5.getX() + resultPoint8.getX()) + resultPoint6.getX()) + resultPoint7.getX()) / 4.0f), round((((resultPoint5.getY() + resultPoint8.getY()) + resultPoint6.getY()) + resultPoint7.getY()) / 4.0f));
    }

    private ResultPoint[] getMatrixCornerPoints(Point[] pointArr) throws NotFoundException {
        float f2 = (((r0 * 2) + (this.nbLayers > 4 ? 1 : 0)) + ((r0 - 4) / 8)) / (this.nbCenterLayers * 2.0f);
        int i2 = pointArr[0].x - pointArr[2].x;
        int i3 = i2 + (i2 > 0 ? 1 : -1);
        int i4 = pointArr[0].y - pointArr[2].y;
        int i5 = i4 + (i4 > 0 ? 1 : -1);
        float f3 = i3 * f2;
        int iRound = round(pointArr[2].x - f3);
        float f4 = i5 * f2;
        int iRound2 = round(pointArr[2].y - f4);
        int iRound3 = round(pointArr[0].x + f3);
        int iRound4 = round(pointArr[0].y + f4);
        int i6 = pointArr[1].x - pointArr[3].x;
        int i7 = i6 + (i6 > 0 ? 1 : -1);
        int i8 = pointArr[1].y - pointArr[3].y;
        int i9 = i8 + (i8 > 0 ? 1 : -1);
        float f5 = i7 * f2;
        int iRound5 = round(pointArr[3].x - f5);
        float f6 = f2 * i9;
        int iRound6 = round(pointArr[3].y - f6);
        int iRound7 = round(pointArr[1].x + f5);
        int iRound8 = round(pointArr[1].y + f6);
        if (isValid(iRound3, iRound4) && isValid(iRound7, iRound8) && isValid(iRound, iRound2) && isValid(iRound5, iRound6)) {
            return new ResultPoint[]{new ResultPoint(iRound3, iRound4), new ResultPoint(iRound7, iRound8), new ResultPoint(iRound, iRound2), new ResultPoint(iRound5, iRound6)};
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void getParameters(boolean[] zArr) {
        int i2;
        int i3;
        if (this.compact) {
            i2 = 2;
            i3 = 6;
        } else {
            i2 = 5;
            i3 = 11;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.nbLayers << 1;
            this.nbLayers = i5;
            if (zArr[i4]) {
                this.nbLayers = i5 + 1;
            }
        }
        for (int i6 = i2; i6 < i2 + i3; i6++) {
            int i7 = this.nbDataBlocks << 1;
            this.nbDataBlocks = i7;
            if (zArr[i6]) {
                this.nbDataBlocks = i7 + 1;
            }
        }
        this.nbLayers++;
        this.nbDataBlocks++;
    }

    private boolean isValid(int i2, int i3) {
        return i2 >= 0 && i2 < this.image.getWidth() && i3 > 0 && i3 < this.image.getHeight();
    }

    private boolean isWhiteOrBlackRectangle(Point point, Point point2, Point point3, Point point4) {
        Point point5 = new Point(point.x - 3, point.y + 3);
        Point point6 = new Point(point2.x - 3, point2.y - 3);
        Point point7 = new Point(point3.x + 3, point3.y - 3);
        Point point8 = new Point(point4.x + 3, point4.y + 3);
        int color = getColor(point8, point5);
        return color != 0 && getColor(point5, point6) == color && getColor(point6, point7) == color && getColor(point7, point8) == color;
    }

    private static int round(float f2) {
        return (int) (f2 + 0.5f);
    }

    private BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        int i2;
        if (this.compact) {
            i2 = (this.nbLayers * 4) + 11;
        } else {
            int i3 = this.nbLayers;
            i2 = i3 <= 4 ? (i3 * 4) + 15 : (i3 * 4) + ((((i3 - 4) / 8) + 1) * 2) + 15;
        }
        int i4 = i2;
        float f2 = i4 - 0.5f;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i4, i4, 0.5f, 0.5f, f2, 0.5f, f2, f2, 0.5f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    private boolean[] sampleLine(Point point, Point point2, int i2) {
        boolean[] zArr = new boolean[i2];
        float fDistance = distance(point, point2);
        float f2 = fDistance / (i2 - 1);
        int i3 = point2.x;
        int i4 = point.x;
        float f3 = ((i3 - i4) * f2) / fDistance;
        int i5 = point2.y;
        float f4 = (f2 * (i5 - r8)) / fDistance;
        float f5 = i4;
        float f6 = point.y;
        for (int i6 = 0; i6 < i2; i6++) {
            zArr[i6] = this.image.get(round(f5), round(f6));
            f5 += f3;
            f6 += f4;
        }
        return zArr;
    }

    public AztecDetectorResult detect() throws NotFoundException {
        Point[] bullEyeCornerPoints = getBullEyeCornerPoints(getMatrixCenter());
        extractParameters(bullEyeCornerPoints);
        ResultPoint[] matrixCornerPoints = getMatrixCornerPoints(bullEyeCornerPoints);
        BitMatrix bitMatrix = this.image;
        int i2 = this.shift;
        return new AztecDetectorResult(sampleGrid(bitMatrix, matrixCornerPoints[i2 % 4], matrixCornerPoints[(i2 + 3) % 4], matrixCornerPoints[(i2 + 2) % 4], matrixCornerPoints[(i2 + 1) % 4]), matrixCornerPoints, this.compact, this.nbDataBlocks, this.nbLayers);
    }
}
