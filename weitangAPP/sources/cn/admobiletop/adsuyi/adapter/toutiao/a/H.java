package cn.admobiletop.adsuyi.adapter.toutiao.a;

/* JADX INFO: loaded from: classes.dex */
public class H implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3875a;

    public H(J j) {
        this.f3875a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3875a.k != null) {
            this.f3875a.k.onVideoPause(this.f3875a);
        }
    }
}
