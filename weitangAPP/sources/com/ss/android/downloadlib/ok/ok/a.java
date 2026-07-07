package com.ss.android.downloadlib.ok.ok;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.ss.android.downloadlib.ok.ok.a.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9892a;
    public String bl;
    public String kf;
    public String n;
    public int ok;
    public int s;

    public a() {
        this.bl = "";
        this.n = "";
        this.kf = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (this.ok == aVar.ok && this.f9892a == aVar.f9892a) {
                String str = this.bl;
                if (str != null) {
                    return str.equals(aVar.bl);
                }
                if (aVar.bl == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.ok * 31) + this.f9892a) * 31;
        String str = this.bl;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.ok);
        parcel.writeInt(this.f9892a);
        parcel.writeString(this.bl);
        parcel.writeString(this.n);
        parcel.writeString(this.kf);
        parcel.writeInt(this.s);
    }

    public a(Parcel parcel) {
        this.bl = "";
        this.n = "";
        this.kf = "";
        this.ok = parcel.readInt();
        this.f9892a = parcel.readInt();
        this.bl = parcel.readString();
        this.n = parcel.readString();
        this.kf = parcel.readString();
        this.s = parcel.readInt();
    }
}
