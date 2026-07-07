package cn.admobiletop.adsuyi.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import cn.admobiletop.adsuyi.a.m.n;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiToastUtil {
    public static void show(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT == 25) {
                n.a(context, str);
            } else {
                Toast.makeText(context, str, 0).show();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
