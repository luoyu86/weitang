package com.tianmu.biz.utils;

import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.tianmu.TianmuSDK;

/* JADX INFO: loaded from: classes2.dex */
public class s0 {
    public static void a(String str) {
        if (TianmuSDK.getInstance().getContext() == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT == 25) {
                k0.a(TianmuSDK.getInstance().getContext(), str, 0);
            } else {
                Toast.makeText(TianmuSDK.getInstance().getContext(), str, 0).show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
