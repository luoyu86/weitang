package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.data.ADSuyiDrawVodAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiDrawVodAdListener;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class d extends c<ADSuyiDrawVodAdListener> implements NativeADUnifiedListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3630d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3631e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<ADSuyiDrawVodAdInfo> f3632f;

    public d(int i2, int i3, String str, ADSuyiDrawVodAdListener aDSuyiDrawVodAdListener) {
        super(str, aDSuyiDrawVodAdListener);
        this.f3630d = i2;
        this.f3631e = i3;
    }

    public void a() {
        List<ADSuyiDrawVodAdInfo> list = this.f3632f;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < this.f3632f.size(); i2++) {
            try {
                ADSuyiDrawVodAdInfo aDSuyiDrawVodAdInfo = this.f3632f.get(i2);
                if (aDSuyiDrawVodAdInfo != null && (aDSuyiDrawVodAdInfo instanceof cn.admobiletop.adsuyi.adapter.gdt.a.c)) {
                    ((cn.admobiletop.adsuyi.adapter.gdt.a.c) aDSuyiDrawVodAdInfo).a();
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
            onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
            return;
        }
        this.f3632f = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            NativeUnifiedADData nativeUnifiedADData = list.get(i2);
            if (this.f3632f != null && nativeUnifiedADData != null) {
                cn.admobiletop.adsuyi.adapter.gdt.a.c cVar = new cn.admobiletop.adsuyi.adapter.gdt.a.c(this.f3630d, this.f3631e, getPlatformPosId());
                cVar.setAdapterAdInfo(nativeUnifiedADData);
                cVar.setAdListener(getAdListener());
                this.f3632f.add(cVar);
            }
        }
        if (getAdListener() != 0) {
            ((ADSuyiDrawVodAdListener) getAdListener()).onAdReceive(this.f3632f);
        }
    }

    @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        onAdFailed(adError.getErrorCode(), adError.getErrorMsg());
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        ADSuyiAdUtil.releaseList(this.f3632f);
        this.f3632f = null;
    }
}
