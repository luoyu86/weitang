package a.a.m;

import android.os.Parcel;
import android.os.Parcelable;
import anetwork.channel.aidl.NetworkResponse;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator<NetworkResponse> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public NetworkResponse createFromParcel(Parcel parcel) {
        return NetworkResponse.readFromParcel(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public NetworkResponse[] newArray(int i2) {
        return new NetworkResponse[i2];
    }
}
