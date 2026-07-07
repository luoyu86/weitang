package com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDAppearanceContentStream;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PDPolylineAppearanceHandler extends PDAbstractAppearanceHandler {
    public PDPolylineAppearanceHandler(PDAnnotation pDAnnotation) {
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
        String str;
        PDAnnotationMarkup pDAnnotationMarkup;
        boolean z;
        boolean z2;
        String str2 = "None";
        PDAnnotationMarkup pDAnnotationMarkup2 = (PDAnnotationMarkup) getAnnotation();
        PDRectangle rectangle = pDAnnotationMarkup2.getRectangle();
        float[] vertices = pDAnnotationMarkup2.getVertices();
        if (vertices == null || vertices.length < 4) {
            return;
        }
        AnnotationBorder annotationBorder = AnnotationBorder.getAnnotationBorder(pDAnnotationMarkup2, pDAnnotationMarkup2.getBorderStyle());
        PDColor color = pDAnnotationMarkup2.getColor();
        if (color == null || color.getComponents().length == 0 || Float.compare(annotationBorder.width, 0.0f) == 0) {
            return;
        }
        float fMax = Float.MIN_VALUE;
        float fMax2 = Float.MIN_VALUE;
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        for (int i2 = 0; i2 < vertices.length / 2; i2++) {
            int i3 = i2 * 2;
            float f2 = vertices[i3];
            float f3 = vertices[i3 + 1];
            fMin = Math.min(fMin, f2);
            fMin2 = Math.min(fMin2, f3);
            fMax = Math.max(fMax, f2);
            fMax2 = Math.max(fMax2, f3);
        }
        rectangle.setLowerLeftX(Math.min(fMin - (annotationBorder.width * 10.0f), rectangle.getLowerLeftX()));
        rectangle.setLowerLeftY(Math.min(fMin2 - (annotationBorder.width * 10.0f), rectangle.getLowerLeftY()));
        rectangle.setUpperRightX(Math.max(fMax + (annotationBorder.width * 10.0f), rectangle.getUpperRightX()));
        rectangle.setUpperRightY(Math.max(fMax2 + (annotationBorder.width * 10.0f), rectangle.getUpperRightY()));
        pDAnnotationMarkup2.setRectangle(rectangle);
        PDAppearanceContentStream normalAppearanceAsContentStream = null;
        try {
            try {
                normalAppearanceAsContentStream = getNormalAppearanceAsContentStream();
                boolean nonStrokingColorOnDemand = normalAppearanceAsContentStream.setNonStrokingColorOnDemand(pDAnnotationMarkup2.getInteriorColor());
                setOpacity(normalAppearanceAsContentStream, pDAnnotationMarkup2.getConstantOpacity());
                boolean strokingColorOnDemand = normalAppearanceAsContentStream.setStrokingColorOnDemand(color);
                float[] fArr = annotationBorder.dashArray;
                if (fArr != null) {
                    normalAppearanceAsContentStream.setLineDashPattern(fArr, 0.0f);
                }
                normalAppearanceAsContentStream.setLineWidth(annotationBorder.width);
                int i4 = 0;
                while (i4 < vertices.length / 2) {
                    int i5 = i4 * 2;
                    float f4 = vertices[i5];
                    float f5 = vertices[i5 + 1];
                    if (i4 == 0) {
                        if (PDAbstractAppearanceHandler.SHORT_STYLES.contains(pDAnnotationMarkup2.getStartPointEndingStyle())) {
                            float f6 = vertices[2];
                            float f7 = vertices[3];
                            z = strokingColorOnDemand;
                            z2 = nonStrokingColorOnDemand;
                            str = str2;
                            pDAnnotationMarkup = pDAnnotationMarkup2;
                            float fSqrt = (float) Math.sqrt(Math.pow(f4 - f6, 2.0d) + Math.pow(f5 - f7, 2.0d));
                            if (Float.compare(fSqrt, 0.0f) != 0) {
                                float f8 = annotationBorder.width;
                                f4 += ((f6 - f4) / fSqrt) * f8;
                                f5 += ((f7 - f5) / fSqrt) * f8;
                            }
                        } else {
                            str = str2;
                            pDAnnotationMarkup = pDAnnotationMarkup2;
                            z = strokingColorOnDemand;
                            z2 = nonStrokingColorOnDemand;
                        }
                        normalAppearanceAsContentStream.moveTo(f4, f5);
                    } else {
                        str = str2;
                        pDAnnotationMarkup = pDAnnotationMarkup2;
                        z = strokingColorOnDemand;
                        z2 = nonStrokingColorOnDemand;
                        if (i4 == (vertices.length / 2) - 1 && PDAbstractAppearanceHandler.SHORT_STYLES.contains(pDAnnotationMarkup.getEndPointEndingStyle())) {
                            float f9 = vertices[vertices.length - 4];
                            float f10 = vertices[vertices.length - 3];
                            float fSqrt2 = (float) Math.sqrt(Math.pow(f9 - f4, 2.0d) + Math.pow(f10 - f5, 2.0d));
                            if (Float.compare(fSqrt2, 0.0f) != 0) {
                                float f11 = annotationBorder.width;
                                f4 -= ((f4 - f9) / fSqrt2) * f11;
                                f5 -= ((f5 - f10) / fSqrt2) * f11;
                            }
                        }
                        normalAppearanceAsContentStream.lineTo(f4, f5);
                    }
                    i4++;
                    nonStrokingColorOnDemand = z2;
                    strokingColorOnDemand = z;
                    str2 = str;
                    pDAnnotationMarkup2 = pDAnnotationMarkup;
                }
                String str3 = str2;
                PDAnnotationMarkup pDAnnotationMarkup3 = pDAnnotationMarkup2;
                boolean z3 = strokingColorOnDemand;
                boolean z4 = nonStrokingColorOnDemand;
                normalAppearanceAsContentStream.stroke();
                if (!str3.equals(pDAnnotationMarkup3.getStartPointEndingStyle())) {
                    float f12 = vertices[2];
                    float f13 = vertices[3];
                    float f14 = vertices[0];
                    float f15 = vertices[1];
                    normalAppearanceAsContentStream.saveGraphicsState();
                    if (PDAbstractAppearanceHandler.ANGLED_STYLES.contains(pDAnnotationMarkup3.getStartPointEndingStyle())) {
                        normalAppearanceAsContentStream.transform(Matrix.getRotateInstance(Math.atan2(f13 - f15, f12 - f14), f14, f15));
                    } else {
                        normalAppearanceAsContentStream.transform(Matrix.getTranslateInstance(f14, f15));
                    }
                    drawStyle(pDAnnotationMarkup3.getStartPointEndingStyle(), normalAppearanceAsContentStream, 0.0f, 0.0f, annotationBorder.width, z3, z4, false);
                    normalAppearanceAsContentStream.restoreGraphicsState();
                }
                if (!str3.equals(pDAnnotationMarkup3.getEndPointEndingStyle())) {
                    float f16 = vertices[vertices.length - 4];
                    float f17 = vertices[vertices.length - 3];
                    float f18 = vertices[vertices.length - 2];
                    float f19 = vertices[vertices.length - 1];
                    if (PDAbstractAppearanceHandler.ANGLED_STYLES.contains(pDAnnotationMarkup3.getEndPointEndingStyle())) {
                        normalAppearanceAsContentStream.transform(Matrix.getRotateInstance(Math.atan2(f19 - f17, f18 - f16), f18, f19));
                    } else {
                        normalAppearanceAsContentStream.transform(Matrix.getTranslateInstance(f18, f19));
                    }
                    drawStyle(pDAnnotationMarkup3.getEndPointEndingStyle(), normalAppearanceAsContentStream, 0.0f, 0.0f, annotationBorder.width, z3, z4, true);
                }
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

    public float getLineWidth() {
        PDAnnotationMarkup pDAnnotationMarkup = (PDAnnotationMarkup) getAnnotation();
        PDBorderStyleDictionary borderStyle = pDAnnotationMarkup.getBorderStyle();
        if (borderStyle != null) {
            return borderStyle.getWidth();
        }
        COSArray border = pDAnnotationMarkup.getBorder();
        if (border.size() < 3) {
            return 1.0f;
        }
        COSBase object = border.getObject(2);
        if (object instanceof COSNumber) {
            return ((COSNumber) object).floatValue();
        }
        return 1.0f;
    }

    public PDPolylineAppearanceHandler(PDAnnotation pDAnnotation, PDDocument pDDocument) {
        super(pDAnnotation, pDDocument);
    }
}
