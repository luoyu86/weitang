package a.a.m.b;

import anetwork.channel.aidl.adapter.ParcelableNetworkListenerWrapper;

/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte f160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ParcelableNetworkListenerWrapper f162c;

    public a(ParcelableNetworkListenerWrapper parcelableNetworkListenerWrapper, byte b2, Object obj) {
        this.f162c = parcelableNetworkListenerWrapper;
        this.f160a = b2;
        this.f161b = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f162c.dispatchCallback(this.f160a, this.f161b);
    }
}
