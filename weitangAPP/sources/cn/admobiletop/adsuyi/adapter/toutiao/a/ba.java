package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ad.data.ADSuyiRewardVodAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiRewardVodAdListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ba extends C0273c<ADSuyiRewardVodAdListener, TTRewardVideoAd> implements ADSuyiRewardVodAdInfo, TTRewardVideoAd.RewardAdInteractionListener {
    public boolean k;
    public Handler l;
    public Map<String, Object> m;

    public ba(String str) {
        super(str);
        this.l = new Handler(Looper.getMainLooper());
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(TTRewardVideoAd tTRewardVideoAd) {
        super.setAdapterAdInfo(tTRewardVideoAd);
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().setShowDownLoadBar(true);
            if (4 == getAdapterAdInfo().getInteractionType()) {
                getAdapterAdInfo().setDownloadListener(new cn.admobiletop.adsuyi.adapter.toutiao.b.B());
            }
            getAdapterAdInfo().setRewardAdInteractionListener(this);
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiRewardVodAdInfo
    public Map<String, Object> getRewardMap() {
        if (this.m == null) {
            this.m = new HashMap();
        }
        return this.m;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasExpired() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean hasShown() {
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdClose() {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new X(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdShow() {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new V(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onAdVideoBarClick() {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new W(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardArrived(boolean z, int i2, Bundle bundle) {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new aa(this, z, i2, bundle));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onRewardVerify(boolean z, int i2, String str, int i3, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onSkippedVideo() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoComplete() {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new Y(this));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
    public void onVideoError() {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(new Z(this));
        }
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        setAdapterAdInfo((TTRewardVideoAd) null);
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.l = null;
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiRewardVodAdInfo
    public void showRewardVod(Activity activity) {
        if (activity == null || isReleased() || !isReady() || getAdapterAdInfo() == null || hasShown() || hasExpired()) {
            return;
        }
        this.k = true;
        getAdapterAdInfo().showRewardVideoAd(activity);
    }

    public void a(Map<String, Object> map) {
        this.m = map;
    }
}
