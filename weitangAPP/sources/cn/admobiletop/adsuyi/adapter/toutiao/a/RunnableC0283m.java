package cn.admobiletop.adsuyi.adapter.toutiao.a;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0283m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0288s f3909a;

    public RunnableC0283m(C0288s c0288s) {
        this.f3909a = c0288s;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3909a.n != null) {
            this.f3909a.n.onVideoLoad(this.f3909a);
        }
    }
}
