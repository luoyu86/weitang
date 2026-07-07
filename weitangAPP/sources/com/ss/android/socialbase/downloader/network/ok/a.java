package com.ss.android.socialbase.downloader.network.ok;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.k;
import com.ss.android.socialbase.downloader.q.kf;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f10131a;
    private static final HandlerThread bl;
    public static long ok;
    private static final Handler s;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        bl = handlerThread;
        a();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        s = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.ok.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static void a() {
        ok = com.ss.android.socialbase.downloader.h.ok.bl().ok("preconnect_connection_outdate_time", 300000L);
        f10131a = com.ss.android.socialbase.downloader.h.ok.bl().ok("preconnect_head_info_outdate_time", 300000L);
        ok.ok().ok(com.ss.android.socialbase.downloader.h.ok.bl().ok("preconnect_max_cache_size", 3));
    }

    public static Looper ok() {
        return bl.getLooper();
    }

    public static void ok(final String str, final k kVar) {
        s.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.ok.a.2
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                if (TextUtils.isEmpty(str)) {
                    k kVar2 = kVar;
                    if (kVar2 != null) {
                        kVar2.ok(null);
                        return;
                    }
                    return;
                }
                try {
                    try {
                        List<com.ss.android.socialbase.downloader.model.bl> listA = a.a(0L, null, null);
                        blVarOk = ok.ok().ok(str) ? ok.ok().ok(str, listA) : null;
                        if (blVarOk == null) {
                            bl blVar = new bl(str, listA, 0L);
                            try {
                                blVar.ok();
                                if (blVar.n()) {
                                    ok.ok().ok(str, blVar);
                                }
                                blVarOk = blVar;
                            } catch (Exception e2) {
                                e = e2;
                                blVarOk = blVar;
                                e.printStackTrace();
                            } catch (Throwable th) {
                                th = th;
                                blVarOk = blVar;
                                try {
                                    blVarOk.bl();
                                } catch (Throwable unused) {
                                }
                                throw th;
                            }
                        }
                        Map<String, String> mapQ = blVarOk.q();
                        k kVar3 = kVar;
                        if (kVar3 != null) {
                            kVar3.ok(mapQ);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
                try {
                    blVarOk.bl();
                } catch (Throwable unused2) {
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.ss.android.socialbase.downloader.model.bl> a(long j, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.bl> list) {
        return kf.ok(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0L);
    }
}
