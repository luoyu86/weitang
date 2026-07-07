package cn.admobiletop.adsuyi.a.l;

/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f3380a;

    public f(h hVar) {
        this.f3380a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3380a.A) {
            return;
        }
        this.f3380a.A = true;
        this.f3380a.t();
    }
}
