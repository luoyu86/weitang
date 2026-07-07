package com.tom_roush.pdfbox.pdmodel.interactive.form;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;

/* JADX INFO: loaded from: classes2.dex */
public final class PDFieldFactory {
    private static final String FIELD_TYPE_BUTTON = "Btn";
    private static final String FIELD_TYPE_CHOICE = "Ch";
    private static final String FIELD_TYPE_SIGNATURE = "Sig";
    private static final String FIELD_TYPE_TEXT = "Tx";

    private PDFieldFactory() {
    }

    private static PDField createButtonSubType(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDNonTerminalField pDNonTerminalField) {
        int i2 = cOSDictionary.getInt(COSName.FF, 0);
        return (32768 & i2) != 0 ? new PDRadioButton(pDAcroForm, cOSDictionary, pDNonTerminalField) : (i2 & 65536) != 0 ? new PDPushButton(pDAcroForm, cOSDictionary, pDNonTerminalField) : new PDCheckBox(pDAcroForm, cOSDictionary, pDNonTerminalField);
    }

    private static PDField createChoiceSubType(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDNonTerminalField pDNonTerminalField) {
        return (cOSDictionary.getInt(COSName.FF, 0) & 131072) != 0 ? new PDComboBox(pDAcroForm, cOSDictionary, pDNonTerminalField) : new PDListBox(pDAcroForm, cOSDictionary, pDNonTerminalField);
    }

    public static PDField createField(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDNonTerminalField pDNonTerminalField) {
        COSArray cOSArray;
        String strFindFieldType = findFieldType(cOSDictionary);
        COSName cOSName = COSName.KIDS;
        if (cOSDictionary.containsKey(cOSName) && (cOSArray = (COSArray) cOSDictionary.getDictionaryObject(cOSName)) != null && cOSArray.size() > 0) {
            for (int i2 = 0; i2 < cOSArray.size(); i2++) {
                COSBase object = cOSArray.getObject(i2);
                if ((object instanceof COSDictionary) && ((COSDictionary) object).getString(COSName.T) != null) {
                    return new PDNonTerminalField(pDAcroForm, cOSDictionary, pDNonTerminalField);
                }
            }
        }
        if (FIELD_TYPE_CHOICE.equals(strFindFieldType)) {
            return createChoiceSubType(pDAcroForm, cOSDictionary, pDNonTerminalField);
        }
        if (FIELD_TYPE_TEXT.equals(strFindFieldType)) {
            return new PDTextField(pDAcroForm, cOSDictionary, pDNonTerminalField);
        }
        if (FIELD_TYPE_SIGNATURE.equals(strFindFieldType)) {
            return new PDSignatureField(pDAcroForm, cOSDictionary, pDNonTerminalField);
        }
        if (FIELD_TYPE_BUTTON.equals(strFindFieldType)) {
            return createButtonSubType(pDAcroForm, cOSDictionary, pDNonTerminalField);
        }
        return null;
    }

    private static String findFieldType(COSDictionary cOSDictionary) {
        String nameAsString = cOSDictionary.getNameAsString(COSName.FT);
        if (nameAsString != null) {
            return nameAsString;
        }
        COSBase dictionaryObject = cOSDictionary.getDictionaryObject(COSName.PARENT, COSName.P);
        return dictionaryObject instanceof COSDictionary ? findFieldType((COSDictionary) dictionaryObject) : nameAsString;
    }
}
