package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class bl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile bl f9782a = null;
    private static String ok = "bl";
    private ConcurrentHashMap<Long, Runnable> bl;

    public bl() {
        this.bl = null;
        this.bl = new ConcurrentHashMap<>();
    }

    public static bl ok() {
        if (f9782a == null) {
            synchronized (bl.class) {
                if (f9782a == null) {
                    f9782a = new bl();
                }
            }
        }
        return f9782a;
    }

    public long a() {
        return r.q().optLong("quick_app_check_internal", 1200L);
    }

    public void ok(n nVar, boolean z, int i2, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i2 == 4) {
            if (!z) {
                ok(id, false, 2);
                nVar.a(false);
                return;
            } else {
                ok(id, true, 2);
                return;
            }
        }
        if (i2 == 5) {
            if (!z) {
                ok(id, false, 1);
                nVar.bl(false);
                return;
            } else {
                ok(id, true, 1);
                return;
            }
        }
        if (i2 != 7) {
            return;
        }
        Runnable runnableRemove = this.bl.remove(Long.valueOf(id));
        if (z) {
            com.ss.android.downloadlib.s.ok.ok().ok(id, 1);
            ok(id, true, 1);
        } else {
            if (runnableRemove != null) {
                com.ss.android.downloadlib.h.ok().a().post(runnableRemove);
            }
            ok(id, false, 1);
        }
    }

    private void ok(long j, boolean z, int i2) {
        com.ss.android.downloadlib.s.ok.ok().ok(j, z, i2);
        if (z) {
            r.io().ok(null, null, null, null, null, 3);
        }
    }

    public void ok(final n nVar, final int i2, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.a.n.ok().ok(new com.ss.android.downloadlib.a.s() { // from class: com.ss.android.downloadlib.addownload.bl.1
            @Override // com.ss.android.downloadlib.a.s
            public void ok(boolean z) {
                bl.this.ok(nVar, z, i2, downloadModel);
            }
        }, a());
    }

    public static boolean ok(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
