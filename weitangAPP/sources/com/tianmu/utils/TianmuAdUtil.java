package com.tianmu.utils;

import com.tianmu.ad.base.BaseAd;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuAdUtil {
    public static boolean canCallBack(BaseAd baseAd) {
        return (isReleased(baseAd) || baseAd.getListener() == null) ? false : true;
    }

    public static boolean isReleased(BaseAd baseAd) {
        return baseAd == null || baseAd.isReleased();
    }
}
