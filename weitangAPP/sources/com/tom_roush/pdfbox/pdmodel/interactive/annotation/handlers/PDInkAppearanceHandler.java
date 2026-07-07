package com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers;

import android.util.Log;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDAppearanceContentStream;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PDInkAppearanceHandler extends PDAbstractAppearanceHandler {
    public PDInkAppearanceHandler(PDAnnotation pDAnnotation) {
        super(pDAnnotation);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateAppearanceStreams() throws Throwable {
        generateNormalAppearance();
        generateRolloverAppearance();
        generateDownAppearance();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateDownAppearance() {
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateNormalAppearance() throws Throwable {
        PDAnnotationMarkup pDAnnotationMarkup = (PDAnnotationMarkup) getAnnotation();
        PDColor color = pDAnnotationMarkup.getColor();
        if (color == null || color.getComponents().length == 0) {
            return;
        }
        AnnotationBorder annotationBorder = AnnotationBorder.getAnnotationBorder(pDAnnotationMarkup, pDAnnotationMarkup.getBorderStyle());
        if (Float.compare(annotationBorder.width, 0.0f) == 0) {
            return;
        }
        float fMax = Float.MIN_VALUE;
        float fMax2 = Float.MIN_VALUE;
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        for (float[] fArr : pDAnnotationMarkup.getInkList()) {
            int length = fArr.length / 2;
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                float f2 = fArr[i3];
                float f3 = fArr[i3 + 1];
                fMin = Math.min(fMin, f2);
                fMin2 = Math.min(fMin2, f3);
                fMax = Math.max(fMax, f2);
                fMax2 = Math.max(fMax2, f3);
            }
        }
        PDRectangle rectangle = pDAnnotationMarkup.getRectangle();
        rectangle.setLowerLeftX(Math.min(fMin - (annotationBorder.width * 2.0f), rectangle.getLowerLeftX()));
        rectangle.setLowerLeftY(Math.min(fMin2 - (annotationBorder.width * 2.0f), rectangle.getLowerLeftY()));
        rectangle.setUpperRightX(Math.max(fMax + (annotationBorder.width * 2.0f), rectangle.getUpperRightX()));
        rectangle.setUpperRightY(Math.max(fMax2 + (annotationBorder.width * 2.0f), rectangle.getUpperRightY()));
        pDAnnotationMarkup.setRectangle(rectangle);
        PDAppearanceContentStream normalAppearanceAsContentStream = null;
        try {
            try {
                normalAppearanceAsContentStream = getNormalAppearanceAsContentStream();
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th) {
                th = th;
                IOUtils.closeQuietly(normalAppearanceAsContentStream);
                throw th;
            }
            try {
                setOpacity(normalAppearanceAsContentStream, pDAnnotationMarkup.getConstantOpacity());
                normalAppearanceAsContentStream.setStrokingColor(color);
                float[] fArr2 = annotationBorder.dashArray;
                if (fArr2 != null) {
                    normalAppearanceAsContentStream.setLineDashPattern(fArr2, 0.0f);
                }
                normalAppearanceAsContentStream.setLineWidth(annotationBorder.width);
                for (float[] fArr3 : pDAnnotationMarkup.getInkList()) {
                    int length2 = fArr3.length / 2;
                    for (int i4 = 0; i4 < length2; i4++) {
                        int i5 = i4 * 2;
                        float f4 = fArr3[i5];
                        float f5 = fArr3[i5 + 1];
                        if (i4 == 0) {
                            normalAppearanceAsContentStream.moveTo(f4, f5);
                        } else {
                            normalAppearanceAsContentStream.lineTo(f4, f5);
                        }
                    }
                    normalAppearanceAsContentStream.stroke();
                }
            } catch (IOException e3) {
                e = e3;
                Log.e("PdfBox-Android", e.getMessage(), e);
            }
            IOUtils.closeQuietly(normalAppearanceAsContentStream);
        } catch (Throwable th2) {
            th = th2;
            IOUtils.closeQuietly(normalAppearanceAsContentStream);
            throw th;
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateRolloverAppearance() {
    }

    public PDInkAppearanceHandler(PDAnnotation pDAnnotation, PDDocument pDDocument) {
        super(pDAnnotation, pDDocument);
    }
}
