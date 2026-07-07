package cn.admobiletop.adsuyi.adapter.toutiao.a;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0285o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0288s f3913a;

    public RunnableC0285o(C0288s c0288s) {
        this.f3913a = c0288s;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3913a.n != null) {
            this.f3913a.n.onVideoStart(this.f3913a);
        }
    }
}
