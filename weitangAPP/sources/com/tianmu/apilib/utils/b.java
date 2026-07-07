package com.tianmu.apilib.utils;

import android.text.TextUtils;
import com.tianmu.biz.utils.TianmuNativeCommonUtil;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static String a() {
        String strL = TianmuNativeCommonUtil.N().l();
        return TextUtils.isEmpty(strL) ? "" : strL;
    }

    public static String b() {
        return new com.tianmu.c.e.a().a(TianmuNativeCommonUtil.N().k()) + TianmuNativeCommonUtil.N().m();
    }
}
