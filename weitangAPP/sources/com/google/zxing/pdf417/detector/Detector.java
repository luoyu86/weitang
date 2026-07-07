package com.google.zxing.pdf417.detector;

import androidx.appcompat.widget.ActivityChooserView;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Detector {
    private static final int MAX_AVG_VARIANCE = 107;
    private static final int MAX_INDIVIDUAL_VARIANCE = 204;
    private static final int SKEW_THRESHOLD = 2;
    private static final int[] START_PATTERN = {8, 1, 1, 1, 1, 1, 1, 3};
    private static final int[] START_PATTERN_REVERSE = {3, 1, 1, 1, 1, 1, 1, 8};
    private static final int[] STOP_PATTERN = {7, 1, 1, 3, 1, 1, 1, 2, 1};
    private static final int[] STOP_PATTERN_REVERSE = {1, 2, 1, 1, 1, 3, 1, 1, 7};
    private final BinaryBitmap image;

    public Detector(BinaryBitmap binaryBitmap) {
        this.image = binaryBitmap;
    }

    private static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, float f2) {
        return ((((round(ResultPoint.distance(resultPoint, resultPoint2) / f2) + round(ResultPoint.distance(resultPoint3, resultPoint4) / f2)) >> 1) + 8) / 17) * 17;
    }

    private static float computeModuleWidth(ResultPoint[] resultPointArr) {
        return (((ResultPoint.distance(resultPointArr[0], resultPointArr[4]) + ResultPoint.distance(resultPointArr[1], resultPointArr[5])) / 34.0f) + ((ResultPoint.distance(resultPointArr[6], resultPointArr[2]) + ResultPoint.distance(resultPointArr[7], resultPointArr[3])) / 36.0f)) / 2.0f;
    }

    private static void correctCodeWordVertices(ResultPoint[] resultPointArr, boolean z) {
        float y = resultPointArr[4].getY() - resultPointArr[6].getY();
        if (z) {
            y = -y;
        }
        if (y > 2.0f) {
            float x = resultPointArr[4].getX() - resultPointArr[0].getX();
            resultPointArr[4] = new ResultPoint(resultPointArr[4].getX(), resultPointArr[4].getY() + ((x * (resultPointArr[6].getY() - resultPointArr[0].getY())) / (resultPointArr[6].getX() - resultPointArr[0].getX())));
        } else if ((-y) > 2.0f) {
            float x2 = resultPointArr[2].getX() - resultPointArr[6].getX();
            resultPointArr[6] = new ResultPoint(resultPointArr[6].getX(), resultPointArr[6].getY() - ((x2 * (resultPointArr[2].getY() - resultPointArr[4].getY())) / (resultPointArr[2].getX() - resultPointArr[4].getX())));
        }
        float y2 = resultPointArr[7].getY() - resultPointArr[5].getY();
        if (z) {
            y2 = -y2;
        }
        if (y2 > 2.0f) {
            float x3 = resultPointArr[5].getX() - resultPointArr[1].getX();
            resultPointArr[5] = new ResultPoint(resultPointArr[5].getX(), resultPointArr[5].getY() + ((x3 * (resultPointArr[7].getY() - resultPointArr[1].getY())) / (resultPointArr[7].getX() - resultPointArr[1].getX())));
            return;
        }
        if ((-y2) > 2.0f) {
            float x4 = resultPointArr[3].getX() - resultPointArr[7].getX();
            resultPointArr[7] = new ResultPoint(resultPointArr[7].getX(), resultPointArr[7].getY() - ((x4 * (resultPointArr[3].getY() - resultPointArr[5].getY())) / (resultPointArr[3].getX() - resultPointArr[5].getX())));
        }
    }

    private static int[] findGuardPattern(BitMatrix bitMatrix, int i2, int i3, int i4, boolean z, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int length = iArr.length;
        int i5 = i2;
        int i6 = i5;
        boolean z2 = z;
        int i7 = 0;
        while (i5 < i2 + i4) {
            if (bitMatrix.get(i5, i3) ^ z2) {
                iArr2[i7] = iArr2[i7] + 1;
            } else {
                int i8 = length - 1;
                if (i7 != i8) {
                    i7++;
                } else {
                    if (patternMatchVariance(iArr2, iArr, 204) < 107) {
                        return new int[]{i6, i5};
                    }
                    i6 += iArr2[0] + iArr2[1];
                    int i9 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i9);
                    iArr2[i9] = 0;
                    iArr2[i8] = 0;
                    i7--;
                }
                iArr2[i7] = 1;
                z2 = !z2;
            }
            i5++;
        }
        return null;
    }

    private static ResultPoint[] findVertices(BitMatrix bitMatrix) {
        boolean z;
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        ResultPoint[] resultPointArr = new ResultPoint[8];
        int[] iArr = new int[START_PATTERN.length];
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= height) {
                z = false;
                break;
            }
            if (findGuardPattern(bitMatrix, 0, i2, width, false, START_PATTERN, iArr) != null) {
                float f2 = i2;
                resultPointArr[0] = new ResultPoint(r1[0], f2);
                resultPointArr[4] = new ResultPoint(r1[1], f2);
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            int i3 = height - 1;
            while (true) {
                if (i3 <= 0) {
                    z = false;
                    break;
                }
                if (findGuardPattern(bitMatrix, 0, i3, width, false, START_PATTERN, iArr) != null) {
                    float f3 = i3;
                    resultPointArr[1] = new ResultPoint(r1[0], f3);
                    resultPointArr[5] = new ResultPoint(r1[1], f3);
                    z = true;
                    break;
                }
                i3--;
            }
        }
        int[] iArr2 = new int[STOP_PATTERN.length];
        if (z) {
            int i4 = 0;
            while (true) {
                if (i4 >= height) {
                    z = false;
                    break;
                }
                if (findGuardPattern(bitMatrix, 0, i4, width, false, STOP_PATTERN, iArr2) != null) {
                    float f4 = i4;
                    resultPointArr[2] = new ResultPoint(r1[1], f4);
                    resultPointArr[6] = new ResultPoint(r1[0], f4);
                    z = true;
                    break;
                }
                i4++;
            }
        }
        if (z) {
            int i5 = height - 1;
            while (true) {
                if (i5 <= 0) {
                    break;
                }
                if (findGuardPattern(bitMatrix, 0, i5, width, false, STOP_PATTERN, iArr2) != null) {
                    float f5 = i5;
                    resultPointArr[3] = new ResultPoint(r1[1], f5);
                    resultPointArr[7] = new ResultPoint(r1[0], f5);
                    z2 = true;
                    break;
                }
                i5--;
            }
        } else {
            z2 = z;
        }
        if (z2) {
            return resultPointArr;
        }
        return null;
    }

    private static ResultPoint[] findVertices180(BitMatrix bitMatrix) {
        boolean z;
        int height = bitMatrix.getHeight();
        boolean z2 = true;
        int width = bitMatrix.getWidth() >> 1;
        ResultPoint[] resultPointArr = new ResultPoint[8];
        int[] iArr = new int[START_PATTERN_REVERSE.length];
        int i2 = height - 1;
        int i3 = i2;
        while (true) {
            if (i3 <= 0) {
                z = false;
                break;
            }
            if (findGuardPattern(bitMatrix, width, i3, width, true, START_PATTERN_REVERSE, iArr) != null) {
                float f2 = i3;
                resultPointArr[0] = new ResultPoint(r3[1], f2);
                resultPointArr[4] = new ResultPoint(r3[0], f2);
                z = true;
                break;
            }
            i3--;
        }
        if (z) {
            int i4 = 0;
            while (true) {
                if (i4 >= height) {
                    z = false;
                    break;
                }
                if (findGuardPattern(bitMatrix, width, i4, width, true, START_PATTERN_REVERSE, iArr) != null) {
                    float f3 = i4;
                    resultPointArr[1] = new ResultPoint(r3[1], f3);
                    resultPointArr[5] = new ResultPoint(r3[0], f3);
                    z = true;
                    break;
                }
                i4++;
            }
        }
        int[] iArr2 = new int[STOP_PATTERN_REVERSE.length];
        if (z) {
            while (true) {
                if (i2 <= 0) {
                    z = false;
                    break;
                }
                if (findGuardPattern(bitMatrix, 0, i2, width, false, STOP_PATTERN_REVERSE, iArr2) != null) {
                    float f4 = i2;
                    resultPointArr[2] = new ResultPoint(r3[0], f4);
                    resultPointArr[6] = new ResultPoint(r3[1], f4);
                    z = true;
                    break;
                }
                i2--;
            }
        }
        if (z) {
            int i5 = 0;
            while (true) {
                if (i5 >= height) {
                    z2 = false;
                    break;
                }
                if (findGuardPattern(bitMatrix, 0, i5, width, false, STOP_PATTERN_REVERSE, iArr2) != null) {
                    float f5 = i5;
                    resultPointArr[3] = new ResultPoint(r3[0], f5);
                    resultPointArr[7] = new ResultPoint(r3[1], f5);
                    break;
                }
                i5++;
            }
        } else {
            z2 = z;
        }
        if (z2) {
            return resultPointArr;
        }
        return null;
    }

    private static int patternMatchVariance(int[] iArr, int[] iArr2, int i2) {
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            i3 += iArr[i5];
            i4 += iArr2[i5];
        }
        if (i3 < i4) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        int i6 = (i3 << 8) / i4;
        int i7 = (i2 * i6) >> 8;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = iArr[i9] << 8;
            int i11 = iArr2[i9] * i6;
            int i12 = i10 > i11 ? i10 - i11 : i11 - i10;
            if (i12 > i7) {
                return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            }
            i8 += i12;
        }
        return i8 / i3;
    }

    private static int round(float f2) {
        return (int) (f2 + 0.5f);
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i2) throws NotFoundException {
        float f2 = i2;
        return GridSampler.getInstance().sampleGrid(bitMatrix, i2, i2, 0.0f, 0.0f, f2, 0.0f, f2, f2, 0.0f, f2, resultPoint.getX(), resultPoint.getY(), resultPoint3.getX(), resultPoint3.getY(), resultPoint4.getX(), resultPoint4.getY(), resultPoint2.getX(), resultPoint2.getY());
    }

    public DetectorResult detect() throws NotFoundException {
        return detect(null);
    }

    public DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException {
        BitMatrix blackMatrix = this.image.getBlackMatrix();
        ResultPoint[] resultPointArrFindVertices = findVertices(blackMatrix);
        if (resultPointArrFindVertices == null) {
            resultPointArrFindVertices = findVertices180(blackMatrix);
            if (resultPointArrFindVertices != null) {
                correctCodeWordVertices(resultPointArrFindVertices, true);
            }
        } else {
            correctCodeWordVertices(resultPointArrFindVertices, false);
        }
        if (resultPointArrFindVertices == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float fComputeModuleWidth = computeModuleWidth(resultPointArrFindVertices);
        if (fComputeModuleWidth < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iComputeDimension = computeDimension(resultPointArrFindVertices[4], resultPointArrFindVertices[6], resultPointArrFindVertices[5], resultPointArrFindVertices[7], fComputeModuleWidth);
        if (iComputeDimension >= 1) {
            return new DetectorResult(sampleGrid(blackMatrix, resultPointArrFindVertices[4], resultPointArrFindVertices[5], resultPointArrFindVertices[6], resultPointArrFindVertices[7], iComputeDimension), new ResultPoint[]{resultPointArrFindVertices[5], resultPointArrFindVertices[4], resultPointArrFindVertices[6], resultPointArrFindVertices[7]});
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
