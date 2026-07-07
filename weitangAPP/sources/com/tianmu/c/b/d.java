package com.tianmu.c.b;

import android.text.TextUtils;
import com.tianmu.biz.utils.u;
import com.tianmu.utils.TianmuLogUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static void a(com.tianmu.c.k.f.d dVar, boolean z) {
        HashMap map = new HashMap(2);
        if (z) {
            map.put("initApiFirstRequest", Boolean.FALSE);
        } else {
            map.put("initApiFirstRequest", Boolean.TRUE);
        }
        String strD = u.d();
        boolean zE = u.e();
        if (!TextUtils.isEmpty(strD) && zE) {
            TianmuLogUtil.iD("request config init tag : " + strD);
            map.put("dataTag", strD);
        }
        com.tianmu.c.k.e.e().b(c.n, map, dVar);
    }
}
