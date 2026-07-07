package c.a.a.a.a.n;

import android.os.Parcel;
import android.os.Parcelable;
import com.aliyun.ams.emas.push.notification.CPushMessage;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Parcelable.Creator<CPushMessage> {
    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CPushMessage createFromParcel(Parcel parcel) {
        return new CPushMessage(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CPushMessage[] newArray(int i2) {
        return new CPushMessage[i2];
    }
}
