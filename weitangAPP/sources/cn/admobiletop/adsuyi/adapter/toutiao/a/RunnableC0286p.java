package cn.admobiletop.adsuyi.adapter.toutiao.a;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0286p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0288s f3914a;

    public RunnableC0286p(C0288s c0288s) {
        this.f3914a = c0288s;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3914a.n != null) {
            this.f3914a.n.onVideoPause(this.f3914a);
        }
    }
}
