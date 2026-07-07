package com.ss.android.downloadlib.addownload.s;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ok implements q {
    private static com.ss.android.downloadlib.addownload.ok.s ok;

    public static com.ss.android.downloadlib.addownload.ok.s ok() {
        return ok;
    }

    @Override // com.ss.android.downloadlib.addownload.s.q
    public boolean ok(final com.ss.android.downloadad.api.ok.a aVar, int i2, final p pVar) {
        DownloadInfo downloadInfoA;
        if (aVar == null || aVar.de() || !ok(aVar)) {
            return false;
        }
        if (!TextUtils.isEmpty(aVar.ld())) {
            downloadInfoA = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).ok(aVar.ld(), null, true);
        } else {
            downloadInfoA = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).a(aVar.ok());
        }
        if (downloadInfoA == null) {
            return false;
        }
        long jOk = com.ss.android.downloadlib.addownload.k.ok(downloadInfoA.getId(), downloadInfoA.getCurBytes(), downloadInfoA.getTotalBytes());
        long totalBytes = downloadInfoA.getTotalBytes();
        if (jOk <= 0 || totalBytes <= 0 || totalBytes > ok(aVar.zz())) {
            return false;
        }
        ok = new com.ss.android.downloadlib.addownload.ok.s() { // from class: com.ss.android.downloadlib.addownload.s.ok.1
            @Override // com.ss.android.downloadlib.addownload.ok.s
            public void a() {
                com.ss.android.downloadlib.addownload.ok.s unused = ok.ok = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "cancel");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.s.ok.ok().ok("pause_optimise", jSONObject, aVar);
                pVar.ok(aVar);
            }

            @Override // com.ss.android.downloadlib.addownload.ok.s
            public void ok() {
                com.ss.android.downloadlib.addownload.ok.s unused = ok.ok = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.downloadlib.s.ok.ok().ok("pause_optimise", jSONObject, aVar);
            }
        };
        TTDelegateActivity.ok(aVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", com.ss.android.downloadlib.h.j.ok(totalBytes - jOk)), "继续", "暂停");
        aVar.rh(true);
        return true;
    }

    private int ok(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("pause_optimise_apk_size", 100) * 1024 * 1024;
    }

    private boolean ok(com.ss.android.downloadad.api.ok.ok okVar) {
        return com.ss.android.downloadlib.h.n.ok(okVar).ok("pause_optimise_apk_size_switch", 0) == 1 && okVar.x();
    }
}
