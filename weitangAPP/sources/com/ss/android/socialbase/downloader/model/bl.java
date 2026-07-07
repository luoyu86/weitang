package com.ss.android.socialbase.downloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class bl implements Parcelable, Comparable {
    public static final Parcelable.Creator<bl> CREATOR = new Parcelable.Creator<bl>() { // from class: com.ss.android.socialbase.downloader.model.bl.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
        public bl createFromParcel(Parcel parcel) {
            return new bl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
        public bl[] newArray(int i2) {
            return new bl[i2];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10115a;
    private final String ok;

    public bl(String str, String str2) {
        this.ok = str;
        this.f10115a = str2;
    }

    public String a() {
        return this.f10115a;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (!(obj instanceof bl)) {
            return 1;
        }
        bl blVar = (bl) obj;
        if (TextUtils.equals(this.ok, blVar.ok())) {
            return 0;
        }
        String str = this.ok;
        if (str == null) {
            return -1;
        }
        int iCompareTo = str.compareTo(blVar.ok());
        if (iCompareTo > 0) {
            return 1;
        }
        return iCompareTo < 0 ? -1 : 0;
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
        bl blVar = (bl) obj;
        return TextUtils.equals(this.ok, blVar.ok) && TextUtils.equals(this.f10115a, blVar.f10115a);
    }

    public int hashCode() {
        String str = this.ok;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f10115a;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String ok() {
        return this.ok;
    }

    public String toString() {
        return "HttpHeader{name='" + this.ok + "', value='" + this.f10115a + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.ok);
        parcel.writeString(this.f10115a);
    }

    public bl(Parcel parcel) {
        this.ok = parcel.readString();
        this.f10115a = parcel.readString();
    }
}
