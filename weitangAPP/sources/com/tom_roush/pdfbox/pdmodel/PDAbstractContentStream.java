package com.tom_roush.pdfbox.pdmodel;

import android.util.Log;
import com.tom_roush.harmony.awt.AWTColor;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.pdfwriter.COSWriter;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.markedcontent.PDPropertyList;
import com.tom_roush.pdfbox.pdmodel.font.PDFont;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColorSpace;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import com.tom_roush.pdfbox.pdmodel.graphics.form.PDFormXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.image.PDImageXObject;
import com.tom_roush.pdfbox.pdmodel.graphics.image.PDInlineImage;
import com.tom_roush.pdfbox.pdmodel.graphics.shading.PDShading;
import com.tom_roush.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import com.tom_roush.pdfbox.pdmodel.graphics.state.RenderingMode;
import com.tom_roush.pdfbox.util.Charsets;
import com.tom_roush.pdfbox.util.Matrix;
import com.tom_roush.pdfbox.util.NumberFormatUtil;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDAbstractContentStream implements Closeable {
    public final PDDocument document;
    private final byte[] formatBuffer;
    private final NumberFormat formatDecimal;
    public final OutputStream outputStream;
    public final PDResources resources;
    public boolean inTextMode = false;
    public final Deque<PDFont> fontStack = new ArrayDeque();
    public final Deque<PDColorSpace> nonStrokingColorSpaceStack = new ArrayDeque();
    public final Deque<PDColorSpace> strokingColorSpaceStack = new ArrayDeque();

    public PDAbstractContentStream(PDDocument pDDocument, OutputStream outputStream, PDResources pDResources) {
        NumberFormat numberInstance = NumberFormat.getNumberInstance(Locale.US);
        this.formatDecimal = numberInstance;
        this.formatBuffer = new byte[32];
        this.document = pDDocument;
        this.outputStream = outputStream;
        this.resources = pDResources;
        numberInstance.setMaximumFractionDigits(4);
        numberInstance.setGroupingUsed(false);
    }

    private boolean isOutsideOneInterval(double d2) {
        return d2 < 0.0d || d2 > 1.0d;
    }

    private void writeAffineTransform(AffineTransform affineTransform) throws IOException {
        double[] dArr = new double[6];
        affineTransform.getMatrix(dArr);
        for (int i2 = 0; i2 < 6; i2++) {
            writeOperand((float) dArr[i2]);
        }
    }

    public void addComment(String str) throws IOException {
        if (str.indexOf(10) >= 0 || str.indexOf(13) >= 0) {
            throw new IllegalArgumentException("comment should not include a newline");
        }
        this.outputStream.write(37);
        this.outputStream.write(str.getBytes(Charsets.US_ASCII));
        this.outputStream.write(10);
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

    public void beginMarkedContent(COSName cOSName) throws IOException {
        writeOperand(cOSName);
        writeOperator(OperatorName.BEGIN_MARKED_CONTENT);
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.inTextMode) {
            Log.w("PdfBox-Android", "You did not call endText(), some viewers won't display your text");
        }
        this.outputStream.close();
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

    public void endMarkedContent() throws IOException {
        writeOperator(OperatorName.END_MARKED_CONTENT);
    }

    public void endText() throws IOException {
        if (!this.inTextMode) {
            throw new IllegalStateException("Error: You must call beginText() before calling endText.");
        }
        writeOperator(OperatorName.END_TEXT);
        this.inTextMode = false;
    }

    public void fill() throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: fill is not allowed within a text block.");
        }
        writeOperator(OperatorName.FILL_NON_ZERO);
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

    public COSName getName(PDColorSpace pDColorSpace) {
        return ((pDColorSpace instanceof PDDeviceGray) || (pDColorSpace instanceof PDDeviceRGB)) ? COSName.getPDFName(pDColorSpace.getName()) : this.resources.add(pDColorSpace);
    }

    public boolean isOutside255Interval(int i2) {
        return i2 < 0 || i2 > 255;
    }

    public void lineTo(float f2, float f3) throws IOException {
        if (this.inTextMode) {
            throw new IllegalStateException("Error: lineTo is not allowed within a text block.");
        }
        writeOperand(f2);
        writeOperand(f3);
        writeOperator(OperatorName.LINE_TO);
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
            throw new IllegalStateException("Error: Restoring the graphics state is not allowed within text objects.");
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
            throw new IllegalStateException("Error: Saving the graphics state is not allowed within text objects.");
        }
        if (!this.fontStack.isEmpty()) {
            Deque<PDFont> deque = this.fontStack;
            deque.push(deque.peek());
        }
        if (!this.strokingColorSpaceStack.isEmpty()) {
            Deque<PDColorSpace> deque2 = this.strokingColorSpaceStack;
            deque2.push(deque2.peek());
        }
        if (!this.nonStrokingColorSpaceStack.isEmpty()) {
            Deque<PDColorSpace> deque3 = this.nonStrokingColorSpaceStack;
            deque3.push(deque3.peek());
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
            this.fontStack.pop();
            this.fontStack.push(pDFont);
        }
        if (pDFont.willBeSubset()) {
            PDDocument pDDocument = this.document;
            if (pDDocument != null) {
                pDDocument.getFontsToSubset().add(pDFont);
            } else {
                Log.w("PdfBox-Android", "Using the subsetted font '" + pDFont.getName() + "' without a PDDocument context; call subset() before saving");
            }
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

    public void setLeading(float f2) throws IOException {
        writeOperand(f2);
        writeOperator(OperatorName.SET_TEXT_LEADING);
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

    public void setMaximumFractionDigits(int i2) {
        this.formatDecimal.setMaximumFractionDigits(i2);
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

    public void setNonStrokingColorSpaceStack(PDColorSpace pDColorSpace) {
        if (this.nonStrokingColorSpaceStack.isEmpty()) {
            this.nonStrokingColorSpaceStack.add(pDColorSpace);
        } else {
            this.nonStrokingColorSpaceStack.pop();
            this.nonStrokingColorSpaceStack.push(pDColorSpace);
        }
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

    public void setStrokingColorSpaceStack(PDColorSpace pDColorSpace) {
        if (this.strokingColorSpaceStack.isEmpty()) {
            this.strokingColorSpaceStack.add(pDColorSpace);
        } else {
            this.strokingColorSpaceStack.pop();
            this.strokingColorSpaceStack.push(pDColorSpace);
        }
    }

    public void setTextMatrix(Matrix matrix) throws IOException {
        if (!this.inTextMode) {
            throw new IllegalStateException("Error: must call beginText() before setTextMatrix");
        }
        writeAffineTransform(matrix.createAffineTransform());
        writeOperator(OperatorName.SET_MATRIX);
    }

    public void setTextRise(float f2) throws IOException {
        writeOperand(f2);
        writeOperator(OperatorName.SET_TEXT_RISE);
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
        byte[] bArrEncode = pDFontPeek.encode(str);
        if (pDFontPeek.willBeSubset()) {
            int iCharCount = 0;
            while (iCharCount < str.length()) {
                int iCodePointAt = str.codePointAt(iCharCount);
                pDFontPeek.addToSubset(iCodePointAt);
                iCharCount += Character.charCount(iCodePointAt);
            }
        }
        COSWriter.writeString(bArrEncode, this.outputStream);
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
            throw new IllegalStateException("Error: Modifying the current transformation matrix is not allowed within text objects.");
        }
        writeAffineTransform(matrix.createAffineTransform());
        writeOperator(OperatorName.CONCAT);
    }

    public void write(String str) throws IOException {
        this.outputStream.write(str.getBytes(Charsets.US_ASCII));
    }

    public void writeBytes(byte[] bArr) throws IOException {
        this.outputStream.write(bArr);
    }

    public void writeLine() throws IOException {
        this.outputStream.write(10);
    }

    public void writeOperand(float f2) throws IOException {
        if (Float.isInfinite(f2) || Float.isNaN(f2)) {
            throw new IllegalArgumentException(f2 + " is not a finite number");
        }
        int floatFast = NumberFormatUtil.formatFloatFast(f2, this.formatDecimal.getMaximumFractionDigits(), this.formatBuffer);
        if (floatFast == -1) {
            write(this.formatDecimal.format(f2));
        } else {
            this.outputStream.write(this.formatBuffer, 0, floatFast);
        }
        this.outputStream.write(32);
    }

    public void writeOperator(String str) throws IOException {
        this.outputStream.write(str.getBytes(Charsets.US_ASCII));
        this.outputStream.write(10);
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

    public void write(byte[] bArr) throws IOException {
        this.outputStream.write(bArr);
    }

    public void beginMarkedContent(COSName cOSName, PDPropertyList pDPropertyList) throws IOException {
        writeOperand(cOSName);
        writeOperand(this.resources.add(pDPropertyList));
        writeOperator(OperatorName.BEGIN_MARKED_CONTENT_SEQ);
    }

    public void writeOperand(int i2) throws IOException {
        write(this.formatDecimal.format(i2));
        this.outputStream.write(32);
    }

    public void setNonStrokingColor(AWTColor aWTColor) throws IOException {
        setNonStrokingColor(new PDColor(new float[]{aWTColor.getRed() / 255.0f, aWTColor.getGreen() / 255.0f, aWTColor.getBlue() / 255.0f}, PDDeviceRGB.INSTANCE));
    }

    public void setStrokingColor(AWTColor aWTColor) throws IOException {
        setStrokingColor(new PDColor(new float[]{aWTColor.getRed() / 255.0f, aWTColor.getGreen() / 255.0f, aWTColor.getBlue() / 255.0f}, PDDeviceRGB.INSTANCE));
    }

    public void writeOperand(COSName cOSName) throws IOException {
        cOSName.writePDF(this.outputStream);
        this.outputStream.write(32);
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

    public void drawImage(PDInlineImage pDInlineImage, float f2, float f3) throws IOException {
        drawImage(pDInlineImage, f2, f3, pDInlineImage.getWidth(), pDInlineImage.getHeight());
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

    public void setStrokingColor(float f2) throws IOException {
        if (!isOutsideOneInterval(f2)) {
            writeOperand(f2);
            writeOperator(OperatorName.STROKING_COLOR_GRAY);
            setStrokingColorSpaceStack(PDDeviceGray.INSTANCE);
        } else {
            throw new IllegalArgumentException("Parameter must be within 0..1, but is " + f2);
        }
    }

    public void setNonStrokingColor(int i2) throws IOException {
        if (!isOutside255Interval(i2)) {
            setNonStrokingColor(i2 / 255.0f);
            return;
        }
        throw new IllegalArgumentException("Parameter must be within 0..255, but is " + i2);
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
}
