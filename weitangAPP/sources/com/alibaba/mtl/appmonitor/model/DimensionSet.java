package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.log.d.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DimensionSet implements Parcelable {
    public static final Parcelable.Creator<DimensionSet> CREATOR = new Parcelable.Creator<DimensionSet>() { // from class: com.alibaba.mtl.appmonitor.model.DimensionSet.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DimensionSet[] newArray(int i2) {
            return new DimensionSet[i2];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public DimensionSet createFromParcel(Parcel parcel) {
            return DimensionSet.a(parcel);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Dimension> f4508c = new ArrayList(3);

    private DimensionSet() {
    }

    public static DimensionSet a(Parcel parcel) {
        DimensionSet dimensionSetCreate = create();
        try {
            Parcelable[] parcelableArray = parcel.readParcelableArray(DimensionSet.class.getClassLoader());
            if (parcelableArray != null) {
                if (dimensionSetCreate.f4508c == null) {
                    dimensionSetCreate.f4508c = new ArrayList();
                }
                for (int i2 = 0; i2 < parcelableArray.length; i2++) {
                    if (parcelableArray[i2] == null || !(parcelableArray[i2] instanceof Dimension)) {
                        i.a("DimensionSet", "parcelables[i]:", parcelableArray[i2]);
                    } else {
                        dimensionSetCreate.f4508c.add((Dimension) parcelableArray[i2]);
                    }
                }
            }
        } catch (Throwable th) {
            i.a("DimensionSet", "[readFromParcel]", th);
        }
        return dimensionSetCreate;
    }

    public static DimensionSet create() {
        return new DimensionSet();
    }

    public DimensionSet addDimension(Dimension dimension) {
        if (this.f4508c.contains(dimension)) {
            return this;
        }
        this.f4508c.add(dimension);
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Dimension getDimension(String str) {
        for (Dimension dimension : this.f4508c) {
            if (dimension.getName().equals(str)) {
                return dimension;
            }
        }
        return null;
    }

    public List<Dimension> getDimensions() {
        return this.f4508c;
    }

    public void setConstantValue(DimensionValueSet dimensionValueSet) {
        List<Dimension> list = this.f4508c;
        if (list == null || dimensionValueSet == null) {
            return;
        }
        for (Dimension dimension : list) {
            if (dimension.getConstantValue() != null && dimensionValueSet.getValue(dimension.getName()) == null) {
                dimensionValueSet.setValue(dimension.getName(), dimension.getConstantValue());
            }
        }
    }

    public boolean valid(DimensionValueSet dimensionValueSet) {
        List<Dimension> list = this.f4508c;
        if (list == null) {
            return true;
        }
        if (dimensionValueSet != null) {
            Iterator<Dimension> it = list.iterator();
            while (it.hasNext()) {
                if (!dimensionValueSet.containValue(it.next().getName())) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        List<Dimension> list = this.f4508c;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                Dimension[] dimensionArr = null;
                if (array != null) {
                    dimensionArr = new Dimension[array.length];
                    for (int i3 = 0; i3 < array.length; i3++) {
                        dimensionArr[i3] = (Dimension) array[i3];
                    }
                }
                parcel.writeParcelableArray(dimensionArr, i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static DimensionSet create(Collection<String> collection) {
        DimensionSet dimensionSet = new DimensionSet();
        if (collection != null) {
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                dimensionSet.addDimension(new Dimension(it.next()));
            }
        }
        return dimensionSet;
    }

    public DimensionSet addDimension(String str) {
        return addDimension(new Dimension(str));
    }

    public static DimensionSet create(String[] strArr) {
        DimensionSet dimensionSet = new DimensionSet();
        if (strArr != null) {
            for (String str : strArr) {
                dimensionSet.addDimension(new Dimension(str));
            }
        }
        return dimensionSet;
    }

    public DimensionSet addDimension(String str, String str2) {
        return addDimension(new Dimension(str, str2));
    }
}
