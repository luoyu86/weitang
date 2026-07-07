package com.tianmu.biz.bean;

import com.tianmu.biz.utils.w0;
import com.tianmu.c.n.n;

/* JADX INFO: loaded from: classes2.dex */
public class DownloadTipType {
    public static final int TYPE_ALL = 2;
    public static final int TYPE_DEFAULT = 1;
    public static final int TYPE_NOT_ALL = 0;
    public static final int TYPE_NOT_WIFI = 1;

    public static boolean notAutoStartDownload() {
        int iG = n.D().g();
        if (2 == iG) {
            return true;
        }
        return 1 == iG && !w0.a();
    }
}
