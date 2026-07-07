package com.tianmu.c.d;

import android.text.TextUtils;
import com.tianmu.biz.utils.TianmuNativeCommonUtil;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static String a() {
        String strI = TianmuNativeCommonUtil.N().i();
        return TextUtils.isEmpty(strI) ? "" : strI;
    }

    public static String b() {
        String strJ = TianmuNativeCommonUtil.N().j();
        return TextUtils.isEmpty(strJ) ? "" : strJ;
    }

    public static String c() {
        return new com.tianmu.c.e.a().a(a()) + TianmuNativeCommonUtil.N().J();
    }
}
