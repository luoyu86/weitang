package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import com.bytedance.sdk.openadsdk.TTAdDislike;

/* JADX INFO: loaded from: classes.dex */
public class ka implements TTAdDislike.DislikeInteractionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ la f4007a;

    public ka(la laVar) {
        this.f4007a = laVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i2, String str, boolean z) {
        if (this.f4007a.getAdListener() == 0 || this.f4007a.f4009d == null) {
            return;
        }
        ((ADSuyiSplashAdListener) this.f4007a.getAdListener()).onAdClose(this.f4007a.f4009d);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onShow() {
    }
}
