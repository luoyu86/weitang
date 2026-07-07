package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: loaded from: classes.dex */
public class C implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ F f3929c;

    public C(F f2, int i2, String str) {
        this.f3929c = f2;
        this.f3927a = i2;
        this.f3928b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3929c.onAdFailed(this.f3927a, this.f3928b);
    }
}
