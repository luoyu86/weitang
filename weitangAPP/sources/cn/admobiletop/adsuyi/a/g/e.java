package cn.admobiletop.adsuyi.a.g;

import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e implements ADSuyiPosId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3296e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3297f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3298g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3299h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3300i;
    public List<ADSuyiPlatformPosId> j;
    public int k;
    public boolean l;
    public double m;
    public String n;
    public int o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3301q;

    public e(long j, long j2, String str, int i2, int i3, String str2, boolean z, int i4, int i5, int i6, double d2, String str3) {
        this.f3293b = j;
        this.f3294c = j2;
        this.f3295d = str;
        this.f3296e = i2;
        this.f3297f = i3;
        this.f3298g = str2;
        this.f3292a = z;
        this.f3300i = i5;
        this.k = i6;
        this.m = d2;
        this.n = str3;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public void b(boolean z) {
        this.f3299h = z;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public String getAdType() {
        return this.f3298g;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public int getBiddingTimeout() {
        return this.o;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public int getCompelRefresh() {
        return this.k;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public int getFrequencyMode() {
        return this.f3300i;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public long getGroupId() {
        return this.f3294c;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public double getHbBidFloor() {
        return this.m;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public long getId() {
        return this.f3293b;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public List<ADSuyiPlatformPosId> getPlatformPosIdList() {
        return this.j;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public String getPosId() {
        return this.f3295d;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public String getRequestMode() {
        return this.n;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public int getSingleSourceTimeout() {
        return this.p;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public int getTotalTimeout() {
        return this.f3301q;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public boolean isHeadingBid() {
        return this.l;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public boolean isLocalData() {
        return this.f3292a;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public boolean isLoopFrequencyType() {
        return getFrequencyMode() == 1;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public boolean needClick() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public boolean needFrequency() {
        return this.f3299h;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public boolean tNeedClick() {
        return false;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPosId
    public void updateTClick() {
    }

    public void a(List<ADSuyiPlatformPosId> list) {
        this.j = list;
    }

    public int b() {
        return this.f3297f;
    }

    public int a() {
        return this.f3296e;
    }

    public void a(int i2, int i3, int i4) {
        this.o = i2;
        this.p = i3;
        this.f3301q = i4;
    }
}
