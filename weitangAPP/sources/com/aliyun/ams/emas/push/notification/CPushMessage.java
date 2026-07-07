package com.aliyun.ams.emas.push.notification;

import android.os.Parcel;
import android.os.Parcelable;
import c.a.a.a.a.n.d;

/* JADX INFO: loaded from: classes.dex */
public class CPushMessage implements Parcelable {
    public static final Parcelable.Creator<CPushMessage> CREATOR = new d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5813e;

    public /* synthetic */ CPushMessage(Parcel parcel, d dVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppId() {
        return this.f5810b;
    }

    public String getContent() {
        return this.f5812d;
    }

    public String getMessageId() {
        return this.f5809a;
    }

    public String getTitle() {
        return this.f5811c;
    }

    public String getTraceInfo() {
        return this.f5813e;
    }

    public void setAppId(String str) {
        this.f5810b = str;
    }

    public void setContent(String str) {
        this.f5812d = str;
    }

    public void setMessageId(String str) {
        this.f5809a = str;
    }

    public void setTitle(String str) {
        this.f5811c = str;
    }

    public void setTraceInfo(String str) {
        this.f5813e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5810b);
        parcel.writeString(this.f5809a);
        parcel.writeString(this.f5811c);
        parcel.writeString(this.f5812d);
        parcel.writeString(this.f5813e);
    }

    public CPushMessage() {
    }

    public CPushMessage(Parcel parcel) {
        this.f5810b = parcel.readString();
        this.f5809a = parcel.readString();
        this.f5811c = parcel.readString();
        this.f5812d = parcel.readString();
        this.f5813e = parcel.readString();
    }
}
