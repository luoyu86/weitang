package com.bytedance.sdk.openadsdk.bl.ok.ok;

import android.app.Activity;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationFullScreenManager;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class j implements TTFullScreenVideoAd {
    private final Bridge ok;

    public j(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public long getExpirationTimestamp() {
        return this.ok.values().longValue(130004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getFullVideoAdType() {
        return this.ok.values().intValue(130003);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public int getInteractionType() {
        return this.ok.values().intValue(130001);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.ok.values().objectValue(130002, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public MediationFullScreenManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.ok.ok.ok.bl((Bridge) this.ok.call(130106, c.d.a.a.a.a.a.ok(0).a(), Bridge.class));
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

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.bl.ok.a.a(tTAppDownloadListener));
        this.ok.call(130102, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setFullScreenVideoAdInteractionListener(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.k.ok.ok.ok.ok(fullScreenVideoAdInteractionListener));
        this.ok.call(130101, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, d2);
        this.ok.call(210103, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void setShowDownLoadBar(boolean z) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, z);
        this.ok.call(130105, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, activity);
        this.ok.call(130103, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, d2);
        this.ok.call(210101, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd
    public void showFullScreenVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(3);
        aVarOk.ok(0, activity);
        aVarOk.ok(1, ritScenes);
        aVarOk.ok(2, str);
        this.ok.call(130104, aVarOk.a(), Void.class);
    }
}
