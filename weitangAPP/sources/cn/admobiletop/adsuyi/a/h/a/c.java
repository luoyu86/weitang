package cn.admobiletop.adsuyi.a.h.a;

/* JADX INFO: loaded from: classes.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e f3326c;

    public c(e eVar, int i2, String str) {
        this.f3326c = eVar;
        this.f3324a = i2;
        this.f3325b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        e eVar = this.f3326c;
        eVar.f(eVar.f3330b, this.f3324a, this.f3325b);
    }
}
