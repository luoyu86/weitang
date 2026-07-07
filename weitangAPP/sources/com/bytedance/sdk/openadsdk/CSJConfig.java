package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CSJConfig implements AdConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6304a;
    private boolean bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f6306i;
    private Map<String, Object> j = new HashMap();
    private boolean k;
    private int kf;
    private String n;
    private String ok;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int[] f6307q;
    private boolean r;
    private int rh;
    private String s;
    private int t;
    private IMediationConfig td;
    private boolean x;
    private TTCustomController z;

    public static class ok {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6308a;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f6310i;
        private TTCustomController j;
        private String n;
        private String ok;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int[] f6311q;
        private String s;
        private IMediationConfig x;
        private int z;
        private boolean bl = false;
        private int kf = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f6309h = true;
        private boolean p = false;
        private boolean k = true;
        private boolean r = false;
        private int rh = 2;
        private int t = 0;

        public ok a(String str) {
            this.f6308a = str;
            return this;
        }

        public ok bl(String str) {
            this.s = str;
            return this;
        }

        public ok kf(boolean z) {
            this.f6310i = z;
            return this;
        }

        public ok n(boolean z) {
            this.r = z;
            return this;
        }

        public ok ok(String str) {
            this.ok = str;
            return this;
        }

        public ok s(String str) {
            this.n = str;
            return this;
        }

        public ok a(boolean z) {
            this.f6309h = z;
            return this;
        }

        public ok bl(boolean z) {
            this.p = z;
            return this;
        }

        public ok ok(boolean z) {
            this.bl = z;
            return this;
        }

        public ok s(boolean z) {
            this.k = z;
            return this;
        }

        public ok a(int i2) {
            this.z = i2;
            return this;
        }

        public ok bl(int i2) {
            this.rh = i2;
            return this;
        }

        public ok ok(int i2) {
            this.kf = i2;
            return this;
        }

        public ok s(int i2) {
            this.t = i2;
            return this;
        }

        public ok ok(int... iArr) {
            this.f6311q = iArr;
            return this;
        }

        public ok ok(TTCustomController tTCustomController) {
            this.j = tTCustomController;
            return this;
        }

        public ok ok(IMediationConfig iMediationConfig) {
            this.x = iMediationConfig;
            return this;
        }
    }

    public CSJConfig(ok okVar) {
        this.bl = false;
        this.kf = 0;
        this.f6305h = true;
        this.p = false;
        this.k = true;
        this.r = false;
        this.ok = okVar.ok;
        this.f6304a = okVar.f6308a;
        this.bl = okVar.bl;
        this.s = okVar.s;
        this.n = okVar.n;
        this.kf = okVar.kf;
        this.f6305h = okVar.f6309h;
        this.p = okVar.p;
        this.f6307q = okVar.f6311q;
        this.k = okVar.k;
        this.r = okVar.r;
        this.z = okVar.j;
        this.rh = okVar.z;
        this.f6306i = okVar.t;
        this.t = okVar.rh;
        this.x = okVar.f6310i;
        this.td = okVar.x;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.f6306i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.ok;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.f6304a;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f6307q;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public IMediationConfig getMediationConfig() {
        return this.td;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.rh;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.kf;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.f6305h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.bl;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.r;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseMediation() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseTextureView() {
        return this.k;
    }

    public void setAgeGroup(int i2) {
        this.f6306i = i2;
    }

    public void setAllowShowNotify(boolean z) {
        this.f6305h = z;
    }

    public void setAppId(String str) {
        this.ok = str;
    }

    public void setAppName(String str) {
        this.f6304a = str;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.z = tTCustomController;
    }

    public void setData(String str) {
        this.n = str;
    }

    public void setDebug(boolean z) {
        this.p = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f6307q = iArr;
    }

    public void setKeywords(String str) {
        this.s = str;
    }

    public void setPaid(boolean z) {
        this.bl = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.r = z;
    }

    public void setThemeStatus(int i2) {
        this.rh = i2;
    }

    public void setTitleBarTheme(int i2) {
        this.kf = i2;
    }

    public void setUseTextureView(boolean z) {
        this.k = z;
    }
}
