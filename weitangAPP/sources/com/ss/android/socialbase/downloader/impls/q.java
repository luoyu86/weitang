package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class q implements com.ss.android.socialbase.downloader.downloader.r {
    @Override // com.ss.android.socialbase.downloader.downloader.r
    public int ok(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strN = com.ss.android.socialbase.downloader.q.kf.n(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(strN)) {
            return 0;
        }
        return strN.hashCode();
    }
}
