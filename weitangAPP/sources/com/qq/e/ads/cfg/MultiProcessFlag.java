package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: loaded from: classes2.dex */
public class MultiProcessFlag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f9539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f9540b;

    public static boolean isMultiProcess() {
        return f9539a;
    }

    public static void setMultiProcess(boolean z) {
        if (f9540b) {
            GDTLogger.w("MultiProcessFlag已经设置过，再次设置无效");
        } else {
            f9540b = true;
            f9539a = z;
        }
    }
}
