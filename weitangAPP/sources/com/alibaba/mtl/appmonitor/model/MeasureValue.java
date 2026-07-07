package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;

/* JADX INFO: loaded from: classes.dex */
public class MeasureValue implements Parcelable, b {
    public static final Parcelable.Creator<MeasureValue> CREATOR = new Parcelable.Creator<MeasureValue>() { // from class: com.alibaba.mtl.appmonitor.model.MeasureValue.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MeasureValue[] newArray(int i2) {
            return new MeasureValue[i2];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MeasureValue createFromParcel(Parcel parcel) {
            return MeasureValue.a(parcel);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Double f4513d;
    private boolean n;
    private double value;

    @Deprecated
    public MeasureValue() {
    }

    public static MeasureValue a(Parcel parcel) {
        MeasureValue measureValueCreate = null;
        try {
            boolean z = parcel.readInt() != 0;
            Double dValueOf = Double.valueOf(parcel.readDouble());
            double d2 = parcel.readDouble();
            measureValueCreate = create();
            measureValueCreate.n = z;
            measureValueCreate.f4513d = dValueOf;
            measureValueCreate.value = d2;
            return measureValueCreate;
        } catch (Throwable th) {
            th.printStackTrace();
            return measureValueCreate;
        }
    }

    public static MeasureValue create() {
        return (MeasureValue) a.a().a(MeasureValue.class, new Object[0]);
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public synchronized void clean() {
        this.value = 0.0d;
        this.f4513d = null;
        this.n = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.alibaba.mtl.appmonitor.c.b
    public synchronized void fill(Object... objArr) {
        if (objArr == null) {
            return;
        }
        if (objArr.length > 0) {
            this.value = ((Double) objArr[0]).doubleValue();
        }
        if (objArr.length > 1) {
            this.f4513d = (Double) objArr[1];
            this.n = false;
        }
    }

    public Double getOffset() {
        return this.f4513d;
    }

    public double getValue() {
        return this.value;
    }

    public boolean isFinish() {
        return this.n;
    }

    public void setFinish(boolean z) {
        this.n = z;
    }

    public void setOffset(double d2) {
        this.f4513d = Double.valueOf(d2);
    }

    public void setValue(double d2) {
        this.value = d2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        try {
            parcel.writeInt(this.n ? 1 : 0);
            Double d2 = this.f4513d;
            parcel.writeDouble(d2 == null ? 0.0d : d2.doubleValue());
            parcel.writeDouble(this.value);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public MeasureValue(double d2) {
        this.value = d2;
    }

    public static MeasureValue create(double d2) {
        return (MeasureValue) a.a().a(MeasureValue.class, Double.valueOf(d2));
    }

    public synchronized void merge(MeasureValue measureValue) {
        if (measureValue == null) {
            return;
        }
        try {
            this.value += measureValue.getValue();
            if (measureValue.getOffset() != null) {
                if (this.f4513d == null) {
                    this.f4513d = Double.valueOf(0.0d);
                }
                this.f4513d = Double.valueOf(this.f4513d.doubleValue() + measureValue.getOffset().doubleValue());
            }
        } catch (Throwable unused) {
        }
    }

    public static MeasureValue create(double d2, double d3) {
        return (MeasureValue) a.a().a(MeasureValue.class, Double.valueOf(d2), Double.valueOf(d3));
    }

    @Deprecated
    public MeasureValue(double d2, double d3) {
        this.f4513d = Double.valueOf(d3);
        this.value = d2;
        this.n = false;
    }
}
