package c.e.e.a.r;

import c.e.e.a.r.j.k;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static a a(int i2) {
        a bVar;
        if (i2 == 0) {
            return k.getInstance().setScanOnly(false);
        }
        if (i2 == 1) {
            bVar = new b(null);
        } else {
            if (i2 == 2) {
                return c.getInstance().setScanOnly(false);
            }
            if (i2 == 15) {
                AppConfigExtVo appConfigExtVo = c.e.a.d.g.getInstance().getAppConfigExtVo();
                bVar = (appConfigExtVo == null || !appConfigExtVo.isEnableNewMtLock()) ? new e(null) : new f(null);
            } else {
                if (i2 != 16) {
                    return null;
                }
                bVar = new i(null);
            }
        }
        return bVar;
    }
}
