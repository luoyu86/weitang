package cn.admobiletop.adsuyi.adapter.toutiao.a;

/* JADX INFO: loaded from: classes.dex */
public class E implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3870a;

    public E(J j) {
        this.f3870a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3870a.k != null) {
            this.f3870a.k.onVideoLoad(this.f3870a);
        }
    }
}
