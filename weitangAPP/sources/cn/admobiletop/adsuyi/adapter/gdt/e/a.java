package cn.admobiletop.adsuyi.adapter.gdt.e;

import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.adapter.gdt.b.j;
import com.qq.e.comm.pi.IBidding;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static double a() {
        return new BigDecimal(d.a(ADSuyiSdk.getInstance().getContext(), "gdt", "0")).doubleValue();
    }

    public static boolean b() {
        return ADSuyiSdk.getInstance().getConfig() != null && ADSuyiSdk.getInstance().getConfig().isDebug() && ADSuyiSdk.getInstance().getConfig().isSandbox();
    }

    public static j a(IBidding iBidding) {
        double dA = a();
        if (dA > 0.0d) {
            return new j(iBidding, dA);
        }
        return null;
    }
}
