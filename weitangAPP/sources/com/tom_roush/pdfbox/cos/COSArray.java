package com.tom_roush.pdfbox.cos;

import com.alipay.sdk.m.u.i;
import com.tom_roush.pdfbox.pdmodel.common.COSObjectable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class COSArray extends COSBase implements Iterable<COSBase>, COSUpdateInfo {
    private boolean needToBeUpdated;
    private final List<COSBase> objects = new ArrayList();

    @Override // com.tom_roush.pdfbox.cos.COSBase
    public Object accept(ICOSVisitor iCOSVisitor) throws IOException {
        return iCOSVisitor.visitFromArray(this);
    }

    public void add(COSBase cOSBase) {
        this.objects.add(cOSBase);
    }

    public void addAll(Collection<COSBase> collection) {
        this.objects.addAll(collection);
    }

    public void clear() {
        this.objects.clear();
    }

    public COSBase get(int i2) {
        return this.objects.get(i2);
    }

    public int getInt(int i2) {
        return getInt(i2, -1);
    }

    public String getName(int i2) {
        return getName(i2, null);
    }

    public COSBase getObject(int i2) {
        COSBase object = this.objects.get(i2);
        if (object instanceof COSObject) {
            object = ((COSObject) object).getObject();
        }
        if (object instanceof COSNull) {
            return null;
        }
        return object;
    }

    public String getString(int i2) {
        return getString(i2, null);
    }

    public void growToSize(int i2) {
        growToSize(i2, null);
    }

    public int indexOf(COSBase cOSBase) {
        for (int i2 = 0; i2 < size(); i2++) {
            COSBase cOSBase2 = get(i2);
            if (cOSBase2 == null) {
                if (cOSBase == null) {
                    return i2;
                }
            } else if (cOSBase2.equals(cOSBase)) {
                return i2;
            }
        }
        return -1;
    }

    public int indexOfObject(COSBase cOSBase) {
        for (int i2 = 0; i2 < size(); i2++) {
            COSBase cOSBase2 = get(i2);
            if (cOSBase2 == null) {
                if (cOSBase2 == cOSBase) {
                    return i2;
                }
            } else if (cOSBase2.equals(cOSBase) || ((cOSBase2 instanceof COSObject) && ((COSObject) cOSBase2).getObject().equals(cOSBase))) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.tom_roush.pdfbox.cos.COSUpdateInfo
    public boolean isNeedToBeUpdated() {
        return this.needToBeUpdated;
    }

    @Override // java.lang.Iterable
    public Iterator<COSBase> iterator() {
        return this.objects.iterator();
    }

    public COSBase remove(int i2) {
        return this.objects.remove(i2);
    }

    public void removeAll(Collection<COSBase> collection) {
        this.objects.removeAll(collection);
    }

    public boolean removeObject(COSBase cOSBase) {
        boolean zRemove = remove(cOSBase);
        if (!zRemove) {
            for (int i2 = 0; i2 < size(); i2++) {
                COSBase cOSBase2 = get(i2);
                if ((cOSBase2 instanceof COSObject) && ((COSObject) cOSBase2).getObject().equals(cOSBase)) {
                    return remove(cOSBase2);
                }
            }
        }
        return zRemove;
    }

    public void retainAll(Collection<COSBase> collection) {
        this.objects.retainAll(collection);
    }

    public void set(int i2, COSBase cOSBase) {
        this.objects.set(i2, cOSBase);
    }

    public void setFloatArray(float[] fArr) {
        clear();
        for (float f2 : fArr) {
            add((COSBase) new COSFloat(f2));
        }
    }

    public void setInt(int i2, int i3) {
        set(i2, (COSBase) COSInteger.get(i3));
    }

    public void setName(int i2, String str) {
        set(i2, (COSBase) COSName.getPDFName(str));
    }

    @Override // com.tom_roush.pdfbox.cos.COSUpdateInfo
    public void setNeedToBeUpdated(boolean z) {
        this.needToBeUpdated = z;
    }

    public void setString(int i2, String str) {
        if (str != null) {
            set(i2, (COSBase) new COSString(str));
        } else {
            set(i2, (COSBase) null);
        }
    }

    public int size() {
        return this.objects.size();
    }

    public float[] toFloatArray() {
        float[] fArr = new float[size()];
        for (int i2 = 0; i2 < size(); i2++) {
            COSBase object = getObject(i2);
            fArr[i2] = object instanceof COSNumber ? ((COSNumber) object).floatValue() : 0.0f;
        }
        return fArr;
    }

    public List<? extends COSBase> toList() {
        return new ArrayList(this.objects);
    }

    public String toString() {
        return "COSArray{" + this.objects + i.f5699d;
    }

    public void add(COSObjectable cOSObjectable) {
        this.objects.add(cOSObjectable.getCOSObject());
    }

    public void addAll(COSArray cOSArray) {
        if (cOSArray != null) {
            this.objects.addAll(cOSArray.objects);
        }
    }

    public int getInt(int i2, int i3) {
        if (i2 >= size()) {
            return i3;
        }
        COSBase cOSBase = this.objects.get(i2);
        return cOSBase instanceof COSNumber ? ((COSNumber) cOSBase).intValue() : i3;
    }

    public String getName(int i2, String str) {
        if (i2 >= size()) {
            return str;
        }
        COSBase cOSBase = this.objects.get(i2);
        return cOSBase instanceof COSName ? ((COSName) cOSBase).getName() : str;
    }

    public String getString(int i2, String str) {
        if (i2 >= size()) {
            return str;
        }
        COSBase cOSBase = this.objects.get(i2);
        return cOSBase instanceof COSString ? ((COSString) cOSBase).getString() : str;
    }

    public void growToSize(int i2, COSBase cOSBase) {
        while (size() < i2) {
            add(cOSBase);
        }
    }

    public boolean remove(COSBase cOSBase) {
        return this.objects.remove(cOSBase);
    }

    public void set(int i2, int i3) {
        this.objects.set(i2, COSInteger.get(i3));
    }

    public void add(int i2, COSBase cOSBase) {
        this.objects.add(i2, cOSBase);
    }

    public void addAll(int i2, Collection<COSBase> collection) {
        this.objects.addAll(i2, collection);
    }

    public void set(int i2, COSObjectable cOSObjectable) {
        this.objects.set(i2, cOSObjectable != null ? cOSObjectable.getCOSObject() : null);
    }
}
