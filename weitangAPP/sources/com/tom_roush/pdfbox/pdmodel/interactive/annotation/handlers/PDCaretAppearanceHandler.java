package com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDAppearanceContentStream;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class PDCaretAppearanceHandler extends PDAbstractAppearanceHandler {
    public PDCaretAppearanceHandler(PDAnnotation pDAnnotation) {
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
        PDAnnotationMarkup pDAnnotationMarkup = (PDAnnotationMarkup) getAnnotation();
        PDAppearanceContentStream normalAppearanceAsContentStream = null;
        try {
            try {
                normalAppearanceAsContentStream = getNormalAppearanceAsContentStream();
                normalAppearanceAsContentStream.setStrokingColor(getColor());
                normalAppearanceAsContentStream.setNonStrokingColor(getColor());
                setOpacity(normalAppearanceAsContentStream, pDAnnotationMarkup.getConstantOpacity());
                PDRectangle rectangle = getRectangle();
                PDRectangle pDRectangle = new PDRectangle(rectangle.getWidth(), rectangle.getHeight());
                if (!pDAnnotationMarkup.getCOSObject().containsKey(COSName.RD)) {
                    float fMin = Math.min(rectangle.getHeight() / 10.0f, 5.0f);
                    pDAnnotationMarkup.setRectDifferences(fMin);
                    float f2 = -fMin;
                    float f3 = fMin * 2.0f;
                    PDRectangle pDRectangle2 = new PDRectangle(f2, f2, rectangle.getWidth() + f3, rectangle.getHeight() + f3);
                    Matrix matrix = pDAnnotationMarkup.getNormalAppearanceStream().getMatrix();
                    matrix.transformPoint(fMin, fMin);
                    pDAnnotationMarkup.getNormalAppearanceStream().setMatrix(matrix.createAffineTransform());
                    pDAnnotationMarkup.setRectangle(new PDRectangle(rectangle.getLowerLeftX() - fMin, rectangle.getLowerLeftY() - fMin, rectangle.getWidth() + f3, rectangle.getHeight() + f3));
                    pDRectangle = pDRectangle2;
                }
                pDAnnotationMarkup.getNormalAppearanceStream().setBBox(pDRectangle);
                float width = rectangle.getWidth() / 2.0f;
                float height = rectangle.getHeight() / 2.0f;
                normalAppearanceAsContentStream.moveTo(0.0f, 0.0f);
                normalAppearanceAsContentStream.curveTo(width, 0.0f, width, height, width, rectangle.getHeight());
                normalAppearanceAsContentStream.curveTo(width, height, width, 0.0f, rectangle.getWidth(), 0.0f);
                normalAppearanceAsContentStream.closePath();
                normalAppearanceAsContentStream.fill();
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

    public PDCaretAppearanceHandler(PDAnnotation pDAnnotation, PDDocument pDDocument) {
        super(pDAnnotation, pDDocument);
    }
}
