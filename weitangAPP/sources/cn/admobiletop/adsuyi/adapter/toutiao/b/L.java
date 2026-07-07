package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: loaded from: classes.dex */
public class L implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S f3947c;

    public L(S s, int i2, String str) {
        this.f3947c = s;
        this.f3945a = i2;
        this.f3946b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3947c.f3959g.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(this.f3945a, this.f3946b));
    }
}
