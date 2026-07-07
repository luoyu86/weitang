package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    private static final int INTEGER_MATH_SHIFT = 8;
    public static final int MAX_MODULES = 57;
    public static final int MIN_SKIP = 3;
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    public static class CenterComparator implements Comparator<FinderPattern>, Serializable {
        private final float average;

        private CenterComparator(float f2) {
            this.average = f2;
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            if (finderPattern2.getCount() != finderPattern.getCount()) {
                return finderPattern2.getCount() - finderPattern.getCount();
            }
            float fAbs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float fAbs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (fAbs < fAbs2) {
                return 1;
            }
            return fAbs == fAbs2 ? 0 : -1;
        }
    }

    public static class FurthestFromAverageComparator implements Comparator<FinderPattern>, Serializable {
        private final float average;

        private FurthestFromAverageComparator(float f2) {
            this.average = f2;
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            float fAbs = Math.abs(finderPattern2.getEstimatedModuleSize() - this.average);
            float fAbs2 = Math.abs(finderPattern.getEstimatedModuleSize() - this.average);
            if (fAbs < fAbs2) {
                return -1;
            }
            return fAbs == fAbs2 ? 0 : 1;
        }
    }

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    private static float centerFromEnd(int[] iArr, int i2) {
        return ((i2 - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    private float crossCheckHorizontal(int i2, int i3, int i4, int i5) {
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i6 = i2;
        while (i6 >= 0 && bitMatrix.get(i6, i3)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bitMatrix.get(i6, i3) && crossCheckStateCount[1] <= i4) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i6--;
        }
        if (i6 < 0 || crossCheckStateCount[1] > i4) {
            return Float.NaN;
        }
        while (i6 >= 0 && bitMatrix.get(i6, i3) && crossCheckStateCount[0] <= i4) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i6--;
        }
        if (crossCheckStateCount[0] > i4) {
            return Float.NaN;
        }
        int i7 = i2 + 1;
        while (i7 < width && bitMatrix.get(i7, i3)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i7++;
        }
        if (i7 == width) {
            return Float.NaN;
        }
        while (i7 < width && !bitMatrix.get(i7, i3) && crossCheckStateCount[3] < i4) {
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i7++;
        }
        if (i7 == width || crossCheckStateCount[3] >= i4) {
            return Float.NaN;
        }
        while (i7 < width && bitMatrix.get(i7, i3) && crossCheckStateCount[4] < i4) {
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i7++;
        }
        if (crossCheckStateCount[4] < i4 && Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i5) * 5 < i5 && foundPatternCross(crossCheckStateCount)) {
            return centerFromEnd(crossCheckStateCount, i7);
        }
        return Float.NaN;
    }

    private float crossCheckVertical(int i2, int i3, int i4, int i5) {
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i6 = i2;
        while (i6 >= 0 && bitMatrix.get(i3, i6)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i6--;
        }
        if (i6 < 0) {
            return Float.NaN;
        }
        while (i6 >= 0 && !bitMatrix.get(i3, i6) && crossCheckStateCount[1] <= i4) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i6--;
        }
        if (i6 < 0 || crossCheckStateCount[1] > i4) {
            return Float.NaN;
        }
        while (i6 >= 0 && bitMatrix.get(i3, i6) && crossCheckStateCount[0] <= i4) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i6--;
        }
        if (crossCheckStateCount[0] > i4) {
            return Float.NaN;
        }
        int i7 = i2 + 1;
        while (i7 < height && bitMatrix.get(i3, i7)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i7++;
        }
        if (i7 == height) {
            return Float.NaN;
        }
        while (i7 < height && !bitMatrix.get(i3, i7) && crossCheckStateCount[3] < i4) {
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i7++;
        }
        if (i7 == height || crossCheckStateCount[3] >= i4) {
            return Float.NaN;
        }
        while (i7 < height && bitMatrix.get(i3, i7) && crossCheckStateCount[4] < i4) {
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i7++;
        }
        if (crossCheckStateCount[4] < i4 && Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + crossCheckStateCount[4]) - i5) * 5 < i5 * 2 && foundPatternCross(crossCheckStateCount)) {
            return centerFromEnd(crossCheckStateCount, i7);
        }
        return Float.NaN;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    public static boolean foundPatternCross(int[] iArr) {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < 5; i5++) {
            int i6 = iArr[i5];
            if (i6 == 0) {
                return false;
            }
            i4 += i6;
        }
        return i4 >= 7 && Math.abs(i2 - (iArr[0] << 8)) < (i3 = (i2 = (i4 << 8) / 7) / 2) && Math.abs(i2 - (iArr[1] << 8)) < i3 && Math.abs((i2 * 3) - (iArr[2] << 8)) < i3 * 3 && Math.abs(i2 - (iArr[3] << 8)) < i3 && Math.abs(i2 - (iArr[4] << 8)) < i3;
    }

    private int[] getCrossCheckStateCount() {
        int[] iArr = this.crossCheckStateCount;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        return iArr;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float fAbs = 0.0f;
        int i2 = 0;
        float estimatedModuleSize = 0.0f;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i2++;
                estimatedModuleSize += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i2 < 3) {
            return false;
        }
        float f2 = estimatedModuleSize / size;
        Iterator<FinderPattern> it = this.possibleCenters.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().getEstimatedModuleSize() - f2);
        }
        return fAbs <= estimatedModuleSize * 0.05f;
    }

    private FinderPattern[] selectBestPatterns() throws NotFoundException {
        int size = this.possibleCenters.size();
        if (size < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        float estimatedModuleSize = 0.0f;
        if (size > 3) {
            Iterator<FinderPattern> it = this.possibleCenters.iterator();
            float f2 = 0.0f;
            float f3 = 0.0f;
            while (it.hasNext()) {
                float estimatedModuleSize2 = it.next().getEstimatedModuleSize();
                f2 += estimatedModuleSize2;
                f3 += estimatedModuleSize2 * estimatedModuleSize2;
            }
            float f4 = f2 / size;
            float fSqrt = (float) Math.sqrt((f3 / r0) - (f4 * f4));
            Collections.sort(this.possibleCenters, new FurthestFromAverageComparator(f4));
            float fMax = Math.max(0.2f * f4, fSqrt);
            int i2 = 0;
            while (i2 < this.possibleCenters.size() && this.possibleCenters.size() > 3) {
                if (Math.abs(this.possibleCenters.get(i2).getEstimatedModuleSize() - f4) > fMax) {
                    this.possibleCenters.remove(i2);
                    i2--;
                }
                i2++;
            }
        }
        if (this.possibleCenters.size() > 3) {
            Iterator<FinderPattern> it2 = this.possibleCenters.iterator();
            while (it2.hasNext()) {
                estimatedModuleSize += it2.next().getEstimatedModuleSize();
            }
            Collections.sort(this.possibleCenters, new CenterComparator(estimatedModuleSize / this.possibleCenters.size()));
            List<FinderPattern> list = this.possibleCenters;
            list.subList(3, list.size()).clear();
        }
        return new FinderPattern[]{this.possibleCenters.get(0), this.possibleCenters.get(1), this.possibleCenters.get(2)};
    }

    public FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i2 = (height * 3) / 228;
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        boolean zHaveMultiplyConfirmedCenters = false;
        while (i3 < height && !zHaveMultiplyConfirmedCenters) {
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            iArr[3] = 0;
            iArr[4] = 0;
            int i4 = 0;
            int i5 = 0;
            while (i4 < width) {
                if (this.image.get(i4, i3)) {
                    if ((i5 & 1) == 1) {
                        i5++;
                    }
                    iArr[i5] = iArr[i5] + 1;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 != 4) {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                } else if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i3, i4)) {
                    if (this.hasSkipped) {
                        zHaveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                    } else {
                        int iFindRowSkip = findRowSkip();
                        if (iFindRowSkip > iArr[2]) {
                            i3 += (iFindRowSkip - iArr[2]) - 2;
                            i4 = width - 1;
                        }
                    }
                    iArr[0] = 0;
                    iArr[1] = 0;
                    iArr[2] = 0;
                    iArr[3] = 0;
                    iArr[4] = 0;
                    i2 = 2;
                    i5 = 0;
                } else {
                    iArr[0] = iArr[2];
                    iArr[1] = iArr[3];
                    iArr[2] = iArr[4];
                    iArr[3] = 1;
                    iArr[4] = 0;
                    i5 = 3;
                }
                i4++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i3, width)) {
                i2 = iArr[0];
                if (this.hasSkipped) {
                    zHaveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                }
            }
            i3 += i2;
        }
        FinderPattern[] finderPatternArrSelectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(finderPatternArrSelectBestPatterns);
        return new FinderPatternInfo(finderPatternArrSelectBestPatterns);
    }

    public BitMatrix getImage() {
        return this.image;
    }

    public List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    public boolean handlePossibleCenter(int[] iArr, int i2, int i3) {
        boolean z = false;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iCenterFromEnd = (int) centerFromEnd(iArr, i3);
        float fCrossCheckVertical = crossCheckVertical(i2, iCenterFromEnd, iArr[2], i4);
        if (!Float.isNaN(fCrossCheckVertical)) {
            float fCrossCheckHorizontal = crossCheckHorizontal(iCenterFromEnd, (int) fCrossCheckVertical, iArr[2], i4);
            if (!Float.isNaN(fCrossCheckHorizontal)) {
                float f2 = i4 / 7.0f;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.possibleCenters.size()) {
                        break;
                    }
                    FinderPattern finderPattern = this.possibleCenters.get(i5);
                    if (finderPattern.aboutEquals(f2, fCrossCheckVertical, fCrossCheckHorizontal)) {
                        this.possibleCenters.set(i5, finderPattern.combineEstimate(fCrossCheckVertical, fCrossCheckHorizontal, f2));
                        z = true;
                        break;
                    }
                    i5++;
                }
                if (!z) {
                    FinderPattern finderPattern2 = new FinderPattern(fCrossCheckHorizontal, fCrossCheckVertical, f2);
                    this.possibleCenters.add(finderPattern2);
                    ResultPointCallback resultPointCallback = this.resultPointCallback;
                    if (resultPointCallback != null) {
                        resultPointCallback.foundPossibleResultPoint(finderPattern2);
                    }
                }
                return true;
            }
        }
        return false;
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }
}
