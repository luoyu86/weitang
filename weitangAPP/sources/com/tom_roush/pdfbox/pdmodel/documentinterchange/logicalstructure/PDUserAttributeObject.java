package com.tom_roush.pdfbox.pdmodel.documentinterchange.logicalstructure;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class PDUserAttributeObject extends PDAttributeObject {
    public static final String OWNER_USER_PROPERTIES = "UserProperties";

    public PDUserAttributeObject() {
        setOwner(OWNER_USER_PROPERTIES);
    }

    public void addUserProperty(PDUserProperty pDUserProperty) {
        ((COSArray) getCOSObject().getDictionaryObject(COSName.P)).add(pDUserProperty);
        notifyChanged();
    }

    public List<PDUserProperty> getOwnerUserProperties() {
        COSArray cOSArray = (COSArray) getCOSObject().getDictionaryObject(COSName.P);
        ArrayList arrayList = new ArrayList(cOSArray.size());
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            arrayList.add(new PDUserProperty((COSDictionary) cOSArray.getObject(i2), this));
        }
        return arrayList;
    }

    public void removeUserProperty(PDUserProperty pDUserProperty) {
        if (pDUserProperty == null) {
            return;
        }
        ((COSArray) getCOSObject().getDictionaryObject(COSName.P)).remove(pDUserProperty.getCOSObject());
        notifyChanged();
    }

    public void setUserProperties(List<PDUserProperty> list) {
        COSArray cOSArray = new COSArray();
        Iterator<PDUserProperty> it = list.iterator();
        while (it.hasNext()) {
            cOSArray.add(it.next());
        }
        getCOSObject().setItem(COSName.P, (COSBase) cOSArray);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.documentinterchange.logicalstructure.PDAttributeObject
    public String toString() {
        return super.toString() + ", userProperties=" + getOwnerUserProperties();
    }

    public void userPropertyChanged(PDUserProperty pDUserProperty) {
    }

    public PDUserAttributeObject(COSDictionary cOSDictionary) {
        super(cOSDictionary);
    }
}
