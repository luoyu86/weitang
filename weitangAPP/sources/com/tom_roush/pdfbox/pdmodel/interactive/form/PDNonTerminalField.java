package com.tom_roush.pdfbox.pdmodel.interactive.form;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.COSArrayList;
import com.tom_roush.pdfbox.pdmodel.fdf.FDFField;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PDNonTerminalField extends PDField {
    public PDNonTerminalField(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public FDFField exportFDF() throws IOException {
        FDFField fDFField = new FDFField();
        fDFField.setPartialFieldName(getPartialName());
        fDFField.setValue(getValue());
        List<PDField> children = getChildren();
        ArrayList arrayList = new ArrayList(children.size());
        Iterator<PDField> it = children.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().exportFDF());
        }
        fDFField.setKids(arrayList);
        return fDFField;
    }

    public List<PDField> getChildren() {
        ArrayList arrayList = new ArrayList();
        COSArray cOSArray = getCOSObject().getCOSArray(COSName.KIDS);
        if (cOSArray == null) {
            return arrayList;
        }
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            COSBase object = cOSArray.getObject(i2);
            if (object instanceof COSDictionary) {
                if (object.getCOSObject() == getCOSObject()) {
                    Log.w("PdfBox-Android", "Child field is same object as parent");
                } else {
                    PDField pDFieldFromDictionary = PDField.fromDictionary(getAcroForm(), (COSDictionary) object, this);
                    if (pDFieldFromDictionary != null) {
                        arrayList.add(pDFieldFromDictionary);
                    }
                }
            }
        }
        return arrayList;
    }

    public COSBase getDefaultValue() {
        return getCOSObject().getDictionaryObject(COSName.DV);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public int getFieldFlags() {
        COSInteger cOSInteger = (COSInteger) getCOSObject().getDictionaryObject(COSName.FF);
        if (cOSInteger != null) {
            return cOSInteger.intValue();
        }
        return 0;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public String getFieldType() {
        return getCOSObject().getNameAsString(COSName.FT);
    }

    public COSBase getValue() {
        return getCOSObject().getDictionaryObject(COSName.V);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public String getValueAsString() {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(COSName.V);
        return dictionaryObject != null ? dictionaryObject.toString() : "";
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public List<PDAnnotationWidget> getWidgets() {
        return Collections.emptyList();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public void importFDF(FDFField fDFField) throws IOException {
        super.importFDF(fDFField);
        List<FDFField> kids = fDFField.getKids();
        List<PDField> children = getChildren();
        if (kids == null) {
            return;
        }
        for (int i2 = 0; i2 < kids.size(); i2++) {
            for (PDField pDField : children) {
                FDFField fDFField2 = kids.get(i2);
                String partialFieldName = fDFField2.getPartialFieldName();
                if (partialFieldName != null && partialFieldName.equals(pDField.getPartialName())) {
                    pDField.importFDF(fDFField2);
                }
            }
        }
    }

    public void setChildren(List<PDField> list) {
        getCOSObject().setItem(COSName.KIDS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setDefaultValue(COSBase cOSBase) {
        getCOSObject().setItem(COSName.V, cOSBase);
    }

    public void setValue(COSBase cOSBase) throws IOException {
        getCOSObject().setItem(COSName.V, cOSBase);
    }

    public PDNonTerminalField(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDNonTerminalField pDNonTerminalField) {
        super(pDAcroForm, cOSDictionary, pDNonTerminalField);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public void setValue(String str) throws IOException {
        getCOSObject().setString(COSName.V, str);
    }
}
