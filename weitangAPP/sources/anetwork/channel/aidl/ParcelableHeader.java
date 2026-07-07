package anetwork.channel.aidl;

import a.a.m.e;
import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableHeader implements Parcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Parcelable.Creator<ParcelableHeader> f760a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, List<String>> f762c;

    public ParcelableHeader(int i2, Map<String, List<String>> map) {
        this.f762c = map;
        this.f761b = i2;
    }

    public static ParcelableHeader a(Parcel parcel) {
        ParcelableHeader parcelableHeader = new ParcelableHeader();
        try {
            if (parcel.readInt() == 1) {
                parcelableHeader.f762c = parcel.readHashMap(ParcelableHeader.class.getClassLoader());
            }
            parcelableHeader.f761b = parcel.readInt();
        } catch (Throwable th) {
            ALog.e("anet.ParcelableHeader", "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableHeader;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Map<String, List<String>> getHeader() {
        return this.f762c;
    }

    public int getResponseCode() {
        return this.f761b;
    }

    public String toString() {
        return "ParcelableResponseHeader [responseCode=" + this.f761b + ", header=" + this.f762c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (this.f762c != null) {
            parcel.writeInt(1);
            parcel.writeMap(this.f762c);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.f761b);
    }

    public ParcelableHeader() {
    }
}
