package com.tianmu.biz.utils;

import android.os.Environment;
import android.os.StatFs;

/* JADX INFO: loaded from: classes2.dex */
public class r {
    public static long a() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Exception unused) {
            return 0L;
        }
    }
}
