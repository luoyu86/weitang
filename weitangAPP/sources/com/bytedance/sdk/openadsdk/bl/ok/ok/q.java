package com.bytedance.sdk.openadsdk.bl.ok.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;

/* JADX INFO: loaded from: classes.dex */
public final class q extends TTCustomController implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TTCustomController f6364a;
    private final Bridge ok;

    public q(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean alist() {
        return ((Boolean) this.ok.call(262103, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i2, ValueSet valueSet, Class<T> cls) {
        TTCustomController tTCustomController = this.f6364a;
        if (tTCustomController == null) {
            return null;
        }
        switch (i2) {
            case 262101:
                break;
            case 262102:
                break;
            case 262103:
                break;
            case 262104:
                break;
            case 262105:
                break;
            case 262106:
                break;
            case 262107:
                break;
            case 262108:
                break;
            case 262109:
                break;
            case 262110:
                break;
            case 262111:
                break;
            case 262112:
                break;
            default:
                ok(i2, valueSet, cls);
                break;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getAndroidId() {
        return (String) this.ok.call(262112, c.d.a.a.a.a.a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevImei() {
        return (String) this.ok.call(262105, c.d.a.a.a.a.a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevOaid() {
        return (String) this.ok.call(262109, c.d.a.a.a.a.a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getMacAddress() {
        return (String) this.ok.call(262107, c.d.a.a.a.a.a.ok(0).a(), String.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public IMediationPrivacyConfig getMediationPrivacyConfig() {
        return (IMediationPrivacyConfig) this.ok.values().objectValue(262113, IMediationPrivacyConfig.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public LocationProvider getTTLocation() {
        return (LocationProvider) this.ok.call(262102, c.d.a.a.a.a.a.ok(0).a(), LocationProvider.class);
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseAndroidId() {
        return ((Boolean) this.ok.call(262110, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseLocation() {
        return ((Boolean) this.ok.call(262101, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePermissionRecordAudio() {
        return ((Boolean) this.ok.call(262111, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUsePhoneState() {
        return ((Boolean) this.ok.call(262104, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWifiState() {
        return ((Boolean) this.ok.call(262106, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public boolean isCanUseWriteExternal() {
        return ((Boolean) this.ok.call(262108, c.d.a.a.a.a.a.ok(0).a(), Boolean.TYPE)).booleanValue();
    }

    public void ok(int i2, ValueSet valueSet, Class cls) {
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return c.d.a.a.a.a.a.f918a;
    }

    public q(TTCustomController tTCustomController) {
        this.f6364a = tTCustomController;
        this.ok = c.d.a.a.a.a.a.f919b;
    }
}
