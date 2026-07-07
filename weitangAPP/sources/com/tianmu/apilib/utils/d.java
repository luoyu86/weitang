package com.tianmu.apilib.utils;

import android.text.TextUtils;
import com.tianmu.biz.utils.TianmuNativeCommonUtil;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static String a() {
        String strH = TianmuNativeCommonUtil.N().H();
        return TextUtils.isEmpty(strH) ? "" : strH;
    }

    public static String b() {
        return new com.tianmu.c.e.a().a(TianmuNativeCommonUtil.N().G()) + TianmuNativeCommonUtil.N().I();
    }
}
