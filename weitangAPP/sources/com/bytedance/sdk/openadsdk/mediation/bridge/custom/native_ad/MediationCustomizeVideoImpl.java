package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo;

/* JADX INFO: loaded from: classes.dex */
public class MediationCustomizeVideoImpl implements Bridge, IMediationCustomizeVideo {
    private TTFeedAd.CustomizeVideo ok;

    public MediationCustomizeVideoImpl(TTFeedAd.CustomizeVideo customizeVideo) {
        this.ok = customizeVideo;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        if (i2 == 8165) {
            reportVideoStart();
            return null;
        }
        if (i2 == 8168) {
            reportVideoFinish();
            return null;
        }
        if (i2 == 8166) {
            reportVideoPause(valueSet.longValue(8074));
            return null;
        }
        if (i2 == 8167) {
            reportVideoContinue(valueSet.longValue(8074));
            return null;
        }
        if (i2 == 8169) {
            reportVideoBreak(valueSet.longValue(8074));
            return null;
        }
        if (i2 == 8170) {
            reportVideoAutoStart();
            return null;
        }
        if (i2 == 8171) {
            reportVideoStartError(valueSet.intValue(8014), valueSet.intValue(8075));
            return null;
        }
        if (i2 != 8172) {
            return null;
        }
        reportVideoError(valueSet.longValue(8074), valueSet.intValue(8014), valueSet.intValue(8075));
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public String getVideoUrl() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoAutoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.ok;
        if (customizeVideo != null) {
            customizeVideo.reportVideoAutoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoBreak(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.ok;
        if (customizeVideo != null) {
            customizeVideo.reportVideoBreak(j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoContinue(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.ok;
        if (customizeVideo != null) {
            customizeVideo.reportVideoContinue(j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoError(long j, int i2, int i3) {
        TTFeedAd.CustomizeVideo customizeVideo = this.ok;
        if (customizeVideo != null) {
            customizeVideo.reportVideoError(j, i2, i3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoFinish() {
        TTFeedAd.CustomizeVideo customizeVideo = this.ok;
        if (customizeVideo != null) {
            customizeVideo.reportVideoFinish();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoPause(long j) {
        TTFeedAd.CustomizeVideo customizeVideo = this.ok;
        if (customizeVideo != null) {
            customizeVideo.reportVideoPause(j);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoStart() {
        TTFeedAd.CustomizeVideo customizeVideo = this.ok;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationCustomizeVideo
    public void reportVideoStartError(int i2, int i3) {
        TTFeedAd.CustomizeVideo customizeVideo = this.ok;
        if (customizeVideo != null) {
            customizeVideo.reportVideoStartError(i2, i3);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
