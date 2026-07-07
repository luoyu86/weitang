package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: loaded from: classes.dex */
public class ia implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ la f4003a;

    public ia(la laVar) {
        this.f4003a = laVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4003a.onAdFailed(-1, "广告对象不存在");
    }
}
