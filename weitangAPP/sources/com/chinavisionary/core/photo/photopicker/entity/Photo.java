package com.chinavisionary.core.photo.photopicker.entity;

import android.os.Parcel;
import android.os.Parcelable;
import c.e.a.b.a.i.c;

/* JADX INFO: loaded from: classes.dex */
public class Photo implements Parcelable {
    public static final Parcelable.Creator<Photo> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6576b;

    public class a implements Parcelable.Creator<Photo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Photo createFromParcel(Parcel parcel) {
            return new Photo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Photo[] newArray(int i2) {
            return new Photo[i2];
        }
    }

    public Photo(int i2, String str) {
        this.f6575a = i2;
        this.f6576b = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Photo.class != obj.getClass()) {
            return false;
        }
        String str = this.f6576b;
        String str2 = ((Photo) obj).f6576b;
        return str != null ? str.equals(str2) : str2 == null;
    }

    public int getId() {
        return this.f6575a;
    }

    public String getPath() {
        return this.f6576b;
    }

    public int hashCode() {
        String str = this.f6576b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean isSelected() {
        return c.getHelper().isSelected(this);
    }

    public void setId(int i2) {
        this.f6575a = i2;
    }

    public void setPath(String str) {
        this.f6576b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f6575a);
        parcel.writeString(this.f6576b);
    }

    public Photo(Parcel parcel) {
        this.f6575a = parcel.readInt();
        this.f6576b = parcel.readString();
    }
}
