package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: loaded from: classes.dex */
public class M implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S f3950c;

    public M(S s, int i2, String str) {
        this.f3950c = s;
        this.f3948a = i2;
        this.f3949b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3950c.onAdFailed(this.f3948a, this.f3949b);
    }
}
