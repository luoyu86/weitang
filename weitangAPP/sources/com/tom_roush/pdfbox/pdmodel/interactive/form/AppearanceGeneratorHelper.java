package com.tom_roush.pdfbox.pdmodel.interactive.form;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import com.tom_roush.fontbox.util.BoundingBox;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.contentstream.operator.Operator;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.pdfparser.PDFStreamParser;
import com.tom_roush.pdfbox.pdfwriter.ContentStreamWriter;
import com.tom_roush.pdfbox.pdmodel.PDPageContentStream;
import com.tom_roush.pdfbox.pdmodel.PDResources;
import com.tom_roush.pdfbox.pdmodel.common.PDPageLabelRange;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.StandardStructureTypes;
import com.tom_roush.pdfbox.pdmodel.font.PDFont;
import com.tom_roush.pdfbox.pdmodel.font.PDSimpleFont;
import com.tom_roush.pdfbox.pdmodel.font.PDType3CharProc;
import com.tom_roush.pdfbox.pdmodel.font.PDType3Font;
import com.tom_roush.pdfbox.pdmodel.font.PDVectorFont;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.interactive.action.PDAction;
import com.tom_roush.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import com.tom_roush.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceCharacteristicsDictionary;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import com.tom_roush.pdfbox.pdmodel.interactive.form.PlainText;
import com.tom_roush.pdfbox.pdmodel.interactive.form.PlainTextFormatter;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppearanceGeneratorHelper {
    private static final float DEFAULT_FONT_SIZE = 12.0f;
    private static final float DEFAULT_PADDING = 0.5f;
    private static final int FONTSCALE = 1000;
    private static final float MAXIMUM_FONT_SIZE = 300.0f;
    private static final float MINIMUM_FONT_SIZE = 4.0f;
    private PDDefaultAppearanceString defaultAppearance;
    private final PDVariableText field;
    private String value;
    private static final Operator BMC = Operator.getOperator(OperatorName.BEGIN_MARKED_CONTENT);
    private static final Operator EMC = Operator.getOperator(OperatorName.END_MARKED_CONTENT);
    private static final float[] HIGHLIGHT_COLOR = {0.6f, 0.75686276f, 0.84313726f};

    public AppearanceGeneratorHelper(PDVariableText pDVariableText) throws IOException {
        this.field = pDVariableText;
        validateAndEnsureAcroFormResources();
        try {
            this.defaultAppearance = pDVariableText.getDefaultAppearanceString();
        } catch (IOException e2) {
            throw new IOException("Could not process default appearance string '" + pDVariableText.getDefaultAppearance() + "' for field '" + pDVariableText.getFullyQualifiedName() + OperatorName.SHOW_TEXT_LINE, e2);
        }
    }

    private PDRectangle applyPadding(PDRectangle pDRectangle, float f2) {
        float lowerLeftX = pDRectangle.getLowerLeftX() + f2;
        float lowerLeftY = pDRectangle.getLowerLeftY() + f2;
        float f3 = f2 * 2.0f;
        return new PDRectangle(lowerLeftX, lowerLeftY, pDRectangle.getWidth() - f3, pDRectangle.getHeight() - f3);
    }

    private float calculateFontSize(PDFont pDFont, PDRectangle pDRectangle) throws IOException {
        float fontSize = this.defaultAppearance.getFontSize();
        if (fontSize != 0.0f) {
            return fontSize;
        }
        if (!isMultiLine()) {
            float scaleY = pDFont.getFontMatrix().getScaleY() * 1000.0f;
            float width = (pDRectangle.getWidth() / (pDFont.getStringWidth(this.value) * pDFont.getFontMatrix().getScaleX())) * pDFont.getFontMatrix().getScaleX() * 1000.0f;
            float capHeight = (pDFont.getFontDescriptor().getCapHeight() + (-pDFont.getFontDescriptor().getDescent())) * pDFont.getFontMatrix().getScaleY();
            if (capHeight <= 0.0f) {
                capHeight = pDFont.getBoundingBox().getHeight() * pDFont.getFontMatrix().getScaleY();
            }
            return Math.min((pDRectangle.getHeight() / capHeight) * scaleY, width);
        }
        PlainText plainText = new PlainText(this.value);
        if (plainText.getParagraphs() == null) {
            return DEFAULT_FONT_SIZE;
        }
        float width2 = pDRectangle.getWidth() - pDRectangle.getLowerLeftX();
        float f2 = MINIMUM_FONT_SIZE;
        while (f2 <= DEFAULT_FONT_SIZE) {
            int size = 0;
            Iterator<PlainText.Paragraph> it = plainText.getParagraphs().iterator();
            while (it.hasNext()) {
                size += it.next().getLines(pDFont, f2, width2).size();
            }
            if (pDFont.getBoundingBox().getHeight() * (f2 / 1000.0f) * size > pDRectangle.getHeight()) {
                return Math.max(f2 - 1.0f, MINIMUM_FONT_SIZE);
            }
            f2 += 1.0f;
        }
        return Math.min(f2, DEFAULT_FONT_SIZE);
    }

    private AffineTransform calculateMatrix(PDRectangle pDRectangle, int i2) {
        float upperRightX;
        if (i2 == 0) {
            return new AffineTransform();
        }
        float upperRightY = 0.0f;
        if (i2 != 90) {
            if (i2 == 180) {
                upperRightY = pDRectangle.getUpperRightY();
                upperRightX = pDRectangle.getUpperRightX();
            } else if (i2 == 270) {
                upperRightX = pDRectangle.getUpperRightX();
            }
            return Matrix.getRotateInstance(Math.toRadians(i2), upperRightY, upperRightX).createAffineTransform();
        }
        upperRightY = pDRectangle.getUpperRightY();
        upperRightX = 0.0f;
        return Matrix.getRotateInstance(Math.toRadians(i2), upperRightY, upperRightX).createAffineTransform();
    }

    private String getFormattedValue(String str) {
        PDAction f2;
        PDFormFieldAdditionalActions actions = this.field.getActions();
        if (actions != null && (f2 = actions.getF()) != null) {
            if (this.field.getAcroForm().getScriptingHandler() != null) {
                return this.field.getAcroForm().getScriptingHandler().format((PDActionJavaScript) f2, str);
            }
            Log.i("PdfBox-Android", "Field contains a formatting action but no ScriptingHandler has been supplied - formatted value might be incorrect");
        }
        return str;
    }

    private int getTextAlign(PDAnnotationWidget pDAnnotationWidget) {
        return pDAnnotationWidget.getCOSObject().getInt(COSName.Q, this.field.getQ());
    }

    private PDDefaultAppearanceString getWidgetDefaultAppearanceString(PDAnnotationWidget pDAnnotationWidget) throws IOException {
        return new PDDefaultAppearanceString((COSString) pDAnnotationWidget.getCOSObject().getDictionaryObject(COSName.DA), this.field.getAcroForm().getDefaultResources());
    }

    private void initializeAppearanceContent(PDAnnotationWidget pDAnnotationWidget, PDAppearanceCharacteristicsDictionary pDAppearanceCharacteristicsDictionary, PDAppearanceStream pDAppearanceStream) throws IOException {
        float width;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PDPageContentStream pDPageContentStream = new PDPageContentStream(this.field.getAcroForm().getDocument(), pDAppearanceStream, (OutputStream) byteArrayOutputStream);
        if (pDAppearanceCharacteristicsDictionary != null) {
            PDColor background = pDAppearanceCharacteristicsDictionary.getBackground();
            if (background != null) {
                pDPageContentStream.setNonStrokingColor(background);
                PDRectangle pDRectangleResolveBoundingBox = resolveBoundingBox(pDAnnotationWidget, pDAppearanceStream);
                pDPageContentStream.addRect(pDRectangleResolveBoundingBox.getLowerLeftX(), pDRectangleResolveBoundingBox.getLowerLeftY(), pDRectangleResolveBoundingBox.getWidth(), pDRectangleResolveBoundingBox.getHeight());
                pDPageContentStream.fill();
            }
            PDColor borderColour = pDAppearanceCharacteristicsDictionary.getBorderColour();
            if (borderColour != null) {
                pDPageContentStream.setStrokingColor(borderColour);
                width = 1.0f;
            } else {
                width = 0.0f;
            }
            PDBorderStyleDictionary borderStyle = pDAnnotationWidget.getBorderStyle();
            if (borderStyle != null && borderStyle.getWidth() > 0.0f) {
                width = borderStyle.getWidth();
            }
            if (width > 0.0f && borderColour != null) {
                if (width != 1.0f) {
                    pDPageContentStream.setLineWidth(width);
                }
                PDRectangle pDRectangleApplyPadding = applyPadding(resolveBoundingBox(pDAnnotationWidget, pDAppearanceStream), Math.max(0.5f, width / 2.0f));
                pDPageContentStream.addRect(pDRectangleApplyPadding.getLowerLeftX(), pDRectangleApplyPadding.getLowerLeftY(), pDRectangleApplyPadding.getWidth(), pDRectangleApplyPadding.getHeight());
                pDPageContentStream.closeAndStroke();
            }
        }
        pDPageContentStream.close();
        byteArrayOutputStream.close();
        writeToStream(byteArrayOutputStream.toByteArray(), pDAppearanceStream);
    }

    private void insertGeneratedAppearance(PDAnnotationWidget pDAnnotationWidget, PDAppearanceStream pDAppearanceStream, OutputStream outputStream) throws IOException {
        float capHeight;
        float descent;
        float fMin;
        PDPageContentStream pDPageContentStream = new PDPageContentStream(this.field.getAcroForm().getDocument(), pDAppearanceStream, outputStream);
        PDRectangle pDRectangleResolveBoundingBox = resolveBoundingBox(pDAnnotationWidget, pDAppearanceStream);
        float width = pDAnnotationWidget.getBorderStyle() != null ? pDAnnotationWidget.getBorderStyle().getWidth() : 0.0f;
        PDRectangle pDRectangleApplyPadding = applyPadding(pDRectangleResolveBoundingBox, Math.max(1.0f, width));
        PDRectangle pDRectangleApplyPadding2 = applyPadding(pDRectangleApplyPadding, Math.max(1.0f, width));
        pDPageContentStream.saveGraphicsState();
        pDPageContentStream.addRect(pDRectangleApplyPadding.getLowerLeftX(), pDRectangleApplyPadding.getLowerLeftY(), pDRectangleApplyPadding.getWidth(), pDRectangleApplyPadding.getHeight());
        pDPageContentStream.clip();
        PDFont font = this.defaultAppearance.getFont();
        if (font == null) {
            throw new IllegalArgumentException("font is null, check whether /DA entry is incomplete or incorrect");
        }
        if (font.getName().contains("+")) {
            Log.w("PdfBox-Android", "Font '" + this.defaultAppearance.getFontName().getName() + "' of field '" + this.field.getFullyQualifiedName() + "' contains subsetted font '" + font.getName() + OperatorName.SHOW_TEXT_LINE);
            Log.w("PdfBox-Android", "This may bring trouble with PDField.setValue(), PDAcroForm.flatten() or PDAcroForm.refreshAppearances()");
            Log.w("PdfBox-Android", "You should replace this font with a non-subsetted font:");
            Log.w("PdfBox-Android", "PDFont font = PDType0Font.load(doc, new FileInputStream(fontfile), false);");
            StringBuilder sb = new StringBuilder();
            sb.append("acroForm.getDefaultResources().put(COSName.getPDFName(\"");
            sb.append(this.defaultAppearance.getFontName().getName());
            sb.append("\", font);");
            Log.w("PdfBox-Android", sb.toString());
        }
        float fontSize = this.defaultAppearance.getFontSize();
        if (fontSize == 0.0f) {
            fontSize = calculateFontSize(font, pDRectangleApplyPadding2);
        }
        float f2 = fontSize;
        if (this.field instanceof PDListBox) {
            insertGeneratedListboxSelectionHighlight(pDPageContentStream, pDAppearanceStream, font, f2);
        }
        pDPageContentStream.beginText();
        this.defaultAppearance.writeTo(pDPageContentStream, f2);
        float f3 = f2 / 1000.0f;
        float height = font.getBoundingBox().getHeight() * f3;
        if (font.getFontDescriptor() != null) {
            capHeight = font.getFontDescriptor().getCapHeight() * f3;
            descent = font.getFontDescriptor().getDescent() * f3;
        } else {
            float fResolveCapHeight = resolveCapHeight(font);
            float fResolveDescent = resolveDescent(font);
            Log.d("PdfBox-Android", "missing font descriptor - resolved Cap/Descent to " + fResolveCapHeight + "/" + fResolveDescent);
            capHeight = fResolveCapHeight * f3;
            descent = fResolveDescent * f3;
        }
        PDVariableText pDVariableText = this.field;
        if ((pDVariableText instanceof PDTextField) && ((PDTextField) pDVariableText).isMultiline()) {
            fMin = pDRectangleApplyPadding2.getUpperRightY() - height;
        } else if (capHeight > pDRectangleApplyPadding.getHeight()) {
            fMin = pDRectangleApplyPadding.getLowerLeftY() + (-descent);
        } else {
            float lowerLeftY = pDRectangleApplyPadding.getLowerLeftY() + ((pDRectangleApplyPadding.getHeight() - capHeight) / 2.0f);
            float f4 = -descent;
            fMin = lowerLeftY - pDRectangleApplyPadding.getLowerLeftY() < f4 ? Math.min(f4 + pDRectangleApplyPadding2.getLowerLeftY(), Math.max(lowerLeftY, (pDRectangleApplyPadding2.getHeight() - pDRectangleApplyPadding2.getLowerLeftY()) - capHeight)) : lowerLeftY;
        }
        float lowerLeftX = pDRectangleApplyPadding2.getLowerLeftX();
        if (shallComb()) {
            insertGeneratedCombAppearance(pDPageContentStream, pDAppearanceStream, font, f2);
        } else if (this.field instanceof PDListBox) {
            insertGeneratedListboxAppearance(pDPageContentStream, pDAppearanceStream, pDRectangleApplyPadding2, font, f2);
        } else {
            PlainText plainText = new PlainText(this.value);
            AppearanceStyle appearanceStyle = new AppearanceStyle();
            appearanceStyle.setFont(font);
            appearanceStyle.setFontSize(f2);
            appearanceStyle.setLeading(font.getBoundingBox().getHeight() * f3);
            new PlainTextFormatter.Builder(pDPageContentStream).style(appearanceStyle).text(plainText).width(pDRectangleApplyPadding2.getWidth()).wrapLines(isMultiLine()).initialOffset(lowerLeftX, fMin).textAlign(getTextAlign(pDAnnotationWidget)).build().format();
        }
        pDPageContentStream.endText();
        pDPageContentStream.restoreGraphicsState();
        pDPageContentStream.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0060 A[LOOP:0: B:10:0x005e->B:11:0x0060, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void insertGeneratedCombAppearance(com.tom_roush.pdfbox.pdmodel.PDPageContentStream r11, com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream r12, com.tom_roush.pdfbox.pdmodel.font.PDFont r13, float r14) throws java.io.IOException {
        /*
            r10 = this;
            com.tom_roush.pdfbox.pdmodel.interactive.form.PDVariableText r0 = r10.field
            com.tom_roush.pdfbox.pdmodel.interactive.form.PDTextField r0 = (com.tom_roush.pdfbox.pdmodel.interactive.form.PDTextField) r0
            int r0 = r0.getMaxLen()
            com.tom_roush.pdfbox.pdmodel.interactive.form.PDVariableText r1 = r10.field
            int r1 = r1.getQ()
            java.lang.String r2 = r10.value
            int r2 = r2.length()
            int r2 = java.lang.Math.min(r2, r0)
            com.tom_roush.pdfbox.pdmodel.common.PDRectangle r3 = r12.getBBox()
            r4 = 1065353216(0x3f800000, float:1.0)
            com.tom_roush.pdfbox.pdmodel.common.PDRectangle r3 = r10.applyPadding(r3, r4)
            com.tom_roush.pdfbox.pdmodel.common.PDRectangle r4 = r12.getBBox()
            float r4 = r4.getWidth()
            float r5 = (float) r0
            float r4 = r4 / r5
            com.tom_roush.pdfbox.pdmodel.font.PDFontDescriptor r5 = r13.getFontDescriptor()
            float r5 = r5.getAscent()
            r6 = 1148846080(0x447a0000, float:1000.0)
            float r5 = r5 / r6
            float r5 = r5 * r14
            float r3 = r3.getLowerLeftY()
            com.tom_roush.pdfbox.pdmodel.common.PDRectangle r12 = r12.getBBox()
            float r12 = r12.getHeight()
            float r12 = r12 - r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r12 = r12 / r5
            float r3 = r3 + r12
            float r12 = r4 / r5
            r7 = 2
            if (r1 != r7) goto L55
            int r0 = r0 - r2
        L50:
            float r0 = (float) r0
            float r0 = r0 * r4
            float r12 = r12 + r0
            goto L5b
        L55:
            r8 = 1
            if (r1 != r8) goto L5b
            int r0 = r0 - r2
            int r0 = r0 / r7
            goto L50
        L5b:
            r0 = 0
            r1 = 0
            r7 = 0
        L5e:
            if (r0 >= r2) goto L80
            java.lang.String r8 = r10.value
            int r9 = r0 + 1
            java.lang.String r0 = r8.substring(r0, r9)
            float r8 = r13.getStringWidth(r0)
            float r8 = r8 / r6
            float r8 = r8 * r14
            float r8 = r8 / r5
            float r7 = r7 / r5
            float r12 = r12 + r7
            float r7 = r8 / r5
            float r12 = r12 - r7
            r11.newLineAtOffset(r12, r3)
            r11.showText(r0)
            r12 = r4
            r7 = r8
            r0 = r9
            r3 = 0
            goto L5e
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.interactive.form.AppearanceGeneratorHelper.insertGeneratedCombAppearance(com.tom_roush.pdfbox.pdmodel.PDPageContentStream, com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream, com.tom_roush.pdfbox.pdmodel.font.PDFont, float):void");
    }

    private void insertGeneratedListboxAppearance(PDPageContentStream pDPageContentStream, PDAppearanceStream pDAppearanceStream, PDRectangle pDRectangle, PDFont pDFont, float f2) throws IOException {
        pDPageContentStream.setNonStrokingColor(0.0f);
        int q2 = this.field.getQ();
        if (q2 == 1 || q2 == 2) {
            float width = (pDAppearanceStream.getBBox().getWidth() - ((pDFont.getStringWidth(this.value) / 1000.0f) * f2)) - MINIMUM_FONT_SIZE;
            if (q2 == 1) {
                width /= 2.0f;
            }
            pDPageContentStream.newLineAtOffset(width, 0.0f);
        } else if (q2 != 0) {
            throw new IOException("Error: Unknown justification value:" + q2);
        }
        List<String> optionsDisplayValues = ((PDListBox) this.field).getOptionsDisplayValues();
        int size = optionsDisplayValues.size();
        float upperRightY = pDRectangle.getUpperRightY();
        int topIndex = ((PDListBox) this.field).getTopIndex();
        for (int i2 = topIndex; i2 < size; i2++) {
            if (i2 == topIndex) {
                upperRightY -= (pDFont.getFontDescriptor().getAscent() / 1000.0f) * f2;
            } else {
                upperRightY -= (pDFont.getBoundingBox().getHeight() / 1000.0f) * f2;
                pDPageContentStream.beginText();
            }
            pDPageContentStream.newLineAtOffset(pDRectangle.getLowerLeftX(), upperRightY);
            pDPageContentStream.showText(optionsDisplayValues.get(i2));
            if (i2 != size - 1) {
                pDPageContentStream.endText();
            }
        }
    }

    private void insertGeneratedListboxSelectionHighlight(PDPageContentStream pDPageContentStream, PDAppearanceStream pDAppearanceStream, PDFont pDFont, float f2) throws IOException {
        List<Integer> selectedOptionsIndex = ((PDListBox) this.field).getSelectedOptionsIndex();
        List<String> value = ((PDListBox) this.field).getValue();
        List<String> optionsExportValues = ((PDListBox) this.field).getOptionsExportValues();
        if (!value.isEmpty() && !optionsExportValues.isEmpty() && selectedOptionsIndex.isEmpty()) {
            selectedOptionsIndex = new ArrayList<>();
            Iterator<String> it = value.iterator();
            while (it.hasNext()) {
                selectedOptionsIndex.add(Integer.valueOf(optionsExportValues.indexOf(it.next())));
            }
        }
        int topIndex = ((PDListBox) this.field).getTopIndex();
        float height = (pDFont.getBoundingBox().getHeight() * f2) / 1000.0f;
        PDRectangle pDRectangleApplyPadding = applyPadding(pDAppearanceStream.getBBox(), 1.0f);
        Iterator<Integer> it2 = selectedOptionsIndex.iterator();
        while (it2.hasNext()) {
            int iIntValue = it2.next().intValue();
            float[] fArr = HIGHLIGHT_COLOR;
            pDPageContentStream.setNonStrokingColor(fArr[0], fArr[1], fArr[2]);
            pDPageContentStream.addRect(pDRectangleApplyPadding.getLowerLeftX(), (pDRectangleApplyPadding.getUpperRightY() - (((iIntValue - topIndex) + 1) * height)) + 2.0f, pDRectangleApplyPadding.getWidth(), height);
            pDPageContentStream.fill();
        }
        pDPageContentStream.setNonStrokingColor(0.0f);
    }

    private boolean isMultiLine() {
        PDVariableText pDVariableText = this.field;
        return (pDVariableText instanceof PDTextField) && ((PDTextField) pDVariableText).isMultiline();
    }

    private static boolean isValidAppearanceStream(PDAppearanceEntry pDAppearanceEntry) {
        PDRectangle bBox;
        return pDAppearanceEntry != null && pDAppearanceEntry.isStream() && (bBox = pDAppearanceEntry.getAppearanceStream().getBBox()) != null && Math.abs(bBox.getWidth()) > 0.0f && Math.abs(bBox.getHeight()) > 0.0f;
    }

    private PDAppearanceStream prepareNormalAppearanceStream(PDAnnotationWidget pDAnnotationWidget) {
        PDAppearanceStream pDAppearanceStream = new PDAppearanceStream(this.field.getAcroForm().getDocument());
        int iResolveRotation = resolveRotation(pDAnnotationWidget);
        PDRectangle rectangle = pDAnnotationWidget.getRectangle();
        PointF pointFTransformPoint = Matrix.getRotateInstance(Math.toRadians(iResolveRotation), 0.0f, 0.0f).transformPoint(rectangle.getWidth(), rectangle.getHeight());
        PDRectangle pDRectangle = new PDRectangle(Math.abs(pointFTransformPoint.x), Math.abs(pointFTransformPoint.y));
        pDAppearanceStream.setBBox(pDRectangle);
        AffineTransform affineTransformCalculateMatrix = calculateMatrix(pDRectangle, iResolveRotation);
        if (!affineTransformCalculateMatrix.isIdentity()) {
            pDAppearanceStream.setMatrix(affineTransformCalculateMatrix);
        }
        pDAppearanceStream.setFormType(1);
        pDAppearanceStream.setResources(new PDResources());
        return pDAppearanceStream;
    }

    private PDRectangle resolveBoundingBox(PDAnnotationWidget pDAnnotationWidget, PDAppearanceStream pDAppearanceStream) {
        PDRectangle bBox = pDAppearanceStream.getBBox();
        return bBox == null ? pDAnnotationWidget.getRectangle().createRetranslatedRectangle() : bBox;
    }

    private float resolveCapHeight(PDFont pDFont) throws IOException {
        return resolveGlyphHeight(pDFont, StandardStructureTypes.H.codePointAt(0));
    }

    private float resolveDescent(PDFont pDFont) throws IOException {
        return resolveGlyphHeight(pDFont, OperatorName.CURVE_TO_REPLICATE_FINAL_POINT.codePointAt(0)) - resolveGlyphHeight(pDFont, PDPageLabelRange.STYLE_LETTERS_LOWER.codePointAt(0));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private float resolveGlyphHeight(PDFont pDFont, int i2) throws IOException {
        Path path = null;
        if (pDFont instanceof PDType3Font) {
            PDType3Font pDType3Font = (PDType3Font) pDFont;
            PDType3CharProc charProc = pDType3Font.getCharProc(i2);
            if (charProc != null) {
                BoundingBox boundingBox = pDType3Font.getBoundingBox();
                PDRectangle glyphBBox = charProc.getGlyphBBox();
                if (glyphBBox != null) {
                    glyphBBox.setLowerLeftX(Math.max(boundingBox.getLowerLeftX(), glyphBBox.getLowerLeftX()));
                    glyphBBox.setLowerLeftY(Math.max(boundingBox.getLowerLeftY(), glyphBBox.getLowerLeftY()));
                    glyphBBox.setUpperRightX(Math.min(boundingBox.getUpperRightX(), glyphBBox.getUpperRightX()));
                    glyphBBox.setUpperRightY(Math.min(boundingBox.getUpperRightY(), glyphBBox.getUpperRightY()));
                    path = glyphBBox.toGeneralPath();
                }
            }
        } else if (pDFont instanceof PDVectorFont) {
            path = ((PDVectorFont) pDFont).getPath(i2);
        } else if (pDFont instanceof PDSimpleFont) {
            PDSimpleFont pDSimpleFont = (PDSimpleFont) pDFont;
            path = pDSimpleFont.getPath(pDSimpleFont.getEncoding().getName(i2));
        } else {
            Log.w("PdfBox-Android", "Unknown font class: " + pDFont.getClass());
        }
        if (path == null) {
            return -1.0f;
        }
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return rectF.height();
    }

    private int resolveRotation(PDAnnotationWidget pDAnnotationWidget) {
        PDAppearanceCharacteristicsDictionary appearanceCharacteristics = pDAnnotationWidget.getAppearanceCharacteristics();
        if (appearanceCharacteristics != null) {
            return appearanceCharacteristics.getRotation();
        }
        return 0;
    }

    private void setAppearanceContent(PDAnnotationWidget pDAnnotationWidget, PDAppearanceStream pDAppearanceStream) throws IOException {
        this.defaultAppearance.copyNeededResourcesTo(pDAppearanceStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ContentStreamWriter contentStreamWriter = new ContentStreamWriter(byteArrayOutputStream);
        List<Object> list = tokenize(pDAppearanceStream);
        Operator operator = BMC;
        int iIndexOf = list.indexOf(operator);
        if (iIndexOf == -1) {
            contentStreamWriter.writeTokens((List<?>) list);
            contentStreamWriter.writeTokens(COSName.TX, operator);
        } else {
            contentStreamWriter.writeTokens((List<?>) list.subList(0, iIndexOf + 1));
        }
        insertGeneratedAppearance(pDAnnotationWidget, pDAppearanceStream, byteArrayOutputStream);
        Operator operator2 = EMC;
        int iIndexOf2 = list.indexOf(operator2);
        if (iIndexOf2 == -1) {
            contentStreamWriter.writeTokens(operator2);
        } else {
            contentStreamWriter.writeTokens((List<?>) list.subList(iIndexOf2, list.size()));
        }
        byteArrayOutputStream.close();
        writeToStream(byteArrayOutputStream.toByteArray(), pDAppearanceStream);
    }

    private boolean shallComb() {
        PDVariableText pDVariableText = this.field;
        return (!(pDVariableText instanceof PDTextField) || !((PDTextField) pDVariableText).isComb() || ((PDTextField) this.field).isMultiline() || ((PDTextField) this.field).isPassword() || ((PDTextField) this.field).isFileSelect()) ? false : true;
    }

    private List<Object> tokenize(PDAppearanceStream pDAppearanceStream) throws IOException {
        PDFStreamParser pDFStreamParser = new PDFStreamParser(pDAppearanceStream);
        pDFStreamParser.parse();
        return pDFStreamParser.getTokens();
    }

    private void validateAndEnsureAcroFormResources() {
        PDResources resources;
        if (this.field.getAcroForm().getDefaultResources() == null) {
            return;
        }
        PDResources defaultResources = this.field.getAcroForm().getDefaultResources();
        Iterator<PDAnnotationWidget> it = this.field.getWidgets().iterator();
        while (it.hasNext()) {
            PDAppearanceStream normalAppearanceStream = it.next().getNormalAppearanceStream();
            if (normalAppearanceStream != null && (resources = normalAppearanceStream.getResources()) != null) {
                COSDictionary cOSObject = resources.getCOSObject();
                COSName cOSName = COSName.FONT;
                COSDictionary cOSDictionary = cOSObject.getCOSDictionary(cOSName);
                COSDictionary cOSDictionary2 = defaultResources.getCOSObject().getCOSDictionary(cOSName);
                for (COSName cOSName2 : resources.getFontNames()) {
                    try {
                        if (defaultResources.getFont(cOSName2) == null) {
                            Log.d("PdfBox-Android", "Adding font resource " + cOSName2 + " from widget to AcroForm");
                            cOSDictionary2.setItem(cOSName2, cOSDictionary.getItem(cOSName2));
                        }
                    } catch (IOException unused) {
                        Log.w("PdfBox-Android", "Unable to match field level font with AcroForm font");
                    }
                }
            }
        }
    }

    private void writeToStream(byte[] bArr, PDAppearanceStream pDAppearanceStream) throws IOException {
        OutputStream outputStreamCreateOutputStream = pDAppearanceStream.getCOSObject().createOutputStream();
        outputStreamCreateOutputStream.write(bArr);
        outputStreamCreateOutputStream.close();
    }

    public void setAppearanceValue(String str) throws IOException {
        PDAppearanceStream appearanceStream;
        this.value = getFormattedValue(str);
        PDVariableText pDVariableText = this.field;
        if ((pDVariableText instanceof PDTextField) && !((PDTextField) pDVariableText).isMultiline()) {
            this.value = this.value.replaceAll("\\u000D\\u000A|[\\u000A\\u000B\\u000C\\u000D\\u0085\\u2028\\u2029]", " ");
        }
        for (PDAnnotationWidget pDAnnotationWidget : this.field.getWidgets()) {
            if (pDAnnotationWidget.getCOSObject().containsKey("PMD")) {
                Log.w("PdfBox-Android", "widget of field " + this.field.getFullyQualifiedName() + " is a PaperMetaData widget, no appearance stream created");
            } else {
                PDDefaultAppearanceString pDDefaultAppearanceString = this.defaultAppearance;
                if (pDAnnotationWidget.getCOSObject().getDictionaryObject(COSName.DA) != null) {
                    this.defaultAppearance = getWidgetDefaultAppearanceString(pDAnnotationWidget);
                }
                if (pDAnnotationWidget.getRectangle() == null) {
                    pDAnnotationWidget.getCOSObject().removeItem(COSName.AP);
                    Log.w("PdfBox-Android", "widget of field " + this.field.getFullyQualifiedName() + " has no rectangle, no appearance stream created");
                } else {
                    PDAppearanceDictionary appearance = pDAnnotationWidget.getAppearance();
                    if (appearance == null) {
                        appearance = new PDAppearanceDictionary();
                        pDAnnotationWidget.setAppearance(appearance);
                    }
                    PDAppearanceEntry normalAppearance = appearance.getNormalAppearance();
                    if (isValidAppearanceStream(normalAppearance)) {
                        appearanceStream = normalAppearance.getAppearanceStream();
                    } else {
                        PDAppearanceStream pDAppearanceStreamPrepareNormalAppearanceStream = prepareNormalAppearanceStream(pDAnnotationWidget);
                        appearance.setNormalAppearance(pDAppearanceStreamPrepareNormalAppearanceStream);
                        appearanceStream = pDAppearanceStreamPrepareNormalAppearanceStream;
                    }
                    PDAppearanceCharacteristicsDictionary appearanceCharacteristics = pDAnnotationWidget.getAppearanceCharacteristics();
                    if (appearanceCharacteristics != null || appearanceStream.getContentStream().getLength() == 0) {
                        initializeAppearanceContent(pDAnnotationWidget, appearanceCharacteristics, appearanceStream);
                    }
                    setAppearanceContent(pDAnnotationWidget, appearanceStream);
                    this.defaultAppearance = pDDefaultAppearanceString;
                }
            }
        }
    }
}
