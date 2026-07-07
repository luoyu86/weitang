package cn.admobiletop.adsuyi.adapter.gdt.d;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiParallelCallback;
import com.qq.e.comm.pi.LADI;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiParallelCallback f3713a;

    public b(ADSuyiParallelCallback aDSuyiParallelCallback) {
        this.f3713a = aDSuyiParallelCallback;
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.d.c
    public void a(LADI ladi) {
        ADSuyiParallelCallback aDSuyiParallelCallback = this.f3713a;
        if (aDSuyiParallelCallback == null) {
            return;
        }
        if (ladi == null) {
            aDSuyiParallelCallback.onFailed("gdt", new ADSuyiError(-1, "GDTAD is null").toString());
        } else {
            aDSuyiParallelCallback.onSuccess();
        }
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.d.c
    public void release() {
        this.f3713a = null;
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.d.c
    public void a(AdError adError, LADI ladi) {
        ADSuyiParallelCallback aDSuyiParallelCallback = this.f3713a;
        if (aDSuyiParallelCallback == null) {
            return;
        }
        aDSuyiParallelCallback.onFailed("gdt", new ADSuyiError(adError == null ? ADSuyiErrorConfig.AD_FAILED_GET_AD_EXCEPTION : adError.getErrorCode(), adError == null ? "获取广告时发生未知异常" : adError.getErrorMsg()).toString());
    }
}
