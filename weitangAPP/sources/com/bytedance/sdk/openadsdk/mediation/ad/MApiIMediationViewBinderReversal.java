package com.bytedance.sdk.openadsdk.mediation.ad;

import c.d.a.a.a.a.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MApiIMediationViewBinderReversal implements IMediationViewBinderReversal {
    private final Bridge ok;

    public MApiIMediationViewBinderReversal(Bridge bridge) {
        this.ok = bridge == null ? a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getCallToActionId() {
        return ((Integer) this.ok.call(271024, a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getDecriptionTextId() {
        return ((Integer) this.ok.call(271023, a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public Map<String, Integer> getExtras() {
        return (Map) this.ok.call(271034, a.ok(0).a(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage1Id() {
        return ((Integer) this.ok.call(271029, a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage2Id() {
        return ((Integer) this.ok.call(271030, a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getGroupImage3Id() {
        return ((Integer) this.ok.call(271031, a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getIconImageId() {
        return ((Integer) this.ok.call(271025, a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLayoutId() {
        return ((Integer) this.ok.call(271021, a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getLogoLayoutId() {
        return ((Integer) this.ok.call(271032, a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMainImageId() {
        return ((Integer) this.ok.call(271026, a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getMediaViewId() {
        return ((Integer) this.ok.call(271027, a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getShakeViewContainerId() {
        return ((Integer) this.ok.call(271033, a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getSourceId() {
        return ((Integer) this.ok.call(271028, a.ok(0).a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinderReversal
    public int getTitleId() {
        return ((Integer) this.ok.call(271022, a.ok(0).a(), Integer.TYPE)).intValue();
    }
}
