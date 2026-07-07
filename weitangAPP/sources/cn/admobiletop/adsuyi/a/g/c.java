package cn.admobiletop.adsuyi.a.g;

import android.text.TextUtils;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class c implements ADSuyiPlatform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3281e;

    public c(String str, String str2, String str3, String str4) {
        this.f3277a = str;
        this.f3278b = str2;
        this.f3279c = str3;
        this.f3280d = str4;
    }

    public void a(int i2) {
        this.f3281e = i2;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform
    public boolean check() {
        boolean z = (TextUtils.isEmpty(this.f3277a) || TextUtils.isEmpty(this.f3278b) || (!cn.admobiletop.adsuyi.a.l.h.l().a(this.f3280d) && !"100001".equals(this.f3280d))) ? false : true;
        if (!z) {
            ADSuyiLogUtil.d("platform : " + this.f3277a + ", AppId : " + this.f3278b + " 检查校验没有通过");
        }
        return z;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform
    public String getAppId() {
        return this.f3278b;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform
    public String getAppKey() {
        return this.f3279c;
    }

    @Override // cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform
    public String getPlatform() {
        return this.f3277a;
    }

    public int a() {
        return this.f3281e;
    }
}
