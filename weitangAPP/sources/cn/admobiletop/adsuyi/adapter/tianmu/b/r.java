package cn.admobiletop.adsuyi.adapter.tianmu.b;

import cn.admobiletop.adsuyi.bid.ADSuyiBidNotice;
import java.math.BigDecimal;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class r implements ADSuyiBidNotice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f3830a;

    public r(s sVar) {
        this.f3830a = sVar;
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidNotice
    public void sendLossNotice(int i2, ArrayList<Double> arrayList) {
        int iIntValue = (arrayList == null || arrayList.size() <= 0) ? 0 : BigDecimal.valueOf(arrayList.get(0).doubleValue()).multiply(new BigDecimal(100)).intValue();
        if (this.f3830a.f3831a != null) {
            if (i2 == 1) {
                this.f3830a.f3831a.sendLossNotice(iIntValue, 1);
            } else {
                this.f3830a.f3831a.sendLossNotice(iIntValue, 0);
            }
        }
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidNotice
    public void sendWinNotice(ArrayList<Double> arrayList) {
        if (this.f3830a.f3831a != null) {
            this.f3830a.f3831a.sendWinNotice(this.f3830a.f3832b);
        }
    }
}
