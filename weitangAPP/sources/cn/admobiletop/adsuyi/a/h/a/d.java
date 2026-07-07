package cn.admobiletop.adsuyi.a.h.a;

/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cn.admobiletop.adsuyi.a.g.a f3327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f3328b;

    public d(e eVar, cn.admobiletop.adsuyi.a.g.a aVar) {
        this.f3328b = eVar;
        this.f3327a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3328b.e(this.f3327a);
    }
}
