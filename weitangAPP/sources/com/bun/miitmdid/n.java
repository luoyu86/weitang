package com.bun.miitmdid;

/* JADX INFO: loaded from: classes.dex */
public abstract class n extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5890b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5891c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5892d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5893e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5894f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f5889a = a();

    public abstract g a();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void doStart();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public native String getAAID();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public native String getOAID();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public native String getVAID();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public native boolean isLimited();

    @Override // com.bun.miitmdid.interfaces.IdSupplier
    public native boolean isSupported();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native boolean isSync();

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public native void shutDown();
}
