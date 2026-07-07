package com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers;

import android.util.Log;
import com.tom_roush.fontbox.util.Charsets;
import com.tom_roush.pdfbox.contentstream.operator.Operator;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.pdfparser.PDFStreamParser;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDColor;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceGray;
import com.tom_roush.pdfbox.pdmodel.graphics.color.PDDeviceRGB;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationMarkup;
import java.io.IOException;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public class PDFreeTextAppearanceHandler extends PDAbstractAppearanceHandler {
    private static final Pattern COLOR_PATTERN = Pattern.compile(".*color\\:\\s*\\#([0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F]).*");
    private COSName fontName;
    private float fontSize;

    public PDFreeTextAppearanceHandler(PDAnnotation pDAnnotation) {
        super(pDAnnotation);
        this.fontSize = 10.0f;
        this.fontName = COSName.HELV;
    }

    private void extractFontDetails(PDAnnotationMarkup pDAnnotationMarkup) {
        PDDocument pDDocument;
        String defaultAppearance = pDAnnotationMarkup.getDefaultAppearance();
        if (defaultAppearance == null && (pDDocument = this.document) != null && pDDocument.getDocumentCatalog().getAcroForm() != null) {
            defaultAppearance = this.document.getDocumentCatalog().getAcroForm().getDefaultAppearance();
        }
        if (defaultAppearance == null) {
            return;
        }
        try {
            PDFStreamParser pDFStreamParser = new PDFStreamParser(defaultAppearance.getBytes(Charsets.US_ASCII));
            COSArray cOSArray = new COSArray();
            COSArray cOSArray2 = new COSArray();
            while (true) {
                Object nextToken = pDFStreamParser.parseNextToken();
                if (nextToken == null) {
                    break;
                }
                if (nextToken instanceof Operator) {
                    if (!OperatorName.SET_FONT_AND_SIZE.equals(((Operator) nextToken).getName())) {
                        cOSArray = cOSArray2;
                    }
                    cOSArray2 = cOSArray;
                    cOSArray = new COSArray();
                } else {
                    cOSArray.add((COSBase) nextToken);
                }
            }
            if (cOSArray2.size() >= 2) {
                COSBase cOSBase = cOSArray2.get(0);
                if (cOSBase instanceof COSName) {
                    this.fontName = (COSName) cOSBase;
                }
                COSBase cOSBase2 = cOSArray2.get(1);
                if (cOSBase2 instanceof COSNumber) {
                    this.fontSize = ((COSNumber) cOSBase2).floatValue();
                }
            }
        } catch (IOException e2) {
            Log.w("PdfBox-Android", "Problem parsing /DA, will use default 'Helv 10'", e2);
        }
    }

    private PDColor extractNonStrokingColor(PDAnnotationMarkup pDAnnotationMarkup) {
        PDColor pDColor;
        PDColor pDColor2 = new PDColor(new float[]{0.0f}, PDDeviceGray.INSTANCE);
        String defaultAppearance = pDAnnotationMarkup.getDefaultAppearance();
        if (defaultAppearance == null) {
            return pDColor2;
        }
        try {
            PDFStreamParser pDFStreamParser = new PDFStreamParser(defaultAppearance.getBytes(Charsets.US_ASCII));
            COSArray cOSArray = new COSArray();
            Operator operator = null;
            COSArray cOSArray2 = null;
            for (Object nextToken = pDFStreamParser.parseNextToken(); nextToken != null; nextToken = pDFStreamParser.parseNextToken()) {
                if (nextToken instanceof Operator) {
                    Operator operator2 = (Operator) nextToken;
                    String name = operator2.getName();
                    if (OperatorName.NON_STROKING_GRAY.equals(name) || OperatorName.NON_STROKING_RGB.equals(name) || OperatorName.NON_STROKING_CMYK.equals(name)) {
                        operator = operator2;
                    } else {
                        cOSArray = cOSArray2;
                    }
                    cOSArray2 = cOSArray;
                    cOSArray = new COSArray();
                } else {
                    cOSArray.add((COSBase) nextToken);
                }
            }
            if (operator == null) {
                return pDColor2;
            }
            String name2 = operator.getName();
            if (OperatorName.NON_STROKING_GRAY.equals(name2)) {
                pDColor = new PDColor(cOSArray2, PDDeviceGray.INSTANCE);
            } else {
                if (!OperatorName.NON_STROKING_RGB.equals(name2)) {
                    OperatorName.NON_STROKING_CMYK.equals(name2);
                    return pDColor2;
                }
                pDColor = new PDColor(cOSArray2, PDDeviceRGB.INSTANCE);
            }
            return pDColor;
        } catch (IOException e2) {
            Log.w("PdfBox-Android", "Problem parsing /DA, will use default black", e2);
            return pDColor2;
        }
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0091  */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.Closeable] */
    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void generateNormalAppearance() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1071
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDFreeTextAppearanceHandler.generateNormalAppearance():void");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.annotation.handlers.PDAppearanceHandler
    public void generateRolloverAppearance() {
    }

    public PDFreeTextAppearanceHandler(PDAnnotation pDAnnotation, PDDocument pDDocument) {
        super(pDAnnotation, pDDocument);
        this.fontSize = 10.0f;
        this.fontName = COSName.HELV;
    }
}
