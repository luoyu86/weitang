package anetwork.channel.aidl;

import a.a.l;
import a.a.m.d;
import a.a.v.a;
import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NetworkResponse implements Parcelable, l {
    public static final Parcelable.Creator<NetworkResponse> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, List<String>> f751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Throwable f752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f753f;

    public NetworkResponse() {
    }

    public static NetworkResponse readFromParcel(Parcel parcel) {
        NetworkResponse networkResponse = new NetworkResponse();
        try {
            networkResponse.f748a = parcel.readInt();
            networkResponse.f749b = parcel.readString();
            int i2 = parcel.readInt();
            if (i2 > 0) {
                byte[] bArr = new byte[i2];
                networkResponse.f750c = bArr;
                parcel.readByteArray(bArr);
            }
            networkResponse.f751d = parcel.readHashMap(NetworkResponse.class.getClassLoader());
            try {
                networkResponse.f753f = (a) parcel.readSerializable();
            } catch (Throwable unused) {
                ALog.i("anet.NetworkResponse", "[readFromParcel] source.readSerializable() error", null, new Object[0]);
            }
        } catch (Exception e2) {
            ALog.w("anet.NetworkResponse", "[readFromParcel]", null, e2, new Object[0]);
        }
        return networkResponse;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // a.a.l
    public byte[] getBytedata() {
        return this.f750c;
    }

    @Override // a.a.l
    public Map<String, List<String>> getConnHeadFields() {
        return this.f751d;
    }

    @Override // a.a.l
    public String getDesc() {
        return this.f749b;
    }

    @Override // a.a.l
    public Throwable getError() {
        return this.f752e;
    }

    @Override // a.a.l
    public a getStatisticData() {
        return this.f753f;
    }

    @Override // a.a.l
    public int getStatusCode() {
        return this.f748a;
    }

    public void setBytedata(byte[] bArr) {
        this.f750c = bArr;
    }

    public void setConnHeadFields(Map<String, List<String>> map) {
        this.f751d = map;
    }

    public void setDesc(String str) {
        this.f749b = str;
    }

    public void setError(Throwable th) {
        this.f752e = th;
    }

    public void setStatisticData(a aVar) {
        this.f753f = aVar;
    }

    public void setStatusCode(int i2) {
        this.f748a = i2;
        this.f749b = ErrorConstant.getErrMsg(i2);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetworkResponse [");
        sb.append("statusCode=");
        sb.append(this.f748a);
        sb.append(", desc=");
        sb.append(this.f749b);
        sb.append(", connHeadFields=");
        sb.append(this.f751d);
        sb.append(", bytedata=");
        sb.append(this.f750c != null ? new String(this.f750c) : "");
        sb.append(", error=");
        sb.append(this.f752e);
        sb.append(", statisticData=");
        sb.append(this.f753f);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f748a);
        parcel.writeString(this.f749b);
        byte[] bArr = this.f750c;
        int length = bArr != null ? bArr.length : 0;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(this.f750c);
        }
        parcel.writeMap(this.f751d);
        a aVar = this.f753f;
        if (aVar != null) {
            parcel.writeSerializable(aVar);
        }
    }

    public NetworkResponse(int i2) {
        this.f748a = i2;
        this.f749b = ErrorConstant.getErrMsg(i2);
    }
}
