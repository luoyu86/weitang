package com.tom_roush.pdfbox.pdmodel.interactive.form;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.pdmodel.common.COSArrayList;
import com.tom_roush.pdfbox.pdmodel.interactive.form.FieldUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDChoice extends PDVariableText {
    public static final int FLAG_COMBO = 131072;
    private static final int FLAG_COMMIT_ON_SEL_CHANGE = 67108864;
    private static final int FLAG_DO_NOT_SPELL_CHECK = 4194304;
    private static final int FLAG_MULTI_SELECT = 2097152;
    private static final int FLAG_SORT = 524288;

    public PDChoice(PDAcroForm pDAcroForm) {
        super(pDAcroForm);
        getCOSObject().setItem(COSName.FT, (COSBase) COSName.CH);
    }

    private List<String> getValueFor(COSName cOSName) {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(cOSName);
        if (!(dictionaryObject instanceof COSString)) {
            return dictionaryObject instanceof COSArray ? COSArrayList.convertCOSStringCOSArrayToList((COSArray) dictionaryObject) : Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(((COSString) dictionaryObject).getString());
        return arrayList;
    }

    private void updateSelectedOptionsIndex(List<String> list) {
        List<String> options = getOptions();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(options.indexOf(it.next())));
        }
        Collections.sort(arrayList);
        setSelectedOptionsIndex(arrayList);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDTerminalField
    public abstract void constructAppearances() throws IOException;

    public List<String> getDefaultValue() {
        return getValueFor(COSName.DV);
    }

    public List<String> getOptions() {
        return FieldUtils.getPairableItems(getCOSObject().getDictionaryObject(COSName.OPT), 0);
    }

    public List<String> getOptionsDisplayValues() {
        return FieldUtils.getPairableItems(getCOSObject().getDictionaryObject(COSName.OPT), 1);
    }

    public List<String> getOptionsExportValues() {
        return getOptions();
    }

    public List<Integer> getSelectedOptionsIndex() {
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(COSName.I);
        return dictionaryObject != null ? COSArrayList.convertIntegerCOSArrayToList((COSArray) dictionaryObject) : Collections.emptyList();
    }

    public List<String> getValue() {
        return getValueFor(COSName.V);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public String getValueAsString() {
        return Arrays.toString(getValue().toArray());
    }

    public boolean isCombo() {
        return getCOSObject().getFlag(COSName.FF, 131072);
    }

    public boolean isCommitOnSelChange() {
        return getCOSObject().getFlag(COSName.FF, FLAG_COMMIT_ON_SEL_CHANGE);
    }

    public boolean isDoNotSpellCheck() {
        return getCOSObject().getFlag(COSName.FF, 4194304);
    }

    public boolean isMultiSelect() {
        return getCOSObject().getFlag(COSName.FF, 2097152);
    }

    public boolean isSort() {
        return getCOSObject().getFlag(COSName.FF, 524288);
    }

    public void setCombo(boolean z) {
        getCOSObject().setFlag(COSName.FF, 131072, z);
    }

    public void setCommitOnSelChange(boolean z) {
        getCOSObject().setFlag(COSName.FF, FLAG_COMMIT_ON_SEL_CHANGE, z);
    }

    public void setDefaultValue(String str) throws IOException {
        getCOSObject().setString(COSName.DV, str);
    }

    public void setDoNotSpellCheck(boolean z) {
        getCOSObject().setFlag(COSName.FF, 4194304, z);
    }

    public void setMultiSelect(boolean z) {
        getCOSObject().setFlag(COSName.FF, 2097152, z);
    }

    public void setOptions(List<String> list) {
        if (list == null || list.isEmpty()) {
            getCOSObject().removeItem(COSName.OPT);
            return;
        }
        if (isSort()) {
            Collections.sort(list);
        }
        getCOSObject().setItem(COSName.OPT, (COSBase) COSArrayList.convertStringListToCOSStringCOSArray(list));
    }

    public void setSelectedOptionsIndex(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            getCOSObject().removeItem(COSName.I);
        } else {
            if (!isMultiSelect()) {
                throw new IllegalArgumentException("Setting the indices is not allowed for choice fields not allowing multiple selections.");
            }
            getCOSObject().setItem(COSName.I, (COSBase) COSArrayList.converterToCOSArray(list));
        }
    }

    public void setSort(boolean z) {
        getCOSObject().setFlag(COSName.FF, 524288, z);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.interactive.form.PDField
    public void setValue(String str) throws IOException {
        getCOSObject().setString(COSName.V, str);
        setSelectedOptionsIndex(null);
        applyChange();
    }

    public PDChoice(PDAcroForm pDAcroForm, COSDictionary cOSDictionary, PDNonTerminalField pDNonTerminalField) {
        super(pDAcroForm, cOSDictionary, pDNonTerminalField);
    }

    public void setValue(List<String> list) throws IOException {
        if (list != null && !list.isEmpty()) {
            if (isMultiSelect()) {
                if (getOptions().containsAll(list)) {
                    getCOSObject().setItem(COSName.V, (COSBase) COSArrayList.convertStringListToCOSStringCOSArray(list));
                    updateSelectedOptionsIndex(list);
                } else {
                    throw new IllegalArgumentException("The values are not contained in the selectable options.");
                }
            } else {
                throw new IllegalArgumentException("The list box does not allow multiple selections.");
            }
        } else {
            getCOSObject().removeItem(COSName.V);
            getCOSObject().removeItem(COSName.I);
        }
        applyChange();
    }

    public void setOptions(List<String> list, List<String> list2) {
        if (list != null && list2 != null && !list.isEmpty() && !list2.isEmpty()) {
            if (list.size() == list2.size()) {
                List<FieldUtils.KeyValue> keyValueList = FieldUtils.toKeyValueList(list, list2);
                if (isSort()) {
                    FieldUtils.sortByValue(keyValueList);
                }
                COSArray cOSArray = new COSArray();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    COSArray cOSArray2 = new COSArray();
                    cOSArray2.add((COSBase) new COSString(keyValueList.get(i2).getKey()));
                    cOSArray2.add((COSBase) new COSString(keyValueList.get(i2).getValue()));
                    cOSArray.add((COSBase) cOSArray2);
                }
                getCOSObject().setItem(COSName.OPT, (COSBase) cOSArray);
                return;
            }
            throw new IllegalArgumentException("The number of entries for exportValue and displayValue shall be the same.");
        }
        getCOSObject().removeItem(COSName.OPT);
    }
}
