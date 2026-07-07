package com.tom_roush.pdfbox.pdmodel.interactive.action;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.pdmodel.common.COSArrayList;
import com.tom_roush.pdfbox.pdmodel.common.PDDestinationOrAction;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDAction implements PDDestinationOrAction {
    public static final String TYPE = "Action";
    public COSDictionary action;

    public PDAction() {
        this.action = new COSDictionary();
        setType(TYPE);
    }

    public List<PDAction> getNext() {
        COSDictionary cOSDictionary = this.action;
        COSName cOSName = COSName.NEXT;
        COSBase dictionaryObject = cOSDictionary.getDictionaryObject(cOSName);
        if (dictionaryObject instanceof COSDictionary) {
            return new COSArrayList(PDActionFactory.createAction((COSDictionary) dictionaryObject), dictionaryObject, this.action, cOSName);
        }
        if (!(dictionaryObject instanceof COSArray)) {
            return null;
        }
        COSArray cOSArray = (COSArray) dictionaryObject;
        ArrayList arrayList = new ArrayList(cOSArray.size());
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            arrayList.add(PDActionFactory.createAction((COSDictionary) cOSArray.getObject(i2)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public String getSubType() {
        return this.action.getNameAsString(COSName.S);
    }

    public String getType() {
        return this.action.getNameAsString(COSName.TYPE);
    }

    public void setNext(List<?> list) {
        this.action.setItem(COSName.NEXT, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setSubType(String str) {
        this.action.setName(COSName.S, str);
    }

    public final void setType(String str) {
        this.action.setName(COSName.TYPE, str);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.action;
    }

    public PDAction(COSDictionary cOSDictionary) {
        this.action = cOSDictionary;
    }
}
