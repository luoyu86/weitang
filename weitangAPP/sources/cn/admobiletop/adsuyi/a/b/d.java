package cn.admobiletop.adsuyi.a.b;

import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f3179a;

    public d(k kVar) {
        this.f3179a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3179a.m()) {
            return;
        }
        if (this.f3179a.f3194i == null || this.f3179a.f3194i.size() <= 0) {
            ADSuyiLogUtil.ti("ADSuyiParallel", "广告请求列类数量异常状态，进入轮询器抛出错误回调");
            this.f3179a.k();
        } else if (((ADSuyiPlatformPosId) this.f3179a.f3194i.get(0)).isBidType()) {
            ADSuyiLogUtil.ti("ADSuyiParallel", "HB 出价排位第一");
            this.f3179a.r0();
        } else {
            ADSuyiLogUtil.ti("ADSuyiParallel", "瀑布流 出价排位第一");
            this.f3179a.s0();
        }
    }
}
