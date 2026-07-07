package com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok;

import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ok {
    public static final ValueSet ok(final IMediationConfig iMediationConfig) {
        c.d.a.a.a.a.a aVarOk = c.d.a.a.a.a.a.ok();
        if (iMediationConfig == null) {
            return null;
        }
        aVarOk.ok(264101, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.1
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.getPublisherDid();
            }
        });
        aVarOk.ok(264102, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.3
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isOpenAdnTest());
            }
        });
        aVarOk.ok(264103, iMediationConfig.getMediationConfigUserInfoForSegment() != null ? bl.ok(iMediationConfig.getMediationConfigUserInfoForSegment()) : null);
        aVarOk.ok(264104, new ValueSet.ValueGetter<Map>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.4
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Map get() {
                return iMediationConfig.getLocalExtra();
            }
        });
        aVarOk.ok(264105, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.5
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.getHttps());
            }
        });
        aVarOk.ok(264106, new ValueSet.ValueGetter<JSONObject>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.6
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public JSONObject get() {
                return iMediationConfig.getCustomLocalConfig();
            }
        });
        aVarOk.ok(264107, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.7
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.getOpensdkVer();
            }
        });
        aVarOk.ok(264108, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.8
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isWxInstalled());
            }
        });
        aVarOk.ok(264109, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.9
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isSupportH265());
            }
        });
        aVarOk.ok(264110, new ValueSet.ValueGetter<Boolean>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.10
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public Boolean get() {
                return Boolean.valueOf(iMediationConfig.isSupportSplashZoomout());
            }
        });
        aVarOk.ok(264111, new ValueSet.ValueGetter<String>() { // from class: com.bytedance.sdk.openadsdk.mediation.init.ok.ok.ok.ok.2
            @Override // com.bykv.vk.openvk.api.proto.ValueSet.ValueGetter
            /* JADX INFO: renamed from: ok, reason: merged with bridge method [inline-methods] */
            public String get() {
                return iMediationConfig.wxAppId();
            }
        });
        return aVarOk.a();
    }
}
