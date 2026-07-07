package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class Detector {
    private final BitMatrix image;
    private ResultPointCallback resultPointCallback;

    public Detector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    private float calculateModuleSizeOneWay(ResultPoint resultPoint, ResultPoint resultPoint2) {
        float fSizeOfBlackWhiteBlackRunBothWays = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint.getX(), (int) resultPoint.getY(), (int) resultPoint2.getX(), (int) resultPoint2.getY());
        float fSizeOfBlackWhiteBlackRunBothWays2 = sizeOfBlackWhiteBlackRunBothWays((int) resultPoint2.getX(), (int) resultPoint2.getY(), (int) resultPoint.getX(), (int) resultPoint.getY());
        return Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays) ? fSizeOfBlackWhiteBlackRunBothWays2 / 7.0f : Float.isNaN(fSizeOfBlackWhiteBlackRunBothWays2) ? fSizeOfBlackWhiteBlackRunBothWays / 7.0f : (fSizeOfBlackWhiteBlackRunBothWays + fSizeOfBlackWhiteBlackRunBothWays2) / 14.0f;
    }

    public static int computeDimension(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, float f2) throws NotFoundException {
        int iRound = ((round(ResultPoint.distance(resultPoint, resultPoint2) / f2) + round(ResultPoint.distance(resultPoint, resultPoint3) / f2)) >> 1) + 7;
        int i2 = iRound & 3;
        if (i2 == 0) {
            return iRound + 1;
        }
        if (i2 == 2) {
            return iRound - 1;
        }
        if (i2 != 3) {
            return iRound;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static PerspectiveTransform createTransform(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4, int i2) {
        float x;
        float y;
        float f2;
        float f3 = i2 - 3.5f;
        if (resultPoint4 != null) {
            x = resultPoint4.getX();
            y = resultPoint4.getY();
            f2 = f3 - 3.0f;
        } else {
            x = (resultPoint2.getX() - resultPoint.getX()) + resultPoint3.getX();
            y = (resultPoint2.getY() - resultPoint.getY()) + resultPoint3.getY();
            f2 = f3;
        }
        return PerspectiveTransform.quadrilateralToQuadrilateral(3.5f, 3.5f, f3, 3.5f, f2, f2, 3.5f, f3, resultPoint.getX(), resultPoint.getY(), resultPoint2.getX(), resultPoint2.getY(), x, y, resultPoint3.getX(), resultPoint3.getY());
    }

    private static int round(float f2) {
        return (int) (f2 + 0.5f);
    }

    private static BitMatrix sampleGrid(BitMatrix bitMatrix, PerspectiveTransform perspectiveTransform, int i2) throws NotFoundException {
        return GridSampler.getInstance().sampleGrid(bitMatrix, i2, i2, perspectiveTransform);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0092, code lost:
    
        if (r15 != 2) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0094, code lost:
    
        r5 = r20 - r1;
        r0 = java.lang.Math.sqrt((r5 * r5) + (r19 * r19));
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a1, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private float sizeOfBlackWhiteBlackRun(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r4 = r18
            r1 = r19
            r6 = r20
            r5 = r21
            goto L25
        L1d:
            r1 = r18
            r4 = r19
            r5 = r20
            r6 = r21
        L25:
            int r7 = r5 - r1
            int r7 = java.lang.Math.abs(r7)
            int r8 = r6 - r4
            int r9 = java.lang.Math.abs(r8)
            int r10 = -r7
            int r10 = r10 >> r3
            r11 = -1
            if (r1 >= r5) goto L38
            r12 = 1
            goto L39
        L38:
            r12 = -1
        L39:
            if (r4 >= r6) goto L3c
            r11 = 1
        L3c:
            int r5 = r5 + r12
            r13 = r1
            r14 = r4
            r15 = 0
        L40:
            if (r13 == r5) goto L8b
            if (r0 == 0) goto L46
            r2 = r14
            goto L47
        L46:
            r2 = r13
        L47:
            r16 = r0
            if (r0 == 0) goto L4d
            r0 = r13
            goto L4e
        L4d:
            r0 = r14
        L4e:
            if (r15 != r3) goto L58
            r3 = r17
            r20 = r5
            r19 = r8
            r8 = 1
            goto L5f
        L58:
            r3 = r17
            r20 = r5
            r19 = r8
            r8 = 0
        L5f:
            com.google.zxing.common.BitMatrix r5 = r3.image
            boolean r0 = r5.get(r2, r0)
            if (r8 != r0) goto L7a
            r0 = 2
            if (r15 != r0) goto L78
            int r13 = r13 - r1
            int r14 = r14 - r4
            int r13 = r13 * r13
            int r14 = r14 * r14
            int r13 = r13 + r14
            double r0 = (double) r13
            double r0 = java.lang.Math.sqrt(r0)
        L76:
            float r0 = (float) r0
            return r0
        L78:
            int r15 = r15 + 1
        L7a:
            int r10 = r10 + r9
            if (r10 <= 0) goto L82
            if (r14 != r6) goto L80
            goto L91
        L80:
            int r14 = r14 + r11
            int r10 = r10 - r7
        L82:
            int r13 = r13 + r12
            r8 = r19
            r5 = r20
            r0 = r16
            r3 = 1
            goto L40
        L8b:
            r3 = r17
            r20 = r5
            r19 = r8
        L91:
            r0 = 2
            if (r15 != r0) goto La1
            int r5 = r20 - r1
            int r5 = r5 * r5
            int r8 = r19 * r19
            int r5 = r5 + r8
            double r0 = (double) r5
            double r0 = java.lang.Math.sqrt(r0)
            goto L76
        La1:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.Detector.sizeOfBlackWhiteBlackRun(int, int, int, int):float");
    }

    private float sizeOfBlackWhiteBlackRunBothWays(int i2, int i3, int i4, int i5) {
        float width;
        float height;
        float fSizeOfBlackWhiteBlackRun = sizeOfBlackWhiteBlackRun(i2, i3, i4, i5);
        int width2 = i2 - (i4 - i2);
        int height2 = 0;
        if (width2 < 0) {
            width = i2 / (i2 - width2);
            width2 = 0;
        } else if (width2 >= this.image.getWidth()) {
            width = ((this.image.getWidth() - 1) - i2) / (width2 - i2);
            width2 = this.image.getWidth() - 1;
        } else {
            width = 1.0f;
        }
        float f2 = i3;
        int i6 = (int) (f2 - ((i5 - i3) * width));
        if (i6 < 0) {
            height = f2 / (i3 - i6);
        } else if (i6 >= this.image.getHeight()) {
            height = ((this.image.getHeight() - 1) - i3) / (i6 - i3);
            height2 = this.image.getHeight() - 1;
        } else {
            height2 = i6;
            height = 1.0f;
        }
        return (fSizeOfBlackWhiteBlackRun + sizeOfBlackWhiteBlackRun(i2, i3, (int) (i2 + ((width2 - i2) * height)), height2)) - 1.0f;
    }

    public float calculateModuleSize(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        return (calculateModuleSizeOneWay(resultPoint, resultPoint2) + calculateModuleSizeOneWay(resultPoint, resultPoint3)) / 2.0f;
    }

    public DetectorResult detect() throws NotFoundException, FormatException {
        return detect(null);
    }

    public AlignmentPattern findAlignmentInRegion(float f2, int i2, int i3, float f3) throws NotFoundException {
        int i4 = (int) (f3 * f2);
        int iMax = Math.max(0, i2 - i4);
        int iMin = Math.min(this.image.getWidth() - 1, i2 + i4) - iMax;
        float f4 = 3.0f * f2;
        if (iMin < f4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iMax2 = Math.max(0, i3 - i4);
        int iMin2 = Math.min(this.image.getHeight() - 1, i3 + i4) - iMax2;
        if (iMin2 >= f4) {
            return new AlignmentPatternFinder(this.image, iMax, iMax2, iMin, iMin2, f2, this.resultPointCallback).find();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public BitMatrix getImage() {
        return this.image;
    }

    public ResultPointCallback getResultPointCallback() {
        return this.resultPointCallback;
    }

    public DetectorResult processFinderPatternInfo(FinderPatternInfo finderPatternInfo) throws NotFoundException, FormatException {
        FinderPattern topLeft = finderPatternInfo.getTopLeft();
        FinderPattern topRight = finderPatternInfo.getTopRight();
        FinderPattern bottomLeft = finderPatternInfo.getBottomLeft();
        float fCalculateModuleSize = calculateModuleSize(topLeft, topRight, bottomLeft);
        if (fCalculateModuleSize < 1.0f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iComputeDimension = computeDimension(topLeft, topRight, bottomLeft, fCalculateModuleSize);
        Version provisionalVersionForDimension = Version.getProvisionalVersionForDimension(iComputeDimension);
        int dimensionForVersion = provisionalVersionForDimension.getDimensionForVersion() - 7;
        AlignmentPattern alignmentPatternFindAlignmentInRegion = null;
        if (provisionalVersionForDimension.getAlignmentPatternCenters().length > 0) {
            float x = (topRight.getX() - topLeft.getX()) + bottomLeft.getX();
            float y = (topRight.getY() - topLeft.getY()) + bottomLeft.getY();
            float f2 = 1.0f - (3.0f / dimensionForVersion);
            int x2 = (int) (topLeft.getX() + ((x - topLeft.getX()) * f2));
            int y2 = (int) (topLeft.getY() + (f2 * (y - topLeft.getY())));
            for (int i2 = 4; i2 <= 16; i2 <<= 1) {
                try {
                    alignmentPatternFindAlignmentInRegion = findAlignmentInRegion(fCalculateModuleSize, x2, y2, i2);
                    break;
                } catch (NotFoundException unused) {
                }
            }
        }
        return new DetectorResult(sampleGrid(this.image, createTransform(topLeft, topRight, bottomLeft, alignmentPatternFindAlignmentInRegion, iComputeDimension), iComputeDimension), alignmentPatternFindAlignmentInRegion == null ? new ResultPoint[]{bottomLeft, topLeft, topRight} : new ResultPoint[]{bottomLeft, topLeft, topRight, alignmentPatternFindAlignmentInRegion});
    }

    public DetectorResult detect(Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        this.resultPointCallback = resultPointCallback;
        return processFinderPatternInfo(new FinderPatternFinder(this.image, resultPointCallback).find(map));
    }
}
