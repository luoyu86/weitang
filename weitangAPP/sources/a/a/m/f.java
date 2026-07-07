package a.a.m;

import android.os.Parcel;
import android.os.Parcelable;
import anetwork.channel.aidl.ParcelableRequest;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Parcelable.Creator<ParcelableRequest> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableRequest createFromParcel(Parcel parcel) {
        return ParcelableRequest.readFromParcel(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ParcelableRequest[] newArray(int i2) {
        return new ParcelableRequest[i2];
    }
}
