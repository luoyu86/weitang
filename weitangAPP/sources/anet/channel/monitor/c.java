package anet.channel.monitor;

import anet.channel.status.NetworkStatusHelper;

/* JADX INFO: loaded from: classes.dex */
public class c implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f510a;

    public c(b bVar) {
        this.f510a = bVar;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f510a.n.a();
        b.f505f = 0L;
        this.f510a.d();
    }
}
