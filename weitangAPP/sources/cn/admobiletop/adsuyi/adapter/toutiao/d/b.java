package cn.admobiletop.adsuyi.adapter.toutiao.d;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiParallelCallback;
import com.bytedance.sdk.openadsdk.TTClientBidding;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiParallelCallback f4065a;

    public b(ADSuyiParallelCallback aDSuyiParallelCallback) {
        this.f4065a = aDSuyiParallelCallback;
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.d.c
    public void a(TTClientBidding tTClientBidding) {
        ADSuyiParallelCallback aDSuyiParallelCallback = this.f4065a;
        if (aDSuyiParallelCallback == null) {
            return;
        }
        if (tTClientBidding == null) {
            aDSuyiParallelCallback.onFailed(ADSuyiIniter.PLATFORM, new ADSuyiError(-1, "TTAD is null").toString());
        } else {
            aDSuyiParallelCallback.onSuccess();
        }
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.d.c
    public void release() {
        this.f4065a = null;
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.d.c
    public void a(a aVar) {
        ADSuyiParallelCallback aDSuyiParallelCallback = this.f4065a;
        if (aDSuyiParallelCallback == null) {
            return;
        }
        aDSuyiParallelCallback.onFailed(ADSuyiIniter.PLATFORM, new ADSuyiError(aVar == null ? ADSuyiErrorConfig.AD_FAILED_GET_AD_EXCEPTION : aVar.a(), aVar == null ? "获取广告时发生未知异常" : aVar.b()).toString());
    }
}
