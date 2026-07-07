package com.tom_roush.pdfbox.pdmodel.common;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PDNumberTreeNode implements COSObjectable {
    private final COSDictionary node;
    private Class<? extends COSObjectable> valueType;

    public PDNumberTreeNode(Class<? extends COSObjectable> cls) {
        this.valueType = null;
        this.node = new COSDictionary();
        this.valueType = cls;
    }

    private void setLowerLimit(Integer num) {
        COSDictionary cOSDictionary = this.node;
        COSName cOSName = COSName.LIMITS;
        COSArray cOSArray = (COSArray) cOSDictionary.getDictionaryObject(cOSName);
        if (cOSArray == null) {
            cOSArray = new COSArray();
            cOSArray.add((COSBase) null);
            cOSArray.add((COSBase) null);
            this.node.setItem(cOSName, (COSBase) cOSArray);
        }
        if (num != null) {
            cOSArray.setInt(0, num.intValue());
        } else {
            cOSArray.set(0, (COSBase) null);
        }
    }

    private void setUpperLimit(Integer num) {
        COSDictionary cOSDictionary = this.node;
        COSName cOSName = COSName.LIMITS;
        COSArray cOSArray = (COSArray) cOSDictionary.getDictionaryObject(cOSName);
        if (cOSArray == null) {
            cOSArray = new COSArray();
            cOSArray.add((COSBase) null);
            cOSArray.add((COSBase) null);
            this.node.setItem(cOSName, (COSBase) cOSArray);
        }
        if (num != null) {
            cOSArray.setInt(1, num.intValue());
        } else {
            cOSArray.set(1, (COSBase) null);
        }
    }

    public COSObjectable convertCOSToPD(COSBase cOSBase) throws IOException {
        try {
            return this.valueType.getDeclaredConstructor(cOSBase.getClass()).newInstance(cOSBase);
        } catch (Throwable th) {
            throw new IOException("Error while trying to create value in number tree:" + th.getMessage(), th);
        }
    }

    public PDNumberTreeNode createChildNode(COSDictionary cOSDictionary) {
        return new PDNumberTreeNode(cOSDictionary, this.valueType);
    }

    public List<PDNumberTreeNode> getKids() {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.KIDS);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            arrayList.add(createChildNode((COSDictionary) cOSArray.getObject(i2)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public Integer getLowerLimit() {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.LIMITS);
        if (cOSArray == null || cOSArray.get(0) == null) {
            return null;
        }
        return Integer.valueOf(cOSArray.getInt(0));
    }

    public Map<Integer, COSObjectable> getNumbers() throws IOException {
        COSBase dictionaryObject = this.node.getDictionaryObject(COSName.NUMS);
        if (!(dictionaryObject instanceof COSArray)) {
            return null;
        }
        COSArray cOSArray = (COSArray) dictionaryObject;
        HashMap map = new HashMap();
        if (cOSArray.size() % 2 != 0) {
            Log.w("PdfBox-Android", "Numbers array has odd size: " + cOSArray.size());
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= cOSArray.size()) {
                return Collections.unmodifiableMap(map);
            }
            COSBase object = cOSArray.getObject(i2);
            if (!(object instanceof COSInteger)) {
                Log.e("PdfBox-Android", "page labels ignored, index " + i2 + " should be a number, but is " + object);
                return null;
            }
            COSBase object2 = cOSArray.getObject(i3);
            map.put(Integer.valueOf(((COSInteger) object).intValue()), object2 == null ? null : convertCOSToPD(object2));
            i2 += 2;
        }
    }

    public Integer getUpperLimit() {
        COSArray cOSArray = (COSArray) this.node.getDictionaryObject(COSName.LIMITS);
        if (cOSArray == null || cOSArray.get(1) == null) {
            return null;
        }
        return Integer.valueOf(cOSArray.getInt(1));
    }

    public Object getValue(Integer num) throws IOException {
        Map<Integer, COSObjectable> numbers = getNumbers();
        if (numbers != null) {
            return numbers.get(num);
        }
        Object value = null;
        List<PDNumberTreeNode> kids = getKids();
        if (kids != null) {
            for (int i2 = 0; i2 < kids.size() && value == null; i2++) {
                PDNumberTreeNode pDNumberTreeNode = kids.get(i2);
                if (pDNumberTreeNode.getLowerLimit().compareTo(num) <= 0 && pDNumberTreeNode.getUpperLimit().compareTo(num) >= 0) {
                    value = pDNumberTreeNode.getValue(num);
                }
            }
        } else {
            Log.w("PdfBox-Android", "NumberTreeNode does not have \"nums\" nor \"kids\" objects.");
        }
        return value;
    }

    public void setKids(List<? extends PDNumberTreeNode> list) {
        if (list != null && !list.isEmpty()) {
            PDNumberTreeNode pDNumberTreeNode = list.get(0);
            PDNumberTreeNode pDNumberTreeNode2 = list.get(list.size() - 1);
            setLowerLimit(pDNumberTreeNode.getLowerLimit());
            setUpperLimit(pDNumberTreeNode2.getUpperLimit());
        } else if (this.node.getDictionaryObject(COSName.NUMS) == null) {
            this.node.setItem(COSName.LIMITS, (COSBase) null);
        }
        this.node.setItem(COSName.KIDS, (COSBase) COSArrayList.converterToCOSArray(list));
    }

    public void setNumbers(Map<Integer, ? extends COSObjectable> map) {
        Integer num;
        Integer num2 = null;
        if (map == null) {
            this.node.setItem(COSName.NUMS, (COSObjectable) null);
            this.node.setItem(COSName.LIMITS, (COSObjectable) null);
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        COSArray cOSArray = new COSArray();
        for (Integer num3 : arrayList) {
            cOSArray.add((COSBase) COSInteger.get(num3.intValue()));
            COSObjectable cOSObjectable = map.get(num3);
            if (cOSObjectable == null) {
                cOSObjectable = COSNull.NULL;
            }
            cOSArray.add(cOSObjectable);
        }
        if (arrayList.isEmpty()) {
            num = null;
        } else {
            Integer num4 = (Integer) arrayList.get(0);
            num2 = (Integer) arrayList.get(arrayList.size() - 1);
            num = num4;
        }
        setUpperLimit(num2);
        setLowerLimit(num);
        this.node.setItem(COSName.NUMS, (COSBase) cOSArray);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.node;
    }

    public PDNumberTreeNode(COSDictionary cOSDictionary, Class<? extends COSObjectable> cls) {
        this.valueType = null;
        this.node = cOSDictionary;
        this.valueType = cls;
    }
}
