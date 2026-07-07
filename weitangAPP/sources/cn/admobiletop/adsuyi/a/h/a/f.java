package cn.admobiletop.adsuyi.a.h.a;

/* JADX INFO: loaded from: classes.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3333b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h f3334c;

    public f(h hVar, int i2, String str) {
        this.f3334c = hVar;
        this.f3332a = i2;
        this.f3333b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3334c.f(this.f3332a, this.f3333b);
    }
}
