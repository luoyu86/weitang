package com.tom_roush.pdfbox.pdmodel;

import com.tom_roush.harmony.awt.AWTColor;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import com.tom_roush.pdfbox.pdmodel.font.PDFont;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.graphics.form.PDFormXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.image.PDImageXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.image.PDInlineImage;
import com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShading;
import com.tom_roush.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import com.tom_roush.pdfbox.pdmodel.graphics.state.RenderingMode;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class PDAppearanceContentStream extends PDAbstractContentStream implements Closeable {
    public PDAppearanceContentStream(PDAppearanceStream pDAppearanceStream) throws IOException {
        this(pDAppearanceStream, pDAppearanceStream.getStream().createOutputStream());
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

    public void drawShape(float f2, boolean z, boolean z2) throws IOException {
        if (f2 < 1.0E-6d) {
            z = false;
        }
        if (z2 && z) {
            fillAndStroke();
            return;
        }
        if (z) {
            stroke();
        } else if (z2) {
            fill();
        } else {
            writeOperator(OperatorName.ENDPATH);
        }
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

    public void setBorderLine(float f2, PDBorderStyleDictionary pDBorderStyleDictionary, COSArray cOSArray) throws IOException {
        if (pDBorderStyleDictionary != null && pDBorderStyleDictionary.getCOSObject().containsKey(COSName.D) && pDBorderStyleDictionary.getStyle().equals("D")) {
            setLineDashPattern(pDBorderStyleDictionary.getDashStyle().getDashArray(), 0.0f);
        } else if (pDBorderStyleDictionary == null && cOSArray.size() > 3) {
            if (cOSArray.getObject(3) instanceof COSArray) {
                setLineDashPattern(((COSArray) cOSArray.getObject(3)).toFloatArray(), 0.0f);
            } else {
                setLineDashPattern(new float[1], 0.0f);
            }
        }
        setLineWidthOnDemand(f2);
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

    public void setLineWidthOnDemand(float f2) throws IOException {
        if (Math.abs(f2 - 1.0f) >= 1.0E-6d) {
            setLineWidth(f2);
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setMiterLimit(float f2) throws IOException {
        super.setMiterLimit(f2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setNonStrokingColor(float f2) throws IOException {
        super.setNonStrokingColor(f2);
    }

    public boolean setNonStrokingColorOnDemand(PDColor pDColor) throws IOException {
        if (pDColor == null) {
            return false;
        }
        float[] components = pDColor.getComponents();
        if (components.length <= 0) {
            return false;
        }
        setNonStrokingColor(components);
        return true;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setRenderingMode(RenderingMode renderingMode) throws IOException {
        super.setRenderingMode(renderingMode);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setStrokingColor(float f2) throws IOException {
        super.setStrokingColor(f2);
    }

    public boolean setStrokingColorOnDemand(PDColor pDColor) throws IOException {
        if (pDColor == null) {
            return false;
        }
        float[] components = pDColor.getComponents();
        if (components.length <= 0) {
            return false;
        }
        setStrokingColor(components);
        return true;
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

    public PDAppearanceContentStream(PDAppearanceStream pDAppearanceStream, boolean z) throws IOException {
        this(pDAppearanceStream, pDAppearanceStream.getStream().createOutputStream(z ? COSName.FLATE_DECODE : null));
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

    public PDAppearanceContentStream(PDAppearanceStream pDAppearanceStream, OutputStream outputStream) {
        super(null, outputStream, pDAppearanceStream.getResources());
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

    public void setStrokingColor(float[] fArr) throws IOException {
        for (float f2 : fArr) {
            writeOperand(f2);
        }
        int length = fArr.length;
        if (length == 1) {
            writeOperator(OperatorName.STROKING_COLOR_GRAY);
        } else if (length != 3) {
            if (length != 4) {
                return;
            }
            writeOperator(OperatorName.STROKING_COLOR_CMYK);
        } else {
            writeOperator(OperatorName.STROKING_COLOR_RGB);
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.PDAbstractContentStream
    public /* bridge */ /* synthetic */ void setNonStrokingColor(PDColor pDColor) throws IOException {
        super.setNonStrokingColor(pDColor);
    }

    public void setNonStrokingColor(float[] fArr) throws IOException {
        for (float f2 : fArr) {
            writeOperand(f2);
        }
        int length = fArr.length;
        if (length == 1) {
            writeOperator(OperatorName.NON_STROKING_GRAY);
        } else if (length != 3) {
            if (length != 4) {
                return;
            }
            writeOperator(OperatorName.NON_STROKING_CMYK);
        } else {
            writeOperator(OperatorName.NON_STROKING_RGB);
        }
    }
}
