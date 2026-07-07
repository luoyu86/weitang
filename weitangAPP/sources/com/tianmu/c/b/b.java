package com.tianmu.c.b;

import android.text.TextUtils;
import com.tianmu.utils.TianmuLogUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static void a(com.tianmu.c.k.f.b bVar) {
        HashMap map = new HashMap(1);
        String strD = com.tianmu.biz.utils.a.d();
        boolean zE = com.tianmu.biz.utils.a.e();
        if (!TextUtils.isEmpty(strD) && zE) {
            TianmuLogUtil.iD("request config map tag : " + strD);
            map.put("dataTag", strD);
        }
        com.tianmu.c.k.e.e().b(c.s, map, null, bVar);
    }
}
