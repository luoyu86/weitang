package a.a.m;

import android.os.Parcel;
import android.os.Parcelable;
import anetwork.channel.aidl.DefaultFinishEvent;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator<DefaultFinishEvent> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DefaultFinishEvent createFromParcel(Parcel parcel) {
        return DefaultFinishEvent.a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public DefaultFinishEvent[] newArray(int i2) {
        return new DefaultFinishEvent[i2];
    }
}
