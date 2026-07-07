package cn.admobiletop.adsuyi.adapter.tianmu.loader;

import cn.admobiletop.adsuyi.ad.ADSuyiRewardVodAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;
import cn.admobiletop.adsuyi.adapter.tianmu.b.o;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.bid.ADSuyiBidParams;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.tianmu.ad.RewardAd;

/* JADX INFO: loaded from: classes.dex */
public class RewardVodAdLoader implements ADSuyiAdapterLoader<ADSuyiRewardVodAd, ADSuyiRewardVodAdListener>, ADSuyiBidManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiRewardVodAd f3852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAdapterParams f3853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiRewardVodAdListener f3854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f3855d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RewardAd f3856e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ADSuyiBidAdapterCallback f3857f;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        if (ADSuyiAdUtil.isReleased(this.f3852a) || (aDSuyiAdapterParams = this.f3853b) == null || aDSuyiAdapterParams.getPlatform() == null || this.f3853b.getPlatformPosId() == null || this.f3854c == null) {
            return;
        }
        b(this.f3852a, this.f3853b.getPlatformPosId(), this.f3854c);
    }

    public final void b(ADSuyiRewardVodAd aDSuyiRewardVodAd, ADSuyiPlatformPosId aDSuyiPlatformPosId, ADSuyiRewardVodAdListener aDSuyiRewardVodAdListener) {
        o oVar;
        if (this.f3857f != null && (oVar = this.f3855d) != null) {
            oVar.a();
            return;
        }
        this.f3855d = new o(aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiRewardVodAdListener, this.f3857f);
        RewardAd rewardAd = new RewardAd(aDSuyiRewardVodAd.getActivity());
        this.f3856e = rewardAd;
        rewardAd.setMute(aDSuyiRewardVodAd.isMute());
        this.f3856e.setListener(this.f3855d);
        this.f3856e.loadAd(aDSuyiPlatformPosId.getPlatformPosId());
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void bid(ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        this.f3857f = aDSuyiBidAdapterCallback;
        a();
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void init(ADSuyiPlatformPosId aDSuyiPlatformPosId, String str, ADSuyiBidParams aDSuyiBidParams) {
        if (aDSuyiBidParams != null) {
            if (aDSuyiBidParams.getSuyiAd() instanceof ADSuyiRewardVodAd) {
                this.f3852a = (ADSuyiRewardVodAd) aDSuyiBidParams.getSuyiAd();
            }
            this.f3853b = aDSuyiBidParams.getAdapterParams();
            if (aDSuyiBidParams.getListener() instanceof ADSuyiRewardVodAdListener) {
                this.f3854c = (ADSuyiRewardVodAdListener) aDSuyiBidParams.getListener();
            }
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        o oVar = this.f3855d;
        if (oVar != null) {
            oVar.release();
            this.f3855d = null;
        }
        RewardAd rewardAd = this.f3856e;
        if (rewardAd != null) {
            rewardAd.release();
            this.f3856e = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiRewardVodAd aDSuyiRewardVodAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiRewardVodAdListener aDSuyiRewardVodAdListener) {
        this.f3852a = aDSuyiRewardVodAd;
        this.f3853b = aDSuyiAdapterParams;
        this.f3854c = aDSuyiRewardVodAdListener;
        a();
    }
}
