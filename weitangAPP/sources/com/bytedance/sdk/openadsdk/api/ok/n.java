package com.bytedance.sdk.openadsdk.api.ok;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import c.d.a.a.a.a.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DownloadShortInfo;

/* JADX INFO: loaded from: classes.dex */
public class n extends com.bytedance.sdk.openadsdk.api.a implements DownloadStatusChangeListener {
    public n(EventListener eventListener) {
        this.ok = eventListener;
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadActive(DownloadShortInfo downloadShortInfo, int i2) {
        ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE, ok() ? null : b.ok().ok(c.d.a.a.a.a.a.ok().ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new s(downloadShortInfo)).ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, i2).a()).a());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFailed(DownloadShortInfo downloadShortInfo) {
        ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_FAILED, ok() ? null : b.ok().ok(c.d.a.a.a.a.a.ok().ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new s(downloadShortInfo)).a()).a());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadFinished(DownloadShortInfo downloadShortInfo) {
        ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_FINISHED, ok() ? null : b.ok().ok(c.d.a.a.a.a.a.ok().ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new s(downloadShortInfo)).a()).a());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadPaused(DownloadShortInfo downloadShortInfo, int i2) {
        ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_PAUSED, ok() ? null : b.ok().ok(c.d.a.a.a.a.a.ok().ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new s(downloadShortInfo)).ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_PERCENT, i2).a()).a());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onDownloadStart(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController) {
        ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_START, ok() ? null : b.ok().ok(c.d.a.a.a.a.a.ok().ok(ValueSetConstants.VALUE_DOWNLOAD_MODEL, new bl(downloadModel)).ok(ValueSetConstants.VALUE_DOWNLOAD_CONTROLLER, new ok(downloadController)).a()).a());
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onIdle() {
        ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_IDLE);
    }

    @Override // com.ss.android.download.api.download.DownloadStatusChangeListener
    public void onInstalled(DownloadShortInfo downloadShortInfo) {
        ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ON_INSTALLED, ok() ? null : b.ok().ok(c.d.a.a.a.a.a.ok().ok(ValueSetConstants.VALUE_DOWNLOAD_STATUS_CHANGE_ON_DOWNLOAD_ACTIVE_SHORT, new s(downloadShortInfo)).a()).a());
    }
}
