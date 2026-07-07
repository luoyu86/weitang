package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: loaded from: classes.dex */
public class Y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ea f3973c;

    public Y(ea eaVar, int i2, String str) {
        this.f3973c = eaVar;
        this.f3971a = i2;
        this.f3972b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3973c.onAdFailed(this.f3971a, this.f3972b);
    }
}
