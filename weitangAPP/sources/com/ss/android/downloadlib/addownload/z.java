package com.ss.android.downloadlib.addownload;

import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.impls.td;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.ss.android.downloadlib.addownload.ok.bl f9850a;
    private static com.ss.android.downloadlib.addownload.ok.s ok;

    public static com.ss.android.downloadlib.addownload.ok.bl a() {
        return f9850a;
    }

    public static com.ss.android.downloadlib.addownload.ok.s ok() {
        return ok;
    }

    public static boolean ok(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8;
    }

    public static void ok(com.ss.android.downloadlib.addownload.ok.s sVar) {
        ok = sVar;
    }

    public static void ok(com.ss.android.downloadlib.addownload.ok.bl blVar) {
        f9850a = blVar;
    }

    public static boolean ok(final com.ss.android.downloadad.api.ok.a aVar, DownloadInfo downloadInfo, int i2, final com.ss.android.downloadlib.addownload.s.p pVar, final boolean z, final com.ss.android.downloadlib.addownload.ok.bl blVar) {
        boolean zA;
        if (aVar == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("tryReverseWifi nativeModel null");
            return false;
        }
        if (downloadInfo == null) {
            com.ss.android.downloadlib.n.bl.ok().ok("tryReverseWifi info null");
            return false;
        }
        final int id = downloadInfo.getId();
        if (z) {
            zA = com.ss.android.downloadlib.h.n.bl(aVar);
        } else {
            zA = com.ss.android.downloadlib.h.n.a(aVar);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("switch_status", Integer.valueOf(zA ? 1 : 0));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (z) {
            com.ss.android.downloadlib.s.ok.ok().ok("cancel_pause_reserve_wifi_switch_status", jSONObject, aVar);
        } else {
            com.ss.android.downloadlib.s.ok.ok().ok("pause_reserve_wifi_switch_status", jSONObject, aVar);
        }
        if (!zA || !ok(i2) || com.ss.android.socialbase.downloader.q.kf.a(r.getContext())) {
            return false;
        }
        if (!z && downloadInfo.hasPauseReservedOnWifi()) {
            return false;
        }
        ok(new com.ss.android.downloadlib.addownload.ok.s() { // from class: com.ss.android.downloadlib.addownload.z.1
            @Override // com.ss.android.downloadlib.addownload.ok.s
            public void a() {
                z.ok((com.ss.android.downloadlib.addownload.ok.s) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(r.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.stopPauseReserveOnWifi();
                }
                if (z) {
                    com.ss.android.downloadlib.s.ok.ok().ok("cancel_pause_reserve_wifi_cancel", aVar);
                } else {
                    com.ss.android.downloadlib.s.ok.ok().a("pause_reserve_wifi_cancel", aVar);
                }
                pVar.ok(aVar);
            }

            @Override // com.ss.android.downloadlib.addownload.ok.s
            public void ok() {
                z.ok((com.ss.android.downloadlib.addownload.ok.s) null);
                DownloadInfo downloadInfo2 = Downloader.getInstance(r.getContext()).getDownloadInfo(id);
                if (downloadInfo2 != null) {
                    downloadInfo2.startPauseReserveOnWifi();
                    td.ok().ok(downloadInfo2);
                    if (z) {
                        com.ss.android.downloadlib.s.ok.ok().ok("cancel_pause_reserve_wifi_confirm", aVar);
                    } else {
                        com.ss.android.downloadlib.s.ok.ok().a("pause_reserve_wifi_confirm", aVar);
                    }
                }
                pVar.ok(aVar);
            }
        });
        if (z && blVar != null) {
            ok(new com.ss.android.downloadlib.addownload.ok.bl() { // from class: com.ss.android.downloadlib.addownload.z.2
                @Override // com.ss.android.downloadlib.addownload.ok.bl
                public void delete() {
                    com.ss.android.downloadlib.s.ok.ok().ok("cancel_pause_reserve_wifi_delete", aVar);
                    blVar.delete();
                }
            });
        }
        if (z) {
            TTDelegateActivity.ok(aVar, "删除");
        } else {
            TTDelegateActivity.a(aVar);
        }
        return true;
    }
}
