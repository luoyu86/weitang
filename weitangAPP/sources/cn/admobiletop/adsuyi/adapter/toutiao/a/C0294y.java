package cn.admobiletop.adsuyi.adapter.toutiao.a;

import android.app.Activity;
import androidx.annotation.NonNull;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInterstitialAdInfo;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInterstitialAdListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.adapter.toutiao.a.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0294y extends C0273c<ADSuyiInterstitialAdListener, TTFullScreenVideoAd> implements ADSuyiInterstitialAdInfo, TTFullScreenVideoAd.FullScreenVideoAdInteractionListener, TTAppDownloadListener {
    public boolean k;
    public boolean l;

    public C0294y(String str) {
        super(str);
        this.l = false;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setAdapterAdInfo(TTFullScreenVideoAd tTFullScreenVideoAd) {
        super.setAdapterAdInfo(tTFullScreenVideoAd);
        if (getAdapterAdInfo() != null) {
            getAdapterAdInfo().setShowDownLoadBar(true);
            if (4 == getAdapterAdInfo().getInteractionType()) {
                getAdapterAdInfo().setDownloadListener(new cn.admobiletop.adsuyi.adapter.toutiao.b.B());
            }
            getAdapterAdInfo().setFullScreenVideoAdInteractionListener(this);
            getAdapterAdInfo().setDownloadListener(this);
        }
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

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        if (getAdListener() != 0) {
            ((ADSuyiInterstitialAdListener) getAdListener()).onAdClose(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        if (getAdListener() != 0) {
            ((ADSuyiInterstitialAdListener) getAdListener()).onAdExpose(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        if (getAdListener() != 0) {
            ((ADSuyiInterstitialAdListener) getAdListener()).onAdClick(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        if (this.l) {
            return;
        }
        onAdVideoBarClick();
        this.l = true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
        this.l = false;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
    }

    @Override // cn.admobiletop.adsuyi.adapter.toutiao.a.C0273c, cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo
    public void releaseAdapter() {
        super.releaseAdapter();
        setAdapterAdInfo(null);
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiInterstitialAdInfo
    public void showInterstitial(@NonNull Activity activity) {
        if (activity == null || isReleased() || !isReady() || getAdapterAdInfo() == null || hasShown() || hasExpired()) {
            return;
        }
        this.k = true;
        getAdapterAdInfo().showFullScreenVideoAd(activity);
    }
}
