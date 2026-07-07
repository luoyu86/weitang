package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: loaded from: classes.dex */
public class ma implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ sa f4018c;

    public ma(sa saVar, int i2, String str) {
        this.f4018c = saVar;
        this.f4016a = i2;
        this.f4017b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4018c.f4044f.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(this.f4016a, this.f4017b));
    }
}
