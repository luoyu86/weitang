package com.tom_roush.pdfbox.pdmodel.interactive.form;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.COSArrayList;
import com.tom_roush.pdfbox.pdmodel.fdf.FDFField;
import com.tom_roush.pdfbox.pdmodel.interactive.action.PDFormFieldAdditionalActions;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDTerminalField extends PDField {
    public PDTerminalField(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
    }

    public final void applyChange() throws IOException {
        if (getAcroForm().getNeedAppearances()) {
            return;
        }
        constructAppearances();
    }

    public abstract void constructAppearances() throws IOException;

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public FDFField exportFDF() throws IOException {
        FDFField fDFField = new FDFField();
        fDFField.setPartialFieldName(getPartialName());
        fDFField.setValue(getCOSObject().getDictionaryObject(COSName.V));
        return fDFField;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public int getFieldFlags() {
        COSInteger cOSInteger = (COSInteger) getCOSObject().getDictionaryObject(COSName.FF);
        if (cOSInteger != null) {
            return cOSInteger.intValue();
        }
        if (getParent() != null) {
            return getParent().getFieldFlags();
        }
        return 0;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public String getFieldType() {
        String nameAsString = getCOSObject().getNameAsString(COSName.FT);
        return (nameAsString != null || getParent() == null) ? nameAsString : getParent().getFieldType();
    }

    @Deprecated
    public PDAnnotationWidget getWidget() {
        return getWidgets().get(0);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public List<PDAnnotationWidget> getWidgets() {
        ArrayList arrayList = new ArrayList();
        COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject(COSName.KIDS);
        if (cOSArray == null) {
            arrayList.add(new PDAnnotationWidget(getCOSObject()));
        } else if (cOSArray.size() > 0) {
            for (int i2 = 0; i2 < cOSArray.size(); i2++) {
                COSBase object = cOSArray.getObject(i2);
                if (object instanceof COSDictionary) {
                    arrayList.add(new PDAnnotationWidget((COSDictionary) object));
                }
            }
        }
        return arrayList;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public void importFDF(FDFField fDFField) throws IOException {
        super.importFDF(fDFField);
        PDAnnotationWidget pDAnnotationWidget = getWidgets().get(0);
        if (pDAnnotationWidget != null) {
            int annotationFlags = pDAnnotationWidget.getAnnotationFlags();
            Integer widgetFieldFlags = fDFField.getWidgetFieldFlags();
            if (widgetFieldFlags != null) {
                pDAnnotationWidget.setAnnotationFlags(widgetFieldFlags.intValue());
                return;
            }
            Integer setWidgetFieldFlags = fDFField.getSetWidgetFieldFlags();
            if (setWidgetFieldFlags != null) {
                annotationFlags |= setWidgetFieldFlags.intValue();
                pDAnnotationWidget.setAnnotationFlags(annotationFlags);
            }
            Integer clearWidgetFieldFlags = fDFField.getClearWidgetFieldFlags();
            if (clearWidgetFieldFlags != null) {
                pDAnnotationWidget.setAnnotationFlags(((int) (((long) clearWidgetFieldFlags.intValue()) ^ UIDFolder.MAXUID)) & annotationFlags);
            }
        }
    }

    public void setActions(PDFormFieldAdditionalActions pDFormFieldAdditionalActions) {
        getCOSObject().setItem(COSName.AA, pDFormFieldAdditionalActions);
    }

    public void setWidgets(List<PDAnnotationWidget> list) {
        getCOSObject().setItem(COSName.KIDS, (COSBase) COSArrayList.converterToCOSArray(list));
        Iterator<PDAnnotationWidget> it = list.iterator();
        while (it.hasNext()) {
            it.next().getCOSObject().setItem(COSName.PARENT, this);
        }
    }

    public PDTerminalField(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDNonTerminalField pDNonTerminalField) {
        super(pDAcroForm, cOSDictionary, pDNonTerminalField);
    }
}
