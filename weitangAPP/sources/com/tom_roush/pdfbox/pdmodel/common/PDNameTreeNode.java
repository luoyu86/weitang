package com.tom_roush.pdfbox.pdmodel.common;

import android.util.Log;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSString;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class PDNameTreeNode<T extends COSObjectable> implements COSObjectable {
    private final COSDictionary node;
    private PDNameTreeNode<T> parent;

    public PDNameTreeNode() {
        this.node = new COSDictionary();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.tom_roush.pdfbox.cos.COSBase] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.tom_roush.pdfbox.cos.COSDictionary] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0070 -> B:20:0x007e). Please report as a decompilation issue!!! */
    private void calculateLimits() {
        ?? r1 = 0;
        r1 = 0;
        r1 = 0;
        if (isRootNode()) {
            this.node.setItem(COSName.LIMITS, (COSBase) null);
            return;
        }
        List<PDNameTreeNode<T>> kids = getKids();
        if (kids != null && !kids.isEmpty()) {
            PDNameTreeNode<T> pDNameTreeNode = kids.get(0);
            PDNameTreeNode<T> pDNameTreeNode2 = kids.get(kids.size() - 1);
            setLowerLimit(pDNameTreeNode.getLowerLimit());
            setUpperLimit(pDNameTreeNode2.getUpperLimit());
            return;
        }
        try {
            Map<String, T> names = getNames();
            if (names == null || names.size() <= 0) {
                this.node.setItem(COSName.LIMITS, (COSBase) null);
            } else {
                Set<String> setKeySet = names.keySet();
                String[] strArr = (String[]) setKeySet.toArray(new String[setKeySet.size()]);
                setLowerLimit(strArr[0]);
                setUpperLimit(strArr[strArr.length - 1]);
            }
        } catch (IOException e2) {
            this.node.setItem(COSName.LIMITS, r1);
            Log.e("PdfBox-Android", "Error while calculating the Limits of a PageNameTreeNode:", e2);
            r1 = "PdfBox-Android";
        }
    }

    private void setLowerLimit(String str) {
        COSDictionary cOSDictionary = this.node;
        COSName cOSName = COSName.LIMITS;
        COSArray cOSArray = cOSDictionary.getCOSArray(cOSName);
        if (cOSArray == null) {
            cOSArray = new COSArray();
            cOSArray.add((COSBase) null);
            cOSArray.add((COSBase) null);
            this.node.setItem(cOSName, (COSBase) cOSArray);
        }
        cOSArray.setString(0, str);
    }

    private void setUpperLimit(String str) {
        COSDictionary cOSDictionary = this.node;
        COSName cOSName = COSName.LIMITS;
        COSArray cOSArray = cOSDictionary.getCOSArray(cOSName);
        if (cOSArray == null) {
            cOSArray = new COSArray();
            cOSArray.add((COSBase) null);
            cOSArray.add((COSBase) null);
            this.node.setItem(cOSName, (COSBase) cOSArray);
        }
        cOSArray.setString(1, str);
    }

    public abstract T convertCOSToPD(COSBase cOSBase) throws IOException;

    public abstract PDNameTreeNode<T> createChildNode(COSDictionary cOSDictionary);

    public List<PDNameTreeNode<T>> getKids() {
        COSArray cOSArray = this.node.getCOSArray(COSName.KIDS);
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(cOSArray.size());
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            arrayList.add(createChildNode((COSDictionary) cOSArray.getObject(i2)));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public String getLowerLimit() {
        COSArray cOSArray = this.node.getCOSArray(COSName.LIMITS);
        if (cOSArray != null) {
            return cOSArray.getString(0);
        }
        return null;
    }

    public Map<String, T> getNames() throws IOException {
        COSArray cOSArray = this.node.getCOSArray(COSName.NAMES);
        if (cOSArray == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cOSArray.size() % 2 != 0) {
            Log.w("PdfBox-Android", "Names array has odd size: " + cOSArray.size());
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= cOSArray.size()) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            COSBase object = cOSArray.getObject(i2);
            if (!(object instanceof COSString)) {
                throw new IOException("Expected string, found " + object + " in name tree at index " + i2);
            }
            linkedHashMap.put(((COSString) object).getString(), convertCOSToPD(cOSArray.getObject(i3)));
            i2 += 2;
        }
    }

    public PDNameTreeNode<T> getParent() {
        return this.parent;
    }

    public String getUpperLimit() {
        COSArray cOSArray = this.node.getCOSArray(COSName.LIMITS);
        if (cOSArray != null) {
            return cOSArray.getString(1);
        }
        return null;
    }

    public T getValue(String str) throws IOException {
        Map<String, T> names = getNames();
        if (names != null) {
            return names.get(str);
        }
        List<PDNameTreeNode<T>> kids = getKids();
        if (kids == null) {
            Log.w("PdfBox-Android", "NameTreeNode does not have \"names\" nor \"kids\" objects.");
            return null;
        }
        for (int i2 = 0; i2 < kids.size(); i2++) {
            PDNameTreeNode<T> pDNameTreeNode = kids.get(i2);
            String upperLimit = pDNameTreeNode.getUpperLimit();
            String lowerLimit = pDNameTreeNode.getLowerLimit();
            if (upperLimit == null || lowerLimit == null || upperLimit.compareTo(lowerLimit) < 0 || (lowerLimit.compareTo(str) <= 0 && upperLimit.compareTo(str) >= 0)) {
                return (T) pDNameTreeNode.getValue(str);
            }
        }
        return null;
    }

    public boolean isRootNode() {
        return this.parent == null;
    }

    public void setKids(List<? extends PDNameTreeNode<T>> list) {
        if (list == null || list.isEmpty()) {
            this.node.setItem(COSName.KIDS, (COSBase) null);
            this.node.setItem(COSName.LIMITS, (COSBase) null);
        } else {
            Iterator<? extends PDNameTreeNode<T>> it = list.iterator();
            while (it.hasNext()) {
                it.next().setParent(this);
            }
            this.node.setItem(COSName.KIDS, (COSBase) COSArrayList.converterToCOSArray(list));
            if (isRootNode()) {
                this.node.setItem(COSName.NAMES, (COSBase) null);
            }
        }
        calculateLimits();
    }

    public void setNames(Map<String, T> map) {
        if (map == null) {
            this.node.setItem(COSName.NAMES, (COSObjectable) null);
            this.node.setItem(COSName.LIMITS, (COSObjectable) null);
            return;
        }
        COSArray cOSArray = new COSArray();
        ArrayList<String> arrayList = new ArrayList(map.keySet());
        Collections.sort(arrayList);
        for (String str : arrayList) {
            cOSArray.add((COSBase) new COSString(str));
            cOSArray.add(map.get(str));
        }
        this.node.setItem(COSName.NAMES, (COSBase) cOSArray);
        calculateLimits();
    }

    public void setParent(PDNameTreeNode<T> pDNameTreeNode) {
        this.parent = pDNameTreeNode;
        calculateLimits();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.COSObjectable
    public COSDictionary getCOSObject() {
        return this.node;
    }

    public PDNameTreeNode(COSDictionary cOSDictionary) {
        this.node = cOSDictionary;
    }
}
