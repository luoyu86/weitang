package com.tianmu.biz.utils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e0 {
    public static int a(Map<String, com.tianmu.c.i.c> map, List<String> list, int i2) {
        if (map != null && list != null) {
            if (list.size() > 1 && map.size() > 1) {
                try {
                    return Math.min(new BigDecimal(map.get(list.get(0)).h()).add(new BigDecimal(map.get(list.get(1)).h())).divide(new BigDecimal(2), 0, 1).intValue(), i2);
                } catch (Exception unused) {
                    return i2;
                }
            }
            if (list.size() == 1 && map.size() == 1) {
                return map.get(list.get(0)).h();
            }
        }
        return 0;
    }
}
