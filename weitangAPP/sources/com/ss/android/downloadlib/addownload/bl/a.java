package com.ss.android.downloadlib.addownload.bl;

import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.downloadlib.addownload.a.q;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Runnable {
    private DownloadInfo ok;

    public a(DownloadInfo downloadInfo) {
        this.ok = downloadInfo;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        final com.ss.android.downloadad.api.ok.a aVarOk;
        if (this.ok == null || (aVarOk = kf.ok().ok(this.ok)) == null) {
            return;
        }
        com.ss.android.downloadlib.s.ok.ok().ok("cleanspace_task", aVarOk);
        long jLongValue = Double.valueOf((com.ss.android.downloadlib.h.n.ok(this.ok.getId()) + 1.0d) * this.ok.getTotalBytes()).longValue() - this.ok.getCurBytes();
        long jA = j.a(0L);
        if (r.z() != null) {
            r.z().n();
        }
        bl.ok();
        bl.a();
        if (com.ss.android.downloadlib.h.n.h(aVarOk.zz())) {
            bl.ok(r.getContext());
        }
        long jA2 = j.a(0L);
        if (jA2 >= jLongValue) {
            aVarOk.j("1");
            q.ok().ok(aVarOk);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("quite_clean_size", Long.valueOf(jA2 - jA));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            com.ss.android.downloadlib.s.ok.ok().ok("cleanspace_download_after_quite_clean", jSONObject, aVarOk);
            Downloader.getInstance(r.getContext()).restart(this.ok.getId());
            return;
        }
        if (r.z() != null) {
            aVarOk.s(false);
            s.ok().ok(aVarOk.ok(), new n() { // from class: com.ss.android.downloadlib.addownload.bl.a.1
            });
            if (r.z().ok(this.ok.getId(), this.ok.getUrl(), true, jLongValue)) {
                aVarOk.n(true);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("show_dialog_result", 3);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        com.ss.android.downloadlib.s.ok.ok().ok("cleanspace_window_show", jSONObject2, aVarOk);
    }
}
