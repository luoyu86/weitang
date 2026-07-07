package anet.channel.status;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NetworkStatusHelper.NetworkStatus f580a;

    public a(NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f580a = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            for (NetworkStatusHelper.INetworkStatusChangeListener iNetworkStatusChangeListener : NetworkStatusHelper.listeners) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                iNetworkStatusChangeListener.onNetworkStatusChanged(this.f580a);
                if (System.currentTimeMillis() - jCurrentTimeMillis > 500) {
                    ALog.e("awcn.NetworkStatusHelper", "call back cost too much time", null, "listener", iNetworkStatusChangeListener);
                }
            }
        } catch (Exception unused) {
        }
    }
}
