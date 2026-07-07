package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.ADSuyiNativeAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class n extends c<ADSuyiNativeAdListener> implements NativeADUnifiedListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiNativeAd f3647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<ADSuyiNativeAdInfo> f3648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.d.c f3649f;

    public n(ADSuyiNativeAd aDSuyiNativeAd, String str, ADSuyiNativeAdListener aDSuyiNativeAdListener, cn.admobiletop.adsuyi.adapter.gdt.d.c cVar) {
        super(str, aDSuyiNativeAdListener);
        this.f3647d = aDSuyiNativeAd;
        this.f3649f = cVar;
    }

    public void a() {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3649f;
        if (cVar != null) {
            cVar.release();
            this.f3649f = null;
        }
        if (getAdListener() != 0) {
            ((ADSuyiNativeAdListener) getAdListener()).onAdReceive(this.f3648e);
        }
    }

    public void b() {
        List<ADSuyiNativeAdInfo> list = this.f3648e;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.f3648e.size(); i2++) {
            try {
                ADSuyiNativeAdInfo aDSuyiNativeAdInfo = this.f3648e.get(i2);
                if (aDSuyiNativeAdInfo != null && (aDSuyiNativeAdInfo instanceof cn.admobiletop.adsuyi.adapter.gdt.a.h)) {
                    ((cn.admobiletop.adsuyi.adapter.gdt.a.h) aDSuyiNativeAdInfo).a();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
    public void onADLoaded(List<NativeUnifiedADData> list) {
        if (list == null || list.isEmpty()) {
            cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3649f;
            if (cVar != null) {
                cVar.a(new AdError(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"), null);
                return;
            } else {
                onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
                return;
            }
        }
        if (getAdListener() == 0 || ADSuyiAdUtil.isReleased(this.f3647d)) {
            return;
        }
        this.f3648e = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            NativeUnifiedADData nativeUnifiedADData = list.get(i2);
            if (nativeUnifiedADData != null) {
                cn.admobiletop.adsuyi.adapter.gdt.a.h hVar = new cn.admobiletop.adsuyi.adapter.gdt.a.h(this.f3647d.isMute(), getPlatformPosId(), this.f3647d);
                hVar.setAdapterAdInfo(nativeUnifiedADData);
                hVar.setAdListener(getAdListener());
                this.f3648e.add(hVar);
            }
        }
        if (this.f3649f == null) {
            a();
        } else {
            this.f3649f.a(list.get(0));
        }
    }

    @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3649f;
        if (cVar != null) {
            cVar.a(adError, null);
        } else {
            onAdFailed(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f3647d = null;
        ADSuyiAdUtil.releaseList(this.f3648e);
        this.f3648e = null;
    }
}
