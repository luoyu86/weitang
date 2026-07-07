package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AdSlot implements SlotType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6296a;
    private int bl;
    private int ep;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f6297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f6298i;
    private String io;
    private int j;
    private String k;
    private int kf;
    private IMediationAdSlot m;
    private float n;
    private String o;
    private String ok;
    private boolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f6299q;
    private String r;
    private int rh;
    private float s;
    private boolean t;
    private String td;
    private String u;
    private String ul;
    private String vz;
    private int x;
    private TTAdLoadType y;
    private int z;
    private String zz;

    public static class Builder {
        private int ep;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int[] f6302i;
        private int j;
        private IMediationAdSlot m;
        private String o;
        private String ok;
        private String p;
        private int r;
        private float rh;
        private String td;
        private String u;
        private String ul;
        private String vz;
        private int x;
        private String y;
        private float z;
        private String zz;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6300a = 640;
        private int bl = 320;
        private boolean s = true;
        private boolean n = false;
        private boolean kf = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f6301h = 1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private String f6303q = "defaultUser";
        private int k = 2;
        private boolean t = true;
        private TTAdLoadType io = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.ok = this.ok;
            adSlot.kf = this.f6301h;
            adSlot.f6297h = this.s;
            adSlot.p = this.n;
            adSlot.f6299q = this.kf;
            adSlot.f6296a = this.f6300a;
            adSlot.bl = this.bl;
            adSlot.s = this.z;
            adSlot.n = this.rh;
            adSlot.k = this.p;
            adSlot.r = this.f6303q;
            adSlot.j = this.k;
            adSlot.rh = this.r;
            adSlot.t = this.t;
            adSlot.f6298i = this.f6302i;
            adSlot.x = this.x;
            adSlot.td = this.td;
            adSlot.u = this.ul;
            adSlot.io = this.o;
            adSlot.ul = this.y;
            adSlot.z = this.j;
            adSlot.zz = this.zz;
            adSlot.o = this.u;
            adSlot.y = this.io;
            adSlot.vz = this.vz;
            adSlot.ep = this.ep;
            adSlot.m = this.m;
            return adSlot;
        }

        public Builder setAdCount(int i2) {
            if (i2 <= 0) {
                i2 = 1;
            }
            if (i2 > 20) {
                i2 = 20;
            }
            this.f6301h = i2;
            return this;
        }

        public Builder setAdId(String str) {
            this.ul = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.io = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i2) {
            this.j = i2;
            return this;
        }

        public Builder setAdloadSeq(int i2) {
            this.x = i2;
            return this;
        }

        public Builder setCodeId(String str) {
            this.ok = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.o = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f2, float f3) {
            this.z = f2;
            this.rh = f3;
            return this;
        }

        public Builder setExt(String str) {
            this.y = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.f6302i = iArr;
            return this;
        }

        public Builder setImageAcceptedSize(int i2, int i3) {
            this.f6300a = i2;
            this.bl = i3;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.t = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.p = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.m = iMediationAdSlot;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i2) {
            this.r = i2;
            return this;
        }

        public Builder setOrientation(int i2) {
            this.k = i2;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.td = str;
            return this;
        }

        public Builder setRewardAmount(int i2) {
            this.ep = i2;
            return this;
        }

        public Builder setRewardName(String str) {
            this.vz = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.s = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.u = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f6303q = str;
            return this;
        }

        public Builder supportIconStyle() {
            this.kf = true;
            return this;
        }

        public Builder supportRenderControl() {
            this.n = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.zz = str;
            return this;
        }
    }

    public int getAdCount() {
        return this.kf;
    }

    public String getAdId() {
        return this.u;
    }

    public TTAdLoadType getAdLoadType() {
        return this.y;
    }

    public int getAdType() {
        return this.z;
    }

    public int getAdloadSeq() {
        return this.x;
    }

    public String getBidAdm() {
        return this.zz;
    }

    public String getCodeId() {
        return this.ok;
    }

    public String getCreativeId() {
        return this.io;
    }

    public float getExpressViewAcceptedHeight() {
        return this.n;
    }

    public float getExpressViewAcceptedWidth() {
        return this.s;
    }

    public String getExt() {
        return this.ul;
    }

    public int[] getExternalABVid() {
        return this.f6298i;
    }

    public int getImgAcceptedHeight() {
        return this.bl;
    }

    public int getImgAcceptedWidth() {
        return this.f6296a;
    }

    public String getMediaExtra() {
        return this.k;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.m;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.rh;
    }

    public int getOrientation() {
        return this.j;
    }

    public String getPrimeRit() {
        String str = this.td;
        return str == null ? "" : str;
    }

    public int getRewardAmount() {
        return this.ep;
    }

    public String getRewardName() {
        return this.vz;
    }

    public String getUserData() {
        return this.o;
    }

    public String getUserID() {
        return this.r;
    }

    public boolean isAutoPlay() {
        return this.t;
    }

    public boolean isSupportDeepLink() {
        return this.f6297h;
    }

    public boolean isSupportIconStyle() {
        return this.f6299q;
    }

    public boolean isSupportRenderConrol() {
        return this.p;
    }

    public void setAdCount(int i2) {
        this.kf = i2;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.y = tTAdLoadType;
    }

    public void setExternalABVid(int... iArr) {
        this.f6298i = iArr;
    }

    public void setGroupLoadMore(int i2) {
        this.k = ok(this.k, i2);
    }

    public void setNativeAdType(int i2) {
        this.rh = i2;
    }

    public void setUserData(String str) {
        this.o = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.ok);
            jSONObject.put("mIsAutoPlay", this.t);
            jSONObject.put("mImgAcceptedWidth", this.f6296a);
            jSONObject.put("mImgAcceptedHeight", this.bl);
            jSONObject.put("mExpressViewAcceptedWidth", this.s);
            jSONObject.put("mExpressViewAcceptedHeight", this.n);
            jSONObject.put("mAdCount", this.kf);
            jSONObject.put("mSupportDeepLink", this.f6297h);
            jSONObject.put("mSupportRenderControl", this.p);
            jSONObject.put("mSupportIconStyle", this.f6299q);
            jSONObject.put("mMediaExtra", this.k);
            jSONObject.put("mUserID", this.r);
            jSONObject.put("mOrientation", this.j);
            jSONObject.put("mNativeAdType", this.rh);
            jSONObject.put("mAdloadSeq", this.x);
            jSONObject.put("mPrimeRit", this.td);
            jSONObject.put("mAdId", this.u);
            jSONObject.put("mCreativeId", this.io);
            jSONObject.put("mExt", this.ul);
            jSONObject.put("mBidAdm", this.zz);
            jSONObject.put("mUserData", this.o);
            jSONObject.put("mAdLoadType", this.y);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.ok + "', mImgAcceptedWidth=" + this.f6296a + ", mImgAcceptedHeight=" + this.bl + ", mExpressViewAcceptedWidth=" + this.s + ", mExpressViewAcceptedHeight=" + this.n + ", mAdCount=" + this.kf + ", mSupportDeepLink=" + this.f6297h + ", mSupportRenderControl=" + this.p + ", mSupportIconStyle=" + this.f6299q + ", mMediaExtra='" + this.k + "', mUserID='" + this.r + "', mOrientation=" + this.j + ", mNativeAdType=" + this.rh + ", mIsAutoPlay=" + this.t + ", mPrimeRit" + this.td + ", mAdloadSeq" + this.x + ", mAdId" + this.u + ", mCreativeId" + this.io + ", mExt" + this.ul + ", mUserData" + this.o + ", mAdLoadType" + this.y + '}';
    }

    private AdSlot() {
        this.j = 2;
        this.t = true;
    }

    private String ok(String str, int i2) {
        JSONObject jSONObject;
        if (i2 < 1) {
            return str;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_tt_group_load_more", i2);
            return jSONObject.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return str;
        }
    }
}
