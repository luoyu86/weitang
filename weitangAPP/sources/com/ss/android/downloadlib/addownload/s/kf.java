package com.ss.android.downloadlib.addownload.s;

import android.text.TextUtils;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kf implements q {
    private static com.ss.android.downloadlib.addownload.ok.s ok;

    public static com.ss.android.downloadlib.addownload.ok.s ok() {
        return ok;
    }

    @Override // com.ss.android.downloadlib.addownload.s.q
    public boolean ok(final com.ss.android.downloadad.api.ok.a aVar, int i2, final p pVar) {
        DownloadInfo downloadInfoA;
        if (aVar == null || aVar.dn() || !ok(aVar)) {
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
        long curBytes = downloadInfoA.getCurBytes();
        long totalBytes = downloadInfoA.getTotalBytes();
        if (curBytes > 0 && totalBytes > 0) {
            int iOk = com.ss.android.downloadlib.addownload.k.ok(downloadInfoA.getId(), (int) ((curBytes * 100) / totalBytes));
            if (iOk > ok(aVar.zz())) {
                ok = new com.ss.android.downloadlib.addownload.ok.s() { // from class: com.ss.android.downloadlib.addownload.s.kf.1
                    @Override // com.ss.android.downloadlib.addownload.ok.s
                    public void a() {
                        com.ss.android.downloadlib.addownload.ok.s unused = kf.ok = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "cancel");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        com.ss.android.downloadlib.s.ok.ok().ok("pause_optimise", jSONObject, aVar);
                        pVar.ok(aVar);
                    }

                    @Override // com.ss.android.downloadlib.addownload.ok.s
                    public void ok() {
                        com.ss.android.downloadlib.addownload.ok.s unused = kf.ok = null;
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("pause_optimise_type", "download_percent");
                            jSONObject.putOpt("pause_optimise_action", "confirm");
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        com.ss.android.downloadlib.s.ok.ok().ok("pause_optimise", jSONObject, aVar);
                    }
                };
                TTDelegateActivity.a(aVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(iOk)), "继续", "暂停");
                aVar.t(true);
                return true;
            }
        }
        return false;
    }

    private int ok(int i2) {
        return com.ss.android.socialbase.downloader.h.ok.ok(i2).ok("pause_optimise_download_percent", 50);
    }

    private boolean ok(com.ss.android.downloadad.api.ok.ok okVar) {
        return com.ss.android.downloadlib.h.n.ok(okVar).ok("pause_optimise_download_percent_switch", 0) == 1 && okVar.x();
    }
}
