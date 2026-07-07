package com.tom_roush.pdfbox.pdmodel.fixup.processor;

import android.util.Log;
import com.tom_roush.fontbox.ttf.TrueTypeFont;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.PDPage;
import com.tom_roush.pdfbox.pdmodel.PDResources;
import com.tom_roush.pdfbox.pdmodel.font.FontMappers;
import com.tom_roush.pdfbox.pdmodel.font.FontMapping;
import com.tom_roush.pdfbox.pdmodel.font.PDType0Font;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import com.tom_roush.pdfbox.pdmodel.interactive.form.PDAcroForm;
import com.tom_roush.pdfbox.pdmodel.interactive.form.PDField;
import com.tom_roush.pdfbox.pdmodel.interactive.form.PDFieldFactory;
import com.tom_roush.pdfbox.pdmodel.interactive.form.PDVariableText;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AcroFormOrphanWidgetsProcessor extends AbstractProcessor {
    public AcroFormOrphanWidgetsProcessor(PDDocument pDDocument) {
        super(pDDocument);
    }

    private void addFontFromWidget(PDResources pDResources, PDAnnotation pDAnnotation) {
        PDAppearanceStream normalAppearanceStream = pDAnnotation.getNormalAppearanceStream();
        if (normalAppearanceStream == null || normalAppearanceStream.getResources() == null) {
            return;
        }
        PDResources resources = normalAppearanceStream.getResources();
        for (COSName cOSName : resources.getFontNames()) {
            if (cOSName.getName().startsWith("+")) {
                Log.d("PdfBox-Android", "font resource for widget was a subsetted font - ignored: " + cOSName.getName());
            } else {
                try {
                    if (pDResources.getFont(cOSName) == null) {
                        pDResources.put(cOSName, resources.getFont(cOSName));
                        Log.d("PdfBox-Android", "qdded font resource to AcroForm from widget for font name " + cOSName.getName());
                    }
                } catch (IOException unused) {
                    Log.d("PdfBox-Android", "unable to add font to AcroForm for font name " + cOSName.getName());
                }
            }
        }
    }

    private void ensureFontResources(PDResources pDResources, PDVariableText pDVariableText) {
        String defaultAppearance = pDVariableText.getDefaultAppearance();
        if (!defaultAppearance.startsWith("/") || defaultAppearance.length() <= 1) {
            return;
        }
        COSName pDFName = COSName.getPDFName(defaultAppearance.substring(1, defaultAppearance.indexOf(" ")));
        if (pDResources != null) {
            try {
                if (pDResources.getFont(pDFName) == null) {
                    Log.d("PdfBox-Android", "trying to add missing font resource for field " + pDVariableText.getFullyQualifiedName());
                    FontMapping<TrueTypeFont> trueTypeFont = FontMappers.instance().getTrueTypeFont(pDFName.getName(), null);
                    if (trueTypeFont != null) {
                        PDType0Font pDType0FontLoad = PDType0Font.load(this.document, (TrueTypeFont) trueTypeFont.getFont(), false);
                        Log.d("PdfBox-Android", "looked up font for " + pDFName.getName() + " - found " + ((TrueTypeFont) trueTypeFont.getFont()).getName());
                        pDResources.put(pDFName, pDType0FontLoad);
                    } else {
                        Log.d("PdfBox-Android", "no suitable font found for field " + pDVariableText.getFullyQualifiedName() + " for font name " + pDFName.getName());
                    }
                }
            } catch (IOException e2) {
                Log.d("PdfBox-Android", "Unable to handle font resources for field " + pDVariableText.getFullyQualifiedName() + ": " + e2.getMessage());
            }
        }
    }

    private void handleAnnotations(PDAcroForm pDAcroForm, List<PDField> list, List<PDAnnotation> list2, Map<String, PDField> map) {
        PDResources defaultResources = pDAcroForm.getDefaultResources();
        for (PDAnnotation pDAnnotation : list2) {
            if (pDAnnotation instanceof PDAnnotationWidget) {
                addFontFromWidget(defaultResources, pDAnnotation);
                if (pDAnnotation.getCOSObject().getCOSDictionary(COSName.PARENT) != null) {
                    PDField pDFieldResolveNonRootField = resolveNonRootField(pDAcroForm, (PDAnnotationWidget) pDAnnotation, map);
                    if (pDFieldResolveNonRootField != null) {
                        list.add(pDFieldResolveNonRootField);
                    }
                } else {
                    list.add(PDFieldFactory.createField(pDAcroForm, pDAnnotation.getCOSObject(), null));
                }
            }
        }
    }

    private void resolveFieldsFromWidgets(PDAcroForm pDAcroForm) {
        HashMap map = new HashMap();
        Log.d("PdfBox-Android", "rebuilding fields from widgets");
        ArrayList arrayList = new ArrayList();
        Iterator<PDPage> it = this.document.getPages().iterator();
        while (it.hasNext()) {
            try {
                handleAnnotations(pDAcroForm, arrayList, it.next().getAnnotations(), map);
            } catch (IOException e2) {
                Log.d("PdfBox-Android", "couldn't read annotations for page " + e2.getMessage());
            }
        }
        pDAcroForm.setFields(arrayList);
        for (PDField pDField : pDAcroForm.getFieldTree()) {
            if (pDField instanceof PDVariableText) {
                ensureFontResources(pDAcroForm.getDefaultResources(), (PDVariableText) pDField);
            }
        }
    }

    private PDField resolveNonRootField(PDAcroForm pDAcroForm, PDAnnotationWidget pDAnnotationWidget, Map<String, PDField> map) {
        COSDictionary cOSDictionary = pDAnnotationWidget.getCOSObject().getCOSDictionary(COSName.PARENT);
        do {
            COSName cOSName = COSName.PARENT;
            if (!cOSDictionary.containsKey(cOSName)) {
                if (map.get(cOSDictionary.getString(COSName.T)) != null) {
                    return null;
                }
                PDField pDFieldCreateField = PDFieldFactory.createField(pDAcroForm, cOSDictionary, null);
                if (pDFieldCreateField != null) {
                    map.put(pDFieldCreateField.getFullyQualifiedName(), pDFieldCreateField);
                }
                return pDFieldCreateField;
            }
            cOSDictionary = cOSDictionary.getCOSDictionary(cOSName);
        } while (cOSDictionary != null);
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.fixup.processor.PDDocumentProcessor
    public void process() {
        PDAcroForm acroForm = this.document.getDocumentCatalog().getAcroForm(null);
        if (acroForm != null) {
            resolveFieldsFromWidgets(acroForm);
        }
    }
}
