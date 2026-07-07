package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0301f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0303h f3993c;

    public RunnableC0301f(C0303h c0303h, int i2, String str) {
        this.f3993c = c0303h;
        this.f3991a = i2;
        this.f3992b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3993c.f3998a.f4039f == 0) {
            this.f3993c.f3998a.onAdFailed(this.f3991a, "banner render fail, " + this.f3992b);
        }
    }
}
