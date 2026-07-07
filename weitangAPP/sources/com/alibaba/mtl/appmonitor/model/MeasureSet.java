package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MeasureSet implements Parcelable {
    public static final Parcelable.Creator<MeasureSet> CREATOR = new Parcelable.Creator<MeasureSet>() { // from class: com.alibaba.mtl.appmonitor.model.MeasureSet.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MeasureSet[] newArray(int i2) {
            return new MeasureSet[i2];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MeasureSet createFromParcel(Parcel parcel) {
            return MeasureSet.a(parcel);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<Measure> f4512d = new ArrayList(3);

    private MeasureSet() {
    }

    public static MeasureSet a(Parcel parcel) {
        MeasureSet measureSetCreate = create();
        try {
            Parcelable[] parcelableArray = parcel.readParcelableArray(MeasureSet.class.getClassLoader());
            if (parcelableArray != null) {
                ArrayList arrayList = new ArrayList(parcelableArray.length);
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((Measure) parcelable);
                }
                measureSetCreate.f4512d = arrayList;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return measureSetCreate;
    }

    public static MeasureSet create() {
        return new MeasureSet();
    }

    public MeasureSet addMeasure(Measure measure) {
        if (!this.f4512d.contains(measure)) {
            this.f4512d.add(measure);
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Measure getMeasure(String str) {
        for (Measure measure : this.f4512d) {
            if (measure.getName().equals(str)) {
                return measure;
            }
        }
        return null;
    }

    public List<Measure> getMeasures() {
        return this.f4512d;
    }

    public void setConstantValue(MeasureValueSet measureValueSet) {
        List<Measure> list = this.f4512d;
        if (list == null || measureValueSet == null) {
            return;
        }
        for (Measure measure : list) {
            if (measure.getConstantValue() != null && measureValueSet.getValue(measure.getName()) == null) {
                measureValueSet.setValue(measure.getName(), measure.getConstantValue().doubleValue());
            }
        }
    }

    public void upateMeasure(Measure measure) {
        int size = this.f4512d.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(this.f4512d.get(i2).name, measure.name)) {
                this.f4512d.get(i2).setMax(measure.getMax());
                this.f4512d.get(i2).setMin(measure.getMin());
                this.f4512d.get(i2).setConstantValue(measure.getConstantValue());
            }
        }
    }

    public void upateMeasures(List<Measure> list) {
        int size = this.f4512d.size();
        int size2 = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            for (int i3 = 0; i3 < size2; i3++) {
                if (TextUtils.equals(this.f4512d.get(i2).name, list.get(i3).name)) {
                    this.f4512d.get(i2).setMax(list.get(i3).getMax());
                    this.f4512d.get(i2).setMin(list.get(i3).getMin());
                }
            }
        }
    }

    public boolean valid(MeasureValueSet measureValueSet) {
        if (this.f4512d == null) {
            return true;
        }
        if (measureValueSet == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.f4512d.size(); i2++) {
            Measure measure = this.f4512d.get(i2);
            if (measure != null) {
                String name = measure.getName();
                if (!measureValueSet.containValue(name) || !measure.valid(measureValueSet.getValue(name))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        List<Measure> list = this.f4512d;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                Measure[] measureArr = null;
                if (array != null) {
                    measureArr = new Measure[array.length];
                    for (int i3 = 0; i3 < array.length; i3++) {
                        measureArr[i3] = (Measure) array[i3];
                    }
                }
                parcel.writeParcelableArray(measureArr, i2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static MeasureSet create(Collection<String> collection) {
        MeasureSet measureSet = new MeasureSet();
        if (collection != null) {
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                measureSet.addMeasure(it.next());
            }
        }
        return measureSet;
    }

    public MeasureSet addMeasure(String str) {
        return addMeasure(new Measure(str));
    }

    public static MeasureSet create(String[] strArr) {
        MeasureSet measureSet = new MeasureSet();
        if (strArr != null) {
            for (String str : strArr) {
                measureSet.addMeasure(str);
            }
        }
        return measureSet;
    }
}
