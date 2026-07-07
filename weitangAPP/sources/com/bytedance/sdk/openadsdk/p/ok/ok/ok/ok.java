package com.bytedance.sdk.openadsdk.p.ok.ok.ok;

import c.d.a.a.a.a.a;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTDrawFeedAd.DrawVideoListener f6452a;
    private ValueSet ok = a.f918a;

    public ok(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.f6452a = drawVideoListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        TTDrawFeedAd.DrawVideoListener drawVideoListener = this.f6452a;
        if (drawVideoListener == null) {
            return null;
        }
        switch (i2) {
            case 171101:
                drawVideoListener.onClick();
                break;
            case 171102:
                drawVideoListener.onClickRetry();
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
