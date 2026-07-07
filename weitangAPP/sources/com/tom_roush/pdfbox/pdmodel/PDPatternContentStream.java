package com.tom_roush.pdfbox.pdmodel;

import com.tom_roush.harmony.awt.AWTColor;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import com.tom_roush.pdfbox.pdmodel.font.PDFont;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.graphics.form.PDFormXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.image.PDImageXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.image.PDInlineImage;
import com.tom_roush.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShading;
import com.tom_roush.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import com.tom_roush.pdfbox.pdmodel.graphics.state.RenderingMode;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class PDPatternContentStream extends PDAbstractContentStream {
    public PDPatternContentStream(PDTilingPattern pDTilingPattern) throws IOException {
        super(null, pDTilingPattern.getContentStream().createOutputStream(), pDTilingPattern.getResources());
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void addComment(String str) throws IOException {
        super.addComment(str);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void addRect(float f2, float f3, float f4, float f5) throws IOException {
        super.addRect(f2, f3, f4, f5);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void beginMarkedContent(COSName cOSName) throws IOException {
        super.beginMarkedContent(cOSName);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void beginText() throws IOException {
        super.beginText();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void clip() throws IOException {
        super.clip();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void clipEvenOdd() throws IOException {
        super.clipEvenOdd();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void closeAndFillAndStroke() throws IOException {
        super.closeAndFillAndStroke();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void closeAndFillAndStrokeEvenOdd() throws IOException {
        super.closeAndFillAndStrokeEvenOdd();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void closeAndStroke() throws IOException {
        super.closeAndStroke();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void closePath() throws IOException {
        super.closePath();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void curveTo(float f2, float f3, float f4, float f5, float f6, float f7) throws IOException {
        super.curveTo(f2, f3, f4, f5, f6, f7);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void curveTo1(float f2, float f3, float f4, float f5) throws IOException {
        super.curveTo1(f2, f3, f4, f5);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void curveTo2(float f2, float f3, float f4, float f5) throws IOException {
        super.curveTo2(f2, f3, f4, f5);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void drawForm(PDFormXObject pDFormXObject) throws IOException {
        super.drawForm(pDFormXObject);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void drawImage(PDImageXObject pDImageXObject, float f2, float f3) throws IOException {
        super.drawImage(pDImageXObject, f2, f3);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void endMarkedContent() throws IOException {
        super.endMarkedContent();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void endText() throws IOException {
        super.endText();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void fill() throws IOException {
        super.fill();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void fillAndStroke() throws IOException {
        super.fillAndStroke();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void fillAndStrokeEvenOdd() throws IOException {
        super.fillAndStrokeEvenOdd();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void fillEvenOdd() throws IOException {
        super.fillEvenOdd();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void lineTo(float f2, float f3) throws IOException {
        super.lineTo(f2, f3);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void moveTo(float f2, float f3) throws IOException {
        super.moveTo(f2, f3);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void newLine() throws IOException {
        super.newLine();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void newLineAtOffset(float f2, float f3) throws IOException {
        super.newLineAtOffset(f2, f3);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void restoreGraphicsState() throws IOException {
        super.restoreGraphicsState();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void saveGraphicsState() throws IOException {
        super.saveGraphicsState();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setCharacterSpacing(float f2) throws IOException {
        super.setCharacterSpacing(f2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setFont(PDFont pDFont, float f2) throws IOException {
        super.setFont(pDFont, f2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setGraphicsStateParameters(PDExtendedGraphicsState pDExtendedGraphicsState) throws IOException {
        super.setGraphicsStateParameters(pDExtendedGraphicsState);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setHorizontalScaling(float f2) throws IOException {
        super.setHorizontalScaling(f2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setLeading(float f2) throws IOException {
        super.setLeading(f2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setLineCapStyle(int i2) throws IOException {
        super.setLineCapStyle(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setLineDashPattern(float[] fArr, float f2) throws IOException {
        super.setLineDashPattern(fArr, f2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setLineJoinStyle(int i2) throws IOException {
        super.setLineJoinStyle(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setLineWidth(float f2) throws IOException {
        super.setLineWidth(f2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setMiterLimit(float f2) throws IOException {
        super.setMiterLimit(f2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setNonStrokingColor(float f2) throws IOException {
        super.setNonStrokingColor(f2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setRenderingMode(RenderingMode renderingMode) throws IOException {
        super.setRenderingMode(renderingMode);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setStrokingColor(float f2) throws IOException {
        super.setStrokingColor(f2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setTextMatrix(Matrix matrix) throws IOException {
        super.setTextMatrix(matrix);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setTextRise(float f2) throws IOException {
        super.setTextRise(f2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setWordSpacing(float f2) throws IOException {
        super.setWordSpacing(f2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void shadingFill(PDShading pDShading) throws IOException {
        super.shadingFill(pDShading);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void showText(String str) throws IOException {
        super.showText(str);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void showTextWithPositioning(Object[] objArr) throws IOException {
        super.showTextWithPositioning(objArr);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void stroke() throws IOException {
        super.stroke();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void transform(Matrix matrix) throws IOException {
        super.transform(matrix);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void beginMarkedContent(COSName cOSName, PDPropertyList pDPropertyList) throws IOException {
        super.beginMarkedContent(cOSName, pDPropertyList);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void drawImage(PDImageXObject pDImageXObject, float f2, float f3, float f4, float f5) throws IOException {
        super.drawImage(pDImageXObject, f2, f3, f4, f5);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setNonStrokingColor(float f2, float f3, float f4) throws IOException {
        super.setNonStrokingColor(f2, f3, f4);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setStrokingColor(float f2, float f3, float f4) throws IOException {
        super.setStrokingColor(f2, f3, f4);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void drawImage(PDImageXObject pDImageXObject, Matrix matrix) throws IOException {
        super.drawImage(pDImageXObject, matrix);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setNonStrokingColor(float f2, float f3, float f4, float f5) throws IOException {
        super.setNonStrokingColor(f2, f3, f4, f5);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setStrokingColor(float f2, float f3, float f4, float f5) throws IOException {
        super.setStrokingColor(f2, f3, f4, f5);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void drawImage(PDInlineImage pDInlineImage, float f2, float f3) throws IOException {
        super.drawImage(pDInlineImage, f2, f3);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setNonStrokingColor(int i2) throws IOException {
        super.setNonStrokingColor(i2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    @Deprecated
    public /* bridge */ /* synthetic */ void setStrokingColor(int i2, int i3, int i4) throws IOException {
        super.setStrokingColor(i2, i3, i4);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void drawImage(PDInlineImage pDInlineImage, float f2, float f3, float f4, float f5) throws IOException {
        super.drawImage(pDInlineImage, f2, f3, f4, f5);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    @Deprecated
    public /* bridge */ /* synthetic */ void setNonStrokingColor(int i2, int i3, int i4) throws IOException {
        super.setNonStrokingColor(i2, i3, i4);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setStrokingColor(AWTColor aWTColor) throws IOException {
        super.setStrokingColor(aWTColor);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setNonStrokingColor(int i2, int i3, int i4, int i5) throws IOException {
        super.setNonStrokingColor(i2, i3, i4, i5);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setStrokingColor(PDColor pDColor) throws IOException {
        super.setStrokingColor(pDColor);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setNonStrokingColor(AWTColor aWTColor) throws IOException {
        super.setNonStrokingColor(aWTColor);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setNonStrokingColor(PDColor pDColor) throws IOException {
        super.setNonStrokingColor(pDColor);
    }
}
