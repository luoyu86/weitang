package cn.admobiletop.adsuyi.adapter.tianmu.loader;

import cn.admobiletop.adsuyi.ad.ADSuyiInnerNoticeAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import cn.admobiletop.adsuyi.adapter.tianmu.b.i;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.tianmu.ad.NativeAd;

/* JADX INFO: loaded from: classes.dex */
public class InnerNoticeAdLoader implements ADSuyiAdapterLoader<ADSuyiInnerNoticeAd, ADSuyiInnerNoticeAdListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f3836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NativeAd f3837b;

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        i iVar = this.f3836a;
        if (iVar != null) {
            iVar.release();
            this.f3836a = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiInnerNoticeAd aDSuyiInnerNoticeAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiInnerNoticeAdListener aDSuyiInnerNoticeAdListener) {
        if (ADSuyiAdUtil.isReleased(aDSuyiInnerNoticeAd) || aDSuyiAdapterParams == null || aDSuyiAdapterParams.getPlatformPosId() == null || aDSuyiInnerNoticeAdListener == null) {
            return;
        }
        ADSuyiPlatformPosId platformPosId = aDSuyiAdapterParams.getPlatformPosId();
        this.f3836a = new i(platformPosId.getPlatformPosId(), aDSuyiInnerNoticeAdListener);
        NativeAd nativeAd = new NativeAd(aDSuyiInnerNoticeAd.getActivity());
        this.f3837b = nativeAd;
        nativeAd.setListener(this.f3836a);
        this.f3837b.loadAd(platformPosId.getPlatformPosId(), 1);
    }
}
