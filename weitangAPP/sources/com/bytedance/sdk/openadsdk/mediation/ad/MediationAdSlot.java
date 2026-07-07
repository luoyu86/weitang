package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediationAdSlot implements IMediationAdSlot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6395a;
    private String bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private MediationSplashRequestInfo f6397i;
    private MediationNativeToBannerListener j;
    private String k;
    private boolean kf;
    private float n;
    private boolean ok;
    private Map<String, Object> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f6398q;
    private boolean r;
    private float rh;
    private int s;
    private String t;
    private float z;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f6399a;
        private boolean bl;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f6400h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private MediationSplashRequestInfo f6401i;
        private MediationNativeToBannerListener j;
        private int k;
        private boolean n;
        private boolean ok;
        private String p;
        private boolean r;
        private float s;
        private String t;
        private Map<String, Object> kf = new HashMap();

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private String f6402q = "";
        private float z = 80.0f;
        private float rh = 80.0f;

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot();
            mediationAdSlot.ok = this.ok;
            mediationAdSlot.f6395a = this.f6399a;
            mediationAdSlot.f6396h = this.bl;
            mediationAdSlot.n = this.s;
            mediationAdSlot.kf = this.n;
            mediationAdSlot.p = this.kf;
            mediationAdSlot.f6398q = this.f6400h;
            mediationAdSlot.k = this.p;
            mediationAdSlot.bl = this.f6402q;
            mediationAdSlot.s = this.k;
            mediationAdSlot.r = this.r;
            mediationAdSlot.j = this.j;
            mediationAdSlot.z = this.z;
            mediationAdSlot.rh = this.rh;
            mediationAdSlot.t = this.t;
            mediationAdSlot.f6397i = this.f6401i;
            return mediationAdSlot;
        }

        public Builder setAllowShowCloseBtn(boolean z) {
            this.r = z;
            return this;
        }

        public Builder setBidNotify(boolean z) {
            this.f6400h = z;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.kf;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.j = mediationNativeToBannerListener;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.f6401i = mediationSplashRequestInfo;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.bl = z;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.k = i2;
            return this;
        }

        public Builder setRewardName(String str) {
            this.f6402q = str;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.p = str;
            return this;
        }

        public Builder setShakeViewSize(float f2, float f3) {
            this.z = f2;
            this.rh = f3;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.f6399a = z;
            return this;
        }

        public Builder setSplashShakeButton(boolean z) {
            this.ok = z;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.n = z;
            return this;
        }

        public Builder setVolume(float f2) {
            this.s = f2;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.t = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getRewardName() {
        return this.bl;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getScenarioId() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.rh;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getVolume() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getWxAppId() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.r;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.f6398q;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isMuted() {
        return this.f6396h;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.f6395a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.ok;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.kf;
    }

    private MediationAdSlot() {
        this.bl = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.f6397i;
    }
}
