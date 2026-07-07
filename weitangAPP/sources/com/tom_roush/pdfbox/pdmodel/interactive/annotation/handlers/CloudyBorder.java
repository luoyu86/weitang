package com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers;

import android.graphics.PointF;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.pdmodel.PDAppearanceContentStream;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class CloudyBorder {
    private static final double ANGLE_180_DEG = 3.141592653589793d;
    private static final double ANGLE_90_DEG = 1.5707963267948966d;
    private final PDRectangle annotRect;
    private double bboxMaxX;
    private double bboxMaxY;
    private double bboxMinX;
    private double bboxMinY;
    private final double intensity;
    private final double lineWidth;
    private final PDAppearanceContentStream output;
    private boolean outputStarted = false;
    private PDRectangle rectWithDiff;
    private static final double ANGLE_34_DEG = Math.toRadians(34.0d);
    private static final double ANGLE_30_DEG = Math.toRadians(30.0d);
    private static final double ANGLE_12_DEG = Math.toRadians(12.0d);

    public CloudyBorder(PDAppearanceContentStream pDAppearanceContentStream, double d2, double d3, PDRectangle pDRectangle) {
        this.output = pDAppearanceContentStream;
        this.intensity = d2;
        this.lineWidth = d3;
        this.annotRect = pDRectangle;
    }

    private void addCornerCurl(double d2, double d3, double d4, double d5, double d6, double d7, double d8, boolean z) throws IOException {
        double d9 = d2 + ANGLE_180_DEG + d8;
        double radians = d9 - Math.toRadians(22.0d);
        getArcSegment(d9, radians, d5, d6, d4, d4, null, z);
        getArc(radians, d3 - d7, d4, d4, d5, d6, null, false);
    }

    private void addFirstIntermediateCurl(double d2, double d3, double d4, double d5, double d6) throws IOException {
        double d7 = d2 + ANGLE_180_DEG;
        double d8 = d7 + d4;
        double d9 = ANGLE_30_DEG;
        getArcSegment(d8, d8 - d9, d5, d6, d3, d3, null, false);
        double d10 = d7 + ANGLE_90_DEG;
        getArcSegment(d8 - d9, d10, d5, d6, d3, d3, null, false);
        getArcSegment(d10, (d7 + ANGLE_180_DEG) - ANGLE_34_DEG, d5, d6, d3, d3, null, false);
    }

    private PDRectangle applyRectDiff(PDRectangle pDRectangle, double d2) {
        double d3;
        double dMax;
        double dMax2;
        double d4 = d2;
        float lowerLeftX = this.annotRect.getLowerLeftX();
        float lowerLeftY = this.annotRect.getLowerLeftY();
        float upperRightX = this.annotRect.getUpperRightX();
        float upperRightY = this.annotRect.getUpperRightY();
        float fMin = Math.min(lowerLeftX, upperRightX);
        float fMin2 = Math.min(lowerLeftY, upperRightY);
        float fMax = Math.max(fMin, upperRightX);
        float fMax2 = Math.max(fMin2, upperRightY);
        if (pDRectangle != null) {
            double dMax3 = Math.max(pDRectangle.getLowerLeftX(), d4);
            dMax = Math.max(pDRectangle.getLowerLeftY(), d4);
            dMax2 = Math.max(pDRectangle.getUpperRightX(), d4);
            double dMax4 = Math.max(pDRectangle.getUpperRightY(), d4);
            d4 = dMax3;
            d3 = dMax4;
        } else {
            d3 = d4;
            dMax = d3;
            dMax2 = dMax;
        }
        float f2 = (float) (((double) fMin) + d4);
        float f3 = (float) (((double) fMin2) + dMax);
        return new PDRectangle(f2, f3, ((float) (((double) fMax) - dMax2)) - f2, ((float) (((double) fMax2) - d3)) - f3);
    }

    private void beginOutput(double d2, double d3) throws IOException {
        this.bboxMinX = d2;
        this.bboxMinY = d3;
        this.bboxMaxX = d2;
        this.bboxMaxY = d3;
        this.outputStarted = true;
        this.output.setLineJoinStyle(2);
    }

    private void cloudyEllipseImpl(double d2, double d3, double d4, double d5) throws IOException {
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double dComputeParamsEllipse;
        double dAtan2;
        int i2;
        double d11;
        double d12;
        if (this.intensity <= 0.0d) {
            drawBasicEllipse(d2, d3, d4, d5);
            return;
        }
        double d13 = d4 - d2;
        double d14 = d5 - d3;
        double ellipseCloudRadius = getEllipseCloudRadius();
        double d15 = ellipseCloudRadius * 0.5d;
        if (d13 < d15 && d14 < d15) {
            drawBasicEllipse(d2, d3, d4, d5);
            return;
        }
        if ((d13 < 5.0d && d14 > 20.0d) || (d13 > 20.0d && d14 < 5.0d)) {
            cloudyRectangleImpl(d2, d3, d4, d5, true);
            return;
        }
        double dSin = (Math.sin(ANGLE_12_DEG) * ellipseCloudRadius) - 1.5d;
        double d16 = dSin * 2.0d;
        if (d13 > d16) {
            d7 = d2 + dSin;
            d6 = d4 - dSin;
        } else {
            double d17 = (d2 + d4) / 2.0d;
            d6 = d17 + 0.1d;
            d7 = d17 - 0.1d;
        }
        if (d14 > d16) {
            d9 = d5 - dSin;
            d8 = d3 + dSin;
        } else {
            double d18 = (d5 + d3) / 2.0d;
            d8 = d18 - 0.1d;
            d9 = d18 + 0.1d;
        }
        PointF[] pointFArrFlattenEllipse = flattenEllipse(d7, d8, d6, d9);
        int length = pointFArrFlattenEllipse.length;
        if (length < 2) {
            return;
        }
        double dHypot = 0.0d;
        for (int i3 = 1; i3 < length; i3++) {
            int i4 = i3 - 1;
            dHypot += Math.hypot(pointFArrFlattenEllipse[i3].x - pointFArrFlattenEllipse[i4].x, pointFArrFlattenEllipse[i3].y - pointFArrFlattenEllipse[i4].y);
        }
        double dCos = Math.cos(ANGLE_34_DEG) * 2.0d;
        int iCeil = (int) Math.ceil(dHypot / (ellipseCloudRadius * dCos));
        if (iCeil < 2) {
            drawBasicEllipse(d2, d3, d4, d5);
            return;
        }
        double d19 = dHypot / ((double) iCeil);
        double d20 = d19 / dCos;
        if (d20 < 0.5d) {
            d19 = dCos * 0.5d;
            d10 = 0.5d;
        } else {
            if (d20 < 3.0d) {
                drawBasicEllipse(d2, d3, d4, d5);
                return;
            }
            d10 = d20;
        }
        double d21 = d19;
        PointF[] pointFArr = new PointF[iCeil];
        double d22 = this.lineWidth * 0.1d;
        int i5 = 0;
        double d23 = 0.0d;
        int i6 = 0;
        while (true) {
            int i7 = i5 + 1;
            if (i7 >= length) {
                break;
            }
            PointF pointF = pointFArrFlattenEllipse[i5];
            PointF pointF2 = pointFArrFlattenEllipse[i7];
            PointF[] pointFArr2 = pointFArrFlattenEllipse;
            int i8 = i6;
            double d24 = pointF2.x - pointF.x;
            double d25 = pointF2.y - pointF.y;
            double dHypot2 = Math.hypot(r11 - r12, r0 - r10);
            if (Double.compare(dHypot2, 0.0d) == 0) {
                i2 = length;
                d11 = d22;
            } else {
                double d26 = dHypot2 + d23;
                double d27 = d21 - d22;
                if (d26 >= d27 || i5 == length - 2) {
                    double dCosine = cosine(d24, dHypot2);
                    i2 = length;
                    double dSine = sine(d25, dHypot2);
                    double d28 = d21 - d23;
                    int i9 = i8;
                    while (true) {
                        d11 = d22;
                        double d29 = ((double) pointF.x) + (d28 * dCosine);
                        double d30 = dCosine;
                        double d31 = ((double) pointF.y) + (d28 * dSine);
                        if (i9 < iCeil) {
                            d12 = dSine;
                            pointFArr[i9] = new PointF((float) d29, (float) d31);
                            i9++;
                        } else {
                            d12 = dSine;
                        }
                        d26 -= d21;
                        d28 += d21;
                        if (d26 < d27) {
                            break;
                        }
                        d22 = d11;
                        dCosine = d30;
                        dSine = d12;
                    }
                    d23 = d26 < 0.0d ? 0.0d : d26;
                    i6 = i9;
                    d22 = d11;
                    length = i2;
                    pointFArrFlattenEllipse = pointFArr2;
                    i5 = i7;
                } else {
                    i2 = length;
                    d11 = d22;
                    d23 = d26;
                }
            }
            i6 = i8;
            d22 = d11;
            length = i2;
            pointFArrFlattenEllipse = pointFArr2;
            i5 = i7;
        }
        double d32 = 0.0d;
        double d33 = 0.0d;
        int i10 = 0;
        while (i10 < i6) {
            int i11 = i10 + 1;
            int i12 = i11 >= i6 ? 0 : i11;
            PointF pointF3 = pointFArr[i10];
            PointF pointF4 = pointFArr[i12];
            if (i10 == 0) {
                PointF pointF5 = pointFArr[i6 - 1];
                dAtan2 = Math.atan2(pointF3.y - pointF5.y, pointF3.x - pointF5.x);
                dComputeParamsEllipse = computeParamsEllipse(pointF5, pointF3, d10, d21);
            } else {
                dComputeParamsEllipse = d32;
                dAtan2 = d33;
            }
            double dAtan22 = Math.atan2(pointF4.y - pointF3.y, pointF4.x - pointF3.x);
            double dComputeParamsEllipse2 = computeParamsEllipse(pointF3, pointF4, d10, d21);
            addCornerCurl(dAtan2, dAtan22, d10, pointF3.x, pointF3.y, dComputeParamsEllipse2, dComputeParamsEllipse, !this.outputStarted);
            i10 = i11;
            d33 = dAtan22;
            d32 = dComputeParamsEllipse2;
            pointFArr = pointFArr;
            i6 = i6;
        }
    }

    private void cloudyPolygonImpl(PointF[] pointFArr, boolean z) throws IOException {
        int i2;
        int i3;
        double dAtan2;
        PointF[] pointFArr2;
        CloudyBorder cloudyBorder;
        double d2;
        int i4;
        double d3;
        CloudyBorder cloudyBorder2 = this;
        PointF[] pointFArrRemoveZeroLengthSegments = removeZeroLengthSegments(pointFArr);
        cloudyBorder2.getPositivePolygon(pointFArrRemoveZeroLengthSegments);
        int length = pointFArrRemoveZeroLengthSegments.length;
        if (length < 2) {
            return;
        }
        if (cloudyBorder2.intensity <= 0.0d) {
            cloudyBorder2.moveTo(pointFArrRemoveZeroLengthSegments[0]);
            for (int i5 = 1; i5 < length; i5++) {
                cloudyBorder2.lineTo(pointFArrRemoveZeroLengthSegments[i5]);
            }
            return;
        }
        double ellipseCloudRadius = z ? getEllipseCloudRadius() : getPolygonCloudRadius();
        double d4 = ellipseCloudRadius < 0.5d ? 0.5d : ellipseCloudRadius;
        double d5 = ANGLE_34_DEG;
        double dCos = Math.cos(d5);
        double d6 = dCos * 2.0d * d4;
        double d7 = dCos * d4;
        double[] dArr = new double[2];
        int i6 = length - 2;
        double d8 = d4;
        if (computeParamsPolygon(d6, d7, dCos, d4, Math.hypot(pointFArrRemoveZeroLengthSegments[0].x - pointFArrRemoveZeroLengthSegments[i6].x, pointFArrRemoveZeroLengthSegments[0].y - pointFArrRemoveZeroLengthSegments[i6].y), dArr) == 0) {
            d5 = dArr[0];
        }
        double d9 = d5;
        double d10 = 0.0d;
        int i7 = 0;
        while (true) {
            int i8 = i7 + 1;
            if (i8 >= length) {
                return;
            }
            PointF pointF = pointFArrRemoveZeroLengthSegments[i7];
            PointF pointF2 = pointFArrRemoveZeroLengthSegments[i8];
            double dHypot = Math.hypot(pointF2.x - pointF.x, pointF2.y - pointF.y);
            if (Double.compare(dHypot, 0.0d) == 0) {
                d9 = ANGLE_34_DEG;
                d2 = d8;
                i3 = i8;
                pointFArr2 = pointFArrRemoveZeroLengthSegments;
                i2 = length;
            } else {
                i2 = length;
                i3 = i8;
                int iComputeParamsPolygon = computeParamsPolygon(d6, d7, dCos, d8, dHypot, dArr);
                if (iComputeParamsPolygon < 0) {
                    if (!cloudyBorder2.outputStarted) {
                        cloudyBorder2.moveTo(pointF);
                    }
                    d2 = d8;
                    pointFArr2 = pointFArrRemoveZeroLengthSegments;
                } else {
                    double d11 = dArr[0];
                    double d12 = dArr[1];
                    double dAtan22 = Math.atan2(pointF2.y - pointF.y, pointF2.x - pointF.x);
                    if (i7 == 0) {
                        PointF pointF3 = pointFArrRemoveZeroLengthSegments[i6];
                        dAtan2 = Math.atan2(pointF.y - pointF3.y, pointF.x - pointF3.x);
                    } else {
                        dAtan2 = d10;
                    }
                    double dCosine = cosine(pointF2.x - pointF.x, dHypot);
                    double dSine = sine(pointF2.y - pointF.y, dHypot);
                    float f2 = pointF.x;
                    float f3 = pointF.y;
                    pointFArr2 = pointFArrRemoveZeroLengthSegments;
                    addCornerCurl(dAtan2, dAtan22, d8, f2, f3, d11, d9, !cloudyBorder2.outputStarted);
                    double d13 = d6 + (d12 * 2.0d);
                    double d14 = ((double) f2) + (d13 * dCosine);
                    double d15 = ((double) f3) + (d13 * dSine);
                    if (iComputeParamsPolygon >= 1) {
                        addFirstIntermediateCurl(dAtan22, d8, d11, d14, d15);
                        d14 += d6 * dCosine;
                        d15 += d6 * dSine;
                        cloudyBorder = this;
                        d2 = d8;
                        i4 = iComputeParamsPolygon - 1;
                    } else {
                        cloudyBorder = this;
                        d2 = d8;
                        i4 = iComputeParamsPolygon;
                    }
                    double d16 = dAtan22;
                    PointF[] intermediateCurlTemplate = cloudyBorder.getIntermediateCurlTemplate(d16, d2);
                    int i9 = 0;
                    while (i9 < i4) {
                        outputCurlTemplate(intermediateCurlTemplate, d14, d15);
                        d14 += d6 * dCosine;
                        d15 += d6 * dSine;
                        i9++;
                        d16 = d16;
                    }
                    double d17 = d16;
                    d3 = iComputeParamsPolygon == 0 ? d11 : ANGLE_34_DEG;
                    d10 = d17;
                    d9 = d3;
                    cloudyBorder2 = cloudyBorder;
                    d8 = d2;
                    pointFArrRemoveZeroLengthSegments = pointFArr2;
                    length = i2;
                    i7 = i3;
                }
            }
            cloudyBorder = cloudyBorder2;
            d3 = d9;
            d9 = d3;
            cloudyBorder2 = cloudyBorder;
            d8 = d2;
            pointFArrRemoveZeroLengthSegments = pointFArr2;
            length = i2;
            i7 = i3;
        }
    }

    private void cloudyRectangleImpl(double d2, double d3, double d4, double d5, boolean z) throws IOException {
        boolean z2;
        PointF[] pointFArr;
        double d6 = d4 - d2;
        double d7 = d5 - d3;
        if (this.intensity <= 0.0d) {
            this.output.addRect((float) d2, (float) d3, (float) d6, (float) d7);
            this.bboxMinX = d2;
            this.bboxMinY = d3;
            this.bboxMaxX = d4;
            this.bboxMaxY = d5;
            return;
        }
        if (d6 < 1.0d) {
            float f2 = (float) d2;
            float f3 = (float) d3;
            pointFArr = new PointF[]{new PointF(f2, f3), new PointF(f2, (float) d5), new PointF(f2, f3)};
            z2 = z;
        } else if (d7 < 1.0d) {
            float f4 = (float) d2;
            float f5 = (float) d3;
            PointF[] pointFArr2 = {new PointF(f4, f5), new PointF((float) d4, f5), new PointF(f4, f5)};
            z2 = z;
            pointFArr = pointFArr2;
        } else {
            float f6 = (float) d2;
            float f7 = (float) d3;
            float f8 = (float) d4;
            float f9 = (float) d5;
            PointF[] pointFArr3 = {new PointF(f6, f7), new PointF(f8, f7), new PointF(f8, f9), new PointF(f6, f9), new PointF(f6, f7)};
            z2 = z;
            pointFArr = pointFArr3;
        }
        cloudyPolygonImpl(pointFArr, z2);
    }

    private double computeParamsEllipse(PointF pointF, PointF pointF2, double d2, double d3) {
        double dHypot = Math.hypot(pointF2.x - pointF.x, pointF2.y - pointF.y);
        if (Double.compare(dHypot, 0.0d) == 0) {
            return ANGLE_34_DEG;
        }
        double d4 = ((d3 / 2.0d) + ((dHypot - d3) / 2.0d)) / d2;
        if (d4 < -1.0d || d4 > 1.0d) {
            return 0.0d;
        }
        return Math.acos(d4);
    }

    private int computeParamsPolygon(double d2, double d3, double d4, double d5, double d6, double[] dArr) {
        double dAcos = 0.0d;
        if (Double.compare(d6, 0.0d) == 0) {
            dArr[0] = ANGLE_34_DEG;
            dArr[1] = 0.0d;
            return -1;
        }
        double d7 = d3 * 2.0d;
        int iCeil = (int) Math.ceil((d6 - d7) / d2);
        double d8 = (d6 - (d7 + (((double) iCeil) * d2))) / 2.0d;
        double d9 = ((d4 * d5) + d8) / d5;
        if (d9 >= -1.0d && d9 <= 1.0d) {
            dAcos = Math.acos(d9);
        }
        dArr[0] = dAcos;
        dArr[1] = d8;
        return iCeil;
    }

    private static double cosine(double d2, double d3) {
        if (Double.compare(d3, 0.0d) == 0) {
            return 0.0d;
        }
        return d2 / d3;
    }

    private void curveTo(double d2, double d3, double d4, double d5, double d6, double d7) throws IOException {
        updateBBox(d2, d3);
        updateBBox(d4, d5);
        updateBBox(d6, d7);
        this.output.curveTo((float) d2, (float) d3, (float) d4, (float) d5, (float) d6, (float) d7);
    }

    private void drawBasicEllipse(double d2, double d3, double d4, double d5) throws IOException {
        getArc(0.0d, 6.283185307179586d, Math.abs(d4 - d2) / 2.0d, Math.abs(d5 - d3) / 2.0d, (d2 + d4) / 2.0d, (d3 + d5) / 2.0d, null, true);
    }

    private void finish() throws IOException {
        if (this.outputStarted) {
            this.output.closePath();
        }
        double d2 = this.lineWidth;
        if (d2 > 0.0d) {
            double d3 = d2 / 2.0d;
            this.bboxMinX -= d3;
            this.bboxMinY -= d3;
            this.bboxMaxX += d3;
            this.bboxMaxY += d3;
        }
    }

    private static PointF[] flattenEllipse(double d2, double d3, double d4, double d5) {
        return new PointF[0];
    }

    private void getArc(double d2, double d3, double d4, double d5, double d6, double d7, ArrayList<PointF> arrayList, boolean z) throws IOException {
        double dCos = (Math.cos(d2) * d4) + d6;
        double dSin = (Math.sin(d2) * d5) + d7;
        double d8 = d3 - d2;
        while (d8 < 0.0d) {
            d8 += 6.283185307179586d;
        }
        if (z) {
            if (arrayList != null) {
                arrayList.add(new PointF((float) dCos, (float) dSin));
            } else {
                moveTo(dCos, dSin);
            }
        }
        double d9 = d8;
        double d10 = 0.0d;
        while (d9 > ANGLE_90_DEG) {
            double d11 = d2 + d10;
            getArcSegment(d11, d11 + ANGLE_90_DEG, d6, d7, d4, d5, arrayList, false);
            d10 += ANGLE_90_DEG;
            d9 -= ANGLE_90_DEG;
        }
        if (d9 > 0.0d) {
            getArcSegment(d2 + d10, d2 + d8, d6, d7, d4, d5, arrayList, false);
        }
    }

    private void getArcSegment(double d2, double d3, double d4, double d5, double d6, double d7, ArrayList<PointF> arrayList, boolean z) throws IOException {
        double d8;
        double dCos = Math.cos(d2);
        double dSin = Math.sin(d2);
        double dCos2 = Math.cos(d3);
        double dSin2 = Math.sin(d3);
        double d9 = (d3 - d2) / 2.0d;
        double dSin3 = Math.sin(d9);
        if (Double.compare(dSin3, 0.0d) == 0) {
            if (z) {
                double d10 = d4 + (dCos * d6);
                double d11 = d5 + (dSin * d7);
                if (arrayList != null) {
                    arrayList.add(new PointF((float) d10, (float) d11));
                    return;
                } else {
                    moveTo(d10, d11);
                    return;
                }
            }
            return;
        }
        double dCos3 = ((1.0d - Math.cos(d9)) * 1.333333333d) / dSin3;
        double d12 = d4 + ((dCos - (dCos3 * dSin)) * d6);
        double d13 = d5 + (((dCos3 * dCos) + dSin) * d7);
        double d14 = d4 + (((dCos3 * dSin2) + dCos2) * d6);
        double d15 = d5 + ((dSin2 - (dCos3 * dCos2)) * d7);
        double d16 = d4 + (dCos2 * d6);
        double d17 = d5 + (dSin2 * d7);
        if (z) {
            double d18 = d4 + (dCos * d6);
            double d19 = d5 + (dSin * d7);
            if (arrayList != null) {
                d8 = d17;
                arrayList.add(new PointF((float) d18, (float) d19));
            } else {
                d8 = d17;
                moveTo(d18, d19);
            }
        } else {
            d8 = d17;
        }
        if (arrayList == null) {
            curveTo(d12, d13, d14, d15, d16, d8);
            return;
        }
        arrayList.add(new PointF((float) d12, (float) d13));
        arrayList.add(new PointF((float) d14, (float) d15));
        arrayList.add(new PointF((float) d16, (float) d8));
    }

    private double getEllipseCloudRadius() {
        return (this.intensity * 4.75d) + (this.lineWidth * 0.5d);
    }

    private PointF[] getIntermediateCurlTemplate(double d2, double d3) throws IOException {
        ArrayList<PointF> arrayList = new ArrayList<>();
        double d4 = d2 + ANGLE_180_DEG;
        double d5 = ANGLE_34_DEG;
        double d6 = ANGLE_12_DEG;
        getArcSegment(d4 + d5, d4 + d6, 0.0d, 0.0d, d3, d3, arrayList, false);
        double d7 = d4 + d6;
        double d8 = d4 + ANGLE_90_DEG;
        getArcSegment(d7, d8, 0.0d, 0.0d, d3, d3, arrayList, false);
        getArcSegment(d8, (d4 + ANGLE_180_DEG) - d5, 0.0d, 0.0d, d3, d3, arrayList, false);
        return (PointF[]) arrayList.toArray(new PointF[arrayList.size()]);
    }

    private double getPolygonCloudRadius() {
        return (this.intensity * 4.0d) + (this.lineWidth * 0.5d);
    }

    private double getPolygonDirection(PointF[] pointFArr) {
        int length = pointFArr.length;
        double d2 = 0.0d;
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int i4 = i3 % length;
            d2 += (double) ((pointFArr[i2].x * pointFArr[i4].y) - (pointFArr[i2].y * pointFArr[i4].x));
            i2 = i3;
        }
        return d2;
    }

    private void getPositivePolygon(PointF[] pointFArr) {
        if (getPolygonDirection(pointFArr) < 0.0d) {
            reversePolygon(pointFArr);
        }
    }

    private void lineTo(PointF pointF) throws IOException {
        lineTo(pointF.x, pointF.y);
    }

    private void moveTo(PointF pointF) throws IOException {
        moveTo(pointF.x, pointF.y);
    }

    private void outputCurlTemplate(PointF[] pointFArr, double d2, double d3) throws IOException {
        int length = pointFArr.length;
        int i2 = 0;
        if (length % 3 == 1) {
            PointF pointF = pointFArr[0];
            moveTo(((double) pointF.x) + d2, ((double) pointF.y) + d3);
            i2 = 1;
            while (true) {
                int i3 = i2 + 2;
                if (i3 >= length) {
                    return;
                }
                PointF pointF2 = pointFArr[i2];
                PointF pointF3 = pointFArr[i2 + 1];
                PointF pointF4 = pointFArr[i3];
                curveTo(((double) pointF2.x) + d2, ((double) pointF2.y) + d3, ((double) pointF3.x) + d2, ((double) pointF3.y) + d3, ((double) pointF4.x) + d2, ((double) pointF4.y) + d3);
                i2 += 3;
            }
        }
    }

    private PointF[] removeZeroLengthSegments(PointF[] pointFArr) {
        int length = pointFArr.length;
        if (length <= 2) {
            return pointFArr;
        }
        PointF pointF = pointFArr[0];
        int i2 = 1;
        int i3 = length;
        while (i2 < length) {
            PointF pointF2 = pointFArr[i2];
            if (Math.abs(pointF2.x - pointF.x) < 0.5d && Math.abs(pointF2.y - pointF.y) < 0.5d) {
                pointFArr[i2] = null;
                i3--;
            }
            i2++;
            pointF = pointF2;
        }
        if (i3 == length) {
            return pointFArr;
        }
        PointF[] pointFArr2 = new PointF[i3];
        int i4 = 0;
        for (PointF pointF3 : pointFArr) {
            if (pointF3 != null) {
                pointFArr2[i4] = pointF3;
                i4++;
            }
        }
        return pointFArr2;
    }

    private void reversePolygon(PointF[] pointFArr) {
        int length = pointFArr.length;
        int i2 = length / 2;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (length - i3) - 1;
            PointF pointF = pointFArr[i3];
            pointFArr[i3] = pointFArr[i4];
            pointFArr[i4] = pointF;
        }
    }

    private static double sine(double d2, double d3) {
        if (Double.compare(d3, 0.0d) == 0) {
            return 0.0d;
        }
        return d2 / d3;
    }

    private void updateBBox(double d2, double d3) {
        this.bboxMinX = Math.min(this.bboxMinX, d2);
        this.bboxMinY = Math.min(this.bboxMinY, d3);
        this.bboxMaxX = Math.max(this.bboxMaxX, d2);
        this.bboxMaxY = Math.max(this.bboxMaxY, d3);
    }

    public void createCloudyEllipse(PDRectangle pDRectangle) throws IOException {
        this.rectWithDiff = applyRectDiff(pDRectangle, 0.0d);
        cloudyEllipseImpl(r10.getLowerLeftX(), this.rectWithDiff.getLowerLeftY(), this.rectWithDiff.getUpperRightX(), this.rectWithDiff.getUpperRightY());
        finish();
    }

    public void createCloudyPolygon(float[][] fArr) throws IOException {
        int length = fArr.length;
        PointF[] pointFArr = new PointF[length];
        for (int i2 = 0; i2 < length; i2++) {
            float[] fArr2 = fArr[i2];
            if (fArr2.length == 2) {
                pointFArr[i2] = new PointF(fArr2[0], fArr2[1]);
            } else if (fArr2.length == 6) {
                pointFArr[i2] = new PointF(fArr2[4], fArr2[5]);
            }
        }
        cloudyPolygonImpl(pointFArr, false);
        finish();
    }

    public void createCloudyRectangle(PDRectangle pDRectangle) throws IOException {
        this.rectWithDiff = applyRectDiff(pDRectangle, this.lineWidth / 2.0d);
        cloudyRectangleImpl(r11.getLowerLeftX(), this.rectWithDiff.getLowerLeftY(), this.rectWithDiff.getUpperRightX(), this.rectWithDiff.getUpperRightY(), false);
        finish();
    }

    public PDRectangle getBBox() {
        return getRectangle();
    }

    public AffineTransform getMatrix() {
        return AffineTransform.getTranslateInstance(-this.bboxMinX, -this.bboxMinY);
    }

    public PDRectangle getRectDifference() {
        PDRectangle pDRectangle = this.annotRect;
        if (pDRectangle == null) {
            float f2 = ((float) this.lineWidth) / 2.0f;
            double d2 = this.lineWidth;
            return new PDRectangle(f2, f2, (float) d2, (float) d2);
        }
        PDRectangle pDRectangle2 = this.rectWithDiff;
        if (pDRectangle2 != null) {
            pDRectangle = pDRectangle2;
        }
        float lowerLeftX = pDRectangle.getLowerLeftX() - ((float) this.bboxMinX);
        float lowerLeftY = pDRectangle.getLowerLeftY() - ((float) this.bboxMinY);
        return new PDRectangle(lowerLeftX, lowerLeftY, (((float) this.bboxMaxX) - pDRectangle.getUpperRightX()) - lowerLeftX, (((float) this.bboxMaxY) - pDRectangle.getUpperRightY()) - lowerLeftY);
    }

    public PDRectangle getRectangle() {
        double d2 = this.bboxMinX;
        double d3 = this.bboxMinY;
        return new PDRectangle((float) d2, (float) d3, (float) (this.bboxMaxX - d2), (float) (this.bboxMaxY - d3));
    }

    private void lineTo(double d2, double d3) throws IOException {
        if (this.outputStarted) {
            updateBBox(d2, d3);
        } else {
            beginOutput(d2, d3);
        }
        this.output.lineTo((float) d2, (float) d3);
    }

    private void moveTo(double d2, double d3) throws IOException {
        if (this.outputStarted) {
            updateBBox(d2, d3);
        } else {
            beginOutput(d2, d3);
        }
        this.output.moveTo((float) d2, (float) d3);
    }
}
