package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.downloader.z f10050a;
    private static volatile com.ss.android.socialbase.downloader.downloader.z ok;

    public static com.ss.android.socialbase.downloader.downloader.z ok(boolean z) {
        if (z && com.ss.android.socialbase.downloader.downloader.bl.qx()) {
            if (f10050a == null) {
                synchronized (j.class) {
                    if (f10050a == null) {
                        f10050a = com.ss.android.socialbase.downloader.downloader.bl.tr().a();
                    }
                }
            }
            return f10050a;
        }
        if (ok == null) {
            synchronized (j.class) {
                if (ok == null) {
                    ok = new i();
                }
            }
        }
        return ok;
    }
}
