package com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers;

import android.util.Log;
import com.tom_roush.pdfbox.io.IOUtils;
import com.tom_roush.pdfbox.pdmodel.PDAppearanceContentStream;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.font.PDType1Font;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationLine;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.IOException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class PDLineAppearanceHandler extends PDAbstractAppearanceHandler {
    public static final int FONT_SIZE = 9;

    public PDLineAppearanceHandler(PDAnnotation pDAnnotation) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r31v1 */
    /* JADX WARN: Type inference failed for: r31v2 */
    /* JADX WARN: Type inference failed for: r31v4 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v20 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v22 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateNormalAppearance() {
        ?? r31;
        double d2;
        boolean z;
        ?? r9;
        double d3;
        String str;
        float stringWidth;
        ?? r92;
        float f2;
        String str2 = "None";
        PDAnnotationLine pDAnnotationLine = (PDAnnotationLine) getAnnotation();
        PDRectangle rectangle = pDAnnotationLine.getRectangle();
        float[] line = pDAnnotationLine.getLine();
        if (line == null) {
            return;
        }
        AnnotationBorder annotationBorder = AnnotationBorder.getAnnotationBorder(pDAnnotationLine, pDAnnotationLine.getBorderStyle());
        PDColor color = pDAnnotationLine.getColor();
        if (color == null || color.getComponents().length == 0) {
            return;
        }
        float leaderLineLength = pDAnnotationLine.getLeaderLineLength();
        float leaderLineExtensionLength = pDAnnotationLine.getLeaderLineExtensionLength();
        float leaderLineOffsetLength = pDAnnotationLine.getLeaderLineOffsetLength();
        float fMax = Float.MIN_VALUE;
        float fMax2 = Float.MIN_VALUE;
        float fMin = Float.MAX_VALUE;
        float fMin2 = Float.MAX_VALUE;
        int i2 = 0;
        while (i2 < line.length / 2) {
            int i3 = i2 * 2;
            String str3 = str2;
            float f3 = line[i3];
            float f4 = line[i3 + 1];
            fMin = Math.min(fMin, f3);
            fMin2 = Math.min(fMin2, f4);
            fMax = Math.max(fMax, f3);
            fMax2 = Math.max(fMax2, f4);
            i2++;
            str2 = str3;
        }
        String str4 = str2;
        if (leaderLineLength < 0.0f) {
            leaderLineOffsetLength = -leaderLineOffsetLength;
            leaderLineExtensionLength = -leaderLineExtensionLength;
        }
        float f5 = annotationBorder.width;
        if (f5 < 1.0E-5d) {
            f5 = 1.0f;
        }
        float f6 = 10.0f * f5;
        float f7 = leaderLineOffsetLength + leaderLineLength;
        float f8 = leaderLineExtensionLength + f7;
        rectangle.setLowerLeftX(Math.min(fMin - Math.max(f6, Math.abs(f8)), rectangle.getLowerLeftX()));
        rectangle.setLowerLeftY(Math.min(fMin2 - Math.max(f6, Math.abs(f8)), rectangle.getLowerLeftY()));
        rectangle.setUpperRightX(Math.max(fMax + Math.max(f6, Math.abs(f8)), rectangle.getUpperRightX()));
        rectangle.setUpperRightY(Math.max(fMax2 + Math.max(f6, Math.abs(f8)), rectangle.getUpperRightY()));
        pDAnnotationLine.setRectangle(rectangle);
        PDAppearanceContentStream normalAppearanceAsContentStream = null;
        try {
            try {
                normalAppearanceAsContentStream = getNormalAppearanceAsContentStream();
                setOpacity(normalAppearanceAsContentStream, pDAnnotationLine.getConstantOpacity());
                boolean strokingColorOnDemand = normalAppearanceAsContentStream.setStrokingColorOnDemand(color);
                float[] fArr = annotationBorder.dashArray;
                if (fArr != null) {
                    normalAppearanceAsContentStream.setLineDashPattern(fArr, 0.0f);
                }
                normalAppearanceAsContentStream.setLineWidth(annotationBorder.width);
                float f9 = line[0];
                float f10 = line[1];
                float f11 = line[2];
                float f12 = line[3];
                String contents = pDAnnotationLine.getContents();
                if (contents == null) {
                    contents = "";
                }
                normalAppearanceAsContentStream.saveGraphicsState();
                r31 = f5;
                double dAtan2 = Math.atan2(f12 - f10, f11 - f9);
                normalAppearanceAsContentStream.transform(Matrix.getRotateInstance(dAtan2, f9, f10));
                float fSqrt = (float) Math.sqrt((r7 * r7) + (r14 * r14));
                normalAppearanceAsContentStream.moveTo(0.0f, leaderLineOffsetLength);
                normalAppearanceAsContentStream.lineTo(0.0f, f8);
                normalAppearanceAsContentStream.moveTo(fSqrt, leaderLineOffsetLength);
                normalAppearanceAsContentStream.lineTo(fSqrt, f8);
                try {
                    if (!pDAnnotationLine.getCaption() || contents.isEmpty()) {
                        d2 = dAtan2;
                        ?? r93 = r31;
                        Set<String> set = PDAbstractAppearanceHandler.SHORT_STYLES;
                        if (set.contains(pDAnnotationLine.getStartPointEndingStyle())) {
                            normalAppearanceAsContentStream.moveTo(r93 == true ? 1.0f : 0.0f, f7);
                        } else {
                            normalAppearanceAsContentStream.moveTo(0.0f, f7);
                        }
                        if (set.contains(pDAnnotationLine.getEndPointEndingStyle())) {
                            normalAppearanceAsContentStream.lineTo(fSqrt - (r93 == true ? 1.0f : 0.0f), f7);
                        } else {
                            normalAppearanceAsContentStream.lineTo(fSqrt, f7);
                        }
                        z = false;
                        normalAppearanceAsContentStream.drawShape(r93 == true ? 1.0f : 0.0f, strokingColorOnDemand, false);
                        r9 = r93;
                    } else {
                        PDType1Font pDType1Font = PDType1Font.HELVETICA;
                        try {
                            stringWidth = (pDType1Font.getStringWidth(pDAnnotationLine.getContents()) / 1000.0f) * 9.0f;
                            str = "PdfBox-Android";
                        } catch (IllegalArgumentException e2) {
                            str = "PdfBox-Android";
                            try {
                                Log.e(str, "line text '" + pDAnnotationLine.getContents() + "' can't be shown", e2);
                                stringWidth = 0.0f;
                            } catch (IOException e3) {
                                e = e3;
                                r31 = str;
                                Log.e(r31, e.getMessage(), e);
                            }
                        }
                        float f13 = (fSqrt - stringWidth) / 2.0f;
                        String captionPositioning = pDAnnotationLine.getCaptionPositioning();
                        Set<String> set2 = PDAbstractAppearanceHandler.SHORT_STYLES;
                        if (set2.contains(pDAnnotationLine.getStartPointEndingStyle())) {
                            ?? r94 = r31;
                            normalAppearanceAsContentStream.moveTo(r94 == true ? 1.0f : 0.0f, f7);
                            r92 = r94;
                        } else {
                            r92 = r31;
                            normalAppearanceAsContentStream.moveTo(0.0f, f7);
                        }
                        if ("Top".equals(captionPositioning)) {
                            f2 = 1.908f;
                        } else {
                            f2 = -2.6f;
                            normalAppearanceAsContentStream.lineTo(f13 - (r92 == true ? 1.0f : 0.0f), f7);
                            normalAppearanceAsContentStream.moveTo((fSqrt - f13) + (r92 == true ? 1.0f : 0.0f), f7);
                        }
                        if (set2.contains(pDAnnotationLine.getEndPointEndingStyle())) {
                            normalAppearanceAsContentStream.lineTo(fSqrt - (r92 == true ? 1.0f : 0.0f), f7);
                        } else {
                            normalAppearanceAsContentStream.lineTo(fSqrt, f7);
                        }
                        normalAppearanceAsContentStream.drawShape(r92 == true ? 1.0f : 0.0f, strokingColorOnDemand, false);
                        float captionHorizontalOffset = pDAnnotationLine.getCaptionHorizontalOffset();
                        float captionVerticalOffset = pDAnnotationLine.getCaptionVerticalOffset();
                        if (stringWidth > 0.0f) {
                            normalAppearanceAsContentStream.beginText();
                            d2 = dAtan2;
                            normalAppearanceAsContentStream.setFont(pDType1Font, 9.0f);
                            normalAppearanceAsContentStream.newLineAtOffset(f13 + captionHorizontalOffset, f2 + f7 + captionVerticalOffset);
                            normalAppearanceAsContentStream.showText(pDAnnotationLine.getContents());
                            normalAppearanceAsContentStream.endText();
                        } else {
                            d2 = dAtan2;
                        }
                        if (Float.compare(captionVerticalOffset, 0.0f) != 0) {
                            float f14 = (fSqrt / 2.0f) + 0.0f;
                            normalAppearanceAsContentStream.moveTo(f14, f7);
                            normalAppearanceAsContentStream.lineTo(f14, captionVerticalOffset + f7);
                            normalAppearanceAsContentStream.drawShape(r92 == true ? 1.0f : 0.0f, strokingColorOnDemand, false);
                        }
                        z = false;
                        r9 = r92;
                    }
                    normalAppearanceAsContentStream.restoreGraphicsState();
                    boolean nonStrokingColorOnDemand = normalAppearanceAsContentStream.setNonStrokingColorOnDemand(pDAnnotationLine.getInteriorColor());
                    if (annotationBorder.width >= 1.0E-5d) {
                        z = strokingColorOnDemand;
                    }
                    if (str4.equals(pDAnnotationLine.getStartPointEndingStyle())) {
                        d3 = d2;
                    } else {
                        normalAppearanceAsContentStream.saveGraphicsState();
                        if (PDAbstractAppearanceHandler.ANGLED_STYLES.contains(pDAnnotationLine.getStartPointEndingStyle())) {
                            d3 = d2;
                            normalAppearanceAsContentStream.transform(Matrix.getRotateInstance(d3, f9, f10));
                            drawStyle(pDAnnotationLine.getStartPointEndingStyle(), normalAppearanceAsContentStream, 0.0f, f7, r9 == true ? 1.0f : 0.0f, z, nonStrokingColorOnDemand, false);
                        } else {
                            d3 = d2;
                            double d4 = f7;
                            drawStyle(pDAnnotationLine.getStartPointEndingStyle(), normalAppearanceAsContentStream, f9 - ((float) (Math.sin(d3) * d4)), f10 + ((float) (d4 * Math.cos(d3))), r9 == true ? 1.0f : 0.0f, z, nonStrokingColorOnDemand, false);
                        }
                        normalAppearanceAsContentStream.restoreGraphicsState();
                    }
                    if (!str4.equals(pDAnnotationLine.getEndPointEndingStyle())) {
                        if (PDAbstractAppearanceHandler.ANGLED_STYLES.contains(pDAnnotationLine.getEndPointEndingStyle())) {
                            normalAppearanceAsContentStream.transform(Matrix.getRotateInstance(d3, f11, f12));
                            drawStyle(pDAnnotationLine.getEndPointEndingStyle(), normalAppearanceAsContentStream, 0.0f, f7, r9 == true ? 1.0f : 0.0f, z, nonStrokingColorOnDemand, true);
                        } else {
                            double d5 = f7;
                            drawStyle(pDAnnotationLine.getEndPointEndingStyle(), normalAppearanceAsContentStream, f11 - ((float) (Math.sin(d3) * d5)), f12 + ((float) (d5 * Math.cos(d3))), r9 == true ? 1.0f : 0.0f, z, nonStrokingColorOnDemand, true);
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                }
            } finally {
                IOUtils.closeQuietly(null);
            }
        } catch (IOException e5) {
            e = e5;
            r31 = "PdfBox-Android";
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateRolloverAppearance() {
    }

    public PDLineAppearanceHandler(PDAnnotation pDAnnotation, PDDocument pDDocument) {
        super(pDAnnotation, pDDocument);
    }
}
