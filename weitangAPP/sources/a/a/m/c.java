package a.a.m;

import android.os.Parcel;
import android.os.Parcelable;
import anetwork.channel.aidl.DefaultProgressEvent;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator<DefaultProgressEvent> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DefaultProgressEvent createFromParcel(Parcel parcel) {
        return DefaultProgressEvent.readFromParcel(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DefaultProgressEvent[] newArray(int i2) {
        return new DefaultProgressEvent[i2];
    }
}
