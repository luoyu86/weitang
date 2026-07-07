package com.tom_roush.pdfbox.pdmodel;

import android.graphics.Path;
import android.util.Log;
import com.tom_roush.harmony.awt.AWTColor;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.pdfwriter.COSWriter;
import com.tom_roush.pdfbox.pdmodel.common.PDStream;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import com.tom_roush.pdfbox.pdmodel.font.PDFont;
import com.tom_roush.pdfbox.pdmodel.graphics.PDXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import com.tom_roush.pdfbox.pdmodel.graphics.form.PDFormXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.image.PDImageXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.image.PDInlineImage;
import com.tom_roush.pdfbox.pdmodel.graphics.pattern.PDTilingPattern;
import com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShading;
import com.tom_roush.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import com.tom_roush.pdfbox.pdmodel.graphics.state.RenderingMode;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import com.tom_roush.pdfbox.util.Charsets;
import com.tom_roush.pdfbox.util.Matrix;
import com.tom_roush.pdfbox.util.NumberFormatUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Locale;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
public final class PDPageContentStream implements Closeable {
    private final PDDocument document;
    private final Stack<PDFont> fontStack;
    private final byte[] formatBuffer;
    private final NumberFormat formatDecimal;
    private boolean inTextMode;
    private final Stack<PDColorSpace> nonStrokingColorSpaceStack;
    private OutputStream output;
    private PDResources resources;
    private boolean sourcePageHadContents;
    private final Stack<PDColorSpace> strokingColorSpaceStack;

    public enum AppendMode {
        OVERWRITE,
        APPEND,
        PREPEND;

        public boolean isOverwrite() {
            return this == OVERWRITE;
        }

        public boolean isPrepend() {
            return this == PREPEND;
        }
    }

    public PDPageContentStream(PDDocument pDDocument, PDPage pDPage) throws IOException {
        this(pDDocument, pDPage, AppendMode.OVERWRITE, true, false);
        if (this.sourcePageHadContents) {
            Log.w("PdfBox-Android", "You are overwriting an existing content, you should use the append mode");
        }
    }

    private COSName getName(PDColorSpace pDColorSpace) throws IOException {
        return ((pDColorSpace instanceof PDDeviceGray) || (pDColorSpace instanceof PDDeviceRGB)) ? COSName.getPDFName(pDColorSpace.getName()) : this.resources.add(pDColorSpace);
    }

    private boolean isOutside255Interval(int i2) {
        return i2 < 0 || i2 > 255;
    }

    private boolean isOutsideOneInterval(double d2) {
        return d2 < 0.0d || d2 > 1.0d;
    }

    private void setNonStrokingColorSpaceStack(PDColorSpace pDColorSpace) {
        if (this.nonStrokingColorSpaceStack.isEmpty()) {
            this.nonStrokingColorSpaceStack.add(pDColorSpace);
        } else {
            this.nonStrokingColorSpaceStack.setElementAt(pDColorSpace, r0.size() - 1);
        }
    }

    private void setStrokingColorSpaceStack(PDColorSpace pDColorSpace) {
        if (this.strokingColorSpaceStack.isEmpty()) {
            this.strokingColorSpaceStack.add(pDColorSpace);
        } else {
            this.strokingColorSpaceStack.setElementAt(pDColorSpace, r0.size() - 1);
        }
    }

    private void write(String str) throws IOException {
        this.output.write(str.getBytes(Charsets.US_ASCII));
    }

    private void writeAffineTransform(AffineTransform affineTransform) throws IOException {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        for (int i2 = 0; i2 < 6; i2++) {
            writeOperand((float) dArr[i2]);
        }
    }

    private void writeBytes(byte[] bArr) throws IOException {
        this.output.write(bArr);
    }

    private void writeLine() throws IOException {
        this.output.write(10);
    }

    private void writeOperator(String str) throws IOException {
        this.output.write(str.getBytes(Charsets.US_ASCII));
        this.output.write(10);
    }

    @Deprecated
    public void addBezier31(float f2, float f3, float f4, float f5) throws IOException {
        curveTo1(f2, f3, f4, f5);
    }

    @Deprecated
    public void addBezier312(float f2, float f3, float f4, float f5, float f6, float f7) throws IOException {
        curveTo(f2, f3, f4, f5, f6, f7);
    }

    @Deprecated
    public void addBezier32(float f2, float f3, float f4, float f5) throws IOException {
        curveTo2(f2, f3, f4, f5);
    }

    public void addComment(String str) throws IOException {
        if (str.indexOf(10) >= 0 || str.indexOf(13) >= 0) {
            throw new IllegalArgumentException("comment should not include a newline");
        }
        this.output.write(37);
        this.output.write(str.getBytes(Charsets.US_ASCII));
        this.output.write(10);
    }

