package cn.admobiletop.adsuyi.adapter.toutiao.a;

/* JADX INFO: loaded from: classes.dex */
public class K implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T f3877a;

    public K(T t) {
        this.f3877a = t;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3877a.o != null) {
            this.f3877a.o.onVideoLoad(this.f3877a);
        }
    }
}
