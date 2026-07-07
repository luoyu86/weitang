package cn.admobiletop.adsuyi.adapter.toutiao.a;

/* JADX INFO: loaded from: classes.dex */
public class O implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T f3883a;

    public O(T t) {
        this.f3883a = t;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3883a.o != null) {
            this.f3883a.o.onVideoComplete(this.f3883a);
        }
    }
}
