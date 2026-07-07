package com.tianmu.ad;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.tianmu.ad.base.BaseAd;
import com.tianmu.ad.bean.RewardAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.ad.listener.RewardAdListener;
import com.tianmu.c.b.a;
import com.tianmu.c.i.f;
import com.tianmu.c.i.l;
import com.tianmu.c.k.f.c;
import com.tianmu.c.m.e;
import com.tianmu.c.n.n;
import com.tianmu.config.TianmuErrorConfig;

/* JADX INFO: loaded from: classes2.dex */
public class RewardAd extends BaseAd<RewardAdListener> {
    private e m;
    private com.tianmu.c.i.e n;
    private boolean o;
    private RewardAdInfo p;

    public RewardAd(Context context) {
        super(context);
    }

    @Override // com.tianmu.ad.base.BaseAd
    public String getAdType() {
        return "rewardvod";
    }

    @Override // com.tianmu.ad.base.BaseAd
    public int getRenderType() {
        return 0;
    }

    public void loadAd(String str) {
        loadAd(str, 1);
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void release() {
        super.release();
        Handler handler = this.f10621a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f10621a = null;
        }
        RewardAdInfo rewardAdInfo = this.p;
        if (rewardAdInfo != null) {
            rewardAdInfo.release();
            this.p = null;
        }
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void requestAdInfo(com.tianmu.c.c.e eVar) {
        a.a(getPosId(), getAdType(), new c(getPosId(), getAdType(), this.f10621a) { // from class: com.tianmu.ad.RewardAd.1
            @Override // com.tianmu.c.k.f.c
            public void a(l lVar) {
                if (lVar == null || lVar.a() == null || lVar.a().size() == 0) {
                    RewardAd.this.onAdFailed(new TianmuError(TianmuErrorConfig.AD_FAILED_AD_IS_EMPTY, "返回的广告数据为空"));
                    return;
                }
                com.tianmu.c.i.c cVar = lVar.a().get(0);
                RewardAd rewardAd = RewardAd.this;
                RewardAdListener listener = rewardAd.getListener();
                RewardAd rewardAd2 = RewardAd.this;
                rewardAd.p = new RewardAdInfo(lVar, listener, rewardAd2, rewardAd2.getAdPosId().j(), RewardAd.this.getAdPosId().i(), RewardAd.this.m);
                RewardAd.this.p.setMute(RewardAd.this.o);
                if (!(cVar instanceof f)) {
                    RewardAd.this.onAdFailed(new TianmuError(TianmuErrorConfig.AD_MATERIAL_DELIVERY_TYPE_INCORRECT, TianmuErrorConfig.MSG_AD_MATERIAL_DELIVERY_TYPE_INCORRECT));
                    return;
                }
                f fVar = (f) cVar;
                if (TextUtils.isEmpty(fVar.getVideoUrl())) {
                    RewardAd.this.onAdFailed(new TianmuError(TianmuErrorConfig.AD_MATERIAL_DELIVERY_TYPE_REWARD_VIDEO_URL, TianmuErrorConfig.MSG_AD_MATERIAL_DELIVERY_TYPE_REWARD_VIDEO_URL));
                } else {
                    fVar.cache();
                    RewardAd.this.m.onAdReceive(RewardAd.this.p);
                }
            }

            @Override // com.tianmu.c.k.f.c
            public void a(int i2, String str) {
                RewardAd.this.onAdFailed(new TianmuError(i2, str));
            }
        });
    }

    public void setMute(boolean z) {
        this.o = z;
    }

    public void setSensorDisable(boolean z) {
        this.f10629i = z;
    }

    @Override // com.tianmu.ad.base.BaseAd
    public void startLoopLoadAd() {
        e eVar = this.m;
        if (eVar != null) {
            eVar.a(this.n, getCount());
        }
    }

    @Override // com.tianmu.ad.base.BaseAd
    public com.tianmu.c.c.e a() {
        this.n = n.D().a(getPosId());
        e eVar = new e(this, this.f10621a);
        this.m = eVar;
        return eVar;
    }
}
