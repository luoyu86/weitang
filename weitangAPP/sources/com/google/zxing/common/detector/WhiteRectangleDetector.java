package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

/* JADX INFO: loaded from: classes2.dex */
public final class WhiteRectangleDetector {
    private static final int CORR = 1;
    private static final int INIT_SIZE = 30;
    private final int downInit;
    private final int height;
    private final BitMatrix image;
    private final int leftInit;
    private final int rightInit;
    private final int upInit;
    private final int width;

    public WhiteRectangleDetector(BitMatrix bitMatrix) throws NotFoundException {
        this.image = bitMatrix;
        int height = bitMatrix.getHeight();
        this.height = height;
        int width = bitMatrix.getWidth();
        this.width = width;
        int i2 = (width - 30) >> 1;
        this.leftInit = i2;
        int i3 = (width + 30) >> 1;
        this.rightInit = i3;
        int i4 = (height - 30) >> 1;
        this.upInit = i4;
        int i5 = (height + 30) >> 1;
        this.downInit = i5;
        if (i4 < 0 || i2 < 0 || i5 >= height || i3 >= width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    private ResultPoint[] centerEdges(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) {
        float x = resultPoint.getX();
        float y = resultPoint.getY();
        float x2 = resultPoint2.getX();
        float y2 = resultPoint2.getY();
        float x3 = resultPoint3.getX();
        float y3 = resultPoint3.getY();
        float x4 = resultPoint4.getX();
        float y4 = resultPoint4.getY();
        return x < ((float) (this.width / 2)) ? new ResultPoint[]{new ResultPoint(x4 - 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 + 1.0f), new ResultPoint(x3 - 1.0f, y3 - 1.0f), new ResultPoint(x + 1.0f, y - 1.0f)} : new ResultPoint[]{new ResultPoint(x4 + 1.0f, y4 + 1.0f), new ResultPoint(x2 + 1.0f, y2 - 1.0f), new ResultPoint(x3 - 1.0f, y3 + 1.0f), new ResultPoint(x - 1.0f, y - 1.0f)};
    }

    private boolean containsBlackPoint(int i2, int i3, int i4, boolean z) {
        if (z) {
            while (i2 <= i3) {
                if (this.image.get(i2, i4)) {
                    return true;
                }
                i2++;
            }
            return false;
        }
        while (i2 <= i3) {
            if (this.image.get(i4, i2)) {
                return true;
            }
            i2++;
        }
        return false;
    }

    private static int distanceL2(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        return round((float) Math.sqrt((f6 * f6) + (f7 * f7)));
    }

    private ResultPoint getBlackPointOnSegment(float f2, float f3, float f4, float f5) {
        int iDistanceL2 = distanceL2(f2, f3, f4, f5);
        float f6 = iDistanceL2;
        float f7 = (f4 - f2) / f6;
        float f8 = (f5 - f3) / f6;
        for (int i2 = 0; i2 < iDistanceL2; i2++) {
            float f9 = i2;
            int iRound = round((f9 * f7) + f2);
            int iRound2 = round((f9 * f8) + f3);
            if (this.image.get(iRound, iRound2)) {
                return new ResultPoint(iRound, iRound2);
            }
        }
        return null;
    }

    private static int round(float f2) {
        return (int) (f2 + 0.5f);
    }

    public ResultPoint[] detect() throws NotFoundException {
        int i2 = this.leftInit;
        int i3 = this.rightInit;
        int i4 = this.upInit;
        int i5 = this.downInit;
        boolean z = false;
        boolean z2 = true;
        boolean z3 = false;
        while (z2) {
            boolean zContainsBlackPoint = true;
            boolean z4 = false;
            while (zContainsBlackPoint && i3 < this.width) {
                zContainsBlackPoint = containsBlackPoint(i4, i5, i3, false);
                if (zContainsBlackPoint) {
                    i3++;
                    z4 = true;
                }
            }
            if (i3 < this.width) {
                boolean zContainsBlackPoint2 = true;
                while (zContainsBlackPoint2 && i5 < this.height) {
                    zContainsBlackPoint2 = containsBlackPoint(i2, i3, i5, true);
                    if (zContainsBlackPoint2) {
                        i5++;
                        z4 = true;
                    }
                }
                if (i5 < this.height) {
                    boolean zContainsBlackPoint3 = true;
                    while (zContainsBlackPoint3 && i2 >= 0) {
                        zContainsBlackPoint3 = containsBlackPoint(i4, i5, i2, false);
                        if (zContainsBlackPoint3) {
                            i2--;
                            z4 = true;
                        }
                    }
                    if (i2 >= 0) {
                        z2 = z4;
                        boolean zContainsBlackPoint4 = true;
                        while (zContainsBlackPoint4 && i4 >= 0) {
                            zContainsBlackPoint4 = containsBlackPoint(i2, i3, i4, true);
                            if (zContainsBlackPoint4) {
                                i4--;
                                z2 = true;
                            }
                        }
                        if (i4 >= 0) {
                            if (z2) {
                                z3 = true;
                            }
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z || !z3) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = i3 - i2;
        ResultPoint blackPointOnSegment = null;
        ResultPoint blackPointOnSegment2 = null;
        for (int i7 = 1; i7 < i6; i7++) {
            blackPointOnSegment2 = getBlackPointOnSegment(i2, i5 - i7, i2 + i7, i5);
            if (blackPointOnSegment2 != null) {
                break;
            }
        }
        if (blackPointOnSegment2 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint blackPointOnSegment3 = null;
        for (int i8 = 1; i8 < i6; i8++) {
            blackPointOnSegment3 = getBlackPointOnSegment(i2, i4 + i8, i2 + i8, i4);
            if (blackPointOnSegment3 != null) {
                break;
            }
        }
        if (blackPointOnSegment3 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        ResultPoint blackPointOnSegment4 = null;
        for (int i9 = 1; i9 < i6; i9++) {
            blackPointOnSegment4 = getBlackPointOnSegment(i3, i4 + i9, i3 - i9, i4);
            if (blackPointOnSegment4 != null) {
                break;
            }
        }
        if (blackPointOnSegment4 == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        for (int i10 = 1; i10 < i6; i10++) {
            blackPointOnSegment = getBlackPointOnSegment(i3, i5 - i10, i3 - i10, i5);
            if (blackPointOnSegment != null) {
                break;
            }
        }
        if (blackPointOnSegment != null) {
            return centerEdges(blackPointOnSegment, blackPointOnSegment2, blackPointOnSegment4, blackPointOnSegment3);
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public WhiteRectangleDetector(BitMatrix bitMatrix, int i2, int i3, int i4) throws NotFoundException {
        this.image = bitMatrix;
        int height = bitMatrix.getHeight();
        this.height = height;
        int width = bitMatrix.getWidth();
        this.width = width;
        int i5 = i2 >> 1;
        int i6 = i3 - i5;
        this.leftInit = i6;
        int i7 = i3 + i5;
        this.rightInit = i7;
        int i8 = i4 - i5;
        this.upInit = i8;
        int i9 = i4 + i5;
        this.downInit = i9;
        if (i8 < 0 || i6 < 0 || i9 >= height || i7 >= width) {
            throw NotFoundException.getNotFoundInstance();
        }
    }
}
