package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class Measure implements Parcelable {
    public static final Parcelable.Creator<Measure> CREATOR = new Parcelable.Creator<Measure>() { // from class: com.alibaba.mtl.appmonitor.model.Measure.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Measure[] newArray(int i2) {
            return new Measure[i2];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Measure createFromParcel(Parcel parcel) {
            return Measure.a(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Double f4509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Double f4510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Double f4511c;
    public String name;

    public Measure(String str) {
        this(str, Double.valueOf(0.0d));
    }

    public static Measure a(Parcel parcel) {
        try {
            boolean z = true;
            Double dValueOf = !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null;
            Double dValueOf2 = !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null;
            String string = parcel.readString();
            if (parcel.readInt() != 0) {
                z = false;
            }
            return new Measure(string, !z ? Double.valueOf(parcel.readDouble()) : null, dValueOf2, dValueOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Measure measure = (Measure) obj;
        String str = this.name;
        if (str == null) {
            if (measure.name != null) {
                return false;
            }
        } else if (!str.equals(measure.name)) {
            return false;
        }
        return true;
    }

    public Double getConstantValue() {
        return this.f4511c;
    }

    public Double getMax() {
        return this.f4510b;
    }

    public Double getMin() {
        return this.f4509a;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public void setConstantValue(Double d2) {
        this.f4511c = d2;
    }

    public void setMax(Double d2) {
        this.f4510b = d2;
    }

    public void setMin(Double d2) {
        this.f4509a = d2;
    }

    public void setRange(Double d2, Double d3) {
        this.f4509a = d2;
        this.f4510b = d3;
    }

    public boolean valid(MeasureValue measureValue) {
        Double dValueOf = Double.valueOf(measureValue.getValue());
        return dValueOf != null && (this.f4509a == null || dValueOf.doubleValue() >= this.f4509a.doubleValue()) && (this.f4510b == null || dValueOf.doubleValue() <= this.f4510b.doubleValue());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        try {
            int i3 = 0;
            parcel.writeInt(this.f4510b == null ? 0 : 1);
            Double d2 = this.f4510b;
            if (d2 != null) {
                parcel.writeDouble(d2.doubleValue());
            }
            parcel.writeInt(this.f4509a == null ? 0 : 1);
            Double d3 = this.f4509a;
            if (d3 != null) {
                parcel.writeDouble(d3.doubleValue());
            }
            parcel.writeString(this.name);
            if (this.f4511c != null) {
                i3 = 1;
            }
            parcel.writeInt(i3);
            Double d4 = this.f4511c;
            if (d4 != null) {
                parcel.writeDouble(d4.doubleValue());
            }
        } catch (Throwable unused) {
        }
    }

    public Measure(String str, Double d2) {
        this(str, d2, Double.valueOf(0.0d), null);
    }

    public Measure(String str, Double d2, Double d3, Double d4) {
        Double dValueOf = Double.valueOf(0.0d);
        this.f4509a = dValueOf;
        this.f4510b = dValueOf;
        this.f4511c = dValueOf;
        this.f4509a = d3;
        this.f4510b = d4;
        this.name = str;
        this.f4511c = Double.valueOf(d2 != null ? d2.doubleValue() : 0.0d);
    }
}
