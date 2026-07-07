package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.bid.ADSuyiBidNotice;
import cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed;
import com.qq.e.comm.pi.IBidding;

/* JADX INFO: loaded from: classes.dex */
public class j implements ADSuyiBidResponsed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBidding f3640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f3641b;

    public j(IBidding iBidding, double d2) {
        this.f3640a = iBidding;
        this.f3641b = d2;
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed
    public double getCPM() {
        return this.f3641b;
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed
    public ADSuyiBidNotice getNotice() {
        return new i(this);
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed
    public String getPlatform() {
        return "gdt";
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed
    public String getToken() {
        return "";
    }
}
