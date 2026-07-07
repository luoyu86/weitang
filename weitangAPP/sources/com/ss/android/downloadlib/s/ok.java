package com.ss.android.downloadlib.s;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.bl;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.downloadlib.addownload.a.n;
import com.ss.android.downloadlib.addownload.a.q;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.appdownloader.n.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ok {

    /* JADX INFO: renamed from: com.ss.android.downloadlib.s.ok$ok, reason: collision with other inner class name */
    public static class C0141ok {
        private static ok ok = new ok();
    }

    public static ok ok() {
        return C0141ok.ok;
    }

    public void a(long j, int i2) {
        ok(j, i2, (DownloadInfo) null);
    }

    private ok() {
    }

    public void a(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null) {
            return;
        }
        com.ss.android.downloadad.api.ok.a aVarOk = kf.ok().ok(downloadInfo);
        if (aVarOk == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("sendDownloadFailedEvent nativeModel null");
            return;
        }
        if (aVarOk.bl.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
            com.ss.android.downloadlib.ok.ok(jSONObject, downloadInfo);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
                aVarOk.s(baseException.getErrorCode());
                aVarOk.ok(baseException.getErrorMessage());
            }
            aVarOk.m();
            jSONObject.put("download_failed_times", aVarOk.y());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            int i2 = 1;
            jSONObject.put("has_send_download_failed_finally", aVarOk.s.get() ? 1 : 2);
            com.ss.android.downloadlib.h.kf.ok(aVarOk, jSONObject);
            if (!aVarOk.cs()) {
                i2 = 2;
            }
            jSONObject.put("is_update_download", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ok(aVarOk.k(), "download_failed", jSONObject, aVarOk);
        q.ok().ok(aVarOk);
    }

    public void ok(long j, int i2) {
        n nVarN = kf.ok().n(j);
        if (nVarN.y()) {
            com.ss.android.downloadlib.n.bl.ok().ok("sendClickEvent ModelBox notValid");
            return;
        }
        if (nVarN.bl.isEnableClickEvent()) {
            int i3 = 1;
            DownloadEventConfig downloadEventConfig = nVarN.bl;
            String clickItemTag = i2 == 1 ? downloadEventConfig.getClickItemTag() : downloadEventConfig.getClickButtonTag();
            String strOk = j.ok(nVarN.bl.getClickLabel(), "click");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("download_click_type", Integer.valueOf(i2));
                jSONObject.putOpt("permission_notification", Integer.valueOf(s.ok() ? 1 : 2));
                if (!com.ss.android.socialbase.downloader.q.kf.bl(r.getContext())) {
                    i3 = 2;
                }
                jSONObject.putOpt("network_available", Integer.valueOf(i3));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            ok(clickItemTag, strOk, jSONObject, nVarN);
            if (!"click".equals(strOk) || nVarN.f9775a == null) {
                return;
            }
            bl.ok().ok(j, nVarN.f9775a.getLogExtra());
        }
    }

    public void ok(long j, int i2, DownloadInfo downloadInfo) {
        n nVarN = kf.ok().n(j);
        if (nVarN.y()) {
            com.ss.android.downloadlib.n.bl.ok().ok("sendEvent ModelBox notValid");
            return;
        }
        String strOk = null;
        JSONObject jSONObject = new JSONObject();
        j.ok(jSONObject, "download_scene", Integer.valueOf(nVarN.u()));
        if (i2 == 1) {
            strOk = j.ok(nVarN.bl.getStorageDenyLabel(), "storage_deny");
        } else if (i2 == 2) {
            strOk = j.ok(nVarN.bl.getClickStartLabel(), "click_start");
            com.ss.android.downloadlib.h.kf.ok(downloadInfo, jSONObject);
        } else if (i2 == 3) {
            strOk = j.ok(nVarN.bl.getClickPauseLabel(), "click_pause");
            com.ss.android.downloadlib.h.kf.a(downloadInfo, jSONObject);
        } else if (i2 == 4) {
            strOk = j.ok(nVarN.bl.getClickContinueLabel(), "click_continue");
            com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
        } else if (i2 == 5) {
            if (downloadInfo != null) {
                try {
                    com.ss.android.downloadlib.h.kf.ok(jSONObject, downloadInfo.getId());
                    com.ss.android.downloadlib.ok.a(jSONObject, downloadInfo);
                } catch (Throwable unused) {
                }
            }
            strOk = j.ok(nVarN.bl.getClickInstallLabel(), "click_install");
        }
        ok(null, strOk, jSONObject, 0L, 1, nVarN);
    }

    public void a(String str, com.ss.android.downloadad.api.ok.ok okVar) {
        ok((String) null, str, okVar);
    }

    public void a(String str, JSONObject jSONObject, com.ss.android.downloadad.api.ok.ok okVar) {
        ok((String) null, str, jSONObject, okVar);
    }

    public void ok(String str, int i2, n nVar) {
        ok(null, str, null, i2, 0, nVar);
    }

    public void ok(long j, boolean z, int i2) {
        n nVarN = kf.ok().n(j);
        if (nVarN.y()) {
            com.ss.android.downloadlib.n.bl.ok().ok("sendQuickAppEvent ModelBox notValid");
            return;
        }
        if (nVarN.f9775a.getQuickAppModel() == null) {
            return;
        }
        DownloadModel downloadModel = nVarN.f9775a;
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_click_type", Integer.valueOf(i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a(z ? "deeplink_quickapp_success" : "deeplink_quickapp_failed", jSONObject, nVarN);
    }

    public void ok(long j, BaseException baseException) {
        n nVarN = kf.ok().n(j);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_time", 0);
            if (baseException != null) {
                jSONObject.putOpt("fail_status", Integer.valueOf(baseException.getErrorCode()));
                jSONObject.putOpt("fail_msg", baseException.getErrorMessage());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a("download_failed", jSONObject, nVarN);
    }

    public void ok(DownloadInfo downloadInfo) {
        com.ss.android.downloadad.api.ok.a aVarOk = kf.ok().ok(downloadInfo);
        if (aVarOk == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.h.kf.bl(downloadInfo, jSONObject);
            aVarOk.ok(System.currentTimeMillis());
            ok(aVarOk.k(), "download_resume", jSONObject, aVarOk);
            q.ok().ok(aVarOk);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ok(JSONObject jSONObject, @NonNull com.ss.android.downloadad.api.ok.a aVar) {
        ok(aVar.k(), "install_finish", jSONObject, aVar);
    }

    public void ok(DownloadInfo downloadInfo, BaseException baseException) {
        com.ss.android.downloadad.api.ok.a aVarOk;
        if (downloadInfo == null || (aVarOk = kf.ok().ok(downloadInfo)) == null || aVarOk.bl.get()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            com.ss.android.downloadlib.ok.ok(jSONObject, downloadInfo);
            jSONObject.putOpt("fail_status", Integer.valueOf(aVarOk.g()));
            jSONObject.putOpt("fail_msg", aVarOk.v());
            jSONObject.put("download_failed_times", aVarOk.y());
            if (downloadInfo.getTotalBytes() > 0) {
                jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
            }
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (aVarOk.e() > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - aVarOk.e());
            }
            if (aVarOk.kz() > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - aVarOk.kz());
            }
            int i2 = 1;
            jSONObject.put("is_update_download", aVarOk.cs() ? 1 : 2);
            jSONObject.put("can_show_notification", s.ok() ? 1 : 2);
            if (!aVarOk.s.get()) {
                i2 = 2;
            }
            jSONObject.put("has_send_download_failed_finally", i2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        ok(aVarOk.k(), "download_cancel", jSONObject, aVarOk);
    }

    public void ok(String str, com.ss.android.downloadad.api.ok.ok okVar) {
        ok(str, (JSONObject) null, okVar);
    }

    public void ok(String str, JSONObject jSONObject, long j) {
        com.ss.android.downloadad.api.ok.ok okVarS = kf.ok().s(j);
        if (okVarS != null) {
            ok(str, jSONObject, okVarS);
            return;
        }
        n nVarN = kf.ok().n(j);
        if (nVarN.y()) {
            com.ss.android.downloadlib.n.bl.ok().ok("sendUnityEvent ModelBox notValid");
        } else {
            ok(str, jSONObject, nVarN);
        }
    }

    public void ok(String str, JSONObject jSONObject, com.ss.android.downloadad.api.ok.ok okVar) {
        JSONObject jSONObject2 = new JSONObject();
        j.ok(jSONObject2, "unity_label", str);
        ok("embeded_ad", "ttdownloader_unity", j.ok(jSONObject, jSONObject2), okVar);
    }

    public void ok(String str, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        a(str, new n(downloadModel.getId(), downloadModel, downloadEventConfig, downloadController));
    }

    public void ok(String str, long j) {
        com.ss.android.downloadad.api.ok.a aVarS = kf.ok().s(j);
        if (aVarS != null) {
            a(str, aVarS);
        } else {
            a(str, kf.ok().n(j));
        }
    }

    public void ok(String str, String str2, com.ss.android.downloadad.api.ok.ok okVar) {
        ok(str, str2, (JSONObject) null, okVar);
    }

    public void ok(String str, String str2, JSONObject jSONObject, com.ss.android.downloadad.api.ok.ok okVar) {
        ok(str, str2, jSONObject, 0L, 0, okVar);
    }

    private void ok(String str, String str2, JSONObject jSONObject, long j, int i2, com.ss.android.downloadad.api.ok.ok okVar) {
        if (okVar == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("onEvent data null");
            return;
        }
        if ((okVar instanceof n) && ((n) okVar).y()) {
            com.ss.android.downloadlib.n.bl.ok().ok("onEvent ModelBox notValid");
            return;
        }
        try {
            bl.ok okVarBl = new bl.ok().ok(j.ok(str, okVar.k(), "embeded_ad")).a(str2).a(okVar.bl()).ok(okVar.a()).bl(okVar.s());
            if (j <= 0) {
                j = okVar.j();
            }
            bl.ok okVarOk = okVarBl.a(j).s(okVar.q()).ok(okVar.rh()).ok(j.ok(ok(okVar), jSONObject)).a(okVar.r()).ok(okVar.t());
            if (i2 <= 0) {
                i2 = 2;
            }
            ok(okVarOk.ok(i2).ok(okVar.z()).ok());
        } catch (Exception e2) {
            com.ss.android.downloadlib.n.bl.ok().ok(e2, "onEvent");
        }
    }

    private JSONObject ok(com.ss.android.downloadad.api.ok.ok okVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            j.ok(okVar.h(), jSONObject);
            j.ok(okVar.i(), jSONObject);
            jSONObject.putOpt("download_url", okVar.ok());
            jSONObject.putOpt("package_name", okVar.n());
            jSONObject.putOpt("android_int", Integer.valueOf(Build.VERSION.SDK_INT));
            jSONObject.putOpt("rom_name", com.ss.android.socialbase.appdownloader.kf.n.p());
            jSONObject.putOpt("rom_version", com.ss.android.socialbase.appdownloader.kf.n.q());
            jSONObject.putOpt("ttdownloader", 1);
            jSONObject.putOpt("funnel_type", Integer.valueOf(okVar.p()));
            if (okVar.p() == 2) {
                com.ss.android.downloadlib.h.kf.a(jSONObject, okVar);
            }
            if (com.ss.android.socialbase.appdownloader.kf.n.i()) {
                com.ss.android.downloadlib.h.kf.ok(jSONObject);
            }
        } catch (Exception e2) {
            r.u().ok(e2, "getBaseJson");
        }
        return jSONObject;
    }

    private void ok(com.ss.android.download.api.model.bl blVar) {
        if (r.ok() == null) {
            return;
        }
        if (blVar.z()) {
            r.ok().ok(blVar);
        } else {
            r.ok().a(blVar);
        }
    }
}
