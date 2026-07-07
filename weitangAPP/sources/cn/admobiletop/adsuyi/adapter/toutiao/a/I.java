package cn.admobiletop.adsuyi.adapter.toutiao.a;

/* JADX INFO: loaded from: classes.dex */
public class I implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3876a;

    public I(J j) {
        this.f3876a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3876a.k != null) {
            this.f3876a.k.onVideoComplete(this.f3876a);
        }
    }
}