    @Deprecated
    public void addLine(float f2, float f3, float f4, float f5) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: addLine is not allowed within a text block.");
        }
        moveTo(f2, f3);
        lineTo(f4, f5);
    }

    @Deprecated
    public void addPolygon(float[] fArr, float[] fArr2) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: addPolygon is not allowed within a text block.");
        }
        if (fArr.length != fArr2.length) {
            throw new IllegalArgumentException("Error: some points are missing coordinate");
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (i2 == 0) {
                moveTo(fArr[i2], fArr2[i2]);
            } else {
                lineTo(fArr[i2], fArr2[i2]);
            }
        }
        closeSubPath();
    }

    public void addRect(float f2, float f3, float f4, float f5) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: addRect is not allowed within a text block.");
        }
        writeOperand(f2);
        writeOperand(f3);
        writeOperand(f4);
        writeOperand(f5);
        writeOperator("re");
    }

    @Deprecated
    public void appendCOSName(COSName cOSName) throws IOException {
        cOSName.writePDF(this.output);
    }

    @Deprecated
    public void appendRawCommands(String str) throws IOException {
        this.output.write(str.getBytes(Charsets.US_ASCII));
    }

    public void beginMarkedContent(COSName cOSName) throws IOException {
        writeOperand(cOSName);
        writeOperator(OperatorName.BEGIN_MARKED_CONTENT);
    }

    @Deprecated
    public void beginMarkedContentSequence(COSName cOSName) throws IOException {
        beginMarkedContent(cOSName);
    }

    public void beginText() throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: Nested beginText() calls are not allowed.");
        }
        writeOperator(OperatorName.BEGIN_TEXT);
        this.inTextMode = true;
    }

    public void clip() throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: clip is not allowed within a text block.");
        }
        writeOperator("W");
        writeOperator(OperatorName.ENDPATH);
    }

    public void clipEvenOdd() throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: clipEvenOdd is not allowed within a text block.");
        }
        writeOperator(OperatorName.CLIP_EVEN_ODD);
        writeOperator(OperatorName.ENDPATH);
    }

    @Deprecated
    public void clipPath(Path.FillType fillType) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: clipPath is not allowed within a text block.");
        }
        if (fillType == Path.FillType.WINDING) {
            writeOperator("W");
        } else {
            if (fillType != Path.FillType.EVEN_ODD) {
                throw new IllegalArgumentException("Error: unknown value for winding rule");
            }
            writeOperator(OperatorName.CLIP_EVEN_ODD);
        }
        writeOperator(OperatorName.ENDPATH);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.inTextMode) {
            Log.w("PdfBox-Android", "You did not call endText(), some viewers won't display your text");
        }
        OutputStream outputStream = this.output;
        if (outputStream != null) {
            outputStream.close();
            this.output = null;
        }
    }

    public void closeAndFillAndStroke() throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: closeAndFillAndStroke is not allowed within a text block.");
        }
        writeOperator(OperatorName.CLOSE_FILL_NON_ZERO_AND_STROKE);
    }

    public void closeAndFillAndStrokeEvenOdd() throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: closeAndFillAndStrokeEvenOdd is not allowed within a text block.");
        }
        writeOperator(OperatorName.CLOSE_FILL_EVEN_ODD_AND_STROKE);
    }

    public void closeAndStroke() throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: closeAndStroke is not allowed within a text block.");
        }
        writeOperator(OperatorName.CLOSE_AND_STROKE);
    }

    public void closePath() throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: closePath is not allowed within a text block.");
        }
        writeOperator(OperatorName.CLOSE_PATH);
    }

    @Deprecated
    public void closeSubPath() throws IOException {
        closePath();
    }

    @Deprecated
    public void concatenate2CTM(double d2, double d3, double d4, double d5, double d6, double d7) throws IOException {
        transform(new Matrix((float) d2, (float) d3, (float) d4, (float) d5, (float) d6, (float) d7));
    }

    public void curveTo(float f2, float f3, float f4, float f5, float f6, float f7) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: curveTo is not allowed within a text block.");
        }
        writeOperand(f2);
        writeOperand(f3);
        writeOperand(f4);
        writeOperand(f5);
        writeOperand(f6);
        writeOperand(f7);
        writeOperator(OperatorName.CURVE_TO);
    }

    public void curveTo1(float f2, float f3, float f4, float f5) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: curveTo1 is not allowed within a text block.");
        }
        writeOperand(f2);
        writeOperand(f3);
        writeOperand(f4);
        writeOperand(f5);
        writeOperator(OperatorName.CURVE_TO_REPLICATE_FINAL_POINT);
    }

    public void curveTo2(float f2, float f3, float f4, float f5) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: curveTo2 is not allowed within a text block.");
        }
        writeOperand(f2);
        writeOperand(f3);
        writeOperand(f4);
        writeOperand(f5);
        writeOperator("v");
    }

    public void drawForm(PDFormXObject pDFormXObject) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: drawForm is not allowed within a text block.");
        }
        writeOperand(this.resources.add(pDFormXObject));
        writeOperator(OperatorName.DRAW_OBJECT);
    }

    public void drawImage(PDImageXObject pDImageXObject, float f2, float f3) throws IOException {
        drawImage(pDImageXObject, f2, f3, pDImageXObject.getWidth(), pDImageXObject.getHeight());
    }

    @Deprecated
    public void drawInlineImage(PDInlineImage pDInlineImage, float f2, float f3) throws IOException {
        drawImage(pDInlineImage, f2, f3, pDInlineImage.getWidth(), pDInlineImage.getHeight());
    }

    @Deprecated
    public void drawLine(float f2, float f3, float f4, float f5) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: drawLine is not allowed within a text block.");
        }
        moveTo(f2, f3);
        lineTo(f4, f5);
        stroke();
    }

    @Deprecated
    public void drawPolygon(float[] fArr, float[] fArr2) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: drawPolygon is not allowed within a text block.");
        }
        addPolygon(fArr, fArr2);
        stroke();
    }

    @Deprecated
    public void drawString(String str) throws IOException {
        showText(str);
    }

    @Deprecated
    public void drawXObject(PDXObject pDXObject, float f2, float f3, float f4, float f5) throws IOException {
        drawXObject(pDXObject, new AffineTransform(f4, 0.0f, 0.0f, f5, f2, f3));
    }

    public void endMarkedContent() throws IOException {
        writeOperator(OperatorName.END_MARKED_CONTENT);
    }

    @Deprecated
    public void endMarkedContentSequence() throws IOException {
        endMarkedContent();
    }

    public void endText() throws IOException {
        if (!this.inTextMode) {
            throw new IllegalStateException("Error: You must call beginText() before calling endText.");
        }
        writeOperator(OperatorName.END_TEXT);
        this.inTextMode = false;
    }

    @Deprecated
    public void fill(Path.FillType fillType) throws IOException {
        if (fillType == Path.FillType.WINDING) {
            fill();
        } else {
            if (fillType != Path.FillType.EVEN_ODD) {
                throw new IllegalArgumentException("Error: unknown value for winding rule");
            }
            fillEvenOdd();
        }
    }

    public void fillAndStroke() throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: fillAndStroke is not allowed within a text block.");
        }
        writeOperator("B");
    }

    public void fillAndStrokeEvenOdd() throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: fillAndStrokeEvenOdd is not allowed within a text block.");
        }
        writeOperator(OperatorName.FILL_EVEN_ODD_AND_STROKE);
    }

    public void fillEvenOdd() throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: fillEvenOdd is not allowed within a text block.");
        }
        writeOperator(OperatorName.FILL_EVEN_ODD);
    }

    @Deprecated
    public void fillPolygon(float[] fArr, float[] fArr2) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: fillPolygon is not allowed within a text block.");
        }
        addPolygon(fArr, fArr2);
        fill();
    }

    @Deprecated
    public void fillRect(float f2, float f3, float f4, float f5) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: fillRect is not allowed within a text block.");
        }
        addRect(f2, f3, f4, f5);
        fill();
    }

    public void lineTo(float f2, float f3) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: lineTo is not allowed within a text block.");
        }
        writeOperand(f2);
        writeOperand(f3);
        writeOperator(OperatorName.LINE_TO);
    }

    @Deprecated
    public void moveTextPositionByAmount(float f2, float f3) throws IOException {
        newLineAtOffset(f2, f3);
    }

    public void moveTo(float f2, float f3) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: moveTo is not allowed within a text block.");
        }
        writeOperand(f2);
        writeOperand(f3);
        writeOperator(OperatorName.MOVE_TO);
    }

    public void newLine() throws IOException {
        if (!this.inTextMode) {
            throw new IllegalStateException("Must call beginText() before newLine()");
        }
        writeOperator(OperatorName.NEXT_LINE);
    }

    public void newLineAtOffset(float f2, float f3) throws IOException {
        if (!this.inTextMode) {
            throw new IllegalStateException("Error: must call beginText() before newLineAtOffset()");
        }
        writeOperand(f2);
        writeOperand(f3);
        writeOperator(OperatorName.MOVE_TEXT);
    }

    public void restoreGraphicsState() throws IOException {
        if (this.inTextMode) {
            Log.w("PdfBox-Android", "Restoring the graphics state is not allowed within text objects.");
        }
        if (!this.fontStack.isEmpty()) {
            this.fontStack.pop();
        }
        if (!this.strokingColorSpaceStack.isEmpty()) {
            this.strokingColorSpaceStack.pop();
        }
        if (!this.nonStrokingColorSpaceStack.isEmpty()) {
            this.nonStrokingColorSpaceStack.pop();
        }
        writeOperator(OperatorName.RESTORE);
    }

    public void saveGraphicsState() throws IOException {
        if (this.inTextMode) {
            Log.w("PdfBox-Android", "Saving the graphics state is not allowed within text objects.");
        }
        if (!this.fontStack.isEmpty()) {
            Stack<PDFont> stack = this.fontStack;
            stack.push(stack.peek());
        }
        if (!this.strokingColorSpaceStack.isEmpty()) {
            Stack<PDColorSpace> stack2 = this.strokingColorSpaceStack;
            stack2.push(stack2.peek());
        }
        if (!this.nonStrokingColorSpaceStack.isEmpty()) {
            Stack<PDColorSpace> stack3 = this.nonStrokingColorSpaceStack;
            stack3.push(stack3.peek());
        }
        writeOperator(OperatorName.SAVE);
    }

    public void setCharacterSpacing(float f2) throws IOException {
        writeOperand(f2);
        writeOperator(OperatorName.SET_CHAR_SPACING);
    }

    public void setFont(PDFont pDFont, float f2) throws IOException {
        if (this.fontStack.isEmpty()) {
            this.fontStack.add(pDFont);
        } else {
            this.fontStack.setElementAt(pDFont, r0.size() - 1);
        }
        if (pDFont.willBeSubset()) {
            this.document.getFontsToSubset().add(pDFont);
        }
        writeOperand(this.resources.add(pDFont));
        writeOperand(f2);
        writeOperator(OperatorName.SET_FONT_AND_SIZE);
    }

    public void setGraphicsStateParameters(PDExtendedGraphicsState pDExtendedGraphicsState) throws IOException {
        writeOperand(this.resources.add(pDExtendedGraphicsState));
        writeOperator(OperatorName.SET_GRAPHICS_STATE_PARAMS);
    }

    public void setHorizontalScaling(float f2) throws IOException {
        writeOperand(f2);
        writeOperator(OperatorName.SET_TEXT_HORIZONTAL_SCALING);
    }

    @Deprecated
    public void setLeading(double d2) throws IOException {
        setLeading((float) d2);
    }

    public void setLineCapStyle(int i2) throws IOException {
        if (i2 < 0 || i2 > 2) {
            throw new IllegalArgumentException("Error: unknown value for line cap style");
        }
        writeOperand(i2);
        writeOperator(OperatorName.SET_LINE_CAPSTYLE);
    }

    public void setLineDashPattern(float[] fArr, float f2) throws IOException {
        write("[");
        for (float f3 : fArr) {
            writeOperand(f3);
        }
        write("] ");
        writeOperand(f2);
        writeOperator(OperatorName.SET_LINE_DASHPATTERN);
    }

    public void setLineJoinStyle(int i2) throws IOException {
        if (i2 < 0 || i2 > 2) {
            throw new IllegalArgumentException("Error: unknown value for line join style");
        }
        writeOperand(i2);
        writeOperator(OperatorName.SET_LINE_JOINSTYLE);
    }

    public void setLineWidth(float f2) throws IOException {
        writeOperand(f2);
        writeOperator(OperatorName.SET_LINE_WIDTH);
    }

    public void setMiterLimit(float f2) throws IOException {
        if (f2 <= 0.0d) {
            throw new IllegalArgumentException("A miter limit <= 0 is invalid and will not render in Acrobat Reader");
        }
        writeOperand(f2);
        writeOperator(OperatorName.SET_LINE_MITERLIMIT);
    }

    public void setNonStrokingColor(PDColor pDColor) throws IOException {
        if (this.nonStrokingColorSpaceStack.isEmpty() || this.nonStrokingColorSpaceStack.peek() != pDColor.getColorSpace()) {
            writeOperand(getName(pDColor.getColorSpace()));
            writeOperator(OperatorName.NON_STROKING_COLORSPACE);
            setNonStrokingColorSpaceStack(pDColor.getColorSpace());
        }
        for (float f2 : pDColor.getComponents()) {
            writeOperand(f2);
        }
        writeOperator(OperatorName.NON_STROKING_COLOR);
    }

    @Deprecated
    public void setNonStrokingColorSpace(PDColorSpace pDColorSpace) throws IOException {
        setNonStrokingColorSpaceStack(pDColorSpace);
        writeOperand(getName(pDColorSpace));
        writeOperator(OperatorName.NON_STROKING_COLORSPACE);
    }

    public void setRenderingMode(RenderingMode renderingMode) throws IOException {
        writeOperand(renderingMode.intValue());
        writeOperator(OperatorName.SET_TEXT_RENDERINGMODE);
    }

    public void setStrokingColor(PDColor pDColor) throws IOException {
        if (this.strokingColorSpaceStack.isEmpty() || this.strokingColorSpaceStack.peek() != pDColor.getColorSpace()) {
            writeOperand(getName(pDColor.getColorSpace()));
            writeOperator(OperatorName.STROKING_COLORSPACE);
            setStrokingColorSpaceStack(pDColor.getColorSpace());
        }
        for (float f2 : pDColor.getComponents()) {
            writeOperand(f2);
        }
        writeOperator(OperatorName.STROKING_COLOR);
    }

    @Deprecated
    public void setStrokingColorSpace(PDColorSpace pDColorSpace) throws IOException {
        setStrokingColorSpaceStack(pDColorSpace);
        writeOperand(getName(pDColorSpace));
        writeOperator(OperatorName.STROKING_COLORSPACE);
    }

    @Deprecated
    public void setTextMatrix(double d2, double d3, double d4, double d5, double d6, double d7) throws IOException {
        setTextMatrix(new Matrix((float) d2, (float) d3, (float) d4, (float) d5, (float) d6, (float) d7));
    }

    public void setTextRise(float f2) throws IOException {
        writeOperand(f2);
        writeOperator(OperatorName.SET_TEXT_RISE);
    }

    @Deprecated
    public void setTextRotation(double d2, double d3, double d4) throws IOException {
        setTextMatrix(Matrix.getRotateInstance(d2, (float) d3, (float) d4));
    }

    @Deprecated
    public void setTextScaling(double d2, double d3, double d4, double d5) throws IOException {
        setTextMatrix(new Matrix((float) d2, 0.0f, 0.0f, (float) d3, (float) d4, (float) d5));
    }

    @Deprecated
    public void setTextTranslation(double d2, double d3) throws IOException {
        setTextMatrix(Matrix.getTranslateInstance((float) d2, (float) d3));
    }

    public void setWordSpacing(float f2) throws IOException {
        writeOperand(f2);
        writeOperator(OperatorName.SET_WORD_SPACING);
    }

    public void shadingFill(PDShading pDShading) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: shadingFill is not allowed within a text block.");
        }
        writeOperand(this.resources.add(pDShading));
        writeOperator(OperatorName.SHADING_FILL);
    }

    public void showText(String str) throws IOException {
        showTextInternal(str);
        write(" ");
        writeOperator(OperatorName.SHOW_TEXT);
    }

    public void showTextInternal(String str) throws IOException {
        if (!this.inTextMode) {
            throw new IllegalStateException("Must call beginText() before showText()");
        }
        if (this.fontStack.isEmpty()) {
            throw new IllegalStateException("Must call setFont() before showText()");
        }
        PDFont pDFontPeek = this.fontStack.peek();
        if (pDFontPeek.willBeSubset()) {
            int iCharCount = 0;
            while (iCharCount < str.length()) {
                int iCodePointAt = str.codePointAt(iCharCount);
                pDFontPeek.addToSubset(iCodePointAt);
                iCharCount += Character.charCount(iCodePointAt);
            }
        }
        COSWriter.writeString(pDFontPeek.encode(str), this.output);
    }

    public void showTextWithPositioning(Object[] objArr) throws IOException {
        write("[");
        for (Object obj : objArr) {
            if (obj instanceof String) {
                showTextInternal((String) obj);
            } else {
                if (!(obj instanceof Float)) {
                    throw new IllegalArgumentException("Argument must consist of array of Float and String types");
                }
                writeOperand(((Float) obj).floatValue());
            }
        }
        write("] ");
        writeOperator(OperatorName.SHOW_TEXT_ADJUSTED);
    }

    public void stroke() throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: stroke is not allowed within a text block.");
        }
        writeOperator("S");
    }

    public void transform(Matrix matrix) throws IOException {
        if (this.inTextMode) {
            Log.w("PdfBox-Android", "Modifying the current transformation matrix is not allowed within text objects.");
        }
        writeAffineTransform(matrix.createAffineTransform());
        writeOperator(OperatorName.CONCAT);
    }

    public void writeOperand(float f2) throws IOException {
        if (Float.isInfinite(f2) || Float.isNaN(f2)) {
            throw new IllegalArgumentException(f2 + " is not a finite number");
        }
        int floatFast = NumberFormatUtil.formatFloatFast(f2, this.formatDecimal.getMaximumFractionDigits(), this.formatBuffer);
        if (floatFast == -1) {
            write(this.formatDecimal.format(f2));
        } else {
            this.output.write(this.formatBuffer, 0, floatFast);
        }
        this.output.write(32);
    }

    @Deprecated
    public void appendRawCommands(byte[] bArr) throws IOException {
        this.output.write(bArr);
    }

    @Deprecated
    public void beginMarkedContentSequence(COSName cOSName, COSName cOSName2) throws IOException {
        writeOperand(cOSName);
        writeOperand(cOSName2);
        writeOperator(OperatorName.BEGIN_MARKED_CONTENT_SEQ);
    }

    @Deprecated
    public void concatenate2CTM(AffineTransform affineTransform) throws IOException {
        transform(new Matrix(affineTransform));
    }

    public void drawImage(PDImageXObject pDImageXObject, float f2, float f3, float f4, float f5) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: drawImage is not allowed within a text block.");
        }
        saveGraphicsState();
        transform(new Matrix(new AffineTransform(f4, 0.0f, 0.0f, f5, f2, f3)));
        writeOperand(this.resources.add(pDImageXObject));
        writeOperator(OperatorName.DRAW_OBJECT);
        restoreGraphicsState();
    }

    @Deprecated
    public void drawInlineImage(PDInlineImage pDInlineImage, float f2, float f3, float f4, float f5) throws IOException {
        drawImage(pDInlineImage, f2, f3, f4, f5);
    }

    public void setLeading(float f2) throws IOException {
        writeOperand(f2);
        writeOperator(OperatorName.SET_TEXT_LEADING);
    }

    @Deprecated
    public void setTextMatrix(AffineTransform affineTransform) throws IOException {
        setTextMatrix(new Matrix(affineTransform));
    }

    @Deprecated
    public void appendRawCommands(int i2) throws IOException {
        this.output.write(i2);
    }

    public void beginMarkedContent(COSName cOSName, PDPropertyList pDPropertyList) throws IOException {
        writeOperand(cOSName);
        writeOperand(this.resources.add(pDPropertyList));
        writeOperator(OperatorName.BEGIN_MARKED_CONTENT_SEQ);
    }

    @Deprecated
    public void drawXObject(PDXObject pDXObject, AffineTransform affineTransform) throws IOException {
        if (!this.inTextMode) {
            COSName cOSNameAdd = this.resources.add(pDXObject, pDXObject instanceof PDImageXObject ? "Im" : StandardStructureTypes.FORM);
            saveGraphicsState();
            transform(new Matrix(affineTransform));
            writeOperand(cOSNameAdd);
            writeOperator(OperatorName.DRAW_OBJECT);
            restoreGraphicsState();
            return;
        }
        throw new IllegalStateException("Error: drawXObject is not allowed within a text block.");
    }

    public void setTextMatrix(Matrix matrix) throws IOException {
        if (this.inTextMode) {
            writeAffineTransform(matrix.createAffineTransform());
            writeOperator(OperatorName.SET_MATRIX);
            return;
        }
        throw new IllegalStateException("Error: must call beginText() before setTextMatrix");
    }

    @Deprecated
    public PDPageContentStream(PDDocument pDDocument, PDPage pDPage, boolean z, boolean z2) throws IOException {
        this(pDDocument, pDPage, z, z2, false);
    }

    @Deprecated
    public void appendRawCommands(double d2) throws IOException {
        this.output.write(this.formatDecimal.format(d2).getBytes(Charsets.US_ASCII));
    }

    public PDPageContentStream(PDDocument pDDocument, PDPage pDPage, AppendMode appendMode, boolean z) throws IOException {
        this(pDDocument, pDPage, appendMode, z, false);
    }

    @Deprecated
    public void appendRawCommands(float f2) throws IOException {
        this.output.write(this.formatDecimal.format(f2).getBytes(Charsets.US_ASCII));
    }

    @Deprecated
    public PDPageContentStream(PDDocument pDDocument, PDPage pDPage, boolean z, boolean z2, boolean z3) throws IOException {
        this(pDDocument, pDPage, z ? AppendMode.APPEND : AppendMode.OVERWRITE, z2, z3);
    }

    public void fill() throws IOException {
        if (!this.inTextMode) {
            writeOperator(OperatorName.FILL_NON_ZERO);
            return;
        }
        throw new IllegalStateException("Error: fill is not allowed within a text block.");
    }

    public PDPageContentStream(PDDocument pDDocument, PDPage pDPage, AppendMode appendMode, boolean z, boolean z2) throws IOException {
        COSArray cOSArray;
        this.inTextMode = false;
        this.fontStack = new Stack<>();
        this.nonStrokingColorSpaceStack = new Stack<>();
        this.strokingColorSpaceStack = new Stack<>();
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
        this.formatDecimal = numberInstance;
        this.formatBuffer = new byte[32];
        this.sourcePageHadContents = false;
        this.document = pDDocument;
        COSName cOSName = z ? COSName.FLATE_DECODE : null;
        if (!appendMode.isOverwrite() && pDPage.hasContents()) {
            PDStream pDStream = new PDStream(pDDocument);
            COSDictionary cOSObject = pDPage.getCOSObject();
            COSName cOSName2 = COSName.CONTENTS;
            COSBase dictionaryObject = cOSObject.getDictionaryObject(cOSName2);
            if (dictionaryObject instanceof COSArray) {
                cOSArray = (COSArray) dictionaryObject;
            } else {
                COSArray cOSArray2 = new COSArray();
                cOSArray2.add(dictionaryObject);
                cOSArray = cOSArray2;
            }
            if (appendMode.isPrepend()) {
                cOSArray.add(0, pDStream.getCOSObject());
            } else {
                cOSArray.add(pDStream);
            }
            if (z2) {
                PDStream pDStream2 = new PDStream(pDDocument);
                this.output = pDStream2.createOutputStream(cOSName);
                saveGraphicsState();
                close();
                cOSArray.add(0, pDStream2.getCOSObject());
            }
            pDPage.getCOSObject().setItem(cOSName2, (COSBase) cOSArray);
            this.output = pDStream.createOutputStream(cOSName);
            if (z2) {
                restoreGraphicsState();
            }
        } else {
            this.sourcePageHadContents = pDPage.hasContents();
            PDStream pDStream3 = new PDStream(pDDocument);
            pDPage.setContents(pDStream3);
            this.output = pDStream3.createOutputStream(cOSName);
        }
        PDResources resources = pDPage.getResources();
        this.resources = resources;
        if (resources == null) {
            PDResources pDResources = new PDResources();
            this.resources = pDResources;
            pDPage.setResources(pDResources);
        }
        numberInstance.setMaximumFractionDigits(5);
        numberInstance.setGroupingUsed(false);
    }

    private void writeOperand(int i2) throws IOException {
        write(this.formatDecimal.format(i2));
        this.output.write(32);
    }

    private void writeOperand(COSName cOSName) throws IOException {
        cOSName.writePDF(this.output);
        this.output.write(32);
    }

    public void setNonStrokingColor(AWTColor aWTColor) throws IOException {
        setNonStrokingColor(new PDColor(new float[]{aWTColor.getRed() / 255.0f, aWTColor.getGreen() / 255.0f, aWTColor.getBlue() / 255.0f}, PDDeviceRGB.INSTANCE));
    }

    public void setStrokingColor(AWTColor aWTColor) throws IOException {
        setStrokingColor(new PDColor(new float[]{aWTColor.getRed() / 255.0f, aWTColor.getGreen() / 255.0f, aWTColor.getBlue() / 255.0f}, PDDeviceRGB.INSTANCE));
    }

    public void drawImage(PDImageXObject pDImageXObject, Matrix matrix) throws IOException {
        if (!this.inTextMode) {
            saveGraphicsState();
            transform(new Matrix(matrix.createAffineTransform()));
            writeOperand(this.resources.add(pDImageXObject));
            writeOperator(OperatorName.DRAW_OBJECT);
            restoreGraphicsState();
            return;
        }
        throw new IllegalStateException("Error: drawImage is not allowed within a text block.");
    }

    @Deprecated
    public void setNonStrokingColor(float[] fArr) throws IOException {
        if (!this.nonStrokingColorSpaceStack.isEmpty()) {
            for (float f2 : fArr) {
                writeOperand(f2);
            }
            this.nonStrokingColorSpaceStack.peek();
            writeOperator(OperatorName.NON_STROKING_COLOR);
            return;
        }
        throw new IllegalStateException("The color space must be set before setting a color");
    }

    @Deprecated
    public void setStrokingColor(float[] fArr) throws IOException {
        if (!this.strokingColorSpaceStack.isEmpty()) {
            for (float f2 : fArr) {
                writeOperand(f2);
            }
            this.strokingColorSpaceStack.peek();
            writeOperator(OperatorName.STROKING_COLOR);
            return;
        }
        throw new IllegalStateException("The color space must be set before setting a color");
    }

    public void drawImage(PDInlineImage pDInlineImage, float f2, float f3) throws IOException {
        drawImage(pDInlineImage, f2, f3, pDInlineImage.getWidth(), pDInlineImage.getHeight());
    }

    public void setNonStrokingColor(float f2, float f3, float f4) throws IOException {
        if (!isOutsideOneInterval(f2) && !isOutsideOneInterval(f3) && !isOutsideOneInterval(f4)) {
            writeOperand(f2);
            writeOperand(f3);
            writeOperand(f4);
            writeOperator(OperatorName.NON_STROKING_RGB);
            setNonStrokingColorSpaceStack(PDDeviceRGB.INSTANCE);
            return;
        }
        throw new IllegalArgumentException("Parameters must be within 0..1, but are " + String.format("(%.2f,%.2f,%.2f)", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
    }

    public void setStrokingColor(float f2, float f3, float f4) throws IOException {
        if (!isOutsideOneInterval(f2) && !isOutsideOneInterval(f3) && !isOutsideOneInterval(f4)) {
            writeOperand(f2);
            writeOperand(f3);
            writeOperand(f4);
            writeOperator(OperatorName.STROKING_COLOR_RGB);
            setStrokingColorSpaceStack(PDDeviceRGB.INSTANCE);
            return;
        }
        throw new IllegalArgumentException("Parameters must be within 0..1, but are " + String.format("(%.2f,%.2f,%.2f)", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
    }

    public void drawImage(PDInlineImage pDInlineImage, float f2, float f3, float f4, float f5) throws IOException {
        if (!this.inTextMode) {
            saveGraphicsState();
            transform(new Matrix(f4, 0.0f, 0.0f, f5, f2, f3));
            StringBuilder sb = new StringBuilder();
            sb.append(OperatorName.BEGIN_INLINE_IMAGE);
            sb.append("\n /W ");
            sb.append(pDInlineImage.getWidth());
            sb.append("\n /H ");
            sb.append(pDInlineImage.getHeight());
            sb.append("\n /CS ");
            sb.append("/");
            sb.append(pDInlineImage.getColorSpace().getName());
            COSArray decode = pDInlineImage.getDecode();
            if (decode != null && decode.size() > 0) {
                sb.append("\n /D ");
                sb.append("[");
                Iterator<COSBase> it = decode.iterator();
                while (it.hasNext()) {
                    sb.append(((COSNumber) it.next()).intValue());
                    sb.append(" ");
                }
                sb.append("]");
            }
            if (pDInlineImage.isStencil()) {
                sb.append("\n /IM true");
            }
            sb.append("\n /BPC ");
            sb.append(pDInlineImage.getBitsPerComponent());
            write(sb.toString());
            writeLine();
            writeOperator(OperatorName.BEGIN_INLINE_IMAGE_DATA);
            writeBytes(pDInlineImage.getData());
            writeLine();
            writeOperator(OperatorName.END_INLINE_IMAGE);
            restoreGraphicsState();
            return;
        }
        throw new IllegalStateException("Error: drawImage is not allowed within a text block.");
    }

    @Deprecated
    public void setNonStrokingColor(int i2, int i3, int i4) throws IOException {
        if (!isOutside255Interval(i2) && !isOutside255Interval(i3) && !isOutside255Interval(i4)) {
            setNonStrokingColor(i2 / 255.0f, i3 / 255.0f, i4 / 255.0f);
            return;
        }
        throw new IllegalArgumentException("Parameters must be within 0..255, but are " + String.format("(%d,%d,%d)", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    @Deprecated
    public void setStrokingColor(int i2, int i3, int i4) throws IOException {
        if (!isOutside255Interval(i2) && !isOutside255Interval(i3) && !isOutside255Interval(i4)) {
            setStrokingColor(i2 / 255.0f, i3 / 255.0f, i4 / 255.0f);
            return;
        }
        throw new IllegalArgumentException("Parameters must be within 0..255, but are " + String.format("(%d,%d,%d)", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    public void setNonStrokingColor(int i2, int i3, int i4, int i5) throws IOException {
        if (!isOutside255Interval(i2) && !isOutside255Interval(i3) && !isOutside255Interval(i4) && !isOutside255Interval(i5)) {
            setNonStrokingColor(i2 / 255.0f, i3 / 255.0f, i4 / 255.0f, i5 / 255.0f);
            return;
        }
        throw new IllegalArgumentException("Parameters must be within 0..255, but are " + String.format("(%d,%d,%d,%d)", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
    }

    @Deprecated
    public void setStrokingColor(int i2, int i3, int i4, int i5) throws IOException {
        if (!isOutside255Interval(i2) && !isOutside255Interval(i3) && !isOutside255Interval(i4) && !isOutside255Interval(i5)) {
            setStrokingColor(i2 / 255.0f, i3 / 255.0f, i4 / 255.0f, i5 / 255.0f);
            return;
        }
        throw new IllegalArgumentException("Parameters must be within 0..255, but are " + String.format("(%d,%d,%d,%d)", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
    }

    @Deprecated
    public void setNonStrokingColor(double d2, double d3, double d4, double d5) throws IOException {
        setNonStrokingColor((float) d2, (float) d3, (float) d4, (float) d5);
    }

    public void setStrokingColor(float f2, float f3, float f4, float f5) throws IOException {
        if (!isOutsideOneInterval(f2) && !isOutsideOneInterval(f3) && !isOutsideOneInterval(f4) && !isOutsideOneInterval(f5)) {
            writeOperand(f2);
            writeOperand(f3);
            writeOperand(f4);
            writeOperand(f5);
            writeOperator(OperatorName.STROKING_COLOR_CMYK);
            return;
        }
        throw new IllegalArgumentException("Parameters must be within 0..1, but are " + String.format("(%.2f,%.2f,%.2f,%.2f)", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)));
    }

    public void setNonStrokingColor(float f2, float f3, float f4, float f5) throws IOException {
        if (!isOutsideOneInterval(f2) && !isOutsideOneInterval(f3) && !isOutsideOneInterval(f4) && !isOutsideOneInterval(f5)) {
            writeOperand(f2);
            writeOperand(f3);
            writeOperand(f4);
            writeOperand(f5);
            writeOperator(OperatorName.NON_STROKING_CMYK);
            return;
        }
        throw new IllegalArgumentException("Parameters must be within 0..1, but are " + String.format("(%.2f,%.2f,%.2f,%.2f)", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)));
    }

    @Deprecated
    public void setStrokingColor(int i2) throws IOException {
        if (!isOutside255Interval(i2)) {
            setStrokingColor(i2 / 255.0f);
            return;
        }
        throw new IllegalArgumentException("Parameter must be within 0..255, but is " + i2);
    }

    public void setNonStrokingColor(int i2) throws IOException {
        if (!isOutside255Interval(i2)) {
            setNonStrokingColor(i2 / 255.0f);
            return;
        }
        throw new IllegalArgumentException("Parameter must be within 0..255, but is " + i2);
    }

    public PDPageContentStream(PDDocument pDDocument, PDAppearanceStream pDAppearanceStream) throws IOException {
        this(pDDocument, pDAppearanceStream, pDAppearanceStream.getStream().createOutputStream());
    }

    public PDPageContentStream(PDDocument pDDocument, PDAppearanceStream pDAppearanceStream, OutputStream outputStream) throws IOException {
        this.inTextMode = false;
        this.fontStack = new Stack<>();
        this.nonStrokingColorSpaceStack = new Stack<>();
        this.strokingColorSpaceStack = new Stack<>();
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
        this.formatDecimal = numberInstance;
        this.formatBuffer = new byte[32];
        this.sourcePageHadContents = false;
        this.document = pDDocument;
        this.output = outputStream;
        this.resources = pDAppearanceStream.getResources();
        numberInstance.setMaximumFractionDigits(4);
        numberInstance.setGroupingUsed(false);
    }

    @Deprecated
    public void setStrokingColor(double d2) throws IOException {
        setStrokingColor((float) d2);
    }

    @Deprecated
    public void setNonStrokingColor(double d2) throws IOException {
        setNonStrokingColor((float) d2);
    }

    public void setStrokingColor(float f2) throws IOException {
        if (!isOutsideOneInterval(f2)) {
            writeOperand(f2);
            writeOperator(OperatorName.STROKING_COLOR_GRAY);
            setStrokingColorSpaceStack(PDDeviceGray.INSTANCE);
        } else {
            throw new IllegalArgumentException("Parameter must be within 0..1, but is " + f2);
        }
    }

    public void setNonStrokingColor(float f2) throws IOException {
        if (!isOutsideOneInterval(f2)) {
            writeOperand(f2);
            writeOperator(OperatorName.NON_STROKING_GRAY);
            setNonStrokingColorSpaceStack(PDDeviceGray.INSTANCE);
        } else {
            throw new IllegalArgumentException("Parameter must be within 0..1, but is " + f2);
        }
    }

    public PDPageContentStream(PDDocument pDDocument, PDFormXObject pDFormXObject, OutputStream outputStream) throws IOException {
        this.inTextMode = false;
        this.fontStack = new Stack<>();
        this.nonStrokingColorSpaceStack = new Stack<>();
        this.strokingColorSpaceStack = new Stack<>();
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
        this.formatDecimal = numberInstance;
        this.formatBuffer = new byte[32];
        this.sourcePageHadContents = false;
        this.document = pDDocument;
        this.output = outputStream;
        this.resources = pDFormXObject.getResources();
        numberInstance.setMaximumFractionDigits(4);
        numberInstance.setGroupingUsed(false);
    }

    public PDPageContentStream(PDDocument pDDocument, PDTilingPattern pDTilingPattern, OutputStream outputStream) throws IOException {
        this.inTextMode = false;
        this.fontStack = new Stack<>();
        this.nonStrokingColorSpaceStack = new Stack<>();
        this.strokingColorSpaceStack = new Stack<>();
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
        this.formatDecimal = numberInstance;
        this.formatBuffer = new byte[32];
        this.sourcePageHadContents = false;
        this.document = pDDocument;
        this.output = outputStream;
        this.resources = pDTilingPattern.getResources();
        numberInstance.setMaximumFractionDigits(4);
        numberInstance.setGroupingUsed(false);
    }
}
