package com.intelligoo.sdk.a.a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.intelligoo.sdk.utils.AdRecordUtil;

/* JADX INFO: loaded from: classes2.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.intelligoo.sdk.a.a.b.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<a> f9176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9177b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9178c;

    public b(Parcel parcel) {
        Bundle bundle = parcel.readBundle(getClass().getClassLoader());
        this.f9176a = bundle.getSparseParcelableArray("records_array");
        this.f9177b = bundle.getString("local_name_complete");
        this.f9178c = bundle.getString("local_name_short");
    }

    public b(SparseArray<a> sparseArray) {
        this.f9176a = sparseArray;
        this.f9177b = AdRecordUtil.getRecordDataAsString(sparseArray.get(9));
        this.f9178c = AdRecordUtil.getRecordDataAsString(sparseArray.get(8));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "AdRecordStore [mLocalNameComplete=" + this.f9177b + ", mLocalNameShort=" + this.f9178c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Bundle bundle = new Bundle();
        bundle.putString("local_name_complete", this.f9177b);
        bundle.putString("local_name_short", this.f9178c);
        bundle.putSparseParcelableArray("records_array", this.f9176a);
        parcel.writeBundle(bundle);
    }
}
