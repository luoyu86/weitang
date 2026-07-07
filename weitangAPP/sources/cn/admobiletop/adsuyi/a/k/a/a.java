package cn.admobiletop.adsuyi.a.k.a;

import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f3347a;

    public a(e eVar) {
        this.f3347a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ADSuyiLogUtil.d("HB广告队列请求时间结束：" + this.f3347a.s + " ，抛弃未返回的平台结果，并开始对已返回的竞价结果进行排序");
        this.f3347a.b(true);
        if (this.f3347a.a()) {
            return;
        }
        this.f3347a.C();
    }
}
