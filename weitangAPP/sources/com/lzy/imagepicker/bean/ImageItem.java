package com.lzy.imagepicker.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class ImageItem implements Serializable, Parcelable {
    public static final Parcelable.Creator<ImageItem> CREATOR = new a();
    public long addTime;
    public int height;
    public String mimeType;
    public String name;
    public String path;
    public long size;
    public int width;

    public class a implements Parcelable.Creator<ImageItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageItem createFromParcel(Parcel parcel) {
            return new ImageItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageItem[] newArray(int i2) {
            return new ImageItem[i2];
        }
    }

    public ImageItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageItem)) {
            return super.equals(obj);
        }
        ImageItem imageItem = (ImageItem) obj;
        return this.path.equalsIgnoreCase(imageItem.path) && this.addTime == imageItem.addTime;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeString(this.path);
        parcel.writeLong(this.size);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.mimeType);
        parcel.writeLong(this.addTime);
    }

    public ImageItem(Parcel parcel) {
        this.name = parcel.readString();
        this.path = parcel.readString();
        this.size = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.mimeType = parcel.readString();
        this.addTime = parcel.readLong();
    }
}
