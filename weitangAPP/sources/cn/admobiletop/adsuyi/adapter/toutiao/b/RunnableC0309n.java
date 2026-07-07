package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0309n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0311p f4021c;

    public RunnableC0309n(C0311p c0311p, int i2, String str) {
        this.f4021c = c0311p;
        this.f4019a = i2;
        this.f4020b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f4021c.f4029a.f4033f == 0) {
            this.f4021c.f4029a.onAdFailed(this.f4019a, "banner render fail, " + this.f4020b);
        }
    }
}
