package cn.admobiletop.adsuyi.adapter.toutiao.a;

/* JADX INFO: loaded from: classes.dex */
public class N implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T f3882a;

    public N(T t) {
        this.f3882a = t;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3882a.o != null) {
            this.f3882a.o.onVideoPause(this.f3882a);
        }
    }
}
