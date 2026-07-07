package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.bid.ADSuyiBidNotice;
import cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.qq.e.comm.pi.IBidding;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class h implements ADSuyiBidResponsed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBidding f3637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3638b;

    public h(IBidding iBidding, int i2) {
        this.f3637a = iBidding;
        this.f3638b = i2;
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed
    public double getCPM() {
        int i2;
        if (this.f3637a != null && (i2 = this.f3638b) >= 0) {
            return BigDecimal.valueOf(i2).divide(BigDecimal.valueOf(100L)).doubleValue();
        }
        if (this.f3638b == -1) {
            ADSuyiLogUtil.d("广点通（优量汇）渠道当前无竞价权限 ECPM : " + this.f3638b);
        }
        return this.f3638b;
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed
    public ADSuyiBidNotice getNotice() {
        return new g(this);
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
