package com.bytedance.sdk.openadsdk.k.ok.ok.ok;

import c.d.a.a.a.a.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTFullScreenVideoAd.FullScreenVideoAdInteractionListener f6385a;
    private ValueSet ok = a.f918a;

    public ok(TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.f6385a = fullScreenVideoAdInteractionListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        TTFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.f6385a;
        if (fullScreenVideoAdInteractionListener == null) {
            return null;
        }
        switch (i2) {
            case 131101:
                fullScreenVideoAdInteractionListener.onAdShow();
                break;
            case 131102:
                fullScreenVideoAdInteractionListener.onAdVideoBarClick();
                break;
            case 131103:
                fullScreenVideoAdInteractionListener.onAdClose();
                break;
            case 131104:
                fullScreenVideoAdInteractionListener.onVideoComplete();
                break;
            case 131105:
                fullScreenVideoAdInteractionListener.onSkippedVideo();
                break;
        }
        ok(i2, valueSet, cls);
        return null;
    }

    public void ok(int i2, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.ok;
    }
}
