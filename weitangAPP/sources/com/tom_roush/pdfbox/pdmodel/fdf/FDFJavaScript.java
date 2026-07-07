package com.tom_roush.pdfbox.pdmodel.fdf;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSStream;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import com.tom_roush.pdfbox.pdmodel.interactive.action.PDAction;
import com.tom_roush.pdfbox.pdmodel.interactive.action.PDActionFactory;
import com.tom_roush.pdfbox.pdmodel.interactive.action.PDActionJavaScript;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FDFJavaScript implements COSObjectable {
    private final COSDictionary dictionary;

    public FDFJavaScript() {
        this.dictionary = new COSDictionary();
    }

    public String getAfter() {
        COSBase dictionaryObject = this.dictionary.getDictionaryObject(COSName.AFTER);
        if (dictionaryObject instanceof COSString) {
            return ((COSString) dictionaryObject).getString();
        }
        if (dictionaryObject instanceof COSStream) {
            return ((COSStream) dictionaryObject).toTextString();
        }
        return null;
    }

    public String getBefore() {
        COSBase dictionaryObject = this.dictionary.getDictionaryObject(COSName.BEFORE);
        if (dictionaryObject instanceof COSString) {
            return ((COSString) dictionaryObject).getString();
        }
        if (dictionaryObject instanceof COSStream) {
            return ((COSStream) dictionaryObject).toTextString();
        }
        return null;
    }

    public Map<String, PDActionJavaScript> getDoc() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        COSArray cOSArray = this.dictionary.getCOSArray(COSName.DOC);
        if (cOSArray == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= cOSArray.size()) {
                return linkedHashMap;
            }
            String name = cOSArray.getName(i2);
            if (name != null) {
                COSBase object = cOSArray.getObject(i3);
                if (object instanceof COSDictionary) {
                    PDAction pDActionCreateAction = PDActionFactory.createAction((COSDictionary) object);
                    if (pDActionCreateAction instanceof PDActionJavaScript) {
                        linkedHashMap.put(name, (PDActionJavaScript) pDActionCreateAction);
                    }
                }
            }
            i2 += 2;
        }
    }

    public void setAfter(String str) {
        this.dictionary.setItem(COSName.AFTER, (COSBase) new COSString(str));
    }

    public void setBefore(String str) {
        this.dictionary.setItem(COSName.BEFORE, (COSBase) new COSString(str));
    }

    public void setDoc(Map<String, PDActionJavaScript> map) {
        COSArray cOSArray = new COSArray();
        for (Map.Entry<String, PDActionJavaScript> entry : map.entrySet()) {
            cOSArray.add((COSBase) new COSString(entry.getKey()));
            cOSArray.add(entry.getValue());
        }
        this.dictionary.setItem(COSName.DOC, (COSBase) cOSArray);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.dictionary;
    }

    public FDFJavaScript(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }
}
