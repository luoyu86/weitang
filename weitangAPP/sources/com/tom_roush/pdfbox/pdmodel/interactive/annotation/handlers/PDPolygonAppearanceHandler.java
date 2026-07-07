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
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDBorderEffectDictionary;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import java.io.IOException;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes2.dex */
public class PDPolygonAppearanceHandler extends PDAbstractAppearanceHandler {
    public PDPolygonAppearanceHandler(PDAnnotation pDAnnotation) {
        super(pDAnnotation);
    }

    private float[][] getPathArray(PDAnnotationMarkup pDAnnotationMarkup) {
        float[][] path = pDAnnotationMarkup.getPath();
        if (path != null) {
            return path;
        }
        float[] vertices = pDAnnotationMarkup.getVertices();
        if (vertices == null) {
            return null;
        }
        int length = vertices.length / 2;
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) float.class, length, 2);
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            fArr[i2][0] = vertices[i3];
            fArr[i2][1] = vertices[i3 + 1];
        }
        return fArr;
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
        float lineWidth = getLineWidth();
        PDRectangle rectangle = pDAnnotationMarkup.getRectangle();
        float[][] pathArray = getPathArray(pDAnnotationMarkup);
        if (pathArray == null) {
            return;
        }
        float fMax = Float.MIN_VALUE;
        float fMax2 = Float.MIN_VALUE;
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        for (int i2 = 0; i2 < pathArray.length; i2++) {
            for (int i3 = 0; i3 < pathArray[i2].length / 2; i3++) {
                int i4 = i3 * 2;
                float f2 = pathArray[i2][i4];
                float f3 = pathArray[i2][i4 + 1];
                fMin = Math.min(fMin, f2);
                fMin2 = Math.min(fMin2, f3);
                fMax = Math.max(fMax, f2);
                fMax2 = Math.max(fMax2, f3);
            }
        }
        rectangle.setLowerLeftX(Math.min(fMin - lineWidth, rectangle.getLowerLeftX()));
        rectangle.setLowerLeftY(Math.min(fMin2 - lineWidth, rectangle.getLowerLeftY()));
        rectangle.setUpperRightX(Math.max(fMax + lineWidth, rectangle.getUpperRightX()));
        rectangle.setUpperRightY(Math.max(fMax2 + lineWidth, rectangle.getUpperRightY()));
        pDAnnotationMarkup.setRectangle(rectangle);
        PDAppearanceContentStream normalAppearanceAsContentStream = null;
        try {
            try {
                normalAppearanceAsContentStream = getNormalAppearanceAsContentStream();
                boolean strokingColorOnDemand = normalAppearanceAsContentStream.setStrokingColorOnDemand(getColor());
                boolean nonStrokingColorOnDemand = normalAppearanceAsContentStream.setNonStrokingColorOnDemand(pDAnnotationMarkup.getInteriorColor());
                setOpacity(normalAppearanceAsContentStream, pDAnnotationMarkup.getConstantOpacity());
                normalAppearanceAsContentStream.setBorderLine(lineWidth, pDAnnotationMarkup.getBorderStyle(), pDAnnotationMarkup.getBorder());
                PDBorderEffectDictionary borderEffect = pDAnnotationMarkup.getBorderEffect();
                if (borderEffect == null || !borderEffect.getStyle().equals("C")) {
                    for (int i5 = 0; i5 < pathArray.length; i5++) {
                        float[] fArr = pathArray[i5];
                        if (i5 == 0 && fArr.length == 2) {
                            normalAppearanceAsContentStream.moveTo(fArr[0], fArr[1]);
                        } else if (fArr.length == 2) {
                            normalAppearanceAsContentStream.lineTo(fArr[0], fArr[1]);
                        } else if (fArr.length == 6) {
                            normalAppearanceAsContentStream.curveTo(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5]);
                        }
                    }
                    normalAppearanceAsContentStream.closePath();
                } else {
                    CloudyBorder cloudyBorder = new CloudyBorder(normalAppearanceAsContentStream, borderEffect.getIntensity(), lineWidth, getRectangle());
                    cloudyBorder.createCloudyPolygon(pathArray);
                    pDAnnotationMarkup.setRectangle(cloudyBorder.getRectangle());
                    PDAppearanceStream normalAppearanceStream = pDAnnotationMarkup.getNormalAppearanceStream();
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

    public PDPolygonAppearanceHandler(PDAnnotation pDAnnotation, PDDocument pDDocument) {
        super(pDAnnotation, pDDocument);
    }
}
