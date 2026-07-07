package com.tianmu.biz.utils;

import com.tianmu.TianmuSDK;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static int a() {
        return new BigDecimal(j0.a(TianmuSDK.getInstance().getContext(), "tianmu", "0")).multiply(new BigDecimal(100)).intValue();
    }

    public static boolean b() {
        return TianmuSDK.getInstance().getConfig() != null && TianmuSDK.getInstance().getConfig().isDebug();
    }
}
