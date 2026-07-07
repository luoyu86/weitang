package com.bytedance.sdk.openadsdk.mediation.ok.ok.ok;

import android.app.Activity;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.bl.ok.ok.q;
import com.bytedance.sdk.openadsdk.mediation.IMediationDrawAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationManager;
import com.bytedance.sdk.openadsdk.mediation.IMediationNativeAdTokenCallback;
import com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo;
import com.bytedance.sdk.openadsdk.mediation.MediationAppDialogClickListener;
import com.bytedance.sdk.openadsdk.mediation.init.MediationConfigUserInfoForSegment;
import com.bytedance.sdk.openadsdk.mediation.ok.ok.a.n;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a implements IMediationManager {
    private final Bridge ok;

    public a(Bridge bridge) {
        this.ok = bridge == null ? c.d.a.a.a.a.a.f919b : bridge;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Map<String, Object> getMediationExtraInfo() {
        return (Map) this.ok.call(270024, c.d.a.a.a.a.a.ok(0).a(), Map.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadDrawToken(Context context, AdSlot adSlot, IMediationDrawAdTokenCallback iMediationDrawAdTokenCallback) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(3);
        aVarOk.ok(0, context);
        aVarOk.ok(1, adSlot);
        aVarOk.ok(2, new com.bytedance.sdk.openadsdk.mediation.ok.ok.a.ok(iMediationDrawAdTokenCallback));
        this.ok.call(270022, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void loadNativeToken(Context context, AdSlot adSlot, IMediationNativeAdTokenCallback iMediationNativeAdTokenCallback) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(3);
        aVarOk.ok(0, context);
        aVarOk.ok(1, adSlot);
        aVarOk.ok(2, new com.bytedance.sdk.openadsdk.mediation.ok.ok.a.bl(iMediationNativeAdTokenCallback));
        this.ok.call(270021, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public Object mtool(int i2, ValueSet valueSet) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(2);
        aVarOk.ok(0, i2);
        aVarOk.ok(1, valueSet);
        return this.ok.call(271043, aVarOk.a(), Object.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void preload(Activity activity, List<IMediationPreloadRequestInfo> list, int i2, int i3) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(4);
        aVarOk.ok(0, activity);
        aVarOk.ok(1, list);
        aVarOk.ok(2, i2);
        aVarOk.ok(3, i3);
        this.ok.call(270013, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, context);
        this.ok.call(270017, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setPulisherDid(String str) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, str);
        this.ok.call(270015, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setThemeStatus(int i2) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, i2);
        this.ok.call(270019, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void setUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, mediationConfigUserInfoForSegment);
        this.ok.call(270014, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public int showOpenOrInstallAppDialog(MediationAppDialogClickListener mediationAppDialogClickListener) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new n(mediationAppDialogClickListener));
        return ((Integer) this.ok.call(270020, aVarOk.a(), Integer.TYPE)).intValue();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void updatePrivacyConfig(TTCustomController tTCustomController) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(1);
        aVarOk.ok(0, new q(tTCustomController));
        this.ok.call(270016, aVarOk.a(), Void.class);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationManager
    public void requestPermissionIfNecessary(Context context, int[] iArr) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok(2);
        aVarOk.ok(0, context);
        aVarOk.ok(1, iArr);
        this.ok.call(270018, aVarOk.a(), Void.class);
    }
}
