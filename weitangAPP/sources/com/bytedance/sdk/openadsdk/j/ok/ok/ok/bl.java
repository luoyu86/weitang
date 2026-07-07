package com.bytedance.sdk.openadsdk.j.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;

/* JADX INFO: loaded from: classes.dex */
public class bl implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTNativeExpressAd.ExpressVideoAdListener f6383a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public bl(TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener) {
        this.f6383a = expressVideoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.f6383a;
        if (expressVideoAdListener == null) {
            return null;
        }
        switch (i2) {
            case 152101:
                expressVideoAdListener.onVideoLoad();
                break;
            case 152102:
                this.f6383a.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
                break;
            case 152103:
                expressVideoAdListener.onVideoAdStartPlay();
                break;
            case 152104:
                expressVideoAdListener.onVideoAdPaused();
                break;
            case 152105:
                expressVideoAdListener.onVideoAdContinuePlay();
                break;
            case 152106:
                this.f6383a.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                break;
            case 152107:
                expressVideoAdListener.onVideoAdComplete();
                break;
            case 152108:
                expressVideoAdListener.onClickRetry();
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
