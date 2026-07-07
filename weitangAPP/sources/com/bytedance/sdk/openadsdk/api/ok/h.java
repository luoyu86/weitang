package com.bytedance.sdk.openadsdk.api.ok;

import c.d.a.a.a.a.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.bytedance.sdk.openadsdk.api.a implements OnItemClickListener {
    public h(EventListener eventListener) {
        this.ok = eventListener;
    }

    @Override // com.ss.android.download.api.config.OnItemClickListener
    public void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        ok(ValueSetConstants.VALUE_ON_ITEM_CLICK, ok() ? null : b.ok().ok(c.d.a.a.a.a.a.ok().ok(ValueSetConstants.VALUE_DOWNLOAD_MODEL, new bl(downloadModel)).ok(ValueSetConstants.VALUE_DOWNLOAD_EVENT_CONFIG, new a(downloadEventConfig)).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, new ok(downloadController)).a()).a());
    }
}
