package cn.admobiletop.adsuyi.adapter.toutiao.b;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.util.ADSuyiToastUtil;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;

/* JADX INFO: loaded from: classes.dex */
public class B implements TTAppDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3926a = false;

    public final void a(String str) {
        ADSuyiToastUtil.show(ADSuyiSdk.getInstance().getContext(), str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        if (this.f3926a) {
            return;
        }
        this.f3926a = true;
        a(str2 + "已开始下载");
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        if (this.f3926a) {
            this.f3926a = false;
            a(str2 + "已暂停下载");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
    }
}
