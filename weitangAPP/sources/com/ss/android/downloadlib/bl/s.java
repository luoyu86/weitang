package com.ss.android.downloadlib.bl;

import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.a.q;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class s implements com.ss.android.socialbase.appdownloader.bl.h, r {
    @Override // com.ss.android.socialbase.downloader.depend.r
    public void a() {
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.bl.s.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.ss.android.downloadlib.addownload.a.kf.ok().a();
                for (com.ss.android.downloadad.api.ok.a aVar : com.ss.android.downloadlib.addownload.a.kf.ok().bl().values()) {
                    int iZz = aVar.zz();
                    if (iZz != 0) {
                        com.ss.android.socialbase.downloader.h.ok okVarOk = com.ss.android.socialbase.downloader.h.ok.ok(iZz);
                        if (okVarOk.a("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).getDownloadInfo(iZz)) != null) {
                            if (j.a(aVar) && !j.bl(aVar.n())) {
                                int spIntVal2 = downloadInfo.getSpIntVal("restart_notify_open_app_count");
                                if (spIntVal2 < okVarOk.ok("noti_open_restart_times", 1)) {
                                    p.ok().n(aVar);
                                    downloadInfo.setSpValue("restart_notify_open_app_count", String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal("restart_notify_continue_count");
                                if (spIntVal3 < okVarOk.ok("noti_continue_restart_times", 1)) {
                                    p.ok().ok(aVar);
                                    downloadInfo.setSpValue("restart_notify_continue_count", String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && com.ss.android.socialbase.downloader.q.kf.bl(downloadInfo) && !j.a(aVar) && (spIntVal = downloadInfo.getSpIntVal("restart_notify_install_count")) < okVarOk.ok("noti_install_restart_times", 1)) {
                                p.ok().bl(aVar);
                                downloadInfo.setSpValue("restart_notify_install_count", String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }

    @Override // com.ss.android.socialbase.downloader.depend.r
    public void ok() {
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.h
    public void ok(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        ok(downloadInfo, downloadInfo.getRealStatus(), z);
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.h
    public void ok(List<DownloadInfo> list) {
    }

    @WorkerThread
    public void ok(DownloadInfo downloadInfo, int i2, boolean z) {
        com.ss.android.downloadlib.addownload.a.kf.ok().a();
        com.ss.android.downloadad.api.ok.a aVarOk = com.ss.android.downloadlib.addownload.a.kf.ok().ok(downloadInfo);
        if (aVarOk == null) {
            return;
        }
        try {
            if (z) {
                aVarOk.bl(downloadInfo.getFailedResumeCount());
            } else if (aVarOk.fb() == -1) {
                return;
            } else {
                aVarOk.bl(-1);
            }
            q.ok().ok(aVarOk);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put(AgooConstants.OPEN_URL, downloadInfo.getUrl());
            jSONObject.put("download_time", downloadInfo.getDownloadTime());
            jSONObject.put("download_status", i2);
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            int i3 = 1;
            jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            if (!z) {
                i3 = 2;
            }
            jSONObject.put("launch_resumed", i3);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            com.ss.android.downloadlib.s.ok.ok().ok("embeded_ad", "download_uncompleted", jSONObject, aVarOk);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
