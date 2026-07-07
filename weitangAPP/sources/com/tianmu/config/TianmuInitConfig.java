package com.tianmu.config;

import android.text.TextUtils;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.c.a;
import com.tianmu.c.n.n;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TianmuImageLoader f11958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11959g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11960h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11961i;
    private boolean j;
    private TianmuCustomController k;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TianmuInitConfig f11962a = new TianmuInitConfig();

        public Builder agreePrivacyStrategy(boolean z) {
            this.f11962a.f11959g = z;
            return this;
        }

        public Builder appId(String str) {
            this.f11962a.f11953a = str;
            return this;
        }

        public TianmuInitConfig build() {
            return this.f11962a;
        }

        public Builder debug(boolean z) {
            this.f11962a.f11954b = z;
            return this;
        }

        public Builder isCanUseLocation(boolean z) {
            this.f11962a.f11955c = z;
            return this;
        }

        public Builder isCanUsePhoneState(boolean z) {
            this.f11962a.f11956d = z;
            return this;
        }

        public Builder isCanUseWifiState(boolean z) {
            this.f11962a.f11957e = z;
            return this;
        }

        public Builder isFlag(boolean z) {
            this.f11962a.f11961i = z;
            return this;
        }

        @Deprecated
        public Builder isSandbox(boolean z) {
            this.f11962a.f11960h = z;
            return this;
        }

        public Builder setMultiprocess(boolean z) {
            this.f11962a.j = z;
            return this;
        }

        public Builder setTianmuCustomController(TianmuCustomController tianmuCustomController) {
            this.f11962a.k = tianmuCustomController;
            return this;
        }
    }

    public void check() {
        if (!isAgreePrivacyStrategy()) {
            this.f11957e = false;
            this.f11955c = false;
            this.f11956d = false;
        }
        if (TextUtils.isEmpty(this.f11953a)) {
            n.D().a(new TianmuError(-1001, "AppId不能为空"));
        }
    }

    public String getAppId() {
        return this.f11953a;
    }

    public TianmuCustomController getCustomController() {
        return this.k;
    }

    public TianmuImageLoader getTianmuImageLoader() {
        return this.f11958f;
    }

    public boolean isAgreePrivacyStrategy() {
        return this.f11959g;
    }

    public boolean isCanUseLocation() {
        return TianmuSDK.setCanUseLocation ? TianmuSDK.isCanUseLocation : this.f11955c;
    }

    public boolean isCanUsePhoneState() {
        return TianmuSDK.setCanUsePhoneState ? TianmuSDK.isCanUsePhoneState : this.f11956d;
    }

    public boolean isCanUseWifiState() {
        return TianmuSDK.setCanUseWifiState ? TianmuSDK.isCanUseWifiState : this.f11957e;
    }

    public boolean isDebug() {
        return this.f11954b;
    }

    public boolean isFlag() {
        return this.f11961i;
    }

    public boolean isGoogle() {
        return false;
    }

    public boolean isMultiprocess() {
        return this.j;
    }

    public boolean isSandbox() {
        return this.f11960h;
    }

    private TianmuInitConfig() {
        this.f11954b = true;
        this.f11955c = true;
        this.f11956d = true;
        this.f11957e = true;
        this.f11959g = true;
        this.f11960h = false;
        this.f11958f = new a();
    }
}
