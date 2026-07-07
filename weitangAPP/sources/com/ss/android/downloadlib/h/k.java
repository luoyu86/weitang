package com.ss.android.downloadlib.h;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    private static Map<String, ok> ok = Collections.synchronizedMap(new HashMap());

    public interface ok {
        void ok();

        void ok(String str);
    }

    public static boolean a(String str) {
        return com.ss.android.downloadlib.addownload.r.n().ok(com.ss.android.downloadlib.addownload.r.getContext(), str);
    }

    private static ok bl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return ok.remove(str);
    }

    public static void ok(String[] strArr, ok okVar) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        String strValueOf = String.valueOf(System.currentTimeMillis());
        ok(strValueOf, okVar);
        TTDelegateActivity.ok(strValueOf, strArr);
    }

    public static void ok(String str) {
        ok okVarBl;
        if (TextUtils.isEmpty(str) || (okVarBl = bl(str)) == null) {
            return;
        }
        okVarBl.ok();
    }

    public static void ok(String str, String str2) {
        ok okVarBl;
        if (TextUtils.isEmpty(str) || (okVarBl = bl(str)) == null) {
            return;
        }
        okVarBl.ok(str2);
    }

    private static void ok(String str, ok okVar) {
        if (TextUtils.isEmpty(str) || okVar == null) {
            return;
        }
        ok.put(str, okVar);
    }
}
