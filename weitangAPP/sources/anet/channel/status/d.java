package anet.channel.status;

/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NetworkStatusMonitor$2 f591a;

    public d(NetworkStatusMonitor$2 networkStatusMonitor$2) {
        this.f591a = networkStatusMonitor$2;
    }

    @Override // java.lang.Runnable
    public void run() {
        b.d();
    }
}
