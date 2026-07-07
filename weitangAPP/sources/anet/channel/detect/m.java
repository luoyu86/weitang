package anet.channel.detect;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;

/* JADX INFO: loaded from: classes.dex */
public class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NetworkStatusHelper.NetworkStatus f427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f428b;

    public m(l lVar, NetworkStatusHelper.NetworkStatus networkStatus) {
        this.f428b = lVar;
        this.f427a = networkStatus;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            NetworkStatusHelper.NetworkStatus networkStatus = this.f427a;
            if (networkStatus != NetworkStatusHelper.NetworkStatus.NO && networkStatus != NetworkStatusHelper.NetworkStatus.NONE) {
                this.f428b.f426a.a(NetworkStatusHelper.getUniqueId(networkStatus));
            }
        } catch (Throwable th) {
            ALog.e("anet.MTUDetector", "MTU detecet fail.", null, th, new Object[0]);
        }
    }
}
