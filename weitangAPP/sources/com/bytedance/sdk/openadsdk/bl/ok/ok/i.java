package com.bytedance.sdk.openadsdk.bl.ok.ok;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationRewardManager;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i implements TTRewardVideoAd {
    private final Bridge ok;

    public i(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public long getExpirationTimestamp() {
        return this.ok.values().longValue(120004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getInteractionType() {
        return this.ok.values().intValue(120001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.ok.values().objectValue(120002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public MediationRewardManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.ok.ok.ok.n((Bridge) this.ok.call(121109, c.d.a.a.a.a.a.ok(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public int getRewardVideoAdType() {
        return this.ok.values().intValue(120003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d2, String str, String str2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(3);
        aVarOk.ok(0, d2);
        aVarOk.ok(1, str);
        aVarOk.ok(2, str2);
        this.ok.call(210102, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.bl.ok.a.ok(tTAdInteractionListener));
        this.ok.call(210104, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.bl.ok.a.a(tTAppDownloadListener));
        this.ok.call(120104, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, d2);
        this.ok.call(210103, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardAdInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.z.ok.ok.ok.ok(rewardAdInteractionListener));
        this.ok.call(120101, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainController(TTRewardVideoAd.RewardAdPlayAgainController rewardAdPlayAgainController) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.z.ok.ok.ok.a(rewardAdPlayAgainController));
        this.ok.call(120103, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setRewardPlayAgainInteractionListener(TTRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.z.ok.ok.ok.ok(rewardAdInteractionListener));
        this.ok.call(120102, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void setShowDownLoadBar(boolean z) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, z);
        this.ok.call(120107, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, activity);
        this.ok.call(120105, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, d2);
        this.ok.call(210101, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd
    public void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(3);
        aVarOk.ok(0, activity);
        aVarOk.ok(1, ritScenes);
        aVarOk.ok(2, str);
        this.ok.call(120106, aVarOk.a(), Void.class);
    }
}
