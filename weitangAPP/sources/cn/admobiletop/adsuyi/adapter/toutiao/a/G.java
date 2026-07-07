package cn.admobiletop.adsuyi.adapter.toutiao.a;

/* JADX INFO: loaded from: classes.dex */
public class G implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3874a;

    public G(J j) {
        this.f3874a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3874a.k != null) {
            this.f3874a.k.onVideoStart(this.f3874a);
        }
    }
}
