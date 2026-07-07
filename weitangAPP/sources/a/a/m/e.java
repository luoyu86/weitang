package a.a.m;

import android.os.Parcel;
import android.os.Parcelable;
import anetwork.channel.aidl.ParcelableHeader;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable.Creator<ParcelableHeader> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableHeader createFromParcel(Parcel parcel) {
        return ParcelableHeader.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableHeader[] newArray(int i2) {
        return new ParcelableHeader[i2];
    }
}
