package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0304i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0312q f4002c;

    public RunnableC0304i(C0312q c0312q, int i2, String str) {
        this.f4002c = c0312q;
        this.f4000a = i2;
        this.f4001b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4002c.onAdFailed(this.f4000a, this.f4001b);
    }
}
