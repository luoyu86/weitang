package anetwork.channel.aidl;

import a.a.g;
import a.a.m.a;
import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ErrorConstant;

/* JADX INFO: loaded from: classes.dex */
public class DefaultFinishEvent implements Parcelable, g {
    public static final Parcelable.Creator<DefaultFinishEvent> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a.a.v.a f739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RequestStatistic f740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Request f741f;

    public DefaultFinishEvent(int i2) {
        this(i2, null, null, null);
    }

    public static DefaultFinishEvent a(Parcel parcel) {
        DefaultFinishEvent defaultFinishEvent = new DefaultFinishEvent(0);
        try {
            defaultFinishEvent.f737b = parcel.readInt();
            defaultFinishEvent.f738c = parcel.readString();
            defaultFinishEvent.f739d = (a.a.v.a) parcel.readSerializable();
        } catch (Throwable unused) {
        }
        return defaultFinishEvent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Object getContext() {
        return this.f736a;
    }

    @Override // a.a.g
    public String getDesc() {
        return this.f738c;
    }

    @Override // a.a.g
    public int getHttpCode() {
        return this.f737b;
    }

    @Override // a.a.g
    public a.a.v.a getStatisticData() {
        return this.f739d;
    }

    public void setContext(Object obj) {
        this.f736a = obj;
    }

    public String toString() {
        return "DefaultFinishEvent [code=" + this.f737b + ", desc=" + this.f738c + ", context=" + this.f736a + ", statisticData=" + this.f739d + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f737b);
        parcel.writeString(this.f738c);
        a.a.v.a aVar = this.f739d;
        if (aVar != null) {
            parcel.writeSerializable(aVar);
        }
    }

    public DefaultFinishEvent(int i2, String str, RequestStatistic requestStatistic) {
        this(i2, str, null, requestStatistic);
    }

    public DefaultFinishEvent(int i2, String str, Request request) {
        this(i2, str, request, request != null ? request.f528a : null);
    }

    public DefaultFinishEvent(int i2, String str, Request request, RequestStatistic requestStatistic) {
        this.f739d = new a.a.v.a();
        this.f737b = i2;
        this.f738c = str == null ? ErrorConstant.getErrMsg(i2) : str;
        this.f741f = request;
        this.f740e = requestStatistic;
    }
}
