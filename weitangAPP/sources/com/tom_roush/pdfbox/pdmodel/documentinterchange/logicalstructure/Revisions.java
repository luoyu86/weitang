package com.tom_roush.pdfbox.pdmodel.documentinterchange.logicalstructure;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class Revisions<T> {
    private List<T> objects;
    private List<Integer> revisionNumbers;

    private List<T> getObjects() {
        if (this.objects == null) {
            this.objects = new ArrayList();
        }
        return this.objects;
    }

    private List<Integer> getRevisionNumbers() {
        if (this.revisionNumbers == null) {
            this.revisionNumbers = new ArrayList();
        }
        return this.revisionNumbers;
    }

    public void addObject(T t, int i2) {
        getObjects().add(t);
        getRevisionNumbers().add(Integer.valueOf(i2));
    }

    public T getObject(int i2) {
        return getObjects().get(i2);
    }

    public int getRevisionNumber(int i2) {
        return getRevisionNumbers().get(i2).intValue();
    }

    public void setRevisionNumber(T t, int i2) {
        int iIndexOf = getObjects().indexOf(t);
        if (iIndexOf > -1) {
            getRevisionNumbers().set(iIndexOf, Integer.valueOf(i2));
        }
    }

    public int size() {
        return getObjects().size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < getObjects().size(); i2++) {
            if (i2 > 0) {
                sb.append("; ");
            }
            sb.append("object=");
            sb.append(getObjects().get(i2));
            sb.append(", revisionNumber=");
            sb.append(getRevisionNumber(i2));
        }
        return sb.toString();
    }
}
