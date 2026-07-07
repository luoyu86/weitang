package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.bid.ADSuyiBidNotice;
import cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.tianmu.ad.base.IBidding;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class s implements ADSuyiBidResponsed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBidding f3831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3832b;

    public s(IBidding iBidding, int i2) {
        this.f3831a = iBidding;
        this.f3832b = i2;
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed
    public double getCPM() {
        int i2;
        if (this.f3831a != null && (i2 = this.f3832b) > 0) {
            return BigDecimal.valueOf(i2).divide(BigDecimal.valueOf(100L)).doubleValue();
        }
        ADSuyiLogUtil.d("天目渠道当前无竞价权限 price = 0 ");
        return 0.0d;
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed
    public ADSuyiBidNotice getNotice() {
        return new r(this);
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed
    public String getPlatform() {
        return "tianmu";
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidResponsed
    public String getToken() {
        return "";
    }
}
