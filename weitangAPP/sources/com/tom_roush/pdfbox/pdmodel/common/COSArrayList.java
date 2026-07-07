package com.tom_roush.pdfbox.pdmodel.common;

import com.alipay.sdk.m.u.i;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSDictionary;
import com.tom_roush.pdfbox.cos.COSFloat;
import com.tom_roush.pdfbox.cos.COSInteger;
import com.tom_roush.pdfbox.cos.COSName;
import com.tom_roush.pdfbox.cos.COSNull;
import com.tom_roush.pdfbox.cos.COSNumber;
import com.tom_roush.pdfbox.cos.COSObject;
import com.tom_roush.pdfbox.cos.COSString;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes2.dex */
public class COSArrayList<E> implements List<E> {
    private final List<E> actual;
    private final COSArray array;
    private COSName dictKey;
    private boolean isFiltered;
    private COSDictionary parentDict;

    public COSArrayList() {
        this.isFiltered = false;
        this.array = new COSArray();
        this.actual = new ArrayList();
    }

    public static List<String> convertCOSNameCOSArrayToList(COSArray cOSArray) {
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            arrayList.add(((COSName) cOSArray.getObject(i2)).getName());
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public static List<String> convertCOSStringCOSArrayToList(COSArray cOSArray) {
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            arrayList.add(((COSString) cOSArray.getObject(i2)).getString());
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public static List<Float> convertFloatCOSArrayToList(COSArray cOSArray) {
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(cOSArray.size());
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            COSBase object = cOSArray.getObject(i2);
            if (object instanceof COSNumber) {
                arrayList.add(Float.valueOf(((COSNumber) object).floatValue()));
            } else {
                arrayList.add(null);
            }
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public static List<Integer> convertIntegerCOSArrayToList(COSArray cOSArray) {
        if (cOSArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < cOSArray.size(); i2++) {
            arrayList.add(Integer.valueOf(((COSNumber) (cOSArray.get(i2) instanceof COSObject ? ((COSObject) cOSArray.get(i2)).getObject() : cOSArray.get(i2))).intValue()));
        }
        return new COSArrayList(arrayList, cOSArray);
    }

    public static COSArray convertStringListToCOSNameCOSArray(List<String> list) {
        COSArray cOSArray = new COSArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            cOSArray.add((COSBase) COSName.getPDFName(it.next()));
        }
        return cOSArray;
    }

    public static COSArray convertStringListToCOSStringCOSArray(List<String> list) {
        COSArray cOSArray = new COSArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            cOSArray.add((COSBase) new COSString(it.next()));
        }
        return cOSArray;
    }

    public static COSArray converterToCOSArray(List<?> list) {
        if (list == null) {
            return null;
        }
        if (list instanceof COSArrayList) {
            return ((COSArrayList) list).array;
        }
        COSArray cOSArray = new COSArray();
        for (Object obj : list) {
            if (obj instanceof String) {
                cOSArray.add((COSBase) new COSString((String) obj));
            } else if ((obj instanceof Integer) || (obj instanceof Long)) {
                cOSArray.add((COSBase) COSInteger.get(((Number) obj).longValue()));
            } else if ((obj instanceof Float) || (obj instanceof Double)) {
                cOSArray.add((COSBase) new COSFloat(((Number) obj).floatValue()));
            } else if (obj instanceof COSObjectable) {
                cOSArray.add(((COSObjectable) obj).getCOSObject());
            } else {
                if (obj != null) {
                    throw new IllegalArgumentException("Error: Don't know how to convert type to COSBase '" + obj.getClass().getName() + OperatorName.SHOW_TEXT_LINE);
                }
                cOSArray.add((COSBase) COSNull.NULL);
            }
        }
        return cOSArray;
    }

    private List<COSBase> toCOSObjectList(Collection<?> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (Object obj : collection) {
            if (obj instanceof String) {
                arrayList.add(new COSString((String) obj));
            } else {
                arrayList.add(((COSObjectable) obj).getCOSObject());
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List, java.util.Collection
    public boolean add(E e2) {
        COSDictionary cOSDictionary = this.parentDict;
        if (cOSDictionary != null) {
            cOSDictionary.setItem(this.dictKey, (COSBase) this.array);
            this.parentDict = null;
        }
        if (e2 instanceof String) {
            this.array.add((COSBase) new COSString((String) e2));
        } else {
            COSArray cOSArray = this.array;
            if (cOSArray != null) {
                cOSArray.add(((COSObjectable) e2).getCOSObject());
            }
        }
        return this.actual.add(e2);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        if (this.isFiltered) {
            throw new UnsupportedOperationException("Adding to a filtered List is not permitted");
        }
        if (this.parentDict != null && collection.size() > 0) {
            this.parentDict.setItem(this.dictKey, (COSBase) this.array);
            this.parentDict = null;
        }
        this.array.addAll(toCOSObjectList(collection));
        return this.actual.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        COSDictionary cOSDictionary = this.parentDict;
        if (cOSDictionary != null) {
            cOSDictionary.setItem(this.dictKey, (COSBase) null);
        }
        this.actual.clear();
        this.array.clear();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.actual.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.actual.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return this.actual.equals(obj);
    }

    @Override // java.util.List
    public E get(int i2) {
        return this.actual.get(i2);
    }

    public COSArray getCOSArray() {
        return this.array;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.actual.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.actual.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.actual.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return this.actual.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.actual.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return this.actual.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        if (this.isFiltered) {
            throw new UnsupportedOperationException("removing entries from a filtered List is not permitted");
        }
        int iIndexOf = this.actual.indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        this.actual.remove(iIndexOf);
        this.array.remove(iIndexOf);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            COSBase cOSObject = ((COSObjectable) it.next()).getCOSObject();
            for (int size = this.array.size() - 1; size >= 0; size--) {
                if (cOSObject.equals(this.array.getObject(size))) {
                    this.array.remove(size);
                }
            }
        }
        return this.actual.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            COSBase cOSObject = ((COSObjectable) it.next()).getCOSObject();
            for (int size = this.array.size() - 1; size >= 0; size--) {
                if (!cOSObject.equals(this.array.getObject(size))) {
                    this.array.remove(size);
                }
            }
        }
        return this.actual.retainAll(collection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public E set(int i2, E e2) {
        if (this.isFiltered) {
            throw new UnsupportedOperationException("Replacing an element in a filtered List is not permitted");
        }
        if (e2 instanceof String) {
            COSString cOSString = new COSString((String) e2);
            COSDictionary cOSDictionary = this.parentDict;
            if (cOSDictionary != null && i2 == 0) {
                cOSDictionary.setItem(this.dictKey, (COSBase) cOSString);
            }
            this.array.set(i2, (COSBase) cOSString);
        } else {
            COSDictionary cOSDictionary2 = this.parentDict;
            if (cOSDictionary2 != null && i2 == 0) {
                cOSDictionary2.setItem(this.dictKey, ((COSObjectable) e2).getCOSObject());
            }
            this.array.set(i2, ((COSObjectable) e2).getCOSObject());
        }
        return this.actual.set(i2, e2);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.actual.size();
    }

    @Override // java.util.List
    public List<E> subList(int i2, int i3) {
        return this.actual.subList(i2, i3);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.actual.toArray();
    }

    @Deprecated
    public COSArray toList() {
        return this.array;
    }

    public String toString() {
        return "COSArrayList{" + this.array.toString() + i.f5699d;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i2) {
        return this.actual.listIterator(i2);
    }

    @Override // java.util.List, java.util.Collection
    public <X> X[] toArray(X[] xArr) {
        return (X[]) this.actual.toArray(xArr);
    }

    public COSArrayList(List<E> list, COSArray cOSArray) {
        this.isFiltered = false;
        this.actual = list;
        this.array = cOSArray;
        if (list.size() != cOSArray.size()) {
            this.isFiltered = true;
        }
    }

    @Override // java.util.List
    public E remove(int i2) {
        if (!this.isFiltered) {
            this.array.remove(i2);
            return this.actual.remove(i2);
        }
        throw new UnsupportedOperationException("removing entries from a filtered List is not permitted");
    }

    @Override // java.util.List
    public boolean addAll(int i2, Collection<? extends E> collection) {
        if (!this.isFiltered) {
            if (this.parentDict != null && collection.size() > 0) {
                this.parentDict.setItem(this.dictKey, (COSBase) this.array);
                this.parentDict = null;
            }
            this.array.addAll(i2, toCOSObjectList(collection));
            return this.actual.addAll(i2, collection);
        }
        throw new UnsupportedOperationException("Inserting to a filtered List is not permitted");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    public void add(int i2, E e2) {
        if (!this.isFiltered) {
            COSDictionary cOSDictionary = this.parentDict;
            if (cOSDictionary != null) {
                cOSDictionary.setItem(this.dictKey, (COSBase) this.array);
                this.parentDict = null;
            }
            this.actual.add(i2, e2);
            if (e2 instanceof String) {
                this.array.add(i2, new COSString((String) e2));
                return;
            } else {
                this.array.add(i2, ((COSObjectable) e2).getCOSObject());
                return;
            }
        }
        throw new UnsupportedOperationException("Adding an element in a filtered List is not permitted");
    }

    public COSArrayList(COSDictionary cOSDictionary, COSName cOSName) {
        this.isFiltered = false;
        this.array = new COSArray();
        this.actual = new ArrayList();
        this.parentDict = cOSDictionary;
        this.dictKey = cOSName;
    }

    public COSArrayList(E e2, COSBase cOSBase, COSDictionary cOSDictionary, COSName cOSName) {
        this.isFiltered = false;
        COSArray cOSArray = new COSArray();
        this.array = cOSArray;
        cOSArray.add(cOSBase);
        ArrayList arrayList = new ArrayList();
        this.actual = arrayList;
        arrayList.add(e2);
        this.parentDict = cOSDictionary;
        this.dictKey = cOSName;
    }
}
