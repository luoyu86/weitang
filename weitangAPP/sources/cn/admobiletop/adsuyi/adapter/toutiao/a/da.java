package cn.admobiletop.adsuyi.adapter.toutiao.a;

import com.bytedance.sdk.openadsdk.TTAdDislike;

/* JADX INFO: loaded from: classes.dex */
public class da implements TTAdDislike.DislikeInteractionCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ea f3899a;

    public da(ea eaVar) {
        this.f3899a = eaVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onCancel() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onSelected(int i2, String str, boolean z) {
        this.f3899a.onCloseClick(null);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
    public void onShow() {
    }
}
