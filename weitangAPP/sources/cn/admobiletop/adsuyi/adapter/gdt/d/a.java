package cn.admobiletop.adsuyi.adapter.gdt.d;

import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.adapter.gdt.b.h;
import cn.admobiletop.adsuyi.adapter.gdt.b.j;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import com.qq.e.comm.pi.IBidding;
import com.qq.e.comm.pi.LADI;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiBidAdapterCallback f3712a;

    public a(ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        this.f3712a = aDSuyiBidAdapterCallback;
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.d.c
    public void a(LADI ladi) {
        j jVarA;
        ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback = this.f3712a;
        if (aDSuyiBidAdapterCallback == null) {
            return;
        }
        if (ladi == null) {
            aDSuyiBidAdapterCallback.onFailed("gdt", new ADSuyiError(-1, "Request AD is null").toString());
            return;
        }
        if (ladi.getECPM() > 0) {
            this.f3712a.onSuccess(new h(ladi, ladi.getECPM()));
        } else if (!cn.admobiletop.adsuyi.adapter.gdt.e.a.b() || (jVarA = cn.admobiletop.adsuyi.adapter.gdt.e.a.a(ladi)) == null) {
            this.f3712a.onFailed("gdt", new ADSuyiError(ADSuyiErrorConfig.AD_FAILED_PLATFORM_IS_NO_BID_PERMISSION, ADSuyiErrorConfig.MSG_AD_FAILED_PLATFORM_IS_NO_BID_PERMISSION).toString());
        } else {
            this.f3712a.onSuccess(jVarA);
        }
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.d.c
    public void release() {
        this.f3712a = null;
    }

    @Override // cn.admobiletop.adsuyi.adapter.gdt.d.c
    public void a(AdError adError, LADI ladi) {
        if (this.f3712a == null) {
            return;
        }
        if (ladi != null && adError != null && adError.getErrorCode() == 5004) {
            HashMap map = new HashMap(2);
            map.put(IBidding.LOSS_REASON, 2);
            map.put(IBidding.ADN_ID, 2);
            ladi.sendLossNotification(map);
        }
        this.f3712a.onFailed("gdt", new ADSuyiError(adError == null ? ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY : adError.getErrorCode(), adError == null ? "返回的广告数据为空" : adError.getErrorMsg()).toString());
    }
}
