package cn.admobiletop.adsuyi.a.l;

/* JADX INFO: loaded from: classes.dex */
public class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f3392a;

    public i(j jVar) {
        this.f3392a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3392a.g("other", true);
        this.f3392a.e(false);
    }
}
