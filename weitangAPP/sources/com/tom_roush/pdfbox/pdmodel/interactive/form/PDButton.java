package com.tom_roush.pdfbox.pdmodel.interactive.form;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.pdmodel.common.COSArrayList;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDButton extends PDTerminalField {
    public static final int FLAG_PUSHBUTTON = 65536;
    public static final int FLAG_RADIO = 32768;
    public static final int FLAG_RADIOS_IN_UNISON = 33554432;

    public PDButton(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
        getCOSObject().setItem(COSName.FT, (COSBase) COSName.BTN);
    }

    private String getOnValue(int i2) {
        List<PDAnnotationWidget> widgets = getWidgets();
        return i2 < widgets.size() ? getOnValueForWidget(widgets.get(i2)) : "";
    }

    private String getOnValueForWidget(PDAnnotationWidget pDAnnotationWidget) {
        PDAppearanceEntry normalAppearance;
        PDAppearanceDictionary appearance = pDAnnotationWidget.getAppearance();
        if (appearance == null || (normalAppearance = appearance.getNormalAppearance()) == null) {
            return "";
        }
        for (COSName cOSName : normalAppearance.getSubDictionary().keySet()) {
            if (COSName.Off.compareTo(cOSName) != 0) {
                return cOSName.getName();
            }
        }
        return "";
    }

    private void updateByOption(String str) throws IOException {
        List<PDAnnotationWidget> widgets = getWidgets();
        List<String> exportValues = getExportValues();
        if (widgets.size() != exportValues.size()) {
            throw new IllegalArgumentException("The number of options doesn't match the number of widgets");
        }
        if (str.equals(COSName.Off.getName())) {
            updateByValue(str);
            return;
        }
        int iIndexOf = exportValues.indexOf(str);
        if (iIndexOf != -1) {
            updateByValue(getOnValue(iIndexOf));
        }
    }

    private void updateByValue(String str) throws IOException {
        getCOSObject().setName(COSName.V, str);
        for (PDAnnotationWidget pDAnnotationWidget : getWidgets()) {
            if (pDAnnotationWidget.getAppearance() != null) {
                if (((COSDictionary) pDAnnotationWidget.getAppearance().getNormalAppearance().getCOSObject()).containsKey(str)) {
                    pDAnnotationWidget.setAppearanceState(str);
                } else {
                    pDAnnotationWidget.setAppearanceState(COSName.Off.getName());
                }
            }
        }
    }

    public void checkValue(String str) {
        Set<String> onValues = getOnValues();
        COSName cOSName = COSName.Off;
        if (cOSName.getName().compareTo(str) == 0 || onValues.contains(str)) {
            return;
        }
        throw new IllegalArgumentException("value '" + str + "' is not a valid option for the field " + getFullyQualifiedName() + ", valid values are: " + onValues + " and " + cOSName.getName());
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDTerminalField
    public void constructAppearances() throws IOException {
        List<String> exportValues = getExportValues();
        if (exportValues.size() <= 0) {
            updateByValue(getValue());
            return;
        }
        try {
            int i2 = Integer.parseInt(getValue());
            if (i2 < exportValues.size()) {
                updateByOption(exportValues.get(i2));
            }
        } catch (NumberFormatException unused) {
        }
    }

    public String getDefaultValue() {
        COSBase inheritableAttribute = getInheritableAttribute(COSName.DV);
        return inheritableAttribute instanceof COSName ? ((COSName) inheritableAttribute).getName() : "";
    }

    public List<String> getExportValues() {
        COSBase inheritableAttribute = getInheritableAttribute(COSName.OPT);
        if (!(inheritableAttribute instanceof COSString)) {
            return inheritableAttribute instanceof COSArray ? COSArrayList.convertCOSStringCOSArrayToList((COSArray) inheritableAttribute) : Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(((COSString) inheritableAttribute).getString());
        return arrayList;
    }

    public Set<String> getOnValues() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (getExportValues().size() > 0) {
            linkedHashSet.addAll(getExportValues());
            return linkedHashSet;
        }
        Iterator<PDAnnotationWidget> it = getWidgets().iterator();
        while (it.hasNext()) {
            linkedHashSet.add(getOnValueForWidget(it.next()));
        }
        return linkedHashSet;
    }

    public String getValue() {
        COSBase inheritableAttribute = getInheritableAttribute(COSName.V);
        if (!(inheritableAttribute instanceof COSName)) {
            return "Off";
        }
        String name = ((COSName) inheritableAttribute).getName();
        List<String> exportValues = getExportValues();
        if (!exportValues.isEmpty()) {
            try {
                int i2 = Integer.parseInt(name, 10);
                if (i2 >= 0 && i2 < exportValues.size()) {
                    return exportValues.get(i2);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return name;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public String getValueAsString() {
        return getValue();
    }

    public boolean isPushButton() {
        return getCOSObject().getFlag(COSName.FF, 65536);
    }

    public boolean isRadioButton() {
        return getCOSObject().getFlag(COSName.FF, 32768);
    }

    public void setDefaultValue(String str) {
        checkValue(str);
        getCOSObject().setName(COSName.DV, str);
    }

    public void setExportValues(List<String> list) {
        if (list == null || list.isEmpty()) {
            getCOSObject().removeItem(COSName.OPT);
        } else {
            getCOSObject().setItem(COSName.OPT, (COSBase) COSArrayList.convertStringListToCOSStringCOSArray(list));
        }
    }

    @Deprecated
    public void setPushButton(boolean z) {
        getCOSObject().setFlag(COSName.FF, 65536, z);
        if (z) {
            setRadioButton(false);
        }
    }

    @Deprecated
    public void setRadioButton(boolean z) {
        getCOSObject().setFlag(COSName.FF, 32768, z);
        if (z) {
            setPushButton(false);
        }
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public void setValue(String str) throws IOException {
        checkValue(str);
        if (getExportValues().size() > 0) {
            updateByOption(str);
        } else {
            updateByValue(str);
        }
        applyChange();
    }

    public PDButton(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDNonTerminalField pDNonTerminalField) {
        super(pDAcroForm, cOSDictionary, pDNonTerminalField);
    }

    public void setValue(int i2) throws IOException {
        if (!getExportValues().isEmpty() && i2 >= 0 && i2 < getExportValues().size()) {
            updateByValue(String.valueOf(i2));
            applyChange();
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("index '");
        sb.append(i2);
        sb.append("' is not a valid index for the field ");
        sb.append(getFullyQualifiedName());
        sb.append(", valid indices are from 0 to ");
        sb.append(getExportValues().size() - 1);
        throw new IllegalArgumentException(sb.toString());
    }
}
