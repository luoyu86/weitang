package com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers;

import android.util.Log;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDAppearanceContentStream;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PDStrikeoutAppearanceHandler extends PDAbstractAppearanceHandler {
    public PDStrikeoutAppearanceHandler(PDAnnotation pDAnnotation) {
        super(pDAnnotation);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateAppearanceStreams() {
        generateNormalAppearance();
        generateRolloverAppearance();
        generateDownAppearance();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateDownAppearance() {
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateNormalAppearance() {
        PDAnnotationTextMarkup pDAnnotationTextMarkup = (PDAnnotationTextMarkup) getAnnotation();
        PDRectangle rectangle = pDAnnotationTextMarkup.getRectangle();
        float[] quadPoints = pDAnnotationTextMarkup.getQuadPoints();
        if (quadPoints == null) {
            return;
        }
        AnnotationBorder annotationBorder = AnnotationBorder.getAnnotationBorder(pDAnnotationTextMarkup, pDAnnotationTextMarkup.getBorderStyle());
        PDColor color = pDAnnotationTextMarkup.getColor();
        if (color == null || color.getComponents().length == 0) {
            return;
        }
        if (Float.compare(annotationBorder.width, 0.0f) == 0) {
            annotationBorder.width = 1.5f;
        }
        int i2 = 0;
        float fMax = Float.MIN_VALUE;
        float fMax2 = Float.MIN_VALUE;
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        for (int i3 = 0; i3 < quadPoints.length / 2; i3++) {
            int i4 = i3 * 2;
            float f2 = quadPoints[i4];
            float f3 = quadPoints[i4 + 1];
            fMin = Math.min(fMin, f2);
            fMin2 = Math.min(fMin2, f3);
            fMax = Math.max(fMax, f2);
            fMax2 = Math.max(fMax2, f3);
        }
        rectangle.setLowerLeftX(Math.min(fMin - (annotationBorder.width / 2.0f), rectangle.getLowerLeftX()));
        rectangle.setLowerLeftY(Math.min(fMin2 - (annotationBorder.width / 2.0f), rectangle.getLowerLeftY()));
        rectangle.setUpperRightX(Math.max(fMax + (annotationBorder.width / 2.0f), rectangle.getUpperRightX()));
        rectangle.setUpperRightY(Math.max(fMax2 + (annotationBorder.width / 2.0f), rectangle.getUpperRightY()));
        pDAnnotationTextMarkup.setRectangle(rectangle);
        PDAppearanceContentStream normalAppearanceAsContentStream = null;
        try {
            try {
                normalAppearanceAsContentStream = getNormalAppearanceAsContentStream();
                setOpacity(normalAppearanceAsContentStream, pDAnnotationTextMarkup.getConstantOpacity());
                normalAppearanceAsContentStream.setStrokingColor(color);
                float[] fArr = annotationBorder.dashArray;
                if (fArr != null) {
                    normalAppearanceAsContentStream.setLineDashPattern(fArr, 0.0f);
                }
                normalAppearanceAsContentStream.setLineWidth(annotationBorder.width);
                while (i2 < quadPoints.length / 8) {
                    int i5 = i2 * 8;
                    int i6 = i5 + 4;
                    int i7 = i5 + 1;
                    int i8 = i5 + 5;
                    float fSqrt = (float) Math.sqrt(Math.pow(quadPoints[i5] - quadPoints[i6], 2.0d) + Math.pow(quadPoints[i7] - quadPoints[i8], 2.0d));
                    float f4 = quadPoints[i6];
                    float f5 = quadPoints[i8];
                    if (Float.compare(fSqrt, 0.0f) != 0) {
                        float f6 = (quadPoints[i5] - quadPoints[i6]) / fSqrt;
                        float f7 = fSqrt / 2.0f;
                        float f8 = annotationBorder.width;
                        f4 += f6 * (f7 - f8);
                        f5 += ((quadPoints[i7] - quadPoints[i8]) / fSqrt) * (f7 - f8);
                    }
                    int i9 = i5 + 2;
                    int i10 = i5 + 6;
                    int i11 = i5 + 3;
                    int i12 = i5 + 7;
                    int i13 = i2;
                    float fSqrt2 = (float) Math.sqrt(Math.pow(quadPoints[i9] - quadPoints[i10], 2.0d) + Math.pow(quadPoints[i11] - quadPoints[i12], 2.0d));
                    float f9 = quadPoints[i10];
                    float f10 = quadPoints[i12];
                    if (Float.compare(fSqrt2, 0.0f) != 0) {
                        float f11 = (quadPoints[i9] - quadPoints[i10]) / fSqrt2;
                        float f12 = fSqrt2 / 2.0f;
                        float f13 = annotationBorder.width;
                        f9 += f11 * (f12 - f13);
                        f10 += ((quadPoints[i11] - quadPoints[i12]) / fSqrt2) * (f12 - f13);
                    }
                    normalAppearanceAsContentStream.moveTo(f4, f5);
                    normalAppearanceAsContentStream.lineTo(f9, f10);
                    i2 = i13 + 1;
                }
                normalAppearanceAsContentStream.stroke();
            } catch (IOException e2) {
                Log.e("PdfBox-Android", e2.getMessage(), e2);
            }
        } finally {
            IOUtils.closeQuietly(normalAppearanceAsContentStream);
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateRolloverAppearance() {
    }

    public PDStrikeoutAppearanceHandler(PDAnnotation pDAnnotation, PDDocument pDDocument) {
        super(pDAnnotation, pDDocument);
    }
}
