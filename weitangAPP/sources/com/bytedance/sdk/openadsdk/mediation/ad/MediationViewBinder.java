package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class MediationViewBinder implements IMediationViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;
    public final Map<String, Integer> extras;
    public final int groupImage1Id;
    public final int groupImage2Id;
    public final int groupImage3Id;
    public final int iconImageId;
    public final int layoutId;
    public final int logoLayoutId;
    public final int mainImageId;
    public final int mediaViewId;
    public final int shakeViewContainerId;
    public final int sourceId;
    public final int titleId;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6407a;
        public int bl;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f6408h;
        public int j;
        public int k;
        public int kf;
        public int n;
        public int ok;
        public int p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f6409q;
        public int r;
        public Map<String, Integer> rh;
        public int s;
        public int z;

        public Builder(int i2) {
            this.rh = Collections.emptyMap();
            this.ok = i2;
            this.rh = new HashMap();
        }

        public Builder addExtra(String str, int i2) {
            this.rh.put(str, Integer.valueOf(i2));
            return this;
        }

        public Builder addExtras(Map<String, Integer> map) {
            this.rh = new HashMap(map);
            return this;
        }

        public MediationViewBinder build() {
            return new MediationViewBinder(this);
        }

        public Builder callToActionId(int i2) {
            this.s = i2;
            return this;
        }

        public Builder descriptionTextId(int i2) {
            this.bl = i2;
            return this;
        }

        public Builder groupImage1Id(int i2) {
            this.k = i2;
            return this;
        }

        public Builder groupImage2Id(int i2) {
            this.r = i2;
            return this;
        }

        public Builder groupImage3Id(int i2) {
            this.j = i2;
            return this;
        }

        public Builder iconImageId(int i2) {
            this.n = i2;
            return this;
        }

        public Builder logoLayoutId(int i2) {
            this.f6409q = i2;
            return this;
        }

        public Builder mainImageId(int i2) {
            this.kf = i2;
            return this;
        }

        public Builder mediaViewIdId(int i2) {
            this.f6408h = i2;
            return this;
        }

        public Builder shakeViewContainerId(int i2) {
            this.z = i2;
            return this;
        }

        public Builder sourceId(int i2) {
            this.p = i2;
            return this;
        }

        public Builder titleId(int i2) {
            this.f6407a = i2;
            return this;
        }
    }

    public MediationViewBinder(Builder builder) {
        this.layoutId = builder.ok;
        this.titleId = builder.f6407a;
        this.decriptionTextId = builder.bl;
        this.callToActionId = builder.s;
        this.iconImageId = builder.n;
        this.mainImageId = builder.kf;
        this.mediaViewId = builder.f6408h;
        this.sourceId = builder.p;
        this.extras = builder.rh;
        this.groupImage1Id = builder.k;
        this.groupImage2Id = builder.r;
        this.groupImage3Id = builder.j;
        this.logoLayoutId = builder.f6409q;
        this.shakeViewContainerId = builder.z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getCallToActionId() {
        return this.callToActionId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getDecriptionTextId() {
        return this.decriptionTextId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public Map<String, Integer> getExtras() {
        return this.extras;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage1Id() {
        return this.groupImage1Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage2Id() {
        return this.groupImage2Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage3Id() {
        return this.groupImage3Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getIconImageId() {
        return this.iconImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLogoLayoutId() {
        return this.logoLayoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMainImageId() {
        return this.mainImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMediaViewId() {
        return this.mediaViewId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getShakeViewContainerId() {
        return this.shakeViewContainerId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getSourceId() {
        return this.sourceId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getTitleId() {
        return this.titleId;
    }
}
