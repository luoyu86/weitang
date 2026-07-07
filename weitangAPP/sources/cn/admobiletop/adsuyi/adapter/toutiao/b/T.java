package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: loaded from: classes.dex */
public class T implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ W f3962c;

    public T(W w, int i2, String str) {
        this.f3962c = w;
        this.f3960a = i2;
        this.f3961b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3962c.onAdFailed(this.f3960a, this.f3961b);
    }
}
