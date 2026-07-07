package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MediationConfig implements IMediationConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6430a;
    private MediationConfigUserInfoForSegment bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6431h;
    private boolean k;
    private JSONObject kf;
    private boolean n;
    private String ok;
    private String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f6432q;
    private String r;
    private Map<String, Object> s;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6433a;
        private MediationConfigUserInfoForSegment bl;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f6434h;
        private boolean k;
        private JSONObject kf;
        private boolean n;
        private String ok;
        private String p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private boolean f6435q;
        private String r;
        private Map<String, Object> s;

        public MediationConfig build() {
            MediationConfig mediationConfig = new MediationConfig();
            mediationConfig.ok = this.ok;
            mediationConfig.f6430a = this.f6433a;
            mediationConfig.bl = this.bl;
            mediationConfig.s = this.s;
            mediationConfig.n = this.n;
            mediationConfig.kf = this.kf;
            mediationConfig.f6431h = this.f6434h;
            mediationConfig.p = this.p;
            mediationConfig.f6432q = this.f6435q;
            mediationConfig.k = this.k;
            mediationConfig.r = this.r;
            return mediationConfig;
        }

        public Builder setCustomLocalConfig(JSONObject jSONObject) {
            this.kf = jSONObject;
            return this;
        }

        public Builder setHttps(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setLocalExtra(Map<String, Object> map) {
            this.s = map;
            return this;
        }

        public Builder setMediationConfigUserInfoForSegment(MediationConfigUserInfoForSegment mediationConfigUserInfoForSegment) {
            this.bl = mediationConfigUserInfoForSegment;
            return this;
        }

        public Builder setOpenAdnTest(boolean z) {
            this.f6433a = z;
            return this;
        }

        public Builder setOpensdkVer(String str) {
            this.p = str;
            return this;
        }

        public Builder setPublisherDid(String str) {
            this.ok = str;
            return this;
        }

        public Builder setSupportH265(boolean z) {
            this.f6435q = z;
            return this;
        }

        public Builder setSupportSplashZoomout(boolean z) {
            this.k = z;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.r = str;
            return this;
        }

        public Builder setWxInstalled(boolean z) {
            this.f6434h = z;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public JSONObject getCustomLocalConfig() {
        return this.kf;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean getHttps() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public Map<String, Object> getLocalExtra() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment() {
        return this.bl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getOpensdkVer() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String getPublisherDid() {
        return this.ok;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isOpenAdnTest() {
        return this.f6430a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportH265() {
        return this.f6432q;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isSupportSplashZoomout() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public boolean isWxInstalled() {
        return this.f6431h;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig
    public String wxAppId() {
        return this.r;
    }

    private MediationConfig() {
    }
}
