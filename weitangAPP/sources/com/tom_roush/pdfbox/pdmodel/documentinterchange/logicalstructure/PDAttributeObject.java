package com.tom_roush.pdfbox.pdmodel.documentinterchange.logicalstructure;

import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.PDDictionaryWrapper;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDExportFormatAttributeObject;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDLayoutAttributeObject;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDListAttributeObject;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDPrintFieldAttributeObject;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDTableAttributeObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDAttributeObject extends PDDictionaryWrapper {
    private PDStructureElement structureElement;

    public PDAttributeObject() {
    }

    public static String arrayToString(Object[] objArr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(objArr[i2]);
        }
        sb.append(']');
        return sb.toString();
    }

    public static PDAttributeObject create(COSDictionary cOSDictionary) {
        String nameAsString = cOSDictionary.getNameAsString(COSName.O);
        return PDUserAttributeObject.OWNER_USER_PROPERTIES.equals(nameAsString) ? new PDUserAttributeObject(cOSDictionary) : PDListAttributeObject.OWNER_LIST.equals(nameAsString) ? new PDListAttributeObject(cOSDictionary) : PDPrintFieldAttributeObject.OWNER_PRINT_FIELD.equals(nameAsString) ? new PDPrintFieldAttributeObject(cOSDictionary) : "Table".equals(nameAsString) ? new PDTableAttributeObject(cOSDictionary) : PDLayoutAttributeObject.OWNER_LAYOUT.equals(nameAsString) ? new PDLayoutAttributeObject(cOSDictionary) : (PDExportFormatAttributeObject.OWNER_XML_1_00.equals(nameAsString) || PDExportFormatAttributeObject.OWNER_HTML_3_20.equals(nameAsString) || PDExportFormatAttributeObject.OWNER_HTML_4_01.equals(nameAsString) || PDExportFormatAttributeObject.OWNER_OEB_1_00.equals(nameAsString) || PDExportFormatAttributeObject.OWNER_RTF_1_05.equals(nameAsString) || PDExportFormatAttributeObject.OWNER_CSS_1_00.equals(nameAsString) || PDExportFormatAttributeObject.OWNER_CSS_2_00.equals(nameAsString)) ? new PDExportFormatAttributeObject(cOSDictionary) : new PDDefaultAttributeObject(cOSDictionary);
    }

    private PDStructureElement getStructureElement() {
        return this.structureElement;
    }

    private boolean isValueChanged(COSBase cOSBase, COSBase cOSBase2) {
        return cOSBase == null ? cOSBase2 != null : !cOSBase.equals(cOSBase2);
    }

    public String getOwner() {
        return getCOSObject().getNameAsString(COSName.O);
    }

    public boolean isEmpty() {
        return getCOSObject().size() == 1 && getOwner() != null;
    }

    public void notifyChanged() {
        if (getStructureElement() != null) {
            getStructureElement().attributeChanged(this);
        }
    }

    public void potentiallyNotifyChanged(COSBase cOSBase, COSBase cOSBase2) {
        if (isValueChanged(cOSBase, cOSBase2)) {
            notifyChanged();
        }
    }

    public void setOwner(String str) {
        getCOSObject().setName(COSName.O, str);
    }

    public void setStructureElement(PDStructureElement pDStructureElement) {
        this.structureElement = pDStructureElement;
    }

    public String toString() {
        return "O=" + getOwner();
    }

    public PDAttributeObject(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }

    public static String arrayToString(float[] fArr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(fArr[i2]);
        }
        sb.append(']');
        return sb.toString();
    }
}
