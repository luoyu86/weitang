package cn.admobiletop.adsuyi.ad.adapter;

import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiAdapterParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiPlatformPosId f3485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiPlatform f3486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3489f;

    public ADSuyiAdapterParams(ADSuyiPlatformPosId aDSuyiPlatformPosId, ADSuyiPlatform aDSuyiPlatform, boolean z, int i2, String str, boolean z2) {
        this.f3487d = z;
        this.f3486c = aDSuyiPlatform;
        this.f3485b = aDSuyiPlatformPosId;
        this.f3488e = i2;
        this.f3484a = str;
        this.f3489f = z2;
    }

    public int getCount() {
        return this.f3488e;
    }

    public ADSuyiPlatform getPlatform() {
        return this.f3486c;
    }

    public ADSuyiPlatformPosId getPlatformPosId() {
        return this.f3485b;
    }

    public String getPosId() {
        return this.f3484a;
    }

    public boolean isCompelRefresh() {
        return this.f3489f;
    }

    public boolean isReward() {
        return this.f3487d;
    }
}
