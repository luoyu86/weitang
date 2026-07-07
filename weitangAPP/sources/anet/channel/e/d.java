package anet.channel.e;

import anet.channel.status.NetworkStatusHelper;

/* JADX INFO: loaded from: classes.dex */
public final class d implements NetworkStatusHelper.INetworkStatusChangeListener {
    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        a.a(networkStatus);
    }
}
