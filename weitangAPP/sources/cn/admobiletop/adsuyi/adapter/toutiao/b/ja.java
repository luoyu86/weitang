package cn.admobiletop.adsuyi.adapter.toutiao.b;

/* JADX INFO: loaded from: classes.dex */
public class ja implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ la f4005a;

    public ja(la laVar) {
        this.f4005a = laVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4005a.onAdFailed(-1, "广告容器异常");
    }
}
