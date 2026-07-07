package anetwork.channel.aidl;

import a.a.h;
import a.a.m.c;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class DefaultProgressEvent implements Parcelable, h {
    public static final Parcelable.Creator<DefaultProgressEvent> CREATOR = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f746e;

    public DefaultProgressEvent() {
    }

    public static DefaultProgressEvent readFromParcel(Parcel parcel) {
        DefaultProgressEvent defaultProgressEvent = new DefaultProgressEvent();
        try {
            defaultProgressEvent.f742a = parcel.readInt();
            defaultProgressEvent.f743b = parcel.readInt();
            defaultProgressEvent.f744c = parcel.readInt();
            int i2 = parcel.readInt();
            if (i2 > 0) {
                byte[] bArr = new byte[i2];
                parcel.readByteArray(bArr);
                defaultProgressEvent.f746e = bArr;
            }
        } catch (Exception unused) {
        }
        return defaultProgressEvent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // a.a.h
    public byte[] getBytedata() {
        return this.f746e;
    }

    public Object getContext() {
        return this.f745d;
    }

    @Override // a.a.h
    public String getDesc() {
        return "";
    }

    @Override // a.a.h
    public int getIndex() {
        return this.f742a;
    }

    @Override // a.a.h
    public int getSize() {
        return this.f743b;
    }

    @Override // a.a.h
    public int getTotal() {
        return this.f744c;
    }

    public void setContext(Object obj) {
        this.f745d = obj;
    }

    public String toString() {
        return "DefaultProgressEvent [index=" + this.f742a + ", size=" + this.f743b + ", total=" + this.f744c + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f742a);
        parcel.writeInt(this.f743b);
        parcel.writeInt(this.f744c);
        byte[] bArr = this.f746e;
        parcel.writeInt(bArr != null ? bArr.length : 0);
        parcel.writeByteArray(this.f746e);
    }

    public DefaultProgressEvent(int i2, int i3, int i4, byte[] bArr) {
        this.f742a = i2;
        this.f743b = i3;
        this.f744c = i4;
        this.f746e = bArr;
    }
}
