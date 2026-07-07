package com.ss.android.socialbase.appdownloader.a;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;

/* JADX INFO: loaded from: classes2.dex */
public class ok {
    public static final String ok;

    static {
        StringBuilder sb = new StringBuilder();
        String str = Build.VERSION.RELEASE;
        boolean z = !TextUtils.isEmpty(str);
        boolean z2 = !TextUtils.isEmpty(Build.ID);
        boolean z3 = "REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL);
        sb.append("AppDownloader");
        if (z) {
            sb.append("/");
            sb.append(str);
        }
        sb.append(" (Linux; U; Android");
        if (z) {
            sb.append(" ");
            sb.append(str);
        }
        if (z3 || z2) {
            sb.append(i.f5697b);
            if (z3) {
                sb.append(" ");
                sb.append(Build.MODEL);
            }
            if (z2) {
                sb.append(" Build/");
                sb.append(Build.ID);
            }
        }
        sb.append(")");
        ok = sb.toString();
    }
}
