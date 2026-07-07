package com.bytedance.sdk.openadsdk.q.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;

/* JADX INFO: loaded from: classes.dex */
public class a implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTFeedAd.VideoRewardListener f6453a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public a(TTFeedAd.VideoRewardListener videoRewardListener) {
        this.f6453a = videoRewardListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6453a == null) {
            return null;
        }
        if (i2 == 163101) {
            this.f6453a.onFeedRewardCountDown(valueSet.intValue(0));
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
