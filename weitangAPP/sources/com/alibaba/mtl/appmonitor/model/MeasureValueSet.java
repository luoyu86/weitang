package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MeasureValueSet implements Parcelable, b {
    public static final Parcelable.Creator<MeasureValueSet> CREATOR = new Parcelable.Creator<MeasureValueSet>() { // from class: com.alibaba.mtl.appmonitor.model.MeasureValueSet.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MeasureValueSet[] newArray(int i2) {
            return new MeasureValueSet[i2];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MeasureValueSet createFromParcel(Parcel parcel) {
            return MeasureValueSet.a(parcel);
        }
    };
    private Map<String, MeasureValue> map = new LinkedHashMap();

    @Deprecated
    public MeasureValueSet() {
    }

    private static Double a(String str) {
        try {
            return Double.valueOf(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static MeasureValueSet create() {
        return (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
    }

    public static MeasureValueSet fromStringMap(Map<String, String> map) {
        MeasureValueSet measureValueSet = (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Double dA = a(entry.getValue());
                if (dA != null) {
                    measureValueSet.map.put(entry.getKey(), (MeasureValue) a.a().a(MeasureValue.class, dA));
                }
            }
        }
        return measureValueSet;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        Iterator<MeasureValue> it = this.map.values().iterator();
        while (it.hasNext()) {
            a.a().a(it.next());
        }
        this.map.clear();
    }

    public boolean containValue(String str) {
        return this.map.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        if (this.map == null) {
            this.map = new LinkedHashMap();
        }
    }

    public Map<String, MeasureValue> getMap() {
        return this.map;
    }

    public MeasureValue getValue(String str) {
        return this.map.get(str);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public void setMap(Map<String, MeasureValue> map) {
        this.map = map;
    }

    public MeasureValueSet setValue(String str, double d2) {
        this.map.put(str, (MeasureValue) a.a().a(MeasureValue.class, Double.valueOf(d2)));
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeMap(this.map);
    }

    @Deprecated
    public static MeasureValueSet create(int i2) {
        return (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
    }

    public void merge(MeasureValueSet measureValueSet) {
        for (String str : this.map.keySet()) {
            this.map.get(str).merge(measureValueSet.getValue(str));
        }
    }

    public void setValue(String str, MeasureValue measureValue) {
        this.map.put(str, measureValue);
    }

    public static MeasureValueSet a(Parcel parcel) {
        try {
            MeasureValueSet measureValueSetCreate = create();
            try {
                measureValueSetCreate.map = parcel.readHashMap(DimensionValueSet.class.getClassLoader());
                return measureValueSetCreate;
            } catch (Throwable unused) {
                return measureValueSetCreate;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static MeasureValueSet create(Map<String, Double> map) {
        MeasureValueSet measureValueSet = (MeasureValueSet) a.a().a(MeasureValueSet.class, new Object[0]);
        if (map != null) {
            for (String str : map.keySet()) {
                Double d2 = map.get(str);
                if (d2 != null) {
                    measureValueSet.map.put(str, (MeasureValue) a.a().a(MeasureValue.class, d2));
                }
            }
        }
        return measureValueSet;
    }
}
