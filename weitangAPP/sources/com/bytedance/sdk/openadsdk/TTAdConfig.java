package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.CSJConfig;
import com.bytedance.sdk.openadsdk.live.ITTLiveTokenInjectionAuth;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;

/* JADX INFO: loaded from: classes.dex */
public final class TTAdConfig extends CSJConfig {
    private ITTLiveTokenInjectionAuth ok;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CSJConfig.ok f6312a = new CSJConfig.ok();
        private ITTLiveTokenInjectionAuth ok;

        public Builder allowShowNotify(boolean z) {
            this.f6312a.a(z);
            return this;
        }

        public Builder appId(String str) {
            this.f6312a.ok(str);
            return this;
        }

        public Builder appName(String str) {
            this.f6312a.a(str);
            return this;
        }

        public TTAdConfig build() {
            TTAdConfig tTAdConfig = new TTAdConfig(this.f6312a);
            tTAdConfig.setInjectionAuth(this.ok);
            return tTAdConfig;
        }

        public Builder customController(TTCustomController tTCustomController) {
            this.f6312a.ok(tTCustomController);
            return this;
        }

        public Builder data(String str) {
            this.f6312a.s(str);
            return this;
        }

        public Builder debug(boolean z) {
            this.f6312a.bl(z);
            return this;
        }

        public Builder directDownloadNetworkType(int... iArr) {
            this.f6312a.ok(iArr);
            return this;
        }

        public Builder injectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
            this.ok = iTTLiveTokenInjectionAuth;
            return this;
        }

        public Builder keywords(String str) {
            this.f6312a.bl(str);
            return this;
        }

        public Builder paid(boolean z) {
            this.f6312a.ok(z);
            return this;
        }

        public Builder setAgeGroup(int i2) {
            this.f6312a.s(i2);
            return this;
        }

        public Builder setMediationConfig(IMediationConfig iMediationConfig) {
            this.f6312a.ok(iMediationConfig);
            return this;
        }

        public Builder setPluginUpdateConfig(int i2) {
            this.f6312a.bl(i2);
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.f6312a.n(z);
            return this;
        }

        public Builder themeStatus(int i2) {
            this.f6312a.a(i2);
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.f6312a.ok(i2);
            return this;
        }

        public Builder useMediation(boolean z) {
            this.f6312a.kf(z);
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.f6312a.s(z);
            return this;
        }
    }

    public ITTLiveTokenInjectionAuth getInjectionAuth() {
        return this.ok;
    }

    public void setInjectionAuth(ITTLiveTokenInjectionAuth iTTLiveTokenInjectionAuth) {
        this.ok = iTTLiveTokenInjectionAuth;
    }

    private TTAdConfig(CSJConfig.ok okVar) {
        super(okVar);
    }
}
