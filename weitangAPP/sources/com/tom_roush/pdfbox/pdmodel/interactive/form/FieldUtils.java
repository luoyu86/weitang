package com.tom_roush.pdfbox.pdmodel.interactive.form;

import com.tom_roush.pdfbox.cos.COSArray;
import com.tom_roush.pdfbox.cos.COSBase;
import com.tom_roush.pdfbox.cos.COSString;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class FieldUtils {

    public static class KeyValue {
        private final String key;
        private final String value;

        public KeyValue(String str, String str2) {
            this.key = str;
            this.value = str2;
        }

        public String getKey() {
            return this.key;
        }

        public String getValue() {
            return this.value;
        }

        public String toString() {
            return "(" + this.key + ", " + this.value + ")";
        }
    }

    public static class KeyValueKeyComparator implements Serializable, Comparator<KeyValue> {
        private static final long serialVersionUID = 6715364290007167694L;

        @Override // java.util.Comparator
        public int compare(KeyValue keyValue, KeyValue keyValue2) {
            return keyValue.key.compareTo(keyValue2.key);
        }
    }

    public static class KeyValueValueComparator implements Serializable, Comparator<KeyValue> {
        private static final long serialVersionUID = -3984095679894798265L;

        @Override // java.util.Comparator
        public int compare(KeyValue keyValue, KeyValue keyValue2) {
            return keyValue.value.compareTo(keyValue2.value);
        }
    }

    private FieldUtils() {
    }

    public static List<String> getPairableItems(COSBase cOSBase, int i2) {
        if (i2 < 0 || i2 > 1) {
            throw new IllegalArgumentException("Only 0 and 1 are allowed as an index into two-element arrays");
        }
        if (cOSBase instanceof COSString) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(((COSString) cOSBase).getString());
            return arrayList;
        }
        if (!(cOSBase instanceof COSArray)) {
            return Collections.emptyList();
        }
        ArrayList arrayList2 = new ArrayList();
        for (COSBase cOSBase2 : (COSArray) cOSBase) {
            if (cOSBase2 instanceof COSString) {
                arrayList2.add(((COSString) cOSBase2).getString());
            } else if (cOSBase2 instanceof COSArray) {
                COSArray cOSArray = (COSArray) cOSBase2;
                if (cOSArray.size() >= i2 + 1 && (cOSArray.get(i2) instanceof COSString)) {
                    arrayList2.add(((COSString) cOSArray.get(i2)).getString());
                }
            }
        }
        return arrayList2;
    }

    public static void sortByKey(List<KeyValue> list) {
        Collections.sort(list, new KeyValueKeyComparator());
    }

    public static void sortByValue(List<KeyValue> list) {
        Collections.sort(list, new KeyValueValueComparator());
    }

    public static List<KeyValue> toKeyValueList(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(new KeyValue(list.get(i2), list2.get(i2)));
        }
        return arrayList;
    }
}
