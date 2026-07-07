package com.tianmu.apilib.utils;

import android.text.TextUtils;
import com.tianmu.biz.utils.TianmuNativeCommonUtil;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String a() {
        String strL = TianmuNativeCommonUtil.N().L();
        return TextUtils.isEmpty(strL) ? "" : strL;
    }

    public static String b() {
        return new com.tianmu.c.e.a().a(TianmuNativeCommonUtil.N().K()) + TianmuNativeCommonUtil.N().M();
    }
}
