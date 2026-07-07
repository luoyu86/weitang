package com.bytedance.sdk.openadsdk.bl.ok.ok;

import android.app.Activity;
import android.view.View;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DislikeInfo;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class t implements TTNativeExpressAd {
    private final Bridge ok;

    public t(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        this.ok.call(150105, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, activity);
        return new p((Bridge) this.ok.call(150108, aVarOk.a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public DislikeInfo getDislikeInfo() {
        return new s((Bridge) this.ok.values().objectValue(150003, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return (View) this.ok.values().objectValue(150001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        return this.ok.values().intValue(150002);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        return this.ok.values().intValue(150004);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.ok.values().objectValue(150005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public MediationNativeManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.ok.ok.ok.s((Bridge) this.ok.call(150113, c.d.a.a.a.a.a.ok(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void loss(Double d2, String str, String str2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(3);
        aVarOk.ok(0, d2);
        aVarOk.ok(1, str);
        aVarOk.ok(2, str2);
        this.ok.call(210102, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.ok.call(150104, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.bl.ok.a.ok(tTAdInteractionListener));
        this.ok.call(210104, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setCanInterruptVideoPlay(boolean z) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, z);
        this.ok.call(150112, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(2);
        aVarOk.ok(0, activity);
        aVarOk.ok(1, new com.bytedance.sdk.openadsdk.kf.ok.ok.ok.ok(dislikeInteractionCallback));
        this.ok.call(150106, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, tTDislikeDialogAbstract);
        this.ok.call(150107, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.bl.ok.a.a(tTAppDownloadListener));
        this.ok.call(150103, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.j.ok.ok.ok.a(expressAdInteractionListener));
        this.ok.call(150101, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, d2);
        this.ok.call(210103, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, i2);
        this.ok.call(150110, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setVideoAdListener(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.j.ok.ok.ok.bl(expressVideoAdListener));
        this.ok.call(150111, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(Activity activity) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, activity);
        this.ok.call(150109, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, d2);
        this.ok.call(210101, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.j.ok.ok.ok.ok(adInteractionListener));
        this.ok.call(150102, aVarOk.a(), Void.class);
    }
}
