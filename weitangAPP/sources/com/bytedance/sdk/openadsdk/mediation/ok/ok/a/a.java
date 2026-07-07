package com.bytedance.sdk.openadsdk.mediation.ok.ok.a;

import android.os.Bundle;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.IMediationInterstitialFullAdListener;

/* JADX INFO: loaded from: classes.dex */
public class a implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IMediationInterstitialFullAdListener f6441a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public a(IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener) {
        this.f6441a = iMediationInterstitialFullAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        IMediationInterstitialFullAdListener iMediationInterstitialFullAdListener = this.f6441a;
        if (iMediationInterstitialFullAdListener == null) {
            return null;
        }
        switch (i2) {
            case 131101:
                iMediationInterstitialFullAdListener.onAdShow();
                break;
            case 131102:
                iMediationInterstitialFullAdListener.onAdVideoBarClick();
                break;
            case 131103:
                iMediationInterstitialFullAdListener.onAdClose();
                break;
            case 131104:
                iMediationInterstitialFullAdListener.onVideoComplete();
                break;
            case 131105:
                iMediationInterstitialFullAdListener.onSkippedVideo();
                break;
            case 131106:
                this.f6441a.onInterstitialFullShowFail(valueSet.intValue(0), (String) valueSet.objectValue(1, String.class));
                break;
            case 131107:
                iMediationInterstitialFullAdListener.onVideoError();
                break;
            case 131108:
                iMediationInterstitialFullAdListener.onAdOpened();
                break;
            case 131109:
                iMediationInterstitialFullAdListener.onAdLeftApplication();
                break;
            case 131110:
                this.f6441a.onRewardVerify((Bundle) valueSet.objectValue(0, Bundle.class));
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
