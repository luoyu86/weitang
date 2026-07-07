package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.qq.e.comm.constants.ErrorCode;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.h.r;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ok.ok;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class bl implements com.ss.android.socialbase.appdownloader.bl.p {
    private static String ok = "bl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f9853a = new Handler(Looper.getMainLooper());

    @Override // com.ss.android.socialbase.appdownloader.bl.p
    public void ok(DownloadInfo downloadInfo, BaseException baseException, int i2) {
        final DownloadModel downloadModelOk;
        if (downloadInfo == null) {
            return;
        }
        if (i2 == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
            ok.ok(jSONObject, downloadInfo);
            r.ok("download_failed", jSONObject.toString());
        }
        com.ss.android.downloadad.api.ok.a aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        if (aVarOk == null) {
            return;
        }
        try {
            if (i2 != -1) {
                if (i2 == -3) {
                    ok.ok(downloadInfo, aVarOk);
                    return;
                }
                if (i2 == 2001) {
                    ok.ok().ok(downloadInfo, aVarOk, ErrorCode.INIT_ERROR);
                    return;
                } else {
                    if (i2 == 11) {
                        ok.ok().ok(downloadInfo, aVarOk, 2000);
                        if (aVarOk.ej()) {
                            return;
                        }
                        ok(downloadInfo, aVarOk);
                        return;
                    }
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.f9853a.post(new Runnable() { // from class: com.ss.android.downloadlib.bl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.r.bl().ok(5, com.ss.android.downloadlib.addownload.r.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (com.ss.android.socialbase.downloader.q.kf.p(baseException)) {
                    if (com.ss.android.downloadlib.addownload.r.z() != null) {
                        com.ss.android.downloadlib.addownload.r.z().ok(aVarOk.a());
                    }
                    com.ss.android.downloadlib.s.ok.ok().ok("download_failed_for_space", aVarOk);
                    if (!aVarOk.vk()) {
                        com.ss.android.downloadlib.s.ok.ok().ok("download_can_restart", aVarOk);
                        ok(downloadInfo);
                    }
                    if ((com.ss.android.downloadlib.addownload.r.z() == null || !com.ss.android.downloadlib.addownload.r.z().s()) && (downloadModelOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(aVarOk.a())) != null && downloadModelOk.isShowToast()) {
                        final com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
                        if (okVarOk.ok("show_no_enough_space_toast", 0) == 1) {
                            this.f9853a.post(new Runnable() { // from class: com.ss.android.downloadlib.bl.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.ss.android.downloadlib.addownload.r.bl().ok(2, com.ss.android.downloadlib.addownload.r.getContext(), downloadModelOk, okVarOk.ok("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), j.ok(baseException.getMessage(), com.ss.android.downloadlib.addownload.r.q().optInt("exception_msg_length", 500)));
            }
            com.ss.android.downloadlib.s.ok.ok().a(downloadInfo, baseException2);
            h.ok().ok(downloadInfo, baseException, "");
        } catch (Exception e2) {
            com.ss.android.downloadlib.addownload.r.u().ok(e2, "onAppDownloadMonitorSend");
        }
    }

    private void ok(final DownloadInfo downloadInfo, final com.ss.android.downloadad.api.ok.a aVar) {
        final long jOk = j.ok(Environment.getDataDirectory(), -1L);
        long jMin = Math.min(524288000L, j.ok(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        final double d2 = (totalBytes * 2.5d) + jMin;
        if (jOk > -1 && totalBytes > -1) {
            double d3 = jOk;
            if (d3 < d2 && d2 - d3 > com.ss.android.downloadlib.addownload.s.a()) {
                com.ss.android.downloadlib.addownload.s.ok(downloadInfo.getId());
            }
        }
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(new ok.InterfaceC0174ok() { // from class: com.ss.android.downloadlib.bl.3
            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
            public void a() {
                if (j.a(aVar)) {
                    com.ss.android.socialbase.downloader.ok.ok.ok().a(this);
                    return;
                }
                long j = jOk;
                if (j <= -1 || totalBytes <= -1 || j >= d2) {
                    return;
                }
                com.ss.android.downloadlib.s.ok.ok().ok("clean_space_install", com.ss.android.downloadlib.addownload.s.ok("install_no_enough_space"), aVar);
                if (com.ss.android.downloadlib.addownload.s.ok(downloadInfo, ((long) d2) - jOk)) {
                    com.ss.android.socialbase.downloader.ok.ok.ok().a(this);
                    aVar.h(true);
                }
            }

            @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC0174ok
            public void bl() {
            }
        });
    }

    private void ok(@NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.h.n.kf(downloadInfo.getId())) {
            s.ok().a(new com.ss.android.downloadlib.addownload.bl.a(downloadInfo));
        }
    }
}
