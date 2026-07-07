package com.bytedance.sdk.openadsdk.bl.ok.a;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;

/* JADX INFO: loaded from: classes.dex */
public class a implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TTAppDownloadListener f6355a;
    private ValueSet ok = c.d.a.a.a.a.a.f918a;

    public a(TTAppDownloadListener tTAppDownloadListener) {
        this.f6355a = tTAppDownloadListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        TTAppDownloadListener tTAppDownloadListener = this.f6355a;
        if (tTAppDownloadListener == null) {
            return null;
        }
        switch (i2) {
            case 221101:
                tTAppDownloadListener.onIdle();
                break;
            case 221102:
                this.f6355a.onDownloadActive(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), (String) valueSet.objectValue(3, String.class));
                break;
            case 221103:
                this.f6355a.onDownloadPaused(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), (String) valueSet.objectValue(3, String.class));
                break;
            case 221104:
                this.f6355a.onDownloadFailed(valueSet.longValue(0), valueSet.longValue(1), (String) valueSet.objectValue(2, String.class), (String) valueSet.objectValue(3, String.class));
                break;
            case 221105:
                this.f6355a.onDownloadFinished(valueSet.longValue(0), (String) valueSet.objectValue(1, String.class), (String) valueSet.objectValue(2, String.class));
                break;
            case 221106:
                this.f6355a.onInstalled((String) valueSet.objectValue(0, String.class), (String) valueSet.objectValue(1, String.class));
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
