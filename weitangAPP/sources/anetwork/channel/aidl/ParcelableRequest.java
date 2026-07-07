package anetwork.channel.aidl;

import a.a.a;
import a.a.j;
import a.a.k;
import a.a.m.f;
import android.os.Parcel;
import android.os.Parcelable;
import anet.channel.request.BodyEntry;
import anet.channel.util.ALog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableRequest implements Parcelable {
    public static final Parcelable.Creator<ParcelableRequest> CREATOR = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BodyEntry f766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f769e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f770f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f771g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<String, String> f772h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<String, String> f773i;
    public int j;
    public int k;
    public String l;
    public String m;
    public Map<String, String> n;

    public ParcelableRequest(k kVar) {
        this.f772h = null;
        this.f773i = null;
        this.f765a = kVar;
        if (kVar != null) {
            this.f768d = kVar.getUrlString();
            this.f767c = kVar.getRetryTime();
            this.f769e = kVar.getCharset();
            this.f770f = kVar.getFollowRedirects();
            this.f771g = kVar.getMethod();
            List<a> headers = kVar.getHeaders();
            if (headers != null) {
                this.f772h = new HashMap();
                for (a aVar : headers) {
                    this.f772h.put(aVar.getName(), aVar.getValue());
                }
            }
            List<j> params = kVar.getParams();
            if (params != null) {
                this.f773i = new HashMap();
                for (j jVar : params) {
                    this.f773i.put(jVar.getKey(), jVar.getValue());
                }
            }
            this.f766b = kVar.getBodyEntry();
            this.j = kVar.getConnectTimeout();
            this.k = kVar.getReadTimeout();
            this.l = kVar.getBizId();
            this.m = kVar.getSeqNo();
            this.n = kVar.getExtProperties();
        }
    }

    public static ParcelableRequest readFromParcel(Parcel parcel) {
        ParcelableRequest parcelableRequest = new ParcelableRequest();
        try {
            parcelableRequest.f767c = parcel.readInt();
            parcelableRequest.f768d = parcel.readString();
            parcelableRequest.f769e = parcel.readString();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            parcelableRequest.f770f = z;
            parcelableRequest.f771g = parcel.readString();
            if (parcel.readInt() != 0) {
                parcelableRequest.f772h = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
            if (parcel.readInt() != 0) {
                parcelableRequest.f773i = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
            parcelableRequest.f766b = (BodyEntry) parcel.readParcelable(ParcelableRequest.class.getClassLoader());
            parcelableRequest.j = parcel.readInt();
            parcelableRequest.k = parcel.readInt();
            parcelableRequest.l = parcel.readString();
            parcelableRequest.m = parcel.readString();
            if (parcel.readInt() != 0) {
                parcelableRequest.n = parcel.readHashMap(ParcelableRequest.class.getClassLoader());
            }
        } catch (Throwable th) {
            ALog.w("anet.ParcelableRequest", "[readFromParcel]", null, th, new Object[0]);
        }
        return parcelableRequest;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getExtProperty(String str) {
        Map<String, String> map = this.n;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        k kVar = this.f765a;
        if (kVar == null) {
            return;
        }
        try {
            parcel.writeInt(kVar.getRetryTime());
            parcel.writeString(this.f768d);
            parcel.writeString(this.f765a.getCharset());
            parcel.writeInt(this.f765a.getFollowRedirects() ? 1 : 0);
            parcel.writeString(this.f765a.getMethod());
            parcel.writeInt(this.f772h == null ? 0 : 1);
            Map<String, String> map = this.f772h;
            if (map != null) {
                parcel.writeMap(map);
            }
            parcel.writeInt(this.f773i == null ? 0 : 1);
            Map<String, String> map2 = this.f773i;
            if (map2 != null) {
                parcel.writeMap(map2);
            }
            parcel.writeParcelable(this.f766b, 0);
            parcel.writeInt(this.f765a.getConnectTimeout());
            parcel.writeInt(this.f765a.getReadTimeout());
            parcel.writeString(this.f765a.getBizId());
            parcel.writeString(this.f765a.getSeqNo());
            Map<String, String> extProperties = this.f765a.getExtProperties();
            parcel.writeInt(extProperties == null ? 0 : 1);
            if (extProperties != null) {
                parcel.writeMap(extProperties);
            }
        } catch (Throwable th) {
            ALog.w("anet.ParcelableRequest", "[writeToParcel]", null, th, new Object[0]);
        }
    }

    public ParcelableRequest() {
        this.f772h = null;
        this.f773i = null;
    }
}
