package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k extends c<ADSuyiInnerNoticeAdListener> implements NativeADUnifiedListener {
    public k(String str, ADSuyiInnerNoticeAdListener aDSuyiInnerNoticeAdListener) {
        super(str, aDSuyiInnerNoticeAdListener);
    }

    @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
    public void onADLoaded(List<NativeUnifiedADData> list) {
        if (getAdListener() == 0 || list.isEmpty()) {
            return;
        }
        NativeUnifiedADData nativeUnifiedADData = list.get(0);
        cn.admobiletop.adsuyi.adapter.gdt.a.f fVar = new cn.admobiletop.adsuyi.adapter.gdt.a.f(getPlatformPosId());
        fVar.setAdapterAdInfo(nativeUnifiedADData);
        fVar.setAdListener(getAdListener());
        ((ADSuyiInnerNoticeAdListener) getAdListener()).onAdReceive(fVar);
        ((ADSuyiInnerNoticeAdListener) getAdListener()).onAdReady(fVar);
    }

    @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        onAdFailed(adError.getErrorCode(), adError.getErrorMsg());
    }
}
