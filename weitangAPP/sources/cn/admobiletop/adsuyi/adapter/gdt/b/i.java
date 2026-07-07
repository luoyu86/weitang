package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.bid.ADSuyiBidNotice;
import com.qq.e.comm.pi.IBidding;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class i implements ADSuyiBidNotice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f3639a;

    public i(j jVar) {
        this.f3639a = jVar;
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidNotice
    public void sendLossNotice(int i2, ArrayList<Double> arrayList) {
        int iIntValue = 0;
        if (arrayList != null && arrayList.size() > 0) {
            iIntValue = BigDecimal.valueOf(arrayList.get(0).doubleValue()).multiply(new BigDecimal(100)).intValue();
        }
        if (this.f3639a.f3640a != null) {
            if (i2 == 1) {
                HashMap map = new HashMap(3);
                map.put(IBidding.WIN_PRICE, Integer.valueOf(iIntValue));
                map.put(IBidding.LOSS_REASON, 1);
                map.put(IBidding.ADN_ID, 2);
                this.f3639a.f3640a.sendWinNotification(map);
                return;
            }
            if (i2 == 2) {
                HashMap map2 = new HashMap(3);
                map2.put(IBidding.WIN_PRICE, Integer.valueOf(iIntValue));
                map2.put(IBidding.LOSS_REASON, 101);
                map2.put(IBidding.ADN_ID, 2);
                this.f3639a.f3640a.sendWinNotification(map2);
                return;
            }
            if (i2 == 3) {
                HashMap map3 = new HashMap(3);
                map3.put(IBidding.WIN_PRICE, Integer.valueOf(iIntValue));
                map3.put(IBidding.LOSS_REASON, 10001);
                map3.put(IBidding.ADN_ID, 2);
                this.f3639a.f3640a.sendWinNotification(map3);
            }
        }
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidNotice
    public void sendWinNotice(ArrayList<Double> arrayList) {
        BigDecimal bigDecimalMultiply;
        if (this.f3639a.f3640a != null) {
            HashMap map = new HashMap();
            map.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(BigDecimal.valueOf(this.f3639a.f3641b).multiply(new BigDecimal(100)).intValue()));
            map.put(IBidding.HIGHEST_LOSS_PRICE, 0);
            if (arrayList.size() > 1 && (bigDecimalMultiply = BigDecimal.valueOf(arrayList.get(1).doubleValue()).multiply(new BigDecimal(100))) != null) {
                map.put(IBidding.HIGHEST_LOSS_PRICE, Integer.valueOf(bigDecimalMultiply.intValue()));
            }
            this.f3639a.f3640a.sendWinNotification(map);
        }
    }
}
