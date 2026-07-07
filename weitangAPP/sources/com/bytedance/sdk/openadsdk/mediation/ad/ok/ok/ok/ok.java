package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.ok;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a.n;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ok implements IMediationNativeAdInfo {
    private final Bridge ok;

    public ok(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getActionText() {
        return (String) this.ok.call(268005, c.d.a.a.a.a.a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getAdImageMode() {
        return ((Integer) this.ok.call(268009, c.d.a.a.a.a.a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getDescription() {
        return (String) this.ok.call(268002, c.d.a.a.a.a.a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, activity);
        return new a((Bridge) this.ok.call(268102, aVarOk.a(), Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getIconUrl() {
        return (String) this.ok.call(268003, c.d.a.a.a.a.a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public List<String> getImageList() {
        return (List) this.ok.call(268007, c.d.a.a.a.a.a.ok(0).a(), List.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getImageUrl() {
        return (String) this.ok.call(268004, c.d.a.a.a.a.a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public int getInteractionType() {
        return ((Integer) this.ok.call(268010, c.d.a.a.a.a.a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationNativeAdAppInfo getNativeAdAppInfo() {
        return new bl((Bridge) this.ok.values().objectValue(268101, Bridge.class));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getSource() {
        return (String) this.ok.call(268008, c.d.a.a.a.a.a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public double getStarRating() {
        return ((Double) this.ok.call(268006, c.d.a.a.a.a.a.ok(0).a(), Double.TYPE)).doubleValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public String getTitle() {
        return (String) this.ok.call(268001, c.d.a.a.a.a.a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public boolean hasDislike() {
        return ((Boolean) this.ok.call(268012, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, IMediationViewBinder iMediationViewBinder) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(6);
        aVarOk.ok(0, activity);
        aVarOk.ok(1, viewGroup);
        aVarOk.ok(2, list);
        aVarOk.ok(3, list2);
        aVarOk.ok(4, list3);
        aVarOk.ok(5, new n(iMediationViewBinder));
        this.ok.call(268011, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeAdInfo
    public MediationAdDislike getDislikeDialog(Activity activity, Map<String, Object> map) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(2);
        aVarOk.ok(0, activity);
        aVarOk.ok(1, map);
        return new a((Bridge) this.ok.call(268103, aVarOk.a(), Bridge.class));
    }
}
