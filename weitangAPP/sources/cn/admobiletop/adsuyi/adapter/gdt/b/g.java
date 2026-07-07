package cn.admobiletop.adsuyi.adapter.gdt.b;

import cn.admobiletop.adsuyi.bid.ADSuyiBidNotice;
import com.qq.e.comm.pi.IBidding;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class g implements ADSuyiBidNotice {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f3636a;

    public g(h hVar) {
        this.f3636a = hVar;
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidNotice
    public void sendLossNotice(int i2, ArrayList<Double> arrayList) {
        int iIntValue = 0;
        if (arrayList != null && arrayList.size() > 0) {
            iIntValue = BigDecimal.valueOf(arrayList.get(0).doubleValue()).multiply(new BigDecimal(100)).intValue();
        }
        if (this.f3636a.f3637a != null) {
            if (i2 == 1) {
                HashMap map = new HashMap(3);
                map.put(IBidding.WIN_PRICE, Integer.valueOf(iIntValue));
                map.put(IBidding.LOSS_REASON, 1);
                map.put(IBidding.ADN_ID, 2);
                this.f3636a.f3637a.sendLossNotification(map);
                return;
            }
            if (i2 == 2) {
                HashMap map2 = new HashMap(3);
                map2.put(IBidding.WIN_PRICE, Integer.valueOf(iIntValue));
                map2.put(IBidding.LOSS_REASON, 101);
                map2.put(IBidding.ADN_ID, 2);
                this.f3636a.f3637a.sendLossNotification(map2);
                return;
            }
            if (i2 == 3) {
                HashMap map3 = new HashMap(3);
                map3.put(IBidding.WIN_PRICE, Integer.valueOf(iIntValue));
                map3.put(IBidding.LOSS_REASON, 10001);
                map3.put(IBidding.ADN_ID, 2);
                this.f3636a.f3637a.sendLossNotification(map3);
            }
        }
    }

    @Override // cn.admobiletop.adsuyi.bid.ADSuyiBidNotice
    public void sendWinNotice(ArrayList<Double> arrayList) {
        if (arrayList == null) {
            if (this.f3636a.f3637a != null) {
                HashMap map = new HashMap();
                map.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(this.f3636a.f3638b));
                map.put(IBidding.HIGHEST_LOSS_PRICE, 0);
                this.f3636a.f3637a.sendWinNotification(map);
                return;
            }
            return;
        }
        if (arrayList.size() <= 1) {
            if (arrayList.size() != 1 || this.f3636a.f3637a == null) {
                return;
            }
            HashMap map2 = new HashMap();
            map2.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(this.f3636a.f3638b));
            map2.put(IBidding.HIGHEST_LOSS_PRICE, 0);
            this.f3636a.f3637a.sendWinNotification(map2);
            return;
        }
        if (this.f3636a.f3637a != null) {
            BigDecimal bigDecimalMultiply = BigDecimal.valueOf(arrayList.get(1).doubleValue()).multiply(new BigDecimal(100));
            if (bigDecimalMultiply != null) {
                HashMap map3 = new HashMap();
                map3.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(this.f3636a.f3638b));
                map3.put(IBidding.HIGHEST_LOSS_PRICE, Integer.valueOf(bigDecimalMultiply.intValue()));
                this.f3636a.f3637a.sendWinNotification(map3);
                return;
            }
            HashMap map4 = new HashMap();
            map4.put(IBidding.EXPECT_COST_PRICE, Integer.valueOf(this.f3636a.f3638b));
            map4.put(IBidding.HIGHEST_LOSS_PRICE, 0);
            this.f3636a.f3637a.sendWinNotification(map4);
        }
    }
}
