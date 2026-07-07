package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.zz;

/* JADX INFO: loaded from: classes2.dex */
public class x implements zz {
    private final long[] ok;

    public x(String str) {
        this.ok = ok(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zz
    public long ok(int i2, int i3) {
        long[] jArr = this.ok;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int length = i2 - 1;
        if (length < 0) {
            length = 0;
        }
        if (length > jArr.length - 1) {
            length = jArr.length - 1;
        }
        return jArr[length];
    }

    private long[] ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length == 0) {
                return null;
            }
            long[] jArr = new long[strArrSplit.length];
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                jArr[i2] = Long.parseLong(strArrSplit[i2]);
            }
            return jArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
