package cn.admobiletop.adsuyi.a.g;

import android.text.TextUtils;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;

/* JADX INFO: loaded from: classes.dex */
public class d implements ADSuyiPlatformPosId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f3289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3290i;
    public ADSuyiAdSize j;
    public boolean k;
    public long l;
    public long m;
    public String n;
    public int o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3291q;
    public int r;
    public double s;
    public boolean t;
    public int u;
    public String v;
    public String w;

    public d(long j, String str, String str2, int i2, int i3, String str3, int i4, String str4, String str5, int i5, int i6, boolean z, int i7, int i8, boolean z2, double d2, int i9, String str6) {
        this.f3282a = j;
        this.f3283b = str;
        this.f3284c = str2;
        this.f3285d = i2;
        this.f3288g = i3;
        this.f3289h = str3;
        this.f3290i = i4;
        this.n = str5;
        this.o = i5;
        this.p = i6;
        this.f3291q = z;
        this.f3286e = i7;
        this.r = i8;
        this.t = z2;
        this.s = d2;
        this.u = i9;
        this.w = str6;
        b(str4);
    }

    public void a(long j) {
        this.l = j;
    }

    public void b(long j) {
        this.m = j;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public ADSuyiAdSize getAdSize() {
        return this.j;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public String getAdType() {
        return this.w;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public String getBidToken() {
        return this.v;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public int getContentSize() {
        return this.r;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public double getECPM() {
        return this.s;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public long getFirstShowTime() {
        return this.l;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public int getFrequency() {
        return this.f3285d;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public long getFrequencyFinishTime() {
        return this.f3287f;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public int getFrequencyMode() {
        return this.f3286e;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public long getId() {
        return this.f3282a;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public long getIntervalShowTime() {
        return this.m;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public String getPlacementId() {
        return this.n;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public String getPlatform() {
        return this.f3283b;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public String getPlatformPosId() {
        return this.f3284c;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public int getRenderType() {
        return this.f3288g;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public int getRequestRate() {
        return this.u;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public int getScreenOrientation() {
        return this.f3290i;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public int getSkipShowTime() {
        return this.o;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public String getTemplate() {
        return this.f3289h;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public boolean isBidType() {
        return this.t;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public boolean isBottom() {
        return this.f3291q;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public boolean isFrequencyFinished() {
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public boolean isLoopFrequencyType() {
        return getFrequencyMode() == 1;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public boolean isSplashHotAreaCtl() {
        return this.p == 1;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public void setBidToken(String str) {
        this.v = str;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public void setECPM(double d2) {
        this.s = d2;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public void setFrequencyFinishTime(long j) {
        this.f3287f = j;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId
    public void setFrequencyFinished(boolean z) {
        this.k = z;
    }

    public String toString() {
        return "PlatformPosId{id=" + this.f3282a + ", platform='" + this.f3283b + "', platformPosId='" + this.f3284c + "', frequency=" + this.f3285d + ", frequencyType=" + this.f3286e + ", frequencyFinished=" + this.k + ", frequencyFinishTime=" + this.f3287f + ", ecpm=" + this.s + ", headerBidding=" + this.t + ", requestRate=" + this.u + ", adType=" + this.w + ", hashcode=" + Integer.toHexString(hashCode()) + '}';
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] strArrSplit = null;
        try {
            if (str.contains("*")) {
                strArrSplit = str.split("\\*");
            } else if (str.contains(":")) {
                strArrSplit = str.split(":");
            }
            if (strArrSplit == null || strArrSplit.length != 2) {
                return;
            }
            int i2 = Integer.parseInt(strArrSplit[0].trim());
            int i3 = Integer.parseInt(strArrSplit[1].trim());
            if (i2 <= 0 || i3 <= 0) {
                return;
            }
            this.j = new ADSuyiAdSize(i2, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
