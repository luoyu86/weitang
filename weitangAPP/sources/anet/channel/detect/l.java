package anet.channel.detect;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;

/* JADX INFO: loaded from: classes.dex */
public class l implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f426a;

    public l(k kVar) {
        this.f426a = kVar;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        ThreadPoolExecutorFactory.submitDetectTask(new m(this, networkStatus));
    }
}
