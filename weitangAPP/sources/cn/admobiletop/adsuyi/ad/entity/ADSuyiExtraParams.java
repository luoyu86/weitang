package cn.admobiletop.adsuyi.ad.entity;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiExtraParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ADSuyiAdSize f3510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAdSize f3511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiAdSize f3512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ADSuyiRewardExtra f3515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ADSuyiAdNativeStyle f3516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3517h;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ADSuyiExtraParams f3518a = new ADSuyiExtraParams();

        public Builder adSize(ADSuyiAdSize aDSuyiAdSize) {
            this.f3518a.f3510a = aDSuyiAdSize;
            return this;
        }

        public ADSuyiExtraParams build() {
            return this.f3518a;
        }

        public Builder jadYunAdViewSize(ADSuyiAdSize aDSuyiAdSize) {
            this.f3518a.f3512c = aDSuyiAdSize;
            return this;
        }

        public Builder nativeAdMediaViewSize(ADSuyiAdSize aDSuyiAdSize) {
            this.f3518a.f3511b = aDSuyiAdSize;
            return this;
        }

        public Builder nativeAdPlayWithMute(boolean z) {
            this.f3518a.f3513d = z;
            return this;
        }

        public Builder nativeStyle(ADSuyiAdNativeStyle aDSuyiAdNativeStyle) {
            this.f3518a.f3516g = aDSuyiAdNativeStyle;
            return this;
        }

        public Builder rewardExtra(ADSuyiRewardExtra aDSuyiRewardExtra) {
            this.f3518a.f3515f = aDSuyiRewardExtra;
            return this;
        }

        public Builder setAdShakeDisable(boolean z) {
            this.f3518a.f3517h = z;
            return this;
        }

        public Builder setVideoWithMute(boolean z) {
            this.f3518a.f3514e = z;
            return this;
        }
    }

    public ADSuyiAdSize getAdSize() {
        return this.f3510a;
    }

    public ADSuyiAdSize getJadYunAdViewSize() {
        return this.f3512c;
    }

    public ADSuyiAdSize getNativeAdMediaViewSize() {
        return this.f3511b;
    }

    public ADSuyiAdNativeStyle getNativeStyle() {
        return this.f3516g;
    }

    public ADSuyiRewardExtra getRewardExtra() {
        return this.f3515f;
    }

    public boolean isAdPlayWithMute() {
        return this.f3514e;
    }

    public boolean isAdShakeDisable() {
        return this.f3517h;
    }

    public boolean isNativeAdPlayWithMute() {
        return this.f3513d;
    }

    public ADSuyiExtraParams() {
        this.f3513d = true;
        this.f3514e = false;
        this.f3517h = false;
    }
}
