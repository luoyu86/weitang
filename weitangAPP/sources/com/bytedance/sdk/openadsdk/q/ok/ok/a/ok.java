package com.bytedance.sdk.openadsdk.q.ok.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.bl.ok.ok.r;

/* JADX INFO: loaded from: classes.dex */
public class ok implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTFeedAd.VideoAdListener f6454a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public ok(TTFeedAd.VideoAdListener videoAdListener) {
        this.f6454a = videoAdListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (this.f6454a == null) {
            return null;
        }
        switch (i2) {
            case 161101:
                this.f6454a.onVideoLoad(new r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161102:
                this.f6454a.onVideoError(valueSet.intValue(0), valueSet.intValue(1));
                break;
            case 161103:
                this.f6454a.onVideoAdPaused(new r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161104:
                this.f6454a.onVideoAdStartPlay(new r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161105:
                this.f6454a.onVideoAdContinuePlay(new r((Bridge) valueSet.objectValue(0, Bridge.class)));
                break;
            case 161106:
                this.f6454a.onProgressUpdate(valueSet.longValue(0), valueSet.longValue(1));
                break;
            case 161107:
                this.f6454a.onVideoAdComplete(new r((Bridge) valueSet.objectValue(0, Bridge.class)));
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
