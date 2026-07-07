package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.b.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class RunnableC0296a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f3977c;

    public RunnableC0296a(r rVar, int i2, String str) {
        this.f3977c = rVar;
        this.f3975a = i2;
        this.f3976b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3977c.onAdFailed(this.f3975a, this.f3976b);
    }
}
