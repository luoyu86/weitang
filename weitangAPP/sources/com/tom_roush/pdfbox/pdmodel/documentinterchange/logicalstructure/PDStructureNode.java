package com.tom_roush.pdfbox.pdmodel.documentinterchange.logicalstructure;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSObject;
import com.tom_roush.pdfbox.pdmodel.common.COSArrayList;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDStructureNode implements COSObjectable {
    private final COSDictionary dictionary;

    public PDStructureNode(String str) {
        COSDictionary cOSDictionary = new COSDictionary();
        this.dictionary = cOSDictionary;
        cOSDictionary.setName(COSName.TYPE, str);
    }

    public static PDStructureNode create(COSDictionary cOSDictionary) {
        String nameAsString = cOSDictionary.getNameAsString(COSName.TYPE);
        if ("StructTreeRoot".equals(nameAsString)) {
            return new PDStructureTreeRoot(cOSDictionary);
        }
        if (nameAsString == null || PDStructureElement.TYPE.equals(nameAsString)) {
            return new PDStructureElement(cOSDictionary);
        }
        throw new IllegalArgumentException("Dictionary must not include a Type entry with a value that is neither StructTreeRoot nor StructElem.");
    }

    private COSObjectable createObjectFromDic(COSDictionary cOSDictionary) {
        String nameAsString = cOSDictionary.getNameAsString(COSName.TYPE);
        if (nameAsString == null || PDStructureElement.TYPE.equals(nameAsString)) {
            return new PDStructureElement(cOSDictionary);
        }
        if (PDObjectReference.TYPE.equals(nameAsString)) {
            return new PDObjectReference(cOSDictionary);
        }
        if (PDMarkedContentReference.TYPE.equals(nameAsString)) {
            return new PDMarkedContentReference(cOSDictionary);
        }
        return null;
    }

    public void appendKid(PDStructureElement pDStructureElement) {
        appendObjectableKid(pDStructureElement);
        pDStructureElement.setParent(this);
    }

    public void appendObjectableKid(COSObjectable cOSObjectable) {
        if (cOSObjectable == null) {
            return;
        }
        appendKid(cOSObjectable.getCOSObject());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createObject(com.tom_roush.pdfbox.cos.COSBase r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof com.tom_roush.pdfbox.cos.COSDictionary
            r1 = 0
            if (r0 == 0) goto L9
            r0 = r4
            com.tom_roush.pdfbox.cos.COSDictionary r0 = (com.tom_roush.pdfbox.cos.COSDictionary) r0
            goto L1c
        L9:
            boolean r0 = r4 instanceof com.tom_roush.pdfbox.cos.COSObject
            if (r0 == 0) goto L1b
            r0 = r4
            com.tom_roush.pdfbox.cos.COSObject r0 = (com.tom_roush.pdfbox.cos.COSObject) r0
            com.tom_roush.pdfbox.cos.COSBase r0 = r0.getObject()
            boolean r2 = r0 instanceof com.tom_roush.pdfbox.cos.COSDictionary
            if (r2 == 0) goto L1b
            com.tom_roush.pdfbox.cos.COSDictionary r0 = (com.tom_roush.pdfbox.cos.COSDictionary) r0
            goto L1c
        L1b:
            r0 = r1
        L1c:
            if (r0 == 0) goto L23
            com.tom_roush.pdfbox.pdmodel.common.COSObjectable r4 = r3.createObjectFromDic(r0)
            return r4
        L23:
            boolean r0 = r4 instanceof com.tom_roush.pdfbox.cos.COSInteger
            if (r0 == 0) goto L32
            com.tom_roush.pdfbox.cos.COSInteger r4 = (com.tom_roush.pdfbox.cos.COSInteger) r4
            int r4 = r4.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            return r4
        L32:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tom_roush.pdfbox.pdmodel.documentinterchange.logicalstructure.PDStructureNode.createObject(com.tom_roush.pdfbox.cos.COSBase):java.lang.Object");
    }

    public List<Object> getKids() {
        ArrayList arrayList = new ArrayList();
        COSBase dictionaryObject = getCOSObject().getDictionaryObject(COSName.K);
        if (dictionaryObject instanceof COSArray) {
            Iterator<COSBase> it = ((COSArray) dictionaryObject).iterator();
            while (it.hasNext()) {
                Object objCreateObject = createObject(it.next());
                if (objCreateObject != null) {
                    arrayList.add(objCreateObject);
                }
            }
        } else {
            Object objCreateObject2 = createObject(dictionaryObject);
            if (objCreateObject2 != null) {
                arrayList.add(objCreateObject2);
            }
        }
        return arrayList;
    }

    public String getType() {
        return getCOSObject().getNameAsString(COSName.TYPE);
    }

    public void insertBefore(PDStructureElement pDStructureElement, Object obj) {
        insertObjectableBefore(pDStructureElement, obj);
    }

    public void insertObjectableBefore(COSObjectable cOSObjectable, Object obj) {
        if (cOSObjectable == null) {
            return;
        }
        insertBefore(cOSObjectable.getCOSObject(), obj);
    }

    public boolean removeKid(PDStructureElement pDStructureElement) {
        boolean zRemoveObjectableKid = removeObjectableKid(pDStructureElement);
        if (zRemoveObjectableKid) {
            pDStructureElement.setParent(null);
        }
        return zRemoveObjectableKid;
    }

    public boolean removeObjectableKid(COSObjectable cOSObjectable) {
        if (cOSObjectable == null) {
            return false;
        }
        return removeKid(cOSObjectable.getCOSObject());
    }

    public void setKids(List<Object> list) {
        getCOSObject().setItem(COSName.K, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.dictionary;
    }

    public void insertBefore(COSBase cOSBase, Object obj) {
        if (cOSBase == null || obj == null) {
            return;
        }
        COSDictionary cOSObject = getCOSObject();
        COSName cOSName = COSName.K;
        COSBase dictionaryObject = cOSObject.getDictionaryObject(cOSName);
        if (dictionaryObject == null) {
            return;
        }
        COSBase cOSObject2 = null;
        if (obj instanceof COSObjectable) {
            cOSObject2 = ((COSObjectable) obj).getCOSObject();
        } else if (obj instanceof COSInteger) {
            cOSObject2 = (COSBase) obj;
        }
        if (dictionaryObject instanceof COSArray) {
            COSArray cOSArray = (COSArray) dictionaryObject;
            cOSArray.add(cOSArray.indexOfObject(cOSObject2), cOSBase.getCOSObject());
            return;
        }
        boolean zEquals = dictionaryObject.equals(cOSObject2);
        if (!zEquals && (dictionaryObject instanceof COSObject)) {
            zEquals = ((COSObject) dictionaryObject).getObject().equals(cOSObject2);
        }
        if (zEquals) {
            COSArray cOSArray2 = new COSArray();
            cOSArray2.add(cOSBase);
            cOSArray2.add(cOSObject2);
            getCOSObject().setItem(cOSName, (COSBase) cOSArray2);
        }
    }

    public void appendKid(COSBase cOSBase) {
        if (cOSBase == null) {
            return;
        }
        COSDictionary cOSObject = getCOSObject();
        COSName cOSName = COSName.K;
        COSBase dictionaryObject = cOSObject.getDictionaryObject(cOSName);
        if (dictionaryObject == null) {
            getCOSObject().setItem(cOSName, cOSBase);
            return;
        }
        if (dictionaryObject instanceof COSArray) {
            ((COSArray) dictionaryObject).add(cOSBase);
            return;
        }
        COSArray cOSArray = new COSArray();
        cOSArray.add(dictionaryObject);
        cOSArray.add(cOSBase);
        getCOSObject().setItem(cOSName, (COSBase) cOSArray);
    }

    public boolean removeKid(COSBase cOSBase) {
        if (cOSBase == null) {
            return false;
        }
        COSDictionary cOSObject = getCOSObject();
        COSName cOSName = COSName.K;
        COSBase dictionaryObject = cOSObject.getDictionaryObject(cOSName);
        if (dictionaryObject == null) {
            return false;
        }
        if (dictionaryObject instanceof COSArray) {
            COSArray cOSArray = (COSArray) dictionaryObject;
            boolean zRemoveObject = cOSArray.removeObject(cOSBase);
            if (cOSArray.size() == 1) {
                getCOSObject().setItem(cOSName, cOSArray.getObject(0));
            }
            return zRemoveObject;
        }
        boolean zEquals = dictionaryObject.equals(cOSBase);
        if (!zEquals && (dictionaryObject instanceof COSObject)) {
            zEquals = ((COSObject) dictionaryObject).getObject().equals(cOSBase);
        }
        if (!zEquals) {
            return false;
        }
        getCOSObject().setItem(cOSName, (COSBase) null);
        return true;
    }

    public PDStructureNode(COSDictionary cOSDictionary) {
        this.dictionary = cOSDictionary;
    }
}
