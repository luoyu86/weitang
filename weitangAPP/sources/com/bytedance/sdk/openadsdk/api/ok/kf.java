package com.bytedance.sdk.openadsdk.api.ok;

import c.d.a.a.a.a.b;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.ss.android.download.api.config.IDownloadButtonClickListener;

/* JADX INFO: loaded from: classes.dex */
public class kf extends com.bytedance.sdk.openadsdk.api.a implements IDownloadButtonClickListener {
    public kf(EventListener eventListener) {
        this.ok = eventListener;
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleComplianceDialog(boolean z) {
        ok(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG, ok() ? null : b.ok().ok(c.d.a.a.a.a.a.ok().ok(ValueSetConstants.VALUE_HANDLE_COMPLIANCE_DIALOG_SHOULD_SHOW, z).a()).a());
    }

    @Override // com.ss.android.download.api.config.IDownloadButtonClickListener
    public void handleMarketFailedComplianceDialog() {
        ok(ValueSetConstants.VALUE_HANDLE_MARKET_FAILED_COMPLIANCE_DIALOG);
    }
}
