package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: loaded from: classes.dex */
public class X implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ea f3970c;

    public X(ea eaVar, int i2, String str) {
        this.f3970c = eaVar;
        this.f3968a = i2;
        this.f3969b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3970c.m.a(new cn.admobiletop.adsuyi.adapter.toutiao.d.a(this.f3968a, this.f3969b));
    }
}
