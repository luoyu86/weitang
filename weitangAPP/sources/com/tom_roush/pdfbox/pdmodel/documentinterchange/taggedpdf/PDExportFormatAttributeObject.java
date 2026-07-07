package com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf;

import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.pdmodel.documentinterchange.logicalstructure.PDAttributeObject;

/* JADX INFO: loaded from: classes2.dex */
public class PDExportFormatAttributeObject extends PDLayoutAttributeObject {
    public static final String OWNER_CSS_1_00 = "CSS-1.00";
    public static final String OWNER_CSS_2_00 = "CSS-2.00";
    public static final String OWNER_HTML_3_20 = "HTML-3.2";
    public static final String OWNER_HTML_4_01 = "HTML-4.01";
    public static final String OWNER_OEB_1_00 = "OEB-1.00";
    public static final String OWNER_RTF_1_05 = "RTF-1.05";
    public static final String OWNER_XML_1_00 = "XML-1.00";

    public PDExportFormatAttributeObject(String str) {
        setOwner(str);
    }

    public int getColSpan() {
        return getInteger(PDTableAttributeObject.COL_SPAN, 1);
    }

    public String[] getHeaders() {
        return getArrayOfString(PDTableAttributeObject.HEADERS);
    }

    public String getListNumbering() {
        return getName(PDListAttributeObject.LIST_NUMBERING, "None");
    }

    public int getRowSpan() {
        return getInteger(PDTableAttributeObject.ROW_SPAN, 1);
    }

    public String getScope() {
        return getName(PDTableAttributeObject.SCOPE);
    }

    public String getSummary() {
        return getString(PDTableAttributeObject.SUMMARY);
    }

    public void setColSpan(int i2) {
        setInteger(PDTableAttributeObject.COL_SPAN, i2);
    }

    public void setHeaders(String[] strArr) {
        setArrayOfString(PDTableAttributeObject.HEADERS, strArr);
    }

    public void setListNumbering(String str) {
        setName(PDListAttributeObject.LIST_NUMBERING, str);
    }

    public void setRowSpan(int i2) {
        setInteger(PDTableAttributeObject.ROW_SPAN, i2);
    }

    public void setScope(String str) {
        setName(PDTableAttributeObject.SCOPE, str);
    }

    public void setSummary(String str) {
        setString(PDTableAttributeObject.SUMMARY, str);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.documentinterchange.taggedpdf.PDLayoutAttributeObject, com.tom_roush.pdfbox.pdmodel.documentinterchange.logicalstructure.PDAttributeObject
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if (isSpecified(PDListAttributeObject.LIST_NUMBERING)) {
            sb.append(", ListNumbering=");
            sb.append(getListNumbering());
        }
        if (isSpecified(PDTableAttributeObject.ROW_SPAN)) {
            sb.append(", RowSpan=");
            sb.append(getRowSpan());
        }
        if (isSpecified(PDTableAttributeObject.COL_SPAN)) {
            sb.append(", ColSpan=");
            sb.append(getColSpan());
        }
        if (isSpecified(PDTableAttributeObject.HEADERS)) {
            sb.append(", Headers=");
            sb.append(PDAttributeObject.arrayToString(getHeaders()));
        }
        if (isSpecified(PDTableAttributeObject.SCOPE)) {
            sb.append(", Scope=");
            sb.append(getScope());
        }
        if (isSpecified(PDTableAttributeObject.SUMMARY)) {
            sb.append(", Summary=");
            sb.append(getSummary());
        }
        return sb.toString();
    }

    public PDExportFormatAttributeObject(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
