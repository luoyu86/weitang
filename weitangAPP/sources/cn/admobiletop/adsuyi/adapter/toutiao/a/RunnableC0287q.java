package cn.admobiletop.adsuyi.adapter.toutiao.a;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0287q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0288s f3915a;

    public RunnableC0287q(C0288s c0288s) {
        this.f3915a = c0288s;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3915a.n != null) {
            this.f3915a.n.onVideoComplete(this.f3915a);
        }
    }
}
