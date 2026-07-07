package com.tom_roush.pdfbox.pdmodel.interactive.form;

import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.pdmodel.PDDocument;
import com.tom_roush.pdfbox.pdmodel.PDPage;
import com.tom_roush.pdfbox.pdmodel.PDPageContentStream;
import com.tom_roush.pdfbox.pdmodel.PDResources;
import com.tom_roush.pdfbox.pdmodel.common.COSArrayList;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import com.tom_roush.pdfbox.pdmodel.common.PDRectangle;
import com.tom_roush.pdfbox.pdmodel.fdf.FDFCatalog;
import com.tom_roush.pdfbox.pdmodel.fdf.FDFDictionary;
import com.tom_roush.pdfbox.pdmodel.fdf.FDFDocument;
import com.tom_roush.pdfbox.pdmodel.fdf.FDFField;
import com.tom_roush.pdfbox.pdmodel.graphics.form.PDFormXObject;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotation;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import com.tom_roush.pdfbox.util.Matrix;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class PDAcroForm implements COSObjectable {
    private static final int FLAG_APPEND_ONLY = 2;
    private static final int FLAG_SIGNATURES_EXIST = 1;
    private final COSDictionary dictionary;
    private final PDDocument document;
    private Map<String, PDField> fieldCache;
    private ScriptingHandler scriptingHandler;

    public PDAcroForm(PDDocument pDDocument) {
        this.document = pDDocument;
        COSDictionary cOSDictionary = new COSDictionary();
        this.dictionary = cOSDictionary;
        cOSDictionary.setItem(COSName.FIELDS, (COSBase) new COSArray());
    }

    private Map<COSDictionary, Set<COSDictionary>> buildPagesWidgetsMap(List<PDField> list) throws IOException {
        HashMap map = new HashMap();
        Iterator<PDField> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            for (PDAnnotationWidget pDAnnotationWidget : it.next().getWidgets()) {
                PDPage page = pDAnnotationWidget.getPage();
                if (page != null) {
                    fillPagesAnnotationMap(map, page, pDAnnotationWidget);
                } else {
                    z = true;
                }
            }
        }
        if (!z) {
            return map;
        }
        Log.w("PdfBox-Android", "There has been a widget with a missing page reference, will check all page annotations");
        for (PDPage pDPage : this.document.getPages()) {
            for (PDAnnotation pDAnnotation : pDPage.getAnnotations()) {
                if (pDAnnotation instanceof PDAnnotationWidget) {
                    fillPagesAnnotationMap(map, pDPage, (PDAnnotationWidget) pDAnnotation);
                }
            }
        }
        return map;
    }

    private void fillPagesAnnotationMap(Map<COSDictionary, Set<COSDictionary>> map, PDPage pDPage, PDAnnotationWidget pDAnnotationWidget) {
        if (map.get(pDPage.getCOSObject()) != null) {
            map.get(pDPage.getCOSObject()).add(pDAnnotationWidget.getCOSObject());
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(pDAnnotationWidget.getCOSObject());
        map.put(pDPage.getCOSObject(), hashSet);
    }

    private RectF getTransformedAppearanceBBox(PDAppearanceStream pDAppearanceStream) {
        Path pathTransform = pDAppearanceStream.getBBox().transform(pDAppearanceStream.getMatrix());
        RectF rectF = new RectF();
        pathTransform.computeBounds(rectF, true);
        return rectF;
    }

    private boolean isVisibleAnnotation(PDAnnotation pDAnnotation) {
        PDAppearanceStream normalAppearanceStream;
        PDRectangle bBox;
        return (pDAnnotation.isInvisible() || pDAnnotation.isHidden() || (normalAppearanceStream = pDAnnotation.getNormalAppearanceStream()) == null || (bBox = normalAppearanceStream.getBBox()) == null || bBox.getWidth() <= 0.0f || bBox.getHeight() <= 0.0f) ? false : true;
    }

    private void removeFields(List<PDField> list) {
        for (PDField pDField : list) {
            ((COSArray) (pDField.getParent() == null ? this.dictionary.getDictionaryObject(COSName.FIELDS) : pDField.getParent().getCOSObject().getDictionaryObject(COSName.KIDS))).removeObject(pDField.getCOSObject());
        }
    }

    private Matrix resolveTransformationMatrix(PDAnnotation pDAnnotation, PDAppearanceStream pDAppearanceStream) {
        RectF transformedAppearanceBBox = getTransformedAppearanceBBox(pDAppearanceStream);
        PDRectangle rectangle = pDAnnotation.getRectangle();
        Matrix matrix = new Matrix();
        matrix.translate(rectangle.getLowerLeftX() - transformedAppearanceBBox.left, rectangle.getLowerLeftY() - transformedAppearanceBBox.top);
        matrix.scale(rectangle.getWidth() / transformedAppearanceBBox.width(), rectangle.getHeight() / transformedAppearanceBBox.height());
        return matrix;
    }

    public FDFDocument exportFDF() throws IOException {
        FDFDocument fDFDocument = new FDFDocument();
        FDFCatalog catalog = fDFDocument.getCatalog();
        FDFDictionary fDFDictionary = new FDFDictionary();
        catalog.setFDF(fDFDictionary);
        ArrayList arrayList = new ArrayList();
        Iterator<PDField> it = getFields().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().exportFDF());
        }
        fDFDictionary.setID(this.document.getDocument().getDocumentID());
        if (!arrayList.isEmpty()) {
            fDFDictionary.setFields(arrayList);
        }
        return fDFDocument;
    }

    public void flatten() throws IOException {
        if (xfaIsDynamic()) {
            Log.w("PdfBox-Android", "Flatten for a dynamix XFA form is not supported");
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<PDField> it = getFieldTree().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        flatten(arrayList, false);
    }

    public String getDefaultAppearance() {
        return this.dictionary.getString(COSName.DA, "");
    }

    public PDResources getDefaultResources() {
        COSBase dictionaryObject = this.dictionary.getDictionaryObject(COSName.DR);
        if (dictionaryObject instanceof COSDictionary) {
            return new PDResources((COSDictionary) dictionaryObject, this.document.getResourceCache());
        }
        return null;
    }

    public PDDocument getDocument() {
        return this.document;
    }

    public PDField getField(String str) {
        Map<String, PDField> map = this.fieldCache;
        if (map != null) {
            return map.get(str);
        }
        for (PDField pDField : getFieldTree()) {
            if (pDField.getFullyQualifiedName().equals(str)) {
                return pDField;
            }
        }
        return null;
    }

    public Iterator<PDField> getFieldIterator() {
        return new PDFieldTree(this).iterator();
    }

    public PDFieldTree getFieldTree() {
        return new PDFieldTree(this);
    }

    public List<PDField> getFields() {
        PDField pDFieldFromDictionary;
        COSArray cOSArray = this.dictionary.getCOSArray(COSName.FIELDS);
        if (cOSArray == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            COSDictionary cOSDictionary = (COSDictionary) cOSArray.getObject(i2);
            if (cOSDictionary != null && (pDFieldFromDictionary = PDField.fromDictionary(this, cOSDictionary, null)) != null) {
                arrayList.add(pDFieldFromDictionary);
            }
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public boolean getNeedAppearances() {
        return this.dictionary.getBoolean(COSName.NEED_APPEARANCES, false);
    }

    public int getQ() {
        COSNumber cOSNumber = (COSNumber) this.dictionary.getDictionaryObject(COSName.Q);
        if (cOSNumber != null) {
            return cOSNumber.intValue();
        }
        return 0;
    }

    public ScriptingHandler getScriptingHandler() {
        return this.scriptingHandler;
    }

    public PDXFAResource getXFA() {
        COSBase dictionaryObject = this.dictionary.getDictionaryObject(COSName.XFA);
        if (dictionaryObject != null) {
            return new PDXFAResource(dictionaryObject);
        }
        return null;
    }

    public boolean hasXFA() {
        return this.dictionary.containsKey(COSName.XFA);
    }

    public void importFDF(FDFDocument fDFDocument) throws IOException {
        List<FDFField> fields = fDFDocument.getCatalog().getFDF().getFields();
        if (fields != null) {
            for (FDFField fDFField : fields) {
                PDField field = getField(fDFField.getPartialFieldName());
                if (field != null) {
                    field.importFDF(fDFField);
                }
            }
        }
    }

    public boolean isAppendOnly() {
        return this.dictionary.getFlag(COSName.SIG_FLAGS, 2);
    }

    public boolean isCachingFields() {
        return this.fieldCache != null;
    }

    public boolean isSignaturesExist() {
        return this.dictionary.getFlag(COSName.SIG_FLAGS, 1);
    }

    public void refreshAppearances() throws IOException {
        for (PDField pDField : getFieldTree()) {
            if (pDField instanceof PDTerminalField) {
                ((PDTerminalField) pDField).constructAppearances();
            }
        }
    }

    public void setAppendOnly(boolean z) {
        this.dictionary.setFlag(COSName.SIG_FLAGS, 2, z);
    }

    public void setCacheFields(boolean z) {
        if (!z) {
            this.fieldCache = null;
            return;
        }
        this.fieldCache = new HashMap();
        for (PDField pDField : getFieldTree()) {
            this.fieldCache.put(pDField.getFullyQualifiedName(), pDField);
        }
    }

    public void setDefaultAppearance(String str) {
        this.dictionary.setString(COSName.DA, str);
    }

    public void setDefaultResources(PDResources pDResources) {
        this.dictionary.setItem(COSName.DR, pDResources);
    }

    public void setFields(List<PDField> list) {
        this.dictionary.setItem(COSName.FIELDS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setNeedAppearances(Boolean bool) {
        this.dictionary.setBoolean(COSName.NEED_APPEARANCES, bool.booleanValue());
    }

    public void setQ(int i2) {
        this.dictionary.setInt(COSName.Q, i2);
    }

    public void setScriptingHandler(ScriptingHandler scriptingHandler) {
        this.scriptingHandler = scriptingHandler;
    }

    public void setSignaturesExist(boolean z) {
        this.dictionary.setFlag(COSName.SIG_FLAGS, 1, z);
    }

    public void setXFA(PDXFAResource pDXFAResource) {
        this.dictionary.setItem(COSName.XFA, pDXFAResource);
    }

    public boolean xfaIsDynamic() {
        return hasXFA() && getFields().isEmpty();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.dictionary;
    }

    public void refreshAppearances(List<PDField> list) throws IOException {
        for (PDField pDField : list) {
            if (pDField instanceof PDTerminalField) {
                ((PDTerminalField) pDField).constructAppearances();
            }
        }
    }

    public PDAcroForm(PDDocument pDDocument, COSDictionary cOSDictionary) {
        this.document = pDDocument;
        this.dictionary = cOSDictionary;
    }

    public void flatten(List<PDField> list, boolean z) throws IOException {
        if (list.isEmpty()) {
            return;
        }
        if (!z && getNeedAppearances()) {
            Log.w("PdfBox-Android", "acroForm.getNeedAppearances() returns true, visual field appearances may not have been set");
            Log.w("PdfBox-Android", "call acroForm.refreshAppearances() or use the flatten() method with refreshAppearances parameter");
        }
        if (xfaIsDynamic()) {
            Log.w("PdfBox-Android", "Flatten for a dynamix XFA form is not supported");
            return;
        }
        if (z) {
            refreshAppearances(list);
        }
        Map<COSDictionary, Set<COSDictionary>> mapBuildPagesWidgetsMap = buildPagesWidgetsMap(list);
        for (PDPage pDPage : this.document.getPages()) {
            Set<COSDictionary> set = mapBuildPagesWidgetsMap.get(pDPage.getCOSObject());
            boolean z2 = false;
            ArrayList arrayList = new ArrayList();
            for (PDAnnotation pDAnnotation : pDPage.getAnnotations()) {
                if (set != null && set.contains(pDAnnotation.getCOSObject())) {
                    if (isVisibleAnnotation(pDAnnotation)) {
                        PDPageContentStream pDPageContentStream = new PDPageContentStream(this.document, pDPage, PDPageContentStream.AppendMode.APPEND, true, !z2);
                        try {
                            PDAppearanceStream normalAppearanceStream = pDAnnotation.getNormalAppearanceStream();
                            PDFormXObject pDFormXObject = new PDFormXObject(normalAppearanceStream.getCOSObject());
                            pDPageContentStream.saveGraphicsState();
                            pDPageContentStream.transform(resolveTransformationMatrix(pDAnnotation, normalAppearanceStream));
                            pDPageContentStream.drawForm(pDFormXObject);
                            pDPageContentStream.restoreGraphicsState();
                            pDPageContentStream.close();
                            z2 = true;
                        } catch (Throwable th) {
                            pDPageContentStream.close();
                            throw th;
                        }
                    } else {
                        continue;
                    }
                } else {
                    arrayList.add(pDAnnotation);
                }
            }
            pDPage.setAnnotations(arrayList);
        }
        removeFields(list);
        this.dictionary.removeItem(COSName.XFA);
    }
}
