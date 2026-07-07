package cn.admobiletop.adsuyi.adapter.toutiao.a;

/* JADX INFO: loaded from: classes.dex */
public class M implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T f3881a;

    public M(T t) {
        this.f3881a = t;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3881a.o != null) {
            this.f3881a.o.onVideoStart(this.f3881a);
        }
    }
}
