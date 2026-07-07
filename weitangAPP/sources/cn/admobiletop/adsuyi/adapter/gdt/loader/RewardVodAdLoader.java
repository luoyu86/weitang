package cn.admobiletop.adsuyi.adapter.gdt.loader;

import cn.admobiletop.adsuyi.ad.ADSuyiRewardVodAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiExtraParams;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiRewardExtra;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;
import cn.admobiletop.adsuyi.adapter.gdt.b.q;
import cn.admobiletop.adsuyi.adapter.gdt.d.a;
import cn.admobiletop.adsuyi.adapter.gdt.d.b;
import cn.admobiletop.adsuyi.adapter.gdt.d.c;
import cn.admobiletop.adsuyi.bid.ADSuyiBidAdapterCallback;
import cn.admobiletop.adsuyi.bid.ADSuyiBidParams;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiParallelCallback;
import cn.admobiletop.adsuyi.parallel.interf.ADSuyiPreLoadParams;
import cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;

/* JADX INFO: loaded from: classes.dex */
public class RewardVodAdLoader implements ADSuyiAdapterLoader<ADSuyiRewardVodAd, ADSuyiRewardVodAdListener>, ADSuyiBidManager, ParallelAdLoadController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiRewardVodAd f3736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAdapterParams f3737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiRewardVodAdListener f3738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f3739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f3740e;

    public final void a() {
        ADSuyiAdapterParams aDSuyiAdapterParams;
        if (ADSuyiAdUtil.isReleased(this.f3736a) || (aDSuyiAdapterParams = this.f3737b) == null || aDSuyiAdapterParams.getPlatform() == null || this.f3737b.getPlatformPosId() == null || this.f3738c == null) {
            return;
        }
        b(this.f3736a, this.f3737b.getPlatformPosId(), this.f3738c);
    }

    public final void b(ADSuyiRewardVodAd aDSuyiRewardVodAd, ADSuyiPlatformPosId aDSuyiPlatformPosId, ADSuyiRewardVodAdListener aDSuyiRewardVodAdListener) {
        String custom;
        ADSuyiRewardExtra rewardExtra;
        q qVar;
        if (this.f3740e != null && (qVar = this.f3739d) != null) {
            qVar.a();
            return;
        }
        ADSuyiExtraParams localExtraParams = aDSuyiRewardVodAd.getLocalExtraParams();
        String userId = "";
        if (localExtraParams == null || (rewardExtra = localExtraParams.getRewardExtra()) == null) {
            custom = "";
        } else {
            userId = rewardExtra.getUserId();
            custom = rewardExtra.getCustom();
        }
        this.f3739d = new q(aDSuyiPlatformPosId.getPlatformPosId(), aDSuyiRewardVodAdListener, this.f3740e);
        RewardVideoAD rewardVideoAD = new RewardVideoAD(aDSuyiRewardVodAd.getActivity(), aDSuyiPlatformPosId.getPlatformPosId(), this.f3739d, !aDSuyiRewardVodAd.isMute());
        rewardVideoAD.setServerSideVerificationOptions(new ServerSideVerificationOptions.Builder().setUserId(userId).setCustomData(custom).build());
        this.f3739d.a(rewardVideoAD);
        rewardVideoAD.loadAD();
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void bid(ADSuyiBidAdapterCallback aDSuyiBidAdapterCallback) {
        this.f3740e = new a(aDSuyiBidAdapterCallback);
        a();
    }

    @Override // cn.admobiletop.adsuyi.bid.manager.ADSuyiBidManager
    public void init(ADSuyiPlatformPosId aDSuyiPlatformPosId, String str, ADSuyiBidParams aDSuyiBidParams) {
        if (aDSuyiBidParams != null) {
            if (aDSuyiBidParams.getSuyiAd() instanceof ADSuyiRewardVodAd) {
                this.f3736a = (ADSuyiRewardVodAd) aDSuyiBidParams.getSuyiAd();
            }
            this.f3737b = aDSuyiBidParams.getAdapterParams();
            if (aDSuyiBidParams.getListener() instanceof ADSuyiRewardVodAdListener) {
                this.f3738c = (ADSuyiRewardVodAdListener) aDSuyiBidParams.getListener();
            }
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onPaused() {
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void onResumed() {
    }

    @Override // cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController
    public void parallelLoad(ADSuyiPreLoadParams aDSuyiPreLoadParams, String str, ADSuyiParallelCallback aDSuyiParallelCallback) {
        if (aDSuyiPreLoadParams == null) {
            aDSuyiParallelCallback.onFailed("gdt", "并行请求参数错误");
            return;
        }
        if (aDSuyiPreLoadParams.getSuyiAd() instanceof ADSuyiRewardVodAd) {
            this.f3736a = (ADSuyiRewardVodAd) aDSuyiPreLoadParams.getSuyiAd();
        }
        this.f3737b = aDSuyiPreLoadParams.getAdapterParams();
        if (aDSuyiPreLoadParams.getListener() instanceof ADSuyiRewardVodAdListener) {
            this.f3738c = (ADSuyiRewardVodAdListener) aDSuyiPreLoadParams.getListener();
        }
        this.f3740e = new b(aDSuyiParallelCallback);
        a();
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void release() {
        q qVar = this.f3739d;
        if (qVar != null) {
            qVar.release();
            this.f3739d = null;
        }
        this.f3736a = null;
        this.f3737b = null;
        this.f3738c = null;
        c cVar = this.f3740e;
        if (cVar != null) {
            cVar.release();
            this.f3740e = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader
    public void loadAd(ADSuyiRewardVodAd aDSuyiRewardVodAd, ADSuyiAdapterParams aDSuyiAdapterParams, ADSuyiRewardVodAdListener aDSuyiRewardVodAdListener) {
        this.f3736a = aDSuyiRewardVodAd;
        this.f3737b = aDSuyiAdapterParams;
        this.f3738c = aDSuyiRewardVodAdListener;
        a();
    }
}
