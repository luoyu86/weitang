package com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDAppearanceContentStream;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationSquareCircle;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDBorderEffectDictionary;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PDCircleAppearanceHandler extends PDAbstractAppearanceHandler {
    public PDCircleAppearanceHandler(PDAnnotation pDAnnotation) {
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
        float lineWidth = getLineWidth();
        PDAnnotationSquareCircle pDAnnotationSquareCircle = (PDAnnotationSquareCircle) getAnnotation();
        PDAppearanceContentStream normalAppearanceAsContentStream = null;
        try {
            try {
                normalAppearanceAsContentStream = getNormalAppearanceAsContentStream();
                boolean strokingColorOnDemand = normalAppearanceAsContentStream.setStrokingColorOnDemand(getColor());
                boolean nonStrokingColorOnDemand = normalAppearanceAsContentStream.setNonStrokingColorOnDemand(pDAnnotationSquareCircle.getInteriorColor());
                setOpacity(normalAppearanceAsContentStream, pDAnnotationSquareCircle.getConstantOpacity());
                normalAppearanceAsContentStream.setBorderLine(lineWidth, pDAnnotationSquareCircle.getBorderStyle(), pDAnnotationSquareCircle.getBorder());
                PDBorderEffectDictionary borderEffect = pDAnnotationSquareCircle.getBorderEffect();
                if (borderEffect == null || !borderEffect.getStyle().equals("C")) {
                    PDRectangle pDRectangleHandleBorderBox = handleBorderBox(pDAnnotationSquareCircle, lineWidth);
                    float lowerLeftX = pDRectangleHandleBorderBox.getLowerLeftX();
                    float lowerLeftY = pDRectangleHandleBorderBox.getLowerLeftY();
                    float upperRightX = pDRectangleHandleBorderBox.getUpperRightX();
                    float upperRightY = pDRectangleHandleBorderBox.getUpperRightY();
                    float width = lowerLeftX + (pDRectangleHandleBorderBox.getWidth() / 2.0f);
                    float height = lowerLeftY + (pDRectangleHandleBorderBox.getHeight() / 2.0f);
                    float height2 = (pDRectangleHandleBorderBox.getHeight() / 2.0f) * 0.55555415f;
                    float width2 = (pDRectangleHandleBorderBox.getWidth() / 2.0f) * 0.55555415f;
                    normalAppearanceAsContentStream.moveTo(width, upperRightY);
                    float f2 = width + width2;
                    float f3 = height + height2;
                    normalAppearanceAsContentStream.curveTo(f2, upperRightY, upperRightX, f3, upperRightX, height);
                    float f4 = height - height2;
                    normalAppearanceAsContentStream.curveTo(upperRightX, f4, f2, lowerLeftY, width, lowerLeftY);
                    float f5 = width - width2;
                    normalAppearanceAsContentStream.curveTo(f5, lowerLeftY, lowerLeftX, f4, lowerLeftX, height);
                    normalAppearanceAsContentStream.curveTo(lowerLeftX, f3, f5, upperRightY, width, upperRightY);
                    normalAppearanceAsContentStream.closePath();
                } else {
                    CloudyBorder cloudyBorder = new CloudyBorder(normalAppearanceAsContentStream, borderEffect.getIntensity(), lineWidth, getRectangle());
                    cloudyBorder.createCloudyEllipse(pDAnnotationSquareCircle.getRectDifference());
                    pDAnnotationSquareCircle.setRectangle(cloudyBorder.getRectangle());
                    pDAnnotationSquareCircle.setRectDifference(cloudyBorder.getRectDifference());
                    PDAppearanceStream normalAppearanceStream = pDAnnotationSquareCircle.getNormalAppearanceStream();
                    normalAppearanceStream.setBBox(cloudyBorder.getBBox());
                    normalAppearanceStream.setMatrix(cloudyBorder.getMatrix());
                }
                normalAppearanceAsContentStream.drawShape(lineWidth, strokingColorOnDemand, nonStrokingColorOnDemand);
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

    public PDCircleAppearanceHandler(PDAnnotation pDAnnotation, PDDocument pDDocument) {
        super(pDAnnotation, pDDocument);
    }
}
