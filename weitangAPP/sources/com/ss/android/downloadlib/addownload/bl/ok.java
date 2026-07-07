package com.ss.android.downloadlib.addownload.bl;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.h.r;
import com.ss.android.socialbase.downloader.depend.td;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class ok implements td {
    private int ok;

    private long a(com.ss.android.socialbase.downloader.h.ok okVar) {
        long jOk = okVar.ok("clear_space_sleep_time", 0L);
        if (jOk <= 0) {
            return 0L;
        }
        if (jOk > 5000) {
            jOk = 5000;
        }
        r.a("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + jOk, null);
        try {
            Thread.sleep(jOk);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        r.a("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return jOk;
    }

    public void ok(int i2) {
        this.ok = i2;
    }

    @Override // com.ss.android.socialbase.downloader.depend.td
    public boolean ok(long j, long j2, x xVar) throws Throwable {
        long j3;
        com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(this.ok);
        if (!ok(okVarOk)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        s.ok().bl();
        long jA = j.a(0L);
        ok();
        long jA2 = j.a(0L);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jA2 < j2) {
            long jA3 = a(okVarOk);
            if (jA3 > 0) {
                jA2 = j.a(0L);
            }
            j3 = jA3;
        } else {
            j3 = 0;
        }
        r.a("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + jA2 + ", cleaned = " + (jA2 - jA), null);
        long j4 = jA2;
        ok(jA, jA2, j2, jCurrentTimeMillis2, j3);
        if (j4 < j2) {
            return false;
        }
        if (xVar == null) {
            return true;
        }
        xVar.ok();
        return true;
    }

    private boolean ok(com.ss.android.socialbase.downloader.h.ok okVar) {
        if (okVar.ok("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - s.ok().a() >= okVar.ok("clear_space_min_time_interval", TTAdConstant.AD_MAX_EVENT_TIME);
    }

    private void ok() throws Throwable {
        com.ss.android.download.api.config.n nVarI = com.ss.android.downloadlib.addownload.r.i();
        if (nVarI != null) {
            nVarI.ok();
        }
        bl.ok();
        bl.a();
    }

    private void ok(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).getDownloadInfo(this.ok);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.ok.ok().ok(downloadInfo, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
