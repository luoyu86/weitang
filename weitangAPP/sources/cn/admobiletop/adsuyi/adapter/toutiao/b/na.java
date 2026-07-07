package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: loaded from: classes.dex */
public class na implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ sa f4024c;

    public na(sa saVar, int i2, String str) {
        this.f4024c = saVar;
        this.f4022a = i2;
        this.f4023b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4024c.onAdFailed(this.f4022a, this.f4023b);
    }
}
