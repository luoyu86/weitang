package com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers;

import android.util.Log;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDAppearanceContentStream;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.PDFormContentStream;
import com.tom_roush.pdfbox.pdmodel.PDPatternContentStream;
import com.tom_roush.pdfbox.pdmodel.PDResources;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.graphics.form.PDFormXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationTextMarkup;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PDSquigglyAppearanceHandler extends PDAbstractAppearanceHandler {
    public PDSquigglyAppearanceHandler(PDAnnotation pDAnnotation) {
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
        int i2;
        PDAppearanceContentStream pDAppearanceContentStream;
        PDAppearanceContentStream normalAppearanceAsContentStream;
        PDFormContentStream pDFormContentStream;
        PDFormContentStream pDFormContentStream2;
        PDPatternContentStream pDPatternContentStream;
        PDPatternContentStream pDPatternContentStream2;
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
        int i3 = 0;
        float fMax = Float.MIN_VALUE;
        float fMax2 = Float.MIN_VALUE;
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        int i4 = 0;
        while (true) {
            i2 = 2;
            if (i4 >= quadPoints.length / 2) {
                break;
            }
            int i5 = i4 * 2;
            float f2 = quadPoints[i5];
            float f3 = quadPoints[i5 + 1];
            fMin = Math.min(fMin, f2);
            fMin2 = Math.min(fMin2, f3);
            fMax = Math.max(fMax, f2);
            fMax2 = Math.max(fMax2, f3);
            i4++;
        }
        rectangle.setLowerLeftX(Math.min(fMin - (annotationBorder.width / 2.0f), rectangle.getLowerLeftX()));
        rectangle.setLowerLeftY(Math.min(fMin2 - (annotationBorder.width / 2.0f), rectangle.getLowerLeftY()));
        rectangle.setUpperRightX(Math.max(fMax + (annotationBorder.width / 2.0f), rectangle.getUpperRightX()));
        rectangle.setUpperRightY(Math.max(fMax2 + (annotationBorder.width / 2.0f), rectangle.getUpperRightY()));
        pDAnnotationTextMarkup.setRectangle(rectangle);
        try {
            normalAppearanceAsContentStream = getNormalAppearanceAsContentStream();
            try {
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e3) {
            e = e3;
            pDAppearanceContentStream = null;
        } catch (Throwable th2) {
            th = th2;
            pDAppearanceContentStream = null;
        }
        try {
            setOpacity(normalAppearanceAsContentStream, pDAnnotationTextMarkup.getConstantOpacity());
            normalAppearanceAsContentStream.setStrokingColor(color);
            while (i3 < quadPoints.length / 8) {
                int i6 = i3 * 8;
                int i7 = i6 + 5;
                float f4 = quadPoints[i6 + 1] - quadPoints[i7];
                float f5 = f4 / 40.0f;
                normalAppearanceAsContentStream.transform(new Matrix(f5, 0.0f, 0.0f, f5 / 1.8f, quadPoints[i6 + 4], quadPoints[i7]));
                PDFormXObject pDFormXObject = new PDFormXObject(createCOSStream());
                int i8 = i6 + 2;
                pDFormXObject.setBBox(new PDRectangle(-0.5f, -0.5f, (((quadPoints[i8] - quadPoints[i6]) / f4) * 40.0f) + 0.5f, 13.0f));
                pDFormXObject.setResources(new PDResources());
                pDFormXObject.setMatrix(AffineTransform.getTranslateInstance(0.5d, 0.5d));
                normalAppearanceAsContentStream.drawForm(pDFormXObject);
                try {
                    pDFormContentStream2 = new PDFormContentStream(pDFormXObject);
                } catch (Throwable th3) {
                    th = th3;
                    pDFormContentStream = null;
                }
                try {
                    PDTilingPattern pDTilingPattern = new PDTilingPattern();
                    pDTilingPattern.setBBox(new PDRectangle(0.0f, 0.0f, 10.0f, 12.0f));
                    pDTilingPattern.setXStep(10.0f);
                    pDTilingPattern.setYStep(13.0f);
                    pDTilingPattern.setTilingType(3);
                    pDTilingPattern.setPaintType(i2);
                    try {
                        pDPatternContentStream2 = new PDPatternContentStream(pDTilingPattern);
                    } catch (Throwable th4) {
                        th = th4;
                        pDPatternContentStream = null;
                    }
                    try {
                        pDPatternContentStream2.setLineCapStyle(1);
                        pDPatternContentStream2.setLineJoinStyle(1);
                        pDPatternContentStream2.setLineWidth(1.0f);
                        pDPatternContentStream2.setMiterLimit(10.0f);
                        pDPatternContentStream2.moveTo(0.0f, 1.0f);
                        pDPatternContentStream2.lineTo(5.0f, 11.0f);
                        pDPatternContentStream2.lineTo(10.0f, 1.0f);
                        pDPatternContentStream2.stroke();
                        IOUtils.closeQuietly(pDPatternContentStream2);
                        pDFormXObject.getResources().add(pDTilingPattern);
                        pDFormContentStream2.addRect(0.0f, 0.0f, ((quadPoints[i8] - quadPoints[i6]) / f4) * 40.0f, 12.0f);
                        pDFormContentStream2.fill();
                        IOUtils.closeQuietly(pDFormContentStream2);
                        i3++;
                        i2 = 2;
                    } catch (Throwable th5) {
                        th = th5;
                        pDPatternContentStream = pDPatternContentStream2;
                        IOUtils.closeQuietly(pDPatternContentStream);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    pDFormContentStream = pDFormContentStream2;
                    IOUtils.closeQuietly(pDFormContentStream);
                    throw th;
                }
            }
            IOUtils.closeQuietly(normalAppearanceAsContentStream);
        } catch (IOException e4) {
            e = e4;
            pDAppearanceContentStream = normalAppearanceAsContentStream;
            try {
                Log.e("PdfBox-Android", e.getMessage(), e);
                IOUtils.closeQuietly(pDAppearanceContentStream);
            } catch (Throwable th7) {
                th = th7;
                IOUtils.closeQuietly(pDAppearanceContentStream);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            pDAppearanceContentStream = normalAppearanceAsContentStream;
            IOUtils.closeQuietly(pDAppearanceContentStream);
            throw th;
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateRolloverAppearance() {
    }

    public PDSquigglyAppearanceHandler(PDAnnotation pDAnnotation, PDDocument pDDocument) {
        super(pDAnnotation, pDDocument);
    }
}
