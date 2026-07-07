package cn.admobiletop.adsuyi.adapter.gdt.loader;

import android.content.Context;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.ADSuyiInnerNoticeAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import cn.admobiletop.adsuyi.adapter.gdt.b.k;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.qq.e.ads.nativ.NativeUnifiedAD;

/* JADX INFO: loaded from: classes.dex */
public class InnerNoticeAdLoader implements ADSuyiAdapterLoader<ADSuyiInnerNoticeAd, ADSuyiInnerNoticeAdListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k f3723a;

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        k kVar = this.f3723a;
        if (kVar != null) {
            kVar.release();
            this.f3723a = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiInnerNoticeAd aDSuyiInnerNoticeAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiInnerNoticeAdListener aDSuyiInnerNoticeAdListener) {
        if (ADSuyiAdUtil.isReleased(aDSuyiInnerNoticeAd) || aDSuyiAdapterParams == null || aDSuyiAdapterParams.getPlatformPosId() == null || aDSuyiInnerNoticeAdListener == null) {
            return;
        }
        Context context = ADSuyiSdk.getInstance().getContext();
        ADSuyiPlatformPosId platformPosId = aDSuyiAdapterParams.getPlatformPosId();
        this.f3723a = new k(platformPosId.getPlatformPosId(), aDSuyiInnerNoticeAdListener);
        new NativeUnifiedAD(context, platformPosId.getPlatformPosId(), this.f3723a).loadData(1);
    }
}
