package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.DownloadStatusController;

/* JADX INFO: loaded from: classes.dex */
public class n implements DownloadStatusController {
    private final Bridge ok;

    public n(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void cancelDownload() {
        this.ok.call(222102, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.DownloadStatusController
    public void changeDownloadStatus() {
        this.ok.call(222101, c.d.a.a.a.a.a.ok(0).a(), Void.class);
    }
}
