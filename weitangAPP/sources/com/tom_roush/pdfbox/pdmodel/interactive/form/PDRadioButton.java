package com.tom_roush.pdfbox.pdmodel.interactive.form;

import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationWidget;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class PDRadioButton extends PDButton {
    private static final int FLAG_NO_TOGGLE_TO_OFF = 16384;

    public PDRadioButton(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
        getCOSObject().setFlag(COSName.FF, 32768, true);
    }

    public List<String> getSelectedExportValues() throws IOException {
        Set<String> onValues = getOnValues();
        List<String> exportValues = getExportValues();
        ArrayList arrayList = new ArrayList();
        if (exportValues.isEmpty()) {
            arrayList.add(getValue());
            return arrayList;
        }
        String value = getValue();
        int i2 = 0;
        Iterator<String> it = onValues.iterator();
        while (it.hasNext()) {
            if (it.next().compareTo(value) == 0) {
                arrayList.add(exportValues.get(i2));
            }
            i2++;
        }
        return arrayList;
    }

    public int getSelectedIndex() {
        Iterator<PDAnnotationWidget> it = getWidgets().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (!COSName.Off.equals(it.next().getAppearanceState())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public boolean isRadiosInUnison() {
        return getCOSObject().getFlag(COSName.FF, PDButton.FLAG_RADIOS_IN_UNISON);
    }

    public void setRadiosInUnison(boolean z) {
        getCOSObject().setFlag(COSName.FF, PDButton.FLAG_RADIOS_IN_UNISON, z);
    }

    public PDRadioButton(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDNonTerminalField pDNonTerminalField) {
        super(pDAcroForm, cOSDictionary, pDNonTerminalField);
    }
}
