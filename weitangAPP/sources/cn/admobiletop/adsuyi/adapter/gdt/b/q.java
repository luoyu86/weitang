package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;
import cn.admobiletop.adsuyi.config.ADSuyiErrorConfig;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class q extends c<ADSuyiRewardVodAdListener> implements RewardVideoADListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RewardVideoAD f3658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.a.k f3659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public cn.admobiletop.adsuyi.adapter.gdt.d.c f3660f;

    public q(String str, ADSuyiRewardVodAdListener aDSuyiRewardVodAdListener, cn.admobiletop.adsuyi.adapter.gdt.d.c cVar) {
        super(str, aDSuyiRewardVodAdListener);
        this.f3660f = cVar;
    }

    public void a(RewardVideoAD rewardVideoAD) {
        this.f3658d = rewardVideoAD;
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClick() {
        if (getAdListener() == 0 || this.f3659e == null) {
            return;
        }
        ((ADSuyiRewardVodAdListener) getAdListener()).onAdClick(this.f3659e);
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADClose() {
        if (getAdListener() == 0 || this.f3659e == null) {
            return;
        }
        ((ADSuyiRewardVodAdListener) getAdListener()).onAdClose(this.f3659e);
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADExpose() {
        if (getAdListener() == 0 || this.f3659e == null) {
            return;
        }
        ((ADSuyiRewardVodAdListener) getAdListener()).onAdExpose(this.f3659e);
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADLoad() {
        if (getAdListener() != 0) {
            cn.admobiletop.adsuyi.adapter.gdt.a.k kVar = new cn.admobiletop.adsuyi.adapter.gdt.a.k(getPlatformPosId());
            this.f3659e = kVar;
            kVar.setAdapterAdInfo(this.f3658d);
            cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3660f;
            if (cVar != null) {
                cVar.a(this.f3658d);
            } else {
                a();
            }
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onADShow() {
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onError(AdError adError) {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3660f;
        if (cVar != null) {
            cVar.a(adError, this.f3658d);
        } else {
            onAdFailed(adError.getErrorCode(), adError.getErrorMsg());
        }
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onReward(Map<String, Object> map) {
        cn.admobiletop.adsuyi.adapter.gdt.a.k kVar;
        if (getAdListener() == 0 || (kVar = this.f3659e) == null) {
            return;
        }
        kVar.a(map);
        ((ADSuyiRewardVodAdListener) getAdListener()).onReward(this.f3659e);
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoCached() {
        if (this.f3660f != null || getAdListener() == 0 || this.f3659e == null) {
            return;
        }
        ((ADSuyiRewardVodAdListener) getAdListener()).onVideoCache(this.f3659e);
    }

    @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
    public void onVideoComplete() {
        if (getAdListener() == 0 || this.f3659e == null) {
            return;
        }
        ((ADSuyiRewardVodAdListener) getAdListener()).onVideoComplete(this.f3659e);
    }

    @Override // cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterBaseAdListener
    public void release() {
        super.release();
        this.f3658d = null;
        cn.admobiletop.adsuyi.adapter.gdt.a.k kVar = this.f3659e;
        if (kVar != null) {
            kVar.release();
            this.f3659e = null;
        }
    }

    public void a() {
        cn.admobiletop.adsuyi.adapter.gdt.d.c cVar = this.f3660f;
        if (cVar != null) {
            cVar.release();
            this.f3660f = null;
        }
        if (getAdListener() != 0) {
            if (this.f3659e == null) {
                onAdFailed(ADSuyiErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空");
            } else {
                ((ADSuyiRewardVodAdListener) getAdListener()).onAdReceive(this.f3659e);
                ((ADSuyiRewardVodAdListener) getAdListener()).onVideoCache(this.f3659e);
            }
        }
    }
}
