package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.data.ADSuyiNativeAdInfo;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiNativeAdListener;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class o extends c<ADSuyiNativeAdListener> implements NativeExpressAD.NativeExpressADListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<ADSuyiNativeAdInfo> f3651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.d.c f3652f;

    public o(String str, String str2, ADSuyiNativeAdListener aDSuyiNativeAdListener, cn.admobiletop.adsuyi.adapter.gdt.d.c cVar) {
        super(str2, aDSuyiNativeAdListener);
        this.f3650d = str;
        this.f3652f = cVar;
    }

    public void a() {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3652f;
        if (cVar != null) {
            cVar.release();
            this.f3652f = null;
        }
        if (getAdListener() != 0) {
            ((ADSuyiNativeAdListener) getAdListener()).onAdReceive(this.f3651e);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClicked(NativeExpressADView nativeExpressADView) {
        ADSuyiNativeAdInfo aDSuyiNativeAdInfo;
        if (getAdListener() == 0 || (aDSuyiNativeAdInfo = (ADSuyiNativeAdInfo) ADSuyiAdUtil.getAdInfoWithAdapterAdInfo(this.f3651e, nativeExpressADView)) == null) {
            return;
        }
        ((ADSuyiNativeAdListener) getAdListener()).onAdClick(aDSuyiNativeAdInfo);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADClosed(NativeExpressADView nativeExpressADView) {
        ADSuyiNativeAdInfo aDSuyiNativeAdInfo;
        if (getAdListener() == 0 || (aDSuyiNativeAdInfo = (ADSuyiNativeAdInfo) ADSuyiAdUtil.getAdInfoWithAdapterAdInfo(this.f3651e, nativeExpressADView)) == null) {
            return;
        }
        ((ADSuyiNativeAdListener) getAdListener()).onAdClose(aDSuyiNativeAdInfo);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADExposure(NativeExpressADView nativeExpressADView) {
        ADSuyiNativeAdInfo aDSuyiNativeAdInfo;
        if (getAdListener() == 0 || (aDSuyiNativeAdInfo = (ADSuyiNativeAdInfo) ADSuyiAdUtil.getAdInfoWithAdapterAdInfo(this.f3651e, nativeExpressADView)) == null) {
            return;
        }
        ((ADSuyiNativeAdListener) getAdListener()).onAdExpose(aDSuyiNativeAdInfo);
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onADLoaded(List<NativeExpressADView> list) {
        if (list == null || list.isEmpty()) {
            cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3652f;
            if (cVar != null) {
                cVar.a(new AdError(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"), null);
                return;
            } else {
                onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
                return;
            }
        }
        if (getAdListener() != 0) {
            this.f3651e = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                cn.admobiletop.adsuyi.adapter.gdt.a.i iVar = new cn.admobiletop.adsuyi.adapter.gdt.a.i(this.f3650d, getPlatformPosId());
                iVar.setAdapterAdInfo(list.get(i2));
                iVar.setAdListener(getAdListener());
                this.f3651e.add(iVar);
            }
            if (this.f3652f == null) {
                a();
            } else {
                this.f3652f.a(list.get(0));
            }
        }
    }

    @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3652f;
        if (cVar != null) {
            cVar.a(adError, null);
        } else {
            onAdFailed(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderFail(NativeExpressADView nativeExpressADView) {
        ADSuyiNativeAdInfo aDSuyiNativeAdInfo;
        if (getAdListener() == 0 || (aDSuyiNativeAdInfo = (ADSuyiNativeAdInfo) ADSuyiAdUtil.getAdInfoWithAdapterAdInfo(this.f3651e, nativeExpressADView)) == null) {
            return;
        }
        ((ADSuyiNativeAdListener) getAdListener()).onRenderFailed(aDSuyiNativeAdInfo, new ADSuyiError(-1, "unknown"));
    }

    @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
    public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        ADSuyiAdUtil.releaseList(this.f3651e);
        this.f3651e = null;
    }
}
