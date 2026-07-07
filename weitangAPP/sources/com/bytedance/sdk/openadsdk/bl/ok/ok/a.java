package com.bytedance.sdk.openadsdk.bl.ok.ok;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.TTAdInteractionListener;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements CSJSplashAd {
    private final Bridge ok;

    public a(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int getInteractionType() {
        return this.ok.values().intValue(110004);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public Map<String, Object> getMediaExtraInfo() {
        return (Map) this.ok.values().objectValue(110005, Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public MediationSplashManager getMediationManager() {
        return new com.bytedance.sdk.openadsdk.mediation.manager.ok.ok.ok.kf((Bridge) this.ok.call(110110, c.d.a.a.a.a.a.ok(0).a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashCardView() {
        return (View) this.ok.values().objectValue(110003, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public int[] getSplashClickEyeSizeToDp() {
        return (int[]) this.ok.values().objectValue(110006, int[].class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashClickEyeView() {
        return (View) this.ok.values().objectValue(110002, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public View getSplashView() {
        return (View) this.ok.values().objectValue(110001, View.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void hideSkipButton() {
        this.ok.call(110101, c.d.a.a.a.a.a.ok(0).a(), Void.class);
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

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.bl.ok.a.a(tTAppDownloadListener));
        this.ok.call(110102, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void setPrice(Double d2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, d2);
        this.ok.call(210103, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashAdListener(CSJSplashAd.SplashAdListener splashAdListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.a.ok.ok.ok.ok(splashAdListener));
        this.ok.call(110103, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashCardListener(CSJSplashAd.SplashCardListener splashCardListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.a.ok.ok.ok.a(splashCardListener));
        this.ok.call(110106, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void setSplashClickEyeListener(CSJSplashAd.SplashClickEyeListener splashClickEyeListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new com.bytedance.sdk.openadsdk.a.ok.ok.ok.bl(splashClickEyeListener));
        this.ok.call(110105, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(2);
        aVarOk.ok(0, viewGroup);
        aVarOk.ok(1, activity);
        this.ok.call(110109, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashClickEyeView(ViewGroup viewGroup) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, viewGroup);
        this.ok.call(110107, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void showSplashView(ViewGroup viewGroup) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, viewGroup);
        this.ok.call(110108, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.CSJSplashAd
    public void startClickEye() {
        this.ok.call(110104, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTClientBidding
    public void win(Double d2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, d2);
        this.ok.call(210101, aVarOk.a(), Void.class);
    }
}
