package com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationNativeToBannerListener;

/* JADX INFO: loaded from: classes.dex */
public class bl implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IMediationNativeToBannerListener f6411a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public bl(IMediationNativeToBannerListener iMediationNativeToBannerListener) {
        this.f6411a = iMediationNativeToBannerListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6411a == null) {
            return null;
        }
        if (i2 != 266013) {
            ok(i2, valueSet, cls);
            return null;
        }
        return (T) this.f6411a.getMediationBannerViewFromNativeAd(new com.bytedance.sdk.openadsdk.mediation.ad.ok.ok.ok.ok((Bridge) valueSet.objectValue(0, Bridge.class)));
    }

    public void ok(int i2, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
