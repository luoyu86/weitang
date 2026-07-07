package anet.channel.detect;

import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;

/* JADX INFO: loaded from: classes.dex */
public class a implements NetworkStatusHelper.INetworkStatusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExceptionDetector f407a;

    public a(ExceptionDetector exceptionDetector) {
        this.f407a = exceptionDetector;
    }

    @Override // anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener
    public void onNetworkStatusChanged(NetworkStatusHelper.NetworkStatus networkStatus) {
        ThreadPoolExecutorFactory.submitDetectTask(new b(this));
    }
}
