package com.tom_roush.pdfbox.pdmodel.interactive.form;

import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAppearanceEntry;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class PDCheckBox extends PDButton {
    public PDCheckBox(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
    }

    public void check() throws IOException {
        setValue(getOnValue());
    }

    public String getOnValue() {
        PDAppearanceEntry normalAppearance;
        PDAppearanceDictionary appearance = getWidgets().get(0).getAppearance();
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

    public boolean isChecked() {
        return getValue().compareTo(getOnValue()) == 0;
    }

    public void unCheck() throws IOException {
        setValue(COSName.Off.getName());
    }

    public PDCheckBox(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDNonTerminalField pDNonTerminalField) {
        super(pDAcroForm, cOSDictionary, pDNonTerminalField);
    }
}
